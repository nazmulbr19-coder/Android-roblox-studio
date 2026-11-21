package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    /* loaded from: classes.dex */
    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = length;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        while (true) {
            if (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 2048) {
                    i += encodedLengthGeneral(charSequence, i2);
                    break;
                }
                i += (127 - charAt) >>> 31;
                i2++;
            } else {
                break;
            }
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i;
        int i4 = i3 + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (i3 < i4) {
            byte b = bArr[i3];
            if (!Utf8.DecodeUtil.isOneByte(b)) {
                break;
            }
            i3++;
            Utf8.DecodeUtil.handleOneByte(b, cArr, i5);
            i5++;
        }
        int i6 = i5;
        while (i3 < i4) {
            int i7 = i3 + 1;
            byte b2 = bArr[i3];
            if (Utf8.DecodeUtil.isOneByte(b2)) {
                int i8 = i6 + 1;
                Utf8.DecodeUtil.handleOneByte(b2, cArr, i6);
                while (i7 < i4) {
                    byte b3 = bArr[i7];
                    if (!Utf8.DecodeUtil.isOneByte(b3)) {
                        break;
                    }
                    i7++;
                    Utf8.DecodeUtil.handleOneByte(b3, cArr, i8);
                    i8++;
                }
                i6 = i8;
                i3 = i7;
            } else if (Utf8.DecodeUtil.isTwoBytes(b2)) {
                if (i7 >= i4) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i3 = i7 + 1;
                Utf8.DecodeUtil.handleTwoBytes(b2, bArr[i7], cArr, i6);
                i6++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b2)) {
                if (i7 >= i4 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i9 = i7 + 1;
                Utf8.DecodeUtil.handleThreeBytes(b2, bArr[i7], bArr[i9], cArr, i6);
                i3 = i9 + 1;
                i6++;
            } else {
                if (i7 >= i4 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i10 = i7 + 1;
                int i11 = i10 + 1;
                Utf8.DecodeUtil.handleFourBytes(b2, bArr[i7], bArr[i10], bArr[i11], cArr, i6);
                i3 = i11 + 1;
                i6 = i6 + 1 + 1;
            }
        }
        return new String(cArr, 0, i6);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i, int i2) {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = byteBuffer.get(i);
            if (!Utf8.DecodeUtil.isOneByte(b)) {
                break;
            }
            i++;
            Utf8.DecodeUtil.handleOneByte(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = byteBuffer.get(i);
            if (Utf8.DecodeUtil.isOneByte(b2)) {
                int i7 = i5 + 1;
                Utf8.DecodeUtil.handleOneByte(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = byteBuffer.get(i6);
                    if (!Utf8.DecodeUtil.isOneByte(b3)) {
                        break;
                    }
                    i6++;
                    Utf8.DecodeUtil.handleOneByte(b3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (Utf8.DecodeUtil.isTwoBytes(b2)) {
                if (i6 >= i3) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i = i6 + 1;
                Utf8.DecodeUtil.handleTwoBytes(b2, byteBuffer.get(i6), cArr, i5);
                i5++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b2)) {
                if (i6 >= i3 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i8 = i6 + 1;
                Utf8.DecodeUtil.handleThreeBytes(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                i = i8 + 1;
                i5++;
            } else {
                if (i6 >= i3 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i9 = i6 + 1;
                int i10 = i9 + 1;
                Utf8.DecodeUtil.handleFourBytes(b2, byteBuffer.get(i6), byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                i = i10 + 1;
                i5 = i5 + 1 + 1;
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        return r12 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int encodeUtf8Array(java.lang.CharSequence r10, byte[] r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.flatbuffer.Utf8Safe.encodeUtf8Array(java.lang.CharSequence, byte[], int, int):int");
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i = 0;
        while (i < length) {
            try {
                char charAt = charSequence.charAt(i);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i, (byte) charAt);
                i++;
            } catch (IndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (byteBuffer.position() + Math.max(i, (position - byteBuffer.position()) + 1)));
            }
        }
        if (i == length) {
            byteBuffer.position(position + i);
            return;
        }
        int i2 = position + i;
        while (i < length) {
            char charAt2 = charSequence.charAt(i);
            if (charAt2 < 128) {
                byteBuffer.put(i2, (byte) charAt2);
            } else if (charAt2 < 2048) {
                int i3 = i2 + 1;
                try {
                    byteBuffer.put(i2, (byte) ((charAt2 >>> 6) | 192));
                    byteBuffer.put(i3, (byte) ((charAt2 & '?') | 128));
                    i2 = i3;
                } catch (IndexOutOfBoundsException e2) {
                    position = i3;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (byteBuffer.position() + Math.max(i, (position - byteBuffer.position()) + 1)));
                }
            } else {
                if (charAt2 >= 55296 && 57343 >= charAt2) {
                    if (i + 1 != length) {
                        i++;
                        char charAt3 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i4 = i2 + 1;
                            try {
                                byteBuffer.put(i2, (byte) ((codePoint >>> 18) | 240));
                                int i5 = i4 + 1;
                                byteBuffer.put(i4, (byte) (((codePoint >>> 12) & 63) | 128));
                                int i6 = i5 + 1;
                                byteBuffer.put(i5, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i6, (byte) ((codePoint & 63) | 128));
                                i2 = i6;
                            } catch (IndexOutOfBoundsException e3) {
                                position = i4;
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (byteBuffer.position() + Math.max(i, (position - byteBuffer.position()) + 1)));
                            }
                        }
                    }
                    throw new UnpairedSurrogateException(i, length);
                }
                int i7 = i2 + 1;
                byteBuffer.put(i2, (byte) ((charAt2 >>> '\f') | 224));
                i2 = i7 + 1;
                byteBuffer.put(i7, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(i2, (byte) ((charAt2 & '?') | 128));
            }
            i++;
            i2++;
        }
        byteBuffer.position(i2);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new UnpairedSurrogateException(i3, length);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2) : decodeUtf8Buffer(byteBuffer, i, i2);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            encodeUtf8Buffer(charSequence, byteBuffer);
        } else {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
