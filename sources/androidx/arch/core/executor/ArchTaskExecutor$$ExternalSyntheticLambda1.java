package androidx.arch.core.executor;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.Executor;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/arch/core/executor/ArchTaskExecutor;", method = "lambda$static$1", proto = "(Ljava/lang/Runnable;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ArchTaskExecutor$$ExternalSyntheticLambda1 implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ArchTaskExecutor.lambda$static$1(runnable);
    }
}
