package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.ui.AudioBrowser;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser$Adapter;", method = "onBindViewHolder$lambda$19", proto = "(Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioItem;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AudioBrowser$Adapter$$ExternalSyntheticLambda4 implements View.OnClickListener {
    public final /* synthetic */ AudioBrowser f$0;
    public final /* synthetic */ RobloxApi.AudioItem f$1;

    public /* synthetic */ AudioBrowser$Adapter$$ExternalSyntheticLambda4(AudioBrowser audioBrowser, RobloxApi.AudioItem audioItem) {
        this.f$0 = audioBrowser;
        this.f$1 = audioItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AudioBrowser.Adapter.onBindViewHolder$lambda$19(this.f$0, this.f$1, view);
    }
}
