package androidx.collection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: IntIntMap.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0086\bø\u0001\u0000J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0086\nJ\u0011\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0017H\u0086\nJ\u0011\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0086\nJ\u0011\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0001H\u0086\nJ\u0016\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003J\u001e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0001J\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003J\b\u0010!\u001a\u00020\u0007H\u0002J&\u0010\"\u001a\u00020\u00072\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0$H\u0086\bø\u0001\u0000J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0003H\u0001J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0019\u0010)\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010*\u001a\u00020\u0003J\u0019\u0010+\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020,H\u0082\bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, d2 = {"Landroidx/collection/MutableIntIntMap;", "Landroidx/collection/IntIntMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findFirstAvailableSlot", "hash1", "findInsertIndex", "key", "getOrPut", "defaultValue", "Lkotlin/Function0;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/IntList;", "Landroidx/collection/IntSet;", "", "plusAssign", TypedValues.TransitionType.S_FROM, "put", "value", "default", "putAll", "remove", "", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", "set", "trim", "writeMetadata", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableIntIntMap extends IntIntMap {
    private int growthLimit;

    public MutableIntIntMap() {
        this(0, 1, null);
    }

    public MutableIntIntMap(int i) {
        super(null);
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Capacity must be a positive value.".toString());
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public /* synthetic */ MutableIntIntMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || MutableFloatFloatMap$$ExternalSyntheticBackport0.m(ULong.m631constructorimpl(ULong.m631constructorimpl(this._size) * 32), ULong.m631constructorimpl(ULong.m631constructorimpl(this._capacity) * 25)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x009a, code lost:
    
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009d, code lost:
    
        r4 = r0.findFirstAvailableSlot(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a5, code lost:
    
        if (r0.growthLimit != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b9, code lost:
    
        if (((r0.metadata[r4 >> 3] >> ((r4 & 7) << 3)) & 255) != 254) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bb, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c0, code lost:
    
        if (r5 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c2, code lost:
    
        r0.adjustStorage();
        r4 = r0.findFirstAvailableSlot(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00be, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c9, code lost:
    
        r0._size++;
        r5 = r0.growthLimit;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e4, code lost:
    
        if (((r0.metadata[r4 >> 3] >> ((r4 & 7) << 3)) & 255) != 128) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e6, code lost:
    
        r19 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e8, code lost:
    
        r0.growthLimit = r5 - r19;
        r10 = r3;
        r13 = r24.metadata;
        r17 = r4 >> 3;
        r18 = (r4 & 7) << 3;
        r13[r17] = (r13[r17] & (~(255 << r18))) | (r10 << r18);
        r7 = r24._capacity;
        r8 = ((r4 - 7) & r7) + (r7 & 7);
        r17 = r8 >> 3;
        r18 = (r8 & 7) << 3;
        r13[r17] = (r13[r17] & (~(255 << r18))) | (r10 << r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x012a, code lost:
    
        return ~r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findInsertIndex(int r25) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntIntMap.findInsertIndex(int):int");
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
        this.keys = new int[max];
        this.values = new int[max];
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

    private final void resizeStorage(int newCapacity) {
        long[] jArr;
        MutableIntIntMap mutableIntIntMap = this;
        long[] jArr2 = mutableIntIntMap.metadata;
        int[] iArr = mutableIntIntMap.keys;
        int[] iArr2 = mutableIntIntMap.values;
        int i = mutableIntIntMap._capacity;
        initializeStorage(newCapacity);
        int[] iArr3 = mutableIntIntMap.keys;
        int[] iArr4 = mutableIntIntMap.values;
        int i2 = 0;
        while (i2 < i) {
            if (((jArr2[i2 >> 3] >> ((i2 & 7) << 3)) & 255) < 128) {
                int i3 = iArr[i2];
                int hashCode = Integer.hashCode(i3) * ScatterMapKt.MurmurHashC1;
                int i4 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = mutableIntIntMap.findFirstAvailableSlot(i4 >>> 7);
                long j = i4 & WorkQueueKt.MASK;
                long[] jArr3 = this.metadata;
                int i5 = findFirstAvailableSlot >> 3;
                int i6 = (findFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                jArr3[i5] = (jArr3[i5] & (~(255 << i6))) | (j << i6);
                int i7 = this._capacity;
                int i8 = ((findFirstAvailableSlot - 7) & i7) + (i7 & 7);
                int i9 = i8 >> 3;
                int i10 = (i8 & 7) << 3;
                jArr3[i9] = (jArr3[i9] & (~(255 << i10))) | (j << i10);
                iArr3[findFirstAvailableSlot] = i3;
                iArr4[findFirstAvailableSlot] = iArr2[i2];
            } else {
                jArr = jArr2;
            }
            i2++;
            mutableIntIntMap = this;
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

    public final int getOrPut(int key, Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        int intValue = defaultValue.invoke().intValue();
        put(key, intValue);
        return intValue;
    }

    public final void minusAssign(int key) {
        remove(key);
    }

    public final void minusAssign(IntList keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        int[] iArr = keys.content;
        int i = keys._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(iArr[i2]);
        }
    }

    public final void minusAssign(IntSet keys) {
        IntSet intSet;
        int i;
        IntSet intSet2;
        Intrinsics.checkNotNullParameter(keys, "keys");
        boolean z = false;
        IntSet intSet3 = keys;
        int[] iArr = intSet3.elements;
        long[] jArr = intSet3.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr[i2];
            boolean z2 = z;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        i = i3;
                        intSet2 = intSet3;
                        remove(iArr[(i2 << 3) + i5]);
                    } else {
                        i = i3;
                        intSet2 = intSet3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                    intSet3 = intSet2;
                }
                intSet = intSet3;
                if (i4 != i3) {
                    return;
                }
            } else {
                intSet = intSet3;
            }
            if (i2 == length) {
                return;
            }
            i2++;
            z = z2;
            intSet3 = intSet;
        }
    }

    public final void minusAssign(int[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (int i : keys) {
            remove(i);
        }
    }

    public final void plusAssign(IntIntMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final int put(int key, int value, int r6) {
        int findInsertIndex = findInsertIndex(key);
        int i = r6;
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        } else {
            i = this.values[findInsertIndex];
        }
        this.keys[findInsertIndex] = key;
        this.values[findInsertIndex] = value;
        return i;
    }

    public final void put(int key, int value) {
        set(key, value);
    }

    public final void putAll(IntIntMap from) {
        boolean z;
        int[] iArr;
        int i;
        boolean z2;
        int[] iArr2;
        Intrinsics.checkNotNullParameter(from, "from");
        IntIntMap intIntMap = from;
        boolean z3 = false;
        int[] iArr3 = intIntMap.keys;
        int[] iArr4 = intIntMap.values;
        long[] jArr = intIntMap.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr[i2];
            IntIntMap intIntMap2 = intIntMap;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        int i6 = (i2 << 3) + i5;
                        i = i3;
                        z2 = z3;
                        iArr2 = iArr3;
                        set(iArr3[i6], iArr4[i6]);
                    } else {
                        i = i3;
                        z2 = z3;
                        iArr2 = iArr3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                    z3 = z2;
                    iArr3 = iArr2;
                }
                z = z3;
                iArr = iArr3;
                if (i4 != i3) {
                    return;
                }
            } else {
                z = z3;
                iArr = iArr3;
            }
            if (i2 == length) {
                return;
            }
            i2++;
            intIntMap = intIntMap2;
            z3 = z;
            iArr3 = iArr;
        }
    }

    public final void remove(int key) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public final boolean remove(int key, int value) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != value) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void removeIf(Function2<? super Integer, ? super Integer, Boolean> predicate) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z3 = false;
        long[] jArr = this.metadata;
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
                        int i6 = (i2 << 3) + i5;
                        i = i3;
                        z2 = z3;
                        if (predicate.invoke(Integer.valueOf(this.keys[i6]), Integer.valueOf(this.values[i6])).booleanValue()) {
                            removeValueAt(i6);
                        }
                    } else {
                        z2 = z3;
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                    z3 = z2;
                }
                z = z3;
                if (i4 != i3) {
                    return;
                }
            } else {
                z = z3;
            }
            if (i2 == length) {
                return;
            }
            i2++;
            z3 = z;
        }
    }

    public final void removeValueAt(int index) {
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

    public final void set(int key, int value) {
        int findInsertIndex = findInsertIndex(key);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = key;
        this.values[findInsertIndex] = value;
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
