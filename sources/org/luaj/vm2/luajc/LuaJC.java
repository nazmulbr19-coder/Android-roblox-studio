package org.luaj.vm2.luajc;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Hashtable;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;

/* loaded from: classes10.dex */
public class LuaJC implements Globals.Loader {
    public static final LuaJC instance = new LuaJC();

    protected LuaJC() {
    }

    private Hashtable compileProtoAndSubProtos(Prototype prototype, String str, String str2, boolean z) throws IOException {
        String standardLuaFileName = toStandardLuaFileName(str2);
        Hashtable hashtable = new Hashtable();
        insert(hashtable, new JavaGen(prototype, str, standardLuaFileName, z));
        return hashtable;
    }

    private void insert(Hashtable hashtable, JavaGen javaGen) {
        hashtable.put(javaGen.classname, javaGen.bytecode);
        int length = javaGen.inners != null ? javaGen.inners.length : 0;
        for (int i = 0; i < length; i++) {
            insert(hashtable, javaGen.inners[i]);
        }
    }

    public static final void install(Globals globals) {
        globals.loader = instance;
    }

    private static String toStandardJavaClassName(String str) {
        String stub = toStub(str);
        StringBuffer stringBuffer = new StringBuffer();
        int length = stub.length();
        for (int i = 0; i < length; i++) {
            char charAt = stub.charAt(i);
            if ((i != 0 || !Character.isJavaIdentifierStart(charAt)) && (i <= 0 || !Character.isJavaIdentifierPart(charAt))) {
                charAt = '_';
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    private static String toStandardLuaFileName(String str) {
        String stringBuffer = new StringBuffer().append(toStub(str).replace('.', '/')).append(".lua").toString();
        return stringBuffer.startsWith("@") ? stringBuffer.substring(1) : stringBuffer;
    }

    private static String toStub(String str) {
        return str.endsWith(".lua") ? str.substring(0, str.length() - 4) : str;
    }

    public Hashtable compileAll(InputStream inputStream, String str, String str2, Globals globals, boolean z) throws IOException {
        String standardJavaClassName = toStandardJavaClassName(str);
        return compileProtoAndSubProtos(globals.loadPrototype(inputStream, standardJavaClassName, "bt"), standardJavaClassName, str2, z);
    }

    public Hashtable compileAll(Reader reader, String str, String str2, Globals globals, boolean z) throws IOException {
        String standardJavaClassName = toStandardJavaClassName(str);
        return compileProtoAndSubProtos(globals.compilePrototype(reader, standardJavaClassName), standardJavaClassName, str2, z);
    }

    @Override // org.luaj.vm2.Globals.Loader
    public LuaFunction load(Prototype prototype, String str, LuaValue luaValue) throws IOException {
        String standardLuaFileName = toStandardLuaFileName(str);
        return new JavaLoader().load(prototype, toStandardJavaClassName(standardLuaFileName), standardLuaFileName, luaValue);
    }
}
