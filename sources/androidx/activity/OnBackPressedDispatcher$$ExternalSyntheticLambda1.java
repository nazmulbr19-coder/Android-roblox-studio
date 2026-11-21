package androidx.activity;

import androidx.lifecycle.Lifecycle;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/OnBackPressedDispatcher;", method = "addCallback$lambda$0", proto = "(Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedDispatcher$addCallback$observer$1;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class OnBackPressedDispatcher$$ExternalSyntheticLambda1 implements AutoCloseable {
    public final /* synthetic */ Lifecycle f$0;
    public final /* synthetic */ OnBackPressedDispatcher$addCallback$observer$1 f$1;

    public /* synthetic */ OnBackPressedDispatcher$$ExternalSyntheticLambda1(Lifecycle lifecycle, OnBackPressedDispatcher$addCallback$observer$1 onBackPressedDispatcher$addCallback$observer$1) {
        this.f$0 = lifecycle;
        this.f$1 = onBackPressedDispatcher$addCallback$observer$1;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        OnBackPressedDispatcher.addCallback$lambda$0(this.f$0, this.f$1);
    }
}
