package org.luaj.vm2.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/* loaded from: classes10.dex */
public class SimpleCharStream {
    public static final boolean staticFlag = false;
    int available;
    protected int[] bufcolumn;
    protected char[] buffer;
    protected int[] bufline;
    public int bufpos;
    int bufsize;
    protected int column;
    protected int inBuf;
    protected Reader inputStream;
    protected int line;
    protected int maxNextCharInd;
    protected boolean prevCharIsCR;
    protected boolean prevCharIsLF;
    protected int tabSize;
    int tokenBegin;

    public SimpleCharStream(InputStream inputStream) {
        this(inputStream, 1, 1, 4096);
    }

    public SimpleCharStream(InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, 4096);
    }

    public SimpleCharStream(InputStream inputStream, int i, int i2, int i3) {
        this(new InputStreamReader(inputStream), i, i2, i3);
    }

    public SimpleCharStream(InputStream inputStream, String str) throws UnsupportedEncodingException {
        this(inputStream, str, 1, 1, 4096);
    }

    public SimpleCharStream(InputStream inputStream, String str, int i, int i2) throws UnsupportedEncodingException {
        this(inputStream, str, i, i2, 4096);
    }

    public SimpleCharStream(InputStream inputStream, String str, int i, int i2, int i3) throws UnsupportedEncodingException {
        this(str == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str), i, i2, i3);
    }

    public SimpleCharStream(Reader reader) {
        this(reader, 1, 1, 4096);
    }

    public SimpleCharStream(Reader reader, int i, int i2) {
        this(reader, i, i2, 4096);
    }

    public SimpleCharStream(Reader reader, int i, int i2, int i3) {
        this.bufpos = -1;
        this.column = 0;
        this.line = 1;
        this.prevCharIsCR = false;
        this.prevCharIsLF = false;
        this.maxNextCharInd = 0;
        this.inBuf = 0;
        this.tabSize = 1;
        this.inputStream = reader;
        this.line = i;
        this.column = i2 - 1;
        this.bufsize = i3;
        this.available = i3;
        this.buffer = new char[i3];
        this.bufline = new int[i3];
        this.bufcolumn = new int[i3];
    }

    public char BeginToken() throws IOException {
        this.tokenBegin = -1;
        char readChar = readChar();
        this.tokenBegin = this.bufpos;
        return readChar;
    }

    public void Done() {
        this.buffer = null;
        this.bufline = null;
        this.bufcolumn = null;
    }

    protected void ExpandBuff(boolean z) {
        int i;
        char[] cArr = new char[this.bufsize + 2048];
        int[] iArr = new int[this.bufsize + 2048];
        int[] iArr2 = new int[this.bufsize + 2048];
        try {
            if (z) {
                System.arraycopy(this.buffer, this.tokenBegin, cArr, 0, this.bufsize - this.tokenBegin);
                System.arraycopy(this.buffer, 0, cArr, this.bufsize - this.tokenBegin, this.bufpos);
                this.buffer = cArr;
                System.arraycopy(this.bufline, this.tokenBegin, iArr, 0, this.bufsize - this.tokenBegin);
                System.arraycopy(this.bufline, 0, iArr, this.bufsize - this.tokenBegin, this.bufpos);
                this.bufline = iArr;
                System.arraycopy(this.bufcolumn, this.tokenBegin, iArr2, 0, this.bufsize - this.tokenBegin);
                System.arraycopy(this.bufcolumn, 0, iArr2, this.bufsize - this.tokenBegin, this.bufpos);
                this.bufcolumn = iArr2;
                i = this.bufpos + (this.bufsize - this.tokenBegin);
                this.bufpos = i;
            } else {
                System.arraycopy(this.buffer, this.tokenBegin, cArr, 0, this.bufsize - this.tokenBegin);
                this.buffer = cArr;
                System.arraycopy(this.bufline, this.tokenBegin, iArr, 0, this.bufsize - this.tokenBegin);
                this.bufline = iArr;
                System.arraycopy(this.bufcolumn, this.tokenBegin, iArr2, 0, this.bufsize - this.tokenBegin);
                this.bufcolumn = iArr2;
                i = this.bufpos - this.tokenBegin;
                this.bufpos = i;
            }
            this.maxNextCharInd = i;
            this.bufsize += 2048;
            this.available = this.bufsize;
            this.tokenBegin = 0;
        } catch (Throwable th) {
            throw new Error(th.getMessage());
        }
    }

    protected void FillBuff() throws IOException {
        int i;
        if (this.maxNextCharInd == this.available) {
            if (this.available == this.bufsize) {
                if (this.tokenBegin > 2048) {
                    this.maxNextCharInd = 0;
                    this.bufpos = 0;
                    i = this.tokenBegin;
                } else if (this.tokenBegin < 0) {
                    this.maxNextCharInd = 0;
                    this.bufpos = 0;
                } else {
                    ExpandBuff(false);
                }
            } else if (this.available > this.tokenBegin) {
                i = this.bufsize;
            } else {
                if (this.tokenBegin - this.available < 2048) {
                    ExpandBuff(true);
                }
                i = this.tokenBegin;
            }
            this.available = i;
        }
        try {
            int read = this.inputStream.read(this.buffer, this.maxNextCharInd, this.available - this.maxNextCharInd);
            if (read != -1) {
                this.maxNextCharInd += read;
            } else {
                this.inputStream.close();
                throw new IOException();
            }
        } catch (IOException e) {
            this.bufpos--;
            backup(0);
            if (this.tokenBegin == -1) {
                this.tokenBegin = this.bufpos;
            }
            throw e;
        }
    }

    public String GetImage() {
        return this.bufpos >= this.tokenBegin ? new String(this.buffer, this.tokenBegin, (this.bufpos - this.tokenBegin) + 1) : new StringBuffer().append(new String(this.buffer, this.tokenBegin, this.bufsize - this.tokenBegin)).append(new String(this.buffer, 0, this.bufpos + 1)).toString();
    }

    public char[] GetSuffix(int i) {
        char[] cArr = new char[i];
        if (this.bufpos + 1 >= i) {
            System.arraycopy(this.buffer, (this.bufpos - i) + 1, cArr, 0, i);
        } else {
            System.arraycopy(this.buffer, this.bufsize - ((i - this.bufpos) - 1), cArr, 0, (i - this.bufpos) - 1);
            System.arraycopy(this.buffer, 0, cArr, (i - this.bufpos) - 1, this.bufpos + 1);
        }
        return cArr;
    }

    public void ReInit(InputStream inputStream) {
        ReInit(inputStream, 1, 1, 4096);
    }

    public void ReInit(InputStream inputStream, int i, int i2) {
        ReInit(inputStream, i, i2, 4096);
    }

    public void ReInit(InputStream inputStream, int i, int i2, int i3) {
        ReInit(new InputStreamReader(inputStream), i, i2, i3);
    }

    public void ReInit(InputStream inputStream, String str) throws UnsupportedEncodingException {
        ReInit(inputStream, str, 1, 1, 4096);
    }

    public void ReInit(InputStream inputStream, String str, int i, int i2) throws UnsupportedEncodingException {
        ReInit(inputStream, str, i, i2, 4096);
    }

    public void ReInit(InputStream inputStream, String str, int i, int i2, int i3) throws UnsupportedEncodingException {
        ReInit(str == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str), i, i2, i3);
    }

    public void ReInit(Reader reader) {
        ReInit(reader, 1, 1, 4096);
    }

    public void ReInit(Reader reader, int i, int i2) {
        ReInit(reader, i, i2, 4096);
    }

    public void ReInit(Reader reader, int i, int i2, int i3) {
        this.inputStream = reader;
        this.line = i;
        this.column = i2 - 1;
        if (this.buffer == null || i3 != this.buffer.length) {
            this.bufsize = i3;
            this.available = i3;
            this.buffer = new char[i3];
            this.bufline = new int[i3];
            this.bufcolumn = new int[i3];
        }
        this.prevCharIsCR = false;
        this.prevCharIsLF = false;
        this.maxNextCharInd = 0;
        this.inBuf = 0;
        this.tokenBegin = 0;
        this.bufpos = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void UpdateLineColumn(char r4) {
        /*
            r3 = this;
            int r0 = r3.column
            r1 = 1
            int r0 = r0 + r1
            r3.column = r0
            boolean r0 = r3.prevCharIsLF
            r2 = 0
            if (r0 == 0) goto L15
            r3.prevCharIsLF = r2
        Ld:
            int r0 = r3.line
            r3.column = r1
            int r0 = r0 + r1
            r3.line = r0
            goto L21
        L15:
            boolean r0 = r3.prevCharIsCR
            if (r0 == 0) goto L21
            r3.prevCharIsCR = r2
            r0 = 10
            if (r4 != r0) goto Ld
            r3.prevCharIsLF = r1
        L21:
            switch(r4) {
                case 9: goto L2b;
                case 10: goto L28;
                case 11: goto L24;
                case 12: goto L24;
                case 13: goto L25;
                default: goto L24;
            }
        L24:
            goto L3d
        L25:
            r3.prevCharIsCR = r1
            goto L3d
        L28:
            r3.prevCharIsLF = r1
            goto L3d
        L2b:
            int r4 = r3.column
            int r4 = r4 - r1
            r3.column = r4
            int r4 = r3.column
            int r0 = r3.tabSize
            int r1 = r3.column
            int r2 = r3.tabSize
            int r1 = r1 % r2
            int r0 = r0 - r1
            int r4 = r4 + r0
            r3.column = r4
        L3d:
            int[] r4 = r3.bufline
            int r0 = r3.bufpos
            int r1 = r3.line
            r4[r0] = r1
            int[] r4 = r3.bufcolumn
            int r0 = r3.bufpos
            int r1 = r3.column
            r4[r0] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.parser.SimpleCharStream.UpdateLineColumn(char):void");
    }

    public void adjustBeginLineColumn(int i, int i2) {
        int i3 = this.tokenBegin;
        int i4 = this.bufpos >= this.tokenBegin ? (this.bufpos - this.tokenBegin) + this.inBuf + 1 : (this.bufsize - this.tokenBegin) + this.bufpos + 1 + this.inBuf;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int[] iArr = this.bufline;
            int i8 = i3 % this.bufsize;
            int i9 = iArr[i8];
            int[] iArr2 = this.bufline;
            i3++;
            int i10 = i3 % this.bufsize;
            if (i9 != iArr2[i10]) {
                i6 = i8;
                break;
            }
            this.bufline[i8] = i;
            int i11 = (this.bufcolumn[i10] + i7) - this.bufcolumn[i8];
            this.bufcolumn[i8] = i7 + i2;
            i5++;
            i7 = i11;
            i6 = i8;
        }
        if (i5 < i4) {
            int i12 = i + 1;
            this.bufline[i6] = i;
            this.bufcolumn[i6] = i2 + i7;
            while (true) {
                int i13 = i5 + 1;
                if (i5 >= i4) {
                    break;
                }
                int[] iArr3 = this.bufline;
                i6 = i3 % this.bufsize;
                i3++;
                if (iArr3[i6] != this.bufline[i3 % this.bufsize]) {
                    this.bufline[i6] = i12;
                    i12++;
                } else {
                    this.bufline[i6] = i12;
                }
                i5 = i13;
            }
        }
        this.line = this.bufline[i6];
        this.column = this.bufcolumn[i6];
    }

    public void backup(int i) {
        this.inBuf += i;
        int i2 = this.bufpos - i;
        this.bufpos = i2;
        if (i2 < 0) {
            this.bufpos += this.bufsize;
        }
    }

    public int getBeginColumn() {
        return this.bufcolumn[this.tokenBegin];
    }

    public int getBeginLine() {
        return this.bufline[this.tokenBegin];
    }

    public int getColumn() {
        return this.bufcolumn[this.bufpos];
    }

    public int getEndColumn() {
        return this.bufcolumn[this.bufpos];
    }

    public int getEndLine() {
        return this.bufline[this.bufpos];
    }

    public int getLine() {
        return this.bufline[this.bufpos];
    }

    public int getTabSize(int i) {
        return this.tabSize;
    }

    public char readChar() throws IOException {
        if (this.inBuf > 0) {
            this.inBuf--;
            int i = this.bufpos + 1;
            this.bufpos = i;
            if (i == this.bufsize) {
                this.bufpos = 0;
            }
            return this.buffer[this.bufpos];
        }
        int i2 = this.bufpos + 1;
        this.bufpos = i2;
        if (i2 >= this.maxNextCharInd) {
            FillBuff();
        }
        char c = this.buffer[this.bufpos];
        UpdateLineColumn(c);
        return c;
    }

    public void setTabSize(int i) {
        this.tabSize = i;
    }
}
