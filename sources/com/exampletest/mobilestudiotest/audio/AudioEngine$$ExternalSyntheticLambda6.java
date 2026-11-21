package com.exampletest.mobilestudiotest.audio;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.audio.AudioEngine;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", method = "update$lambda$7", proto = "(Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Voice;FFFZZ)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes3.dex */
public final /* synthetic */ class AudioEngine$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ AudioEngine.Voice f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ float f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ boolean f$5;

    public /* synthetic */ AudioEngine$$ExternalSyntheticLambda6(AudioEngine.Voice voice, float f, float f2, float f3, boolean z, boolean z2) {
        this.f$0 = voice;
        this.f$1 = f;
        this.f$2 = f2;
        this.f$3 = f3;
        this.f$4 = z;
        this.f$5 = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioEngine.update$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
