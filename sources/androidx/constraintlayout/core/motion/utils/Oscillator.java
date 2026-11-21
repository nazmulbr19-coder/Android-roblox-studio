package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double mPI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d, float f) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        System.arraycopy(this.mPosition, binarySearch, this.mPosition, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d;
        this.mPeriod[binarySearch] = f;
        this.mNormalized = false;
    }

    double getDP(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        double d2 = (this.mPeriod[binarySearch] - this.mPeriod[binarySearch - 1]) / (this.mPosition[binarySearch] - this.mPosition[binarySearch - 1]);
        return (d2 * d) + (this.mPeriod[binarySearch - 1] - (this.mPosition[binarySearch - 1] * d2));
    }

    double getP(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        double d2 = (this.mPeriod[binarySearch] - this.mPeriod[binarySearch - 1]) / (this.mPosition[binarySearch] - this.mPosition[binarySearch - 1]);
        return this.mArea[binarySearch - 1] + ((this.mPeriod[binarySearch - 1] - (this.mPosition[binarySearch - 1] * d2)) * (d - this.mPosition[binarySearch - 1])) + ((((d * d) - (this.mPosition[binarySearch - 1] * this.mPosition[binarySearch - 1])) * d2) / 2.0d);
    }

    public double getSlope(double d, double d2, double d3) {
        double p = d2 + getP(d);
        double dp = getDP(d) + d3;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                return dp * 4.0d * Math.signum((((p * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return 2.0d * dp;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                return (-this.mPI2) * dp * Math.sin(this.mPI2 * p);
            case 6:
                return dp * 4.0d * ((((p * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.mCustomCurve.getSlope(p % 1.0d, 0);
            default:
                return this.mPI2 * dp * Math.cos(this.mPI2 * p);
        }
    }

    public double getValue(double d, double d2) {
        double p = getP(d) + d2;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p % 1.0d));
            case 2:
                return 1.0d - Math.abs((((p * 4.0d) + 1.0d) % 4.0d) - 2.0d);
            case 3:
                return (((p * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                return 1.0d - (((p * 2.0d) + 1.0d) % 2.0d);
            case 5:
                return Math.cos(this.mPI2 * (d2 + p));
            case 6:
                double abs = 1.0d - Math.abs(((p * 4.0d) % 4.0d) - 2.0d);
                return 1.0d - (abs * abs);
            case 7:
                return this.mCustomCurve.getPos(p % 1.0d, 0);
            default:
                return Math.sin(this.mPI2 * p);
        }
    }

    public void normalize() {
        double d = 0.0d;
        double d2 = 0.0d;
        for (int i = 0; i < this.mPeriod.length; i++) {
            d2 += this.mPeriod[i];
        }
        for (int i2 = 1; i2 < this.mPeriod.length; i2++) {
            d += ((this.mPeriod[i2 - 1] + this.mPeriod[i2]) / 2.0f) * (this.mPosition[i2] - this.mPosition[i2 - 1]);
        }
        for (int i3 = 0; i3 < this.mPeriod.length; i3++) {
            float[] fArr = this.mPeriod;
            fArr[i3] = fArr[i3] * ((float) (d2 / d));
        }
        this.mArea[0] = 0.0d;
        for (int i4 = 1; i4 < this.mPeriod.length; i4++) {
            this.mArea[i4] = this.mArea[i4 - 1] + (((this.mPeriod[i4 - 1] + this.mPeriod[i4]) / 2.0f) * (this.mPosition[i4] - this.mPosition[i4 - 1]));
        }
        this.mNormalized = true;
    }

    public void setType(int i, String str) {
        this.mType = i;
        this.mCustomType = str;
        if (this.mCustomType != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
