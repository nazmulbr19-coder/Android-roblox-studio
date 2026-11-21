package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public abstract class CarouselStrategy {
    private float smallSizeMax;
    private float smallSizeMin;

    /* loaded from: classes.dex */
    enum StrategyType {
        CONTAINED,
        UNCONTAINED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] doubleCounts(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr2.length; i++) {
            iArr2[i] = iArr[i] * 2;
        }
        return iArr2;
    }

    public static float getChildMaskPercentage(float f, float f2, float f3) {
        return 1.0f - ((f - f3) / (f2 - f3));
    }

    public float getSmallItemSizeMax() {
        return this.smallSizeMax;
    }

    public float getSmallItemSizeMin() {
        return this.smallSizeMin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StrategyType getStrategyType() {
        return StrategyType.CONTAINED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initialize(Context context) {
        this.smallSizeMin = this.smallSizeMin > 0.0f ? this.smallSizeMin : CarouselStrategyHelper.getSmallSizeMin(context);
        this.smallSizeMax = this.smallSizeMax > 0.0f ? this.smallSizeMax : CarouselStrategyHelper.getSmallSizeMax(context);
    }

    public abstract KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view);

    public void setSmallItemSizeMax(float f) {
        this.smallSizeMax = f;
    }

    public void setSmallItemSizeMin(float f) {
        this.smallSizeMin = f;
    }

    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        return false;
    }
}
