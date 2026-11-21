package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.ui.AudioBrowser;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser$Adapter;", method = "onBindViewHolder$lambda$21$lambda$20", proto = "(Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioItem;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AudioBrowser$Adapter$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ RobloxApi.AudioItem f$0;

    public /* synthetic */ AudioBrowser$Adapter$$ExternalSyntheticLambda0(RobloxApi.AudioItem audioItem) {
        this.f$0 = audioItem;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AudioBrowser.Adapter.onBindViewHolder$lambda$21$lambda$20(this.f$0);
    }
}
