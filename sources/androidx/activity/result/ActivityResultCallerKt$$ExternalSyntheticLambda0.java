package androidx.activity.result;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/result/ActivityResultCallerKt;", method = "registerForActivityResult$lambda$0", proto = "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ActivityResultCallerKt$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ActivityResultCallerKt$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        ActivityResultCallerKt.registerForActivityResult$lambda$0(this.f$0, obj);
    }
}
