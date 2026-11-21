package com.exampletest.mobilestudiotest.lua;

import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Vector3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/Region3V;", "", "min", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "max", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getMin", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getMax", "cframe", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "getCframe", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "size", "getSize", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Region3V {
    private final Vector3 max;
    private final Vector3 min;

    public Region3V(Vector3 min, Vector3 max) {
        Intrinsics.checkNotNullParameter(min, "min");
        Intrinsics.checkNotNullParameter(max, "max");
        this.min = min;
        this.max = max;
    }

    public final CFrame getCframe() {
        return CFrame.INSTANCE.at(this.min.plus(this.max).div(2.0f));
    }

    public final Vector3 getMax() {
        return this.max;
    }

    public final Vector3 getMin() {
        return this.min;
    }

    public final Vector3 getSize() {
        return this.max.minus(this.min);
    }

    public String toString() {
        return getCframe().getPosition() + "; " + getSize();
    }
}
