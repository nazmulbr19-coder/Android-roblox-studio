package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/content/res/ResourcesCompat$FontCallback;", method = "lambda$callbackSuccessAsync$0", proto = "(Landroid/graphics/Typeface;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ResourcesCompat$FontCallback$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ResourcesCompat.FontCallback f$0;
    public final /* synthetic */ Typeface f$1;

    public /* synthetic */ ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f$0 = fontCallback;
        this.f$1 = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m75x46c88379(this.f$1);
    }
}
