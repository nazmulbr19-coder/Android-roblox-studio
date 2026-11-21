package org.luaj.vm2.ast;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.List;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.ast.Exp;
import org.luaj.vm2.ast.Stat;

/* loaded from: classes10.dex */
public class NameResolver extends Visitor {
    private NameScope scope = null;

    private void popScope() {
        this.scope = this.scope.outerScope;
    }

    private void pushScope() {
        this.scope = new NameScope(this.scope);
    }

    protected void defineLocalVar(Name name) {
        name.variable = this.scope.define(name.name);
    }

    protected void defineLocalVars(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            defineLocalVar((Name) list.get(i));
        }
    }

    protected Variable resolveNameReference(Name name) {
        Variable find = this.scope.find(name.name);
        if (find.isLocal() && this.scope.functionNestingCount != find.definingScope.functionNestingCount) {
            find.isupvalue = true;
        }
        return find;
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(Block block) {
        pushScope();
        block.scope = this.scope;
        super.visit(block);
        popScope();
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(Exp.NameExp nameExp) {
        nameExp.name.variable = resolveNameReference(nameExp.name);
        super.visit(nameExp);
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(FuncBody funcBody) {
        pushScope();
        this.scope.functionNestingCount++;
        funcBody.scope = this.scope;
        super.visit(funcBody);
        popScope();
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(NameScope nameScope) {
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(ParList parList) {
        if (parList.names != null) {
            defineLocalVars(parList.names);
        }
        if (parList.isvararg) {
            this.scope.define(AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_ARG);
        }
        super.visit(parList);
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(Stat.Assign assign) {
        super.visit(assign);
        int size = assign.vars.size();
        for (int i = 0; i < size; i++) {
            ((Exp.VarExp) assign.vars.get(i)).markHasAssignment();
        }
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(Stat.FuncDef funcDef) {
        funcDef.name.name.variable = resolveNameReference(funcDef.name.name);
        funcDef.name.name.variable.hasassignments = true;
        super.visit(funcDef);
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(Stat.GenericFor genericFor) {
        pushScope();
        genericFor.scope = this.scope;
        defineLocalVars(genericFor.names);
        super.visit(genericFor);
        popScope();
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(Stat.LocalAssign localAssign) {
        visitExps(localAssign.values);
        defineLocalVars(localAssign.names);
        int size = localAssign.names.size();
        int size2 = localAssign.values != null ? localAssign.values.size() : 0;
        boolean z = size2 > 0 && size2 < size && ((Exp) localAssign.values.get(size2 + (-1))).isvarargexp();
        for (int i = 0; i < size; i++) {
            if (i >= (z ? size2 - 1 : size2)) {
                break;
            }
            if (localAssign.values.get(i) instanceof Exp.Constant) {
                ((Name) localAssign.names.get(i)).variable.initialValue = ((Exp.Constant) localAssign.values.get(i)).value;
            }
        }
        if (z) {
            return;
        }
        while (size2 < size) {
            ((Name) localAssign.names.get(size2)).variable.initialValue = LuaValue.NIL;
            size2++;
        }
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(Stat.LocalFuncDef localFuncDef) {
        defineLocalVar(localFuncDef.name);
        super.visit(localFuncDef);
    }

    @Override // org.luaj.vm2.ast.Visitor
    public void visit(Stat.NumericFor numericFor) {
        pushScope();
        numericFor.scope = this.scope;
        defineLocalVar(numericFor.name);
        super.visit(numericFor);
        popScope();
    }
}
