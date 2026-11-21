package androidx.activity;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/EdgeToEdge;", method = "enableEdgeToEdge$lambda$1", proto = "(Landroidx/activity/EdgeToEdgeImpl;Landroidx/activity/SystemBarStyle;Landroidx/activity/SystemBarStyle;Landroidx/activity/ComponentActivity;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class EdgeToEdge$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ EdgeToEdgeImpl f$0;
    public final /* synthetic */ SystemBarStyle f$1;
    public final /* synthetic */ SystemBarStyle f$2;
    public final /* synthetic */ ComponentActivity f$3;
    public final /* synthetic */ View f$4;

    public /* synthetic */ EdgeToEdge$$ExternalSyntheticLambda0(EdgeToEdgeImpl edgeToEdgeImpl, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, ComponentActivity componentActivity, View view) {
        this.f$0 = edgeToEdgeImpl;
        this.f$1 = systemBarStyle;
        this.f$2 = systemBarStyle2;
        this.f$3 = componentActivity;
        this.f$4 = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EdgeToEdge.enableEdgeToEdge$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
