package com.exampletest.mobilestudiotest.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: RbxBinary.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006+"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/ByteReader;", "", "buf", "", "pos", "", "end", "<init>", "([BII)V", "getBuf", "()[B", "getPos", "()I", "setPos", "(I)V", "getEnd", "remaining", "need", "", "n", "u8", "u16", "i32", "f32", "", "i64", "", "f64", "", "bytes", "stringBytes", TypedValues.Custom.S_STRING, "", "interleaved", "size", "u32Array", "", "i32Array", "f32Array", "", "refArray", "i64Array", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ByteReader {
    private final byte[] buf;
    private final int end;
    private int pos;

    public ByteReader(byte[] buf, int i, int i2) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        this.buf = buf;
        this.pos = i;
        this.end = i2;
    }

    public /* synthetic */ ByteReader(byte[] bArr, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? bArr.length : i2);
    }

    private final void need(int n) {
        if (this.pos + n > this.end) {
            throw new RbxFormatException("Unexpected end of chunk");
        }
    }

    public final byte[] bytes(int n) {
        need(n);
        byte[] copyOfRange = ArraysKt.copyOfRange(this.buf, this.pos, this.pos + n);
        this.pos += n;
        return copyOfRange;
    }

    public final float f32() {
        return Float.intBitsToFloat(i32());
    }

    public final float[] f32Array(int n) {
        int[] u32Array = u32Array(n);
        float[] fArr = new float[n];
        for (int i = 0; i < n; i++) {
            int i2 = u32Array[i];
            fArr[i] = Float.intBitsToFloat((i2 >>> 1) | (i2 << 31));
        }
        return fArr;
    }

    public final double f64() {
        return Double.longBitsToDouble(i64());
    }

    public final byte[] getBuf() {
        return this.buf;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getPos() {
        return this.pos;
    }

    public final int i32() {
        need(4);
        int i = (this.buf[this.pos] & UByte.MAX_VALUE) | ((this.buf[this.pos + 1] & UByte.MAX_VALUE) << 8) | ((this.buf[this.pos + 2] & UByte.MAX_VALUE) << 16) | ((this.buf[this.pos + 3] & UByte.MAX_VALUE) << 24);
        this.pos += 4;
        return i;
    }

    public final int[] i32Array(int n) {
        int[] u32Array = u32Array(n);
        int length = u32Array.length;
        for (int i = 0; i < length; i++) {
            int i2 = u32Array[i];
            u32Array[i] = (i2 >>> 1) ^ (-(i2 & 1));
        }
        return u32Array;
    }

    public final long i64() {
        return (i32() << 32) | (i32() & 4294967295L);
    }

    public final long[] i64Array(int n) {
        byte[] interleaved = interleaved(n, 8);
        long[] jArr = new long[n];
        for (int i = 0; i < n; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j << 8) | (interleaved[(i * 8) + i2] & 255);
            }
            jArr[i] = (j >>> 1) ^ (-(1 & j));
        }
        return jArr;
    }

    public final byte[] interleaved(int n, int size) {
        need(n * size);
        byte[] bArr = new byte[n * size];
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < n; i2++) {
                bArr[(i2 * size) + i] = this.buf[this.pos + (i * n) + i2];
            }
        }
        this.pos += n * size;
        return bArr;
    }

    public final int[] refArray(int n) {
        int[] i32Array = i32Array(n);
        for (int i = 1; i < n; i++) {
            i32Array[i] = i32Array[i] + i32Array[i - 1];
        }
        return i32Array;
    }

    public final int remaining() {
        return this.end - this.pos;
    }

    public final void setPos(int i) {
        this.pos = i;
    }

    public final String string() {
        return new String(stringBytes(), Charsets.UTF_8);
    }

    public final byte[] stringBytes() {
        int i32 = i32();
        if (i32 >= 0) {
            return bytes(i32);
        }
        throw new RbxFormatException("Bad string length");
    }

    public final int u16() {
        need(2);
        int i = (this.buf[this.pos] & UByte.MAX_VALUE) | ((this.buf[this.pos + 1] & UByte.MAX_VALUE) << 8);
        this.pos += 2;
        return i;
    }

    public final int[] u32Array(int n) {
        byte[] interleaved = interleaved(n, 4);
        int[] iArr = new int[n];
        for (int i = 0; i < n; i++) {
            int i2 = i * 4;
            iArr[i] = ((interleaved[i2] & UByte.MAX_VALUE) << 24) | ((interleaved[i2 + 1] & UByte.MAX_VALUE) << 16) | ((interleaved[i2 + 2] & UByte.MAX_VALUE) << 8) | (interleaved[i2 + 3] & UByte.MAX_VALUE);
        }
        return iArr;
    }

    public final int u8() {
        need(1);
        byte[] bArr = this.buf;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }
}
