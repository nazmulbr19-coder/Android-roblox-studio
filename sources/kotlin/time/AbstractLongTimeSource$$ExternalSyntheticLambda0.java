package kotlin.time;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/time/AbstractLongTimeSource;", method = "zero_delegate$lambda$0", proto = "(Lkotlin/time/AbstractLongTimeSource;)J")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AbstractLongTimeSource$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ AbstractLongTimeSource f$0;

    public /* synthetic */ AbstractLongTimeSource$$ExternalSyntheticLambda0(AbstractLongTimeSource abstractLongTimeSource) {
        this.f$0 = abstractLongTimeSource;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Long.valueOf(AbstractLongTimeSource.zero_delegate$lambda$0(this.f$0));
    }
}
