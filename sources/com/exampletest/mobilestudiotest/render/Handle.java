package com.exampletest.mobilestudiotest.render;

import com.exampletest.mobilestudiotest.model.Vector3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SceneRenderer.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Handle;", "", "index", "", "axis", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "base", "tip", "radius", "", "<init>", "(ILcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;F)V", "getIndex", "()I", "getAxis", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getBase", "getTip", "getRadius", "()F", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Handle {
    private final Vector3 axis;
    private final Vector3 base;
    private final int index;
    private final float radius;
    private final Vector3 tip;

    public Handle(int i, Vector3 axis, Vector3 base, Vector3 tip, float f) {
        Intrinsics.checkNotNullParameter(axis, "axis");
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.index = i;
        this.axis = axis;
        this.base = base;
        this.tip = tip;
        this.radius = f;
    }

    public final Vector3 getAxis() {
        return this.axis;
    }

    public final Vector3 getBase() {
        return this.base;
    }

    public final int getIndex() {
        return this.index;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final Vector3 getTip() {
        return this.tip;
    }
}
