package kotlinx.coroutines.channels;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt;", method = "consumesAll$lambda$2$ChannelsKt__DeprecatedKt", proto = "([Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ ReceiveChannel[] f$0;

    public /* synthetic */ ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda1(ReceiveChannel[] receiveChannelArr) {
        this.f$0 = receiveChannelArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ChannelsKt__DeprecatedKt.m1977$r8$lambda$Pnlf7xJwYiqoh8L1HZzjr5nMtM(this.f$0, (Throwable) obj);
    }
}
