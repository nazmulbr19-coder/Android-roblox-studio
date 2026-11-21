package androidx.core.util;

import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    /* loaded from: classes.dex */
    private static class Api34Impl {
        private Api34Impl() {
        }

        public static float deriveDimension(int i, float f, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i, f, displayMetrics);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i, float f, DisplayMetrics displayMetrics) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i, f, displayMetrics);
        }
        switch (i) {
            case 0:
                return f;
            case 1:
                if (displayMetrics.density == 0.0f) {
                    return 0.0f;
                }
                return f / displayMetrics.density;
            case 2:
                if (displayMetrics.scaledDensity == 0.0f) {
                    return 0.0f;
                }
                return f / displayMetrics.scaledDensity;
            case 3:
                if (displayMetrics.xdpi == 0.0f) {
                    return 0.0f;
                }
                return (f / displayMetrics.xdpi) / INCHES_PER_PT;
            case 4:
                if (displayMetrics.xdpi == 0.0f) {
                    return 0.0f;
                }
                return f / displayMetrics.xdpi;
            case 5:
                if (displayMetrics.xdpi == 0.0f) {
                    return 0.0f;
                }
                return (f / displayMetrics.xdpi) / INCHES_PER_MM;
            default:
                throw new IllegalArgumentException("Invalid unitToConvertTo " + i);
        }
    }

    public static float dpToPx(float f, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f, displayMetrics);
    }

    public static int getUnitFromComplexDimension(int i) {
        return (i >> 0) & 15;
    }

    public static float pxToDp(float f, DisplayMetrics displayMetrics) {
        return deriveDimension(1, f, displayMetrics);
    }

    public static float pxToSp(float f, DisplayMetrics displayMetrics) {
        return deriveDimension(2, f, displayMetrics);
    }

    public static float spToPx(float f, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f, displayMetrics);
    }
}
