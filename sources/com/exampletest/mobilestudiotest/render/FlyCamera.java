package com.exampletest.mobilestudiotest.render;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Vector3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Camera.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001dJ\u0016\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bJ\u0016\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007¨\u0006)"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/FlyCamera;", "", "<init>", "()V", "pos", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "getPos", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "setPos", "(Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "yaw", "", "getYaw", "()F", "setYaw", "(F)V", "pitch", "getPitch", "setPitch", "fov", "getFov", "setFov", "forward", "getForward", "right", "getRight", "up", "getUp", "cframe", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "lookAt", "", TypedValues.AttributesType.S_TARGET, "setFromCFrame", "cf", "rotate", "dYaw", "dPitch", "focusOn", "center", "radius", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FlyCamera {
    private float yaw;
    private Vector3 pos = new Vector3(0.0f, 20.0f, 40.0f);
    private float pitch = -0.4f;
    private float fov = 70.0f;

    public final CFrame cframe() {
        return CFrame.Companion.lookAt$default(CFrame.INSTANCE, this.pos, this.pos.plus(getForward()), null, 4, null);
    }

    public final void focusOn(Vector3 center, float radius) {
        Intrinsics.checkNotNullParameter(center, "center");
        this.pos = center.minus(getForward().times(RangesKt.coerceAtLeast(2.2f * radius, 6.0f)));
    }

    public final Vector3 getForward() {
        return new Vector3((-((float) Math.sin(this.yaw))) * ((float) Math.cos(this.pitch)), (float) Math.sin(this.pitch), (-((float) Math.cos(this.yaw))) * ((float) Math.cos(this.pitch)));
    }

    public final float getFov() {
        return this.fov;
    }

    public final float getPitch() {
        return this.pitch;
    }

    public final Vector3 getPos() {
        return this.pos;
    }

    public final Vector3 getRight() {
        return new Vector3((float) Math.cos(this.yaw), 0.0f, -((float) Math.sin(this.yaw)));
    }

    public final Vector3 getUp() {
        return getRight().cross(getForward()).getUnit();
    }

    public final float getYaw() {
        return this.yaw;
    }

    public final void lookAt(Vector3 target) {
        Intrinsics.checkNotNullParameter(target, "target");
        Vector3 unit = target.minus(this.pos).getUnit();
        this.pitch = (float) Math.asin(RangesKt.coerceIn(unit.getY(), -1.0f, 1.0f));
        this.yaw = (float) Math.atan2(-unit.getX(), -unit.getZ());
    }

    public final void rotate(float dYaw, float dPitch) {
        this.yaw += dYaw;
        this.pitch = RangesKt.coerceIn(this.pitch + dPitch, -1.55f, 1.55f);
    }

    public final void setFov(float f) {
        this.fov = f;
    }

    public final void setFromCFrame(CFrame cf) {
        Intrinsics.checkNotNullParameter(cf, "cf");
        this.pos = cf.getPosition();
        lookAt(cf.getPosition().plus(cf.getLookVector()));
    }

    public final void setPitch(float f) {
        this.pitch = f;
    }

    public final void setPos(Vector3 vector3) {
        Intrinsics.checkNotNullParameter(vector3, "<set-?>");
        this.pos = vector3;
    }

    public final void setYaw(float f) {
        this.yaw = f;
    }
}
