package androidx.core.content;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/content/IntentSanitizer$Builder;", method = "lambda$allowExtra$13", proto = "(Ljava/lang/Class;Landroidx/core/util/Predicate;Ljava/lang/Object;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class IntentSanitizer$Builder$$ExternalSyntheticLambda13 implements Predicate {
    public final /* synthetic */ Class f$0;
    public final /* synthetic */ Predicate f$1;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda13(Class cls, Predicate predicate) {
        this.f$0 = cls;
        this.f$1 = predicate;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return IntentSanitizer.Builder.lambda$allowExtra$13(this.f$0, this.f$1, obj);
    }
}
