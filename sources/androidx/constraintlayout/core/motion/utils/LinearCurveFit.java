package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        int i;
        double d;
        this.mTotalLength = Double.NaN;
        char c = 0;
        int length = dArr2[0].length;
        this.mSlopeTemp = new double[length];
        this.mT = dArr;
        this.mY = dArr2;
        if (length > 2) {
            double d2 = 0.0d;
            double d3 = 0.0d;
            double d4 = 0.0d;
            int i2 = 0;
            while (i2 < dArr.length) {
                double d5 = dArr2[i2][c];
                double d6 = dArr2[i2][c];
                if (i2 > 0) {
                    i = length;
                    d = d5;
                    d2 += Math.hypot(d5 - d3, d6 - d4);
                } else {
                    i = length;
                    d = d5;
                }
                d3 = d;
                d4 = d6;
                i2++;
                length = i;
                c = 0;
            }
            this.mTotalLength = 0.0d;
        }
    }

    private double getLength2D(double d) {
        double d2;
        char c;
        LinearCurveFit linearCurveFit = this;
        double d3 = 0.0d;
        if (Double.isNaN(linearCurveFit.mTotalLength)) {
            return 0.0d;
        }
        int length = linearCurveFit.mT.length;
        char c2 = 0;
        if (d <= linearCurveFit.mT[0]) {
            return 0.0d;
        }
        if (d >= linearCurveFit.mT[length - 1]) {
            return linearCurveFit.mTotalLength;
        }
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i = 0;
        while (i < length - 1) {
            double d7 = linearCurveFit.mY[i][c2];
            double d8 = linearCurveFit.mY[i][1];
            if (i > 0) {
                d2 = d3;
                c = c2;
                d4 += Math.hypot(d7 - d5, d8 - d6);
            } else {
                d2 = d3;
                c = c2;
            }
            d5 = d7;
            d6 = d8;
            if (d == linearCurveFit.mT[i]) {
                return d4;
            }
            if (d < linearCurveFit.mT[i + 1]) {
                double d9 = (d - linearCurveFit.mT[i]) / (linearCurveFit.mT[i + 1] - linearCurveFit.mT[i]);
                return d4 + Math.hypot(d8 - (((1.0d - d9) * linearCurveFit.mY[i][1]) + (linearCurveFit.mY[i + 1][1] * d9)), d7 - (((1.0d - d9) * linearCurveFit.mY[i][c]) + (linearCurveFit.mY[i + 1][c] * d9)));
            }
            i++;
            linearCurveFit = this;
            c2 = c;
            d3 = d2;
        }
        return d3;
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
                double d2 = (d - this.mT[i2]) / (this.mT[i2 + 1] - this.mT[i2]);
                return ((1.0d - d2) * this.mY[i2][i]) + (this.mY[i2 + 1][i] * d2);
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
                double d2 = (d - this.mT[i5]) / (this.mT[i5 + 1] - this.mT[i5]);
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = ((1.0d - d2) * this.mY[i5][i7]) + (this.mY[i5 + 1][i7] * d2);
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
                double d2 = (d - this.mT[i5]) / (this.mT[i5 + 1] - this.mT[i5]);
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) (((1.0d - d2) * this.mY[i5][i7]) + (this.mY[i5 + 1][i7] * d2));
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        int length = this.mT.length;
        if (d < this.mT[0]) {
            d = this.mT[0];
        } else if (d >= this.mT[length - 1]) {
            d = this.mT[length - 1];
        }
        for (int i2 = 0; i2 < length - 1; i2++) {
            if (d <= this.mT[i2 + 1]) {
                return (this.mY[i2 + 1][i] - this.mY[i2][i]) / (this.mT[i2 + 1] - this.mT[i2]);
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
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = (this.mY[i + 1][i2] - this.mY[i][i2]) / d3;
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
