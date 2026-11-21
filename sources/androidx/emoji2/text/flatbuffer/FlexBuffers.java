package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    /* loaded from: classes.dex */
    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.access$000(), 1, 1);

        Blob(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.bb.data());
            wrap.position(this.end);
            wrap.limit(this.end + size());
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i) {
            if (i < 0 || i > size()) {
                throw new AssertionError();
            }
            return this.bb.get(this.end + i);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = this.bb.get(this.end + i);
            }
            return bArr;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.bb.getString(this.end, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append(Typography.quote);
            sb.append(this.bb.getString(this.end, size()));
            return sb.append(Typography.quote);
        }
    }

    /* loaded from: classes.dex */
    public static class FlexBufferException extends RuntimeException {
        /* JADX INFO: Access modifiers changed from: package-private */
        public FlexBufferException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static class Key extends Object {
        private static final Key EMPTY = new Key(FlexBuffers.access$000(), 0, 0);

        Key(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        static /* synthetic */ Key access$700() {
            return EMPTY;
        }

        public static Key empty() {
            return EMPTY;
        }

        int compareTo(byte[] bArr) {
            byte b;
            byte b2;
            int i = this.end;
            int i2 = 0;
            do {
                b = this.bb.get(i);
                b2 = bArr[i2];
                if (b == 0) {
                    return b - b2;
                }
                i++;
                i2++;
                if (i2 == bArr.length) {
                    return b - b2;
                }
            } while (b == b2);
            return b - b2;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof Key) && ((Key) obj).end == this.end && ((Key) obj).byteWidth == this.byteWidth;
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int i = this.end;
            while (this.bb.get(i) != 0) {
                i++;
            }
            return this.bb.getString(this.end, i - this.end);
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            return sb.append(toString());
        }
    }

    /* loaded from: classes.dex */
    public static class KeyVector {
        private final TypedVector vec;

        KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i) {
            if (i >= size()) {
                return Key.access$700();
            }
            return new Key(this.vec.bb, FlexBuffers.access$200(this.vec.bb, this.vec.end + (this.vec.byteWidth * i), this.vec.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < this.vec.size(); i++) {
                this.vec.get(i).toString(sb);
                if (i != this.vec.size() - 1) {
                    sb.append(", ");
                }
            }
            return sb.append("]").toString();
        }
    }

    /* loaded from: classes.dex */
    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.access$000(), 1, 1);

        Map(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        private int binarySearch(KeyVector keyVector, byte[] bArr) {
            int i = 0;
            int size = keyVector.size() - 1;
            while (i <= size) {
                int i2 = (i + size) >>> 1;
                int compareTo = keyVector.get(i2).compareTo(bArr);
                if (compareTo < 0) {
                    i = i2 + 1;
                } else {
                    if (compareTo <= 0) {
                        return i2;
                    }
                    size = i2 - 1;
                }
            }
            return -(i + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public Reference get(byte[] bArr) {
            KeyVector keys = keys();
            int size = keys.size();
            int binarySearch = binarySearch(keys, bArr);
            return (binarySearch < 0 || binarySearch >= size) ? Reference.access$600() : get(binarySearch);
        }

        public KeyVector keys() {
            int i = this.end - (this.byteWidth * 3);
            return new KeyVector(new TypedVector(this.bb, FlexBuffers.access$200(this.bb, i, this.byteWidth), FlexBuffers.access$100(this.bb, this.byteWidth + i, this.byteWidth), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append("{ ");
            KeyVector keys = keys();
            int size = size();
            Vector values = values();
            for (int i = 0; i < size; i++) {
                sb.append(Typography.quote).append(keys.get(i).toString()).append("\" : ");
                sb.append(values.get(i).toString());
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        public Vector values() {
            return new Vector(this.bb, this.end, this.byteWidth);
        }
    }

    /* loaded from: classes.dex */
    private static abstract class Object {
        ReadBuf bb;
        int byteWidth;
        int end;

        Object(ReadBuf readBuf, int i, int i2) {
            this.bb = readBuf;
            this.end = i;
            this.byteWidth = i2;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb);
    }

    /* loaded from: classes.dex */
    public static class Reference {
        private static final Reference NULL_REFERENCE = new Reference(FlexBuffers.access$000(), 0, 1, 0);
        private ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        Reference(ReadBuf readBuf, int i, int i2, int i3) {
            this(readBuf, i, i2, 1 << (i3 & 3), i3 >> 2);
        }

        Reference(ReadBuf readBuf, int i, int i2, int i3, int i4) {
            this.bb = readBuf;
            this.end = i;
            this.parentWidth = i2;
            this.byteWidth = i3;
            this.type = i4;
        }

        static /* synthetic */ Reference access$600() {
            return NULL_REFERENCE;
        }

        public Blob asBlob() {
            return (isBlob() || isString()) ? new Blob(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth) : Blob.empty();
        }

        public boolean asBoolean() {
            return isBoolean() ? this.bb.get(this.end) != 0 : asUInt() != 0;
        }

        public double asFloat() {
            if (this.type == 3) {
                return FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
            }
            switch (this.type) {
                case 0:
                    return 0.0d;
                case 1:
                    return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
                case 2:
                case 26:
                    return FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
                case 5:
                    return Double.parseDouble(asString());
                case 6:
                    return FlexBuffers.access$100(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 7:
                    return FlexBuffers.access$300(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 8:
                    return FlexBuffers.access$400(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 10:
                    return asVector().size();
                default:
                    return 0.0d;
            }
        }

        public int asInt() {
            if (this.type == 1) {
                return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
            }
            switch (this.type) {
                case 0:
                    return 0;
                case 2:
                    return (int) FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
                case 3:
                    return (int) FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
                case 5:
                    return Integer.parseInt(asString());
                case 6:
                    return FlexBuffers.access$100(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 7:
                    return (int) FlexBuffers.access$300(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.parentWidth);
                case 8:
                    return (int) FlexBuffers.access$400(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 10:
                    return asVector().size();
                case 26:
                    return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
                default:
                    return 0;
            }
        }

        public Key asKey() {
            return isKey() ? new Key(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth) : Key.empty();
        }

        public long asLong() {
            if (this.type == 1) {
                return FlexBuffers.access$500(this.bb, this.end, this.parentWidth);
            }
            switch (this.type) {
                case 0:
                    return 0L;
                case 2:
                    return FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
                case 3:
                    return (long) FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
                case 5:
                    try {
                        return Long.parseLong(asString());
                    } catch (NumberFormatException e) {
                        return 0L;
                    }
                case 6:
                    return FlexBuffers.access$500(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 7:
                    return FlexBuffers.access$300(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.parentWidth);
                case 8:
                    return (long) FlexBuffers.access$400(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 10:
                    return asVector().size();
                case 26:
                    return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
                default:
                    return 0L;
            }
        }

        public Map asMap() {
            return isMap() ? new Map(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth) : Map.empty();
        }

        public String asString() {
            if (isString()) {
                int access$200 = FlexBuffers.access$200(this.bb, this.end, this.parentWidth);
                return this.bb.getString(access$200, (int) FlexBuffers.access$300(this.bb, access$200 - this.byteWidth, this.byteWidth));
            }
            if (!isKey()) {
                return "";
            }
            int access$2002 = FlexBuffers.access$200(this.bb, this.end, this.byteWidth);
            int i = access$2002;
            while (this.bb.get(i) != 0) {
                i++;
            }
            return this.bb.getString(access$2002, i - access$2002);
        }

        public long asUInt() {
            if (this.type == 2) {
                return FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
            }
            switch (this.type) {
                case 0:
                    return 0L;
                case 1:
                    return FlexBuffers.access$500(this.bb, this.end, this.parentWidth);
                case 3:
                    return (long) FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
                case 5:
                    return Long.parseLong(asString());
                case 6:
                    return FlexBuffers.access$500(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 7:
                    return FlexBuffers.access$300(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 8:
                    return (long) FlexBuffers.access$400(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.parentWidth);
                case 10:
                    return asVector().size();
                case 26:
                    return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
                default:
                    return 0L;
            }
        }

        public Vector asVector() {
            return isVector() ? new Vector(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth) : this.type == 15 ? new TypedVector(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth, 4) : FlexBuffers.isTypedVector(this.type) ? new TypedVector(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type)) : Vector.empty();
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isFloat() {
            return this.type == 3 || this.type == 8;
        }

        public boolean isInt() {
            return this.type == 1 || this.type == 6;
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            return this.type == 2 || this.type == 7;
        }

        public boolean isVector() {
            return this.type == 10 || this.type == 9;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        StringBuilder toString(StringBuilder sb) {
            switch (this.type) {
                case 0:
                    return sb.append("null");
                case 1:
                case 6:
                    return sb.append(asLong());
                case 2:
                case 7:
                    return sb.append(asUInt());
                case 3:
                case 8:
                    return sb.append(asFloat());
                case 4:
                    return asKey().toString(sb.append(Typography.quote)).append(Typography.quote);
                case 5:
                    return sb.append(Typography.quote).append(asString()).append(Typography.quote);
                case 9:
                    return asMap().toString(sb);
                case 10:
                    return asVector().toString(sb);
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 36:
                    return sb.append(asVector());
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    throw new FlexBufferException("not_implemented:" + this.type);
                case 25:
                    return asBlob().toString(sb);
                case 26:
                    return sb.append(asBoolean());
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                default:
                    return sb;
            }
        }
    }

    /* loaded from: classes.dex */
    private static abstract class Sized extends Object {
        protected final int size;

        Sized(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
            this.size = FlexBuffers.access$100(this.bb, i - i2, i2);
        }

        public int size() {
            return this.size;
        }
    }

    /* loaded from: classes.dex */
    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.access$000(), 1, 1, 1);
        private final int elemType;

        TypedVector(ReadBuf readBuf, int i, int i2, int i3) {
            super(readBuf, i, i2);
            this.elemType = i3;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int i) {
            if (i >= size()) {
                return Reference.access$600();
            }
            return new Reference(this.bb, this.end + (this.byteWidth * i), this.byteWidth, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }
    }

    /* loaded from: classes.dex */
    static class Unsigned {
        Unsigned() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int byteToUnsignedInt(byte b) {
            return b & UByte.MAX_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static long intToUnsignedLong(int i) {
            return i & 4294967295L;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int shortToUnsignedInt(short s) {
            return 65535 & s;
        }
    }

    /* loaded from: classes.dex */
    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.access$000(), 1, 1);

        Vector(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i) {
            long size = size();
            if (i >= size) {
                return Reference.access$600();
            }
            return new Reference(this.bb, this.end + (this.byteWidth * i), this.byteWidth, Unsigned.byteToUnsignedInt(this.bb.get((int) (this.end + (this.byteWidth * size) + i))));
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append("[ ");
            int size = size();
            for (int i = 0; i < size; i++) {
                get(i).toString(sb);
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }
    }

    static /* synthetic */ ReadBuf access$000() {
        return EMPTY_BB;
    }

    static /* synthetic */ int access$100(ReadBuf readBuf, int i, int i2) {
        return readInt(readBuf, i, i2);
    }

    static /* synthetic */ int access$200(ReadBuf readBuf, int i, int i2) {
        return indirect(readBuf, i, i2);
    }

    static /* synthetic */ long access$300(ReadBuf readBuf, int i, int i2) {
        return readUInt(readBuf, i, i2);
    }

    static /* synthetic */ double access$400(ReadBuf readBuf, int i, int i2) {
        return readDouble(readBuf, i, i2);
    }

    static /* synthetic */ long access$500(ReadBuf readBuf, int i, int i2) {
        return readLong(readBuf, i, i2);
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int limit = readBuf.limit() - 1;
        byte b = readBuf.get(limit);
        int i = limit - 1;
        return new Reference(readBuf, i - b, b, Unsigned.byteToUnsignedInt(readBuf.get(i)));
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    private static int indirect(ReadBuf readBuf, int i, int i2) {
        return (int) (i - readUInt(readBuf, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isTypeInline(int i) {
        return i <= 3 || i == 26;
    }

    static boolean isTypedVector(int i) {
        return (i >= 11 && i <= 15) || i == 36;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isTypedVectorElementType(int i) {
        return (i >= 1 && i <= 4) || i == 26;
    }

    private static double readDouble(ReadBuf readBuf, int i, int i2) {
        switch (i2) {
            case 4:
                return readBuf.getFloat(i);
            case 8:
                return readBuf.getDouble(i);
            default:
                return -1.0d;
        }
    }

    private static int readInt(ReadBuf readBuf, int i, int i2) {
        return (int) readLong(readBuf, i, i2);
    }

    private static long readLong(ReadBuf readBuf, int i, int i2) {
        switch (i2) {
            case 1:
                return readBuf.get(i);
            case 2:
                return readBuf.getShort(i);
            case 4:
                return readBuf.getInt(i);
            case 8:
                return readBuf.getLong(i);
            default:
                return -1L;
        }
    }

    private static long readUInt(ReadBuf readBuf, int i, int i2) {
        switch (i2) {
            case 1:
                return Unsigned.byteToUnsignedInt(readBuf.get(i));
            case 2:
                return Unsigned.shortToUnsignedInt(readBuf.getShort(i));
            case 4:
                return Unsigned.intToUnsignedLong(readBuf.getInt(i));
            case 8:
                return readBuf.getLong(i);
            default:
                return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int toTypedVector(int i, int i2) {
        if (!isTypedVectorElementType(i)) {
            throw new AssertionError();
        }
        switch (i2) {
            case 0:
                return (i - 1) + 11;
            case 1:
            default:
                throw new AssertionError();
            case 2:
                return (i - 1) + 16;
            case 3:
                return (i - 1) + 19;
            case 4:
                return (i - 1) + 22;
        }
    }

    static int toTypedVectorElementType(int i) {
        return (i - 11) + 1;
    }
}
