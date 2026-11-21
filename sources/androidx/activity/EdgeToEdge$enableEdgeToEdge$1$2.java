package androidx.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EdgeToEdge.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"androidx/activity/EdgeToEdge$enableEdgeToEdge$1$2", "Landroid/view/View;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "activity"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EdgeToEdge$enableEdgeToEdge$1$2 extends View {
    final /* synthetic */ Runnable $setup;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EdgeToEdge$enableEdgeToEdge$1$2(Runnable runnable, Context context) {
        super(context);
        this.$setup = runnable;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.$setup.run();
    }
}
