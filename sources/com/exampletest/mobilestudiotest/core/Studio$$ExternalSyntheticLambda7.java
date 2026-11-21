package com.exampletest.mobilestudiotest.core;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/core/Studio;", method = "prefs_delegate$lambda$110", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;)Landroid/content/SharedPreferences;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class Studio$$ExternalSyntheticLambda7 implements Function0 {
    public final /* synthetic */ Studio f$0;

    public /* synthetic */ Studio$$ExternalSyntheticLambda7(Studio studio) {
        this.f$0 = studio;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Studio.prefs_delegate$lambda$110(this.f$0);
    }
}
