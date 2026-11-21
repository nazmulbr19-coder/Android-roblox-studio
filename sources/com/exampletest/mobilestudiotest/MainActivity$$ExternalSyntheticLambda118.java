package com.exampletest.mobilestudiotest;

import android.net.Uri;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "writeTo$lambda$333$lambda$331", proto = "(ZLcom/exampletest/mobilestudiotest/MainActivity;Landroid/net/Uri;Ljava/lang/String;[B)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda118 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MainActivity f$1;
    public final /* synthetic */ Uri f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ byte[] f$4;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda118(boolean z, MainActivity mainActivity, Uri uri, String str, byte[] bArr) {
        this.f$0 = z;
        this.f$1 = mainActivity;
        this.f$2 = uri;
        this.f$3 = str;
        this.f$4 = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.writeTo$lambda$333$lambda$331(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
