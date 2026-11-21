package com.exampletest.mobilestudiotest.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/PlayHud;", method = "lambda$10$lambda$8", proto = "(Lcom/exampletest/mobilestudiotest/ui/PlayHud;Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class PlayHud$$ExternalSyntheticLambda7 implements TextView.OnEditorActionListener {
    public final /* synthetic */ PlayHud f$0;

    public /* synthetic */ PlayHud$$ExternalSyntheticLambda7(PlayHud playHud) {
        this.f$0 = playHud;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return PlayHud.lambda$10$lambda$8(this.f$0, textView, i, keyEvent);
    }
}
