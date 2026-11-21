package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.AdapterView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "listDialog$lambda$84", proto = "(Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/util/List;Landroid/widget/AdapterView;Landroid/view/View;IJ)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda17 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda17(Ref.ObjectRef objectRef, List list) {
        this.f$0 = objectRef;
        this.f$1 = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AccountUi.listDialog$lambda$84(this.f$0, this.f$1, adapterView, view, i, j);
    }
}
