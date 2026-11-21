package com.exampletest.mobilestudiotest.lua;

import com.exampletest.mobilestudiotest.model.Vector3int16;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/Region3int16V;", "", "min", "Lcom/exampletest/mobilestudiotest/model/Vector3int16;", "max", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Vector3int16;Lcom/exampletest/mobilestudiotest/model/Vector3int16;)V", "getMin", "()Lcom/exampletest/mobilestudiotest/model/Vector3int16;", "getMax", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Region3int16V {
    private final Vector3int16 max;
    private final Vector3int16 min;

    public Region3int16V(Vector3int16 min, Vector3int16 max) {
        Intrinsics.checkNotNullParameter(min, "min");
        Intrinsics.checkNotNullParameter(max, "max");
        this.min = min;
        this.max = max;
    }

    public final Vector3int16 getMax() {
        return this.max;
    }

    public final Vector3int16 getMin() {
        return this.min;
    }
}
