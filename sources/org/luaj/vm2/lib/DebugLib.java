package org.luaj.vm2.lib;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import org.luaj.vm2.Globals;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaNil;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Print;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.Varargs;

/* loaded from: classes10.dex */
public class DebugLib extends TwoArgFunction {
    private static final LuaString ACTIVELINES;
    private static final LuaString CALL;
    public static boolean CALLS;
    private static final LuaString COUNT;
    private static final LuaString CURRENTLINE;
    private static final LuaString FUNC;
    private static final LuaString ISTAILCALL;
    private static final LuaString ISVARARG;
    private static final LuaString LASTLINEDEFINED;
    private static final LuaString LINE;
    private static final LuaString LINEDEFINED;
    private static final LuaString LUA;
    private static final LuaString NAME;
    private static final LuaString NAMEWHAT;
    private static final LuaString NPARAMS;
    private static final LuaString NUPS;
    private static final LuaString QMARK;
    private static final LuaString RETURN;
    private static final LuaString SHORT_SRC;
    private static final LuaString SOURCE;
    public static boolean TRACE;
    private static final LuaString WHAT;
    Globals globals;

    /* loaded from: classes10.dex */
    static class CallFrame {
        LuaFunction f;
        int pc;
        CallFrame previous;
        LuaValue[] stack;
        int top;
        Varargs v;

        CallFrame() {
        }

        static /* synthetic */ int access$1500(CallFrame callFrame) {
            return callFrame.linedefined();
        }

        private int linedefined() {
            if (this.f.isclosure()) {
                return this.f.checkclosure().p.linedefined;
            }
            return -1;
        }

        int currentline() {
            int[] iArr;
            if (this.f.isclosure() && (iArr = this.f.checkclosure().p.lineinfo) != null && this.pc >= 0 && this.pc < iArr.length) {
                return iArr[this.pc];
            }
            return -1;
        }

        Varargs getLocal(int i) {
            LuaString luaString = getlocalname(i);
            return luaString != null ? LuaValue.varargsOf(luaString, this.stack[i - 1]) : LuaValue.NIL;
        }

        LuaString getlocalname(int i) {
            if (this.f.isclosure()) {
                return this.f.checkclosure().p.getlocalname(i, this.pc);
            }
            return null;
        }

        void instr(int i, Varargs varargs, int i2) {
            this.pc = i;
            this.v = varargs;
            this.top = i2;
            if (DebugLib.TRACE) {
                Print.printState(this.f.checkclosure(), i, this.stack, i2, varargs);
            }
        }

        void reset() {
            this.f = null;
            this.v = null;
            this.stack = null;
        }

        void set(LuaClosure luaClosure, Varargs varargs, LuaValue[] luaValueArr) {
            this.f = luaClosure;
            this.v = varargs;
            this.stack = luaValueArr;
        }

        void set(LuaFunction luaFunction) {
            this.f = luaFunction;
        }

        Varargs setLocal(int i, LuaValue luaValue) {
            LuaString luaString = getlocalname(i);
            if (luaString == null) {
                return LuaValue.NIL;
            }
            this.stack[i - 1] = luaValue;
            return luaString;
        }

        public String shortsource() {
            return this.f.isclosure() ? this.f.checkclosure().p.shortsource() : "[Java]";
        }

        String sourceline() {
            return !this.f.isclosure() ? this.f.tojstring() : new StringBuffer().append(this.f.checkclosure().p.shortsource()).append(":").append(currentline()).toString();
        }
    }

    /* loaded from: classes10.dex */
    public static class CallStack {
        static final CallFrame[] EMPTY = new CallFrame[0];
        CallFrame[] frame = EMPTY;
        int calls = 0;

        CallStack() {
        }

        private synchronized CallFrame pushcall() {
            CallFrame[] callFrameArr;
            int i;
            if (this.calls >= this.frame.length) {
                int max = Math.max(4, (this.frame.length * 3) / 2);
                CallFrame[] callFrameArr2 = new CallFrame[max];
                System.arraycopy(this.frame, 0, callFrameArr2, 0, this.frame.length);
                for (int length = this.frame.length; length < max; length++) {
                    callFrameArr2[length] = new CallFrame();
                }
                this.frame = callFrameArr2;
                for (int i2 = 1; i2 < max; i2++) {
                    callFrameArr2[i2].previous = callFrameArr2[i2 - 1];
                }
            }
            callFrameArr = this.frame;
            i = this.calls;
            this.calls = i + 1;
            return callFrameArr[i];
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0012. Please report as an issue. */
        synchronized DebugInfo auxgetinfo(String str, LuaFunction luaFunction, CallFrame callFrame) {
            DebugInfo debugInfo;
            NameWhat nameWhat;
            debugInfo = new DebugInfo();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                switch (str.charAt(i)) {
                    case 'L':
                    case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                    case 'S':
                        debugInfo.funcinfo(luaFunction);
                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                        debugInfo.currentline = (callFrame == null || !callFrame.f.isclosure()) ? -1 : callFrame.currentline();
                        break;
                    case 'n':
                        if (callFrame != null && callFrame.previous != null && callFrame.previous.f.isclosure() && (nameWhat = DebugLib.getfuncname(callFrame.previous)) != null) {
                            debugInfo.name = nameWhat.name;
                            debugInfo.namewhat = nameWhat.namewhat;
                        }
                        if (debugInfo.namewhat == null) {
                            debugInfo.namewhat = "";
                            debugInfo.name = null;
                        }
                        break;
                    case 't':
                        debugInfo.istailcall = false;
                    case 'u':
                        if (luaFunction != null) {
                            if (luaFunction.isclosure()) {
                                Prototype prototype = luaFunction.checkclosure().p;
                                debugInfo.nups = (short) prototype.upvalues.length;
                                debugInfo.nparams = (short) prototype.numparams;
                                debugInfo.isvararg = prototype.is_vararg != 0;
                            }
                        }
                        debugInfo.nups = (short) 0;
                        debugInfo.isvararg = true;
                        debugInfo.nparams = (short) 0;
                    default:
                }
            }
            return debugInfo;
        }

        synchronized int currentline() {
            return this.calls > 0 ? this.frame[this.calls - 1].currentline() : -1;
        }

        synchronized CallFrame findCallFrame(LuaValue luaValue) {
            for (int i = 1; i <= this.calls; i++) {
                if (this.frame[this.calls - i].f == luaValue) {
                    return this.frame[i];
                }
            }
            return null;
        }

        synchronized CallFrame getCallFrame(int i) {
            if (i >= 1) {
                if (i <= this.calls) {
                    return this.frame[this.calls - i];
                }
            }
            return null;
        }

        final synchronized void onCall(LuaClosure luaClosure, Varargs varargs, LuaValue[] luaValueArr) {
            pushcall().set(luaClosure, varargs, luaValueArr);
        }

        final synchronized void onCall(LuaFunction luaFunction) {
            pushcall().set(luaFunction);
        }

        final synchronized void onInstruction(int i, Varargs varargs, int i2) {
            if (this.calls > 0) {
                this.frame[this.calls - 1].instr(i, varargs, i2);
            }
        }

        final synchronized void onReturn() {
            if (this.calls > 0) {
                CallFrame[] callFrameArr = this.frame;
                int i = this.calls - 1;
                this.calls = i;
                callFrameArr[i].reset();
            }
        }

        synchronized String traceback(int i) {
            StringBuffer stringBuffer;
            String stringBuffer2;
            stringBuffer = new StringBuffer();
            stringBuffer.append("stack traceback:");
            while (true) {
                int i2 = i + 1;
                CallFrame callFrame = getCallFrame(i);
                if (callFrame != null) {
                    stringBuffer.append("\n\t");
                    stringBuffer.append(callFrame.shortsource());
                    stringBuffer.append(':');
                    if (callFrame.currentline() > 0) {
                        stringBuffer.append(new StringBuffer().append(callFrame.currentline()).append(":").toString());
                    }
                    stringBuffer.append(" in ");
                    DebugInfo auxgetinfo = auxgetinfo("n", callFrame.f, callFrame);
                    if (CallFrame.access$1500(callFrame) == 0) {
                        stringBuffer2 = "main chunk";
                    } else if (auxgetinfo.name != null) {
                        stringBuffer.append("function '");
                        stringBuffer.append(auxgetinfo.name);
                        stringBuffer.append('\'');
                        i = i2;
                    } else {
                        stringBuffer2 = new StringBuffer().append("function <").append(callFrame.shortsource()).append(":").append(CallFrame.access$1500(callFrame)).append(">").toString();
                    }
                    stringBuffer.append(stringBuffer2);
                    i = i2;
                } else {
                    stringBuffer.append("\n\t[Java]: in ?");
                }
            }
            return stringBuffer.toString();
        }
    }

    /* loaded from: classes10.dex */
    static class DebugInfo {
        CallFrame cf;
        int currentline;
        boolean istailcall;
        boolean isvararg;
        int lastlinedefined;
        int linedefined;
        String name;
        String namewhat;
        short nparams;
        short nups;
        String short_src;
        String source;
        String what;

        DebugInfo() {
        }

        public void funcinfo(LuaFunction luaFunction) {
            String name;
            if (luaFunction.isclosure()) {
                Prototype prototype = luaFunction.checkclosure().p;
                this.source = prototype.source != null ? prototype.source.tojstring() : "=?";
                this.linedefined = prototype.linedefined;
                this.lastlinedefined = prototype.lastlinedefined;
                this.what = this.linedefined == 0 ? "main" : "Lua";
                name = prototype.shortsource();
            } else {
                this.source = "=[Java]";
                this.linedefined = -1;
                this.lastlinedefined = -1;
                this.what = "Java";
                name = luaFunction.name();
            }
            this.short_src = name;
        }
    }

    /* loaded from: classes10.dex */
    static class NameWhat {
        final String name;
        final String namewhat;

        NameWhat(String str, String str2) {
            this.name = str;
            this.namewhat = str2;
        }
    }

    /* loaded from: classes10.dex */
    static final class debug extends ZeroArgFunction {
        debug() {
        }

        @Override // org.luaj.vm2.lib.ZeroArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return NONE;
        }
    }

    /* loaded from: classes10.dex */
    final class gethook extends VarArgFunction {
        gethook() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread.State state = (varargs.narg() > 0 ? varargs.checkthread(1) : DebugLib.this.globals.running).state;
            return varargsOf(state.hookfunc != null ? state.hookfunc : NIL, valueOf(new StringBuffer().append(state.hookcall ? "c" : "").append(state.hookline ? "l" : "").append(state.hookrtrn ? "r" : "").toString()), valueOf(state.hookcount));
        }
    }

    /* loaded from: classes10.dex */
    final class getinfo extends VarArgFunction {
        getinfo() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread;
            int i;
            CallFrame findCallFrame;
            int i2 = 1;
            if (varargs.isthread(1)) {
                luaThread = varargs.checkthread(1);
                i = 2;
            } else {
                luaThread = DebugLib.this.globals.running;
                i = 1;
            }
            int i3 = i + 1;
            LuaValue arg = varargs.arg(i);
            int i4 = i3 + 1;
            String optjstring = varargs.optjstring(i3, "flnStu");
            CallStack callstack = DebugLib.this.callstack(luaThread);
            if (arg.isnumber()) {
                findCallFrame = callstack.getCallFrame(arg.toint());
                if (findCallFrame == null) {
                    return NONE;
                }
                arg = findCallFrame.f;
            } else {
                if (!arg.isfunction()) {
                    return argerror(i4 - 2, "function or level");
                }
                findCallFrame = callstack.findCallFrame(arg);
            }
            DebugInfo auxgetinfo = callstack.auxgetinfo(optjstring, (LuaFunction) arg, findCallFrame);
            LuaTable luaTable = new LuaTable();
            if (optjstring.indexOf(83) >= 0) {
                luaTable.set(DebugLib.access$000(), DebugLib.access$100());
                luaTable.set(DebugLib.access$200(), valueOf(auxgetinfo.source));
                luaTable.set(DebugLib.access$300(), valueOf(auxgetinfo.short_src));
                luaTable.set(DebugLib.access$400(), valueOf(auxgetinfo.linedefined));
                luaTable.set(DebugLib.access$500(), valueOf(auxgetinfo.lastlinedefined));
            }
            if (optjstring.indexOf(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR) >= 0) {
                luaTable.set(DebugLib.access$600(), valueOf(auxgetinfo.currentline));
            }
            if (optjstring.indexOf(117) >= 0) {
                luaTable.set(DebugLib.access$700(), valueOf((int) auxgetinfo.nups));
                luaTable.set(DebugLib.access$800(), valueOf((int) auxgetinfo.nparams));
                luaTable.set(DebugLib.access$900(), auxgetinfo.isvararg ? ONE : ZERO);
            }
            if (optjstring.indexOf(110) >= 0) {
                luaTable.set(DebugLib.access$1000(), LuaValue.valueOf(auxgetinfo.name != null ? auxgetinfo.name : "?"));
                luaTable.set(DebugLib.access$1100(), LuaValue.valueOf(auxgetinfo.namewhat));
            }
            if (optjstring.indexOf(116) >= 0) {
                luaTable.set(DebugLib.access$1200(), ZERO);
            }
            if (optjstring.indexOf(76) >= 0) {
                LuaTable luaTable2 = new LuaTable();
                luaTable.set(DebugLib.access$1300(), luaTable2);
                while (true) {
                    CallFrame callFrame = callstack.getCallFrame(i2);
                    if (callFrame == null) {
                        break;
                    }
                    if (callFrame.f == arg) {
                        luaTable2.insert(-1, valueOf(callFrame.currentline()));
                    }
                    i2++;
                }
            }
            if (optjstring.indexOf(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY) >= 0 && arg != null) {
                luaTable.set(DebugLib.access$1400(), arg);
            }
            return luaTable;
        }
    }

    /* loaded from: classes10.dex */
    final class getlocal extends VarArgFunction {
        getlocal() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            int i;
            LuaThread luaThread;
            if (varargs.isthread(1)) {
                luaThread = varargs.checkthread(1);
                i = 2;
            } else {
                i = 1;
                luaThread = DebugLib.this.globals.running;
            }
            int i2 = i + 1;
            int checkint = varargs.checkint(i);
            int checkint2 = varargs.checkint(i2);
            CallFrame callFrame = DebugLib.this.callstack(luaThread).getCallFrame(checkint);
            return callFrame != null ? callFrame.getLocal(checkint2) : NONE;
        }
    }

    /* loaded from: classes10.dex */
    final class getmetatable extends LibFunction {
        getmetatable() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaValue luaValue2 = luaValue.getmetatable();
            return luaValue2 == null ? NIL : luaValue2;
        }
    }

    /* loaded from: classes10.dex */
    final class getregistry extends ZeroArgFunction {
        getregistry() {
        }

        @Override // org.luaj.vm2.lib.ZeroArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return DebugLib.this.globals;
        }
    }

    /* loaded from: classes10.dex */
    static final class getupvalue extends VarArgFunction {
        getupvalue() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaClosure luaClosure;
            LuaString findupvalue;
            LuaFunction checkfunction = varargs.checkfunction(1);
            int checkint = varargs.checkint(2);
            return (!(checkfunction instanceof LuaClosure) || (findupvalue = DebugLib.findupvalue((luaClosure = (LuaClosure) checkfunction), checkint)) == null) ? NIL : varargsOf(findupvalue, luaClosure.upValues[checkint - 1].getValue());
        }
    }

    /* loaded from: classes10.dex */
    static final class getuservalue extends LibFunction {
        getuservalue() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return !luaValue.isuserdata() ? NIL : luaValue;
        }
    }

    /* loaded from: classes10.dex */
    final class sethook extends VarArgFunction {
        sethook() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread;
            int i;
            if (varargs.isthread(1)) {
                luaThread = varargs.checkthread(1);
                i = 2;
            } else {
                luaThread = DebugLib.this.globals.running;
                i = 1;
            }
            int i2 = i + 1;
            LuaFunction optfunction = varargs.optfunction(i, null);
            int i3 = i2 + 1;
            String optjstring = varargs.optjstring(i2, "");
            int optint = varargs.optint(i3, 0);
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i4 = 0; i4 < optjstring.length(); i4++) {
                switch (optjstring.charAt(i4)) {
                    case 'c':
                        z = true;
                        break;
                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                        z2 = true;
                        break;
                    case 'r':
                        z3 = true;
                        break;
                }
            }
            LuaThread.State state = luaThread.state;
            state.hookfunc = optfunction;
            state.hookcall = z;
            state.hookline = z2;
            state.hookcount = optint;
            state.hookrtrn = z3;
            return NONE;
        }
    }

    /* loaded from: classes10.dex */
    final class setlocal extends VarArgFunction {
        setlocal() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            int i;
            LuaThread luaThread;
            if (varargs.isthread(1)) {
                luaThread = varargs.checkthread(1);
                i = 2;
            } else {
                i = 1;
                luaThread = DebugLib.this.globals.running;
            }
            int i2 = i + 1;
            int checkint = varargs.checkint(i);
            int i3 = i2 + 1;
            int checkint2 = varargs.checkint(i2);
            LuaValue arg = varargs.arg(i3);
            CallFrame callFrame = DebugLib.this.callstack(luaThread).getCallFrame(checkint);
            return callFrame != null ? callFrame.setLocal(checkint2, arg) : NONE;
        }
    }

    /* loaded from: classes10.dex */
    final class setmetatable extends TwoArgFunction {
        setmetatable() {
        }

        @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            LuaTable opttable = luaValue2.opttable(null);
            switch (luaValue.type()) {
                case 0:
                    LuaNil.s_metatable = opttable;
                    return luaValue;
                case 1:
                    LuaBoolean.s_metatable = opttable;
                    return luaValue;
                case 2:
                case 5:
                case 7:
                default:
                    luaValue.setmetatable(opttable);
                    return luaValue;
                case 3:
                    LuaNumber.s_metatable = opttable;
                    return luaValue;
                case 4:
                    LuaString.s_metatable = opttable;
                    return luaValue;
                case 6:
                    LuaFunction.s_metatable = opttable;
                    return luaValue;
                case 8:
                    LuaThread.s_metatable = opttable;
                    return luaValue;
            }
        }
    }

    /* loaded from: classes10.dex */
    final class setupvalue extends VarArgFunction {
        setupvalue() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaClosure luaClosure;
            LuaString findupvalue;
            LuaFunction checkfunction = varargs.checkfunction(1);
            int checkint = varargs.checkint(2);
            LuaValue arg = varargs.arg(3);
            if (!(checkfunction instanceof LuaClosure) || (findupvalue = DebugLib.findupvalue((luaClosure = (LuaClosure) checkfunction), checkint)) == null) {
                return NIL;
            }
            luaClosure.upValues[checkint - 1].setValue(arg);
            return findupvalue;
        }
    }

    /* loaded from: classes10.dex */
    final class setuservalue extends VarArgFunction {
        setuservalue() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            varargs.checkuserdata(1);
            LuaValue checkvalue = varargs.checkvalue(2);
            LuaUserdata luaUserdata = (LuaUserdata) varargs.arg1();
            luaUserdata.m_instance = checkvalue.checkuserdata();
            luaUserdata.m_metatable = checkvalue.getmetatable();
            return NONE;
        }
    }

    /* loaded from: classes10.dex */
    final class traceback extends VarArgFunction {
        traceback() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread;
            int i;
            if (varargs.isthread(1)) {
                luaThread = varargs.checkthread(1);
                i = 2;
            } else {
                luaThread = DebugLib.this.globals.running;
                i = 1;
            }
            int i2 = i + 1;
            String optjstring = varargs.optjstring(i, null);
            String traceback = DebugLib.this.callstack(luaThread).traceback(varargs.optint(i2, 1));
            if (optjstring != null) {
                traceback = new StringBuffer().append(optjstring).append("\n").append(traceback).toString();
            }
            return valueOf(traceback);
        }
    }

    /* loaded from: classes10.dex */
    final class upvalueid extends VarArgFunction {
        upvalueid() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaFunction checkfunction = varargs.checkfunction(1);
            int checkint = varargs.checkint(2);
            if (checkfunction instanceof LuaClosure) {
                LuaClosure luaClosure = (LuaClosure) checkfunction;
                if (luaClosure.upValues != null && checkint > 0 && checkint <= luaClosure.upValues.length) {
                    return valueOf(luaClosure.upValues[checkint - 1].hashCode());
                }
            }
            return NIL;
        }
    }

    /* loaded from: classes10.dex */
    final class upvaluejoin extends VarArgFunction {
        upvaluejoin() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaClosure checkclosure = varargs.checkclosure(1);
            int checkint = varargs.checkint(2);
            LuaClosure checkclosure2 = varargs.checkclosure(3);
            int checkint2 = varargs.checkint(4);
            if (checkint < 1 || checkint > checkclosure.upValues.length) {
                argerror("index out of range");
            }
            if (checkint2 < 1 || checkint2 > checkclosure2.upValues.length) {
                argerror("index out of range");
            }
            checkclosure.upValues[checkint - 1] = checkclosure2.upValues[checkint2 - 1];
            return NONE;
        }
    }

    static {
        try {
            CALLS = System.getProperty("CALLS") != null;
        } catch (Exception e) {
        }
        try {
            TRACE = System.getProperty("TRACE") != null;
        } catch (Exception e2) {
        }
        LUA = valueOf("Lua");
        QMARK = valueOf("?");
        CALL = valueOf(NotificationCompat.CATEGORY_CALL);
        LINE = valueOf("line");
        COUNT = valueOf("count");
        RETURN = valueOf("return");
        FUNC = valueOf("func");
        ISTAILCALL = valueOf("istailcall");
        ISVARARG = valueOf("isvararg");
        NUPS = valueOf("nups");
        NPARAMS = valueOf("nparams");
        NAME = valueOf("name");
        NAMEWHAT = valueOf("namewhat");
        WHAT = valueOf("what");
        SOURCE = valueOf("source");
        SHORT_SRC = valueOf("short_src");
        LINEDEFINED = valueOf("linedefined");
        LASTLINEDEFINED = valueOf("lastlinedefined");
        CURRENTLINE = valueOf("currentline");
        ACTIVELINES = valueOf("activelines");
    }

    static /* synthetic */ LuaString access$000() {
        return WHAT;
    }

    static /* synthetic */ LuaString access$100() {
        return LUA;
    }

    static /* synthetic */ LuaString access$1000() {
        return NAME;
    }

    static /* synthetic */ LuaString access$1100() {
        return NAMEWHAT;
    }

    static /* synthetic */ LuaString access$1200() {
        return ISTAILCALL;
    }

    static /* synthetic */ LuaString access$1300() {
        return ACTIVELINES;
    }

    static /* synthetic */ LuaString access$1400() {
        return FUNC;
    }

    static /* synthetic */ LuaString access$200() {
        return SOURCE;
    }

    static /* synthetic */ LuaString access$300() {
        return SHORT_SRC;
    }

    static /* synthetic */ LuaString access$400() {
        return LINEDEFINED;
    }

    static /* synthetic */ LuaString access$500() {
        return LASTLINEDEFINED;
    }

    static /* synthetic */ LuaString access$600() {
        return CURRENTLINE;
    }

    static /* synthetic */ LuaString access$700() {
        return NUPS;
    }

    static /* synthetic */ LuaString access$800() {
        return NPARAMS;
    }

    static /* synthetic */ LuaString access$900() {
        return ISVARARG;
    }

    static int findsetreg(Prototype prototype, int i, int i2) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i) {
            int i5 = prototype.code[i4];
            int GET_OPCODE = Lua.GET_OPCODE(i5);
            int GETARG_A = Lua.GETARG_A(i5);
            switch (GET_OPCODE) {
                case 4:
                    int GETARG_B = Lua.GETARG_B(i5);
                    if (GETARG_A <= i2) {
                        if (i2 > GETARG_A + GETARG_B) {
                            break;
                        }
                    } else {
                        break;
                    }
                    break;
                case 23:
                    int GETARG_sBx = Lua.GETARG_sBx(i5);
                    int i6 = i4 + 1 + GETARG_sBx;
                    if (i4 >= i6) {
                        continue;
                    } else if (i6 > i) {
                        break;
                    } else {
                        i4 += GETARG_sBx;
                        break;
                    }
                case 27:
                    if (i2 != GETARG_A) {
                        continue;
                    }
                    break;
                case 29:
                case 30:
                    if (i2 < GETARG_A) {
                        continue;
                    }
                    break;
                case 34:
                    if (i2 < GETARG_A + 2) {
                        break;
                    }
                    break;
                default:
                    if (!Lua.testAMode(GET_OPCODE)) {
                        break;
                    } else if (i2 != GETARG_A) {
                        break;
                    }
                    break;
            }
            i3 = i4;
            i4++;
        }
        return i3;
    }

    static LuaString findupvalue(LuaClosure luaClosure, int i) {
        if (luaClosure.upValues == null || i <= 0 || i > luaClosure.upValues.length) {
            return null;
        }
        return (luaClosure.p.upvalues == null || i > luaClosure.p.upvalues.length) ? LuaString.valueOf(new StringBuffer().append(".").append(i).toString()) : luaClosure.p.upvalues[i - 1].name;
    }

    static NameWhat getfuncname(CallFrame callFrame) {
        LuaString luaString;
        if (!callFrame.f.isclosure()) {
            return new NameWhat(callFrame.f.classnamestub(), "Java");
        }
        Prototype prototype = callFrame.f.checkclosure().p;
        int i = callFrame.pc;
        int i2 = prototype.code[i];
        switch (Lua.GET_OPCODE(i2)) {
            case 6:
            case 7:
            case 12:
                luaString = LuaValue.INDEX;
                break;
            case 8:
            case 10:
                luaString = LuaValue.NEWINDEX;
                break;
            case 9:
            case 11:
            case 20:
            case 23:
            case 27:
            case 28:
            case 31:
            case 32:
            case 33:
            default:
                return null;
            case 13:
                luaString = LuaValue.ADD;
                break;
            case 14:
                luaString = LuaValue.SUB;
                break;
            case 15:
                luaString = LuaValue.MUL;
                break;
            case 16:
                luaString = LuaValue.DIV;
                break;
            case 17:
                luaString = LuaValue.MOD;
                break;
            case 18:
                luaString = LuaValue.POW;
                break;
            case 19:
                luaString = LuaValue.UNM;
                break;
            case 21:
                luaString = LuaValue.LEN;
                break;
            case 22:
                luaString = LuaValue.CONCAT;
                break;
            case 24:
                luaString = LuaValue.EQ;
                break;
            case 25:
                luaString = LuaValue.LT;
                break;
            case 26:
                luaString = LuaValue.LE;
                break;
            case 29:
            case 30:
                return getobjname(prototype, i, Lua.GETARG_A(i2));
            case 34:
                return new NameWhat("(for iterator)", "(for iterator");
        }
        return new NameWhat(luaString.tojstring(), "metamethod");
    }

    public static NameWhat getobjname(Prototype prototype, int i, int i2) {
        LuaString luaString = prototype.getlocalname(i2 + 1, i);
        if (luaString != null) {
            return new NameWhat(luaString.tojstring(), "local");
        }
        int findsetreg = findsetreg(prototype, i, i2);
        if (findsetreg == -1) {
            return null;
        }
        int i3 = prototype.code[findsetreg];
        switch (Lua.GET_OPCODE(i3)) {
            case 0:
                int GETARG_A = Lua.GETARG_A(i3);
                int GETARG_B = Lua.GETARG_B(i3);
                if (GETARG_B < GETARG_A) {
                    return getobjname(prototype, findsetreg, GETARG_B);
                }
                return null;
            case 1:
            case 2:
                int GETARG_Bx = Lua.GET_OPCODE(i3) == 1 ? Lua.GETARG_Bx(i3) : Lua.GETARG_Ax(prototype.code[findsetreg + 1]);
                if (prototype.k[GETARG_Bx].isstring()) {
                    return new NameWhat(prototype.k[GETARG_Bx].strvalue().tojstring(), "constant");
                }
                return null;
            case 3:
            case 4:
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                return null;
            case 5:
                int GETARG_B2 = Lua.GETARG_B(i3);
                return new NameWhat((GETARG_B2 < prototype.upvalues.length ? prototype.upvalues[GETARG_B2].name : QMARK).tojstring(), "upvalue");
            case 6:
            case 7:
                int GETARG_C = Lua.GETARG_C(i3);
                int GETARG_B3 = Lua.GETARG_B(i3);
                LuaString luaString2 = Lua.GET_OPCODE(i3) == 7 ? prototype.getlocalname(GETARG_B3 + 1, findsetreg) : GETARG_B3 < prototype.upvalues.length ? prototype.upvalues[GETARG_B3].name : QMARK;
                return new NameWhat(kname(prototype, GETARG_C).tojstring(), (luaString2 == null || !luaString2.eq_b(ENV)) ? "field" : "global");
            case 12:
                return new NameWhat(kname(prototype, Lua.GETARG_C(i3)).tojstring(), "method");
        }
    }

    static LuaString kname(Prototype prototype, int i) {
        return (Lua.ISK(i) && prototype.k[Lua.INDEXK(i)].isstring()) ? prototype.k[Lua.INDEXK(i)].strvalue() : QMARK;
    }

    static void lua_assert(boolean z) {
        if (!z) {
            throw new RuntimeException("lua_assert failed");
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        this.globals.debuglib = this;
        LuaTable luaTable = new LuaTable();
        luaTable.set("debug", new debug());
        luaTable.set("gethook", new gethook());
        luaTable.set("getinfo", new getinfo());
        luaTable.set("getlocal", new getlocal());
        luaTable.set("getmetatable", new getmetatable());
        luaTable.set("getregistry", new getregistry());
        luaTable.set("getupvalue", new getupvalue());
        luaTable.set("getuservalue", new getuservalue());
        luaTable.set("sethook", new sethook());
        luaTable.set("setlocal", new setlocal());
        luaTable.set("setmetatable", new setmetatable());
        luaTable.set("setupvalue", new setupvalue());
        luaTable.set("setuservalue", new setuservalue());
        luaTable.set("traceback", new traceback());
        luaTable.set("upvalueid", new upvalueid());
        luaTable.set("upvaluejoin", new upvaluejoin());
        luaValue2.set("debug", luaTable);
        luaValue2.get("package").get("loaded").set("debug", luaTable);
        return luaTable;
    }

    void callHook(LuaThread.State state, LuaValue luaValue, LuaValue luaValue2) {
        if (state.inhook || state.hookfunc == null) {
            return;
        }
        state.inhook = true;
        try {
            try {
                state.hookfunc.call(luaValue, luaValue2);
            } catch (LuaError e) {
                throw e;
            } catch (RuntimeException e2) {
                throw new LuaError(e2);
            }
        } finally {
            state.inhook = false;
        }
    }

    CallStack callstack() {
        return callstack(this.globals.running);
    }

    CallStack callstack(LuaThread luaThread) {
        if (luaThread.callstack == null) {
            luaThread.callstack = new CallStack();
        }
        return (CallStack) luaThread.callstack;
    }

    public void onCall(LuaClosure luaClosure, Varargs varargs, LuaValue[] luaValueArr) {
        LuaThread.State state = this.globals.running.state;
        if (state.inhook) {
            return;
        }
        callstack().onCall(luaClosure, varargs, luaValueArr);
        if (state.hookcall) {
            callHook(state, CALL, NIL);
        }
    }

    public void onCall(LuaFunction luaFunction) {
        LuaThread.State state = this.globals.running.state;
        if (state.inhook) {
            return;
        }
        callstack().onCall(luaFunction);
        if (state.hookcall) {
            callHook(state, CALL, NIL);
        }
    }

    public void onInstruction(int i, Varargs varargs, int i2) {
        int currentline;
        LuaThread.State state = this.globals.running.state;
        if (state.inhook) {
            return;
        }
        callstack().onInstruction(i, varargs, i2);
        if (state.hookfunc == null) {
            return;
        }
        if (state.hookcount > 0) {
            int i3 = state.bytecodes + 1;
            state.bytecodes = i3;
            if (i3 % state.hookcount == 0) {
                callHook(state, COUNT, NIL);
            }
        }
        if (!state.hookline || (currentline = callstack().currentline()) == state.lastline) {
            return;
        }
        state.lastline = currentline;
        callHook(state, LINE, LuaValue.valueOf(currentline));
    }

    public void onReturn() {
        LuaThread.State state = this.globals.running.state;
        if (state.inhook) {
            return;
        }
        callstack().onReturn();
        if (state.hookrtrn) {
            callHook(state, RETURN, NIL);
        }
    }

    public String traceback(int i) {
        return callstack().traceback(i);
    }
}
