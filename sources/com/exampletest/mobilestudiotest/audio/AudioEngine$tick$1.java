package com.exampletest.mobilestudiotest.audio;

import com.exampletest.mobilestudiotest.audio.AudioEngine;
import kotlin.Metadata;

/* compiled from: AudioEngine.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/exampletest/mobilestudiotest/audio/AudioEngine$tick$1", "Ljava/lang/Runnable;", "run", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioEngine$tick$1 implements Runnable {
    final /* synthetic */ AudioEngine.Voice $v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioEngine$tick$1(AudioEngine.Voice voice) {
        this.$v = voice;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.$v.getMp() == null) {
            return;
        }
        try {
            if (this.$v.getPrepared()) {
                this.$v.setPosition(r0.getCurrentPosition() / 1000.0d);
            }
            if (this.$v.getWantPlay()) {
                AudioEngine.access$getH$p().postDelayed(this, 200L);
            }
        } catch (Exception e) {
        }
    }
}
