package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Color3;
import java.util.ArrayList;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/Dialogs;", method = "colorPicker$lambda$41$lambda$40", proto = "(Lkotlin/jvm/internal/Ref$IntRef;Lcom/exampletest/mobilestudiotest/model/Color3;Lkotlin/jvm/internal/Ref$IntRef;Lkotlin/jvm/internal/Ref$IntRef;Ljava/util/ArrayList;Landroid/view/View;Landroid/widget/EditText;Landroid/content/Context;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ Color3 f$1;
    public final /* synthetic */ Ref.IntRef f$2;
    public final /* synthetic */ Ref.IntRef f$3;
    public final /* synthetic */ ArrayList f$4;
    public final /* synthetic */ View f$5;
    public final /* synthetic */ EditText f$6;
    public final /* synthetic */ Context f$7;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda2(Ref.IntRef intRef, Color3 color3, Ref.IntRef intRef2, Ref.IntRef intRef3, ArrayList arrayList, View view, EditText editText, Context context) {
        this.f$0 = intRef;
        this.f$1 = color3;
        this.f$2 = intRef2;
        this.f$3 = intRef3;
        this.f$4 = arrayList;
        this.f$5 = view;
        this.f$6 = editText;
        this.f$7 = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialogs.colorPicker$lambda$41$lambda$40(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, view);
    }
}
