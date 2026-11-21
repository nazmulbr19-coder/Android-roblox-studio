package org.luaj.vm2.lib.jse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes10.dex */
public class JseProcess {
    final Thread error;
    final Thread input;
    final Thread output;
    final Process process;

    /* loaded from: classes10.dex */
    private static final class CopyThread extends Thread {
        private final InputStream input;
        private final OutputStream output;
        private final InputStream ownedInput;
        private final OutputStream ownedOutput;

        private CopyThread(OutputStream outputStream, OutputStream outputStream2, InputStream inputStream, InputStream inputStream2) {
            this.output = outputStream;
            this.ownedOutput = outputStream2;
            this.ownedInput = inputStream;
            this.input = inputStream2;
        }

        /* synthetic */ CopyThread(OutputStream outputStream, OutputStream outputStream2, InputStream inputStream, InputStream inputStream2, AnonymousClass1 anonymousClass1) {
            this(outputStream, outputStream2, inputStream, inputStream2);
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    try {
                        int read = this.input.read(bArr);
                        if (read < 0) {
                            break;
                        } else {
                            this.output.write(bArr, 0, read);
                        }
                    } catch (Throwable th) {
                        if (this.ownedInput != null) {
                            this.ownedInput.close();
                        }
                        if (this.ownedOutput != null) {
                            this.ownedOutput.close();
                        }
                        throw th;
                    }
                }
                if (this.ownedInput != null) {
                    this.ownedInput.close();
                }
                if (this.ownedOutput != null) {
                    this.ownedOutput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private JseProcess(Process process, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) {
        this.process = process;
        this.input = inputStream == null ? null : copyBytes(inputStream, process.getOutputStream(), null, process.getOutputStream());
        this.output = outputStream == null ? null : copyBytes(process.getInputStream(), outputStream, process.getInputStream(), null);
        this.error = outputStream2 != null ? copyBytes(process.getErrorStream(), outputStream2, process.getErrorStream(), null) : null;
    }

    public JseProcess(String str, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) throws IOException {
        this(Runtime.getRuntime().exec(str), inputStream, outputStream, outputStream2);
    }

    public JseProcess(String[] strArr, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) throws IOException {
        this(Runtime.getRuntime().exec(strArr), inputStream, outputStream, outputStream2);
    }

    private Thread copyBytes(InputStream inputStream, OutputStream outputStream, InputStream inputStream2, OutputStream outputStream2) {
        CopyThread copyThread = new CopyThread(outputStream, outputStream2, inputStream2, inputStream, null);
        copyThread.start();
        return copyThread;
    }

    public int exitValue() {
        return this.process.exitValue();
    }

    public int waitFor() throws InterruptedException {
        int waitFor = this.process.waitFor();
        if (this.input != null) {
            this.input.join();
        }
        if (this.output != null) {
            this.output.join();
        }
        if (this.error != null) {
            this.error.join();
        }
        this.process.destroy();
        return waitFor;
    }
}
