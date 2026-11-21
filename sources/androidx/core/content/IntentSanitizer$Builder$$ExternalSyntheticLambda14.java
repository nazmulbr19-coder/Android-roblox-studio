package androidx.core.content;

import android.content.ComponentName;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroid/content/ComponentName;", method = "equals", proto = "(Ljava/lang/Object;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class IntentSanitizer$Builder$$ExternalSyntheticLambda14 implements Predicate {
    public final /* synthetic */ ComponentName f$0;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda14(ComponentName componentName) {
        this.f$0 = componentName;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return IntentSanitizer.Builder.$r8$lambda$HF7enmHP1Z3cPiyI1KCE8M8gPts(this.f$0, (ComponentName) obj);
    }
}
