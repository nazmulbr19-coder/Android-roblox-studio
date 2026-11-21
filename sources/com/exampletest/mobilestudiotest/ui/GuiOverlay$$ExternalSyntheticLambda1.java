package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.model.Instance;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay;", method = "editTextBox$lambda$109", proto = "(Lcom/exampletest/mobilestudiotest/ui/GuiOverlay;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lcom/exampletest/mobilestudiotest/model/Instance;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class GuiOverlay$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ GuiOverlay f$0;
    public final /* synthetic */ LuaRuntime f$1;
    public final /* synthetic */ Instance f$2;

    public /* synthetic */ GuiOverlay$$ExternalSyntheticLambda1(GuiOverlay guiOverlay, LuaRuntime luaRuntime, Instance instance) {
        this.f$0 = guiOverlay;
        this.f$1 = luaRuntime;
        this.f$2 = instance;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        GuiOverlay.editTextBox$lambda$109(this.f$0, this.f$1, this.f$2, dialogInterface, i);
    }
}
