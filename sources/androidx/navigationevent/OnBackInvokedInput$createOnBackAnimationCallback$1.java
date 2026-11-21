package androidx.navigationevent;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBackInvokedInput.android.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"androidx/navigationevent/OnBackInvokedInput$createOnBackAnimationCallback$1", "Landroid/window/OnBackAnimationCallback;", "onBackStarted", "", "backEvent", "Landroid/window/BackEvent;", "onBackProgressed", "onBackInvoked", "onBackCancelled", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnBackInvokedInput$createOnBackAnimationCallback$1 implements OnBackAnimationCallback {
    final /* synthetic */ OnBackInvokedInput this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnBackInvokedInput$createOnBackAnimationCallback$1(OnBackInvokedInput onBackInvokedInput) {
        this.this$0 = onBackInvokedInput;
    }

    public void onBackCancelled() {
        this.this$0.dispatchOnBackCancelled();
    }

    public void onBackInvoked() {
        this.this$0.dispatchOnBackCompleted();
    }

    public void onBackProgressed(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        this.this$0.dispatchOnBackProgressed(NavigationEvent_androidKt.NavigationEvent(backEvent));
    }

    public void onBackStarted(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        this.this$0.dispatchOnBackStarted(NavigationEvent_androidKt.NavigationEvent(backEvent));
    }
}
