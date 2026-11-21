package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "installPluginId$lambda$179", proto = "(Landroid/app/Activity;JLcom/exampletest/mobilestudiotest/core/Studio;Ljava/lang/String;)Ljava/io/File;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ Studio f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda0(Activity activity, long j, Studio studio, String str) {
        this.f$0 = activity;
        this.f$1 = j;
        this.f$2 = studio;
        this.f$3 = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.installPluginId$lambda$179(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
