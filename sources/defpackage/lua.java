package defpackage;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Print;
import org.luaj.vm2.Varargs;

/* loaded from: classes.dex */
public class lua {
    private static Globals globals = null;
    private static final String usage = "usage: java -cp luaj-jse.jar lua [options] [script [args]].\nAvailable options are:\n  -e stat  execute string 'stat'\n  -l name  require library 'name'\n  -i       enter interactive mode after executing 'script'\n  -v       show version information\n  -b      \tuse luajc bytecode-to-bytecode compiler (requires bcel on class path)\n  -n      \tnodebug - do not load debug library by default\n  -p      \tprint the prototype\n  -c enc  \tuse the supplied encoding 'enc' for input files\n  --       stop handling options\n  -        execute stdin and stop handling options";
    private static final String version = "Luaj-jse 3.0.1 Copyright (c) 2012 Luaj.org.org";
    private static boolean print = false;
    private static String encoding = null;

    private static void interactiveMode() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("> ");
            System.out.flush();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            } else {
                processScript(new ByteArrayInputStream(readLine.getBytes()), "=stdin", null, 0);
            }
        }
    }

    private static void loadLibrary(String str) throws IOException {
        LuaString valueOf = LuaValue.valueOf(str);
        try {
            globals.get("require").call(valueOf);
        } catch (Exception e) {
            try {
                ((LuaValue) Class.forName(str).newInstance()).call(valueOf, globals);
            } catch (Exception e2) {
                throw new IOException(new StringBuffer().append("loadLibrary(").append(str).append(") failed: ").append(e).append(",").append(e2).toString());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0076, code lost:
    
        java.lang.System.out.println(defpackage.lua.version);
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f6 A[Catch: IOException -> 0x00fa, TRY_LEAVE, TryCatch #0 {IOException -> 0x00fa, blocks: (B:6:0x000e, B:10:0x0015, B:12:0x001d, B:14:0x0025, B:15:0x002b, B:17:0x0052, B:19:0x0072, B:22:0x0031, B:26:0x0036, B:28:0x003b, B:30:0x0040, B:31:0x0045, B:35:0x004d, B:38:0x0056, B:40:0x005b, B:41:0x005e, B:45:0x0065, B:47:0x006e, B:52:0x0076, B:54:0x007f, B:55:0x0088, B:57:0x008c, B:59:0x0093, B:62:0x009c, B:65:0x00aa, B:68:0x00af, B:70:0x00b7, B:84:0x00bf, B:85:0x00f1, B:72:0x00c4, B:73:0x00ca, B:76:0x00e6, B:77:0x00ce, B:79:0x00e2, B:93:0x00e8, B:87:0x00f6, B:97:0x0084), top: B:5:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void main(java.lang.String[] r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lua.main(java.lang.String[]):void");
    }

    private static void processScript(InputStream inputStream, String str, String[] strArr, int i) throws IOException {
        InputStream inputStream2;
        Throwable th;
        try {
            try {
                inputStream2 = new BufferedInputStream(inputStream);
                try {
                    LuaValue load = encoding != null ? globals.load(new InputStreamReader(inputStream2, encoding), str) : globals.load(inputStream2, str, "bt", globals);
                    inputStream2.close();
                    if (print && load.isclosure()) {
                        Print.print(load.checkclosure().p);
                    }
                    load.invoke(setGlobalArg(str, strArr, i, globals));
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2.close();
                    throw th;
                }
            } catch (Throwable th3) {
                inputStream2 = inputStream;
                th = th3;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private static Varargs setGlobalArg(String str, String[] strArr, int i, LuaValue luaValue) {
        if (strArr == null) {
            return LuaValue.NONE;
        }
        LuaTable tableOf = LuaValue.tableOf();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            tableOf.set(i2 - i, LuaValue.valueOf(strArr[i2]));
        }
        tableOf.set(0, LuaValue.valueOf(str));
        tableOf.set(-1, LuaValue.valueOf("luaj"));
        luaValue.set(AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_ARG, tableOf);
        return tableOf.unpack();
    }

    private static void usageExit() {
        System.out.println(usage);
        System.exit(-1);
    }
}
