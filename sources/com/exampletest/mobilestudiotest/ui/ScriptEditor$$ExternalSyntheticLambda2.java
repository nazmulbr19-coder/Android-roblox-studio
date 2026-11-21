package com.exampletest.mobilestudiotest.ui;

import android.widget.PopupWindow;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ScriptEditor;", method = "showPopup$lambda$29$lambda$28", proto = "(Lcom/exampletest/mobilestudiotest/ui/ScriptEditor;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ScriptEditor$$ExternalSyntheticLambda2 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ ScriptEditor f$0;

    public /* synthetic */ ScriptEditor$$ExternalSyntheticLambda2(ScriptEditor scriptEditor) {
        this.f$0 = scriptEditor;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ScriptEditor.showPopup$lambda$29$lambda$28(this.f$0);
    }
}
