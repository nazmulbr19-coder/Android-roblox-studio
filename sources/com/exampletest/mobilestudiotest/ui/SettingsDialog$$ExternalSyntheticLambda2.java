package com.exampletest.mobilestudiotest.ui;

import android.widget.CompoundButton;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "editTheme$lambda$63$lambda$62", proto = "(Lkotlin/jvm/internal/Ref$ObjectRef;Landroid/widget/CompoundButton;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda2 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Ref.ObjectRef f$0;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda2(Ref.ObjectRef objectRef) {
        this.f$0 = objectRef;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SettingsDialog.editTheme$lambda$63$lambda$62(this.f$0, compoundButton, z);
    }
}
