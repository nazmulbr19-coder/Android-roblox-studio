package com.exampletest.mobilestudiotest.net;

import android.graphics.Bitmap;
import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageLoader.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¨\u0006\b"}, d2 = {"com/exampletest/mobilestudiotest/net/ImageLoader$mem$1", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "sizeOf", "", "key", "value", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ImageLoader$mem$1 extends LruCache<String, Bitmap> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageLoader$mem$1(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    public /* bridge */ /* synthetic */ int sizeOf(String str, Bitmap bitmap) {
        return sizeOf2(str, bitmap);
    }

    /* renamed from: sizeOf, reason: avoid collision after fix types in other method */
    protected int sizeOf2(String key, Bitmap value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return value.getByteCount();
    }
}
