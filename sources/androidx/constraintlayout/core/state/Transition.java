package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Transition implements TypedValues {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;
    int mParentEndHeight;
    int mParentEndWidth;
    int mParentInterpolateHeight;
    int mParentInterpolatedWidth;
    int mParentStartHeight;
    int mParentStartWidth;
    final CorePixelDp mToPixel;
    boolean mWrap;
    private HashMap<Integer, HashMap<String, KeyPosition>> mKeyPositions = new HashMap<>();
    private HashMap<String, WidgetState> mState = new HashMap<>();
    private TypedBundle mBundle = new TypedBundle();
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private Easing mEasing = null;
    private int mAutoTransition = 0;
    private int mDuration = 400;
    private float mStagger = 0.0f;
    private OnSwipe mOnSwipe = null;

    /* loaded from: classes.dex */
    static class KeyPosition {
        int mFrame;
        String mTarget;
        int mType;
        float mX;
        float mY;

        KeyPosition(String str, int i, int i2, float f, float f2) {
            this.mTarget = str;
            this.mFrame = i;
            this.mType = i2;
            this.mX = f;
            this.mY = f2;
        }
    }

    /* loaded from: classes.dex */
    static class OnSwipe {
        public static final int ANCHOR_SIDE_BOTTOM = 3;
        public static final int ANCHOR_SIDE_END = 6;
        public static final int ANCHOR_SIDE_LEFT = 1;
        public static final int ANCHOR_SIDE_MIDDLE = 4;
        public static final int ANCHOR_SIDE_RIGHT = 2;
        public static final int ANCHOR_SIDE_START = 5;
        public static final int ANCHOR_SIDE_TOP = 0;
        public static final int BOUNDARY_BOUNCE_BOTH = 3;
        public static final int BOUNDARY_BOUNCE_END = 2;
        public static final int BOUNDARY_BOUNCE_START = 1;
        public static final int BOUNDARY_OVERSHOOT = 0;
        public static final int DRAG_ANTICLOCKWISE = 7;
        public static final int DRAG_CLOCKWISE = 6;
        public static final int DRAG_DOWN = 1;
        public static final int DRAG_END = 5;
        public static final int DRAG_LEFT = 2;
        public static final int DRAG_RIGHT = 3;
        public static final int DRAG_START = 4;
        public static final int DRAG_UP = 0;
        public static final int MODE_CONTINUOUS_VELOCITY = 0;
        public static final int MODE_SPRING = 1;
        public static final int ON_UP_AUTOCOMPLETE = 0;
        public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
        public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
        public static final int ON_UP_DECELERATE = 4;
        public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
        public static final int ON_UP_NEVER_COMPLETE_TO_END = 7;
        public static final int ON_UP_NEVER_COMPLETE_TO_START = 6;
        public static final int ON_UP_STOP = 3;
        String mAnchorId;
        private int mAnchorSide;
        private StopEngine mEngine;
        String mLimitBoundsTo;
        private String mRotationCenterId;
        private long mStart;
        public static final String[] SIDES = {"top", "left", "right", "bottom", "middle", "start", "end"};
        private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        public static final String[] DIRECTIONS = {"up", "down", "left", "right", "start", "end", "clockwise", "anticlockwise"};
        public static final String[] MODE = {"velocity", "spring"};
        public static final String[] TOUCH_UP = {"autocomplete", "toStart", "toEnd", "stop", "decelerate", "decelerateComplete", "neverCompleteStart", "neverCompleteEnd"};
        public static final String[] BOUNDARY = {"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
        private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
        private boolean mDragVertical = true;
        private int mDragDirection = 0;
        private float mDragScale = 1.0f;
        private float mDragThreshold = 10.0f;
        private int mAutoCompleteMode = 0;
        private float mMaxVelocity = 4.0f;
        private float mMaxAcceleration = 1.2f;
        private int mOnTouchUp = 0;
        private float mSpringMass = 1.0f;
        private float mSpringStiffness = 400.0f;
        private float mSpringDamping = 10.0f;
        private float mSpringStopThreshold = 0.01f;
        private float mDestination = 0.0f;
        private int mSpringBoundary = 0;

        OnSwipe() {
        }

        void config(float f, float f2, long j, float f3) {
            SpringStopEngine springStopEngine;
            StopLogicEngine stopLogicEngine;
            StopLogicEngine.Decelerate decelerate;
            this.mStart = j;
            float signum = Math.abs(f2) > this.mMaxVelocity ? this.mMaxVelocity * Math.signum(f2) : f2;
            this.mDestination = getDestinationPosition(f, signum, f3);
            if (this.mDestination == f) {
                this.mEngine = null;
                return;
            }
            if (this.mOnTouchUp == 4 && this.mAutoCompleteMode == 0) {
                if (this.mEngine instanceof StopLogicEngine.Decelerate) {
                    decelerate = (StopLogicEngine.Decelerate) this.mEngine;
                } else {
                    decelerate = new StopLogicEngine.Decelerate();
                    this.mEngine = decelerate;
                }
                decelerate.config(f, this.mDestination, signum);
                return;
            }
            if (this.mAutoCompleteMode == 0) {
                if (this.mEngine instanceof StopLogicEngine) {
                    stopLogicEngine = (StopLogicEngine) this.mEngine;
                } else {
                    StopLogicEngine stopLogicEngine2 = new StopLogicEngine();
                    stopLogicEngine = stopLogicEngine2;
                    this.mEngine = stopLogicEngine2;
                }
                stopLogicEngine.config(f, this.mDestination, signum, f3, this.mMaxAcceleration, this.mMaxVelocity);
                return;
            }
            if (this.mEngine instanceof SpringStopEngine) {
                springStopEngine = (SpringStopEngine) this.mEngine;
            } else {
                SpringStopEngine springStopEngine2 = new SpringStopEngine();
                this.mEngine = springStopEngine2;
                springStopEngine = springStopEngine2;
            }
            springStopEngine.springConfig(f, this.mDestination, signum, this.mSpringMass, this.mSpringStiffness, this.mSpringDamping, this.mSpringStopThreshold, this.mSpringBoundary);
        }

        float getDestinationPosition(float f, float f2, float f3) {
            float abs = (((Math.abs(f2) * 0.5f) * f2) / this.mMaxAcceleration) + f;
            switch (this.mOnTouchUp) {
                case 1:
                    return f >= 1.0f ? 1.0f : 0.0f;
                case 2:
                    return f <= 0.0f ? 0.0f : 1.0f;
                case 3:
                    return Float.NaN;
                case 4:
                    return Math.max(0.0f, Math.min(1.0f, abs));
                case 5:
                    return (abs <= 0.2f || abs >= 0.8f) ? abs > 0.5f ? 1.0f : 0.0f : abs;
                case 6:
                    return 1.0f;
                case 7:
                    return 0.0f;
                default:
                    return ((double) abs) > 0.5d ? 1.0f : 0.0f;
            }
        }

        float[] getDirection() {
            return TOUCH_DIRECTION[this.mDragDirection];
        }

        float getScale() {
            return this.mDragScale;
        }

        float[] getSide() {
            return TOUCH_SIDES[this.mAnchorSide];
        }

        public float getTouchUpProgress(long j) {
            return this.mEngine.isStopped() ? this.mDestination : this.mEngine.getInterpolation(((float) (j - this.mStart)) * 1.0E-9f);
        }

        public boolean isNotDone(float f) {
            return (this.mOnTouchUp == 3 || this.mEngine == null || this.mEngine.isStopped()) ? false : true;
        }

        public void printInfo() {
            if (this.mAutoCompleteMode == 0) {
                System.out.println("velocity = " + this.mEngine.getVelocity());
                System.out.println("mMaxAcceleration = " + this.mMaxAcceleration);
                System.out.println("mMaxVelocity = " + this.mMaxVelocity);
            } else {
                System.out.println("mSpringMass          = " + this.mSpringMass);
                System.out.println("mSpringStiffness     = " + this.mSpringStiffness);
                System.out.println("mSpringDamping       = " + this.mSpringDamping);
                System.out.println("mSpringStopThreshold = " + this.mSpringStopThreshold);
                System.out.println("mSpringBoundary      = " + this.mSpringBoundary);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setAnchorId(String str) {
            this.mAnchorId = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setAnchorSide(int i) {
            this.mAnchorSide = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setAutoCompleteMode(int i) {
            this.mAutoCompleteMode = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setDragDirection(int i) {
            this.mDragDirection = i;
            this.mDragVertical = this.mDragDirection < 2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setDragScale(float f) {
            if (Float.isNaN(f)) {
                return;
            }
            this.mDragScale = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setDragThreshold(float f) {
            if (Float.isNaN(f)) {
                return;
            }
            this.mDragThreshold = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setLimitBoundsTo(String str) {
            this.mLimitBoundsTo = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setMaxAcceleration(float f) {
            if (Float.isNaN(f)) {
                return;
            }
            this.mMaxAcceleration = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setMaxVelocity(float f) {
            if (Float.isNaN(f)) {
                return;
            }
            this.mMaxVelocity = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setOnTouchUp(int i) {
            this.mOnTouchUp = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setRotationCenterId(String str) {
            this.mRotationCenterId = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setSpringBoundary(int i) {
            this.mSpringBoundary = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setSpringDamping(float f) {
            if (Float.isNaN(f)) {
                return;
            }
            this.mSpringDamping = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setSpringMass(float f) {
            if (Float.isNaN(f)) {
                return;
            }
            this.mSpringMass = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setSpringStiffness(float f) {
            if (Float.isNaN(f)) {
                return;
            }
            this.mSpringStiffness = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setSpringStopThreshold(float f) {
            if (Float.isNaN(f)) {
                return;
            }
            this.mSpringStopThreshold = f;
        }
    }

    /* loaded from: classes.dex */
    public static class WidgetState {
        boolean mNeedSetup = true;
        KeyCache mKeyCache = new KeyCache();
        int mParentHeight = -1;
        int mParentWidth = -1;
        WidgetFrame mStart = new WidgetFrame();
        WidgetFrame mEnd = new WidgetFrame();
        WidgetFrame mInterpolated = new WidgetFrame();
        MotionWidget mMotionWidgetStart = new MotionWidget(this.mStart);
        MotionWidget mMotionWidgetEnd = new MotionWidget(this.mEnd);
        MotionWidget mMotionWidgetInterpolated = new MotionWidget(this.mInterpolated);
        Motion mMotionControl = new Motion(this.mMotionWidgetStart);

        public WidgetState() {
            this.mMotionControl.setStart(this.mMotionWidgetStart);
            this.mMotionControl.setEnd(this.mMotionWidgetEnd);
        }

        public WidgetFrame getFrame(int i) {
            return i == 0 ? this.mStart : i == 1 ? this.mEnd : this.mInterpolated;
        }

        String getPathRelativeId() {
            return this.mMotionControl.getAnimateRelativeTo();
        }

        public void interpolate(int i, int i2, float f, Transition transition) {
            this.mParentHeight = i2;
            this.mParentWidth = i;
            if (this.mNeedSetup) {
                this.mMotionControl.setup(i, i2, 1.0f, System.nanoTime());
                this.mNeedSetup = false;
            }
            WidgetFrame.interpolate(i, i2, this.mInterpolated, this.mStart, this.mEnd, transition, f);
            this.mInterpolated.interpolatedPos = f;
            this.mMotionControl.interpolate(this.mMotionWidgetInterpolated, f, System.nanoTime(), this.mKeyCache);
        }

        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            this.mMotionControl.addKey(motionKeyAttributes);
        }

        public void setKeyAttribute(TypedBundle typedBundle, CustomVariable[] customVariableArr) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            if (customVariableArr != null) {
                for (int i = 0; i < customVariableArr.length; i++) {
                    motionKeyAttributes.mCustom.put(customVariableArr[i].getName(), customVariableArr[i]);
                }
            }
            this.mMotionControl.addKey(motionKeyAttributes);
        }

        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta(motionKeyCycle);
            this.mMotionControl.addKey(motionKeyCycle);
        }

        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta(motionKeyPosition);
            this.mMotionControl.addKey(motionKeyPosition);
        }

        public void setPathRelative(WidgetState widgetState) {
            this.mMotionControl.setupRelative(widgetState.mMotionControl);
        }

        public void update(ConstraintWidget constraintWidget, int i) {
            if (i == 0) {
                this.mStart.update(constraintWidget);
                this.mMotionWidgetStart.updateMotion(this.mMotionWidgetStart);
                this.mMotionControl.setStart(this.mMotionWidgetStart);
                this.mNeedSetup = true;
            } else if (i == 1) {
                this.mEnd.update(constraintWidget);
                this.mMotionControl.setEnd(this.mMotionWidgetEnd);
                this.mNeedSetup = true;
            }
            this.mParentWidth = -1;
        }
    }

    public Transition(CorePixelDp corePixelDp) {
        this.mToPixel = corePixelDp;
    }

    private void calculateParentDimensions(float f) {
        this.mParentInterpolatedWidth = (int) (this.mParentStartWidth + 0.5f + ((this.mParentEndWidth - this.mParentStartWidth) * f));
        this.mParentInterpolateHeight = (int) (this.mParentStartHeight + 0.5f + ((this.mParentEndHeight - this.mParentStartHeight) * f));
    }

    public static Interpolator getInterpolator(int i, String str) {
        switch (i) {
            case -1:
                return new Transition$$ExternalSyntheticLambda0(str);
            case 0:
                return new Transition$$ExternalSyntheticLambda1();
            case 1:
                return new Transition$$ExternalSyntheticLambda2();
            case 2:
                return new Transition$$ExternalSyntheticLambda3();
            case 3:
                return new Transition$$ExternalSyntheticLambda4();
            case 4:
                return new Transition$$ExternalSyntheticLambda7();
            case 5:
                return new Transition$$ExternalSyntheticLambda6();
            case 6:
                return new Transition$$ExternalSyntheticLambda5();
            default:
                return null;
        }
    }

    private WidgetState getWidgetState(String str) {
        return this.mState.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$getInterpolator$0(String str, float f) {
        return (float) Easing.getInterpolator(str).get(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$getInterpolator$1(float f) {
        return (float) Easing.getInterpolator("standard").get(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$getInterpolator$2(float f) {
        return (float) Easing.getInterpolator("accelerate").get(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$getInterpolator$3(float f) {
        return (float) Easing.getInterpolator("decelerate").get(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$getInterpolator$4(float f) {
        return (float) Easing.getInterpolator("linear").get(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$getInterpolator$5(float f) {
        return (float) Easing.getInterpolator("anticipate").get(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$getInterpolator$6(float f) {
        return (float) Easing.getInterpolator("overshoot").get(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$getInterpolator$7(float f) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(f);
    }

    public void addCustomColor(int i, String str, String str2, int i2) {
        getWidgetState(str, null, i).getFrame(i).addCustomColor(str2, i2);
    }

    public void addCustomFloat(int i, String str, String str2, float f) {
        getWidgetState(str, null, i).getFrame(i).addCustomFloat(str2, f);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyAttribute(typedBundle);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle, CustomVariable[] customVariableArr) {
        getWidgetState(str, null, 0).setKeyAttribute(typedBundle, customVariableArr);
    }

    public void addKeyCycle(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyCycle(typedBundle);
    }

    public void addKeyPosition(String str, int i, int i2, float f, float f2) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add(TypedValues.PositionType.TYPE_POSITION_TYPE, 2);
        typedBundle.add(100, i);
        typedBundle.add(TypedValues.PositionType.TYPE_PERCENT_X, f);
        typedBundle.add(TypedValues.PositionType.TYPE_PERCENT_Y, f2);
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
        KeyPosition keyPosition = new KeyPosition(str, i, i2, f, f2);
        HashMap<String, KeyPosition> hashMap = this.mKeyPositions.get(Integer.valueOf(i));
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.mKeyPositions.put(Integer.valueOf(i), hashMap);
        }
        hashMap.put(str, keyPosition);
    }

    public void addKeyPosition(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
    }

    public void calcStagger() {
        if (this.mStagger == 0.0f) {
            return;
        }
        boolean z = ((double) this.mStagger) < 0.0d;
        float abs = Math.abs(this.mStagger);
        float f = Float.MAX_VALUE;
        float f2 = -3.4028235E38f;
        boolean z2 = false;
        Iterator<String> it = this.mState.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (!Float.isNaN(this.mState.get(it.next()).mMotionControl.getMotionStagger())) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            Iterator<String> it2 = this.mState.keySet().iterator();
            while (it2.hasNext()) {
                Motion motion = this.mState.get(it2.next()).mMotionControl;
                float finalX = motion.getFinalX() + motion.getFinalY();
                f = Math.min(f, finalX);
                f2 = Math.max(f2, finalX);
            }
            Iterator<String> it3 = this.mState.keySet().iterator();
            while (it3.hasNext()) {
                Motion motion2 = this.mState.get(it3.next()).mMotionControl;
                float finalX2 = motion2.getFinalX() + motion2.getFinalY();
                float f3 = abs - (((finalX2 - f) * abs) / (f2 - f));
                if (z) {
                    f3 = abs - (((f2 - finalX2) / (f2 - f)) * abs);
                }
                motion2.setStaggerScale(1.0f / (1.0f - abs));
                motion2.setStaggerOffset(f3);
            }
            return;
        }
        Iterator<String> it4 = this.mState.keySet().iterator();
        while (it4.hasNext()) {
            float motionStagger = this.mState.get(it4.next()).mMotionControl.getMotionStagger();
            if (!Float.isNaN(motionStagger)) {
                f = Math.min(f, motionStagger);
                f2 = Math.max(f2, motionStagger);
            }
        }
        Iterator<String> it5 = this.mState.keySet().iterator();
        while (it5.hasNext()) {
            Motion motion3 = this.mState.get(it5.next()).mMotionControl;
            float motionStagger2 = motion3.getMotionStagger();
            if (!Float.isNaN(motionStagger2)) {
                float f4 = 1.0f / (1.0f - abs);
                float f5 = abs - (((motionStagger2 - f) * abs) / (f2 - f));
                if (z) {
                    f5 = abs - (((f2 - motionStagger2) / (f2 - f)) * abs);
                }
                motion3.setStaggerScale(f4);
                motion3.setStaggerOffset(f5);
            }
        }
    }

    public void clear() {
        this.mState.clear();
    }

    public boolean contains(String str) {
        return this.mState.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnSwipe createOnSwipe() {
        OnSwipe onSwipe = new OnSwipe();
        this.mOnSwipe = onSwipe;
        return onSwipe;
    }

    public float dragToProgress(float f, int i, int i2, float f2, float f3) {
        Iterator<WidgetState> it = this.mState.values().iterator();
        WidgetState next = it.hasNext() ? it.next() : null;
        if (this.mOnSwipe != null && next != null) {
            if (this.mOnSwipe.mAnchorId == null) {
                float[] direction = this.mOnSwipe.getDirection();
                return this.mOnSwipe.getScale() * (direction[0] != 0.0f ? (Math.abs(direction[0]) * f2) / next.mParentHeight : (Math.abs(direction[1]) * f3) / next.mParentHeight);
            }
            WidgetState widgetState = this.mState.get(this.mOnSwipe.mAnchorId);
            float[] direction2 = this.mOnSwipe.getDirection();
            float[] side = this.mOnSwipe.getSide();
            float[] fArr = new float[2];
            widgetState.interpolate(i, i2, f, this);
            widgetState.mMotionControl.getDpDt(f, side[0], side[1], fArr);
            return this.mOnSwipe.getScale() * (direction2[0] != 0.0f ? (Math.abs(direction2[0]) * f2) / fArr[0] : (Math.abs(direction2[1]) * f3) / fArr[1]);
        }
        if (next != null) {
            return (-f3) / next.mParentHeight;
        }
        return 1.0f;
    }

    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        KeyPosition keyPosition;
        int i = 0;
        for (int i2 = 0; i2 <= 100; i2++) {
            HashMap<String, KeyPosition> hashMap = this.mKeyPositions.get(Integer.valueOf(i2));
            if (hashMap != null && (keyPosition = hashMap.get(widgetFrame.widget.stringId)) != null) {
                fArr[i] = keyPosition.mX;
                fArr2[i] = keyPosition.mY;
                fArr3[i] = keyPosition.mFrame;
                i++;
            }
        }
    }

    public KeyPosition findNextPosition(String str, int i) {
        KeyPosition keyPosition;
        while (i <= 100) {
            HashMap<String, KeyPosition> hashMap = this.mKeyPositions.get(Integer.valueOf(i));
            if (hashMap != null && (keyPosition = hashMap.get(str)) != null) {
                return keyPosition;
            }
            i++;
        }
        return null;
    }

    public KeyPosition findPreviousPosition(String str, int i) {
        KeyPosition keyPosition;
        while (i >= 0) {
            HashMap<String, KeyPosition> hashMap = this.mKeyPositions.get(Integer.valueOf(i));
            if (hashMap != null && (keyPosition = hashMap.get(str)) != null) {
                return keyPosition;
            }
            i--;
        }
        return null;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 1).mEnd;
    }

    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mEnd;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 2).mInterpolated;
    }

    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mInterpolated;
    }

    public int getInterpolatedHeight() {
        return this.mParentInterpolateHeight;
    }

    public int getInterpolatedWidth() {
        return this.mParentInterpolatedWidth;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }

    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.mState.get(str).mMotionControl.buildKeyFrames(fArr, iArr, iArr2);
    }

    public Motion getMotion(String str) {
        return getWidgetState(str, null, 0).mMotionControl;
    }

    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i = 0;
        for (int i2 = 0; i2 <= 100; i2++) {
            HashMap<String, KeyPosition> hashMap = this.mKeyPositions.get(Integer.valueOf(i2));
            if (hashMap != null && hashMap.get(widgetFrame.widget.stringId) != null) {
                i++;
            }
        }
        return i;
    }

    public float[] getPath(String str) {
        int i = 1000 / 16;
        float[] fArr = new float[i * 2];
        this.mState.get(str).mMotionControl.buildPath(fArr, i);
        return fArr;
    }

    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 0).mStart;
    }

    public WidgetFrame getStart(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mStart;
    }

    public float getTouchUpProgress(long j) {
        if (this.mOnSwipe != null) {
            return this.mOnSwipe.getTouchUpProgress(j);
        }
        return 0.0f;
    }

    public WidgetState getWidgetState(String str, ConstraintWidget constraintWidget, int i) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.mBundle.applyDelta(widgetState.mMotionControl);
            widgetState.mMotionWidgetStart.updateMotion(widgetState.mMotionControl);
            this.mState.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.update(constraintWidget, i);
            }
        }
        return widgetState;
    }

    public boolean hasOnSwipe() {
        return this.mOnSwipe != null;
    }

    public boolean hasPositionKeyframes() {
        return this.mKeyPositions.size() > 0;
    }

    public void interpolate(int i, int i2, float f) {
        if (this.mWrap) {
            calculateParentDimensions(f);
        }
        if (this.mEasing != null) {
            f = (float) this.mEasing.get(f);
        }
        Iterator<String> it = this.mState.keySet().iterator();
        while (it.hasNext()) {
            this.mState.get(it.next()).interpolate(i, i2, f, this);
        }
    }

    public boolean isEmpty() {
        return this.mState.isEmpty();
    }

    public boolean isFirstDownAccepted(float f, float f2) {
        if (this.mOnSwipe == null) {
            return false;
        }
        if (this.mOnSwipe.mLimitBoundsTo == null) {
            return true;
        }
        WidgetState widgetState = this.mState.get(this.mOnSwipe.mLimitBoundsTo);
        if (widgetState == null) {
            System.err.println("mLimitBoundsTo target is null");
            return false;
        }
        WidgetFrame frame = widgetState.getFrame(2);
        return f >= ((float) frame.left) && f < ((float) frame.right) && f2 >= ((float) frame.top) && f2 < ((float) frame.bottom);
    }

    public boolean isTouchNotDone(float f) {
        return this.mOnSwipe.isNotDone(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetProperties() {
        this.mOnSwipe = null;
        this.mBundle.clear();
    }

    public void setTouchUp(float f, long j, float f2, float f3) {
        if (this.mOnSwipe != null) {
            WidgetState widgetState = this.mState.get(this.mOnSwipe.mAnchorId);
            float[] fArr = new float[2];
            float[] direction = this.mOnSwipe.getDirection();
            float[] side = this.mOnSwipe.getSide();
            widgetState.mMotionControl.getDpDt(f, side[0], side[1], fArr);
            if (Math.abs((direction[0] * fArr[0]) + (direction[1] * fArr[1])) < 0.01d) {
                fArr[0] = 0.01f;
                fArr[1] = 0.01f;
            }
            this.mOnSwipe.config(f, (direction[0] != 0.0f ? f2 / fArr[0] : f3 / fArr[1]) * this.mOnSwipe.getScale(), j, this.mDuration * 0.001f);
        }
    }

    public void setTransitionProperties(TypedBundle typedBundle) {
        typedBundle.applyDelta(this.mBundle);
        typedBundle.applyDelta(this);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i != 706) {
            return false;
        }
        this.mStagger = f;
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 705) {
            return false;
        }
        this.mDefaultInterpolatorString = str;
        this.mEasing = Easing.getInterpolator(str);
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        this.mWrap = constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        this.mWrap |= constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            int width = constraintWidgetContainer.getWidth();
            this.mParentStartWidth = width;
            this.mParentInterpolatedWidth = width;
            int height = constraintWidgetContainer.getHeight();
            this.mParentStartHeight = height;
            this.mParentInterpolateHeight = height;
        } else {
            this.mParentEndWidth = constraintWidgetContainer.getWidth();
            this.mParentEndHeight = constraintWidgetContainer.getHeight();
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        WidgetState[] widgetStateArr = new WidgetState[size];
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = children.get(i2);
            WidgetState widgetState = getWidgetState(constraintWidget.stringId, null, i);
            widgetStateArr[i2] = widgetState;
            widgetState.update(constraintWidget, i);
            String pathRelativeId = widgetState.getPathRelativeId();
            if (pathRelativeId != null) {
                widgetState.setPathRelative(getWidgetState(pathRelativeId, null, i));
            }
        }
        calcStagger();
    }
}
