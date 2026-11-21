package com.exampletest.mobilestudiotest.audio;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.audio.AudioEngine;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", method = "pausePreview$lambda$20", proto = "(Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Preview;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes3.dex */
public final /* synthetic */ class AudioEngine$$ExternalSyntheticLambda16 implements Runnable {
    public final /* synthetic */ AudioEngine.Preview f$0;

    public /* synthetic */ AudioEngine$$ExternalSyntheticLambda16(AudioEngine.Preview preview) {
        this.f$0 = preview;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioEngine.pausePreview$lambda$20(this.f$0);
    }
}
