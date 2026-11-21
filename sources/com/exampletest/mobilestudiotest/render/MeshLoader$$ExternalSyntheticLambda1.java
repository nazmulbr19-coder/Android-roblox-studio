package com.exampletest.mobilestudiotest.render;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/render/MeshLoader;", method = "get$lambda$3", proto = "(J[B)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes8.dex */
public final /* synthetic */ class MeshLoader$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ byte[] f$1;

    public /* synthetic */ MeshLoader$$ExternalSyntheticLambda1(long j, byte[] bArr) {
        this.f$0 = j;
        this.f$1 = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MeshLoader.get$lambda$3(this.f$0, this.f$1);
    }
}
