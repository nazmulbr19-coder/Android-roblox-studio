package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.model.Instance;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay;", method = "editTextBox$lambda$107", proto = "(Lcom/exampletest/mobilestudiotest/ui/GuiOverlay;Lcom/exampletest/mobilestudiotest/model/Instance;Landroid/widget/EditText;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class GuiOverlay$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ GuiOverlay f$0;
    public final /* synthetic */ Instance f$1;
    public final /* synthetic */ EditText f$2;
    public final /* synthetic */ LuaRuntime f$3;

    public /* synthetic */ GuiOverlay$$ExternalSyntheticLambda0(GuiOverlay guiOverlay, Instance instance, EditText editText, LuaRuntime luaRuntime) {
        this.f$0 = guiOverlay;
        this.f$1 = instance;
        this.f$2 = editText;
        this.f$3 = luaRuntime;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        GuiOverlay.editTextBox$lambda$107(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface, i);
    }
}
