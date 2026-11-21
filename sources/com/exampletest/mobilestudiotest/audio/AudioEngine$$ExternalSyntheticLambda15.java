package com.exampletest.mobilestudiotest.audio;

import android.media.MediaPlayer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.audio.AudioEngine;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", method = "create$lambda$12$lambda$11", proto = "(Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Voice;Landroid/media/MediaPlayer;II)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes3.dex */
public final /* synthetic */ class AudioEngine$$ExternalSyntheticLambda15 implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ AudioEngine.Voice f$0;

    public /* synthetic */ AudioEngine$$ExternalSyntheticLambda15(AudioEngine.Voice voice) {
        this.f$0 = voice;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return AudioEngine.create$lambda$12$lambda$11(this.f$0, mediaPlayer, i, i2);
    }
}
