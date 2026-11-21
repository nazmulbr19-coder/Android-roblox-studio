package androidx.emoji2.text;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.ThreadFactory;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/emoji2/text/ConcurrencyHelpers;", method = "lambda$createBackgroundPriorityExecutor$0", proto = "(Ljava/lang/String;Ljava/lang/Runnable;)Ljava/lang/Thread;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ConcurrencyHelpers$$ExternalSyntheticLambda1 implements ThreadFactory {
    public final /* synthetic */ String f$0;

    public /* synthetic */ ConcurrencyHelpers$$ExternalSyntheticLambda1(String str) {
        this.f$0 = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.lambda$createBackgroundPriorityExecutor$0(this.f$0, runnable);
    }
}
