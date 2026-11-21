package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String mStr = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    /* loaded from: classes.dex */
    static class CubicEasing extends Easing {
        double mX1;
        double mX2;
        double mY1;
        double mY2;
        private static double sError = 0.01d;
        private static double sDError = 1.0E-4d;

        CubicEasing(double d, double d2, double d3, double d4) {
            setup(d, d2, d3, d4);
        }

        CubicEasing(String str) {
            this.mStr = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.mX1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int indexOf3 = str.indexOf(44, indexOf2 + 1);
            this.mY1 = Double.parseDouble(str.substring(indexOf2 + 1, indexOf3).trim());
            int indexOf4 = str.indexOf(44, indexOf3 + 1);
            this.mX2 = Double.parseDouble(str.substring(indexOf3 + 1, indexOf4).trim());
            this.mY2 = Double.parseDouble(str.substring(indexOf4 + 1, str.indexOf(41, indexOf4 + 1)).trim());
        }

        private double getDiffX(double d) {
            double d2 = 1.0d - d;
            return (d2 * 3.0d * d2 * this.mX1) + (6.0d * d2 * d * (this.mX2 - this.mX1)) + (3.0d * d * d * (1.0d - this.mX2));
        }

        private double getDiffY(double d) {
            double d2 = 1.0d - d;
            return (d2 * 3.0d * d2 * this.mY1) + (6.0d * d2 * d * (this.mY2 - this.mY1)) + (3.0d * d * d * (1.0d - this.mY2));
        }

        private double getX(double d) {
            double d2 = 1.0d - d;
            return (this.mX1 * d2 * 3.0d * d2 * d) + (this.mX2 * 3.0d * d2 * d * d) + (d * d * d);
        }

        private double getY(double d) {
            double d2 = 1.0d - d;
            return (this.mY1 * d2 * 3.0d * d2 * d) + (this.mY2 * 3.0d * d2 * d * d) + (d * d * d);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d3 > sError) {
                d3 *= 0.5d;
                d2 = getX(d2) < d ? d2 + d3 : d2 - d3;
            }
            double x = getX(d2 - d3);
            double x2 = getX(d2 + d3);
            double y = getY(d2 - d3);
            return (((getY(d2 + d3) - y) * (d - x)) / (x2 - x)) + y;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d3 > sDError) {
                d3 *= 0.5d;
                d2 = getX(d2) < d ? d2 + d3 : d2 - d3;
            }
            double x = getX(d2 - d3);
            return (getY(d2 + d3) - getY(d2 - d3)) / (getX(d2 + d3) - x);
        }

        void setup(double d, double d2, double d3, double d4) {
            this.mX1 = d;
            this.mY1 = d2;
            this.mX2 = d3;
            this.mY2 = d4;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Easing getInterpolator(String str) {
        char c;
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(ACCELERATE_NAME)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1263948740:
                if (str.equals(DECELERATE_NAME)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1197605014:
                if (str.equals(ANTICIPATE_NAME)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1102672091:
                if (str.equals(LINEAR_NAME)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -749065269:
                if (str.equals(OVERSHOOT_NAME)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1312628413:
                if (str.equals(STANDARD_NAME)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return new CubicEasing(STANDARD);
            case 1:
                return new CubicEasing(ACCELERATE);
            case 2:
                return new CubicEasing(DECELERATE);
            case 3:
                return new CubicEasing(LINEAR);
            case 4:
                return new CubicEasing(ANTICIPATE);
            case 5:
                return new CubicEasing(OVERSHOOT);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.mStr;
    }
}
