package defpackage;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.luaj.vm2.Globals;
import org.luaj.vm2.Print;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.compiler.DumpState;
import org.luaj.vm2.lib.jse.JsePlatform;

/* loaded from: classes.dex */
public class luac {
    private static final String usage = "usage: java -cp luaj-jse.jar luac [options] [filenames].\nAvailable options are:\n  -        process stdin\n  -l       list\n  -o name  output to file 'name' (default is \"luac.out\")\n  -p       parse only\n  -s       strip debug information\n  -e       little endian format for numbers\n  -i<n>    number format 'n', (n=0,1 or 4, default=0)\n  -v       show version information\n  -c enc  \tuse the supplied encoding 'enc' for input files\n  --       stop handling options\n";
    private static final String version = "Luaj-jse 3.0.1Copyright (C) 2009 luaj.org";
    private String encoding;
    private boolean list;
    private boolean littleendian;
    private int numberformat;
    private String output;
    private boolean parseonly;
    private boolean processing;
    private boolean stripdebug;
    private boolean versioninfo;

    private luac(String[] strArr) throws IOException {
        this.list = false;
        this.output = "luac.out";
        this.parseonly = false;
        this.stripdebug = false;
        this.littleendian = false;
        this.numberformat = 0;
        this.versioninfo = false;
        this.processing = true;
        this.encoding = null;
        int i = 0;
        while (i < strArr.length) {
            try {
                if (this.processing && strArr[i].startsWith("-") && strArr[i].length() > 1) {
                    switch (strArr[i].charAt(1)) {
                        case '-':
                            if (strArr[i].length() > 2) {
                                usageExit();
                            }
                            this.processing = false;
                            break;
                        case 'c':
                            i++;
                            if (i >= strArr.length) {
                                usageExit();
                            }
                            this.encoding = strArr[i];
                            break;
                        case TypedValues.TYPE_TARGET /* 101 */:
                            this.littleendian = true;
                            break;
                        case 'i':
                            if (strArr[i].length() <= 2) {
                                usageExit();
                            }
                            this.numberformat = Integer.parseInt(strArr[i].substring(2));
                            break;
                        case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                            this.list = true;
                            break;
                        case 'o':
                            i++;
                            if (i >= strArr.length) {
                                usageExit();
                            }
                            this.output = strArr[i];
                            break;
                        case 'p':
                            this.parseonly = true;
                            break;
                        case 's':
                            this.stripdebug = true;
                            break;
                        case 'v':
                            this.versioninfo = true;
                            break;
                        default:
                            usageExit();
                            break;
                    }
                }
                i++;
            } catch (IOException e) {
                System.err.println(e.toString());
                System.exit(-2);
                return;
            }
        }
        if (this.versioninfo) {
            System.out.println(version);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.output);
        try {
            Globals standardGlobals = JsePlatform.standardGlobals();
            this.processing = true;
            int i2 = 0;
            while (i2 < strArr.length) {
                if (!this.processing || !strArr[i2].startsWith("-")) {
                    processScript(standardGlobals, new FileInputStream(strArr[i2]), strArr[i2].substring(0, strArr[i2].length() - 4), fileOutputStream);
                } else if (strArr[i2].length() > 1) {
                    switch (strArr[i2].charAt(1)) {
                        case '-':
                            this.processing = false;
                            break;
                        case 'c':
                        case 'o':
                            i2++;
                            break;
                    }
                } else {
                    processScript(standardGlobals, System.in, "=stdin", fileOutputStream);
                }
                i2++;
            }
            fileOutputStream.close();
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public static void main(String[] strArr) throws IOException {
        new luac(strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void processScript(Globals globals, InputStream inputStream, String str, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            Prototype compilePrototype = this.encoding != null ? globals.compilePrototype(new InputStreamReader(bufferedInputStream, this.encoding), str) : globals.compilePrototype(bufferedInputStream, str);
            if (this.list) {
                Print.printCode(compilePrototype);
            }
            boolean z = this.parseonly;
            InputStream inputStream2 = z;
            if (z == 0) {
                boolean z2 = this.stripdebug;
                DumpState.dump(compilePrototype, outputStream, z2, this.numberformat, this.littleendian);
                inputStream2 = z2;
            }
            bufferedInputStream.close();
            inputStream = inputStream2;
        } catch (Exception e2) {
            e = e2;
            inputStream = bufferedInputStream;
            e.printStackTrace(System.err);
            inputStream.close();
            inputStream = inputStream;
        } catch (Throwable th2) {
            th = th2;
            inputStream = bufferedInputStream;
            inputStream.close();
            throw th;
        }
    }

    private static void usageExit() {
        System.out.println(usage);
        System.exit(-1);
    }
}
