package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: FloatSet.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\u0003H\u0007J\u0019\u0010!\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0082\bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/collection/MutableFloatSet;", "Landroidx/collection/FloatSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "", "addAll", "elements", "", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeDeletedMarkers", "removeElementAt", "index", "resizeStorage", "newCapacity", "trim", "writeMetadata", "value", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableFloatSet extends FloatSet {
    private int growthLimit;

    public MutableFloatSet() {
        this(0, 1, null);
    }

    public MutableFloatSet(int i) {
        super(null);
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Capacity must be a positive value.".toString());
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public /* synthetic */ MutableFloatSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || MutableFloatFloatMap$$ExternalSyntheticBackport0.m(ULong.m631constructorimpl(ULong.m631constructorimpl(this._size) * 32), ULong.m631constructorimpl(ULong.m631constructorimpl(this._capacity) * 25)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0098, code lost:
    
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009b, code lost:
    
        r4 = r0.findFirstAvailableSlot(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a3, code lost:
    
        if (r0.growthLimit != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
    
        if (((r0.metadata[r4 >> 3] >> ((r4 & 7) << 3)) & 255) != 254) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b9, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00be, code lost:
    
        if (r5 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c0, code lost:
    
        r0.adjustStorage();
        r4 = r0.findFirstAvailableSlot(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bc, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c7, code lost:
    
        r0._size++;
        r5 = r0.growthLimit;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e1, code lost:
    
        if (((r0.metadata[r4 >> 3] >> ((r4 & 7) << 3)) & 255) != 128) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e3, code lost:
    
        r19 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e5, code lost:
    
        r0.growthLimit = r5 - r19;
        r9 = r3;
        r12 = r23.metadata;
        r14 = r4 >> 3;
        r17 = (r4 & 7) << 3;
        r12[r14] = (r12[r14] & (~(255 << r17))) | (r9 << r17);
        r7 = r23._capacity;
        r8 = ((r4 - 7) & r7) + (r7 & 7);
        r14 = r8 >> 3;
        r17 = (r8 & 7) << 3;
        r12[r14] = (r12[r14] & (~(255 << r17))) | (r9 << r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0126, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findAbsoluteInsertIndex(float r24) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableFloatSet.findAbsoluteInsertIndex(float):int");
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i = this._capacity;
        int i2 = hash1 & i;
        int i3 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i4 = i2 >> 3;
            int i5 = (i2 & 7) << 3;
            long j = (jArr[i4] >>> i5) | ((jArr[i4 + 1] << (64 - i5)) & ((-i5) >> 63));
            long j2 = ((~j) << 7) & j & (-9187201950435737472L);
            if (j2 != 0) {
                return ((Long.numberOfTrailingZeros(j2) >> 3) + i2) & i;
            }
            i3 += 8;
            i2 = (i2 + i3) & i;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            long[] jArr2 = new long[((((capacity + 1) + 7) + 7) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.metadata = jArr;
        long[] jArr3 = this.metadata;
        int i = capacity >> 3;
        int i2 = (capacity & 7) << 3;
        jArr3[i] = (jArr3[i] & (~(255 << i2))) | (255 << i2);
        initializeGrowth();
    }

    private final void initializeStorage(int initialCapacity) {
        int max = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.elements = new float[max];
    }

    private final void removeDeletedMarkers() {
        long[] jArr;
        int i;
        long[] jArr2 = this.metadata;
        int i2 = this._capacity;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            if (((jArr2[i4 >> 3] >> ((i4 & 7) << 3)) & 255) == 254) {
                long[] jArr3 = this.metadata;
                int i5 = i4 >> 3;
                int i6 = (i4 & 7) << 3;
                jArr3[i5] = (jArr3[i5] & (~(255 << i6))) | (128 << i6);
                int i7 = this._capacity;
                int i8 = ((i4 - 7) & i7) + (i7 & 7);
                int i9 = i8 >> 3;
                int i10 = (i8 & 7) << 3;
                jArr = jArr2;
                i = i2;
                jArr3[i9] = (jArr3[i9] & (~(255 << i10))) | (128 << i10);
                i3++;
            } else {
                jArr = jArr2;
                i = i2;
            }
            i4++;
            jArr2 = jArr;
            i2 = i;
        }
        this.growthLimit += i3;
    }

    private final void removeElementAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = index >> 3;
        int i2 = (index & 7) << 3;
        jArr[i] = (jArr[i] & (~(255 << i2))) | (254 << i2);
        int i3 = this._capacity;
        int i4 = ((index - 7) & i3) + (i3 & 7);
        int i5 = i4 >> 3;
        int i6 = (i4 & 7) << 3;
        jArr[i5] = (jArr[i5] & (~(255 << i6))) | (254 << i6);
    }

    private final void resizeStorage(int newCapacity) {
        long[] jArr;
        MutableFloatSet mutableFloatSet = this;
        long[] jArr2 = mutableFloatSet.metadata;
        float[] fArr = mutableFloatSet.elements;
        int i = mutableFloatSet._capacity;
        initializeStorage(newCapacity);
        float[] fArr2 = mutableFloatSet.elements;
        int i2 = 0;
        while (i2 < i) {
            if (((jArr2[i2 >> 3] >> ((i2 & 7) << 3)) & 255) < 128) {
                float f = fArr[i2];
                int hashCode = Float.hashCode(f) * ScatterMapKt.MurmurHashC1;
                int i3 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = mutableFloatSet.findFirstAvailableSlot(i3 >>> 7);
                long j = i3 & WorkQueueKt.MASK;
                long[] jArr3 = this.metadata;
                int i4 = findFirstAvailableSlot >> 3;
                int i5 = (findFirstAvailableSlot & 7) << 3;
                jArr3[i4] = (jArr3[i4] & (~(255 << i5))) | (j << i5);
                int i6 = this._capacity;
                int i7 = ((findFirstAvailableSlot - 7) & i6) + (i6 & 7);
                int i8 = i7 >> 3;
                int i9 = (i7 & 7) << 3;
                jArr = jArr2;
                jArr3[i8] = (jArr3[i8] & (~(255 << i9))) | (j << i9);
                fArr2[findFirstAvailableSlot] = f;
            } else {
                jArr = jArr2;
            }
            i2++;
            mutableFloatSet = this;
            jArr2 = jArr;
        }
    }

    private final void writeMetadata(int index, long value) {
        long[] jArr = this.metadata;
        int i = index >> 3;
        int i2 = (index & 7) << 3;
        jArr[i] = (jArr[i] & (~(255 << i2))) | (value << i2);
        int i3 = this._capacity;
        int i4 = ((index - 7) & i3) + (i3 & 7);
        int i5 = i4 >> 3;
        int i6 = (i4 & 7) << 3;
        jArr[i5] = (jArr[i5] & (~(255 << i6))) | (value << i6);
    }

    public final boolean add(float element) {
        int i = this._size;
        this.elements[findAbsoluteInsertIndex(element)] = element;
        return this._size != i;
    }

    public final boolean addAll(FloatSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign(elements);
        return i != this._size;
    }

    public final boolean addAll(float[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign(elements);
        return i != this._size;
    }

    public final void clear() {
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            int i3 = (i & 7) << 3;
            jArr[i2] = (jArr[i2] & (~(255 << i3))) | (255 << i3);
        }
        initializeGrowth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
    
        if (((((~r12) << 6) & r12) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a2, code lost:
    
        r22 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void minusAssign(float r24) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableFloatSet.minusAssign(float):void");
    }

    public final void minusAssign(FloatSet elements) {
        FloatSet floatSet;
        FloatSet floatSet2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        FloatSet floatSet3 = elements;
        float[] fArr = floatSet3.elements;
        long[] jArr = floatSet3.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        i = i3;
                        floatSet2 = floatSet3;
                        minusAssign(fArr[(i2 << 3) + i5]);
                    } else {
                        floatSet2 = floatSet3;
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                    floatSet3 = floatSet2;
                }
                floatSet = floatSet3;
                if (i4 != i3) {
                    return;
                }
            } else {
                floatSet = floatSet3;
            }
            if (i2 == length) {
                return;
            }
            i2++;
            floatSet3 = floatSet;
        }
    }

    public final void minusAssign(float[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (float f : elements) {
            minusAssign(f);
        }
    }

    public final void plusAssign(float element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    public final void plusAssign(FloatSet elements) {
        FloatSet floatSet;
        FloatSet floatSet2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        FloatSet floatSet3 = elements;
        float[] fArr = floatSet3.elements;
        long[] jArr = floatSet3.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        i = i3;
                        floatSet2 = floatSet3;
                        plusAssign(fArr[(i2 << 3) + i5]);
                    } else {
                        floatSet2 = floatSet3;
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                    floatSet3 = floatSet2;
                }
                floatSet = floatSet3;
                if (i4 != i3) {
                    return;
                }
            } else {
                floatSet = floatSet3;
            }
            if (i2 == length) {
                return;
            }
            i2++;
            floatSet3 = floatSet;
        }
    }

    public final void plusAssign(float[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (float f : elements) {
            plusAssign(f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        if (((((~r12) << 6) & r12) & (-9187201950435737472L)) == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a5, code lost:
    
        r22 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(float r25) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableFloatSet.remove(float):boolean");
    }

    public final boolean removeAll(FloatSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign(elements);
        return i != this._size;
    }

    public final boolean removeAll(float[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign(elements);
        return i != this._size;
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity >= i) {
            return 0;
        }
        resizeStorage(normalizeCapacity);
        return i - this._capacity;
    }
}
