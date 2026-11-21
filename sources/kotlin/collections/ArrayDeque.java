package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ArrayDeque.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \\*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\\B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u0005\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0011\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0083\bJ\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u000b\u0010#\u001a\u00028\u0000¢\u0006\u0002\u0010$J\r\u0010%\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010$J\u000b\u0010&\u001a\u00028\u0000¢\u0006\u0002\u0010$J\r\u0010'\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010$J\u0013\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00152\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0002\u0010*J\u000b\u0010,\u001a\u00028\u0000¢\u0006\u0002\u0010$J\r\u0010-\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010$J\u000b\u0010.\u001a\u00028\u0000¢\u0006\u0002\u0010$J\r\u0010/\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010$J\u0015\u00100\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u001d\u00100\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J\u001e\u00103\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u0016\u00104\u001a\u00020\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001e\u00104\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0016\u00105\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u001e\u00106\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00107J\u0016\u00108\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00101J\u0015\u00109\u001a\u00020\u00042\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010:J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010:J\u0015\u0010<\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u001bJ\u0016\u0010>\u001a\u00020\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0016\u0010?\u001a\u00020\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001d\u0010@\u001a\u00020\"2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\"0BH\u0082\bJ\b\u0010C\u001a\u00020\u0015H\u0016J'\u0010D\u001a\b\u0012\u0004\u0012\u0002HE0\r\"\u0004\b\u0001\u0010E2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002HE0\rH\u0016¢\u0006\u0002\u0010GJ\u0015\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016¢\u0006\u0002\u0010HJ\u0018\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0014J\u0018\u0010L\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0002J\u0018\u0010M\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0002J\u0018\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0002J\b\u0010Q\u001a\u00020\u0015H\u0002J)\u0010R\u001a\b\u0012\u0004\u0012\u0002HE0\r\"\u0004\b\u0001\u0010E2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002HE0\rH\u0000¢\u0006\u0004\bS\u0010GJ\u0017\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0000¢\u0006\u0004\bS\u0010HJ\u001d\u0010T\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0000¢\u0006\u0002\bUJM\u0010V\u001a\u00020\u00152>\u0010W\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00150XH\u0000¢\u0006\u0002\b[R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006]"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "<init>", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "head", "elementData", "", "", "[Ljava/lang/Object;", "value", "size", "getSize", "()I", "ensureCapacity", "", "minCapacity", "copyElements", "newCapacity", "internalGet", "internalIndex", "(I)Ljava/lang/Object;", "positiveMod", "index", "negativeMod", "incremented", "decremented", "isEmpty", "", "first", "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "addFirst", "element", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "copyCollectionElements", "addAll", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "filterInPlace", "predicate", "Lkotlin/Function1;", "clear", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "removeRange", "fromIndex", "toIndex", "removeRangeShiftPreceding", "removeRangeShiftSucceeding", "nullifyNonEmpty", "internalFromIndex", "internalToIndex", "registerModification", "testToArray", "testToArray$kotlin_stdlib", "testRemoveRange", "testRemoveRange$kotlin_stdlib", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    private static final int defaultMinCapacity = 10;
    private Object[] elementData;
    private int head;
    private int size;
    private static final Object[] emptyElementData = new Object[0];

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = emptyElementData;
        } else {
            if (i <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i);
            }
            objArr = new Object[i];
        }
        this.elementData = objArr;
    }

    public ArrayDeque(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.elementData = elements.toArray(new Object[0]);
        this.size = this.elementData.length;
        if (this.elementData.length == 0) {
            this.elementData = emptyElementData;
        }
    }

    private final void copyCollectionElements(int internalIndex, Collection<? extends E> elements) {
        Iterator<? extends E> it = elements.iterator();
        int length = this.elementData.length;
        for (int i = internalIndex; i < length && it.hasNext(); i++) {
            this.elementData[i] = it.next();
        }
        int i2 = this.head;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.elementData[i3] = it.next();
        }
        this.size = size() + elements.size();
    }

    private final void copyElements(int newCapacity) {
        Object[] objArr = new Object[newCapacity];
        ArraysKt.copyInto(this.elementData, objArr, 0, this.head, this.elementData.length);
        ArraysKt.copyInto(this.elementData, objArr, this.elementData.length - this.head, 0, this.head);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int decremented(int index) {
        return index == 0 ? ArraysKt.getLastIndex(this.elementData) : index - 1;
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        if (minCapacity <= this.elementData.length) {
            return;
        }
        if (this.elementData == emptyElementData) {
            this.elementData = new Object[RangesKt.coerceAtLeast(minCapacity, 10)];
        } else {
            copyElements(AbstractList.INSTANCE.newCapacity$kotlin_stdlib(this.elementData.length, minCapacity));
        }
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> predicate) {
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod = positiveMod(this.head + size());
                int i = this.head;
                boolean z = false;
                if (this.head < positiveMod) {
                    for (int i2 = this.head; i2 < positiveMod; i2++) {
                        Object obj = this.elementData[i2];
                        if (predicate.invoke(obj).booleanValue()) {
                            this.elementData[i] = obj;
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    ArraysKt.fill(this.elementData, (Object) null, i, positiveMod);
                } else {
                    int length = this.elementData.length;
                    for (int i3 = this.head; i3 < length; i3++) {
                        Object obj2 = this.elementData[i3];
                        this.elementData[i3] = null;
                        if (predicate.invoke(obj2).booleanValue()) {
                            this.elementData[i] = obj2;
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    i = positiveMod(i);
                    for (int i4 = 0; i4 < positiveMod; i4++) {
                        Object obj3 = this.elementData[i4];
                        this.elementData[i4] = null;
                        if (predicate.invoke(obj3).booleanValue()) {
                            this.elementData[i] = obj3;
                            i = incremented(i);
                        } else {
                            z = true;
                        }
                    }
                }
                if (z) {
                    registerModification();
                    this.size = negativeMod(i - this.head);
                }
                return z;
            }
        }
        return false;
    }

    private final int incremented(int index) {
        if (index == ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    private final E internalGet(int internalIndex) {
        return (E) this.elementData[internalIndex];
    }

    private final int internalIndex(int index) {
        return positiveMod(this.head + index);
    }

    private final int negativeMod(int index) {
        return index < 0 ? this.elementData.length + index : index;
    }

    private final void nullifyNonEmpty(int internalFromIndex, int internalToIndex) {
        if (internalFromIndex < internalToIndex) {
            ArraysKt.fill(this.elementData, (Object) null, internalFromIndex, internalToIndex);
        } else {
            ArraysKt.fill(this.elementData, (Object) null, internalFromIndex, this.elementData.length);
            ArraysKt.fill(this.elementData, (Object) null, 0, internalToIndex);
        }
    }

    private final int positiveMod(int index) {
        return index >= this.elementData.length ? index - this.elementData.length : index;
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void removeRangeShiftPreceding(int fromIndex, int toIndex) {
        int positiveMod = positiveMod(this.head + (fromIndex - 1));
        int positiveMod2 = positiveMod(this.head + (toIndex - 1));
        int i = fromIndex;
        while (i > 0) {
            int min = Math.min(i, Math.min(positiveMod + 1, positiveMod2 + 1));
            ArraysKt.copyInto(this.elementData, this.elementData, (positiveMod2 - min) + 1, (positiveMod - min) + 1, positiveMod + 1);
            positiveMod = negativeMod(positiveMod - min);
            positiveMod2 = negativeMod(positiveMod2 - min);
            i -= min;
        }
    }

    private final void removeRangeShiftSucceeding(int fromIndex, int toIndex) {
        int positiveMod = positiveMod(this.head + toIndex);
        int positiveMod2 = positiveMod(this.head + fromIndex);
        int size = size() - toIndex;
        while (size > 0) {
            int min = Math.min(size, Math.min(this.elementData.length - positiveMod, this.elementData.length - positiveMod2));
            ArraysKt.copyInto(this.elementData, this.elementData, positiveMod2, positiveMod, positiveMod + min);
            positiveMod = positiveMod(positiveMod + min);
            positiveMod2 = positiveMod(positiveMod2 + min);
            size -= min;
        }
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        registerModification();
        ensureCapacity(size() + 1);
        int positiveMod = positiveMod(this.head + index);
        if (index < ((size() + 1) >> 1)) {
            int decremented = decremented(positiveMod);
            int decremented2 = decremented(this.head);
            if (decremented >= this.head) {
                this.elementData[decremented2] = this.elementData[this.head];
                ArraysKt.copyInto(this.elementData, this.elementData, this.head, this.head + 1, decremented + 1);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, this.head - 1, this.head, this.elementData.length);
                this.elementData[this.elementData.length - 1] = this.elementData[0];
                ArraysKt.copyInto(this.elementData, this.elementData, 0, 1, decremented + 1);
            }
            this.elementData[decremented] = element;
            this.head = decremented2;
        } else {
            int positiveMod2 = positiveMod(this.head + size());
            if (positiveMod < positiveMod2) {
                ArraysKt.copyInto(this.elementData, this.elementData, positiveMod + 1, positiveMod, positiveMod2);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, 1, 0, positiveMod2);
                this.elementData[0] = this.elementData[this.elementData.length - 1];
                ArraysKt.copyInto(this.elementData, this.elementData, positiveMod + 1, positiveMod, this.elementData.length - 1);
            }
            this.elementData[positiveMod] = element;
        }
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        registerModification();
        ensureCapacity(size() + elements.size());
        int positiveMod = positiveMod(this.head + size());
        int positiveMod2 = positiveMod(this.head + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i = this.head - size;
            if (positiveMod2 < this.head) {
                ArraysKt.copyInto(this.elementData, this.elementData, i, this.head, this.elementData.length);
                if (size >= positiveMod2) {
                    ArraysKt.copyInto(this.elementData, this.elementData, this.elementData.length - size, 0, positiveMod2);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, this.elementData.length - size, 0, size);
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, size, positiveMod2);
                }
            } else if (i >= 0) {
                ArraysKt.copyInto(this.elementData, this.elementData, i, this.head, positiveMod2);
            } else {
                i += this.elementData.length;
                int i2 = positiveMod2 - this.head;
                int length = this.elementData.length - i;
                if (length >= i2) {
                    ArraysKt.copyInto(this.elementData, this.elementData, i, this.head, positiveMod2);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, i, this.head, this.head + length);
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, this.head + length, positiveMod2);
                }
            }
            this.head = i;
            copyCollectionElements(negativeMod(positiveMod2 - size), elements);
        } else {
            int i3 = positiveMod2 + size;
            if (positiveMod2 >= positiveMod) {
                ArraysKt.copyInto(this.elementData, this.elementData, size, 0, positiveMod);
                if (i3 >= this.elementData.length) {
                    ArraysKt.copyInto(this.elementData, this.elementData, i3 - this.elementData.length, positiveMod2, this.elementData.length);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, this.elementData.length - size, this.elementData.length);
                    ArraysKt.copyInto(this.elementData, this.elementData, i3, positiveMod2, this.elementData.length - size);
                }
            } else if (positiveMod + size <= this.elementData.length) {
                ArraysKt.copyInto(this.elementData, this.elementData, i3, positiveMod2, positiveMod);
            } else if (i3 >= this.elementData.length) {
                ArraysKt.copyInto(this.elementData, this.elementData, i3 - this.elementData.length, positiveMod2, positiveMod);
            } else {
                int length2 = (positiveMod + size) - this.elementData.length;
                ArraysKt.copyInto(this.elementData, this.elementData, 0, positiveMod - length2, positiveMod);
                ArraysKt.copyInto(this.elementData, this.elementData, i3, positiveMod2, positiveMod - length2);
            }
            copyCollectionElements(positiveMod2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        registerModification();
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    public final void addFirst(E element) {
        registerModification();
        ensureCapacity(size() + 1);
        this.head = decremented(this.head);
        this.elementData[this.head] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        registerModification();
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = element;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            registerModification();
            nullifyNonEmpty(this.head, positiveMod(this.head + size()));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (E) this.elementData[positiveMod(this.head + index)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        int positiveMod = positiveMod(this.head + size());
        if (this.head < positiveMod) {
            for (int i = this.head; i < positiveMod; i++) {
                if (Intrinsics.areEqual(element, this.elementData[i])) {
                    return i - this.head;
                }
            }
            return -1;
        }
        if (this.head < positiveMod) {
            return -1;
        }
        int length = this.elementData.length;
        for (int i2 = this.head; i2 < length; i2++) {
            if (Intrinsics.areEqual(element, this.elementData[i2])) {
                return i2 - this.head;
            }
        }
        for (int i3 = 0; i3 < positiveMod; i3++) {
            if (Intrinsics.areEqual(element, this.elementData[i3])) {
                return (this.elementData.length + i3) - this.head;
            }
        }
        return -1;
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        structure.invoke(Integer.valueOf((isEmpty() || this.head < positiveMod(this.head + size())) ? this.head : this.head - this.elementData.length), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        int positiveMod = positiveMod(this.head + size());
        if (this.head < positiveMod) {
            int i = positiveMod - 1;
            int i2 = this.head;
            if (i2 <= i) {
                while (!Intrinsics.areEqual(element, this.elementData[i])) {
                    if (i != i2) {
                        i--;
                    }
                }
                return i - this.head;
            }
        } else if (this.head > positiveMod) {
            for (int i3 = positiveMod - 1; -1 < i3; i3--) {
                if (Intrinsics.areEqual(element, this.elementData[i3])) {
                    return (this.elementData.length + i3) - this.head;
                }
            }
            int lastIndex = ArraysKt.getLastIndex(this.elementData);
            int i4 = this.head;
            if (i4 <= lastIndex) {
                while (!Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                    if (lastIndex != i4) {
                        lastIndex--;
                    }
                }
                return lastIndex - this.head;
            }
        }
        return -1;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        int indexOf = indexOf(element);
        if (indexOf == -1) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod = positiveMod(this.head + size());
                int i2 = this.head;
                boolean z2 = false;
                if (this.head < positiveMod) {
                    for (int i3 = this.head; i3 < positiveMod; i3++) {
                        Object obj = this.elementData[i3];
                        if (elements.contains(obj)) {
                            z2 = true;
                        } else {
                            this.elementData[i2] = obj;
                            i2++;
                        }
                    }
                    ArraysKt.fill(this.elementData, (Object) null, i2, positiveMod);
                    boolean z3 = z2;
                    i = i2;
                    z = z3;
                } else {
                    int length = this.elementData.length;
                    for (int i4 = this.head; i4 < length; i4++) {
                        Object obj2 = this.elementData[i4];
                        this.elementData[i4] = null;
                        if (elements.contains(obj2)) {
                            z2 = true;
                        } else {
                            this.elementData[i2] = obj2;
                            i2++;
                        }
                    }
                    int positiveMod2 = positiveMod(i2);
                    for (int i5 = 0; i5 < positiveMod; i5++) {
                        Object obj3 = this.elementData[i5];
                        this.elementData[i5] = null;
                        if (elements.contains(obj3)) {
                            z2 = true;
                        } else {
                            this.elementData[positiveMod2] = obj3;
                            positiveMod2 = incremented(positiveMod2);
                        }
                    }
                    boolean z4 = z2;
                    i = positiveMod2;
                    z = z4;
                }
                if (z) {
                    registerModification();
                    this.size = negativeMod(i - this.head);
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        if (index == CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        registerModification();
        int positiveMod = positiveMod(this.head + index);
        E e = (E) this.elementData[positiveMod];
        if (index < (size() >> 1)) {
            if (positiveMod >= this.head) {
                ArraysKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, positiveMod);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, 1, 0, positiveMod);
                this.elementData[0] = this.elementData[this.elementData.length - 1];
                ArraysKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, this.elementData.length - 1);
            }
            this.elementData[this.head] = null;
            this.head = incremented(this.head);
        } else {
            int positiveMod2 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
            if (positiveMod <= positiveMod2) {
                ArraysKt.copyInto(this.elementData, this.elementData, positiveMod, positiveMod + 1, positiveMod2 + 1);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, positiveMod, positiveMod + 1, this.elementData.length);
                this.elementData[this.elementData.length - 1] = this.elementData[0];
                ArraysKt.copyInto(this.elementData, this.elementData, 0, 1, positiveMod2 + 1);
            }
            this.elementData[positiveMod2] = null;
        }
        this.size = size() - 1;
        return e;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        E e = (E) this.elementData[this.head];
        this.elementData[this.head] = null;
        this.head = incremented(this.head);
        this.size = size() - 1;
        return e;
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        int positiveMod = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        E e = (E) this.elementData[positiveMod];
        this.elementData[positiveMod] = null;
        this.size = size() - 1;
        return e;
    }

    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, size());
        int i = toIndex - fromIndex;
        if (i == 0) {
            return;
        }
        if (i == size()) {
            clear();
            return;
        }
        if (i == 1) {
            removeAt(fromIndex);
            return;
        }
        registerModification();
        if (fromIndex < size() - toIndex) {
            removeRangeShiftPreceding(fromIndex, toIndex);
            int positiveMod = positiveMod(this.head + i);
            nullifyNonEmpty(this.head, positiveMod);
            this.head = positiveMod;
        } else {
            removeRangeShiftSucceeding(fromIndex, toIndex);
            int positiveMod2 = positiveMod(this.head + size());
            nullifyNonEmpty(negativeMod(positiveMod2 - i), positiveMod2);
        }
        this.size = size() - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod = positiveMod(this.head + size());
                int i2 = this.head;
                boolean z2 = false;
                if (this.head < positiveMod) {
                    for (int i3 = this.head; i3 < positiveMod; i3++) {
                        Object obj = this.elementData[i3];
                        if (elements.contains(obj)) {
                            this.elementData[i2] = obj;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    ArraysKt.fill(this.elementData, (Object) null, i2, positiveMod);
                    boolean z3 = z2;
                    i = i2;
                    z = z3;
                } else {
                    int length = this.elementData.length;
                    for (int i4 = this.head; i4 < length; i4++) {
                        Object obj2 = this.elementData[i4];
                        this.elementData[i4] = null;
                        if (elements.contains(obj2)) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    int positiveMod2 = positiveMod(i2);
                    for (int i5 = 0; i5 < positiveMod; i5++) {
                        Object obj3 = this.elementData[i5];
                        this.elementData[i5] = null;
                        if (elements.contains(obj3)) {
                            this.elementData[positiveMod2] = obj3;
                            positiveMod2 = incremented(positiveMod2);
                        } else {
                            z2 = true;
                        }
                    }
                    boolean z4 = z2;
                    i = positiveMod2;
                    z = z4;
                }
                if (z) {
                    registerModification();
                    this.size = negativeMod(i - this.head);
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        int positiveMod = positiveMod(this.head + index);
        E e = (E) this.elementData[positiveMod];
        this.elementData[positiveMod] = element;
        return e;
    }

    public final void testRemoveRange$kotlin_stdlib(int fromIndex, int toIndex) {
        removeRange(fromIndex, toIndex);
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) toArray(array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        Object[] arrayOfNulls = array.length >= size() ? array : ArraysKt.arrayOfNulls(array, size());
        int positiveMod = positiveMod(this.head + size());
        if (this.head < positiveMod) {
            ArraysKt.copyInto$default(this.elementData, arrayOfNulls, 0, this.head, positiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            ArraysKt.copyInto(this.elementData, arrayOfNulls, 0, this.head, this.elementData.length);
            ArraysKt.copyInto(this.elementData, arrayOfNulls, this.elementData.length - this.head, 0, positiveMod);
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size(), arrayOfNulls);
    }
}
