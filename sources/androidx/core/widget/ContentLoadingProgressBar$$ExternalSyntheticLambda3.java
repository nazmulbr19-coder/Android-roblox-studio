package androidx.core.widget;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/widget/ContentLoadingProgressBar;", method = "hideOnUiThread", proto = "()V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ContentLoadingProgressBar$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar f$0;

    public /* synthetic */ ContentLoadingProgressBar$$ExternalSyntheticLambda3(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f$0 = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContentLoadingProgressBar.m124$r8$lambda$LzWHroRwziRn4m5pHwlpZWokBw(this.f$0);
    }
}
