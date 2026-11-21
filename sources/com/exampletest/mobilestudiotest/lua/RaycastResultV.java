package com.exampletest.mobilestudiotest.lua;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/RaycastResultV;", "", "hit", "Lcom/exampletest/mobilestudiotest/lua/RayHitInfo;", "<init>", "(Lcom/exampletest/mobilestudiotest/lua/RayHitInfo;)V", "getHit", "()Lcom/exampletest/mobilestudiotest/lua/RayHitInfo;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RaycastResultV {
    private final RayHitInfo hit;

    public RaycastResultV(RayHitInfo hit) {
        Intrinsics.checkNotNullParameter(hit, "hit");
        this.hit = hit;
    }

    public final RayHitInfo getHit() {
        return this.hit;
    }
}
