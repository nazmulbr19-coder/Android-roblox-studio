package com.exampletest.mobilestudiotest.render;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Vector3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticBatches.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"¨\u00062"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/BatchSpec;", "", "mesh", "", "cube", "", "cf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "scale", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "r", "", "g", "b", "emissive", "mat", "surfA", "surfB", "kind", "", "tex", "Lcom/exampletest/mobilestudiotest/render/TexBind;", "pending", "stride", TypedValues.CycleType.S_WAVE_OFFSET, "<init>", "([FZLcom/exampletest/mobilestudiotest/model/CFrame;Lcom/exampletest/mobilestudiotest/model/Vector3;FFFZ[FLcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;ILcom/exampletest/mobilestudiotest/render/TexBind;ZILcom/exampletest/mobilestudiotest/model/Vector3;)V", "getMesh", "()[F", "getCube", "()Z", "getCf", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "getScale", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getR", "()F", "getG", "getB", "getEmissive", "getMat", "getSurfA", "getSurfB", "getKind", "()I", "getTex", "()Lcom/exampletest/mobilestudiotest/render/TexBind;", "getPending", "getStride", "getOffset", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BatchSpec {
    private final float b;
    private final CFrame cf;
    private final boolean cube;
    private final boolean emissive;
    private final float g;
    private final int kind;
    private final float[] mat;
    private final float[] mesh;
    private final Vector3 offset;
    private final boolean pending;
    private final float r;
    private final Vector3 scale;
    private final int stride;
    private final Vector3 surfA;
    private final Vector3 surfB;
    private final TexBind tex;

    public BatchSpec(float[] mesh, boolean z, CFrame cf, Vector3 scale, float f, float f2, float f3, boolean z2, float[] mat, Vector3 vector3, Vector3 vector32, int i, TexBind texBind, boolean z3, int i2, Vector3 offset) {
        Intrinsics.checkNotNullParameter(mesh, "mesh");
        Intrinsics.checkNotNullParameter(cf, "cf");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(mat, "mat");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.mesh = mesh;
        this.cube = z;
        this.cf = cf;
        this.scale = scale;
        this.r = f;
        this.g = f2;
        this.b = f3;
        this.emissive = z2;
        this.mat = mat;
        this.surfA = vector3;
        this.surfB = vector32;
        this.kind = i;
        this.tex = texBind;
        this.pending = z3;
        this.stride = i2;
        this.offset = offset;
    }

    public /* synthetic */ BatchSpec(float[] fArr, boolean z, CFrame cFrame, Vector3 vector3, float f, float f2, float f3, boolean z2, float[] fArr2, Vector3 vector32, Vector3 vector33, int i, TexBind texBind, boolean z3, int i2, Vector3 vector34, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr, z, cFrame, vector3, f, f2, f3, z2, fArr2, vector32, vector33, i, texBind, z3, (i3 & 16384) != 0 ? 6 : i2, (i3 & 32768) != 0 ? Vector3.INSTANCE.getZERO() : vector34);
    }

    public final float getB() {
        return this.b;
    }

    public final CFrame getCf() {
        return this.cf;
    }

    public final boolean getCube() {
        return this.cube;
    }

    public final boolean getEmissive() {
        return this.emissive;
    }

    public final float getG() {
        return this.g;
    }

    public final int getKind() {
        return this.kind;
    }

    public final float[] getMat() {
        return this.mat;
    }

    public final float[] getMesh() {
        return this.mesh;
    }

    public final Vector3 getOffset() {
        return this.offset;
    }

    public final boolean getPending() {
        return this.pending;
    }

    public final float getR() {
        return this.r;
    }

    public final Vector3 getScale() {
        return this.scale;
    }

    public final int getStride() {
        return this.stride;
    }

    public final Vector3 getSurfA() {
        return this.surfA;
    }

    public final Vector3 getSurfB() {
        return this.surfB;
    }

    public final TexBind getTex() {
        return this.tex;
    }
}
