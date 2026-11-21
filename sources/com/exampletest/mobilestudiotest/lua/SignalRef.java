package com.exampletest.mobilestudiotest.lua;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LuaRuntime.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/SignalRef;", "", "owner", "name", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "getOwner", "()Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SignalRef {
    private final String name;
    private final Object owner;

    public SignalRef(Object owner, String name) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.owner = owner;
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getOwner() {
        return this.owner;
    }
}
