package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/content/UriMatcherCompat;", method = "lambda$asPredicate$0", proto = "(Landroid/content/UriMatcher;Landroid/net/Uri;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class UriMatcherCompat$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ UriMatcher f$0;

    public /* synthetic */ UriMatcherCompat$$ExternalSyntheticLambda0(UriMatcher uriMatcher) {
        this.f$0 = uriMatcher;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return UriMatcherCompat.lambda$asPredicate$0(this.f$0, (Uri) obj);
    }
}
