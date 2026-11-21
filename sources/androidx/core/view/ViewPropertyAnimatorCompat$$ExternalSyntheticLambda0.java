package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/ViewPropertyAnimatorCompat;", method = "lambda$setUpdateListener$0", proto = "(Landroidx/core/view/ViewPropertyAnimatorUpdateListener;Landroid/view/View;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f$0;
    public final /* synthetic */ View f$1;

    public /* synthetic */ ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f$0 = viewPropertyAnimatorUpdateListener;
        this.f$1 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewPropertyAnimatorCompat.lambda$setUpdateListener$0(this.f$0, this.f$1, valueAnimator);
    }
}
