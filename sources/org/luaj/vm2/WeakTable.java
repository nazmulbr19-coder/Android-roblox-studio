package org.luaj.vm2;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.lang.ref.WeakReference;
import org.luaj.vm2.LuaTable;

/* loaded from: classes10.dex */
public class WeakTable implements Metatable {
    private LuaValue backing;
    private boolean weakkeys;
    private boolean weakvalues;

    /* loaded from: classes10.dex */
    static class WeakKeyAndValueSlot extends WeakSlot {
        private final int keyhash;

        protected WeakKeyAndValueSlot(LuaValue luaValue, LuaValue luaValue2, LuaTable.Slot slot) {
            super(WeakTable.weaken(luaValue), WeakTable.weaken(luaValue2), slot);
            this.keyhash = luaValue.hashCode();
        }

        protected WeakKeyAndValueSlot(WeakKeyAndValueSlot weakKeyAndValueSlot, LuaTable.Slot slot) {
            super(weakKeyAndValueSlot.key, weakKeyAndValueSlot.value, slot);
            this.keyhash = weakKeyAndValueSlot.keyhash;
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        protected WeakSlot copy(LuaTable.Slot slot) {
            return new WeakKeyAndValueSlot(this, slot);
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashmod(this.keyhash, i);
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        public LuaTable.Slot set(LuaValue luaValue) {
            this.value = WeakTable.weaken(luaValue);
            return this;
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        public LuaValue strongkey() {
            return WeakTable.strengthen(this.key);
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        public LuaValue strongvalue() {
            return WeakTable.strengthen(this.value);
        }
    }

    /* loaded from: classes10.dex */
    static class WeakKeySlot extends WeakSlot {
        private final int keyhash;

        protected WeakKeySlot(LuaValue luaValue, LuaValue luaValue2, LuaTable.Slot slot) {
            super(WeakTable.weaken(luaValue), luaValue2, slot);
            this.keyhash = luaValue.hashCode();
        }

        protected WeakKeySlot(WeakKeySlot weakKeySlot, LuaTable.Slot slot) {
            super(weakKeySlot.key, weakKeySlot.value, slot);
            this.keyhash = weakKeySlot.keyhash;
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        protected WeakSlot copy(LuaTable.Slot slot) {
            return new WeakKeySlot(this, slot);
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashmod(this.keyhash, i);
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        public LuaTable.Slot set(LuaValue luaValue) {
            this.value = luaValue;
            return this;
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        public LuaValue strongkey() {
            return WeakTable.strengthen(this.key);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class WeakSlot implements LuaTable.Slot {
        protected Object key;
        protected LuaTable.Slot next;
        protected Object value;

        protected WeakSlot(Object obj, Object obj2, LuaTable.Slot slot) {
            this.key = obj;
            this.value = obj2;
            this.next = slot;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public LuaTable.Slot add(LuaTable.Slot slot) {
            if (this.next != null) {
                slot = this.next.add(slot);
            }
            this.next = slot;
            return (strongkey() == null || strongvalue() == null) ? this.next : this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            return 0;
        }

        protected abstract WeakSlot copy(LuaTable.Slot slot);

        @Override // org.luaj.vm2.LuaTable.Slot
        public LuaTable.StrongSlot find(LuaValue luaValue) {
            LuaTable.StrongSlot first = first();
            if (first != null) {
                return first.find(luaValue);
            }
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public LuaTable.StrongSlot first() {
            LuaValue strongkey = strongkey();
            LuaValue strongvalue = strongvalue();
            if (strongkey != null && strongvalue != null) {
                return new LuaTable.NormalEntry(strongkey, strongvalue);
            }
            this.key = null;
            this.value = null;
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            LuaTable.StrongSlot first = first();
            return first != null && first.keyeq(luaValue);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public abstract int keyindex(int i);

        @Override // org.luaj.vm2.LuaTable.Slot
        public LuaTable.Slot relink(LuaTable.Slot slot) {
            return (strongkey() == null || strongvalue() == null) ? slot : (slot == null && this.next == null) ? this : copy(slot);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public LuaTable.Slot remove(LuaTable.StrongSlot strongSlot) {
            LuaValue strongkey = strongkey();
            if (strongkey == null) {
                return this.next.remove(strongSlot);
            }
            if (strongSlot.keyeq(strongkey)) {
                this.value = null;
                return this;
            }
            this.next = this.next.remove(strongSlot);
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public LuaTable.Slot rest() {
            return this.next;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public LuaTable.Slot set(LuaTable.StrongSlot strongSlot, LuaValue luaValue) {
            LuaValue strongkey = strongkey();
            if (strongkey == null) {
                return this.next.set(strongSlot, luaValue);
            }
            if (strongSlot.find(strongkey) != null) {
                return set(luaValue);
            }
            this.next = this.next.set(strongSlot, luaValue);
            return this;
        }

        public abstract LuaTable.Slot set(LuaValue luaValue);

        public LuaValue strongkey() {
            return (LuaValue) this.key;
        }

        public LuaValue strongvalue() {
            return (LuaValue) this.value;
        }
    }

    /* loaded from: classes10.dex */
    static final class WeakUserdata extends WeakValue {
        private final LuaValue mt;
        private final WeakReference ob;

        private WeakUserdata(LuaValue luaValue) {
            super(luaValue);
            this.ob = new WeakReference(luaValue.touserdata());
            this.mt = luaValue.getmetatable();
        }

        /* synthetic */ WeakUserdata(LuaValue luaValue, AnonymousClass1 anonymousClass1) {
            this(luaValue);
        }

        @Override // org.luaj.vm2.WeakTable.WeakValue, org.luaj.vm2.LuaValue
        public LuaValue strongvalue() {
            Object obj = this.ref.get();
            if (obj != null) {
                return (LuaValue) obj;
            }
            Object obj2 = this.ob.get();
            if (obj2 == null) {
                return null;
            }
            LuaUserdata userdataOf = LuaValue.userdataOf(obj2, this.mt);
            this.ref = new WeakReference(userdataOf);
            return userdataOf;
        }
    }

    /* loaded from: classes10.dex */
    static class WeakValue extends LuaValue {
        WeakReference ref;

        protected WeakValue(LuaValue luaValue) {
            this.ref = new WeakReference(luaValue);
        }

        @Override // org.luaj.vm2.LuaValue
        public boolean raweq(LuaValue luaValue) {
            Object obj = this.ref.get();
            return obj != null && luaValue.raweq((LuaValue) obj);
        }

        @Override // org.luaj.vm2.LuaValue
        public LuaValue strongvalue() {
            return (LuaValue) this.ref.get();
        }

        @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String toString() {
            return new StringBuffer().append("weak<").append(this.ref.get()).append(">").toString();
        }

        @Override // org.luaj.vm2.LuaValue
        public int type() {
            illegal(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "weak value");
            return 0;
        }

        @Override // org.luaj.vm2.LuaValue
        public String typename() {
            illegal("typename", "weak value");
            return null;
        }
    }

    /* loaded from: classes10.dex */
    static class WeakValueSlot extends WeakSlot {
        protected WeakValueSlot(LuaValue luaValue, LuaValue luaValue2, LuaTable.Slot slot) {
            super(luaValue, WeakTable.weaken(luaValue2), slot);
        }

        protected WeakValueSlot(WeakValueSlot weakValueSlot, LuaTable.Slot slot) {
            super(weakValueSlot.key, weakValueSlot.value, slot);
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        protected WeakSlot copy(LuaTable.Slot slot) {
            return new WeakValueSlot(this, slot);
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashSlot(strongkey(), i);
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        public LuaTable.Slot set(LuaValue luaValue) {
            this.value = WeakTable.weaken(luaValue);
            return this;
        }

        @Override // org.luaj.vm2.WeakTable.WeakSlot
        public LuaValue strongvalue() {
            return WeakTable.strengthen(this.value);
        }
    }

    public WeakTable(boolean z, boolean z2, LuaValue luaValue) {
        this.weakkeys = z;
        this.weakvalues = z2;
        this.backing = luaValue;
    }

    public static LuaTable make(boolean z, boolean z2) {
        String str;
        if (z) {
            str = z2 ? "kv" : "k";
        } else {
            if (!z2) {
                return LuaTable.tableOf();
            }
            str = "v";
        }
        LuaString valueOf = LuaString.valueOf(str);
        LuaTable tableOf = LuaTable.tableOf();
        tableOf.setmetatable(LuaTable.tableOf(new LuaValue[]{LuaValue.MODE, valueOf}));
        return tableOf;
    }

    protected static LuaValue strengthen(Object obj) {
        if (obj instanceof WeakReference) {
            obj = ((WeakReference) obj).get();
        }
        return obj instanceof WeakValue ? ((WeakValue) obj).strongvalue() : (LuaValue) obj;
    }

    protected static LuaValue weaken(LuaValue luaValue) {
        switch (luaValue.type()) {
            case 5:
            case 6:
            case 8:
                return new WeakValue(luaValue);
            case 7:
                return new WeakUserdata(luaValue, null);
            default:
                return luaValue;
        }
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue arrayget(LuaValue[] luaValueArr, int i) {
        LuaValue luaValue = luaValueArr[i];
        if (luaValue != null && (luaValue = strengthen(luaValue)) == null) {
            luaValueArr[i] = null;
        }
        return luaValue;
    }

    @Override // org.luaj.vm2.Metatable
    public LuaTable.Slot entry(LuaValue luaValue, LuaValue luaValue2) {
        LuaValue strongvalue = luaValue2.strongvalue();
        if (strongvalue == null) {
            return null;
        }
        return (!this.weakkeys || luaValue.isnumber() || luaValue.isstring() || luaValue.isboolean()) ? (!this.weakvalues || strongvalue.isnumber() || strongvalue.isstring() || strongvalue.isboolean()) ? LuaTable.defaultEntry(luaValue, strongvalue) : new WeakValueSlot(luaValue, strongvalue, null) : (!this.weakvalues || strongvalue.isnumber() || strongvalue.isstring() || strongvalue.isboolean()) ? new WeakKeySlot(luaValue, strongvalue, null) : new WeakKeyAndValueSlot(luaValue, strongvalue, null);
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue toLuaValue() {
        return this.backing;
    }

    @Override // org.luaj.vm2.Metatable
    public boolean useWeakKeys() {
        return this.weakkeys;
    }

    @Override // org.luaj.vm2.Metatable
    public boolean useWeakValues() {
        return this.weakvalues;
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue wrap(LuaValue luaValue) {
        return this.weakvalues ? weaken(luaValue) : luaValue;
    }
}
