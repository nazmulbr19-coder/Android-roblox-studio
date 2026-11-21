package androidx.core.graphics;

import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$ImageInfo;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$Source;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageDecoder.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes.dex */
public final class ImageDecoderKt$decodeDrawable$1 implements ImageDecoder$OnHeaderDecodedListener {
    final /* synthetic */ Function3<ImageDecoder, ImageDecoder$ImageInfo, ImageDecoder$Source, Unit> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageDecoderKt$decodeDrawable$1(Function3<? super ImageDecoder, ? super ImageDecoder$ImageInfo, ? super ImageDecoder$Source, Unit> function3) {
        this.$action = function3;
    }

    public final void onHeaderDecoded(ImageDecoder decoder, ImageDecoder$ImageInfo info, ImageDecoder$Source source) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        this.$action.invoke(decoder, info, source);
    }
}
