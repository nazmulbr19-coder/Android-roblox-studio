package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* compiled from: Dialogs.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/exampletest/mobilestudiotest/ui/Dialogs$colorPicker$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "s", "Landroid/widget/SeekBar;", "p", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Dialogs$colorPicker$1 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ Ref.IntRef $b;
    final /* synthetic */ Context $ctx;
    final /* synthetic */ Ref.IntRef $g;
    final /* synthetic */ EditText $hex;
    final /* synthetic */ int $i;
    final /* synthetic */ View $preview;
    final /* synthetic */ Ref.IntRef $r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dialogs$colorPicker$1(int i, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, View view, EditText editText, Context context) {
        this.$i = i;
        this.$r = intRef;
        this.$g = intRef2;
        this.$b = intRef3;
        this.$preview = view;
        this.$hex = editText;
        this.$ctx = context;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar s, int p, boolean fromUser) {
        Ref.IntRef intRef;
        if (fromUser) {
            switch (this.$i) {
                case 0:
                    intRef = this.$r;
                    break;
                case 1:
                    intRef = this.$g;
                    break;
                default:
                    intRef = this.$b;
                    break;
            }
            intRef.element = p;
            Dialogs.colorPicker$refresh$default(this.$preview, this.$hex, this.$r, this.$g, this.$b, this.$ctx, false, 64, null);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar s) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar s) {
    }
}
