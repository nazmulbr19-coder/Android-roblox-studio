package org.luaj.vm2.luajc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.luaj.vm2.Lua;
import org.luaj.vm2.Print;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.Upvaldesc;

/* loaded from: classes10.dex */
public class ProtoInfo {
    public final BasicBlock[] blocklist;
    public final BasicBlock[] blocks;
    public final String name;
    public final UpvalInfo[][] openups;
    public final VarInfo[] params;
    public final Prototype prototype;
    public final ProtoInfo[] subprotos;
    public final UpvalInfo[] upvals;
    public final VarInfo[][] vars;

    public ProtoInfo(Prototype prototype, String str) {
        this(prototype, str, null);
    }

    private ProtoInfo(Prototype prototype, String str, UpvalInfo[] upvalInfoArr) {
        this.name = str;
        this.prototype = prototype;
        this.upvals = upvalInfoArr == null ? new UpvalInfo[]{new UpvalInfo(this)} : upvalInfoArr;
        this.subprotos = (prototype.p == null || prototype.p.length <= 0) ? null : new ProtoInfo[prototype.p.length];
        this.blocks = BasicBlock.findBasicBlocks(prototype);
        this.blocklist = BasicBlock.findLiveBlocks(this.blocks);
        this.params = new VarInfo[prototype.maxstacksize];
        for (int i = 0; i < prototype.maxstacksize; i++) {
            this.params[i] = VarInfo.PARAM(i);
        }
        this.vars = findVariables();
        replaceTrivialPhiVariables();
        this.openups = new UpvalInfo[prototype.maxstacksize];
        findUpvalues();
    }

    private void appendOpenUps(StringBuffer stringBuffer, int i) {
        for (int i2 = 0; i2 < this.prototype.maxstacksize; i2++) {
            VarInfo varInfo = i < 0 ? this.params[i2] : this.vars[i2][i];
            if (varInfo != null && varInfo.pc == i && varInfo.allocupvalue) {
                stringBuffer.append(new StringBuffer().append("    open: ").append(varInfo.upvalue).append("\n").toString());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
    
        if (r7 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        r7 = r7.tojstring();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        if (r7 != null) goto L16;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0036. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String[] findInnerprotoNames() {
        /*
            r11 = this;
            org.luaj.vm2.Prototype r0 = r11.prototype
            org.luaj.vm2.Prototype[] r0 = r0.p
            int r0 = r0.length
            r1 = 0
            if (r0 > 0) goto L9
            return r1
        L9:
            org.luaj.vm2.Prototype r0 = r11.prototype
            org.luaj.vm2.Prototype[] r0 = r0.p
            int r0 = r0.length
            java.lang.String[] r0 = new java.lang.String[r0]
            java.util.Hashtable r2 = new java.util.Hashtable
            r2.<init>()
            org.luaj.vm2.Prototype r3 = r11.prototype
            int[] r3 = r3.code
            int r4 = r3.length
            r5 = 0
        L1b:
            if (r5 >= r4) goto Lb3
            r6 = r3[r5]
            int r6 = org.luaj.vm2.Lua.GET_OPCODE(r6)
            r7 = 37
            if (r6 != r7) goto Laf
            r6 = r3[r5]
            int r6 = org.luaj.vm2.Lua.GETARG_Bx(r6)
            int r7 = r5 + 1
            r8 = r3[r7]
            int r9 = org.luaj.vm2.Lua.GET_OPCODE(r8)
            r10 = 1
            switch(r9) {
                case 8: goto L5c;
                case 9: goto L49;
                case 10: goto L5c;
                default: goto L39;
            }
        L39:
            r8 = r3[r5]
            int r8 = org.luaj.vm2.Lua.GETARG_A(r8)
            org.luaj.vm2.Prototype r9 = r11.prototype
            int r8 = r8 + r10
            org.luaj.vm2.LuaString r7 = r9.getlocalname(r8, r7)
            if (r7 == 0) goto L73
            goto L57
        L49:
            int r7 = org.luaj.vm2.Lua.GETARG_B(r8)
            org.luaj.vm2.Prototype r8 = r11.prototype
            org.luaj.vm2.Upvaldesc[] r8 = r8.upvalues
            r7 = r8[r7]
            org.luaj.vm2.LuaString r7 = r7.name
            if (r7 == 0) goto L73
        L57:
            java.lang.String r7 = r7.tojstring()
            goto L74
        L5c:
            int r7 = org.luaj.vm2.Lua.GETARG_B(r8)
            boolean r8 = org.luaj.vm2.Lua.ISK(r7)
            if (r8 == 0) goto L73
            org.luaj.vm2.Prototype r8 = r11.prototype
            org.luaj.vm2.LuaValue[] r8 = r8.k
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r8[r7]
            java.lang.String r7 = r7.tojstring()
            goto L74
        L73:
            r7 = r1
        L74:
            if (r7 == 0) goto L7b
            java.lang.String r7 = toJavaClassPart(r7)
            goto L7f
        L7b:
            java.lang.String r7 = java.lang.String.valueOf(r6)
        L7f:
            boolean r8 = r2.containsKey(r7)
            if (r8 == 0) goto La8
        L85:
            java.lang.StringBuffer r8 = new java.lang.StringBuffer
            r8.<init>()
            java.lang.StringBuffer r8 = r8.append(r7)
            r9 = 36
            java.lang.StringBuffer r8 = r8.append(r9)
            int r9 = r10 + 1
            java.lang.StringBuffer r8 = r8.append(r10)
            java.lang.String r8 = r8.toString()
            boolean r10 = r2.containsKey(r8)
            if (r10 != 0) goto La6
            r7 = r8
            goto La8
        La6:
            r10 = r9
            goto L85
        La8:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            r2.put(r7, r8)
            r0[r6] = r7
        Laf:
            int r5 = r5 + 1
            goto L1b
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.luajc.ProtoInfo.findInnerprotoNames():java.lang.String[]");
    }

    private UpvalInfo findOpenUp(int i, int i2) {
        if (this.openups[i2] == null) {
            this.openups[i2] = new UpvalInfo[this.prototype.code.length];
        }
        if (this.openups[i2][i] != null) {
            return this.openups[i2][i];
        }
        UpvalInfo upvalInfo = new UpvalInfo(this, i, i2);
        int length = this.prototype.code.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.vars[i2][i3] != null && this.vars[i2][i3].upvalue == upvalInfo) {
                this.openups[i2][i3] = upvalInfo;
            }
        }
        return upvalInfo;
    }

    private void findUpvalues() {
        int[] iArr = this.prototype.code;
        int length = iArr.length;
        String[] findInnerprotoNames = findInnerprotoNames();
        for (int i = 0; i < length; i++) {
            if (Lua.GET_OPCODE(iArr[i]) == 37) {
                int GETARG_Bx = Lua.GETARG_Bx(iArr[i]);
                Prototype prototype = this.prototype.p[GETARG_Bx];
                UpvalInfo[] upvalInfoArr = new UpvalInfo[prototype.upvalues.length];
                String stringBuffer = new StringBuffer().append(this.name).append("$").append(findInnerprotoNames[GETARG_Bx]).toString();
                for (int i2 = 0; i2 < prototype.upvalues.length; i2++) {
                    Upvaldesc upvaldesc = prototype.upvalues[i2];
                    upvalInfoArr[i2] = upvaldesc.instack ? findOpenUp(i, upvaldesc.idx) : this.upvals[upvaldesc.idx];
                }
                this.subprotos[GETARG_Bx] = new ProtoInfo(prototype, stringBuffer, upvalInfoArr);
            }
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (Lua.GET_OPCODE(iArr[i3]) == 9) {
                this.upvals[Lua.GETARG_B(iArr[i3])].rw = true;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x0082. Please report as an issue. */
    private VarInfo[][] findVariables() {
        VarInfo varInfo;
        VarInfo varInfo2;
        int length = this.prototype.code.length;
        int i = this.prototype.maxstacksize;
        VarInfo[][] varInfoArr = new VarInfo[i];
        for (int i2 = 0; i2 < i; i2++) {
            varInfoArr[i2] = new VarInfo[length];
        }
        for (int i3 = 0; i3 < this.blocklist.length; i3++) {
            BasicBlock basicBlock = this.blocklist[i3];
            int length2 = basicBlock.prev != null ? basicBlock.prev.length : 0;
            for (int i4 = 0; i4 < i; i4++) {
                if (length2 == 0) {
                    varInfo2 = this.params[i4];
                } else if (length2 == 1) {
                    varInfo2 = varInfoArr[i4][basicBlock.prev[0].pc1];
                } else {
                    varInfo2 = null;
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (varInfoArr[i4][basicBlock.prev[i5].pc1] == VarInfo.INVALID) {
                            varInfo2 = VarInfo.INVALID;
                        }
                    }
                }
                if (varInfo2 == null) {
                    varInfo2 = VarInfo.PHI(this, i4, basicBlock.pc0);
                }
                varInfoArr[i4][basicBlock.pc0] = varInfo2;
            }
            for (int i6 = basicBlock.pc0; i6 <= basicBlock.pc1; i6++) {
                if (i6 > basicBlock.pc0) {
                    propogateVars(varInfoArr, i6 - 1, i6);
                }
                int i7 = this.prototype.code[i6];
                switch (Lua.GET_OPCODE(i7)) {
                    case 0:
                    case 19:
                    case 20:
                    case 21:
                    case 28:
                        int GETARG_A = Lua.GETARG_A(i7);
                        varInfoArr[Lua.GETARG_B(i7)][i6].isreferenced = true;
                        varInfoArr[GETARG_A][i6] = new VarInfo(GETARG_A, i6);
                    case 1:
                    case 3:
                    case 5:
                    case 11:
                        int GETARG_A2 = Lua.GETARG_A(i7);
                        varInfoArr[GETARG_A2][i6] = new VarInfo(GETARG_A2, i6);
                    case 2:
                    default:
                        throw new IllegalStateException(new StringBuffer().append("unhandled opcode: ").append(i7).toString());
                    case 4:
                        int GETARG_A3 = Lua.GETARG_A(i7);
                        int GETARG_B = Lua.GETARG_B(i7);
                        while (true) {
                            int i8 = GETARG_B - 1;
                            if (GETARG_B >= 0) {
                                varInfoArr[GETARG_A3][i6] = new VarInfo(GETARG_A3, i6);
                                GETARG_A3++;
                                GETARG_B = i8;
                            }
                        }
                        break;
                    case 6:
                        int GETARG_A4 = Lua.GETARG_A(i7);
                        int GETARG_C = Lua.GETARG_C(i7);
                        if (!Lua.ISK(GETARG_C)) {
                            varInfoArr[GETARG_C][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A4][i6] = new VarInfo(GETARG_A4, i6);
                    case 7:
                        int GETARG_A5 = Lua.GETARG_A(i7);
                        int GETARG_B2 = Lua.GETARG_B(i7);
                        int GETARG_C2 = Lua.GETARG_C(i7);
                        varInfoArr[GETARG_B2][i6].isreferenced = true;
                        if (!Lua.ISK(GETARG_C2)) {
                            varInfoArr[GETARG_C2][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A5][i6] = new VarInfo(GETARG_A5, i6);
                    case 8:
                        int GETARG_B3 = Lua.GETARG_B(i7);
                        int GETARG_C3 = Lua.GETARG_C(i7);
                        if (!Lua.ISK(GETARG_B3)) {
                            varInfoArr[GETARG_B3][i6].isreferenced = true;
                        }
                        if (!Lua.ISK(GETARG_C3)) {
                            varInfo = varInfoArr[GETARG_C3][i6];
                            varInfo.isreferenced = true;
                        }
                    case 9:
                    case 27:
                        varInfo = varInfoArr[Lua.GETARG_A(i7)][i6];
                        varInfo.isreferenced = true;
                    case 10:
                        int GETARG_A6 = Lua.GETARG_A(i7);
                        int GETARG_B4 = Lua.GETARG_B(i7);
                        int GETARG_C4 = Lua.GETARG_C(i7);
                        varInfoArr[GETARG_A6][i6].isreferenced = true;
                        if (!Lua.ISK(GETARG_B4)) {
                            varInfoArr[GETARG_B4][i6].isreferenced = true;
                        }
                        if (!Lua.ISK(GETARG_C4)) {
                            varInfo = varInfoArr[GETARG_C4][i6];
                            varInfo.isreferenced = true;
                        }
                    case 12:
                        int GETARG_A7 = Lua.GETARG_A(i7);
                        int GETARG_B5 = Lua.GETARG_B(i7);
                        int GETARG_C5 = Lua.GETARG_C(i7);
                        varInfoArr[GETARG_B5][i6].isreferenced = true;
                        if (!Lua.ISK(GETARG_C5)) {
                            varInfoArr[GETARG_C5][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A7][i6] = new VarInfo(GETARG_A7, i6);
                        int i9 = GETARG_A7 + 1;
                        varInfoArr[i9][i6] = new VarInfo(i9, i6);
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        int GETARG_A8 = Lua.GETARG_A(i7);
                        int GETARG_B6 = Lua.GETARG_B(i7);
                        int GETARG_C6 = Lua.GETARG_C(i7);
                        if (!Lua.ISK(GETARG_B6)) {
                            varInfoArr[GETARG_B6][i6].isreferenced = true;
                        }
                        if (!Lua.ISK(GETARG_C6)) {
                            varInfoArr[GETARG_C6][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A8][i6] = new VarInfo(GETARG_A8, i6);
                    case 22:
                        int GETARG_A9 = Lua.GETARG_A(i7);
                        int GETARG_C7 = Lua.GETARG_C(i7);
                        for (int GETARG_B7 = Lua.GETARG_B(i7); GETARG_B7 <= GETARG_C7; GETARG_B7++) {
                            varInfoArr[GETARG_B7][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A9][i6] = new VarInfo(GETARG_A9, i6);
                    case 23:
                        int GETARG_A10 = Lua.GETARG_A(i7);
                        if (GETARG_A10 > 0) {
                            for (int i10 = GETARG_A10 - 1; i10 < i; i10++) {
                                varInfoArr[i10][i6] = VarInfo.INVALID;
                            }
                        }
                    case 24:
                    case 25:
                    case 26:
                        int GETARG_B8 = Lua.GETARG_B(i7);
                        int GETARG_C8 = Lua.GETARG_C(i7);
                        if (!Lua.ISK(GETARG_B8)) {
                            varInfoArr[GETARG_B8][i6].isreferenced = true;
                        }
                        if (!Lua.ISK(GETARG_C8)) {
                            varInfo = varInfoArr[GETARG_C8][i6];
                            varInfo.isreferenced = true;
                        }
                    case 29:
                        int GETARG_A11 = Lua.GETARG_A(i7);
                        int GETARG_B9 = Lua.GETARG_B(i7);
                        int GETARG_C9 = Lua.GETARG_C(i7);
                        varInfoArr[GETARG_A11][i6].isreferenced = true;
                        varInfoArr[GETARG_A11][i6].isreferenced = true;
                        for (int i11 = 1; i11 <= GETARG_B9 - 1; i11++) {
                            varInfoArr[GETARG_A11 + i11][i6].isreferenced = true;
                        }
                        int i12 = 0;
                        while (i12 <= GETARG_C9 - 2) {
                            varInfoArr[GETARG_A11][i6] = new VarInfo(GETARG_A11, i6);
                            i12++;
                            GETARG_A11++;
                        }
                        while (GETARG_A11 < i) {
                            varInfoArr[GETARG_A11][i6] = VarInfo.INVALID;
                            GETARG_A11++;
                        }
                    case 30:
                        int GETARG_A12 = Lua.GETARG_A(i7);
                        int GETARG_B10 = Lua.GETARG_B(i7);
                        varInfoArr[GETARG_A12][i6].isreferenced = true;
                        for (int i13 = 1; i13 <= GETARG_B10 - 1; i13++) {
                            varInfoArr[GETARG_A12 + i13][i6].isreferenced = true;
                        }
                    case 31:
                        int GETARG_A13 = Lua.GETARG_A(i7);
                        int GETARG_B11 = Lua.GETARG_B(i7);
                        for (int i14 = 0; i14 <= GETARG_B11 - 2; i14++) {
                            varInfoArr[GETARG_A13 + i14][i6].isreferenced = true;
                        }
                    case 32:
                        int GETARG_A14 = Lua.GETARG_A(i7);
                        varInfoArr[GETARG_A14][i6].isreferenced = true;
                        varInfoArr[GETARG_A14 + 2][i6].isreferenced = true;
                        varInfoArr[GETARG_A14][i6] = new VarInfo(GETARG_A14, i6);
                        varInfoArr[GETARG_A14][i6].isreferenced = true;
                        varInfoArr[GETARG_A14 + 1][i6].isreferenced = true;
                        int i15 = GETARG_A14 + 3;
                        varInfoArr[i15][i6] = new VarInfo(i15, i6);
                    case 33:
                        int GETARG_A15 = Lua.GETARG_A(i7);
                        varInfoArr[GETARG_A15 + 2][i6].isreferenced = true;
                        varInfoArr[GETARG_A15][i6] = new VarInfo(GETARG_A15, i6);
                    case 34:
                        int GETARG_A16 = Lua.GETARG_A(i7);
                        int GETARG_C10 = Lua.GETARG_C(i7);
                        int i16 = GETARG_A16 + 1;
                        varInfoArr[GETARG_A16][i6].isreferenced = true;
                        int i17 = i16 + 1;
                        varInfoArr[i16][i6].isreferenced = true;
                        int i18 = i17 + 1;
                        varInfoArr[i17][i6].isreferenced = true;
                        int i19 = 0;
                        while (i19 < GETARG_C10) {
                            varInfoArr[i18][i6] = new VarInfo(i18, i6);
                            i19++;
                            i18++;
                        }
                        while (i18 < i) {
                            varInfoArr[i18][i6] = VarInfo.INVALID;
                            i18++;
                        }
                    case 35:
                        int GETARG_A17 = Lua.GETARG_A(i7);
                        varInfoArr[GETARG_A17 + 1][i6].isreferenced = true;
                        varInfoArr[GETARG_A17][i6] = new VarInfo(GETARG_A17, i6);
                    case 36:
                        int GETARG_A18 = Lua.GETARG_A(i7);
                        int GETARG_B12 = Lua.GETARG_B(i7);
                        varInfoArr[GETARG_A18][i6].isreferenced = true;
                        for (int i20 = 1; i20 <= GETARG_B12; i20++) {
                            varInfoArr[GETARG_A18 + i20][i6].isreferenced = true;
                        }
                    case 37:
                        int GETARG_A19 = Lua.GETARG_A(i7);
                        Upvaldesc[] upvaldescArr = this.prototype.p[Lua.GETARG_Bx(i7)].upvalues;
                        int length3 = upvaldescArr.length;
                        for (int i21 = 0; i21 < length3; i21++) {
                            if (upvaldescArr[i21].instack) {
                                varInfoArr[upvaldescArr[i21].idx][i6].isreferenced = true;
                            }
                        }
                        varInfoArr[GETARG_A19][i6] = new VarInfo(GETARG_A19, i6);
                    case 38:
                        int GETARG_A20 = Lua.GETARG_A(i7);
                        int GETARG_B13 = Lua.GETARG_B(i7);
                        int i22 = 1;
                        while (i22 < GETARG_B13) {
                            varInfoArr[GETARG_A20][i6] = new VarInfo(GETARG_A20, i6);
                            i22++;
                            GETARG_A20++;
                        }
                        if (GETARG_B13 == 0) {
                            while (GETARG_A20 < i) {
                                varInfoArr[GETARG_A20][i6] = VarInfo.INVALID;
                                GETARG_A20++;
                            }
                        }
                }
            }
        }
        return varInfoArr;
    }

    private static void propogateVars(VarInfo[][] varInfoArr, int i, int i2) {
        int length = varInfoArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            varInfoArr[i3][i2] = varInfoArr[i3][i];
        }
    }

    private void replaceAll(VarInfo[] varInfoArr, int i, VarInfo varInfo, VarInfo varInfo2) {
        for (int i2 = 0; i2 < i; i2++) {
            if (varInfoArr[i2] == varInfo) {
                varInfoArr[i2] = varInfo2;
            }
        }
    }

    private void replaceTrivialPhiVariables() {
        for (int i = 0; i < this.blocklist.length; i++) {
            BasicBlock basicBlock = this.blocklist[i];
            for (int i2 = 0; i2 < this.prototype.maxstacksize; i2++) {
                VarInfo varInfo = this.vars[i2][basicBlock.pc0];
                VarInfo resolvePhiVariableValues = varInfo.resolvePhiVariableValues();
                if (resolvePhiVariableValues != null) {
                    substituteVariable(i2, varInfo, resolvePhiVariableValues);
                }
            }
        }
    }

    private void substituteVariable(int i, VarInfo varInfo, VarInfo varInfo2) {
        int length = this.prototype.code.length;
        for (int i2 = 0; i2 < length; i2++) {
            replaceAll(this.vars[i], this.vars[i].length, varInfo, varInfo2);
        }
    }

    private static String toJavaClassPart(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(Character.isJavaIdentifierPart(str.charAt(i)) ? str.charAt(i) : '_');
        }
        return stringBuffer.toString();
    }

    public boolean isInitialValueUsed(int i) {
        return this.params[i].isreferenced;
    }

    public boolean isReadWriteUpvalue(UpvalInfo upvalInfo) {
        return upvalInfo.rw;
    }

    public boolean isUpvalueAssign(int i, int i2) {
        VarInfo varInfo = i < 0 ? this.params[i2] : this.vars[i2][i];
        return (varInfo == null || varInfo.upvalue == null || !varInfo.upvalue.rw) ? false : true;
    }

    public boolean isUpvalueCreate(int i, int i2) {
        VarInfo varInfo = i < 0 ? this.params[i2] : this.vars[i2][i];
        return varInfo != null && varInfo.upvalue != null && varInfo.upvalue.rw && varInfo.allocupvalue && i == varInfo.pc;
    }

    public boolean isUpvalueRefer(int i, int i2) {
        if (i > 0 && this.vars[i2][i] != null && this.vars[i2][i].pc == i && this.vars[i2][i - 1] != null) {
            i--;
        }
        VarInfo varInfo = i < 0 ? this.params[i2] : this.vars[i2][i];
        return (varInfo == null || varInfo.upvalue == null || !varInfo.upvalue.rw) ? false : true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("proto '").append(this.name).append("'\n").toString());
        int length = this.upvals != null ? this.upvals.length : 0;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(new StringBuffer().append(" up[").append(i).append("]: ").append(this.upvals[i]).append("\n").toString());
        }
        for (int i2 = 0; i2 < this.blocklist.length; i2++) {
            BasicBlock basicBlock = this.blocklist[i2];
            int i3 = basicBlock.pc0;
            stringBuffer.append(new StringBuffer().append("  block ").append(basicBlock.toString()).toString());
            appendOpenUps(stringBuffer, -1);
            while (i3 <= basicBlock.pc1) {
                appendOpenUps(stringBuffer, i3);
                stringBuffer.append("     ");
                for (int i4 = 0; i4 < this.prototype.maxstacksize; i4++) {
                    VarInfo varInfo = this.vars[i4][i3];
                    stringBuffer.append(new StringBuffer().append(varInfo == null ? "null   " : String.valueOf(varInfo)).append(varInfo == null ? "" : varInfo.upvalue != null ? !varInfo.upvalue.rw ? "[C] " : (varInfo.allocupvalue && varInfo.pc == i3) ? "[*] " : "[]  " : "    ").toString());
                }
                stringBuffer.append("  ");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = Print.ps;
                Print.ps = new PrintStream(byteArrayOutputStream);
                try {
                    Print.printOpCode(this.prototype, i3);
                    Print.ps.close();
                    Print.ps = printStream;
                    stringBuffer.append(byteArrayOutputStream.toString());
                    stringBuffer.append("\n");
                    i3++;
                } catch (Throwable th) {
                    Print.ps.close();
                    Print.ps = printStream;
                    throw th;
                }
            }
        }
        int length2 = this.subprotos != null ? this.subprotos.length : 0;
        for (int i5 = 0; i5 < length2; i5++) {
            stringBuffer.append(this.subprotos[i5].toString());
        }
        return stringBuffer.toString();
    }
}
