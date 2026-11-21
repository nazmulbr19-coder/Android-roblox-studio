package com.exampletest.mobilestudiotest.ui;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToolboxPanel.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/exampletest/mobilestudiotest/ui/ToolboxPanel$buildMarket$10", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "r", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ToolboxPanel$buildMarket$10 extends RecyclerView.OnScrollListener {
    final /* synthetic */ GridLayoutManager $glm;
    final /* synthetic */ ToolboxPanel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToolboxPanel$buildMarket$10(GridLayoutManager gridLayoutManager, ToolboxPanel toolboxPanel) {
        this.$glm = gridLayoutManager;
        this.this$0 = toolboxPanel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r, int dx, int dy) {
        Intrinsics.checkNotNullParameter(r, "r");
        if (this.$glm.findLastVisibleItemPosition() >= ToolboxPanel.access$getItems$p(this.this$0).size() - 6) {
            ToolboxPanel.access$loadMore(this.this$0);
        }
    }
}
