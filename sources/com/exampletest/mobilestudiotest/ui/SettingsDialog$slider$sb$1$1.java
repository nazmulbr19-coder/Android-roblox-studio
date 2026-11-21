package com.exampletest.mobilestudiotest.ui;

import android.widget.SeekBar;
import android.widget.TextView;
import com.exampletest.mobilestudiotest.model.DataTypesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SettingsDialog.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/exampletest/mobilestudiotest/ui/SettingsDialog$slider$sb$1$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "s", "Landroid/widget/SeekBar;", "p", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsDialog$slider$sb$1$1 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ float $min;
    final /* synthetic */ Function1<Float, Unit> $onSet;
    final /* synthetic */ float $step;
    final /* synthetic */ TextView $valueText;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsDialog$slider$sb$1$1(float f, float f2, TextView textView, Function1<? super Float, Unit> function1) {
        this.$min = f;
        this.$step = f2;
        this.$valueText = textView;
        this.$onSet = function1;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar s, int p, boolean fromUser) {
        float f = this.$min + (p * this.$step);
        this.$valueText.setText(DataTypesKt.fmtNum(f));
        if (fromUser) {
            this.$onSet.invoke(Float.valueOf(f));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar s) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar s) {
    }
}
