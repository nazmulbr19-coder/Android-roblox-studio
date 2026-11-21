package androidx.core.view;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/ViewKt;", method = "postOnAnimationDelayed$lambda$0", proto = "(Lkotlin/jvm/functions/Function0;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ViewKt$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ ViewKt$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewKt.postOnAnimationDelayed$lambda$0(this.f$0);
    }
}
