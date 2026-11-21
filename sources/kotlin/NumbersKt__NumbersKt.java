package kotlin;

/* compiled from: Numbers.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0010\n\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0006\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\u0005\u001a\u00020\n*\u00020\nH\u0087\b\u001a\r\u0010\u0006\u001a\u00020\n*\u00020\nH\u0087\b\u001a\u0014\u0010\u0007\u001a\u00020\n*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0007¨\u0006\u000b"}, d2 = {"countOneBits", "", "", "countLeadingZeroBits", "countTrailingZeroBits", "takeHighestOneBit", "takeLowestOneBit", "rotateLeft", "bitCount", "rotateRight", "", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes.dex */
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    private static final int countLeadingZeroBits(byte b) {
        return Integer.numberOfLeadingZeros(b & UByte.MAX_VALUE) - 24;
    }

    private static final int countLeadingZeroBits(short s) {
        return Integer.numberOfLeadingZeros(65535 & s) - 16;
    }

    private static final int countOneBits(byte b) {
        return Integer.bitCount(b & UByte.MAX_VALUE);
    }

    private static final int countOneBits(short s) {
        return Integer.bitCount(65535 & s);
    }

    private static final int countTrailingZeroBits(byte b) {
        return Integer.numberOfTrailingZeros(b | UByte.MIN_VALUE);
    }

    private static final int countTrailingZeroBits(short s) {
        return Integer.numberOfTrailingZeros(65536 | s);
    }

    public static final byte rotateLeft(byte b, int i) {
        return (byte) ((b << (i & 7)) | ((b & 255) >>> (8 - (i & 7))));
    }

    public static final short rotateLeft(short s, int i) {
        return (short) ((s << (i & 15)) | ((65535 & s) >>> (16 - (i & 15))));
    }

    public static final byte rotateRight(byte b, int i) {
        return (byte) ((b << (8 - (i & 7))) | ((b & 255) >>> (i & 7)));
    }

    public static final short rotateRight(short s, int i) {
        return (short) ((s << (16 - (i & 15))) | ((65535 & s) >>> (i & 15)));
    }

    private static final byte takeHighestOneBit(byte b) {
        return (byte) Integer.highestOneBit(b & UByte.MAX_VALUE);
    }

    private static final short takeHighestOneBit(short s) {
        return (short) Integer.highestOneBit(65535 & s);
    }

    private static final byte takeLowestOneBit(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    private static final short takeLowestOneBit(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
