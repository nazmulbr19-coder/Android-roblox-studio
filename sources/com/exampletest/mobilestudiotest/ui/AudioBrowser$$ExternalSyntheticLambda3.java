package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;", method = "previewListener$lambda$2$lambda$1", proto = "(Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AudioBrowser$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ AudioBrowser f$0;

    public /* synthetic */ AudioBrowser$$ExternalSyntheticLambda3(AudioBrowser audioBrowser) {
        this.f$0 = audioBrowser;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioBrowser.previewListener$lambda$2$lambda$1(this.f$0);
    }
}
