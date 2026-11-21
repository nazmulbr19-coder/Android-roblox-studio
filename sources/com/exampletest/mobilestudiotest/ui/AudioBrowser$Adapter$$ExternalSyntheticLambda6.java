package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.ui.AudioBrowser;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser$Adapter;", method = "onBindViewHolder$lambda$26", proto = "(Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioItem;Landroid/view/View;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AudioBrowser$Adapter$$ExternalSyntheticLambda6 implements View.OnLongClickListener {
    public final /* synthetic */ AudioBrowser f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ RobloxApi.AudioItem f$4;

    public /* synthetic */ AudioBrowser$Adapter$$ExternalSyntheticLambda6(AudioBrowser audioBrowser, String str, String str2, String str3, RobloxApi.AudioItem audioItem) {
        this.f$0 = audioBrowser;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = str3;
        this.f$4 = audioItem;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return AudioBrowser.Adapter.onBindViewHolder$lambda$26(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
