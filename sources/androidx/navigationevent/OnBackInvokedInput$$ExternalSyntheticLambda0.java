package androidx.navigationevent;

import android.window.OnBackInvokedCallback;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/navigationevent/OnBackInvokedInput;", method = "onBackInvokedCallback$lambda$0", proto = "(Landroidx/navigationevent/OnBackInvokedInput;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class OnBackInvokedInput$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ OnBackInvokedInput f$0;

    public /* synthetic */ OnBackInvokedInput$$ExternalSyntheticLambda0(OnBackInvokedInput onBackInvokedInput) {
        this.f$0 = onBackInvokedInput;
    }

    public final void onBackInvoked() {
        OnBackInvokedInput.onBackInvokedCallback$lambda$0(this.f$0);
    }
}
