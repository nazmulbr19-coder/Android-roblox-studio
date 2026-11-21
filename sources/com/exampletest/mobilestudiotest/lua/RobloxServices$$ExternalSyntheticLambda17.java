package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", method = "pathObject$lambda$40", proto = "(Lkotlin/jvm/internal/Ref$ObjectRef;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxServices$$ExternalSyntheticLambda17 implements Function1 {
    public final /* synthetic */ Ref.ObjectRef f$0;

    public /* synthetic */ RobloxServices$$ExternalSyntheticLambda17(Ref.ObjectRef objectRef) {
        this.f$0 = objectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return RobloxServices.pathObject$lambda$40(this.f$0, (Varargs) obj);
    }
}
