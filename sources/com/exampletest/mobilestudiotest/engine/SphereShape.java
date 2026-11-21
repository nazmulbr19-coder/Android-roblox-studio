package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Geometry.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/SphereShape;", "Lcom/exampletest/mobilestudiotest/engine/ConvexShape;", "c", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "r", "", "axes", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Vector3;FLjava/util/List;)V", "getR", "()F", "project", "Lkotlin/Pair;", "axis", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SphereShape extends ConvexShape {
    private final float r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SphereShape(Vector3 c, float f, List<Vector3> axes) {
        super(CollectionsKt.listOf(c), axes, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(axes, "axes");
        this.r = f;
    }

    public final float getR() {
        return this.r;
    }

    @Override // com.exampletest.mobilestudiotest.engine.ConvexShape
    public Pair<Float, Float> project(Vector3 axis) {
        Intrinsics.checkNotNullParameter(axis, "axis");
        float dot = getCenter().dot(axis);
        float magnitude = axis.getMagnitude();
        return TuplesKt.to(Float.valueOf(dot - (this.r * magnitude)), Float.valueOf((this.r * magnitude) + dot));
    }
}
