package org.luaj.vm2.lib;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.luaj.vm2.Buffer;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.compiler.DumpState;

/* loaded from: classes10.dex */
public class StringLib extends TwoArgFunction {
    private static final int CAP_POSITION = -2;
    private static final int CAP_UNFINISHED = -1;
    private static final String FLAGS = "-+ #0";
    private static final int L_ESC = 37;
    private static final byte MASK_ALPHA = 1;
    private static final byte MASK_CONTROL = 64;
    private static final byte MASK_DIGIT = 8;
    private static final byte MASK_HEXDIGIT = Byte.MIN_VALUE;
    private static final byte MASK_LOWERCASE = 2;
    private static final byte MASK_PUNCT = 16;
    private static final byte MASK_SPACE = 32;
    private static final byte MASK_UPPERCASE = 4;
    private static final int MAX_CAPTURES = 32;
    private static final LuaString SPECIALS = valueOf("^$*+?.([%-");
    private static final byte[] CHAR_TABLE = new byte[256];

    /* loaded from: classes10.dex */
    static class FormatDesc {
        private static final int MAX_FLAGS = 5;
        private boolean alternateForm;
        public final int conversion;
        private boolean explicitPlus;
        private boolean leftAdjust;
        public final int length;
        private int precision;
        private boolean space;
        private int width;
        private boolean zeroPad;

        public FormatDesc(Varargs varargs, LuaString luaString, int i) {
            int length = luaString.length();
            int i2 = 0;
            int i3 = i;
            int i4 = 0;
            boolean z = true;
            while (z) {
                if (i3 < length) {
                    i4 = luaString.luaByte(i3);
                    i3++;
                } else {
                    i4 = 0;
                }
                switch (i4) {
                    case 32:
                        this.space = true;
                        break;
                    case 35:
                        this.alternateForm = true;
                        break;
                    case 43:
                        this.explicitPlus = true;
                        break;
                    case 45:
                        this.leftAdjust = true;
                        break;
                    case 48:
                        this.zeroPad = true;
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            if (i3 - i > 5) {
                LuaValue.error("invalid format (repeated flags)");
            }
            this.width = -1;
            if (Character.isDigit((char) i4)) {
                this.width = i4 - 48;
                if (i3 < length) {
                    i4 = luaString.luaByte(i3);
                    i3++;
                } else {
                    i4 = 0;
                }
                if (Character.isDigit((char) i4)) {
                    this.width = (this.width * 10) + (i4 - 48);
                    if (i3 < length) {
                        i4 = luaString.luaByte(i3);
                        i3++;
                    } else {
                        i4 = 0;
                    }
                }
            }
            this.precision = -1;
            if (i4 == 46) {
                if (i3 < length) {
                    i4 = luaString.luaByte(i3);
                    i3++;
                } else {
                    i4 = 0;
                }
                if (Character.isDigit((char) i4)) {
                    this.precision = i4 - 48;
                    if (i3 < length) {
                        i4 = luaString.luaByte(i3);
                        i3++;
                    } else {
                        i4 = 0;
                    }
                    if (Character.isDigit((char) i4)) {
                        this.precision = (this.precision * 10) + (i4 - 48);
                        if (i3 < length) {
                            i2 = luaString.luaByte(i3);
                            i3++;
                        }
                        i4 = i2;
                    }
                }
            }
            if (Character.isDigit((char) i4)) {
                LuaValue.error("invalid format (width or precision too long)");
            }
            this.zeroPad &= !this.leftAdjust;
            this.conversion = i4;
            this.length = i3 - i;
        }

        static /* synthetic */ int access$200(FormatDesc formatDesc) {
            return formatDesc.precision;
        }

        public static final void pad(Buffer buffer, char c, int i) {
            byte b = (byte) c;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return;
                }
                buffer.append(b);
                i = i2;
            }
        }

        public void format(Buffer buffer, byte b) {
            buffer.append(b);
        }

        public void format(Buffer buffer, double d) {
            buffer.append(String.valueOf(d));
        }

        public void format(Buffer buffer, long j) {
            int i;
            String l;
            int i2;
            if (j == 0 && this.precision == 0) {
                l = "";
            } else {
                switch (this.conversion) {
                    case 88:
                    case 120:
                        i = 16;
                        break;
                    case 111:
                        i = 8;
                        break;
                    default:
                        i = 10;
                        break;
                }
                l = Long.toString(j, i);
                if (this.conversion == 88) {
                    l = l.toUpperCase();
                }
            }
            int length = l.length();
            if (j < 0) {
                i2 = length;
                length--;
            } else {
                i2 = (this.explicitPlus || this.space) ? length + 1 : length;
            }
            int i3 = this.precision > length ? this.precision - length : (this.precision == -1 && this.zeroPad && this.width > i2) ? this.width - i2 : 0;
            int i4 = i2 + i3;
            int i5 = this.width > i4 ? this.width - i4 : 0;
            if (!this.leftAdjust) {
                pad(buffer, ' ', i5);
            }
            if (j < 0) {
                if (i3 > 0) {
                    buffer.append((byte) 45);
                    l = l.substring(1);
                }
            } else if (this.explicitPlus) {
                buffer.append((byte) 43);
            } else if (this.space) {
                buffer.append(StringLib.MASK_SPACE);
            }
            if (i3 > 0) {
                pad(buffer, '0', i3);
            }
            buffer.append(l);
            if (this.leftAdjust) {
                pad(buffer, ' ', i5);
            }
        }

        public void format(Buffer buffer, LuaString luaString) {
            int indexOf = luaString.indexOf((byte) 0, 0);
            if (indexOf != -1) {
                luaString = luaString.substring(0, indexOf);
            }
            buffer.append(luaString);
        }
    }

    /* loaded from: classes10.dex */
    static class GMatchAux extends VarArgFunction {
        private final MatchState ms;
        private int soffset = 0;
        private final int srclen;

        public GMatchAux(Varargs varargs, LuaString luaString, LuaString luaString2) {
            this.srclen = luaString.length();
            this.ms = new MatchState(varargs, luaString, luaString2);
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            while (this.soffset < this.srclen) {
                this.ms.reset();
                int match = this.ms.match(this.soffset, 0);
                if (match >= 0) {
                    int i = this.soffset;
                    this.soffset = match;
                    return this.ms.push_captures(true, i, match);
                }
                this.soffset++;
            }
            return NIL;
        }
    }

    /* loaded from: classes10.dex */
    static class MatchState {
        final Varargs args;
        final LuaString p;
        final LuaString s;
        int level = 0;
        int[] cinit = new int[32];
        int[] clen = new int[32];

        MatchState(Varargs varargs, LuaString luaString, LuaString luaString2) {
            this.s = luaString;
            this.p = luaString2;
            this.args = varargs;
        }

        private void add_s(Buffer buffer, LuaString luaString, int i, int i2) {
            int length = luaString.length();
            int i3 = 0;
            while (i3 < length) {
                byte luaByte = (byte) luaString.luaByte(i3);
                if (luaByte == 37) {
                    i3++;
                    luaByte = (byte) luaString.luaByte(i3);
                    if (Character.isDigit((char) luaByte)) {
                        buffer.append(luaByte == 48 ? this.s.substring(i, i2) : push_onecapture(luaByte - 49, i, i2).strvalue());
                        i3++;
                    }
                }
                buffer.append(luaByte);
                i3++;
            }
        }

        private int capture_to_close() {
            for (int i = this.level - 1; i >= 0; i--) {
                if (this.clen[i] == -1) {
                    return i;
                }
            }
            LuaValue.error("invalid pattern capture");
            return 0;
        }

        private int check_capture(int i) {
            int i2 = i - 49;
            if (i2 < 0 || i2 >= this.level || this.clen[i2] == -1) {
                LuaValue.error("invalid capture index");
            }
            return i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0045, code lost:
        
            if (r0 != r5) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
        
            return r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
        
            if (r4 != false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
        
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        
            if ((r1 & Byte.MIN_VALUE) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x001e, code lost:
        
            if ((r1 & 9) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:
        
            if ((r1 & org.luaj.vm2.lib.StringLib.MASK_UPPERCASE) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0028, code lost:
        
            if ((r1 & org.luaj.vm2.lib.StringLib.MASK_SPACE) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x002d, code lost:
        
            if ((r1 & org.luaj.vm2.lib.StringLib.MASK_PUNCT) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0032, code lost:
        
            if ((r1 & org.luaj.vm2.lib.StringLib.MASK_LOWERCASE) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0037, code lost:
        
            if ((r1 & org.luaj.vm2.lib.StringLib.MASK_DIGIT) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x003c, code lost:
        
            if ((r1 & org.luaj.vm2.lib.StringLib.MASK_CONTROL) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0040, code lost:
        
            if ((r1 & org.luaj.vm2.lib.StringLib.MASK_ALPHA) != 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        
            if (r4 == 0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0044, code lost:
        
            r4 = false;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static boolean match_class(int r4, int r5) {
            /*
                char r0 = (char) r5
                char r0 = java.lang.Character.toLowerCase(r0)
                byte[] r1 = org.luaj.vm2.lib.StringLib.access$300()
                r1 = r1[r4]
                r2 = 0
                r3 = 1
                switch(r0) {
                    case 97: goto L3f;
                    case 99: goto L3a;
                    case 100: goto L35;
                    case 108: goto L30;
                    case 112: goto L2b;
                    case 115: goto L26;
                    case 117: goto L21;
                    case 119: goto L1c;
                    case 120: goto L17;
                    case 122: goto L14;
                    default: goto L10;
                }
            L10:
                if (r5 != r4) goto L4c
                r2 = r3
                goto L4c
            L14:
                if (r4 != 0) goto L44
                goto L42
            L17:
                r1 = r1 & (-128(0xffffffffffffff80, float:NaN))
                if (r1 == 0) goto L44
                goto L42
            L1c:
                r1 = r1 & 9
                if (r1 == 0) goto L44
                goto L42
            L21:
                r1 = r1 & 4
                if (r1 == 0) goto L44
                goto L42
            L26:
                r1 = r1 & 32
                if (r1 == 0) goto L44
                goto L42
            L2b:
                r1 = r1 & 16
                if (r1 == 0) goto L44
                goto L42
            L30:
                r1 = r1 & 2
                if (r1 == 0) goto L44
                goto L42
            L35:
                r1 = r1 & 8
                if (r1 == 0) goto L44
                goto L42
            L3a:
                r1 = r1 & 64
                if (r1 == 0) goto L44
                goto L42
            L3f:
                r1 = r1 & r3
                if (r1 == 0) goto L44
            L42:
                r4 = r3
                goto L45
            L44:
                r4 = r2
            L45:
                if (r0 != r5) goto L49
                r2 = r4
                goto L4c
            L49:
                if (r4 != 0) goto L4c
                r2 = r3
            L4c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.StringLib.MatchState.match_class(int, int):boolean");
        }

        private LuaValue push_onecapture(int i, int i2, int i3) {
            if (i >= this.level) {
                return i == 0 ? this.s.substring(i2, i3) : LuaValue.error("invalid capture index");
            }
            int i4 = this.clen[i];
            if (i4 == -1) {
                return LuaValue.error("unfinished capture");
            }
            if (i4 == -2) {
                return LuaValue.valueOf(this.cinit[i] + 1);
            }
            int i5 = this.cinit[i];
            return this.s.substring(i5, i4 + i5);
        }

        public void add_value(Buffer buffer, int i, int i2, LuaValue luaValue) {
            LuaValue luaValue2;
            switch (luaValue.type()) {
                case 3:
                case 4:
                    add_s(buffer, luaValue.strvalue(), i, i2);
                    return;
                case 5:
                    luaValue2 = luaValue.get(push_onecapture(0, i, i2));
                    break;
                case 6:
                    luaValue2 = luaValue.invoke(push_captures(true, i, i2)).arg1();
                    break;
                default:
                    LuaValue.error("bad argument: string/function/table expected");
                    return;
            }
            if (!luaValue2.toboolean()) {
                luaValue2 = this.s.substring(i, i2);
            } else if (!luaValue2.isstring()) {
                LuaValue.error(new StringBuffer().append("invalid replacement value (a ").append(luaValue2.typename()).append(")").toString());
            }
            buffer.append(luaValue2.strvalue());
        }

        int classend(int i) {
            int i2 = i + 1;
            switch (this.p.luaByte(i)) {
                case 37:
                    if (i2 == this.p.length()) {
                        LuaValue.error("malformed pattern (ends with %)");
                        break;
                    }
                    break;
                case 91:
                    if (this.p.luaByte(i2) == 94) {
                        i2++;
                    }
                    do {
                        if (i2 == this.p.length()) {
                            LuaValue.error("malformed pattern (missing ])");
                        }
                        int i3 = i2 + 1;
                        if (this.p.luaByte(i2) == 37 && i3 != this.p.length()) {
                            i3++;
                        }
                        i2 = i3;
                    } while (this.p.luaByte(i2) != 93);
                    break;
                default:
                    return i2;
            }
            return i2 + 1;
        }

        int end_capture(int i, int i2) {
            int capture_to_close = capture_to_close();
            this.clen[capture_to_close] = i - this.cinit[capture_to_close];
            int match = match(i, i2);
            if (match == -1) {
                this.clen[capture_to_close] = -1;
            }
            return match;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:32:0x00ef. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0011. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0050. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00f5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0106 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x010b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0113 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00bb A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int match(int r7, int r8) {
            /*
                Method dump skipped, instructions count: 330
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.StringLib.MatchState.match(int, int):int");
        }

        int match_capture(int i, int i2) {
            int check_capture = check_capture(i2);
            int i3 = this.clen[check_capture];
            if (this.s.length() - i < i3 || !LuaString.equals(this.s, this.cinit[check_capture], this.s, i, i3)) {
                return -1;
            }
            return i + i3;
        }

        int matchbalance(int i, int i2) {
            int luaByte;
            int length = this.p.length();
            if (i2 == length || i2 + 1 == length) {
                LuaValue.error("unbalanced pattern");
            }
            int length2 = this.s.length();
            if (i >= length2 || this.s.luaByte(i) != (luaByte = this.p.luaByte(i2))) {
                return -1;
            }
            int luaByte2 = this.p.luaByte(i2 + 1);
            int i3 = 1;
            while (true) {
                i++;
                if (i >= length2) {
                    return -1;
                }
                if (this.s.luaByte(i) == luaByte2) {
                    i3--;
                    if (i3 == 0) {
                        return i + 1;
                    }
                } else if (this.s.luaByte(i) == luaByte) {
                    i3++;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        
            if (r4.p.luaByte(r1 - 2) > r5) goto L5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        
            if (r5 > r4.p.luaByte(r1)) goto L5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x005a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0046 -> B:4:0x000f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004e -> B:4:0x000f). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean matchbracketclass(int r5, int r6, int r7) {
            /*
                r4 = this;
                org.luaj.vm2.LuaString r0 = r4.p
                int r1 = r6 + 1
                int r0 = r0.luaByte(r1)
                r2 = 94
                r3 = 1
                if (r0 != r2) goto L11
                r6 = 0
                r0 = r6
            Lf:
                r6 = r1
                goto L12
            L11:
                r0 = r3
            L12:
                int r6 = r6 + r3
                if (r6 >= r7) goto L5a
                org.luaj.vm2.LuaString r1 = r4.p
                int r1 = r1.luaByte(r6)
                r2 = 37
                if (r1 != r2) goto L2e
                int r6 = r6 + 1
                org.luaj.vm2.LuaString r1 = r4.p
                int r1 = r1.luaByte(r6)
                boolean r1 = match_class(r5, r1)
                if (r1 == 0) goto L12
                return r0
            L2e:
                org.luaj.vm2.LuaString r1 = r4.p
                int r2 = r6 + 1
                int r1 = r1.luaByte(r2)
                r2 = 45
                if (r1 != r2) goto L51
                int r1 = r6 + 2
                if (r1 >= r7) goto L51
                org.luaj.vm2.LuaString r6 = r4.p
                int r2 = r1 + (-2)
                int r6 = r6.luaByte(r2)
                if (r6 > r5) goto Lf
                org.luaj.vm2.LuaString r6 = r4.p
                int r6 = r6.luaByte(r1)
                if (r5 > r6) goto Lf
                return r0
            L51:
                org.luaj.vm2.LuaString r1 = r4.p
                int r1 = r1.luaByte(r6)
                if (r1 != r5) goto L12
                return r0
            L5a:
                r0 = r0 ^ r3
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.StringLib.MatchState.matchbracketclass(int, int, int):boolean");
        }

        int max_expand(int i, int i2, int i3) {
            int i4 = 0;
            while (true) {
                int i5 = i + i4;
                if (i5 >= this.s.length() || !singlematch(this.s.luaByte(i5), i2, i3)) {
                    break;
                }
                i4++;
            }
            while (i4 >= 0) {
                int match = match(i + i4, i3 + 1);
                if (match != -1) {
                    return match;
                }
                i4--;
            }
            return -1;
        }

        int min_expand(int i, int i2, int i3) {
            while (true) {
                int match = match(i, i3 + 1);
                if (match != -1) {
                    return match;
                }
                if (i >= this.s.length() || !singlematch(this.s.luaByte(i), i2, i3)) {
                    break;
                }
                i++;
            }
            return -1;
        }

        Varargs push_captures(boolean z, int i, int i2) {
            int i3 = (this.level == 0 && z) ? 1 : this.level;
            switch (i3) {
                case 0:
                    return LuaValue.NONE;
                case 1:
                    return push_onecapture(0, i, i2);
                default:
                    LuaValue[] luaValueArr = new LuaValue[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        luaValueArr[i4] = push_onecapture(i4, i, i2);
                    }
                    return LuaValue.varargsOf(luaValueArr);
            }
        }

        void reset() {
            this.level = 0;
        }

        boolean singlematch(int i, int i2, int i3) {
            switch (this.p.luaByte(i2)) {
                case 37:
                    return match_class(i, this.p.luaByte(i2 + 1));
                case 46:
                    return true;
                case 91:
                    return matchbracketclass(i, i2, i3 - 1);
                default:
                    return this.p.luaByte(i2) == i;
            }
        }

        int start_capture(int i, int i2, int i3) {
            int i4 = this.level;
            if (i4 >= 32) {
                LuaValue.error("too many captures");
            }
            this.cinit[i4] = i;
            this.clen[i4] = i3;
            this.level = i4 + 1;
            int match = match(i, i2);
            if (match == -1) {
                this.level--;
            }
            return match;
        }
    }

    /* loaded from: classes10.dex */
    static final class byte_ extends VarArgFunction {
        byte_() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            int i = checkstring.m_length;
            int access$000 = StringLib.access$000(varargs.optint(2, 1), i);
            int access$0002 = StringLib.access$000(varargs.optint(3, access$000), i);
            if (access$000 <= 0) {
                access$000 = 1;
            }
            if (access$0002 <= i) {
                i = access$0002;
            }
            if (access$000 > i) {
                return NONE;
            }
            int i2 = (i - access$000) + 1;
            if (access$000 + i2 <= i) {
                error("string slice too long");
            }
            LuaValue[] luaValueArr = new LuaValue[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                luaValueArr[i3] = valueOf(checkstring.luaByte((access$000 + i3) - 1));
            }
            return varargsOf(luaValueArr);
        }
    }

    /* loaded from: classes10.dex */
    static final class char_ extends VarArgFunction {
        char_() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            int narg = varargs.narg();
            byte[] bArr = new byte[narg];
            int i = 0;
            int i2 = 1;
            while (i < narg) {
                int checkint = varargs.checkint(i2);
                if (checkint < 0 || checkint >= 256) {
                    argerror(i2, "invalid value");
                }
                bArr[i] = (byte) checkint;
                i++;
                i2++;
            }
            return LuaString.valueUsing(bArr);
        }
    }

    /* loaded from: classes10.dex */
    static final class dump extends OneArgFunction {
        dump() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaFunction checkfunction = luaValue.checkfunction();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DumpState.dump(((LuaClosure) checkfunction).p, byteArrayOutputStream, true);
                return LuaString.valueUsing(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                return error(e.getMessage());
            }
        }
    }

    /* loaded from: classes10.dex */
    static final class find extends VarArgFunction {
        find() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return StringLib.str_find_aux(varargs, true);
        }
    }

    /* loaded from: classes10.dex */
    static final class format extends VarArgFunction {
        format() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            long checklong;
            int i = 1;
            LuaString checkstring = varargs.checkstring(1);
            int length = checkstring.length();
            Buffer buffer = new Buffer(length);
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                int luaByte = checkstring.luaByte(i2);
                switch (luaByte) {
                    case 10:
                        buffer.append("\n");
                        break;
                    case 37:
                        if (i3 < length) {
                            if (checkstring.luaByte(i3) != 37) {
                                i++;
                                FormatDesc formatDesc = new FormatDesc(varargs, checkstring, i3);
                                i3 += formatDesc.length;
                                switch (formatDesc.conversion) {
                                    case 69:
                                    case 71:
                                    case TypedValues.TYPE_TARGET /* 101 */:
                                    case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                                    case 103:
                                        formatDesc.format(buffer, varargs.checkdouble(i));
                                        break;
                                    case 88:
                                    case 111:
                                    case 117:
                                    case 120:
                                        checklong = varargs.checklong(i);
                                        break;
                                    case 99:
                                        formatDesc.format(buffer, (byte) varargs.checkint(i));
                                        break;
                                    case 100:
                                    case 105:
                                        checklong = varargs.checkint(i);
                                        break;
                                    case 113:
                                        StringLib.access$100(buffer, varargs.checkstring(i));
                                        break;
                                    case 115:
                                        LuaString checkstring2 = varargs.checkstring(i);
                                        if (FormatDesc.access$200(formatDesc) == -1 && checkstring2.length() >= 100) {
                                            buffer.append(checkstring2);
                                            break;
                                        } else {
                                            formatDesc.format(buffer, checkstring2);
                                            break;
                                        }
                                    default:
                                        error(new StringBuffer().append("invalid option '%").append((char) formatDesc.conversion).append("' to 'format'").toString());
                                        break;
                                }
                                formatDesc.format(buffer, checklong);
                                break;
                            } else {
                                i2 = i3 + 1;
                                buffer.append((byte) 37);
                                break;
                            }
                        } else {
                            break;
                        }
                    default:
                        buffer.append((byte) luaByte);
                        break;
                }
                i2 = i3;
            }
            return buffer.tostring();
        }
    }

    /* loaded from: classes10.dex */
    static final class gmatch extends VarArgFunction {
        gmatch() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return new GMatchAux(varargs, varargs.checkstring(1), varargs.checkstring(2));
        }
    }

    /* loaded from: classes10.dex */
    static final class gsub extends VarArgFunction {
        gsub() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            int length = checkstring.length();
            LuaString checkstring2 = varargs.checkstring(2);
            LuaValue arg = varargs.arg(3);
            int optint = varargs.optint(4, length + 1);
            int i = 0;
            int i2 = (checkstring2.length() <= 0 || checkstring2.charAt(0) != 94) ? 0 : 1;
            Buffer buffer = new Buffer(length);
            MatchState matchState = new MatchState(varargs, checkstring, checkstring2);
            int i3 = 0;
            while (i < optint) {
                matchState.reset();
                int match = matchState.match(i3, i2);
                if (match != -1) {
                    i++;
                    matchState.add_value(buffer, i3, match, arg);
                }
                if (match == -1 || match <= i3) {
                    if (i3 >= length) {
                        break;
                    }
                    match = i3 + 1;
                    buffer.append((byte) checkstring.luaByte(i3));
                }
                i3 = match;
                if (i2 != 0) {
                    break;
                }
            }
            buffer.append(checkstring.substring(i3, length));
            return varargsOf(buffer.tostring(), valueOf(i));
        }
    }

    /* loaded from: classes10.dex */
    static final class len extends OneArgFunction {
        len() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return luaValue.checkstring().len();
        }
    }

    /* loaded from: classes10.dex */
    static final class lower extends OneArgFunction {
        lower() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.checkjstring().toLowerCase());
        }
    }

    /* loaded from: classes10.dex */
    static final class match extends VarArgFunction {
        match() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return StringLib.str_find_aux(varargs, false);
        }
    }

    /* loaded from: classes10.dex */
    static final class rep extends VarArgFunction {
        rep() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            int length = checkstring.length() * varargs.checkint(2);
            byte[] bArr = new byte[length];
            int length2 = checkstring.length();
            for (int i = 0; i < length; i += length2) {
                checkstring.copyInto(0, bArr, i, length2);
            }
            return LuaString.valueUsing(bArr);
        }
    }

    /* loaded from: classes10.dex */
    static final class reverse extends OneArgFunction {
        reverse() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaString checkstring = luaValue.checkstring();
            int length = checkstring.length();
            byte[] bArr = new byte[length];
            int i = length - 1;
            int i2 = 0;
            while (i2 < length) {
                bArr[i] = (byte) checkstring.luaByte(i2);
                i2++;
                i--;
            }
            return LuaString.valueUsing(bArr);
        }
    }

    /* loaded from: classes10.dex */
    static final class sub extends VarArgFunction {
        sub() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            int length = checkstring.length();
            int access$000 = StringLib.access$000(varargs.checkint(2), length);
            int access$0002 = StringLib.access$000(varargs.optint(3, -1), length);
            if (access$000 < 1) {
                access$000 = 1;
            }
            if (access$0002 <= length) {
                length = access$0002;
            }
            return access$000 <= length ? checkstring.substring(access$000 - 1, length) : EMPTYSTRING;
        }
    }

    /* loaded from: classes10.dex */
    static final class upper extends OneArgFunction {
        upper() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.checkjstring().toUpperCase());
        }
    }

    static {
        for (int i = 0; i < 256; i++) {
            char c = (char) i;
            CHAR_TABLE[i] = (byte) ((Character.isDigit(c) ? 8 : 0) | (Character.isLowerCase(c) ? 2 : 0) | (Character.isUpperCase(c) ? 4 : 0) | ((c < ' ' || c == 127) ? 64 : 0));
            if ((c >= 'a' && c <= 'f') || ((c >= 'A' && c <= 'F') || (c >= '0' && c <= '9'))) {
                byte[] bArr = CHAR_TABLE;
                bArr[i] = (byte) (bArr[i] | Byte.MIN_VALUE);
            }
            if ((c >= '!' && c <= '/') || (c >= ':' && c <= '@')) {
                byte[] bArr2 = CHAR_TABLE;
                bArr2[i] = (byte) (bArr2[i] | MASK_PUNCT);
            }
            if ((CHAR_TABLE[i] & 6) != 0) {
                byte[] bArr3 = CHAR_TABLE;
                bArr3[i] = (byte) (bArr3[i] | MASK_ALPHA);
            }
        }
        CHAR_TABLE[32] = MASK_SPACE;
        byte[] bArr4 = CHAR_TABLE;
        bArr4[13] = (byte) (bArr4[13] | MASK_SPACE);
        byte[] bArr5 = CHAR_TABLE;
        bArr5[10] = (byte) (bArr5[10] | MASK_SPACE);
        byte[] bArr6 = CHAR_TABLE;
        bArr6[9] = (byte) (bArr6[9] | MASK_SPACE);
        byte[] bArr7 = CHAR_TABLE;
        bArr7[12] = (byte) (bArr7[12] | MASK_SPACE);
        byte[] bArr8 = CHAR_TABLE;
        bArr8[12] = (byte) (bArr8[12] | MASK_SPACE);
    }

    static /* synthetic */ int access$000(int i, int i2) {
        return posrelat(i, i2);
    }

    static /* synthetic */ void access$100(Buffer buffer, LuaString luaString) {
        addquoted(buffer, luaString);
    }

    static /* synthetic */ byte[] access$300() {
        return CHAR_TABLE;
    }

    private static void addquoted(Buffer buffer, LuaString luaString) {
        buffer.append((byte) 34);
        int length = luaString.length();
        for (int i = 0; i < length; i++) {
            int luaByte = luaString.luaByte(i);
            switch (luaByte) {
                case 10:
                case 34:
                case 92:
                    buffer.append((byte) 92);
                    break;
                default:
                    if (luaByte <= 31 || luaByte == 127) {
                        buffer.append((byte) 92);
                        int i2 = i + 1;
                        if (i2 == length || luaString.luaByte(i2) < 48 || luaString.luaByte(i2) > 57) {
                            buffer.append(Integer.toString(luaByte));
                            break;
                        } else {
                            buffer.append((byte) 48);
                            buffer.append((byte) ((char) ((luaByte / 10) + 48)));
                            luaByte = (char) ((luaByte % 10) + 48);
                            break;
                        }
                    }
                    break;
            }
            buffer.append((byte) luaByte);
        }
        buffer.append((byte) 34);
    }

    private static int posrelat(int i, int i2) {
        return i < 0 ? i2 + i + 1 : i;
    }

    static Varargs str_find_aux(Varargs varargs, boolean z) {
        LuaString checkstring = varargs.checkstring(1);
        LuaString checkstring2 = varargs.checkstring(2);
        int optint = varargs.optint(3, 1);
        if (optint > 0) {
            optint = Math.min(optint - 1, checkstring.length());
        } else if (optint < 0) {
            optint = Math.max(0, checkstring.length() + optint);
        }
        if (!z || (!varargs.arg(4).toboolean() && checkstring2.indexOfAny(SPECIALS) != -1)) {
            MatchState matchState = new MatchState(varargs, checkstring, checkstring2);
            int i = checkstring2.luaByte(0) == 94 ? 1 : 0;
            int i2 = i;
            while (true) {
                matchState.reset();
                int match2 = matchState.match(optint, i2);
                if (match2 == -1) {
                    int i3 = optint + 1;
                    if (optint >= checkstring.length() || i != 0) {
                        break;
                    }
                    optint = i3;
                } else {
                    return z ? varargsOf(valueOf(optint + 1), valueOf(match2), matchState.push_captures(false, optint, match2)) : matchState.push_captures(true, optint, match2);
                }
            }
        } else {
            int indexOf = checkstring.indexOf(checkstring2, optint);
            if (indexOf != -1) {
                return varargsOf(valueOf(indexOf + 1), valueOf(indexOf + checkstring2.length()));
            }
        }
        return NIL;
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("byte", new byte_());
        luaTable.set("char", new char_());
        luaTable.set("dump", new dump());
        luaTable.set("find", new find());
        luaTable.set("format", new format());
        luaTable.set("gmatch", new gmatch());
        luaTable.set("gsub", new gsub());
        luaTable.set("len", new len());
        luaTable.set("lower", new lower());
        luaTable.set("match", new match());
        luaTable.set("rep", new rep());
        luaTable.set("reverse", new reverse());
        luaTable.set("sub", new sub());
        luaTable.set("upper", new upper());
        LuaTable tableOf = LuaValue.tableOf(new LuaValue[]{INDEX, luaTable});
        luaValue2.set(TypedValues.Custom.S_STRING, luaTable);
        luaValue2.get("package").get("loaded").set(TypedValues.Custom.S_STRING, luaTable);
        if (LuaString.s_metatable == null) {
            LuaString.s_metatable = tableOf;
        }
        return luaTable;
    }
}
