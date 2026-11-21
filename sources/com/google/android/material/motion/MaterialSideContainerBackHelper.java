package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* loaded from: classes.dex */
public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistanceGrow;
    private final float maxScaleXDistanceShrink;
    private final float maxScaleYDistance;

    /* renamed from: com.google.android.material.motion.MaterialSideContainerBackHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ int val$gravity;
        final /* synthetic */ boolean val$leftSwipeEdge;

        AnonymousClass1(boolean z, int i) {
            this.val$leftSwipeEdge = z;
            this.val$gravity = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MaterialSideContainerBackHelper.this.view.setTranslationX(0.0f);
            MaterialSideContainerBackHelper.this.updateBackProgress(0.0f, this.val$leftSwipeEdge, this.val$gravity);
        }
    }

    public MaterialSideContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistanceShrink = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.maxScaleXDistanceGrow = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.maxScaleYDistance = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    private boolean checkAbsoluteGravity(int i, int i2) {
        return (Gravity.getAbsoluteGravity(i, this.view.getLayoutDirection()) & i2) == i2;
    }

    private int getEdgeMargin(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_Y, 1.0f));
        if (this.view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) this.view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.cancelDuration);
        animatorSet.start();
    }

    public void finishBackProgress(BackEventCompat backEventCompat, int i, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z = backEventCompat.getSwipeEdge() == 0;
        boolean checkAbsoluteGravity = checkAbsoluteGravity(i, 3);
        float width = (this.view.getWidth() * this.view.getScaleX()) + getEdgeMargin(checkAbsoluteGravity);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.TRANSLATION_X, checkAbsoluteGravity ? -width : width);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEventCompat.getProgress()));
        ofFloat.addListener(new AnonymousClass1(z, i));
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void startBackProgress(BackEventCompat backEventCompat) {
        super.onStartBackProgress(backEventCompat);
    }

    public void updateBackProgress(float f, boolean z, int i) {
        int i2;
        float f2;
        float interpolateProgress = interpolateProgress(f);
        boolean checkAbsoluteGravity = checkAbsoluteGravity(i, 3);
        boolean z2 = z == checkAbsoluteGravity;
        int width = this.view.getWidth();
        int height = this.view.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float f3 = this.maxScaleXDistanceShrink / width;
            float f4 = this.maxScaleXDistanceGrow / width;
            float f5 = this.maxScaleYDistance / height;
            this.view.setPivotX(checkAbsoluteGravity ? 0.0f : width);
            float lerp = AnimationUtils.lerp(0.0f, z2 ? f4 : -f3, interpolateProgress);
            float f6 = lerp + 1.0f;
            float lerp2 = 1.0f - AnimationUtils.lerp(0.0f, f5, interpolateProgress);
            if (!Float.isNaN(f6) && !Float.isNaN(lerp2)) {
                this.view.setScaleX(f6);
                this.view.setScaleY(lerp2);
                if (!(this.view instanceof ViewGroup)) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) this.view;
                int i3 = 0;
                while (true) {
                    float f7 = interpolateProgress;
                    if (i3 >= viewGroup.getChildCount()) {
                        return;
                    }
                    View childAt = viewGroup.getChildAt(i3);
                    if (checkAbsoluteGravity) {
                        i2 = i3;
                        f2 = (width - childAt.getRight()) + childAt.getWidth();
                    } else {
                        i2 = i3;
                        f2 = -childAt.getLeft();
                    }
                    childAt.setPivotX(f2);
                    childAt.setPivotY(-childAt.getTop());
                    float f8 = z2 ? 1.0f - lerp : 1.0f;
                    float f9 = lerp2 != 0.0f ? (f6 / lerp2) * f8 : 1.0f;
                    if (!Float.isNaN(f8) && !Float.isNaN(f9)) {
                        childAt.setScaleX(f8);
                        childAt.setScaleY(f9);
                    }
                    i3 = i2 + 1;
                    interpolateProgress = f7;
                }
            }
        }
    }

    public void updateBackProgress(BackEventCompat backEventCompat, int i) {
        if (super.onUpdateBackProgress(backEventCompat) == null) {
            return;
        }
        updateBackProgress(backEventCompat.getProgress(), backEventCompat.getSwipeEdge() == 0, i);
    }
}
