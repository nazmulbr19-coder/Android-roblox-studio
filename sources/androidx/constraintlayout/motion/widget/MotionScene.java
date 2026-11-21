package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DESKTOP = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private boolean mRtl;
    private MotionLayout.MotionTracker mVelocityTracker;
    final ViewTransitionController mViewTransitionController;
    StateSet mStateSet = null;
    Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private Transition mDefaultTransition = null;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mIgnoreTouch = false;
    private boolean mMotionOutsideRegion = false;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionScene$1, reason: invalid class name */
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

    /* loaded from: classes.dex */
    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTERCEPT_TOUCH = 4;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        /* loaded from: classes.dex */
        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R.styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public TransitionOnClick(Transition transition, int i, int i2) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                this.mTargetId = i;
                this.mMode = i2;
            }

            public void addOnClickListeners(MotionLayout motionLayout, int i, Transition transition) {
                View findViewById = this.mTargetId == -1 ? motionLayout : motionLayout.findViewById(this.mTargetId);
                if (findViewById == null) {
                    Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + this.mTargetId);
                    return;
                }
                int access$100 = Transition.access$100(transition);
                int access$000 = Transition.access$000(transition);
                if (access$100 == -1) {
                    findViewById.setOnClickListener(this);
                    return;
                }
                if ((((this.mMode & 1) != 0 && i == access$100) | ((this.mMode & 256) != 0 && i == access$100) | ((this.mMode & 1) != 0 && i == access$100) | ((this.mMode & 16) != 0 && i == access$000)) || ((this.mMode & 4096) != 0 && i == access$000)) {
                    findViewById.setOnClickListener(this);
                }
            }

            boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                if (this.mTransition == transition) {
                    return true;
                }
                int access$000 = Transition.access$000(this.mTransition);
                int access$100 = Transition.access$100(this.mTransition);
                return access$100 == -1 ? motionLayout.mCurrentState != access$000 : motionLayout.mCurrentState == access$100 || motionLayout.mCurrentState == access$000;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout access$700 = MotionScene.access$700(Transition.access$800(this.mTransition));
                if (access$700.isInteractionEnabled()) {
                    if (Transition.access$100(this.mTransition) == -1) {
                        int currentState = access$700.getCurrentState();
                        if (currentState == -1) {
                            access$700.transitionToState(Transition.access$000(this.mTransition));
                            return;
                        }
                        Transition transition = new Transition(Transition.access$800(this.mTransition), this.mTransition);
                        Transition.access$102(transition, currentState);
                        Transition.access$002(transition, Transition.access$000(this.mTransition));
                        access$700.setTransition(transition);
                        access$700.transitionToEnd();
                        return;
                    }
                    Transition transition2 = Transition.access$800(this.mTransition).mCurrentTransition;
                    boolean z = false;
                    boolean z2 = ((this.mMode & 1) == 0 && (this.mMode & 256) == 0) ? false : true;
                    boolean z3 = ((this.mMode & 16) == 0 && (this.mMode & 4096) == 0) ? false : true;
                    if (z2 && z3) {
                        z = true;
                    }
                    if (z) {
                        if (Transition.access$800(this.mTransition).mCurrentTransition != this.mTransition) {
                            access$700.setTransition(this.mTransition);
                        }
                        if (access$700.getCurrentState() == access$700.getEndState() || access$700.getProgress() > 0.5f) {
                            z2 = false;
                        } else {
                            z3 = false;
                        }
                    }
                    if (isTransitionViable(transition2, access$700)) {
                        if (z2 && (this.mMode & 1) != 0) {
                            access$700.setTransition(this.mTransition);
                            access$700.transitionToEnd();
                            return;
                        }
                        if (z3 && (this.mMode & 16) != 0) {
                            access$700.setTransition(this.mTransition);
                            access$700.transitionToStart();
                        } else if (z2 && (this.mMode & 256) != 0) {
                            access$700.setTransition(this.mTransition);
                            access$700.setProgress(1.0f);
                        } else {
                            if (!z3 || (this.mMode & 4096) == 0) {
                                return;
                            }
                            access$700.setTransition(this.mTransition);
                            access$700.setProgress(0.0f);
                        }
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                if (this.mTargetId == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(this.mTargetId);
                if (findViewById == null) {
                    Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + this.mTargetId);
                } else {
                    findViewById.setOnClickListener(null);
                }
            }
        }

        public Transition(int i, MotionScene motionScene, int i2, int i3) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = i;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i2;
            this.mConstraintSetEnd = i3;
            this.mDuration = MotionScene.access$900(motionScene);
            this.mLayoutDuringTransition = MotionScene.access$1000(motionScene);
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = MotionScene.access$900(motionScene);
            this.mLayoutDuringTransition = MotionScene.access$1000(motionScene);
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }

        Transition(MotionScene motionScene, Transition transition) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            this.mDuration = MotionScene.access$900(motionScene);
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        static /* synthetic */ int access$000(Transition transition) {
            return transition.mConstraintSetEnd;
        }

        static /* synthetic */ int access$002(Transition transition, int i) {
            transition.mConstraintSetEnd = i;
            return i;
        }

        static /* synthetic */ int access$100(Transition transition) {
            return transition.mConstraintSetStart;
        }

        static /* synthetic */ int access$102(Transition transition, int i) {
            transition.mConstraintSetStart = i;
            return i;
        }

        static /* synthetic */ boolean access$1300(Transition transition) {
            return transition.mIsAbstract;
        }

        static /* synthetic */ ArrayList access$1400(Transition transition) {
            return transition.mKeyFramesList;
        }

        static /* synthetic */ int access$1500(Transition transition) {
            return transition.mDefaultInterpolator;
        }

        static /* synthetic */ String access$1600(Transition transition) {
            return transition.mDefaultInterpolatorString;
        }

        static /* synthetic */ int access$1700(Transition transition) {
            return transition.mDefaultInterpolatorID;
        }

        static /* synthetic */ int access$1800(Transition transition) {
            return transition.mDuration;
        }

        static /* synthetic */ int access$1900(Transition transition) {
            return transition.mPathMotionArc;
        }

        static /* synthetic */ TouchResponse access$200(Transition transition) {
            return transition.mTouchResponse;
        }

        static /* synthetic */ float access$2000(Transition transition) {
            return transition.mStagger;
        }

        static /* synthetic */ TouchResponse access$202(Transition transition, TouchResponse touchResponse) {
            transition.mTouchResponse = touchResponse;
            return touchResponse;
        }

        static /* synthetic */ int access$300(Transition transition) {
            return transition.mId;
        }

        static /* synthetic */ ArrayList access$400(Transition transition) {
            return transition.mOnClicks;
        }

        static /* synthetic */ boolean access$500(Transition transition) {
            return transition.mDisable;
        }

        static /* synthetic */ int access$600(Transition transition) {
            return transition.mAutoTransition;
        }

        static /* synthetic */ MotionScene access$800(Transition transition) {
            return transition.mMotionScene;
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        MotionScene.access$1100(motionScene).append(this.mConstraintSetEnd, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.mConstraintSetEnd = MotionScene.access$1200(motionScene, context, this.mConstraintSetEnd);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        MotionScene.access$1100(motionScene).append(this.mConstraintSetStart, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.mConstraintSetStart = MotionScene.access$1200(motionScene, context, this.mConstraintSetStart);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    TypedValue peekValue = typedArray.peekValue(index);
                    if (peekValue.type == 1) {
                        this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                        if (this.mDefaultInterpolatorID != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (peekValue.type == 3) {
                        this.mDefaultInterpolatorString = typedArray.getString(index);
                        if (this.mDefaultInterpolatorString != null) {
                            if (this.mDefaultInterpolatorString.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    this.mDuration = typedArray.getInt(index, this.mDuration);
                    if (this.mDuration < 8) {
                        this.mDuration = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.mKeyFramesList.add(keyFrames);
        }

        public void addOnClick(int i, int i2) {
            Iterator<TransitionOnClick> it = this.mOnClicks.iterator();
            while (it.hasNext()) {
                TransitionOnClick next = it.next();
                if (next.mTargetId == i) {
                    next.mMode = i2;
                    return;
                }
            }
            this.mOnClicks.add(new TransitionOnClick(this, i, i2));
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public String debugString(Context context) {
            String resourceEntryName = this.mConstraintSetStart == -1 ? "null" : context.getResources().getResourceEntryName(this.mConstraintSetStart);
            return this.mConstraintSetEnd == -1 ? resourceEntryName + " -> null" : resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i) {
            return (this.mTransitionFlags & i) != 0;
        }

        public void removeOnClick(int i) {
            TransitionOnClick transitionOnClick = null;
            Iterator<TransitionOnClick> it = this.mOnClicks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TransitionOnClick next = it.next();
                if (next.mTargetId == i) {
                    transitionOnClick = next;
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.mOnClicks.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i) {
            this.mAutoTransition = i;
        }

        public void setDuration(int i) {
            this.mDuration = Math.max(i, 8);
        }

        public void setEnabled(boolean z) {
            this.mDisable = !z;
        }

        public void setInterpolatorInfo(int i, String str, int i2) {
            this.mDefaultInterpolator = i;
            this.mDefaultInterpolatorString = str;
            this.mDefaultInterpolatorID = i2;
        }

        public void setLayoutDuringTransition(int i) {
            this.mLayoutDuringTransition = i;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            this.mTouchResponse = onSwipe == null ? null : new TouchResponse(MotionScene.access$700(this.mMotionScene), onSwipe);
        }

        public void setOnTouchUp(int i) {
            TouchResponse touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.setTouchUpMode(i);
            }
        }

        public void setPathMotionArc(int i) {
            this.mPathMotionArc = i;
        }

        public void setStagger(float f) {
            this.mStagger = f;
        }

        public void setTransitionFlag(int i) {
            this.mTransitionFlags = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionScene(Context context, MotionLayout motionLayout, int i) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
        load(context, i);
        this.mConstraintSetMap.put(R.id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
    }

    static /* synthetic */ int access$1000(MotionScene motionScene) {
        return motionScene.mLayoutDuringTransition;
    }

    static /* synthetic */ SparseArray access$1100(MotionScene motionScene) {
        return motionScene.mConstraintSetMap;
    }

    static /* synthetic */ int access$1200(MotionScene motionScene, Context context, int i) {
        return motionScene.parseInclude(context, i);
    }

    static /* synthetic */ MotionLayout access$700(MotionScene motionScene) {
        return motionScene.mMotionLayout;
    }

    static /* synthetic */ int access$900(MotionScene motionScene) {
        return motionScene.mDefaultDuration;
    }

    private int getId(Context context, String str) {
        int i = -1;
        if (str.contains("/")) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        }
        if (i != -1) {
            return i;
        }
        if (str != null && str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
        return i;
    }

    private int getIndex(Transition transition) {
        int access$300 = Transition.access$300(transition);
        if (access$300 == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i = 0; i < this.mTransitionList.size(); i++) {
            if (Transition.access$300(this.mTransitionList.get(i)) == access$300) {
                return i;
            }
        }
        return -1;
    }

    static String getLine(Context context, int i, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    private int getRealID(int i) {
        int stateGetConstraintID;
        return (this.mStateSet == null || (stateGetConstraintID = this.mStateSet.stateGetConstraintID(i, -1, -1)) == -1) ? i : stateGetConstraintID;
    }

    private boolean hasCycleDependency(int i) {
        int i2 = this.mDeriveMap.get(i);
        int size = this.mDeriveMap.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.mDeriveMap.get(i2);
            size = i3;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x008b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0014. Please report as an issue. */
    private void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        Transition transition = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                switch (eventType) {
                    case 0:
                    case 3:
                    case 4:
                        eventType = xml.next();
                    case 1:
                    default:
                        eventType = xml.next();
                    case 2:
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals(CONSTRAINTSET_TAG)) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case -1239391468:
                                if (name.equals("KeyFrameSet")) {
                                    c = '\b';
                                    break;
                                }
                                break;
                            case -687739768:
                                if (name.equals(INCLUDE_TAG_UC)) {
                                    c = 7;
                                    break;
                                }
                                break;
                            case 61998586:
                                if (name.equals("ViewTransition")) {
                                    c = '\t';
                                    break;
                                }
                                break;
                            case 269306229:
                                if (name.equals(TRANSITION_TAG)) {
                                    break;
                                }
                                break;
                            case 312750793:
                                if (name.equals(ONCLICK_TAG)) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 327855227:
                                if (name.equals(ONSWIPE_TAG)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 793277014:
                                if (name.equals(TypedValues.MotionScene.NAME)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals(STATESET_TAG)) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 1942574248:
                                if (name.equals(INCLUDE_TAG)) {
                                    c = 6;
                                    break;
                                }
                                break;
                        }
                        c = 65535;
                        switch (c) {
                            case 0:
                                parseMotionSceneTags(context, xml);
                                eventType = xml.next();
                            case 1:
                                ArrayList<Transition> arrayList = this.mTransitionList;
                                Transition transition2 = new Transition(this, context, xml);
                                transition = transition2;
                                arrayList.add(transition2);
                                if (this.mCurrentTransition == null && !Transition.access$1300(transition)) {
                                    this.mCurrentTransition = transition;
                                    if (this.mCurrentTransition != null && Transition.access$200(this.mCurrentTransition) != null) {
                                        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
                                    }
                                }
                                if (Transition.access$1300(transition)) {
                                    if (Transition.access$000(transition) == -1) {
                                        this.mDefaultTransition = transition;
                                    } else {
                                        this.mAbstractTransitionList.add(transition);
                                    }
                                    this.mTransitionList.remove(transition);
                                }
                                eventType = xml.next();
                                break;
                            case 2:
                                if (transition == null) {
                                    Log.v(TypedValues.MotionScene.NAME, " OnSwipe (" + context.getResources().getResourceEntryName(i) + ".xml:" + xml.getLineNumber() + ")");
                                }
                                if (transition != null) {
                                    Transition.access$202(transition, new TouchResponse(context, this.mMotionLayout, xml));
                                }
                                eventType = xml.next();
                            case 3:
                                if (transition != null && !this.mMotionLayout.isInEditMode()) {
                                    transition.addOnClick(context, xml);
                                }
                                eventType = xml.next();
                                break;
                            case 4:
                                this.mStateSet = new StateSet(context, xml);
                                eventType = xml.next();
                            case 5:
                                parseConstraintSet(context, xml);
                                eventType = xml.next();
                            case 6:
                            case 7:
                                parseInclude(context, xml);
                                eventType = xml.next();
                            case '\b':
                                KeyFrames keyFrames = new KeyFrames(context, xml);
                                if (transition != null) {
                                    Transition.access$1400(transition).add(keyFrames);
                                }
                                eventType = xml.next();
                            case '\t':
                                this.mViewTransitionController.add(new ViewTransition(context, xml));
                                eventType = xml.next();
                            default:
                                eventType = xml.next();
                        }
                        break;
                }
            }
        } catch (IOException e) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private int parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ?? r0;
        char c;
        ConstraintSet constraintSet = new ConstraintSet();
        boolean z = false;
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            switch (attributeName.hashCode()) {
                case -1496482599:
                    if (attributeName.equals("deriveConstraintsFrom")) {
                        r0 = 1;
                        break;
                    }
                    break;
                case -1153153640:
                    if (attributeName.equals("constraintRotate")) {
                        r0 = 3;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        r0 = z;
                        break;
                    }
                    break;
                case 973381616:
                    if (attributeName.equals("stateLabels")) {
                        r0 = 2;
                        break;
                    }
                    break;
            }
            r0 = -1;
            switch (r0) {
                case 0:
                    int id = getId(context, attributeValue);
                    this.mConstraintSetIdMap.put(stripID(attributeValue), Integer.valueOf(id));
                    constraintSet.mIdString = Debug.getName(context, id);
                    i2 = id;
                    break;
                case 1:
                    i = getId(context, attributeValue);
                    break;
                case 2:
                    constraintSet.setStateLabels(attributeValue);
                    break;
                case 3:
                    try {
                        constraintSet.mRotate = Integer.parseInt(attributeValue);
                        break;
                    } catch (NumberFormatException e) {
                        switch (attributeValue.hashCode()) {
                            case -768416914:
                                if (attributeValue.equals("x_left")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (attributeValue.equals("left")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 3387192:
                                if (attributeValue.equals(AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_NONE_SCRIPT)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (attributeValue.equals("right")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1954540437:
                                if (attributeValue.equals("x_right")) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        c = 65535;
                        switch (c) {
                            case 0:
                                z = false;
                                constraintSet.mRotate = 0;
                                break;
                            case 1:
                                constraintSet.mRotate = 1;
                                z = false;
                                break;
                            case 2:
                                constraintSet.mRotate = 2;
                                z = false;
                                break;
                            case 3:
                                constraintSet.mRotate = 3;
                                z = false;
                                break;
                            case 4:
                                constraintSet.mRotate = 4;
                                z = false;
                                break;
                            default:
                                z = false;
                                break;
                        }
                    }
            }
        }
        if (i2 != -1) {
            if (this.mMotionLayout.mDebugPath != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (i != -1) {
                this.mDeriveMap.put(i2, i);
            }
            this.mConstraintSetMap.put(i2, constraintSet);
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    private int parseInclude(Context context, int i) {
        String str = "Error parsing resource: ";
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && CONSTRAINTSET_TAG.equals(name)) {
                    str = parseConstraintSet(context, xml);
                    return str;
                }
            }
            return -1;
        } catch (IOException e) {
            Log.e(TypedValues.MotionScene.NAME, str + i, e);
            return -1;
        } catch (XmlPullParserException e2) {
            Log.e(TypedValues.MotionScene.NAME, str + i, e2);
            return -1;
        }
    }

    private void parseInclude(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.include_constraintSet) {
                parseInclude(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
                if (this.mDefaultDuration < 8) {
                    this.mDefaultDuration = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.mConstraintSetMap.get(i);
        constraintSet.derivedState = constraintSet.mIdString;
        int i2 = this.mDeriveMap.get(i);
        if (i2 > 0) {
            readConstraintChain(i2, motionLayout);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i2);
            if (constraintSet2 == null) {
                Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i2));
                return;
            } else {
                constraintSet.derivedState += "/" + constraintSet2.derivedState;
                constraintSet.readFallback(constraintSet2);
            }
        } else {
            constraintSet.derivedState += "  layout";
            constraintSet.readFallback(motionLayout);
        }
        constraintSet.applyDeltaFrom(constraintSet);
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (Transition.access$400(next).size() > 0) {
                Iterator it2 = Transition.access$400(next).iterator();
                while (it2.hasNext()) {
                    ((Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.mAbstractTransitionList.iterator();
        while (it3.hasNext()) {
            Transition next2 = it3.next();
            if (Transition.access$400(next2).size() > 0) {
                Iterator it4 = Transition.access$400(next2).iterator();
                while (it4.hasNext()) {
                    ((Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.mTransitionList.iterator();
        while (it5.hasNext()) {
            Transition next3 = it5.next();
            if (Transition.access$400(next3).size() > 0) {
                Iterator it6 = Transition.access$400(next3).iterator();
                while (it6.hasNext()) {
                    ((Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i, next3);
                }
            }
        }
        Iterator<Transition> it7 = this.mAbstractTransitionList.iterator();
        while (it7.hasNext()) {
            Transition next4 = it7.next();
            if (Transition.access$400(next4).size() > 0) {
                Iterator it8 = Transition.access$400(next4).iterator();
                while (it8.hasNext()) {
                    ((Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        return this.mViewTransitionController.applyViewTransition(i, motionController);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean autoTransition(MotionLayout motionLayout, int i) {
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (Transition.access$600(next) != 0 && (this.mCurrentTransition != next || !this.mCurrentTransition.isTransitionFlag(2))) {
                if (i == Transition.access$100(next) && (Transition.access$600(next) == 4 || Transition.access$600(next) == 2)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (Transition.access$600(next) == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (i == Transition.access$000(next) && (Transition.access$600(next) == 3 || Transition.access$600(next) == 1)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (Transition.access$600(next) == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i, float f, float f2, MotionEvent motionEvent) {
        List<Transition> list;
        float f3;
        float f4 = f;
        float f5 = f2;
        if (i == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i);
        float f6 = 0.0f;
        Transition transition = null;
        RectF rectF = new RectF();
        for (Transition transition2 : transitionsWithState) {
            if (!Transition.access$500(transition2)) {
                if (Transition.access$200(transition2) != null) {
                    Transition.access$200(transition2).setRTL(this.mRtl);
                    RectF touchRegion = Transition.access$200(transition2).getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                        RectF limitBoundsTo = Transition.access$200(transition2).getLimitBoundsTo(this.mMotionLayout, rectF);
                        if (limitBoundsTo == null || motionEvent == null || limitBoundsTo.contains(motionEvent.getX(), motionEvent.getY())) {
                            float dot = Transition.access$200(transition2).dot(f4, f5);
                            if (!Transition.access$200(transition2).mIsRotateMode || motionEvent == null) {
                                list = transitionsWithState;
                                f3 = f6;
                            } else {
                                list = transitionsWithState;
                                f3 = f6;
                                dot = ((float) (Math.atan2(f5 + r13, f4 + r12) - Math.atan2(motionEvent.getX() - Transition.access$200(transition2).mRotateCenterX, motionEvent.getY() - Transition.access$200(transition2).mRotateCenterY))) * 10.0f;
                            }
                            float f7 = Transition.access$000(transition2) == i ? dot * (-1.0f) : dot * 1.1f;
                            if (f7 > f3) {
                                f6 = f7;
                                transition = transition2;
                                f4 = f;
                                f5 = f2;
                                transitionsWithState = list;
                            }
                        }
                    }
                } else {
                    list = transitionsWithState;
                    f3 = f6;
                }
                f6 = f3;
                f4 = f;
                f5 = f2;
                transitionsWithState = list;
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z) {
        this.mDisableAutoTransition = z;
    }

    public void enableViewTransition(int i, boolean z) {
        this.mViewTransitionController.enableViewTransition(i, z);
    }

    public int gatPathMotionArc() {
        if (this.mCurrentTransition != null) {
            return Transition.access$1900(this.mCurrentTransition);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoCompleteMode() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0;
        }
        return Transition.access$200(this.mCurrentTransition).getAutoCompleteMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int i) {
        return getConstraintSet(i, -1, -1);
    }

    ConstraintSet getConstraintSet(int i, int i2, int i3) {
        int stateGetConstraintID;
        if (this.mStateSet != null && (stateGetConstraintID = this.mStateSet.stateGetConstraintID(i, i2, i3)) != -1) {
            i = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i) != null) {
            return this.mConstraintSetMap.get(i);
        }
        Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i) + " In MotionScene");
        return this.mConstraintSetMap.get(this.mConstraintSetMap.keyAt(0));
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int keyAt = this.mConstraintSetMap.keyAt(i);
            if (str.equals(context.getResources().getResourceName(keyAt))) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int[] iArr = new int[this.mConstraintSetMap.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = this.mConstraintSetMap.keyAt(i);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        return this.mCurrentTransition != null ? Transition.access$1800(this.mCurrentTransition) : this.mDefaultDuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEndId() {
        if (this.mCurrentTransition == null) {
            return -1;
        }
        return Transition.access$000(this.mCurrentTransition);
    }

    public Interpolator getInterpolator() {
        switch (Transition.access$1500(this.mCurrentTransition)) {
            case -2:
                return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), Transition.access$1700(this.mCurrentTransition));
            case -1:
                return new AnonymousClass1(Easing.getInterpolator(Transition.access$1600(this.mCurrentTransition)));
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
            case 6:
                return new AnticipateInterpolator();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Key getKeyFrame(Context context, int i, int i2, int i3) {
        if (this.mCurrentTransition == null) {
            return null;
        }
        Iterator it = Transition.access$1400(this.mCurrentTransition).iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            for (Integer num : keyFrames.getKeys()) {
                if (i2 == num.intValue()) {
                    Iterator<Key> it2 = keyFrames.getKeyFramesForView(num.intValue()).iterator();
                    while (it2.hasNext()) {
                        Key next = it2.next();
                        if (next.mFramePosition == i3 && next.mType == i) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        if (this.mCurrentTransition != null) {
            Iterator it = Transition.access$1400(this.mCurrentTransition).iterator();
            while (it.hasNext()) {
                ((KeyFrames) it.next()).addFrames(motionController);
            }
        } else if (this.mDefaultTransition != null) {
            Iterator it2 = Transition.access$1400(this.mDefaultTransition).iterator();
            while (it2.hasNext()) {
                ((KeyFrames) it2.next()).addFrames(motionController);
            }
        }
    }

    public int[] getMatchingStateLabels(String... strArr) {
        int[] iArr = new int[this.mConstraintSetMap.size()];
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            ConstraintSet valueAt = this.mConstraintSetMap.valueAt(i2);
            int keyAt = this.mConstraintSetMap.keyAt(i2);
            if (valueAt.matchesLabels(strArr)) {
                valueAt.getStateLabels();
                iArr[i] = keyAt;
                i++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxVelocity() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return false;
        }
        return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i) {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getProgressDirection(float f, float f2) {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getProgressDirection(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSpringBoundary() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0;
        }
        return Transition.access$200(this.mCurrentTransition).getSpringBoundary();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getSpringDamping() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getSpringDamping();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getSpringMass() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getSpringMass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getSpringStiffiness() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getSpringStiffness();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getSpringStopThreshold() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getSpringStopThreshold();
    }

    public float getStaggered() {
        if (this.mCurrentTransition != null) {
            return Transition.access$2000(this.mCurrentTransition);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStartId() {
        if (this.mCurrentTransition == null) {
            return -1;
        }
        return Transition.access$100(this.mCurrentTransition);
    }

    public Transition getTransitionById(int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (Transition.access$300(next) == i) {
                return next;
            }
        }
        return null;
    }

    int getTransitionDirection(int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (Transition.access$100(it.next()) == i) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i) {
        int realID = getRealID(i);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (Transition.access$100(next) == realID || Transition.access$000(next) == realID) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasKeyFramePosition(View view, int i) {
        if (this.mCurrentTransition == null) {
            return false;
        }
        Iterator it = Transition.access$1400(this.mCurrentTransition).iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isViewTransitionEnabled(int i) {
        return this.mViewTransitionController.isViewTransitionEnabled(i);
    }

    public int lookUpConstraintId(String str) {
        Integer num = this.mConstraintSetIdMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i) {
        for (Map.Entry<String, Integer> entry : this.mConstraintSetIdMap.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == i) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processScrollMove(float f, float f2) {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).scrollMove(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processScrollUp(float f, float f2) {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).scrollUp(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processTouchEvent(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i != -1) {
            boolean z = false;
            switch (motionEvent.getAction()) {
                case 0:
                    this.mLastTouchX = motionEvent.getRawX();
                    this.mLastTouchY = motionEvent.getRawY();
                    this.mLastTouchDown = motionEvent;
                    this.mIgnoreTouch = false;
                    if (Transition.access$200(this.mCurrentTransition) != null) {
                        RectF limitBoundsTo = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, rectF);
                        if (limitBoundsTo != null && !limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            this.mLastTouchDown = null;
                            this.mIgnoreTouch = true;
                            return;
                        }
                        RectF touchRegion = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            this.mMotionOutsideRegion = false;
                        } else {
                            this.mMotionOutsideRegion = true;
                        }
                        Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
                        return;
                    }
                    return;
                case 2:
                    if (!this.mIgnoreTouch) {
                        float rawY = motionEvent.getRawY() - this.mLastTouchY;
                        float rawX = motionEvent.getRawX() - this.mLastTouchX;
                        if ((rawX != 0.0d || rawY != 0.0d) && this.mLastTouchDown != null) {
                            Transition bestTransitionFor = bestTransitionFor(i, rawX, rawY, this.mLastTouchDown);
                            if (bestTransitionFor != null) {
                                motionLayout.setTransition(bestTransitionFor);
                                RectF touchRegion2 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, rectF);
                                if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                                    z = true;
                                }
                                this.mMotionOutsideRegion = z;
                                Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                                break;
                            }
                        } else {
                            return;
                        }
                    }
                    break;
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        if (this.mCurrentTransition != null && Transition.access$200(this.mCurrentTransition) != null && !this.mMotionOutsideRegion) {
            Transition.access$200(this.mCurrentTransition).processTouchEvent(motionEvent, this.mVelocityTracker, i, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || this.mVelocityTracker == null) {
            return;
        }
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        if (motionLayout.mCurrentState != -1) {
            autoTransition(motionLayout, motionLayout.mCurrentState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readFallback(MotionLayout motionLayout) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int keyAt = this.mConstraintSetMap.keyAt(i);
            if (hasCycleDependency(keyAt)) {
                Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
                return;
            }
            readConstraintChain(keyAt, motionLayout);
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i, constraintSet);
    }

    public void setDuration(int i) {
        if (this.mCurrentTransition != null) {
            this.mCurrentTransition.setDuration(i);
        } else {
            this.mDefaultDuration = i;
        }
    }

    public void setKeyframe(View view, int i, String str, Object obj) {
        if (this.mCurrentTransition == null) {
            return;
        }
        Iterator it = Transition.access$1400(this.mCurrentTransition).iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    if ((obj != null ? ((Float) obj).floatValue() : 0.0f) == 0.0f) {
                    }
                }
            }
        }
    }

    public void setRtl(boolean z) {
        this.mRtl = z;
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTransition(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.mStateSet != null) {
            int stateGetConstraintID = this.mStateSet.stateGetConstraintID(i, -1, -1);
            if (stateGetConstraintID != -1) {
                i3 = stateGetConstraintID;
            }
            int stateGetConstraintID2 = this.mStateSet.stateGetConstraintID(i2, -1, -1);
            if (stateGetConstraintID2 != -1) {
                i4 = stateGetConstraintID2;
            }
        }
        if (this.mCurrentTransition != null && Transition.access$000(this.mCurrentTransition) == i2 && Transition.access$100(this.mCurrentTransition) == i) {
            return;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if ((Transition.access$000(next) == i4 && Transition.access$100(next) == i3) || (Transition.access$000(next) == i2 && Transition.access$100(next) == i)) {
                this.mCurrentTransition = next;
                if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
                    return;
                }
                Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
                return;
            }
        }
        Transition transition = this.mDefaultTransition;
        Iterator<Transition> it2 = this.mAbstractTransitionList.iterator();
        while (it2.hasNext()) {
            Transition next2 = it2.next();
            if (Transition.access$000(next2) == i2) {
                transition = next2;
            }
        }
        Transition transition2 = new Transition(this, transition);
        Transition.access$102(transition2, i3);
        Transition.access$002(transition2, i4);
        if (i3 != -1) {
            this.mTransitionList.add(transition2);
        }
        this.mCurrentTransition = transition2;
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupTouch() {
        if (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).setupTouch();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supportTouch() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (Transition.access$200(it.next()) != null) {
                return true;
            }
        }
        return (this.mCurrentTransition == null || Transition.access$200(this.mCurrentTransition) == null) ? false : true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.mMotionLayout && motionLayout.mScene == this;
    }

    public void viewTransition(int i, View... viewArr) {
        this.mViewTransitionController.viewTransition(i, viewArr);
    }
}
