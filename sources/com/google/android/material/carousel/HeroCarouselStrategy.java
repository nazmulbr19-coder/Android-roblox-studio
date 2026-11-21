package com.google.android.material.carousel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        Arrangement arrangement;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = layoutParams.topMargin + layoutParams.bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f = layoutParams.leftMargin + layoutParams.rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float max = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float min = Math.min(measuredWidth + f, containerHeight);
        float clamp = MathUtils.clamp((measuredWidth / 3.0f) + f, smallItemSizeMin + f, max + f);
        float f2 = (min + clamp) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        if (containerHeight < 2.0f * smallItemSizeMin) {
            iArr = new int[]{0};
        }
        int[] iArr2 = iArr;
        int max2 = (int) Math.max(1.0d, Math.floor((containerHeight - (CarouselStrategyHelper.maxValue(SMALL_COUNTS) * max)) / min));
        int[] iArr3 = new int[(((int) Math.ceil(containerHeight / min)) - max2) + 1];
        for (int i = 0; i < iArr3.length; i++) {
            iArr3[i] = max2 + i;
        }
        boolean z = carousel.getCarouselAlignment() == 1;
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(containerHeight, clamp, smallItemSizeMin, max, z ? doubleCounts(iArr2) : iArr2, f2, z ? doubleCounts(MEDIUM_COUNTS) : MEDIUM_COUNTS, min, iArr3);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (findLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            z = false;
            arrangement = Arrangement.findLowestCostArrangement(containerHeight, clamp, smallItemSizeMin, max, iArr2, f2, MEDIUM_COUNTS, min, iArr3);
        } else {
            arrangement = findLowestCostArrangement;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f, containerHeight, arrangement, z ? 1 : 0);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        if (carousel.getCarouselAlignment() == 1) {
            if (i < this.keylineCount && carousel.getItemCount() >= this.keylineCount) {
                return true;
            }
            if (i >= this.keylineCount && carousel.getItemCount() < this.keylineCount) {
                return true;
            }
        }
        return false;
    }
}
