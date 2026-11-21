package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Carousel extends MotionHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "Carousel";
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private Adapter mAdapter;
    private int mAnimateTargetDelay;
    private int mBackwardTransition;
    private float mDampening;
    private int mEmptyViewBehavior;
    private int mFirstViewReference;
    private int mForwardTransition;
    private int mIndex;
    private boolean mInfiniteCarousel;
    int mLastStartId;
    private final ArrayList<View> mList;
    private MotionLayout mMotionLayout;
    private int mNextState;
    private int mPreviousIndex;
    private int mPreviousState;
    private int mStartIndex;
    private int mTargetIndex;
    private int mTouchUpMode;
    Runnable mUpdateRunnable;
    private float mVelocityThreshold;

    /* renamed from: androidx.constraintlayout.helper.widget.Carousel$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: androidx.constraintlayout.helper.widget.Carousel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC00001 implements Runnable {
            final /* synthetic */ float val$v;

            RunnableC00001(float f) {
                this.val$v = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.access$000(Carousel.this).touchAnimateTo(5, 1.0f, this.val$v);
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Carousel.access$000(Carousel.this).setProgress(0.0f);
            Carousel.access$100(Carousel.this);
            Carousel.access$300(Carousel.this).onNewItem(Carousel.access$200(Carousel.this));
            float velocity = Carousel.access$000(Carousel.this).getVelocity();
            if (Carousel.access$400(Carousel.this) != 2 || velocity <= Carousel.access$500(Carousel.this) || Carousel.access$200(Carousel.this) >= Carousel.access$300(Carousel.this).count() - 1) {
                return;
            }
            float access$600 = Carousel.access$600(Carousel.this) * velocity;
            if (Carousel.access$200(Carousel.this) != 0 || Carousel.access$700(Carousel.this) <= Carousel.access$200(Carousel.this)) {
                if (Carousel.access$200(Carousel.this) != Carousel.access$300(Carousel.this).count() - 1 || Carousel.access$700(Carousel.this) >= Carousel.access$200(Carousel.this)) {
                    Carousel.access$000(Carousel.this).post(new RunnableC00001(access$600));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface Adapter {
        int count();

        void onNewItem(int i);

        void populate(View view, int i);
    }

    public Carousel(Context context) {
        super(context);
        this.mAdapter = null;
        this.mList = new ArrayList<>();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1();
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdapter = null;
        this.mList = new ArrayList<>();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1();
        init(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAdapter = null;
        this.mList = new ArrayList<>();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1();
        init(context, attributeSet);
    }

    static /* synthetic */ MotionLayout access$000(Carousel carousel) {
        return carousel.mMotionLayout;
    }

    static /* synthetic */ void access$100(Carousel carousel) {
        carousel.updateItems();
    }

    static /* synthetic */ int access$200(Carousel carousel) {
        return carousel.mIndex;
    }

    static /* synthetic */ Adapter access$300(Carousel carousel) {
        return carousel.mAdapter;
    }

    static /* synthetic */ int access$400(Carousel carousel) {
        return carousel.mTouchUpMode;
    }

    static /* synthetic */ float access$500(Carousel carousel) {
        return carousel.mVelocityThreshold;
    }

    static /* synthetic */ float access$600(Carousel carousel) {
        return carousel.mDampening;
    }

    static /* synthetic */ int access$700(Carousel carousel) {
        return carousel.mPreviousIndex;
    }

    private void enableAllTransitions(boolean z) {
        Iterator<MotionScene.Transition> it = this.mMotionLayout.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z);
        }
    }

    private boolean enableTransition(int i, boolean z) {
        MotionScene.Transition transition;
        if (i == -1 || this.mMotionLayout == null || (transition = this.mMotionLayout.getTransition(i)) == null || z == transition.isEnabled()) {
            return false;
        }
        transition.setEnabled(z);
        return true;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.mFirstViewReference = obtainStyledAttributes.getResourceId(index, this.mFirstViewReference);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.mBackwardTransition = obtainStyledAttributes.getResourceId(index, this.mBackwardTransition);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.mForwardTransition = obtainStyledAttributes.getResourceId(index, this.mForwardTransition);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.mEmptyViewBehavior = obtainStyledAttributes.getInt(index, this.mEmptyViewBehavior);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.mPreviousState = obtainStyledAttributes.getResourceId(index, this.mPreviousState);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.mNextState = obtainStyledAttributes.getResourceId(index, this.mNextState);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.mDampening = obtainStyledAttributes.getFloat(index, this.mDampening);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.mTouchUpMode = obtainStyledAttributes.getInt(index, this.mTouchUpMode);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.mVelocityThreshold = obtainStyledAttributes.getFloat(index, this.mVelocityThreshold);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.mInfiniteCarousel = obtainStyledAttributes.getBoolean(index, this.mInfiniteCarousel);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void updateItems() {
        if (this.mAdapter == null || this.mMotionLayout == null || this.mAdapter.count() == 0) {
            return;
        }
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            View view = this.mList.get(i);
            int i2 = (this.mIndex + i) - this.mStartIndex;
            if (this.mInfiniteCarousel) {
                if (i2 < 0) {
                    if (this.mEmptyViewBehavior != 4) {
                        updateViewVisibility(view, this.mEmptyViewBehavior);
                    } else {
                        updateViewVisibility(view, 0);
                    }
                    if (i2 % this.mAdapter.count() == 0) {
                        this.mAdapter.populate(view, 0);
                    } else {
                        this.mAdapter.populate(view, this.mAdapter.count() + (i2 % this.mAdapter.count()));
                    }
                } else if (i2 >= this.mAdapter.count()) {
                    if (i2 == this.mAdapter.count()) {
                        i2 = 0;
                    } else if (i2 > this.mAdapter.count()) {
                        i2 %= this.mAdapter.count();
                    }
                    if (this.mEmptyViewBehavior != 4) {
                        updateViewVisibility(view, this.mEmptyViewBehavior);
                    } else {
                        updateViewVisibility(view, 0);
                    }
                    this.mAdapter.populate(view, i2);
                } else {
                    updateViewVisibility(view, 0);
                    this.mAdapter.populate(view, i2);
                }
            } else if (i2 < 0) {
                updateViewVisibility(view, this.mEmptyViewBehavior);
            } else if (i2 >= this.mAdapter.count()) {
                updateViewVisibility(view, this.mEmptyViewBehavior);
            } else {
                updateViewVisibility(view, 0);
                this.mAdapter.populate(view, i2);
            }
        }
        if (this.mTargetIndex != -1 && this.mTargetIndex != this.mIndex) {
            this.mMotionLayout.post(new Carousel$$ExternalSyntheticLambda0(this));
        } else if (this.mTargetIndex == this.mIndex) {
            this.mTargetIndex = -1;
        }
        if (this.mBackwardTransition == -1 || this.mForwardTransition == -1) {
            Log.w(TAG, "No backward or forward transitions defined for Carousel!");
            return;
        }
        if (this.mInfiniteCarousel) {
            return;
        }
        int count = this.mAdapter.count();
        if (this.mIndex == 0) {
            enableTransition(this.mBackwardTransition, false);
        } else {
            enableTransition(this.mBackwardTransition, true);
            this.mMotionLayout.setTransition(this.mBackwardTransition);
        }
        if (this.mIndex == count - 1) {
            enableTransition(this.mForwardTransition, false);
        } else {
            enableTransition(this.mForwardTransition, true);
            this.mMotionLayout.setTransition(this.mForwardTransition);
        }
    }

    private boolean updateViewVisibility(int i, View view, int i2) {
        ConstraintSet.Constraint constraint;
        ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(i);
        if (constraintSet == null || (constraint = constraintSet.getConstraint(view.getId())) == null) {
            return false;
        }
        constraint.propertySet.mVisibilityMode = 1;
        view.setVisibility(i2);
        return true;
    }

    private boolean updateViewVisibility(View view, int i) {
        if (this.mMotionLayout == null) {
            return false;
        }
        boolean z = false;
        for (int i2 : this.mMotionLayout.getConstraintSetIds()) {
            z |= updateViewVisibility(i2, view, i);
        }
        return z;
    }

    public int getCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public boolean isInfinite() {
        return this.mInfiniteCarousel;
    }

    public void jumpToIndex(int i) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, i));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateItems$0$androidx-constraintlayout-helper-widget-Carousel, reason: not valid java name */
    public /* synthetic */ void m38xc943cdea() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (this.mTargetIndex < this.mIndex) {
            this.mMotionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        } else {
            this.mMotionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            this.mList.clear();
            for (int i = 0; i < this.mCount; i++) {
                int i2 = this.mIds[i];
                View viewById = motionLayout.getViewById(i2);
                if (this.mFirstViewReference == i2) {
                    this.mStartIndex = i;
                }
                this.mList.add(viewById);
            }
            this.mMotionLayout = motionLayout;
            if (this.mTouchUpMode == 2) {
                MotionScene.Transition transition = this.mMotionLayout.getTransition(this.mForwardTransition);
                if (transition != null) {
                    transition.setOnTouchUp(5);
                }
                MotionScene.Transition transition2 = this.mMotionLayout.getTransition(this.mBackwardTransition);
                if (transition2 != null) {
                    transition2.setOnTouchUp(5);
                }
            }
            updateItems();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mList.clear();
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
        this.mLastStartId = i;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        this.mPreviousIndex = this.mIndex;
        if (i == this.mNextState) {
            this.mIndex++;
        } else if (i == this.mPreviousState) {
            this.mIndex--;
        }
        if (this.mInfiniteCarousel) {
            if (this.mIndex >= this.mAdapter.count()) {
                this.mIndex = 0;
            }
            if (this.mIndex < 0) {
                this.mIndex = this.mAdapter.count() - 1;
            }
        } else {
            if (this.mIndex >= this.mAdapter.count()) {
                this.mIndex = this.mAdapter.count() - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        }
        if (this.mPreviousIndex != this.mIndex) {
            this.mMotionLayout.post(this.mUpdateRunnable);
        }
    }

    public void refresh() {
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            View view = this.mList.get(i);
            if (this.mAdapter.count() == 0) {
                updateViewVisibility(view, this.mEmptyViewBehavior);
            } else {
                updateViewVisibility(view, 0);
            }
        }
        this.mMotionLayout.rebuildScene();
        updateItems();
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void setInfinite(boolean z) {
        this.mInfiniteCarousel = z;
    }

    public void transitionToIndex(int i, int i2) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, i));
        this.mAnimateTargetDelay = Math.max(0, i2);
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (i < this.mIndex) {
            this.mMotionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        } else {
            this.mMotionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
        }
    }
}
