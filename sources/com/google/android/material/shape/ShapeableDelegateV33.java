package com.google.android.material.shape;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes.dex */
class ShapeableDelegateV33 extends ShapeableDelegate {

    /* renamed from: com.google.android.material.shape.ShapeableDelegateV33$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ViewOutlineProvider {
        AnonymousClass1() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableDelegateV33.this.shapePath.isEmpty()) {
                return;
            }
            outline.setPath(ShapeableDelegateV33.this.shapePath);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeableDelegateV33(View view) {
        initMaskOutlineProvider(view);
    }

    private void initMaskOutlineProvider(View view) {
        view.setOutlineProvider(new AnonymousClass1());
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    void invalidateClippingMethod(View view) {
        view.setClipToOutline(!shouldUseCompatClipping());
        if (shouldUseCompatClipping()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    boolean shouldUseCompatClipping() {
        return this.forceCompatClippingEnabled;
    }
}
