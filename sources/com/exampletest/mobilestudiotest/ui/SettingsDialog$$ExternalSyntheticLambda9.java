package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Theme;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "show$lambda$3", proto = "(Lcom/exampletest/mobilestudiotest/core/Theme;Lkotlin/jvm/internal/Ref$BooleanRef;Lkotlin/jvm/internal/Ref$ObjectRef;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda9 implements Function0 {
    public final /* synthetic */ Theme f$0;
    public final /* synthetic */ Ref.BooleanRef f$1;
    public final /* synthetic */ Ref.ObjectRef f$2;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda9(Theme theme, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef) {
        this.f$0 = theme;
        this.f$1 = booleanRef;
        this.f$2 = objectRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return SettingsDialog.show$lambda$3(this.f$0, this.f$1, this.f$2);
    }
}
