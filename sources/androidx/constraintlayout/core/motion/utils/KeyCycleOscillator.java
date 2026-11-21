package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* renamed from: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Comparator<WavePoint> {
        AnonymousClass1() {
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(WavePoint wavePoint, WavePoint wavePoint2) {
            return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(WavePoint wavePoint, WavePoint wavePoint2) {
            return compare2(wavePoint, wavePoint2);
        }
    }

    /* loaded from: classes.dex */
    private static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = TypedValues.CycleType.getId(this.mType);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.mTypeId, get(f));
        }
    }

    /* loaded from: classes.dex */
    static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        float mPathLength;
        float[] mPeriod;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;
        Oscillator mOscillator = new Oscillator();
        private final int mOffst = 0;
        private final int mPhase = 1;
        private final int mValue = 2;

        CycleOscillator(int i, String str, int i2, int i3) {
            this.mWaveShape = i;
            this.mVariesBy = i2;
            this.mOscillator.setType(i, str);
            this.mValues = new float[i3];
            this.mPosition = new double[i3];
            this.mPeriod = new float[i3];
            this.mOffsetArr = new float[i3];
            this.mPhaseArr = new float[i3];
            this.mScale = new float[i3];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f) {
            if (this.mCurveFit != null) {
                this.mCurveFit.getSlope(f, this.mSplineSlopeCache);
                this.mCurveFit.getPos(f, this.mSplineValueCache);
            } else {
                this.mSplineSlopeCache[0] = 0.0d;
                this.mSplineSlopeCache[1] = 0.0d;
                this.mSplineSlopeCache[2] = 0.0d;
            }
            return this.mSplineSlopeCache[0] + (this.mSplineSlopeCache[2] * this.mOscillator.getValue(f, this.mSplineValueCache[1])) + (this.mSplineValueCache[2] * this.mOscillator.getSlope(f, this.mSplineValueCache[1], this.mSplineSlopeCache[1]));
        }

        public double getValues(float f) {
            if (this.mCurveFit != null) {
                this.mCurveFit.getPos(f, this.mSplineValueCache);
            } else {
                this.mSplineValueCache[0] = this.mOffsetArr[0];
                this.mSplineValueCache[1] = this.mPhaseArr[0];
                this.mSplineValueCache[2] = this.mValues[0];
            }
            double d = this.mSplineValueCache[0];
            double[] dArr = this.mSplineValueCache;
            Objects.requireNonNull(this);
            return (this.mSplineValueCache[2] * this.mOscillator.getValue(f, dArr[1])) + d;
        }

        public void setPoint(int i, int i2, float f, float f2, float f3, float f4) {
            this.mPosition[i] = i2 / 100.0d;
            this.mPeriod[i] = f;
            this.mOffsetArr[i] = f2;
            this.mPhaseArr[i] = f3;
            this.mValues[i] = f4;
        }

        public void setup(float f) {
            this.mPathLength = f;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            this.mSplineValueCache = new double[this.mValues.length + 2];
            this.mSplineSlopeCache = new double[this.mValues.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            int length = this.mPosition.length - 1;
            if (this.mPosition[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i = 0; i < dArr.length; i++) {
                dArr[i][0] = this.mOffsetArr[i];
                dArr[i][1] = this.mPhaseArr[i];
                dArr[i][2] = this.mValues[i];
                this.mOscillator.addPoint(this.mPosition[i], this.mPeriod[i]);
            }
            this.mOscillator.normalize();
            if (this.mPosition.length > 1) {
                this.mCurveFit = CurveFit.get(0, this.mPosition, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = TypedValues.CycleType.getId(this.mType);
        }

        public void setPathRotate(MotionWidget motionWidget, float f, double d, double d2) {
            motionWidget.setRotationZ(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.mTypeId, get(f));
        }
    }

    /* loaded from: classes.dex */
    static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        WavePoint(int i, float f, float f2, float f3, float f4) {
            this.mPosition = i;
            this.mValue = f4;
            this.mOffset = f2;
            this.mPeriod = f;
            this.mPhase = f3;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f) {
        return (float) this.mCycleOscillator.getValues(f);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCycleOscillator.getSlope(f);
    }

    protected void setCustom(Object obj) {
    }

    public void setPoint(int i, int i2, String str, int i3, float f, float f2, float f3, float f4) {
        this.mWavePoints.add(new WavePoint(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.mWaveShape = i2;
        this.mWaveString = str;
    }

    public void setPoint(int i, int i2, String str, int i3, float f, float f2, float f3, float f4, Object obj) {
        this.mWavePoints.add(new WavePoint(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.mWaveShape = i2;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f) {
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new AnonymousClass1());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        int i = 0;
        while (it.hasNext()) {
            WavePoint next = it.next();
            dArr[i] = next.mPeriod * 0.01d;
            dArr2[i][0] = next.mValue;
            dArr2[i][1] = next.mOffset;
            dArr2[i][2] = next.mPhase;
            this.mCycleOscillator.setPoint(i, next.mPosition, next.mPeriod, next.mOffset, next.mPhase, next.mValue);
            i++;
        }
        this.mCycleOscillator.setup(f);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().mPosition + " , " + decimalFormat.format(r3.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }
}
