package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "places$lambda$100", proto = "(Lkotlin/jvm/functions/Function2;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/ui/MainActions;Ljava/util/List;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda25 implements Function1 {
    public final /* synthetic */ Function2 f$0;
    public final /* synthetic */ RobloxCloud.Game f$1;
    public final /* synthetic */ Activity f$2;
    public final /* synthetic */ Studio f$3;
    public final /* synthetic */ MainActions f$4;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda25(Function2 function2, RobloxCloud.Game game, Activity activity, Studio studio, MainActions mainActions) {
        this.f$0 = function2;
        this.f$1 = game;
        this.f$2 = activity;
        this.f$3 = studio;
        this.f$4 = mainActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.places$lambda$100(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (List) obj);
    }
}
