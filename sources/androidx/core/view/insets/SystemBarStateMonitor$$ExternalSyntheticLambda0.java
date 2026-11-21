package androidx.core.view.insets;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/insets/SystemBarStateMonitor;", method = "lambda$new$0", proto = "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SystemBarStateMonitor$$ExternalSyntheticLambda0 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ SystemBarStateMonitor f$0;

    public /* synthetic */ SystemBarStateMonitor$$ExternalSyntheticLambda0(SystemBarStateMonitor systemBarStateMonitor) {
        this.f$0 = systemBarStateMonitor;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f$0.m122lambda$new$0$androidxcoreviewinsetsSystemBarStateMonitor(view, windowInsetsCompat);
    }
}
