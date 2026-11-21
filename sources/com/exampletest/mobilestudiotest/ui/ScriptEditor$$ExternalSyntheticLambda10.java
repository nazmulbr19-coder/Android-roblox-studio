package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.AdapterView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ScriptEditor;", method = "lambda$22$lambda$21", proto = "(Lcom/exampletest/mobilestudiotest/ui/ScriptEditor;Landroid/widget/AdapterView;Landroid/view/View;IJ)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ScriptEditor$$ExternalSyntheticLambda10 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ ScriptEditor f$0;

    public /* synthetic */ ScriptEditor$$ExternalSyntheticLambda10(ScriptEditor scriptEditor) {
        this.f$0 = scriptEditor;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ScriptEditor.lambda$22$lambda$21(this.f$0, adapterView, view, i, j);
    }
}
