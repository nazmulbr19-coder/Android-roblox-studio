package com.exampletest.mobilestudiotest.lua;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.LuaValue;

/* compiled from: LuaRuntime.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/Connection;", "", "owner", "name", "", "fn", "Lorg/luaj/vm2/LuaValue;", "once", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lorg/luaj/vm2/LuaValue;Z)V", "getOwner", "()Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "getFn", "()Lorg/luaj/vm2/LuaValue;", "getOnce", "()Z", "connected", "getConnected", "setConnected", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Connection {
    private boolean connected;
    private final LuaValue fn;
    private final String name;
    private final boolean once;
    private final Object owner;

    public Connection(Object owner, String name, LuaValue fn, boolean z) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fn, "fn");
        this.owner = owner;
        this.name = name;
        this.fn = fn;
        this.once = z;
        this.connected = true;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final LuaValue getFn() {
        return this.fn;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getOnce() {
        return this.once;
    }

    public final Object getOwner() {
        return this.owner;
    }

    public final void setConnected(boolean z) {
        this.connected = z;
    }
}
