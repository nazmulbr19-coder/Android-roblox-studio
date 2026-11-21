package org.luaj.vm2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import kotlin.UByte;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.luaj.vm2.lib.MathLib;
import org.luaj.vm2.parser.LuaParserConstants;

/* loaded from: classes10.dex */
public class LuaString extends LuaValue {
    static final int RECENT_STRINGS_CACHE_SIZE = 128;
    static final int RECENT_STRINGS_MAX_LENGTH = 32;
    public static LuaValue s_metatable;
    public final byte[] m_bytes;
    private final int m_hashcode;
    public final int m_length;
    public final int m_offset;

    /* loaded from: classes10.dex */
    private static final class RecentShortStrings {
        private static final LuaString[] recent_short_strings = new LuaString[128];

        private RecentShortStrings() {
        }

        static /* synthetic */ LuaString[] access$000() {
            return recent_short_strings;
        }
    }

    private LuaString(byte[] bArr, int i, int i2) {
        this.m_bytes = bArr;
        this.m_offset = i;
        this.m_length = i2;
        this.m_hashcode = hashCode(bArr, i, i2);
    }

    private boolean byteseq(byte[] bArr, int i, int i2) {
        return this.m_length == i2 && equals(this.m_bytes, this.m_offset, bArr, i, i2);
    }

    private double checkarith() {
        double scannumber = scannumber();
        if (Double.isNaN(scannumber)) {
            aritherror();
        }
        return scannumber;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public static String decodeAsUtf8(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i2 + i;
        int i5 = 0;
        int i6 = i;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = i6 + 1;
            switch (bArr[i6] & 224) {
                case 224:
                    i8++;
                case 192:
                    i8++;
                    break;
            }
            i6 = i8;
            i7++;
        }
        char[] cArr = new char[i7];
        while (i < i4) {
            int i9 = i5 + 1;
            int i10 = i + 1;
            int i11 = bArr[i];
            if (i11 < 0 && i10 < i4) {
                if (i11 < -32 || (i3 = i10 + 1) >= i4) {
                    i11 = ((i11 & 63) << 6) | (bArr[i10] & 63);
                    i10++;
                } else {
                    int i12 = ((i11 & 15) << 12) | ((bArr[i10] & 63) << 6);
                    i10 = i3 + 1;
                    i11 = i12 | (bArr[i3] & 63);
                }
            }
            cArr[i5] = (char) i11;
            i5 = i9;
            i = i10;
        }
        return new String(cArr);
    }

    public static int encodeToUtf8(char[] cArr, int i, byte[] bArr, int i2) {
        int i3 = i2;
        for (int i4 = 0; i4 < i; i4++) {
            char c = cArr[i4];
            if (c < 128) {
                bArr[i3] = (byte) c;
                i3++;
            } else if (c < 2048) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) (((c >> 6) & 31) | 192);
                i3 = i5 + 1;
                bArr[i5] = (byte) ((c & '?') | 128);
            } else {
                int i6 = i3 + 1;
                bArr[i3] = (byte) (((c >> '\f') & 15) | 224);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((c >> 6) & 63) | 128);
                bArr[i7] = (byte) ((c & '?') | 128);
                i3 = i7 + 1;
            }
        }
        return i3 - i2;
    }

    public static boolean equals(LuaString luaString, int i, LuaString luaString2, int i2, int i3) {
        return equals(luaString.m_bytes, luaString.m_offset + i, luaString2.m_bytes, luaString2.m_offset + i2, i3);
    }

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length < i + i3 || bArr2.length < i2 + i3) {
            return false;
        }
        while (true) {
            i3--;
            if (i3 < 0) {
                return true;
            }
            int i4 = i + 1;
            int i5 = i2 + 1;
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i = i4;
            i2 = i5;
        }
    }

    public static int hashCode(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 5) + 1;
        int i4 = i2;
        while (i2 >= i3) {
            i4 ^= ((i4 << 5) + (i4 >> 2)) + (bArr[(i + i2) - 1] & 255);
            i2 -= i3;
        }
        return i4;
    }

    public static int lengthAsUtf8(char[] cArr) {
        int length = cArr.length;
        int i = length;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            char c = cArr[length];
            if (c >= 128) {
                i += c >= 2048 ? 2 : 1;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x000e. Please report as an issue. */
    private double scandouble(int i, int i2) {
        int i3 = i + 64;
        if (i2 > i3) {
            i2 = i3;
        }
        for (int i4 = i; i4 < i2; i4++) {
            switch (this.m_bytes[i4]) {
                case 43:
                case 45:
                case 46:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case LuaParserConstants.EXP /* 56 */:
                case LuaParserConstants.HEX /* 57 */:
                case 69:
                case TypedValues.TYPE_TARGET /* 101 */:
                default:
                    return Double.NaN;
            }
        }
        char[] cArr = new char[i2 - i];
        for (int i5 = i; i5 < i2; i5++) {
            cArr[i5 - i] = (char) this.m_bytes[i5];
        }
        try {
            return Double.parseDouble(new String(cArr));
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    private double scanlong(int i, int i2, int i3) {
        boolean z = this.m_bytes[i2] == 45;
        if (z) {
            i2++;
        }
        long j = 0;
        while (i2 < i3) {
            byte b = this.m_bytes[i2];
            byte b2 = 48;
            if (i > 10 && (this.m_bytes[i2] < 48 || this.m_bytes[i2] > 57)) {
                b2 = (this.m_bytes[i2] < 65 || this.m_bytes[i2] > 90) ? (byte) 87 : (byte) 55;
            }
            int i4 = b - b2;
            if (i4 < 0 || i4 >= i) {
                return Double.NaN;
            }
            j = (j * i) + i4;
            if (j < 0) {
                return Double.NaN;
            }
            i2++;
        }
        return z ? -j : j;
    }

    private static LuaString valueFromCopy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i + i3];
        }
        return new LuaString(bArr2, 0, i2);
    }

    public static LuaString valueOf(String str) {
        char[] charArray = str.toCharArray();
        int lengthAsUtf8 = lengthAsUtf8(charArray);
        byte[] bArr = new byte[lengthAsUtf8];
        encodeToUtf8(charArray, charArray.length, bArr, 0);
        return valueUsing(bArr, 0, lengthAsUtf8);
    }

    public static LuaString valueOf(byte[] bArr) {
        return valueOf(bArr, 0, bArr.length);
    }

    public static LuaString valueOf(byte[] bArr, int i, int i2) {
        if (i2 > 32) {
            return valueFromCopy(bArr, i, i2);
        }
        int hashCode = hashCode(bArr, i, i2);
        int i3 = hashCode & WorkQueueKt.MASK;
        LuaString luaString = RecentShortStrings.access$000()[i3];
        if (luaString != null && luaString.m_hashcode == hashCode && luaString.byteseq(bArr, i, i2)) {
            return luaString;
        }
        LuaString valueFromCopy = valueFromCopy(bArr, i, i2);
        RecentShortStrings.access$000()[i3] = valueFromCopy;
        return valueFromCopy;
    }

    public static LuaString valueOf(char[] cArr) {
        return valueOf(cArr, 0, cArr.length);
    }

    public static LuaString valueOf(char[] cArr, int i, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) cArr[i3 + i];
        }
        return valueUsing(bArr, 0, i2);
    }

    public static LuaString valueUsing(byte[] bArr) {
        return valueUsing(bArr, 0, bArr.length);
    }

    public static LuaString valueUsing(byte[] bArr, int i, int i2) {
        if (bArr.length > 32) {
            return new LuaString(bArr, i, i2);
        }
        int hashCode = hashCode(bArr, i, i2);
        int i3 = hashCode & WorkQueueKt.MASK;
        LuaString luaString = RecentShortStrings.access$000()[i3];
        if (luaString != null && luaString.m_hashcode == hashCode && luaString.byteseq(bArr, i, i2)) {
            return luaString;
        }
        LuaString luaString2 = new LuaString(bArr, i, i2);
        RecentShortStrings.access$000()[i3] = luaString2;
        return luaString2;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(double d) {
        return valueOf(checkarith() + d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(int i) {
        return valueOf(checkarith() + i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(ADD, luaValue) : luaValue.add(scannumber);
    }

    public int charAt(int i) {
        if (i < 0 || i >= this.m_length) {
            throw new IndexOutOfBoundsException();
        }
        return luaByte(i);
    }

    @Override // org.luaj.vm2.LuaValue
    public double checkdouble() {
        double scannumber = scannumber();
        if (Double.isNaN(scannumber)) {
            argerror("number");
        }
        return scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public int checkint() {
        return (int) checkdouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger checkinteger() {
        return valueOf(checkint());
    }

    @Override // org.luaj.vm2.LuaValue
    public String checkjstring() {
        return tojstring();
    }

    @Override // org.luaj.vm2.LuaValue
    public long checklong() {
        return (long) checkdouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber checknumber() {
        return valueOf(checkdouble());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber checknumber(String str) {
        double scannumber = scannumber();
        if (Double.isNaN(scannumber)) {
            error(str);
        }
        return valueOf(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString checkstring() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public Buffer concat(Buffer buffer) {
        return buffer.concatTo(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concat(LuaValue luaValue) {
        return luaValue.concatTo(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concatTo(LuaNumber luaNumber) {
        return concatTo(luaNumber.strvalue());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concatTo(LuaString luaString) {
        int i = luaString.m_length + this.m_length;
        byte[] bArr = new byte[i];
        System.arraycopy(luaString.m_bytes, luaString.m_offset, bArr, 0, luaString.m_length);
        System.arraycopy(this.m_bytes, this.m_offset, bArr, luaString.m_length, this.m_length);
        return valueUsing(bArr, 0, i);
    }

    public void copyInto(int i, byte[] bArr, int i2, int i3) {
        System.arraycopy(this.m_bytes, this.m_offset + i, bArr, i2, i3);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(double d) {
        return LuaDouble.ddiv(checkarith(), d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(int i) {
        return LuaDouble.ddiv(checkarith(), i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(DIV, luaValue) : luaValue.divInto(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue divInto(double d) {
        return LuaDouble.ddiv(d, checkarith());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue eq(LuaValue luaValue) {
        return luaValue.raweq(this) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean eq_b(LuaValue luaValue) {
        return luaValue.raweq(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean equals(Object obj) {
        if (obj instanceof LuaString) {
            return raweq((LuaString) obj);
        }
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gt(LuaValue luaValue) {
        return luaValue.strcmp(this) < 0 ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(double d) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(int i) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(LuaValue luaValue) {
        return luaValue.strcmp(this) < 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(LuaValue luaValue) {
        return luaValue.strcmp(this) <= 0 ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(double d) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(int i) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(LuaValue luaValue) {
        return luaValue.strcmp(this) <= 0;
    }

    public int hashCode() {
        return this.m_hashcode;
    }

    public int indexOf(byte b, int i) {
        while (i < this.m_length) {
            if (this.m_bytes[this.m_offset + i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int indexOf(LuaString luaString, int i) {
        int length = luaString.length();
        int i2 = this.m_length - length;
        while (i <= i2) {
            if (equals(this.m_bytes, this.m_offset + i, luaString.m_bytes, luaString.m_offset, length)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int indexOfAny(LuaString luaString) {
        int i = this.m_offset + this.m_length;
        int i2 = luaString.m_offset + luaString.m_length;
        for (int i3 = this.m_offset; i3 < i; i3++) {
            for (int i4 = luaString.m_offset; i4 < i2; i4++) {
                if (this.m_bytes[i3] == luaString.m_bytes[i4]) {
                    return i3 - this.m_offset;
                }
            }
        }
        return -1;
    }

    public boolean isValidUtf8() {
        int i;
        int i2 = this.m_offset;
        int i3 = this.m_offset + this.m_length;
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b = this.m_bytes[i2];
            if (b < 0) {
                if ((b & 224) == 192 && i4 < i3) {
                    int i5 = i4 + 1;
                    if ((this.m_bytes[i4] & 192) == 128) {
                        i2 = i5;
                    } else {
                        i4 = i5;
                    }
                }
                if ((b & 240) != 224 || (i = i4 + 1) >= i3 || (this.m_bytes[i4] & 192) != 128) {
                    return false;
                }
                i4 = i + 1;
                if ((this.m_bytes[i] & 192) != 128) {
                    return false;
                }
            }
            i2 = i4;
        }
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isint() {
        double scannumber = scannumber();
        return !Double.isNaN(scannumber) && ((double) ((int) scannumber)) == scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean islong() {
        double scannumber = scannumber();
        return !Double.isNaN(scannumber) && ((double) ((long) scannumber)) == scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isnumber() {
        return !Double.isNaN(scannumber());
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isstring() {
        return true;
    }

    public int lastIndexOf(LuaString luaString) {
        int length = luaString.length();
        for (int i = this.m_length - length; i >= 0; i--) {
            if (equals(this.m_bytes, this.m_offset + i, luaString.m_bytes, luaString.m_offset, length)) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue len() {
        return LuaInteger.valueOf(this.m_length);
    }

    @Override // org.luaj.vm2.LuaValue
    public int length() {
        return this.m_length;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lt(LuaValue luaValue) {
        return luaValue.strcmp(this) > 0 ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(double d) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(int i) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(LuaValue luaValue) {
        return luaValue.strcmp(this) > 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(LuaValue luaValue) {
        return luaValue.strcmp(this) >= 0 ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(double d) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(int i) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(LuaValue luaValue) {
        return luaValue.strcmp(this) >= 0;
    }

    public int luaByte(int i) {
        return this.m_bytes[this.m_offset + i] & UByte.MAX_VALUE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(double d) {
        return LuaDouble.dmod(checkarith(), d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(int i) {
        return LuaDouble.dmod(checkarith(), i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(MOD, luaValue) : luaValue.modFrom(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue modFrom(double d) {
        return LuaDouble.dmod(d, checkarith());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(double d) {
        return valueOf(checkarith() * d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(int i) {
        return valueOf(checkarith() * i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(MUL, luaValue) : luaValue.mul(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue neg() {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? super.neg() : valueOf(-scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public double optdouble(double d) {
        return checknumber().checkdouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public int optint(int i) {
        return checknumber().checkint();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger optinteger(LuaInteger luaInteger) {
        return checknumber().checkinteger();
    }

    @Override // org.luaj.vm2.LuaValue
    public String optjstring(String str) {
        return tojstring();
    }

    @Override // org.luaj.vm2.LuaValue
    public long optlong(long j) {
        return checknumber().checklong();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber optnumber(LuaNumber luaNumber) {
        return checknumber().checknumber();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString optstring(LuaString luaString) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(double d) {
        return MathLib.dpow(checkarith(), d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(int i) {
        return MathLib.dpow(checkarith(), i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(POW, luaValue) : luaValue.powWith(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(double d) {
        return MathLib.dpow(d, checkarith());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(int i) {
        return MathLib.dpow(i, checkarith());
    }

    public void printToStream(PrintStream printStream) {
        int i = this.m_length;
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print((char) this.m_bytes[this.m_offset + i2]);
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaString luaString) {
        if (this == luaString) {
            return true;
        }
        if (luaString.m_length != this.m_length) {
            return false;
        }
        if (luaString.m_bytes == this.m_bytes && luaString.m_offset == this.m_offset) {
            return true;
        }
        if (luaString.hashCode() != hashCode()) {
            return false;
        }
        for (int i = 0; i < this.m_length; i++) {
            if (luaString.m_bytes[luaString.m_offset + i] != this.m_bytes[this.m_offset + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaValue luaValue) {
        return luaValue.raweq(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public int rawlen() {
        return this.m_length;
    }

    public double scannumber() {
        int i;
        int i2 = this.m_offset;
        int i3 = this.m_offset + this.m_length;
        while (i2 < i3 && this.m_bytes[i2] == 32) {
            i2++;
        }
        while (i2 < i3) {
            if (this.m_bytes[i3 - 1] != 32) {
                if (this.m_bytes[i2] == 48 && (i = i2 + 1) < i3 && (this.m_bytes[i] == 120 || this.m_bytes[i] == 88)) {
                    return scanlong(16, i2 + 2, i3);
                }
                double scanlong = scanlong(10, i2, i3);
                return Double.isNaN(scanlong) ? scandouble(i2, i3) : scanlong;
            }
            i3--;
        }
        return Double.NaN;
    }

    public double scannumber(int i) {
        if (i >= 2 && i <= 36) {
            int i2 = this.m_offset;
            int i3 = this.m_offset + this.m_length;
            while (i2 < i3 && this.m_bytes[i2] == 32) {
                i2++;
            }
            while (i2 < i3) {
                if (this.m_bytes[i3 - 1] != 32) {
                    return scanlong(i, i2, i3);
                }
                i3--;
            }
        }
        return Double.NaN;
    }

    @Override // org.luaj.vm2.LuaValue
    public int strcmp(LuaString luaString) {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i3 < this.m_length && i4 < luaString.m_length; i4++) {
            if (this.m_bytes[this.m_offset + i3] != luaString.m_bytes[luaString.m_offset + i4]) {
                i = this.m_bytes[this.m_offset + i3];
                i2 = luaString.m_bytes[luaString.m_offset + i4];
                break;
            }
            i3++;
        }
        i = this.m_length;
        i2 = luaString.m_length;
        return i - i2;
    }

    @Override // org.luaj.vm2.LuaValue
    public int strcmp(LuaValue luaValue) {
        return -luaValue.strcmp(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString strvalue() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(double d) {
        return valueOf(checkarith() - d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(int i) {
        return valueOf(checkarith() - i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(SUB, luaValue) : luaValue.subFrom(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue subFrom(double d) {
        return valueOf(d - checkarith());
    }

    public LuaString substring(int i, int i2) {
        int i3 = this.m_offset + i;
        int i4 = i2 - i;
        return i4 >= this.m_length / 2 ? valueUsing(this.m_bytes, i3, i4) : valueOf(this.m_bytes, i3, i4);
    }

    public InputStream toInputStream() {
        return new ByteArrayInputStream(this.m_bytes, this.m_offset, this.m_length);
    }

    @Override // org.luaj.vm2.LuaValue
    public byte tobyte() {
        return (byte) toint();
    }

    @Override // org.luaj.vm2.LuaValue
    public char tochar() {
        return (char) toint();
    }

    @Override // org.luaj.vm2.LuaValue
    public double todouble() {
        double scannumber = scannumber();
        if (Double.isNaN(scannumber)) {
            return 0.0d;
        }
        return scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public float tofloat() {
        return (float) todouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public int toint() {
        return (int) tolong();
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return decodeAsUtf8(this.m_bytes, this.m_offset, this.m_length);
    }

    @Override // org.luaj.vm2.LuaValue
    public long tolong() {
        return (long) todouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue tonumber() {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? NIL : valueOf(scannumber);
    }

    public LuaValue tonumber(int i) {
        double scannumber = scannumber(i);
        return Double.isNaN(scannumber) ? NIL : valueOf(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public short toshort() {
        return (short) toint();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue tostring() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 4;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return TypedValues.Custom.S_STRING;
    }

    public void write(DataOutputStream dataOutputStream, int i, int i2) throws IOException {
        dataOutputStream.write(this.m_bytes, this.m_offset + i, i2);
    }
}
