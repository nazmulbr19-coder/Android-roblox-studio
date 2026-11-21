package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public ArrayReadWriteBuf(int i) {
        this(new byte[i]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    public ArrayReadWriteBuf(byte[] bArr, int i) {
        this.buffer = bArr;
        this.writePos = i;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i) {
        return this.buffer[i];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i) {
        return this.buffer[i] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i) {
        return (this.buffer[i + 3] << 24) | ((this.buffer[i + 2] & UByte.MAX_VALUE) << 16) | ((this.buffer[i + 1] & UByte.MAX_VALUE) << 8) | (this.buffer[i] & UByte.MAX_VALUE);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i) {
        long j = (this.buffer[i] & 255) | ((this.buffer[r1] & 255) << 8);
        long j2 = j | ((this.buffer[r0] & 255) << 16);
        long j3 = j2 | ((this.buffer[r1] & 255) << 24);
        long j4 = j3 | ((this.buffer[r0] & 255) << 32);
        int i2 = i + 1 + 1 + 1 + 1 + 1 + 1;
        return j4 | ((this.buffer[r1] & 255) << 40) | ((this.buffer[i2] & 255) << 48) | (this.buffer[i2 + 1] << 56);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i) {
        return (short) ((this.buffer[i + 1] << 8) | (this.buffer[i] & UByte.MAX_VALUE));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i, int i2) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i, i2);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b) {
        set(this.writePos, b);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i, int i2) {
        set(this.writePos, bArr, i, i2);
        this.writePos += i2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z) {
        setBoolean(this.writePos, z);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d) {
        setDouble(this.writePos, d);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f) {
        setFloat(this.writePos, f);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i) {
        setInt(this.writePos, i);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j) {
        setLong(this.writePos, j);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s) {
        setShort(this.writePos, s);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i) {
        if (this.buffer.length > i) {
            return true;
        }
        int length = this.buffer.length;
        this.buffer = Arrays.copyOf(this.buffer, (length >> 1) + length);
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i, byte b) {
        requestCapacity(i + 1);
        this.buffer[i] = b;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i, byte[] bArr, int i2, int i3) {
        requestCapacity((i3 - i2) + i);
        System.arraycopy(bArr, i2, this.buffer, i, i3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i, boolean z) {
        set(i, z ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i, double d) {
        requestCapacity(i + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d);
        int i2 = (int) doubleToRawLongBits;
        int i3 = i + 1;
        this.buffer[i] = (byte) (i2 & 255);
        int i4 = i3 + 1;
        this.buffer[i3] = (byte) ((i2 >> 8) & 255);
        int i5 = i4 + 1;
        this.buffer[i4] = (byte) ((i2 >> 16) & 255);
        int i6 = i5 + 1;
        this.buffer[i5] = (byte) ((i2 >> 24) & 255);
        int i7 = (int) (doubleToRawLongBits >> 32);
        int i8 = i6 + 1;
        this.buffer[i6] = (byte) (i7 & 255);
        int i9 = i8 + 1;
        this.buffer[i8] = (byte) ((i7 >> 8) & 255);
        this.buffer[i9] = (byte) ((i7 >> 16) & 255);
        this.buffer[i9 + 1] = (byte) ((i7 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i, float f) {
        requestCapacity(i + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        int i2 = i + 1;
        this.buffer[i] = (byte) (floatToRawIntBits & 255);
        int i3 = i2 + 1;
        this.buffer[i2] = (byte) ((floatToRawIntBits >> 8) & 255);
        this.buffer[i3] = (byte) ((floatToRawIntBits >> 16) & 255);
        this.buffer[i3 + 1] = (byte) ((floatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i, int i2) {
        requestCapacity(i + 4);
        int i3 = i + 1;
        this.buffer[i] = (byte) (i2 & 255);
        int i4 = i3 + 1;
        this.buffer[i3] = (byte) ((i2 >> 8) & 255);
        this.buffer[i4] = (byte) ((i2 >> 16) & 255);
        this.buffer[i4 + 1] = (byte) ((i2 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i, long j) {
        requestCapacity(i + 8);
        int i2 = (int) j;
        int i3 = i + 1;
        this.buffer[i] = (byte) (i2 & 255);
        int i4 = i3 + 1;
        this.buffer[i3] = (byte) ((i2 >> 8) & 255);
        int i5 = i4 + 1;
        this.buffer[i4] = (byte) ((i2 >> 16) & 255);
        int i6 = i5 + 1;
        this.buffer[i5] = (byte) ((i2 >> 24) & 255);
        int i7 = (int) (j >> 32);
        int i8 = i6 + 1;
        this.buffer[i6] = (byte) (i7 & 255);
        int i9 = i8 + 1;
        this.buffer[i8] = (byte) ((i7 >> 8) & 255);
        this.buffer[i9] = (byte) ((i7 >> 16) & 255);
        this.buffer[i9 + 1] = (byte) ((i7 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i, short s) {
        requestCapacity(i + 2);
        this.buffer[i] = (byte) (s & 255);
        this.buffer[i + 1] = (byte) ((s >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }
}
