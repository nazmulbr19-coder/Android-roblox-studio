package com.exampletest.mobilestudiotest.engine;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/engine/Avatar;", method = "composeClothing$lambda$51", proto = "(Ljava/util/Map;I)Landroid/graphics/Bitmap;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class Avatar$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ Avatar$$ExternalSyntheticLambda0(Map map) {
        this.f$0 = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Avatar.composeClothing$lambda$51(this.f$0, ((Integer) obj).intValue());
    }
}
