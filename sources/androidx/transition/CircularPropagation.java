package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        TransitionValues transitionValues3;
        ViewGroup viewGroup2;
        int round;
        int i;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        int i2 = 1;
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            transitionValues3 = transitionValues;
            i2 = -1;
        } else {
            transitionValues3 = transitionValues2;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i = epicenter.centerX();
            round = epicenter.centerY();
            viewGroup2 = viewGroup;
        } else {
            viewGroup2 = viewGroup;
            viewGroup2.getLocationOnScreen(new int[2]);
            int round2 = Math.round(r10[0] + (viewGroup2.getWidth() / 2) + viewGroup2.getTranslationX());
            round = Math.round(r10[1] + (viewGroup2.getHeight() / 2) + viewGroup2.getTranslationY());
            i = round2;
        }
        float distance = distance(viewX, viewY, i, round) / distance(0.0f, 0.0f, viewGroup2.getWidth(), viewGroup2.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (i2 * duration)) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f;
    }
}
