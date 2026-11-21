package androidx.constraintlayout.motion.widget;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/constraintlayout/motion/widget/ViewTransition;", method = "lambda$applyTransition$0", proto = "([Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ViewTransition$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ViewTransition f$0;
    public final /* synthetic */ View[] f$1;

    public /* synthetic */ ViewTransition$$ExternalSyntheticLambda0(ViewTransition viewTransition, View[] viewArr) {
        this.f$0 = viewTransition;
        this.f$1 = viewArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m40x14d7500(this.f$1);
    }
}
