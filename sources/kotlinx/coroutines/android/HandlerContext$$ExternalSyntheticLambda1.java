package kotlinx.coroutines.android;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/android/HandlerContext;", method = "scheduleResumeAfterDelay$lambda$2", proto = "(Lkotlinx/coroutines/android/HandlerContext;Ljava/lang/Runnable;Ljava/lang/Throwable;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class HandlerContext$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ HandlerContext f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ HandlerContext$$ExternalSyntheticLambda1(HandlerContext handlerContext, Runnable runnable) {
        this.f$0 = handlerContext;
        this.f$1 = runnable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return HandlerContext.scheduleResumeAfterDelay$lambda$2(this.f$0, this.f$1, (Throwable) obj);
    }
}
