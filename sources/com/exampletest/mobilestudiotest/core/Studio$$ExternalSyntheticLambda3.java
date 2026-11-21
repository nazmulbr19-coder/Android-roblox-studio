package com.exampletest.mobilestudiotest.core;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/core/Studio;", method = "pruneSelection$lambda$61$lambda$60", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/model/Instance;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class Studio$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ Studio f$0;

    public /* synthetic */ Studio$$ExternalSyntheticLambda3(Studio studio) {
        this.f$0 = studio;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(Studio.pruneSelection$lambda$61$lambda$60(this.f$0, (Instance) obj));
    }
}
