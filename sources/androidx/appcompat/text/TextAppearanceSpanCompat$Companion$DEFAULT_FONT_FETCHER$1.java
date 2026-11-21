package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.text.TextAppearanceSpanCompat;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextAppearanceSpanCompat.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"androidx/appcompat/text/TextAppearanceSpanCompat$Companion$DEFAULT_FONT_FETCHER$1", "Landroidx/appcompat/text/TextAppearanceSpanCompat$Companion$FontFetcher;", "getCachedFont", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "fontResId", "", "getFont", "appcompat"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextAppearanceSpanCompat$Companion$DEFAULT_FONT_FETCHER$1 implements TextAppearanceSpanCompat.Companion.FontFetcher {
    @Override // androidx.appcompat.text.TextAppearanceSpanCompat.Companion.FontFetcher
    public Typeface getCachedFont(Context context, int fontResId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ResourcesCompat.getCachedFont(context, fontResId);
    }

    @Override // androidx.appcompat.text.TextAppearanceSpanCompat.Companion.FontFetcher
    public Typeface getFont(Context context, int fontResId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ResourcesCompat.getFont(context, fontResId);
    }
}
