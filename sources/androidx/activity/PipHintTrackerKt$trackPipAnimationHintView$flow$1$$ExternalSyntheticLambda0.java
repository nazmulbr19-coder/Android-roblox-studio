package androidx.activity;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/PipHintTrackerKt$trackPipAnimationHintView$flow$1;", method = "invokeSuspend$lambda$0", proto = "(Lkotlinx/coroutines/channels/ProducerScope;Landroid/view/View;IIIIIIII)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ProducerScope f$0;

    public /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(this.f$0, view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
