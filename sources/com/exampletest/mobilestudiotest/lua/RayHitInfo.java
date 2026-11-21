package com.exampletest.mobilestudiotest.lua;

import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.Vector3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/RayHitInfo;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "position", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "normal", "distance", "", "material", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;FI)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getPosition", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getNormal", "getDistance", "()F", "getMaterial", "()I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RayHitInfo {
    private final float distance;
    private final Instance inst;
    private final int material;
    private final Vector3 normal;
    private final Vector3 position;

    public RayHitInfo(Instance inst, Vector3 position, Vector3 normal, float f, int i) {
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(normal, "normal");
        this.inst = inst;
        this.position = position;
        this.normal = normal;
        this.distance = f;
        this.material = i;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final Instance getInst() {
        return this.inst;
    }

    public final int getMaterial() {
        return this.material;
    }

    public final Vector3 getNormal() {
        return this.normal;
    }

    public final Vector3 getPosition() {
        return this.position;
    }
}
