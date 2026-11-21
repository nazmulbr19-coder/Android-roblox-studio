package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Motion implements TypedValues {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    public String mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private MotionKeyTrigger[] mKeyTriggers;
    Motion mRelativeMotion;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    MotionWidget mView;
    Rect mTempRect = new Rect();
    private int mCurveFitType = 0;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int mMaxDimension = 4;
    private float[] mValuesBuff = new float[this.mMaxDimension];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private int mPathMotionArc = -1;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private int mQuantizeMotionSteps = -1;
    private float mQuantizeMotionPhase = Float.NaN;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private boolean mNoMovement = false;

    /* renamed from: androidx.constraintlayout.core.motion.Motion$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements DifferentialInterpolator {
        float mX;
        final /* synthetic */ Easing val$easing;

        AnonymousClass1(Easing easing) {
            this.val$easing = easing;
        }

        @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
        public float getInterpolation(float f) {
            this.mX = f;
            return (float) this.val$easing.get(f);
        }

        @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
        public float getVelocity() {
            return (float) this.val$easing.getDiff(this.mX);
        }
    }

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else if (this.mStaggerScale != 1.0d) {
            if (f < this.mStaggerOffset) {
                f = 0.0f;
            }
            if (f > this.mStaggerOffset && f < 1.0d) {
                f = Math.min((f - this.mStaggerOffset) * this.mStaggerScale, 1.0f);
            }
        }
        float f2 = f;
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float f3 = 0.0f;
        float f4 = Float.NaN;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (next.mKeyFrameEasing != null) {
                if (next.mTime < f) {
                    easing = next.mKeyFrameEasing;
                    f3 = next.mTime;
                } else if (Float.isNaN(f4)) {
                    f4 = next.mTime;
                }
            }
        }
        if (easing != null) {
            if (Float.isNaN(f4)) {
                f4 = 1.0f;
            }
            float f5 = (f - f3) / (f4 - f3);
            f2 = ((f4 - f3) * ((float) easing.get(f5))) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(f5);
            }
        }
        return f2;
    }

    private static DifferentialInterpolator getInterpolator(int i, String str, int i2) {
        switch (i) {
            case -1:
                return new AnonymousClass1(Easing.getInterpolator(str));
            default:
                return null;
        }
    }

    private float getPreCycleDistance() {
        float f;
        float f2;
        char c;
        int i = 100;
        float[] fArr = new float[2];
        float f3 = 0.0f;
        float f4 = 1.0f / (100 - 1);
        double d = 0.0d;
        double d2 = 0.0d;
        int i2 = 0;
        while (i2 < i) {
            float f5 = i2 * f4;
            double d3 = f5;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f6 = Float.NaN;
            int i3 = i;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f7 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Iterator<MotionPaths> it2 = it;
                if (next.mKeyFrameEasing != null) {
                    if (next.mTime < f5) {
                        Easing easing2 = next.mKeyFrameEasing;
                        f7 = next.mTime;
                        easing = easing2;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.mTime;
                    }
                }
                it = it2;
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                f = f3;
                f2 = f5;
                d3 = ((f6 - f7) * ((float) easing.get((f5 - f7) / (f6 - f7)))) + f7;
            } else {
                f = f3;
                f2 = f5;
            }
            this.mSpline[0].getPos(d3, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d3, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i2 > 0) {
                c = 1;
                f += (float) Math.hypot(d2 - fArr[1], d - fArr[0]);
            } else {
                c = 1;
            }
            d = fArr[0];
            d2 = fArr[c];
            i2++;
            i = i3;
            f3 = f;
        }
        return f3;
    }

    private void insertKey(MotionPaths motionPaths) {
        MotionPaths motionPaths2 = null;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (motionPaths.mPosition == next.mPosition) {
                motionPaths2 = next;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-r1) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    private void setupRelative() {
        if (this.mRelativeMotion == null) {
            return;
        }
        this.mStartMotionPath.setupRelative(this.mRelativeMotion, this.mRelativeMotion.mStartMotionPath);
        this.mEndMotionPath.setupRelative(this.mRelativeMotion, this.mRelativeMotion.mEndMotionPath);
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    void buildBounds(float[] fArr, int i) {
        float f;
        Motion motion = this;
        int i2 = i;
        float f2 = 1.0f;
        float f3 = 1.0f / (i2 - 1);
        SplineSet splineSet = motion.mAttributesMap == null ? null : motion.mAttributesMap.get("translationX");
        if (motion.mAttributesMap != null) {
            motion.mAttributesMap.get("translationY");
        }
        if (motion.mCycleMap != null) {
            motion.mCycleMap.get("translationX");
        }
        if (motion.mCycleMap != null) {
            motion.mCycleMap.get("translationY");
        }
        int i3 = 0;
        while (i3 < i2) {
            float f4 = i3 * f3;
            if (motion.mStaggerScale != f2) {
                if (f4 < motion.mStaggerOffset) {
                    f4 = 0.0f;
                }
                if (f4 > motion.mStaggerOffset && f4 < 1.0d) {
                    f4 = Math.min((f4 - motion.mStaggerOffset) * motion.mStaggerScale, f2);
                }
            }
            double d = f4;
            Easing easing = motion.mStartMotionPath.mKeyFrameEasing;
            float f5 = 0.0f;
            float f6 = Float.NaN;
            Iterator<MotionPaths> it = motion.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                if (next.mKeyFrameEasing != null) {
                    if (next.mTime < f4) {
                        Easing easing2 = next.mKeyFrameEasing;
                        f5 = next.mTime;
                        easing = easing2;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                f = f3;
                d = ((f6 - f5) * ((float) easing.get((f4 - f5) / (f6 - f5)))) + f5;
            } else {
                f = f3;
            }
            motion.mSpline[0].getPos(d, motion.mInterpolateData);
            if (motion.mArcSpline != null && motion.mInterpolateData.length > 0) {
                motion.mArcSpline.getPos(d, motion.mInterpolateData);
            }
            motion.mStartMotionPath.getBounds(motion.mInterpolateVariables, motion.mInterpolateData, fArr, i3 * 2);
            i3++;
            motion = this;
            i2 = i;
            f3 = f;
            splineSet = splineSet;
            f2 = 1.0f;
        }
    }

    int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        int i = 0;
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                iArr[i] = it.next().mMode;
                i++;
            }
            i = 0;
        }
        for (double d : timePoints) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
            i += 2;
        }
        return i / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        int i = 0;
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                iArr[i] = it.next().mMode;
                i++;
            }
            i = 0;
        }
        if (iArr2 != null) {
            Iterator<MotionPaths> it2 = this.mMotionPaths.iterator();
            while (it2.hasNext()) {
                iArr2[i] = (int) (it2.next().mPosition * 100.0f);
                i++;
            }
            i = 0;
        }
        int i2 = i;
        for (int i3 = 0; i3 < timePoints.length; i3++) {
            this.mSpline[0].getPos(timePoints[i3], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i3], this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    public void buildPath(float[] fArr, int i) {
        float f;
        int i2 = i;
        float f2 = 1.0f;
        float f3 = 1.0f / (i2 - 1);
        SplineSet splineSet = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationX");
        SplineSet splineSet2 = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationY");
        KeyCycleOscillator keyCycleOscillator = this.mCycleMap == null ? null : this.mCycleMap.get("translationX");
        KeyCycleOscillator keyCycleOscillator2 = this.mCycleMap != null ? this.mCycleMap.get("translationY") : null;
        int i3 = 0;
        while (i3 < i2) {
            float f4 = i3 * f3;
            if (this.mStaggerScale != f2) {
                if (f4 < this.mStaggerOffset) {
                    f4 = 0.0f;
                }
                if (f4 > this.mStaggerOffset && f4 < 1.0d) {
                    f4 = Math.min((f4 - this.mStaggerOffset) * this.mStaggerScale, f2);
                }
            }
            double d = f4;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f5 = 0.0f;
            float f6 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                if (next.mKeyFrameEasing != null) {
                    if (next.mTime < f4) {
                        Easing easing2 = next.mKeyFrameEasing;
                        f5 = next.mTime;
                        easing = easing2;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                f = f3;
                d = ((f6 - f5) * ((float) easing.get((f4 - f5) / (f6 - f5)))) + f5;
            } else {
                f = f3;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
                this.mArcSpline.getPos(d, this.mInterpolateData);
            }
            this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 2);
            if (keyCycleOscillator != null) {
                int i4 = i3 * 2;
                fArr[i4] = fArr[i4] + keyCycleOscillator.get(f4);
            } else if (splineSet != null) {
                int i5 = i3 * 2;
                fArr[i5] = fArr[i5] + splineSet.get(f4);
            }
            if (keyCycleOscillator2 != null) {
                int i6 = (i3 * 2) + 1;
                fArr[i6] = fArr[i6] + keyCycleOscillator2.get(f4);
            } else if (splineSet2 != null) {
                int i7 = (i3 * 2) + 1;
                fArr[i7] = fArr[i7] + splineSet2.get(f4);
            }
            i3++;
            i2 = i;
            f3 = f;
            f2 = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i) {
        this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
    }

    void buildRectangles(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            this.mSpline[0].getPos(getAdjustedPosition(i2 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 8);
        }
    }

    void endTrigger(boolean z) {
    }

    public String getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    int getAttributeValues(String str, float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = splineSet.get(i2 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d, dArr);
        this.mSpline[0].getSlope(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f, float f2, float f3, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        if (this.mSpline == null) {
            float f4 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
            float f5 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
            float f6 = this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth;
            float f7 = this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight;
            fArr[0] = ((1.0f - f2) * f4) + ((f4 + f6) * f2);
            fArr[1] = ((1.0f - f3) * f5) + ((f5 + f7) * f3);
            return;
        }
        this.mSpline[0].getSlope(adjustedPosition, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition, this.mInterpolateData);
        float f8 = this.mVelocity[0];
        for (int i = 0; i < this.mInterpolateVelocity.length; i++) {
            double[] dArr = this.mInterpolateVelocity;
            dArr[i] = dArr[i] * f8;
        }
        if (this.mArcSpline == null) {
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        } else if (this.mInterpolateData.length > 0) {
            this.mArcSpline.getPos(adjustedPosition, this.mInterpolateData);
            this.mArcSpline.getSlope(adjustedPosition, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int i = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i = Math.max(i, it.next().mDrawPath);
        }
        return Math.max(i, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        int i2 = 0;
        int i3 = 0;
        float[] fArr = new float[2];
        Iterator<MotionKey> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            MotionKey next = it.next();
            if (next.mType == i || i != -1) {
                int i4 = i3;
                iArr[i3] = 0;
                int i5 = i3 + 1;
                iArr[i5] = next.mType;
                int i6 = i5 + 1;
                iArr[i6] = next.mFramePosition;
                float f = next.mFramePosition / 100.0f;
                this.mSpline[0].getPos(f, this.mInterpolateData);
                this.mStartMotionPath.getCenter(f, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i7 = i6 + 1;
                iArr[i7] = Float.floatToIntBits(fArr[0]);
                int i8 = i7 + 1;
                iArr[i8] = Float.floatToIntBits(fArr[1]);
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    int i9 = i8 + 1;
                    iArr[i9] = motionKeyPosition.mPositionType;
                    int i10 = i9 + 1;
                    iArr[i10] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i8 = i10 + 1;
                    iArr[i8] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                i3 = i8 + 1;
                iArr[i4] = i3 - i4;
                i2++;
            }
        }
        return i2;
    }

    float getKeyFrameParameter(int i, float f, float f2) {
        float f3 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
        float f4 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
        float f5 = this.mStartMotionPath.mX + (this.mStartMotionPath.mWidth / 2.0f);
        float f6 = this.mStartMotionPath.mY + (this.mStartMotionPath.mHeight / 2.0f);
        float hypot = (float) Math.hypot(f3, f4);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f7 = f - f5;
        float f8 = f2 - f6;
        if (((float) Math.hypot(f7, f8)) == 0.0f) {
            return 0.0f;
        }
        float f9 = (f7 * f3) + (f8 * f4);
        switch (i) {
            case 0:
                return f9 / hypot;
            case 1:
                return (float) Math.sqrt((hypot * hypot) - (f9 * f9));
            case 2:
                return f7 / f3;
            case 3:
                return f8 / f3;
            case 4:
                return f7 / f4;
            case 5:
                return f8 / f4;
            default:
                return 0.0f;
        }
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        int i = 0;
        Iterator<MotionKey> it = this.mKeyList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            int i3 = i + 1;
            iArr[i] = next.mFramePosition + (next.mType * 1000);
            float f = next.mFramePosition / 100.0f;
            this.mSpline[0].getPos(f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(f, this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
            i = i3;
        }
        return i;
    }

    public float getMotionStagger() {
        return this.mMotionStagger;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double[] getPos(double d) {
        this.mSpline[0].getPos(d, this.mInterpolateData);
        if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
            this.mArcSpline.getPos(d, this.mInterpolateData);
        }
        return this.mInterpolateData;
    }

    MotionKeyPosition getPositionKeyframe(int i, int i2, float f, float f2) {
        int i3;
        int i4;
        float f3;
        float f4;
        FloatRect floatRect = new FloatRect();
        floatRect.left = this.mStartMotionPath.mX;
        floatRect.top = this.mStartMotionPath.mY;
        floatRect.right = floatRect.left + this.mStartMotionPath.mWidth;
        floatRect.bottom = floatRect.top + this.mStartMotionPath.mHeight;
        FloatRect floatRect2 = new FloatRect();
        floatRect2.left = this.mEndMotionPath.mX;
        floatRect2.top = this.mEndMotionPath.mY;
        floatRect2.right = floatRect2.left + this.mEndMotionPath.mWidth;
        floatRect2.bottom = floatRect2.top + this.mEndMotionPath.mHeight;
        Iterator<MotionKey> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            MotionKey next = it.next();
            if (next instanceof MotionKeyPosition) {
                i3 = i;
                i4 = i2;
                f3 = f;
                f4 = f2;
                if (((MotionKeyPosition) next).intersects(i3, i4, floatRect, floatRect2, f3, f4)) {
                    return (MotionKeyPosition) next;
                }
            } else {
                i3 = i;
                i4 = i2;
                f3 = f;
                f4 = f2;
            }
            i = i3;
            i2 = i4;
            f = f3;
            f2 = f4;
        }
        return null;
    }

    void getPostLayoutDvDp(float f, int i, int i2, float f2, float f3, float[] fArr) {
        VelocityMatrix velocityMatrix;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        SplineSet splineSet = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationX");
        SplineSet splineSet2 = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationY");
        SplineSet splineSet3 = this.mAttributesMap == null ? null : this.mAttributesMap.get("rotationZ");
        SplineSet splineSet4 = this.mAttributesMap == null ? null : this.mAttributesMap.get("scaleX");
        SplineSet splineSet5 = this.mAttributesMap == null ? null : this.mAttributesMap.get("scaleY");
        KeyCycleOscillator keyCycleOscillator = this.mCycleMap == null ? null : this.mCycleMap.get("translationX");
        KeyCycleOscillator keyCycleOscillator2 = this.mCycleMap == null ? null : this.mCycleMap.get("translationY");
        KeyCycleOscillator keyCycleOscillator3 = this.mCycleMap == null ? null : this.mCycleMap.get("rotationZ");
        KeyCycleOscillator keyCycleOscillator4 = this.mCycleMap == null ? null : this.mCycleMap.get("scaleX");
        KeyCycleOscillator keyCycleOscillator5 = this.mCycleMap != null ? this.mCycleMap.get("scaleY") : null;
        VelocityMatrix velocityMatrix2 = new VelocityMatrix();
        velocityMatrix2.clear();
        velocityMatrix2.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix2.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix2.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix2.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix2.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix2.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        if (this.mArcSpline != null) {
            if (this.mInterpolateData.length > 0) {
                velocityMatrix = velocityMatrix2;
                this.mArcSpline.getPos(adjustedPosition, this.mInterpolateData);
                this.mArcSpline.getSlope(adjustedPosition, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            } else {
                velocityMatrix = velocityMatrix2;
            }
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
            return;
        }
        if (this.mSpline != null) {
            float adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f4 = this.mVelocity[0];
            int i3 = 0;
            while (i3 < this.mInterpolateVelocity.length) {
                double[] dArr = this.mInterpolateVelocity;
                int i4 = i3;
                dArr[i4] = dArr[i3] * f4;
                i3 = i4 + 1;
            }
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            velocityMatrix2.applyTransform(f2, f3, i, i2, fArr);
            return;
        }
        float f5 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
        float f6 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
        float f7 = this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth;
        float f8 = f6 + (this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight);
        fArr[0] = ((1.0f - f2) * f5) + ((f5 + f7) * f2);
        fArr[1] = ((1.0f - f3) * f6) + (f8 * f3);
        velocityMatrix2.clear();
        velocityMatrix2.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix2.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix2.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix2.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix2.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix2.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        velocityMatrix2.applyTransform(f2, f3, i, i2, fArr);
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
        float f2;
        MotionWidget motionWidget2 = motionWidget;
        float adjustedPosition = getAdjustedPosition(f, null);
        if (this.mQuantizeMotionSteps != -1) {
            float f3 = 1.0f / this.mQuantizeMotionSteps;
            float floor = ((float) Math.floor(adjustedPosition / f3)) * f3;
            float f4 = (adjustedPosition % f3) / f3;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f4 = (this.mQuantizeMotionPhase + f4) % 1.0f;
            }
            f2 = ((this.mQuantizeMotionInterpolator != null ? this.mQuantizeMotionInterpolator.getInterpolation(f4) : ((double) f4) > 0.5d ? 1.0f : 0.0f) * f3) + floor;
        } else {
            f2 = adjustedPosition;
        }
        if (this.mAttributesMap != null) {
            Iterator<SplineSet> it = this.mAttributesMap.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(motionWidget2, f2);
            }
        }
        if (this.mSpline != null) {
            this.mSpline[0].getPos(f2, this.mInterpolateData);
            this.mSpline[0].getSlope(f2, this.mInterpolateVelocity);
            if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
                this.mArcSpline.getPos(f2, this.mInterpolateData);
                this.mArcSpline.getSlope(f2, this.mInterpolateVelocity);
            }
            if (!this.mNoMovement) {
                float f5 = f2;
                this.mStartMotionPath.setView(f5, motionWidget2, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
                f2 = f5;
                motionWidget2 = motionWidget2;
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget2.getParent().findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float top = (this.mTransformPivotView.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
                    float left = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
                    if (motionWidget2.getRight() - motionWidget2.getLeft() > 0 && motionWidget2.getBottom() - motionWidget2.getTop() > 0) {
                        motionWidget2.setPivotX(left - motionWidget2.getLeft());
                        motionWidget2.setPivotY(top - motionWidget2.getTop());
                    }
                }
            }
            for (int i = 1; i < this.mSpline.length; i++) {
                this.mSpline[i].getPos(f2, this.mValuesBuff);
                this.mStartMotionPath.mCustomAttributes.get(this.mAttributeNames[i - 1]).setInterpolatedValue(motionWidget2, this.mValuesBuff);
            }
            if (this.mStartPoint.mVisibilityMode == 0) {
                if (f2 <= 0.0f) {
                    motionWidget2.setVisibility(this.mStartPoint.mVisibility);
                } else if (f2 >= 1.0f) {
                    motionWidget2.setVisibility(this.mEndPoint.mVisibility);
                } else if (this.mEndPoint.mVisibility != this.mStartPoint.mVisibility) {
                    motionWidget2.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                for (int i2 = 0; i2 < this.mKeyTriggers.length; i2++) {
                    this.mKeyTriggers[i2].conditionallyFire(f2, motionWidget2);
                }
            }
        } else {
            float f6 = this.mStartMotionPath.mX + ((this.mEndMotionPath.mX - this.mStartMotionPath.mX) * f2);
            float f7 = this.mStartMotionPath.mY + ((this.mEndMotionPath.mY - this.mStartMotionPath.mY) * f2);
            int i3 = (int) (f6 + 0.5f);
            int i4 = (int) (f7 + 0.5f);
            int i5 = (int) (f6 + 0.5f + this.mStartMotionPath.mWidth + ((this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth) * f2));
            int i6 = (int) (0.5f + f7 + this.mStartMotionPath.mHeight + ((this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) * f2));
            int i7 = i5 - i3;
            int i8 = i6 - i4;
            motionWidget2.layout(i3, i4, i5, i6);
        }
        if (this.mCycleMap != null) {
            for (KeyCycleOscillator keyCycleOscillator : this.mCycleMap.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(motionWidget2, f2, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]);
                } else {
                    keyCycleOscillator.setProperty(motionWidget2, f2);
                }
            }
        }
        return false;
    }

    String name() {
        return this.mView.getName();
    }

    void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f, float f2, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        floatRect.left = this.mStartMotionPath.mX;
        floatRect.top = this.mStartMotionPath.mY;
        floatRect.right = floatRect.left + this.mStartMotionPath.mWidth;
        floatRect.bottom = floatRect.top + this.mStartMotionPath.mHeight;
        FloatRect floatRect2 = new FloatRect();
        floatRect2.left = this.mEndMotionPath.mX;
        floatRect2.top = this.mEndMotionPath.mY;
        floatRect2.right = floatRect2.left + this.mEndMotionPath.mWidth;
        floatRect2.bottom = floatRect2.top + this.mEndMotionPath.mHeight;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f, f2, strArr, fArr);
    }

    void rotate(Rect rect, Rect rect2, int i, int i2, int i3) {
        switch (i) {
            case 1:
                int i4 = rect.left + rect.right;
                rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
                rect2.top = i3 - ((rect.height() + i4) / 2);
                rect2.right = rect2.left + rect.width();
                rect2.bottom = rect2.top + rect.height();
                return;
            case 2:
                int i5 = rect.left + rect.right;
                rect2.left = i2 - ((rect.width() + (rect.top + rect.bottom)) / 2);
                rect2.top = (i5 - rect.height()) / 2;
                rect2.right = rect2.left + rect.width();
                rect2.bottom = rect2.top + rect.height();
                return;
            case 3:
                int i6 = rect.left + rect.right;
                int i7 = rect.top + rect.bottom;
                rect2.left = ((rect.height() / 2) + rect.top) - (i6 / 2);
                rect2.top = i3 - ((rect.height() + i6) / 2);
                rect2.right = rect2.left + rect.width();
                rect2.bottom = rect2.top + rect.height();
                return;
            case 4:
                int i8 = rect.left + rect.right;
                rect2.left = i2 - ((rect.width() + (rect.bottom + rect.top)) / 2);
                rect2.top = (i8 - rect.height()) / 2;
                rect2.right = rect2.left + rect.width();
                rect2.bottom = rect2.top + rect.height();
                return;
            default:
                return;
        }
    }

    void setBothStates(MotionWidget motionWidget) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mNoMovement = true;
        this.mStartMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    public void setEnd(MotionWidget motionWidget) {
        this.mEndMotionPath.mTime = 1.0f;
        this.mEndMotionPath.mPosition = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(motionWidget.getLeft(), motionWidget.getTop(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setIdString(String str) {
        this.mId = str;
        this.mStartMotionPath.mId = this.mId;
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    public void setStaggerOffset(float f) {
        this.mStaggerOffset = f;
    }

    public void setStaggerScale(float f) {
        this.mStaggerScale = f;
    }

    public void setStart(MotionWidget motionWidget) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mStartMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
        TypedBundle motionProperties = motionWidget.getWidgetFrame().getMotionProperties();
        if (motionProperties != null) {
            motionProperties.applyDelta(this);
        }
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i, int i2, int i3) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        Rect rect = new Rect();
        switch (i) {
            case 1:
                int i4 = viewState.left + viewState.right;
                rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
                rect.top = i2 - ((viewState.height() + i4) / 2);
                rect.right = rect.left + viewState.width();
                rect.bottom = rect.top + viewState.height();
                break;
            case 2:
                int i5 = viewState.left + viewState.right;
                rect.left = i3 - ((viewState.width() + (viewState.top + viewState.bottom)) / 2);
                rect.top = (i5 - viewState.height()) / 2;
                rect.right = rect.left + viewState.width();
                rect.bottom = rect.top + viewState.height();
                break;
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, motionWidget, i, viewState.rotation);
    }

    public void setTransformPivotTarget(int i) {
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (602 == i) {
            this.mQuantizeMotionPhase = f;
            return true;
        }
        if (600 != i) {
            return false;
        }
        this.mMotionStagger = f;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        switch (i) {
            case 509:
                setPathMotionArc(i2);
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS /* 610 */:
                this.mQuantizeMotionSteps = i2;
                return true;
            case TypedValues.TransitionType.TYPE_AUTO_TRANSITION /* 704 */:
                return true;
            default:
                return false;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (705 == i || 611 == i) {
            this.mQuantizeMotionInterpolator = getInterpolator(-1, str, 0);
            return true;
        }
        if (605 != i) {
            return false;
        }
        this.mStartMotionPath.mAnimateRelativeTo = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    public void setup(int i, int i2, float f, long j) {
        HashSet<String> hashSet;
        HashSet<String> hashSet2;
        ?? r18;
        HashMap<String, Integer> hashMap;
        int i3;
        int i4;
        CustomVariable customVariable;
        Iterator<String> it;
        SplineSet makeSpline;
        Iterator<String> it2;
        Integer num;
        HashSet hashSet3;
        HashSet<String> hashSet4;
        HashSet<String> hashSet5;
        SplineSet makeSpline2;
        HashSet<String> hashSet6;
        HashSet<String> hashSet7;
        KeyFrameArray.CustomVar customVar;
        HashSet hashSet8 = new HashSet();
        HashSet<String> hashSet9 = new HashSet<>();
        HashSet<String> hashSet10 = new HashSet<>();
        HashSet<String> hashSet11 = new HashSet<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        ArrayList arrayList = null;
        setupRelative();
        if (this.mPathMotionArc != -1 && this.mStartMotionPath.mPathMotionArc == -1) {
            this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet10);
        if (this.mKeyList != null) {
            Iterator<MotionKey> it3 = this.mKeyList.iterator();
            while (it3.hasNext()) {
                MotionKey next = it3.next();
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    insertKey(new MotionPaths(i, i2, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    if (motionKeyPosition.mCurveFit != -1) {
                        this.mCurveFitType = motionKeyPosition.mCurveFit;
                    }
                } else if (next instanceof MotionKeyCycle) {
                    next.getAttributeNames(hashSet11);
                } else if (next instanceof MotionKeyTimeCycle) {
                    next.getAttributeNames(hashSet9);
                } else if (next instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap2);
                    next.getAttributeNames(hashSet10);
                }
            }
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        if (hashSet10.isEmpty()) {
            hashSet = hashSet9;
            hashSet2 = hashSet11;
            r18 = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it4 = hashSet10.iterator();
            while (it4.hasNext()) {
                String next2 = it4.next();
                if (next2.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                    String str = next2.split(",")[1];
                    Iterator<MotionKey> it5 = this.mKeyList.iterator();
                    while (it5.hasNext()) {
                        MotionKey next3 = it5.next();
                        HashSet hashSet12 = hashSet8;
                        if (next3.mCustom == null) {
                            hashSet8 = hashSet12;
                        } else {
                            CustomVariable customVariable2 = next3.mCustom.get(str);
                            if (customVariable2 != null) {
                                hashSet6 = hashSet9;
                                hashSet7 = hashSet11;
                                customVar = customVar2;
                                customVar.append(next3.mFramePosition, customVariable2);
                            } else {
                                hashSet6 = hashSet9;
                                hashSet7 = hashSet11;
                                customVar = customVar2;
                            }
                            customVar2 = customVar;
                            hashSet8 = hashSet12;
                            hashSet9 = hashSet6;
                            hashSet11 = hashSet7;
                        }
                    }
                    hashSet3 = hashSet8;
                    hashSet4 = hashSet9;
                    hashSet5 = hashSet11;
                    makeSpline2 = SplineSet.makeCustomSplineSet(next2, customVar2);
                } else {
                    hashSet3 = hashSet8;
                    hashSet4 = hashSet9;
                    hashSet5 = hashSet11;
                    makeSpline2 = SplineSet.makeSpline(next2, j);
                }
                if (makeSpline2 == null) {
                    hashSet8 = hashSet3;
                    hashSet9 = hashSet4;
                    hashSet11 = hashSet5;
                } else {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                    hashSet8 = hashSet3;
                    hashSet9 = hashSet4;
                    hashSet11 = hashSet5;
                }
            }
            hashSet = hashSet9;
            hashSet2 = hashSet11;
            r18 = 1;
            if (this.mKeyList != null) {
                Iterator<MotionKey> it6 = this.mKeyList.iterator();
                while (it6.hasNext()) {
                    MotionKey next4 = it6.next();
                    if (next4 instanceof MotionKeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int i5 = 0;
                if (hashMap2.containsKey(str2) && (num = hashMap2.get(str2)) != null) {
                    i5 = num.intValue();
                }
                SplineSet splineSet = this.mAttributesMap.get(str2);
                if (splineSet != null) {
                    splineSet.setup(i5);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it7 = hashSet.iterator();
            while (it7.hasNext()) {
                String next5 = it7.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar3 = new KeyFrameArray.CustomVar();
                        String str3 = next5.split(",")[r18];
                        Iterator<MotionKey> it8 = this.mKeyList.iterator();
                        while (it8.hasNext()) {
                            MotionKey next6 = it8.next();
                            if (next6.mCustom != null) {
                                CustomVariable customVariable3 = next6.mCustom.get(str3);
                                if (customVariable3 != null) {
                                    it2 = it7;
                                    customVar3.append(next6.mFramePosition, customVariable3);
                                } else {
                                    it2 = it7;
                                }
                                it7 = it2;
                            }
                        }
                        it = it7;
                        makeSpline = SplineSet.makeCustomSplineSet(next5, customVar3);
                    } else {
                        it = it7;
                        makeSpline = SplineSet.makeSpline(next5, j);
                    }
                    if (makeSpline == null) {
                        it7 = it;
                    } else {
                        makeSpline.setType(next5);
                        it7 = it;
                    }
                }
            }
            if (this.mKeyList != null) {
                Iterator<MotionKey> it9 = this.mKeyList.iterator();
                while (it9.hasNext()) {
                    MotionKey next7 = it9.next();
                    if (next7 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                int i6 = 0;
                if (hashMap2.containsKey(str4)) {
                    i6 = hashMap2.get(str4).intValue();
                }
                this.mTimeCycleAttributesMap.get(str4).setup(i6);
            }
        }
        MotionPaths[] motionPathsArr = new MotionPaths[this.mMotionPaths.size() + 2];
        int i7 = 1;
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[motionPathsArr.length - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it10 = this.mMotionPaths.iterator();
        while (it10.hasNext()) {
            motionPathsArr[i7] = it10.next();
            i7++;
        }
        HashSet hashSet13 = new HashSet();
        for (String str5 : this.mEndMotionPath.mCustomAttributes.keySet()) {
            if (this.mStartMotionPath.mCustomAttributes.containsKey(str5) && !hashSet10.contains("CUSTOM," + str5)) {
                hashSet13.add(str5);
            }
        }
        this.mAttributeNames = (String[]) hashSet13.toArray(new String[0]);
        this.mAttributeInterpolatorCount = new int[this.mAttributeNames.length];
        for (int i8 = 0; i8 < this.mAttributeNames.length; i8++) {
            String str6 = this.mAttributeNames[i8];
            this.mAttributeInterpolatorCount[i8] = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= motionPathsArr.length) {
                    break;
                }
                if (motionPathsArr[i9].mCustomAttributes.containsKey(str6) && (customVariable = motionPathsArr[i9].mCustomAttributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i8] = iArr[i8] + customVariable.numberOfInterpolatedValues();
                    break;
                }
                i9++;
            }
        }
        boolean z = motionPathsArr[0].mPathMotionArc != -1 ? r18 : false;
        boolean[] zArr = new boolean[this.mAttributeNames.length + 18];
        for (int i10 = 1; i10 < motionPathsArr.length; i10++) {
            motionPathsArr[i10].different(motionPathsArr[i10 - 1], zArr, this.mAttributeNames, z);
        }
        int i11 = 0;
        for (int i12 = 1; i12 < zArr.length; i12++) {
            if (zArr[i12]) {
                i11++;
            }
        }
        this.mInterpolateVariables = new int[i11];
        int max = Math.max(2, i11);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i13 = 0;
        for (int i14 = 1; i14 < zArr.length; i14++) {
            if (zArr[i14]) {
                this.mInterpolateVariables[i13] = i14;
                i13++;
            }
        }
        int length = motionPathsArr.length;
        int[] iArr2 = new int[2];
        iArr2[r18] = this.mInterpolateVariables.length;
        iArr2[0] = length;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr2);
        double[] dArr2 = new double[motionPathsArr.length];
        int i15 = 0;
        while (i15 < motionPathsArr.length) {
            motionPathsArr[i15].fillStandard(dArr[i15], this.mInterpolateVariables);
            dArr2[i15] = motionPathsArr[i15].mTime;
            i15++;
            i13 = i13;
        }
        int i16 = 0;
        while (i16 < this.mInterpolateVariables.length) {
            if (this.mInterpolateVariables[i16] < MotionPaths.sNames.length) {
                i4 = i16;
                String str7 = MotionPaths.sNames[this.mInterpolateVariables[i4]] + " [";
                int i17 = 0;
                while (i17 < motionPathsArr.length) {
                    str7 = str7 + dArr[i17][i4];
                    i17++;
                    hashSet10 = hashSet10;
                }
            } else {
                i4 = i16;
            }
            i16 = i4 + 1;
            hashSet10 = hashSet10;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i18 = 0;
        while (i18 < this.mAttributeNames.length) {
            int i19 = 0;
            double[][] dArr3 = null;
            double[] dArr4 = null;
            String str8 = this.mAttributeNames[i18];
            int i20 = i18;
            int i21 = 0;
            while (true) {
                hashMap = hashMap2;
                if (i21 < motionPathsArr.length) {
                    if (motionPathsArr[i21].hasCustomData(str8)) {
                        if (dArr3 == null) {
                            dArr4 = new double[motionPathsArr.length];
                            int length2 = motionPathsArr.length;
                            i3 = i21;
                            int[] iArr3 = new int[2];
                            iArr3[r18] = motionPathsArr[i3].getCustomDataCount(str8);
                            iArr3[0] = length2;
                            dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                        } else {
                            i3 = i21;
                        }
                        double[][] dArr5 = dArr3;
                        dArr4[i19] = motionPathsArr[i3].mTime;
                        motionPathsArr[i3].getCustomData(str8, dArr5[i19], 0);
                        i19++;
                        dArr3 = dArr5;
                    } else {
                        i3 = i21;
                    }
                    i21 = i3 + 1;
                    hashMap2 = hashMap;
                }
            }
            this.mSpline[i20 + 1] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr4, i19), (double[][]) Arrays.copyOf(dArr3, i19));
            i18 = i20 + 1;
            hashMap2 = hashMap;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != -1) {
            int length3 = motionPathsArr.length;
            int[] iArr4 = new int[length3];
            double[] dArr6 = new double[length3];
            int[] iArr5 = new int[2];
            iArr5[r18] = 2;
            iArr5[0] = length3;
            double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr5);
            int i22 = 0;
            while (i22 < length3) {
                iArr4[i22] = motionPathsArr[i22].mPathMotionArc;
                dArr6[i22] = motionPathsArr[i22].mTime;
                dArr7[i22][0] = motionPathsArr[i22].mX;
                dArr7[i22][r18] = motionPathsArr[i22].mY;
                i22++;
                dArr = dArr;
                dArr2 = dArr2;
            }
            this.mArcSpline = CurveFit.getArc(iArr4, dArr6, dArr7);
        }
        float f2 = Float.NaN;
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it11 = hashSet2.iterator();
            while (it11.hasNext()) {
                String next8 = it11.next();
                KeyCycleOscillator makeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(next8);
                if (makeWidgetCycle != null) {
                    if (makeWidgetCycle.variesByPath() && Float.isNaN(f2)) {
                        f2 = getPreCycleDistance();
                    }
                    makeWidgetCycle.setType(next8);
                    this.mCycleMap.put(next8, makeWidgetCycle);
                }
            }
            Iterator<MotionKey> it12 = this.mKeyList.iterator();
            while (it12.hasNext()) {
                MotionKey next9 = it12.next();
                if (next9 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it13 = this.mCycleMap.values().iterator();
            while (it13.hasNext()) {
                it13.next().setup(f2);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.mRelativeMotion = motion;
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }
}
