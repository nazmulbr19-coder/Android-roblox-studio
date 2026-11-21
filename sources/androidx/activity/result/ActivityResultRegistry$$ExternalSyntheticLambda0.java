package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/result/ActivityResultRegistry;", method = "register$lambda$1", proto = "(Landroidx/activity/result/ActivityResultRegistry;Ljava/lang/String;Landroidx/activity/result/ActivityResultCallback;Landroidx/activity/result/contract/ActivityResultContract;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ActivityResultRegistry$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ ActivityResultRegistry f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ ActivityResultCallback f$2;
    public final /* synthetic */ ActivityResultContract f$3;

    public /* synthetic */ ActivityResultRegistry$$ExternalSyntheticLambda0(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.f$0 = activityResultRegistry;
        this.f$1 = str;
        this.f$2 = activityResultCallback;
        this.f$3 = activityResultContract;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ActivityResultRegistry.register$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, lifecycleOwner, event);
    }
}
