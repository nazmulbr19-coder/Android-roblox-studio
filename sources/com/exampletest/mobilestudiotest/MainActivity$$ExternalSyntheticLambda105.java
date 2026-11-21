package com.exampletest.mobilestudiotest;

import android.net.Uri;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "writeTo$lambda$333", proto = "(Lkotlin/jvm/functions/Function0;Lcom/exampletest/mobilestudiotest/MainActivity;Landroid/net/Uri;ZLjava/lang/String;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda105 implements Runnable {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ MainActivity f$1;
    public final /* synthetic */ Uri f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda105(Function0 function0, MainActivity mainActivity, Uri uri, boolean z, String str) {
        this.f$0 = function0;
        this.f$1 = mainActivity;
        this.f$2 = uri;
        this.f$3 = z;
        this.f$4 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.writeTo$lambda$333(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
