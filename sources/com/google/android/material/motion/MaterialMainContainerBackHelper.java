package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes.dex */
public class MaterialMainContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private static final float MIN_SCALE = 0.9f;
    private float[] expandedCornerRadii;
    private Rect initialHideFromClipBounds;
    private Rect initialHideToClipBounds;
    private float initialTouchY;
    private final float maxTranslationY;
    private final float minEdgeGap;

    /* renamed from: com.google.android.material.motion.MaterialMainContainerBackHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ View val$collapsedView;

        AnonymousClass1(View view) {
            this.val$collapsedView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.val$collapsedView != null) {
                this.val$collapsedView.setVisibility(0);
            }
        }
    }

    public MaterialMainContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.minEdgeGap = resources.getDimension(R.dimen.m3_back_progress_main_container_min_edge_gap);
        this.maxTranslationY = resources.getDimension(R.dimen.m3_back_progress_main_container_max_translation_y);
    }

    private float[] calculateExpandedCornerRadii() {
        WindowInsets rootWindowInsets;
        char c;
        int i;
        if (Build.VERSION.SDK_INT < 31 || (rootWindowInsets = this.view.getRootWindowInsets()) == null) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        DisplayMetrics displayMetrics = this.view.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int[] iArr = new int[2];
        this.view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int width = this.view.getWidth();
        int height = this.view.getHeight();
        int roundedCornerRadius = (i4 == 0 && i5 == 0) ? getRoundedCornerRadius(rootWindowInsets, 0) : 0;
        int roundedCornerRadius2 = (i4 + width < i2 || i5 != 0) ? 0 : getRoundedCornerRadius(rootWindowInsets, 1);
        int roundedCornerRadius3 = (i4 + width < i2 || i5 + height < i3) ? 0 : getRoundedCornerRadius(rootWindowInsets, 2);
        if (i4 == 0) {
            c = 1;
            if (i5 + height >= i3) {
                i = getRoundedCornerRadius(rootWindowInsets, 3);
                float[] fArr = new float[8];
                fArr[0] = roundedCornerRadius;
                fArr[c] = roundedCornerRadius;
                fArr[2] = roundedCornerRadius2;
                fArr[3] = roundedCornerRadius2;
                fArr[4] = roundedCornerRadius3;
                fArr[5] = roundedCornerRadius3;
                fArr[6] = i;
                fArr[7] = i;
                return fArr;
            }
        } else {
            c = 1;
        }
        i = 0;
        float[] fArr2 = new float[8];
        fArr2[0] = roundedCornerRadius;
        fArr2[c] = roundedCornerRadius;
        fArr2[2] = roundedCornerRadius2;
        fArr2[3] = roundedCornerRadius2;
        fArr2[4] = roundedCornerRadius3;
        fArr2[5] = roundedCornerRadius3;
        fArr2[6] = i;
        fArr2[7] = i;
        return fArr2;
    }

    private ValueAnimator createCornerAnimator(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new MaterialMainContainerBackHelper$$ExternalSyntheticLambda0(), clippableRoundedCornerLayout.getCornerRadii(), getExpandedCornerRadii());
        ofObject.addUpdateListener(new MaterialMainContainerBackHelper$$ExternalSyntheticLambda1(clippableRoundedCornerLayout));
        return ofObject;
    }

    private AnimatorSet createResetScaleAndTranslationAnimator(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new AnonymousClass1(view));
        return animatorSet;
    }

    private int getRoundedCornerRadius(WindowInsets windowInsets, int i) {
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(i);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$createCornerAnimator$0(float f, Object obj, Object obj2) {
        return lerpCornerRadii((float[]) obj, (float[]) obj2, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$createCornerAnimator$1(ClippableRoundedCornerLayout clippableRoundedCornerLayout, ValueAnimator valueAnimator) {
        clippableRoundedCornerLayout.updateCornerRadii((float[]) valueAnimator.getAnimatedValue());
    }

    private static float[] lerpCornerRadii(float[] fArr, float f, float f2) {
        return new float[]{AnimationUtils.lerp(fArr[0], f, f2), AnimationUtils.lerp(fArr[1], f, f2), AnimationUtils.lerp(fArr[2], f, f2), AnimationUtils.lerp(fArr[3], f, f2), AnimationUtils.lerp(fArr[4], f, f2), AnimationUtils.lerp(fArr[5], f, f2), AnimationUtils.lerp(fArr[6], f, f2), AnimationUtils.lerp(fArr[7], f, f2)};
    }

    private static float[] lerpCornerRadii(float[] fArr, float[] fArr2, float f) {
        return new float[]{AnimationUtils.lerp(fArr[0], fArr2[0], f), AnimationUtils.lerp(fArr[1], fArr2[1], f), AnimationUtils.lerp(fArr[2], fArr2[2], f), AnimationUtils.lerp(fArr[3], fArr2[3], f), AnimationUtils.lerp(fArr[4], fArr2[4], f), AnimationUtils.lerp(fArr[5], fArr2[5], f), AnimationUtils.lerp(fArr[6], fArr2[6], f), AnimationUtils.lerp(fArr[7], fArr2[7], f)};
    }

    private void resetInitialValues() {
        this.initialTouchY = 0.0f;
        this.initialHideToClipBounds = null;
        this.initialHideFromClipBounds = null;
    }

    public void cancelBackProgress(View view) {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        AnimatorSet createResetScaleAndTranslationAnimator = createResetScaleAndTranslationAnimator(view);
        if (this.view instanceof ClippableRoundedCornerLayout) {
            createResetScaleAndTranslationAnimator.playTogether(createCornerAnimator((ClippableRoundedCornerLayout) this.view));
        }
        createResetScaleAndTranslationAnimator.setDuration(this.cancelDuration);
        createResetScaleAndTranslationAnimator.start();
        resetInitialValues();
    }

    public void clearExpandedCornerRadii() {
        this.expandedCornerRadii = null;
    }

    public void finishBackProgress(long j, View view) {
        AnimatorSet createResetScaleAndTranslationAnimator = createResetScaleAndTranslationAnimator(view);
        createResetScaleAndTranslationAnimator.setDuration(j);
        createResetScaleAndTranslationAnimator.start();
        resetInitialValues();
    }

    public float[] getExpandedCornerRadii() {
        if (this.expandedCornerRadii == null) {
            this.expandedCornerRadii = calculateExpandedCornerRadii();
        }
        return this.expandedCornerRadii;
    }

    public Rect getInitialHideFromClipBounds() {
        return this.initialHideFromClipBounds;
    }

    public Rect getInitialHideToClipBounds() {
        return this.initialHideToClipBounds;
    }

    public void startBackProgress(float f, View view) {
        this.initialHideToClipBounds = ViewUtils.calculateRectFromBounds(this.view);
        if (view != null) {
            this.initialHideFromClipBounds = ViewUtils.calculateOffsetRectFromBounds(this.view, view);
        }
        this.initialTouchY = f;
    }

    public void startBackProgress(BackEventCompat backEventCompat, View view) {
        super.onStartBackProgress(backEventCompat);
        startBackProgress(backEventCompat.getTouchY(), view);
    }

    public void updateBackProgress(float f, boolean z, float f2, float f3) {
        float interpolateProgress = interpolateProgress(f);
        float width = this.view.getWidth();
        float height = this.view.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float lerp = AnimationUtils.lerp(1.0f, MIN_SCALE, interpolateProgress);
            float lerp2 = AnimationUtils.lerp(0.0f, Math.max(0.0f, ((width - (MIN_SCALE * width)) / 2.0f) - this.minEdgeGap), interpolateProgress) * (z ? 1 : -1);
            float min = Math.min(Math.max(0.0f, ((height - (lerp * height)) / 2.0f) - this.minEdgeGap), this.maxTranslationY);
            float f4 = f2 - this.initialTouchY;
            float lerp3 = AnimationUtils.lerp(0.0f, min, Math.abs(f4) / height) * Math.signum(f4);
            if (Float.isNaN(lerp) || Float.isNaN(lerp2)) {
                return;
            }
            if (Float.isNaN(lerp3)) {
                return;
            }
            this.view.setScaleX(lerp);
            this.view.setScaleY(lerp);
            this.view.setTranslationX(lerp2);
            this.view.setTranslationY(lerp3);
            if (this.view instanceof ClippableRoundedCornerLayout) {
                ((ClippableRoundedCornerLayout) this.view).updateCornerRadii(lerpCornerRadii(getExpandedCornerRadii(), f3, interpolateProgress));
            }
        }
    }

    public void updateBackProgress(BackEventCompat backEventCompat, View view, float f) {
        if (super.onUpdateBackProgress(backEventCompat) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        updateBackProgress(backEventCompat.getProgress(), backEventCompat.getSwipeEdge() == 0, backEventCompat.getTouchY(), f);
    }
}
