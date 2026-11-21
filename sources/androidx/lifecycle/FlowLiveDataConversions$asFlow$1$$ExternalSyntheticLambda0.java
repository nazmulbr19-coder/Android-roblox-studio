package androidx.lifecycle;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/FlowLiveDataConversions$asFlow$1;", method = "invokeSuspend$lambda$0", proto = "(Lkotlinx/coroutines/channels/ProducerScope;Ljava/lang/Object;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ ProducerScope f$0;

    public /* synthetic */ FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        FlowLiveDataConversions$asFlow$1.invokeSuspend$lambda$0(this.f$0, obj);
    }
}
