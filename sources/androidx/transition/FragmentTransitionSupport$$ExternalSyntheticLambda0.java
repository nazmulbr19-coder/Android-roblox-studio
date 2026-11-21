package androidx.transition;

import androidx.core.os.CancellationSignal;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/transition/FragmentTransitionSupport;", method = "lambda$setListenerForTransitionEnd$0", proto = "(Ljava/lang/Runnable;Landroidx/transition/Transition;Ljava/lang/Runnable;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentTransitionSupport$$ExternalSyntheticLambda0 implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ Runnable f$0;
    public final /* synthetic */ Transition f$1;
    public final /* synthetic */ Runnable f$2;

    public /* synthetic */ FragmentTransitionSupport$$ExternalSyntheticLambda0(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f$0 = runnable;
        this.f$1 = transition;
        this.f$2 = runnable2;
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0(this.f$0, this.f$1, this.f$2);
    }
}
