package kotlinx.coroutines;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt;", method = "newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt", proto = "(ILjava/lang/String;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/lang/Runnable;)Ljava/lang/Thread;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0 implements ThreadFactory {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ AtomicInteger f$2;

    public /* synthetic */ ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0(int i, String str, AtomicInteger atomicInteger) {
        this.f$0 = i;
        this.f$1 = str;
        this.f$2 = atomicInteger;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.$r8$lambda$XFVhsA28fmYUFDEvkT7eVQ1JeFw(this.f$0, this.f$1, this.f$2, runnable);
    }
}
