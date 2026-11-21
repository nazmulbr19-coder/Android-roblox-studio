package org.luaj.vm2.ast;

import org.luaj.vm2.LuaValue;

/* loaded from: classes10.dex */
public abstract class Exp extends SyntaxElement {

    /* loaded from: classes10.dex */
    public static class AnonFuncDef extends Exp {
        public final FuncBody body;

        public AnonFuncDef(FuncBody funcBody) {
            this.body = funcBody;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class BinopExp extends Exp {
        public final Exp lhs;
        public final int op;
        public final Exp rhs;

        public BinopExp(Exp exp, int i, Exp exp2) {
            this.lhs = exp;
            this.op = i;
            this.rhs = exp2;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class Constant extends Exp {
        public final LuaValue value;

        public Constant(LuaValue luaValue) {
            this.value = luaValue;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class FieldExp extends VarExp {
        public final PrimaryExp lhs;
        public final Name name;

        public FieldExp(PrimaryExp primaryExp, String str) {
            this.lhs = primaryExp;
            this.name = new Name(str);
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class FuncCall extends PrimaryExp {
        public final FuncArgs args;
        public final PrimaryExp lhs;

        public FuncCall(PrimaryExp primaryExp, FuncArgs funcArgs) {
            this.lhs = primaryExp;
            this.args = funcArgs;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override // org.luaj.vm2.ast.Exp.PrimaryExp, org.luaj.vm2.ast.Exp
        public boolean isfunccall() {
            return true;
        }

        @Override // org.luaj.vm2.ast.Exp
        public boolean isvarargexp() {
            return true;
        }
    }

    /* loaded from: classes10.dex */
    public static class IndexExp extends VarExp {
        public final Exp exp;
        public final PrimaryExp lhs;

        public IndexExp(PrimaryExp primaryExp, Exp exp) {
            this.lhs = primaryExp;
            this.exp = exp;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class MethodCall extends FuncCall {
        public final String name;

        public MethodCall(PrimaryExp primaryExp, String str, FuncArgs funcArgs) {
            super(primaryExp, funcArgs);
            this.name = new String(str);
        }

        @Override // org.luaj.vm2.ast.Exp.FuncCall, org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override // org.luaj.vm2.ast.Exp.FuncCall, org.luaj.vm2.ast.Exp.PrimaryExp, org.luaj.vm2.ast.Exp
        public boolean isfunccall() {
            return true;
        }
    }

    /* loaded from: classes10.dex */
    public static class NameExp extends VarExp {
        public final Name name;

        public NameExp(String str) {
            this.name = new Name(str);
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override // org.luaj.vm2.ast.Exp.VarExp
        public void markHasAssignment() {
            this.name.variable.hasassignments = true;
        }
    }

    /* loaded from: classes10.dex */
    public static class ParensExp extends PrimaryExp {
        public final Exp exp;

        public ParensExp(Exp exp) {
            this.exp = exp;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class PrimaryExp extends Exp {
        @Override // org.luaj.vm2.ast.Exp
        public boolean isfunccall() {
            return false;
        }

        @Override // org.luaj.vm2.ast.Exp
        public boolean isvarexp() {
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static class UnopExp extends Exp {
        public final int op;
        public final Exp rhs;

        public UnopExp(int i, Exp exp) {
            this.op = i;
            this.rhs = exp;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class VarExp extends PrimaryExp {
        @Override // org.luaj.vm2.ast.Exp.PrimaryExp, org.luaj.vm2.ast.Exp
        public boolean isvarexp() {
            return true;
        }

        public void markHasAssignment() {
        }
    }

    /* loaded from: classes10.dex */
    public static class VarargsExp extends Exp {
        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override // org.luaj.vm2.ast.Exp
        public boolean isvarargexp() {
            return true;
        }
    }

    public static Exp anonymousfunction(FuncBody funcBody) {
        return new AnonFuncDef(funcBody);
    }

    public static Exp binaryexp(Exp exp, int i, Exp exp2) {
        if (exp instanceof UnopExp) {
            UnopExp unopExp = (UnopExp) exp;
            if (precedence(i) > precedence(unopExp.op)) {
                return unaryexp(unopExp.op, binaryexp(unopExp.rhs, i, exp2));
            }
        }
        if (exp instanceof BinopExp) {
            BinopExp binopExp = (BinopExp) exp;
            if (precedence(i) > precedence(binopExp.op) || (precedence(i) == precedence(binopExp.op) && isrightassoc(i))) {
                return binaryexp(binopExp.lhs, binopExp.op, binaryexp(binopExp.rhs, i, exp2));
            }
        }
        if (exp2 instanceof BinopExp) {
            BinopExp binopExp2 = (BinopExp) exp2;
            if (precedence(i) > precedence(binopExp2.op) || (precedence(i) == precedence(binopExp2.op) && !isrightassoc(i))) {
                return binaryexp(binaryexp(exp, i, binopExp2.lhs), binopExp2.op, binopExp2.rhs);
            }
        }
        return new BinopExp(exp, i, exp2);
    }

    public static Exp constant(LuaValue luaValue) {
        return new Constant(luaValue);
    }

    public static FieldExp fieldop(PrimaryExp primaryExp, String str) {
        return new FieldExp(primaryExp, str);
    }

    public static FuncCall functionop(PrimaryExp primaryExp, FuncArgs funcArgs) {
        return new FuncCall(primaryExp, funcArgs);
    }

    public static IndexExp indexop(PrimaryExp primaryExp, Exp exp) {
        return new IndexExp(primaryExp, exp);
    }

    static boolean isrightassoc(int i) {
        switch (i) {
            case 18:
            case 22:
                return true;
            default:
                return false;
        }
    }

    public static MethodCall methodop(PrimaryExp primaryExp, String str, FuncArgs funcArgs) {
        return new MethodCall(primaryExp, str, funcArgs);
    }

    public static NameExp nameprefix(String str) {
        return new NameExp(str);
    }

    public static Exp numberconstant(String str) {
        return new Constant(LuaValue.valueOf(str).tonumber());
    }

    public static ParensExp parensprefix(Exp exp) {
        return new ParensExp(exp);
    }

    static int precedence(int i) {
        switch (i) {
            case 13:
            case 14:
                return 4;
            case 15:
            case 16:
            case 17:
                return 5;
            case 18:
                return 7;
            case 19:
            case 20:
            case 21:
                return 6;
            case 22:
                return 3;
            case 24:
            case 25:
            case 26:
            case 61:
            case 62:
            case 63:
                return 2;
            case 59:
                return 0;
            case 60:
                return 1;
            default:
                throw new IllegalStateException(new StringBuffer().append("precedence of bad op ").append(i).toString());
        }
    }

    public static Exp tableconstructor(TableConstructor tableConstructor) {
        return tableConstructor;
    }

    public static Exp unaryexp(int i, Exp exp) {
        if (exp instanceof BinopExp) {
            BinopExp binopExp = (BinopExp) exp;
            if (precedence(i) > precedence(binopExp.op)) {
                return binaryexp(unaryexp(i, binopExp.lhs), binopExp.op, binopExp.rhs);
            }
        }
        return new UnopExp(i, exp);
    }

    public static Exp varargs() {
        return new VarargsExp();
    }

    public abstract void accept(Visitor visitor);

    public boolean isfunccall() {
        return false;
    }

    public boolean isvarargexp() {
        return false;
    }

    public boolean isvarexp() {
        return false;
    }
}
