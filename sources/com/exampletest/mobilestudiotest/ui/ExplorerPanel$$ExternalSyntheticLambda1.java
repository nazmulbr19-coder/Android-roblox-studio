package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;", method = "rename$lambda$52", proto = "(Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;Lcom/exampletest/mobilestudiotest/model/Instance;Landroid/widget/EditText;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ExplorerPanel$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ExplorerPanel f$0;
    public final /* synthetic */ Instance f$1;
    public final /* synthetic */ EditText f$2;

    public /* synthetic */ ExplorerPanel$$ExternalSyntheticLambda1(ExplorerPanel explorerPanel, Instance instance, EditText editText) {
        this.f$0 = explorerPanel;
        this.f$1 = instance;
        this.f$2 = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ExplorerPanel.rename$lambda$52(this.f$0, this.f$1, this.f$2, dialogInterface, i);
    }
}
