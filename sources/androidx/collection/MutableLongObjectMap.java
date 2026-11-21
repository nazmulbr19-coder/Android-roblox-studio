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

/* compiled from: LongObjectMap.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J'\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001aH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001bH\u0086\nJ\u0017\u0010\u001c\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001d\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010#J\u001b\u0010\"\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\bH\u0002J&\u0010'\u001a\u00020\b2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0)H\u0086\bø\u0001\u0000J\u0017\u0010*\u001a\u0004\u0018\u00018\u00002\u0006\u0010+\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001e\u0010/\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0004J\u0019\u00102\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\fH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00063"}, d2 = {"Landroidx/collection/MutableLongObjectMap;", "V", "Landroidx/collection/LongObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "key", "", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/LongList;", "Landroidx/collection/LongSet;", "", "plusAssign", TypedValues.TransitionType.S_FROM, "put", "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(J)Ljava/lang/Object;", "", "(JLjava/lang/Object;)Z", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "set", "(JLjava/lang/Object;)V", "trim", "writeMetadata", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableLongObjectMap<V> extends LongObjectMap<V> {
    private int growthLimit;

    public MutableLongObjectMap() {
        this(0, 1, null);
    }

    public MutableLongObjectMap(int i) {
        super(null);
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Capacity must be a positive value.".toString());
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public /* synthetic */ MutableLongObjectMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || MutableFloatFloatMap$$ExternalSyntheticBackport0.m(ULong.m631constructorimpl(ULong.m631constructorimpl(this._size) * 32), ULong.m631constructorimpl(ULong.m631constructorimpl(this._capacity) * 25)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0094, code lost:
    
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0097, code lost:
    
        r4 = r0.findFirstAvailableSlot(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009f, code lost:
    
        if (r0.growthLimit != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b3, code lost:
    
        if (((r0.metadata[r4 >> 3] >> ((r4 & 7) << 3)) & 255) != 254) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b5, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ba, code lost:
    
        if (r5 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bc, code lost:
    
        r0.adjustStorage();
        r4 = r0.findFirstAvailableSlot(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c3, code lost:
    
        r0._size++;
        r5 = r0.growthLimit;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00dd, code lost:
    
        if (((r0.metadata[r4 >> 3] >> ((r4 & 7) << 3)) & 255) != 128) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00df, code lost:
    
        r19 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e1, code lost:
    
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
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0122, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findAbsoluteInsertIndex(long r24) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongObjectMap.findAbsoluteInsertIndex(long):int");
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
        this.keys = new long[max];
        this.values = new Object[max];
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
        MutableLongObjectMap<V> mutableLongObjectMap = this;
        long[] jArr2 = mutableLongObjectMap.metadata;
        long[] jArr3 = mutableLongObjectMap.keys;
        Object[] objArr = mutableLongObjectMap.values;
        int i = mutableLongObjectMap._capacity;
        initializeStorage(newCapacity);
        long[] jArr4 = mutableLongObjectMap.keys;
        Object[] objArr2 = mutableLongObjectMap.values;
        int i2 = 0;
        while (i2 < i) {
            if (((jArr2[i2 >> 3] >> ((i2 & 7) << 3)) & 255) < 128) {
                long j = jArr3[i2];
                int hashCode = Long.hashCode(j) * ScatterMapKt.MurmurHashC1;
                int i3 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = mutableLongObjectMap.findFirstAvailableSlot(i3 >>> 7);
                long j2 = i3 & WorkQueueKt.MASK;
                long[] jArr5 = this.metadata;
                int i4 = findFirstAvailableSlot >> 3;
                int i5 = (findFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                jArr5[i4] = (jArr5[i4] & (~(255 << i5))) | (j2 << i5);
                int i6 = this._capacity;
                int i7 = ((findFirstAvailableSlot - 7) & i6) + (i6 & 7);
                int i8 = i7 >> 3;
                int i9 = (i7 & 7) << 3;
                jArr5[i8] = (jArr5[i8] & (~(255 << i9))) | (j2 << i9);
                jArr4[findFirstAvailableSlot] = j;
                objArr2[findFirstAvailableSlot] = objArr[i2];
            } else {
                jArr = jArr2;
            }
            i2++;
            mutableLongObjectMap = this;
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
        ArraysKt.fill(this.values, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    public final V getOrPut(long key, Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = get(key);
        if (v != null) {
            return v;
        }
        V invoke = defaultValue.invoke();
        set(key, invoke);
        return invoke;
    }

    public final void minusAssign(long key) {
        remove(key);
    }

    public final void minusAssign(LongList keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        long[] jArr = keys.content;
        int i = keys._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(jArr[i2]);
        }
    }

    public final void minusAssign(LongSet keys) {
        LongSet longSet;
        boolean z;
        int i;
        LongSet longSet2;
        boolean z2;
        Intrinsics.checkNotNullParameter(keys, "keys");
        boolean z3 = false;
        LongSet longSet3 = keys;
        boolean z4 = false;
        long[] jArr = longSet3.elements;
        long[] jArr2 = longSet3.metadata;
        int length = jArr2.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr2[i2];
            boolean z5 = z3;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        i = i3;
                        longSet2 = longSet3;
                        z2 = z4;
                        remove(jArr[(i2 << 3) + i5]);
                    } else {
                        i = i3;
                        longSet2 = longSet3;
                        z2 = z4;
                    }
                    j >>= i;
                    i5++;
                    longSet3 = longSet2;
                    i3 = i;
                    z4 = z2;
                }
                longSet = longSet3;
                z = z4;
                if (i4 != i3) {
                    return;
                }
            } else {
                longSet = longSet3;
                z = z4;
            }
            if (i2 == length) {
                return;
            }
            i2++;
            z3 = z5;
            longSet3 = longSet;
            z4 = z;
        }
    }

    public final void minusAssign(long[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (long j : keys) {
            remove(j);
        }
    }

    public final void plusAssign(LongObjectMap<V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final V put(long key, V value) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(key);
        V v = (V) this.values[findAbsoluteInsertIndex];
        this.keys[findAbsoluteInsertIndex] = key;
        this.values[findAbsoluteInsertIndex] = value;
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(LongObjectMap<V> from) {
        boolean z;
        long[] jArr;
        Object[] objArr;
        int i;
        boolean z2;
        long[] jArr2;
        Object[] objArr2;
        Intrinsics.checkNotNullParameter(from, "from");
        LongObjectMap<V> longObjectMap = from;
        boolean z3 = false;
        long[] jArr3 = longObjectMap.keys;
        Object[] objArr3 = longObjectMap.values;
        long[] jArr4 = longObjectMap.metadata;
        int length = jArr4.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr4[i2];
            LongObjectMap<V> longObjectMap2 = longObjectMap;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        int i6 = (i2 << 3) + i5;
                        i = i3;
                        z2 = z3;
                        jArr2 = jArr3;
                        objArr2 = objArr3;
                        set(jArr3[i6], objArr3[i6]);
                    } else {
                        i = i3;
                        z2 = z3;
                        jArr2 = jArr3;
                        objArr2 = objArr3;
                    }
                    j >>= i;
                    i5++;
                    z3 = z2;
                    i3 = i;
                    jArr3 = jArr2;
                    objArr3 = objArr2;
                }
                z = z3;
                jArr = jArr3;
                objArr = objArr3;
                if (i4 != i3) {
                    return;
                }
            } else {
                z = z3;
                jArr = jArr3;
                objArr = objArr3;
            }
            if (i2 == length) {
                return;
            }
            i2++;
            longObjectMap = longObjectMap2;
            z3 = z;
            jArr3 = jArr;
            objArr3 = objArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0097, code lost:
    
        if (((((~r12) << 6) & r12) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        r20 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V remove(long r23) {
        /*
            Method dump skipped, instructions count: 183
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongObjectMap.remove(long):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009b, code lost:
    
        if (((((~r12) << 6) & r12) & (-9187201950435737472L)) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009e, code lost:
    
        r22 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(long r25, V r27) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongObjectMap.remove(long, java.lang.Object):boolean");
    }

    public final void removeIf(Function2<? super Long, ? super V, Boolean> predicate) {
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
                        if (predicate.invoke(Long.valueOf(this.keys[i6]), this.values[i6]).booleanValue()) {
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

    public final V removeValueAt(int index) {
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
        V v = (V) this.values[index];
        this.values[index] = null;
        return v;
    }

    public final void set(long key, V value) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[findAbsoluteInsertIndex] = key;
        this.values[findAbsoluteInsertIndex] = value;
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
