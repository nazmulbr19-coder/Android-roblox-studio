package org.luaj.vm2.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import org.luaj.vm2.LocVars;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.compiler.FuncState;
import org.luaj.vm2.compiler.LuaC;
import org.luaj.vm2.lib.MathLib;
import org.luaj.vm2.parser.LuaParserConstants;

/* loaded from: classes10.dex */
public class LexState extends Constants {
    private static final int EOZ = -1;
    static final int FIRST_RESERVED = 257;
    private static final int LUAI_MAXCCALLS = 200;
    private static final int LUA_COMPAT_LSTR = 1;
    private static final boolean LUA_COMPAT_VARARG = true;
    private static final int MAX_INT = 2147483645;
    static final int NO_JUMP = -1;
    static final int NUM_RESERVED = 22;
    static final int OPR_ADD = 0;
    static final int OPR_AND = 13;
    static final int OPR_CONCAT = 6;
    static final int OPR_DIV = 3;
    static final int OPR_EQ = 8;
    static final int OPR_GE = 12;
    static final int OPR_GT = 11;
    static final int OPR_LE = 10;
    static final int OPR_LEN = 2;
    static final int OPR_LT = 9;
    static final int OPR_MINUS = 0;
    static final int OPR_MOD = 4;
    static final int OPR_MUL = 2;
    static final int OPR_NE = 7;
    static final int OPR_NOBINOPR = 15;
    static final int OPR_NOT = 1;
    static final int OPR_NOUNOPR = 3;
    static final int OPR_OR = 14;
    static final int OPR_POW = 5;
    static final int OPR_SUB = 1;
    static final Hashtable RESERVED;
    protected static final String RESERVED_LOCAL_VAR_FOR_CONTROL = "(for control)";
    protected static final String RESERVED_LOCAL_VAR_FOR_GENERATOR = "(for generator)";
    protected static final String RESERVED_LOCAL_VAR_FOR_INDEX = "(for index)";
    protected static final String RESERVED_LOCAL_VAR_FOR_LIMIT = "(for limit)";
    protected static final String RESERVED_LOCAL_VAR_FOR_STATE = "(for state)";
    protected static final String RESERVED_LOCAL_VAR_FOR_STEP = "(for step)";
    protected static final String[] RESERVED_LOCAL_VAR_KEYWORDS = {RESERVED_LOCAL_VAR_FOR_CONTROL, RESERVED_LOCAL_VAR_FOR_GENERATOR, RESERVED_LOCAL_VAR_FOR_INDEX, RESERVED_LOCAL_VAR_FOR_LIMIT, RESERVED_LOCAL_VAR_FOR_STATE, RESERVED_LOCAL_VAR_FOR_STEP};
    private static final Hashtable RESERVED_LOCAL_VAR_KEYWORDS_TABLE = new Hashtable();
    static final int TK_AND = 257;
    static final int TK_BREAK = 258;
    static final int TK_CONCAT = 279;
    static final int TK_DBCOLON = 285;
    static final int TK_DO = 259;
    static final int TK_DOTS = 280;
    static final int TK_ELSE = 260;
    static final int TK_ELSEIF = 261;
    static final int TK_END = 262;
    static final int TK_EOS = 286;
    static final int TK_EQ = 281;
    static final int TK_FALSE = 263;
    static final int TK_FOR = 264;
    static final int TK_FUNCTION = 265;
    static final int TK_GE = 282;
    static final int TK_GOTO = 266;
    static final int TK_IF = 267;
    static final int TK_IN = 268;
    static final int TK_LE = 283;
    static final int TK_LOCAL = 269;
    static final int TK_NAME = 288;
    static final int TK_NE = 284;
    static final int TK_NIL = 270;
    static final int TK_NOT = 271;
    static final int TK_NUMBER = 287;
    static final int TK_OR = 272;
    static final int TK_REPEAT = 273;
    static final int TK_RETURN = 274;
    static final int TK_STRING = 289;
    static final int TK_THEN = 275;
    static final int TK_TRUE = 276;
    static final int TK_UNTIL = 277;
    static final int TK_WHILE = 278;
    private static final int UCHAR_MAX = 255;
    static final int UNARY_PRIORITY = 8;
    static final int VCALL = 12;
    static final int VFALSE = 3;
    static final int VINDEXED = 9;
    static final int VJMP = 10;
    static final int VK = 4;
    static final int VKNUM = 5;
    static final int VLOCAL = 7;
    static final int VNIL = 1;
    static final int VNONRELOC = 6;
    static final int VRELOCABLE = 11;
    static final int VTRUE = 2;
    static final int VUPVAL = 8;
    static final int VVARARG = 13;
    static final int VVOID = 0;
    static final String[] luaX_tokens;
    static Priority[] priority;
    LuaC.CompileState L;
    int current;
    byte decpoint;
    LuaString envn;
    FuncState fs;
    int lastline;
    int linenumber;
    int nbuff;
    LuaString source;
    InputStream z;
    final Token t = new Token(null);
    final Token lookahead = new Token(null);
    Dyndata dyd = new Dyndata();
    char[] buff = new char[32];

    /* loaded from: classes10.dex */
    static class ConsControl {
        int na;
        int nh;
        expdesc t;
        int tostore;
        expdesc v = new expdesc();

        ConsControl() {
        }
    }

    /* loaded from: classes10.dex */
    static class Dyndata {
        Vardesc[] actvar;
        Labeldesc[] gt;
        Labeldesc[] label;
        int n_actvar = 0;
        int n_gt = 0;
        int n_label = 0;

        Dyndata() {
        }
    }

    /* loaded from: classes10.dex */
    static class LHS_assign {
        LHS_assign prev;
        expdesc v = new expdesc();

        LHS_assign() {
        }
    }

    /* loaded from: classes10.dex */
    static class Labeldesc {
        int line;
        short nactvar;
        LuaString name;
        int pc;

        public Labeldesc(LuaString luaString, int i, int i2, short s) {
            this.name = luaString;
            this.pc = i;
            this.line = i2;
            this.nactvar = s;
        }
    }

    /* loaded from: classes10.dex */
    static class Priority {
        final byte left;
        final byte right;

        public Priority(int i, int i2) {
            this.left = (byte) i;
            this.right = (byte) i2;
        }
    }

    /* loaded from: classes10.dex */
    private static class SemInfo {
        LuaValue r;
        LuaString ts;

        private SemInfo() {
        }

        /* synthetic */ SemInfo(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    private static class Token {
        final SemInfo seminfo;
        int token;

        private Token() {
            this.seminfo = new SemInfo(null);
        }

        /* synthetic */ Token(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void set(Token token) {
            this.token = token.token;
            this.seminfo.r = token.seminfo.r;
            this.seminfo.ts = token.seminfo.ts;
        }
    }

    /* loaded from: classes10.dex */
    static class Vardesc {
        final short idx;

        Vardesc(int i) {
            this.idx = (short) i;
        }
    }

    /* loaded from: classes10.dex */
    static class expdesc {
        int k;
        final U u = new U();
        final IntPtr t = new IntPtr();
        final IntPtr f = new IntPtr();

        /* loaded from: classes10.dex */
        static class U {
            private LuaValue _nval;
            short ind_idx;
            short ind_t;
            short ind_vt;
            int info;

            U() {
            }

            static /* synthetic */ LuaValue access$200(U u) {
                return u._nval;
            }

            static /* synthetic */ LuaValue access$202(U u, LuaValue luaValue) {
                u._nval = luaValue;
                return luaValue;
            }

            public LuaValue nval() {
                return this._nval == null ? LuaInteger.valueOf(this.info) : this._nval;
            }

            public void setNval(LuaValue luaValue) {
                this._nval = luaValue;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasjumps() {
            return this.t.i != this.f.i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void init(int i, int i2) {
            this.f.i = -1;
            this.t.i = -1;
            this.k = i;
            this.u.info = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isnumeral() {
            return this.k == 5 && this.t.i == -1 && this.f.i == -1;
        }

        public void setvalue(expdesc expdescVar) {
            this.f.i = expdescVar.f.i;
            this.k = expdescVar.k;
            this.t.i = expdescVar.t.i;
            U.access$202(this.u, U.access$200(expdescVar.u));
            this.u.ind_idx = expdescVar.u.ind_idx;
            this.u.ind_t = expdescVar.u.ind_t;
            this.u.ind_vt = expdescVar.u.ind_vt;
            this.u.info = expdescVar.u.info;
        }
    }

    static {
        for (int i = 0; i < RESERVED_LOCAL_VAR_KEYWORDS.length; i++) {
            RESERVED_LOCAL_VAR_KEYWORDS_TABLE.put(RESERVED_LOCAL_VAR_KEYWORDS[i], Boolean.TRUE);
        }
        char c = 11;
        char c2 = '\f';
        luaX_tokens = new String[]{"and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while", "..", "...", "==", ">=", "<=", "~=", "::", "<eos>", "<number>", "<name>", "<string>", "<eof>"};
        RESERVED = new Hashtable();
        int i2 = 0;
        for (int i3 = 22; i2 < i3; i3 = 22) {
            RESERVED.put(LuaValue.valueOf(luaX_tokens[i2]), new Integer(i2 + 257));
            i2++;
            c = c;
            c2 = c2;
        }
        Priority[] priorityArr = new Priority[15];
        priorityArr[0] = new Priority(6, 6);
        priorityArr[1] = new Priority(6, 6);
        priorityArr[2] = new Priority(7, 7);
        priorityArr[3] = new Priority(7, 7);
        priorityArr[4] = new Priority(7, 7);
        priorityArr[5] = new Priority(10, 9);
        priorityArr[6] = new Priority(5, 4);
        priorityArr[7] = new Priority(3, 3);
        priorityArr[8] = new Priority(3, 3);
        priorityArr[9] = new Priority(3, 3);
        priorityArr[10] = new Priority(3, 3);
        priorityArr[c] = new Priority(3, 3);
        priorityArr[c2] = new Priority(3, 3);
        priorityArr[13] = new Priority(2, 2);
        priorityArr[14] = new Priority(1, 1);
        priority = priorityArr;
    }

    public LexState(LuaC.CompileState compileState, InputStream inputStream) {
        this.z = inputStream;
        this.L = compileState;
    }

    private static final String LUA_QL(Object obj) {
        return LUA_QS(String.valueOf(obj));
    }

    private static final String LUA_QS(String str) {
        return new StringBuffer().append("'").append(str).append("'").toString();
    }

    public static boolean isReservedKeyword(String str) {
        return RESERVED_LOCAL_VAR_KEYWORDS_TABLE.containsKey(str);
    }

    private boolean isalnum(int i) {
        return (i >= 48 && i <= 57) || (i >= 97 && i <= 122) || ((i >= 65 && i <= 90) || i == 95);
    }

    private boolean isalpha(int i) {
        return (i >= 97 && i <= 122) || (i >= 65 && i <= 90);
    }

    private static boolean iscntrl(int i) {
        return i < 32;
    }

    private boolean isdigit(int i) {
        return i >= 48 && i <= 57;
    }

    private boolean isspace(int i) {
        return i <= 32;
    }

    private boolean isxdigit(int i) {
        return (i >= 48 && i <= 57) || (i >= 97 && i <= 102) || (i >= 65 && i <= 70);
    }

    static int luaO_int2fb(int i) {
        int i2 = 0;
        while (i >= 16) {
            i = (i + 1) >> 1;
            i2++;
        }
        return i < 8 ? i : ((i2 + 1) << 3) | (i - 8);
    }

    private void skipShebang() {
        if (this.current == 35) {
            while (!currIsNewline() && this.current != -1) {
                nextChar();
            }
        }
    }

    static final boolean vkisinreg(int i) {
        return i == 6 || i == 7;
    }

    static final boolean vkisvar(int i) {
        return 7 <= i && i <= 9;
    }

    Prototype addprototype() {
        Prototype prototype = this.fs.f;
        if (prototype.p == null || this.fs.np >= prototype.p.length) {
            prototype.p = realloc(prototype.p, Math.max(1, this.fs.np * 2));
        }
        Prototype[] prototypeArr = prototype.p;
        FuncState funcState = this.fs;
        int i = funcState.np;
        funcState.np = i + 1;
        Prototype prototype2 = new Prototype();
        prototypeArr[i] = prototype2;
        return prototype2;
    }

    void adjust_assign(int i, int i2, expdesc expdescVar) {
        FuncState funcState = this.fs;
        int i3 = i - i2;
        if (hasmultret(expdescVar.k)) {
            int i4 = i3 + 1;
            if (i4 < 0) {
                i4 = 0;
            }
            funcState.setreturns(expdescVar, i4);
            if (i4 > 1) {
                funcState.reserveregs(i4 - 1);
                return;
            }
            return;
        }
        if (expdescVar.k != 0) {
            funcState.exp2nextreg(expdescVar);
        }
        if (i3 > 0) {
            short s = funcState.freereg;
            funcState.reserveregs(i3);
            funcState.nil(s, i3);
        }
    }

    void adjustlocalvars(int i) {
        FuncState funcState = this.fs;
        funcState.nactvar = (short) (funcState.nactvar + i);
        while (i > 0) {
            funcState.getlocvar(funcState.nactvar - i).startpc = funcState.pc;
            i--;
        }
    }

    void anchor_token() {
        _assert(this.fs != null || this.t.token == TK_EOS);
        if (this.t.token == TK_NAME || this.t.token == TK_STRING) {
            LuaString luaString = this.t.seminfo.ts;
            this.L.cachedLuaString(this.t.seminfo.ts);
        }
    }

    void assignment(LHS_assign lHS_assign, int i) {
        expdesc expdescVar = new expdesc();
        check_condition(7 <= lHS_assign.v.k && lHS_assign.v.k <= 9, "syntax error");
        if (testnext(44)) {
            LHS_assign lHS_assign2 = new LHS_assign();
            lHS_assign2.prev = lHS_assign;
            suffixedexp(lHS_assign2.v);
            if (lHS_assign2.v.k != 9) {
                check_conflict(lHS_assign, lHS_assign2.v);
            }
            assignment(lHS_assign2, i + 1);
        } else {
            checknext(61);
            int explist = explist(expdescVar);
            if (explist == i) {
                this.fs.setoneret(expdescVar);
                this.fs.storevar(lHS_assign.v, expdescVar);
            } else {
                adjust_assign(i, explist, expdescVar);
                if (explist > i) {
                    FuncState funcState = this.fs;
                    funcState.freereg = (short) (funcState.freereg - (explist - i));
                }
            }
        }
        expdescVar.init(6, this.fs.freereg - 1);
        this.fs.storevar(lHS_assign.v, expdescVar);
    }

    void block() {
        FuncState funcState = this.fs;
        funcState.enterblock(new FuncState.BlockCnt(), false);
        statlist();
        funcState.leaveblock();
    }

    boolean block_follow(boolean z) {
        switch (this.t.token) {
            case TK_ELSE /* 260 */:
            case TK_ELSEIF /* 261 */:
            case TK_END /* 262 */:
            case TK_EOS /* 286 */:
                return true;
            case TK_UNTIL /* 277 */:
                return z;
            default:
                return false;
        }
    }

    void body(expdesc expdescVar, boolean z, int i) {
        FuncState funcState = new FuncState();
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        funcState.f = addprototype();
        funcState.f.linedefined = i;
        open_func(funcState, blockCnt);
        checknext(40);
        if (z) {
            new_localvarliteral("self");
            adjustlocalvars(1);
        }
        parlist();
        checknext(41);
        statlist();
        funcState.f.lastlinedefined = this.linenumber;
        check_match(TK_END, TK_FUNCTION, i);
        codeclosure(expdescVar);
        close_func();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void breaklabel() {
        LuaString valueOf = LuaString.valueOf("break");
        Dyndata dyndata = this.dyd;
        Labeldesc[] grow = grow(this.dyd.label, this.dyd.n_label + 1);
        dyndata.label = grow;
        Dyndata dyndata2 = this.dyd;
        int i = dyndata2.n_label;
        dyndata2.n_label = i + 1;
        findgotos(this.dyd.label[newlabelentry(grow, i, valueOf, 0, this.fs.pc)]);
    }

    void buffreplace(char c, char c2) {
        int i = this.nbuff;
        char[] cArr = this.buff;
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            if (cArr[i] == c) {
                cArr[i] = c2;
            }
        }
    }

    void check(int i) {
        if (this.t.token != i) {
            error_expected(i);
        }
    }

    void check_condition(boolean z, String str) {
        if (z) {
            return;
        }
        syntaxerror(str);
    }

    void check_conflict(LHS_assign lHS_assign, expdesc expdescVar) {
        FuncState funcState = this.fs;
        short s = funcState.freereg;
        boolean z = false;
        while (lHS_assign != null) {
            if (lHS_assign.v.k == 9) {
                if (lHS_assign.v.u.ind_vt == expdescVar.k && lHS_assign.v.u.ind_t == expdescVar.u.info) {
                    lHS_assign.v.u.ind_vt = (short) 7;
                    lHS_assign.v.u.ind_t = s;
                    z = true;
                }
                if (expdescVar.k == 7 && lHS_assign.v.u.ind_idx == expdescVar.u.info) {
                    lHS_assign.v.u.ind_idx = s;
                    z = true;
                }
            }
            lHS_assign = lHS_assign.prev;
        }
        if (z) {
            funcState.codeABC(expdescVar.k == 7 ? 0 : 5, s, expdescVar.u.info, 0);
            funcState.reserveregs(1);
        }
    }

    void check_match(int i, int i2, int i3) {
        if (testnext(i)) {
            return;
        }
        if (i3 == this.linenumber) {
            error_expected(i);
        } else {
            syntaxerror(this.L.pushfstring(new StringBuffer().append(LUA_QS(token2str(i))).append(" expected ").append("(to close ").append(LUA_QS(token2str(i2))).append(" at line ").append(i3).append(")").toString()));
        }
    }

    boolean check_next(String str) {
        if (str.indexOf(this.current) < 0) {
            return false;
        }
        save_and_next();
        return true;
    }

    void checkname(expdesc expdescVar) {
        codestring(expdescVar, str_checkname());
    }

    void checknext(int i) {
        check(i);
        next();
    }

    void close_func() {
        FuncState funcState = this.fs;
        Prototype prototype = funcState.f;
        funcState.ret(0, 0);
        funcState.leaveblock();
        prototype.code = realloc(prototype.code, funcState.pc);
        prototype.lineinfo = realloc(prototype.lineinfo, funcState.pc);
        prototype.k = realloc(prototype.k, funcState.nk);
        prototype.p = realloc(prototype.p, funcState.np);
        prototype.locvars = realloc(prototype.locvars, funcState.nlocvars);
        prototype.upvalues = realloc(prototype.upvalues, funcState.nups);
        _assert(funcState.bl == null);
        this.fs = funcState.prev;
    }

    void closegoto(int i, Labeldesc labeldesc) {
        FuncState funcState = this.fs;
        Labeldesc[] labeldescArr = this.dyd.gt;
        Labeldesc labeldesc2 = labeldescArr[i];
        _assert(labeldesc2.name.eq_b(labeldesc.name));
        if (labeldesc2.nactvar < labeldesc.nactvar) {
            semerror(this.L.pushfstring(new StringBuffer().append("<goto ").append(labeldesc2.name).append("> at line ").append(labeldesc2.line).append(" jumps into the scope of local '").append(funcState.getlocvar(labeldesc2.nactvar).varname.tojstring()).append("'").toString()));
        }
        funcState.patchlist(labeldesc2.pc, labeldesc.pc);
        System.arraycopy(labeldescArr, i + 1, labeldescArr, i, (this.dyd.n_gt - i) - 1);
        Dyndata dyndata = this.dyd;
        int i2 = dyndata.n_gt - 1;
        dyndata.n_gt = i2;
        labeldescArr[i2] = null;
    }

    void codeclosure(expdesc expdescVar) {
        FuncState funcState = this.fs.prev;
        expdescVar.init(11, funcState.codeABx(37, 0, funcState.np - 1));
        funcState.exp2nextreg(expdescVar);
    }

    void codestring(expdesc expdescVar, LuaString luaString) {
        expdescVar.init(4, this.fs.stringK(luaString));
    }

    int cond() {
        expdesc expdescVar = new expdesc();
        expr(expdescVar);
        if (expdescVar.k == 1) {
            expdescVar.k = 3;
        }
        this.fs.goiftrue(expdescVar);
        return expdescVar.f.i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0054, code lost:
    
        if (r8.lookahead.token != 61) goto L16;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0047. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void constructor(org.luaj.vm2.compiler.LexState.expdesc r9) {
        /*
            r8 = this;
            org.luaj.vm2.compiler.FuncState r0 = r8.fs
            int r1 = r8.linenumber
            r2 = 11
            r3 = 0
            int r4 = r0.codeABC(r2, r3, r3, r3)
            org.luaj.vm2.compiler.LexState$ConsControl r5 = new org.luaj.vm2.compiler.LexState$ConsControl
            r5.<init>()
            r5.tostore = r3
            r5.nh = r3
            r5.na = r3
            r5.t = r9
            r9.init(r2, r4)
            org.luaj.vm2.compiler.LexState$expdesc r2 = r5.v
            r2.init(r3, r3)
            r0.exp2nextreg(r9)
            r9 = 123(0x7b, float:1.72E-43)
            r8.checknext(r9)
        L28:
            org.luaj.vm2.compiler.LexState$expdesc r2 = r5.v
            int r2 = r2.k
            if (r2 == 0) goto L34
            int r2 = r5.tostore
            if (r2 > 0) goto L34
            r2 = r3
            goto L35
        L34:
            r2 = 1
        L35:
            _assert(r2)
            org.luaj.vm2.compiler.LexState$Token r2 = r8.t
            int r2 = r2.token
            r6 = 125(0x7d, float:1.75E-43)
            if (r2 == r6) goto L6d
            r0.closelistfield(r5)
            org.luaj.vm2.compiler.LexState$Token r2 = r8.t
            int r2 = r2.token
            switch(r2) {
                case 91: goto L5a;
                case 288: goto L4b;
                default: goto L4a;
            }
        L4a:
            goto L56
        L4b:
            r8.lookahead()
            org.luaj.vm2.compiler.LexState$Token r2 = r8.lookahead
            int r2 = r2.token
            r7 = 61
            if (r2 == r7) goto L5a
        L56:
            r8.listfield(r5)
            goto L5d
        L5a:
            r8.recfield(r5)
        L5d:
            r2 = 44
            boolean r2 = r8.testnext(r2)
            if (r2 != 0) goto L28
            r2 = 59
            boolean r2 = r8.testnext(r2)
            if (r2 != 0) goto L28
        L6d:
            r8.check_match(r6, r9, r1)
            r0.lastlistfield(r5)
            org.luaj.vm2.compiler.InstructionPtr r9 = new org.luaj.vm2.compiler.InstructionPtr
            org.luaj.vm2.Prototype r0 = r0.f
            int[] r0 = r0.code
            r9.<init>(r0, r4)
            int r0 = r5.na
            int r0 = luaO_int2fb(r0)
            SETARG_B(r9, r0)
            int r0 = r5.nh
            int r0 = luaO_int2fb(r0)
            SETARG_C(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.compiler.LexState.constructor(org.luaj.vm2.compiler.LexState$expdesc):void");
    }

    boolean currIsNewline() {
        return this.current == 10 || this.current == 13;
    }

    void enterlevel() {
        LuaC.CompileState compileState = this.L;
        int i = compileState.nCcalls + 1;
        compileState.nCcalls = i;
        if (i > 200) {
            lexerror("chunk has too many syntax levels", 0);
        }
    }

    void error_expected(int i) {
        syntaxerror(this.L.pushfstring(new StringBuffer().append(LUA_QS(token2str(i))).append(" expected").toString()));
    }

    int exp1() {
        expdesc expdescVar = new expdesc();
        expr(expdescVar);
        int i = expdescVar.k;
        this.fs.exp2nextreg(expdescVar);
        return i;
    }

    int explist(expdesc expdescVar) {
        expr(expdescVar);
        int i = 1;
        while (testnext(44)) {
            this.fs.exp2nextreg(expdescVar);
            expr(expdescVar);
            i++;
        }
        return i;
    }

    void expr(expdesc expdescVar) {
        subexpr(expdescVar, 0);
    }

    void exprstat() {
        FuncState funcState = this.fs;
        LHS_assign lHS_assign = new LHS_assign();
        suffixedexp(lHS_assign.v);
        if (this.t.token == 61 || this.t.token == 44) {
            lHS_assign.prev = null;
            assignment(lHS_assign, 1);
        } else {
            check_condition(lHS_assign.v.k == 12, "syntax error");
            SETARG_C(funcState.getcodePtr(lHS_assign.v), 1);
        }
    }

    void fieldsel(expdesc expdescVar) {
        FuncState funcState = this.fs;
        expdesc expdescVar2 = new expdesc();
        funcState.exp2anyregup(expdescVar);
        next();
        checkname(expdescVar2);
        funcState.indexed(expdescVar, expdescVar2);
    }

    void findgotos(Labeldesc labeldesc) {
        Labeldesc[] labeldescArr = this.dyd.gt;
        int i = this.fs.bl.firstgoto;
        while (i < this.dyd.n_gt) {
            if (labeldescArr[i].name.eq_b(labeldesc.name)) {
                closegoto(i, labeldesc);
            } else {
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean findlabel(int i) {
        FuncState.BlockCnt blockCnt = this.fs.bl;
        Dyndata dyndata = this.dyd;
        Labeldesc labeldesc = dyndata.gt[i];
        for (int i2 = blockCnt.firstlabel; i2 < dyndata.n_label; i2++) {
            Labeldesc labeldesc2 = dyndata.label[i2];
            if (labeldesc2.name.eq_b(labeldesc.name)) {
                if (labeldesc.nactvar > labeldesc2.nactvar && (blockCnt.upval || dyndata.n_label > blockCnt.firstlabel)) {
                    this.fs.patchclose(labeldesc.pc, labeldesc2.nactvar);
                }
                closegoto(i, labeldesc2);
                return true;
            }
        }
        return false;
    }

    void forbody(int i, int i2, int i3, boolean z) {
        int i4;
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        FuncState funcState = this.fs;
        adjustlocalvars(3);
        checknext(TK_DO);
        int codeAsBx = z ? funcState.codeAsBx(33, i, -1) : funcState.jump();
        funcState.enterblock(blockCnt, false);
        adjustlocalvars(i3);
        funcState.reserveregs(i3);
        block();
        funcState.leaveblock();
        funcState.patchtohere(codeAsBx);
        if (z) {
            i4 = 32;
        } else {
            funcState.codeABC(34, i, 0, i3);
            funcState.fixline(i2);
            i += 2;
            i4 = 35;
        }
        funcState.patchlist(funcState.codeAsBx(i4, i, -1), codeAsBx + 1);
        funcState.fixline(i2);
    }

    void forlist(LuaString luaString) {
        FuncState funcState = this.fs;
        expdesc expdescVar = new expdesc();
        short s = funcState.freereg;
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_GENERATOR);
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_STATE);
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_CONTROL);
        new_localvar(luaString);
        int i = 4;
        while (testnext(44)) {
            new_localvar(str_checkname());
            i++;
        }
        checknext(TK_IN);
        int i2 = this.linenumber;
        adjust_assign(3, explist(expdescVar), expdescVar);
        funcState.checkstack(3);
        forbody(s, i2, i - 3, false);
    }

    void fornum(LuaString luaString, int i) {
        FuncState funcState = this.fs;
        short s = funcState.freereg;
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_INDEX);
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_LIMIT);
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_STEP);
        new_localvar(luaString);
        checknext(61);
        exp1();
        checknext(44);
        exp1();
        if (testnext(44)) {
            exp1();
        } else {
            funcState.codeABx(1, funcState.freereg, funcState.numberK(LuaInteger.valueOf(1)));
            funcState.reserveregs(1);
        }
        forbody(s, i, 1, true);
    }

    void forstat(int i) {
        FuncState funcState = this.fs;
        funcState.enterblock(new FuncState.BlockCnt(), true);
        next();
        LuaString str_checkname = str_checkname();
        switch (this.t.token) {
            case 44:
            case TK_IN /* 268 */:
                forlist(str_checkname);
                break;
            case 61:
                fornum(str_checkname, i);
                break;
            default:
                syntaxerror(new StringBuffer().append(LUA_QL("=")).append(" or ").append(LUA_QL("in")).append(" expected").toString());
                break;
        }
        check_match(TK_END, 264, i);
        funcState.leaveblock();
    }

    void funcargs(expdesc expdescVar, int i) {
        int i2;
        FuncState funcState = this.fs;
        expdesc expdescVar2 = new expdesc();
        switch (this.t.token) {
            case 40:
                next();
                if (this.t.token == 41) {
                    expdescVar2.k = 0;
                } else {
                    explist(expdescVar2);
                    funcState.setmultret(expdescVar2);
                }
                check_match(41, 40, i);
                break;
            case 123:
                constructor(expdescVar2);
                break;
            case TK_STRING /* 289 */:
                codestring(expdescVar2, this.t.seminfo.ts);
                next();
                break;
            default:
                syntaxerror("function arguments expected");
                return;
        }
        _assert(expdescVar.k == 6);
        int i3 = expdescVar.u.info;
        if (hasmultret(expdescVar2.k)) {
            i2 = -1;
        } else {
            if (expdescVar2.k != 0) {
                funcState.exp2nextreg(expdescVar2);
            }
            i2 = funcState.freereg - (i3 + 1);
        }
        expdescVar.init(12, funcState.codeABC(29, i3, i2 + 1, 2));
        funcState.fixline(i);
        funcState.freereg = (short) (i3 + 1);
    }

    boolean funcname(expdesc expdescVar) {
        singlevar(expdescVar);
        while (this.t.token == 46) {
            fieldsel(expdescVar);
        }
        if (this.t.token != 58) {
            return false;
        }
        fieldsel(expdescVar);
        return true;
    }

    void funcstat(int i) {
        expdesc expdescVar = new expdesc();
        expdesc expdescVar2 = new expdesc();
        next();
        body(expdescVar2, funcname(expdescVar), i);
        this.fs.storevar(expdescVar, expdescVar2);
        this.fs.fixline(i);
    }

    int getbinopr(int i) {
        switch (i) {
            case 37:
                return 4;
            case 42:
                return 2;
            case 43:
                return 0;
            case 45:
                return 1;
            case 47:
                return 3;
            case 60:
                return 9;
            case 62:
                return 11;
            case 94:
                return 5;
            case 257:
                return 13;
            case 272:
                return 14;
            case TK_CONCAT /* 279 */:
                return 6;
            case TK_EQ /* 281 */:
                return 8;
            case TK_GE /* 282 */:
                return 12;
            case TK_LE /* 283 */:
                return 10;
            case 284:
                return 7;
            default:
                return 15;
        }
    }

    int getunopr(int i) {
        switch (i) {
            case 35:
                return 2;
            case 45:
                return 0;
            case TK_NOT /* 271 */:
                return 1;
            default:
                return 3;
        }
    }

    void gotostat(int i) {
        LuaString valueOf;
        int i2 = this.linenumber;
        if (testnext(TK_GOTO)) {
            valueOf = str_checkname();
        } else {
            next();
            valueOf = LuaString.valueOf("break");
        }
        LuaString luaString = valueOf;
        Dyndata dyndata = this.dyd;
        Labeldesc[] grow = grow(this.dyd.gt, this.dyd.n_gt + 1);
        dyndata.gt = grow;
        Dyndata dyndata2 = this.dyd;
        int i3 = dyndata2.n_gt;
        dyndata2.n_gt = i3 + 1;
        findlabel(newlabelentry(grow, i3, luaString, i2, i));
    }

    boolean hasmultret(int i) {
        return i == 12 || i == 13;
    }

    int hexvalue(int i) {
        return i <= 57 ? i - 48 : i <= 70 ? (i + 10) - 65 : (i + 10) - 97;
    }

    void ifstat(int i) {
        IntPtr intPtr = new IntPtr(-1);
        do {
            test_then_block(intPtr);
        } while (this.t.token == TK_ELSEIF);
        if (testnext(TK_ELSE)) {
            block();
        }
        check_match(TK_END, TK_IF, i);
        this.fs.patchtohere(intPtr.i);
    }

    void inclinenumber() {
        int i = this.current;
        _assert(currIsNewline());
        nextChar();
        if (currIsNewline() && this.current != i) {
            nextChar();
        }
        int i2 = this.linenumber + 1;
        this.linenumber = i2;
        if (i2 >= MAX_INT) {
            syntaxerror("chunk has too many lines");
        }
    }

    void labelstat(LuaString luaString, int i) {
        this.fs.checkrepeated(this.dyd.label, this.dyd.n_label, luaString);
        checknext(TK_DBCOLON);
        Dyndata dyndata = this.dyd;
        Labeldesc[] grow = grow(this.dyd.label, this.dyd.n_label + 1);
        dyndata.label = grow;
        Dyndata dyndata2 = this.dyd;
        int i2 = dyndata2.n_label;
        dyndata2.n_label = i2 + 1;
        int newlabelentry = newlabelentry(grow, i2, luaString, i, this.fs.pc);
        skipnoopstat();
        if (block_follow(false)) {
            this.dyd.label[newlabelentry].nactvar = this.fs.bl.nactvar;
        }
        findgotos(this.dyd.label[newlabelentry]);
    }

    void leavelevel() {
        LuaC.CompileState compileState = this.L;
        compileState.nCcalls--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lexerror(String str, int i) {
        String chunkid = Lua.chunkid(this.source.tojstring());
        this.L.pushfstring(new StringBuffer().append(chunkid).append(":").append(this.linenumber).append(": ").append(str).toString());
        if (i != 0) {
            this.L.pushfstring(new StringBuffer().append("syntax error: ").append(str).append(" near ").append(txtToken(i)).toString());
        }
        throw new LuaError(new StringBuffer().append(chunkid).append(":").append(this.linenumber).append(": ").append(str).toString());
    }

    void listfield(ConsControl consControl) {
        expr(consControl.v);
        this.fs.checklimit(consControl.na, MAX_INT, "items in a constructor");
        consControl.na++;
        consControl.tostore++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        nextChar();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r7.current == 61) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        return 61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        nextChar();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
    
        return org.luaj.vm2.compiler.LexState.TK_EQ;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ef, code lost:
    
        read_numeral(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f2, code lost:
    
        return org.luaj.vm2.compiler.LexState.TK_NUMBER;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000e. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int llex(org.luaj.vm2.compiler.LexState.SemInfo r8) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.compiler.LexState.llex(org.luaj.vm2.compiler.LexState$SemInfo):int");
    }

    void localfunc() {
        expdesc expdescVar = new expdesc();
        FuncState funcState = this.fs;
        new_localvar(str_checkname());
        adjustlocalvars(1);
        body(expdescVar, false, this.linenumber);
        funcState.getlocvar(funcState.nactvar - 1).startpc = funcState.pc;
    }

    void localstat() {
        expdesc expdescVar = new expdesc();
        int i = 0;
        int i2 = 0;
        do {
            new_localvar(str_checkname());
            i2++;
        } while (testnext(44));
        if (testnext(61)) {
            i = explist(expdescVar);
        } else {
            expdescVar.k = 0;
        }
        adjust_assign(i2, i, expdescVar);
        adjustlocalvars(i2);
    }

    void lookahead() {
        _assert(this.lookahead.token == TK_EOS);
        this.lookahead.token = llex(this.lookahead.seminfo);
    }

    public void mainfunc(FuncState funcState) {
        open_func(funcState, new FuncState.BlockCnt());
        this.fs.f.is_vararg = 1;
        expdesc expdescVar = new expdesc();
        expdescVar.init(7, 0);
        this.fs.newupvalue(this.envn, expdescVar);
        next();
        statlist();
        check(TK_EOS);
        close_func();
    }

    void new_localvar(LuaString luaString) {
        int registerlocalvar = registerlocalvar(luaString);
        this.fs.checklimit(this.dyd.n_actvar + 1, 200, "local variables");
        if (this.dyd.actvar == null || this.dyd.n_actvar + 1 > this.dyd.actvar.length) {
            this.dyd.actvar = realloc(this.dyd.actvar, Math.max(1, this.dyd.n_actvar * 2));
        }
        Vardesc[] vardescArr = this.dyd.actvar;
        Dyndata dyndata = this.dyd;
        int i = dyndata.n_actvar;
        dyndata.n_actvar = i + 1;
        vardescArr[i] = new Vardesc(registerlocalvar);
    }

    void new_localvarliteral(String str) {
        new_localvar(newstring(str));
    }

    int newlabelentry(Labeldesc[] labeldescArr, int i, LuaString luaString, int i2, int i3) {
        labeldescArr[i] = new Labeldesc(luaString, i3, i2, this.fs.nactvar);
        return i;
    }

    LuaString newstring(String str) {
        return this.L.newTString(str);
    }

    LuaString newstring(char[] cArr, int i, int i2) {
        return this.L.newTString(new String(cArr, i, i2));
    }

    void next() {
        Token token;
        this.lastline = this.linenumber;
        int i = this.lookahead.token;
        int i2 = TK_EOS;
        if (i != TK_EOS) {
            this.t.set(this.lookahead);
            token = this.lookahead;
        } else {
            token = this.t;
            i2 = llex(this.t.seminfo);
        }
        token.token = i2;
    }

    void nextChar() {
        try {
            this.current = this.z.read();
        } catch (IOException e) {
            e.printStackTrace();
            this.current = -1;
        }
    }

    void open_func(FuncState funcState, FuncState.BlockCnt blockCnt) {
        funcState.prev = this.fs;
        funcState.ls = this;
        this.fs = funcState;
        funcState.pc = 0;
        funcState.lasttarget = -1;
        funcState.jpc = new IntPtr(-1);
        funcState.freereg = (short) 0;
        funcState.nk = 0;
        funcState.np = 0;
        funcState.nups = (short) 0;
        funcState.nlocvars = (short) 0;
        funcState.nactvar = (short) 0;
        funcState.firstlocal = this.dyd.n_actvar;
        funcState.bl = null;
        funcState.f.source = this.source;
        funcState.f.maxstacksize = 2;
        funcState.enterblock(blockCnt, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        new_localvar(str_checkname());
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        next();
        r1.is_vararg = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        adjustlocalvars(r2);
        r1.numparams = r0.nactvar;
        r0.reserveregs(r0.nactvar);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000d, code lost:
    
        if (r5.t.token != 41) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        switch(r5.t.token) {
            case 280: goto L8;
            case 288: goto L7;
            default: goto L6;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
    
        syntaxerror(new java.lang.StringBuffer().append("<name> or ").append(LUA_QL("...")).append(" expected").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x004b, code lost:
    
        if (r1.is_vararg != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0053, code lost:
    
        if (testnext(44) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void parlist() {
        /*
            r5 = this;
            org.luaj.vm2.compiler.FuncState r0 = r5.fs
            org.luaj.vm2.Prototype r1 = r0.f
            r2 = 0
            r1.is_vararg = r2
            org.luaj.vm2.compiler.LexState$Token r3 = r5.t
            int r3 = r3.token
            r4 = 41
            if (r3 == r4) goto L55
        Lf:
            org.luaj.vm2.compiler.LexState$Token r3 = r5.t
            int r3 = r3.token
            switch(r3) {
                case 280: goto L43;
                case 288: goto L39;
                default: goto L16;
            }
        L16:
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r4 = "<name> or "
            java.lang.StringBuffer r3 = r3.append(r4)
            java.lang.String r4 = "..."
            java.lang.String r4 = LUA_QL(r4)
            java.lang.StringBuffer r3 = r3.append(r4)
            java.lang.String r4 = " expected"
            java.lang.StringBuffer r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r5.syntaxerror(r3)
            goto L49
        L39:
            org.luaj.vm2.LuaString r3 = r5.str_checkname()
            r5.new_localvar(r3)
            int r2 = r2 + 1
            goto L49
        L43:
            r5.next()
            r3 = 1
            r1.is_vararg = r3
        L49:
            int r3 = r1.is_vararg
            if (r3 != 0) goto L55
            r3 = 44
            boolean r3 = r5.testnext(r3)
            if (r3 != 0) goto Lf
        L55:
            r5.adjustlocalvars(r2)
            short r2 = r0.nactvar
            r1.numparams = r2
            short r1 = r0.nactvar
            r0.reserveregs(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.compiler.LexState.parlist():void");
    }

    void primaryexp(expdesc expdescVar) {
        switch (this.t.token) {
            case 40:
                int i = this.linenumber;
                next();
                expr(expdescVar);
                check_match(41, 40, i);
                this.fs.dischargevars(expdescVar);
                return;
            case TK_NAME /* 288 */:
                singlevar(expdescVar);
                return;
            default:
                syntaxerror(new StringBuffer().append("unexpected symbol ").append(this.t.token).append(" (").append((char) this.t.token).append(")").toString());
                return;
        }
    }

    void read_long_string(SemInfo semInfo, int i) {
        String str;
        int i2;
        save_and_next();
        if (currIsNewline()) {
            inclinenumber();
        }
        boolean z = false;
        while (!z) {
            switch (this.current) {
                case -1:
                    str = semInfo != null ? "unfinished long string" : "unfinished long comment";
                    i2 = TK_EOS;
                    break;
                case 10:
                case 13:
                    save(10);
                    inclinenumber();
                    if (semInfo == null) {
                        this.nbuff = 0;
                        break;
                    } else {
                        continue;
                    }
                case 91:
                    if (skip_sep() != i) {
                        break;
                    } else {
                        save_and_next();
                        if (i != 0) {
                            break;
                        } else {
                            str = "nesting of [[...]] is deprecated";
                            i2 = 91;
                            break;
                        }
                    }
                case 93:
                    if (skip_sep() == i) {
                        save_and_next();
                        z = true;
                        break;
                    } else {
                        continue;
                    }
                default:
                    if (semInfo != null) {
                        save_and_next();
                        break;
                    } else {
                        nextChar();
                        continue;
                    }
            }
            lexerror(str, i2);
        }
        if (semInfo != null) {
            int i3 = i + 2;
            semInfo.ts = this.L.newTString(LuaString.valueOf(this.buff, i3, this.nbuff - (i3 * 2)));
        }
    }

    void read_numeral(SemInfo semInfo) {
        int i = this.current;
        _assert(isdigit(this.current));
        save_and_next();
        String str = (i == 48 && check_next("Xx")) ? "Pp" : "Ee";
        while (true) {
            if (check_next(str)) {
                check_next("+-");
            }
            if (!isxdigit(this.current) && this.current != 46) {
                save(0);
                str2d(new String(this.buff, 0, this.nbuff), semInfo);
                return;
            }
            save_and_next();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0019. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void read_string(int r7, org.luaj.vm2.compiler.LexState.SemInfo r8) {
        /*
            r6 = this;
        L0:
            r6.save_and_next()
        L3:
            int r0 = r6.current
            r1 = 1
            if (r0 == r7) goto L8e
            int r0 = r6.current
            r2 = 289(0x121, float:4.05E-43)
            java.lang.String r3 = "unfinished string"
            switch(r0) {
                case -1: goto L87;
                case 10: goto L82;
                case 13: goto L82;
                case 92: goto L12;
                default: goto L11;
            }
        L11:
            goto L24
        L12:
            r6.nextChar()
            int r0 = r6.current
            r3 = 10
            switch(r0) {
                case -1: goto L3;
                case 10: goto L57;
                case 13: goto L57;
                case 97: goto L4f;
                case 98: goto L4c;
                case 102: goto L49;
                case 110: goto L50;
                case 114: goto L46;
                case 116: goto L43;
                case 118: goto L40;
                case 120: goto L3b;
                case 122: goto L37;
                default: goto L1c;
            }
        L1c:
            int r0 = r6.current
            boolean r0 = r6.isdigit(r0)
            if (r0 != 0) goto L5e
        L24:
            goto L0
        L25:
            int r0 = r6.current
            boolean r0 = r6.isspace(r0)
            if (r0 == 0) goto L3
            boolean r0 = r6.currIsNewline()
            if (r0 == 0) goto L37
            r6.inclinenumber()
            goto L25
        L37:
            r6.nextChar()
            goto L25
        L3b:
            int r3 = r6.readhexaesc()
            goto L50
        L40:
            r3 = 11
            goto L50
        L43:
            r3 = 9
            goto L50
        L46:
            r3 = 13
            goto L50
        L49:
            r3 = 12
            goto L50
        L4c:
            r3 = 8
            goto L50
        L4f:
            r3 = 7
        L50:
            r6.save(r3)
            r6.nextChar()
            goto L3
        L57:
            r6.save(r3)
            r6.inclinenumber()
            goto L3
        L5e:
            r0 = 0
            r4 = r0
        L60:
            int r0 = r0 * r3
            int r5 = r6.current
            int r5 = r5 + (-48)
            int r0 = r0 + r5
            r6.nextChar()
            int r4 = r4 + r1
            r5 = 3
            if (r4 >= r5) goto L75
            int r5 = r6.current
            boolean r5 = r6.isdigit(r5)
            if (r5 != 0) goto L60
        L75:
            r1 = 255(0xff, float:3.57E-43)
            if (r0 <= r1) goto L7e
            java.lang.String r1 = "escape sequence too large"
            r6.lexerror(r1, r2)
        L7e:
            r6.save(r0)
            goto L3
        L82:
            r6.lexerror(r3, r2)
            goto L3
        L87:
            r0 = 286(0x11e, float:4.01E-43)
            r6.lexerror(r3, r0)
            goto L3
        L8e:
            r6.save_and_next()
            org.luaj.vm2.compiler.LuaC$CompileState r7 = r6.L
            char[] r0 = r6.buff
            int r2 = r6.nbuff
            int r2 = r2 + (-2)
            org.luaj.vm2.LuaString r0 = org.luaj.vm2.LuaString.valueOf(r0, r1, r2)
            org.luaj.vm2.LuaString r7 = r7.newTString(r0)
            r8.ts = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.compiler.LexState.read_string(int, org.luaj.vm2.compiler.LexState$SemInfo):void");
    }

    int readhexaesc() {
        nextChar();
        int i = this.current;
        nextChar();
        int i2 = this.current;
        if (!isxdigit(i) || !isxdigit(i2)) {
            lexerror(new StringBuffer().append("hexadecimal digit expected 'x").append((char) i).append((char) i2).toString(), TK_STRING);
        }
        return (hexvalue(i) << 4) + hexvalue(i2);
    }

    void recfield(ConsControl consControl) {
        FuncState funcState = this.fs;
        short s = this.fs.freereg;
        expdesc expdescVar = new expdesc();
        expdesc expdescVar2 = new expdesc();
        if (this.t.token == TK_NAME) {
            funcState.checklimit(consControl.nh, MAX_INT, "items in a constructor");
            checkname(expdescVar);
        } else {
            yindex(expdescVar);
        }
        consControl.nh++;
        checknext(61);
        int exp2RK = funcState.exp2RK(expdescVar);
        expr(expdescVar2);
        funcState.codeABC(10, consControl.t.u.info, exp2RK, funcState.exp2RK(expdescVar2));
        funcState.freereg = s;
    }

    int registerlocalvar(LuaString luaString) {
        FuncState funcState = this.fs;
        Prototype prototype = funcState.f;
        if (prototype.locvars == null || funcState.nlocvars + 1 > prototype.locvars.length) {
            prototype.locvars = realloc(prototype.locvars, (funcState.nlocvars * 2) + 1);
        }
        prototype.locvars[funcState.nlocvars] = new LocVars(luaString, 0, 0);
        short s = funcState.nlocvars;
        funcState.nlocvars = (short) (s + 1);
        return s;
    }

    void removevars(int i) {
        FuncState funcState = this.fs;
        while (funcState.nactvar > i) {
            short s = (short) (funcState.nactvar - 1);
            funcState.nactvar = s;
            funcState.getlocvar(s).endpc = funcState.pc;
        }
    }

    void repeatstat(int i) {
        FuncState funcState = this.fs;
        int i2 = funcState.getlabel();
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        FuncState.BlockCnt blockCnt2 = new FuncState.BlockCnt();
        funcState.enterblock(blockCnt, true);
        funcState.enterblock(blockCnt2, false);
        next();
        statlist();
        check_match(TK_UNTIL, TK_REPEAT, i);
        int cond = cond();
        if (blockCnt2.upval) {
            funcState.patchclose(cond, blockCnt2.nactvar);
        }
        funcState.leaveblock();
        funcState.patchlist(cond, i2);
        funcState.leaveblock();
    }

    void retstat() {
        int i;
        FuncState funcState = this.fs;
        expdesc expdescVar = new expdesc();
        int i2 = 0;
        if (block_follow(true) || this.t.token == 59) {
            i = 0;
        } else {
            i = explist(expdescVar);
            if (hasmultret(expdescVar.k)) {
                funcState.setmultret(expdescVar);
                if (expdescVar.k == 12 && i == 1) {
                    SET_OPCODE(funcState.getcodePtr(expdescVar), 30);
                    _assert(Lua.GETARG_A(funcState.getcode(expdescVar)) == funcState.nactvar);
                }
                i2 = funcState.nactvar;
                i = -1;
            } else if (i == 1) {
                i2 = funcState.exp2anyreg(expdescVar);
            } else {
                funcState.exp2nextreg(expdescVar);
                short s = funcState.nactvar;
                _assert(i == funcState.freereg - s);
                i2 = s;
            }
        }
        funcState.ret(i2, i);
        testnext(59);
    }

    void save(int i) {
        if (this.buff == null || this.nbuff + 1 > this.buff.length) {
            this.buff = realloc(this.buff, (this.nbuff * 2) + 1);
        }
        char[] cArr = this.buff;
        int i2 = this.nbuff;
        this.nbuff = i2 + 1;
        cArr[i2] = (char) i;
    }

    void save_and_next() {
        save(this.current);
        nextChar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void semerror(String str) {
        this.t.token = 0;
        syntaxerror(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setinput(LuaC.CompileState compileState, int i, InputStream inputStream, LuaString luaString) {
        this.decpoint = (byte) 46;
        this.L = compileState;
        this.lookahead.token = TK_EOS;
        this.z = inputStream;
        this.fs = null;
        this.linenumber = 1;
        this.lastline = 1;
        this.source = luaString;
        this.envn = LuaValue.ENV;
        this.nbuff = 0;
        this.current = i;
        skipShebang();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    void simpleexp(expdesc expdescVar) {
        int i;
        switch (this.t.token) {
            case 123:
                constructor(expdescVar);
                return;
            case TK_FALSE /* 263 */:
                i = 3;
                expdescVar.init(i, 0);
                next();
                return;
            case TK_FUNCTION /* 265 */:
                next();
                body(expdescVar, false, this.linenumber);
                return;
            case TK_NIL /* 270 */:
                expdescVar.init(1, 0);
                next();
                return;
            case TK_TRUE /* 276 */:
                i = 2;
                expdescVar.init(i, 0);
                next();
                return;
            case TK_DOTS /* 280 */:
                FuncState funcState = this.fs;
                check_condition(funcState.f.is_vararg != 0, new StringBuffer().append("cannot use ").append(LUA_QL("...")).append(" outside a vararg function").toString());
                expdescVar.init(13, funcState.codeABC(38, 0, 1, 0));
                next();
                return;
            case TK_NUMBER /* 287 */:
                expdescVar.init(5, 0);
                expdescVar.u.setNval(this.t.seminfo.r);
                next();
                return;
            case TK_STRING /* 289 */:
                codestring(expdescVar, this.t.seminfo.ts);
                next();
                return;
            default:
                suffixedexp(expdescVar);
                return;
        }
    }

    void singlevar(expdesc expdescVar) {
        LuaString str_checkname = str_checkname();
        FuncState funcState = this.fs;
        boolean z = true;
        if (FuncState.singlevaraux(funcState, str_checkname, expdescVar, 1) == 0) {
            expdesc expdescVar2 = new expdesc();
            FuncState.singlevaraux(funcState, this.envn, expdescVar, 1);
            if (expdescVar.k != 7 && expdescVar.k != 8) {
                z = false;
            }
            _assert(z);
            codestring(expdescVar2, str_checkname);
            funcState.indexed(expdescVar, expdescVar2);
        }
    }

    int skip_sep() {
        int i = this.current;
        int i2 = 0;
        _assert(i == 91 || i == 93);
        save_and_next();
        while (this.current == 61) {
            save_and_next();
            i2++;
        }
        return this.current != i ? (-i2) - 1 : i2;
    }

    void skipnoopstat() {
        while (true) {
            if (this.t.token != 59 && this.t.token != TK_DBCOLON) {
                return;
            } else {
                statement();
            }
        }
    }

    void statement() {
        int i = this.linenumber;
        enterlevel();
        switch (this.t.token) {
            case 59:
                next();
                break;
            case TK_BREAK /* 258 */:
            case TK_GOTO /* 266 */:
                gotostat(this.fs.jump());
                break;
            case TK_DO /* 259 */:
                next();
                block();
                check_match(TK_END, TK_DO, i);
                break;
            case 264:
                forstat(i);
                break;
            case TK_FUNCTION /* 265 */:
                funcstat(i);
                break;
            case TK_IF /* 267 */:
                ifstat(i);
                break;
            case TK_LOCAL /* 269 */:
                next();
                if (!testnext(TK_FUNCTION)) {
                    localstat();
                    break;
                } else {
                    localfunc();
                    break;
                }
            case TK_REPEAT /* 273 */:
                repeatstat(i);
                break;
            case TK_RETURN /* 274 */:
                next();
                retstat();
                break;
            case TK_WHILE /* 278 */:
                whilestat(i);
                break;
            case TK_DBCOLON /* 285 */:
                next();
                labelstat(str_checkname(), i);
                break;
            default:
                exprstat();
                break;
        }
        _assert(this.fs.f.maxstacksize >= this.fs.freereg && this.fs.freereg >= this.fs.nactvar);
        this.fs.freereg = this.fs.nactvar;
        leavelevel();
    }

    void statlist() {
        while (!block_follow(true)) {
            int i = this.t.token;
            statement();
            if (i == TK_RETURN) {
                return;
            }
        }
    }

    boolean str2d(String str, SemInfo semInfo) {
        semInfo.r = (str.indexOf(110) >= 0 || str.indexOf(78) >= 0) ? LuaValue.ZERO : (str.indexOf(120) >= 0 || str.indexOf(88) >= 0) ? strx2number(str, semInfo) : LuaValue.valueOf(Double.parseDouble(str.trim()));
        return true;
    }

    LuaString str_checkname() {
        check(TK_NAME);
        LuaString luaString = this.t.seminfo.ts;
        next();
        return luaString;
    }

    LuaValue strx2number(String str, SemInfo semInfo) {
        double d;
        boolean z;
        int i;
        int i2;
        boolean z2;
        char[] charArray = str.toCharArray();
        int i3 = 0;
        while (i3 < charArray.length && isspace(charArray[i3])) {
            i3++;
        }
        if (i3 >= charArray.length || charArray[i3] != '-') {
            d = 1.0d;
        } else {
            i3++;
            d = -1.0d;
        }
        if (i3 + 2 < charArray.length) {
            int i4 = i3 + 1;
            if (charArray[i3] == '0' && (charArray[i4] == 'x' || charArray[i4] == 'X')) {
                boolean z3 = true;
                int i5 = i4 + 1;
                double d2 = 0.0d;
                while (i5 < charArray.length && isxdigit(charArray[i5])) {
                    d2 = (d2 * 16.0d) + hexvalue(charArray[i5]);
                    i5++;
                }
                if (i5 >= charArray.length || charArray[i5] != '.') {
                    z = true;
                    i = 0;
                } else {
                    i5++;
                    i = 0;
                    while (i5 < charArray.length && isxdigit(charArray[i5])) {
                        d2 = (d2 * 16.0d) + hexvalue(charArray[i5]);
                        i -= 4;
                        z3 = z3;
                        i5++;
                    }
                    z = z3;
                }
                if (i5 < charArray.length && (charArray[i5] == 'p' || charArray[i5] == 'P')) {
                    int i6 = i5 + 1;
                    if (i6 >= charArray.length || charArray[i6] != '-') {
                        i2 = 0;
                        z2 = false;
                    } else {
                        i6++;
                        z2 = z;
                        i2 = 0;
                    }
                    while (i6 < charArray.length && isdigit(charArray[i6])) {
                        i2 = ((i2 * 10) + charArray[i6]) - 48;
                        i6++;
                    }
                    if (z2) {
                        i2 = -i2;
                    }
                    i += i2;
                }
                return LuaValue.valueOf(d * d2 * MathLib.dpow_d(2.0d, i));
            }
        }
        return LuaValue.ZERO;
    }

    int subexpr(expdesc expdescVar, int i) {
        enterlevel();
        int i2 = getunopr(this.t.token);
        if (i2 != 3) {
            int i3 = this.linenumber;
            next();
            subexpr(expdescVar, 8);
            this.fs.prefix(i2, expdescVar, i3);
        } else {
            simpleexp(expdescVar);
        }
        int i4 = getbinopr(this.t.token);
        while (i4 != 15 && priority[i4].left > i) {
            expdesc expdescVar2 = new expdesc();
            int i5 = this.linenumber;
            next();
            this.fs.infix(i4, expdescVar);
            int subexpr = subexpr(expdescVar2, priority[i4].right);
            this.fs.posfix(i4, expdescVar, expdescVar2, i5);
            i4 = subexpr;
        }
        leavelevel();
        return i4;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0009. Please report as an issue. */
    void suffixedexp(expdesc expdescVar) {
        int i = this.linenumber;
        primaryexp(expdescVar);
        while (true) {
            switch (this.t.token) {
                case 40:
                case 123:
                case TK_STRING /* 289 */:
                    this.fs.exp2nextreg(expdescVar);
                    funcargs(expdescVar, i);
                case 46:
                    fieldsel(expdescVar);
                case LuaParserConstants.HEXNUM /* 58 */:
                    expdesc expdescVar2 = new expdesc();
                    next();
                    checkname(expdescVar2);
                    this.fs.self(expdescVar, expdescVar2);
                    funcargs(expdescVar, i);
                case 91:
                    expdesc expdescVar3 = new expdesc();
                    this.fs.exp2anyregup(expdescVar);
                    yindex(expdescVar3);
                    this.fs.indexed(expdescVar, expdescVar3);
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syntaxerror(String str) {
        lexerror(str, this.t.token);
    }

    void test_then_block(IntPtr intPtr) {
        int jump;
        expdesc expdescVar = new expdesc();
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        next();
        expr(expdescVar);
        checknext(TK_THEN);
        if (this.t.token == TK_GOTO || this.t.token == TK_BREAK) {
            this.fs.goiffalse(expdescVar);
            this.fs.enterblock(blockCnt, false);
            gotostat(expdescVar.t.i);
            skipnoopstat();
            if (block_follow(false)) {
                this.fs.leaveblock();
                return;
            }
            jump = this.fs.jump();
        } else {
            this.fs.goiftrue(expdescVar);
            this.fs.enterblock(blockCnt, false);
            jump = expdescVar.f.i;
        }
        statlist();
        this.fs.leaveblock();
        if (this.t.token == TK_ELSE || this.t.token == TK_ELSEIF) {
            this.fs.concat(intPtr, this.fs.jump());
        }
        this.fs.patchtohere(jump);
    }

    boolean testnext(int i) {
        if (this.t.token != i) {
            return false;
        }
        next();
        return true;
    }

    String token2str(int i) {
        LuaC.CompileState compileState;
        String valueOf;
        if (i >= 257) {
            return luaX_tokens[i - 257];
        }
        if (iscntrl(i)) {
            compileState = this.L;
            valueOf = new StringBuffer().append("char(").append(i).append(")").toString();
        } else {
            compileState = this.L;
            valueOf = String.valueOf((char) i);
        }
        return compileState.pushfstring(valueOf);
    }

    String txtToken(int i) {
        switch (i) {
            case TK_NUMBER /* 287 */:
            case TK_NAME /* 288 */:
            case TK_STRING /* 289 */:
                return new String(this.buff, 0, this.nbuff);
            default:
                return token2str(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void undefgoto(Labeldesc labeldesc) {
        semerror(this.L.pushfstring((isReservedKeyword(labeldesc.name.tojstring()) ? new StringBuffer().append("<").append(labeldesc.name).append("> at line ").append(labeldesc.line).append(" not inside a loop") : new StringBuffer().append("no visible label '").append(labeldesc.name).append("' for <goto> at line ").append(labeldesc.line)).toString()));
    }

    void whilestat(int i) {
        FuncState funcState = this.fs;
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        next();
        int i2 = funcState.getlabel();
        int cond = cond();
        funcState.enterblock(blockCnt, true);
        checknext(TK_DO);
        block();
        funcState.patchlist(funcState.jump(), i2);
        check_match(TK_END, TK_WHILE, i);
        funcState.leaveblock();
        funcState.patchtohere(cond);
    }

    void yindex(expdesc expdescVar) {
        next();
        expr(expdescVar);
        this.fs.exp2val(expdescVar);
        checknext(93);
    }
}
