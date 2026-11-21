package com.exampletest.mobilestudiotest.render;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/render/UnionMeshes;", method = "get$lambda$12", proto = "(Ljava/lang/String;Lcom/exampletest/mobilestudiotest/model/Instance;[B)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes8.dex */
public final /* synthetic */ class UnionMeshes$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Instance f$1;
    public final /* synthetic */ byte[] f$2;

    public /* synthetic */ UnionMeshes$$ExternalSyntheticLambda4(String str, Instance instance, byte[] bArr) {
        this.f$0 = str;
        this.f$1 = instance;
        this.f$2 = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnionMeshes.get$lambda$12(this.f$0, this.f$1, this.f$2);
    }
}
