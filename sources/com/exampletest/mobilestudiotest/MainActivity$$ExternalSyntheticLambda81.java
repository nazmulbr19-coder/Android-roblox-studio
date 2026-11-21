package com.exampletest.mobilestudiotest;

import android.view.View;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "snapRow$lambda$242$lambda$241", proto = "(Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;FLandroid/view/View;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda81 implements View.OnFocusChangeListener {
    public final /* synthetic */ EditText f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ float f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda81(EditText editText, Function1 function1, float f) {
        this.f$0 = editText;
        this.f$1 = function1;
        this.f$2 = f;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        MainActivity.snapRow$lambda$242$lambda$241(this.f$0, this.f$1, this.f$2, view, z);
    }
}
