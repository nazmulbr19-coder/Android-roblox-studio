package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i, int i2, double d) {
        Cam16 fromInt = Cam16.fromInt(i);
        Cam16 fromInt2 = Cam16.fromInt(i2);
        double jstar = fromInt.getJstar();
        double astar = fromInt.getAstar();
        double bstar = fromInt.getBstar();
        return Cam16.fromUcs(jstar + ((fromInt2.getJstar() - jstar) * d), astar + ((fromInt2.getAstar() - astar) * d), bstar + ((fromInt2.getBstar() - bstar) * d)).toInt();
    }

    public static int harmonize(int i, int i2) {
        Hct fromInt = Hct.fromInt(i);
        Hct fromInt2 = Hct.fromInt(i2);
        return Hct.from(MathUtils.sanitizeDegreesDouble(fromInt.getHue() + (MathUtils.rotationDirection(fromInt.getHue(), fromInt2.getHue()) * Math.min(0.5d * MathUtils.differenceDegrees(fromInt.getHue(), fromInt2.getHue()), 15.0d))), fromInt.getChroma(), fromInt.getTone()).toInt();
    }

    public static int hctHue(int i, int i2, double d) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i, i2, d)).getHue(), Cam16.fromInt(i).getChroma(), ColorUtils.lstarFromArgb(i)).toInt();
    }
}
