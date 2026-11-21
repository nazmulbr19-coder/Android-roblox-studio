package androidx.graphics.shapes;

import androidx.collection.FloatList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: FloatMapping.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0000¨\u0006\u000e"}, d2 = {"linearMap", "", "xValues", "Landroidx/collection/FloatList;", "yValues", "x", "progressInRange", "", "progress", "progressFrom", "progressTo", "validateProgress", "", "p", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatMappingKt {
    public static final float linearMap(FloatList xValues, FloatList yValues, float f) {
        Intrinsics.checkNotNullParameter(xValues, "xValues");
        Intrinsics.checkNotNullParameter(yValues, "yValues");
        if (!(0.0f <= f && f <= 1.0f)) {
            throw new IllegalArgumentException(("Invalid progress: " + f).toString());
        }
        Iterator<Integer> it = RangesKt.until(0, xValues._size).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (progressInRange(f, xValues.get(nextInt), xValues.get((nextInt + 1) % xValues.getSize()))) {
                int size = (nextInt + 1) % xValues.getSize();
                float positiveModulo = Utils.positiveModulo(xValues.get(size) - xValues.get(nextInt), 1.0f);
                return Utils.positiveModulo(yValues.get(nextInt) + (Utils.positiveModulo(yValues.get(size) - yValues.get(nextInt), 1.0f) * (positiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f - xValues.get(nextInt), 1.0f) / positiveModulo)), 1.0f);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final boolean progressInRange(float f, float f2, float f3) {
        return f3 >= f2 ? f2 <= f && f <= f3 : f >= f2 || f <= f3;
    }

    public static final void validateProgress(FloatList p) {
        int i;
        Intrinsics.checkNotNullParameter(p, "p");
        Boolean bool = true;
        float[] fArr = p.content;
        int i2 = 0;
        int i3 = p._size;
        while (true) {
            boolean z = false;
            if (i2 >= i3) {
                break;
            }
            float f = fArr[i2];
            if (bool.booleanValue()) {
                if (0.0f <= f && f <= 1.0f) {
                    z = true;
                }
            }
            bool = Boolean.valueOf(z);
            i2++;
        }
        if (!bool.booleanValue()) {
            throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
        }
        Iterable until = RangesKt.until(1, p.getSize());
        if ((until instanceof Collection) && ((Collection) until).isEmpty()) {
            i = 0;
        } else {
            i = 0;
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                if ((p.get(nextInt) < p.get(nextInt + (-1))) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (!(i <= 1)) {
            throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
        }
    }
}
