package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import java.io.File;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "installPluginId$lambda$180", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/ui/MainActions;Landroid/app/Activity;Ljava/io/File;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ MainActions f$1;
    public final /* synthetic */ Activity f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda1(Studio studio, MainActions mainActions, Activity activity) {
        this.f$0 = studio;
        this.f$1 = mainActions;
        this.f$2 = activity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.installPluginId$lambda$180(this.f$0, this.f$1, this.f$2, (File) obj);
    }
}
