package org.luaj.vm2;

/* loaded from: classes10.dex */
public final class Buffer {
    private static final int DEFAULT_CAPACITY = 64;
    private static final byte[] NOBYTES = new byte[0];
    private byte[] bytes;
    private int length;
    private int offset;
    private LuaValue value;

    public Buffer() {
        this(64);
    }

    public Buffer(int i) {
        this.bytes = new byte[i];
        this.length = 0;
        this.offset = 0;
        this.value = null;
    }

    public Buffer(LuaValue luaValue) {
        this.bytes = NOBYTES;
        this.offset = 0;
        this.length = 0;
        this.value = luaValue;
    }

    private final void realloc(int i, int i2) {
        if (i != this.bytes.length) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.bytes, this.offset, bArr, i2, this.length);
            this.bytes = bArr;
            this.offset = i2;
        }
    }

    public final Buffer append(byte b) {
        makeroom(0, 1);
        byte[] bArr = this.bytes;
        int i = this.offset;
        int i2 = this.length;
        this.length = i2 + 1;
        bArr[i + i2] = b;
        return this;
    }

    public final Buffer append(String str) {
        char[] charArray = str.toCharArray();
        int lengthAsUtf8 = LuaString.lengthAsUtf8(charArray);
        makeroom(0, lengthAsUtf8);
        LuaString.encodeToUtf8(charArray, charArray.length, this.bytes, this.offset + this.length);
        this.length += lengthAsUtf8;
        return this;
    }

    public final Buffer append(LuaString luaString) {
        int i = luaString.m_length;
        makeroom(0, i);
        luaString.copyInto(0, this.bytes, this.offset + this.length, i);
        this.length += i;
        return this;
    }

    public final Buffer append(LuaValue luaValue) {
        append(luaValue.strvalue());
        return this;
    }

    public Buffer concatTo(LuaNumber luaNumber) {
        return (this.value == null || this.value.isstring()) ? prepend(luaNumber.strvalue()) : setvalue(luaNumber.concat(this.value));
    }

    public Buffer concatTo(LuaString luaString) {
        return (this.value == null || this.value.isstring()) ? prepend(luaString) : setvalue(luaString.concat(this.value));
    }

    public Buffer concatTo(LuaValue luaValue) {
        return setvalue(luaValue.concat(value()));
    }

    public final void makeroom(int i, int i2) {
        if (this.value != null) {
            LuaString strvalue = this.value.strvalue();
            this.value = null;
            this.length = strvalue.m_length;
            this.offset = i;
            this.bytes = new byte[i + this.length + i2];
            System.arraycopy(strvalue.m_bytes, strvalue.m_offset, this.bytes, this.offset, this.length);
            return;
        }
        if (this.offset + this.length + i2 > this.bytes.length || this.offset < i) {
            int i3 = this.length + i + i2;
            if (i3 < 32) {
                i3 = 32;
            } else if (i3 < this.length * 2) {
                i3 = this.length * 2;
            }
            realloc(i3, i == 0 ? 0 : (i3 - this.length) - i2);
        }
    }

    public Buffer prepend(LuaString luaString) {
        int i = luaString.m_length;
        makeroom(i, 0);
        System.arraycopy(luaString.m_bytes, luaString.m_offset, this.bytes, this.offset - i, i);
        this.offset -= i;
        this.length += i;
        this.value = null;
        return this;
    }

    public Buffer setvalue(LuaValue luaValue) {
        this.bytes = NOBYTES;
        this.length = 0;
        this.offset = 0;
        this.value = luaValue;
        return this;
    }

    public String toString() {
        return tojstring();
    }

    public String tojstring() {
        return value().tojstring();
    }

    public final LuaString tostring() {
        realloc(this.length, 0);
        return LuaString.valueOf(this.bytes, this.offset, this.length);
    }

    public LuaValue value() {
        return this.value != null ? this.value : tostring();
    }
}
