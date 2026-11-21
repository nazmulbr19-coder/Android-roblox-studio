package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ List val$awaitingContainerChanges;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;

        AnonymousClass1(List list, SpecialEffectsController.Operation operation) {
            this.val$awaitingContainerChanges = list;
            this.val$operation = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$awaitingContainerChanges.contains(this.val$operation)) {
                this.val$awaitingContainerChanges.remove(this.val$operation);
                DefaultSpecialEffectsController.this.applyContainerChanges(this.val$operation);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimationInfo val$animationInfo;
        final /* synthetic */ ViewGroup val$container;
        final /* synthetic */ boolean val$isHideOperation;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;
        final /* synthetic */ View val$viewToAnimate;

        AnonymousClass2(ViewGroup viewGroup, View view, boolean z, SpecialEffectsController.Operation operation, AnimationInfo animationInfo) {
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$isHideOperation = z;
            this.val$operation = operation;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$container.endViewTransition(this.val$viewToAnimate);
            if (this.val$isHideOperation) {
                this.val$operation.getFinalState().applyState(this.val$viewToAnimate);
            }
            this.val$animationInfo.completeSpecialEffect();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animator from operation " + this.val$operation + " has ended.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements CancellationSignal.OnCancelListener {
        final /* synthetic */ Animator val$animator;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;

        AnonymousClass3(Animator animator, SpecialEffectsController.Operation operation) {
            this.val$animator = animator;
            this.val$operation = operation;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            this.val$animator.end();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animator from operation " + this.val$operation + " has been canceled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements Animation.AnimationListener {
        final /* synthetic */ AnimationInfo val$animationInfo;
        final /* synthetic */ ViewGroup val$container;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;
        final /* synthetic */ View val$viewToAnimate;

        /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass4.this.val$container.endViewTransition(AnonymousClass4.this.val$viewToAnimate);
                AnonymousClass4.this.val$animationInfo.completeSpecialEffect();
            }
        }

        AnonymousClass4(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, AnimationInfo animationInfo) {
            this.val$operation = operation;
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.val$container.post(new AnonymousClass1());
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + this.val$operation + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + this.val$operation + " has reached onAnimationStart.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 implements CancellationSignal.OnCancelListener {
        final /* synthetic */ AnimationInfo val$animationInfo;
        final /* synthetic */ ViewGroup val$container;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;
        final /* synthetic */ View val$viewToAnimate;

        AnonymousClass5(View view, ViewGroup viewGroup, AnimationInfo animationInfo, SpecialEffectsController.Operation operation) {
            this.val$viewToAnimate = view;
            this.val$container = viewGroup;
            this.val$animationInfo = animationInfo;
            this.val$operation = operation;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            this.val$viewToAnimate.clearAnimation();
            this.val$container.endViewTransition(this.val$viewToAnimate);
            this.val$animationInfo.completeSpecialEffect();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + this.val$operation + " has been cancelled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ SpecialEffectsController.Operation val$firstOut;
        final /* synthetic */ boolean val$isPop;
        final /* synthetic */ SpecialEffectsController.Operation val$lastIn;
        final /* synthetic */ ArrayMap val$lastInViews;

        AnonymousClass6(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z, ArrayMap arrayMap) {
            this.val$lastIn = operation;
            this.val$firstOut = operation2;
            this.val$isPop = z;
            this.val$lastInViews = arrayMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.callSharedElementStartEnd(this.val$lastIn.getFragment(), this.val$firstOut.getFragment(), this.val$isPop, this.val$lastInViews, false);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$7, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ FragmentTransitionImpl val$impl;
        final /* synthetic */ Rect val$lastInEpicenterRect;
        final /* synthetic */ View val$lastInEpicenterView;

        AnonymousClass7(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
            this.val$impl = fragmentTransitionImpl;
            this.val$lastInEpicenterView = view;
            this.val$lastInEpicenterRect = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$impl.getBoundsOnScreen(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$8, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ ArrayList val$transitioningViews;

        AnonymousClass8(ArrayList arrayList) {
            this.val$transitioningViews = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.setViewVisibility(this.val$transitioningViews, 4);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$9, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ SpecialEffectsController.Operation val$operation;
        final /* synthetic */ TransitionInfo val$transitionInfo;

        AnonymousClass9(TransitionInfo transitionInfo, SpecialEffectsController.Operation operation) {
            this.val$transitionInfo = transitionInfo;
            this.val$operation = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$transitionInfo.completeSpecialEffect();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Transition for operation " + this.val$operation + "has completed");
            }
        }
    }

    /* loaded from: classes.dex */
    private static class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z;
        }

        FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            this.mAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mLoadedAnim = true;
            return this.mAnimation;
        }
    }

    /* loaded from: classes.dex */
    private static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation mOperation;
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return from == finalState || !(from == SpecialEffectsController.Operation.State.VISIBLE || finalState == SpecialEffectsController.Operation.State.VISIBLE);
        }
    }

    /* loaded from: classes.dex */
    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final Object mSharedElementTransition;
        private final Object mTransition;

        TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.mTransition = z ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mOverlapAllowed = z ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            if (FragmentTransition.PLATFORM_IMPL != null && FragmentTransition.PLATFORM_IMPL.canHandle(obj)) {
                return FragmentTransition.PLATFORM_IMPL;
            }
            if (FragmentTransition.SUPPORT_IMPL == null || !FragmentTransition.SUPPORT_IMPL.canHandle(obj)) {
                throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
            }
            return FragmentTransition.SUPPORT_IMPL;
        }

        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(List<AnimationInfo> list, List<SpecialEffectsController.Operation> list2, boolean z, Map<SpecialEffectsController.Operation, Boolean> map) {
        int i;
        AnimationInfo animationInfo;
        View view;
        int i2;
        SpecialEffectsController.Operation operation;
        ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<AnimationInfo> it = list.iterator();
        boolean z2 = false;
        while (true) {
            i = 2;
            if (!it.hasNext()) {
                break;
            }
            AnimationInfo next = it.next();
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation operation2 = next.getOperation();
                        Fragment fragment = operation2.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation2))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            boolean z3 = operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z3) {
                                list2.remove(operation2);
                            }
                            View view2 = fragment.mView;
                            container.startViewTransition(view2);
                            ViewGroup viewGroup = container;
                            animator.addListener(new AnonymousClass2(viewGroup, view2, z3, operation2, next));
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has started.");
                            }
                            next.getSignal().setOnCancelListener(new AnonymousClass3(animator, operation2));
                            container = viewGroup;
                            z2 = true;
                        }
                    }
                }
            }
        }
        ViewGroup viewGroup2 = container;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AnimationInfo animationInfo2 = (AnimationInfo) it2.next();
            SpecialEffectsController.Operation operation3 = animationInfo2.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(i)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (FragmentManager.isLoggingEnabled(i)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                View view3 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation3.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                    view = view3;
                    operation = operation3;
                    animationInfo = animationInfo2;
                    i2 = i;
                } else {
                    viewGroup2.startViewTransition(view3);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, viewGroup2, view3);
                    ViewGroup viewGroup3 = viewGroup2;
                    animationInfo = animationInfo2;
                    view = view3;
                    i2 = i;
                    operation = operation3;
                    viewGroup2 = viewGroup3;
                    endViewTransitionAnimation.setAnimationListener(new AnonymousClass4(operation3, viewGroup3, view, animationInfo));
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(i2)) {
                        Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has started.");
                    }
                }
                ViewGroup viewGroup4 = viewGroup2;
                viewGroup2 = viewGroup4;
                animationInfo.getSignal().setOnCancelListener(new AnonymousClass5(view, viewGroup4, animationInfo, operation));
                i = i2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:201:0x059e, code lost:
    
        if (r11 == r39) goto L169;
     */
    /* JADX WARN: Removed duplicated region for block: B:211:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0604  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> startTransitions(java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> r35, java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r36, boolean r37, androidx.fragment.app.SpecialEffectsController.Operation r38, androidx.fragment.app.SpecialEffectsController.Operation r39) {
        /*
            Method dump skipped, instructions count: 1769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.startTransitions(java.util.List, java.util.List, boolean, androidx.fragment.app.SpecialEffectsController$Operation, androidx.fragment.app.SpecialEffectsController$Operation):java.util.Map");
    }

    private void syncAnimations(List<SpecialEffectsController.Operation> list) {
        Fragment fragment = list.get(list.size() - 1).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    void applyContainerChanges(SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            switch (operation3.getFinalState()) {
                case GONE:
                case INVISIBLE:
                case REMOVED:
                    if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                        operation = operation3;
                        break;
                    }
                    break;
                case VISIBLE:
                    if (from != SpecialEffectsController.Operation.State.VISIBLE) {
                        operation2 = operation3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int i = 2;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        syncAnimations(list);
        Iterator<SpecialEffectsController.Operation> it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                int i2 = i;
                SpecialEffectsController.Operation operation4 = operation;
                Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z, operation4, operation2);
                startAnimations(arrayList, arrayList3, startTransitions.containsValue(true), startTransitions);
                Iterator<SpecialEffectsController.Operation> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    applyContainerChanges(it2.next());
                }
                arrayList3.clear();
                if (FragmentManager.isLoggingEnabled(i2)) {
                    Log.v(FragmentManager.TAG, "Completed executing operations from " + operation4 + " to " + operation2);
                    return;
                }
                return;
            }
            SpecialEffectsController.Operation next = it.next();
            CancellationSignal cancellationSignal = new CancellationSignal();
            next.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(next, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            next.markStartedSpecialEffect(cancellationSignal2);
            int i3 = i;
            if (z) {
                if (next == operation) {
                    arrayList2.add(new TransitionInfo(next, cancellationSignal2, z, z2));
                    next.addCompletionListener(new AnonymousClass1(arrayList3, next));
                    i = i3;
                }
                z2 = false;
                arrayList2.add(new TransitionInfo(next, cancellationSignal2, z, z2));
                next.addCompletionListener(new AnonymousClass1(arrayList3, next));
                i = i3;
            } else {
                if (next == operation2) {
                    arrayList2.add(new TransitionInfo(next, cancellationSignal2, z, z2));
                    next.addCompletionListener(new AnonymousClass1(arrayList3, next));
                    i = i3;
                }
                z2 = false;
                arrayList2.add(new TransitionInfo(next, cancellationSignal2, z, z2));
                next.addCompletionListener(new AnonymousClass1(arrayList3, next));
                i = i3;
            }
        }
    }

    void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
