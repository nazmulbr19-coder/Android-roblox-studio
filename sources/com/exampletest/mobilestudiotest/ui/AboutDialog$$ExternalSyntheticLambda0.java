package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AboutDialog;", method = "show$linkButton$lambda$9$lambda$8", proto = "(Landroid/app/Activity;Ljava/lang/String;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AboutDialog$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ AboutDialog$$ExternalSyntheticLambda0(Activity activity, String str) {
        this.f$0 = activity;
        this.f$1 = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AboutDialog.show$linkButton$lambda$9$lambda$8(this.f$0, this.f$1, view);
    }
}
