package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import com.exampletest.mobilestudiotest.model.Color3;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* compiled from: Dialogs.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/exampletest/mobilestudiotest/ui/Dialogs$colorPicker$2", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "a", "", "bb", "c", "onTextChanged", "afterTextChanged", "Landroid/text/Editable;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Dialogs$colorPicker$2 implements TextWatcher {
    final /* synthetic */ Ref.IntRef $b;
    final /* synthetic */ ArrayList<SeekBar> $bars;
    final /* synthetic */ Context $ctx;
    final /* synthetic */ Ref.IntRef $g;
    final /* synthetic */ EditText $hex;
    final /* synthetic */ View $preview;
    final /* synthetic */ Ref.IntRef $r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dialogs$colorPicker$2(Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, ArrayList<SeekBar> arrayList, View view, EditText editText, Context context) {
        this.$r = intRef;
        this.$g = intRef2;
        this.$b = intRef3;
        this.$bars = arrayList;
        this.$preview = view;
        this.$hex = editText;
        this.$ctx = context;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        Color3 fromHex = Color3.INSTANCE.fromHex(String.valueOf(s));
        if (fromHex == null) {
            return;
        }
        int r = (int) ((fromHex.getR() * 255.0f) + 0.5f);
        int g = (int) ((fromHex.getG() * 255.0f) + 0.5f);
        int b = (int) ((fromHex.getB() * 255.0f) + 0.5f);
        if (r == this.$r.element && g == this.$g.element && b == this.$b.element) {
            return;
        }
        this.$r.element = r;
        this.$g.element = g;
        this.$b.element = b;
        this.$bars.get(0).setProgress(this.$r.element);
        this.$bars.get(1).setProgress(this.$g.element);
        this.$bars.get(2).setProgress(this.$b.element);
        Dialogs.access$colorPicker$refresh(this.$preview, this.$hex, this.$r, this.$g, this.$b, this.$ctx, false);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int a, int bb, int c) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int a, int bb, int c) {
    }
}
