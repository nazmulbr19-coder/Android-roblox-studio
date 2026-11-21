package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MotionController {
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
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, ViewOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    View mView;
    Rect mTempRect = new Rect();
    boolean mForceMeasure = false;
    private int mCurveFitType = -1;
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
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private int mPathMotionArc = Key.UNSET;
    private int mTransformPivotTarget = Key.UNSET;
    private View mTransformPivotView = null;
    private int mQuantizeMotionSteps = Key.UNSET;
    private float mQuantizeMotionPhase = Float.NaN;
    private Interpolator mQuantizeMotionInterpolator = null;
    private boolean mNoMovement = false;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionController$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Interpolator {
        final /* synthetic */ Easing val$easing;

        AnonymousClass1(Easing easing) {
            this.val$easing = easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.val$easing.get(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionController(View view) {
        setView(view);
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

    private static Interpolator getInterpolator(Context context, int i, String str, int i2) {
        switch (i) {
            case -3:
                return null;
            case -2:
                return AnimationUtils.loadInterpolator(context, i2);
            case -1:
                return new AnonymousClass1(Easing.getInterpolator(str));
            case 0:
                return new AccelerateDecelerateInterpolator();
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new DecelerateInterpolator();
            case 3:
                return null;
            case 4:
                return new BounceInterpolator();
            case 5:
                return new OvershootInterpolator();
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
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    void buildBounds(float[] fArr, int i) {
        float f;
        MotionController motionController = this;
        int i2 = i;
        float f2 = 1.0f;
        float f3 = 1.0f / (i2 - 1);
        ViewSpline viewSpline = motionController.mAttributesMap == null ? null : motionController.mAttributesMap.get("translationX");
        if (motionController.mAttributesMap != null) {
            motionController.mAttributesMap.get("translationY");
        }
        if (motionController.mCycleMap != null) {
            motionController.mCycleMap.get("translationX");
        }
        if (motionController.mCycleMap != null) {
            motionController.mCycleMap.get("translationY");
        }
        int i3 = 0;
        while (i3 < i2) {
            float f4 = i3 * f3;
            if (motionController.mStaggerScale != f2) {
                if (f4 < motionController.mStaggerOffset) {
                    f4 = 0.0f;
                }
                if (f4 > motionController.mStaggerOffset && f4 < 1.0d) {
                    f4 = Math.min((f4 - motionController.mStaggerOffset) * motionController.mStaggerScale, f2);
                }
            }
            double d = f4;
            Easing easing = motionController.mStartMotionPath.mKeyFrameEasing;
            float f5 = 0.0f;
            float f6 = Float.NaN;
            Iterator<MotionPaths> it = motionController.mMotionPaths.iterator();
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
            motionController.mSpline[0].getPos(d, motionController.mInterpolateData);
            if (motionController.mArcSpline != null && motionController.mInterpolateData.length > 0) {
                motionController.mArcSpline.getPos(d, motionController.mInterpolateData);
            }
            motionController.mStartMotionPath.getBounds(motionController.mInterpolateVariables, motionController.mInterpolateData, fArr, i3 * 2);
            i3++;
            motionController = this;
            i2 = i;
            f3 = f;
            viewSpline = viewSpline;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public int buildKeyFrames(float[] fArr, int[] iArr) {
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
        int i2 = i;
        for (int i3 = 0; i3 < timePoints.length; i3++) {
            this.mSpline[0].getPos(timePoints[i3], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i3], this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildPath(float[] fArr, int i) {
        float f;
        int i2 = i;
        float f2 = 1.0f;
        float f3 = 1.0f / (i2 - 1);
        ViewSpline viewSpline = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationX");
        ViewSpline viewSpline2 = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationY");
        ViewOscillator viewOscillator = this.mCycleMap == null ? null : this.mCycleMap.get("translationX");
        ViewOscillator viewOscillator2 = this.mCycleMap != null ? this.mCycleMap.get("translationY") : null;
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
            if (viewOscillator != null) {
                int i4 = i3 * 2;
                fArr[i4] = fArr[i4] + viewOscillator.get(f4);
            } else if (viewSpline != null) {
                int i5 = i3 * 2;
                fArr[i5] = fArr[i5] + viewSpline.get(f4);
            }
            if (viewOscillator2 != null) {
                int i6 = (i3 * 2) + 1;
                fArr[i6] = fArr[i6] + viewOscillator2.get(f4);
            } else if (viewSpline2 != null) {
                int i7 = (i3 * 2) + 1;
                fArr[i7] = fArr[i7] + viewSpline2.get(f4);
            }
            i3++;
            i2 = i;
            f3 = f;
            f2 = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildRect(float f, float[] fArr, int i) {
        this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildRectangles(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            this.mSpline[0].getPos(getAdjustedPosition(i2 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endTrigger(boolean z) {
        if (!"button".equals(Debug.getName(this.mView)) || this.mKeyTriggers == null) {
            return;
        }
        for (int i = 0; i < this.mKeyTriggers.length; i++) {
            this.mKeyTriggers[i].conditionallyFire(z ? -100.0f : 100.0f, this.mView);
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAttributeValues(String str, float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        ViewSpline viewSpline = this.mAttributesMap.get(str);
        if (viewSpline == null) {
            return -1;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = viewSpline.get(i2 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        int[] iArr = new int[4];
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

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        int i2 = 0;
        int i3 = 0;
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
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
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    int i9 = i8 + 1;
                    iArr[i9] = keyPosition.mPositionType;
                    int i10 = i9 + 1;
                    iArr[i10] = Float.floatToIntBits(keyPosition.mPercentX);
                    i8 = i10 + 1;
                    iArr[i8] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                i3 = i8 + 1;
                iArr[i4] = i3 - i4;
                i2++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getKeyFrameParameter(int i, float f, float f2) {
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
        Iterator<Key> it = this.mKeyList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Key next = it.next();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public double[] getPos(double d) {
        this.mSpline[0].getPos(d, this.mInterpolateData);
        if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
            this.mArcSpline.getPos(d, this.mInterpolateData);
        }
        return this.mInterpolateData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyPositionBase getPositionKeyframe(int i, int i2, float f, float f2) {
        int i3;
        int i4;
        float f3;
        float f4;
        RectF rectF = new RectF();
        rectF.left = this.mStartMotionPath.mX;
        rectF.top = this.mStartMotionPath.mY;
        rectF.right = rectF.left + this.mStartMotionPath.mWidth;
        rectF.bottom = rectF.top + this.mStartMotionPath.mHeight;
        RectF rectF2 = new RectF();
        rectF2.left = this.mEndMotionPath.mX;
        rectF2.top = this.mEndMotionPath.mY;
        rectF2.right = rectF2.left + this.mEndMotionPath.mWidth;
        rectF2.bottom = rectF2.top + this.mEndMotionPath.mHeight;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                i3 = i;
                i4 = i2;
                f3 = f;
                f4 = f2;
                if (((KeyPositionBase) next).intersects(i3, i4, rectF, rectF2, f3, f4)) {
                    return (KeyPositionBase) next;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getPostLayoutDvDp(float f, int i, int i2, float f2, float f3, float[] fArr) {
        VelocityMatrix velocityMatrix;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        ViewSpline viewSpline = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationX");
        ViewSpline viewSpline2 = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationY");
        ViewSpline viewSpline3 = this.mAttributesMap == null ? null : this.mAttributesMap.get(Key.ROTATION);
        ViewSpline viewSpline4 = this.mAttributesMap == null ? null : this.mAttributesMap.get("scaleX");
        ViewSpline viewSpline5 = this.mAttributesMap == null ? null : this.mAttributesMap.get("scaleY");
        ViewOscillator viewOscillator = this.mCycleMap == null ? null : this.mCycleMap.get("translationX");
        ViewOscillator viewOscillator2 = this.mCycleMap == null ? null : this.mCycleMap.get("translationY");
        ViewOscillator viewOscillator3 = this.mCycleMap == null ? null : this.mCycleMap.get(Key.ROTATION);
        ViewOscillator viewOscillator4 = this.mCycleMap == null ? null : this.mCycleMap.get("scaleX");
        ViewOscillator viewOscillator5 = this.mCycleMap != null ? this.mCycleMap.get("scaleY") : null;
        VelocityMatrix velocityMatrix2 = new VelocityMatrix();
        velocityMatrix2.clear();
        velocityMatrix2.setRotationVelocity(viewSpline3, adjustedPosition);
        velocityMatrix2.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
        velocityMatrix2.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
        velocityMatrix2.setRotationVelocity(viewOscillator3, adjustedPosition);
        velocityMatrix2.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
        velocityMatrix2.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
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
        velocityMatrix2.setRotationVelocity(viewSpline3, adjustedPosition);
        velocityMatrix2.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
        velocityMatrix2.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
        velocityMatrix2.setRotationVelocity(viewOscillator3, adjustedPosition);
        velocityMatrix2.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
        velocityMatrix2.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
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

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean interpolate(View view, float f, long j, KeyCache keyCache) {
        boolean z;
        ViewTimeCycle.PathRotate pathRotate;
        View view2;
        char c;
        float f2;
        float f3;
        View view3;
        int i;
        float f4;
        View view4 = view;
        float adjustedPosition = getAdjustedPosition(f, null);
        if (this.mQuantizeMotionSteps != Key.UNSET) {
            float f5 = 1.0f / this.mQuantizeMotionSteps;
            float floor = ((float) Math.floor(adjustedPosition / f5)) * f5;
            float f6 = (adjustedPosition % f5) / f5;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f6 = (this.mQuantizeMotionPhase + f6) % 1.0f;
            }
            adjustedPosition = ((this.mQuantizeMotionInterpolator != null ? this.mQuantizeMotionInterpolator.getInterpolation(f6) : ((double) f6) > 0.5d ? 1.0f : 0.0f) * f5) + floor;
        }
        if (this.mAttributesMap != null) {
            Iterator<ViewSpline> it = this.mAttributesMap.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view4, adjustedPosition);
            }
        }
        if (this.mTimeCycleAttributesMap != null) {
            boolean z2 = false;
            pathRotate = null;
            for (ViewTimeCycle viewTimeCycle : this.mTimeCycleAttributesMap.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    z2 |= viewTimeCycle.setProperty(view4, adjustedPosition, j, keyCache);
                    view4 = view;
                }
            }
            z = z2;
        } else {
            z = false;
            pathRotate = null;
        }
        if (this.mSpline != null) {
            this.mSpline[0].getPos(adjustedPosition, this.mInterpolateData);
            this.mSpline[0].getSlope(adjustedPosition, this.mInterpolateVelocity);
            if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
                this.mArcSpline.getPos(adjustedPosition, this.mInterpolateData);
                this.mArcSpline.getSlope(adjustedPosition, this.mInterpolateVelocity);
            }
            if (this.mNoMovement) {
                view3 = view;
            } else {
                float f7 = adjustedPosition;
                this.mStartMotionPath.setView(f7, view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
                adjustedPosition = f7;
                view3 = view;
                this.mForceMeasure = false;
            }
            if (this.mTransformPivotTarget != Key.UNSET) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = ((View) view3.getParent()).findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float top = (this.mTransformPivotView.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
                    float left = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
                    if (view3.getRight() - view3.getLeft() > 0 && view3.getBottom() - view3.getTop() > 0) {
                        view3.setPivotX(left - view3.getLeft());
                        view3.setPivotY(top - view3.getTop());
                    }
                }
            }
            if (this.mAttributesMap != null) {
                for (ViewSpline viewSpline : this.mAttributesMap.values()) {
                    if ((viewSpline instanceof ViewSpline.PathRotate) && this.mInterpolateVelocity.length > 1) {
                        ((ViewSpline.PathRotate) viewSpline).setPathRotate(view3, adjustedPosition, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]);
                    }
                    view3 = view;
                }
            }
            if (pathRotate != null) {
                view2 = view;
                i = 0;
                f4 = 0.0f;
                float f8 = adjustedPosition;
                adjustedPosition = f8;
                z |= pathRotate.setPathRotate(view2, keyCache, f8, j, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]);
            } else {
                view2 = view;
                i = 0;
                f4 = 0.0f;
            }
            for (int i2 = 1; i2 < this.mSpline.length; i2++) {
                this.mSpline[i2].getPos(adjustedPosition, this.mValuesBuff);
                CustomSupport.setInterpolatedValue(this.mStartMotionPath.mAttributes.get(this.mAttributeNames[i2 - 1]), view2, this.mValuesBuff);
            }
            if (this.mStartPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= f4) {
                    view2.setVisibility(this.mStartPoint.mVisibility);
                } else if (adjustedPosition >= 1.0f) {
                    view2.setVisibility(this.mEndPoint.mVisibility);
                } else if (this.mEndPoint.mVisibility != this.mStartPoint.mVisibility) {
                    view2.setVisibility(i);
                }
            }
            if (this.mKeyTriggers != null) {
                for (int i3 = 0; i3 < this.mKeyTriggers.length; i3++) {
                    this.mKeyTriggers[i3].conditionallyFire(adjustedPosition, view2);
                }
            }
            f2 = adjustedPosition;
            c = 1;
        } else {
            view2 = view;
            float f9 = this.mStartMotionPath.mX + ((this.mEndMotionPath.mX - this.mStartMotionPath.mX) * adjustedPosition);
            float f10 = this.mStartMotionPath.mY + ((this.mEndMotionPath.mY - this.mStartMotionPath.mY) * adjustedPosition);
            int i4 = (int) (f9 + 0.5f);
            int i5 = (int) (f10 + 0.5f);
            int i6 = (int) (f9 + 0.5f + this.mStartMotionPath.mWidth + ((this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth) * adjustedPosition));
            int i7 = (int) (0.5f + f10 + this.mStartMotionPath.mHeight + ((this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) * adjustedPosition));
            c = 1;
            int i8 = i6 - i4;
            int i9 = i7 - i5;
            if (this.mEndMotionPath.mWidth == this.mStartMotionPath.mWidth && this.mEndMotionPath.mHeight == this.mStartMotionPath.mHeight && !this.mForceMeasure) {
                f2 = adjustedPosition;
            } else {
                f2 = adjustedPosition;
                view2.measure(View.MeasureSpec.makeMeasureSpec(i8, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i9, BasicMeasure.EXACTLY));
                this.mForceMeasure = false;
            }
            view2.layout(i4, i5, i6, i7);
        }
        if (this.mCycleMap != null) {
            for (ViewOscillator viewOscillator : this.mCycleMap.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    f3 = f2;
                    ((ViewOscillator.PathRotateSet) viewOscillator).setPathRotate(view2, f3, this.mInterpolateVelocity[0], this.mInterpolateVelocity[c]);
                } else {
                    f3 = f2;
                    viewOscillator.setProperty(view2, f3);
                }
                f2 = f3;
            }
        }
        return z;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f2, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        rectF.left = this.mStartMotionPath.mX;
        rectF.top = this.mStartMotionPath.mY;
        rectF.right = rectF.left + this.mStartMotionPath.mWidth;
        rectF.bottom = rectF.top + this.mStartMotionPath.mHeight;
        RectF rectF2 = new RectF();
        rectF2.left = this.mEndMotionPath.mX;
        rectF2.top = this.mEndMotionPath.mY;
        rectF2.right = rectF2.left + this.mEndMotionPath.mWidth;
        rectF2.bottom = rectF2.top + this.mEndMotionPath.mHeight;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBothStates(View view) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mNoMovement = true;
        this.mStartMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEndState(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        int i3 = constraintSet.mRotate;
        if (i3 != 0) {
            rotate(rect, this.mTempRect, i3, i, i2);
            rect = this.mTempRect;
        }
        this.mEndMotionPath.mTime = 1.0f;
        this.mEndMotionPath.mPosition = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(rect, constraintSet, i3, this.mId);
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartCurrentState(View view) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mStartMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartState(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        Rect rect2;
        int i3 = constraintSet.mRotate;
        if (i3 != 0) {
            rect2 = rect;
            rotate(rect2, this.mTempRect, i3, i, i2);
        } else {
            rect2 = rect;
        }
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds(rect2.left, rect2.top, rect2.width(), rect2.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(rect2, constraintSet, i3, this.mId);
        this.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        this.mQuantizeMotionSteps = parameters.motion.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = parameters.motion.mQuantizeMotionPhase;
        this.mQuantizeMotionInterpolator = getInterpolator(this.mView.getContext(), parameters.motion.mQuantizeInterpolatorType, parameters.motion.mQuantizeInterpolatorString, parameters.motion.mQuantizeInterpolatorID);
    }

    public void setStartState(ViewState viewState, View view, int i, int i2, int i3) {
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
        this.mStartPoint.setState(rect, view, i, viewState.rotation);
    }

    public void setTransformPivotTarget(int i) {
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    public void setup(int i, int i2, float f, long j) {
        ?? r17;
        ArrayList arrayList;
        int i3;
        boolean[] zArr;
        int i4;
        HashSet<String> hashSet;
        ConstraintAttribute constraintAttribute;
        Iterator<String> it;
        ViewTimeCycle makeSpline;
        Iterator<String> it2;
        Integer num;
        HashSet hashSet2;
        char c;
        ViewSpline makeSpline2;
        HashSet hashSet3;
        HashSet hashSet4 = new HashSet();
        HashSet<String> hashSet5 = new HashSet<>();
        HashSet<String> hashSet6 = new HashSet<>();
        HashSet<String> hashSet7 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList arrayList2 = null;
        if (this.mPathMotionArc != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet6);
        if (this.mKeyList != null) {
            Iterator<Key> it3 = this.mKeyList.iterator();
            while (it3.hasNext()) {
                Key next = it3.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new MotionPaths(i, i2, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    if (keyPosition.mCurveFit != Key.UNSET) {
                        this.mCurveFitType = keyPosition.mCurveFit;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet7);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet5);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet6);
                }
            }
        }
        if (arrayList2 != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList2.toArray(new KeyTrigger[0]);
        }
        char c2 = 1;
        if (hashSet6.isEmpty()) {
            r17 = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it4 = hashSet6.iterator();
            while (it4.hasNext()) {
                String next2 = it4.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[c2];
                    Iterator<Key> it5 = this.mKeyList.iterator();
                    while (it5.hasNext()) {
                        char c3 = c2;
                        Key next3 = it5.next();
                        if (next3.mCustomConstraints == null) {
                            c2 = c3;
                        } else {
                            ConstraintAttribute constraintAttribute2 = next3.mCustomConstraints.get(str);
                            if (constraintAttribute2 != null) {
                                hashSet3 = hashSet4;
                                sparseArray.append(next3.mFramePosition, constraintAttribute2);
                            } else {
                                hashSet3 = hashSet4;
                            }
                            c2 = c3;
                            hashSet4 = hashSet3;
                        }
                    }
                    hashSet2 = hashSet4;
                    c = c2;
                    makeSpline2 = ViewSpline.makeCustomSpline(next2, (SparseArray<ConstraintAttribute>) sparseArray);
                } else {
                    hashSet2 = hashSet4;
                    c = c2;
                    makeSpline2 = ViewSpline.makeSpline(next2);
                }
                if (makeSpline2 == null) {
                    c2 = c;
                    hashSet4 = hashSet2;
                } else {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                    c2 = c;
                    hashSet4 = hashSet2;
                }
            }
            r17 = c2;
            if (this.mKeyList != null) {
                Iterator<Key> it6 = this.mKeyList.iterator();
                while (it6.hasNext()) {
                    Key next4 = it6.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int i5 = 0;
                if (hashMap.containsKey(str2) && (num = hashMap.get(str2)) != null) {
                    i5 = num.intValue();
                }
                ViewSpline viewSpline = this.mAttributesMap.get(str2);
                if (viewSpline != null) {
                    viewSpline.setup(i5);
                }
            }
        }
        if (!hashSet5.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it7 = hashSet5.iterator();
            while (it7.hasNext()) {
                String next5 = it7.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[r17];
                        Iterator<Key> it8 = this.mKeyList.iterator();
                        while (it8.hasNext()) {
                            Key next6 = it8.next();
                            if (next6.mCustomConstraints != null) {
                                ConstraintAttribute constraintAttribute3 = next6.mCustomConstraints.get(str3);
                                if (constraintAttribute3 != null) {
                                    it2 = it7;
                                    sparseArray2.append(next6.mFramePosition, constraintAttribute3);
                                } else {
                                    it2 = it7;
                                }
                                it7 = it2;
                            }
                        }
                        it = it7;
                        makeSpline = ViewTimeCycle.makeCustomSpline(next5, sparseArray2);
                    } else {
                        it = it7;
                        makeSpline = ViewTimeCycle.makeSpline(next5, j);
                    }
                    if (makeSpline == null) {
                        it7 = it;
                    } else {
                        makeSpline.setType(next5);
                        this.mTimeCycleAttributesMap.put(next5, makeSpline);
                        it7 = it;
                    }
                }
            }
            if (this.mKeyList != null) {
                Iterator<Key> it9 = this.mKeyList.iterator();
                while (it9.hasNext()) {
                    Key next7 = it9.next();
                    if (next7 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                int i6 = 0;
                if (hashMap.containsKey(str4)) {
                    i6 = hashMap.get(str4).intValue();
                }
                this.mTimeCycleAttributesMap.get(str4).setup(i6);
            }
        }
        MotionPaths[] motionPathsArr = new MotionPaths[this.mMotionPaths.size() + 2];
        int i7 = 1;
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[motionPathsArr.length - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it10 = this.mMotionPaths.iterator();
        while (it10.hasNext()) {
            motionPathsArr[i7] = it10.next();
            i7++;
        }
        HashSet hashSet8 = new HashSet();
        for (String str5 : this.mEndMotionPath.mAttributes.keySet()) {
            if (this.mStartMotionPath.mAttributes.containsKey(str5) && !hashSet6.contains("CUSTOM," + str5)) {
                hashSet8.add(str5);
            }
        }
        this.mAttributeNames = (String[]) hashSet8.toArray(new String[0]);
        this.mAttributeInterpolatorCount = new int[this.mAttributeNames.length];
        int i8 = 0;
        while (i8 < this.mAttributeNames.length) {
            String str6 = this.mAttributeNames[i8];
            this.mAttributeInterpolatorCount[i8] = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= motionPathsArr.length) {
                    hashSet = hashSet5;
                    break;
                }
                if (motionPathsArr[i9].mAttributes.containsKey(str6) && (constraintAttribute = motionPathsArr[i9].mAttributes.get(str6)) != null) {
                    hashSet = hashSet5;
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i8] = iArr[i8] + constraintAttribute.numberOfInterpolatedValues();
                    break;
                }
                i9++;
                hashSet5 = hashSet5;
            }
            i8++;
            hashSet5 = hashSet;
        }
        boolean z = motionPathsArr[0].mPathMotionArc != Key.UNSET ? r17 : false;
        boolean[] zArr2 = new boolean[this.mAttributeNames.length + 18];
        int i10 = 1;
        while (i10 < motionPathsArr.length) {
            motionPathsArr[i10].different(motionPathsArr[i10 - 1], zArr2, this.mAttributeNames, z);
            i10++;
            hashSet6 = hashSet6;
        }
        int i11 = 0;
        for (int i12 = 1; i12 < zArr2.length; i12++) {
            if (zArr2[i12]) {
                i11++;
            }
        }
        this.mInterpolateVariables = new int[i11];
        int max = Math.max(2, i11);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i13 = 0;
        for (int i14 = 1; i14 < zArr2.length; i14++) {
            if (zArr2[i14]) {
                this.mInterpolateVariables[i13] = i14;
                i13++;
            }
        }
        int length = motionPathsArr.length;
        int[] iArr2 = new int[2];
        iArr2[r17] = this.mInterpolateVariables.length;
        iArr2[0] = length;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr2);
        double[] dArr2 = new double[motionPathsArr.length];
        int i15 = 0;
        while (i15 < motionPathsArr.length) {
            motionPathsArr[i15].fillStandard(dArr[i15], this.mInterpolateVariables);
            dArr2[i15] = motionPathsArr[i15].mTime;
            i15++;
            i13 = i13;
            hashSet7 = hashSet7;
        }
        HashSet<String> hashSet9 = hashSet7;
        int i16 = 0;
        while (i16 < this.mInterpolateVariables.length) {
            int i17 = this.mInterpolateVariables[i16];
            if (i17 < MotionPaths.sNames.length) {
                i4 = i16;
                String str7 = MotionPaths.sNames[this.mInterpolateVariables[i4]] + " [";
                int i18 = 0;
                while (i18 < motionPathsArr.length) {
                    str7 = str7 + dArr[i18][i4];
                    i18++;
                    i17 = i17;
                }
            } else {
                i4 = i16;
            }
            i16 = i4 + 1;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i19 = 0;
        while (i19 < this.mAttributeNames.length) {
            int i20 = 0;
            double[][] dArr3 = null;
            double[] dArr4 = null;
            int i21 = i19;
            String str8 = this.mAttributeNames[i21];
            HashMap<String, Integer> hashMap2 = hashMap;
            int i22 = 0;
            while (true) {
                arrayList = arrayList2;
                if (i22 < motionPathsArr.length) {
                    if (motionPathsArr[i22].hasCustomData(str8)) {
                        if (dArr3 == null) {
                            dArr4 = new double[motionPathsArr.length];
                            int length2 = motionPathsArr.length;
                            i3 = i22;
                            int[] iArr3 = new int[2];
                            iArr3[r17] = motionPathsArr[i3].getCustomDataCount(str8);
                            iArr3[0] = length2;
                            dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                        } else {
                            i3 = i22;
                        }
                        dArr4[i20] = motionPathsArr[i3].mTime;
                        zArr = zArr2;
                        motionPathsArr[i3].getCustomData(str8, dArr3[i20], 0);
                        i20++;
                    } else {
                        i3 = i22;
                        zArr = zArr2;
                    }
                    i22 = i3 + 1;
                    arrayList2 = arrayList;
                    zArr2 = zArr;
                }
            }
            this.mSpline[i21 + 1] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr4, i20), (double[][]) Arrays.copyOf(dArr3, i20));
            i19 = i21 + 1;
            hashMap = hashMap2;
            arrayList2 = arrayList;
            zArr2 = zArr2;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int length3 = motionPathsArr.length;
            int[] iArr4 = new int[length3];
            double[] dArr5 = new double[length3];
            int[] iArr5 = new int[2];
            iArr5[r17] = 2;
            iArr5[0] = length3;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr5);
            int i23 = 0;
            while (i23 < length3) {
                iArr4[i23] = motionPathsArr[i23].mPathMotionArc;
                dArr5[i23] = motionPathsArr[i23].mTime;
                dArr6[i23][0] = motionPathsArr[i23].mX;
                dArr6[i23][r17] = r19[i23].mY;
                i23++;
                motionPathsArr = motionPathsArr;
                dArr = dArr;
            }
            this.mArcSpline = CurveFit.getArc(iArr4, dArr5, dArr6);
        }
        float f2 = Float.NaN;
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it11 = hashSet9.iterator();
            while (it11.hasNext()) {
                String next8 = it11.next();
                ViewOscillator makeSpline3 = ViewOscillator.makeSpline(next8);
                if (makeSpline3 != null) {
                    if (makeSpline3.variesByPath() && Float.isNaN(f2)) {
                        f2 = getPreCycleDistance();
                    }
                    makeSpline3.setType(next8);
                    this.mCycleMap.put(next8, makeSpline3);
                }
            }
            Iterator<Key> it12 = this.mKeyList.iterator();
            while (it12.hasNext()) {
                Key next9 = it12.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<ViewOscillator> it13 = this.mCycleMap.values().iterator();
            while (it13.hasNext()) {
                it13.next().setup(f2);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }
}
