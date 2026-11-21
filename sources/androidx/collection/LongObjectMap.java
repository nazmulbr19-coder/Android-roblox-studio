package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LongObjectMap.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bø\u0001\u0000J\u0006\u0010\u001c\u001a\u00020\u0018J&\u0010\u001c\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bø\u0001\u0000J\u0011\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001bH\u0086\u0002J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001bJ\u0013\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00052\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001bH\u0080\b¢\u0006\u0002\b'JD\u0010(\u001a\u00020)26\u0010*\u001a2\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020)0\u001aH\u0086\bø\u0001\u0000J/\u0010-\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020)0.H\u0081\bø\u0001\u0000J/\u00100\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J/\u00101\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J\u0018\u00102\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\u001bH\u0086\u0002¢\u0006\u0002\u00103J\u001b\u00104\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u00105\u001a\u00028\u0000¢\u0006\u0002\u00106J'\u00107\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001b2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000008H\u0086\bø\u0001\u0000¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u0005H\u0016J\u0006\u0010;\u001a\u00020\u0018J\u0006\u0010<\u001a\u00020\u0018J:\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020@2\b\b\u0002\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020@H\u0007Jx\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020@2\b\b\u0002\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020@28\b\u0004\u0010E\u001a2\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020@0\u001aH\u0087\bø\u0001\u0000J\u0006\u0010F\u001a\u00020\u0018J\b\u0010G\u001a\u00020>H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u0018\u0010\u000f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003R\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000bR\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u0016\u0012\u0004\b\u0015\u0010\u0003\u0082\u0001\u0001H\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"Landroidx/collection/LongObjectMap;", "V", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "all", "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "containsKey", "containsValue", "value", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findKeyIndex", "findKeyIndex$collection", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(J)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_NONE_SCRIPT, "toString", "Landroidx/collection/MutableLongObjectMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LongObjectMap<V> {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public Object[] values;

    private LongObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public /* synthetic */ LongObjectMap(DefaultConstructorMarker defaultConstructorMarker) {
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

    public static /* synthetic */ String joinToString$default(LongObjectMap longObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
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
        return longObjectMap.joinToString(charSequence, charSequence2, charSequence3, i, (i2 & 16) != 0 ? "..." : charSequence4);
    }

    public static /* synthetic */ String joinToString$default(LongObjectMap longObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 transform, int i2, Object obj) {
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
        LongObjectMap longObjectMap2 = longObjectMap;
        boolean z2 = false;
        long[] jArr = longObjectMap2.keys;
        Object[] objArr = longObjectMap2.values;
        long[] jArr2 = longObjectMap2.metadata;
        int length = jArr2.length - 2;
        int i6 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i6];
                boolean z3 = z;
                int i7 = i5;
                LongObjectMap longObjectMap3 = longObjectMap2;
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
                            i3 = i8;
                            Object obj2 = objArr[i12];
                            if (i11 == i4) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i11 != 0) {
                                sb.append(separator);
                            }
                            charSequence6 = separator;
                            sb.append((CharSequence) transform.invoke(Long.valueOf(j2), obj2));
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
                longObjectMap2 = longObjectMap3;
                z2 = z4;
                z = z3;
                separator = charSequence5;
            }
            sb.append(postfix);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(postfix);
        String sb22 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public final boolean all(Function2<? super Long, ? super V, Boolean> predicate) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z3 = false;
        long[] jArr = this.keys;
        Object[] objArr = this.values;
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
                        if (!predicate.invoke(Long.valueOf(jArr[i6]), objArr[i6]).booleanValue()) {
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

    public final boolean any(Function2<? super Long, ? super V, Boolean> predicate) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z3 = false;
        long[] jArr = this.keys;
        Object[] objArr = this.values;
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
                        if (predicate.invoke(Long.valueOf(jArr[i6]), objArr[i6]).booleanValue()) {
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0096, code lost:
    
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
    
        r21 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean contains(long r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = 0
            r2 = 0
            int r3 = java.lang.Long.hashCode(r24)
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r2 = 0
            r2 = r3 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            r5 = 0
            int r5 = r3 >>> 7
            r5 = r5 & r4
            r6 = 0
        L1b:
            long[] r7 = r0.metadata
            r8 = 0
            int r9 = r5 >> 3
            r10 = r5 & 7
            int r10 = r10 << 3
            r11 = r7[r9]
            long r11 = r11 >>> r10
            int r13 = r9 + 1
            r13 = r7[r13]
            int r15 = 64 - r10
            long r13 = r13 << r15
            r15 = r3
            r16 = r4
            long r3 = (long) r10
            long r3 = -r3
            r17 = 63
            long r3 = r3 >> r17
            long r13 = r13 & r3
            long r11 = r11 | r13
            r3 = r11
            r7 = 0
            long r8 = (long) r2
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r13
            long r8 = r8 ^ r3
            long r13 = r8 - r13
            r10 = r1
            r17 = r2
            long r1 = ~r8
            long r13 = r13 & r1
            r1 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r1
        L53:
            r3 = r13
            r7 = 0
            r8 = 0
            int r18 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            r19 = 0
            r20 = 1
            if (r18 == 0) goto L62
            r3 = r20
            goto L64
        L62:
            r3 = r19
        L64:
            if (r3 == 0) goto L88
            r3 = r13
            r7 = 0
            r8 = r3
            r18 = 0
            int r21 = java.lang.Long.numberOfTrailingZeros(r8)
            int r21 = r21 >> 3
            int r21 = r5 + r21
            r21 = r21 & r16
            long[] r3 = r0.keys
            r7 = r3[r21]
            int r3 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r3 != 0) goto L7f
            goto L9b
        L7f:
            r3 = r13
            r7 = 0
            r8 = 1
            long r8 = r3 - r8
            long r3 = r3 & r8
            r13 = r3
            goto L53
        L88:
            r3 = r11
            r7 = 0
            r21 = r1
            long r1 = ~r3
            r18 = 6
            long r1 = r1 << r18
            long r1 = r1 & r3
            long r1 = r1 & r21
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 == 0) goto La0
        L99:
            r21 = -1
        L9b:
            if (r21 < 0) goto L9f
            r19 = r20
        L9f:
            return r19
        La0:
            int r6 = r6 + 8
            int r1 = r5 + r6
            r5 = r1 & r16
            r1 = r10
            r3 = r15
            r4 = r16
            r2 = r17
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.contains(long):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0096, code lost:
    
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
    
        r21 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsKey(long r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = 0
            r2 = 0
            int r3 = java.lang.Long.hashCode(r24)
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r2 = 0
            r2 = r3 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            r5 = 0
            int r5 = r3 >>> 7
            r5 = r5 & r4
            r6 = 0
        L1b:
            long[] r7 = r0.metadata
            r8 = 0
            int r9 = r5 >> 3
            r10 = r5 & 7
            int r10 = r10 << 3
            r11 = r7[r9]
            long r11 = r11 >>> r10
            int r13 = r9 + 1
            r13 = r7[r13]
            int r15 = 64 - r10
            long r13 = r13 << r15
            r15 = r3
            r16 = r4
            long r3 = (long) r10
            long r3 = -r3
            r17 = 63
            long r3 = r3 >> r17
            long r13 = r13 & r3
            long r11 = r11 | r13
            r3 = r11
            r7 = 0
            long r8 = (long) r2
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r13
            long r8 = r8 ^ r3
            long r13 = r8 - r13
            r10 = r1
            r17 = r2
            long r1 = ~r8
            long r13 = r13 & r1
            r1 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r1
        L53:
            r3 = r13
            r7 = 0
            r8 = 0
            int r18 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            r19 = 0
            r20 = 1
            if (r18 == 0) goto L62
            r3 = r20
            goto L64
        L62:
            r3 = r19
        L64:
            if (r3 == 0) goto L88
            r3 = r13
            r7 = 0
            r8 = r3
            r18 = 0
            int r21 = java.lang.Long.numberOfTrailingZeros(r8)
            int r21 = r21 >> 3
            int r21 = r5 + r21
            r21 = r21 & r16
            long[] r3 = r0.keys
            r7 = r3[r21]
            int r3 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r3 != 0) goto L7f
            goto L9b
        L7f:
            r3 = r13
            r7 = 0
            r8 = 1
            long r8 = r3 - r8
            long r3 = r3 & r8
            r13 = r3
            goto L53
        L88:
            r3 = r11
            r7 = 0
            r21 = r1
            long r1 = ~r3
            r18 = 6
            long r1 = r1 << r18
            long r1 = r1 & r3
            long r1 = r1 & r21
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 == 0) goto La0
        L99:
            r21 = -1
        L9b:
            if (r21 < 0) goto L9f
            r19 = r20
        L9f:
            return r19
        La0:
            int r6 = r6 + 8
            int r1 = r5 + r6
            r5 = r1 & r16
            r1 = r10
            r3 = r15
            r4 = r16
            r2 = r17
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.containsKey(long):boolean");
    }

    public final boolean containsValue(V value) {
        boolean z;
        int i;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 > length) {
            return false;
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
                        if (Intrinsics.areEqual(value, objArr[(i2 << 3) + i5])) {
                            return true;
                        }
                    } else {
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                }
                z = false;
                if (i4 != i3) {
                    return false;
                }
            } else {
                z = false;
            }
            if (i2 == length) {
                return z;
            }
            i2++;
        }
    }

    public final int count() {
        return get_size();
    }

    public final int count(Function2<? super Long, ? super V, Boolean> predicate) {
        LongObjectMap<V> longObjectMap;
        int i;
        LongObjectMap<V> longObjectMap2;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z = false;
        int i2 = 0;
        LongObjectMap<V> longObjectMap3 = this;
        long[] jArr = longObjectMap3.keys;
        Object[] objArr = longObjectMap3.values;
        long[] jArr2 = longObjectMap3.metadata;
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
                            longObjectMap2 = longObjectMap3;
                            if (predicate.invoke(Long.valueOf(jArr[i8]), objArr[i8]).booleanValue()) {
                                i4++;
                            }
                        } else {
                            i = i5;
                            longObjectMap2 = longObjectMap3;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                        longObjectMap3 = longObjectMap2;
                    }
                    longObjectMap = longObjectMap3;
                    if (i6 != i5) {
                        return i4;
                    }
                    i2 = i4;
                } else {
                    longObjectMap = longObjectMap3;
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                z = z2;
                longObjectMap3 = longObjectMap;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
    
        return r22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0092, code lost:
    
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0095, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int findKeyIndex$collection(long r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 0
            r2 = 0
            int r3 = java.lang.Long.hashCode(r22)
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r2 = 0
            r2 = r3 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            r5 = 0
            int r5 = r3 >>> 7
            r5 = r5 & r4
            r6 = 0
        L1b:
            long[] r7 = r0.metadata
            r8 = 0
            int r9 = r5 >> 3
            r10 = r5 & 7
            int r10 = r10 << 3
            r11 = r7[r9]
            long r11 = r11 >>> r10
            int r13 = r9 + 1
            r13 = r7[r13]
            int r15 = 64 - r10
            long r13 = r13 << r15
            r15 = r3
            r16 = r4
            long r3 = (long) r10
            long r3 = -r3
            r17 = 63
            long r3 = r3 >> r17
            long r13 = r13 & r3
            long r11 = r11 | r13
            r3 = r11
            r7 = 0
            long r8 = (long) r2
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r13
            long r8 = r8 ^ r3
            long r13 = r8 - r13
            r10 = r1
            r17 = r2
            long r1 = ~r8
            long r13 = r13 & r1
            r1 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r1
        L53:
            r3 = r13
            r7 = 0
            r8 = 0
            int r18 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r18 == 0) goto L5e
            r18 = 1
            goto L60
        L5e:
            r18 = 0
        L60:
            if (r18 == 0) goto L84
            r3 = r13
            r7 = 0
            r8 = r3
            r18 = 0
            int r19 = java.lang.Long.numberOfTrailingZeros(r8)
            int r19 = r19 >> 3
            int r19 = r5 + r19
            r19 = r19 & r16
            long[] r3 = r0.keys
            r7 = r3[r19]
            int r3 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r3 != 0) goto L7b
            return r19
        L7b:
            r3 = r13
            r7 = 0
            r8 = 1
            long r8 = r3 - r8
            long r3 = r3 & r8
            r13 = r3
            goto L53
        L84:
            r3 = r11
            r7 = 0
            r18 = r1
            long r1 = ~r3
            r20 = 6
            long r1 = r1 << r20
            long r1 = r1 & r3
            long r1 = r1 & r18
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 == 0) goto L97
        L95:
            r1 = -1
            return r1
        L97:
            int r6 = r6 + 8
            int r1 = r5 + r6
            r5 = r1 & r16
            r1 = r10
            r3 = r15
            r4 = r16
            r2 = r17
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.findKeyIndex$collection(long):int");
    }

    public final void forEach(Function2<? super Long, ? super V, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        boolean z = false;
        long[] jArr = this.keys;
        Object[] objArr = this.values;
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
                        block.invoke(Long.valueOf(jArr3[i6]), objArr[i6]);
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

    public final void forEachValue(Function1<? super V, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.values;
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
                        block.invoke(objArr[(i2 << 3) + i5]);
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
    
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0095, code lost:
    
        r19 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get(long r22) {
        /*
            Method dump skipped, instructions count: 182
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.get(long):java.lang.Object");
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
    
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0095, code lost:
    
        r19 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V getOrDefault(long r22, V r24) {
        /*
            Method dump skipped, instructions count: 181
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.getOrDefault(long, java.lang.Object):java.lang.Object");
    }

    public final V getOrElse(long key, Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = get(key);
        return v == null ? defaultValue.invoke() : v;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int i = 0;
        LongObjectMap<V> longObjectMap = this;
        long[] jArr = longObjectMap.keys;
        Object[] objArr = longObjectMap.values;
        long[] jArr2 = longObjectMap.metadata;
        int length = jArr2.length - 2;
        int i2 = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr2[i2];
                int i3 = i;
                LongObjectMap<V> longObjectMap2 = longObjectMap;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            long j2 = jArr[i6];
                            Object obj = objArr[i6];
                            i3 += Long.hashCode(j2) ^ (obj != null ? obj.hashCode() : 0);
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
                longObjectMap = longObjectMap2;
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
        LongObjectMap<V> longObjectMap = this;
        boolean z2 = false;
        long[] jArr = longObjectMap.keys;
        Object[] objArr = longObjectMap.values;
        long[] jArr2 = longObjectMap.metadata;
        int length = jArr2.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i3];
                boolean z3 = z;
                int i4 = i2;
                LongObjectMap<V> longObjectMap2 = longObjectMap;
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
                            Object obj = objArr[i9];
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
                            sb2.append(obj);
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
                longObjectMap = longObjectMap2;
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

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function2<? super Long, ? super V, ? extends CharSequence> transform) {
        StringBuilder sb;
        int i;
        CharSequence separator2 = separator;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        sb2.append(prefix);
        int i2 = 0;
        LongObjectMap<V> longObjectMap = this;
        boolean z2 = false;
        long[] jArr = longObjectMap.keys;
        Object[] objArr = longObjectMap.values;
        long[] jArr2 = longObjectMap.metadata;
        int length = jArr2.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i3];
                boolean z3 = z;
                int i4 = i2;
                LongObjectMap<V> longObjectMap2 = longObjectMap;
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
                            Object obj = objArr[i9];
                            sb = sb2;
                            if (i8 == limit) {
                                sb2.append(truncated);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb2.append(separator2);
                            }
                            sb2.append(transform.invoke(Long.valueOf(j2), obj));
                            i8++;
                        } else {
                            sb = sb2;
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        separator2 = separator;
                        i5 = i;
                        sb2 = sb;
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
                longObjectMap = longObjectMap2;
                z2 = z4;
                z = z3;
                sb2 = sb;
            }
        } else {
            sb = sb2;
        }
        sb2.append(postfix);
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, int i, Function2<? super Long, ? super V, ? extends CharSequence> transform) {
        StringBuilder sb;
        int i2;
        int i3;
        CharSequence separator = charSequence;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean z = false;
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        sb2.append(prefix);
        int i4 = 0;
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i5 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr2[i5];
                boolean z3 = z;
                sb = sb2;
                boolean z4 = z2;
                int i6 = i4;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8;
                    int i8 = 8 - ((~(i5 - length)) >>> 31);
                    int i9 = 0;
                    i4 = i6;
                    while (i9 < i8) {
                        if ((j & 255) < 128) {
                            int i10 = (i5 << 3) + i9;
                            long j2 = jArr[i10];
                            i2 = i7;
                            Object obj = objArr[i10];
                            i3 = i9;
                            if (i4 == i) {
                                sb2.append((CharSequence) r5);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb2.append(separator);
                            }
                            sb2.append(transform.invoke(Long.valueOf(j2), obj));
                            i4++;
                        } else {
                            i2 = i7;
                            i3 = i9;
                        }
                        j >>= i2;
                        i9 = i3 + 1;
                        i7 = i2;
                        separator = charSequence;
                    }
                    if (i8 != i7) {
                        break;
                    }
                } else {
                    i4 = i6;
                }
                if (i5 == length) {
                    break;
                }
                i5++;
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

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, Function2<? super Long, ? super V, ? extends CharSequence> transform) {
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
        Object[] objArr = this.values;
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
                            i = i5;
                            Object obj = objArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            sb2.append(transform.invoke(Long.valueOf(j2), obj));
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

    public final String joinToString(CharSequence charSequence, CharSequence prefix, Function2<? super Long, ? super V, ? extends CharSequence> transform) {
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
        Object[] objArr = this.values;
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
                            i = i5;
                            Object obj = objArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            sb2.append(transform.invoke(Long.valueOf(j2), obj));
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

    public final String joinToString(CharSequence charSequence, Function2<? super Long, ? super V, ? extends CharSequence> transform) {
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
        Object[] objArr = this.values;
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
                            i = i5;
                            Object obj = objArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            sb2.append(transform.invoke(Long.valueOf(j2), obj));
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

    public final String joinToString(Function2<? super Long, ? super V, ? extends CharSequence> transform) {
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
        Object[] objArr = this.values;
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
                            i = i5;
                            Object obj = objArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append((CharSequence) r2);
                            }
                            str2 = r2;
                            sb2.append(transform.invoke(Long.valueOf(j2), obj));
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

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        boolean z;
        long[] jArr;
        int i;
        boolean z2;
        long[] jArr2;
        LongObjectMap<V> longObjectMap = this;
        if (longObjectMap.isEmpty()) {
            return "{}";
        }
        StringBuilder append = new StringBuilder().append('{');
        int i2 = 0;
        LongObjectMap<V> longObjectMap2 = this;
        boolean z3 = false;
        long[] jArr3 = longObjectMap2.keys;
        Object[] objArr = longObjectMap2.values;
        long[] jArr4 = longObjectMap2.metadata;
        int length = jArr4.length - 2;
        int i3 = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr4[i3];
                int i4 = i2;
                LongObjectMap<V> longObjectMap3 = longObjectMap2;
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
                            Object obj = objArr[i8];
                            append.append(j2);
                            append.append("=");
                            append.append(obj == longObjectMap ? "(this)" : obj);
                            int i9 = i4 + 1;
                            if (i9 < longObjectMap._size) {
                                append.append(',').append(' ');
                            }
                            i4 = i9;
                        } else {
                            i = i5;
                            z2 = z3;
                            jArr2 = jArr3;
                        }
                        j >>= i;
                        i7++;
                        longObjectMap = this;
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
                longObjectMap = this;
                longObjectMap2 = longObjectMap3;
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
