package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.Intent;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/content/ContextKt$receiveBroadcastsAsync$2;", method = "invokeSuspend$lambda$0", proto = "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;Landroid/content/BroadcastReceiver;Landroid/content/Intent;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ContextKt$receiveBroadcastsAsync$2$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ Function3 f$1;

    public /* synthetic */ ContextKt$receiveBroadcastsAsync$2$$ExternalSyntheticLambda0(CoroutineScope coroutineScope, Function3 function3) {
        this.f$0 = coroutineScope;
        this.f$1 = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ContextKt$receiveBroadcastsAsync$2.invokeSuspend$lambda$0(this.f$0, this.f$1, (BroadcastReceiver) obj, (Intent) obj2);
    }
}
