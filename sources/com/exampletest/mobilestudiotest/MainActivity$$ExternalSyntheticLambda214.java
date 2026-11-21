package com.exampletest.mobilestudiotest;

import android.widget.CompoundButton;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "managePlugins$lambda$340$lambda$339", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/io/File;Landroid/widget/CompoundButton;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda214 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ File f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda214(MainActivity mainActivity, File file) {
        this.f$0 = mainActivity;
        this.f$1 = file;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MainActivity.managePlugins$lambda$340$lambda$339(this.f$0, this.f$1, compoundButton, z);
    }
}
