package androidx.core.view;

import android.content.ClipData;
import androidx.core.util.Predicate;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Ljava/util/function/Predicate;", method = "test", proto = "(Ljava/lang/Object;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ java.util.function.Predicate f$0;

    public /* synthetic */ ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0(java.util.function.Predicate predicate) {
        this.f$0 = predicate;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return this.f$0.test((ClipData.Item) obj);
    }
}
