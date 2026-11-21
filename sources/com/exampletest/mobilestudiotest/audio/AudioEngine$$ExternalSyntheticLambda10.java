package com.exampletest.mobilestudiotest.audio;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.audio.AudioEngine;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", method = "togglePreview$lambda$19", proto = "(JLcom/exampletest/mobilestudiotest/audio/AudioEngine$Preview;F)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes3.dex */
public final /* synthetic */ class AudioEngine$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ AudioEngine.Preview f$1;
    public final /* synthetic */ float f$2;

    public /* synthetic */ AudioEngine$$ExternalSyntheticLambda10(long j, AudioEngine.Preview preview, float f) {
        this.f$0 = j;
        this.f$1 = preview;
        this.f$2 = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioEngine.togglePreview$lambda$19(this.f$0, this.f$1, this.f$2);
    }
}
