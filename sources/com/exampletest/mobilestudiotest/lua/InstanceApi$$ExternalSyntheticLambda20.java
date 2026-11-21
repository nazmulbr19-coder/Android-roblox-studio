package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", method = "index$lambda$12$lambda$11", proto = "(Lcom/exampletest/mobilestudiotest/lua/InstanceApi;Ljava/lang/String;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class InstanceApi$$ExternalSyntheticLambda20 implements Function1 {
    public final /* synthetic */ InstanceApi f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ InstanceApi$$ExternalSyntheticLambda20(InstanceApi instanceApi, String str) {
        this.f$0 = instanceApi;
        this.f$1 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return InstanceApi.index$lambda$12$lambda$11(this.f$0, this.f$1, (Varargs) obj);
    }
}
