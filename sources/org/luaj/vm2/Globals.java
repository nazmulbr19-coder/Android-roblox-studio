package org.luaj.vm2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import kotlin.UByte;
import org.luaj.vm2.lib.BaseLib;
import org.luaj.vm2.lib.DebugLib;
import org.luaj.vm2.lib.PackageLib;
import org.luaj.vm2.lib.ResourceFinder;

/* loaded from: classes10.dex */
public class Globals extends LuaTable {
    public BaseLib baselib;
    public Compiler compiler;
    public DebugLib debuglib;
    public ResourceFinder finder;
    public Loader loader;
    public PackageLib package_;
    public Undumper undumper;
    public InputStream STDIN = null;
    public PrintStream STDOUT = System.out;
    public PrintStream STDERR = System.err;
    public LuaThread running = new LuaThread(this);

    /* loaded from: classes10.dex */
    static abstract class AbstractBufferedStream extends InputStream {
        protected byte[] b;
        protected int i = 0;
        protected int j = 0;

        protected AbstractBufferedStream(int i) {
            this.b = new byte[i];
        }

        protected abstract int avail() throws IOException;

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.j - this.i;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (avail() <= 0) {
                return -1;
            }
            byte[] bArr = this.b;
            int i = this.i;
            this.i = i + 1;
            return bArr[i] & UByte.MAX_VALUE;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int avail = avail();
            if (avail <= 0) {
                return -1;
            }
            int min = Math.min(avail, i2);
            System.arraycopy(this.b, this.i, bArr, i, min);
            this.i += min;
            return min;
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long min = Math.min(j, this.j - this.i);
            this.i = (int) (this.i + min);
            return min;
        }
    }

    /* loaded from: classes10.dex */
    static class BufferedStream extends AbstractBufferedStream {
        private final InputStream s;

        BufferedStream(int i, InputStream inputStream) {
            super(i);
            this.s = inputStream;
        }

        public BufferedStream(InputStream inputStream) {
            this(128, inputStream);
        }

        @Override // org.luaj.vm2.Globals.AbstractBufferedStream
        protected int avail() throws IOException {
            if (this.i < this.j) {
                return this.j - this.i;
            }
            if (this.j >= this.b.length) {
                this.j = 0;
                this.i = 0;
            }
            int read = this.s.read(this.b, this.j, this.b.length - this.j);
            if (read < 0) {
                return -1;
            }
            if (read == 0) {
                int read2 = this.s.read();
                if (read2 < 0) {
                    return -1;
                }
                this.b[this.j] = (byte) read2;
                read = 1;
            }
            this.j += read;
            return read;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.s.close();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            if (this.i > 0 || i > this.b.length) {
                byte[] bArr = i > this.b.length ? new byte[i] : this.b;
                System.arraycopy(this.b, this.i, bArr, 0, this.j - this.i);
                this.j -= this.i;
                this.i = 0;
                this.b = bArr;
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            this.i = 0;
        }
    }

    /* loaded from: classes10.dex */
    public interface Compiler {
        Prototype compile(InputStream inputStream, String str) throws IOException;
    }

    /* loaded from: classes10.dex */
    public interface Loader {
        LuaFunction load(Prototype prototype, String str, LuaValue luaValue) throws IOException;
    }

    /* loaded from: classes10.dex */
    static class StrReader extends Reader {
        int i = 0;
        final int n;
        final String s;

        StrReader(String str) {
            this.s = str;
            this.n = str.length();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.i = this.n;
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            if (this.i >= this.n) {
                return -1;
            }
            String str = this.s;
            int i = this.i;
            this.i = i + 1;
            return str.charAt(i);
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2 && this.i < this.n) {
                cArr[i + i3] = this.s.charAt(this.i);
                i3++;
                this.i++;
            }
            if (i3 > 0 || i2 == 0) {
                return i3;
            }
            return -1;
        }
    }

    /* loaded from: classes10.dex */
    static class UTF8Stream extends AbstractBufferedStream {
        private final char[] c;
        private final Reader r;

        UTF8Stream(Reader reader) {
            super(96);
            this.c = new char[32];
            this.r = reader;
        }

        @Override // org.luaj.vm2.Globals.AbstractBufferedStream
        protected int avail() throws IOException {
            if (this.i < this.j) {
                return this.j - this.i;
            }
            int read = this.r.read(this.c);
            if (read < 0) {
                return -1;
            }
            if (read == 0) {
                int read2 = this.r.read();
                if (read2 < 0) {
                    return -1;
                }
                this.c[0] = (char) read2;
                read = 1;
            }
            char[] cArr = this.c;
            byte[] bArr = this.b;
            this.i = 0;
            this.j = LuaString.encodeToUtf8(cArr, read, bArr, 0);
            return this.j;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.r.close();
        }
    }

    /* loaded from: classes10.dex */
    public interface Undumper {
        Prototype undump(InputStream inputStream, String str) throws IOException;
    }

    @Override // org.luaj.vm2.LuaValue
    public Globals checkglobals() {
        return this;
    }

    public Prototype compilePrototype(InputStream inputStream, String str) throws IOException {
        if (this.compiler == null) {
            error("No compiler.");
        }
        return this.compiler.compile(inputStream, str);
    }

    public Prototype compilePrototype(Reader reader, String str) throws IOException {
        return compilePrototype(new UTF8Stream(reader), str);
    }

    public LuaValue load(InputStream inputStream, String str, String str2, LuaValue luaValue) {
        try {
            return this.loader.load(loadPrototype(inputStream, str, str2), str, luaValue);
        } catch (LuaError e) {
            throw e;
        } catch (Exception e2) {
            return error(new StringBuffer().append("load ").append(str).append(": ").append(e2).toString());
        }
    }

    public LuaValue load(Reader reader, String str) {
        return load(new UTF8Stream(reader), str, "t", this);
    }

    public LuaValue load(Reader reader, String str, LuaTable luaTable) {
        return load(new UTF8Stream(reader), str, "t", luaTable);
    }

    public LuaValue load(String str) {
        return load(new StrReader(str), str);
    }

    public LuaValue load(String str, String str2) {
        return load(new StrReader(str), str2);
    }

    public LuaValue load(String str, String str2, LuaTable luaTable) {
        return load(new StrReader(str), str2, luaTable);
    }

    public Prototype loadPrototype(InputStream inputStream, String str, String str2) throws IOException {
        if (str2.indexOf(98) >= 0) {
            if (this.undumper == null) {
                error("No undumper.");
            }
            if (!inputStream.markSupported()) {
                inputStream = new BufferedStream(inputStream);
            }
            inputStream.mark(4);
            Prototype undump = this.undumper.undump(inputStream, str);
            if (undump != null) {
                return undump;
            }
            inputStream.reset();
        }
        if (str2.indexOf(116) >= 0) {
            return compilePrototype(inputStream, str);
        }
        error(new StringBuffer().append("Failed to load prototype ").append(str).append(" using mode '").append(str2).append("'").toString());
        return null;
    }

    public LuaValue loadfile(String str) {
        try {
            return load(this.finder.findResource(str), new StringBuffer().append("@").append(str).toString(), "bt", this);
        } catch (Exception e) {
            return error(new StringBuffer().append("load ").append(str).append(": ").append(e).toString());
        }
    }

    public Varargs yield(Varargs varargs) {
        if (this.running == null || this.running.isMainThread()) {
            throw new LuaError("cannot yield main thread");
        }
        return this.running.state.lua_yield(varargs);
    }
}
