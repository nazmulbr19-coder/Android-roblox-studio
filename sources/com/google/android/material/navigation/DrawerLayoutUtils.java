package com.google.android.material.navigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;

/* loaded from: classes.dex */
public class DrawerLayoutUtils {
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DEFAULT_SCRIM_ALPHA = Color.alpha(DEFAULT_SCRIM_COLOR);

    /* renamed from: com.google.android.material.navigation.DrawerLayoutUtils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ DrawerLayout val$drawerLayout;
        final /* synthetic */ View val$drawerView;

        AnonymousClass1(DrawerLayout drawerLayout, View view) {
            this.val$drawerLayout = drawerLayout;
            this.val$drawerView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$drawerLayout.closeDrawer(this.val$drawerView, false);
            this.val$drawerLayout.setScrimColor(DrawerLayoutUtils.DEFAULT_SCRIM_COLOR);
        }
    }

    private DrawerLayoutUtils() {
    }

    public static Animator.AnimatorListener getScrimCloseAnimatorListener(DrawerLayout drawerLayout, View view) {
        return new AnonymousClass1(drawerLayout, view);
    }

    public static ValueAnimator.AnimatorUpdateListener getScrimCloseAnimatorUpdateListener(DrawerLayout drawerLayout) {
        return new DrawerLayoutUtils$$ExternalSyntheticLambda0(drawerLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getScrimCloseAnimatorUpdateListener$0(DrawerLayout drawerLayout, ValueAnimator valueAnimator) {
        drawerLayout.setScrimColor(ColorUtils.setAlphaComponent(DEFAULT_SCRIM_COLOR, AnimationUtils.lerp(DEFAULT_SCRIM_ALPHA, 0, valueAnimator.getAnimatedFraction())));
    }
}
