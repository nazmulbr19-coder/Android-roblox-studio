package org.luaj.vm2.lib.jse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.BaseLib;

/* loaded from: classes10.dex */
public class JseBaseLib extends BaseLib {
    @Override // org.luaj.vm2.lib.BaseLib, org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        super.call(luaValue, luaValue2);
        luaValue2.checkglobals().STDIN = System.in;
        return luaValue2;
    }

    @Override // org.luaj.vm2.lib.BaseLib, org.luaj.vm2.lib.ResourceFinder
    public InputStream findResource(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return super.findResource(str);
        }
        try {
            return new FileInputStream(file);
        } catch (IOException e) {
            return null;
        }
    }
}
