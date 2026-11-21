package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegate;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/appcompat/app/AppCompatDelegate$SerialExecutor;", method = "lambda$execute$0", proto = "(Ljava/lang/Runnable;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegate$SerialExecutor$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AppCompatDelegate.SerialExecutor f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ AppCompatDelegate$SerialExecutor$$ExternalSyntheticLambda0(AppCompatDelegate.SerialExecutor serialExecutor, Runnable runnable) {
        this.f$0 = serialExecutor;
        this.f$1 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m1x45c145d(this.f$1);
    }
}
