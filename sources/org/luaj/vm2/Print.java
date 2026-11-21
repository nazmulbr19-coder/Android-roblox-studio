package org.luaj.vm2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import kotlin.text.Typography;

/* loaded from: classes10.dex */
public class Print extends Lua {
    private static final String STRING_FOR_NULL = "null";
    public static PrintStream ps = System.out;
    public static final String[] OPNAMES = {"MOVE", "LOADK", "LOADKX", "LOADBOOL", "LOADNIL", "GETUPVAL", "GETTABUP", "GETTABLE", "SETTABUP", "SETUPVAL", "SETTABLE", "NEWTABLE", "SELF", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "UNM", "NOT", "LEN", "CONCAT", "JMP", "EQ", "LT", "LE", "TEST", "TESTSET", "CALL", "TAILCALL", "RETURN", "FORLOOP", "FORPREP", "TFORCALL", "TFORLOOP", "SETLIST", "CLOSURE", "VARARG", "EXTRAARG", null};

    private void _assert(boolean z) {
        if (!z) {
            throw new NullPointerException("_assert failed");
        }
    }

    private static void format(String str, int i) {
        int length = str.length();
        if (length > i) {
            ps.print(str.substring(0, i));
            return;
        }
        ps.print(str);
        int i2 = i - length;
        while (true) {
            i2--;
            if (i2 < 0) {
                return;
            } else {
                ps.print(' ');
            }
        }
    }

    private static int getline(Prototype prototype, int i) {
        if (i <= 0 || prototype.lineinfo == null || i >= prototype.lineinfo.length) {
            return -1;
        }
        return prototype.lineinfo[i];
    }

    private static String id(Prototype prototype) {
        return "Proto";
    }

    public static void print(Prototype prototype) {
        printFunction(prototype, true);
    }

    public static void printCode(Prototype prototype) {
        int length = prototype.code.length;
        for (int i = 0; i < length; i++) {
            printOpCode(prototype, i);
            ps.println();
        }
    }

    static void printConstant(PrintStream printStream, Prototype prototype, int i) {
        printValue(printStream, prototype.k[i]);
    }

    static void printConstants(Prototype prototype) {
        int length = prototype.k.length;
        ps.print(new StringBuffer().append("constants (").append(length).append(") for ").append(id(prototype)).append(":\n").toString());
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            ps.print(new StringBuffer().append("  ").append(i2).append("  ").toString());
            printValue(ps, prototype.k[i]);
            ps.print("\n");
            i = i2;
        }
    }

    public static void printFunction(Prototype prototype, boolean z) {
        int length = prototype.p.length;
        printHeader(prototype);
        printCode(prototype);
        if (z) {
            printConstants(prototype);
            printLocals(prototype);
            printUpValues(prototype);
        }
        for (int i = 0; i < length; i++) {
            printFunction(prototype.p[i], z);
        }
    }

    static void printHeader(Prototype prototype) {
        String valueOf = String.valueOf(prototype.source);
        ps.print(new StringBuffer().append("\n%").append(prototype.linedefined == 0 ? "main" : "function").append(" <").append((valueOf.startsWith("@") || valueOf.startsWith("=")) ? valueOf.substring(1) : "\u001bLua".equals(valueOf) ? "(bstring)" : "(string)").append(":").append(prototype.linedefined).append(",").append(prototype.lastlinedefined).append("> (").append(prototype.code.length).append(" instructions, ").append(prototype.code.length * 4).append(" bytes at ").append(id(prototype)).append(")\n").toString());
        ps.print(new StringBuffer().append(prototype.numparams).append(" param, ").append(prototype.maxstacksize).append(" slot, ").append(prototype.upvalues.length).append(" upvalue, ").toString());
        ps.print(new StringBuffer().append(prototype.locvars.length).append(" local, ").append(prototype.k.length).append(" constant, ").append(prototype.p.length).append(" function\n").toString());
    }

    static void printLocals(Prototype prototype) {
        int length = prototype.locvars.length;
        ps.print(new StringBuffer().append("locals (").append(length).append(") for ").append(id(prototype)).append(":\n").toString());
        for (int i = 0; i < length; i++) {
            ps.println(new StringBuffer().append("  ").append(i).append("  ").append(prototype.locvars[i].varname).append(" ").append(prototype.locvars[i].startpc + 1).append(" ").append(prototype.locvars[i].endpc + 1).toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x01ad, code lost:
    
        if (ISK(r5) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01fd, code lost:
    
        r12.print("-");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d5, code lost:
    
        if (ISK(r5) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01f3, code lost:
    
        if (ISK(r5) != false) goto L66;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x011c. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void printOpCode(java.io.PrintStream r12, org.luaj.vm2.Prototype r13, int r14) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.Print.printOpCode(java.io.PrintStream, org.luaj.vm2.Prototype, int):void");
    }

    public static void printOpCode(Prototype prototype, int i) {
        printOpCode(ps, prototype, i);
    }

    public static void printStack(LuaValue[] luaValueArr, int i, Varargs varargs) {
        PrintStream printStream;
        String stringBuffer;
        ps.print('[');
        int i2 = 0;
        while (i2 < luaValueArr.length) {
            LuaValue luaValue = luaValueArr[i2];
            if (luaValue == null) {
                ps.print(STRING_FOR_NULL);
            } else {
                switch (luaValue.type()) {
                    case 4:
                        LuaString checkstring = luaValue.checkstring();
                        printStream = ps;
                        if (checkstring.length() >= 48) {
                            stringBuffer = new StringBuffer().append(checkstring.substring(0, 32).tojstring()).append("...+").append(checkstring.length() - 32).append("b").toString();
                            break;
                        } else {
                            stringBuffer = checkstring.tojstring();
                            break;
                        }
                    case 5:
                    case 6:
                    default:
                        printStream = ps;
                        stringBuffer = luaValue.tojstring();
                        break;
                    case 7:
                        Object obj = luaValue.touserdata();
                        if (obj == null) {
                            printStream = ps;
                            stringBuffer = luaValue.toString();
                            break;
                        } else {
                            String name = obj.getClass().getName();
                            ps.print(new StringBuffer().append(name.substring(name.lastIndexOf(46) + 1)).append(": ").append(Integer.toHexString(obj.hashCode())).toString());
                            break;
                        }
                }
                printStream.print(stringBuffer);
            }
            i2++;
            if (i2 == i) {
                ps.print(']');
            }
            ps.print(" | ");
        }
        ps.print(varargs);
    }

    public static void printState(LuaClosure luaClosure, int i, LuaValue[] luaValueArr, int i2, Varargs varargs) {
        PrintStream printStream = ps;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ps = new PrintStream(byteArrayOutputStream);
        printOpCode(luaClosure.p, i);
        ps.flush();
        ps.close();
        ps = printStream;
        format(byteArrayOutputStream.toString(), 50);
        printStack(luaValueArr, i2, varargs);
        ps.println();
    }

    static void printString(PrintStream printStream, LuaString luaString) {
        String str;
        printStream.print(Typography.quote);
        int i = luaString.m_length;
        for (int i2 = 0; i2 < i; i2++) {
            byte b = luaString.m_bytes[luaString.m_offset + i2];
            if (b < 32 || b > 126 || b == 34 || b == 92) {
                switch (b) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    case 34:
                        str = "\\\"";
                        break;
                    case 92:
                        str = "\\\\";
                        break;
                    default:
                        printStream.print('\\');
                        str = Integer.toString(b & 1255).substring(1);
                        break;
                }
                printStream.print(str);
            } else {
                printStream.print((char) b);
            }
        }
        printStream.print(Typography.quote);
    }

    static void printUpValues(Prototype prototype) {
        int length = prototype.upvalues.length;
        ps.print(new StringBuffer().append("upvalues (").append(length).append(") for ").append(id(prototype)).append(":\n").toString());
        for (int i = 0; i < length; i++) {
            ps.print(new StringBuffer().append("  ").append(i).append("  ").append(prototype.upvalues[i]).append("\n").toString());
        }
    }

    static void printUpvalue(PrintStream printStream, Upvaldesc upvaldesc) {
        printStream.print(new StringBuffer().append((int) upvaldesc.idx).append(" ").toString());
        printValue(printStream, upvaldesc.name);
    }

    static void printValue(PrintStream printStream, LuaValue luaValue) {
        switch (luaValue.type()) {
            case 4:
                printString(printStream, (LuaString) luaValue);
                return;
            default:
                printStream.print(luaValue.tojstring());
                return;
        }
    }
}
