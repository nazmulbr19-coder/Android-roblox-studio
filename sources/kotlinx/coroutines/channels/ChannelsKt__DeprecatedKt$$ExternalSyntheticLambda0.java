package kotlinx.coroutines.channels;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt;", method = "consumes$lambda$24$ChannelsKt__DeprecatedKt", proto = "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ ReceiveChannel f$0;

    public /* synthetic */ ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda0(ReceiveChannel receiveChannel) {
        this.f$0 = receiveChannel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ChannelsKt__DeprecatedKt.m1978$r8$lambda$TvPjweWNaRxtVDl8gJDJ7l7UZo(this.f$0, (Throwable) obj);
    }
}
