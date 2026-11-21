package com.exampletest.mobilestudiotest.ui;

import android.graphics.Bitmap;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.jvm.functions.Function4;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", method = "_init_$lambda$2", proto = "(Lcom/exampletest/mobilestudiotest/ui/ViewportView;Lcom/exampletest/mobilestudiotest/model/Instance;FFLandroid/graphics/Bitmap;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ViewportView$$ExternalSyntheticLambda1 implements Function4 {
    public final /* synthetic */ ViewportView f$0;

    public /* synthetic */ ViewportView$$ExternalSyntheticLambda1(ViewportView viewportView) {
        this.f$0 = viewportView;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return ViewportView._init_$lambda$2(this.f$0, (Instance) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue(), (Bitmap) obj4);
    }
}
