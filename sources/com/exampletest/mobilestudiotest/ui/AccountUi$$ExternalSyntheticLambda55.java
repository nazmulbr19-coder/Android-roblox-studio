package com.exampletest.mobilestudiotest.ui;

import android.widget.ImageView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "loadHeadshot$lambda$13", proto = "(JLandroid/widget/ImageView;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda55 implements Runnable {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ ImageView f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda55(long j, ImageView imageView) {
        this.f$0 = j;
        this.f$1 = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AccountUi.loadHeadshot$lambda$13(this.f$0, this.f$1);
    }
}
