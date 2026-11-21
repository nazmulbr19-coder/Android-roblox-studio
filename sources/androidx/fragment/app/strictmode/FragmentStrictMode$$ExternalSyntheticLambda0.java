package androidx.fragment.app.strictmode;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/fragment/app/strictmode/FragmentStrictMode;", method = "handlePolicyViolation$lambda-0", proto = "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;Landroidx/fragment/app/strictmode/Violation;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentStrictMode$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ FragmentStrictMode.Policy f$0;
    public final /* synthetic */ Violation f$1;

    public /* synthetic */ FragmentStrictMode$$ExternalSyntheticLambda0(FragmentStrictMode.Policy policy, Violation violation) {
        this.f$0 = policy;
        this.f$1 = violation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FragmentStrictMode.$r8$lambda$E62gJnU4P90oRCiSrlB5WGv5ZAk(this.f$0, this.f$1);
    }
}
