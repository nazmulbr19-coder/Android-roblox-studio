package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "GridLayoutManager";
    private static final Set<Integer> sSupportedDirectionsForActionScrollInDirection = Collections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, 130)));
    int[] mCachedBorders;
    int mColumnWithAccessibilityFocus;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    private int mPositionTargetedByScrollInDirection;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    int mRowWithAccessibilityFocus;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    /* loaded from: classes.dex */
    private static class Api21Impl {
        private Api21Impl() {
        }

        static boolean isAccessibilityFocused(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* loaded from: classes.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SpanSizeLookup {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i) {
            int i2 = 0;
            int size = sparseIntArray.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        int getCachedSpanGroupIndex(int i, int i2) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i, i2);
            }
            int i3 = this.mSpanGroupIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i2);
            this.mSpanGroupIndexCache.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int findFirstKeyLessThan;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            if (this.mCacheSpanGroupIndices && (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i)) != -1) {
                i4 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i5 = findFirstKeyLessThan + 1;
                i3 = getCachedSpanIndex(findFirstKeyLessThan, i2) + getSpanSize(findFirstKeyLessThan);
                if (i3 == i2) {
                    i3 = 0;
                    i4++;
                }
            }
            int spanSize = getSpanSize(i);
            for (int i6 = i5; i6 < i; i6++) {
                int spanSize2 = getSpanSize(i6);
                i3 += spanSize2;
                if (i3 == i2) {
                    i3 = 0;
                    i4++;
                } else if (i3 > i2) {
                    i3 = spanSize2;
                    i4++;
                }
            }
            return i3 + spanSize > i2 ? i4 + 1 : i4;
        }

        public int getSpanIndex(int i, int i2) {
            int findFirstKeyLessThan;
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            int i3 = 0;
            int i4 = 0;
            if (this.mCacheSpanIndices && (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanIndexCache, i)) >= 0) {
                i3 = this.mSpanIndexCache.get(findFirstKeyLessThan) + getSpanSize(findFirstKeyLessThan);
                i4 = findFirstKeyLessThan + 1;
            }
            for (int i5 = i4; i5 < i; i5++) {
                int spanSize2 = getSpanSize(i5);
                i3 += spanSize2;
                if (i3 == i2) {
                    i3 = 0;
                } else if (i3 > i2) {
                    i3 = spanSize2;
                }
            }
            if (i3 + spanSize <= i2) {
                return i3;
            }
            return 0;
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(getProperties(context, attributeSet, i, i2).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            i2 = 0;
            i3 = i;
            i4 = 1;
        } else {
            i2 = i - 1;
            i3 = -1;
            i4 = -1;
        }
        int i5 = 0;
        for (int i6 = i2; i6 != i3; i6 += i4) {
            View view = this.mSet[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.mSpanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanIndex = i5;
            i5 += layoutParams.mSpanSize;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i);
    }

    static int[] calculateItemBorders(int[] iArr, int i, int i2) {
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        iArr[0] = 0;
        int i3 = i2 / i;
        int i4 = i2 % i;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8 = i3;
            i6 += i4;
            if (i6 > 0 && i - i6 < i4) {
                i8++;
                i6 -= i;
            }
            i5 += i8;
            iArr[i7] = i5;
        }
        return iArr;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        if (getChildCount() == 0 || state.getItemCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
        View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
        if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
            int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
            int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
            int max = this.mShouldReverseLayout ? Math.max(0, ((this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
            if (isSmoothScrollbarEnabled) {
                return Math.round((max * (Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)));
            }
            return max;
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (getChildCount() == 0 || state.getItemCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
        View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
        if (findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null) {
            return 0;
        }
        if (!isSmoothScrollbarEnabled()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
        }
        int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
        int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
        return (int) ((decoratedEnd / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1));
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        boolean z = i == 1;
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z) {
            while (spanIndex > 0 && anchorInfo.mPosition > 0) {
                anchorInfo.mPosition--;
                spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i2 = anchorInfo.mPosition;
        int i3 = spanIndex;
        while (i2 < itemCount) {
            int spanIndex2 = getSpanIndex(recycler, state, i2 + 1);
            if (spanIndex2 <= i3) {
                break;
            }
            i2++;
            i3 = spanIndex2;
        }
        anchorInfo.mPosition = i2;
    }

    private void ensureViewSet() {
        if (this.mSet == null || this.mSet.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private View findChildWithAccessibilityFocus() {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= getChildCount()) {
                break;
            }
            if (Api21Impl.isAccessibilityFocused((View) Objects.requireNonNull(getChildAt(i2)))) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return getChildAt(i2);
        }
        return null;
    }

    private int findScrollTargetPositionAbove(int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            int rowIndex = getRowIndex(i4);
            int columnIndex = getColumnIndex(i4);
            if (rowIndex < 0 || columnIndex < 0) {
                return -1;
            }
            if (this.mOrientation == 1) {
                if (rowIndex < i && getColumnIndices(i4).contains(Integer.valueOf(i2))) {
                    int i5 = i4;
                    this.mRowWithAccessibilityFocus = rowIndex;
                    return i5;
                }
            } else if (rowIndex < i && columnIndex == i2) {
                int i6 = i4;
                this.mRowWithAccessibilityFocus = ((Integer) Collections.max(getRowIndices(i4))).intValue();
                return i6;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionBelow(int i, int i2, int i3) {
        for (int i4 = i3 + 1; i4 < getItemCount(); i4++) {
            int rowIndex = getRowIndex(i4);
            int columnIndex = getColumnIndex(i4);
            if (rowIndex < 0 || columnIndex < 0) {
                return -1;
            }
            if (this.mOrientation == 1) {
                if (rowIndex > i && (columnIndex == i2 || getColumnIndices(i4).contains(Integer.valueOf(i2)))) {
                    int i5 = i4;
                    this.mRowWithAccessibilityFocus = rowIndex;
                    return i5;
                }
            } else if (rowIndex > i && columnIndex == i2) {
                int i6 = i4;
                this.mRowWithAccessibilityFocus = getRowIndex(i4);
                return i6;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionOnTheLeft(int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            int rowIndex = getRowIndex(i4);
            int columnIndex = getColumnIndex(i4);
            if (rowIndex < 0 || columnIndex < 0) {
                return -1;
            }
            if (this.mOrientation == 1) {
                if ((rowIndex == i && columnIndex < i2) || rowIndex < i) {
                    int i5 = i4;
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                    return i5;
                }
            } else if (getRowIndices(i4).contains(Integer.valueOf(i)) && columnIndex < i2) {
                this.mColumnWithAccessibilityFocus = columnIndex;
                return i4;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionOnTheRight(int i, int i2, int i3) {
        for (int i4 = i3 + 1; i4 < getItemCount(); i4++) {
            int rowIndex = getRowIndex(i4);
            int columnIndex = getColumnIndex(i4);
            if (rowIndex < 0 || columnIndex < 0) {
                return -1;
            }
            if (this.mOrientation == 1) {
                if ((rowIndex == i && columnIndex > i2) || rowIndex > i) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                    return i4;
                }
            } else if (columnIndex > i2 && getRowIndices(i4).contains(Integer.valueOf(i))) {
                this.mColumnWithAccessibilityFocus = columnIndex;
                return i4;
            }
        }
        return -1;
    }

    private int getColumnIndex(int i) {
        return this.mOrientation == 0 ? getSpanGroupIndex(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i) : getSpanIndex(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i);
    }

    private Set<Integer> getColumnIndices(int i) {
        return getRowOrColumnIndices(getColumnIndex(i), i);
    }

    private int getRowIndex(int i) {
        return this.mOrientation == 1 ? getSpanGroupIndex(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i) : getSpanIndex(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i);
    }

    private Set<Integer> getRowIndices(int i) {
        return getRowOrColumnIndices(getRowIndex(i), i);
    }

    private Set<Integer> getRowOrColumnIndices(int i, int i2) {
        HashSet hashSet = new HashSet();
        int spanSize = getSpanSize(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i2);
        for (int i3 = i; i3 < i + spanSize; i3++) {
            hashSet.add(Integer.valueOf(i3));
        }
        return hashSet;
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i2 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void guessMeasurement(float f, int i) {
        calculateItemBorders(Math.max(Math.round(this.mSpanCount * f), i));
    }

    private boolean hasAccessibilityFocusChanged(int i) {
        return (getRowIndices(i).contains(Integer.valueOf(this.mRowWithAccessibilityFocus)) && getColumnIndices(i).contains(Integer.valueOf(this.mColumnWithAccessibilityFocus))) ? false : true;
    }

    private void measureChild(View view, int i, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i2 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i3 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = getChildMeasureSpec(spaceForSpanRange, i, i3, layoutParams.width, false);
            childMeasureSpec = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i2, layoutParams.height, true);
        } else {
            childMeasureSpec = getChildMeasureSpec(spaceForSpanRange, i, i2, layoutParams.height, false);
            childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i3, layoutParams.width, true);
        }
        measureChildWithDecorationsAndMargin(view, childMeasureSpec2, childMeasureSpec, z);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i, i2, layoutParams) : shouldMeasureChild(view, i, i2, layoutParams)) {
            view.measure(i, i2);
        }
    }

    private void updateMeasurements() {
        calculateItemBorders(getOrientation() == 1 ? (getWidth() - getPaddingRight()) - getPaddingLeft() : (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.mSpanCount;
        for (int i2 = 0; i2 < this.mSpanCount && layoutState.hasMore(state) && i > 0; i2++) {
            int i3 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i3, Math.max(0, layoutState.mScrollingOffset));
            i -= this.mSpanSizeLookup.getSpanSize(i3);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(state) : super.computeHorizontalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(state) : super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(state) : super.computeVerticalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(state) : super.computeVerticalScrollRange(state);
    }

    int findPositionOfFirstItemOnARowBelowForHorizontalGrid(int i) {
        if (i < 0 || this.mOrientation == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap();
        for (int i2 = 0; i2 < getItemCount(); i2++) {
            Iterator<Integer> it = getRowIndices(i2).iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue < 0) {
                    return -1;
                }
                if (!treeMap.containsKey(Integer.valueOf(intValue))) {
                    treeMap.put(Integer.valueOf(intValue), Integer.valueOf(i2));
                }
            }
        }
        Iterator it2 = treeMap.keySet().iterator();
        while (it2.hasNext()) {
            int intValue2 = ((Integer) it2.next()).intValue();
            if (intValue2 > i) {
                int intValue3 = ((Integer) treeMap.get(Integer.valueOf(intValue2))).intValue();
                this.mRowWithAccessibilityFocus = intValue2;
                this.mColumnWithAccessibilityFocus = 0;
                return intValue3;
            }
        }
        return -1;
    }

    int findPositionOfLastItemOnARowAboveForHorizontalGrid(int i) {
        if (i < 0 || this.mOrientation == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        for (int i2 = 0; i2 < getItemCount(); i2++) {
            Iterator<Integer> it = getRowIndices(i2).iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue < 0) {
                    return -1;
                }
                treeMap.put(Integer.valueOf(intValue), Integer.valueOf(i2));
            }
        }
        Iterator it2 = treeMap.keySet().iterator();
        while (it2.hasNext()) {
            int intValue2 = ((Integer) it2.next()).intValue();
            if (intValue2 < i) {
                int intValue3 = ((Integer) treeMap.get(Integer.valueOf(intValue2))).intValue();
                this.mRowWithAccessibilityFocus = intValue2;
                this.mColumnWithAccessibilityFocus = getColumnIndex(intValue3);
                return intValue3;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i = 0;
        int childCount = getChildCount();
        int i2 = 1;
        if (z2) {
            i = getChildCount() - 1;
            childCount = -1;
            i2 = -1;
        }
        int itemCount = state.getItemCount();
        ensureLayoutState();
        View view = null;
        View view2 = null;
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        for (int i3 = i; i3 != childCount; i3 += i2) {
            View childAt = getChildAt(i3);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount) {
                if (getSpanIndex(recycler, state, position) != 0) {
                    continue;
                } else if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (view == null) {
                    view = childAt;
                }
            }
        }
        return view2 != null ? view2 : view;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    int getSpaceForSpanRange(int i, int i2) {
        return (this.mOrientation == 1 && isLayoutRTL()) ? this.mCachedBorders[this.mSpanCount - i] - this.mCachedBorders[(this.mSpanCount - i) - i2] : this.mCachedBorders[i + i2] - this.mCachedBorders[i];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        View view;
        int decoratedMeasurementInOther;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int makeMeasureSpec;
        int childMeasureSpec;
        boolean z;
        View next;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        boolean z2 = modeInOther != 1073741824;
        int i7 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z2) {
            updateMeasurements();
        }
        boolean z3 = layoutState.mItemDirection == 1;
        int i8 = this.mSpanCount;
        if (z3) {
            i = 0;
        } else {
            i8 = getSpanIndex(recycler, state, layoutState.mCurrentPosition) + getSpanSize(recycler, state, layoutState.mCurrentPosition);
            i = 0;
        }
        while (i < this.mSpanCount && layoutState.hasMore(state) && i8 > 0) {
            int i9 = layoutState.mCurrentPosition;
            int spanSize = getSpanSize(recycler, state, i9);
            if (spanSize > this.mSpanCount) {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
            i8 -= spanSize;
            if (i8 < 0 || (next = layoutState.next(recycler)) == null) {
                break;
            }
            this.mSet[i] = next;
            i++;
        }
        if (i == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        int i10 = 0;
        float f2 = 0.0f;
        assignSpans(recycler, state, i, z3);
        int i11 = 0;
        while (i11 < i) {
            View view2 = this.mSet[i11];
            if (layoutState.mScrapList != null) {
                z = false;
                if (z3) {
                    addDisappearingView(view2);
                } else {
                    addDisappearingView(view2, 0);
                }
            } else if (z3) {
                addView(view2);
                z = false;
            } else {
                z = false;
                addView(view2, 0);
            }
            calculateItemDecorationsForChild(view2, this.mDecorInsets);
            measureChild(view2, modeInOther, z);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view2);
            if (decoratedMeasurement > i10) {
                i10 = decoratedMeasurement;
            }
            int i12 = i10;
            float decoratedMeasurementInOther2 = (this.mOrientationHelper.getDecoratedMeasurementInOther(view2) * 1.0f) / ((LayoutParams) view2.getLayoutParams()).mSpanSize;
            if (decoratedMeasurementInOther2 > f2) {
                f2 = decoratedMeasurementInOther2;
            }
            i11++;
            i10 = i12;
        }
        if (z2) {
            guessMeasurement(f2, i7);
            int i13 = 0;
            for (int i14 = 0; i14 < i; i14++) {
                View view3 = this.mSet[i14];
                measureChild(view3, BasicMeasure.EXACTLY, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view3);
                if (decoratedMeasurement2 > i13) {
                    i13 = decoratedMeasurement2;
                }
            }
            i2 = i13;
        } else {
            i2 = i10;
        }
        int i15 = 0;
        while (i15 < i) {
            View view4 = this.mSet[i15];
            if (this.mOrientationHelper.getDecoratedMeasurement(view4) != i2) {
                LayoutParams layoutParams = (LayoutParams) view4.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                i5 = i15;
                int i16 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                f = f2;
                int i17 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    i6 = modeInOther;
                    makeMeasureSpec = getChildMeasureSpec(spaceForSpanRange, BasicMeasure.EXACTLY, i17, layoutParams.width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2 - i16, BasicMeasure.EXACTLY);
                } else {
                    i6 = modeInOther;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2 - i17, BasicMeasure.EXACTLY);
                    childMeasureSpec = getChildMeasureSpec(spaceForSpanRange, BasicMeasure.EXACTLY, i16, layoutParams.height, false);
                }
                measureChildWithDecorationsAndMargin(view4, makeMeasureSpec, childMeasureSpec, true);
            } else {
                i5 = i15;
                f = f2;
                i6 = modeInOther;
            }
            i15 = i5 + 1;
            modeInOther = i6;
            f2 = f;
        }
        layoutChunkResult.mConsumed = i2;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        if (this.mOrientation == 1) {
            if (layoutState.mLayoutDirection == -1) {
                i21 = layoutState.mOffset;
                i20 = i21 - i2;
            } else {
                i20 = layoutState.mOffset;
                i21 = i20 + i2;
            }
        } else if (layoutState.mLayoutDirection == -1) {
            i19 = layoutState.mOffset;
            i18 = i19 - i2;
        } else {
            i18 = layoutState.mOffset;
            i19 = i18 + i2;
        }
        int i22 = 0;
        while (i22 < i) {
            View view5 = this.mSet[i22];
            LayoutParams layoutParams2 = (LayoutParams) view5.getLayoutParams();
            int i23 = i18;
            if (this.mOrientation != 1) {
                i20 = getPaddingTop() + this.mCachedBorders[layoutParams2.mSpanIndex];
                view = view5;
                decoratedMeasurementInOther = i20 + this.mOrientationHelper.getDecoratedMeasurementInOther(view5);
                i3 = i19;
                i4 = i23;
            } else if (isLayoutRTL()) {
                int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                i4 = paddingLeft - this.mOrientationHelper.getDecoratedMeasurementInOther(view5);
                view = view5;
                decoratedMeasurementInOther = i21;
                i3 = paddingLeft;
            } else {
                int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.mSpanIndex];
                int decoratedMeasurementInOther3 = paddingLeft2 + this.mOrientationHelper.getDecoratedMeasurementInOther(view5);
                i4 = paddingLeft2;
                view = view5;
                decoratedMeasurementInOther = i21;
                i3 = decoratedMeasurementInOther3;
            }
            layoutDecoratedWithMargins(view, i4, i20, i3, decoratedMeasurementInOther);
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable |= view.hasFocusable();
            i22++;
            i18 = i4;
            i19 = i3;
            i21 = decoratedMeasurementInOther;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        super.onAnchorReady(recycler, state, anchorInfo, i);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i);
        }
        ensureViewSet();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        int childCount;
        View view2;
        int i4;
        int i5;
        int i6;
        int i7;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i8 = layoutParams.mSpanIndex;
        int i9 = layoutParams.mSpanIndex + layoutParams.mSpanSize;
        if (super.onFocusSearchFailed(view, i, recycler, state) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i) == 1) != this.mShouldReverseLayout) {
            i2 = getChildCount() - 1;
            i3 = -1;
            childCount = -1;
        } else {
            i2 = 0;
            i3 = 1;
            childCount = getChildCount();
        }
        boolean z = this.mOrientation == 1 && isLayoutRTL();
        View view3 = null;
        View view4 = null;
        int spanGroupIndex = getSpanGroupIndex(recycler2, state2, i2);
        int i10 = -1;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        int i14 = i2;
        while (i14 != childCount) {
            int i15 = i2;
            int spanGroupIndex2 = getSpanGroupIndex(recycler2, state2, i14);
            View childAt = getChildAt(i14);
            if (childAt == findContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || spanGroupIndex2 == spanGroupIndex) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                view2 = findContainingItemView;
                int i16 = layoutParams2.mSpanIndex;
                i4 = spanGroupIndex;
                int i17 = layoutParams2.mSpanIndex + layoutParams2.mSpanSize;
                if (childAt.hasFocusable() && i16 == i8 && i17 == i9) {
                    return childAt;
                }
                boolean z2 = false;
                if (!(childAt.hasFocusable() && view3 == null) && (childAt.hasFocusable() || view4 != null)) {
                    i5 = i14;
                    int min = Math.min(i17, i9) - Math.max(i16, i8);
                    if (!childAt.hasFocusable()) {
                        i6 = i10;
                        if (view3 == null) {
                            i7 = i11;
                            if (isViewPartiallyVisible(childAt, false, true)) {
                                if (min > i13) {
                                    z2 = true;
                                } else if (min == i13) {
                                    if (z == (i16 > i12)) {
                                        z2 = true;
                                    }
                                }
                            }
                        } else {
                            i7 = i11;
                        }
                    } else if (min > i11) {
                        z2 = true;
                        i6 = i10;
                        i7 = i11;
                    } else {
                        if (min == i11) {
                            i6 = i10;
                            if (z == (i16 > i10)) {
                                z2 = true;
                                i7 = i11;
                            }
                        } else {
                            i6 = i10;
                        }
                        i7 = i11;
                    }
                } else {
                    z2 = true;
                    i6 = i10;
                    i7 = i11;
                    i5 = i14;
                }
                if (z2) {
                    if (childAt.hasFocusable()) {
                        int i18 = layoutParams2.mSpanIndex;
                        i7 = Math.min(i17, i9) - Math.max(i16, i8);
                        view3 = childAt;
                        i10 = i18;
                    } else {
                        i12 = layoutParams2.mSpanIndex;
                        view4 = childAt;
                        i13 = Math.min(i17, i9) - Math.max(i16, i8);
                        i10 = i6;
                    }
                    i14 = i5 + i3;
                    recycler2 = recycler;
                    state2 = state;
                    i11 = i7;
                    i2 = i15;
                    findContainingItemView = view2;
                    spanGroupIndex = i4;
                }
            } else {
                if (view3 != null) {
                    break;
                }
                view2 = findContainingItemView;
                i6 = i10;
                i7 = i11;
                i4 = spanGroupIndex;
                i5 = i14;
            }
            i10 = i6;
            i14 = i5 + i3;
            recycler2 = recycler;
            state2 = state;
            i11 = i7;
            i2 = i15;
            findContainingItemView = view2;
            spanGroupIndex = i4;
        }
        return view3 != null ? view3 : view4;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
        if (this.mRecyclerView.mAdapter == null || this.mRecyclerView.mAdapter.getItemCount() <= 1) {
            return;
        }
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        View findViewByPosition;
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
        if (this.mPositionTargetedByScrollInDirection == -1 || (findViewByPosition = findViewByPosition(this.mPositionTargetedByScrollInDirection)) == null) {
            return;
        }
        findViewByPosition.sendAccessibilityEvent(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        this.mPositionTargetedByScrollInDirection = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        RecyclerView.ViewHolder childViewHolder;
        int findScrollTargetPositionOnTheLeft;
        if (i != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION.getId() || i == -1) {
            if (i != 16908343 || bundle == null) {
                return super.performAccessibilityAction(i, bundle);
            }
            int i2 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_ROW_INT, -1);
            int i3 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_COLUMN_INT, -1);
            if (i2 == -1 || i3 == -1) {
                return false;
            }
            int itemCount = this.mRecyclerView.mAdapter.getItemCount();
            int i4 = -1;
            int i5 = 0;
            while (true) {
                if (i5 >= itemCount) {
                    break;
                }
                int spanIndex = getSpanIndex(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i5);
                int spanGroupIndex = getSpanGroupIndex(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i5);
                if (this.mOrientation == 1) {
                    if (spanIndex == i3 && spanGroupIndex == i2) {
                        i4 = i5;
                        break;
                    }
                    i5++;
                } else {
                    if (spanIndex == i2 && spanGroupIndex == i3) {
                        i4 = i5;
                        break;
                    }
                    i5++;
                }
            }
            if (i4 <= -1) {
                return false;
            }
            scrollToPositionWithOffset(i4, 0);
            return true;
        }
        View findChildWithAccessibilityFocus = findChildWithAccessibilityFocus();
        if (findChildWithAccessibilityFocus == null || bundle == null) {
            return false;
        }
        int i6 = bundle.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
        if (!sSupportedDirectionsForActionScrollInDirection.contains(Integer.valueOf(i6)) || (childViewHolder = this.mRecyclerView.getChildViewHolder(findChildWithAccessibilityFocus)) == null) {
            return false;
        }
        int absoluteAdapterPosition = childViewHolder.getAbsoluteAdapterPosition();
        int rowIndex = getRowIndex(absoluteAdapterPosition);
        int columnIndex = getColumnIndex(absoluteAdapterPosition);
        if (rowIndex < 0 || columnIndex < 0) {
            return false;
        }
        if (hasAccessibilityFocusChanged(absoluteAdapterPosition)) {
            this.mRowWithAccessibilityFocus = rowIndex;
            this.mColumnWithAccessibilityFocus = columnIndex;
        }
        int i7 = this.mRowWithAccessibilityFocus == -1 ? rowIndex : this.mRowWithAccessibilityFocus;
        int i8 = this.mColumnWithAccessibilityFocus == -1 ? columnIndex : this.mColumnWithAccessibilityFocus;
        switch (i6) {
            case 17:
                findScrollTargetPositionOnTheLeft = findScrollTargetPositionOnTheLeft(i7, i8, absoluteAdapterPosition);
                break;
            case 33:
                findScrollTargetPositionOnTheLeft = findScrollTargetPositionAbove(i7, i8, absoluteAdapterPosition);
                break;
            case 66:
                findScrollTargetPositionOnTheLeft = findScrollTargetPositionOnTheRight(i7, i8, absoluteAdapterPosition);
                break;
            case 130:
                findScrollTargetPositionOnTheLeft = findScrollTargetPositionBelow(i7, i8, absoluteAdapterPosition);
                break;
            default:
                return false;
        }
        if (findScrollTargetPositionOnTheLeft == -1 && this.mOrientation == 0) {
            if (i6 == 17) {
                findScrollTargetPositionOnTheLeft = findPositionOfLastItemOnARowAboveForHorizontalGrid(rowIndex);
            } else if (i6 == 66) {
                findScrollTargetPositionOnTheLeft = findPositionOfFirstItemOnARowBelowForHorizontalGrid(rowIndex);
            }
        }
        if (findScrollTargetPositionOnTheLeft == -1) {
            return false;
        }
        scrollToPosition(findScrollTargetPositionOnTheLeft);
        this.mPositionTargetedByScrollInDirection = findScrollTargetPositionOnTheLeft;
        return true;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = chooseSize(i, this.mCachedBorders[this.mCachedBorders.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = chooseSize(i2, this.mCachedBorders[this.mCachedBorders.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setSpanCount(int i) {
        if (i == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.mSpanCount = i;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.mUsingSpansToEstimateScrollBarDimensions = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }
}
