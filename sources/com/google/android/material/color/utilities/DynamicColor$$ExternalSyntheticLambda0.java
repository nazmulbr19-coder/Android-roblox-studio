package com.google.android.material.color.utilities;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/color/utilities/DynamicColor;", method = "lambda$fromArgb$0", proto = "(Lcom/google/android/material/color/utilities/TonalPalette;Lcom/google/android/material/color/utilities/DynamicScheme;)Lcom/google/android/material/color/utilities/TonalPalette;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DynamicColor$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ TonalPalette f$0;

    public /* synthetic */ DynamicColor$$ExternalSyntheticLambda0(TonalPalette tonalPalette) {
        this.f$0 = tonalPalette;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return DynamicColor.lambda$fromArgb$0(this.f$0, (DynamicScheme) obj);
    }
}
