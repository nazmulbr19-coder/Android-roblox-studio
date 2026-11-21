package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int DOWN_ARC = 4;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    private static final int UP_ARC = 5;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    /* loaded from: classes.dex */
    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] sOurPercent = new double[91];
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        boolean mLinear;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        Arc(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            double d7;
            double d8;
            double d9;
            this.mLinear = false;
            double d10 = d5 - d3;
            double d11 = d6 - d4;
            switch (i) {
                case 1:
                    this.mVertical = true;
                    break;
                case 2:
                case 3:
                default:
                    this.mVertical = false;
                    break;
                case 4:
                    this.mVertical = d11 > 0.0d;
                    break;
                case 5:
                    this.mVertical = d11 < 0.0d;
                    break;
            }
            this.mTime1 = d;
            this.mTime2 = d2;
            this.mOneOverDeltaTime = 1.0d / (this.mTime2 - this.mTime1);
            if (3 == i) {
                this.mLinear = true;
            }
            if (this.mLinear || Math.abs(d10) < EPSILON) {
                d7 = d3;
                d8 = d4;
                d9 = d5;
            } else {
                if (Math.abs(d11) >= EPSILON) {
                    this.mLut = new double[TypedValues.TYPE_TARGET];
                    this.mEllipseA = (this.mVertical ? -1 : 1) * d10;
                    this.mEllipseB = (this.mVertical ? 1 : -1) * d11;
                    this.mEllipseCenterX = this.mVertical ? d5 : d3;
                    this.mEllipseCenterY = this.mVertical ? d4 : d6;
                    buildTable(d3, d4, d5, d6);
                    this.mArcVelocity = this.mOneOverDeltaTime * this.mArcDistance;
                    return;
                }
                d7 = d3;
                d8 = d4;
                d9 = d5;
            }
            this.mLinear = true;
            this.mX1 = d7;
            this.mX2 = d9;
            this.mY1 = d8;
            this.mY2 = d6;
            this.mArcDistance = Math.hypot(d11, d10);
            this.mArcVelocity = this.mOneOverDeltaTime * this.mArcDistance;
            this.mEllipseCenterX = d10 / (this.mTime2 - this.mTime1);
            this.mEllipseCenterY = d11 / (this.mTime2 - this.mTime1);
        }

        private void buildTable(double d, double d2, double d3, double d4) {
            int i;
            double d5;
            double d6;
            double d7 = d3 - d;
            double d8 = d2 - d4;
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            int i2 = 0;
            while (i2 < sOurPercent.length) {
                double radians = Math.toRadians((i2 * 90.0d) / (sOurPercent.length - 1));
                double sin = d7 * Math.sin(radians);
                double cos = d8 * Math.cos(radians);
                if (i2 > 0) {
                    d5 = d7;
                    d6 = d8;
                    d11 += Math.hypot(sin - d9, cos - d10);
                    sOurPercent[i2] = d11;
                } else {
                    d5 = d7;
                    d6 = d8;
                }
                d9 = sin;
                d10 = cos;
                i2++;
                d7 = d5;
                d8 = d6;
            }
            this.mArcDistance = d11;
            for (int i3 = 0; i3 < sOurPercent.length; i3++) {
                double[] dArr = sOurPercent;
                dArr[i3] = dArr[i3] / d11;
            }
            int i4 = 0;
            while (i4 < this.mLut.length) {
                double length = i4 / (this.mLut.length - 1);
                int binarySearch = Arrays.binarySearch(sOurPercent, length);
                if (binarySearch >= 0) {
                    this.mLut[i4] = binarySearch / (sOurPercent.length - 1);
                    i = i4;
                } else if (binarySearch == -1) {
                    this.mLut[i4] = 0.0d;
                    i = i4;
                } else {
                    int i5 = (-binarySearch) - 2;
                    i = i4;
                    this.mLut[i] = (i5 + ((length - sOurPercent[i5]) / (sOurPercent[(-binarySearch) - 1] - sOurPercent[i5]))) / (sOurPercent.length - 1);
                }
                i4 = i + 1;
            }
        }

        double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d) * hypot : d * hypot;
        }

        double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d2 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, d2);
            return this.mVertical ? (-d2) * hypot : d2 * hypot;
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d) {
            return this.mX1 + ((this.mX2 - this.mX1) * (d - this.mTime1) * this.mOneOverDeltaTime);
        }

        public double getLinearY(double d) {
            return this.mY1 + ((this.mY2 - this.mY1) * (d - this.mTime1) * this.mOneOverDeltaTime);
        }

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        double lookup(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double length = (this.mLut.length - 1) * d;
            int i = (int) length;
            return this.mLut[i] + ((this.mLut[i + 1] - this.mLut[i]) * (length - ((int) length)));
        }

        void setPoint(double d) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (i3 < this.mArcs.length) {
            switch (iArr[i3]) {
                case 0:
                    r7 = 3;
                    break;
                case 1:
                    i2 = 1;
                    r7 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    r7 = i2 != 1 ? 1 : 2;
                    i2 = r7;
                    break;
                case 4:
                    r7 = 4;
                    break;
                case 5:
                    r7 = 5;
                    break;
                default:
                    r7 = i;
                    break;
            }
            this.mArcs[i3] = new Arc(r7, dArr[i3], dArr[i3 + 1], dArr2[i3][0], dArr2[i3][1], dArr2[i3 + 1][0], dArr2[i3 + 1][1]);
            i3++;
            i = r7;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        if (this.mExtrapolate) {
            if (d < this.mArcs[0].mTime1) {
                double d2 = this.mArcs[0].mTime1;
                double d3 = d - this.mArcs[0].mTime1;
                if (this.mArcs[0].mLinear) {
                    return i == 0 ? this.mArcs[0].getLinearX(d2) + (this.mArcs[0].getLinearDX(d2) * d3) : this.mArcs[0].getLinearY(d2) + (this.mArcs[0].getLinearDY(d2) * d3);
                }
                this.mArcs[0].setPoint(d2);
                return i == 0 ? this.mArcs[0].getX() + (this.mArcs[0].getDX() * d3) : this.mArcs[0].getY() + (this.mArcs[0].getDY() * d3);
            }
            if (d > this.mArcs[this.mArcs.length - 1].mTime2) {
                double d4 = this.mArcs[this.mArcs.length - 1].mTime2;
                double d5 = d - d4;
                int length = this.mArcs.length - 1;
                return i == 0 ? this.mArcs[length].getLinearX(d4) + (this.mArcs[length].getLinearDX(d4) * d5) : this.mArcs[length].getLinearY(d4) + (this.mArcs[length].getLinearDY(d4) * d5);
            }
        } else if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else if (d > this.mArcs[this.mArcs.length - 1].mTime2) {
            d = this.mArcs[this.mArcs.length - 1].mTime2;
        }
        for (int i2 = 0; i2 < this.mArcs.length; i2++) {
            if (d <= this.mArcs[i2].mTime2) {
                if (this.mArcs[i2].mLinear) {
                    return i == 0 ? this.mArcs[i2].getLinearX(d) : this.mArcs[i2].getLinearY(d);
                }
                this.mArcs[i2].setPoint(d);
                return i == 0 ? this.mArcs[i2].getX() : this.mArcs[i2].getY();
            }
        }
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        if (!this.mExtrapolate) {
            if (d < this.mArcs[0].mTime1) {
                d = this.mArcs[0].mTime1;
            }
            if (d > this.mArcs[this.mArcs.length - 1].mTime2) {
                d = this.mArcs[this.mArcs.length - 1].mTime2;
            }
        } else {
            if (d < this.mArcs[0].mTime1) {
                double d2 = this.mArcs[0].mTime1;
                double d3 = d - this.mArcs[0].mTime1;
                if (this.mArcs[0].mLinear) {
                    dArr[0] = this.mArcs[0].getLinearX(d2) + (this.mArcs[0].getLinearDX(d2) * d3);
                    dArr[1] = this.mArcs[0].getLinearY(d2) + (this.mArcs[0].getLinearDY(d2) * d3);
                    return;
                } else {
                    this.mArcs[0].setPoint(d2);
                    dArr[0] = this.mArcs[0].getX() + (this.mArcs[0].getDX() * d3);
                    dArr[1] = this.mArcs[0].getY() + (this.mArcs[0].getDY() * d3);
                    return;
                }
            }
            if (d > this.mArcs[this.mArcs.length - 1].mTime2) {
                double d4 = this.mArcs[this.mArcs.length - 1].mTime2;
                double d5 = d - d4;
                int length = this.mArcs.length - 1;
                if (this.mArcs[length].mLinear) {
                    dArr[0] = this.mArcs[length].getLinearX(d4) + (this.mArcs[length].getLinearDX(d4) * d5);
                    dArr[1] = this.mArcs[length].getLinearY(d4) + (this.mArcs[length].getLinearDY(d4) * d5);
                    return;
                } else {
                    this.mArcs[length].setPoint(d);
                    dArr[0] = this.mArcs[length].getX() + (this.mArcs[length].getDX() * d5);
                    dArr[1] = this.mArcs[length].getY() + (this.mArcs[length].getDY() * d5);
                    return;
                }
            }
        }
        for (int i = 0; i < this.mArcs.length; i++) {
            if (d <= this.mArcs[i].mTime2) {
                if (this.mArcs[i].mLinear) {
                    dArr[0] = this.mArcs[i].getLinearX(d);
                    dArr[1] = this.mArcs[i].getLinearY(d);
                    return;
                } else {
                    this.mArcs[i].setPoint(d);
                    dArr[0] = this.mArcs[i].getX();
                    dArr[1] = this.mArcs[i].getY();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        if (this.mExtrapolate) {
            if (d < this.mArcs[0].mTime1) {
                double d2 = this.mArcs[0].mTime1;
                double d3 = d - this.mArcs[0].mTime1;
                if (this.mArcs[0].mLinear) {
                    fArr[0] = (float) (this.mArcs[0].getLinearX(d2) + (this.mArcs[0].getLinearDX(d2) * d3));
                    fArr[1] = (float) (this.mArcs[0].getLinearY(d2) + (this.mArcs[0].getLinearDY(d2) * d3));
                    return;
                } else {
                    this.mArcs[0].setPoint(d2);
                    fArr[0] = (float) (this.mArcs[0].getX() + (this.mArcs[0].getDX() * d3));
                    fArr[1] = (float) (this.mArcs[0].getY() + (this.mArcs[0].getDY() * d3));
                    return;
                }
            }
            if (d > this.mArcs[this.mArcs.length - 1].mTime2) {
                double d4 = this.mArcs[this.mArcs.length - 1].mTime2;
                double d5 = d - d4;
                int length = this.mArcs.length - 1;
                if (this.mArcs[length].mLinear) {
                    fArr[0] = (float) (this.mArcs[length].getLinearX(d4) + (this.mArcs[length].getLinearDX(d4) * d5));
                    fArr[1] = (float) (this.mArcs[length].getLinearY(d4) + (this.mArcs[length].getLinearDY(d4) * d5));
                    return;
                } else {
                    this.mArcs[length].setPoint(d);
                    fArr[0] = (float) this.mArcs[length].getX();
                    fArr[1] = (float) this.mArcs[length].getY();
                    return;
                }
            }
        } else if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else if (d > this.mArcs[this.mArcs.length - 1].mTime2) {
            d = this.mArcs[this.mArcs.length - 1].mTime2;
        }
        for (int i = 0; i < this.mArcs.length; i++) {
            if (d <= this.mArcs[i].mTime2) {
                if (this.mArcs[i].mLinear) {
                    fArr[0] = (float) this.mArcs[i].getLinearX(d);
                    fArr[1] = (float) this.mArcs[i].getLinearY(d);
                    return;
                } else {
                    this.mArcs[i].setPoint(d);
                    fArr[0] = (float) this.mArcs[i].getX();
                    fArr[1] = (float) this.mArcs[i].getY();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        }
        if (d > this.mArcs[this.mArcs.length - 1].mTime2) {
            d = this.mArcs[this.mArcs.length - 1].mTime2;
        }
        for (int i2 = 0; i2 < this.mArcs.length; i2++) {
            if (d <= this.mArcs[i2].mTime2) {
                if (this.mArcs[i2].mLinear) {
                    return i == 0 ? this.mArcs[i2].getLinearDX(d) : this.mArcs[i2].getLinearDY(d);
                }
                this.mArcs[i2].setPoint(d);
                return i == 0 ? this.mArcs[i2].getDX() : this.mArcs[i2].getDY();
            }
        }
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else if (d > this.mArcs[this.mArcs.length - 1].mTime2) {
            d = this.mArcs[this.mArcs.length - 1].mTime2;
        }
        for (int i = 0; i < this.mArcs.length; i++) {
            if (d <= this.mArcs[i].mTime2) {
                if (this.mArcs[i].mLinear) {
                    dArr[0] = this.mArcs[i].getLinearDX(d);
                    dArr[1] = this.mArcs[i].getLinearDY(d);
                    return;
                } else {
                    this.mArcs[i].setPoint(d);
                    dArr[0] = this.mArcs[i].getDX();
                    dArr[1] = this.mArcs[i].getDY();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }
}
