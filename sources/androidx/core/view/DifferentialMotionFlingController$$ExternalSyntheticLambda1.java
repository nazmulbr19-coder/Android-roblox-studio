package androidx.core.view;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.DifferentialMotionFlingController;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/DifferentialMotionFlingController;", method = "getCurrentVelocity", proto = "(Landroid/view/VelocityTracker;Landroid/view/MotionEvent;I)F")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DifferentialMotionFlingController$$ExternalSyntheticLambda1 implements DifferentialMotionFlingController.DifferentialVelocityProvider {
    @Override // androidx.core.view.DifferentialMotionFlingController.DifferentialVelocityProvider
    public final float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i) {
        return DifferentialMotionFlingController.$r8$lambda$rCNQ1h5KBIaVcUXhwymI_1638W0(velocityTracker, motionEvent, i);
    }
}
