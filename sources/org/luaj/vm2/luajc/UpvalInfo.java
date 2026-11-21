package org.luaj.vm2.luajc;

import org.luaj.vm2.Lua;

/* loaded from: classes10.dex */
public class UpvalInfo {
    int nvars;
    ProtoInfo pi;
    boolean rw;
    int slot;
    VarInfo[] var;

    public UpvalInfo(ProtoInfo protoInfo) {
        this.pi = protoInfo;
        this.slot = 0;
        this.nvars = 1;
        this.var = new VarInfo[]{VarInfo.PARAM(0)};
        this.rw = false;
    }

    public UpvalInfo(ProtoInfo protoInfo, int i, int i2) {
        this.pi = protoInfo;
        this.slot = i2;
        this.nvars = 0;
        this.var = null;
        includeVarAndPosteriorVars(protoInfo.vars[i2][i]);
        for (int i3 = 0; i3 < this.nvars; i3++) {
            this.var[i3].allocupvalue = testIsAllocUpvalue(this.var[i3]);
        }
        this.rw = this.nvars > 1;
    }

    private void appendVar(VarInfo varInfo) {
        if (this.nvars == 0) {
            this.var = new VarInfo[1];
        } else if (this.nvars + 1 >= this.var.length) {
            VarInfo[] varInfoArr = this.var;
            this.var = new VarInfo[(this.nvars * 2) + 1];
            System.arraycopy(varInfoArr, 0, this.var, 0, this.nvars);
        }
        VarInfo[] varInfoArr2 = this.var;
        int i = this.nvars;
        this.nvars = i + 1;
        varInfoArr2[i] = varInfo;
    }

    private boolean includePosteriorVarsCheckLoops(VarInfo varInfo) {
        int length = this.pi.blocklist.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            BasicBlock basicBlock = this.pi.blocklist[i];
            if (this.pi.vars[this.slot][basicBlock.pc1] != varInfo) {
                int i2 = basicBlock.pc1;
                while (true) {
                    i2--;
                    if (i2 < basicBlock.pc0) {
                        break;
                    }
                    if (this.pi.vars[this.slot][i2] == varInfo) {
                        z |= includeVarAndPosteriorVars(this.pi.vars[this.slot][i2 + 1]);
                        break;
                    }
                }
            } else {
                int length2 = basicBlock.next != null ? basicBlock.next.length : 0;
                for (int i3 = 0; i3 < length2; i3++) {
                    VarInfo varInfo2 = this.pi.vars[this.slot][basicBlock.next[i3].pc0];
                    if (varInfo2 != varInfo) {
                        z |= includeVarAndPosteriorVars(varInfo2);
                        if (varInfo2.isPhiVar()) {
                            includePriorVarsIgnoreLoops(varInfo2);
                        }
                    }
                }
            }
        }
        return z;
    }

    private void includePriorVarsIgnoreLoops(VarInfo varInfo) {
        int length = this.pi.blocklist.length;
        for (int i = 0; i < length; i++) {
            BasicBlock basicBlock = this.pi.blocklist[i];
            if (this.pi.vars[this.slot][basicBlock.pc0] != varInfo) {
                int i2 = basicBlock.pc0;
                while (true) {
                    i2++;
                    if (i2 <= basicBlock.pc1) {
                        if (this.pi.vars[this.slot][i2] == varInfo) {
                            includeVarAndPosteriorVars(this.pi.vars[this.slot][i2 - 1]);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                int length2 = basicBlock.prev != null ? basicBlock.prev.length : 0;
                for (int i3 = 0; i3 < length2; i3++) {
                    VarInfo varInfo2 = this.pi.vars[this.slot][basicBlock.prev[i3].pc1];
                    if (varInfo2 != varInfo) {
                        includeVarAndPosteriorVars(varInfo2);
                    }
                }
            }
        }
    }

    private boolean includeVarAndPosteriorVars(VarInfo varInfo) {
        boolean z = false;
        if (varInfo != null && varInfo != VarInfo.INVALID) {
            if (varInfo.upvalue == this) {
                return true;
            }
            varInfo.upvalue = this;
            appendVar(varInfo);
            if (isLoopVariable(varInfo)) {
                return false;
            }
            z = includePosteriorVarsCheckLoops(varInfo);
            if (z) {
                includePriorVarsIgnoreLoops(varInfo);
            }
        }
        return z;
    }

    private boolean isLoopVariable(VarInfo varInfo) {
        if (varInfo.pc < 0) {
            return false;
        }
        switch (Lua.GET_OPCODE(this.pi.prototype.code[varInfo.pc])) {
            case 32:
            case 35:
                return true;
            default:
                return false;
        }
    }

    private boolean testIsAllocUpvalue(VarInfo varInfo) {
        if (varInfo.pc < 0) {
            return true;
        }
        BasicBlock basicBlock = this.pi.blocks[varInfo.pc];
        if (varInfo.pc > basicBlock.pc0) {
            return this.pi.vars[this.slot][varInfo.pc - 1].upvalue != this;
        }
        if (basicBlock.prev == null) {
            VarInfo varInfo2 = this.pi.params[this.slot];
            if (varInfo2 != null && varInfo2.upvalue != this) {
                return true;
            }
        } else {
            int length = basicBlock.prev.length;
            for (int i = 0; i < length; i++) {
                VarInfo varInfo3 = this.pi.vars[this.slot][basicBlock.prev[i].pc1];
                if (varInfo3 != null && varInfo3.upvalue != this) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.pi.name);
        int i = 0;
        while (i < this.nvars) {
            stringBuffer.append(i > 0 ? "," : " ");
            stringBuffer.append(String.valueOf(this.var[i]));
            i++;
        }
        if (this.rw) {
            stringBuffer.append("(rw)");
        }
        return stringBuffer.toString();
    }
}
