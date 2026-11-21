package androidx.activity;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/ComponentActivity;", method = "_init_$lambda$4", proto = "(Landroidx/activity/ComponentActivity;Landroid/content/Context;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda6 implements OnContextAvailableListener {
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda6(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context context) {
        ComponentActivity._init_$lambda$4(this.f$0, context);
    }
}
