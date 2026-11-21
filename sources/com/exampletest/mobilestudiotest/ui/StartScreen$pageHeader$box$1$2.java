package com.exampletest.mobilestudiotest.ui;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: StartScreen.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/exampletest/mobilestudiotest/ui/StartScreen$pageHeader$box$1$2", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "a", "", "b", "c", "onTextChanged", "afterTextChanged", "Landroid/text/Editable;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartScreen$pageHeader$box$1$2 implements TextWatcher {
    final /* synthetic */ StartScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartScreen$pageHeader$box$1$2(StartScreen startScreen) {
        this.this$0 = startScreen;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        String obj;
        StartScreen startScreen = this.this$0;
        String obj2 = (s == null || (obj = s.toString()) == null) ? null : StringsKt.trim((CharSequence) obj).toString();
        if (obj2 == null) {
            obj2 = "";
        }
        StartScreen.access$setQuery$p(startScreen, obj2);
        StartScreen.access$applyFilter(this.this$0);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int a, int b, int c) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int a, int b, int c) {
    }
}
