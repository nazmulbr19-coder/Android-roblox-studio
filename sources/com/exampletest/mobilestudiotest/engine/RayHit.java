package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.Vector3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Geometry.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/RayHit;", "", "part", "Lcom/exampletest/mobilestudiotest/model/Instance;", "t", "", "position", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "normal", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;FLcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getPart", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getT", "()F", "getPosition", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getNormal", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class RayHit {
    private final Vector3 normal;
    private final Instance part;
    private final Vector3 position;
    private final float t;

    public RayHit(Instance part, float f, Vector3 position, Vector3 normal) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(normal, "normal");
        this.part = part;
        this.t = f;
        this.position = position;
        this.normal = normal;
    }

    public final Vector3 getNormal() {
        return this.normal;
    }

    public final Instance getPart() {
        return this.part;
    }

    public final Vector3 getPosition() {
        return this.position;
    }

    public final float getT() {
        return this.t;
    }
}
