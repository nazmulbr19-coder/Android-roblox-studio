package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.PluginButton;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "buildRibbon$lambda$225$lambda$224", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Lcom/exampletest/mobilestudiotest/core/PluginButton;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ PluginButton f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda0(MainActivity mainActivity, PluginButton pluginButton) {
        this.f$0 = mainActivity;
        this.f$1 = pluginButton;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return MainActivity.buildRibbon$lambda$225$lambda$224(this.f$0, this.f$1);
    }
}
