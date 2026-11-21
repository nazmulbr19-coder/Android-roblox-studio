package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/MenuHostHelper;", method = "lambda$addMenuProvider$0", proto = "(Landroidx/core/view/MenuProvider;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MenuHostHelper$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ MenuHostHelper f$0;
    public final /* synthetic */ MenuProvider f$1;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda1(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f$0 = menuHostHelper;
        this.f$1 = menuProvider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f$0.m97lambda$addMenuProvider$0$androidxcoreviewMenuHostHelper(this.f$1, lifecycleOwner, event);
    }
}
