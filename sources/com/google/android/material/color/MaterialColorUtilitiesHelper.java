package com.google.android.material.color;

import com.google.android.material.R;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class MaterialColorUtilitiesHelper {
    private static final Map<Integer, DynamicColor> colorResourceIdToColorValue;
    private static final MaterialDynamicColors dynamicColors = new MaterialDynamicColors();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_primary), dynamicColors.primary());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_primary), dynamicColors.onPrimary());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_primary_inverse), dynamicColors.inversePrimary());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_primary_container), dynamicColors.primaryContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_primary_container), dynamicColors.onPrimaryContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_secondary), dynamicColors.secondary());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_secondary), dynamicColors.onSecondary());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_secondary_container), dynamicColors.secondaryContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_secondary_container), dynamicColors.onSecondaryContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_tertiary), dynamicColors.tertiary());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary), dynamicColors.onTertiary());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_tertiary_container), dynamicColors.tertiaryContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary_container), dynamicColors.onTertiaryContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_background), dynamicColors.background());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_background), dynamicColors.onBackground());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface), dynamicColors.surface());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_surface), dynamicColors.onSurface());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_variant), dynamicColors.surfaceVariant());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_surface_variant), dynamicColors.onSurfaceVariant());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_inverse), dynamicColors.inverseSurface());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_surface_inverse), dynamicColors.inverseOnSurface());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_bright), dynamicColors.surfaceBright());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_dim), dynamicColors.surfaceDim());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_container), dynamicColors.surfaceContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_container_low), dynamicColors.surfaceContainerLow());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_container_high), dynamicColors.surfaceContainerHigh());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_container_lowest), dynamicColors.surfaceContainerLowest());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_surface_container_highest), dynamicColors.surfaceContainerHighest());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_outline), dynamicColors.outline());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_outline_variant), dynamicColors.outlineVariant());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_error), dynamicColors.error());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_error), dynamicColors.onError());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_error_container), dynamicColors.errorContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_on_error_container), dynamicColors.onErrorContainer());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_control_activated), dynamicColors.controlActivated());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_control_normal), dynamicColors.controlNormal());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_control_highlight), dynamicColors.controlHighlight());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse), dynamicColors.textPrimaryInverse());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse), dynamicColors.textSecondaryAndTertiaryInverse());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse_disabled), dynamicColors.textSecondaryAndTertiaryInverseDisabled());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse_disable_only), dynamicColors.textPrimaryInverseDisableOnly());
        hashMap.put(Integer.valueOf(R.color.material_personalized_color_text_hint_foreground_inverse), dynamicColors.textHintInverse());
        colorResourceIdToColorValue = Collections.unmodifiableMap(hashMap);
    }

    private MaterialColorUtilitiesHelper() {
    }

    public static Map<Integer, Integer> createColorResourcesIdsToColorValues(DynamicScheme dynamicScheme) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, DynamicColor> entry : colorResourceIdToColorValue.entrySet()) {
            hashMap.put(entry.getKey(), Integer.valueOf(entry.getValue().getArgb(dynamicScheme)));
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
