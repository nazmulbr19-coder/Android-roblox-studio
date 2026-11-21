package com.google.android.material.navigationrail;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;

/* loaded from: classes.dex */
class LabelMoveTransition extends Transition {
    private static final float HORIZONTAL_DISTANCE = -30.0f;
    private static final String LABEL_VISIBILITY = "NavigationRailLabelVisibility";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$createAnimator$0(View view, ValueAnimator valueAnimator) {
        view.setTranslationX((1.0f - valueAnimator.getAnimatedFraction()) * HORIZONTAL_DISTANCE);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        transitionValues.values.put(LABEL_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        transitionValues.values.put(LABEL_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || transitionValues.values.get(LABEL_VISIBILITY) == null || transitionValues2.values.get(LABEL_VISIBILITY) == null) {
            return super.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
        if (((Integer) transitionValues.values.get(LABEL_VISIBILITY)).intValue() != 8 || ((Integer) transitionValues2.values.get(LABEL_VISIBILITY)).intValue() != 0) {
            return super.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
        View view = transitionValues2.view;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new LabelMoveTransition$$ExternalSyntheticLambda0(view));
        return ofFloat;
    }
}
