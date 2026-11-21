package com.exampletest.mobilestudiotest.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: RbxBinary.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020#J\u000e\u0010$\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010%\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006("}, d2 = {"Lcom/exampletest/mobilestudiotest/format/ByteWriter;", "", "<init>", "()V", "out", "Ljava/io/ByteArrayOutputStream;", "getOut", "()Ljava/io/ByteArrayOutputStream;", "u8", "", "v", "", "u16", "i32", "f32", "", "i64", "", "f64", "", "bytes", "b", "", TypedValues.Custom.S_STRING, "s", "", "interleaved", "d", "n", "size", "u32Array", "a", "", "i32Array", "f32Array", "", "refArray", "i64Array", "", "toByteArray", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ByteWriter {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public final void bytes(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        this.out.write(b);
    }

    public final void f32(float v) {
        i32(Float.floatToRawIntBits(v));
    }

    public final void f32Array(float[] a) {
        Intrinsics.checkNotNullParameter(a, "a");
        int length = a.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            int floatToRawIntBits = Float.floatToRawIntBits(a[i]);
            iArr[i] = (floatToRawIntBits << 1) | (floatToRawIntBits >>> 31);
        }
        u32Array(iArr);
    }

    public final void f64(double v) {
        i64(Double.doubleToRawLongBits(v));
    }

    public final ByteArrayOutputStream getOut() {
        return this.out;
    }

    public final void i32(int v) {
        u8(v);
        u8(v >> 8);
        u8(v >> 16);
        u8(v >> 24);
    }

    public final void i32Array(int[] a) {
        Intrinsics.checkNotNullParameter(a, "a");
        int length = a.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = (a[i] << 1) ^ (a[i] >> 31);
        }
        u32Array(iArr);
    }

    public final void i64(long v) {
        i32((int) v);
        i32((int) (v >>> 32));
    }

    public final void i64Array(long[] a) {
        Intrinsics.checkNotNullParameter(a, "a");
        byte[] bArr = new byte[a.length * 8];
        int length = a.length;
        for (int i = 0; i < length; i++) {
            long j = (a[i] << 1) ^ (a[i] >> 63);
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[(i * 8) + i2] = (byte) (j >>> (56 - (i2 * 8)));
            }
        }
        interleaved(bArr, a.length, 8);
    }

    public final void interleaved(byte[] d, int n, int size) {
        Intrinsics.checkNotNullParameter(d, "d");
        byte[] bArr = new byte[n * size];
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < n; i2++) {
                bArr[(i * n) + i2] = d[(i2 * size) + i];
            }
        }
        this.out.write(bArr);
    }

    public final void refArray(int[] a) {
        Intrinsics.checkNotNullParameter(a, "a");
        int[] iArr = new int[a.length];
        int i = 0;
        int length = a.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = a[i2] - i;
            i = a[i2];
        }
        i32Array(iArr);
    }

    public final void string(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        byte[] bytes = s.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        string(bytes);
    }

    public final void string(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        i32(b.length);
        bytes(b);
    }

    public final byte[] toByteArray() {
        byte[] byteArray = this.out.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final void u16(int v) {
        u8(v);
        u8(v >> 8);
    }

    public final void u32Array(int[] a) {
        Intrinsics.checkNotNullParameter(a, "a");
        byte[] bArr = new byte[a.length * 4];
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int i2 = a[i];
            bArr[i * 4] = (byte) (i2 >>> 24);
            bArr[(i * 4) + 1] = (byte) (i2 >>> 16);
            bArr[(i * 4) + 2] = (byte) (i2 >>> 8);
            bArr[(i * 4) + 3] = (byte) i2;
        }
        interleaved(bArr, a.length, 4);
    }

    public final void u8(int v) {
        this.out.write(v & 255);
    }
}
