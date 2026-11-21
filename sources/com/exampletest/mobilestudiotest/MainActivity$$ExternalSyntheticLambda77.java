package com.exampletest.mobilestudiotest;

import android.net.Uri;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.MainActivity;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "onFilePicked$lambda$313", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Landroid/net/Uri;Lcom/exampletest/mobilestudiotest/MainActivity$OpenMode;Ljava/lang/String;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda77 implements Runnable {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ Uri f$1;
    public final /* synthetic */ MainActivity.OpenMode f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda77(MainActivity mainActivity, Uri uri, MainActivity.OpenMode openMode, String str) {
        this.f$0 = mainActivity;
        this.f$1 = uri;
        this.f$2 = openMode;
        this.f$3 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.onFilePicked$lambda$313(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
