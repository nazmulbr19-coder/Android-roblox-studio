package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroid/view/ViewConfiguration;", method = "getScaledMaximumFlingVelocity", proto = "()I")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ViewConfigurationCompat$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ ViewConfiguration f$0;

    public /* synthetic */ ViewConfigurationCompat$$ExternalSyntheticLambda0(ViewConfiguration viewConfiguration) {
        this.f$0 = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        return Integer.valueOf(ViewConfigurationCompat.$r8$lambda$u_xUdJpIAAO3758SdHprtx7JUP0(this.f$0));
    }
}
