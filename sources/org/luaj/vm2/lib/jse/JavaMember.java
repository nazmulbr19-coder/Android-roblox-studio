package org.luaj.vm2.lib.jse;

import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;
import org.luaj.vm2.lib.jse.CoerceLuaToJava;

/* loaded from: classes10.dex */
abstract class JavaMember extends VarArgFunction {
    static final int METHOD_MODIFIERS_VARARGS = 128;
    final CoerceLuaToJava.Coercion[] fixedargs;
    final CoerceLuaToJava.Coercion varargs;

    /* JADX INFO: Access modifiers changed from: protected */
    public JavaMember(Class[] clsArr, int i) {
        boolean z = (i & 128) != 0;
        int length = clsArr.length;
        this.fixedargs = new CoerceLuaToJava.Coercion[z ? length - 1 : length];
        for (int i2 = 0; i2 < this.fixedargs.length; i2++) {
            this.fixedargs[i2] = CoerceLuaToJava.getCoercion(clsArr[i2]);
        }
        this.varargs = z ? CoerceLuaToJava.getCoercion(clsArr[clsArr.length - 1]) : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object[] convertArgs(Varargs varargs) {
        Object[] objArr;
        int i = 0;
        if (this.varargs == null) {
            int length = this.fixedargs.length;
            objArr = new Object[length];
            while (i < length) {
                int i2 = i + 1;
                objArr[i] = this.fixedargs[i].coerce(varargs.arg(i2));
                i = i2;
            }
        } else {
            int max = Math.max(this.fixedargs.length, varargs.narg());
            objArr = new Object[max];
            while (i < this.fixedargs.length) {
                int i3 = i + 1;
                objArr[i] = this.fixedargs[i].coerce(varargs.arg(i3));
                i = i3;
            }
            int length2 = this.fixedargs.length;
            while (length2 < max) {
                int i4 = length2 + 1;
                objArr[length2] = this.varargs.coerce(varargs.arg(i4));
                length2 = i4;
            }
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int score(Varargs varargs) {
        int narg = varargs.narg();
        int i = 0;
        int length = narg > this.fixedargs.length ? CoerceLuaToJava.SCORE_WRONG_TYPE * (narg - this.fixedargs.length) : 0;
        while (i < this.fixedargs.length) {
            CoerceLuaToJava.Coercion coercion = this.fixedargs[i];
            i++;
            length += coercion.score(varargs.arg(i));
        }
        if (this.varargs != null) {
            int length2 = this.fixedargs.length;
            while (length2 < narg) {
                length2++;
                length += this.varargs.score(varargs.arg(length2));
            }
        }
        return length;
    }
}
