package com.exampletest.mobilestudiotest.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: CsgMesh.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002&'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007J \u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00152\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0007H\u0002J&\u0010\"\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/exampletest/mobilestudiotest/format/CsgMesh;", "", "<init>", "()V", "KEY", "", "MAGIC", "", "xorByte", "", "b", "i", "", "startsWithMagic", "", "scrambled", "isCsgMesh", "decode", "Lcom/exampletest/mobilestudiotest/format/CsgMesh$Decoded;", "raw", "le", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "at", "checkIndices", "", "idx", "nv", "firstLod", "all", "lods", "decodeList", "version", "decodePacked", "decodeDeltaIndices", "start", "size", "count", "CsgException", "Decoded", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CsgMesh {
    public static final CsgMesh INSTANCE = new CsgMesh();
    private static final int[] KEY = {86, 46, 110, 88, 49, 32, 48, 4, 52, 105, 12, 119, 12, 1, 94, 0, 26, 96, 55, 105, 29, 82, 43, 7, 79, 36, 89, TypedValues.TYPE_TARGET, 83, 4, 122};
    private static final byte[] MAGIC;

    /* compiled from: CsgMesh.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/CsgMesh$CsgException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", NotificationCompat.CATEGORY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CsgException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CsgException(String msg) {
            super(msg);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    /* compiled from: CsgMesh.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/CsgMesh$Decoded;", "", "pos", "", "nrm", "colors", "", "indices", "<init>", "([F[F[I[I)V", "getPos", "()[F", "getNrm", "getColors", "()[I", "getIndices", "vertexCount", "", "getVertexCount", "()I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Decoded {
        private final int[] colors;
        private final int[] indices;
        private final float[] nrm;
        private final float[] pos;

        public Decoded(float[] pos, float[] nrm, int[] colors, int[] indices) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(nrm, "nrm");
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(indices, "indices");
            this.pos = pos;
            this.nrm = nrm;
            this.colors = colors;
            this.indices = indices;
        }

        public final int[] getColors() {
            return this.colors;
        }

        public final int[] getIndices() {
            return this.indices;
        }

        public final float[] getNrm() {
            return this.nrm;
        }

        public final float[] getPos() {
            return this.pos;
        }

        public final int getVertexCount() {
            return this.pos.length / 3;
        }
    }

    static {
        byte[] bytes = "CSGMDL".getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        MAGIC = bytes;
    }

    private CsgMesh() {
    }

    private final void checkIndices(int[] idx, int nv) {
        for (int i : idx) {
            if (i < 0 || i >= nv) {
                throw new CsgException("index out of range");
            }
        }
    }

    private final Decoded decodeList(byte[] b, int version) {
        ByteBuffer le = le(b, 42);
        int i = le.getInt();
        int i2 = le.getInt();
        if (i < 0 || i2 < 40 || (i * i2) + 50 > b.length) {
            throw new CsgException("bad vertex data");
        }
        float[] fArr = new float[i * 3];
        float[] fArr2 = new float[i * 3];
        int[] iArr = new int[i];
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                break;
            }
            int i4 = (i3 * i2) + 50;
            le.position(i4);
            fArr[i3 * 3] = le.getFloat();
            fArr[(i3 * 3) + 1] = le.getFloat();
            fArr[(i3 * 3) + 2] = le.getFloat();
            fArr2[i3 * 3] = le.getFloat();
            fArr2[(i3 * 3) + 1] = le.getFloat();
            fArr2[(i3 * 3) + 2] = le.getFloat();
            iArr[i3] = ((b[i4 + 27] & UByte.MAX_VALUE) << 24) | ((b[i4 + 24] & UByte.MAX_VALUE) << 16) | ((b[i4 + 25] & UByte.MAX_VALUE) << 8) | (b[i4 + 26] & UByte.MAX_VALUE);
            i3++;
        }
        le.position((i * i2) + 50);
        if (le.remaining() < 4) {
            throw new CsgException("missing indices");
        }
        int i5 = le.getInt();
        if (i5 < 0 || i5 * 4 > le.remaining()) {
            throw new CsgException("bad index count");
        }
        int[] iArr2 = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr2[i6] = le.getInt();
        }
        checkIndices(iArr2, i);
        int[] iArr3 = null;
        if (version >= 4 && le.remaining() >= 4) {
            int i7 = le.getInt();
            if ((1 <= i7 && i7 < 65) && le.remaining() >= i7 * 4) {
                int[] iArr4 = new int[i7];
                for (int i8 = 0; i8 < i7; i8++) {
                    iArr4[i8] = le.getInt();
                }
                iArr3 = iArr4;
            }
        }
        return new Decoded(fArr, fArr2, iArr, firstLod(iArr2, iArr3));
    }

    private final Decoded decodePacked(byte[] b) {
        ByteBuffer le = le(b, 10);
        int decodePacked$count = decodePacked$count(le, -1);
        if (le.remaining() < decodePacked$count * 12) {
            throw new CsgException("bad positions");
        }
        int i = decodePacked$count * 3;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = le.getFloat();
        }
        decodePacked$count(le, decodePacked$count);
        int i3 = le.getInt();
        if (i3 != decodePacked$count * 6 || le.remaining() < i3) {
            throw new CsgException("bad normals");
        }
        int i4 = decodePacked$count * 3;
        float[] fArr2 = new float[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            fArr2[i5] = ((le.getShort() & UShort.MAX_VALUE) / 32767.0f) - 1.0f;
        }
        decodePacked$count(le, decodePacked$count);
        int[] iArr = new int[decodePacked$count];
        for (int i6 = 0; i6 < decodePacked$count; i6++) {
            iArr[i6] = ((le.get() & UByte.MAX_VALUE) << 24) | ((le.get() & UByte.MAX_VALUE) << 16) | ((le.get() & UByte.MAX_VALUE) << 8) | (le.get() & UByte.MAX_VALUE);
        }
        decodePacked$count(le, decodePacked$count);
        le.position(le.position() + decodePacked$count);
        decodePacked$count(le, decodePacked$count);
        le.position(le.position() + (decodePacked$count * 8));
        decodePacked$count(le, decodePacked$count);
        le.position(le.position() + le.getInt());
        int i7 = le.getInt();
        int i8 = le.getInt();
        if (i7 < 0 || i8 < 0 || i8 > le.remaining()) {
            throw new CsgException("bad index data");
        }
        int[] decodeDeltaIndices = decodeDeltaIndices(b, le.position(), i8, i7);
        checkIndices(decodeDeltaIndices, decodePacked$count);
        le.position(le.position() + i8);
        int[] iArr2 = null;
        if (le.remaining() >= 4) {
            int i9 = le.getInt();
            if ((1 <= i9 && i9 < 65) && le.remaining() >= i9 * 4) {
                int[] iArr3 = new int[i9];
                for (int i10 = 0; i10 < i9; i10++) {
                    iArr3[i10] = le.getInt();
                }
                iArr2 = iArr3;
            }
        }
        return new Decoded(fArr, fArr2, iArr, firstLod(decodeDeltaIndices, iArr2));
    }

    private static final int decodePacked$count(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.getShort() & UShort.MAX_VALUE;
        if (i < 0 || i2 == i) {
            return i2;
        }
        throw new CsgException("inconsistent vertex count");
    }

    private final int[] firstLod(int[] all, int[] lods) {
        if (lods == null || lods.length < 2) {
            return all;
        }
        int coerceIn = RangesKt.coerceIn(lods[0], 0, all.length);
        int coerceIn2 = RangesKt.coerceIn(lods[1], coerceIn, all.length);
        return coerceIn2 - coerceIn < 3 ? all : ArraysKt.copyOfRange(all, coerceIn, coerceIn2 - ((coerceIn2 - coerceIn) % 3));
    }

    private final ByteBuffer le(byte[] b, int at) {
        ByteBuffer order = ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN);
        order.position(at);
        return order;
    }

    private final boolean startsWithMagic(byte[] b, boolean scrambled) {
        if (b.length < 10) {
            return false;
        }
        int length = MAGIC.length;
        for (int i = 0; i < length; i++) {
            if ((scrambled ? xorByte(b, i) : b[i]) != MAGIC[i]) {
                return false;
            }
        }
        return true;
    }

    private final byte xorByte(byte[] b, int i) {
        return (byte) (b[i] ^ KEY[i % KEY.length]);
    }

    public final Decoded decode(byte[] raw) {
        boolean z;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(raw, "raw");
        if (startsWithMagic(raw, false)) {
            z = false;
        } else {
            z = true;
            if (!startsWithMagic(raw, true)) {
                throw new CsgException("not a union mesh");
            }
        }
        byte[] bArr2 = new byte[10];
        for (int i = 0; i < 10; i++) {
            bArr2[i] = z ? INSTANCE.xorByte(raw, i) : raw[i];
        }
        int i2 = ByteBuffer.wrap(bArr2, 6, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
        switch (i2) {
            case 2:
            case 3:
            case 4:
                if (z) {
                    int length = raw.length;
                    bArr = new byte[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        bArr[i3] = INSTANCE.xorByte(raw, i3);
                    }
                } else {
                    bArr = raw;
                }
                return decodeList(bArr, i2);
            case 5:
            case 6:
                return decodePacked(raw);
            default:
                throw new CsgException("union mesh version " + i2 + " isn't supported");
        }
    }

    public final int[] decodeDeltaIndices(byte[] b, int start, int size, int count) {
        int i;
        Intrinsics.checkNotNullParameter(b, "b");
        int[] iArr = new int[count];
        int i2 = start;
        int i3 = start + size;
        int i4 = 0;
        int i5 = 0;
        while (i5 < count) {
            if (i2 >= i3) {
                throw new CsgException("index data too short");
            }
            int i6 = i2 + 1;
            int i7 = b[i2] & UByte.MAX_VALUE;
            if (i7 < 128) {
                i = i7 >= 64 ? i7 - 128 : i7;
            } else {
                if (i6 + 2 > i3) {
                    throw new CsgException("index data too short");
                }
                i = ((i7 & WorkQueueKt.MASK) << 16) | ((b[i6] & UByte.MAX_VALUE) << 8) | (b[i6 + 1] & UByte.MAX_VALUE);
                i6 += 2;
                if (i >= 4194304) {
                    i -= 8388608;
                }
            }
            i4 += i;
            iArr[i5] = i4;
            i5++;
            i2 = i6;
        }
        if (i2 == i3) {
            return iArr;
        }
        throw new CsgException("index data has " + (i3 - i2) + " extra bytes");
    }

    public final boolean isCsgMesh(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        return startsWithMagic(b, true) || startsWithMagic(b, false);
    }
}
