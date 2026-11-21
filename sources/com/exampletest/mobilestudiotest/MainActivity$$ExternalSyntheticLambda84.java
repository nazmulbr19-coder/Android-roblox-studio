package com.exampletest.mobilestudiotest;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "buildTabs$lambda$63$lambda$62", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/lang/String;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda84 implements View.OnClickListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda84(MainActivity mainActivity, String str) {
        this.f$0 = mainActivity;
        this.f$1 = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MainActivity.buildTabs$lambda$63$lambda$62(this.f$0, this.f$1, view);
    }
}
