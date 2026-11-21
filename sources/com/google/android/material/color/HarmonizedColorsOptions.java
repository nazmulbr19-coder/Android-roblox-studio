package com.google.android.material.color;

import androidx.appcompat.R;

/* loaded from: classes.dex */
public class HarmonizedColorsOptions {
    private final int colorAttributeToHarmonizeWith;
    private final HarmonizedColorAttributes colorAttributes;
    private final int[] colorResourceIds;

    /* loaded from: classes.dex */
    public static class Builder {
        private HarmonizedColorAttributes colorAttributes;
        private int[] colorResourceIds = new int[0];
        private int colorAttributeToHarmonizeWith = R.attr.colorPrimary;

        static /* synthetic */ int[] access$000(Builder builder) {
            return builder.colorResourceIds;
        }

        static /* synthetic */ HarmonizedColorAttributes access$100(Builder builder) {
            return builder.colorAttributes;
        }

        static /* synthetic */ int access$200(Builder builder) {
            return builder.colorAttributeToHarmonizeWith;
        }

        public HarmonizedColorsOptions build() {
            return new HarmonizedColorsOptions(this, null);
        }

        public Builder setColorAttributeToHarmonizeWith(int i) {
            this.colorAttributeToHarmonizeWith = i;
            return this;
        }

        public Builder setColorAttributes(HarmonizedColorAttributes harmonizedColorAttributes) {
            this.colorAttributes = harmonizedColorAttributes;
            return this;
        }

        public Builder setColorResourceIds(int[] iArr) {
            this.colorResourceIds = iArr;
            return this;
        }
    }

    private HarmonizedColorsOptions(Builder builder) {
        this.colorResourceIds = Builder.access$000(builder);
        this.colorAttributes = Builder.access$100(builder);
        this.colorAttributeToHarmonizeWith = Builder.access$200(builder);
    }

    /* synthetic */ HarmonizedColorsOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static HarmonizedColorsOptions createMaterialDefaults() {
        return new Builder().setColorAttributes(HarmonizedColorAttributes.createMaterialDefaults()).build();
    }

    public int getColorAttributeToHarmonizeWith() {
        return this.colorAttributeToHarmonizeWith;
    }

    public HarmonizedColorAttributes getColorAttributes() {
        return this.colorAttributes;
    }

    public int[] getColorResourceIds() {
        return this.colorResourceIds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getThemeOverlayResourceId(int i) {
        return (this.colorAttributes == null || this.colorAttributes.getThemeOverlay() == 0) ? i : this.colorAttributes.getThemeOverlay();
    }
}
