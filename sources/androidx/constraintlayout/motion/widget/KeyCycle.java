package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
    private String mTransitionEasing = null;
    private int mCurveFit = 0;
    private int mWaveShape = -1;
    private String mCustomWaveShape = null;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mWavePhase = 0.0f;
    private float mProgress = Float.NaN;
    private int mWaveVariesBy = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    /* loaded from: classes.dex */
    private static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_PHASE = 21;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray sAttrMap = new SparseIntArray();

        static {
            sAttrMap.append(R.styleable.KeyCycle_motionTarget, 1);
            sAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            sAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            sAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            sAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            sAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            sAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            sAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            sAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            sAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            sAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            sAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            sAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            sAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            sAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            sAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            sAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            sAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            sAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            sAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
            sAttrMap.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        private Loader() {
        }

        static /* synthetic */ void access$000(KeyCycle keyCycle, TypedArray typedArray) {
            read(keyCycle, typedArray);
        }

        private static void read(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (sAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            if (keyCycle.mTargetId == -1) {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyCycle.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            break;
                        }
                    case 2:
                        keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                        break;
                    case 3:
                        KeyCycle.access$102(keyCycle, typedArray.getString(index));
                        break;
                    case 4:
                        KeyCycle.access$202(keyCycle, typedArray.getInteger(index, KeyCycle.access$200(keyCycle)));
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            KeyCycle.access$302(keyCycle, typedArray.getString(index));
                            KeyCycle.access$402(keyCycle, 7);
                            break;
                        } else {
                            KeyCycle.access$402(keyCycle, typedArray.getInt(index, KeyCycle.access$400(keyCycle)));
                            break;
                        }
                    case 6:
                        KeyCycle.access$502(keyCycle, typedArray.getFloat(index, KeyCycle.access$500(keyCycle)));
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            KeyCycle.access$602(keyCycle, typedArray.getDimension(index, KeyCycle.access$600(keyCycle)));
                            break;
                        } else {
                            KeyCycle.access$602(keyCycle, typedArray.getFloat(index, KeyCycle.access$600(keyCycle)));
                            break;
                        }
                    case 8:
                        KeyCycle.access$702(keyCycle, typedArray.getInt(index, KeyCycle.access$700(keyCycle)));
                        break;
                    case 9:
                        KeyCycle.access$802(keyCycle, typedArray.getFloat(index, KeyCycle.access$800(keyCycle)));
                        break;
                    case 10:
                        KeyCycle.access$902(keyCycle, typedArray.getDimension(index, KeyCycle.access$900(keyCycle)));
                        break;
                    case 11:
                        KeyCycle.access$1002(keyCycle, typedArray.getFloat(index, KeyCycle.access$1000(keyCycle)));
                        break;
                    case 12:
                        KeyCycle.access$1102(keyCycle, typedArray.getFloat(index, KeyCycle.access$1100(keyCycle)));
                        break;
                    case 13:
                        KeyCycle.access$1202(keyCycle, typedArray.getFloat(index, KeyCycle.access$1200(keyCycle)));
                        break;
                    case 14:
                        KeyCycle.access$1302(keyCycle, typedArray.getFloat(index, KeyCycle.access$1300(keyCycle)));
                        break;
                    case 15:
                        KeyCycle.access$1402(keyCycle, typedArray.getFloat(index, KeyCycle.access$1400(keyCycle)));
                        break;
                    case 16:
                        KeyCycle.access$1502(keyCycle, typedArray.getFloat(index, KeyCycle.access$1500(keyCycle)));
                        break;
                    case 17:
                        KeyCycle.access$1602(keyCycle, typedArray.getDimension(index, KeyCycle.access$1600(keyCycle)));
                        break;
                    case 18:
                        KeyCycle.access$1702(keyCycle, typedArray.getDimension(index, KeyCycle.access$1700(keyCycle)));
                        break;
                    case 19:
                        int i2 = Build.VERSION.SDK_INT;
                        KeyCycle.access$1802(keyCycle, typedArray.getDimension(index, KeyCycle.access$1800(keyCycle)));
                        break;
                    case 20:
                        KeyCycle.access$1902(keyCycle, typedArray.getFloat(index, KeyCycle.access$1900(keyCycle)));
                        break;
                    case 21:
                        KeyCycle.access$2002(keyCycle, typedArray.getFloat(index, KeyCycle.access$2000(keyCycle)) / 360.0f);
                        break;
                    default:
                        Log.e(TypedValues.CycleType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + sAttrMap.get(index));
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    static /* synthetic */ float access$1000(KeyCycle keyCycle) {
        return keyCycle.mRotation;
    }

    static /* synthetic */ float access$1002(KeyCycle keyCycle, float f) {
        keyCycle.mRotation = f;
        return f;
    }

    static /* synthetic */ String access$102(KeyCycle keyCycle, String str) {
        keyCycle.mTransitionEasing = str;
        return str;
    }

    static /* synthetic */ float access$1100(KeyCycle keyCycle) {
        return keyCycle.mRotationX;
    }

    static /* synthetic */ float access$1102(KeyCycle keyCycle, float f) {
        keyCycle.mRotationX = f;
        return f;
    }

    static /* synthetic */ float access$1200(KeyCycle keyCycle) {
        return keyCycle.mRotationY;
    }

    static /* synthetic */ float access$1202(KeyCycle keyCycle, float f) {
        keyCycle.mRotationY = f;
        return f;
    }

    static /* synthetic */ float access$1300(KeyCycle keyCycle) {
        return keyCycle.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1302(KeyCycle keyCycle, float f) {
        keyCycle.mTransitionPathRotate = f;
        return f;
    }

    static /* synthetic */ float access$1400(KeyCycle keyCycle) {
        return keyCycle.mScaleX;
    }

    static /* synthetic */ float access$1402(KeyCycle keyCycle, float f) {
        keyCycle.mScaleX = f;
        return f;
    }

    static /* synthetic */ float access$1500(KeyCycle keyCycle) {
        return keyCycle.mScaleY;
    }

    static /* synthetic */ float access$1502(KeyCycle keyCycle, float f) {
        keyCycle.mScaleY = f;
        return f;
    }

    static /* synthetic */ float access$1600(KeyCycle keyCycle) {
        return keyCycle.mTranslationX;
    }

    static /* synthetic */ float access$1602(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationX = f;
        return f;
    }

    static /* synthetic */ float access$1700(KeyCycle keyCycle) {
        return keyCycle.mTranslationY;
    }

    static /* synthetic */ float access$1702(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationY = f;
        return f;
    }

    static /* synthetic */ float access$1800(KeyCycle keyCycle) {
        return keyCycle.mTranslationZ;
    }

    static /* synthetic */ float access$1802(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationZ = f;
        return f;
    }

    static /* synthetic */ float access$1900(KeyCycle keyCycle) {
        return keyCycle.mProgress;
    }

    static /* synthetic */ float access$1902(KeyCycle keyCycle, float f) {
        keyCycle.mProgress = f;
        return f;
    }

    static /* synthetic */ int access$200(KeyCycle keyCycle) {
        return keyCycle.mCurveFit;
    }

    static /* synthetic */ float access$2000(KeyCycle keyCycle) {
        return keyCycle.mWavePhase;
    }

    static /* synthetic */ float access$2002(KeyCycle keyCycle, float f) {
        keyCycle.mWavePhase = f;
        return f;
    }

    static /* synthetic */ int access$202(KeyCycle keyCycle, int i) {
        keyCycle.mCurveFit = i;
        return i;
    }

    static /* synthetic */ String access$302(KeyCycle keyCycle, String str) {
        keyCycle.mCustomWaveShape = str;
        return str;
    }

    static /* synthetic */ int access$400(KeyCycle keyCycle) {
        return keyCycle.mWaveShape;
    }

    static /* synthetic */ int access$402(KeyCycle keyCycle, int i) {
        keyCycle.mWaveShape = i;
        return i;
    }

    static /* synthetic */ float access$500(KeyCycle keyCycle) {
        return keyCycle.mWavePeriod;
    }

    static /* synthetic */ float access$502(KeyCycle keyCycle, float f) {
        keyCycle.mWavePeriod = f;
        return f;
    }

    static /* synthetic */ float access$600(KeyCycle keyCycle) {
        return keyCycle.mWaveOffset;
    }

    static /* synthetic */ float access$602(KeyCycle keyCycle, float f) {
        keyCycle.mWaveOffset = f;
        return f;
    }

    static /* synthetic */ int access$700(KeyCycle keyCycle) {
        return keyCycle.mWaveVariesBy;
    }

    static /* synthetic */ int access$702(KeyCycle keyCycle, int i) {
        keyCycle.mWaveVariesBy = i;
        return i;
    }

    static /* synthetic */ float access$800(KeyCycle keyCycle) {
        return keyCycle.mAlpha;
    }

    static /* synthetic */ float access$802(KeyCycle keyCycle, float f) {
        keyCycle.mAlpha = f;
        return f;
    }

    static /* synthetic */ float access$900(KeyCycle keyCycle) {
        return keyCycle.mElevation;
    }

    static /* synthetic */ float access$902(KeyCycle keyCycle, float f) {
        keyCycle.mElevation = f;
        return f;
    }

    public void addCycleValues(HashMap<String, ViewOscillator> hashMap) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring("CUSTOM".length() + 1));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (viewOscillator = hashMap.get(str)) != null) {
                    viewOscillator.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (viewOscillator2 = hashMap.get(str)) != null) {
                    viewOscillator2.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
        char c;
        Debug.logStack(TypedValues.CycleType.NAME, "add " + hashMap.size() + " values", 2);
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(str);
            if (viewSpline != null) {
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            c = 7;
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals(Key.ROTATION)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            c = '\f';
                            break;
                        }
                        break;
                }
                c = 65535;
                switch (c) {
                    case 0:
                        viewSpline.setPoint(this.mFramePosition, this.mAlpha);
                        break;
                    case 1:
                        viewSpline.setPoint(this.mFramePosition, this.mElevation);
                        break;
                    case 2:
                        viewSpline.setPoint(this.mFramePosition, this.mRotation);
                        break;
                    case 3:
                        viewSpline.setPoint(this.mFramePosition, this.mRotationX);
                        break;
                    case 4:
                        viewSpline.setPoint(this.mFramePosition, this.mRotationY);
                        break;
                    case 5:
                        viewSpline.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                        break;
                    case 6:
                        viewSpline.setPoint(this.mFramePosition, this.mScaleX);
                        break;
                    case 7:
                        viewSpline.setPoint(this.mFramePosition, this.mScaleY);
                        break;
                    case '\b':
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationX);
                        break;
                    case '\t':
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationY);
                        break;
                    case '\n':
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationZ);
                        break;
                    case 11:
                        viewSpline.setPoint(this.mFramePosition, this.mWaveOffset);
                        break;
                    case '\f':
                        viewSpline.setPoint(this.mFramePosition, this.mWavePhase);
                        break;
                    case '\r':
                        viewSpline.setPoint(this.mFramePosition, this.mProgress);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            break;
                        } else {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                            break;
                        }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyCycle().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo39clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.mTransitionEasing = keyCycle.mTransitionEasing;
        this.mCurveFit = keyCycle.mCurveFit;
        this.mWaveShape = keyCycle.mWaveShape;
        this.mCustomWaveShape = keyCycle.mCustomWaveShape;
        this.mWavePeriod = keyCycle.mWavePeriod;
        this.mWaveOffset = keyCycle.mWaveOffset;
        this.mWavePhase = keyCycle.mWavePhase;
        this.mProgress = keyCycle.mProgress;
        this.mWaveVariesBy = keyCycle.mWaveVariesBy;
        this.mAlpha = keyCycle.mAlpha;
        this.mElevation = keyCycle.mElevation;
        this.mRotation = keyCycle.mRotation;
        this.mTransitionPathRotate = keyCycle.mTransitionPathRotate;
        this.mRotationX = keyCycle.mRotationX;
        this.mRotationY = keyCycle.mRotationY;
        this.mScaleX = keyCycle.mScaleX;
        this.mScaleY = keyCycle.mScaleY;
        this.mTranslationX = keyCycle.mTranslationX;
        this.mTranslationY = keyCycle.mTranslationY;
        this.mTranslationZ = keyCycle.mTranslationZ;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public float getValue(String str) {
        char c;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c = '\f';
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
                return this.mAlpha;
            case 1:
                return this.mElevation;
            case 2:
                return this.mRotation;
            case 3:
                return this.mRotationX;
            case 4:
                return this.mRotationY;
            case 5:
                return this.mTransitionPathRotate;
            case 6:
                return this.mScaleX;
            case 7:
                return this.mScaleY;
            case '\b':
                return this.mTranslationX;
            case '\t':
                return this.mTranslationY;
            case '\n':
                return this.mTranslationZ;
            case 11:
                return this.mWaveOffset;
            case '\f':
                return this.mWavePhase;
            case '\r':
                return this.mProgress;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.access$000(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        char c;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals(Key.MOTIONPROGRESS)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 184161818:
                if (str.equals("wavePeriod")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1532805160:
                if (str.equals("waveShape")) {
                    c = 17;
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
                this.mAlpha = toFloat(obj);
                return;
            case 1:
                this.mCurveFit = toInt(obj);
                return;
            case 2:
                this.mElevation = toFloat(obj);
                return;
            case 3:
                this.mProgress = toFloat(obj);
                return;
            case 4:
                this.mRotation = toFloat(obj);
                return;
            case 5:
                this.mRotationX = toFloat(obj);
                return;
            case 6:
                this.mRotationY = toFloat(obj);
                return;
            case 7:
                this.mScaleX = toFloat(obj);
                return;
            case '\b':
                this.mScaleY = toFloat(obj);
                return;
            case '\t':
                this.mTransitionEasing = obj.toString();
                return;
            case '\n':
                this.mTransitionPathRotate = toFloat(obj);
                return;
            case 11:
                this.mTranslationX = toFloat(obj);
                return;
            case '\f':
                this.mTranslationY = toFloat(obj);
                return;
            case '\r':
                this.mTranslationZ = toFloat(obj);
                return;
            case 14:
                this.mWavePeriod = toFloat(obj);
                return;
            case 15:
                this.mWaveOffset = toFloat(obj);
                return;
            case 16:
                this.mWavePhase = toFloat(obj);
                return;
            case 17:
                if (obj instanceof Integer) {
                    this.mWaveShape = toInt(obj);
                    return;
                } else {
                    this.mWaveShape = 7;
                    this.mCustomWaveShape = obj.toString();
                    return;
                }
            default:
                return;
        }
    }
}
