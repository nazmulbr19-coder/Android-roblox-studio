package com.google.android.material.color;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.android.material.color.utilities.Score;

/* loaded from: classes.dex */
public class DynamicColorsOptions {
    private static final DynamicColors.Precondition ALWAYS_ALLOW = new AnonymousClass1();
    private static final DynamicColors.OnAppliedCallback NO_OP_CALLBACK = new AnonymousClass2();
    private Integer contentBasedSeedColor;
    private final DynamicColors.OnAppliedCallback onAppliedCallback;
    private final DynamicColors.Precondition precondition;
    private final int themeOverlay;

    /* renamed from: com.google.android.material.color.DynamicColorsOptions$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements DynamicColors.Precondition {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.color.DynamicColors.Precondition
        public boolean shouldApplyDynamicColors(Activity activity, int i) {
            return true;
        }
    }

    /* renamed from: com.google.android.material.color.DynamicColorsOptions$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements DynamicColors.OnAppliedCallback {
        AnonymousClass2() {
        }

        @Override // com.google.android.material.color.DynamicColors.OnAppliedCallback
        public void onApplied(Activity activity) {
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private Bitmap contentBasedSourceBitmap;
        private Integer contentBasedSourceColor;
        private int themeOverlay;
        private DynamicColors.Precondition precondition = DynamicColorsOptions.access$500();
        private DynamicColors.OnAppliedCallback onAppliedCallback = DynamicColorsOptions.access$600();

        static /* synthetic */ int access$000(Builder builder) {
            return builder.themeOverlay;
        }

        static /* synthetic */ DynamicColors.Precondition access$100(Builder builder) {
            return builder.precondition;
        }

        static /* synthetic */ DynamicColors.OnAppliedCallback access$200(Builder builder) {
            return builder.onAppliedCallback;
        }

        static /* synthetic */ Integer access$300(Builder builder) {
            return builder.contentBasedSourceColor;
        }

        static /* synthetic */ Bitmap access$400(Builder builder) {
            return builder.contentBasedSourceBitmap;
        }

        public DynamicColorsOptions build() {
            return new DynamicColorsOptions(this, null);
        }

        public Builder setContentBasedSource(int i) {
            this.contentBasedSourceBitmap = null;
            this.contentBasedSourceColor = Integer.valueOf(i);
            return this;
        }

        public Builder setContentBasedSource(Bitmap bitmap) {
            this.contentBasedSourceBitmap = bitmap;
            this.contentBasedSourceColor = null;
            return this;
        }

        public Builder setOnAppliedCallback(DynamicColors.OnAppliedCallback onAppliedCallback) {
            this.onAppliedCallback = onAppliedCallback;
            return this;
        }

        public Builder setPrecondition(DynamicColors.Precondition precondition) {
            this.precondition = precondition;
            return this;
        }

        public Builder setThemeOverlay(int i) {
            this.themeOverlay = i;
            return this;
        }
    }

    private DynamicColorsOptions(Builder builder) {
        this.themeOverlay = Builder.access$000(builder);
        this.precondition = Builder.access$100(builder);
        this.onAppliedCallback = Builder.access$200(builder);
        if (Builder.access$300(builder) != null) {
            this.contentBasedSeedColor = Builder.access$300(builder);
        } else if (Builder.access$400(builder) != null) {
            this.contentBasedSeedColor = Integer.valueOf(extractSeedColorFromImage(Builder.access$400(builder)));
        }
    }

    /* synthetic */ DynamicColorsOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static /* synthetic */ DynamicColors.Precondition access$500() {
        return ALWAYS_ALLOW;
    }

    static /* synthetic */ DynamicColors.OnAppliedCallback access$600() {
        return NO_OP_CALLBACK;
    }

    private static int extractSeedColorFromImage(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return Score.score(QuantizerCelebi.quantize(iArr, 128)).get(0).intValue();
    }

    public Integer getContentBasedSeedColor() {
        return this.contentBasedSeedColor;
    }

    public DynamicColors.OnAppliedCallback getOnAppliedCallback() {
        return this.onAppliedCallback;
    }

    public DynamicColors.Precondition getPrecondition() {
        return this.precondition;
    }

    public int getThemeOverlay() {
        return this.themeOverlay;
    }
}
