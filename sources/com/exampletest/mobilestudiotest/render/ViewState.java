package com.exampletest.mobilestudiotest.render;

import android.opengl.Matrix;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.Vector3;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Camera.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\u0018J\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180-2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001eJ\u000e\u00100\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/ViewState;", "", "<init>", "()V", "view", "", "getView", "()[F", "proj", "getProj", "vp", "getVp", "invVp", "getInvVp", "width", "", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "camPos", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "getCamPos", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "setCamPos", "(Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "near", "", "getNear", "()F", "setNear", "(F)V", "update", "", "eye", TypedValues.AttributesType.S_TARGET, "fov", "w", "h", "project", "p", "screenRay", "Lkotlin/Pair;", "x", "y", "distTo", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ViewState {
    private final float[] view = new float[16];
    private final float[] proj = new float[16];
    private final float[] vp = new float[16];
    private final float[] invVp = new float[16];
    private int width = 1;
    private int height = 1;
    private Vector3 camPos = Vector3.INSTANCE.getZERO();
    private float near = 0.3f;

    private static final Vector3 screenRay$un(ViewState viewState, float f, float f2, float f3) {
        float[] fArr = new float[4];
        Matrix.multiplyMV(fArr, 0, viewState.invVp, 0, new float[]{f, f2, f3, 1.0f}, 0);
        return new Vector3(fArr[0] / fArr[3], fArr[1] / fArr[3], fArr[2] / fArr[3]);
    }

    public static /* synthetic */ void update$default(ViewState viewState, Vector3 vector3, Vector3 vector32, float f, int i, int i2, float f2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            f2 = 0.3f;
        }
        viewState.update(vector3, vector32, f, i, i2, f2);
    }

    public final float distTo(Vector3 p) {
        Intrinsics.checkNotNullParameter(p, "p");
        Vector3 minus = p.minus(this.camPos);
        return (float) Math.sqrt(minus.dot(minus));
    }

    public final Vector3 getCamPos() {
        return this.camPos;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float[] getInvVp() {
        return this.invVp;
    }

    public final float getNear() {
        return this.near;
    }

    public final float[] getProj() {
        return this.proj;
    }

    public final float[] getView() {
        return this.view;
    }

    public final float[] getVp() {
        return this.vp;
    }

    public final int getWidth() {
        return this.width;
    }

    public final float[] project(Vector3 p) {
        Intrinsics.checkNotNullParameter(p, "p");
        float[] fArr = new float[4];
        Matrix.multiplyMV(fArr, 0, this.vp, 0, new float[]{p.getX(), p.getY(), p.getZ(), 1.0f}, 0);
        if (fArr[3] <= 0.01f) {
            return null;
        }
        return new float[]{(((fArr[0] / fArr[3]) * 0.5f) + 0.5f) * this.width, (1.0f - (((fArr[1] / fArr[3]) * 0.5f) + 0.5f)) * this.height, fArr[2] / fArr[3]};
    }

    public final Pair<Vector3, Vector3> screenRay(float x, float y) {
        float f = ((x / this.width) * 2.0f) - 1.0f;
        float f2 = 1.0f - ((y / this.height) * 2.0f);
        return TuplesKt.to(this.camPos, screenRay$un(this, f, f2, 1.0f).minus(screenRay$un(this, f, f2, -1.0f)).getUnit());
    }

    public final void setCamPos(Vector3 vector3) {
        Intrinsics.checkNotNullParameter(vector3, "<set-?>");
        this.camPos = vector3;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setNear(float f) {
        this.near = f;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final void update(Vector3 eye, Vector3 target, float fov, int w, int h, float near) {
        Intrinsics.checkNotNullParameter(eye, "eye");
        Intrinsics.checkNotNullParameter(target, "target");
        this.width = Math.max(w, 1);
        this.height = Math.max(h, 1);
        this.camPos = eye;
        this.near = near;
        Vector3 z = Math.abs(target.minus(eye).getUnit().getY()) > 0.999f ? Vector3.INSTANCE.getZ() : Vector3.INSTANCE.getY();
        Matrix.setLookAtM(this.view, 0, eye.getX(), eye.getY(), eye.getZ(), target.getX(), target.getY(), target.getZ(), z.getX(), z.getY(), z.getZ());
        Matrix.perspectiveM(this.proj, 0, fov, this.width / this.height, near, 10000.0f);
        Matrix.multiplyMM(this.vp, 0, this.proj, 0, this.view, 0);
        Matrix.invertM(this.invVp, 0, this.vp, 0);
    }
}
