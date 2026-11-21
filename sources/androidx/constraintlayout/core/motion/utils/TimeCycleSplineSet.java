package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float sVal2PI = 6.2831855f;
    protected int mCount;
    protected CurveFit mCurveFit;
    protected long mLastTime;
    protected String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    protected float[] mCache = new float[3];
    protected boolean mContinue = false;
    protected float mLastCycle = Float.NaN;

    /* loaded from: classes.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int i, CustomAttribute customAttribute, float f, int i2, float f2) {
            this.mConstraintAttributeList.append(i, customAttribute);
            this.mWaveProperties.append(i, new float[]{f, f2});
            this.mWaveShape = Math.max(this.mWaveShape, i2);
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float f2 = this.mTempValues[this.mTempValues.length - 2];
            float f3 = this.mTempValues[this.mTempValues.length - 1];
            long j2 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                this.mLastCycle = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                if (Float.isNaN(this.mLastCycle)) {
                    this.mLastCycle = 0.0f;
                }
            }
            this.mLastCycle = (float) ((this.mLastCycle + ((j2 * 1.0E-9d) * f2)) % 1.0d);
            this.mLastTime = j;
            float calcWave = calcWave(this.mLastCycle);
            this.mContinue = false;
            for (int i = 0; i < this.mCustomCache.length; i++) {
                this.mContinue |= ((double) this.mTempValues[i]) != 0.0d;
                this.mCustomCache[i] = (this.mTempValues[i] * calcWave) + f3;
            }
            motionWidget.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCustomCache);
            if (f2 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues + 2];
            this.mCustomCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues + 2);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i2);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i2);
                float[] valueAt2 = this.mWaveProperties.valueAt(i2);
                dArr[i2] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                for (int i3 = 0; i3 < this.mTempValues.length; i3++) {
                    dArr2[i2][i3] = this.mTempValues[i3];
                }
                dArr2[i2][numberOfInterpolatedValues] = valueAt2[0];
                dArr2[i2][numberOfInterpolatedValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }
    }

    /* loaded from: classes.dex */
    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int i, CustomVariable customVariable, float f, int i2, float f2) {
            this.mConstraintAttributeList.append(i, customVariable);
            this.mWaveProperties.append(i, new float[]{f, f2});
            this.mWaveShape = Math.max(this.mWaveShape, i2);
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float f2 = this.mTempValues[this.mTempValues.length - 2];
            float f3 = this.mTempValues[this.mTempValues.length - 1];
            long j2 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                this.mLastCycle = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                if (Float.isNaN(this.mLastCycle)) {
                    this.mLastCycle = 0.0f;
                }
            }
            this.mLastCycle = (float) ((this.mLastCycle + ((j2 * 1.0E-9d) * f2)) % 1.0d);
            this.mLastTime = j;
            float calcWave = calcWave(this.mLastCycle);
            this.mContinue = false;
            for (int i = 0; i < this.mCustomCache.length; i++) {
                this.mContinue |= ((double) this.mTempValues[i]) != 0.0d;
                this.mCustomCache[i] = (this.mTempValues[i] * calcWave) + f3;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mCustomCache);
            if (f2 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues + 2];
            this.mCustomCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues + 2);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i2);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i2);
                float[] valueAt2 = this.mWaveProperties.valueAt(i2);
                dArr[i2] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                for (int i3 = 0; i3 < this.mTempValues.length; i3++) {
                    dArr2[i2][i3] = this.mTempValues[i3];
                }
                dArr2[i2][numberOfInterpolatedValues] = valueAt2[0];
                dArr2[i2][numberOfInterpolatedValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }
    }

    /* loaded from: classes.dex */
    protected static class Sort {
        protected Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[][] fArr, int i, int i2) {
            int[] iArr2 = new int[iArr.length + 10];
            int i3 = 0 + 1;
            iArr2[0] = i2;
            int i4 = i3 + 1;
            iArr2[i3] = i;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int partition = partition(iArr, fArr, i6, i7);
                    int i8 = i4 + 1;
                    iArr2[i4] = partition - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i4 = i10 + 1;
                    iArr2[i10] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            for (int i5 = i; i5 < i2; i5++) {
                if (iArr[i5] <= i3) {
                    swap(iArr, fArr, i4, i5);
                    i4++;
                }
            }
            swap(iArr, fArr, i4, i2);
            return i4;
        }

        private static void swap(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float[] fArr2 = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = fArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float calcWave(float f) {
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(sVal2PI * f);
            case 2:
                return 1.0f - Math.abs(f);
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((f * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(sVal2PI * f);
            case 6:
                float abs = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (abs * abs);
            default:
                return (float) Math.sin(sVal2PI * f);
        }
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i, float f, float f2, int i2, float f3) {
        this.mTimePoints[this.mCount] = i;
        this.mValues[this.mCount][0] = f;
        this.mValues[this.mCount][1] = f2;
        this.mValues[this.mCount][2] = f3;
        this.mWaveShape = Math.max(this.mWaveShape, i2);
        this.mCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStartTime(long j) {
        this.mLastTime = j;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i) {
        if (this.mCount == 0) {
            System.err.println("Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, this.mCount - 1);
        int i2 = 0;
        for (int i3 = 1; i3 < this.mTimePoints.length; i3++) {
            if (this.mTimePoints[i3] != this.mTimePoints[i3 - 1]) {
                i2++;
            }
        }
        if (i2 == 0) {
            i2 = 1;
        }
        double[] dArr = new double[i2];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i2, 3);
        int i4 = 0;
        for (int i5 = 0; i5 < this.mCount; i5++) {
            if (i5 <= 0 || this.mTimePoints[i5] != this.mTimePoints[i5 - 1]) {
                dArr[i4] = this.mTimePoints[i5] * 0.01d;
                dArr2[i4][0] = this.mValues[i5][0];
                dArr2[i4][1] = this.mValues[i5][1];
                dArr2[i4][2] = this.mValues[i5][2];
                i4++;
            }
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.mCount; i++) {
            str = str + "[" + this.mTimePoints[i] + " , " + decimalFormat.format(this.mValues[i]) + "] ";
        }
        return str;
    }
}
