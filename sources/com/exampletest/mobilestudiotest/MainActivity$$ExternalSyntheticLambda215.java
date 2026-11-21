package com.exampletest.mobilestudiotest;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "managePlugins$lambda$342", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/io/File;Lkotlin/jvm/internal/Ref$ObjectRef;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda215 implements Function1 {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ File f$1;
    public final /* synthetic */ Ref.ObjectRef f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda215(MainActivity mainActivity, File file, Ref.ObjectRef objectRef) {
        this.f$0 = mainActivity;
        this.f$1 = file;
        this.f$2 = objectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MainActivity.managePlugins$lambda$342(this.f$0, this.f$1, this.f$2, (View) obj);
    }
}
