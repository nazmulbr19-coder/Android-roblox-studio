package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new AnonymousClass1();

    /* renamed from: androidx.recyclerview.widget.DiffUtil$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Comparator<Diagonal> {
        AnonymousClass1() {
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.x - diagonal2.x;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Diagonal diagonal, Diagonal diagonal2) {
            return compare2(diagonal, diagonal2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* loaded from: classes.dex */
    static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        CenteredArray(int i) {
            this.mData = new int[i];
            this.mMid = this.mData.length / 2;
        }

        int[] backingData() {
            return this.mData;
        }

        public void fill(int i) {
            Arrays.fill(this.mData, i);
        }

        int get(int i) {
            return this.mData[this.mMid + i];
        }

        void set(int i, int i2) {
            this.mData[this.mMid + i] = i2;
        }
    }

    /* loaded from: classes.dex */
    static class Diagonal {
        public final int size;
        public final int x;
        public final int y;

        Diagonal(int i, int i2, int i3) {
            this.x = i;
            this.y = i2;
            this.size = i3;
        }

        int endX() {
            return this.x + this.size;
        }

        int endY() {
            return this.y + this.size;
        }
    }

    /* loaded from: classes.dex */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(this.mOldItemStatuses, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.x != 0 || diagonal.y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i) {
            int i2 = 0;
            int size = this.mDiagonals.size();
            for (int i3 = 0; i3 < size; i3++) {
                Diagonal diagonal = this.mDiagonals.get(i3);
                while (i2 < diagonal.y) {
                    if (this.mNewItemStatuses[i2] == 0 && this.mCallback.areItemsTheSame(i, i2)) {
                        int i4 = this.mCallback.areContentsTheSame(i, i2) ? 8 : 4;
                        this.mOldItemStatuses[i] = (i2 << 4) | i4;
                        this.mNewItemStatuses[i2] = (i << 4) | i4;
                        return;
                    }
                    i2++;
                }
                i2 = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i = 0; i < diagonal.size; i++) {
                    int i2 = diagonal.x + i;
                    int i3 = diagonal.y + i;
                    int i4 = this.mCallback.areContentsTheSame(i2, i3) ? 1 : 2;
                    this.mOldItemStatuses[i2] = (i3 << 4) | i4;
                    this.mNewItemStatuses[i3] = (i2 << 4) | i4;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (i < diagonal.x) {
                    if (this.mOldItemStatuses[i] == 0) {
                        findMatchingAddition(i);
                    }
                    i++;
                }
                i = diagonal.endX();
            }
        }

        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i, boolean z) {
            PostponedUpdate postponedUpdate = null;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostponedUpdate next = it.next();
                if (next.posInOwnerList == i && next.removal == z) {
                    postponedUpdate = next;
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next2 = it.next();
                if (z) {
                    next2.currentPos--;
                } else {
                    next2.currentPos++;
                }
            }
            return postponedUpdate;
        }

        public int convertNewPositionToOld(int i) {
            if (i < 0 || i >= this.mNewListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", new list size = " + this.mNewListSize);
            }
            int i2 = this.mNewItemStatuses[i];
            if ((i2 & 15) == 0) {
                return -1;
            }
            return i2 >> 4;
        }

        public int convertOldPositionToNew(int i) {
            if (i < 0 || i >= this.mOldListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", old list size = " + this.mOldListSize);
            }
            int i2 = this.mOldItemStatuses[i];
            if ((i2 & 15) == 0) {
                return -1;
            }
            return i2 >> 4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            boolean z;
            ListUpdateCallback listUpdateCallback2;
            int i;
            ListUpdateCallback listUpdateCallback3 = listUpdateCallback;
            if (listUpdateCallback3 instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback3;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback3);
                listUpdateCallback3 = batchingListUpdateCallback;
            }
            int i2 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i3 = this.mOldListSize;
            int i4 = this.mNewListSize;
            int i5 = 1;
            int size = this.mDiagonals.size() - 1;
            while (size >= 0) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int endX = diagonal.endX();
                int endY = diagonal.endY();
                while (true) {
                    z = false;
                    if (i3 <= endX) {
                        break;
                    }
                    i3--;
                    int i6 = this.mOldItemStatuses[i3];
                    if ((i6 & 12) != 0) {
                        int i7 = i6 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i7, false);
                        if (postponedUpdate != null) {
                            int i8 = i2 - postponedUpdate.currentPos;
                            batchingListUpdateCallback.onMoved(i3, i8 - 1);
                            if ((i6 & 4) != 0) {
                                listUpdateCallback2 = listUpdateCallback3;
                                i = i2;
                                batchingListUpdateCallback.onChanged(i8 - 1, 1, this.mCallback.getChangePayload(i3, i7));
                            } else {
                                listUpdateCallback2 = listUpdateCallback3;
                                i = i2;
                            }
                        } else {
                            listUpdateCallback2 = listUpdateCallback3;
                            i = i2;
                            boolean z2 = i5;
                            arrayDeque.add(new PostponedUpdate(i3, (i - i3) - (z2 ? 1 : 0), z2));
                        }
                        i2 = i;
                    } else {
                        listUpdateCallback2 = listUpdateCallback3;
                        batchingListUpdateCallback.onRemoved(i3, i5);
                        i2--;
                    }
                    listUpdateCallback3 = listUpdateCallback2;
                    i5 = 1;
                }
                ListUpdateCallback listUpdateCallback4 = listUpdateCallback3;
                while (i4 > endY) {
                    i4--;
                    int i9 = this.mNewItemStatuses[i4];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i10, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i4, i2 - i3, z));
                        } else {
                            batchingListUpdateCallback.onMoved((i2 - postponedUpdate2.currentPos) - 1, i3);
                            if ((i9 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i3, 1, this.mCallback.getChangePayload(i10, i4));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i3, 1);
                        i2++;
                    }
                    z = false;
                }
                int i11 = diagonal.x;
                int i12 = diagonal.y;
                for (int i13 = 0; i13 < diagonal.size; i13++) {
                    if ((this.mOldItemStatuses[i11] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i11, 1, this.mCallback.getChangePayload(i11, i12));
                    }
                    i11++;
                    i12++;
                }
                int i14 = diagonal.x;
                i4 = diagonal.y;
                size--;
                i3 = i14;
                i5 = 1;
                listUpdateCallback3 = listUpdateCallback4;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(T t, T t2);

        public abstract boolean areItemsTheSame(T t, T t2);

        public Object getChangePayload(T t, T t2) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        PostponedUpdate(int i, int i2, boolean z) {
            this.posInOwnerList = i;
            this.currentPos = i2;
            this.removal = z;
        }
    }

    /* loaded from: classes.dex */
    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i, int i2, int i3, int i4) {
            this.oldListStart = i;
            this.oldListEnd = i2;
            this.newListStart = i3;
            this.newListEnd = i4;
        }

        int newSize() {
            return this.newListEnd - this.newListStart;
        }

        int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }
    }

    /* loaded from: classes.dex */
    static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        Snake() {
        }

        int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        Diagonal toDiagonal() {
            return hasAdditionOrRemoval() ? this.reverse ? new Diagonal(this.startX, this.startY, diagonalSize()) : isAddition() ? new Diagonal(this.startX, this.startY + 1, diagonalSize()) : new Diagonal(this.startX + 1, this.startY, diagonalSize()) : new Diagonal(this.startX, this.startY, this.endX - this.startX);
        }
    }

    private DiffUtil() {
    }

    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i2;
        int i3;
        int i4;
        boolean z = (range.oldSize() - range.newSize()) % 2 == 0;
        int oldSize = range.oldSize() - range.newSize();
        for (int i5 = -i; i5 <= i; i5 += 2) {
            if (i5 == (-i) || (i5 != i && centeredArray2.get(i5 + 1) < centeredArray2.get(i5 - 1))) {
                i2 = centeredArray2.get(i5 + 1);
                i3 = i2;
            } else {
                i3 = centeredArray2.get(i5 - 1);
                i2 = i3 - 1;
            }
            int i6 = range.newListEnd - ((range.oldListEnd - i2) - i5);
            int i7 = (i == 0 || i2 != i3) ? i6 : i6 + 1;
            while (i2 > range.oldListStart && i6 > range.newListStart && callback.areItemsTheSame(i2 - 1, i6 - 1)) {
                i2--;
                i6--;
            }
            centeredArray2.set(i5, i2);
            if (z && (i4 = oldSize - i5) >= (-i) && i4 <= i && centeredArray.get(i4) >= i2) {
                Snake snake = new Snake();
                snake.startX = i2;
                snake.startY = i6;
                snake.endX = i3;
                snake.endY = i7;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    public static DiffResult calculateDiff(Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i = ((oldListSize + newListSize) + 1) / 2;
        CenteredArray centeredArray = new CenteredArray((i * 2) + 1);
        CenteredArray centeredArray2 = new CenteredArray((i * 2) + 1);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake midPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = midPoint.startX;
                range2.newListEnd = midPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = midPoint.endX;
                range.newListStart = midPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z);
    }

    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i2;
        int i3;
        boolean z = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int oldSize = range.oldSize() - range.newSize();
        for (int i4 = -i; i4 <= i; i4 += 2) {
            if (i4 == (-i) || (i4 != i && centeredArray.get(i4 + 1) > centeredArray.get(i4 - 1))) {
                i2 = centeredArray.get(i4 + 1);
                i3 = i2;
            } else {
                i3 = centeredArray.get(i4 - 1);
                i2 = i3 + 1;
            }
            int i5 = (range.newListStart + (i2 - range.oldListStart)) - i4;
            int i6 = (i == 0 || i2 != i3) ? i5 : i5 - 1;
            while (i2 < range.oldListEnd && i5 < range.newListEnd) {
                if (!callback.areItemsTheSame(i2, i5)) {
                    break;
                }
                i2++;
                i5++;
            }
            centeredArray.set(i4, i2);
            if (z) {
                int i7 = oldSize - i4;
                if (i7 >= (-i) + 1 && i7 <= i - 1) {
                    if (centeredArray2.get(i7) <= i2) {
                        Snake snake = new Snake();
                        snake.startX = i3;
                        snake.startY = i6;
                        snake.endX = i2;
                        snake.endY = i5;
                        snake.reverse = false;
                        return snake;
                    }
                }
            }
        }
        return null;
    }

    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() < 1 || range.newSize() < 1) {
            return null;
        }
        int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
        centeredArray.set(1, range.oldListStart);
        centeredArray2.set(1, range.oldListEnd);
        for (int i = 0; i < oldSize; i++) {
            Snake forward = forward(range, callback, centeredArray, centeredArray2, i);
            if (forward != null) {
                return forward;
            }
            Snake backward = backward(range, callback, centeredArray, centeredArray2, i);
            if (backward != null) {
                return backward;
            }
        }
        return null;
    }
}
