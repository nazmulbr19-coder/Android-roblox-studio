package androidx.fragment.app;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/fragment/app/FragmentActivity;", method = "lambda$init$3", proto = "(Landroid/content/Context;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentActivity$$ExternalSyntheticLambda3 implements OnContextAvailableListener {
    public final /* synthetic */ FragmentActivity f$0;

    public /* synthetic */ FragmentActivity$$ExternalSyntheticLambda3(FragmentActivity fragmentActivity) {
        this.f$0 = fragmentActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context context) {
        this.f$0.m134lambda$init$3$androidxfragmentappFragmentActivity(context);
    }
}
