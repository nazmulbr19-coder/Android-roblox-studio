package org.luaj.vm2;

import java.lang.ref.WeakReference;
import java.util.Vector;
import kotlin.text.Typography;

/* loaded from: classes10.dex */
public class LuaTable extends LuaValue implements Metatable {
    private static final int MIN_HASH_CAPACITY = 2;
    private static final LuaString N = valueOf("n");
    private static final Slot[] NOBUCKETS = new Slot[0];
    protected LuaValue[] array;
    protected Slot[] hash;
    protected int hashEntries;
    protected Metatable m_metatable;

    /* loaded from: classes10.dex */
    private static class DeadSlot implements Slot {
        private final Object key;
        private Slot next;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.ref.WeakReference] */
        private DeadSlot(LuaValue luaValue, Slot slot) {
            this.key = LuaTable.isLargeKey(luaValue) ? new WeakReference(luaValue) : luaValue;
            this.next = slot;
        }

        /* synthetic */ DeadSlot(LuaValue luaValue, Slot slot, AnonymousClass1 anonymousClass1) {
            this(luaValue, slot);
        }

        private LuaValue key() {
            return (LuaValue) (this.key instanceof WeakReference ? ((WeakReference) this.key).get() : this.key);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot add(Slot slot) {
            return this.next != null ? this.next.add(slot) : slot;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            return -1;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot find(LuaValue luaValue) {
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot first() {
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            LuaValue key = key();
            return key != null && luaValue.raweq(key);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return 0;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot relink(Slot slot) {
            return slot;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot remove(StrongSlot strongSlot) {
            if (key() == null) {
                return this.next;
            }
            this.next = this.next.remove(strongSlot);
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot rest() {
            return this.next;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot set(StrongSlot strongSlot, LuaValue luaValue) {
            Slot slot = this.next != null ? this.next.set(strongSlot, luaValue) : null;
            if (key() == null) {
                return slot;
            }
            this.next = slot;
            return this;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<dead");
            LuaValue key = key();
            if (key != null) {
                stringBuffer.append(": ");
                stringBuffer.append(key.toString());
            }
            stringBuffer.append(Typography.greater);
            if (this.next != null) {
                stringBuffer.append("; ");
                stringBuffer.append(this.next.toString());
            }
            return stringBuffer.toString();
        }
    }

    /* loaded from: classes10.dex */
    static abstract class Entry extends Varargs implements StrongSlot {
        Entry() {
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot add(Slot slot) {
            return new LinkSlot(this, slot);
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            switch (i) {
                case 1:
                    return key();
                case 2:
                    return value();
                default:
                    return LuaValue.NIL;
            }
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return key();
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            return 0;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot find(LuaValue luaValue) {
            if (keyeq(luaValue)) {
                return this;
            }
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot first() {
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public abstract LuaValue key();

        @Override // org.luaj.vm2.LuaTable.Slot
        public abstract boolean keyeq(LuaValue luaValue);

        @Override // org.luaj.vm2.LuaTable.Slot
        public abstract int keyindex(int i);

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return 2;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot relink(Slot slot) {
            return slot != null ? new LinkSlot(this, slot) : this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot remove(StrongSlot strongSlot) {
            return new DeadSlot(key(), null, null);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot rest() {
            return null;
        }

        abstract Entry set(LuaValue luaValue);

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot set(StrongSlot strongSlot, LuaValue luaValue) {
            return set(luaValue);
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            switch (i) {
                case 1:
                    return this;
                case 2:
                    return value();
                default:
                    return LuaValue.NONE;
            }
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public Varargs toVarargs() {
            return LuaValue.varargsOf(key(), value());
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public abstract LuaValue value();
    }

    /* loaded from: classes10.dex */
    private static class IntKeyEntry extends Entry {
        private final int key;
        private LuaValue value;

        IntKeyEntry(int i, LuaValue luaValue) {
            this.key = i;
            this.value = luaValue;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            if (this.key < 1 || this.key > i) {
                return 0;
            }
            return this.key;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue key() {
            return LuaValue.valueOf(this.key);
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            return luaValue.raweq(this.key);
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashmod(LuaInteger.hashCode(this.key), i);
        }

        @Override // org.luaj.vm2.LuaTable.Entry
        public Entry set(LuaValue luaValue) {
            this.value = luaValue;
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue value() {
            return this.value;
        }
    }

    /* loaded from: classes10.dex */
    private static class LinkSlot implements StrongSlot {
        private Entry entry;
        private Slot next;

        LinkSlot(Entry entry, Slot slot) {
            this.entry = entry;
            this.next = slot;
        }

        private Slot setnext(Slot slot) {
            if (slot == null) {
                return this.entry;
            }
            this.next = slot;
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot add(Slot slot) {
            return setnext(this.next.add(slot));
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            return this.entry.arraykey(i);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot find(LuaValue luaValue) {
            if (this.entry.keyeq(luaValue)) {
                return this;
            }
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot first() {
            return this.entry;
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue key() {
            return this.entry.key();
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            return this.entry.keyeq(luaValue);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return this.entry.keyindex(i);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot relink(Slot slot) {
            return slot != null ? new LinkSlot(this.entry, slot) : this.entry;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot remove(StrongSlot strongSlot) {
            if (this == strongSlot) {
                return new DeadSlot(key(), this.next, null);
            }
            this.next = this.next.remove(strongSlot);
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot rest() {
            return this.next;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot set(StrongSlot strongSlot, LuaValue luaValue) {
            if (strongSlot != this) {
                return setnext(this.next.set(strongSlot, luaValue));
            }
            this.entry = this.entry.set(luaValue);
            return this;
        }

        public String toString() {
            return new StringBuffer().append(this.entry).append("; ").append(this.next).toString();
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public Varargs toVarargs() {
            return this.entry.toVarargs();
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue value() {
            return this.entry.value();
        }
    }

    /* loaded from: classes10.dex */
    static class NormalEntry extends Entry {
        private final LuaValue key;
        private LuaValue value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public NormalEntry(LuaValue luaValue, LuaValue luaValue2) {
            this.key = luaValue;
            this.value = luaValue2;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue key() {
            return this.key;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            return luaValue.raweq(this.key);
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashSlot(this.key, i);
        }

        @Override // org.luaj.vm2.LuaTable.Entry
        public Entry set(LuaValue luaValue) {
            this.value = luaValue;
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public Varargs toVarargs() {
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue value() {
            return this.value;
        }
    }

    /* loaded from: classes10.dex */
    private static class NumberValueEntry extends Entry {
        private final LuaValue key;
        private double value;

        NumberValueEntry(LuaValue luaValue, double d) {
            this.key = luaValue;
            this.value = d;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue key() {
            return this.key;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            return luaValue.raweq(this.key);
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashSlot(this.key, i);
        }

        @Override // org.luaj.vm2.LuaTable.Entry
        public Entry set(LuaValue luaValue) {
            LuaValue luaValue2 = luaValue.tonumber();
            if (luaValue2.isnil()) {
                return new NormalEntry(this.key, luaValue);
            }
            this.value = luaValue2.todouble();
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue value() {
            return LuaValue.valueOf(this.value);
        }
    }

    /* loaded from: classes10.dex */
    interface Slot {
        Slot add(Slot slot);

        int arraykey(int i);

        StrongSlot find(LuaValue luaValue);

        StrongSlot first();

        boolean keyeq(LuaValue luaValue);

        int keyindex(int i);

        Slot relink(Slot slot);

        Slot remove(StrongSlot strongSlot);

        Slot rest();

        Slot set(StrongSlot strongSlot, LuaValue luaValue);
    }

    /* loaded from: classes10.dex */
    interface StrongSlot extends Slot {
        LuaValue key();

        Varargs toVarargs();

        LuaValue value();
    }

    public LuaTable() {
        this.array = NOVALS;
        this.hash = NOBUCKETS;
    }

    public LuaTable(int i, int i2) {
        presize(i, i2);
    }

    public LuaTable(Varargs varargs) {
        this(varargs, 1);
    }

    public LuaTable(Varargs varargs, int i) {
        int i2 = i - 1;
        int max = Math.max(varargs.narg() - i2, 0);
        presize(max, 1);
        set(N, valueOf(max));
        for (int i3 = 1; i3 <= max; i3++) {
            set(i3, varargs.arg(i3 + i2));
        }
    }

    public LuaTable(LuaValue[] luaValueArr, LuaValue[] luaValueArr2, Varargs varargs) {
        int length = luaValueArr != null ? luaValueArr.length : 0;
        int length2 = luaValueArr2 != null ? luaValueArr2.length : 0;
        presize((varargs != null ? varargs.narg() : 0) + length2, length >> 1);
        int i = 0;
        while (i < length2) {
            int i2 = i + 1;
            rawset(i2, luaValueArr2[i]);
            i = i2;
        }
        if (varargs != null) {
            int narg = varargs.narg();
            for (int i3 = 1; i3 <= narg; i3++) {
                rawset(length2 + i3, varargs.arg(i3));
            }
        }
        for (int i4 = 0; i4 < length; i4 += 2) {
            int i5 = i4 + 1;
            if (!luaValueArr[i5].isnil()) {
                rawset(luaValueArr[i4], luaValueArr[i5]);
            }
        }
    }

    private boolean arrayset(int i, LuaValue luaValue) {
        if (i <= 0 || i > this.array.length) {
            return false;
        }
        LuaValue[] luaValueArr = this.array;
        int i2 = i - 1;
        if (luaValue.isnil()) {
            luaValue = null;
        } else if (this.m_metatable != null) {
            luaValue = this.m_metatable.wrap(luaValue);
        }
        luaValueArr[i2] = luaValue;
        return true;
    }

    private boolean checkLoadFactor() {
        return this.hashEntries >= this.hash.length;
    }

    private boolean compare(int i, int i2, LuaValue luaValue) {
        LuaValue arrayget;
        LuaValue arrayget2;
        if (this.m_metatable == null) {
            arrayget = this.array[i];
            arrayget2 = this.array[i2];
        } else {
            arrayget = this.m_metatable.arrayget(this.array, i);
            arrayget2 = this.m_metatable.arrayget(this.array, i2);
        }
        if (arrayget == null || arrayget2 == null) {
            return false;
        }
        return !luaValue.isnil() ? luaValue.call(arrayget, arrayget2).toboolean() : arrayget.lt_b(arrayget2);
    }

    private int countHashKeys() {
        int i = 0;
        for (int i2 = 0; i2 < this.hash.length; i2++) {
            for (Slot slot = this.hash[i2]; slot != null; slot = slot.rest()) {
                if (slot.first() != null) {
                    i++;
                }
            }
        }
        return i;
    }

    private int countIntKeys(int[] iArr) {
        int i = 0;
        int i2 = 1;
        for (int i3 = 0; i3 < 31 && i2 <= this.array.length; i3++) {
            int min = Math.min(this.array.length, 1 << i3);
            int i4 = 0;
            while (i2 <= min) {
                int i5 = i2 + 1;
                if (this.array[i2 - 1] != null) {
                    i4++;
                }
                i2 = i5;
            }
            iArr[i3] = i4;
            i += i4;
        }
        for (int i6 = 0; i6 < this.hash.length; i6++) {
            for (Slot slot = this.hash[i6]; slot != null; slot = slot.rest()) {
                int arraykey = slot.arraykey(Integer.MAX_VALUE);
                if (arraykey > 0) {
                    int log2 = log2(arraykey);
                    iArr[log2] = iArr[log2] + 1;
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Entry defaultEntry(LuaValue luaValue, LuaValue luaValue2) {
        return luaValue.isinttype() ? new IntKeyEntry(luaValue.toint(), luaValue2) : luaValue2.type() == 3 ? new NumberValueEntry(luaValue, luaValue2.todouble()) : new NormalEntry(luaValue, luaValue2);
    }

    private void dropWeakArrayValues() {
        for (int i = 0; i < this.array.length; i++) {
            this.m_metatable.arrayget(this.array, i);
        }
    }

    private void hashRemove(LuaValue luaValue) {
        if (this.hash.length > 0) {
            int hashSlot = hashSlot(luaValue);
            for (Slot slot = this.hash[hashSlot]; slot != null; slot = slot.rest()) {
                StrongSlot find = slot.find(luaValue);
                if (find != null) {
                    this.hash[hashSlot] = this.hash[hashSlot].remove(find);
                    this.hashEntries--;
                    return;
                }
            }
        }
    }

    private int hashSlot(LuaValue luaValue) {
        return hashSlot(luaValue, this.hash.length - 1);
    }

    public static int hashSlot(LuaValue luaValue, int i) {
        int type = luaValue.type();
        int hashCode = luaValue.hashCode();
        switch (type) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                return hashmod(hashCode, i);
            case 4:
            case 6:
            default:
                return hashpow2(hashCode, i);
        }
    }

    public static int hashmod(int i, int i2) {
        return (i & Integer.MAX_VALUE) % i2;
    }

    public static int hashpow2(int i, int i2) {
        return i & i2;
    }

    private void heapSort(int i, LuaValue luaValue) {
        heapify(i, luaValue);
        int i2 = i - 1;
        while (i2 > 0) {
            swap(i2, 0);
            i2--;
            siftDown(0, i2, luaValue);
        }
    }

    private void heapify(int i, LuaValue luaValue) {
        for (int i2 = (i / 2) - 1; i2 >= 0; i2--) {
            siftDown(i2, i - 1, luaValue);
        }
    }

    protected static boolean isLargeKey(LuaValue luaValue) {
        switch (luaValue.type()) {
            case 1:
            case 3:
                return false;
            case 2:
            default:
                return true;
            case 4:
                return luaValue.rawlen() > 32;
        }
    }

    static int log2(int i) {
        int i2;
        int i3 = i - 1;
        if (i3 < 0) {
            return Integer.MIN_VALUE;
        }
        if (((-65536) & i3) != 0) {
            i3 >>>= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if ((65280 & i3) != 0) {
            i2 += 8;
            i3 >>>= 8;
        }
        if ((i3 & 240) != 0) {
            i2 += 4;
            i3 >>>= 4;
        }
        switch (i3) {
            case 0:
                return 0;
            case 1:
                return i2 + 1;
            case 2:
            case 3:
                return i2 + 2;
            case 4:
            case 5:
            case 6:
            case 7:
                return i2 + 3;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return i2 + 4;
            default:
                return i2;
        }
    }

    private void rehash(int i) {
        LuaValue[] luaValueArr;
        Slot[] slotArr;
        int i2;
        Slot defaultEntry;
        if (this.m_metatable != null && (this.m_metatable.useWeakKeys() || this.m_metatable.useWeakValues())) {
            this.hashEntries = countHashKeys();
            if (this.m_metatable.useWeakValues()) {
                dropWeakArrayValues();
            }
        }
        int[] iArr = new int[32];
        int countIntKeys = countIntKeys(iArr);
        if (i > 0) {
            countIntKeys++;
            int log2 = log2(i);
            iArr[log2] = iArr[log2] + 1;
        }
        int i3 = iArr[0];
        int i4 = 1;
        int i5 = 0;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            i3 += iArr[i4];
            int i6 = 1 << i4;
            if (countIntKeys * 2 < i6) {
                break;
            }
            if (i3 >= (1 << (i4 - 1))) {
                i5 = i6;
            }
            i4++;
        }
        LuaValue[] luaValueArr2 = this.array;
        Slot[] slotArr2 = this.hash;
        int i7 = (i <= 0 || i > i5) ? 0 : -1;
        if (i5 != luaValueArr2.length) {
            luaValueArr = new LuaValue[i5];
            if (i5 > luaValueArr2.length) {
                int log22 = log2(i5) + 1;
                for (int log23 = log2(luaValueArr2.length + 1); log23 < log22; log23++) {
                    i7 += iArr[log23];
                }
            } else if (luaValueArr2.length > i5) {
                int log24 = log2(luaValueArr2.length) + 1;
                for (int log25 = log2(i5 + 1); log25 < log24; log25++) {
                    i7 -= iArr[log25];
                }
            }
            System.arraycopy(luaValueArr2, 0, luaValueArr, 0, Math.min(luaValueArr2.length, i5));
        } else {
            luaValueArr = this.array;
        }
        int i8 = (this.hashEntries - i7) + ((i < 0 || i > i5) ? 1 : 0);
        if (i8 > 0) {
            int log26 = i8 >= 2 ? 1 << log2(i8) : 2;
            i2 = log26 - 1;
            slotArr = new Slot[log26];
        } else {
            slotArr = NOBUCKETS;
            i2 = 0;
        }
        for (Slot slot : slotArr2) {
            for (; slot != null; slot = slot.rest()) {
                int arraykey = slot.arraykey(i5);
                if (arraykey > 0) {
                    StrongSlot first = slot.first();
                    if (first != null) {
                        luaValueArr[arraykey - 1] = first.value();
                    }
                } else {
                    int keyindex = slot.keyindex(i2);
                    slotArr[keyindex] = slot.relink(slotArr[keyindex]);
                }
            }
        }
        while (i5 < luaValueArr2.length) {
            int i9 = i5 + 1;
            LuaValue luaValue = luaValueArr2[i5];
            if (luaValue != null) {
                int hashmod = hashmod(LuaInteger.hashCode(i9), i2);
                if (this.m_metatable != null) {
                    defaultEntry = this.m_metatable.entry(valueOf(i9), luaValue);
                    if (defaultEntry == null) {
                    }
                } else {
                    defaultEntry = defaultEntry(valueOf(i9), luaValue);
                }
                if (slotArr[hashmod] != null) {
                    defaultEntry = slotArr[hashmod].add(defaultEntry);
                }
                slotArr[hashmod] = defaultEntry;
            }
            i5 = i9;
        }
        this.hash = slotArr;
        this.array = luaValueArr;
        this.hashEntries -= i7;
    }

    private static LuaValue[] resize(LuaValue[] luaValueArr, int i) {
        LuaValue[] luaValueArr2 = new LuaValue[i];
        System.arraycopy(luaValueArr, 0, luaValueArr2, 0, luaValueArr.length);
        return luaValueArr2;
    }

    private void siftDown(int i, int i2, LuaValue luaValue) {
        while (true) {
            int i3 = (i * 2) + 1;
            if (i3 > i2) {
                return;
            }
            if (i3 < i2) {
                int i4 = i3 + 1;
                if (compare(i3, i4, luaValue)) {
                    i3 = i4;
                }
            }
            if (!compare(i, i3, luaValue)) {
                return;
            }
            swap(i, i3);
            i = i3;
        }
    }

    private void swap(int i, int i2) {
        LuaValue luaValue = this.array[i];
        this.array[i] = this.array[i2];
        this.array[i2] = luaValue;
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue arrayget(LuaValue[] luaValueArr, int i) {
        return luaValueArr[i];
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaTable checktable() {
        return this;
    }

    public LuaValue concat(LuaString luaString, int i, int i2) {
        Buffer buffer = new Buffer();
        if (i <= i2) {
            while (true) {
                buffer.append(get(i).checkstring());
                i++;
                if (i > i2) {
                    break;
                }
                buffer.append(luaString);
            }
        }
        return buffer.tostring();
    }

    @Override // org.luaj.vm2.Metatable
    public Slot entry(LuaValue luaValue, LuaValue luaValue2) {
        return defaultEntry(luaValue, luaValue2);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue eq(LuaValue luaValue) {
        return eq_b(luaValue) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean eq_b(LuaValue luaValue) {
        if (this == luaValue) {
            return true;
        }
        if (this.m_metatable == null || !luaValue.istable()) {
            return false;
        }
        LuaValue luaValue2 = luaValue.getmetatable();
        return luaValue2 != null && LuaValue.eqmtcall(this, this.m_metatable.toLuaValue(), luaValue, luaValue2);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue get(int i) {
        LuaValue rawget = rawget(i);
        return (!rawget.isnil() || this.m_metatable == null) ? rawget : gettable(this, valueOf(i));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue get(LuaValue luaValue) {
        LuaValue rawget = rawget(luaValue);
        return (!rawget.isnil() || this.m_metatable == null) ? rawget : gettable(this, luaValue);
    }

    protected int getArrayLength() {
        return this.array.length;
    }

    protected int getHashLength() {
        return this.hash.length;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        if (this.m_metatable != null) {
            return this.m_metatable.toLuaValue();
        }
        return null;
    }

    protected LuaValue hashget(LuaValue luaValue) {
        if (this.hashEntries > 0) {
            for (Slot slot = this.hash[hashSlot(luaValue)]; slot != null; slot = slot.rest()) {
                StrongSlot find = slot.find(luaValue);
                if (find != null) {
                    return find.value();
                }
            }
        }
        return NIL;
    }

    public void hashset(LuaValue luaValue, LuaValue luaValue2) {
        int i;
        if (luaValue2.isnil()) {
            hashRemove(luaValue);
            return;
        }
        if (this.hash.length > 0) {
            i = hashSlot(luaValue);
            for (Slot slot = this.hash[i]; slot != null; slot = slot.rest()) {
                StrongSlot find = slot.find(luaValue);
                if (find != null) {
                    this.hash[i] = this.hash[i].set(find, luaValue2);
                    return;
                }
            }
        } else {
            i = 0;
        }
        if (checkLoadFactor()) {
            if (!luaValue.isinttype() || luaValue.toint() <= 0) {
                rehash(-1);
            } else {
                rehash(luaValue.toint());
                if (arrayset(luaValue.toint(), luaValue2)) {
                    return;
                }
            }
            i = hashSlot(luaValue);
        }
        Slot entry = this.m_metatable != null ? this.m_metatable.entry(luaValue, luaValue2) : defaultEntry(luaValue, luaValue2);
        Slot[] slotArr = this.hash;
        if (this.hash[i] != null) {
            entry = this.hash[i].add(entry);
        }
        slotArr[i] = entry;
        this.hashEntries++;
    }

    @Override // org.luaj.vm2.LuaValue
    public Varargs inext(LuaValue luaValue) {
        int checkint = luaValue.checkint() + 1;
        LuaValue rawget = rawget(checkint);
        return rawget.isnil() ? NONE : varargsOf(LuaInteger.valueOf(checkint), rawget);
    }

    public void insert(int i, LuaValue luaValue) {
        if (i == 0) {
            i = rawlen() + 1;
        }
        while (!luaValue.isnil()) {
            LuaValue rawget = rawget(i);
            rawset(i, luaValue);
            luaValue = rawget;
            i++;
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean istable() {
        return true;
    }

    public int keyCount() {
        LuaValue luaValue = LuaValue.NIL;
        int i = 0;
        while (true) {
            luaValue = next(luaValue).arg1();
            if (luaValue.isnil()) {
                return i;
            }
            i++;
        }
    }

    public LuaValue[] keys() {
        Vector vector = new Vector();
        LuaValue luaValue = LuaValue.NIL;
        while (true) {
            luaValue = next(luaValue).arg1();
            if (luaValue.isnil()) {
                LuaValue[] luaValueArr = new LuaValue[vector.size()];
                vector.copyInto(luaValueArr);
                return luaValueArr;
            }
            vector.addElement(luaValue);
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue len() {
        LuaValue metatag = metatag(LEN);
        return metatag.toboolean() ? metatag.call(this) : LuaInteger.valueOf(rawlen());
    }

    @Override // org.luaj.vm2.LuaValue
    public int length() {
        return this.m_metatable != null ? len().toint() : rawlen();
    }

    @Override // org.luaj.vm2.LuaValue
    public Varargs next(LuaValue luaValue) {
        int i;
        int i2 = 0;
        if (!luaValue.isnil()) {
            if (!luaValue.isinttype() || (i = luaValue.toint()) <= 0 || i > this.array.length) {
                if (this.hash.length == 0) {
                    error("invalid key to 'next'");
                }
                int hashSlot = hashSlot(luaValue);
                for (Slot slot = this.hash[hashSlot]; slot != null; slot = slot.rest()) {
                    if (i2 != 0) {
                        StrongSlot first = slot.first();
                        if (first != null) {
                            return first.toVarargs();
                        }
                    } else if (slot.keyeq(luaValue)) {
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    error("invalid key to 'next'");
                }
                i2 = hashSlot + this.array.length + 1;
            } else {
                i2 = i;
            }
        }
        while (i2 < this.array.length) {
            if (this.array[i2] != null) {
                LuaValue arrayget = this.m_metatable == null ? this.array[i2] : this.m_metatable.arrayget(this.array, i2);
                if (arrayget != null) {
                    return varargsOf(LuaInteger.valueOf(i2 + 1), arrayget);
                }
            }
            i2++;
        }
        for (int length = i2 - this.array.length; length < this.hash.length; length++) {
            for (Slot slot2 = this.hash[length]; slot2 != null; slot2 = slot2.rest()) {
                StrongSlot first2 = slot2.first();
                if (first2 != null) {
                    return first2.toVarargs();
                }
            }
        }
        return NIL;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaTable opttable(LuaTable luaTable) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public void presize(int i) {
        if (i > this.array.length) {
            this.array = resize(this.array, 1 << log2(i));
        }
    }

    public void presize(int i, int i2) {
        if (i2 > 0 && i2 < 2) {
            i2 = 2;
        }
        this.array = i > 0 ? new LuaValue[1 << log2(i)] : NOVALS;
        this.hash = i2 > 0 ? new Slot[1 << log2(i2)] : NOBUCKETS;
        this.hashEntries = 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue rawget(int i) {
        if (i <= 0 || i > this.array.length) {
            return hashget(LuaInteger.valueOf(i));
        }
        LuaValue arrayget = this.m_metatable == null ? this.array[i - 1] : this.m_metatable.arrayget(this.array, i - 1);
        return arrayget == null ? NIL : arrayget;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue rawget(LuaValue luaValue) {
        int i;
        if (!luaValue.isinttype() || (i = luaValue.toint()) <= 0 || i > this.array.length) {
            return hashget(luaValue);
        }
        LuaValue arrayget = this.m_metatable == null ? this.array[i - 1] : this.m_metatable.arrayget(this.array, i - 1);
        return arrayget == null ? NIL : arrayget;
    }

    @Override // org.luaj.vm2.LuaValue
    public int rawlen() {
        int arrayLength = getArrayLength();
        int i = arrayLength + 1;
        int i2 = 0;
        while (!rawget(i).isnil()) {
            i2 = i;
            i = getHashLength() + arrayLength + 1 + i;
        }
        while (i > i2 + 1) {
            int i3 = (i + i2) / 2;
            if (rawget(i3).isnil()) {
                i = i3;
            } else {
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // org.luaj.vm2.LuaValue
    public void rawset(int i, LuaValue luaValue) {
        if (arrayset(i, luaValue)) {
            return;
        }
        hashset(LuaInteger.valueOf(i), luaValue);
    }

    @Override // org.luaj.vm2.LuaValue
    public void rawset(LuaValue luaValue, LuaValue luaValue2) {
        if (luaValue.isinttype() && arrayset(luaValue.toint(), luaValue2)) {
            return;
        }
        hashset(luaValue, luaValue2);
    }

    public LuaValue remove(int i) {
        int rawlen = rawlen();
        if (i == 0) {
            i = rawlen;
        } else if (i > rawlen) {
            return NONE;
        }
        LuaValue rawget = rawget(i);
        LuaValue luaValue = rawget;
        while (!luaValue.isnil()) {
            int i2 = i + 1;
            LuaValue rawget2 = rawget(i2);
            rawset(i, rawget2);
            i = i2;
            luaValue = rawget2;
        }
        return rawget.isnil() ? NONE : rawget;
    }

    @Override // org.luaj.vm2.LuaValue
    public void set(int i, LuaValue luaValue) {
        if (this.m_metatable != null && rawget(i).isnil() && settable(this, LuaInteger.valueOf(i), luaValue)) {
            return;
        }
        rawset(i, luaValue);
    }

    @Override // org.luaj.vm2.LuaValue
    public void set(LuaValue luaValue, LuaValue luaValue2) {
        if (!luaValue.isvalidkey() && !metatag(NEWINDEX).isfunction()) {
            typerror("table index");
        }
        if (this.m_metatable != null && rawget(luaValue).isnil() && settable(this, luaValue, luaValue2)) {
            return;
        }
        rawset(luaValue, luaValue2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r3 != (r4.m_metatable != null && r4.m_metatable.useWeakValues())) goto L27;
     */
    @Override // org.luaj.vm2.LuaValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.luaj.vm2.LuaValue setmetatable(org.luaj.vm2.LuaValue r5) {
        /*
            r4 = this;
            org.luaj.vm2.Metatable r0 = r4.m_metatable
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            org.luaj.vm2.Metatable r0 = r4.m_metatable
            boolean r0 = r0.useWeakKeys()
            if (r0 == 0) goto L10
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            org.luaj.vm2.Metatable r3 = r4.m_metatable
            if (r3 == 0) goto L1f
            org.luaj.vm2.Metatable r3 = r4.m_metatable
            boolean r3 = r3.useWeakValues()
            if (r3 == 0) goto L1f
            r3 = r1
            goto L20
        L1f:
            r3 = r2
        L20:
            org.luaj.vm2.Metatable r5 = metatableOf(r5)
            r4.m_metatable = r5
            org.luaj.vm2.Metatable r5 = r4.m_metatable
            if (r5 == 0) goto L34
            org.luaj.vm2.Metatable r5 = r4.m_metatable
            boolean r5 = r5.useWeakKeys()
            if (r5 == 0) goto L34
            r5 = r1
            goto L35
        L34:
            r5 = r2
        L35:
            if (r0 != r5) goto L46
            org.luaj.vm2.Metatable r5 = r4.m_metatable
            if (r5 == 0) goto L43
            org.luaj.vm2.Metatable r5 = r4.m_metatable
            boolean r5 = r5.useWeakValues()
            if (r5 != 0) goto L44
        L43:
            r1 = r2
        L44:
            if (r3 == r1) goto L49
        L46:
            r4.rehash(r2)
        L49:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.LuaTable.setmetatable(org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
    }

    public void sort(LuaValue luaValue) {
        if (this.m_metatable != null && this.m_metatable.useWeakValues()) {
            dropWeakArrayValues();
        }
        int length = this.array.length;
        while (length > 0 && this.array[length - 1] == null) {
            length--;
        }
        if (length > 1) {
            heapSort(length, luaValue);
        }
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue toLuaValue() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 5;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "table";
    }

    public Varargs unpack() {
        return unpack(1, rawlen());
    }

    public Varargs unpack(int i) {
        return unpack(i, rawlen());
    }

    public Varargs unpack(int i, int i2) {
        int i3 = (i2 + 1) - i;
        switch (i3) {
            case 0:
                break;
            case 1:
                return get(i);
            case 2:
                return varargsOf(get(i), get(i + 1));
            default:
                if (i3 >= 0) {
                    LuaValue[] luaValueArr = new LuaValue[i3];
                    while (true) {
                        i3--;
                        if (i3 < 0) {
                            return varargsOf(luaValueArr);
                        }
                        luaValueArr[i3] = get(i + i3);
                    }
                }
                break;
        }
        return NONE;
    }

    @Override // org.luaj.vm2.Metatable
    public boolean useWeakKeys() {
        return false;
    }

    @Override // org.luaj.vm2.Metatable
    public boolean useWeakValues() {
        return false;
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue wrap(LuaValue luaValue) {
        return luaValue;
    }
}
