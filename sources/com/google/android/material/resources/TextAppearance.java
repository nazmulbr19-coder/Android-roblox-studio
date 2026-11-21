package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;
    public final String fontFamily;
    private final int fontFamilyResourceId;
    public String fontVariationSettings;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    private ColorStateList textColor;
    public final ColorStateList textColorHint;
    public final ColorStateList textColorLink;
    private float textSize;
    public final int textStyle;
    public final int typeface;
    private boolean fontResolved = false;
    private boolean systemFontLoadAttempted = false;

    /* renamed from: com.google.android.material.resources.TextAppearance$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ResourcesCompat.FontCallback {
        final /* synthetic */ TextAppearanceFontCallback val$callback;

        AnonymousClass1(TextAppearanceFontCallback textAppearanceFontCallback) {
            this.val$callback = textAppearanceFontCallback;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i) {
            TextAppearance.access$102(TextAppearance.this, true);
            this.val$callback.onFontRetrievalFailed(i);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(Typeface typeface) {
            TextAppearance.access$002(TextAppearance.this, Typeface.create(typeface, TextAppearance.this.textStyle));
            TextAppearance.access$102(TextAppearance.this, true);
            this.val$callback.onFontRetrieved(TextAppearance.access$000(TextAppearance.this), false);
        }
    }

    /* renamed from: com.google.android.material.resources.TextAppearance$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends TextAppearanceFontCallback {
        final /* synthetic */ TextAppearanceFontCallback val$callback;
        final /* synthetic */ Context val$context;
        final /* synthetic */ TextPaint val$textPaint;

        AnonymousClass2(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
            this.val$context = context;
            this.val$textPaint = textPaint;
            this.val$callback = textAppearanceFontCallback;
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i) {
            this.val$callback.onFontRetrievalFailed(i);
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(Typeface typeface, boolean z) {
            TextAppearance.this.updateTextPaintMeasureState(this.val$context, this.val$textPaint, typeface);
            this.val$callback.onFontRetrieved(typeface, z);
        }
    }

    public TextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        setTextSize(obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        setTextColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, com.google.android.material.R.styleable.MaterialTextAppearance);
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(com.google.android.material.R.styleable.MaterialTextAppearance_android_letterSpacing);
        this.letterSpacing = obtainStyledAttributes2.getFloat(com.google.android.material.R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.fontVariationSettings = obtainStyledAttributes2.getString(MaterialResources.getIndexWithValue(obtainStyledAttributes2, com.google.android.material.R.styleable.MaterialTextAppearance_fontVariationSettings, com.google.android.material.R.styleable.MaterialTextAppearance_android_fontVariationSettings));
        }
        obtainStyledAttributes2.recycle();
    }

    static /* synthetic */ Typeface access$000(TextAppearance textAppearance) {
        return textAppearance.font;
    }

    static /* synthetic */ Typeface access$002(TextAppearance textAppearance, Typeface typeface) {
        textAppearance.font = typeface;
        return typeface;
    }

    static /* synthetic */ boolean access$102(TextAppearance textAppearance, boolean z) {
        textAppearance.fontResolved = z;
        return z;
    }

    private void createFallbackFont() {
        if (this.font == null && this.fontFamily != null) {
            this.font = Typeface.create(this.fontFamily, this.textStyle);
        }
        if (this.font == null) {
            switch (this.typeface) {
                case 1:
                    this.font = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.font = Typeface.SERIF;
                    break;
                case 3:
                    this.font = Typeface.MONOSPACE;
                    break;
                default:
                    this.font = Typeface.DEFAULT;
                    break;
            }
            this.font = Typeface.create(this.font, this.textStyle);
        }
    }

    private Typeface getSystemTypeface(Context context) {
        Typeface create;
        if (this.systemFontLoadAttempted) {
            return null;
        }
        this.systemFontLoadAttempted = true;
        String readFontProviderSystemFontFamily = readFontProviderSystemFontFamily(context, this.fontFamilyResourceId);
        if (readFontProviderSystemFontFamily == null || (create = Typeface.create(readFontProviderSystemFontFamily, 0)) == Typeface.DEFAULT) {
            return null;
        }
        return Typeface.create(create, this.textStyle);
    }

    private boolean maybeLoadFontSynchronously(Context context) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            getFont(context);
            return true;
        }
        if (this.fontResolved) {
            return true;
        }
        if (this.fontFamilyResourceId == 0) {
            return false;
        }
        Typeface cachedFont = ResourcesCompat.getCachedFont(context, this.fontFamilyResourceId);
        if (cachedFont != null) {
            this.font = cachedFont;
            this.fontResolved = true;
            return true;
        }
        Typeface systemTypeface = getSystemTypeface(context);
        if (systemTypeface == null) {
            return false;
        }
        this.font = systemTypeface;
        this.fontResolved = true;
        return true;
    }

    private static String readFontProviderSystemFontFamily(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 0 || !resources.getResourceTypeName(i).equals("font")) {
            return null;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            while (xml.getEventType() != 1) {
                if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                    TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R.styleable.FontFamily);
                    String string = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
                    obtainAttributes.recycle();
                    return string;
                }
                xml.next();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    public Typeface getFont(Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                this.font = ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                if (this.font != null) {
                    this.font = Typeface.create(this.font, this.textStyle);
                }
            } catch (Resources.NotFoundException e) {
            } catch (UnsupportedOperationException e2) {
            } catch (Exception e3) {
                Log.d(TAG, "Error loading font " + this.fontFamily, e3);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(context, textPaint, getFallbackFont());
        getFontAsync(context, new AnonymousClass2(context, textPaint, textAppearanceFontCallback));
    }

    public void getFontAsync(Context context, TextAppearanceFontCallback textAppearanceFontCallback) {
        if (!maybeLoadFontSynchronously(context)) {
            createFallbackFont();
        }
        if (this.fontFamilyResourceId == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, this.fontFamilyResourceId, new AnonymousClass1(textAppearanceFontCallback), null);
        } catch (Resources.NotFoundException e) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception e2) {
            Log.d(TAG, "Error loading font " + this.fontFamily, e2);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    public String getFontVariationSettings() {
        return this.fontVariationSettings;
    }

    public ColorStateList getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setFontVariationSettings(String str) {
        this.fontVariationSettings = str;
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textColor = colorStateList;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public void updateDrawState(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        textPaint.setColor(this.textColor != null ? this.textColor.getColorForState(textPaint.drawableState, this.textColor.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        textPaint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor != null ? this.shadowColor.getColorForState(textPaint.drawableState, this.shadowColor.getDefaultColor()) : 0);
    }

    public void updateMeasureState(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        if (maybeLoadFontSynchronously(context) && this.fontResolved && this.font != null) {
            updateTextPaintMeasureState(context, textPaint, this.font);
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(context, typeface);
        if (maybeCopyWithFontWeightAdjustment != null) {
            typeface = maybeCopyWithFontWeightAdjustment;
        }
        textPaint.setTypeface(typeface);
        int i = this.textStyle & (~typeface.getStyle());
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(null);
            textPaint.setFontVariationSettings(this.fontVariationSettings);
        }
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }
}
