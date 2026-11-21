package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", method = "workspaceCall$lambda$52", proto = "(Ljava/util/List;ZLcom/exampletest/mobilestudiotest/model/Instance;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class InstanceApi$$ExternalSyntheticLambda14 implements Function1 {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ InstanceApi$$ExternalSyntheticLambda14(List list, boolean z) {
        this.f$0 = list;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(InstanceApi.workspaceCall$lambda$52(this.f$0, this.f$1, (Instance) obj));
    }
}
