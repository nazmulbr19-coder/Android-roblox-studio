package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length - 1, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        for (int i = 0; i < length2; i++) {
            for (int i2 = 0; i2 < length - 1; i2++) {
                dArr3[i2][i] = (dArr2[i2 + 1][i] - dArr2[i2][i]) / (dArr[i2 + 1] - dArr[i2]);
                if (i2 == 0) {
                    dArr4[i2][i] = dArr3[i2][i];
                } else {
                    dArr4[i2][i] = (dArr3[i2 - 1][i] + dArr3[i2][i]) * 0.5d;
                }
            }
            dArr4[length - 1][i] = dArr3[length - 2][i];
        }
        for (int i3 = 0; i3 < length - 1; i3++) {
            for (int i4 = 0; i4 < length2; i4++) {
                if (dArr3[i3][i4] == 0.0d) {
                    dArr4[i3][i4] = 0.0d;
                    dArr4[i3 + 1][i4] = 0.0d;
                } else {
                    double d = dArr4[i3][i4] / dArr3[i3][i4];
                    double d2 = dArr4[i3 + 1][i4] / dArr3[i3][i4];
                    double hypot = Math.hypot(d, d2);
                    if (hypot > 9.0d) {
                        double d3 = 3.0d / hypot;
                        dArr4[i3][i4] = d3 * d * dArr3[i3][i4];
                        dArr4[i3 + 1][i4] = d3 * d2 * dArr3[i3][i4];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (indexOf2 != -1) {
            int i2 = i + 1;
            dArr[i] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            int i3 = indexOf2 + 1;
            indexOf = i3;
            indexOf2 = str.indexOf(44, i3);
            i = i2;
        }
        dArr[i] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i + 1));
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            dArr2[i + length2][0] = d2;
            dArr3[i + length2] = i * d;
            if (i > 0) {
                dArr2[(length2 * 2) + i][0] = d2 + 1.0d;
                dArr3[(length2 * 2) + i] = (i * d) + 1.0d;
                dArr2[i - 1][0] = (d2 - 1.0d) - d;
                dArr3[i - 1] = ((i * d) - 1.0d) - d;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    private static double diff(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        return ((((((((((-6.0d) * d7) * d4) + ((d2 * 6.0d) * d4)) + ((d7 * 6.0d) * d3)) - ((6.0d * d2) * d3)) + (((d * 3.0d) * d6) * d7)) + (((3.0d * d) * d5) * d7)) - (((2.0d * d) * d6) * d2)) - (((4.0d * d) * d5) * d2)) + (d * d5);
    }

    private static double interpolate(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d7 * d2;
        return (((((((((((-2.0d) * d8) * d4) + ((d7 * 3.0d) * d4)) + ((d8 * 2.0d) * d3)) - ((3.0d * d7) * d3)) + d3) + ((d * d6) * d8)) + ((d * d5) * d8)) - ((d * d6) * d7)) - (((2.0d * d) * d5) * d7)) + (d * d5 * d2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        int length = this.mT.length;
        if (this.mExtrapolate) {
            if (d <= this.mT[0]) {
                return this.mY[0][i] + ((d - this.mT[0]) * getSlope(this.mT[0], i));
            }
            if (d >= this.mT[length - 1]) {
                return this.mY[length - 1][i] + ((d - this.mT[length - 1]) * getSlope(this.mT[length - 1], i));
            }
        } else {
            if (d <= this.mT[0]) {
                return this.mY[0][i];
            }
            if (d >= this.mT[length - 1]) {
                return this.mY[length - 1][i];
            }
        }
        for (int i2 = 0; i2 < length - 1; i2++) {
            if (d == this.mT[i2]) {
                return this.mY[i2][i];
            }
            if (d < this.mT[i2 + 1]) {
                double d2 = this.mT[i2 + 1] - this.mT[i2];
                return interpolate(d2, (d - this.mT[i2]) / d2, this.mY[i2][i], this.mY[i2 + 1][i], this.mTangent[i2][i], this.mTangent[i2 + 1][i]);
            }
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        int length = this.mT.length;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            if (d <= this.mT[0]) {
                getSlope(this.mT[0], this.mSlopeTemp);
                for (int i = 0; i < length2; i++) {
                    dArr[i] = this.mY[0][i] + ((d - this.mT[0]) * this.mSlopeTemp[i]);
                }
                return;
            }
            if (d >= this.mT[length - 1]) {
                getSlope(this.mT[length - 1], this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = this.mY[length - 1][i2] + ((d - this.mT[length - 1]) * this.mSlopeTemp[i2]);
                }
                return;
            }
        } else {
            if (d <= this.mT[0]) {
                for (int i3 = 0; i3 < length2; i3++) {
                    dArr[i3] = this.mY[0][i3];
                }
                return;
            }
            if (d >= this.mT[length - 1]) {
                for (int i4 = 0; i4 < length2; i4++) {
                    dArr[i4] = this.mY[length - 1][i4];
                }
                return;
            }
        }
        for (int i5 = 0; i5 < length - 1; i5++) {
            if (d == this.mT[i5]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = this.mY[i5][i6];
                }
            }
            if (d < this.mT[i5 + 1]) {
                double d2 = this.mT[i5 + 1] - this.mT[i5];
                double d3 = (d - this.mT[i5]) / d2;
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = interpolate(d2, d3, this.mY[i5][i7], this.mY[i5 + 1][i7], this.mTangent[i5][i7], this.mTangent[i5 + 1][i7]);
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        int length = this.mT.length;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            if (d <= this.mT[0]) {
                getSlope(this.mT[0], this.mSlopeTemp);
                for (int i = 0; i < length2; i++) {
                    fArr[i] = (float) (this.mY[0][i] + ((d - this.mT[0]) * this.mSlopeTemp[i]));
                }
                return;
            }
            if (d >= this.mT[length - 1]) {
                getSlope(this.mT[length - 1], this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (this.mY[length - 1][i2] + ((d - this.mT[length - 1]) * this.mSlopeTemp[i2]));
                }
                return;
            }
        } else {
            if (d <= this.mT[0]) {
                for (int i3 = 0; i3 < length2; i3++) {
                    fArr[i3] = (float) this.mY[0][i3];
                }
                return;
            }
            if (d >= this.mT[length - 1]) {
                for (int i4 = 0; i4 < length2; i4++) {
                    fArr[i4] = (float) this.mY[length - 1][i4];
                }
                return;
            }
        }
        for (int i5 = 0; i5 < length - 1; i5++) {
            if (d == this.mT[i5]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) this.mY[i5][i6];
                }
            }
            if (d < this.mT[i5 + 1]) {
                double d2 = this.mT[i5 + 1] - this.mT[i5];
                double d3 = (d - this.mT[i5]) / d2;
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) interpolate(d2, d3, this.mY[i5][i7], this.mY[i5 + 1][i7], this.mTangent[i5][i7], this.mTangent[i5 + 1][i7]);
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        int length = this.mT.length;
        double d2 = d < this.mT[0] ? this.mT[0] : d >= this.mT[length + (-1)] ? this.mT[length - 1] : d;
        for (int i2 = 0; i2 < length - 1; i2++) {
            if (d2 <= this.mT[i2 + 1]) {
                double d3 = this.mT[i2 + 1] - this.mT[i2];
                return diff(d3, (d2 - this.mT[i2]) / d3, this.mY[i2][i], this.mY[i2 + 1][i], this.mTangent[i2][i], this.mTangent[i2 + 1][i]) / d3;
            }
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        int length = this.mT.length;
        int length2 = this.mY[0].length;
        double d2 = d <= this.mT[0] ? this.mT[0] : d >= this.mT[length + (-1)] ? this.mT[length - 1] : d;
        for (int i = 0; i < length - 1; i++) {
            if (d2 <= this.mT[i + 1]) {
                double d3 = this.mT[i + 1] - this.mT[i];
                double d4 = (d2 - this.mT[i]) / d3;
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = diff(d3, d4, this.mY[i][i2], this.mY[i + 1][i2], this.mTangent[i][i2], this.mTangent[i + 1][i2]) / d3;
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }
}
