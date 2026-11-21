package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ViewTransitionController {
    ArrayList<ViewTransition.Animate> mAnimations;
    private final MotionLayout mMotionLayout;
    private HashSet<View> mRelatedViews;
    private ArrayList<ViewTransition> mViewTransitions = new ArrayList<>();
    private String mTAG = "ViewTransitionController";
    ArrayList<ViewTransition.Animate> mRemoveList = new ArrayList<>();

    /* renamed from: androidx.constraintlayout.motion.widget.ViewTransitionController$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements SharedValues.SharedValuesListener {
        final /* synthetic */ boolean val$isSet;
        final /* synthetic */ int val$listen_for_id;
        final /* synthetic */ int val$listen_for_value;
        final /* synthetic */ ViewTransition val$viewTransition;

        AnonymousClass1(ViewTransition viewTransition, int i, boolean z, int i2) {
            this.val$viewTransition = viewTransition;
            this.val$listen_for_id = i;
            this.val$isSet = z;
            this.val$listen_for_value = i2;
        }

        @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
        public void onNewValue(int i, int i2, int i3) {
            int sharedValueCurrent = this.val$viewTransition.getSharedValueCurrent();
            this.val$viewTransition.setSharedValueCurrent(i2);
            if (this.val$listen_for_id != i || sharedValueCurrent == i2) {
                return;
            }
            if (this.val$isSet) {
                if (this.val$listen_for_value == i2) {
                    int childCount = ViewTransitionController.access$000(ViewTransitionController.this).getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = ViewTransitionController.access$000(ViewTransitionController.this).getChildAt(i4);
                        if (this.val$viewTransition.matchesView(childAt)) {
                            int currentState = ViewTransitionController.access$000(ViewTransitionController.this).getCurrentState();
                            this.val$viewTransition.applyTransition(ViewTransitionController.this, ViewTransitionController.access$000(ViewTransitionController.this), currentState, ViewTransitionController.access$000(ViewTransitionController.this).getConstraintSet(currentState), childAt);
                        }
                    }
                    return;
                }
                return;
            }
            if (this.val$listen_for_value != i2) {
                int childCount2 = ViewTransitionController.access$000(ViewTransitionController.this).getChildCount();
                for (int i5 = 0; i5 < childCount2; i5++) {
                    View childAt2 = ViewTransitionController.access$000(ViewTransitionController.this).getChildAt(i5);
                    if (this.val$viewTransition.matchesView(childAt2)) {
                        int currentState2 = ViewTransitionController.access$000(ViewTransitionController.this).getCurrentState();
                        this.val$viewTransition.applyTransition(ViewTransitionController.this, ViewTransitionController.access$000(ViewTransitionController.this), currentState2, ViewTransitionController.access$000(ViewTransitionController.this).getConstraintSet(currentState2), childAt2);
                    }
                }
            }
        }
    }

    public ViewTransitionController(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    static /* synthetic */ MotionLayout access$000(ViewTransitionController viewTransitionController) {
        return viewTransitionController.mMotionLayout;
    }

    private void listenForSharedVariable(ViewTransition viewTransition, boolean z) {
        ConstraintLayout.getSharedValues().addListener(viewTransition.getSharedValueID(), new AnonymousClass1(viewTransition, viewTransition.getSharedValueID(), z, viewTransition.getSharedValue()));
    }

    private void viewTransition(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.mMotionLayout.getCurrentState();
        if (viewTransition.mViewTransitionMode == 2) {
            viewTransition.applyTransition(this, this.mMotionLayout, currentState, null, viewArr);
            return;
        }
        if (currentState == -1) {
            Log.w(this.mTAG, "No support for ViewTransition within transition yet. Currently: " + this.mMotionLayout.toString());
            return;
        }
        ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(currentState);
        if (constraintSet == null) {
            return;
        }
        viewTransition.applyTransition(this, this.mMotionLayout, currentState, constraintSet, viewArr);
    }

    public void add(ViewTransition viewTransition) {
        this.mViewTransitions.add(viewTransition);
        this.mRelatedViews = null;
        if (viewTransition.getStateTransition() == 4) {
            listenForSharedVariable(viewTransition, true);
        } else if (viewTransition.getStateTransition() == 5) {
            listenForSharedVariable(viewTransition, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAnimation(ViewTransition.Animate animate) {
        if (this.mAnimations == null) {
            this.mAnimations = new ArrayList<>();
        }
        this.mAnimations.add(animate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void animate() {
        if (this.mAnimations == null) {
            return;
        }
        Iterator<ViewTransition.Animate> it = this.mAnimations.iterator();
        while (it.hasNext()) {
            it.next().mutate();
        }
        this.mAnimations.removeAll(this.mRemoveList);
        this.mRemoveList.clear();
        if (this.mAnimations.isEmpty()) {
            this.mAnimations = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean applyViewTransition(int i, MotionController motionController) {
        Iterator<ViewTransition> it = this.mViewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.getId() == i) {
                next.mKeyFrames.addAllFrames(motionController);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enableViewTransition(int i, boolean z) {
        Iterator<ViewTransition> it = this.mViewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.getId() == i) {
                next.setEnabled(z);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate() {
        this.mMotionLayout.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isViewTransitionEnabled(int i) {
        Iterator<ViewTransition> it = this.mViewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.getId() == i) {
                return next.isEnabled();
            }
        }
        return false;
    }

    void remove(int i) {
        ViewTransition viewTransition = null;
        Iterator<ViewTransition> it = this.mViewTransitions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ViewTransition next = it.next();
            if (next.getId() == i) {
                viewTransition = next;
                break;
            }
        }
        if (viewTransition != null) {
            this.mRelatedViews = null;
            this.mViewTransitions.remove(viewTransition);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAnimation(ViewTransition.Animate animate) {
        this.mRemoveList.add(animate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void touchEvent(MotionEvent motionEvent) {
        int currentState = this.mMotionLayout.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.mRelatedViews == null) {
            this.mRelatedViews = new HashSet<>();
            Iterator<ViewTransition> it = this.mViewTransitions.iterator();
            while (it.hasNext()) {
                ViewTransition next = it.next();
                int childCount = this.mMotionLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.mMotionLayout.getChildAt(i);
                    if (next.matchesView(childAt)) {
                        childAt.getId();
                        this.mRelatedViews.add(childAt);
                    }
                }
            }
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        if (this.mAnimations != null && !this.mAnimations.isEmpty()) {
            Iterator<ViewTransition.Animate> it2 = this.mAnimations.iterator();
            while (it2.hasNext()) {
                it2.next().reactTo(action, x, y);
            }
        }
        switch (action) {
            case 0:
            case 1:
                ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(currentState);
                Iterator<ViewTransition> it3 = this.mViewTransitions.iterator();
                while (it3.hasNext()) {
                    ViewTransition next2 = it3.next();
                    if (next2.supports(action)) {
                        Iterator<View> it4 = this.mRelatedViews.iterator();
                        while (it4.hasNext()) {
                            View next3 = it4.next();
                            if (next2.matchesView(next3)) {
                                next3.getHitRect(rect);
                                if (rect.contains((int) x, (int) y)) {
                                    next2.applyTransition(this, this.mMotionLayout, currentState, constraintSet, next3);
                                }
                            }
                        }
                    }
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void viewTransition(int i, View... viewArr) {
        ViewTransition viewTransition = null;
        ArrayList arrayList = new ArrayList();
        Iterator<ViewTransition> it = this.mViewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.getId() == i) {
                viewTransition = next;
                for (View view : viewArr) {
                    if (next.checkTags(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    viewTransition(viewTransition, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
            }
        }
        if (viewTransition == null) {
            Log.e(this.mTAG, " Could not find ViewTransition");
        }
    }
}
