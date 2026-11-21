package com.exampletest.mobilestudiotest;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "snapRow$lambda$242$lambda$240", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;FLandroid/widget/TextView;ILandroid/view/KeyEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda80 implements TextView.OnEditorActionListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ Function1 f$2;
    public final /* synthetic */ float f$3;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda80(MainActivity mainActivity, EditText editText, Function1 function1, float f) {
        this.f$0 = mainActivity;
        this.f$1 = editText;
        this.f$2 = function1;
        this.f$3 = f;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return MainActivity.snapRow$lambda$242$lambda$240(this.f$0, this.f$1, this.f$2, this.f$3, textView, i, keyEvent);
    }
}
