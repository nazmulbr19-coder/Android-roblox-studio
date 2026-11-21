package com.exampletest.mobilestudiotest.audio;

import android.media.MediaPlayer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.audio.AudioEngine;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/audio/AudioEngine;", method = "togglePreview$lambda$19$lambda$18$lambda$15", proto = "(Lcom/exampletest/mobilestudiotest/audio/AudioEngine$Preview;FLandroid/media/MediaPlayer;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes3.dex */
public final /* synthetic */ class AudioEngine$$ExternalSyntheticLambda1 implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ AudioEngine.Preview f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ AudioEngine$$ExternalSyntheticLambda1(AudioEngine.Preview preview, float f) {
        this.f$0 = preview;
        this.f$1 = f;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        AudioEngine.togglePreview$lambda$19$lambda$18$lambda$15(this.f$0, this.f$1, mediaPlayer);
    }
}
