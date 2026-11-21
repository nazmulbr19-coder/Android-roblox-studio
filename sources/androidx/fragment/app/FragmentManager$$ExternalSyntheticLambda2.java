package androidx.fragment.app;

import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.util.Consumer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/fragment/app/FragmentManager;", method = "lambda$new$2", proto = "(Landroidx/core/app/MultiWindowModeChangedInfo;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentManager$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ FragmentManager f$0;

    public /* synthetic */ FragmentManager$$ExternalSyntheticLambda2(FragmentManager fragmentManager) {
        this.f$0 = fragmentManager;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        this.f$0.m138lambda$new$2$androidxfragmentappFragmentManager((MultiWindowModeChangedInfo) obj);
    }
}
