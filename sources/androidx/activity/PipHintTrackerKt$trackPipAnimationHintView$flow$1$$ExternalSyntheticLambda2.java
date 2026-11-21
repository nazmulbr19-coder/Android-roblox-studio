package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/PipHintTrackerKt$trackPipAnimationHintView$flow$1;", method = "invokeSuspend$lambda$2", proto = "(Landroid/view/View;Landroid/view/ViewTreeObserver$OnScrollChangedListener;Landroid/view/View$OnLayoutChangeListener;Landroidx/activity/PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ ViewTreeObserver.OnScrollChangedListener f$1;
    public final /* synthetic */ View.OnLayoutChangeListener f$2;
    public final /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 f$3;

    public /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda2(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1) {
        this.f$0 = view;
        this.f$1 = onScrollChangedListener;
        this.f$2 = onLayoutChangeListener;
        this.f$3 = pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
