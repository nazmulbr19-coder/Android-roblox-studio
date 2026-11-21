package com.exampletest.mobilestudiotest.render;

import androidx.core.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;

/* compiled from: RbxMesh.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J8\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0002J\"\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u0010H\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0010H\u0002¨\u0006)"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/RbxMesh;", "", "<init>", "()V", "parse", "Lcom/exampletest/mobilestudiotest/render/MeshData;", "bytes", "", "build", "pos", "", "nrm", "uv", "faces", "", "f0", "", "f1", "parseV1", "text", "", "scaleHalf", "", "buf", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "b", "at", "smoothNormals", "readVerts", "Lcom/exampletest/mobilestudiotest/render/RbxMesh$Verts;", "bb", "n", "stride", "readFaces", "parseV2", "parseV3", "parseV4", "parseChunked", "UnsupportedMesh", "Verts", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class RbxMesh {
    public static final RbxMesh INSTANCE = new RbxMesh();

    /* compiled from: RbxMesh.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/RbxMesh$UnsupportedMesh;", "Ljava/lang/Exception;", "Lkotlin/Exception;", NotificationCompat.CATEGORY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class UnsupportedMesh extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedMesh(String msg) {
            super(msg);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    /* compiled from: RbxMesh.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/RbxMesh$Verts;", "", "pos", "", "nrm", "uv", "<init>", "([F[F[F)V", "getPos", "()[F", "getNrm", "getUv", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class Verts {
        private final float[] nrm;
        private final float[] pos;
        private final float[] uv;

        public Verts(float[] pos, float[] nrm, float[] uv) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(nrm, "nrm");
            Intrinsics.checkNotNullParameter(uv, "uv");
            this.pos = pos;
            this.nrm = nrm;
            this.uv = uv;
        }

        public final float[] getNrm() {
            return this.nrm;
        }

        public final float[] getPos() {
            return this.pos;
        }

        public final float[] getUv() {
            return this.uv;
        }
    }

    private RbxMesh() {
    }

    private final ByteBuffer buf(byte[] b, int at) {
        ByteBuffer order = ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN);
        order.position(at);
        return order;
    }

    private final MeshData build(float[] pos, float[] nrm, float[] uv, int[] faces, int f0, int f1) {
        float[] fArr;
        int length = pos.length / 3;
        float[] fArr2 = new float[(f1 - f0) * 24];
        float[] fArr3 = {Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE};
        float[] fArr4 = {-3.4028235E38f, -3.4028235E38f, -3.4028235E38f};
        int i = 0;
        for (int i2 = f0; i2 < f1; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = faces[(i2 * 3) + i3];
                if (i4 >= 0 && i4 < length) {
                    for (int i5 = 0; i5 < 3; i5++) {
                        float f = pos[(i4 * 3) + i5];
                        fArr2[i + i5] = f;
                        if (f < fArr3[i5]) {
                            fArr3[i5] = f;
                        }
                        if (f > fArr4[i5]) {
                            fArr4[i5] = f;
                        }
                    }
                    fArr2[i + 3] = nrm[i4 * 3];
                    fArr2[i + 4] = nrm[(i4 * 3) + 1];
                    fArr2[i + 5] = nrm[(i4 * 3) + 2];
                    fArr2[i + 6] = uv[i4 * 2];
                    fArr2[i + 7] = uv[(i4 * 2) + 1];
                }
                i += 8;
            }
        }
        if (fArr3[0] > fArr4[0]) {
            ArraysKt.fill$default(fArr3, 0.0f, 0, 0, 6, (Object) null);
            fArr = fArr4;
            ArraysKt.fill$default(fArr, 0.0f, 0, 0, 6, (Object) null);
        } else {
            fArr = fArr4;
        }
        return new MeshData(fArr2, fArr3, fArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01c1, code lost:
    
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ad, code lost:
    
        r5 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ed, code lost:
    
        throw new com.exampletest.mobilestudiotest.render.RbxMesh.UnsupportedMesh("mesh without geometry");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c6, code lost:
    
        if (r3 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0137, code lost:
    
        throw new com.exampletest.mobilestudiotest.render.RbxMesh.UnsupportedMesh("Draco mesh without positions");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a3, code lost:
    
        if (r9 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a5, code lost:
    
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01a6, code lost:
    
        if (r10 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a8, code lost:
    
        r5 = new int[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ae, code lost:
    
        r12 = r5.length / 3;
        r13 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01b2, code lost:
    
        if (r13 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b6, code lost:
    
        if (r13.length < 2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b8, code lost:
    
        r7 = kotlin.ranges.RangesKt.coerceIn(r13[1], 1, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c2, code lost:
    
        r2 = r0.getPos();
        r3 = r0.getNrm();
        r4 = r0.getUv();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ce, code lost:
    
        if (r13 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d2, code lost:
    
        if (r13.length < 2) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01d4, code lost:
    
        r6 = kotlin.ranges.RangesKt.coerceIn(r13[0], 0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e4, code lost:
    
        return build(r2, r3, r4, r5, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01dc, code lost:
    
        r6 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.render.MeshData parseChunked(byte[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.RbxMesh.parseChunked(byte[], int):com.exampletest.mobilestudiotest.render.MeshData");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.render.MeshData parseV1(java.lang.String r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.RbxMesh.parseV1(java.lang.String, boolean):com.exampletest.mobilestudiotest.render.MeshData");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List parseV1$lambda$2(MatchResult m) {
        Intrinsics.checkNotNullParameter(m, "m");
        List split$default = StringsKt.split$default((CharSequence) m.getGroupValues().get(1), new char[]{','}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            Float floatOrNull = StringsKt.toFloatOrNull(StringsKt.trim((CharSequence) it.next()).toString());
            arrayList.add(Float.valueOf(floatOrNull != null ? floatOrNull.floatValue() : 0.0f));
        }
        return arrayList;
    }

    private final MeshData parseV2(byte[] b, int at) {
        ByteBuffer buf = buf(b, at);
        int i = buf.getShort() & UShort.MAX_VALUE;
        int i2 = buf.get() & UByte.MAX_VALUE;
        int i3 = buf.get() & UByte.MAX_VALUE;
        int i4 = buf.getInt();
        int i5 = buf.getInt();
        buf.position(at + i);
        Intrinsics.checkNotNull(buf);
        Verts readVerts = readVerts(buf, i4, i2);
        return build(readVerts.getPos(), readVerts.getNrm(), readVerts.getUv(), readFaces(buf, i5, i3), 0, i5);
    }

    private final MeshData parseV3(byte[] b, int at) {
        ByteBuffer buf = buf(b, at);
        int i = buf.getShort() & UShort.MAX_VALUE;
        int i2 = buf.get() & UByte.MAX_VALUE;
        int i3 = buf.get() & UByte.MAX_VALUE;
        buf.getShort();
        int i4 = buf.getShort() & UShort.MAX_VALUE;
        int i5 = buf.getInt();
        int i6 = buf.getInt();
        buf.position(at + i);
        Intrinsics.checkNotNull(buf);
        Verts readVerts = readVerts(buf, i5, i2);
        int[] readFaces = readFaces(buf, i6, i3);
        int[] iArr = new int[i4];
        for (int i7 = 0; i7 < i4; i7++) {
            iArr[i7] = buf.getInt();
        }
        int coerceIn = i4 >= 2 ? RangesKt.coerceIn(iArr[1], 1, i6) : i6;
        return build(readVerts.getPos(), readVerts.getNrm(), readVerts.getUv(), readFaces, i4 >= 2 ? RangesKt.coerceIn(iArr[0], 0, coerceIn) : 0, coerceIn);
    }

    private final MeshData parseV4(byte[] b, int at) {
        ByteBuffer buf = buf(b, at);
        int i = buf.getShort() & UShort.MAX_VALUE;
        buf.getShort();
        int i2 = buf.getInt();
        int i3 = buf.getInt();
        int i4 = buf.getShort() & UShort.MAX_VALUE;
        int i5 = buf.getShort() & UShort.MAX_VALUE;
        buf.position(at + i);
        Intrinsics.checkNotNull(buf);
        Verts readVerts = readVerts(buf, i2, 40);
        if (i5 > 0) {
            buf.position(buf.position() + (i2 * 8));
        }
        int[] readFaces$default = readFaces$default(this, buf, i3, 0, 4, null);
        int[] iArr = new int[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            iArr[i6] = buf.getInt();
        }
        int coerceIn = i4 >= 2 ? RangesKt.coerceIn(iArr[1], 1, i3) : i3;
        return build(readVerts.getPos(), readVerts.getNrm(), readVerts.getUv(), readFaces$default, i4 >= 2 ? RangesKt.coerceIn(iArr[0], 0, coerceIn) : 0, coerceIn);
    }

    private final int[] readFaces(ByteBuffer bb, int n, int stride) {
        int[] iArr = new int[n * 3];
        for (int i = 0; i < n; i++) {
            int position = bb.position();
            iArr[i * 3] = bb.getInt();
            iArr[(i * 3) + 1] = bb.getInt();
            iArr[(i * 3) + 2] = bb.getInt();
            bb.position(position + stride);
        }
        return iArr;
    }

    static /* synthetic */ int[] readFaces$default(RbxMesh rbxMesh, ByteBuffer byteBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 12;
        }
        return rbxMesh.readFaces(byteBuffer, i, i2);
    }

    private final Verts readVerts(ByteBuffer bb, int n, int stride) {
        float[] fArr = new float[n * 3];
        float[] fArr2 = new float[n * 3];
        float[] fArr3 = new float[n * 2];
        for (int i = 0; i < n; i++) {
            int position = bb.position();
            fArr[i * 3] = bb.getFloat();
            fArr[(i * 3) + 1] = bb.getFloat();
            fArr[(i * 3) + 2] = bb.getFloat();
            fArr2[i * 3] = bb.getFloat();
            fArr2[(i * 3) + 1] = bb.getFloat();
            fArr2[(i * 3) + 2] = bb.getFloat();
            fArr3[i * 2] = bb.getFloat();
            fArr3[(i * 2) + 1] = bb.getFloat();
            bb.position(position + stride);
        }
        return new Verts(fArr, fArr2, fArr3);
    }

    public final MeshData parse(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        String str = new String(bytes, 0, Math.min(bytes.length, 13), Charsets.ISO_8859_1);
        if (!StringsKt.startsWith$default(str, "version ", false, 2, (Object) null)) {
            throw new UnsupportedMesh("not a mesh file");
        }
        String substring = str.substring(8, 12);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int indexOf = ArraysKt.indexOf(bytes, (byte) 10);
        if (indexOf < 0) {
            throw new UnsupportedMesh("bad header");
        }
        int i = indexOf + 1;
        if (StringsKt.startsWith$default(substring, "1.", false, 2, (Object) null)) {
            return parseV1(new String(bytes, Charsets.ISO_8859_1), Intrinsics.areEqual(substring, "1.00"));
        }
        if (Intrinsics.areEqual(substring, "2.00")) {
            return parseV2(bytes, i);
        }
        if (StringsKt.startsWith$default(substring, "3.", false, 2, (Object) null)) {
            return parseV3(bytes, i);
        }
        if (StringsKt.startsWith$default(substring, "4.", false, 2, (Object) null) || StringsKt.startsWith$default(substring, "5.", false, 2, (Object) null)) {
            return parseV4(bytes, i);
        }
        if (StringsKt.startsWith$default(substring, "6.", false, 2, (Object) null) || StringsKt.startsWith$default(substring, "7.", false, 2, (Object) null)) {
            return parseChunked(bytes, i);
        }
        throw new UnsupportedMesh("mesh version " + substring);
    }

    public final float[] smoothNormals(float[] pos, int[] faces) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(faces, "faces");
        float[] fArr = new float[pos.length];
        int length = pos.length / 3;
        int i = 0;
        while (i + 2 < faces.length) {
            int i2 = faces[i];
            int i3 = faces[i + 1];
            int i4 = faces[i + 2];
            i += 3;
            if (i2 >= 0 && i2 < length) {
                if (i3 >= 0 && i3 < length) {
                    if (i4 >= 0 && i4 < length) {
                        float f = pos[i3 * 3] - pos[i2 * 3];
                        float f2 = pos[(i3 * 3) + 1] - pos[(i2 * 3) + 1];
                        float f3 = pos[(i3 * 3) + 2] - pos[(i2 * 3) + 2];
                        float f4 = pos[i4 * 3] - pos[i2 * 3];
                        float f5 = pos[(i4 * 3) + 1] - pos[(i2 * 3) + 1];
                        float f6 = pos[(i4 * 3) + 2] - pos[(i2 * 3) + 2];
                        float f7 = (f2 * f6) - (f3 * f5);
                        float f8 = (f3 * f4) - (f * f6);
                        float f9 = (f * f5) - (f2 * f4);
                        int[] iArr = {i2, i3, i4};
                        for (int i5 = 0; i5 < 3; i5++) {
                            int i6 = iArr[i5];
                            int i7 = i6 * 3;
                            fArr[i7] = fArr[i7] + f7;
                            int i8 = (i6 * 3) + 1;
                            fArr[i8] = fArr[i8] + f8;
                            int i9 = (i6 * 3) + 2;
                            fArr[i9] = fArr[i9] + f9;
                        }
                    }
                }
            }
        }
        for (int i10 = 0; i10 < length; i10++) {
            float sqrt = (float) Math.sqrt((fArr[i10 * 3] * fArr[i10 * 3]) + (fArr[(i10 * 3) + 1] * fArr[(i10 * 3) + 1]) + (fArr[(i10 * 3) + 2] * fArr[(i10 * 3) + 2]));
            if (sqrt > 1.0E-12f) {
                int i11 = i10 * 3;
                fArr[i11] = fArr[i11] / sqrt;
                int i12 = (i10 * 3) + 1;
                fArr[i12] = fArr[i12] / sqrt;
                int i13 = (i10 * 3) + 2;
                fArr[i13] = fArr[i13] / sqrt;
            } else {
                fArr[(i10 * 3) + 1] = 1.0f;
            }
        }
        return fArr;
    }
}
