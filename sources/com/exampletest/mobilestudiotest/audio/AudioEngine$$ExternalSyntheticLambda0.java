package com.exampletest.mobilestudiotest.audio;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.audio.AudioEngine;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", method = "seekPreview$lambda$23", proto = "(Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Preview;F)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes3.dex */
public final /* synthetic */ class AudioEngine$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AudioEngine.Preview f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ AudioEngine$$ExternalSyntheticLambda0(AudioEngine.Preview preview, float f) {
        this.f$0 = preview;
        this.f$1 = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioEngine.seekPreview$lambda$23(this.f$0, this.f$1);
    }
}
