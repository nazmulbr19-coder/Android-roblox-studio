package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: PipHintTracker.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
final class PipHintTrackerKt$trackPipAnimationHintView$2<T> implements FlowCollector {
    final /* synthetic */ Activity $this_trackPipAnimationHintView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PipHintTrackerKt$trackPipAnimationHintView$2(Activity activity) {
        this.$this_trackPipAnimationHintView = activity;
    }

    public final Object emit(Rect rect, Continuation<? super Unit> continuation) {
        Api26Impl.INSTANCE.setPipParamsSourceRectHint(this.$this_trackPipAnimationHintView, rect);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Rect) obj, (Continuation<? super Unit>) continuation);
    }
}
