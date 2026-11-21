package com.exampletest.mobilestudiotest.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioBrowser.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/exampletest/mobilestudiotest/ui/AudioBrowser$buildResults$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "r", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AudioBrowser$buildResults$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ LinearLayoutManager $lm;
    final /* synthetic */ AudioBrowser this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioBrowser$buildResults$1(LinearLayoutManager linearLayoutManager, AudioBrowser audioBrowser) {
        this.$lm = linearLayoutManager;
        this.this$0 = audioBrowser;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r, int dx, int dy) {
        Intrinsics.checkNotNullParameter(r, "r");
        if (this.$lm.findLastVisibleItemPosition() >= AudioBrowser.access$getItems$p(this.this$0).size() - 5) {
            AudioBrowser.access$loadMore(this.this$0);
        }
    }
}
