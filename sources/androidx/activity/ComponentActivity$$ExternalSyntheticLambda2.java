package androidx.activity;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/ComponentActivity;", method = "onBackPressedInput_delegate$lambda$0", proto = "(Landroidx/activity/ComponentActivity;)Landroidx/navigationevent/DirectNavigationEventInput;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda2(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ComponentActivity.onBackPressedInput_delegate$lambda$0(this.f$0);
    }
}
