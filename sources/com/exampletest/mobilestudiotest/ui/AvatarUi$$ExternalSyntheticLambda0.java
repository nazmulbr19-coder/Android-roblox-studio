package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", method = "segmented$lambda$45$lambda$43$lambda$42", proto = "(Lkotlin/jvm/internal/Ref$IntRef;ILkotlin/jvm/functions/Function1;Ljava/util/ArrayList;Landroid/app/Activity;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AvatarUi$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Function1 f$2;
    public final /* synthetic */ ArrayList f$3;
    public final /* synthetic */ Activity f$4;

    public /* synthetic */ AvatarUi$$ExternalSyntheticLambda0(Ref.IntRef intRef, int i, Function1 function1, ArrayList arrayList, Activity activity) {
        this.f$0 = intRef;
        this.f$1 = i;
        this.f$2 = function1;
        this.f$3 = arrayList;
        this.f$4 = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AvatarUi.segmented$lambda$45$lambda$43$lambda$42(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
