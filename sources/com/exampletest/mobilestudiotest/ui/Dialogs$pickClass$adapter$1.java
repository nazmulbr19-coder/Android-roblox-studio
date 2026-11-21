package com.exampletest.mobilestudiotest.ui;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Dialogs.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/exampletest/mobilestudiotest/ui/Dialogs$pickClass$adapter$1", "Landroid/widget/ArrayAdapter;", "", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Dialogs$pickClass$adapter$1 extends ArrayAdapter<String> {
    final /* synthetic */ Context $ctx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Dialogs$pickClass$adapter$1(Context context, ArrayList<String> arrayList) {
        super(context, R.layout.simple_list_item_1, arrayList);
        this.$ctx = context;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = super.getView(position, convertView, parent);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        String item = getItem(position);
        Intrinsics.checkNotNull(item);
        String str = item;
        textView.setText(str);
        textView.setTextColor(Ui.INSTANCE.getTEXT());
        int dp = Ui.INSTANCE.dp(this.$ctx, 18.0f);
        Drawable iconFor = Ui.INSTANCE.iconFor(this.$ctx, str);
        iconFor.setBounds(0, 0, dp, dp);
        textView.setCompoundDrawables(iconFor, null, null, null);
        textView.setCompoundDrawablePadding(Ui.INSTANCE.dp(this.$ctx, 10.0f));
        return textView;
    }
}
