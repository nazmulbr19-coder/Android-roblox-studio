package com.exampletest.mobilestudiotest.engine;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.engine.CollisionMeshes;
import com.exampletest.mobilestudiotest.model.Vector3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/engine/CollisionMeshes;", method = "ray$lambda$9", proto = "([FLcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;Lkotlin/jvm/internal/Ref$FloatRef;FLkotlin/jvm/internal/Ref$ObjectRef;Lcom/exampletest/mobilestudiotest/engine/CollisionMeshes$Mesh;I)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class CollisionMeshes$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ float[] f$0;
    public final /* synthetic */ Vector3 f$1;
    public final /* synthetic */ Vector3 f$2;
    public final /* synthetic */ Ref.FloatRef f$3;
    public final /* synthetic */ float f$4;
    public final /* synthetic */ Ref.ObjectRef f$5;
    public final /* synthetic */ CollisionMeshes.Mesh f$6;

    public /* synthetic */ CollisionMeshes$$ExternalSyntheticLambda0(float[] fArr, Vector3 vector3, Vector3 vector32, Ref.FloatRef floatRef, float f, Ref.ObjectRef objectRef, CollisionMeshes.Mesh mesh) {
        this.f$0 = fArr;
        this.f$1 = vector3;
        this.f$2 = vector32;
        this.f$3 = floatRef;
        this.f$4 = f;
        this.f$5 = objectRef;
        this.f$6 = mesh;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return CollisionMeshes.ray$lambda$9(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, ((Integer) obj).intValue());
    }
}
