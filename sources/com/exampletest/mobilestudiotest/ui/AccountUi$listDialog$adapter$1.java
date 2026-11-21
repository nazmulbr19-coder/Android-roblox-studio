package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.exampletest.mobilestudiotest.net.ImageLoader;
import com.exampletest.mobilestudiotest.ui.AccountUi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountUi.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/exampletest/mobilestudiotest/ui/AccountUi$listDialog$adapter$1", "Landroid/widget/BaseAdapter;", "getCount", "", "getItem", "Lcom/exampletest/mobilestudiotest/ui/AccountUi$Row;", "p", "getItemId", "", "getView", "Landroid/view/View;", "convert", "parent", "Landroid/view/ViewGroup;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccountUi$listDialog$adapter$1 extends BaseAdapter {
    final /* synthetic */ Activity $act;
    final /* synthetic */ List<AccountUi.Row> $rows;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountUi$listDialog$adapter$1(List<AccountUi.Row> list, Activity activity) {
        this.$rows = list;
        this.$act = activity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.$rows.size();
    }

    @Override // android.widget.Adapter
    public AccountUi.Row getItem(int p) {
        return this.$rows.get(p);
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int p) {
        return p;
    }

    @Override // android.widget.Adapter
    public View getView(int p, View convert, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AccountUi.Row row = this.$rows.get(p);
        LinearLayout linearLayout = convert instanceof LinearLayout ? (LinearLayout) convert : null;
        if (linearLayout == null) {
            linearLayout = new LinearLayout(this.$act);
            Activity activity = this.$act;
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            Activity activity2 = activity;
            linearLayout.setPadding(Ui.INSTANCE.dp(activity2, 12.0f), Ui.INSTANCE.dp(activity2, 8.0f), Ui.INSTANCE.dp(activity2, 12.0f), Ui.INSTANCE.dp(activity2, 8.0f));
            ImageView imageView = new ImageView(activity2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(activity2, 44.0f), Ui.INSTANCE.dp(activity2, 44.0f), 0.0f, 4, null);
            lp$default.rightMargin = Ui.INSTANCE.dp(activity2, 12.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(imageView, lp$default);
            LinearLayout linearLayout2 = new LinearLayout(activity2);
            linearLayout2.setOrientation(1);
            linearLayout2.addView(Ui.INSTANCE.text(activity2, "", 14.0f, Ui.INSTANCE.getTEXT(), true));
            linearLayout2.addView(Ui.text$default(Ui.INSTANCE, activity2, "", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null));
            linearLayout.addView(linearLayout2, Ui.INSTANCE.lp(0, -2, 1.0f));
        }
        View childAt = linearLayout.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView2 = (ImageView) childAt;
        View childAt2 = linearLayout.getChildAt(1);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout3 = (LinearLayout) childAt2;
        View childAt3 = linearLayout3.getChildAt(0);
        Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) childAt3).setText(row.getTitle());
        View childAt4 = linearLayout3.getChildAt(1);
        Intrinsics.checkNotNull(childAt4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) childAt4;
        textView.setText(row.getSub());
        textView.setVisibility(row.getSub().length() == 0 ? 8 : 0);
        String iconUrl = row.getIconUrl();
        Bitmap key = iconUrl != null ? ImageLoader.INSTANCE.getKey("url:" + iconUrl) : null;
        if (key != null) {
            imageView2.setImageBitmap(key);
        } else {
            imageView2.setImageDrawable(row.getIconFallback());
        }
        return linearLayout;
    }
}
