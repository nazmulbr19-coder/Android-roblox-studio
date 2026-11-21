package com.google.android.material.carousel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};

    boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i) {
        int itemCount = arrangement.getItemCount() - i;
        boolean z = itemCount > 0 && (arrangement.smallCount > 0 || arrangement.mediumCount > 1);
        while (itemCount > 0) {
            if (arrangement.smallCount > 0) {
                arrangement.smallCount--;
            } else if (arrangement.mediumCount > 1) {
                arrangement.mediumCount--;
            }
            itemCount--;
        }
        return z;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        int[] iArr;
        boolean z;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = layoutParams.topMargin + layoutParams.bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f = layoutParams.leftMargin + layoutParams.rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float max = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float min = Math.min(measuredHeight + f, containerHeight);
        float clamp = MathUtils.clamp((measuredHeight / 3.0f) + f, smallItemSizeMin + f, max + f);
        float f2 = (min + clamp) / 2.0f;
        int[] iArr2 = SMALL_COUNTS;
        if (containerHeight <= smallItemSizeMin * 2.0f) {
            iArr2 = new int[]{0};
        }
        int[] iArr3 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            int[] doubleCounts = doubleCounts(iArr2);
            iArr3 = doubleCounts(iArr3);
            iArr = doubleCounts;
        } else {
            iArr = iArr2;
        }
        int max2 = (int) Math.max(1.0d, Math.floor(((containerHeight - (CarouselStrategyHelper.maxValue(iArr3) * f2)) - (CarouselStrategyHelper.maxValue(iArr) * max)) / min));
        int ceil = (int) Math.ceil(containerHeight / min);
        int[] iArr4 = new int[(ceil - max2) + 1];
        for (int i = 0; i < iArr4.length; i++) {
            iArr4[i] = ceil - i;
        }
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(containerHeight, clamp, smallItemSizeMin, max, iArr, f2, iArr3, min, iArr4);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        boolean ensureArrangementFitsItemCount = ensureArrangementFitsItemCount(findLowestCostArrangement, carousel.getItemCount());
        if (findLowestCostArrangement.mediumCount == 0 && findLowestCostArrangement.smallCount == 0 && containerHeight > smallItemSizeMin * 2.0f) {
            findLowestCostArrangement.smallCount = 1;
            z = true;
        } else {
            z = ensureArrangementFitsItemCount;
        }
        if (z) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(containerHeight, clamp, smallItemSizeMin, max, new int[]{findLowestCostArrangement.smallCount}, f2, new int[]{findLowestCostArrangement.mediumCount}, min, new int[]{findLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f, containerHeight, findLowestCostArrangement, carousel.getCarouselAlignment());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        return (i < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
    }
}
