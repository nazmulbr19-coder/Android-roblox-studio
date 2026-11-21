package com.exampletest.mobilestudiotest;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "openLauncher$lambda$5", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Landroid/net/Uri;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda151 implements ActivityResultCallback {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda151(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        MainActivity.openLauncher$lambda$5(this.f$0, (Uri) obj);
    }
}
