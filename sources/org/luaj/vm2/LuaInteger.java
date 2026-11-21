package org.luaj.vm2;

import androidx.core.view.InputDeviceCompat;
import org.luaj.vm2.lib.MathLib;

/* loaded from: classes10.dex */
public class LuaInteger extends LuaNumber {
    private static final LuaInteger[] intValues = new LuaInteger[512];
    public final int v;

    static {
        for (int i = 0; i < 512; i++) {
            intValues[i] = new LuaInteger(i + InputDeviceCompat.SOURCE_ANY);
        }
    }

    LuaInteger(int i) {
        this.v = i;
    }

    public static int hashCode(int i) {
        return i;
    }

    public static LuaInteger valueOf(int i) {
        return (i > 255 || i < -256) ? new LuaInteger(i) : intValues[i + 256];
    }

    public static LuaNumber valueOf(long j) {
        int i = (int) j;
        return j == ((long) i) ? (i > 255 || i < -256) ? new LuaInteger(i) : intValues[i + 256] : LuaDouble.valueOf(j);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(double d) {
        return LuaDouble.valueOf(d + this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(int i) {
        return valueOf(i + this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(LuaValue luaValue) {
        return luaValue.add(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public double checkdouble() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public int checkint() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger checkinteger() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public String checkjstring() {
        return String.valueOf(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public long checklong() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString checkstring() {
        return valueOf(String.valueOf(this.v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(double d) {
        return LuaDouble.ddiv(this.v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(int i) {
        return LuaDouble.ddiv(this.v, i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(LuaValue luaValue) {
        return luaValue.divInto(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue divInto(double d) {
        return LuaDouble.ddiv(d, this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue eq(LuaValue luaValue) {
        return luaValue.raweq(this.v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean eq_b(LuaValue luaValue) {
        return luaValue.raweq(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean equals(Object obj) {
        return (obj instanceof LuaInteger) && ((LuaInteger) obj).v == this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gt(double d) {
        return ((double) this.v) > d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gt(int i) {
        return this.v > i ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gt(LuaValue luaValue) {
        return luaValue.lt_b(this.v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(double d) {
        return ((double) this.v) > d;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(int i) {
        return this.v > i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(LuaValue luaValue) {
        return luaValue.lt_b(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(double d) {
        return ((double) this.v) >= d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(int i) {
        return this.v >= i ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(LuaValue luaValue) {
        return luaValue.lteq_b(this.v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(double d) {
        return ((double) this.v) >= d;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(int i) {
        return this.v >= i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(LuaValue luaValue) {
        return luaValue.lteq_b(this.v);
    }

    public int hashCode() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isint() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isinttype() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean islong() {
        return true;
    }

    @Override // org.luaj.vm2.LuaNumber, org.luaj.vm2.LuaValue
    public boolean isstring() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lt(double d) {
        return ((double) this.v) < d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lt(int i) {
        return this.v < i ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lt(LuaValue luaValue) {
        return luaValue.gt_b(this.v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(double d) {
        return ((double) this.v) < d;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(int i) {
        return this.v < i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(LuaValue luaValue) {
        return luaValue.gt_b(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(double d) {
        return ((double) this.v) <= d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(int i) {
        return this.v <= i ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(LuaValue luaValue) {
        return luaValue.gteq_b(this.v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(double d) {
        return ((double) this.v) <= d;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(int i) {
        return this.v <= i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(LuaValue luaValue) {
        return luaValue.gteq_b(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(double d) {
        return LuaDouble.dmod(this.v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(int i) {
        return LuaDouble.dmod(this.v, i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(LuaValue luaValue) {
        return luaValue.modFrom(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue modFrom(double d) {
        return LuaDouble.dmod(d, this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(double d) {
        return LuaDouble.valueOf(d * this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(int i) {
        return valueOf(i * this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(LuaValue luaValue) {
        return luaValue.mul(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue neg() {
        return valueOf(-this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public double optdouble(double d) {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public int optint(int i) {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger optinteger(LuaInteger luaInteger) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public String optjstring(String str) {
        return Integer.toString(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public long optlong(long j) {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString optstring(LuaString luaString) {
        return LuaString.valueOf(Integer.toString(this.v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(double d) {
        return MathLib.dpow(this.v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(int i) {
        return MathLib.dpow(this.v, i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(LuaValue luaValue) {
        return luaValue.powWith(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(double d) {
        return MathLib.dpow(d, this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(int i) {
        return MathLib.dpow(i, this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(double d) {
        return ((double) this.v) == d;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(int i) {
        return this.v == i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaValue luaValue) {
        return luaValue.raweq(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public int strcmp(LuaString luaString) {
        typerror("attempt to compare number with string");
        return 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString strvalue() {
        return LuaString.valueOf(Integer.toString(this.v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(double d) {
        return LuaDouble.valueOf(this.v - d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(int i) {
        return LuaDouble.valueOf(this.v - i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(LuaValue luaValue) {
        return luaValue.subFrom(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue subFrom(double d) {
        return LuaDouble.valueOf(d - this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue subFrom(int i) {
        return valueOf(i - this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public byte tobyte() {
        return (byte) this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public char tochar() {
        return (char) this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public double todouble() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public float tofloat() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public int toint() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return Integer.toString(this.v);
    }

    @Override // org.luaj.vm2.LuaValue
    public long tolong() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public short toshort() {
        return (short) this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue tostring() {
        return LuaString.valueOf(Integer.toString(this.v));
    }
}
