package com.exampletest.mobilestudiotest;

import android.net.Uri;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.DataModel;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "onFilePicked$lambda$313$lambda$310$lambda$309", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Lcom/exampletest/mobilestudiotest/model/DataModel;Landroid/net/Uri;Ljava/lang/String;ZI)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda45 implements Function0 {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ DataModel f$1;
    public final /* synthetic */ Uri f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ int f$5;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda45(MainActivity mainActivity, DataModel dataModel, Uri uri, String str, boolean z, int i) {
        this.f$0 = mainActivity;
        this.f$1 = dataModel;
        this.f$2 = uri;
        this.f$3 = str;
        this.f$4 = z;
        this.f$5 = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return MainActivity.onFilePicked$lambda$313$lambda$310$lambda$309(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
