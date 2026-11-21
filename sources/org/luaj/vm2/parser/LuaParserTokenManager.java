package org.luaj.vm2.parser;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.io.PrintStream;

/* loaded from: classes10.dex */
public class LuaParserTokenManager implements LuaParserConstants {
    protected char curChar;
    int curLexState;
    public PrintStream debugStream;
    int defaultLexState;
    private StringBuffer image;
    protected SimpleCharStream input_stream;
    private final StringBuffer jjimage;
    private int jjimageLen;
    int jjmatchedKind;
    int jjmatchedPos;
    int jjnewStateCnt;
    int jjround;
    private final int[] jjrounds;
    private final int[] jjstateSet;
    private int lengthOfMatch;
    static final long[] jjbitVec0 = {-2, -1, -1, -1};
    static final long[] jjbitVec2 = {0, 0, -1, -1};
    static final int[] jjnextStates = {62, 63, 65, 32, 49, 50, 51, 36, 37, 38, 26, 27, 29, 22, 36, 37, 38, 46, 36, 47, 37, 38, 49, 50, 51, 59, 49, 60, 50, 51, 20, 25, 23, 24, 33, 34, 39, 40, 45, 52, 53, 58, 0, 1, 3};
    public static final String[] jjstrLiteralImages = {"", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "return", "repeat", "then", "true", "until", "while", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "::", null, null, null, "#", ";", "=", ",", ".", ":", "(", ")", "[", "]", "...", "{", "}", "+", "-", "*", "/", "^", "%", "..", "<", "<=", ">", ">=", "==", "~="};
    public static final String[] lexStateNames = {"DEFAULT", "IN_COMMENT", "IN_LC0", "IN_LC1", "IN_LC2", "IN_LC3", "IN_LCN", "IN_LS0", "IN_LS1", "IN_LS2", "IN_LS3", "IN_LSN"};
    public static final int[] jjnewLexState = {-1, -1, -1, -1, -1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    static final long[] jjtoToken = {6926536226618998785L, 2147483618};
    static final long[] jjtoSkip = {8257598, 0};
    static final long[] jjtoSpecial = {8257536, 0};
    static final long[] jjtoMore = {268566464, 0};

    public LuaParserTokenManager(SimpleCharStream simpleCharStream) {
        this.debugStream = System.out;
        this.jjrounds = new int[66];
        this.jjstateSet = new int[132];
        this.jjimage = new StringBuffer();
        this.image = this.jjimage;
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.input_stream = simpleCharStream;
    }

    public LuaParserTokenManager(SimpleCharStream simpleCharStream, int i) {
        this(simpleCharStream);
        SwitchTo(i);
    }

    private void ReInitRounds() {
        this.jjround = -2147483647;
        int i = 66;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            this.jjrounds[i2] = Integer.MIN_VALUE;
            i = i2;
        }
    }

    private void jjAddStates(int i, int i2) {
        while (true) {
            int[] iArr = this.jjstateSet;
            int i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i3 + 1;
            iArr[i3] = jjnextStates[i];
            int i4 = i + 1;
            if (i == i2) {
                return;
            } else {
                i = i4;
            }
        }
    }

    private static final boolean jjCanMove_0(int i, int i2, int i3, long j, long j2) {
        switch (i) {
            case 0:
                return (jjbitVec2[i3] & j2) != 0;
            default:
                return (jjbitVec0[i2] & j) != 0;
        }
    }

    private void jjCheckNAdd(int i) {
        if (this.jjrounds[i] != this.jjround) {
            int[] iArr = this.jjstateSet;
            int i2 = this.jjnewStateCnt;
            this.jjnewStateCnt = i2 + 1;
            iArr[i2] = i;
            this.jjrounds[i] = this.jjround;
        }
    }

    private void jjCheckNAddStates(int i, int i2) {
        while (true) {
            jjCheckNAdd(jjnextStates[i]);
            int i3 = i + 1;
            if (i == i2) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private void jjCheckNAddTwoStates(int i, int i2) {
        jjCheckNAdd(i);
        jjCheckNAdd(i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01a7, code lost:
    
        if ((r8 & 43980465111040L) != 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01e1, code lost:
    
        if (r6 > 52) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01ed, code lost:
    
        r0 = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01ec, code lost:
    
        r6 = 52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01ea, code lost:
    
        if (r6 > 52) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x022b, code lost:
    
        if ((43980465111040L & r8) != 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if (r6 > 52) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        r0 = 64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        r6 = 52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x03a0, code lost:
    
        if ((r8 & 541165879422L) != 0) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        if (r6 > 52) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0423, code lost:
    
        if ((r8 & 541165879422L) != 0) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x04a5, code lost:
    
        r0 = 9;
        r11 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x04a3, code lost:
    
        if ((r8 & (-268435457)) != 0) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a2, code lost:
    
        if ((r8 & 287948901175001088L) != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f8, code lost:
    
        if ((r8 & (-549755813889L)) != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0101, code lost:
    
        if (r31.curChar == '\'') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0124, code lost:
    
        if ((r8 & 287948901175001088L) != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0166, code lost:
    
        if (r6 > 61) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0176, code lost:
    
        if ((r8 & (-17179869185L)) != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0188, code lost:
    
        if (r31.curChar == '\"') goto L131;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:220:0x0398. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0041. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int jjMoveNfa_0(int r32, int r33) {
        /*
            Method dump skipped, instructions count: 1866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.parser.LuaParserTokenManager.jjMoveNfa_0(int, int):int");
    }

    private int jjMoveNfa_1(int i, int i2) {
        this.jjnewStateCnt = 4;
        this.jjstateSet[0] = i;
        int i3 = 1;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = i2;
        while (true) {
            int i7 = this.jjround + 1;
            this.jjround = i7;
            if (i7 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar >= '@') {
                if (this.curChar >= 128) {
                    int i8 = this.curChar >> '\b';
                    int i9 = i8 >> 6;
                    long j = 1 << (i8 & 63);
                    int i10 = (this.curChar & 255) >> 6;
                    long j2 = 1 << (this.curChar & '?');
                    do {
                        i3--;
                        switch (this.jjstateSet[i3]) {
                            case 0:
                            case 4:
                                if (!jjCanMove_0(i8, i9, i10, j, j2)) {
                                    break;
                                } else {
                                    if (i5 > 17) {
                                        i5 = 17;
                                    }
                                    jjCheckNAddStates(42, 44);
                                    break;
                                }
                        }
                    } while (i3 != i4);
                } else {
                    char c = this.curChar;
                    do {
                        i3--;
                        switch (this.jjstateSet[i3]) {
                            case 0:
                            case 4:
                                jjCheckNAddStates(42, 44);
                                i5 = 17;
                                break;
                        }
                    } while (i3 != i4);
                }
            } else {
                long j3 = 1 << this.curChar;
                do {
                    i3--;
                    switch (this.jjstateSet[i3]) {
                        case 0:
                            if ((j3 & (-9217)) == 0) {
                                break;
                            } else {
                                jjCheckNAddStates(42, 44);
                                break;
                            }
                        case 1:
                            if ((9216 & j3) != 0) {
                                if (i5 <= 17) {
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case 2:
                            if (this.curChar == '\n') {
                                if (i5 <= 17) {
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case 3:
                            if (this.curChar != '\r') {
                                break;
                            } else {
                                int[] iArr = this.jjstateSet;
                                int i11 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i11 + 1;
                                iArr[i11] = 2;
                                break;
                            }
                        case 4:
                            if ((j3 & (-9217)) != 0) {
                                if (i5 > 17) {
                                    i5 = 17;
                                }
                                jjCheckNAddStates(42, 44);
                            } else if ((9216 & j3) != 0 && i5 > 17) {
                                i5 = 17;
                            }
                            if (this.curChar != '\r') {
                                break;
                            } else {
                                int[] iArr2 = this.jjstateSet;
                                int i12 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i12 + 1;
                                iArr2[i12] = 2;
                                break;
                            }
                    }
                    i5 = 17;
                } while (i3 != i4);
            }
            if (i5 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i5;
                this.jjmatchedPos = i6;
                i5 = Integer.MAX_VALUE;
            }
            i6++;
            i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i4;
            i4 = 4 - i4;
            if (i3 == i4) {
                return i6;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e) {
                return i6;
            }
        }
    }

    private int jjMoveNfa_11(int i, int i2) {
        this.jjnewStateCnt = 7;
        this.jjstateSet[0] = i;
        int i3 = 1;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        while (true) {
            int i6 = this.jjround + 1;
            this.jjround = i6;
            if (i6 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                char c = this.curChar;
                do {
                    i3--;
                    switch (this.jjstateSet[i3]) {
                        case 0:
                        case 1:
                            if (this.curChar != '=') {
                                break;
                            } else {
                                jjCheckNAddTwoStates(1, 2);
                                break;
                            }
                        case 3:
                            if (this.curChar != '=') {
                                break;
                            } else {
                                int[] iArr = this.jjstateSet;
                                int i7 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i7 + 1;
                                iArr[i7] = 0;
                                break;
                            }
                        case 4:
                            if (this.curChar != '=') {
                                break;
                            } else {
                                int[] iArr2 = this.jjstateSet;
                                int i8 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i8 + 1;
                                iArr2[i8] = 3;
                                break;
                            }
                        case 5:
                            if (this.curChar != '=') {
                                break;
                            } else {
                                int[] iArr3 = this.jjstateSet;
                                int i9 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i9 + 1;
                                iArr3[i9] = 4;
                                break;
                            }
                    }
                } while (i3 != i5);
            } else if (this.curChar < 128) {
                char c2 = this.curChar;
                do {
                    i3--;
                    switch (this.jjstateSet[i3]) {
                        case 2:
                            if (this.curChar == ']' && i4 > 27) {
                                i4 = 27;
                                break;
                            }
                            break;
                        case 6:
                            if (this.curChar != ']') {
                                break;
                            } else {
                                int[] iArr4 = this.jjstateSet;
                                int i10 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i10 + 1;
                                iArr4[i10] = 5;
                                break;
                            }
                    }
                } while (i3 != i5);
            } else {
                char c3 = this.curChar;
                char c4 = this.curChar;
                char c5 = this.curChar;
                do {
                    i3--;
                    int i11 = this.jjstateSet[i3];
                } while (i3 != i5);
            }
            if (i4 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i4;
                this.jjmatchedPos = i2;
                i4 = Integer.MAX_VALUE;
            }
            i2++;
            i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i5;
            i5 = 7 - i5;
            if (i3 == i5) {
                return i2;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e) {
                return i2;
            }
        }
    }

    private int jjMoveNfa_6(int i, int i2) {
        this.jjnewStateCnt = 7;
        this.jjstateSet[0] = i;
        int i3 = 1;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        while (true) {
            int i6 = this.jjround + 1;
            this.jjround = i6;
            if (i6 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                char c = this.curChar;
                do {
                    i3--;
                    switch (this.jjstateSet[i3]) {
                        case 0:
                        case 1:
                            if (this.curChar != '=') {
                                break;
                            } else {
                                jjCheckNAddTwoStates(1, 2);
                                break;
                            }
                        case 3:
                            if (this.curChar != '=') {
                                break;
                            } else {
                                int[] iArr = this.jjstateSet;
                                int i7 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i7 + 1;
                                iArr[i7] = 0;
                                break;
                            }
                        case 4:
                            if (this.curChar != '=') {
                                break;
                            } else {
                                int[] iArr2 = this.jjstateSet;
                                int i8 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i8 + 1;
                                iArr2[i8] = 3;
                                break;
                            }
                        case 5:
                            if (this.curChar != '=') {
                                break;
                            } else {
                                int[] iArr3 = this.jjstateSet;
                                int i9 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i9 + 1;
                                iArr3[i9] = 4;
                                break;
                            }
                    }
                } while (i3 != i5);
            } else if (this.curChar < 128) {
                char c2 = this.curChar;
                do {
                    i3--;
                    switch (this.jjstateSet[i3]) {
                        case 2:
                            if (this.curChar == ']' && i4 > 22) {
                                i4 = 22;
                                break;
                            }
                            break;
                        case 6:
                            if (this.curChar != ']') {
                                break;
                            } else {
                                int[] iArr4 = this.jjstateSet;
                                int i10 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i10 + 1;
                                iArr4[i10] = 5;
                                break;
                            }
                    }
                } while (i3 != i5);
            } else {
                char c3 = this.curChar;
                char c4 = this.curChar;
                char c5 = this.curChar;
                do {
                    i3--;
                    int i11 = this.jjstateSet[i3];
                } while (i3 != i5);
            }
            if (i4 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i4;
                this.jjmatchedPos = i2;
                i4 = Integer.MAX_VALUE;
            }
            i2++;
            i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i5;
            i5 = 7 - i5;
            if (i3 == i5) {
                return i2;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e) {
                return i2;
            }
        }
    }

    private int jjMoveStringLiteralDfa0_0() {
        switch (this.curChar) {
            case '#':
                return jjStopAtPos(0, 69);
            case '%':
                return jjStopAtPos(0, 87);
            case '(':
                return jjStopAtPos(0, 75);
            case ')':
                return jjStopAtPos(0, 76);
            case '*':
                return jjStopAtPos(0, 84);
            case '+':
                return jjStopAtPos(0, 82);
            case ',':
                return jjStopAtPos(0, 72);
            case '-':
                this.jjmatchedKind = 83;
                return jjMoveStringLiteralDfa1_0(66496L, 0L);
            case '.':
                this.jjmatchedKind = 73;
                return jjMoveStringLiteralDfa1_0(0L, 16809984L);
            case '/':
                return jjStopAtPos(0, 85);
            case LuaParserConstants.HEXNUM /* 58 */:
                this.jjmatchedKind = 74;
                return jjMoveStringLiteralDfa1_0(0L, 2L);
            case ';':
                return jjStopAtPos(0, 70);
            case '<':
                this.jjmatchedKind = 89;
                return jjMoveStringLiteralDfa1_0(0L, 67108864L);
            case '=':
                this.jjmatchedKind = 71;
                return jjMoveStringLiteralDfa1_0(0L, 536870912L);
            case '>':
                this.jjmatchedKind = 91;
                return jjMoveStringLiteralDfa1_0(0L, 268435456L);
            case '[':
                this.jjmatchedKind = 77;
                return jjMoveStringLiteralDfa1_0(30720L, 0L);
            case ']':
                return jjStopAtPos(0, 78);
            case '^':
                return jjStopAtPos(0, 86);
            case 'a':
                return jjMoveStringLiteralDfa1_0(536870912L, 0L);
            case 'b':
                return jjMoveStringLiteralDfa1_0(1073741824L, 0L);
            case 'd':
                return jjMoveStringLiteralDfa1_0(2147483648L, 0L);
            case TypedValues.TYPE_TARGET /* 101 */:
                return jjMoveStringLiteralDfa1_0(30064771072L, 0L);
            case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                return jjMoveStringLiteralDfa1_0(240518168576L, 0L);
            case 'g':
                return jjMoveStringLiteralDfa1_0(274877906944L, 0L);
            case 'i':
                return jjMoveStringLiteralDfa1_0(1649267441664L, 0L);
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                return jjMoveStringLiteralDfa1_0(2199023255552L, 0L);
            case 'n':
                return jjMoveStringLiteralDfa1_0(13194139533312L, 0L);
            case 'o':
                return jjMoveStringLiteralDfa1_0(17592186044416L, 0L);
            case 'r':
                return jjMoveStringLiteralDfa1_0(105553116266496L, 0L);
            case 't':
                return jjMoveStringLiteralDfa1_0(422212465065984L, 0L);
            case 'u':
                return jjMoveStringLiteralDfa1_0(562949953421312L, 0L);
            case 'w':
                return jjMoveStringLiteralDfa1_0(1125899906842624L, 0L);
            case '{':
                return jjStopAtPos(0, 80);
            case '}':
                return jjStopAtPos(0, 81);
            case '~':
                return jjMoveStringLiteralDfa1_0(0L, 1073741824L);
            default:
                return jjMoveNfa_0(8, 0);
        }
    }

    private int jjMoveStringLiteralDfa0_1() {
        return jjMoveNfa_1(4, 0);
    }

    private int jjMoveStringLiteralDfa0_10() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_10(67108864L);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa0_11() {
        return jjMoveNfa_11(6, 0);
    }

    private int jjMoveStringLiteralDfa0_2() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_2(262144L);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa0_3() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_3(524288L);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa0_4() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_4(1048576L);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa0_5() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_5(2097152L);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa0_6() {
        return jjMoveNfa_6(6, 0);
    }

    private int jjMoveStringLiteralDfa0_7() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_7(8388608L);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa0_8() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_8(16777216L);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa0_9() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_9(33554432L);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_0(long j, long j2) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '-':
                    if ((65536 & j) != 0) {
                        this.jjmatchedKind = 16;
                        this.jjmatchedPos = 1;
                    }
                    return jjMoveStringLiteralDfa2_0(j, 960L, j2, 0L);
                case '.':
                    if ((16777216 & j2) != 0) {
                        this.jjmatchedKind = 88;
                        this.jjmatchedPos = 1;
                    }
                    return jjMoveStringLiteralDfa2_0(j, 0L, j2, 32768L);
                case LuaParserConstants.HEXNUM /* 58 */:
                    if ((2 & j2) != 0) {
                        return jjStopAtPos(1, 65);
                    }
                    break;
                case '=':
                    return (67108864 & j2) != 0 ? jjStopAtPos(1, 90) : (268435456 & j2) != 0 ? jjStopAtPos(1, 92) : (536870912 & j2) != 0 ? jjStopAtPos(1, 93) : (1073741824 & j2) != 0 ? jjStopAtPos(1, 94) : jjMoveStringLiteralDfa2_0(j, 28672L, j2, 0L);
                case '[':
                    if ((2048 & j) != 0) {
                        return jjStopAtPos(1, 11);
                    }
                    break;
                case 'a':
                    return jjMoveStringLiteralDfa2_0(j, 34359738368L, j2, 0L);
                case TypedValues.TYPE_TARGET /* 101 */:
                    return jjMoveStringLiteralDfa2_0(j, 105553116266496L, j2, 0L);
                case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                    if ((549755813888L & j) != 0) {
                        return jjStartNfaWithStates_0(1, 39, 17);
                    }
                    break;
                case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                    return jjMoveStringLiteralDfa2_0(j, 1266637395197952L, j2, 0L);
                case 'i':
                    return jjMoveStringLiteralDfa2_0(j, 4398046511104L, j2, 0L);
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                    return jjMoveStringLiteralDfa2_0(j, 12884901888L, j2, 0L);
                case 'n':
                    return (1099511627776L & j) != 0 ? jjStartNfaWithStates_0(1, 40, 17) : jjMoveStringLiteralDfa2_0(j, 562967670161408L, j2, 0L);
                case 'o':
                    return (2147483648L & j) != 0 ? jjStartNfaWithStates_0(1, 31, 17) : jjMoveStringLiteralDfa2_0(j, 11338713661440L, j2, 0L);
                case 'r':
                    return (17592186044416L & j) != 0 ? jjStartNfaWithStates_0(1, 44, 17) : jjMoveStringLiteralDfa2_0(j, 281476050452480L, j2, 0L);
                case 'u':
                    return jjMoveStringLiteralDfa2_0(j, 137438953472L, j2, 0L);
            }
            return jjStartNfa_0(0, j, j2);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(0, j, j2);
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_10(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_10(j, 67108864L);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_2(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j & 262144) != 0) {
                        return jjStopAtPos(1, 18);
                    }
                    return 2;
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_3(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_3(j, 524288L);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_4(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_4(j, 1048576L);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_5(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_5(j, 2097152L);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_7(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j & 8388608) != 0) {
                        return jjStopAtPos(1, 23);
                    }
                    return 2;
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_8(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_8(j, 16777216L);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_9(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_9(j, 33554432L);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa2_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(0, j, j3);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '.':
                    if ((32768 & j6) != 0) {
                        return jjStopAtPos(2, 79);
                    }
                    break;
                case '=':
                    return jjMoveStringLiteralDfa3_0(j5, 24576L, j6, 0L);
                case '[':
                    return (4096 & j5) != 0 ? jjStopAtPos(2, 12) : jjMoveStringLiteralDfa3_0(j5, 960L, j6, 0L);
                case 'c':
                    return jjMoveStringLiteralDfa3_0(j5, 2199023255552L, j6, 0L);
                case 'd':
                    if ((536870912 & j5) != 0) {
                        return jjStartNfaWithStates_0(2, 29, 17);
                    }
                    if ((17179869184L & j5) != 0) {
                        return jjStartNfaWithStates_0(2, 34, 17);
                    }
                    break;
                case TypedValues.TYPE_TARGET /* 101 */:
                    return jjMoveStringLiteralDfa3_0(j5, 140738562097152L, j6, 0L);
                case 'i':
                    return jjMoveStringLiteralDfa3_0(j5, 1125899906842624L, j6, 0L);
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                    return (4398046511104L & j5) != 0 ? jjStartNfaWithStates_0(2, 42, 17) : jjMoveStringLiteralDfa3_0(j5, 34359738368L, j6, 0L);
                case 'n':
                    return jjMoveStringLiteralDfa3_0(j5, 137438953472L, j6, 0L);
                case 'p':
                    return jjMoveStringLiteralDfa3_0(j5, 70368744177664L, j6, 0L);
                case 'r':
                    if ((68719476736L & j5) != 0) {
                        return jjStartNfaWithStates_0(2, 36, 17);
                    }
                    break;
                case 's':
                    return jjMoveStringLiteralDfa3_0(j5, 12884901888L, j6, 0L);
                case 't':
                    return (8796093022208L & j5) != 0 ? jjStartNfaWithStates_0(2, 43, 17) : jjMoveStringLiteralDfa3_0(j5, 598409203417088L, j6, 0L);
                case 'u':
                    return jjMoveStringLiteralDfa3_0(j5, 281474976710656L, j6, 0L);
            }
            return jjStartNfa_0(1, j5, j6);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(1, j5, j6);
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa2_10(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa3_10(j3, 67108864L);
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa2_3(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 524288) != 0) {
                        return jjStopAtPos(2, 19);
                    }
                    return 3;
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa2_4(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa3_4(j3, 1048576L);
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa2_5(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa3_5(j3, 2097152L);
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa2_8(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 16777216) != 0) {
                        return jjStopAtPos(2, 24);
                    }
                    return 3;
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa2_9(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa3_9(j3, 33554432L);
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa3_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        if (((j4 & j3) | j5) == 0) {
            return jjStartNfa_0(1, j, j3);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa4_0(j5, 17280L);
                case '[':
                    if ((64 & j5) != 0) {
                        return jjStopAtPos(3, 6);
                    }
                    if ((8192 & j5) != 0) {
                        return jjStopAtPos(3, 13);
                    }
                    break;
                case 'a':
                    return jjMoveStringLiteralDfa4_0(j5, 2200096997376L);
                case 'c':
                    return jjMoveStringLiteralDfa4_0(j5, 137438953472L);
                case TypedValues.TYPE_TARGET /* 101 */:
                    if ((4294967296L & j5) != 0) {
                        this.jjmatchedKind = 32;
                        this.jjmatchedPos = 3;
                    } else if ((281474976710656L & j5) != 0) {
                        return jjStartNfaWithStates_0(3, 48, 17);
                    }
                    return jjMoveStringLiteralDfa4_0(j5, 70377334112256L);
                case 'i':
                    return jjMoveStringLiteralDfa4_0(j5, 562949953421312L);
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                    return jjMoveStringLiteralDfa4_0(j5, 1125899906842624L);
                case 'n':
                    if ((140737488355328L & j5) != 0) {
                        return jjStartNfaWithStates_0(3, 47, 17);
                    }
                    break;
                case 'o':
                    if ((274877906944L & j5) != 0) {
                        return jjStartNfaWithStates_0(3, 38, 17);
                    }
                    break;
                case 's':
                    return jjMoveStringLiteralDfa4_0(j5, 34359738368L);
                case 'u':
                    return jjMoveStringLiteralDfa4_0(j5, 35184372088832L);
            }
            return jjStartNfa_0(2, j5, 0L);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(2, j5, 0L);
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa3_10(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 3;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa4_10(j3, 67108864L);
                default:
                    return 4;
            }
        } catch (IOException e) {
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa3_4(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 3;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 1048576) != 0) {
                        return jjStopAtPos(3, 20);
                    }
                    return 4;
                default:
                    return 4;
            }
        } catch (IOException e) {
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa3_5(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 3;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa4_5(j3, 2097152L);
                default:
                    return 4;
            }
        } catch (IOException e) {
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa3_9(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 3;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 33554432) != 0) {
                        return jjStopAtPos(3, 25);
                    }
                    return 4;
                default:
                    return 4;
            }
        } catch (IOException e) {
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa4_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(2, j, 0L);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa5_0(j3, 768L);
                case '[':
                    if ((128 & j3) != 0) {
                        return jjStopAtPos(4, 7);
                    }
                    if ((16384 & j3) != 0) {
                        return jjStopAtPos(4, 14);
                    }
                    break;
                case 'a':
                    return jjMoveStringLiteralDfa5_0(j3, 70368744177664L);
                case TypedValues.TYPE_TARGET /* 101 */:
                    if ((34359738368L & j3) != 0) {
                        return jjStartNfaWithStates_0(4, 35, 17);
                    }
                    if ((1125899906842624L & j3) != 0) {
                        return jjStartNfaWithStates_0(4, 50, 17);
                    }
                    break;
                case 'i':
                    return jjMoveStringLiteralDfa5_0(j3, 8589934592L);
                case 'k':
                    if ((1073741824 & j3) != 0) {
                        return jjStartNfaWithStates_0(4, 30, 17);
                    }
                    break;
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                    if ((2199023255552L & j3) != 0) {
                        return jjStartNfaWithStates_0(4, 41, 17);
                    }
                    if ((562949953421312L & j3) != 0) {
                        return jjStartNfaWithStates_0(4, 49, 17);
                    }
                    break;
                case 'r':
                    return jjMoveStringLiteralDfa5_0(j3, 35184372088832L);
                case 't':
                    return jjMoveStringLiteralDfa5_0(j3, 137438953472L);
            }
            return jjStartNfa_0(3, j3, 0L);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(3, j3, 0L);
            return 4;
        }
    }

    private int jjMoveStringLiteralDfa4_10(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 4;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 67108864) != 0) {
                        return jjStopAtPos(4, 26);
                    }
                    return 5;
                default:
                    return 5;
            }
        } catch (IOException e) {
            return 4;
        }
    }

    private int jjMoveStringLiteralDfa4_5(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 4;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 2097152) != 0) {
                        return jjStopAtPos(4, 21);
                    }
                    return 5;
                default:
                    return 5;
            }
        } catch (IOException e) {
            return 4;
        }
    }

    private int jjMoveStringLiteralDfa5_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(3, j, 0L);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa6_0(j3, 512L);
                case '[':
                    if ((256 & j3) != 0) {
                        return jjStopAtPos(5, 8);
                    }
                    break;
                case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                    if ((8589934592L & j3) != 0) {
                        return jjStartNfaWithStates_0(5, 33, 17);
                    }
                    break;
                case 'i':
                    return jjMoveStringLiteralDfa6_0(j3, 137438953472L);
                case 'n':
                    if ((35184372088832L & j3) != 0) {
                        return jjStartNfaWithStates_0(5, 45, 17);
                    }
                    break;
                case 't':
                    if ((70368744177664L & j3) != 0) {
                        return jjStartNfaWithStates_0(5, 46, 17);
                    }
                    break;
            }
            return jjStartNfa_0(4, j3, 0L);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(4, j3, 0L);
            return 5;
        }
    }

    private int jjMoveStringLiteralDfa6_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(4, j, 0L);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '[':
                    if ((512 & j3) != 0) {
                        return jjStopAtPos(6, 9);
                    }
                    break;
                case 'o':
                    return jjMoveStringLiteralDfa7_0(j3, 137438953472L);
            }
            return jjStartNfa_0(5, j3, 0L);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(5, j3, 0L);
            return 6;
        }
    }

    private int jjMoveStringLiteralDfa7_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(5, j, 0L);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'n':
                    if ((137438953472L & j3) != 0) {
                        return jjStartNfaWithStates_0(7, 37, 17);
                    }
                    break;
            }
            return jjStartNfa_0(6, j3, 0L);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(6, j3, 0L);
            return 7;
        }
    }

    private int jjStartNfaWithStates_0(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_0(i3, i + 1);
        } catch (IOException e) {
            return i + 1;
        }
    }

    private final int jjStartNfa_0(int i, long j, long j2) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(i, j, j2), i + 1);
    }

    private int jjStopAtPos(int i, int i2) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        return i + 1;
    }

    private final int jjStopStringLiteralDfa_0(int i, long j, long j2) {
        switch (i) {
            case 0:
                if ((30720 & j) != 0 || (j2 & 8192) != 0) {
                    return 14;
                }
                if ((j2 & 16810496) != 0) {
                    return 31;
                }
                if ((2251799276814336L & j) == 0) {
                    return ((j & 66496) == 0 && (j2 & 524288) == 0) ? -1 : 7;
                }
                this.jjmatchedKind = 51;
                return 17;
            case 1:
                if ((66496 & j) != 0) {
                    return 6;
                }
                if ((28672 & j) != 0) {
                    return 13;
                }
                if ((19243600969728L & j) != 0) {
                    return 17;
                }
                if ((2232555675844608L & j) == 0) {
                    return -1;
                }
                if (this.jjmatchedPos != 1) {
                    this.jjmatchedKind = 51;
                    this.jjmatchedPos = 1;
                }
                return 17;
            case 2:
                if ((2219275100094464L & j) != 0) {
                    this.jjmatchedKind = 51;
                    this.jjmatchedPos = 2;
                    return 17;
                }
                if ((24576 & j) != 0) {
                    return 12;
                }
                if ((960 & j) != 0) {
                    return 5;
                }
                return (13280575750144L & j) != 0 ? 17 : -1;
            case 3:
                if ((896 & j) != 0) {
                    return 4;
                }
                if ((1796774872219648L & j) == 0) {
                    if ((422500227874816L & j) != 0) {
                        return 17;
                    }
                    return (16384 & j) != 0 ? 9 : -1;
                }
                if (this.jjmatchedPos != 3) {
                    this.jjmatchedKind = 51;
                    this.jjmatchedPos = 3;
                }
                return 17;
            case 4:
                if ((105699145154560L & j) != 0) {
                    this.jjmatchedKind = 51;
                    this.jjmatchedPos = 4;
                    return 17;
                }
                if ((768 & j) != 0) {
                    return 3;
                }
                return (1691084316999680L & j) != 0 ? 17 : -1;
            case 5:
                if ((512 & j) != 0) {
                    return 0;
                }
                if ((105561706201088L & j) != 0) {
                    return 17;
                }
                if ((j & 137438953472L) == 0) {
                    return -1;
                }
                this.jjmatchedKind = 51;
                this.jjmatchedPos = 5;
                return 17;
            case 6:
                if ((j & 137438953472L) == 0) {
                    return -1;
                }
                this.jjmatchedKind = 51;
                this.jjmatchedPos = 6;
                return 17;
            default:
                return -1;
        }
    }

    public void ReInit(SimpleCharStream simpleCharStream) {
        this.jjnewStateCnt = 0;
        this.jjmatchedPos = 0;
        this.curLexState = this.defaultLexState;
        this.input_stream = simpleCharStream;
        ReInitRounds();
    }

    public void ReInit(SimpleCharStream simpleCharStream, int i) {
        ReInit(simpleCharStream);
        SwitchTo(i);
    }

    void SkipLexicalActions(Token token) {
        int i = this.jjmatchedKind;
    }

    public void SwitchTo(int i) {
        if (i >= 12 || i < 0) {
            throw new TokenMgrError(new StringBuffer().append("Error: Ignoring invalid lexical state : ").append(i).append(". State unchanged.").toString(), 2);
        }
        this.curLexState = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00a5, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00b6, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00c7, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00d8, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x003c, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00da, code lost:
    
        r22.jjmatchedKind = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x004e, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0060, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0072, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0083, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0094, code lost:
    
        if (r22.jjmatchedKind > 28) goto L57;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0028. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.luaj.vm2.parser.Token getNextToken() {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.parser.LuaParserTokenManager.getNextToken():org.luaj.vm2.parser.Token");
    }

    protected Token jjFillToken() {
        String str;
        int beginLine;
        int beginColumn;
        int endLine;
        int endColumn;
        if (this.jjmatchedPos < 0) {
            str = this.image == null ? "" : this.image.toString();
            beginLine = this.input_stream.getBeginLine();
            beginColumn = this.input_stream.getBeginColumn();
            endLine = beginLine;
            endColumn = beginColumn;
        } else {
            str = jjstrLiteralImages[this.jjmatchedKind];
            if (str == null) {
                str = this.input_stream.GetImage();
            }
            beginLine = this.input_stream.getBeginLine();
            beginColumn = this.input_stream.getBeginColumn();
            endLine = this.input_stream.getEndLine();
            endColumn = this.input_stream.getEndColumn();
        }
        Token newToken = Token.newToken(this.jjmatchedKind, str);
        newToken.beginLine = beginLine;
        newToken.endLine = endLine;
        newToken.beginColumn = beginColumn;
        newToken.endColumn = endColumn;
        return newToken;
    }

    public void setDebugStream(PrintStream printStream) {
        this.debugStream = printStream;
    }
}
