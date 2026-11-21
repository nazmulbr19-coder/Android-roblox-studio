package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = new ThreadLocal<>();
    private final TextPaint mTextPaint = new TextPaint();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultGlyphChecker() {
        this.mTextPaint.setTextSize(10.0f);
    }

    private static StringBuilder getStringBuilder() {
        if (sStringBuilder.get() == null) {
            sStringBuilder.set(new StringBuilder());
        }
        return sStringBuilder.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        StringBuilder stringBuilder = getStringBuilder();
        stringBuilder.setLength(0);
        while (i < i2) {
            stringBuilder.append(charSequence.charAt(i));
            i++;
        }
        return PaintCompat.hasGlyph(this.mTextPaint, stringBuilder.toString());
    }
}
