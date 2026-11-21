package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObjectIntMap.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0006\u0010\u001c\u001a\u00020\u0019J&\u0010\u001c\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0015\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010'JD\u0010(\u001a\u00020)26\u0010*\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020)0\u001bH\u0086\bø\u0001\u0000J/\u0010-\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020)0.H\u0081\bø\u0001\u0000J/\u00100\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J/\u00101\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J\u0016\u00102\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010'J\u001b\u00103\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u0005¢\u0006\u0002\u00105J'\u00106\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u00002\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000507H\u0086\bø\u0001\u0000¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\u0005H\u0016J\u0006\u0010:\u001a\u00020\u0019J\u0006\u0010;\u001a\u00020\u0019J:\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020?H\u0007Jx\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020?28\b\u0004\u0010D\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020?0\u001bH\u0087\bø\u0001\u0000J\u0006\u0010E\u001a\u00020\u0019J\b\u0010F\u001a\u00020=H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000f\u0012\u0004\b\u000e\u0010\u0003R\u0018\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u0018\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u0082\u0001\u0001G\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006H"}, d2 = {"Landroidx/collection/ObjectIntMap;", "K", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "any", "contains", "key", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "(Ljava/lang/Object;)I", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "(Ljava/lang/Object;I)I", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)I", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_NONE_SCRIPT, "toString", "Landroidx/collection/MutableObjectIntMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ObjectIntMap<K> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public int[] values;

    private ObjectIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = IntSetKt.getEmptyIntArray();
    }

    public /* synthetic */ ObjectIntMap(DefaultConstructorMarker defaultConstructorMarker) {
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

    public static /* synthetic */ String joinToString$default(ObjectIntMap objectIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
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
        return objectIntMap.joinToString(charSequence, charSequence2, charSequence3, i, (i2 & 16) != 0 ? "..." : charSequence4);
    }

    public static /* synthetic */ String joinToString$default(ObjectIntMap objectIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 transform, int i2, Object obj) {
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
        ObjectIntMap objectIntMap2 = objectIntMap;
        boolean z2 = false;
        Object[] objArr = objectIntMap2.keys;
        int[] iArr = objectIntMap2.values;
        long[] jArr = objectIntMap2.metadata;
        int length = jArr.length - 2;
        int i6 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr[i6];
                boolean z3 = z;
                int i7 = i5;
                ObjectIntMap objectIntMap3 = objectIntMap2;
                boolean z4 = z2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    int i11 = i7;
                    while (i10 < i9) {
                        if ((j & 255) < 128) {
                            int i12 = (i6 << 3) + i10;
                            Object obj2 = objArr[i12];
                            int i13 = iArr[i12];
                            if (i11 == i4) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i11 != 0) {
                                sb.append(separator);
                            }
                            i3 = i8;
                            charSequence6 = separator;
                            sb.append((CharSequence) transform.invoke(obj2, Integer.valueOf(i13)));
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
                objectIntMap2 = objectIntMap3;
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

    public final boolean all(Function2<? super K, ? super Integer, Boolean> predicate) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z3 = false;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 > length) {
            return true;
        }
        while (true) {
            long j = jArr[i2];
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
                        if (!predicate.invoke(objArr[i6], Integer.valueOf(iArr[i6])).booleanValue()) {
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

    public final boolean any(Function2<? super K, ? super Integer, Boolean> predicate) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z3 = false;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 > length) {
            return false;
        }
        while (true) {
            long j = jArr[i2];
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
                        if (predicate.invoke(objArr[i6], Integer.valueOf(iArr[i6])).booleanValue()) {
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

    public final boolean contains(K key) {
        return findKeyIndex(key) >= 0;
    }

    public final boolean containsKey(K key) {
        return findKeyIndex(key) >= 0;
    }

    public final boolean containsValue(int value) {
        boolean z;
        int i;
        int[] iArr = this.values;
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
                        if (value == iArr[(i2 << 3) + i5]) {
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

    public final int count(Function2<? super K, ? super Integer, Boolean> predicate) {
        ObjectIntMap<K> objectIntMap;
        int i;
        ObjectIntMap<K> objectIntMap2;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z = false;
        int i2 = 0;
        ObjectIntMap<K> objectIntMap3 = this;
        Object[] objArr = objectIntMap3.keys;
        int[] iArr = objectIntMap3.values;
        long[] jArr = objectIntMap3.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr[i3];
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
                            objectIntMap2 = objectIntMap3;
                            if (predicate.invoke(objArr[i8], Integer.valueOf(iArr[i8])).booleanValue()) {
                                i4++;
                            }
                        } else {
                            i = i5;
                            objectIntMap2 = objectIntMap3;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                        objectIntMap3 = objectIntMap2;
                    }
                    objectIntMap = objectIntMap3;
                    if (i6 != i5) {
                        return i4;
                    }
                    i2 = i4;
                } else {
                    objectIntMap = objectIntMap3;
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                z = z2;
                objectIntMap3 = objectIntMap;
            }
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object other) {
        int i;
        int i2;
        boolean z = true;
        if (other == this) {
            return true;
        }
        boolean z2 = false;
        if (!(other instanceof ObjectIntMap) || ((ObjectIntMap) other).get_size() != get_size()) {
            return false;
        }
        ObjectIntMap objectIntMap = (ObjectIntMap) other;
        ObjectIntMap<K> objectIntMap2 = this;
        Object[] objArr = objectIntMap2.keys;
        int[] iArr = objectIntMap2.values;
        long[] jArr = objectIntMap2.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (0 > length) {
            return true;
        }
        while (true) {
            long j = jArr[i3];
            boolean z3 = z;
            boolean z4 = z2;
            ObjectIntMap<K> objectIntMap3 = objectIntMap2;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j & 255) < 128 ? z3 : z4) {
                        int i7 = (i3 << 3) + i6;
                        i = i4;
                        i2 = i6;
                        if (iArr[i7] != objectIntMap.get(objArr[i7])) {
                            return z4;
                        }
                    } else {
                        i = i4;
                        i2 = i6;
                    }
                    j >>= i;
                    i6 = i2 + 1;
                    i4 = i;
                }
                if (i5 != i4) {
                    return z3;
                }
            }
            if (i3 == length) {
                return z3;
            }
            i3++;
            z2 = z4;
            objectIntMap2 = objectIntMap3;
            z = z3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0096, code lost:
    
        if (((((~r12) << 6) & r12) & (-9187201950435737472L)) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int findKeyIndex(K r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = 0
            if (r1 == 0) goto Lc
            int r4 = r1.hashCode()
            goto Ld
        Lc:
            r4 = 0
        Ld:
            r5 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r4 = r4 * r5
            int r5 = r4 << 16
            r4 = r4 ^ r5
            r2 = 0
            r2 = r4 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            r6 = 0
            int r6 = r4 >>> 7
            r6 = r6 & r5
            r7 = 0
        L20:
            long[] r8 = r0.metadata
            r9 = 0
            int r10 = r6 >> 3
            r11 = r6 & 7
            int r11 = r11 << 3
            r12 = r8[r10]
            long r12 = r12 >>> r11
            int r14 = r10 + 1
            r14 = r8[r14]
            int r16 = 64 - r11
            long r14 = r14 << r16
            r17 = r4
            long r3 = (long) r11
            long r3 = -r3
            r18 = 63
            long r3 = r3 >> r18
            long r14 = r14 & r3
            long r12 = r12 | r14
            r3 = r12
            r8 = 0
            long r9 = (long) r2
            r14 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r14
            long r9 = r9 ^ r3
            long r14 = r9 - r14
            r11 = r2
            r18 = r3
            long r2 = ~r9
            long r14 = r14 & r2
            r2 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r2
        L58:
            r8 = r14
            r4 = 0
            r18 = 0
            int r10 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r10 == 0) goto L62
            r10 = 1
            goto L63
        L62:
            r10 = 0
        L63:
            if (r10 == 0) goto L8a
            r8 = r14
            r4 = 0
            r18 = r8
            r10 = 0
            int r20 = java.lang.Long.numberOfTrailingZeros(r18)
            int r20 = r20 >> 3
            int r20 = r6 + r20
            r20 = r20 & r5
            java.lang.Object[] r4 = r0.keys
            r4 = r4[r20]
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r4 == 0) goto L80
            return r20
        L80:
            r8 = r14
            r4 = 0
            r18 = 1
            long r18 = r8 - r18
            long r8 = r8 & r18
            r14 = r8
            goto L58
        L8a:
            r8 = r12
            r4 = 0
            r20 = r2
            long r2 = ~r8
            r10 = 6
            long r2 = r2 << r10
            long r2 = r2 & r8
            long r2 = r2 & r20
            int r2 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r2 == 0) goto L9b
        L99:
            r2 = -1
            return r2
        L9b:
            int r7 = r7 + 8
            int r2 = r6 + r7
            r6 = r2 & r5
            r2 = r11
            r4 = r17
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectIntMap.findKeyIndex(java.lang.Object):int");
    }

    public final void forEach(Function2<? super K, ? super Integer, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        boolean z = false;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 > length) {
            return;
        }
        while (true) {
            long j = jArr[i2];
            boolean z2 = z;
            Object[] objArr2 = objArr;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        int i6 = (i2 << 3) + i5;
                        i = i3;
                        block.invoke(objArr2[i6], Integer.valueOf(iArr[i6]));
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
            objArr = objArr2;
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

    public final void forEachKey(Function1<? super K, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.keys;
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

    public final void forEachValue(Function1<? super Integer, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        int[] iArr = this.values;
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
                        block.invoke(Integer.valueOf(iArr[(i2 << 3) + i5]));
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

    public final int get(K key) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("There is no key " + key + " in the map");
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    public final int getOrDefault(K key, int defaultValue) {
        int findKeyIndex = findKeyIndex(key);
        return findKeyIndex >= 0 ? this.values[findKeyIndex] : defaultValue;
    }

    public final int getOrElse(K key, Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(key);
        return findKeyIndex >= 0 ? this.values[findKeyIndex] : defaultValue.invoke().intValue();
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int i = 0;
        ObjectIntMap<K> objectIntMap = this;
        Object[] objArr = objectIntMap.keys;
        int[] iArr = objectIntMap.values;
        long[] jArr = objectIntMap.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr[i2];
                int i3 = i;
                ObjectIntMap<K> objectIntMap2 = objectIntMap;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            Object obj = objArr[i6];
                            i3 += (obj != null ? obj.hashCode() : 0) ^ Integer.hashCode(iArr[i6]);
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
                objectIntMap = objectIntMap2;
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
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        sb2.append(prefix);
        int i2 = 0;
        ObjectIntMap<K> objectIntMap = this;
        boolean z2 = false;
        Object[] objArr = objectIntMap.keys;
        int[] iArr = objectIntMap.values;
        long[] jArr = objectIntMap.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr[i3];
                boolean z3 = z;
                int i4 = i2;
                ObjectIntMap<K> objectIntMap2 = objectIntMap;
                boolean z4 = z2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    int i8 = i4;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i9 = (i3 << 3) + i7;
                            Object obj = objArr[i9];
                            i = i5;
                            int i10 = iArr[i9];
                            sb = sb2;
                            if (i8 == limit) {
                                sb2.append(truncated);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb2.append(separator2);
                            }
                            sb2.append(obj);
                            sb2.append('=');
                            sb2.append(i10);
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
                objectIntMap = objectIntMap2;
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

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
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
        ObjectIntMap<K> objectIntMap = this;
        boolean z2 = false;
        Object[] objArr = objectIntMap.keys;
        int[] iArr = objectIntMap.values;
        long[] jArr = objectIntMap.metadata;
        int length = jArr.length - 2;
        int i4 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr[i4];
                boolean z3 = z;
                int i5 = i3;
                ObjectIntMap<K> objectIntMap2 = objectIntMap;
                boolean z4 = z2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i4 - length)) >>> 31);
                    int i8 = 0;
                    i = i5;
                    while (i8 < i7) {
                        if ((j & 255) < 128) {
                            int i9 = (i4 << 3) + i8;
                            Object obj = objArr[i9];
                            int i10 = iArr[i9];
                            i2 = i6;
                            if (i == limit) {
                                sb.append(truncated2);
                                break loop0;
                            }
                            if (i != 0) {
                                sb.append(separator2);
                            }
                            sb.append(transform.invoke(obj, Integer.valueOf(i10)));
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
                objectIntMap = objectIntMap2;
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

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, int i, Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
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
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i5 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr[i5];
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
                            i2 = i7;
                            Object obj = objArr[i10];
                            int i11 = iArr[i10];
                            i3 = i9;
                            if (i4 == i) {
                                sb2.append((CharSequence) r5);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb2.append(separator);
                            }
                            sb2.append(transform.invoke(obj, Integer.valueOf(i11)));
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

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
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
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr[i3];
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
                            i = i5;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            sb2.append(transform.invoke(obj, Integer.valueOf(i9)));
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

    public final String joinToString(CharSequence charSequence, CharSequence prefix, Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
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
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr[i3];
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
                            i = i5;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            sb2.append(transform.invoke(obj, Integer.valueOf(i9)));
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

    public final String joinToString(CharSequence charSequence, Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
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
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr[i3];
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
                            i = i5;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append(separator);
                            }
                            sb2.append(transform.invoke(obj, Integer.valueOf(i9)));
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

    public final String joinToString(Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
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
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (0 <= length) {
            loop0: while (true) {
                long j = jArr[i3];
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
                            i = i5;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            if (i2 == -1) {
                                sb2.append((CharSequence) r6);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb2.append((CharSequence) r2);
                            }
                            str2 = r2;
                            sb2.append(transform.invoke(obj, Integer.valueOf(i9)));
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
        int i;
        boolean z2;
        ObjectIntMap<K> objectIntMap = this;
        if (objectIntMap.isEmpty()) {
            return "{}";
        }
        StringBuilder append = new StringBuilder().append('{');
        int i2 = 0;
        ObjectIntMap<K> objectIntMap2 = this;
        boolean z3 = false;
        Object[] objArr = objectIntMap2.keys;
        int[] iArr = objectIntMap2.values;
        long[] jArr = objectIntMap2.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (0 <= length) {
            while (true) {
                long j = jArr[i3];
                int i4 = i2;
                ObjectIntMap<K> objectIntMap3 = objectIntMap2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((255 & j) < 128) {
                            int i8 = (i3 << 3) + i7;
                            i = i5;
                            Object obj = objArr[i8];
                            z2 = z3;
                            int i9 = iArr[i8];
                            if (obj == objectIntMap) {
                                obj = "(this)";
                            }
                            append.append(obj);
                            append.append("=");
                            append.append(i9);
                            int i10 = i4 + 1;
                            if (i10 < objectIntMap._size) {
                                append.append(',').append(' ');
                            }
                            i4 = i10;
                        } else {
                            i = i5;
                            z2 = z3;
                        }
                        j >>= i;
                        i7++;
                        objectIntMap = this;
                        i5 = i;
                        z3 = z2;
                    }
                    z = z3;
                    if (i6 != i5) {
                        break;
                    }
                    i2 = i4;
                } else {
                    z = z3;
                    i2 = i4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                objectIntMap = this;
                objectIntMap2 = objectIntMap3;
                z3 = z;
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
