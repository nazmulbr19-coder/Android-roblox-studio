package com.exampletest.mobilestudiotest.net;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/net/ImageLoader;", method = "getKey$lambda$6", proto = "(Ljava/lang/String;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes6.dex */
public final /* synthetic */ class ImageLoader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ String f$0;

    public /* synthetic */ ImageLoader$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageLoader.getKey$lambda$6(this.f$0);
    }
}
