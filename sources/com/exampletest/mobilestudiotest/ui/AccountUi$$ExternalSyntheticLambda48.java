package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import android.webkit.WebView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "signIn$lambda$61", proto = "(Lkotlin/jvm/internal/Ref$BooleanRef;Landroid/webkit/WebView;Landroid/content/DialogInterface;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda48 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ WebView f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda48(Ref.BooleanRef booleanRef, WebView webView) {
        this.f$0 = booleanRef;
        this.f$1 = webView;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        AccountUi.signIn$lambda$61(this.f$0, this.f$1, dialogInterface);
    }
}
