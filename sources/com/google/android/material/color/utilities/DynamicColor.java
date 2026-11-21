package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* loaded from: classes.dex */
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache;
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    public DynamicColor(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, DynamicColor> function4, ContrastCurve contrastCurve, Function<DynamicScheme, ToneDeltaPair> function5) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = null;
    }

    public DynamicColor(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, DynamicColor> function4, ContrastCurve contrastCurve, Function<DynamicScheme, ToneDeltaPair> function5, Function<DynamicScheme, Double> function6) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = function6;
    }

    public static double enableLightForeground(double d) {
        if (!tonePrefersLightForeground(d) || toneAllowsLightForeground(d)) {
            return d;
        }
        return 49.0d;
    }

    public static double foregroundTone(double d, double d2) {
        double lighterUnsafe = Contrast.lighterUnsafe(d, d2);
        double darkerUnsafe = Contrast.darkerUnsafe(d, d2);
        double ratioOfTones = Contrast.ratioOfTones(lighterUnsafe, d);
        double ratioOfTones2 = Contrast.ratioOfTones(darkerUnsafe, d);
        if (tonePrefersLightForeground(d)) {
            return (ratioOfTones >= d2 || ratioOfTones >= ratioOfTones2 || ((Math.abs(ratioOfTones - ratioOfTones2) > 0.1d ? 1 : (Math.abs(ratioOfTones - ratioOfTones2) == 0.1d ? 0 : -1)) < 0 && (ratioOfTones > d2 ? 1 : (ratioOfTones == d2 ? 0 : -1)) < 0 && (ratioOfTones2 > d2 ? 1 : (ratioOfTones2 == d2 ? 0 : -1)) < 0)) ? lighterUnsafe : darkerUnsafe;
        }
        return (ratioOfTones2 >= d2 || ratioOfTones2 >= ratioOfTones) ? darkerUnsafe : lighterUnsafe;
    }

    public static DynamicColor fromArgb(String str, int i) {
        return fromPalette(str, new DynamicColor$$ExternalSyntheticLambda0(TonalPalette.fromInt(i)), new DynamicColor$$ExternalSyntheticLambda1(Hct.fromInt(i)));
    }

    public static DynamicColor fromPalette(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, null, null, null, null);
    }

    public static DynamicColor fromPalette(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z) {
        return new DynamicColor(str, function, function2, z, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$fromArgb$1(Hct hct, DynamicScheme dynamicScheme) {
        return Double.valueOf(hct.getTone());
    }

    public static boolean toneAllowsLightForeground(double d) {
        return Math.round(d) <= 49;
    }

    public static boolean tonePrefersLightForeground(double d) {
        return Math.round(d) < 60;
    }

    public int getArgb(DynamicScheme dynamicScheme) {
        int i = getHct(dynamicScheme).toInt();
        return this.opacity == null ? i : (16777215 & i) | (MathUtils.clampInt(0, 255, (int) Math.round(255.0d * this.opacity.apply(dynamicScheme).doubleValue())) << 24);
    }

    public Hct getHct(DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hct2 = this.palette.apply(dynamicScheme).getHct(getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hct2);
        return hct2;
    }

    public double getTone(DynamicScheme dynamicScheme) {
        ArrayList arrayList;
        double d;
        boolean z = dynamicScheme.contrastLevel < 0.0d;
        if (this.toneDeltaPair == null) {
            boolean z2 = z;
            double doubleValue = this.tone.apply(dynamicScheme).doubleValue();
            if (this.background == null) {
                return doubleValue;
            }
            double tone = this.background.apply(dynamicScheme).getTone(dynamicScheme);
            double d2 = this.contrastCurve.get(dynamicScheme.contrastLevel);
            if (Contrast.ratioOfTones(tone, doubleValue) < d2) {
                doubleValue = foregroundTone(tone, d2);
            }
            if (z2) {
                doubleValue = foregroundTone(tone, d2);
            }
            if (this.isBackground && 50.0d <= doubleValue && doubleValue < 60.0d) {
                doubleValue = Contrast.ratioOfTones(49.0d, tone) >= d2 ? 49.0d : 60.0d;
            }
            if (this.secondBackground == null) {
                return doubleValue;
            }
            double tone2 = this.background.apply(dynamicScheme).getTone(dynamicScheme);
            double tone3 = this.secondBackground.apply(dynamicScheme).getTone(dynamicScheme);
            double max = Math.max(tone2, tone3);
            double min = Math.min(tone2, tone3);
            if (Contrast.ratioOfTones(max, doubleValue) >= d2 && Contrast.ratioOfTones(min, doubleValue) >= d2) {
                return doubleValue;
            }
            double lighter = Contrast.lighter(max, d2);
            double darker = Contrast.darker(min, d2);
            ArrayList arrayList2 = new ArrayList();
            if (lighter != -1.0d) {
                arrayList = arrayList2;
                arrayList.add(Double.valueOf(lighter));
            } else {
                arrayList = arrayList2;
            }
            if (darker != -1.0d) {
                arrayList.add(Double.valueOf(darker));
            }
            if (tonePrefersLightForeground(tone2) || tonePrefersLightForeground(tone3)) {
                if (lighter == -1.0d) {
                    return 100.0d;
                }
                return lighter;
            }
            if (arrayList.size() == 1) {
                return ((Double) arrayList.get(0)).doubleValue();
            }
            if (darker != -1.0d) {
                return darker;
            }
            return 0.0d;
        }
        ToneDeltaPair apply = this.toneDeltaPair.apply(dynamicScheme);
        DynamicColor roleA = apply.getRoleA();
        DynamicColor roleB = apply.getRoleB();
        double delta = apply.getDelta();
        TonePolarity polarity = apply.getPolarity();
        boolean stayTogether = apply.getStayTogether();
        double tone4 = this.background.apply(dynamicScheme).getTone(dynamicScheme);
        boolean z3 = polarity == TonePolarity.NEARER || (polarity == TonePolarity.LIGHTER && !dynamicScheme.isDark) || (polarity == TonePolarity.DARKER && dynamicScheme.isDark);
        DynamicColor dynamicColor = z3 ? roleA : roleB;
        DynamicColor dynamicColor2 = z3 ? roleB : roleA;
        boolean equals = this.name.equals(dynamicColor.name);
        double d3 = dynamicScheme.isDark ? 1.0d : -1.0d;
        boolean z4 = z;
        double d4 = dynamicColor.contrastCurve.get(dynamicScheme.contrastLevel);
        double d5 = dynamicColor2.contrastCurve.get(dynamicScheme.contrastLevel);
        double doubleValue2 = dynamicColor.tone.apply(dynamicScheme).doubleValue();
        double foregroundTone = Contrast.ratioOfTones(tone4, doubleValue2) >= d4 ? doubleValue2 : foregroundTone(tone4, d4);
        double doubleValue3 = dynamicColor2.tone.apply(dynamicScheme).doubleValue();
        double foregroundTone2 = Contrast.ratioOfTones(tone4, doubleValue3) >= d5 ? doubleValue3 : foregroundTone(tone4, d5);
        if (z4) {
            foregroundTone = foregroundTone(tone4, d4);
            foregroundTone2 = foregroundTone(tone4, d5);
        }
        if ((foregroundTone2 - foregroundTone) * d3 < delta) {
            double clampDouble = MathUtils.clampDouble(0.0d, 100.0d, foregroundTone + (delta * d3));
            if ((clampDouble - foregroundTone) * d3 < delta) {
                foregroundTone = MathUtils.clampDouble(0.0d, 100.0d, clampDouble - (delta * d3));
                d = clampDouble;
            } else {
                d = clampDouble;
            }
        } else {
            d = foregroundTone2;
        }
        if (50.0d > foregroundTone || foregroundTone >= 60.0d) {
            if (50.0d <= d && d < 60.0d) {
                if (!stayTogether) {
                    d = d3 > 0.0d ? 60.0d : 49.0d;
                } else if (d3 > 0.0d) {
                    foregroundTone = 60.0d;
                    d = Math.max(d, 60.0d + (delta * d3));
                } else {
                    foregroundTone = 49.0d;
                    d = Math.min(d, 49.0d + (delta * d3));
                }
            }
        } else if (d3 > 0.0d) {
            foregroundTone = 60.0d;
            d = Math.max(d, 60.0d + (delta * d3));
        } else {
            foregroundTone = 49.0d;
            d = Math.min(d, 49.0d + (delta * d3));
        }
        return equals ? foregroundTone : d;
    }
}
