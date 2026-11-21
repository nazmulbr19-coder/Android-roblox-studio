package org.luaj.vm2.parser;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.luaj.vm2.LoadState;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.ast.Block;
import org.luaj.vm2.ast.Chunk;
import org.luaj.vm2.ast.Exp;
import org.luaj.vm2.ast.FuncArgs;
import org.luaj.vm2.ast.FuncBody;
import org.luaj.vm2.ast.Name;
import org.luaj.vm2.ast.ParList;
import org.luaj.vm2.ast.Stat;
import org.luaj.vm2.ast.Str;
import org.luaj.vm2.ast.SyntaxElement;
import org.luaj.vm2.ast.TableConstructor;
import org.luaj.vm2.ast.TableField;

/* loaded from: classes10.dex */
public class LuaParser implements LuaParserConstants {
    private static int[] jj_la1_0;
    private static int[] jj_la1_1;
    private static int[] jj_la1_2;
    private final JJCalls[] jj_2_rtns;
    private int jj_endpos;
    private List jj_expentries;
    private int[] jj_expentry;
    private int jj_gc;
    private int jj_gen;
    SimpleCharStream jj_input_stream;
    private int jj_kind;
    private int jj_la;
    private final int[] jj_la1;
    private Token jj_lastpos;
    private int[] jj_lasttokens;
    private final LookaheadSuccess jj_ls;
    public Token jj_nt;
    private int jj_ntk;
    private boolean jj_rescan;
    private Token jj_scanpos;
    public Token token;
    public LuaParserTokenManager token_source;

    /* loaded from: classes10.dex */
    static final class JJCalls {
        int arg;
        Token first;
        int gen;
        JJCalls next;

        JJCalls() {
        }
    }

    /* loaded from: classes10.dex */
    private static final class LookaheadSuccess extends Error {
        private LookaheadSuccess() {
        }

        /* synthetic */ LookaheadSuccess(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        LuaValue.valueOf(true);
        jj_la1_init_0();
        jj_la1_init_1();
        jj_la1_init_2();
    }

    public LuaParser(InputStream inputStream) {
        this(inputStream, null);
    }

    public LuaParser(InputStream inputStream, String str) {
        this.jj_la1 = new int[34];
        this.jj_2_rtns = new JJCalls[7];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(null);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        try {
            this.jj_input_stream = new SimpleCharStream(inputStream, str, 1, 1);
            this.token_source = new LuaParserTokenManager(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i = 0; i < 34; i++) {
                this.jj_la1[i] = -1;
            }
            for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
                this.jj_2_rtns[i2] = new JJCalls();
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public LuaParser(Reader reader) {
        this.jj_la1 = new int[34];
        this.jj_2_rtns = new JJCalls[7];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(null);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.jj_input_stream = new SimpleCharStream(reader, 1, 1);
        this.token_source = new LuaParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 34; i++) {
            this.jj_la1[i] = -1;
        }
        for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
            this.jj_2_rtns[i2] = new JJCalls();
        }
    }

    public LuaParser(LuaParserTokenManager luaParserTokenManager) {
        this.jj_la1 = new int[34];
        this.jj_2_rtns = new JJCalls[7];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(null);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.token_source = luaParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 34; i++) {
            this.jj_la1[i] = -1;
        }
        for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
            this.jj_2_rtns[i2] = new JJCalls();
        }
    }

    private void L(SyntaxElement syntaxElement, long j) {
        syntaxElement.beginLine = (int) (j >> 32);
        syntaxElement.beginColumn = (short) j;
        syntaxElement.endLine = this.token.endLine;
        syntaxElement.endColumn = (short) this.token.endColumn;
    }

    private void L(SyntaxElement syntaxElement, Token token) {
        syntaxElement.beginLine = token.beginLine;
        syntaxElement.beginColumn = (short) token.beginColumn;
        syntaxElement.endLine = this.token.endLine;
        syntaxElement.endColumn = (short) this.token.endColumn;
    }

    private long LineInfo() {
        return (this.jj_input_stream.getBeginLine() << 32) | this.jj_input_stream.getBeginColumn();
    }

    private static Exp.FuncCall assertfunccall(Exp.PrimaryExp primaryExp) throws ParseException {
        if (primaryExp.isfunccall()) {
            return (Exp.FuncCall) primaryExp;
        }
        throw new ParseException("expected function call");
    }

    private static Exp.VarExp assertvarexp(Exp.PrimaryExp primaryExp) throws ParseException {
        if (primaryExp.isvarexp()) {
            return (Exp.VarExp) primaryExp;
        }
        throw new ParseException("expected variable");
    }

    private boolean jj_2_1(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_1();
        } catch (LookaheadSuccess e) {
            return true;
        } finally {
            jj_save(0, i);
        }
    }

    private boolean jj_2_2(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_2();
        } catch (LookaheadSuccess e) {
            return true;
        } finally {
            jj_save(1, i);
        }
    }

    private boolean jj_2_3(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_3();
        } catch (LookaheadSuccess e) {
            return true;
        } finally {
            jj_save(2, i);
        }
    }

    private boolean jj_2_4(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_4();
        } catch (LookaheadSuccess e) {
            return true;
        } finally {
            jj_save(3, i);
        }
    }

    private boolean jj_2_5(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_5();
        } catch (LookaheadSuccess e) {
            return true;
        } finally {
            jj_save(4, i);
        }
    }

    private boolean jj_2_6(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_6();
        } catch (LookaheadSuccess e) {
            return true;
        } finally {
            jj_save(5, i);
        }
    }

    private boolean jj_2_7(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_7();
        } catch (LookaheadSuccess e) {
            return true;
        } finally {
            jj_save(6, i);
        }
    }

    private boolean jj_3R_10() {
        Token token = this.jj_scanpos;
        if (!jj_3R_15()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_16()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_17()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_18();
    }

    private boolean jj_3R_11() {
        Token token = this.jj_scanpos;
        if (!jj_3R_19()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_20()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_21()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_22()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_23()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_24()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_25()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_26()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_27()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_28()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_29()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_30()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_31()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_32()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_33();
    }

    private boolean jj_3R_12() {
        Token token = this.jj_scanpos;
        if (!jj_3R_34()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_35();
    }

    private boolean jj_3R_13() {
        Token token = this.jj_scanpos;
        if (!jj_scan_token(72)) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(70);
    }

    private boolean jj_3R_14() {
        Token token = this.jj_scanpos;
        if (!jj_3R_36()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3_7()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_37();
    }

    private boolean jj_3R_15() {
        return jj_scan_token(73) || jj_scan_token(51);
    }

    private boolean jj_3R_16() {
        return jj_scan_token(77) || jj_3R_12();
    }

    private boolean jj_3R_17() {
        return jj_scan_token(74) || jj_scan_token(51);
    }

    private boolean jj_3R_18() {
        return jj_3R_38();
    }

    private boolean jj_3R_19() {
        return jj_scan_token(82);
    }

    private boolean jj_3R_20() {
        return jj_scan_token(83);
    }

    private boolean jj_3R_21() {
        return jj_scan_token(84);
    }

    private boolean jj_3R_22() {
        return jj_scan_token(85);
    }

    private boolean jj_3R_23() {
        return jj_scan_token(86);
    }

    private boolean jj_3R_24() {
        return jj_scan_token(87);
    }

    private boolean jj_3R_25() {
        return jj_scan_token(88);
    }

    private boolean jj_3R_26() {
        return jj_scan_token(89);
    }

    private boolean jj_3R_27() {
        return jj_scan_token(90);
    }

    private boolean jj_3R_28() {
        return jj_scan_token(91);
    }

    private boolean jj_3R_29() {
        return jj_scan_token(92);
    }

    private boolean jj_3R_30() {
        return jj_scan_token(93);
    }

    private boolean jj_3R_31() {
        return jj_scan_token(94);
    }

    private boolean jj_3R_32() {
        return jj_scan_token(29);
    }

    private boolean jj_3R_33() {
        return jj_scan_token(44);
    }

    private boolean jj_3R_34() {
        return jj_3R_39();
    }

    private boolean jj_3R_35() {
        return jj_3R_40();
    }

    private boolean jj_3R_36() {
        return jj_scan_token(77);
    }

    private boolean jj_3R_37() {
        return jj_3R_12();
    }

    private boolean jj_3R_38() {
        Token token = this.jj_scanpos;
        if (!jj_3R_41()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_42()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_43();
    }

    private boolean jj_3R_39() {
        Token token = this.jj_scanpos;
        if (!jj_3R_44()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_45()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_46()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_47()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_48()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_49()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_50()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_51()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_52();
    }

    private boolean jj_3R_40() {
        Token token = this.jj_scanpos;
        if (!jj_3R_53()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_54()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_55();
    }

    private boolean jj_3R_41() {
        if (jj_scan_token(75)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_56()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(76);
    }

    private boolean jj_3R_42() {
        return jj_3R_57();
    }

    private boolean jj_3R_43() {
        return jj_3R_58();
    }

    private boolean jj_3R_44() {
        return jj_scan_token(42);
    }

    private boolean jj_3R_45() {
        return jj_scan_token(48);
    }

    private boolean jj_3R_46() {
        return jj_scan_token(35);
    }

    private boolean jj_3R_47() {
        return jj_scan_token(52);
    }

    private boolean jj_3R_48() {
        return jj_3R_58();
    }

    private boolean jj_3R_49() {
        return jj_scan_token(79);
    }

    private boolean jj_3R_50() {
        return jj_3R_57();
    }

    private boolean jj_3R_51() {
        return jj_3R_59();
    }

    private boolean jj_3R_52() {
        return jj_3R_60();
    }

    private boolean jj_3R_53() {
        return jj_scan_token(83);
    }

    private boolean jj_3R_54() {
        return jj_scan_token(43);
    }

    private boolean jj_3R_55() {
        return jj_scan_token(69);
    }

    private boolean jj_3R_56() {
        return jj_3R_61();
    }

    private boolean jj_3R_57() {
        if (jj_scan_token(80)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_62()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(81);
    }

    private boolean jj_3R_58() {
        Token token = this.jj_scanpos;
        if (!jj_3R_63()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_64()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_65()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_66()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_67()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_68()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_69();
    }

    private boolean jj_3R_59() {
        return jj_scan_token(37);
    }

    private boolean jj_3R_60() {
        return jj_3R_70();
    }

    private boolean jj_3R_61() {
        return jj_3R_12();
    }

    private boolean jj_3R_62() {
        return jj_3R_71();
    }

    private boolean jj_3R_63() {
        return jj_scan_token(61);
    }

    private boolean jj_3R_64() {
        return jj_scan_token(62);
    }

    private boolean jj_3R_65() {
        return jj_scan_token(23);
    }

    private boolean jj_3R_66() {
        return jj_scan_token(24);
    }

    private boolean jj_3R_67() {
        return jj_scan_token(25);
    }

    private boolean jj_3R_68() {
        return jj_scan_token(26);
    }

    private boolean jj_3R_69() {
        return jj_scan_token(27);
    }

    private boolean jj_3R_70() {
        Token token = this.jj_scanpos;
        if (!jj_3R_72()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_73();
    }

    private boolean jj_3R_71() {
        return jj_3R_14();
    }

    private boolean jj_3R_72() {
        return jj_scan_token(51);
    }

    private boolean jj_3R_73() {
        return jj_scan_token(75);
    }

    private boolean jj_3_1() {
        return jj_scan_token(36) || jj_scan_token(51) || jj_scan_token(71);
    }

    private boolean jj_3_2() {
        return jj_scan_token(41) || jj_scan_token(37);
    }

    private boolean jj_3_3() {
        return jj_3R_10();
    }

    private boolean jj_3_4() {
        return jj_scan_token(72) || jj_scan_token(51);
    }

    private boolean jj_3_5() {
        return jj_3R_11() || jj_3R_12();
    }

    private boolean jj_3_6() {
        return jj_3R_13() || jj_3R_14();
    }

    private boolean jj_3_7() {
        return jj_scan_token(51) || jj_scan_token(71);
    }

    private void jj_add_error_token(int i, int i2) {
        int i3;
        if (i2 >= 100) {
            return;
        }
        if (i2 == this.jj_endpos + 1) {
            int[] iArr = this.jj_lasttokens;
            int i4 = this.jj_endpos;
            this.jj_endpos = i4 + 1;
            iArr[i4] = i;
            return;
        }
        if (this.jj_endpos != 0) {
            this.jj_expentry = new int[this.jj_endpos];
            for (int i5 = 0; i5 < this.jj_endpos; i5++) {
                this.jj_expentry[i5] = this.jj_lasttokens[i5];
            }
            Iterator it = this.jj_expentries.iterator();
            loop1: while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int[] iArr2 = (int[]) it.next();
                if (iArr2.length == this.jj_expentry.length) {
                    for (0; i3 < this.jj_expentry.length; i3 + 1) {
                        i3 = iArr2[i3] == this.jj_expentry[i3] ? i3 + 1 : 0;
                    }
                    this.jj_expentries.add(this.jj_expentry);
                    break loop1;
                }
            }
            if (i2 != 0) {
                int[] iArr3 = this.jj_lasttokens;
                this.jj_endpos = i2;
                iArr3[i2 - 1] = i;
            }
        }
    }

    private Token jj_consume_token(int i) throws ParseException {
        Token token = this.token;
        if (token.next != null) {
            this.token = this.token.next;
        } else {
            Token token2 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token2.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        if (this.token.kind != i) {
            this.token = token;
            this.jj_kind = i;
            throw generateParseException();
        }
        this.jj_gen++;
        int i2 = this.jj_gc + 1;
        this.jj_gc = i2;
        if (i2 > 100) {
            this.jj_gc = 0;
            for (int i3 = 0; i3 < this.jj_2_rtns.length; i3++) {
                for (JJCalls jJCalls = this.jj_2_rtns[i3]; jJCalls != null; jJCalls = jJCalls.next) {
                    if (jJCalls.gen < this.jj_gen) {
                        jJCalls.first = null;
                    }
                }
            }
        }
        return this.token;
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{0, -1073741824, 0, 0, 0, -1073741824, 0, 0, 0, 0, 260046848, 0, 0, 0, 0, 0, 0, 260046848, 260046848, 260046848, 0, 260046848, 260046848, 260046848, 0, 0, 0, 260046848, 0, 0, 260046848, 0, 536870912, 0};
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{0, 803568, 8192, 0, 0, 278720, 48, 524800, 2, 1, 1612254248, 0, 0, 0, 0, 0, 524288, 1610612736, 1612254248, 1610612736, 0, 1612252200, 1610612736, 1612254248, 524288, 0, 524288, 1612254248, 0, 0, 1612254248, 0, 4096, 2048};
    }

    private static void jj_la1_init_2() {
        jj_la1_2 = new int[]{32, 2114, 0, 256, 128, 66, 0, 2048, 0, 0, 624672, 64, 384, 256, 512, 1024, 2048, 77312, 624672, 67584, 256, 100352, 0, 624672, 32768, 256, 32768, 632864, 320, 8192, 624672, 320, 2147221504, 524320};
    }

    private int jj_ntk() {
        int i;
        Token token = this.token.next;
        this.jj_nt = token;
        if (token == null) {
            Token token2 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token2.next = nextToken;
            i = nextToken.kind;
        } else {
            i = this.jj_nt.kind;
        }
        this.jj_ntk = i;
        return i;
    }

    private void jj_rescan_token() {
        this.jj_rescan = true;
        for (int i = 0; i < 7; i++) {
            try {
                JJCalls jJCalls = this.jj_2_rtns[i];
                do {
                    if (jJCalls.gen > this.jj_gen) {
                        this.jj_la = jJCalls.arg;
                        Token token = jJCalls.first;
                        this.jj_scanpos = token;
                        this.jj_lastpos = token;
                        switch (i) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                            case 2:
                                jj_3_3();
                                break;
                            case 3:
                                jj_3_4();
                                break;
                            case 4:
                                jj_3_5();
                                break;
                            case 5:
                                jj_3_6();
                                break;
                            case 6:
                                jj_3_7();
                                break;
                        }
                    }
                    jJCalls = jJCalls.next;
                } while (jJCalls != null);
            } catch (LookaheadSuccess e) {
            }
        }
        this.jj_rescan = false;
    }

    private void jj_save(int i, int i2) {
        JJCalls jJCalls = this.jj_2_rtns[i];
        while (true) {
            if (jJCalls.gen <= this.jj_gen) {
                break;
            }
            if (jJCalls.next == null) {
                JJCalls jJCalls2 = new JJCalls();
                jJCalls.next = jJCalls2;
                jJCalls = jJCalls2;
                break;
            }
            jJCalls = jJCalls.next;
        }
        jJCalls.gen = (this.jj_gen + i2) - this.jj_la;
        jJCalls.first = this.token;
        jJCalls.arg = i2;
    }

    private boolean jj_scan_token(int i) {
        if (this.jj_scanpos == this.jj_lastpos) {
            this.jj_la--;
            if (this.jj_scanpos.next == null) {
                Token token = this.jj_scanpos;
                Token nextToken = this.token_source.getNextToken();
                token.next = nextToken;
                this.jj_scanpos = nextToken;
                this.jj_lastpos = nextToken;
            } else {
                Token token2 = this.jj_scanpos.next;
                this.jj_scanpos = token2;
                this.jj_lastpos = token2;
            }
        } else {
            this.jj_scanpos = this.jj_scanpos.next;
        }
        if (this.jj_rescan) {
            Token token3 = this.token;
            int i2 = 0;
            while (true) {
                if (token3 != null) {
                    if (token3 == this.jj_scanpos) {
                        jj_add_error_token(i, i2);
                        break;
                    }
                    i2++;
                    token3 = token3.next;
                } else {
                    break;
                }
            }
        }
        if (this.jj_scanpos.kind != i) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            throw this.jj_ls;
        }
        return false;
    }

    public static void main(String[] strArr) throws ParseException {
        new LuaParser(System.in).Chunk();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final org.luaj.vm2.ast.Stat Assign(org.luaj.vm2.ast.Exp.VarExp r6) throws org.luaj.vm2.parser.ParseException {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r6)
            long r1 = r5.LineInfo()
        Lc:
            int r6 = r5.jj_ntk
            r3 = -1
            if (r6 != r3) goto L16
            int r6 = r5.jj_ntk()
            goto L18
        L16:
            int r6 = r5.jj_ntk
        L18:
            switch(r6) {
                case 72: goto L24;
                default: goto L1b;
            }
        L1b:
            int[] r6 = r5.jj_la1
            r3 = 13
            int r4 = r5.jj_gen
            r6[r3] = r4
            goto L31
        L24:
            r6 = 72
            r5.jj_consume_token(r6)
            org.luaj.vm2.ast.Exp$VarExp r6 = r5.VarExp()
            r0.add(r6)
            goto Lc
        L31:
            r6 = 71
            r5.jj_consume_token(r6)
            java.util.List r6 = r5.ExpList()
            org.luaj.vm2.ast.Stat r6 = org.luaj.vm2.ast.Stat.assignment(r0, r6)
            r5.L(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.parser.LuaParser.Assign(org.luaj.vm2.ast.Exp$VarExp):org.luaj.vm2.ast.Stat");
    }

    public final int Binop() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 29:
                jj_consume_token(29);
                return 60;
            case 44:
                jj_consume_token(44);
                return 59;
            case LoadState.LUAC_VERSION /* 82 */:
                jj_consume_token(82);
                return 13;
            case 83:
                jj_consume_token(83);
                return 14;
            case 84:
                jj_consume_token(84);
                return 15;
            case 85:
                jj_consume_token(85);
                return 16;
            case 86:
                jj_consume_token(86);
                return 18;
            case 87:
                jj_consume_token(87);
                return 17;
            case 88:
                jj_consume_token(88);
                return 22;
            case 89:
                jj_consume_token(89);
                return 25;
            case 90:
                jj_consume_token(90);
                return 26;
            case 91:
                jj_consume_token(91);
                return 63;
            case 92:
                jj_consume_token(92);
                return 62;
            case 93:
                jj_consume_token(93);
                return 24;
            case 94:
                jj_consume_token(94);
                return 61;
            default:
                this.jj_la1[32] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final org.luaj.vm2.ast.Block Block() throws org.luaj.vm2.parser.ParseException {
        /*
            r7 = this;
            org.luaj.vm2.ast.Block r0 = new org.luaj.vm2.ast.Block
            r0.<init>()
            long r1 = r7.LineInfo()
        L9:
            int r3 = r7.jj_ntk
            r4 = -1
            if (r3 != r4) goto L13
            int r3 = r7.jj_ntk()
            goto L15
        L13:
            int r3 = r7.jj_ntk
        L15:
            switch(r3) {
                case 30: goto L20;
                case 31: goto L20;
                case 36: goto L20;
                case 37: goto L20;
                case 38: goto L20;
                case 39: goto L20;
                case 41: goto L20;
                case 46: goto L20;
                case 50: goto L20;
                case 51: goto L20;
                case 65: goto L20;
                case 70: goto L20;
                case 75: goto L20;
                default: goto L18;
            }
        L18:
            int[] r3 = r7.jj_la1
            r5 = 1
            int r6 = r7.jj_gen
            r3[r5] = r6
            goto L28
        L20:
            org.luaj.vm2.ast.Stat r3 = r7.Stat()
            r0.add(r3)
            goto L9
        L28:
            int r3 = r7.jj_ntk
            if (r3 != r4) goto L31
            int r3 = r7.jj_ntk()
            goto L33
        L31:
            int r3 = r7.jj_ntk
        L33:
            switch(r3) {
                case 45: goto L3e;
                default: goto L36;
            }
        L36:
            int[] r3 = r7.jj_la1
            r4 = 2
            int r5 = r7.jj_gen
            r3[r4] = r5
            goto L45
        L3e:
            org.luaj.vm2.ast.Stat r3 = r7.ReturnStat()
            r0.add(r3)
        L45:
            r7.L(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.parser.LuaParser.Block():org.luaj.vm2.ast.Block");
    }

    public final Chunk Chunk() throws ParseException {
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 69:
                jj_consume_token(69);
                this.token_source.SwitchTo(1);
                break;
            default:
                this.jj_la1[0] = this.jj_gen;
                break;
        }
        Block Block = Block();
        jj_consume_token(0);
        Chunk chunk = new Chunk(Block);
        L(chunk, LineInfo);
        return chunk;
    }

    public final Exp Exp() throws ParseException {
        Exp SimpleExp;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 35:
            case 37:
            case 42:
            case 48:
            case 51:
            case 52:
            case 61:
            case 62:
            case 75:
            case 79:
            case 80:
                SimpleExp = SimpleExp();
                break;
            case 43:
            case 69:
            case 83:
                SimpleExp = Exp.unaryexp(Unop(), Exp());
                break;
            default:
                this.jj_la1[23] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        while (jj_2_5(2)) {
            SimpleExp = Exp.binaryexp(SimpleExp, Binop(), Exp());
        }
        L(SimpleExp, LineInfo);
        return SimpleExp;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final java.util.List ExpList() throws org.luaj.vm2.parser.ParseException {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            org.luaj.vm2.ast.Exp r1 = r4.Exp()
            r0.add(r1)
            int r1 = r4.jj_ntk
            r2 = -1
            if (r1 != r2) goto L16
            int r1 = r4.jj_ntk()
            goto L18
        L16:
            int r1 = r4.jj_ntk
        L18:
            switch(r1) {
                case 72: goto L24;
                default: goto L1b;
            }
        L1b:
            int[] r1 = r4.jj_la1
            r2 = 20
            int r3 = r4.jj_gen
            r1[r2] = r3
            goto L2a
        L24:
            r1 = 72
            r4.jj_consume_token(r1)
            goto L5
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.parser.LuaParser.ExpList():java.util.List");
    }

    public final Stat ExprStat() throws ParseException {
        Stat Assign;
        long LineInfo = LineInfo();
        Exp.PrimaryExp PrimaryExp = PrimaryExp();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 71:
            case 72:
                Assign = Assign(assertvarexp(PrimaryExp));
                break;
            default:
                this.jj_la1[12] = this.jj_gen;
                Assign = null;
                break;
        }
        if (Assign == null) {
            Assign = Stat.functioncall(assertfunccall(PrimaryExp));
        }
        L(Assign, LineInfo);
        return Assign;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0060. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
    public final TableField Field() throws ParseException {
        TableField keyedField;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 77:
                jj_consume_token(77);
                Exp Exp = Exp();
                jj_consume_token(78);
                jj_consume_token(71);
                keyedField = TableField.keyedField(Exp, Exp());
                L(keyedField, LineInfo);
                return keyedField;
            default:
                this.jj_la1[29] = this.jj_gen;
                if (jj_2_7(2)) {
                    Token jj_consume_token = jj_consume_token(51);
                    jj_consume_token(71);
                    keyedField = TableField.namedField(jj_consume_token.image, Exp());
                } else {
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 35:
                        case 37:
                        case 42:
                        case 43:
                        case 48:
                        case 51:
                        case 52:
                        case 61:
                        case 62:
                        case 69:
                        case 75:
                        case 79:
                        case 80:
                        case 83:
                            keyedField = TableField.listField(Exp());
                            break;
                        default:
                            this.jj_la1[30] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                }
                L(keyedField, LineInfo);
                return keyedField;
        }
    }

    public final List FieldList() throws ParseException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(Field());
            if (!jj_2_6(2)) {
                break;
            }
            FieldSep();
        }
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 70:
            case 72:
                FieldSep();
                return arrayList;
            case 71:
            default:
                this.jj_la1[28] = this.jj_gen;
                return arrayList;
        }
    }

    public final void FieldSep() throws ParseException {
        int i;
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 70:
                i = 70;
                break;
            case 71:
            default:
                this.jj_la1[31] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            case 72:
                i = 72;
                break;
        }
        jj_consume_token(i);
    }

    public final FuncArgs FuncArgs() throws ParseException {
        FuncArgs string;
        List ExpList;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 61:
            case 62:
                string = FuncArgs.string(Str());
                break;
            case 75:
                jj_consume_token(75);
                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 35:
                    case 37:
                    case 42:
                    case 43:
                    case 48:
                    case 51:
                    case 52:
                    case 61:
                    case 62:
                    case 69:
                    case 75:
                    case 79:
                    case 80:
                    case 83:
                        ExpList = ExpList();
                        break;
                    default:
                        this.jj_la1[18] = this.jj_gen;
                        ExpList = null;
                        break;
                }
                jj_consume_token(76);
                string = FuncArgs.explist(ExpList);
                break;
            case 80:
                string = FuncArgs.tableconstructor(TableConstructor());
                break;
            default:
                this.jj_la1[19] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        L(string, LineInfo);
        return string;
    }

    public final FuncBody FuncBody() throws ParseException {
        ParList ParList;
        long LineInfo = LineInfo();
        jj_consume_token(75);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 51:
            case 79:
                ParList = ParList();
                break;
            default:
                this.jj_la1[24] = this.jj_gen;
                ParList = null;
                break;
        }
        jj_consume_token(76);
        Block Block = Block();
        jj_consume_token(34);
        FuncBody funcBody = new FuncBody(ParList, Block);
        L(funcBody, LineInfo);
        return funcBody;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final org.luaj.vm2.ast.FuncName FuncName() throws org.luaj.vm2.parser.ParseException {
        /*
            r7 = this;
            r0 = 51
            org.luaj.vm2.parser.Token r1 = r7.jj_consume_token(r0)
            org.luaj.vm2.ast.FuncName r2 = new org.luaj.vm2.ast.FuncName
            java.lang.String r3 = r1.image
            r2.<init>(r3)
        Ld:
            int r3 = r7.jj_ntk
            r4 = -1
            if (r3 != r4) goto L17
            int r3 = r7.jj_ntk()
            goto L19
        L17:
            int r3 = r7.jj_ntk
        L19:
            switch(r3) {
                case 73: goto L25;
                default: goto L1c;
            }
        L1c:
            int[] r3 = r7.jj_la1
            r5 = 14
            int r6 = r7.jj_gen
            r3[r5] = r6
            goto L34
        L25:
            r1 = 73
            r7.jj_consume_token(r1)
            org.luaj.vm2.parser.Token r1 = r7.jj_consume_token(r0)
            java.lang.String r3 = r1.image
            r2.adddot(r3)
            goto Ld
        L34:
            int r3 = r7.jj_ntk
            if (r3 != r4) goto L3d
            int r3 = r7.jj_ntk()
            goto L3f
        L3d:
            int r3 = r7.jj_ntk
        L3f:
            switch(r3) {
                case 74: goto L4b;
                default: goto L42;
            }
        L42:
            int[] r0 = r7.jj_la1
            r3 = 15
            int r4 = r7.jj_gen
            r0[r3] = r4
            goto L58
        L4b:
            r1 = 74
            r7.jj_consume_token(r1)
            org.luaj.vm2.parser.Token r1 = r7.jj_consume_token(r0)
            java.lang.String r0 = r1.image
            r2.method = r0
        L58:
            r7.L(r2, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.parser.LuaParser.FuncName():org.luaj.vm2.ast.FuncName");
    }

    public final FuncBody FunctionCall() throws ParseException {
        long LineInfo = LineInfo();
        jj_consume_token(37);
        FuncBody FuncBody = FuncBody();
        L(FuncBody, LineInfo);
        return FuncBody;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final org.luaj.vm2.ast.Stat IfThenElse() throws org.luaj.vm2.parser.ParseException {
        /*
            r9 = this;
            r0 = 39
            r9.jj_consume_token(r0)
            org.luaj.vm2.ast.Exp r0 = r9.Exp()
            r1 = 47
            r9.jj_consume_token(r1)
            org.luaj.vm2.ast.Block r2 = r9.Block()
            r3 = 0
            r4 = r3
            r5 = r4
        L15:
            int r6 = r9.jj_ntk
            r7 = -1
            if (r6 != r7) goto L1f
            int r6 = r9.jj_ntk()
            goto L21
        L1f:
            int r6 = r9.jj_ntk
        L21:
            switch(r6) {
                case 33: goto L2d;
                default: goto L24;
            }
        L24:
            int[] r1 = r9.jj_la1
            r6 = 8
            int r8 = r9.jj_gen
            r1[r6] = r8
            goto L52
        L2d:
            r6 = 33
            r9.jj_consume_token(r6)
            org.luaj.vm2.ast.Exp r6 = r9.Exp()
            r9.jj_consume_token(r1)
            org.luaj.vm2.ast.Block r7 = r9.Block()
            if (r4 != 0) goto L44
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L44:
            if (r5 != 0) goto L4b
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L4b:
            r4.add(r6)
            r5.add(r7)
            goto L15
        L52:
            int r1 = r9.jj_ntk
            if (r1 != r7) goto L5b
            int r1 = r9.jj_ntk()
            goto L5d
        L5b:
            int r1 = r9.jj_ntk
        L5d:
            switch(r1) {
                case 32: goto L69;
                default: goto L60;
            }
        L60:
            int[] r1 = r9.jj_la1
            r6 = 9
            int r7 = r9.jj_gen
            r1[r6] = r7
            goto L72
        L69:
            r1 = 32
            r9.jj_consume_token(r1)
            org.luaj.vm2.ast.Block r3 = r9.Block()
        L72:
            r1 = 34
            r9.jj_consume_token(r1)
            org.luaj.vm2.ast.Stat r0 = org.luaj.vm2.ast.Stat.ifthenelse(r0, r2, r4, r5, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.parser.LuaParser.IfThenElse():org.luaj.vm2.ast.Stat");
    }

    public final Stat Label() throws ParseException {
        jj_consume_token(65);
        Token jj_consume_token = jj_consume_token(51);
        jj_consume_token(65);
        return Stat.labelstat(jj_consume_token.image);
    }

    public final List NameList() throws ParseException {
        ArrayList arrayList = new ArrayList();
        Name name = new Name(jj_consume_token(51).image);
        while (true) {
            arrayList.add(name);
            if (!jj_2_4(2)) {
                return arrayList;
            }
            jj_consume_token(72);
            name = new Name(jj_consume_token(51).image);
        }
    }

    public final ParList ParList() throws ParseException {
        long LineInfo = LineInfo();
        boolean z = true;
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 51:
                List NameList = NameList();
                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                    case 72:
                        jj_consume_token(72);
                        jj_consume_token(79);
                        break;
                    default:
                        this.jj_la1[25] = this.jj_gen;
                        z = false;
                        break;
                }
                ParList parList = new ParList(NameList, z);
                L(parList, LineInfo);
                return parList;
            case 79:
                jj_consume_token(79);
                ParList parList2 = new ParList(null, true);
                L(parList2, LineInfo);
                return parList2;
            default:
                this.jj_la1[26] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final Exp.PrimaryExp PostfixOp(Exp.PrimaryExp primaryExp) throws ParseException {
        Exp.PrimaryExp functionop;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 61:
            case 62:
            case 75:
            case 80:
                functionop = Exp.functionop(primaryExp, FuncArgs());
                break;
            case 73:
                jj_consume_token(73);
                functionop = Exp.fieldop(primaryExp, jj_consume_token(51).image);
                break;
            case 74:
                jj_consume_token(74);
                functionop = Exp.methodop(primaryExp, jj_consume_token(51).image, FuncArgs());
                break;
            case 77:
                jj_consume_token(77);
                Exp Exp = Exp();
                jj_consume_token(78);
                functionop = Exp.indexop(primaryExp, Exp);
                break;
            default:
                this.jj_la1[17] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        L(functionop, LineInfo);
        return functionop;
    }

    public final Exp.PrimaryExp PrefixExp() throws ParseException {
        Exp.PrimaryExp nameprefix;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 51:
                nameprefix = Exp.nameprefix(jj_consume_token(51).image);
                break;
            case 75:
                jj_consume_token(75);
                Exp Exp = Exp();
                jj_consume_token(76);
                nameprefix = Exp.parensprefix(Exp);
                break;
            default:
                this.jj_la1[16] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        L(nameprefix, LineInfo);
        return nameprefix;
    }

    public final Exp.PrimaryExp PrimaryExp() throws ParseException {
        long LineInfo = LineInfo();
        Exp.PrimaryExp PrefixExp = PrefixExp();
        while (jj_2_3(2)) {
            PrefixExp = PostfixOp(PrefixExp);
        }
        L(PrefixExp, LineInfo);
        return PrefixExp;
    }

    public void ReInit(InputStream inputStream) {
        ReInit(inputStream, null);
    }

    public void ReInit(InputStream inputStream, String str) {
        try {
            this.jj_input_stream.ReInit(inputStream, str, 1, 1);
            this.token_source.ReInit(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i = 0; i < 34; i++) {
                this.jj_la1[i] = -1;
            }
            for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
                this.jj_2_rtns[i2] = new JJCalls();
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void ReInit(Reader reader) {
        this.jj_input_stream.ReInit(reader, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 34; i++) {
            this.jj_la1[i] = -1;
        }
        for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
            this.jj_2_rtns[i2] = new JJCalls();
        }
    }

    public void ReInit(LuaParserTokenManager luaParserTokenManager) {
        this.token_source = luaParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 34; i++) {
            this.jj_la1[i] = -1;
        }
        for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
            this.jj_2_rtns[i2] = new JJCalls();
        }
    }

    public final Stat ReturnStat() throws ParseException {
        List ExpList;
        long LineInfo = LineInfo();
        jj_consume_token(45);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 35:
            case 37:
            case 42:
            case 43:
            case 48:
            case 51:
            case 52:
            case 61:
            case 62:
            case 69:
            case 75:
            case 79:
            case 80:
            case 83:
                ExpList = ExpList();
                break;
            default:
                this.jj_la1[10] = this.jj_gen;
                ExpList = null;
                break;
        }
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 70:
                jj_consume_token(70);
                break;
            default:
                this.jj_la1[11] = this.jj_gen;
                break;
        }
        Stat returnstat = Stat.returnstat(ExpList);
        L(returnstat, LineInfo);
        return returnstat;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0010. Please report as an issue. */
    public final Exp SimpleExp() throws ParseException {
        LuaValue Str;
        Exp anonymousfunction;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 61:
            case 62:
                Str = Str();
                anonymousfunction = Exp.constant(Str);
                L(anonymousfunction, LineInfo);
                return anonymousfunction;
            case 35:
                jj_consume_token(35);
                Str = LuaValue.FALSE;
                anonymousfunction = Exp.constant(Str);
                L(anonymousfunction, LineInfo);
                return anonymousfunction;
            case 37:
                anonymousfunction = Exp.anonymousfunction(FunctionCall());
                L(anonymousfunction, LineInfo);
                return anonymousfunction;
            case 42:
                jj_consume_token(42);
                Str = LuaValue.NIL;
                anonymousfunction = Exp.constant(Str);
                L(anonymousfunction, LineInfo);
                return anonymousfunction;
            case 48:
                jj_consume_token(48);
                Str = LuaValue.TRUE;
                anonymousfunction = Exp.constant(Str);
                L(anonymousfunction, LineInfo);
                return anonymousfunction;
            case 51:
            case 75:
                return PrimaryExp();
            case 52:
                anonymousfunction = Exp.numberconstant(jj_consume_token(52).image);
                L(anonymousfunction, LineInfo);
                return anonymousfunction;
            case 79:
                jj_consume_token(79);
                anonymousfunction = Exp.varargs();
                L(anonymousfunction, LineInfo);
                return anonymousfunction;
            case 80:
                anonymousfunction = Exp.tableconstructor(TableConstructor());
                L(anonymousfunction, LineInfo);
                return anonymousfunction;
            default:
                this.jj_la1[21] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final Stat Stat() throws ParseException {
        Stat breakstat;
        long LineInfo = LineInfo();
        List list = null;
        Exp Exp = null;
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 30:
                jj_consume_token(30);
                breakstat = Stat.breakstat();
                break;
            case 31:
                jj_consume_token(31);
                Block Block = Block();
                jj_consume_token(34);
                breakstat = Stat.block(Block);
                break;
            case 38:
                jj_consume_token(38);
                breakstat = Stat.gotostat(jj_consume_token(51).image);
                break;
            case 39:
                breakstat = IfThenElse();
                break;
            case 46:
                jj_consume_token(46);
                Block Block2 = Block();
                jj_consume_token(49);
                breakstat = Stat.repeatuntil(Block2, Exp());
                break;
            case 50:
                jj_consume_token(50);
                Exp Exp2 = Exp();
                jj_consume_token(31);
                Block Block3 = Block();
                jj_consume_token(34);
                breakstat = Stat.whiledo(Exp2, Block3);
                break;
            case 65:
                breakstat = Label();
                break;
            case 70:
                jj_consume_token(70);
                return null;
            default:
                this.jj_la1[5] = this.jj_gen;
                if (jj_2_1(3)) {
                    jj_consume_token(36);
                    Token jj_consume_token = jj_consume_token(51);
                    jj_consume_token(71);
                    Exp Exp3 = Exp();
                    jj_consume_token(72);
                    Exp Exp4 = Exp();
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 72:
                            jj_consume_token(72);
                            Exp = Exp();
                            break;
                        default:
                            this.jj_la1[3] = this.jj_gen;
                            break;
                    }
                    jj_consume_token(31);
                    Block Block4 = Block();
                    jj_consume_token(34);
                    breakstat = Stat.fornumeric(jj_consume_token.image, Exp3, Exp4, Exp, Block4);
                    break;
                } else {
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 36:
                            jj_consume_token(36);
                            List NameList = NameList();
                            jj_consume_token(40);
                            List ExpList = ExpList();
                            jj_consume_token(31);
                            Block Block5 = Block();
                            jj_consume_token(34);
                            breakstat = Stat.forgeneric(NameList, ExpList, Block5);
                            break;
                        case 37:
                            jj_consume_token(37);
                            breakstat = Stat.functiondef(FuncName(), FuncBody());
                            break;
                        default:
                            this.jj_la1[6] = this.jj_gen;
                            if (jj_2_2(2)) {
                                jj_consume_token(41);
                                jj_consume_token(37);
                                breakstat = Stat.localfunctiondef(jj_consume_token(51).image, FuncBody());
                                break;
                            } else {
                                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                                    case 41:
                                        jj_consume_token(41);
                                        List NameList2 = NameList();
                                        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                                            case 71:
                                                jj_consume_token(71);
                                                list = ExpList();
                                                break;
                                            default:
                                                this.jj_la1[4] = this.jj_gen;
                                                break;
                                        }
                                        breakstat = Stat.localassignment(NameList2, list);
                                        break;
                                    case 51:
                                    case 75:
                                        breakstat = ExprStat();
                                        break;
                                    default:
                                        this.jj_la1[7] = this.jj_gen;
                                        jj_consume_token(-1);
                                        throw new ParseException();
                                }
                            }
                    }
                }
        }
        L(breakstat, LineInfo);
        return breakstat;
    }

    public final LuaString Str() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
                jj_consume_token(23);
                return Str.longString(this.token.image);
            case 24:
                jj_consume_token(24);
                return Str.longString(this.token.image);
            case 25:
                jj_consume_token(25);
                return Str.longString(this.token.image);
            case 26:
                jj_consume_token(26);
                return Str.longString(this.token.image);
            case 27:
                jj_consume_token(27);
                return Str.longString(this.token.image);
            case 61:
                jj_consume_token(61);
                return Str.quoteString(this.token.image);
            case 62:
                jj_consume_token(62);
                return Str.charString(this.token.image);
            default:
                this.jj_la1[22] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final TableConstructor TableConstructor() throws ParseException {
        TableConstructor tableConstructor = new TableConstructor();
        long LineInfo = LineInfo();
        jj_consume_token(80);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 35:
            case 37:
            case 42:
            case 43:
            case 48:
            case 51:
            case 52:
            case 61:
            case 62:
            case 69:
            case 75:
            case 77:
            case 79:
            case 80:
            case 83:
                tableConstructor.fields = FieldList();
                break;
            default:
                this.jj_la1[27] = this.jj_gen;
                break;
        }
        jj_consume_token(81);
        L(tableConstructor, LineInfo);
        return tableConstructor;
    }

    public final int Unop() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 43:
                jj_consume_token(43);
                return 20;
            case 69:
                jj_consume_token(69);
                return 21;
            case 83:
                jj_consume_token(83);
                return 19;
            default:
                this.jj_la1[33] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final Exp.VarExp VarExp() throws ParseException {
        return assertvarexp(PrimaryExp());
    }

    public final void disable_tracing() {
    }

    public final void enable_tracing() {
    }

    public ParseException generateParseException() {
        this.jj_expentries.clear();
        boolean[] zArr = new boolean[95];
        if (this.jj_kind >= 0) {
            zArr[this.jj_kind] = true;
            this.jj_kind = -1;
        }
        for (int i = 0; i < 34; i++) {
            if (this.jj_la1[i] == this.jj_gen) {
                for (int i2 = 0; i2 < 32; i2++) {
                    int i3 = 1 << i2;
                    if ((jj_la1_0[i] & i3) != 0) {
                        zArr[i2] = true;
                    }
                    if ((jj_la1_1[i] & i3) != 0) {
                        zArr[i2 + 32] = true;
                    }
                    if ((jj_la1_2[i] & i3) != 0) {
                        zArr[i2 + 64] = true;
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 95; i4++) {
            if (zArr[i4]) {
                this.jj_expentry = new int[1];
                this.jj_expentry[0] = i4;
                this.jj_expentries.add(this.jj_expentry);
            }
        }
        this.jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] iArr = new int[this.jj_expentries.size()];
        for (int i5 = 0; i5 < this.jj_expentries.size(); i5++) {
            iArr[i5] = (int[]) this.jj_expentries.get(i5);
        }
        return new ParseException(this.token, iArr, tokenImage);
    }

    public SimpleCharStream getCharStream() {
        return this.jj_input_stream;
    }

    public final Token getNextToken() {
        if (this.token.next != null) {
            this.token = this.token.next;
        } else {
            Token token = this.token;
            Token nextToken = this.token_source.getNextToken();
            token.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        this.jj_gen++;
        return this.token;
    }

    public final Token getToken(int i) {
        Token token = this.token;
        for (int i2 = 0; i2 < i; i2++) {
            if (token.next != null) {
                token = token.next;
            } else {
                Token nextToken = this.token_source.getNextToken();
                token.next = nextToken;
                token = nextToken;
            }
        }
        return token;
    }
}
