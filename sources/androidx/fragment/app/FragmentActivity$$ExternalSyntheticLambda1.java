package androidx.fragment.app;

import android.content.res.Configuration;
import androidx.core.util.Consumer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/fragment/app/FragmentActivity;", method = "lambda$init$1", proto = "(Landroid/content/res/Configuration;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentActivity$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ FragmentActivity f$0;

    public /* synthetic */ FragmentActivity$$ExternalSyntheticLambda1(FragmentActivity fragmentActivity) {
        this.f$0 = fragmentActivity;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        this.f$0.m132lambda$init$1$androidxfragmentappFragmentActivity((Configuration) obj);
    }
}
