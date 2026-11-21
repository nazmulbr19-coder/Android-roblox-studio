package com.google.android.material.carousel;

import androidx.core.math.MathUtils;

/* loaded from: classes.dex */
public final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    public Arrangement(int i, float f, float f2, float f3, int i2, float f4, int i3, float f5, int i4, float f6) {
        this.priority = i;
        this.smallSize = MathUtils.clamp(f, f2, f3);
        this.smallCount = i2;
        this.mediumSize = f4;
        this.mediumCount = i3;
        this.largeSize = f5;
        this.largeCount = i4;
        fit(f6, f2, f3, f5);
        this.cost = cost(f5);
    }

    private float calculateLargeSize(float f, int i, float f2, int i2, int i3) {
        return (f - ((i + (i2 / 2.0f)) * (i > 0 ? f2 : 0.0f))) / (i3 + (i2 / 2.0f));
    }

    private float cost(float f) {
        if (isValid()) {
            return Math.abs(f - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    public static Arrangement findLowestCostArrangement(float f, float f2, float f3, float f4, int[] iArr, float f5, int[] iArr2, float f6, int[] iArr3) {
        Arrangement arrangement = null;
        int i = 1;
        for (int i2 : iArr3) {
            int length = iArr2.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = iArr2[i3];
                int length2 = iArr.length;
                int i5 = 0;
                while (i5 < length2) {
                    int i6 = length;
                    int i7 = i3;
                    int i8 = i;
                    int i9 = length2;
                    int i10 = i5;
                    Arrangement arrangement2 = new Arrangement(i8, f2, f3, f4, iArr[i5], f5, i4, f6, i2, f);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        arrangement = arrangement2;
                        if (arrangement.cost == 0.0f) {
                            return arrangement;
                        }
                    }
                    int i11 = i8 + 1;
                    i5 = i10 + 1;
                    i3 = i7;
                    i = i11;
                    length = i6;
                    length2 = i9;
                }
                i3++;
                i = i;
                length = length;
            }
        }
        return arrangement;
    }

    private void fit(float f, float f2, float f3, float f4) {
        float space = f - getSpace();
        if (this.smallCount > 0 && space > 0.0f) {
            this.smallSize += Math.min(space / this.smallCount, f3 - this.smallSize);
        } else if (this.smallCount > 0 && space < 0.0f) {
            this.smallSize += Math.max(space / this.smallCount, f2 - this.smallSize);
        }
        this.smallSize = this.smallCount > 0 ? this.smallSize : 0.0f;
        this.largeSize = calculateLargeSize(f, this.smallCount, this.smallSize, this.mediumCount, this.largeCount);
        this.mediumSize = (this.largeSize + this.smallSize) / 2.0f;
        if (this.mediumCount <= 0 || this.largeSize == f4) {
            return;
        }
        float f5 = (f4 - this.largeSize) * this.largeCount;
        float min = Math.min(Math.abs(f5), this.mediumSize * 0.1f * this.mediumCount);
        if (f5 > 0.0f) {
            this.mediumSize -= min / this.mediumCount;
            this.largeSize += min / this.largeCount;
        } else {
            this.mediumSize += min / this.mediumCount;
            this.largeSize -= min / this.largeCount;
        }
    }

    private float getSpace() {
        return (this.largeSize * this.largeCount) + (this.mediumSize * this.mediumCount) + (this.smallSize * this.smallCount);
    }

    private boolean isValid() {
        return (this.largeCount <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) ? this.largeCount <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize : this.largeSize > this.mediumSize && this.mediumSize > this.smallSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }
}
