package com.google.android.material.color;

/* loaded from: classes.dex */
public class ColorContrastOptions {
    private final int highContrastThemeOverlayResourceId;
    private final int mediumContrastThemeOverlayResourceId;

    /* loaded from: classes.dex */
    public static class Builder {
        private int highContrastThemeOverlayResourceId;
        private int mediumContrastThemeOverlayResourceId;

        static /* synthetic */ int access$000(Builder builder) {
            return builder.mediumContrastThemeOverlayResourceId;
        }

        static /* synthetic */ int access$100(Builder builder) {
            return builder.highContrastThemeOverlayResourceId;
        }

        public ColorContrastOptions build() {
            return new ColorContrastOptions(this, null);
        }

        public Builder setHighContrastThemeOverlay(int i) {
            this.highContrastThemeOverlayResourceId = i;
            return this;
        }

        public Builder setMediumContrastThemeOverlay(int i) {
            this.mediumContrastThemeOverlayResourceId = i;
            return this;
        }
    }

    private ColorContrastOptions(Builder builder) {
        this.mediumContrastThemeOverlayResourceId = Builder.access$000(builder);
        this.highContrastThemeOverlayResourceId = Builder.access$100(builder);
    }

    /* synthetic */ ColorContrastOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public int getHighContrastThemeOverlay() {
        return this.highContrastThemeOverlayResourceId;
    }

    public int getMediumContrastThemeOverlay() {
        return this.mediumContrastThemeOverlayResourceId;
    }
}
