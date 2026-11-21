package androidx.activity;

import androidx.activity.OnBackPressedDispatcher;
import androidx.navigationevent.OnBackCompletedFallback;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/OnBackPressedDispatcher$OnBackPressedEventInput;", method = "dispatcher$lambda$0", proto = "(Landroidx/activity/OnBackPressedDispatcher;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 implements OnBackCompletedFallback {
    public final /* synthetic */ OnBackPressedDispatcher f$0;

    public /* synthetic */ OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f$0 = onBackPressedDispatcher;
    }

    @Override // androidx.navigationevent.OnBackCompletedFallback
    public final void onBackCompletedFallback() {
        OnBackPressedDispatcher.OnBackPressedEventInput.dispatcher$lambda$0(this.f$0);
    }
}
