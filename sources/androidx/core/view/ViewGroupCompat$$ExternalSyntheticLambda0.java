package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/ViewGroupCompat;", method = "lambda$dispatchApplyWindowInsets$1", proto = "([Landroid/view/WindowInsets;Landroid/view/View$OnApplyWindowInsetsListener;Landroid/view/View;Landroid/view/WindowInsets;)Landroid/view/WindowInsets;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ViewGroupCompat$$ExternalSyntheticLambda0 implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ WindowInsets[] f$0;
    public final /* synthetic */ View.OnApplyWindowInsetsListener f$1;

    public /* synthetic */ ViewGroupCompat$$ExternalSyntheticLambda0(WindowInsets[] windowInsetsArr, View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f$0 = windowInsetsArr;
        this.f$1 = onApplyWindowInsetsListener;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ViewGroupCompat.lambda$dispatchApplyWindowInsets$1(this.f$0, this.f$1, view, windowInsets);
    }
}
