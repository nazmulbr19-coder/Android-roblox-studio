package com.exampletest.mobilestudiotest.ui;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/OutputPanel;", method = "_init_$lambda$4", proto = "(Landroid/widget/EditText;Lcom/exampletest/mobilestudiotest/ui/OutputPanel;Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class OutputPanel$$ExternalSyntheticLambda3 implements TextView.OnEditorActionListener {
    public final /* synthetic */ EditText f$0;
    public final /* synthetic */ OutputPanel f$1;

    public /* synthetic */ OutputPanel$$ExternalSyntheticLambda3(EditText editText, OutputPanel outputPanel) {
        this.f$0 = editText;
        this.f$1 = outputPanel;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return OutputPanel._init_$lambda$4(this.f$0, this.f$1, textView, i, keyEvent);
    }
}
