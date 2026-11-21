package org.luaj.vm2;

/* loaded from: classes10.dex */
public class LuaClosure extends LuaFunction {
    private static final UpValue[] NOUPVALUES = new UpValue[0];
    final Globals globals;
    public final Prototype p;
    public UpValue[] upValues;

    public LuaClosure(Prototype prototype, LuaValue luaValue) {
        this.p = prototype;
        if (prototype.upvalues == null || prototype.upvalues.length == 0) {
            this.upValues = NOUPVALUES;
        } else {
            this.upValues = new UpValue[prototype.upvalues.length];
            this.upValues[0] = new UpValue(new LuaValue[]{luaValue}, 0);
        }
        this.globals = luaValue instanceof Globals ? (Globals) luaValue : null;
    }

    private UpValue findupval(LuaValue[] luaValueArr, short s, UpValue[] upValueArr) {
        int length = upValueArr.length;
        for (int i = 0; i < length; i++) {
            if (upValueArr[i] != null && upValueArr[i].index == s) {
                return upValueArr[i];
            }
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (upValueArr[i2] == null) {
                UpValue upValue = new UpValue(luaValueArr, s);
                upValueArr[i2] = upValue;
                return upValue;
            }
        }
        error("No space for upvalue");
        return null;
    }

    private void processErrorHooks(LuaError luaError, Prototype prototype, int i) {
        String str = "?";
        StringBuffer append = new StringBuffer().append(prototype.source != null ? prototype.source.tojstring() : "?").append(":");
        if (prototype.lineinfo != null && i >= 0 && i < prototype.lineinfo.length) {
            str = String.valueOf(prototype.lineinfo[i]);
        }
        luaError.fileline = append.append(str).toString();
        luaError.traceback = errorHook(luaError.getMessage(), luaError.level);
    }

    @Override // org.luaj.vm2.LuaValue
    public final LuaValue call() {
        LuaValue[] luaValueArr = new LuaValue[this.p.maxstacksize];
        for (int i = 0; i < this.p.numparams; i++) {
            luaValueArr[i] = NIL;
        }
        return execute(luaValueArr, NONE).arg1();
    }

    @Override // org.luaj.vm2.LuaValue
    public final LuaValue call(LuaValue luaValue) {
        LuaValue[] luaValueArr = new LuaValue[this.p.maxstacksize];
        System.arraycopy(NILS, 0, luaValueArr, 0, this.p.maxstacksize);
        for (int i = 1; i < this.p.numparams; i++) {
            luaValueArr[i] = NIL;
        }
        switch (this.p.numparams) {
            case 0:
                break;
            default:
                luaValueArr[0] = luaValue;
                luaValue = NONE;
                break;
        }
        return execute(luaValueArr, luaValue).arg1();
    }

    @Override // org.luaj.vm2.LuaValue
    public final LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        Varargs varargsOf;
        Varargs execute;
        LuaValue[] luaValueArr = new LuaValue[this.p.maxstacksize];
        for (int i = 2; i < this.p.numparams; i++) {
            luaValueArr[i] = NIL;
        }
        switch (this.p.numparams) {
            case 0:
                if (this.p.is_vararg != 0) {
                    varargsOf = varargsOf(luaValue, luaValue2);
                    execute = execute(luaValueArr, varargsOf);
                    break;
                }
                varargsOf = NONE;
                execute = execute(luaValueArr, varargsOf);
            case 1:
                luaValueArr[0] = luaValue;
                execute = execute(luaValueArr, luaValue2);
                break;
            default:
                luaValueArr[0] = luaValue;
                luaValueArr[1] = luaValue2;
                varargsOf = NONE;
                execute = execute(luaValueArr, varargsOf);
                break;
        }
        return execute.arg1();
    }

    @Override // org.luaj.vm2.LuaValue
    public final LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        Varargs varargsOf;
        Varargs execute;
        LuaValue[] luaValueArr = new LuaValue[this.p.maxstacksize];
        for (int i = 3; i < this.p.numparams; i++) {
            luaValueArr[i] = NIL;
        }
        switch (this.p.numparams) {
            case 0:
                if (this.p.is_vararg != 0) {
                    varargsOf = varargsOf(luaValue, luaValue2, luaValue3);
                    execute = execute(luaValueArr, varargsOf);
                    break;
                }
                varargsOf = NONE;
                execute = execute(luaValueArr, varargsOf);
            case 1:
                luaValueArr[0] = luaValue;
                if (this.p.is_vararg != 0) {
                    varargsOf = varargsOf(luaValue2, luaValue3);
                    execute = execute(luaValueArr, varargsOf);
                    break;
                }
                varargsOf = NONE;
                execute = execute(luaValueArr, varargsOf);
            case 2:
                luaValueArr[0] = luaValue;
                luaValueArr[1] = luaValue2;
                execute = execute(luaValueArr, luaValue3);
                break;
            default:
                luaValueArr[0] = luaValue;
                luaValueArr[1] = luaValue2;
                luaValueArr[2] = luaValue3;
                varargsOf = NONE;
                execute = execute(luaValueArr, varargsOf);
                break;
        }
        return execute.arg1();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaClosure checkclosure() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    String errorHook(String str, int i) {
        String str2;
        if (this.globals == null) {
            return str;
        }
        LuaThread luaThread = this.globals.running;
        if (luaThread.errorfunc == null) {
            return this.globals.debuglib != null ? new StringBuffer().append(str).append("\n").append(this.globals.debuglib.traceback(i)).toString() : str;
        }
        LuaValue luaValue = luaThread.errorfunc;
        luaThread.errorfunc = null;
        try {
            str2 = luaValue.call(LuaValue.valueOf(str)).tojstring();
        } catch (Throwable th) {
            str2 = "error in error handling";
        }
        luaThread.errorfunc = luaValue;
        return str2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0051. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:81:0x0371. Please report as an issue. */
    protected Varargs execute(LuaValue[] luaValueArr, Varargs varargs) {
        LuaValue value;
        LuaValue luaValue;
        LuaValue luaValue2;
        LuaValue luaValue3;
        LuaValue luaValue4;
        Varargs invoke;
        Varargs varargsOf;
        Varargs varargs2 = varargs;
        Varargs varargs3 = NONE;
        int[] iArr = this.p.code;
        LuaValue[] luaValueArr2 = this.p.k;
        UpValue[] upValueArr = this.p.p.length > 0 ? new UpValue[luaValueArr.length] : null;
        if (this.globals != null && this.globals.debuglib != null) {
            this.globals.debuglib.onCall(this, varargs2, luaValueArr);
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                try {
                    try {
                        if (this.globals != null && this.globals.debuglib != null) {
                            this.globals.debuglib.onInstruction(i, varargs3, i2);
                        }
                        int i3 = iArr[i];
                        int i4 = (i3 >> 6) & 255;
                        int i5 = i3 & 63;
                        switch (i5) {
                            case 0:
                                luaValueArr[i4] = luaValueArr[i3 >>> 23];
                                i++;
                                varargs2 = varargs;
                            case 1:
                                luaValueArr[i4] = luaValueArr2[i3 >>> 14];
                                i++;
                                varargs2 = varargs;
                            case 2:
                            default:
                                throw new IllegalArgumentException(new StringBuffer().append("Illegal opcode: ").append(i5).toString());
                            case 3:
                                luaValueArr[i4] = (i3 >>> 23) != 0 ? LuaValue.TRUE : LuaValue.FALSE;
                                if ((i3 & Lua.MASK_C) == 0) {
                                    i++;
                                    varargs2 = varargs;
                                }
                                i++;
                                i++;
                                varargs2 = varargs;
                            case 4:
                                int i6 = i3 >>> 23;
                                while (true) {
                                    int i7 = i6 - 1;
                                    if (i6 >= 0) {
                                        luaValueArr[i4] = LuaValue.NIL;
                                        i6 = i7;
                                        i4++;
                                    }
                                }
                                i++;
                                varargs2 = varargs;
                                break;
                            case 5:
                                luaValueArr[i4] = this.upValues[i3 >>> 23].getValue();
                                i++;
                                varargs2 = varargs;
                            case 6:
                                LuaValue value2 = this.upValues[i3 >>> 23].getValue();
                                int i8 = (i3 >> 14) & 511;
                                luaValueArr[i4] = value2.get(i8 > 255 ? luaValueArr2[i8 & 255] : luaValueArr[i8]);
                                i++;
                                varargs2 = varargs;
                            case 7:
                                LuaValue luaValue5 = luaValueArr[i3 >>> 23];
                                int i9 = (i3 >> 14) & 511;
                                luaValueArr[i4] = luaValue5.get(i9 > 255 ? luaValueArr2[i9 & 255] : luaValueArr[i9]);
                                i++;
                                varargs2 = varargs;
                            case 8:
                                value = this.upValues[i4].getValue();
                                int i10 = i3 >>> 23;
                                luaValue = i10 > 255 ? luaValueArr2[i10 & 255] : luaValueArr[i10];
                                int i11 = (i3 >> 14) & 511;
                                luaValue2 = i11 > 255 ? luaValueArr2[i11 & 255] : luaValueArr[i11];
                                value.set(luaValue, luaValue2);
                                i++;
                                varargs2 = varargs;
                            case 9:
                                this.upValues[i3 >>> 23].setValue(luaValueArr[i4]);
                                i++;
                                varargs2 = varargs;
                            case 10:
                                value = luaValueArr[i4];
                                int i12 = i3 >>> 23;
                                luaValue = i12 > 255 ? luaValueArr2[i12 & 255] : luaValueArr[i12];
                                int i13 = (i3 >> 14) & 511;
                                luaValue2 = i13 > 255 ? luaValueArr2[i13 & 255] : luaValueArr[i13];
                                value.set(luaValue, luaValue2);
                                i++;
                                varargs2 = varargs;
                            case 11:
                                luaValueArr[i4] = new LuaTable(i3 >>> 23, (i3 >> 14) & 511);
                                i++;
                                varargs2 = varargs;
                            case 12:
                                LuaValue luaValue6 = luaValueArr[i3 >>> 23];
                                luaValueArr[i4 + 1] = luaValue6;
                                int i14 = (i3 >> 14) & 511;
                                luaValueArr[i4] = luaValue6.get(i14 > 255 ? luaValueArr2[i14 & 255] : luaValueArr[i14]);
                                i++;
                                varargs2 = varargs;
                            case 13:
                                int i15 = i3 >>> 23;
                                int i16 = (i3 >> 14) & 511;
                                luaValueArr[i4] = (i15 > 255 ? luaValueArr2[i15 & 255] : luaValueArr[i15]).add(i16 > 255 ? luaValueArr2[i16 & 255] : luaValueArr[i16]);
                                i++;
                                varargs2 = varargs;
                            case 14:
                                int i17 = i3 >>> 23;
                                int i18 = (i3 >> 14) & 511;
                                luaValueArr[i4] = (i17 > 255 ? luaValueArr2[i17 & 255] : luaValueArr[i17]).sub(i18 > 255 ? luaValueArr2[i18 & 255] : luaValueArr[i18]);
                                i++;
                                varargs2 = varargs;
                            case 15:
                                int i19 = i3 >>> 23;
                                int i20 = (i3 >> 14) & 511;
                                luaValueArr[i4] = (i19 > 255 ? luaValueArr2[i19 & 255] : luaValueArr[i19]).mul(i20 > 255 ? luaValueArr2[i20 & 255] : luaValueArr[i20]);
                                i++;
                                varargs2 = varargs;
                            case 16:
                                int i21 = i3 >>> 23;
                                int i22 = (i3 >> 14) & 511;
                                luaValueArr[i4] = (i21 > 255 ? luaValueArr2[i21 & 255] : luaValueArr[i21]).div(i22 > 255 ? luaValueArr2[i22 & 255] : luaValueArr[i22]);
                                i++;
                                varargs2 = varargs;
                            case 17:
                                int i23 = i3 >>> 23;
                                int i24 = (i3 >> 14) & 511;
                                luaValueArr[i4] = (i23 > 255 ? luaValueArr2[i23 & 255] : luaValueArr[i23]).mod(i24 > 255 ? luaValueArr2[i24 & 255] : luaValueArr[i24]);
                                i++;
                                varargs2 = varargs;
                            case 18:
                                int i25 = i3 >>> 23;
                                int i26 = (i3 >> 14) & 511;
                                luaValueArr[i4] = (i25 > 255 ? luaValueArr2[i25 & 255] : luaValueArr[i25]).pow(i26 > 255 ? luaValueArr2[i26 & 255] : luaValueArr[i26]);
                                i++;
                                varargs2 = varargs;
                            case 19:
                                luaValueArr[i4] = luaValueArr[i3 >>> 23].neg();
                                i++;
                                varargs2 = varargs;
                            case 20:
                                luaValueArr[i4] = luaValueArr[i3 >>> 23].not();
                                i++;
                                varargs2 = varargs;
                            case 21:
                                luaValueArr[i4] = luaValueArr[i3 >>> 23].len();
                                i++;
                                varargs2 = varargs;
                            case 22:
                                int i27 = i3 >>> 23;
                                int i28 = (i3 >> 14) & 511;
                                if (i28 > i27 + 1) {
                                    Buffer buffer = luaValueArr[i28].buffer();
                                    while (true) {
                                        i28--;
                                        if (i28 >= i27) {
                                            buffer = luaValueArr[i28].concat(buffer);
                                        } else {
                                            luaValueArr[i4] = buffer.value();
                                        }
                                    }
                                } else {
                                    luaValueArr[i4] = luaValueArr[i28 - 1].concat(luaValueArr[i28]);
                                }
                                i++;
                                varargs2 = varargs;
                            case 23:
                                i += (i3 >>> 14) - Lua.MAXARG_sBx;
                                if (i4 > 0) {
                                    int i29 = i4 - 1;
                                    int length = upValueArr.length;
                                    while (true) {
                                        length--;
                                        if (length >= 0) {
                                            if (upValueArr[length] != null && upValueArr[length].index >= i29) {
                                                upValueArr[length].close();
                                                upValueArr[length] = null;
                                            }
                                        }
                                    }
                                }
                                i++;
                                varargs2 = varargs;
                                break;
                            case 24:
                                int i30 = i3 >>> 23;
                                int i31 = (i3 >> 14) & 511;
                                if ((i30 > 255 ? luaValueArr2[i30 & 255] : luaValueArr[i30]).eq_b(i31 > 255 ? luaValueArr2[i31 & 255] : luaValueArr[i31]) != (i4 != 0)) {
                                    i++;
                                    i++;
                                    varargs2 = varargs;
                                } else {
                                    i++;
                                    varargs2 = varargs;
                                }
                            case 25:
                                int i32 = i3 >>> 23;
                                int i33 = (i3 >> 14) & 511;
                                if ((i32 > 255 ? luaValueArr2[i32 & 255] : luaValueArr[i32]).lt_b(i33 > 255 ? luaValueArr2[i33 & 255] : luaValueArr[i33]) != (i4 != 0)) {
                                    i++;
                                    i++;
                                    varargs2 = varargs;
                                } else {
                                    i++;
                                    varargs2 = varargs;
                                }
                            case 26:
                                int i34 = i3 >>> 23;
                                int i35 = (i3 >> 14) & 511;
                                if ((i34 > 255 ? luaValueArr2[i34 & 255] : luaValueArr[i34]).lteq_b(i35 > 255 ? luaValueArr2[i35 & 255] : luaValueArr[i35]) != (i4 != 0)) {
                                    i++;
                                    i++;
                                    varargs2 = varargs;
                                } else {
                                    i++;
                                    varargs2 = varargs;
                                }
                            case 27:
                                if (luaValueArr[i4].toboolean() != ((i3 & Lua.MASK_C) != 0)) {
                                    i++;
                                    i++;
                                    varargs2 = varargs;
                                } else {
                                    i++;
                                    varargs2 = varargs;
                                }
                            case 28:
                                LuaValue luaValue7 = luaValueArr[i3 >>> 23];
                                if (luaValue7.toboolean() == ((i3 & Lua.MASK_C) != 0)) {
                                    luaValueArr[i4] = luaValue7;
                                    i++;
                                    varargs2 = varargs;
                                }
                                i++;
                                i++;
                                varargs2 = varargs;
                            case 29:
                                switch (i3 & Lua.MASK_Bx) {
                                    case 8388608:
                                        luaValue3 = luaValueArr[i4];
                                        luaValue4 = NONE;
                                        invoke = luaValue3.invoke(luaValue4);
                                        i2 = i4 + invoke.narg();
                                        varargs3 = invoke;
                                        break;
                                    case 8404992:
                                        luaValueArr[i4].call();
                                        break;
                                    case 8421376:
                                        luaValueArr[i4] = luaValueArr[i4].call();
                                        break;
                                    case 16777216:
                                        luaValue3 = luaValueArr[i4];
                                        luaValue4 = luaValueArr[i4 + 1];
                                        invoke = luaValue3.invoke(luaValue4);
                                        i2 = i4 + invoke.narg();
                                        varargs3 = invoke;
                                        break;
                                    case 16793600:
                                        luaValueArr[i4].call(luaValueArr[i4 + 1]);
                                        break;
                                    case 16809984:
                                        luaValueArr[i4] = luaValueArr[i4].call(luaValueArr[i4 + 1]);
                                        break;
                                    case 25182208:
                                        luaValueArr[i4].call(luaValueArr[i4 + 1], luaValueArr[i4 + 2]);
                                        break;
                                    case 25198592:
                                        luaValueArr[i4] = luaValueArr[i4].call(luaValueArr[i4 + 1], luaValueArr[i4 + 2]);
                                        break;
                                    case 33570816:
                                        luaValueArr[i4].call(luaValueArr[i4 + 1], luaValueArr[i4 + 2], luaValueArr[i4 + 3]);
                                        break;
                                    case 33587200:
                                        luaValueArr[i4] = luaValueArr[i4].call(luaValueArr[i4 + 1], luaValueArr[i4 + 2], luaValueArr[i4 + 3]);
                                        break;
                                    default:
                                        int i36 = i3 >>> 23;
                                        int i37 = (i3 >> 14) & 511;
                                        LuaValue luaValue8 = luaValueArr[i4];
                                        if (i36 > 0) {
                                            varargsOf = varargsOf(luaValueArr, i4 + 1, i36 - 1);
                                        } else {
                                            int i38 = i4 + 1;
                                            varargsOf = varargsOf(luaValueArr, i38, (i2 - varargs3.narg()) - i38, varargs3);
                                        }
                                        Varargs invoke2 = luaValue8.invoke(varargsOf);
                                        if (i37 > 0) {
                                            invoke2.copyto(luaValueArr, i4, i37 - 1);
                                            invoke = NONE;
                                        } else {
                                            i2 = i4 + invoke2.narg();
                                            invoke = invoke2.dealias();
                                        }
                                        varargs3 = invoke;
                                        break;
                                }
                                i++;
                                varargs2 = varargs;
                            case 30:
                                switch ((-8388608) & i3) {
                                    case 8388608:
                                        TailcallVarargs tailcallVarargs = new TailcallVarargs(luaValueArr[i4], NONE);
                                        if (upValueArr != null) {
                                            int length2 = upValueArr.length;
                                            while (true) {
                                                length2--;
                                                if (length2 >= 0) {
                                                    if (upValueArr[length2] != null) {
                                                        upValueArr[length2].close();
                                                    }
                                                }
                                            }
                                        }
                                        if (this.globals != null && this.globals.debuglib != null) {
                                            this.globals.debuglib.onReturn();
                                        }
                                        return tailcallVarargs;
                                    case 16777216:
                                        TailcallVarargs tailcallVarargs2 = new TailcallVarargs(luaValueArr[i4], luaValueArr[i4 + 1]);
                                        if (upValueArr != null) {
                                            int length3 = upValueArr.length;
                                            while (true) {
                                                length3--;
                                                if (length3 >= 0) {
                                                    if (upValueArr[length3] != null) {
                                                        upValueArr[length3].close();
                                                    }
                                                }
                                            }
                                        }
                                        if (this.globals != null && this.globals.debuglib != null) {
                                            this.globals.debuglib.onReturn();
                                        }
                                        return tailcallVarargs2;
                                    case 25165824:
                                        TailcallVarargs tailcallVarargs3 = new TailcallVarargs(luaValueArr[i4], varargsOf(luaValueArr[i4 + 1], luaValueArr[i4 + 2]));
                                        if (upValueArr != null) {
                                            int length4 = upValueArr.length;
                                            while (true) {
                                                length4--;
                                                if (length4 >= 0) {
                                                    if (upValueArr[length4] != null) {
                                                        upValueArr[length4].close();
                                                    }
                                                }
                                            }
                                        }
                                        if (this.globals != null && this.globals.debuglib != null) {
                                            this.globals.debuglib.onReturn();
                                        }
                                        return tailcallVarargs3;
                                    case 33554432:
                                        TailcallVarargs tailcallVarargs4 = new TailcallVarargs(luaValueArr[i4], varargsOf(luaValueArr[i4 + 1], luaValueArr[i4 + 2], luaValueArr[i4 + 3]));
                                        if (upValueArr != null) {
                                            int length5 = upValueArr.length;
                                            while (true) {
                                                length5--;
                                                if (length5 >= 0) {
                                                    if (upValueArr[length5] != null) {
                                                        upValueArr[length5].close();
                                                    }
                                                }
                                            }
                                        }
                                        if (this.globals != null && this.globals.debuglib != null) {
                                            this.globals.debuglib.onReturn();
                                        }
                                        return tailcallVarargs4;
                                    default:
                                        int i39 = i3 >>> 23;
                                        int i40 = i4 + 1;
                                        TailcallVarargs tailcallVarargs5 = new TailcallVarargs(luaValueArr[i4], i39 > 0 ? varargsOf(luaValueArr, i40, i39 - 1) : varargsOf(luaValueArr, i40, (i2 - varargs3.narg()) - i40, varargs3));
                                        if (upValueArr != null) {
                                            int length6 = upValueArr.length;
                                            while (true) {
                                                length6--;
                                                if (length6 >= 0) {
                                                    if (upValueArr[length6] != null) {
                                                        upValueArr[length6].close();
                                                    }
                                                }
                                            }
                                        }
                                        if (this.globals != null && this.globals.debuglib != null) {
                                            this.globals.debuglib.onReturn();
                                        }
                                        return tailcallVarargs5;
                                }
                            case 31:
                                int i41 = i3 >>> 23;
                                switch (i41) {
                                    case 0:
                                        Varargs varargsOf2 = varargsOf(luaValueArr, i4, (i2 - varargs3.narg()) - i4, varargs3);
                                        if (upValueArr != null) {
                                            int length7 = upValueArr.length;
                                            while (true) {
                                                length7--;
                                                if (length7 >= 0) {
                                                    if (upValueArr[length7] != null) {
                                                        upValueArr[length7].close();
                                                    }
                                                }
                                            }
                                        }
                                        if (this.globals != null && this.globals.debuglib != null) {
                                            this.globals.debuglib.onReturn();
                                        }
                                        return varargsOf2;
                                    case 1:
                                        LuaValue luaValue9 = NONE;
                                        if (upValueArr != null) {
                                            int length8 = upValueArr.length;
                                            while (true) {
                                                length8--;
                                                if (length8 >= 0) {
                                                    if (upValueArr[length8] != null) {
                                                        upValueArr[length8].close();
                                                    }
                                                }
                                            }
                                        }
                                        if (this.globals != null && this.globals.debuglib != null) {
                                            this.globals.debuglib.onReturn();
                                        }
                                        return luaValue9;
                                    case 2:
                                        if (upValueArr != null) {
                                            while (true) {
                                            }
                                        }
                                        return luaValueArr[i4];
                                    default:
                                        Varargs varargsOf3 = varargsOf(luaValueArr, i4, i41 - 1);
                                        if (upValueArr != null) {
                                            int length9 = upValueArr.length;
                                            while (true) {
                                                length9--;
                                                if (length9 >= 0) {
                                                    if (upValueArr[length9] != null) {
                                                        upValueArr[length9].close();
                                                    }
                                                }
                                            }
                                        }
                                        if (this.globals != null && this.globals.debuglib != null) {
                                            this.globals.debuglib.onReturn();
                                        }
                                        return varargsOf3;
                                }
                            case 32:
                                LuaValue luaValue10 = luaValueArr[i4 + 1];
                                LuaValue luaValue11 = luaValueArr[i4 + 2];
                                LuaValue add = luaValue11.add(luaValueArr[i4]);
                                if (!luaValue11.gt_b(0)) {
                                    if (!add.gteq_b(luaValue10)) {
                                    }
                                    luaValueArr[i4] = add;
                                    luaValueArr[i4 + 3] = add;
                                    i += (i3 >>> 14) - Lua.MAXARG_sBx;
                                } else if (add.lteq_b(luaValue10)) {
                                    luaValueArr[i4] = add;
                                    luaValueArr[i4 + 3] = add;
                                    i += (i3 >>> 14) - Lua.MAXARG_sBx;
                                }
                                i++;
                                varargs2 = varargs;
                            case 33:
                                LuaNumber checknumber = luaValueArr[i4].checknumber("'for' initial value must be a number");
                                int i42 = i4 + 1;
                                LuaNumber checknumber2 = luaValueArr[i42].checknumber("'for' limit must be a number");
                                int i43 = i4 + 2;
                                LuaNumber checknumber3 = luaValueArr[i43].checknumber("'for' step must be a number");
                                luaValueArr[i4] = checknumber.sub(checknumber3);
                                luaValueArr[i42] = checknumber2;
                                luaValueArr[i43] = checknumber3;
                                i += (i3 >>> 14) - Lua.MAXARG_sBx;
                                i++;
                                varargs2 = varargs;
                            case 34:
                                Varargs invoke3 = luaValueArr[i4].invoke(varargsOf(luaValueArr[i4 + 1], luaValueArr[i4 + 2]));
                                int i44 = (i3 >> 14) & 511;
                                while (true) {
                                    i44--;
                                    if (i44 >= 0) {
                                        luaValueArr[i4 + 3 + i44] = invoke3.arg(i44 + 1);
                                    } else {
                                        varargs3 = NONE;
                                        i++;
                                        varargs2 = varargs;
                                    }
                                }
                            case 35:
                                int i45 = i4 + 1;
                                if (!luaValueArr[i45].isnil()) {
                                    luaValueArr[i4] = luaValueArr[i45];
                                    i += (i3 >>> 14) - Lua.MAXARG_sBx;
                                }
                                i++;
                                varargs2 = varargs;
                            case 36:
                                int i46 = (i3 >> 14) & 511;
                                if (i46 == 0) {
                                    i++;
                                    i46 = iArr[i];
                                }
                                int i47 = (i46 - 1) * 50;
                                LuaValue luaValue12 = luaValueArr[i4];
                                int i48 = i3 >>> 23;
                                if (i48 == 0) {
                                    int i49 = (i2 - i4) - 1;
                                    int narg = i49 - varargs3.narg();
                                    int i50 = 1;
                                    while (i50 <= narg) {
                                        luaValue12.set(i47 + i50, luaValueArr[i4 + i50]);
                                        i50++;
                                    }
                                    while (i50 <= i49) {
                                        luaValue12.set(i47 + i50, varargs3.arg(i50 - narg));
                                        i50++;
                                    }
                                } else {
                                    luaValue12.presize(i47 + i48);
                                    for (int i51 = 1; i51 <= i48; i51++) {
                                        luaValue12.set(i47 + i51, luaValueArr[i4 + i51]);
                                    }
                                }
                                i++;
                                varargs2 = varargs;
                            case 37:
                                Prototype prototype = this.p.p[i3 >>> 14];
                                LuaClosure luaClosure = new LuaClosure(prototype, this.globals);
                                Upvaldesc[] upvaldescArr = prototype.upvalues;
                                int length10 = upvaldescArr.length;
                                for (int i52 = 0; i52 < length10; i52++) {
                                    if (upvaldescArr[i52].instack) {
                                        luaClosure.upValues[i52] = findupval(luaValueArr, upvaldescArr[i52].idx, upValueArr);
                                    } else {
                                        luaClosure.upValues[i52] = this.upValues[upvaldescArr[i52].idx];
                                    }
                                }
                                luaValueArr[i4] = luaClosure;
                                i++;
                                varargs2 = varargs;
                            case 38:
                                int i53 = i3 >>> 23;
                                if (i53 == 0) {
                                    i2 = i4 + varargs2.narg();
                                    varargs3 = varargs2;
                                } else {
                                    for (int i54 = 1; i54 < i53; i54++) {
                                        luaValueArr[(i4 + i54) - 1] = varargs2.arg(i54);
                                    }
                                }
                                i++;
                                varargs2 = varargs;
                            case 39:
                                throw new IllegalArgumentException("Uexecutable opcode: OP_EXTRAARG");
                        }
                    } catch (Exception e) {
                        LuaError luaError = new LuaError(e);
                        processErrorHooks(luaError, this.p, i);
                        throw luaError;
                    }
                } catch (LuaError e2) {
                    if (e2.traceback == null) {
                        processErrorHooks(e2, this.p, i);
                    }
                    throw e2;
                }
            } finally {
                if (upValueArr != null) {
                    int length11 = upValueArr.length;
                    while (true) {
                        length11--;
                        if (length11 >= 0) {
                            if (upValueArr[length11] != null) {
                                upValueArr[length11].close();
                            }
                        }
                    }
                }
                if (this.globals != null && this.globals.debuglib != null) {
                    this.globals.debuglib.onReturn();
                }
            }
        }
    }

    protected LuaValue getUpvalue(int i) {
        return this.upValues[i].getValue();
    }

    @Override // org.luaj.vm2.LuaFunction, org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    @Override // org.luaj.vm2.LuaValue
    public final Varargs invoke(Varargs varargs) {
        return onInvoke(varargs).eval();
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isclosure() {
        return true;
    }

    @Override // org.luaj.vm2.LuaFunction
    public String name() {
        return new StringBuffer().append("<").append(this.p.shortsource()).append(":").append(this.p.linedefined).append(">").toString();
    }

    @Override // org.luaj.vm2.LuaValue
    public final Varargs onInvoke(Varargs varargs) {
        LuaValue[] luaValueArr = new LuaValue[this.p.maxstacksize];
        int i = 0;
        while (i < this.p.numparams) {
            int i2 = i + 1;
            luaValueArr[i] = varargs.arg(i2);
            i = i2;
        }
        return execute(luaValueArr, this.p.is_vararg != 0 ? varargs.subargs(this.p.numparams + 1) : NONE);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaClosure optclosure(LuaClosure luaClosure) {
        return this;
    }

    protected void setUpvalue(int i, LuaValue luaValue) {
        this.upValues[i].setValue(luaValue);
    }

    @Override // org.luaj.vm2.LuaFunction, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return new StringBuffer().append("function: ").append(this.p.toString()).toString();
    }
}
