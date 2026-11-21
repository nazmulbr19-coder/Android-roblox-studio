package com.exampletest.mobilestudiotest.render;

import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/render/MaterialTextures;", method = "get$lambda$8", proto = "(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes8.dex */
public final /* synthetic */ class MaterialTextures$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ MaterialTextures$$ExternalSyntheticLambda0(String str, Context context, String str2, String str3) {
        this.f$0 = str;
        this.f$1 = context;
        this.f$2 = str2;
        this.f$3 = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MaterialTextures.get$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
