package com.exampletest.mobilestudiotest.ui;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/Dialogs;", method = "pickClass$lambda$1", proto = "(Lkotlin/jvm/functions/Function1;Ljava/util/ArrayList;Landroid/app/AlertDialog;Landroid/widget/AdapterView;Landroid/view/View;IJ)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda1 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ ArrayList f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda1(Function1 function1, ArrayList arrayList, AlertDialog alertDialog) {
        this.f$0 = function1;
        this.f$1 = arrayList;
        this.f$2 = alertDialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Dialogs.pickClass$lambda$1(this.f$0, this.f$1, this.f$2, adapterView, view, i, j);
    }
}
