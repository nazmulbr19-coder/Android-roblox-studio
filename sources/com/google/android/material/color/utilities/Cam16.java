package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public final class Cam16 {
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;
    private final double j;
    private final double jstar;
    private final double m;
    private final double q;
    private final double s;
    private final double[] tempArray = {0.0d, 0.0d, 0.0d};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    private Cam16(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.hue = d;
        this.chroma = d2;
        this.j = d3;
        this.q = d4;
        this.m = d5;
        this.s = d6;
        this.jstar = d7;
        this.astar = d8;
        this.bstar = d9;
    }

    public static Cam16 fromInt(int i) {
        return fromIntInViewingConditions(i, ViewingConditions.DEFAULT);
    }

    static Cam16 fromIntInViewingConditions(int i, ViewingConditions viewingConditions) {
        double linearized = ColorUtils.linearized((16711680 & i) >> 16);
        double linearized2 = ColorUtils.linearized((65280 & i) >> 8);
        double linearized3 = ColorUtils.linearized(i & 255);
        return fromXyzInViewingConditions((0.41233895d * linearized) + (0.35762064d * linearized2) + (0.18051042d * linearized3), (0.2126d * linearized) + (0.7152d * linearized2) + (0.0722d * linearized3), (0.01932141d * linearized) + (0.11916382d * linearized2) + (0.95034478d * linearized3), viewingConditions);
    }

    static Cam16 fromJch(double d, double d2, double d3) {
        return fromJchInViewingConditions(d, d2, d3, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double c = (4.0d / viewingConditions.getC()) * Math.sqrt(d / 100.0d) * (viewingConditions.getAw() + 4.0d) * viewingConditions.getFlRoot();
        double flRoot = d2 * viewingConditions.getFlRoot();
        double sqrt = Math.sqrt((viewingConditions.getC() * (d2 / Math.sqrt(d / 100.0d))) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double radians = Math.toRadians(d3);
        double d4 = (1.7000000000000002d * d) / ((0.007d * d) + 1.0d);
        double log1p = Math.log1p(0.0228d * flRoot) * 43.859649122807014d;
        return new Cam16(d3, d2, d, c, flRoot, sqrt, d4, log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    public static Cam16 fromUcs(double d, double d2, double d3) {
        return fromUcsInViewingConditions(d, d2, d3, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double expm1 = (Math.expm1(Math.hypot(d2, d3) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double atan2 = Math.atan2(d3, d2) * 57.29577951308232d;
        return fromJchInViewingConditions(d / (1.0d - ((d - 100.0d) * 0.007d)), expm1, atan2 < 0.0d ? atan2 + 360.0d : atan2, viewingConditions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Cam16 fromXyzInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double[][] dArr = XYZ_TO_CAM16RGB;
        double d4 = (dArr[0][0] * d) + (dArr[0][1] * d2) + (dArr[0][2] * d3);
        double d5 = (dArr[1][0] * d) + (dArr[1][1] * d2) + (dArr[1][2] * d3);
        double d6 = (dArr[2][0] * d) + (dArr[2][1] * d2) + (dArr[2][2] * d3);
        double d7 = viewingConditions.getRgbD()[0] * d4;
        double d8 = viewingConditions.getRgbD()[1] * d5;
        double d9 = viewingConditions.getRgbD()[2] * d6;
        double pow = Math.pow((viewingConditions.getFl() * Math.abs(d7)) / 100.0d, 0.42d);
        double pow2 = Math.pow((viewingConditions.getFl() * Math.abs(d8)) / 100.0d, 0.42d);
        double pow3 = Math.pow((viewingConditions.getFl() * Math.abs(d9)) / 100.0d, 0.42d);
        double signum = ((Math.signum(d7) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d8) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d9) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d10 = (((signum * 11.0d) + ((-12.0d) * signum2)) + signum3) / 11.0d;
        double d11 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d12 = (((signum * 20.0d) + (signum2 * 20.0d)) + (21.0d * signum3)) / 20.0d;
        double d13 = (((40.0d * signum) + (signum2 * 20.0d)) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d11, d10));
        double d14 = degrees < 0.0d ? degrees + 360.0d : degrees >= 360.0d ? degrees - 360.0d : degrees;
        double radians = Math.toRadians(d14);
        double pow4 = Math.pow((d13 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
        double c = (4.0d / viewingConditions.getC()) * Math.sqrt(pow4 / 100.0d) * (viewingConditions.getAw() + 4.0d) * viewingConditions.getFlRoot();
        double pow5 = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d) * Math.pow((Math.hypot(d10, d11) * (((3846.153846153846d * ((Math.cos(Math.toRadians(d14 < 20.14d ? d14 + 360.0d : d14) + 2.0d) + 3.8d) * 0.25d)) * viewingConditions.getNc()) * viewingConditions.getNcb())) / (d12 + 0.305d), 0.9d);
        double sqrt = pow5 * Math.sqrt(pow4 / 100.0d);
        double flRoot = sqrt * viewingConditions.getFlRoot();
        double sqrt2 = Math.sqrt((viewingConditions.getC() * pow5) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double d15 = (1.7000000000000002d * pow4) / ((0.007d * pow4) + 1.0d);
        double log1p = Math.log1p(0.0228d * flRoot) * 43.859649122807014d;
        return new Cam16(d14, sqrt, pow4, c, flRoot, sqrt2, d15, log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    public double distance(Cam16 cam16) {
        double jstar = getJstar() - cam16.getJstar();
        double astar = getAstar() - cam16.getAstar();
        double bstar = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((jstar * jstar) + (astar * astar) + (bstar * bstar)), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.m;
    }

    public double getQ() {
        return this.q;
    }

    public double getS() {
        return this.s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    int viewed(ViewingConditions viewingConditions) {
        double[] xyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(xyzInViewingConditions[0], xyzInViewingConditions[1], xyzInViewingConditions[2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double pow = Math.pow(((getChroma() == 0.0d || getJ() == 0.0d) ? 0.0d : getChroma() / Math.sqrt(getJ() / 100.0d)) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double cos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d;
        double aw = viewingConditions.getAw() * Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ());
        double nc = 3846.153846153846d * cos * viewingConditions.getNc() * viewingConditions.getNcb();
        double nbb = aw / viewingConditions.getNbb();
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians);
        double d = (((nbb + 0.305d) * 23.0d) * pow) / (((23.0d * nc) + ((11.0d * pow) * cos2)) + ((108.0d * pow) * sin));
        double d2 = d * cos2;
        double d3 = d * sin;
        double d4 = (((nbb * 460.0d) + (451.0d * d2)) + (288.0d * d3)) / 1403.0d;
        double d5 = (((nbb * 460.0d) - (891.0d * d2)) - (261.0d * d3)) / 1403.0d;
        double d6 = (((460.0d * nbb) - (220.0d * d2)) - (6300.0d * d3)) / 1403.0d;
        double signum = Math.signum(d4) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(0.0d, (Math.abs(d4) * 27.13d) / (400.0d - Math.abs(d4))), 2.380952380952381d);
        double signum2 = Math.signum(d5) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(0.0d, (Math.abs(d5) * 27.13d) / (400.0d - Math.abs(d5))), 2.380952380952381d);
        double pow2 = Math.pow(Math.max(0.0d, (Math.abs(d6) * 27.13d) / (400.0d - Math.abs(d6))), 2.380952380952381d) * Math.signum(d6) * (100.0d / viewingConditions.getFl());
        double d7 = signum / viewingConditions.getRgbD()[0];
        double d8 = signum2 / viewingConditions.getRgbD()[1];
        double d9 = pow2 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double d10 = (dArr2[0][0] * d7) + (dArr2[0][1] * d8) + (dArr2[0][2] * d9);
        double d11 = (dArr2[1][0] * d7) + (dArr2[1][1] * d8) + (dArr2[1][2] * d9);
        double d12 = (dArr2[2][0] * d7) + (dArr2[2][1] * d8) + (dArr2[2][2] * d9);
        if (dArr == null) {
            return new double[]{d10, d11, d12};
        }
        dArr[0] = d10;
        dArr[1] = d11;
        dArr[2] = d12;
        return dArr;
    }
}
