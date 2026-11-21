package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
    }

    /* renamed from: get, reason: avoid collision after fix types in other method */
    public Integer get2(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Integer get(Drawable drawable) {
        return get2(drawable);
    }

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Drawable drawable, Integer num) {
        set2(drawable, num);
    }
}
