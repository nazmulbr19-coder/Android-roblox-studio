package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private boolean mResizeClip;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = new AnonymousClass1(PointF.class, "topLeft");
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = new AnonymousClass2(PointF.class, "bottomRight");
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new AnonymousClass3(PointF.class, "bottomRight");
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = new AnonymousClass4(PointF.class, "topLeft");
    private static final Property<View, PointF> POSITION_PROPERTY = new AnonymousClass5(PointF.class, "position");
    private static final RectEvaluator sRectEvaluator = new RectEvaluator();

    /* renamed from: androidx.transition.ChangeBounds$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends Property<ViewBounds, PointF> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public PointF get2(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(ViewBounds viewBounds) {
            return get2(viewBounds);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setTopLeft(pointF);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(ViewBounds viewBounds, PointF pointF) {
            set2(viewBounds, pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends Property<ViewBounds, PointF> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public PointF get2(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(ViewBounds viewBounds) {
            return get2(viewBounds);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setBottomRight(pointF);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(ViewBounds viewBounds, PointF pointF) {
            set2(viewBounds, pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends Property<View, PointF> {
        AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public PointF get2(View view) {
            return null;
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, PointF pointF) {
            set2(view, pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends Property<View, PointF> {
        AnonymousClass4(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public PointF get2(View view) {
            return null;
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, PointF pointF) {
            set2(view, pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends Property<View, PointF> {
        AnonymousClass5(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public PointF get2(View view) {
            return null;
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, PointF pointF) {
            set2(view, pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 extends AnimatorListenerAdapter {
        private final ViewBounds mViewBounds;
        final /* synthetic */ ViewBounds val$viewBounds;

        AnonymousClass6(ViewBounds viewBounds) {
            this.val$viewBounds = viewBounds;
            this.mViewBounds = this.val$viewBounds;
        }
    }

    /* loaded from: classes.dex */
    private static class ClipListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final int mEndBottom;
        private final Rect mEndClip;
        private final boolean mEndClipIsNull;
        private final int mEndLeft;
        private final int mEndRight;
        private final int mEndTop;
        private boolean mIsCanceled;
        private final int mStartBottom;
        private final Rect mStartClip;
        private final boolean mStartClipIsNull;
        private final int mStartLeft;
        private final int mStartRight;
        private final int mStartTop;
        private final View mView;

        ClipListener(View view, Rect rect, boolean z, Rect rect2, boolean z2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mView = view;
            this.mStartClip = rect;
            this.mStartClipIsNull = z;
            this.mEndClip = rect2;
            this.mEndClipIsNull = z2;
            this.mStartLeft = i;
            this.mStartTop = i2;
            this.mStartRight = i3;
            this.mStartBottom = i4;
            this.mEndLeft = i5;
            this.mEndTop = i6;
            this.mEndRight = i7;
            this.mEndBottom = i8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (this.mIsCanceled) {
                return;
            }
            Rect rect = null;
            if (z) {
                if (!this.mStartClipIsNull) {
                    rect = this.mStartClip;
                }
            } else if (!this.mEndClipIsNull) {
                rect = this.mEndClip;
            }
            this.mView.setClipBounds(rect);
            if (z) {
                ViewUtils.setLeftTopRightBottom(this.mView, this.mStartLeft, this.mStartTop, this.mStartRight, this.mStartBottom);
            } else {
                ViewUtils.setLeftTopRightBottom(this.mView, this.mEndLeft, this.mEndTop, this.mEndRight, this.mEndBottom);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
            int max = Math.max(this.mStartRight - this.mStartLeft, this.mEndRight - this.mEndLeft);
            int max2 = Math.max(this.mStartBottom - this.mStartTop, this.mEndBottom - this.mEndTop);
            int i = z ? this.mEndLeft : this.mStartLeft;
            int i2 = z ? this.mEndTop : this.mStartTop;
            ViewUtils.setLeftTopRightBottom(this.mView, i, i2, i + max, i2 + max2);
            this.mView.setClipBounds(z ? this.mEndClip : this.mStartClip);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            this.mIsCanceled = true;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            this.mView.setTag(R.id.transition_clip, this.mView.getClipBounds());
            this.mView.setClipBounds(this.mEndClipIsNull ? null : this.mEndClip);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            Rect rect = (Rect) this.mView.getTag(R.id.transition_clip);
            this.mView.setTag(R.id.transition_clip, null);
            this.mView.setClipBounds(rect);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    /* loaded from: classes.dex */
    private static class SuppressLayoutListener extends TransitionListenerAdapter {
        boolean mCanceled = false;
        final ViewGroup mParent;

        SuppressLayoutListener(ViewGroup viewGroup) {
            this.mParent = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            if (!this.mCanceled) {
                ViewGroupUtils.suppressLayout(this.mParent, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, true);
        }
    }

    /* loaded from: classes.dex */
    private static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private final View mView;

        ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            this.mBottomRightCalls++;
            if (this.mTopLeftCalls == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }

        void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            this.mTopLeftCalls++;
            if (this.mTopLeftCalls == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    public ChangeBounds() {
        this.mResizeClip = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mResizeClip = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        if (this.mResizeClip) {
            transitionValues.values.put(PROPNAME_CLIP, view.getClipBounds());
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        Rect rect;
        captureValues(transitionValues);
        if (!this.mResizeClip || (rect = (Rect) transitionValues.view.getTag(R.id.transition_clip)) == null) {
            return;
        }
        transitionValues.values.put(PROPNAME_CLIP, rect);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z;
        int i;
        int i2;
        Rect rect;
        Animator mergeAnimators;
        int i3;
        int i4;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 != null && viewGroup3 != null) {
            View view = transitionValues2.view;
            Rect rect2 = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect3 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            int i5 = rect2.left;
            int i6 = rect3.left;
            int i7 = rect2.top;
            int i8 = rect3.top;
            int i9 = rect2.right;
            int i10 = rect3.right;
            int i11 = rect2.bottom;
            int i12 = rect3.bottom;
            int i13 = i9 - i5;
            int i14 = i11 - i7;
            int i15 = i10 - i6;
            int i16 = i12 - i8;
            Rect rect4 = (Rect) transitionValues.values.get(PROPNAME_CLIP);
            Rect rect5 = (Rect) transitionValues2.values.get(PROPNAME_CLIP);
            if ((i13 != 0 && i14 != 0) || (i15 != 0 && i16 != 0)) {
                r10 = (i5 == i6 && i7 == i8) ? 0 : 0 + 1;
                if (i9 != i10 || i11 != i12) {
                    r10++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                r10++;
            }
            if (r10 <= 0) {
                return null;
            }
            if (this.mResizeClip) {
                z = true;
                ViewUtils.setLeftTopRightBottom(view, i5, i7, i5 + Math.max(i13, i15), i7 + Math.max(i14, i16));
                ObjectAnimator objectAnimator = null;
                if (i5 == i6 && i7 == i8) {
                    i = i11;
                    i2 = i12;
                } else {
                    i = i11;
                    i2 = i12;
                    objectAnimator = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath(i5, i7, i6, i8));
                }
                boolean z2 = rect4 == null;
                Rect rect6 = z2 ? new Rect(0, 0, i13, i14) : rect4;
                boolean z3 = rect5 == null;
                Rect rect7 = z3 ? new Rect(0, 0, i15, i16) : rect5;
                ObjectAnimator objectAnimator2 = null;
                if (rect6.equals(rect7)) {
                    rect = rect7;
                } else {
                    view.setClipBounds(rect6);
                    objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", sRectEvaluator, rect6, rect7);
                    rect = rect7;
                    ClipListener clipListener = new ClipListener(view, rect6, z2, rect, z3, i5, i7, i9, i, i6, i8, i10, i2);
                    objectAnimator2.addListener(clipListener);
                    addListener(clipListener);
                }
                mergeAnimators = TransitionUtils.mergeAnimators(objectAnimator, objectAnimator2);
            } else {
                ViewUtils.setLeftTopRightBottom(view, i5, i7, i9, i11);
                z = true;
                if (r10 == 2) {
                    if (i13 != i15) {
                        i3 = i13;
                        i4 = i14;
                    } else if (i14 == i16) {
                        mergeAnimators = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath(i5, i7, i6, i8));
                    } else {
                        i4 = i14;
                        i3 = i13;
                    }
                    ViewBounds viewBounds = new ViewBounds(view);
                    ObjectAnimator ofPointF = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath(i5, i7, i6, i8));
                    ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(i9, i11, i10, i12));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ofPointF, ofPointF2);
                    animatorSet.addListener(new AnonymousClass6(viewBounds));
                    mergeAnimators = animatorSet;
                } else {
                    mergeAnimators = (i5 == i6 && i7 == i8) ? ObjectAnimatorUtils.ofPointF(view, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(i9, i11, i10, i12)) : ObjectAnimatorUtils.ofPointF(view, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(i5, i7, i6, i8));
                }
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ViewGroupUtils.suppressLayout(viewGroup4, z);
                getRootTransition().addListener(new SuppressLayoutListener(viewGroup4));
            }
            return mergeAnimators;
        }
        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public void setResizeClip(boolean z) {
        this.mResizeClip = z;
    }
}
