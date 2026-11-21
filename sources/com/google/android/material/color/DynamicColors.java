package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.core.os.BuildCompat;
import com.google.android.material.R;
import com.google.android.material.color.DynamicColorsOptions;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.SchemeContent;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class DynamicColors {
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    private static final String TAG;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {R.attr.dynamicColorThemeOverlay};
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION = new AnonymousClass1();
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION = new AnonymousClass2();

    /* renamed from: com.google.android.material.color.DynamicColors$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements DeviceSupportCondition {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
        public boolean isSupported() {
            return true;
        }
    }

    /* renamed from: com.google.android.material.color.DynamicColors$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements DeviceSupportCondition {
        private Long version;

        AnonymousClass2() {
        }

        @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
        public boolean isSupported() {
            if (this.version == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                    declaredMethod.setAccessible(true);
                    this.version = Long.valueOf(((Long) declaredMethod.invoke(null, "ro.build.version.oneui")).longValue());
                } catch (Exception e) {
                    this.version = -1L;
                }
            }
            return this.version.longValue() >= 40100;
        }
    }

    /* loaded from: classes.dex */
    private interface DeviceSupportCondition {
        boolean isSupported();
    }

    /* loaded from: classes.dex */
    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final DynamicColorsOptions dynamicColorsOptions;

        DynamicColorsActivityLifecycleCallbacks(DynamicColorsOptions dynamicColorsOptions) {
            this.dynamicColorsOptions = dynamicColorsOptions;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            DynamicColors.applyToActivityIfAvailable(activity, this.dynamicColorsOptions);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* loaded from: classes.dex */
    public interface OnAppliedCallback {
        void onApplied(Activity activity);
    }

    /* loaded from: classes.dex */
    public interface Precondition {
        boolean shouldApplyDynamicColors(Activity activity, int i);
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("fcnt", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("google", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("hmd global", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("infinix", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("infinix mobility limited", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("itel", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("kyocera", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("lenovo", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("lge", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("meizu", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("motorola", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("nothing", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("oneplus", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("oppo", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("realme", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("robolectric", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("samsung", SAMSUNG_DEVICE_SUPPORT_CONDITION);
        hashMap.put("sharp", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("shift", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("sony", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("tcl", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("tecno", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("tecno mobile limited", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("vivo", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("wingtech", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("xiaomi", DEFAULT_DEVICE_SUPPORT_CONDITION);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap2.put("jio", DEFAULT_DEVICE_SUPPORT_CONDITION);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(hashMap2);
        TAG = DynamicColors.class.getSimpleName();
    }

    private DynamicColors() {
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity) {
        applyToActivityIfAvailable(activity);
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity, int i) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().setThemeOverlay(i).build());
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity, Precondition precondition) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().setPrecondition(precondition).build());
    }

    public static void applyToActivitiesIfAvailable(Application application) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, int i) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setThemeOverlay(i).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, int i, Precondition precondition) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setThemeOverlay(i).setPrecondition(precondition).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, Precondition precondition) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setPrecondition(precondition).build());
    }

    public static void applyToActivitiesIfAvailable(Application application, DynamicColorsOptions dynamicColorsOptions) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(dynamicColorsOptions));
    }

    public static void applyToActivityIfAvailable(Activity activity) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().build());
    }

    public static void applyToActivityIfAvailable(Activity activity, DynamicColorsOptions dynamicColorsOptions) {
        if (isDynamicColorAvailable()) {
            int i = 0;
            if (dynamicColorsOptions.getContentBasedSeedColor() == null) {
                i = dynamicColorsOptions.getThemeOverlay() == 0 ? getDefaultThemeOverlay(activity, DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE) : dynamicColorsOptions.getThemeOverlay();
            }
            if (dynamicColorsOptions.getPrecondition().shouldApplyDynamicColors(activity, i)) {
                if (dynamicColorsOptions.getContentBasedSeedColor() != null) {
                    SchemeContent schemeContent = new SchemeContent(Hct.fromInt(dynamicColorsOptions.getContentBasedSeedColor().intValue()), !MaterialColors.isLightTheme(activity), getSystemContrast(activity));
                    ColorResourcesOverride colorResourcesOverride = ColorResourcesOverride.getInstance();
                    if (colorResourcesOverride == null || !colorResourcesOverride.applyIfPossible(activity, MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(schemeContent))) {
                        return;
                    }
                } else {
                    ThemeUtils.applyThemeOverlay(activity, i);
                }
                dynamicColorsOptions.getOnAppliedCallback().onApplied(activity);
            }
        }
    }

    private static int getDefaultThemeOverlay(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static float getSystemContrast(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager == null || Build.VERSION.SDK_INT < 34) {
            return 0.0f;
        }
        return uiModeManager.getContrast();
    }

    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        if (BuildCompat.isAtLeastT()) {
            return true;
        }
        DeviceSupportCondition deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase(Locale.ROOT));
        if (deviceSupportCondition == null) {
            deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase(Locale.ROOT));
        }
        return deviceSupportCondition != null && deviceSupportCondition.isSupported();
    }

    public static Context wrapContextIfAvailable(Context context) {
        return wrapContextIfAvailable(context, 0);
    }

    public static Context wrapContextIfAvailable(Context context, int i) {
        return wrapContextIfAvailable(context, new DynamicColorsOptions.Builder().setThemeOverlay(i).build());
    }

    public static Context wrapContextIfAvailable(Context context, DynamicColorsOptions dynamicColorsOptions) {
        if (!isDynamicColorAvailable()) {
            return context;
        }
        int themeOverlay = dynamicColorsOptions.getThemeOverlay();
        if (themeOverlay == 0) {
            themeOverlay = getDefaultThemeOverlay(context, DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        }
        if (themeOverlay == 0) {
            return context;
        }
        if (dynamicColorsOptions.getContentBasedSeedColor() != null) {
            SchemeContent schemeContent = new SchemeContent(Hct.fromInt(dynamicColorsOptions.getContentBasedSeedColor().intValue()), !MaterialColors.isLightTheme(context), getSystemContrast(context));
            ColorResourcesOverride colorResourcesOverride = ColorResourcesOverride.getInstance();
            if (colorResourcesOverride != null) {
                return colorResourcesOverride.wrapContextIfPossible(context, MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(schemeContent));
            }
        }
        return new ContextThemeWrapper(context, themeOverlay);
    }
}
