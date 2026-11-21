package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    /* loaded from: classes.dex */
    private static final class KeyColor {
        private static final double MAX_CHROMA_VALUE = 200.0d;
        private final Map<Integer, Double> chromaCache = new HashMap();
        private final double hue;
        private final double requestedChroma;

        public KeyColor(double d, double d2) {
            this.hue = d;
            this.requestedChroma = d2;
        }

        private double maxChroma(int i) {
            Double valueOf;
            if (this.chromaCache.get(Integer.valueOf(i)) == null && (valueOf = Double.valueOf(Hct.from(this.hue, MAX_CHROMA_VALUE, i).getChroma())) != null) {
                this.chromaCache.put(Integer.valueOf(i), valueOf);
            }
            return this.chromaCache.get(Integer.valueOf(i)).doubleValue();
        }

        public Hct create() {
            int i = 0;
            int i2 = 100;
            while (i < i2) {
                int i3 = (i + i2) / 2;
                boolean z = maxChroma(i3) < maxChroma(i3 + 1);
                if (maxChroma(i3) >= this.requestedChroma - 0.01d) {
                    if (Math.abs(i - 50) < Math.abs(i2 - 50)) {
                        i2 = i3;
                    } else {
                        if (i == i3) {
                            return Hct.from(this.hue, this.requestedChroma, i);
                        }
                        i = i3;
                    }
                } else if (z) {
                    i = i3 + 1;
                } else {
                    i2 = i3;
                }
            }
            return Hct.from(this.hue, this.requestedChroma, i);
        }
    }

    private TonalPalette(double d, double d2, Hct hct) {
        this.hue = d;
        this.chroma = d2;
        this.keyColor = hct;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d, double d2) {
        return new TonalPalette(d, d2, new KeyColor(d, d2).create());
    }

    public static TonalPalette fromInt(int i) {
        return fromHct(Hct.fromInt(i));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d) {
        return Hct.from(this.hue, this.chroma, d);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i) {
        Integer num = this.cache.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(Hct.from(this.hue, this.chroma, i).toInt());
            this.cache.put(Integer.valueOf(i), num);
        }
        return num.intValue();
    }
}
