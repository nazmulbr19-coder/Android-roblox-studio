package org.luaj.vm2.lib.jse;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.lib.IoLib;

/* loaded from: classes10.dex */
public class JseIoLib extends IoLib {

    /* loaded from: classes10.dex */
    private final class FileImpl extends IoLib.File {
        private boolean closed;
        private final RandomAccessFile file;
        private final InputStream is;
        private boolean nobuffer;
        private final OutputStream os;
        private final /* synthetic */ JseIoLib this$0;

        private FileImpl(JseIoLib jseIoLib, InputStream inputStream) {
            this(jseIoLib, null, inputStream, null);
        }

        /* synthetic */ FileImpl(JseIoLib jseIoLib, InputStream inputStream, AnonymousClass1 anonymousClass1) {
            this(jseIoLib, inputStream);
        }

        private FileImpl(JseIoLib jseIoLib, OutputStream outputStream) {
            this(jseIoLib, null, null, outputStream);
        }

        /* synthetic */ FileImpl(JseIoLib jseIoLib, OutputStream outputStream, AnonymousClass1 anonymousClass1) {
            this(jseIoLib, outputStream);
        }

        private FileImpl(JseIoLib jseIoLib, RandomAccessFile randomAccessFile) {
            this(jseIoLib, randomAccessFile, null, null);
        }

        private FileImpl(JseIoLib jseIoLib, RandomAccessFile randomAccessFile, InputStream inputStream, OutputStream outputStream) {
            super();
            this.this$0 = jseIoLib;
            this.closed = false;
            this.nobuffer = false;
            this.file = randomAccessFile;
            if (inputStream == null) {
                inputStream = null;
            } else if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream);
            }
            this.is = inputStream;
            this.os = outputStream;
        }

        /* synthetic */ FileImpl(JseIoLib jseIoLib, RandomAccessFile randomAccessFile, AnonymousClass1 anonymousClass1) {
            this(jseIoLib, randomAccessFile);
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void close() throws IOException {
            this.closed = true;
            if (this.file != null) {
                this.file.close();
            }
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void flush() throws IOException {
            if (this.os != null) {
                this.os.flush();
            }
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isclosed() {
            return this.closed;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isstdfile() {
            return this.file == null;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int peek() throws IOException {
            if (this.is != null) {
                this.is.mark(1);
                int read = this.is.read();
                this.is.reset();
                return read;
            }
            if (this.file == null) {
                JseIoLib.access$500();
                return 0;
            }
            long filePointer = this.file.getFilePointer();
            int read2 = this.file.read();
            this.file.seek(filePointer);
            return read2;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read() throws IOException {
            if (this.is != null) {
                return this.is.read();
            }
            if (this.file != null) {
                return this.file.read();
            }
            JseIoLib.access$500();
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.file != null) {
                return this.file.read(bArr, i, i2);
            }
            if (this.is != null) {
                return this.is.read(bArr, i, i2);
            }
            JseIoLib.access$500();
            return i2;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int remaining() throws IOException {
            if (this.file != null) {
                return (int) (this.file.length() - this.file.getFilePointer());
            }
            return -1;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int seek(String str, int i) throws IOException {
            RandomAccessFile randomAccessFile;
            long filePointer;
            long j;
            if (this.file == null) {
                JseIoLib.access$500();
                return 0;
            }
            if ("set".equals(str)) {
                randomAccessFile = this.file;
                j = i;
            } else {
                if ("end".equals(str)) {
                    randomAccessFile = this.file;
                    filePointer = this.file.length();
                } else {
                    randomAccessFile = this.file;
                    filePointer = this.file.getFilePointer();
                }
                j = filePointer + i;
            }
            randomAccessFile.seek(j);
            return (int) this.file.getFilePointer();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void setvbuf(String str, int i) {
            this.nobuffer = "no".equals(str);
        }

        @Override // org.luaj.vm2.lib.IoLib.File, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String tojstring() {
            return new StringBuffer().append("file (").append(hashCode()).append(")").toString();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void write(LuaString luaString) throws IOException {
            if (this.os != null) {
                this.os.write(luaString.m_bytes, luaString.m_offset, luaString.m_length);
            } else if (this.file != null) {
                this.file.write(luaString.m_bytes, luaString.m_offset, luaString.m_length);
            } else {
                JseIoLib.access$500();
            }
            if (this.nobuffer) {
                flush();
            }
        }
    }

    /* loaded from: classes10.dex */
    private final class StdinFile extends IoLib.File {
        private final /* synthetic */ JseIoLib this$0;

        private StdinFile(JseIoLib jseIoLib) {
            super();
            this.this$0 = jseIoLib;
        }

        /* synthetic */ StdinFile(JseIoLib jseIoLib, AnonymousClass1 anonymousClass1) {
            this(jseIoLib);
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void close() throws IOException {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void flush() throws IOException {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isclosed() {
            return false;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isstdfile() {
            return true;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int peek() throws IOException, EOFException {
            JseIoLib.access$800(this.this$0).STDIN.mark(1);
            int read = JseIoLib.access$900(this.this$0).STDIN.read();
            JseIoLib.access$1000(this.this$0).STDIN.reset();
            return read;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read() throws IOException, EOFException {
            return JseIoLib.access$1100(this.this$0).STDIN.read();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return JseIoLib.access$1200(this.this$0).STDIN.read(bArr, i, i2);
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int remaining() throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int seek(String str, int i) throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void setvbuf(String str, int i) {
        }

        @Override // org.luaj.vm2.lib.IoLib.File, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String tojstring() {
            return new StringBuffer().append("file (").append(hashCode()).append(")").toString();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void write(LuaString luaString) throws IOException {
        }
    }

    /* loaded from: classes10.dex */
    private final class StdoutFile extends IoLib.File {
        private final int file_type;
        private final /* synthetic */ JseIoLib this$0;

        private StdoutFile(JseIoLib jseIoLib, int i) {
            super();
            this.this$0 = jseIoLib;
            this.file_type = i;
        }

        /* synthetic */ StdoutFile(JseIoLib jseIoLib, int i, AnonymousClass1 anonymousClass1) {
            this(jseIoLib, i);
        }

        private final PrintStream getPrintStream() {
            return this.file_type == 2 ? JseIoLib.access$600(this.this$0).STDERR : JseIoLib.access$700(this.this$0).STDOUT;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void close() throws IOException {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void flush() throws IOException {
            getPrintStream().flush();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isclosed() {
            return false;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isstdfile() {
            return true;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int peek() throws IOException, EOFException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read() throws IOException, EOFException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int remaining() throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int seek(String str, int i) throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void setvbuf(String str, int i) {
        }

        @Override // org.luaj.vm2.lib.IoLib.File, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String tojstring() {
            return new StringBuffer().append("file (").append(hashCode()).append(")").toString();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void write(LuaString luaString) throws IOException {
            getPrintStream().write(luaString.m_bytes, luaString.m_offset, luaString.m_length);
        }
    }

    static /* synthetic */ Globals access$1000(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static /* synthetic */ Globals access$1100(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static /* synthetic */ Globals access$1200(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static /* synthetic */ void access$500() {
        notimplemented();
    }

    static /* synthetic */ Globals access$600(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static /* synthetic */ Globals access$700(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static /* synthetic */ Globals access$800(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static /* synthetic */ Globals access$900(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    private static void notimplemented() {
        throw new LuaError("not implemented");
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File openFile(String str, boolean z, boolean z2, boolean z3, boolean z4) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, z ? "r" : "rw");
        if (z2) {
            randomAccessFile.seek(randomAccessFile.length());
        } else if (!z) {
            randomAccessFile.setLength(0L);
        }
        return new FileImpl(this, randomAccessFile, (AnonymousClass1) null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File openProgram(String str, String str2) throws IOException {
        Process exec = Runtime.getRuntime().exec(str);
        return "w".equals(str2) ? new FileImpl(this, exec.getOutputStream(), (AnonymousClass1) null) : new FileImpl(this, exec.getInputStream(), (AnonymousClass1) null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File tmpFile() throws IOException {
        File createTempFile = File.createTempFile(".luaj", "bin");
        createTempFile.deleteOnExit();
        return new FileImpl(this, new RandomAccessFile(createTempFile, "rw"), (AnonymousClass1) null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File wrapStderr() throws IOException {
        return new StdoutFile(this, 2, null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File wrapStdin() throws IOException {
        return new StdinFile(this, null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File wrapStdout() throws IOException {
        return new StdoutFile(this, 1, null);
    }
}
