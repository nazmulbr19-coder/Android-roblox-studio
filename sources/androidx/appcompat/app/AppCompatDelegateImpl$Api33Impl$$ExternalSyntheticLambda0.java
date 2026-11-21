package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/appcompat/app/AppCompatDelegateImpl;", method = "onBackPressed", proto = "()Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ AppCompatDelegateImpl f$0;

    public /* synthetic */ AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f$0 = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f$0.onBackPressed();
    }
}
