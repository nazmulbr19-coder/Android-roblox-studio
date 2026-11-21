package androidx.collection;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LongFloatMap.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J&\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0006\u0010\u001b\u001a\u00020\u0016J&\u0010\u001b\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0011\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0019H\u0086\u0002J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u0004J&\u0010!\u001a\u00020\u00042\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0013\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0019H\u0001JD\u0010%\u001a\u00020&26\u0010'\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020&0\u0018H\u0086\bø\u0001\u0000J/\u0010*\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020&0+H\u0081\bø\u0001\u0000J/\u0010-\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020&0+H\u0086\bø\u0001\u0000J/\u0010.\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020&0+H\u0086\bø\u0001\u0000J\u0011\u0010/\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0019H\u0086\u0002J\u0016\u00100\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u001aJ\"\u00102\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00192\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a03H\u0086\bø\u0001\u0000J\b\u00104\u001a\u00020\u0004H\u0016J\u0006\u00105\u001a\u00020\u0016J\u0006\u00106\u001a\u00020\u0016J:\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010>\u001a\u00020:H\u0007Jx\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010>\u001a\u00020:28\b\u0004\u0010?\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020:0\u0018H\u0087\bø\u0001\u0000J\u0006\u0010@\u001a\u00020\u0016J\b\u0010A\u001a\u000208H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0018\u0010\u0006\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0018\u0010\u000e\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\nR\u0018\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u0082\u0001\u0001B\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006C"}, d2 = {"Landroidx/collection/LongFloatMap;", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "", "", "any", "contains", "key", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_NONE_SCRIPT, "toString", "Landroidx/collection/MutableLongFloatMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LongFloatMap {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public float[] values;

    private LongFloatMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = FloatSetKt.getEmptyFloatArray();
    }

    public /* synthetic */ LongFloatMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public static /* synthetic */ String joinToString$default(LongFloatMap longFloatMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        return longFloatMap.joinToString(charSequence, charSequence2, charSequence3, i, (i2 & 16) != 0 ? "..." : charSequence4);
    }

    public static /* synthetic */ String joinToString$default(LongFloatMap longFloatMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 transform, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        CharSequence separator = (i2 & 1) != 0 ? ", " : charSequence;
        CharSequence prefix = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence postfix = (i2 & 4) != 0 ? "" : charSequence3;
        int i4 = (i2 & 8) != 0 ? -1 : i;
        CharSequence truncated = (i2 & 16) != 0 ? "..." : charSequence4;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        sb.append(prefix);
        int i5 = 0;
        LongFloatMap longFloatMap2 = longFloatMap;
        boolean z2 = false;
        long[] jArr = longFloatMap2.keys;
        float[] fArr = longFloatMap2.values;
        long[] jArr2 = longFloatMap2.metadata;
        int length = jArr2.length - 2;
        int i6 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i6];
                boolean z3 = z;
                int i7 = i5;
                LongFloatMap longFloatMap3 = longFloatMap2;
                boolean z4 = z2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    int i11 = i7;
                    while (i10 < i9) {
                        if ((j & 255) < 128) {
                            int i12 = (i6 << 3) + i10;
                            long j2 = jArr[i12];
                            float f = fArr[i12];
                            if (i11 == i4) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i11 != 0) {
                                sb.append(separator);
                            }
                            i3 = i8;
                            charSequence6 = separator;
                            sb.append((CharSequence) transform.invoke(Long.valueOf(j2), Float.valueOf(f)));
                            i11++;
                        } else {
                            charSequence6 = separator;
                            i3 = i8;
                        }
                        j >>= i3;
                        i10++;
                        i8 = i3;
                        separator = charSequence6;
                    }
                    charSequence5 = separator;
                    if (i9 != i8) {
                        break;
                    }
                    i5 = i11;
                } else {
                    charSequence5 = separator;
                    i5 = i7;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                longFloatMap2 = longFloatMap3;
                z2 = z4;
                z = z3;
                separator = charSequence5;
            }
        }
        sb.append(postfix);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final boolean all(Function2<? super Long, ? super Float, Boolean> predicate) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z3 = false;
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i2 = 0;
        if (0 > length) {
            return true;
        }
        while (true) {
            long j = jArr2[i2];
            long j2 = j;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((j2 & 255) < 128) {
                        int i6 = (i2 << 3) + i5;
                        i = i3;
                        z2 = z3;
                        if (!predicate.invoke(Long.valueOf(jArr[i6]), Float.valueOf(fArr[i6])).booleanValue()) {
                            return false;
                        }
                    } else {
                        z2 = z3;
                        i = i3;
                    }
                    j2 >>= i;
                    i5++;
                    i3 = i;
                    z3 = z2;
                }
                z = z3;
                if (i4 != i3) {
                    return true;
                }
            } else {
                z = z3;
            }
            if (i2 == length) {
                return true;
            }
            i2++;
            z3 = z;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean any(Function2<? super Long, ? super Float, Boolean> predicate) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z3 = false;
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i2 = 0;
        if (0 > length) {
            return false;
        }
        while (true) {
            long j = jArr2[i2];
            long j2 = j;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((j2 & 255) < 128) {
                        int i6 = (i2 << 3) + i5;
                        i = i3;
                        z2 = z3;
                        if (predicate.invoke(Long.valueOf(jArr[i6]), Float.valueOf(fArr[i6])).booleanValue()) {
                            return true;
                        }
                    } else {
                        z2 = z3;
                        i = i3;
                    }
                    j2 >>= i;
                    i5++;
                    i3 = i;
                    z3 = z2;
                }
                z = z3;
                if (i4 != i3) {
                    return false;
                }
            } else {
                z = z3;
            }
            if (i2 == length) {
                return false;
            }
            i2++;
            z3 = z;
        }
    }

    public final boolean contains(long key) {
        return findKeyIndex(key) >= 0;
    }

    public final boolean containsKey(long key) {
        return findKeyIndex(key) >= 0;
    }

    public final boolean containsValue(float value) {
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            if (value == fArr[(i << 3) + i3]) {
                                return true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count() {
        return get_size();
    }

    public final int count(Function2<? super Long, ? super Float, Boolean> predicate) {
        LongFloatMap longFloatMap;
        int i;
        LongFloatMap longFloatMap2;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z = false;
        int i2 = 0;
        LongFloatMap longFloatMap3 = this;
        long[] jArr = longFloatMap3.keys;
        float[] fArr = longFloatMap3.values;
        long[] jArr2 = longFloatMap3.metadata;
        int length = jArr2.length - 2;
        int i3 = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr2[i3];
                boolean z2 = z;
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((255 & j) < 128) {
                            int i8 = (i3 << 3) + i7;
                            i = i5;
                            longFloatMap2 = longFloatMap3;
                            if (predicate.invoke(Long.valueOf(jArr[i8]), Float.valueOf(fArr[i8])).booleanValue()) {
                                i4++;
                            }
                        } else {
                            i = i5;
                            longFloatMap2 = longFloatMap3;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                        longFloatMap3 = longFloatMap2;
                    }
                    longFloatMap = longFloatMap3;
                    if (i6 != i5) {
                        return i4;
                    }
                    i2 = i4;
                } else {
                    longFloatMap = longFloatMap3;
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                z = z2;
                longFloatMap3 = longFloatMap;
            }
        }
        return i2;
    }

    public boolean equals(Object other) {
        LongFloatMap longFloatMap;
        boolean z;
        int i;
        LongFloatMap longFloatMap2;
        boolean z2;
        boolean z3 = true;
        if (other == this) {
            return true;
        }
        boolean z4 = false;
        if (!(other instanceof LongFloatMap) || ((LongFloatMap) other).get_size() != get_size()) {
            return false;
        }
        LongFloatMap longFloatMap3 = this;
        boolean z5 = false;
        long[] jArr = longFloatMap3.keys;
        float[] fArr = longFloatMap3.values;
        long[] jArr2 = longFloatMap3.metadata;
        int length = jArr2.length - 2;
        int i2 = 0;
        if (0 > length) {
            return true;
        }
        while (true) {
            long j = jArr2[i2];
            boolean z6 = z3;
            boolean z7 = z4;
            boolean z8 = z5;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((j & 255) < 128 ? z6 : z7) {
                        int i6 = (i2 << 3) + i5;
                        i = i3;
                        longFloatMap2 = longFloatMap3;
                        z2 = z7;
                        if (!(fArr[i6] == ((LongFloatMap) other).get(jArr[i6]) ? z6 : z2)) {
                            return z2;
                        }
                    } else {
                        i = i3;
                        longFloatMap2 = longFloatMap3;
                        z2 = z7;
                    }
                    j >>= i;
                    i5++;
                    longFloatMap3 = longFloatMap2;
                    i3 = i;
                    z7 = z2;
                }
                longFloatMap = longFloatMap3;
                z = z7;
                if (i4 != i3) {
                    return z6;
                }
            } else {
                longFloatMap = longFloatMap3;
                z = z7;
            }
            if (i2 == length) {
                return z6;
            }
            i2++;
            z5 = z8;
            z3 = z6;
            longFloatMap3 = longFloatMap;
            z4 = z;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x008e, code lost:
    
        if (((((~r10) << 6) & r10) & (-9187201950435737472L)) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0091, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int findKeyIndex(long r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            int r2 = java.lang.Long.hashCode(r21)
            r3 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r3
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r1 = 0
            r1 = r2 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            r4 = 0
            int r4 = r2 >>> 7
            r4 = r4 & r3
            r5 = 0
        L1a:
            long[] r6 = r0.metadata
            r7 = 0
            int r8 = r4 >> 3
            r9 = r4 & 7
            int r9 = r9 << 3
            r10 = r6[r8]
            long r10 = r10 >>> r9
            int r12 = r8 + 1
            r12 = r6[r12]
            int r14 = 64 - r9
            long r12 = r12 << r14
            long r14 = (long) r9
            long r14 = -r14
            r16 = 63
            long r14 = r14 >> r16
            long r12 = r12 & r14
            long r10 = r10 | r12
            r6 = r10
            r8 = 0
            long r12 = (long) r1
            r14 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r12 = r12 * r14
            long r12 = r12 ^ r6
            long r14 = r12 - r14
            r16 = r1
            r9 = r2
            long r1 = ~r12
            long r14 = r14 & r1
            r1 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r1
        L4f:
            r6 = r14
            r8 = 0
            r12 = 0
            int r17 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r17 == 0) goto L5a
            r17 = 1
            goto L5c
        L5a:
            r17 = 0
        L5c:
            if (r17 == 0) goto L80
            r6 = r14
            r8 = 0
            r12 = r6
            r17 = 0
            int r18 = java.lang.Long.numberOfTrailingZeros(r12)
            int r18 = r18 >> 3
            int r18 = r4 + r18
            r18 = r18 & r3
            long[] r6 = r0.keys
            r7 = r6[r18]
            int r6 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r6 != 0) goto L77
            return r18
        L77:
            r6 = r14
            r8 = 0
            r12 = 1
            long r12 = r6 - r12
            long r6 = r6 & r12
            r14 = r6
            goto L4f
        L80:
            r6 = r10
            r8 = 0
            r17 = r1
            long r1 = ~r6
            r19 = 6
            long r1 = r1 << r19
            long r1 = r1 & r6
            long r1 = r1 & r17
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 == 0) goto L93
        L91:
            r1 = -1
            return r1
        L93:
            int r5 = r5 + 8
            int r1 = r4 + r5
            r4 = r1 & r3
            r2 = r9
            r1 = r16
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongFloatMap.findKeyIndex(long):int");
    }

    public final void forEach(Function2<? super Long, ? super Float, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        boolean z = false;
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr2[i2];
            boolean z2 = z;
            long[] jArr3 = jArr;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        int i6 = (i2 << 3) + i5;
                        i = i3;
                        block.invoke(Long.valueOf(jArr3[i6]), Float.valueOf(fArr[i6]));
                    } else {
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                }
                if (i4 != i3) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            }
            i2++;
            z = z2;
            jArr = jArr3;
        }
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        block.invoke(Integer.valueOf((i << 3) + i3));
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void forEachKey(Function1<? super Long, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.keys;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        i = i3;
                        block.invoke(Long.valueOf(jArr[(i2 << 3) + i5]));
                    } else {
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                }
                if (i4 != i3) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void forEachValue(Function1<? super Float, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        float[] fArr = this.values;
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
                        i = i3;
                        block.invoke(Float.valueOf(fArr[(i2 << 3) + i5]));
                    } else {
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                }
                if (i4 != i3) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final float get(long key) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("Cannot find value for key " + key);
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    public final float getOrDefault(long key, float defaultValue) {
        int findKeyIndex = findKeyIndex(key);
        return findKeyIndex >= 0 ? this.values[findKeyIndex] : defaultValue;
    }

    public final float getOrElse(long key, Function0<Float> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(key);
        return findKeyIndex < 0 ? defaultValue.invoke().floatValue() : this.values[findKeyIndex];
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int i = 0;
        LongFloatMap longFloatMap = this;
        long[] jArr = longFloatMap.keys;
        float[] fArr = longFloatMap.values;
        long[] jArr2 = longFloatMap.metadata;
        int length = jArr2.length - 2;
        int i2 = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr2[i2];
                int i3 = i;
                LongFloatMap longFloatMap2 = longFloatMap;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            i3 += Long.hashCode(jArr[i6]) ^ Float.hashCode(fArr[i6]);
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                    i = i3;
                } else {
                    i = i3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                longFloatMap = longFloatMap2;
            }
        }
        return i;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        StringBuilder sb;
        int i;
        CharSequence separator2 = separator;
        CharSequence truncated2 = truncated;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated2, "truncated");
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        sb2.append(prefix);
        int i2 = 0;
        LongFloatMap longFloatMap = this;
        boolean z2 = false;
        long[] jArr = longFloatMap.keys;
        float[] fArr = longFloatMap.values;
        long[] jArr2 = longFloatMap.metadata;
        int length = jArr2.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i3];
                boolean z3 = z;
                int i4 = i2;
                LongFloatMap longFloatMap2 = longFloatMap;
                boolean z4 = z2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    int i8 = i4;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i9 = (i3 << 3) + i7;
                            long j2 = jArr[i9];
                            i = i5;
                            float f = fArr[i9];
                            sb = sb2;
                            if (i8 == limit) {
                                sb2.append(truncated2);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb2.append(separator2);
                            }
                            sb2.append(j2);
                            sb2.append('=');
                            sb2.append(f);
                            i8++;
                        } else {
                            sb = sb2;
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        separator2 = separator;
                        truncated2 = truncated;
                        sb2 = sb;
                        i5 = i;
                    }
                    sb = sb2;
                    if (i6 != i5) {
                        break;
                    }
                    i2 = i8;
                } else {
                    sb = sb2;
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                separator2 = separator;
                truncated2 = truncated;
                longFloatMap = longFloatMap2;
                z2 = z4;
                z = z3;
                sb2 = sb;
            }
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
            return sb3;
        }
        sb = sb2;
        sb2.append(postfix);
        String sb32 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb32, "StringBuilder().apply(builderAction).toString()");
        return sb32;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function2<? super Long, ? super Float, ? extends CharSequence> transform) {
        int i;
        int i2;
        CharSequence separator2 = separator;
        CharSequence truncated2 = truncated;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated2, "truncated");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        sb.append(prefix);
        int i3 = 0;
        LongFloatMap longFloatMap = this;
        boolean z2 = false;
        long[] jArr = longFloatMap.keys;
        float[] fArr = longFloatMap.values;
        long[] jArr2 = longFloatMap.metadata;
        int length = jArr2.length - 2;
        int i4 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i4];
                boolean z3 = z;
                int i5 = i3;
                LongFloatMap longFloatMap2 = longFloatMap;
                boolean z4 = z2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i4 - length)) >>> 31);
                    int i8 = 0;
                    i = i5;
                    while (i8 < i7) {
                        if ((j & 255) < 128) {
                            int i9 = (i4 << 3) + i8;
                            long j2 = jArr[i9];
                            float f = fArr[i9];
                            i2 = i6;
                            if (i == limit) {
                                sb.append(truncated2);
                                break loop0;
                            }
                            if (i != 0) {
                                sb.append(separator2);
                            }
                            sb.append(transform.invoke(Long.valueOf(j2), Float.valueOf(f)));
                            i++;
                        } else {
                            i2 = i6;
                        }
                        j >>= i2;
                        i8++;
                        separator2 = separator;
                        truncated2 = truncated;
                        i6 = i2;
                    }
                    if (i7 != i6) {
                        break;
                    }
                } else {
                    i = i5;
                }
                if (i4 == length) {
                    break;
                }
                i4++;
                separator2 = separator;
                truncated2 = truncated;
                i3 = i;
                longFloatMap = longFloatMap2;
                z2 = z4;
                z = z3;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(postfix);
        String sb22 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, int i, Function2<? super Long, ? super Float, ? extends CharSequence> transform) {
        StringBuilder sb;
        String str;
        String str2;
        int i2;
        CharSequence separator = charSequence;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean z = false;
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        sb2.append(prefix);
        int i3 = 0;
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i4 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i4];
                boolean z3 = z;
                sb = sb2;
                boolean z4 = z2;
                int i5 = i3;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i4 - length)) >>> 31);
                    int i8 = 0;
                    i3 = i5;
                    while (i8 < i7) {
                        if ((j & 255) < 128) {
                            int i9 = (i4 << 3) + i8;
                            long j2 = jArr[i9];
                            float f = fArr[i9];
                            i2 = i6;
                            if (i3 == i) {
                                sb2.append((CharSequence) r5);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb2.append(separator);
                            }
                            str2 = r5;
                            sb2.append(transform.invoke(Long.valueOf(j2), Float.valueOf(f)));
                            i3++;
                        } else {
                            str2 = r5;
                            i2 = i6;
                        }
                        j >>= i2;
                        i8++;
                        separator = charSequence;
                        i6 = i2;
                        r5 = str2;
                    }
                    str = r5;
                    if (i7 != i6) {
                        break;
                    }
                } else {
                    str = r5;
                    i3 = i5;
                }
                if (i4 == length) {
                    break;
                }
                i4++;
                separator = charSequence;
                z2 = z4;
                z = z3;
                sb2 = sb;
                r5 = str;
            }
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
            return sb3;
        }
        sb = sb2;
        sb2.append(postfix);
        String sb32 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb32, "StringBuilder().apply(builderAction).toString()");
        return sb32;
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, Function2<? super Long, ? super Float, ? extends CharSequence> transform) {
        StringBuilder sb;
        int i;
        CharSequence separator = charSequence;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean z = false;
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        sb2.append(prefix);
        int i2 = 0;
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i3];
                boolean z3 = z;
                sb = sb2;
                boolean z4 = z2;
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    i2 = i4;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i3 << 3) + i7;
                            long j2 = jArr[i8];
                            float f = fArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            i = i5;
                            sb2.append(transform.invoke(Long.valueOf(j2), Float.valueOf(f)));
                            i2++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        separator = charSequence;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                separator = charSequence;
                z2 = z4;
                z = z3;
                sb2 = sb;
            }
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
            return sb3;
        }
        sb = sb2;
        sb2.append(postfix);
        String sb32 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb32, "StringBuilder().apply(builderAction).toString()");
        return sb32;
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, Function2<? super Long, ? super Float, ? extends CharSequence> transform) {
        StringBuilder sb;
        int i;
        CharSequence separator = charSequence;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean z = false;
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        sb2.append(prefix);
        int i2 = 0;
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i3];
                boolean z3 = z;
                sb = sb2;
                boolean z4 = z2;
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    i2 = i4;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i3 << 3) + i7;
                            long j2 = jArr[i8];
                            float f = fArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            i = i5;
                            sb2.append(transform.invoke(Long.valueOf(j2), Float.valueOf(f)));
                            i2++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        separator = charSequence;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                separator = charSequence;
                z2 = z4;
                z = z3;
                sb2 = sb;
            }
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
            return sb3;
        }
        sb = sb2;
        sb2.append((CharSequence) r4);
        String sb32 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb32, "StringBuilder().apply(builderAction).toString()");
        return sb32;
    }

    public final String joinToString(CharSequence charSequence, Function2<? super Long, ? super Float, ? extends CharSequence> transform) {
        StringBuilder sb;
        int i;
        CharSequence separator = charSequence;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean z = false;
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        sb2.append((CharSequence) "");
        int i2 = 0;
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i3];
                boolean z3 = z;
                sb = sb2;
                boolean z4 = z2;
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    i2 = i4;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i3 << 3) + i7;
                            long j2 = jArr[i8];
                            float f = fArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            i = i5;
                            sb2.append(transform.invoke(Long.valueOf(j2), Float.valueOf(f)));
                            i2++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        separator = charSequence;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                separator = charSequence;
                z2 = z4;
                z = z3;
                sb2 = sb;
            }
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
            return sb3;
        }
        sb = sb2;
        sb2.append((CharSequence) r3);
        String sb32 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb32, "StringBuilder().apply(builderAction).toString()");
        return sb32;
    }

    public final String joinToString(Function2<? super Long, ? super Float, ? extends CharSequence> transform) {
        StringBuilder sb;
        String str;
        String str2;
        int i;
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean z = false;
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        sb2.append((CharSequence) "");
        int i2 = 0;
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i3];
                boolean z3 = z;
                sb = sb2;
                boolean z4 = z2;
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    i2 = i4;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i3 << 3) + i7;
                            long j2 = jArr[i8];
                            float f = fArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append((CharSequence) r2);
                            }
                            i = i5;
                            str2 = r2;
                            sb2.append(transform.invoke(Long.valueOf(j2), Float.valueOf(f)));
                            i2++;
                        } else {
                            str2 = r2;
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                        r2 = str2;
                    }
                    str = r2;
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    str = r2;
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                z2 = z4;
                z = z3;
                sb2 = sb;
                r2 = str;
            }
        } else {
            sb = sb2;
        }
        sb2.append((CharSequence) r3);
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        boolean z;
        long[] jArr;
        int i;
        boolean z2;
        long[] jArr2;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder append = new StringBuilder().append('{');
        int i2 = 0;
        LongFloatMap longFloatMap = this;
        boolean z3 = false;
        long[] jArr3 = longFloatMap.keys;
        float[] fArr = longFloatMap.values;
        long[] jArr4 = longFloatMap.metadata;
        int length = jArr4.length - 2;
        int i3 = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr4[i3];
                int i4 = i2;
                LongFloatMap longFloatMap2 = longFloatMap;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((255 & j) < 128) {
                            int i8 = (i3 << 3) + i7;
                            i = i5;
                            z2 = z3;
                            long j2 = jArr3[i8];
                            jArr2 = jArr3;
                            float f = fArr[i8];
                            append.append(j2);
                            append.append("=");
                            append.append(f);
                            int i9 = i4 + 1;
                            if (i9 < this._size) {
                                i4 = i9;
                                append.append(',').append(' ');
                            } else {
                                i4 = i9;
                            }
                        } else {
                            i = i5;
                            z2 = z3;
                            jArr2 = jArr3;
                        }
                        j >>= i;
                        i7++;
                        z3 = z2;
                        i5 = i;
                        jArr3 = jArr2;
                    }
                    z = z3;
                    jArr = jArr3;
                    if (i6 != i5) {
                        break;
                    }
                    i2 = i4;
                } else {
                    z = z3;
                    jArr = jArr3;
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                longFloatMap = longFloatMap2;
                z3 = z;
                jArr3 = jArr;
            }
            String sb = append.append('}').toString();
            Intrinsics.checkNotNullExpressionValue(sb, "s.append('}').toString()");
            return sb;
        }
        String sb2 = append.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "s.append('}').toString()");
        return sb2;
    }
}
