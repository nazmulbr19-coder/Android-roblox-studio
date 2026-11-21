package androidx.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigationevent.NavigationEventDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBackPressedDispatcher.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/activity/OnBackPressedDispatcher$addCallback$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "activity"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher$addCallback$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ OnBackPressedCallback.OnBackPressedEventHandler $eventHandler;
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ OnBackPressedDispatcher this$0;

    /* compiled from: OnBackPressedDispatcher.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnBackPressedDispatcher$addCallback$observer$1(OnBackPressedCallback.OnBackPressedEventHandler onBackPressedEventHandler, OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle) {
        this.$eventHandler = onBackPressedEventHandler;
        this.this$0 = onBackPressedDispatcher;
        this.$lifecycle = lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
                if (ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
                    this.$eventHandler.setLifecycleActive(true);
                    return;
                } else {
                    NavigationEventDispatcher.addHandler$default(this.this$0.getEventDispatcher$activity(), this.$eventHandler, 0, 2, null);
                    return;
                }
            case 2:
                if (ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
                    this.$eventHandler.setLifecycleActive(false);
                    return;
                } else {
                    this.$eventHandler.remove();
                    return;
                }
            case 3:
                this.$eventHandler.remove();
                this.$lifecycle.removeObserver(this);
                return;
            default:
                return;
        }
    }
}
