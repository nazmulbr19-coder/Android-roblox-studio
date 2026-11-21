package com.exampletest.mobilestudiotest.audio;

import android.media.MediaPlayer;
import com.exampletest.mobilestudiotest.audio.AudioEngine;
import kotlin.Metadata;

/* compiled from: AudioEngine.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/exampletest/mobilestudiotest/audio/AudioEngine$tick$2", "Ljava/lang/Runnable;", "run", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioEngine$tick$2 implements Runnable {
    final /* synthetic */ MediaPlayer $mp;
    final /* synthetic */ AudioEngine.Preview $p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioEngine$tick$2(AudioEngine.Preview preview, MediaPlayer mediaPlayer) {
        this.$p = preview;
        this.$mp = mediaPlayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (AudioEngine.INSTANCE.getPreview() == this.$p && AudioEngine.access$getPreviewPlayer$p() == this.$mp && this.$p.getState() == AudioEngine.PreviewState.PLAYING) {
            try {
                this.$p.setPosition(this.$mp.getCurrentPosition() / 1000.0f);
                AudioEngine.access$notifyPreview(AudioEngine.INSTANCE);
                AudioEngine.access$getH$p().postDelayed(this, 150L);
            } catch (Exception e) {
            }
        }
    }
}
