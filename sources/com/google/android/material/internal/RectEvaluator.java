package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(Rect rect) {
        this.rect = rect;
    }

    /* renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Rect evaluate2(float f, Rect rect, Rect rect2) {
        this.rect.set(rect.left + ((int) ((rect2.left - rect.left) * f)), rect.top + ((int) ((rect2.top - rect.top) * f)), rect.right + ((int) ((rect2.right - rect.right) * f)), rect.bottom + ((int) ((rect2.bottom - rect.bottom) * f)));
        return this.rect;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Rect evaluate(float f, Rect rect, Rect rect2) {
        return evaluate2(f, rect, rect2);
    }
}
