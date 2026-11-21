package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    String mAnimateRelativeTo;
    HashMap<String, CustomVariable> mCustomAttributes;
    int mDrawPath;
    float mHeight;
    public String mId;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mPosition;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float mTime;
    float mWidth;
    float mX;
    float mY;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = null;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mCustomAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public MotionPaths(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = null;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mCustomAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != null) {
            initPolar(i, i2, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        switch (motionKeyPosition.mPositionType) {
            case 1:
                initPath(motionKeyPosition, motionPaths, motionPaths2);
                return;
            case 2:
                initScreen(i, i2, motionKeyPosition, motionPaths, motionPaths2);
                return;
            default:
                initCartesian(motionKeyPosition, motionPaths, motionPaths2);
                return;
        }
    }

    private boolean diff(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    private static float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private static float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f5 - f3) * f) + ((f6 - f4) * f2) + f4;
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.mMotion.mTransitionEasing);
        this.mPathMotionArc = motionWidget.mMotion.mPathMotionArc;
        this.mAnimateRelativeTo = motionWidget.mMotion.mAnimateRelativeTo;
        this.mPathRotate = motionWidget.mMotion.mPathRotate;
        this.mDrawPath = motionWidget.mMotion.mDrawPath;
        this.mAnimateCircleAngleTo = motionWidget.mMotion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.mPropertySet.mProgress;
        if (motionWidget.mWidgetFrame != null && motionWidget.mWidgetFrame.widget != null) {
            this.mRelativeAngle = motionWidget.mWidgetFrame.widget.mCircleConstraintAngle;
        }
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomAttributes.put(str, customAttribute);
            }
        }
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionPaths motionPaths) {
        return compareTo2(motionPaths);
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean diff = diff(this.mX, motionPaths.mX);
        boolean diff2 = diff(this.mY, motionPaths.mY);
        int i = 0 + 1;
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        int i2 = i + 1;
        zArr[i] = zArr[i] | (diff || diff2 || z);
        int i3 = i2 + 1;
        zArr[i2] = zArr[i2] | (diff || diff2 || z);
        int i4 = i3 + 1;
        zArr[i3] = zArr[i3] | diff(this.mWidth, motionPaths.mWidth);
        int i5 = i4 + 1;
        zArr[i4] = zArr[i4] | diff(this.mHeight, motionPaths.mHeight);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < fArr.length) {
                dArr[i] = fArr[iArr[i2]];
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.mX;
        float f2 = this.mY;
        float f3 = this.mWidth;
        float f4 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            switch (iArr[i2]) {
                case 3:
                    f3 = f5;
                    break;
                case 4:
                    f4 = f5;
                    break;
            }
        }
        fArr[i] = f3;
        fArr[i + 1] = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f;
        float f2 = this.mX;
        float f3 = this.mY;
        float f4 = this.mWidth;
        float f5 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f6 = (float) dArr[i2];
            switch (iArr[i2]) {
                case 1:
                    f2 = f6;
                    break;
                case 2:
                    f3 = f6;
                    break;
                case 3:
                    f4 = f6;
                    break;
                case 4:
                    f5 = f6;
                    break;
            }
        }
        if (this.mRelativeToController != null) {
            float[] fArr2 = new float[2];
            this.mRelativeToController.getCenter(d, fArr2, new float[2]);
            float f7 = fArr2[0];
            float f8 = fArr2[1];
            float f9 = f2;
            float f10 = f3;
            f = 2.0f;
            float sin = (float) ((f7 + (Math.sin(f10) * f9)) - (f4 / 2.0f));
            f3 = (float) ((f8 - (Math.cos(f10) * f9)) - (f5 / 2.0f));
            f2 = sin;
        } else {
            f = 2.0f;
        }
        fArr[i] = (f4 / f) + f2 + 0.0f;
        fArr[i + 1] = (f5 / f) + f3 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        float f2;
        float f3;
        float f4 = this.mX;
        float f5 = this.mY;
        float f6 = this.mWidth;
        float f7 = this.mHeight;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f12 = (float) dArr[i];
            float f13 = (float) dArr2[i];
            switch (iArr[i]) {
                case 1:
                    f4 = f12;
                    f8 = f13;
                    break;
                case 2:
                    f5 = f12;
                    f9 = f13;
                    break;
                case 3:
                    f6 = f12;
                    f10 = f13;
                    break;
                case 4:
                    f7 = f12;
                    f11 = f13;
                    break;
            }
        }
        float f14 = (f10 / 2.0f) + f8;
        float f15 = (f11 / 2.0f) + f9;
        if (this.mRelativeToController != null) {
            f3 = 2.0f;
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            float f16 = f4;
            float f17 = f5;
            this.mRelativeToController.getCenter(d, fArr3, fArr4);
            float f18 = fArr3[0];
            float f19 = fArr3[1];
            float f20 = f8;
            float f21 = f9;
            float f22 = fArr4[0];
            float f23 = fArr4[1];
            f = f6;
            f2 = f7;
            float sin = (float) ((f18 + (Math.sin(f17) * f16)) - (f / 2.0f));
            float cos = (float) ((f19 - (f16 * Math.cos(f17))) - (f2 / 2.0f));
            f14 = (float) (f22 + (Math.sin(f17) * f20) + (f21 * Math.cos(f17)));
            f15 = (float) ((f23 - (f20 * Math.cos(f17))) + (f21 * Math.sin(f17)));
            f4 = sin;
            f5 = cos;
        } else {
            f = f6;
            f2 = f7;
            f3 = 2.0f;
        }
        fArr[0] = (f / f3) + f4 + 0.0f;
        fArr[1] = (f2 / f3) + f5 + 0.0f;
        fArr2[0] = f14;
        fArr2[1] = f15;
    }

    void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f;
        float f2 = this.mX;
        float f3 = this.mY;
        float f4 = this.mWidth;
        float f5 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f6 = (float) dArr[i2];
            switch (iArr[i2]) {
                case 1:
                    f2 = f6;
                    break;
                case 2:
                    f3 = f6;
                    break;
                case 3:
                    f4 = f6;
                    break;
                case 4:
                    f5 = f6;
                    break;
            }
        }
        if (this.mRelativeToController != null) {
            float[] fArr2 = new float[2];
            this.mRelativeToController.getCenter(d, fArr2, new float[2]);
            float f7 = fArr2[0];
            float f8 = fArr2[1];
            float f9 = f2;
            float f10 = f3;
            f = 2.0f;
            float sin = (float) ((f7 + (Math.sin(f10) * f9)) - (f4 / 2.0f));
            f3 = (float) ((f8 - (Math.cos(f10) * f9)) - (f5 / 2.0f));
            f2 = sin;
        } else {
            f = 2.0f;
        }
        fArr[i] = (f4 / f) + f2 + 0.0f;
        fArr[i + 1] = (f5 / f) + f3 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[numberOfInterpolatedValues]);
        int i2 = 0;
        while (i2 < numberOfInterpolatedValues) {
            dArr[i] = r2[i2];
            i2++;
            i++;
        }
        return numberOfInterpolatedValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        int[] iArr2 = iArr;
        float f10 = this.mX;
        float f11 = this.mY;
        float f12 = this.mWidth;
        float f13 = this.mHeight;
        float f14 = f10;
        int i2 = 0;
        while (true) {
            float f15 = f11;
            if (i2 >= iArr2.length) {
                if (this.mRelativeToController != null) {
                    float centerX = this.mRelativeToController.getCenterX();
                    float centerY = this.mRelativeToController.getCenterY();
                    float f16 = f14;
                    f3 = 2.0f;
                    float sin = (float) ((centerX + (Math.sin(f15) * f16)) - (f12 / 2.0f));
                    f2 = f13;
                    f = f12;
                    f4 = (float) ((centerY - (f16 * Math.cos(f15))) - (f2 / 2.0f));
                    f5 = sin;
                } else {
                    f = f12;
                    f2 = f13;
                    f3 = 2.0f;
                    f4 = f15;
                    f5 = f14;
                }
                float f17 = f5;
                float f18 = f4;
                float f19 = f5 + f;
                float f20 = f18;
                float f21 = f19;
                float f22 = f4 + f2;
                float f23 = f17;
                float f24 = f22;
                float f25 = f18 + (f2 / f3);
                float f26 = !Float.isNaN(Float.NaN) ? f17 + ((f19 - f17) * Float.NaN) : f17 + (f / f3);
                float f27 = !Float.isNaN(Float.NaN) ? f18 + ((f22 - f18) * Float.NaN) : f25;
                if (1.0f != 1.0f) {
                    float f28 = (f17 + f19) / f3;
                    f19 = ((f19 - f28) * 1.0f) + f28;
                    f21 = ((f21 - f28) * 1.0f) + f28;
                    f23 = ((f23 - f28) * 1.0f) + f28;
                    f6 = ((f17 - f28) * 1.0f) + f28;
                } else {
                    f6 = f17;
                }
                if (1.0f != 1.0f) {
                    float f29 = (f18 + f22) / f3;
                    f20 = ((f20 - f29) * 1.0f) + f29;
                    f22 = ((f22 - f29) * 1.0f) + f29;
                    f24 = ((f24 - f29) * 1.0f) + f29;
                    f7 = ((f18 - f29) * 1.0f) + f29;
                } else {
                    f7 = f18;
                }
                if (0.0f != 0.0f) {
                    float sin2 = (float) Math.sin(Math.toRadians(0.0f));
                    float cos = (float) Math.cos(Math.toRadians(0.0f));
                    float xRotate = xRotate(sin2, cos, f26, f27, f6, f7);
                    float yRotate = yRotate(sin2, cos, f26, f27, f6, f7);
                    float f30 = f19;
                    float f31 = f20;
                    f19 = xRotate(sin2, cos, f26, f27, f30, f31);
                    f20 = yRotate(sin2, cos, f26, f27, f30, f31);
                    float f32 = f21;
                    float f33 = f22;
                    f21 = xRotate(sin2, cos, f26, f27, f32, f33);
                    f22 = yRotate(sin2, cos, f26, f27, f32, f33);
                    float f34 = f23;
                    float f35 = f24;
                    f23 = xRotate(sin2, cos, f26, f27, f34, f35);
                    f24 = yRotate(sin2, cos, f26, f27, f34, f35);
                    f8 = xRotate;
                    f9 = yRotate;
                } else {
                    f8 = f6;
                    f9 = f7;
                }
                int i3 = i + 1;
                fArr[i] = f8 + 0.0f;
                int i4 = i3 + 1;
                fArr[i3] = f9 + 0.0f;
                int i5 = i4 + 1;
                fArr[i4] = f19 + 0.0f;
                int i6 = i5 + 1;
                fArr[i5] = f20 + 0.0f;
                int i7 = i6 + 1;
                fArr[i6] = f21 + 0.0f;
                int i8 = i7 + 1;
                fArr[i7] = f22 + 0.0f;
                int i9 = i8 + 1;
                fArr[i8] = f23 + 0.0f;
                int i10 = i9 + 1;
                fArr[i9] = f24 + 0.0f;
                return;
            }
            int i11 = i2;
            float f36 = (float) dArr[i11];
            switch (iArr[i11]) {
                case 1:
                    f14 = f36;
                    break;
                case 2:
                    f15 = f36;
                    break;
                case 3:
                    f12 = f36;
                    break;
                case 4:
                    f13 = f36;
                    break;
            }
            i2 = i11 + 1;
            iArr2 = iArr;
            f11 = f15;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.mCustomAttributes.containsKey(str);
    }

    void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f2 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f3 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth - motionPaths.mWidth;
        float f5 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        float f6 = motionPaths.mX + (motionPaths.mWidth / 2.0f);
        float f7 = motionPaths.mY + (motionPaths.mHeight / 2.0f);
        float f8 = (motionPaths2.mX + (motionPaths2.mWidth / 2.0f)) - f6;
        float f9 = (motionPaths2.mY + (motionPaths2.mHeight / 2.0f)) - f7;
        this.mX = (int) ((motionPaths.mX + (f8 * f)) - ((f4 * f2) / 2.0f));
        this.mY = (int) ((motionPaths.mY + (f9 * f)) - ((f5 * f3) / 2.0f));
        this.mWidth = (int) (motionPaths.mWidth + (f4 * f2));
        this.mHeight = (int) (motionPaths.mHeight + (f5 * f3));
        float f10 = Float.isNaN(motionKeyPosition.mPercentX) ? f : motionKeyPosition.mPercentX;
        float f11 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        float f12 = Float.isNaN(motionKeyPosition.mPercentY) ? f : motionKeyPosition.mPercentY;
        float f13 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((motionPaths.mX + (f8 * f10)) + (f9 * f13)) - ((f4 * f2) / 2.0f));
        this.mY = (int) (((motionPaths.mY + (f8 * f11)) + (f9 * f12)) - ((f5 * f3) / 2.0f));
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f2 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f3 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth - motionPaths.mWidth;
        float f5 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        float f6 = Float.isNaN(motionKeyPosition.mPercentX) ? f : motionKeyPosition.mPercentX;
        float f7 = motionPaths.mX + (motionPaths.mWidth / 2.0f);
        float f8 = motionPaths.mY + (motionPaths.mHeight / 2.0f);
        float f9 = (motionPaths2.mX + (motionPaths2.mWidth / 2.0f)) - f7;
        float f10 = (motionPaths2.mY + (motionPaths2.mHeight / 2.0f)) - f8;
        this.mX = (int) ((motionPaths.mX + (f9 * f6)) - ((f4 * f2) / 2.0f));
        this.mY = (int) ((motionPaths.mY + (f10 * f6)) - ((f5 * f3) / 2.0f));
        this.mWidth = (int) (motionPaths.mWidth + (f4 * f2));
        this.mHeight = (int) (motionPaths.mHeight + (f5 * f3));
        float f11 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        this.mX = (int) ((motionPaths.mX + (f9 * f6)) - ((f4 * f2) / 2.0f));
        this.mY = (int) ((motionPaths.mY + (f10 * f6)) - ((f5 * f3) / 2.0f));
        this.mX += (-f10) * f11;
        this.mY += f9 * f11;
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    void initPolar(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f2 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f3 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth - motionPaths.mWidth;
        float f5 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (int) (motionPaths.mWidth + (f4 * f2));
        this.mHeight = (int) (motionPaths.mHeight + (f5 * f3));
        float f6 = 1.0f - f;
        switch (motionKeyPosition.mPositionType) {
            case 1:
                this.mX = ((Float.isNaN(motionKeyPosition.mPercentX) ? f : motionKeyPosition.mPercentX) * (motionPaths2.mX - motionPaths.mX)) + motionPaths.mX;
                this.mY = ((Float.isNaN(motionKeyPosition.mPercentY) ? f : motionKeyPosition.mPercentY) * (motionPaths2.mY - motionPaths.mY)) + motionPaths.mY;
                break;
            case 2:
                this.mX = Float.isNaN(motionKeyPosition.mPercentX) ? ((motionPaths2.mX - motionPaths.mX) * f) + motionPaths.mX : motionKeyPosition.mPercentX * Math.min(f3, f2);
                this.mY = Float.isNaN(motionKeyPosition.mPercentY) ? ((motionPaths2.mY - motionPaths.mY) * f) + motionPaths.mY : motionKeyPosition.mPercentY;
                break;
            default:
                this.mX = ((Float.isNaN(motionKeyPosition.mPercentX) ? f : motionKeyPosition.mPercentX) * (motionPaths2.mX - motionPaths.mX)) + motionPaths.mX;
                this.mY = ((Float.isNaN(motionKeyPosition.mPercentY) ? f : motionKeyPosition.mPercentY) * (motionPaths2.mY - motionPaths.mY)) + motionPaths.mY;
                break;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    void initScreen(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i3;
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f2 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f3 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth - motionPaths.mWidth;
        float f5 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        float f6 = motionPaths.mX + (motionPaths.mWidth / 2.0f);
        float f7 = motionPaths.mY + (motionPaths.mHeight / 2.0f);
        float f8 = motionPaths2.mX + (motionPaths2.mWidth / 2.0f);
        float f9 = motionPaths2.mY + (motionPaths2.mHeight / 2.0f);
        this.mX = (int) ((motionPaths.mX + ((f8 - f6) * f)) - ((f4 * f2) / 2.0f));
        this.mY = (int) ((motionPaths.mY + ((f9 - f7) * f)) - ((f5 * f3) / 2.0f));
        this.mWidth = (int) (motionPaths.mWidth + (f4 * f2));
        this.mHeight = (int) (motionPaths.mHeight + (f5 * f3));
        this.mMode = 2;
        if (Float.isNaN(motionKeyPosition.mPercentX)) {
            i3 = i;
        } else {
            i3 = i - ((int) this.mWidth);
            this.mX = (int) (i3 * motionKeyPosition.mPercentX);
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.mY = (int) ((i2 - ((int) this.mHeight)) * motionKeyPosition.mPercentY);
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBounds(float f, float f2, float f3, float f4) {
        this.mX = f;
        this.mY = f2;
        this.mWidth = f3;
        this.mHeight = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            switch (iArr[i]) {
                case 1:
                    f3 = f7;
                    break;
                case 2:
                    f4 = f7;
                    break;
                case 3:
                    f5 = f7;
                    break;
                case 4:
                    f6 = f7;
                    break;
            }
        }
        float f8 = f3 - ((0.0f * f5) / 2.0f);
        float f9 = f4 - ((0.0f * f6) / 2.0f);
        fArr[0] = ((1.0f - f) * f8) + ((f8 + ((0.0f + 1.0f) * f5)) * f) + 0.0f;
        fArr[1] = ((1.0f - f2) * f9) + ((f9 + ((0.0f + 1.0f) * f6)) * f2) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setView(float f, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        char c;
        float f2;
        float f3;
        float f4;
        int i;
        float f5;
        double d;
        float f6 = this.mX;
        float f7 = this.mY;
        float f8 = this.mWidth;
        float f9 = this.mHeight;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = Float.NaN;
        if (iArr.length != 0) {
            c = 1;
            if (this.mTempValue.length <= iArr[iArr.length - 1]) {
                int i2 = iArr[iArr.length - 1] + 1;
                this.mTempValue = new double[i2];
                this.mTempDelta = new double[i2];
            }
        } else {
            c = 1;
        }
        float f15 = f6;
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.mTempValue[iArr[i3]] = dArr[i3];
            this.mTempDelta[iArr[i3]] = dArr2[i3];
        }
        int i4 = 0;
        float f16 = f7;
        while (i4 < this.mTempValue.length) {
            if (Double.isNaN(this.mTempValue[i4])) {
                if (dArr3 == null) {
                    i = i4;
                    f5 = f16;
                } else if (dArr3[i4] == 0.0d) {
                    i = i4;
                    f5 = f16;
                }
                f16 = f5;
                i4 = i + 1;
            }
            double d2 = dArr3 != null ? dArr3[i4] : 0.0d;
            if (Double.isNaN(this.mTempValue[i4])) {
                i = i4;
                f5 = f16;
                d = d2;
            } else {
                i = i4;
                f5 = f16;
                d = this.mTempValue[i4] + d2;
            }
            float f17 = (float) d;
            float f18 = (float) this.mTempDelta[i];
            switch (i) {
                case 0:
                    f16 = f5;
                    break;
                case 1:
                    f10 = f18;
                    f15 = f17;
                    f16 = f5;
                    break;
                case 2:
                    f16 = f17;
                    f11 = f18;
                    break;
                case 3:
                    f12 = f18;
                    f8 = f17;
                    f16 = f5;
                    break;
                case 4:
                    f13 = f18;
                    f9 = f17;
                    f16 = f5;
                    break;
                case 5:
                    f14 = f17;
                    f16 = f5;
                    break;
                default:
                    f16 = f5;
                    break;
            }
            i4 = i + 1;
        }
        float f19 = f16;
        if (this.mRelativeToController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            f2 = f8;
            f3 = f9;
            this.mRelativeToController.getCenter(f, fArr, fArr2);
            float f20 = fArr[0];
            float f21 = fArr[c];
            float f22 = f15;
            float f23 = f10;
            float f24 = f11;
            float f25 = fArr2[0];
            float f26 = fArr2[c];
            float sin = (float) ((f20 + (Math.sin(f19) * f22)) - (f2 / 2.0f));
            float cos = (float) ((f21 - (Math.cos(f19) * f22)) - (f3 / 2.0f));
            float sin2 = (float) (f25 + (Math.sin(f19) * f23) + (f24 * Math.cos(f19) * f22));
            float cos2 = (float) ((f26 - (f23 * Math.cos(f19))) + (Math.sin(f19) * f22 * f24));
            f15 = sin;
            if (dArr2.length >= 2) {
                dArr2[0] = sin2;
                dArr2[c] = cos2;
            }
            if (!Float.isNaN(f14)) {
                motionWidget.setRotationZ((float) (f14 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f4 = cos;
        } else {
            f2 = f8;
            f3 = f9;
            float f27 = f10;
            float f28 = f11;
            float f29 = f12;
            float f30 = f13;
            if (!Float.isNaN(f14)) {
                motionWidget.setRotationZ(0.0f + ((float) (f14 + Math.toDegrees(Math.atan2(f28 + (f30 / 2.0f), f27 + (f29 / 2.0f))))));
            }
            f4 = f19;
        }
        int i5 = (int) (f15 + 0.5f);
        int i6 = (int) (f4 + 0.5f);
        int i7 = (int) (f15 + 0.5f + f2);
        int i8 = (int) (0.5f + f4 + f3);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        motionWidget.layout(i5, i6, i7, i8);
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = ((this.mX + (this.mWidth / 2.0f)) - motionPaths.mX) - (motionPaths.mWidth / 2.0f);
        double d2 = ((this.mY + (this.mHeight / 2.0f)) - motionPaths.mY) - (motionPaths.mHeight / 2.0f);
        this.mRelativeToController = motion;
        this.mX = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians(this.mRelativeAngle);
        }
    }
}
