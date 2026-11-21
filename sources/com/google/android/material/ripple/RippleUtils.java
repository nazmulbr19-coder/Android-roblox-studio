package com.google.android.material.ripple;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes.dex */
public class RippleUtils {
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";

    @Deprecated
    public static final boolean USE_FRAMEWORK_RIPPLE = true;
    private static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    private static final int[] FOCUSED_STATE_SET = {R.attr.state_focused};
    private static final int[] SELECTED_PRESSED_STATE_SET = {R.attr.state_selected, R.attr.state_pressed};
    private static final int[] SELECTED_STATE_SET = {R.attr.state_selected};
    private static final int[] ENABLED_PRESSED_STATE_SET = {R.attr.state_enabled, R.attr.state_pressed};
    static final String LOG_TAG = RippleUtils.class.getSimpleName();

    /* loaded from: classes.dex */
    private static class RippleUtilsLollipop {
        private RippleUtilsLollipop() {
        }

        static /* synthetic */ Drawable access$000(Context context, int i) {
            return createOvalRipple(context, i);
        }

        private static Drawable createOvalRipple(Context context, int i) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(MaterialColors.getColorStateList(context, androidx.appcompat.R.attr.colorControlHighlight, ColorStateList.valueOf(0)), null, new InsetDrawable((Drawable) gradientDrawable, i, i, i, i));
        }
    }

    private RippleUtils() {
    }

    public static ColorStateList convertToRippleDrawableColor(ColorStateList colorStateList) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        iArr[0] = SELECTED_STATE_SET;
        iArr2[0] = getColorForState(colorStateList, SELECTED_PRESSED_STATE_SET);
        int i = 0 + 1;
        iArr[i] = FOCUSED_STATE_SET;
        iArr2[i] = getColorForState(colorStateList, FOCUSED_STATE_SET);
        int i2 = i + 1;
        iArr[i2] = StateSet.NOTHING;
        iArr2[i2] = getColorForState(colorStateList, PRESSED_STATE_SET);
        int i3 = i2 + 1;
        return new ColorStateList(iArr, iArr2);
    }

    public static Drawable createOvalRippleLollipop(Context context, int i) {
        return RippleUtilsLollipop.access$000(context, i);
    }

    private static int doubleAlpha(int i) {
        return ColorUtils.setAlphaComponent(i, Math.min(Color.alpha(i) * 2, 255));
    }

    private static int getColorForState(ColorStateList colorStateList, int[] iArr) {
        return doubleAlpha(colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0);
    }

    public static ColorStateList sanitizeRippleDrawableColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) != 0) {
            Log.w(LOG_TAG, TRANSPARENT_DEFAULT_COLOR_WARNING);
        }
        return colorStateList;
    }

    public static boolean shouldDrawRippleCompat(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842908) {
                z2 = true;
            } else if (i == 16842919) {
                z2 = true;
            } else if (i == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
