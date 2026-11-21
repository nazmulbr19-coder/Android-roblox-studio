package org.luaj.vm2.server;

import java.io.InputStream;
import java.io.Reader;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

/* loaded from: classes10.dex */
public class DefaultLauncher implements Launcher {
    protected Globals g = JsePlatform.standardGlobals();

    private Object[] launchChunk(LuaValue luaValue, Object[] objArr) {
        int length = objArr.length;
        LuaValue[] luaValueArr = new LuaValue[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            luaValueArr[i2] = CoerceJavaToLua.coerce(objArr[i2]);
        }
        Varargs invoke = luaValue.invoke(LuaValue.varargsOf(luaValueArr));
        int narg = invoke.narg();
        Object[] objArr2 = new Object[narg];
        while (i < narg) {
            int i3 = i + 1;
            LuaValue arg = invoke.arg(i3);
            switch (arg.type()) {
                case -2:
                    objArr2[i] = Integer.valueOf(arg.toint());
                    break;
                case -1:
                case 2:
                case 5:
                case 6:
                default:
                    objArr2[i] = arg;
                    break;
                case 0:
                    objArr2[i] = null;
                    break;
                case 1:
                    objArr2[i] = Boolean.valueOf(arg.toboolean());
                    break;
                case 3:
                    objArr2[i] = Double.valueOf(arg.todouble());
                    break;
                case 4:
                    objArr2[i] = arg.tojstring();
                    break;
                case 7:
                    objArr2[i] = arg.touserdata();
                    break;
            }
            i = i3;
        }
        return objArr2;
    }

    @Override // org.luaj.vm2.server.Launcher
    public Object[] launch(InputStream inputStream, Object[] objArr) {
        return launchChunk(this.g.load(inputStream, "main", "bt", this.g), objArr);
    }

    @Override // org.luaj.vm2.server.Launcher
    public Object[] launch(Reader reader, Object[] objArr) {
        return launchChunk(this.g.load(reader, "main"), objArr);
    }

    @Override // org.luaj.vm2.server.Launcher
    public Object[] launch(String str, Object[] objArr) {
        return launchChunk(this.g.load(str, "main"), objArr);
    }
}
