package com.exampletest.mobilestudiotest.audio;

import android.media.MediaPlayer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.audio.AudioEngine;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", method = "create$lambda$12$lambda$10", proto = "(Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Voice;Landroid/media/MediaPlayer;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes3.dex */
public final /* synthetic */ class AudioEngine$$ExternalSyntheticLambda14 implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ AudioEngine.Voice f$0;

    public /* synthetic */ AudioEngine$$ExternalSyntheticLambda14(AudioEngine.Voice voice) {
        this.f$0 = voice;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        AudioEngine.create$lambda$12$lambda$10(this.f$0, mediaPlayer);
    }
}
