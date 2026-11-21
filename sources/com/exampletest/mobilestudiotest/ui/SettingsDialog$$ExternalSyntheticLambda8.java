package com.exampletest.mobilestudiotest.ui;

import android.widget.CompoundButton;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "toggle$lambda$55$lambda$54", proto = "(Lkotlin/jvm/functions/Function1;Landroid/widget/CompoundButton;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda8 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda8(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SettingsDialog.toggle$lambda$55$lambda$54(this.f$0, compoundButton, z);
    }
}
