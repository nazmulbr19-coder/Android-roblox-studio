package androidx.appcompat.text;

import android.content.Context;
import androidx.appcompat.text.TextAppearanceSpanCompat;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/appcompat/text/TextAppearanceSpanCompat$Companion;", method = "createInternal$lambda$0", proto = "(Landroidx/appcompat/text/TextAppearanceSpanCompat$Companion$FontFetcher;Landroid/content/Context;ILjava/util/concurrent/atomic/AtomicReference;Ljava/lang/Runnable;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class TextAppearanceSpanCompat$Companion$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ TextAppearanceSpanCompat.Companion.FontFetcher f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ AtomicReference f$3;
    public final /* synthetic */ Runnable f$4;

    public /* synthetic */ TextAppearanceSpanCompat$Companion$$ExternalSyntheticLambda0(TextAppearanceSpanCompat.Companion.FontFetcher fontFetcher, Context context, int i, AtomicReference atomicReference, Runnable runnable) {
        this.f$0 = fontFetcher;
        this.f$1 = context;
        this.f$2 = i;
        this.f$3 = atomicReference;
        this.f$4 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextAppearanceSpanCompat.Companion.createInternal$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
