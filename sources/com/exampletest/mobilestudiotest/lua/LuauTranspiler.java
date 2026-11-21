package com.exampletest.mobilestudiotest.lua;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: LuauTranspiler.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005 !\"#$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler;", "", "<init>", "()V", "keywords", "", "", "ops", "", "lastFailure", "getLastFailure", "()Ljava/lang/String;", "setLastFailure", "(Ljava/lang/String;)V", "transpile", "src", "hoistTopLocals", "", "relevel", "text", "prefix", "lex", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$Tok;", "Lkotlin/collections/ArrayList;", "s", "interpolated", "Lkotlin/Pair;", "", "start", "transpileExpr", "e", "K", "Tok", "ParseError", "LoopCtx", "Parser", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuauTranspiler {
    private static volatile String lastFailure;
    public static final LuauTranspiler INSTANCE = new LuauTranspiler();
    private static final Set<String> keywords = SetsKt.setOf((Object[]) new String[]{"and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while"});
    private static final List<String> ops = CollectionsKt.listOf((Object[]) new String[]{"...", "..=", "//=", "..", "==", "~=", "<=", ">=", "//", "::", "->", "+=", "-=", "*=", "/=", "%=", "^=", "+", "-", "*", "/", "%", "^", "#", "&", "|", "~", "<", ">", "=", "(", ")", "{", "}", "[", "]", ";", ":", ",", ".", "?", "@", "!"});

    /* compiled from: LuauTranspiler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$K;", "", "<init>", "(Ljava/lang/String;I)V", "NAME", "KEYWORD", "NUMBER", "STRING", "OP", "EOF", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    private enum K {
        NAME,
        KEYWORD,
        NUMBER,
        STRING,
        OP,
        EOF;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<K> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: LuauTranspiler.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$LoopCtx;", "", "id", "", "<init>", "(I)V", "getId", "()I", "usesContinue", "", "getUsesContinue", "()Z", "setUsesContinue", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    private static final class LoopCtx {
        private final int id;
        private boolean usesContinue;

        public LoopCtx(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getUsesContinue() {
            return this.usesContinue;
        }

        public final void setUsesContinue(boolean z) {
            this.usesContinue = z;
        }
    }

    /* compiled from: LuauTranspiler.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$ParseError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    private static final class ParseError extends Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LuauTranspiler.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u0006\u0010'\u001a\u00020\u0004J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eJ\u0006\u0010,\u001a\u00020)J\u0006\u0010-\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020)J\u000e\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020%J\u0006\u00101\u001a\u00020)J\u0006\u00102\u001a\u00020\u0006J\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u000eJ\u0006\u00105\u001a\u00020)J\u0006\u00106\u001a\u00020)J\u0006\u00107\u001a\u00020)J\u0006\u00108\u001a\u00020)J\u0016\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020%J\u0006\u0010<\u001a\u00020)J\u0006\u0010=\u001a\u00020)J\u0006\u0010>\u001a\u00020)J\u0006\u0010?\u001a\u00020)J\u0006\u0010@\u001a\u00020)J\u0006\u0010A\u001a\u00020)J\u0006\u0010B\u001a\u00020)J\u0006\u0010C\u001a\u00020)J\u0006\u0010D\u001a\u00020)J\u0006\u0010E\u001a\u00020)J\u0006\u0010F\u001a\u00020)J\u001e\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010H2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u0006\u0010J\u001a\u00020)J\u000e\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R%\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aj\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006M"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$Parser;", "", "t", "", "Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$Tok;", "hoist", "", "<init>", "(Ljava/util/List;Z)V", "getT", "()Ljava/util/List;", "getHoist", "()Z", "p", "", "getP", "()I", "setP", "(I)V", "labelCounter", "getLabelCounter", "setLabelCounter", "depth", "getDepth", "setDepth", "loops", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$LoopCtx;", "Lkotlin/collections/ArrayList;", "getLoops", "()Ljava/util/ArrayList;", "peek", "o", "next", "atEof", "expectOp", "s", "", "expectKw", "expectName", "drop", "", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "run", "blockEnd", "block", "loopBody", "endKw", "statement", "isStatementWord", "typeDecl", "start", "nameWithType", "localName", "funcBody", "skipAngle", "skipBalanced", "open", "close", "returnType", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "simpleType", "exprList", "exprStatement", "primaryExpr", "suffixedExpr", "callArgs", "table", "simpleExpr", "ifExpr", "binPrio", "Lkotlin/Pair;", "k", "expr", "subExpr", "limit", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Parser {
        private int depth;
        private final boolean hoist;
        private int labelCounter;
        private final ArrayList<LoopCtx> loops;
        private int p;
        private final List<Tok> t;

        public Parser(List<Tok> t, boolean z) {
            Intrinsics.checkNotNullParameter(t, "t");
            this.t = t;
            this.hoist = z;
            this.loops = new ArrayList<>();
        }

        public /* synthetic */ Parser(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? false : z);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:17:0x003f. Please report as an issue. */
        private final Pair<Integer, Integer> binPrio(Tok k) {
            int i;
            if (k.getK() == K.KEYWORD) {
                String text = k.getText();
                if (Intrinsics.areEqual(text, "or")) {
                    i = 1;
                } else {
                    if (!Intrinsics.areEqual(text, "and")) {
                        return null;
                    }
                    i = 2;
                }
                return TuplesKt.to(Integer.valueOf(i), Integer.valueOf(i));
            }
            if (k.getK() != K.OP) {
                return null;
            }
            String text2 = k.getText();
            switch (text2.hashCode()) {
                case 37:
                    if (!text2.equals("%")) {
                        return null;
                    }
                    return TuplesKt.to(11, 11);
                case 42:
                    if (!text2.equals("*")) {
                        return null;
                    }
                    return TuplesKt.to(11, 11);
                case 43:
                    if (!text2.equals("+")) {
                        return null;
                    }
                    return TuplesKt.to(10, 10);
                case 45:
                    if (!text2.equals("-")) {
                        return null;
                    }
                    return TuplesKt.to(10, 10);
                case 47:
                    if (!text2.equals("/")) {
                        return null;
                    }
                    return TuplesKt.to(11, 11);
                case 60:
                    if (!text2.equals("<")) {
                        return null;
                    }
                    return TuplesKt.to(3, 3);
                case 62:
                    if (!text2.equals(">")) {
                        return null;
                    }
                    return TuplesKt.to(3, 3);
                case 94:
                    if (text2.equals("^")) {
                        return TuplesKt.to(14, 13);
                    }
                    return null;
                case 1472:
                    if (text2.equals("..")) {
                        return TuplesKt.to(9, 8);
                    }
                    return null;
                case 1504:
                    if (!text2.equals("//")) {
                        return null;
                    }
                    return TuplesKt.to(11, 11);
                case 1921:
                    if (!text2.equals("<=")) {
                        return null;
                    }
                    return TuplesKt.to(3, 3);
                case 1952:
                    if (!text2.equals("==")) {
                        return null;
                    }
                    return TuplesKt.to(3, 3);
                case 1983:
                    if (!text2.equals(">=")) {
                        return null;
                    }
                    return TuplesKt.to(3, 3);
                case 3967:
                    if (!text2.equals("~=")) {
                        return null;
                    }
                    return TuplesKt.to(3, 3);
                default:
                    return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final CharSequence exprStatement$lambda$2(Parser parser, int i) {
            return parser.t.get(i).getOut();
        }

        public static /* synthetic */ Tok peek$default(Parser parser, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return parser.peek(i);
        }

        public final boolean atEof() {
            return peek$default(this, 0, 1, null).getK() == K.EOF;
        }

        public final void block() {
            this.depth++;
            while (!blockEnd()) {
                if (peek$default(this, 0, 1, null).isKw("return")) {
                    next();
                    if (!blockEnd() && !peek$default(this, 0, 1, null).isOp(";")) {
                        exprList();
                    }
                    if (peek$default(this, 0, 1, null).isOp(";")) {
                        next();
                    }
                } else {
                    statement();
                }
            }
            this.depth--;
        }

        public final boolean blockEnd() {
            Tok peek$default = peek$default(this, 0, 1, null);
            return peek$default.getK() == K.EOF || peek$default.isKw("end") || peek$default.isKw("else") || peek$default.isKw("elseif") || peek$default.isKw("until");
        }

        public final void callArgs() {
            Tok peek$default = peek$default(this, 0, 1, null);
            if (peek$default.getK() == K.STRING) {
                next();
                return;
            }
            if (peek$default.isOp("{")) {
                table();
                Unit unit = Unit.INSTANCE;
            } else {
                if (!peek$default.isOp("(")) {
                    throw new ParseError();
                }
                next();
                if (!peek$default(this, 0, 1, null).isOp(")")) {
                    exprList();
                }
                expectOp(")");
            }
        }

        public final void drop(int from, int to) {
            for (int i = from; i < to; i++) {
                Tok tok = this.t.get(i);
                String text = tok.getText();
                StringBuilder sb = new StringBuilder();
                int length = text.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = text.charAt(i2);
                    if (charAt == '\n') {
                        sb.append(charAt);
                    }
                }
                tok.setOut(sb.toString());
                tok.setPrefix("");
                tok.setSuffix("");
            }
        }

        public final Tok expectKw(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            if (peek$default(this, 0, 1, null).isKw(s)) {
                return next();
            }
            throw new ParseError();
        }

        public final Tok expectName() {
            if (peek$default(this, 0, 1, null).getK() == K.NAME) {
                return next();
            }
            throw new ParseError();
        }

        public final Tok expectOp(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            if (peek$default(this, 0, 1, null).isOp(s)) {
                return next();
            }
            throw new ParseError();
        }

        public final void expr() {
            subExpr(0);
        }

        public final void exprList() {
            while (true) {
                expr();
                if (!peek$default(this, 0, 1, null).isOp(",")) {
                    return;
                } else {
                    next();
                }
            }
        }

        public final void exprStatement() {
            int i = this.p;
            suffixedExpr();
            Tok peek$default = peek$default(this, 0, 1, null);
            if (peek$default.isOp("=") || peek$default.isOp(",")) {
                while (peek$default(this, 0, 1, null).isOp(",")) {
                    next();
                    suffixedExpr();
                }
                expectOp("=");
                exprList();
                return;
            }
            if (peek$default.getK() != K.OP || peek$default.getText().length() < 2 || !StringsKt.endsWith$default(peek$default.getText(), "=", false, 2, (Object) null) || SetsKt.setOf((Object[]) new String[]{"==", "~=", "<=", ">="}).contains(peek$default.getText())) {
                return;
            }
            Tok next = next();
            String dropLast = StringsKt.dropLast(next.getText(), 1);
            String joinToString$default = CollectionsKt.joinToString$default(RangesKt.until(i, this.p - 1), " ", null, null, 0, null, new LuauTranspiler$Parser$$ExternalSyntheticLambda0(this), 30, null);
            int i2 = this.p;
            expr();
            Tok tok = this.t.get(this.p - 1);
            if (Intrinsics.areEqual(dropLast, "//")) {
                next.setOut("= math.floor(" + joinToString$default + " / (");
                tok.setSuffix(tok.getSuffix() + "))");
            } else {
                next.setOut("= " + joinToString$default + " " + dropLast + " (");
                tok.setSuffix(tok.getSuffix() + ")");
            }
            if (i2 == this.p) {
                throw new ParseError();
            }
        }

        public final void funcBody() {
            if (peek$default(this, 0, 1, null).isOp("<")) {
                int i = this.p;
                skipAngle();
                drop(i, this.p);
            }
            expectOp("(");
            while (!peek$default(this, 0, 1, null).isOp(")")) {
                if (peek$default(this, 0, 1, null).isOp("...")) {
                    next();
                    if (peek$default(this, 0, 1, null).isOp(":")) {
                        int i2 = this.p;
                        next();
                        type();
                        drop(i2, this.p);
                    }
                } else {
                    nameWithType();
                }
                if (!peek$default(this, 0, 1, null).isOp(",")) {
                    break;
                } else {
                    next();
                }
            }
            expectOp(")");
            if (peek$default(this, 0, 1, null).isOp(":")) {
                int i3 = this.p;
                next();
                returnType();
                drop(i3, this.p);
            }
            this.loops.add(null);
            block();
            this.loops.remove(this.loops.size() - 1);
            expectKw("end");
        }

        public final int getDepth() {
            return this.depth;
        }

        public final boolean getHoist() {
            return this.hoist;
        }

        public final int getLabelCounter() {
            return this.labelCounter;
        }

        public final ArrayList<LoopCtx> getLoops() {
            return this.loops;
        }

        public final int getP() {
            return this.p;
        }

        public final List<Tok> getT() {
            return this.t;
        }

        public final void ifExpr() {
            next().setOut("(function() if");
            expr();
            expectKw("then").setOut("then return");
            expr();
            while (peek$default(this, 0, 1, null).isKw("elseif")) {
                next();
                expr();
                expectKw("then").setOut("then return");
                expr();
            }
            expectKw("else").setOut("else return");
            expr();
            Tok tok = this.t.get(this.p - 1);
            tok.setSuffix(tok.getSuffix() + " end end)()");
        }

        public final boolean isStatementWord() {
            Tok peek = peek(1);
            return (peek.isOp("(") || peek.isOp("=") || peek.isOp(".") || peek.isOp("[") || peek.isOp(":") || peek.isOp(",") || peek.getK() == K.STRING || peek.isOp("{") || peek.isOp("+=") || peek.isOp("-=")) ? false : true;
        }

        public final void localName() {
            expectName();
            if (peek$default(this, 0, 1, null).isOp("<")) {
                int i = this.p;
                skipAngle();
                drop(i, this.p);
            }
            if (peek$default(this, 0, 1, null).isOp(":")) {
                int i2 = this.p;
                next();
                type();
                drop(i2, this.p);
            }
        }

        public final Tok loopBody(String endKw) {
            Intrinsics.checkNotNullParameter(endKw, "endKw");
            this.labelCounter++;
            LoopCtx loopCtx = new LoopCtx(this.labelCounter);
            this.loops.add(loopCtx);
            int i = this.p;
            block();
            this.loops.remove(this.loops.size() - 1);
            Tok expectKw = expectKw(endKw);
            if (loopCtx.getUsesContinue()) {
                if (Intrinsics.areEqual(endKw, "end")) {
                    this.t.get(i).setPrefix("do " + this.t.get(i).getPrefix());
                    expectKw.setPrefix(expectKw.getPrefix() + " end ::__continue" + loopCtx.getId() + ":: ");
                } else {
                    expectKw.setPrefix("::__continue" + loopCtx.getId() + ":: ");
                }
            }
            return expectKw;
        }

        public final void nameWithType() {
            expectName();
            if (peek$default(this, 0, 1, null).isOp(":")) {
                int i = this.p;
                next();
                type();
                drop(i, this.p);
            }
        }

        public final Tok next() {
            Tok tok = this.t.get(this.p);
            if (this.p < this.t.size() - 1) {
                this.p++;
            }
            return tok;
        }

        public final Tok peek(int o) {
            return this.t.get(Math.min(this.p + o, this.t.size() - 1));
        }

        public final void primaryExpr() {
            Tok peek$default = peek$default(this, 0, 1, null);
            if (peek$default.getK() == K.NAME) {
                next();
            } else {
                if (!peek$default.isOp("(")) {
                    throw new ParseError();
                }
                next();
                expr();
                expectOp(")");
            }
        }

        public final void returnType() {
            if (!peek$default(this, 0, 1, null).isOp("(")) {
                type();
                return;
            }
            skipBalanced("(", ")");
            if (peek$default(this, 0, 1, null).isOp("->")) {
                next();
                type();
            }
            while (peek$default(this, 0, 1, null).isOp("?")) {
                next();
            }
            while (true) {
                if (!peek$default(this, 0, 1, null).isOp("|") && !peek$default(this, 0, 1, null).isOp("&")) {
                    return;
                }
                next();
                simpleType();
            }
        }

        public final void run() {
            block();
            if (!atEof()) {
                throw new ParseError();
            }
        }

        public final void setDepth(int i) {
            this.depth = i;
        }

        public final void setLabelCounter(int i) {
            this.labelCounter = i;
        }

        public final void setP(int i) {
            this.p = i;
        }

        public final void simpleExpr() {
            Tok peek$default = peek$default(this, 0, 1, null);
            if (peek$default.getK() == K.NUMBER || peek$default.getK() == K.STRING || peek$default.isKw("nil") || peek$default.isKw("true") || peek$default.isKw("false") || peek$default.isOp("...")) {
                next();
            } else if (peek$default.isOp("{")) {
                table();
            } else if (peek$default.isKw("function")) {
                next();
                funcBody();
            } else if (peek$default.isKw("if")) {
                ifExpr();
            } else {
                suffixedExpr();
            }
            if (peek$default(this, 0, 1, null).isOp("::")) {
                int i = this.p;
                next();
                type();
                drop(i, this.p);
            }
        }

        public final void simpleType() {
            Tok peek$default = peek$default(this, 0, 1, null);
            if (peek$default.isOp("<")) {
                skipAngle();
                simpleType();
            } else if (peek$default.isOp("(")) {
                skipBalanced("(", ")");
                if (peek$default(this, 0, 1, null).isOp("->")) {
                    next();
                    type();
                }
            } else if (peek$default.isOp("{")) {
                skipBalanced("{", "}");
            } else if (peek$default.isName("typeof")) {
                next();
                skipBalanced("(", ")");
            } else if (peek$default.isOp("...")) {
                next();
                simpleType();
            } else {
                if (peek$default.getK() != K.NAME && !peek$default.isKw("nil") && !peek$default.isKw("true") && !peek$default.isKw("false") && peek$default.getK() != K.STRING) {
                    throw new ParseError();
                }
                next();
                while (peek$default(this, 0, 1, null).isOp(".")) {
                    next();
                    expectName();
                }
                if (peek$default(this, 0, 1, null).isOp("<")) {
                    skipAngle();
                }
                if (peek$default(this, 0, 1, null).isOp("...")) {
                    next();
                }
            }
            while (peek$default(this, 0, 1, null).isOp("?")) {
                next();
            }
        }

        public final void skipAngle() {
            expectOp("<");
            int i = 1;
            while (i > 0 && !atEof()) {
                Tok next = next();
                if (next.isOp("<")) {
                    i++;
                } else if (next.isOp(">")) {
                    i--;
                } else if (next.isOp(">=")) {
                    i--;
                }
            }
        }

        public final void skipBalanced(String open, String close) {
            Intrinsics.checkNotNullParameter(open, "open");
            Intrinsics.checkNotNullParameter(close, "close");
            expectOp(open);
            int i = 1;
            while (i > 0 && !atEof()) {
                Tok next = next();
                if (next.isOp(open)) {
                    i++;
                } else if (next.isOp(close)) {
                    i--;
                }
            }
        }

        public final void statement() {
            Tok peek$default = peek$default(this, 0, 1, null);
            if (peek$default.isOp(";")) {
                next();
                return;
            }
            if (peek$default.isKw("if")) {
                next();
                expr();
                expectKw("then");
                block();
                while (peek$default(this, 0, 1, null).isKw("elseif")) {
                    next();
                    expr();
                    expectKw("then");
                    block();
                }
                if (peek$default(this, 0, 1, null).isKw("else")) {
                    next();
                    block();
                }
                expectKw("end");
                return;
            }
            if (peek$default.isKw("while")) {
                next();
                expr();
                expectKw("do");
                loopBody("end");
                return;
            }
            if (peek$default.isKw("do")) {
                next();
                block();
                expectKw("end");
                return;
            }
            if (peek$default.isKw("for")) {
                next();
                nameWithType();
                if (peek$default(this, 0, 1, null).isOp("=")) {
                    next();
                    exprList();
                } else {
                    while (peek$default(this, 0, 1, null).isOp(",")) {
                        next();
                        nameWithType();
                    }
                    expectKw("in");
                    int i = this.p;
                    expr();
                    if (peek$default(this, 0, 1, null).isOp(",")) {
                        while (peek$default(this, 0, 1, null).isOp(",")) {
                            next();
                            expr();
                        }
                    } else {
                        this.t.get(i).setPrefix("__iter(" + this.t.get(i).getPrefix());
                        Tok tok = this.t.get(this.p - 1);
                        tok.setSuffix(tok.getSuffix() + ")");
                    }
                }
                expectKw("do");
                loopBody("end");
                return;
            }
            if (peek$default.isKw("repeat")) {
                next();
                loopBody("until");
                expr();
                Unit unit = Unit.INSTANCE;
                return;
            }
            if (!peek$default.isKw("function")) {
                if (peek$default.isKw("local")) {
                    Tok next = next();
                    boolean z = this.hoist && this.depth == 1;
                    if (z) {
                        next.setOut("");
                    }
                    if (peek$default(this, 0, 1, null).isKw("function")) {
                        next();
                        expectName();
                        funcBody();
                    } else {
                        localName();
                        while (peek$default(this, 0, 1, null).isOp(",")) {
                            next();
                            localName();
                        }
                        if (peek$default(this, 0, 1, null).isOp("=")) {
                            next();
                            exprList();
                        } else if (z) {
                            Tok tok2 = this.t.get(this.p - 1);
                            tok2.setSuffix(tok2.getSuffix() + " = nil");
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
                if (peek$default.isKw("break")) {
                    next();
                    return;
                }
                if (peek$default.isKw("goto")) {
                    next();
                    expectName();
                    return;
                }
                if (peek$default.isOp("::")) {
                    next();
                    expectName();
                    expectOp("::");
                    return;
                }
                if (peek$default.isName("continue") && isStatementWord()) {
                    Tok next2 = next();
                    LoopCtx loopCtx = (LoopCtx) CollectionsKt.lastOrNull((List) this.loops);
                    if (loopCtx == null) {
                        throw new ParseError();
                    }
                    loopCtx.setUsesContinue(true);
                    next2.setOut("goto __continue" + loopCtx.getId());
                    Unit unit3 = Unit.INSTANCE;
                    return;
                }
                if (peek$default.isName(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) && peek(1).getK() == K.NAME && (peek(2).isOp("=") || peek(2).isOp("<"))) {
                    typeDecl(this.p);
                    Unit unit4 = Unit.INSTANCE;
                    return;
                } else if (peek$default.isName("export") && peek(1).isName(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                    typeDecl(this.p);
                    Unit unit5 = Unit.INSTANCE;
                    return;
                } else {
                    exprStatement();
                    Unit unit6 = Unit.INSTANCE;
                    return;
                }
            }
            next();
            expectName();
            while (true) {
                if (!peek$default(this, 0, 1, null).isOp(".") && !peek$default(this, 0, 1, null).isOp(":")) {
                    funcBody();
                    Unit unit7 = Unit.INSTANCE;
                    return;
                } else {
                    next();
                    expectName();
                }
            }
        }

        public final void subExpr(int limit) {
            int i = this.p;
            Tok peek$default = peek$default(this, 0, 1, null);
            if (peek$default.isKw("not") || peek$default.isOp("-") || peek$default.isOp("#")) {
                next();
                subExpr(12);
            } else {
                simpleExpr();
            }
            while (true) {
                Tok peek$default2 = peek$default(this, 0, 1, null);
                Pair<Integer, Integer> binPrio = binPrio(peek$default2);
                if (binPrio == null || binPrio.getFirst().intValue() <= limit) {
                    return;
                }
                next();
                subExpr(binPrio.getSecond().intValue());
                if (peek$default2.isOp("//")) {
                    peek$default2.setOut("/");
                    this.t.get(i).setPrefix("math.floor(" + this.t.get(i).getPrefix());
                    Tok tok = this.t.get(this.p - 1);
                    tok.setSuffix(tok.getSuffix() + ")");
                }
            }
        }

        public final void suffixedExpr() {
            primaryExpr();
            while (true) {
                Tok peek$default = peek$default(this, 0, 1, null);
                if (peek$default.isOp(".")) {
                    next();
                    if (peek$default(this, 0, 1, null).getK() != K.NAME && peek$default(this, 0, 1, null).getK() != K.KEYWORD) {
                        throw new ParseError();
                    }
                    next();
                } else if (peek$default.isOp("[")) {
                    next();
                    expr();
                    expectOp("]");
                } else if (peek$default.isOp(":")) {
                    next();
                    expectName();
                    callArgs();
                } else if (!peek$default.isOp("(") && !peek$default.isOp("{") && peek$default.getK() != K.STRING) {
                    return;
                } else {
                    callArgs();
                }
            }
        }

        public final void table() {
            expectOp("{");
            while (!peek$default(this, 0, 1, null).isOp("}")) {
                if (peek$default(this, 0, 1, null).isOp("[")) {
                    next();
                    expr();
                    expectOp("]");
                    expectOp("=");
                    expr();
                } else if (peek$default(this, 0, 1, null).getK() == K.NAME && peek(1).isOp("=")) {
                    next();
                    next();
                    expr();
                } else {
                    expr();
                }
                if (!peek$default(this, 0, 1, null).isOp(",") && !peek$default(this, 0, 1, null).isOp(";")) {
                    break;
                } else {
                    next();
                }
            }
            expectOp("}");
        }

        public final void type() {
            if (peek$default(this, 0, 1, null).isOp("|") || peek$default(this, 0, 1, null).isOp("&")) {
                next();
            }
            simpleType();
            while (true) {
                if (!peek$default(this, 0, 1, null).isOp("|") && !peek$default(this, 0, 1, null).isOp("&")) {
                    return;
                }
                next();
                simpleType();
            }
        }

        public final void typeDecl(int start) {
            if (peek$default(this, 0, 1, null).isName("export")) {
                next();
            }
            next();
            expectName();
            if (peek$default(this, 0, 1, null).isOp("<")) {
                skipAngle();
            }
            expectOp("=");
            type();
            drop(start, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LuauTranspiler.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$Tok;", "", "k", "Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$K;", "text", "", "trivia", "<init>", "(Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$K;Ljava/lang/String;Ljava/lang/String;)V", "getK", "()Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$K;", "getText", "()Ljava/lang/String;", "getTrivia", "out", "getOut", "setOut", "(Ljava/lang/String;)V", "prefix", "getPrefix", "setPrefix", "suffix", "getSuffix", "setSuffix", "isOp", "", "s", "isKw", "isName", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Tok {
        private final K k;
        private String out;
        private String prefix;
        private String suffix;
        private final String text;
        private final String trivia;

        public Tok(K k, String text, String trivia) {
            Intrinsics.checkNotNullParameter(k, "k");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(trivia, "trivia");
            this.k = k;
            this.text = text;
            this.trivia = trivia;
            this.out = this.text;
            this.prefix = "";
            this.suffix = "";
        }

        public final K getK() {
            return this.k;
        }

        public final String getOut() {
            return this.out;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getSuffix() {
            return this.suffix;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTrivia() {
            return this.trivia;
        }

        public final boolean isKw(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            return this.k == K.KEYWORD && Intrinsics.areEqual(this.text, s);
        }

        public final boolean isName(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            return this.k == K.NAME && Intrinsics.areEqual(this.text, s);
        }

        public final boolean isOp(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            return this.k == K.OP && Intrinsics.areEqual(this.text, s);
        }

        public final void setOut(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.out = str;
        }

        public final void setPrefix(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.prefix = str;
        }

        public final void setSuffix(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.suffix = str;
        }
    }

    private LuauTranspiler() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0086, code lost:
    
        if (r6 <= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0088, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<java.lang.Integer, java.lang.String> interpolated(java.lang.String r20, int r21) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuauTranspiler.interpolated(java.lang.String, int):kotlin.Pair");
    }

    private static final void interpolated$flush(StringBuilder sb, ArrayList<String> arrayList) {
        if (sb.length() > 0) {
            arrayList.add("\"" + ((Object) sb) + "\"");
            sb.setLength(0);
        }
    }

    private final ArrayList<Tok> lex(String s) {
        int i;
        int i2;
        int i3;
        ArrayList<Tok> arrayList = new ArrayList<>();
        int i4 = 0;
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i5 = i4;
            while (i5 < length) {
                char charAt = s.charAt(i5);
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        sb.append(charAt);
                        i5++;
                        break;
                    default:
                        if (charAt == '-' && i5 + 1 < length && s.charAt(i5 + 1) == '-') {
                            int lex$longBracketLevel = lex$longBracketLevel(length, s, i5 + 2);
                            if (lex$longBracketLevel >= 0) {
                                i3 = lex$skipLong(s, length, i5 + 2, lex$longBracketLevel);
                                i2 = i5;
                            } else {
                                i2 = i5;
                                int indexOf$default = StringsKt.indexOf$default((CharSequence) s, '\n', i2, false, 4, (Object) null);
                                i3 = indexOf$default < 0 ? length : indexOf$default;
                            }
                            String substring = s.substring(i2, i3);
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                            sb.append(lex$longBracketLevel == 0 ? relevel(substring, "--") : substring);
                            i5 = i3;
                            break;
                        } else {
                            i = i5;
                        }
                        break;
                }
            }
            i = i5;
            if (i >= length) {
                K k = K.EOF;
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                arrayList.add(new Tok(k, "", sb2));
                return arrayList;
            }
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            sb.setLength(0);
            char charAt2 = s.charAt(i);
            if (Character.isLetter(charAt2) || charAt2 == '_') {
                i4 = i;
                while (i4 < length && (Character.isLetterOrDigit(s.charAt(i4)) || s.charAt(i4) == '_')) {
                    i4++;
                }
                String substring2 = s.substring(i, i4);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                arrayList.add(new Tok(keywords.contains(substring2) ? K.KEYWORD : K.NAME, substring2, sb3));
            } else {
                Object obj = null;
                if (Character.isDigit(charAt2) || (charAt2 == '.' && i + 1 < length && Character.isDigit(s.charAt(i + 1)))) {
                    int i6 = i;
                    if (charAt2 == '0' && i + 1 < length && (s.charAt(i + 1) == 'x' || s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'b' || s.charAt(i + 1) == 'B')) {
                        i6 += 2;
                        while (i6 < length && (Character.isLetterOrDigit(s.charAt(i6)) || s.charAt(i6) == '_')) {
                            i6++;
                        }
                    } else {
                        while (i6 < length && (Character.isDigit(s.charAt(i6)) || s.charAt(i6) == '.' || s.charAt(i6) == '_')) {
                            i6++;
                        }
                        if (i6 < length && (s.charAt(i6) == 'e' || s.charAt(i6) == 'E')) {
                            i6++;
                            if (i6 < length && (s.charAt(i6) == '+' || s.charAt(i6) == '-')) {
                                i6++;
                            }
                            while (i6 < length && Character.isDigit(s.charAt(i6))) {
                                i6++;
                            }
                        }
                    }
                    String substring3 = s.substring(i, i6);
                    Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                    String replace$default = StringsKt.replace$default(substring3, "_", "", false, 4, (Object) null);
                    if (StringsKt.startsWith$default(replace$default, "0b", false, 2, (Object) null) || StringsKt.startsWith$default(replace$default, "0B", false, 2, (Object) null)) {
                        String substring4 = replace$default.substring(2);
                        Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                        Long longOrNull = StringsKt.toLongOrNull(substring4, 2);
                        replace$default = String.valueOf(longOrNull != null ? longOrNull.longValue() : 0L);
                    }
                    K k2 = K.NUMBER;
                    String substring5 = s.substring(i, i6);
                    Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
                    Tok tok = new Tok(k2, substring5, sb3);
                    tok.setOut(replace$default);
                    arrayList.add(tok);
                    i4 = i6;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    int i7 = i + 1;
                    while (i7 < length && s.charAt(i7) != charAt2) {
                        if (s.charAt(i7) == '\\') {
                            i7++;
                        }
                        if (i7 >= length || s.charAt(i7) != '\n' || s.charAt(i7 - 1) == '\\') {
                            i7++;
                        }
                    }
                    i4 = Math.min(i7 + 1, length);
                    K k3 = K.STRING;
                    String substring6 = s.substring(i, i4);
                    Intrinsics.checkNotNullExpressionValue(substring6, "substring(...)");
                    arrayList.add(new Tok(k3, substring6, sb3));
                } else if (charAt2 == '[' && lex$longBracketLevel(length, s, i) >= 0) {
                    int lex$longBracketLevel2 = lex$longBracketLevel(length, s, i);
                    int lex$skipLong = lex$skipLong(s, length, i, lex$longBracketLevel2);
                    K k4 = K.STRING;
                    String substring7 = s.substring(i, lex$skipLong);
                    Intrinsics.checkNotNullExpressionValue(substring7, "substring(...)");
                    Tok tok2 = new Tok(k4, substring7, sb3);
                    if (lex$longBracketLevel2 == 0) {
                        tok2.setOut(relevel(tok2.getText(), ""));
                    }
                    arrayList.add(tok2);
                    i4 = lex$skipLong;
                } else if (charAt2 == '`') {
                    Pair<Integer, String> interpolated = interpolated(s, i);
                    int intValue = interpolated.component1().intValue();
                    String component2 = interpolated.component2();
                    K k5 = K.STRING;
                    String substring8 = s.substring(i, intValue);
                    Intrinsics.checkNotNullExpressionValue(substring8, "substring(...)");
                    Tok tok3 = new Tok(k5, substring8, sb3);
                    tok3.setOut(component2);
                    arrayList.add(tok3);
                    i4 = intValue;
                } else {
                    Iterator<T> it = ops.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (StringsKt.startsWith$default(s, (String) next, i, false, 4, (Object) null)) {
                                obj = next;
                            }
                        }
                    }
                    String str = (String) obj;
                    if (str == null) {
                        str = String.valueOf(charAt2);
                    }
                    arrayList.add(new Tok(K.OP, str, sb3));
                    i4 = str.length() + i;
                }
            }
        }
    }

    private static final int lex$longBracketLevel(int i, String str, int i2) {
        if (i2 >= i || str.charAt(i2) != '[') {
            return -1;
        }
        int i3 = i2 + 1;
        int i4 = 0;
        while (i3 < i && str.charAt(i3) == '=') {
            i4++;
            i3++;
        }
        if (i3 >= i || str.charAt(i3) != '[') {
            return -1;
        }
        return i4;
    }

    private static final int lex$skipLong(String str, int i, int i2, int i3) {
        String str2 = "]" + StringsKt.repeat("=", i3) + "]";
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, i2 + i3 + 2, false, 4, (Object) null);
        return indexOf$default < 0 ? i : str2.length() + indexOf$default;
    }

    private final String relevel(String text, String prefix) {
        String removePrefix = StringsKt.removePrefix(text, (CharSequence) prefix);
        if (!StringsKt.startsWith$default(removePrefix, "[[", false, 2, (Object) null) || !StringsKt.endsWith$default(removePrefix, "]]", false, 2, (Object) null)) {
            return text;
        }
        String substring = removePrefix.substring(2, removePrefix.length() - 2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        if (!StringsKt.contains$default((CharSequence) substring, (CharSequence) "[[", false, 2, (Object) null)) {
            return text;
        }
        int i = 1;
        while (StringsKt.contains$default((CharSequence) substring, (CharSequence) ("]" + StringsKt.repeat("=", i) + "]"), false, 2, (Object) null)) {
            i++;
        }
        String repeat = StringsKt.repeat("=", i);
        return prefix + "[" + repeat + "[" + substring + "]" + repeat + "]";
    }

    public static /* synthetic */ String transpile$default(LuauTranspiler luauTranspiler, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return luauTranspiler.transpile(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence transpile$lambda$3(Tok it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getText();
    }

    private final String transpileExpr(String e) {
        String transpile$default = transpile$default(this, "return " + e, false, 2, null);
        if (!StringsKt.startsWith$default(transpile$default, "return ", false, 2, (Object) null)) {
            return e;
        }
        String substring = transpile$default.substring(7);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final String getLastFailure() {
        return lastFailure;
    }

    public final void setLastFailure(String str) {
        lastFailure = str;
    }

    public final String transpile(String src, boolean hoistTopLocals) {
        String str;
        Exception exc;
        Intrinsics.checkNotNullParameter(src, "src");
        Parser parser = null;
        ArrayList<Tok> arrayList = null;
        try {
            arrayList = lex(src);
        } catch (Exception e) {
            e = e;
        }
        try {
            parser = new Parser(arrayList, hoistTopLocals);
            parser.run();
            StringBuilder sb = new StringBuilder(src.length() + 64);
            Iterator<Tok> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Tok next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Tok tok = next;
                sb.append(tok.getTrivia());
                sb.append(tok.getPrefix());
                sb.append(tok.getOut());
                sb.append(tok.getSuffix());
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNull(sb2);
            return sb2;
        } catch (Exception e2) {
            e = e2;
            if (!(e instanceof ParseError) && !(e instanceof IndexOutOfBoundsException)) {
                throw e;
            }
            ArrayList<Tok> arrayList2 = arrayList;
            int p = parser != null ? parser.getP() : 0;
            if (arrayList2 == null) {
                str = null;
            } else {
                int i = 0;
                for (Tok tok2 : CollectionsKt.take(arrayList2, p)) {
                    String trivia = tok2.getTrivia();
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        exc = e;
                        if (i3 >= trivia.length()) {
                            break;
                        }
                        if (trivia.charAt(i3) == '\n') {
                            i2++;
                        }
                        i3++;
                        e = exc;
                    }
                    String text = tok2.getText();
                    int i4 = 0;
                    int i5 = 0;
                    while (i5 < text.length()) {
                        String str2 = text;
                        if (text.charAt(i5) == '\n') {
                            i4++;
                        }
                        i5++;
                        text = str2;
                    }
                    i += i2 + i4;
                    e = exc;
                }
                List<Tok> subList = arrayList2.subList(RangesKt.coerceAtLeast(p - 6, 0), RangesKt.coerceAtMost(p + 4, arrayList2.size()));
                Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
                str = "line " + (i + 1) + " near: " + CollectionsKt.joinToString$default(subList, " ", null, null, 0, null, new LuauTranspiler$$ExternalSyntheticLambda0(), 30, null);
            }
            lastFailure = str;
            return src;
        }
    }
}
