package com.exampletest.mobilestudiotest.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: RbxBinary.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/Lz4;", "", "<init>", "()V", "decompress", "", "src", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "", "len", "dstLen", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Lz4 {
    public static final Lz4 INSTANCE = new Lz4();

    private Lz4() {
    }

    public final byte[] decompress(byte[] src, int off, int len, int dstLen) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(src, "src");
        byte[] bArr = new byte[dstLen];
        int i3 = off;
        int i4 = off + len;
        int i5 = 0;
        while (i3 < i4) {
            int i6 = i3 + 1;
            int i7 = src[i3] & 255;
            int i8 = i7 >>> 4;
            if (i8 == 15) {
                while (true) {
                    i2 = i6 + 1;
                    int i9 = src[i6] & 255;
                    i8 += i9;
                    if (i9 != 255) {
                        break;
                    }
                    i6 = i2;
                }
                i6 = i2;
            }
            System.arraycopy(src, i6, bArr, i5, i8);
            int i10 = i6 + i8;
            i5 += i8;
            if (i10 >= i4) {
                break;
            }
            int i11 = (src[i10] & 255) | ((src[i10 + 1] & 255) << 8);
            int i12 = i10 + 2;
            int i13 = i7 & 15;
            if (i13 == 15) {
                while (true) {
                    i = i12 + 1;
                    int i14 = src[i12] & 255;
                    i13 += i14;
                    if (i14 != 255) {
                        break;
                    }
                    i12 = i;
                }
                i12 = i;
            }
            int i15 = i13 + 4;
            int i16 = i5 - i11;
            if (i16 < 0) {
                throw new RbxFormatException("Corrupt LZ4 data");
            }
            int i17 = 0;
            while (i17 < i15) {
                bArr[i5] = bArr[i16];
                i17++;
                i5++;
                i16++;
            }
            i3 = i12;
        }
        return bArr;
    }
}
