package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.CheckBox;
import android.widget.Switch;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", method = "gameSettings$lambda$77", proto = "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/util/HashMap;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/net/CloudPlace;Landroid/widget/CheckBox;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/model/Instance;Landroid/widget/Switch;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AvatarUi$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ HashMap f$2;
    public final /* synthetic */ Studio f$3;
    public final /* synthetic */ CloudPlace f$4;
    public final /* synthetic */ CheckBox f$5;
    public final /* synthetic */ Activity f$6;
    public final /* synthetic */ Instance f$7;
    public final /* synthetic */ Switch f$8;

    public /* synthetic */ AvatarUi$$ExternalSyntheticLambda3(Function0 function0, Function0 function02, HashMap hashMap, Studio studio, CloudPlace cloudPlace, CheckBox checkBox, Activity activity, Instance instance, Switch r9) {
        this.f$0 = function0;
        this.f$1 = function02;
        this.f$2 = hashMap;
        this.f$3 = studio;
        this.f$4 = cloudPlace;
        this.f$5 = checkBox;
        this.f$6 = activity;
        this.f$7 = instance;
        this.f$8 = r9;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AvatarUi.gameSettings$lambda$77(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, dialogInterface, i);
    }
}
