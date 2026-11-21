package androidx.core.app;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/app/ActivityCompat;", method = "lambda$recreate$0", proto = "(Landroid/app/Activity;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ActivityCompat$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Activity f$0;

    public /* synthetic */ ActivityCompat$$ExternalSyntheticLambda0(Activity activity) {
        this.f$0 = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityCompat.lambda$recreate$0(this.f$0);
    }
}
