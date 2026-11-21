package androidx.savedstate;

import androidx.savedstate.SavedStateRegistryController;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/savedstate/SavedStateRegistryController$Companion;", method = "create$lambda$0", proto = "(Landroidx/savedstate/SavedStateRegistryOwner;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SavedStateRegistryController$Companion$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ SavedStateRegistryOwner f$0;

    public /* synthetic */ SavedStateRegistryController$Companion$$ExternalSyntheticLambda0(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.f$0 = savedStateRegistryOwner;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return SavedStateRegistryController.Companion.create$lambda$0(this.f$0);
    }
}
