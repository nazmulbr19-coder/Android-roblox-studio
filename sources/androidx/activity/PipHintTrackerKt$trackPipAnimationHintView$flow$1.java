package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: PipHintTracker.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/graphics/Rect;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<ProducerScope<? super Rect>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> continuation) {
        super(2, continuation);
        this.$view = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void invokeSuspend$lambda$0(ProducerScope producerScope, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i3 == i7 && i2 == i6 && i4 == i8) {
            return;
        }
        Intrinsics.checkNotNull(view);
        producerScope.mo1947trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void invokeSuspend$lambda$1(ProducerScope producerScope, View view) {
        producerScope.mo1947trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeSuspend$lambda$2(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1) {
        view.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        view.removeOnLayoutChangeListener(onLayoutChangeListener);
        view.removeOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, continuation);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Rect> producerScope, Continuation<? super Unit> continuation) {
        return invoke2(producerScope, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super Rect> producerScope, Continuation<? super Unit> continuation) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0 pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0(producerScope);
                PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1(producerScope, this.$view);
                PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(producerScope, this.$view, pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1, pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0);
                if (this.$view.isAttachedToWindow()) {
                    producerScope.mo1947trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
                    this.$view.getViewTreeObserver().addOnScrollChangedListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1);
                    this.$view.addOnLayoutChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0);
                }
                this.$view.addOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda2(this.$view, pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1, pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0, pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
