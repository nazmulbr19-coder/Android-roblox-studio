package com.exampletest.mobilestudiotest.ui;

import android.widget.ImageView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "loadHeadshot$lambda$13$lambda$12", proto = "(Ljava/lang/String;Landroid/widget/ImageView;JLjava/lang/String;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ ImageView f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda4(String str, ImageView imageView, long j) {
        this.f$0 = str;
        this.f$1 = imageView;
        this.f$2 = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.loadHeadshot$lambda$13$lambda$12(this.f$0, this.f$1, this.f$2, (String) obj);
    }
}
