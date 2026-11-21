package org.luaj.vm2.compiler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.luaj.vm2.LoadState;
import org.luaj.vm2.LocVars;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;

/* loaded from: classes10.dex */
public class DumpState {
    public static boolean ALLOW_INTEGER_CASTING = false;
    public static final int NUMBER_FORMAT_DEFAULT = 0;
    public static final int NUMBER_FORMAT_FLOATS_OR_DOUBLES = 0;
    public static final int NUMBER_FORMAT_INTS_ONLY = 1;
    public static final int NUMBER_FORMAT_NUM_PATCH_INT32 = 4;
    private static final int SIZEOF_INSTRUCTION = 4;
    private static final int SIZEOF_INT = 4;
    private static final int SIZEOF_SIZET = 4;
    private boolean IS_LITTLE_ENDIAN = false;
    private int NUMBER_FORMAT = 0;
    private int SIZEOF_LUA_NUMBER = 8;
    int status = 0;
    boolean strip;
    DataOutputStream writer;

    public DumpState(OutputStream outputStream, boolean z) {
        this.writer = new DataOutputStream(outputStream);
        this.strip = z;
    }

    public static int dump(Prototype prototype, OutputStream outputStream, boolean z) throws IOException {
        DumpState dumpState = new DumpState(outputStream, z);
        dumpState.dumpHeader();
        dumpState.dumpFunction(prototype);
        return dumpState.status;
    }

    public static int dump(Prototype prototype, OutputStream outputStream, boolean z, int i, boolean z2) throws IOException {
        switch (i) {
            case 0:
            case 1:
            case 4:
                DumpState dumpState = new DumpState(outputStream, z);
                dumpState.IS_LITTLE_ENDIAN = z2;
                dumpState.NUMBER_FORMAT = i;
                dumpState.SIZEOF_LUA_NUMBER = i == 1 ? 4 : 8;
                dumpState.dumpHeader();
                dumpState.dumpFunction(prototype);
                return dumpState.status;
            case 2:
            case 3:
            default:
                throw new IllegalArgumentException(new StringBuffer().append("number format not supported: ").append(i).toString());
        }
    }

    void dumpBlock(byte[] bArr, int i) throws IOException {
        this.writer.write(bArr, 0, i);
    }

    void dumpChar(int i) throws IOException {
        this.writer.write(i);
    }

    void dumpCode(Prototype prototype) throws IOException {
        int[] iArr = prototype.code;
        dumpInt(iArr.length);
        for (int i : iArr) {
            dumpInt(i);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003c. Please report as an issue. */
    void dumpConstants(Prototype prototype) throws IOException {
        DataOutputStream dataOutputStream;
        LuaValue[] luaValueArr = prototype.k;
        dumpInt(luaValueArr.length);
        for (LuaValue luaValue : luaValueArr) {
            switch (luaValue.type()) {
                case 0:
                    this.writer.write(0);
                    break;
                case 1:
                    this.writer.write(1);
                    dumpChar(luaValue.toboolean() ? 1 : 0);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException(new StringBuffer().append("bad type for ").append(luaValue).toString());
                case 3:
                    int i = 3;
                    switch (this.NUMBER_FORMAT) {
                        case 0:
                            this.writer.write(3);
                            dumpDouble(luaValue.todouble());
                            break;
                        case 1:
                            if (!ALLOW_INTEGER_CASTING && !luaValue.isint()) {
                                throw new IllegalArgumentException(new StringBuffer().append("not an integer: ").append(luaValue).toString());
                            }
                            dataOutputStream = this.writer;
                            dataOutputStream.write(i);
                            dumpInt(luaValue.toint());
                            break;
                        case 2:
                        case 3:
                        default:
                            throw new IllegalArgumentException(new StringBuffer().append("number format not supported: ").append(this.NUMBER_FORMAT).toString());
                        case 4:
                            if (luaValue.isint()) {
                                dataOutputStream = this.writer;
                                i = -2;
                                dataOutputStream.write(i);
                                dumpInt(luaValue.toint());
                                break;
                            }
                            this.writer.write(3);
                            dumpDouble(luaValue.todouble());
                            break;
                    }
                case 4:
                    this.writer.write(4);
                    dumpString((LuaString) luaValue);
                    break;
            }
        }
        int length = prototype.p.length;
        dumpInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            dumpFunction(prototype.p[i2]);
        }
    }

    void dumpDebug(Prototype prototype) throws IOException {
        if (this.strip) {
            dumpInt(0);
        } else {
            dumpString(prototype.source);
        }
        int length = this.strip ? 0 : prototype.lineinfo.length;
        dumpInt(length);
        for (int i = 0; i < length; i++) {
            dumpInt(prototype.lineinfo[i]);
        }
        int length2 = this.strip ? 0 : prototype.locvars.length;
        dumpInt(length2);
        for (int i2 = 0; i2 < length2; i2++) {
            LocVars locVars = prototype.locvars[i2];
            dumpString(locVars.varname);
            dumpInt(locVars.startpc);
            dumpInt(locVars.endpc);
        }
        int length3 = this.strip ? 0 : prototype.upvalues.length;
        dumpInt(length3);
        for (int i3 = 0; i3 < length3; i3++) {
            dumpString(prototype.upvalues[i3].name);
        }
    }

    void dumpDouble(double d) throws IOException {
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (!this.IS_LITTLE_ENDIAN) {
            this.writer.writeLong(doubleToLongBits);
        } else {
            dumpInt((int) doubleToLongBits);
            dumpInt((int) (doubleToLongBits >> 32));
        }
    }

    void dumpFunction(Prototype prototype) throws IOException {
        dumpInt(prototype.linedefined);
        dumpInt(prototype.lastlinedefined);
        dumpChar(prototype.numparams);
        dumpChar(prototype.is_vararg);
        dumpChar(prototype.maxstacksize);
        dumpCode(prototype);
        dumpConstants(prototype);
        dumpUpvalues(prototype);
        dumpDebug(prototype);
    }

    void dumpHeader() throws IOException {
        this.writer.write(LoadState.LUA_SIGNATURE);
        this.writer.write(82);
        this.writer.write(0);
        this.writer.write(this.IS_LITTLE_ENDIAN ? 1 : 0);
        this.writer.write(4);
        this.writer.write(4);
        this.writer.write(4);
        this.writer.write(this.SIZEOF_LUA_NUMBER);
        this.writer.write(this.NUMBER_FORMAT);
        this.writer.write(LoadState.LUAC_TAIL);
    }

    void dumpInt(int i) throws IOException {
        if (!this.IS_LITTLE_ENDIAN) {
            this.writer.writeInt(i);
            return;
        }
        this.writer.writeByte(i & 255);
        this.writer.writeByte((i >> 8) & 255);
        this.writer.writeByte((i >> 16) & 255);
        this.writer.writeByte((i >> 24) & 255);
    }

    void dumpString(LuaString luaString) throws IOException {
        int i = luaString.len().toint();
        dumpInt(i + 1);
        luaString.write(this.writer, 0, i);
        this.writer.write(0);
    }

    void dumpUpvalues(Prototype prototype) throws IOException {
        int length = prototype.upvalues.length;
        dumpInt(length);
        for (int i = 0; i < length; i++) {
            this.writer.writeByte(prototype.upvalues[i].instack ? 1 : 0);
            this.writer.writeByte(prototype.upvalues[i].idx);
        }
    }
}
