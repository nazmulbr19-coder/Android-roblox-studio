package com.exampletest.mobilestudiotest.ui;

import android.widget.SeekBar;
import com.exampletest.mobilestudiotest.audio.AudioEngine;
import com.exampletest.mobilestudiotest.ui.AudioBrowser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioBrowser.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/exampletest/mobilestudiotest/ui/AudioBrowser$Adapter$onBindViewHolder$2", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "sb", "Landroid/widget/SeekBar;", "v", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AudioBrowser$Adapter$onBindViewHolder$2 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ AudioBrowser.VH $h;
    final /* synthetic */ long $id;
    final /* synthetic */ AudioBrowser this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioBrowser$Adapter$onBindViewHolder$2(AudioBrowser.VH vh, AudioBrowser audioBrowser, long j) {
        this.$h = vh;
        this.this$0 = audioBrowser;
        this.$id = j;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar sb, int v, boolean fromUser) {
        Intrinsics.checkNotNullParameter(sb, "sb");
        if (fromUser) {
            this.$h.getElapsed().setText(AudioBrowser.access$fmtClock(this.this$0, v / 10.0f));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar sb) {
        Intrinsics.checkNotNullParameter(sb, "sb");
        AudioBrowser.access$setDraggingId$p(this.this$0, Long.valueOf(this.$id));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar sb) {
        Intrinsics.checkNotNullParameter(sb, "sb");
        AudioBrowser.access$setDraggingId$p(this.this$0, null);
        AudioEngine.INSTANCE.seekPreview(this.$id, sb.getProgress() / 10.0f);
    }
}
