package com.exampletest.mobilestudiotest.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "loadHeadshot$lambda$13$apply$lambda$11$lambda$10", proto = "(Landroid/widget/ImageView;JLandroid/graphics/Bitmap;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda33 implements Runnable {
    public final /* synthetic */ ImageView f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ Bitmap f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda33(ImageView imageView, long j, Bitmap bitmap) {
        this.f$0 = imageView;
        this.f$1 = j;
        this.f$2 = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AccountUi.loadHeadshot$lambda$13$apply$lambda$11$lambda$10(this.f$0, this.f$1, this.f$2);
    }
}
