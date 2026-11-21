package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    /* renamed from: androidx.appcompat.widget.AppCompatDrawableManager$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ResourceManagerInternal.ResourceManagerHooks {
        private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
        private final int[] TINT_COLOR_CONTROL_NORMAL = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        private final int[] TINT_COLOR_CONTROL_STATE_LIST = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        private final int[] TINT_CHECKABLE_BUTTON_LIST = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        AnonymousClass1() {
        }

        private boolean arrayContains(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList createBorderlessButtonColorStateList(Context context) {
            return createButtonColorStateList(context, 0);
        }

        private ColorStateList createButtonColorStateList(Context context, int i) {
            int[][] iArr = new int[4];
            int[] iArr2 = new int[4];
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
            int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal);
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = disabledThemeAttrColor;
            int i2 = 0 + 1;
            iArr[i2] = ThemeUtils.PRESSED_STATE_SET;
            iArr2[i2] = ColorUtils.compositeColors(themeAttrColor, i);
            int i3 = i2 + 1;
            iArr[i3] = ThemeUtils.FOCUSED_STATE_SET;
            iArr2[i3] = ColorUtils.compositeColors(themeAttrColor, i);
            int i4 = i3 + 1;
            iArr[i4] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[i4] = i;
            int i5 = i4 + 1;
            return new ColorStateList(iArr, iArr2);
        }

        private ColorStateList createColoredButtonColorStateList(Context context) {
            return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
        }

        private ColorStateList createDefaultButtonColorStateList(Context context) {
            return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
        }

        private ColorStateList createSwitchThumbColorStateList(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                int i = 0 + 1;
                iArr[i] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[i] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                int i2 = i + 1;
                iArr[i2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[i2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                int i3 = i2 + 1;
            } else {
                iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
                int i4 = 0 + 1;
                iArr[i4] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[i4] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                int i5 = i4 + 1;
                iArr[i5] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[i5] = themeAttrColorStateList.getDefaultColor();
                int i6 = i5 + 1;
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
            Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
            if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawable;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable.draw(canvas);
                BitmapDrawable bitmapDrawable4 = new BitmapDrawable(createBitmap);
                BitmapDrawable bitmapDrawable5 = new BitmapDrawable(createBitmap);
                bitmapDrawable = bitmapDrawable4;
                bitmapDrawable2 = bitmapDrawable5;
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawable2;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        private void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
            drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode == null ? AppCompatDrawableManager.m4$$Nest$sfgetDEFAULT_MODE() : mode));
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
            if (i == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i == R.drawable.abc_ratingbar_material) {
                return getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_big);
            }
            if (i == R.drawable.abc_ratingbar_indicator_material) {
                return getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_medium);
            }
            if (i == R.drawable.abc_ratingbar_small_material) {
                return getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public ColorStateList getTintListForDrawableRes(Context context, int i) {
            if (i == R.drawable.abc_edit_text_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
            }
            if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
            }
            if (i == R.drawable.abc_switch_thumb_material) {
                return createSwitchThumbColorStateList(context);
            }
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return createDefaultButtonColorStateList(context);
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return createBorderlessButtonColorStateList(context);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return createColoredButtonColorStateList(context);
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
            }
            if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i)) {
                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
            }
            if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
            }
            if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public PorterDuff.Mode getTintModeForDrawableRes(int i) {
            if (i == R.drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public boolean tintDrawable(Context context, int i, Drawable drawable) {
            if (i == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.background), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.m4$$Nest$sfgetDEFAULT_MODE());
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.m4$$Nest$sfgetDEFAULT_MODE());
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.m4$$Nest$sfgetDEFAULT_MODE());
                return true;
            }
            if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.background), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.m4$$Nest$sfgetDEFAULT_MODE());
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.m4$$Nest$sfgetDEFAULT_MODE());
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.m4$$Nest$sfgetDEFAULT_MODE());
            return true;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable) {
            PorterDuff.Mode m4$$Nest$sfgetDEFAULT_MODE = AppCompatDrawableManager.m4$$Nest$sfgetDEFAULT_MODE();
            boolean z = false;
            int i2 = 0;
            int i3 = -1;
            if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
                i2 = R.attr.colorControlNormal;
                z = true;
            } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                i2 = R.attr.colorControlActivated;
                z = true;
            } else if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                i2 = android.R.attr.colorBackground;
                z = true;
                m4$$Nest$sfgetDEFAULT_MODE = PorterDuff.Mode.MULTIPLY;
            } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                i2 = android.R.attr.colorForeground;
                z = true;
                i3 = Math.round(40.8f);
            } else if (i == R.drawable.abc_dialog_material_background) {
                i2 = android.R.attr.colorBackground;
                z = true;
            }
            if (!z) {
                return false;
            }
            Drawable mutate = drawable.mutate();
            mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), m4$$Nest$sfgetDEFAULT_MODE));
            if (i3 == -1) {
                return true;
            }
            mutate.setAlpha(i3);
            return true;
        }
    }

    /* renamed from: -$$Nest$sfgetDEFAULT_MODE, reason: not valid java name */
    static /* bridge */ /* synthetic */ PorterDuff.Mode m4$$Nest$sfgetDEFAULT_MODE() {
        return DEFAULT_MODE;
    }

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                preload();
            }
            appCompatDrawableManager = INSTANCE;
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new AppCompatDrawableManager();
                INSTANCE.mResourceManager = ResourceManagerInternal.get();
                INSTANCE.mResourceManager.setHooks(new AnonymousClass1());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized Drawable getDrawable(Context context, int i) {
        return this.mResourceManager.getDrawable(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable getDrawable(Context context, int i, boolean z) {
        return this.mResourceManager.getDrawable(context, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList getTintList(Context context, int i) {
        return this.mResourceManager.getTintList(context, i);
    }

    public synchronized void onConfigurationChanged(Context context) {
        this.mResourceManager.onConfigurationChanged(context);
    }

    synchronized Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        return this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i);
    }

    boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, i, drawable);
    }
}
