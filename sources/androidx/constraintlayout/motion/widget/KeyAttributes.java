package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class KeyAttributes extends Key {
    private static final boolean DEBUG = false;
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttributes";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private boolean mVisibility = false;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;

    /* loaded from: classes.dex */
    private static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static SparseIntArray sAttrMap = new SparseIntArray();

        static {
            sAttrMap.append(R.styleable.KeyAttribute_android_alpha, 1);
            sAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
            sAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
            sAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
            sAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
            sAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            sAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            sAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
            sAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            sAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
            sAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
            sAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
            sAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
            sAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
            sAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
            sAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
            sAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
            sAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        private Loader() {
        }

        public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (sAttrMap.get(index)) {
                    case 1:
                        KeyAttributes.access$002(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$000(keyAttributes)));
                        break;
                    case 2:
                        KeyAttributes.access$102(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$100(keyAttributes)));
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e(KeyAttributes.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + sAttrMap.get(index));
                        break;
                    case 4:
                        KeyAttributes.access$202(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$200(keyAttributes)));
                        break;
                    case 5:
                        KeyAttributes.access$502(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$500(keyAttributes)));
                        break;
                    case 6:
                        KeyAttributes.access$602(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$600(keyAttributes)));
                        break;
                    case 7:
                        KeyAttributes.access$402(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$400(keyAttributes)));
                        break;
                    case 8:
                        KeyAttributes.access$1102(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1100(keyAttributes)));
                        break;
                    case 9:
                        KeyAttributes.access$902(keyAttributes, typedArray.getString(index));
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            if (keyAttributes.mTargetId == -1) {
                                keyAttributes.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyAttributes.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            break;
                        }
                    case 12:
                        keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                        break;
                    case 13:
                        KeyAttributes.access$302(keyAttributes, typedArray.getInteger(index, KeyAttributes.access$300(keyAttributes)));
                        break;
                    case 14:
                        KeyAttributes.access$1002(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1000(keyAttributes)));
                        break;
                    case 15:
                        KeyAttributes.access$1202(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1200(keyAttributes)));
                        break;
                    case 16:
                        KeyAttributes.access$1302(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1300(keyAttributes)));
                        break;
                    case 17:
                        int i2 = Build.VERSION.SDK_INT;
                        KeyAttributes.access$1402(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1400(keyAttributes)));
                        break;
                    case 18:
                        KeyAttributes.access$1502(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1500(keyAttributes)));
                        break;
                    case 19:
                        KeyAttributes.access$702(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$700(keyAttributes)));
                        break;
                    case 20:
                        KeyAttributes.access$802(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$800(keyAttributes)));
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap<>();
    }

    static /* synthetic */ float access$000(KeyAttributes keyAttributes) {
        return keyAttributes.mAlpha;
    }

    static /* synthetic */ float access$002(KeyAttributes keyAttributes, float f) {
        keyAttributes.mAlpha = f;
        return f;
    }

    static /* synthetic */ float access$100(KeyAttributes keyAttributes) {
        return keyAttributes.mElevation;
    }

    static /* synthetic */ float access$1000(KeyAttributes keyAttributes) {
        return keyAttributes.mScaleY;
    }

    static /* synthetic */ float access$1002(KeyAttributes keyAttributes, float f) {
        keyAttributes.mScaleY = f;
        return f;
    }

    static /* synthetic */ float access$102(KeyAttributes keyAttributes, float f) {
        keyAttributes.mElevation = f;
        return f;
    }

    static /* synthetic */ float access$1100(KeyAttributes keyAttributes) {
        return keyAttributes.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1102(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTransitionPathRotate = f;
        return f;
    }

    static /* synthetic */ float access$1200(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationX;
    }

    static /* synthetic */ float access$1202(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationX = f;
        return f;
    }

    static /* synthetic */ float access$1300(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationY;
    }

    static /* synthetic */ float access$1302(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationY = f;
        return f;
    }

    static /* synthetic */ float access$1400(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationZ;
    }

    static /* synthetic */ float access$1402(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationZ = f;
        return f;
    }

    static /* synthetic */ float access$1500(KeyAttributes keyAttributes) {
        return keyAttributes.mProgress;
    }

    static /* synthetic */ float access$1502(KeyAttributes keyAttributes, float f) {
        keyAttributes.mProgress = f;
        return f;
    }

    static /* synthetic */ float access$200(KeyAttributes keyAttributes) {
        return keyAttributes.mRotation;
    }

    static /* synthetic */ float access$202(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotation = f;
        return f;
    }

    static /* synthetic */ int access$300(KeyAttributes keyAttributes) {
        return keyAttributes.mCurveFit;
    }

    static /* synthetic */ int access$302(KeyAttributes keyAttributes, int i) {
        keyAttributes.mCurveFit = i;
        return i;
    }

    static /* synthetic */ float access$400(KeyAttributes keyAttributes) {
        return keyAttributes.mScaleX;
    }

    static /* synthetic */ float access$402(KeyAttributes keyAttributes, float f) {
        keyAttributes.mScaleX = f;
        return f;
    }

    static /* synthetic */ float access$500(KeyAttributes keyAttributes) {
        return keyAttributes.mRotationX;
    }

    static /* synthetic */ float access$502(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotationX = f;
        return f;
    }

    static /* synthetic */ float access$600(KeyAttributes keyAttributes) {
        return keyAttributes.mRotationY;
    }

    static /* synthetic */ float access$602(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotationY = f;
        return f;
    }

    static /* synthetic */ float access$700(KeyAttributes keyAttributes) {
        return keyAttributes.mPivotX;
    }

    static /* synthetic */ float access$702(KeyAttributes keyAttributes, float f) {
        keyAttributes.mPivotX = f;
        return f;
    }

    static /* synthetic */ float access$800(KeyAttributes keyAttributes) {
        return keyAttributes.mPivotY;
    }

    static /* synthetic */ float access$802(KeyAttributes keyAttributes, float f) {
        keyAttributes.mPivotY = f;
        return f;
    }

    static /* synthetic */ String access$902(KeyAttributes keyAttributes, String str) {
        keyAttributes.mTransitionEasing = str;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0068, code lost:
    
        if (r1.equals("elevation") != false) goto L59;
     */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r8) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.addValues(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyAttributes().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo39clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.mCurveFit = keyAttributes.mCurveFit;
        this.mVisibility = keyAttributes.mVisibility;
        this.mAlpha = keyAttributes.mAlpha;
        this.mElevation = keyAttributes.mElevation;
        this.mRotation = keyAttributes.mRotation;
        this.mRotationX = keyAttributes.mRotationX;
        this.mRotationY = keyAttributes.mRotationY;
        this.mPivotX = keyAttributes.mPivotX;
        this.mPivotY = keyAttributes.mPivotY;
        this.mTransitionPathRotate = keyAttributes.mTransitionPathRotate;
        this.mScaleX = keyAttributes.mScaleX;
        this.mScaleY = keyAttributes.mScaleY;
        this.mTranslationX = keyAttributes.mTranslationX;
        this.mTranslationY = keyAttributes.mTranslationY;
        this.mTranslationZ = keyAttributes.mTranslationZ;
        this.mProgress = keyAttributes.mProgress;
        this.mTransitionEasing = keyAttributes.mTransitionEasing;
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
        if (!Float.isNaN(this.mPivotX)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashSet.add(Key.PIVOT_Y);
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
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            hashMap.put("alpha", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            hashMap.put("elevation", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            hashMap.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashMap.put("rotationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashMap.put("rotationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashMap.put(Key.PIVOT_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashMap.put(Key.PIVOT_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashMap.put("translationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashMap.put("translationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashMap.put("translationZ", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashMap.put("scaleX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashMap.put("scaleY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            hashMap.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.mCurveFit));
            }
        }
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
                    c = 11;
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
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -760884510:
                if (str.equals(Key.PIVOT_X)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -760884509:
                if (str.equals(Key.PIVOT_Y)) {
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
                    c = '\r';
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
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
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
                this.mPivotX = toFloat(obj);
                return;
            case '\b':
                this.mPivotY = toFloat(obj);
                return;
            case '\t':
                this.mScaleX = toFloat(obj);
                return;
            case '\n':
                this.mScaleY = toFloat(obj);
                return;
            case 11:
                this.mTransitionEasing = obj.toString();
                return;
            case '\f':
                this.mVisibility = toBoolean(obj);
                return;
            case '\r':
                this.mTransitionPathRotate = toFloat(obj);
                return;
            case 14:
                this.mTranslationX = toFloat(obj);
                return;
            case 15:
                this.mTranslationY = toFloat(obj);
                return;
            case 16:
                this.mTranslationZ = toFloat(obj);
                return;
            default:
                return;
        }
    }
}
