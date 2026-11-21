package com.exampletest.mobilestudiotest.audio;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.audio.AudioEngine;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", method = "togglePreview$lambda$19$lambda$18", proto = "(Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Preview;JF)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes3.dex */
public final /* synthetic */ class AudioEngine$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ AudioEngine.Preview f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ float f$2;

    public /* synthetic */ AudioEngine$$ExternalSyntheticLambda9(AudioEngine.Preview preview, long j, float f) {
        this.f$0 = preview;
        this.f$1 = j;
        this.f$2 = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioEngine.togglePreview$lambda$19$lambda$18(this.f$0, this.f$1, this.f$2);
    }
}
