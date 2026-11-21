package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/PipHintTrackerKt$trackPipAnimationHintView$flow$1;", method = "invokeSuspend$lambda$1", proto = "(Lkotlinx/coroutines/channels/ProducerScope;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ ProducerScope f$0;
    public final /* synthetic */ View f$1;

    public /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1(ProducerScope producerScope, View view) {
        this.f$0 = producerScope;
        this.f$1 = view;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(this.f$0, this.f$1);
    }
}
