package org.luaj.vm2.script;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;
import org.luaj.vm2.Globals;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.luaj.vm2.luajc.LuaJC;

/* loaded from: classes10.dex */
public class LuajContext extends SimpleScriptContext implements ScriptContext {
    public final Globals globals;
    private final PrintStream stderr;
    private final InputStream stdin;
    private final PrintStream stdout;

    /* loaded from: classes10.dex */
    static final class ReaderInputStream extends InputStream {
        final Reader r;

        ReaderInputStream(Reader reader) {
            this.r = reader;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.r.read();
        }
    }

    /* loaded from: classes10.dex */
    static final class WriterOutputStream extends OutputStream {
        final Writer w;

        WriterOutputStream(Writer writer) {
            this.w = writer;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.w.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.w.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.w.write(new String(new byte[]{(byte) i}));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.w.write(new String(bArr));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.w.write(new String(bArr, i, i2));
        }
    }

    public LuajContext() {
        this("true".equals(System.getProperty("org.luaj.debug")), "true".equals(System.getProperty("org.luaj.luajc")));
    }

    public LuajContext(boolean z, boolean z2) {
        this.globals = z ? JsePlatform.debugGlobals() : JsePlatform.standardGlobals();
        if (z2) {
            LuaJC.install(this.globals);
        }
        this.stdin = this.globals.STDIN;
        this.stdout = this.globals.STDOUT;
        this.stderr = this.globals.STDERR;
    }

    public void setErrorWriter(Writer writer) {
        this.globals.STDERR = writer != null ? new PrintStream(new WriterOutputStream(writer)) : this.stderr;
    }

    public void setReader(Reader reader) {
        this.globals.STDIN = reader != null ? new ReaderInputStream(reader) : this.stdin;
    }

    public void setWriter(Writer writer) {
        this.globals.STDOUT = writer != null ? new PrintStream((OutputStream) new WriterOutputStream(writer), true) : this.stdout;
    }
}
