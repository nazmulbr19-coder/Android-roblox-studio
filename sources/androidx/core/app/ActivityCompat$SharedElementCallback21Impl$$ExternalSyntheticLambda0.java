package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.SharedElementCallback;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroid/app/SharedElementCallback$OnSharedElementsReadyListener;", method = "onSharedElementsReady", proto = "()V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0 implements SharedElementCallback.OnSharedElementsReadyListener {
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f$0;

    public /* synthetic */ ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f$0 = onSharedElementsReadyListener;
    }

    @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
    public final void onSharedElementsReady() {
        this.f$0.onSharedElementsReady();
    }
}
