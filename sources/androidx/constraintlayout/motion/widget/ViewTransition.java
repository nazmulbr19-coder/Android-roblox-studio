package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
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
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ViewTransition {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    static final int LINEAR = 3;
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "ViewTransition";
    private static final int UNSET = -1;
    static final int VIEWTRANSITIONMODE_ALLSTATES = 1;
    static final int VIEWTRANSITIONMODE_CURRENTSTATE = 0;
    static final int VIEWTRANSITIONMODE_NOSTATE = 2;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";
    ConstraintSet.Constraint mConstraintDelta;
    Context mContext;
    private int mId;
    KeyFrames mKeyFrames;
    ConstraintSet mSet;
    private int mTargetId;
    private String mTargetString;
    int mViewTransitionMode;
    private int mOnStateTransition = -1;
    private boolean mDisabled = false;
    private int mPathMotionArc = 0;
    private int mDuration = -1;
    private int mUpDuration = -1;
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private int mDefaultInterpolatorID = -1;
    private int mSetsTag = -1;
    private int mClearsTag = -1;
    private int mIfTagSet = -1;
    private int mIfTagNotSet = -1;
    private int mSharedValueTarget = -1;
    private int mSharedValueID = -1;
    private int mSharedValueCurrent = -1;

    /* renamed from: androidx.constraintlayout.motion.widget.ViewTransition$1, reason: invalid class name */
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
    static class Animate {
        private final int mClearsTag;
        float mDpositionDt;
        int mDuration;
        boolean mHoldAt100;
        Interpolator mInterpolator;
        MotionController mMC;
        float mPosition;
        private final int mSetsTag;
        int mUpDuration;
        ViewTransitionController mVtController;
        KeyCache mCache = new KeyCache();
        boolean mReverse = false;
        Rect mTempRec = new Rect();
        long mStart = System.nanoTime();
        long mLastRender = this.mStart;

        Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            this.mHoldAt100 = false;
            this.mVtController = viewTransitionController;
            this.mMC = motionController;
            this.mDuration = i;
            this.mUpDuration = i2;
            this.mVtController.addAnimation(this);
            this.mInterpolator = interpolator;
            this.mSetsTag = i4;
            this.mClearsTag = i5;
            if (i3 == 3) {
                this.mHoldAt100 = true;
            }
            this.mDpositionDt = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            mutate();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void mutate() {
            if (this.mReverse) {
                mutateReverse();
            } else {
                mutateForward();
            }
        }

        void mutateForward() {
            long nanoTime = System.nanoTime();
            long j = nanoTime - this.mLastRender;
            this.mLastRender = nanoTime;
            this.mPosition += ((float) (j * 1.0E-6d)) * this.mDpositionDt;
            if (this.mPosition >= 1.0f) {
                this.mPosition = 1.0f;
            }
            boolean interpolate = this.mMC.interpolate(this.mMC.mView, this.mInterpolator == null ? this.mPosition : this.mInterpolator.getInterpolation(this.mPosition), nanoTime, this.mCache);
            if (this.mPosition >= 1.0f) {
                if (this.mSetsTag != -1) {
                    this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.mMC.getView().setTag(this.mClearsTag, null);
                }
                if (!this.mHoldAt100) {
                    this.mVtController.removeAnimation(this);
                }
            }
            if (this.mPosition < 1.0f || interpolate) {
                this.mVtController.invalidate();
            }
        }

        void mutateReverse() {
            long nanoTime = System.nanoTime();
            long j = nanoTime - this.mLastRender;
            this.mLastRender = nanoTime;
            this.mPosition -= ((float) (j * 1.0E-6d)) * this.mDpositionDt;
            if (this.mPosition < 0.0f) {
                this.mPosition = 0.0f;
            }
            boolean interpolate = this.mMC.interpolate(this.mMC.mView, this.mInterpolator == null ? this.mPosition : this.mInterpolator.getInterpolation(this.mPosition), nanoTime, this.mCache);
            if (this.mPosition <= 0.0f) {
                if (this.mSetsTag != -1) {
                    this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.mMC.getView().setTag(this.mClearsTag, null);
                }
                this.mVtController.removeAnimation(this);
            }
            if (this.mPosition > 0.0f || interpolate) {
                this.mVtController.invalidate();
            }
        }

        public void reactTo(int i, float f, float f2) {
            switch (i) {
                case 1:
                    if (this.mReverse) {
                        return;
                    }
                    reverse(true);
                    return;
                case 2:
                    this.mMC.getView().getHitRect(this.mTempRec);
                    if (this.mTempRec.contains((int) f, (int) f2) || this.mReverse) {
                        return;
                    }
                    reverse(true);
                    return;
                default:
                    return;
            }
        }

        void reverse(boolean z) {
            this.mReverse = z;
            if (this.mReverse && this.mUpDuration != -1) {
                this.mDpositionDt = this.mUpDuration == 0 ? Float.MAX_VALUE : 1.0f / this.mUpDuration;
            }
            this.mVtController.invalidate();
            this.mLastRender = System.nanoTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0031. Please report as an issue. */
    public ViewTransition(Context context, XmlPullParser xmlPullParser) {
        this.mContext = context;
        try {
            int eventType = xmlPullParser.getEventType();
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                switch (eventType) {
                    case 0:
                    case 4:
                        eventType = xmlPullParser.next();
                    case 1:
                    default:
                        eventType = xmlPullParser.next();
                    case 2:
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -1962203927:
                                if (name.equals(CONSTRAINT_OVERRIDE)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -1239391468:
                                if (name.equals(KEY_FRAME_SET_TAG)) {
                                    break;
                                }
                                break;
                            case 61998586:
                                if (name.equals("ViewTransition")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 366511058:
                                if (name.equals(CUSTOM_METHOD)) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 1791837707:
                                if (name.equals(CUSTOM_ATTRIBUTE)) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        c = 65535;
                        switch (c) {
                            case 0:
                                parseViewTransitionTags(context, xmlPullParser);
                                break;
                            case 1:
                                this.mKeyFrames = new KeyFrames(context, xmlPullParser);
                                break;
                            case 2:
                                this.mConstraintDelta = ConstraintSet.buildDelta(context, xmlPullParser);
                                break;
                            case 3:
                            case 4:
                                ConstraintAttribute.parse(context, xmlPullParser, this.mConstraintDelta.mCustomConstraints);
                                break;
                            default:
                                Log.e("ViewTransition", Debug.getLoc() + " unknown tag " + name);
                                Log.e("ViewTransition", ".xml:" + xmlPullParser.getLineNumber());
                                break;
                        }
                        eventType = xmlPullParser.next();
                        break;
                    case 3:
                        if ("ViewTransition".equals(xmlPullParser.getName())) {
                            return;
                        }
                        eventType = xmlPullParser.next();
                }
            }
        } catch (IOException e) {
            Log.e("ViewTransition", "Error parsing XML resource", e);
        } catch (XmlPullParserException e2) {
            Log.e("ViewTransition", "Error parsing XML resource", e2);
        }
    }

    private void parseViewTransitionTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.ViewTransition_android_id) {
                this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    if (this.mTargetId == -1) {
                        this.mTargetString = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.mTargetString = obtainStyledAttributes.getString(index);
                } else {
                    this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.mOnStateTransition = obtainStyledAttributes.getInt(index, this.mOnStateTransition);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.mDisabled = obtainStyledAttributes.getBoolean(index, this.mDisabled);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.mDuration = obtainStyledAttributes.getInt(index, this.mDuration);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.mUpDuration = obtainStyledAttributes.getInt(index, this.mUpDuration);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.mViewTransitionMode = obtainStyledAttributes.getInt(index, this.mViewTransitionMode);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                if (peekValue.type == 1) {
                    this.mDefaultInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                    if (this.mDefaultInterpolatorID != -1) {
                        this.mDefaultInterpolator = -2;
                    }
                } else if (peekValue.type == 3) {
                    this.mDefaultInterpolatorString = obtainStyledAttributes.getString(index);
                    if (this.mDefaultInterpolatorString == null || this.mDefaultInterpolatorString.indexOf("/") <= 0) {
                        this.mDefaultInterpolator = -1;
                    } else {
                        this.mDefaultInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                        this.mDefaultInterpolator = -2;
                    }
                } else {
                    this.mDefaultInterpolator = obtainStyledAttributes.getInteger(index, this.mDefaultInterpolator);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.mSetsTag = obtainStyledAttributes.getResourceId(index, this.mSetsTag);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.mClearsTag = obtainStyledAttributes.getResourceId(index, this.mClearsTag);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.mIfTagSet = obtainStyledAttributes.getResourceId(index, this.mIfTagSet);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.mIfTagNotSet = obtainStyledAttributes.getResourceId(index, this.mIfTagNotSet);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.mSharedValueID = obtainStyledAttributes.getResourceId(index, this.mSharedValueID);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.mSharedValueTarget = obtainStyledAttributes.getInteger(index, this.mSharedValueTarget);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void updateTransition(MotionScene.Transition transition, View view) {
        if (this.mDuration != -1) {
            transition.setDuration(this.mDuration);
        }
        transition.setPathMotionArc(this.mPathMotionArc);
        transition.setInterpolatorInfo(this.mDefaultInterpolator, this.mDefaultInterpolatorString, this.mDefaultInterpolatorID);
        int id = view.getId();
        if (this.mKeyFrames != null) {
            ArrayList<Key> keyFramesForView = this.mKeyFrames.getKeyFramesForView(-1);
            KeyFrames keyFrames = new KeyFrames();
            Iterator<Key> it = keyFramesForView.iterator();
            while (it.hasNext()) {
                keyFrames.addKey(it.next().clone().setViewId(id));
            }
            transition.addKeyFrame(keyFrames);
        }
    }

    void applyIndependentTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.setBothStates(view);
        this.mKeyFrames.addAllFrames(motionController);
        motionController.setup(motionLayout.getWidth(), motionLayout.getHeight(), this.mDuration, System.nanoTime());
        new Animate(viewTransitionController, motionController, this.mDuration, this.mUpDuration, this.mOnStateTransition, getInterpolator(motionLayout.getContext()), this.mSetsTag, this.mClearsTag);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i, ConstraintSet constraintSet, View... viewArr) {
        if (this.mDisabled) {
            return;
        }
        int i2 = 0;
        if (this.mViewTransitionMode == 2) {
            applyIndependentTransition(viewTransitionController, motionLayout, viewArr[0]);
            return;
        }
        if (this.mViewTransitionMode == 1) {
            int[] constraintSetIds = motionLayout.getConstraintSetIds();
            int i3 = 0;
            while (i3 < constraintSetIds.length) {
                int i4 = constraintSetIds[i3];
                if (i4 != i) {
                    ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i4);
                    int length = viewArr.length;
                    for (int i5 = i2; i5 < length; i5++) {
                        ConstraintSet.Constraint constraint = constraintSet2.getConstraint(viewArr[i5].getId());
                        if (this.mConstraintDelta != null) {
                            this.mConstraintDelta.applyDelta(constraint);
                            constraint.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
                        }
                    }
                }
                i3++;
                i2 = 0;
            }
        }
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(constraintSet);
        for (View view : viewArr) {
            ConstraintSet.Constraint constraint2 = constraintSet3.getConstraint(view.getId());
            if (this.mConstraintDelta != null) {
                this.mConstraintDelta.applyDelta(constraint2);
                constraint2.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
            }
        }
        motionLayout.updateState(i, constraintSet3);
        motionLayout.updateState(R.id.view_transition, constraintSet);
        motionLayout.setState(R.id.view_transition, -1, -1);
        MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.mScene, R.id.view_transition, i);
        for (View view2 : viewArr) {
            updateTransition(transition, view2);
        }
        motionLayout.setTransition(transition);
        motionLayout.transitionToEnd(new ViewTransition$$ExternalSyntheticLambda0(this, viewArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkTags(View view) {
        return (this.mIfTagSet == -1 || view.getTag(this.mIfTagSet) != null) && (this.mIfTagNotSet == -1 || view.getTag(this.mIfTagNotSet) == null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getId() {
        return this.mId;
    }

    Interpolator getInterpolator(Context context) {
        switch (this.mDefaultInterpolator) {
            case -2:
                return AnimationUtils.loadInterpolator(context, this.mDefaultInterpolatorID);
            case -1:
                return new AnonymousClass1(Easing.getInterpolator(this.mDefaultInterpolatorString));
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

    public int getSharedValue() {
        return this.mSharedValueTarget;
    }

    public int getSharedValueCurrent() {
        return this.mSharedValueCurrent;
    }

    public int getSharedValueID() {
        return this.mSharedValueID;
    }

    public int getStateTransition() {
        return this.mOnStateTransition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnabled() {
        return !this.mDisabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$applyTransition$0$androidx-constraintlayout-motion-widget-ViewTransition, reason: not valid java name */
    public /* synthetic */ void m40x14d7500(View[] viewArr) {
        if (this.mSetsTag != -1) {
            for (View view : viewArr) {
                view.setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.mClearsTag != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.mClearsTag, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matchesView(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.mTargetId == -1 && this.mTargetString == null) || !checkTags(view)) {
            return false;
        }
        if (view.getId() == this.mTargetId) {
            return true;
        }
        return this.mTargetString != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).constraintTag) != null && str.matches(this.mTargetString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.mDisabled = !z;
    }

    void setId(int i) {
        this.mId = i;
    }

    public void setSharedValue(int i) {
        this.mSharedValueTarget = i;
    }

    public void setSharedValueCurrent(int i) {
        this.mSharedValueCurrent = i;
    }

    public void setSharedValueID(int i) {
        this.mSharedValueID = i;
    }

    public void setStateTransition(int i) {
        this.mOnStateTransition = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supports(int i) {
        return this.mOnStateTransition == 1 ? i == 0 : this.mOnStateTransition == 2 ? i == 1 : this.mOnStateTransition == 3 && i == 0;
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.mContext, this.mId) + ")";
    }
}
