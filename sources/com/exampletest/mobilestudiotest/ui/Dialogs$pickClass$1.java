package com.exampletest.mobilestudiotest.ui;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Dialogs.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/exampletest/mobilestudiotest/ui/Dialogs$pickClass$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "a", "", "b", "c", "onTextChanged", "afterTextChanged", "Landroid/text/Editable;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Dialogs$pickClass$1 implements TextWatcher {
    final /* synthetic */ Dialogs$pickClass$adapter$1 $adapter;
    final /* synthetic */ List<String> $all;
    final /* synthetic */ ArrayList<String> $shown;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dialogs$pickClass$1(ArrayList<String> arrayList, List<String> list, Dialogs$pickClass$adapter$1 dialogs$pickClass$adapter$1) {
        this.$shown = arrayList;
        this.$all = list;
        this.$adapter = dialogs$pickClass$adapter$1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        String lowerCase = StringsKt.trim((CharSequence) String.valueOf(s)).toString().toLowerCase(Locale.ROOT);
        String str = "toLowerCase(...)";
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.$shown.clear();
        ArrayList<String> arrayList = this.$shown;
        List<String> list = this.$all;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            String lowerCase2 = ((String) obj).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, str);
            String str2 = lowerCase;
            String str3 = str;
            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                arrayList2.add(obj);
            }
            lowerCase = str2;
            str = str3;
        }
        arrayList.addAll(arrayList2);
        this.$adapter.notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int a, int b, int c) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int a, int b, int c) {
    }
}
