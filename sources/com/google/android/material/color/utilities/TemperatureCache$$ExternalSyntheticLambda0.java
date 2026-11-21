package com.google.android.material.color.utilities;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/color/utilities/TemperatureCache;", method = "lambda$getHctsByTemp$0", proto = "(Lcom/google/android/material/color/utilities/Hct;)Ljava/lang/Double;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class TemperatureCache$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ TemperatureCache f$0;

    public /* synthetic */ TemperatureCache$$ExternalSyntheticLambda0(TemperatureCache temperatureCache) {
        this.f$0 = temperatureCache;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f$0.m379xb7a75f35((Hct) obj);
    }
}
