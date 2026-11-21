package com.exampletest.mobilestudiotest.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 H2\u00020\u0001:\u0001HBy\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,J\u0011\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010-\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fH\u0086\u0002J\u0011\u00100\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u001fH\u0086\u0002J\u0011\u00101\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u001fH\u0086\u0002J\u000e\u00102\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fJ\u000e\u00103\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fJ\u000e\u00104\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fJ\u000e\u00105\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020\u0000J\u0006\u00107\u001a\u00020\u0000J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001fJ\u0006\u0010:\u001a\u00020\u001fJ\u0006\u0010;\u001a\u00020\u001fJ\u0006\u0010<\u001a\u00020=J\u0016\u0010>\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0003J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020=J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010E\u001a\u00020,H\u0016J\b\u0010F\u001a\u00020GH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b'\u0010!R\u0011\u0010(\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b)\u0010!¨\u0006I"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/CFrame;", "", "x", "", "y", "z", "r00", "r01", "r02", "r10", "r11", "r12", "r20", "r21", "r22", "<init>", "(FFFFFFFFFFFF)V", "getX", "()F", "getY", "getZ", "getR00", "getR01", "getR02", "getR10", "getR11", "getR12", "getR20", "getR21", "getR22", "position", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "getPosition", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "rightVector", "getRightVector", "upVector", "getUpVector", "backVector", "getBackVector", "lookVector", "getLookVector", "column", "i", "", "times", "o", "v", "plus", "minus", "vectorToWorld", "vectorToObject", "pointToObject", "pointToWorld", "inverse", "rotationOnly", "withPosition", "p", "toEulerXYZ", "toOrientation", "toQuaternion", "", "lerp", "t", "orthonormalize", "components", "equals", "", "other", "hashCode", "toString", "", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CFrame {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CFrame IDENTITY = new CFrame(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null);
    private final float r00;
    private final float r01;
    private final float r02;
    private final float r10;
    private final float r11;
    private final float r12;
    private final float r20;
    private final float r21;
    private final float r22;
    private final float x;
    private final float y;
    private final float z;

    /* compiled from: DataTypes.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ&\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0011J.\u0010\u001c\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011J \u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/CFrame$Companion;", "", "<init>", "()V", "IDENTITY", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "getIDENTITY", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "at", "p", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "fromColumns", "r", "u", "b", "rx", "a", "", "ry", "rz", "angles", "x", "y", "z", "fromOrientation", "fromAxisAngle", "axis", "angle", "fromQuaternion", "qx", "qy", "qz", "qw", "lookAt", "eye", TypedValues.AttributesType.S_TARGET, "up", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CFrame lookAt$default(Companion companion, Vector3 vector3, Vector3 vector32, Vector3 vector33, int i, Object obj) {
            if ((i & 4) != 0) {
                vector33 = Vector3.INSTANCE.getY();
            }
            return companion.lookAt(vector3, vector32, vector33);
        }

        public final CFrame angles(float x, float y, float z) {
            return rx(x).times(ry(y)).times(rz(z));
        }

        public final CFrame at(Vector3 p) {
            Intrinsics.checkNotNullParameter(p, "p");
            return new CFrame(p.getX(), p.getY(), p.getZ(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null);
        }

        public final CFrame fromAxisAngle(Vector3 axis, float angle) {
            Intrinsics.checkNotNullParameter(axis, "axis");
            Vector3 unit = axis.getUnit();
            float f = angle / 2.0f;
            float sin = (float) Math.sin(f);
            return fromQuaternion(Vector3.INSTANCE.getZERO(), unit.getX() * sin, unit.getY() * sin, unit.getZ() * sin, (float) Math.cos(f));
        }

        public final CFrame fromColumns(Vector3 p, Vector3 r, Vector3 u, Vector3 b) {
            Intrinsics.checkNotNullParameter(p, "p");
            Intrinsics.checkNotNullParameter(r, "r");
            Intrinsics.checkNotNullParameter(u, "u");
            Intrinsics.checkNotNullParameter(b, "b");
            return new CFrame(p.getX(), p.getY(), p.getZ(), r.getX(), u.getX(), b.getX(), r.getY(), u.getY(), b.getY(), r.getZ(), u.getZ(), b.getZ());
        }

        public final CFrame fromOrientation(float x, float y, float z) {
            return ry(y).times(rx(x)).times(rz(z));
        }

        public final CFrame fromQuaternion(Vector3 p, float qx, float qy, float qz, float qw) {
            Intrinsics.checkNotNullParameter(p, "p");
            float sqrt = (float) Math.sqrt((qx * qx) + (qy * qy) + (qz * qz) + (qw * qw));
            if (sqrt < 1.0E-9f) {
                sqrt = 1.0f;
            }
            float f = qx / sqrt;
            float f2 = qy / sqrt;
            float f3 = qz / sqrt;
            float f4 = qw / sqrt;
            return new CFrame(p.getX(), p.getY(), p.getZ(), 1.0f - (((f2 * f2) + (f3 * f3)) * 2.0f), ((f * f2) - (f3 * f4)) * 2.0f, ((f * f3) + (f2 * f4)) * 2.0f, ((f * f2) + (f3 * f4)) * 2.0f, 1.0f - (((f * f) + (f3 * f3)) * 2.0f), ((f2 * f3) - (f * f4)) * 2.0f, ((f * f3) - (f2 * f4)) * 2.0f, ((f2 * f3) + (f * f4)) * 2.0f, 1.0f - (2.0f * ((f * f) + (f2 * f2))));
        }

        public final CFrame getIDENTITY() {
            return CFrame.access$getIDENTITY$cp();
        }

        public final CFrame lookAt(Vector3 eye, Vector3 target, Vector3 up) {
            Intrinsics.checkNotNullParameter(eye, "eye");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(up, "up");
            Vector3 unit = target.minus(eye).getUnit();
            if (unit.getMagnitude() < 1.0E-6f) {
                return at(eye);
            }
            Vector3 unaryMinus = unit.unaryMinus();
            Vector3 unit2 = up.cross(unaryMinus).getUnit();
            if (unit2.getMagnitude() < 1.0E-6f) {
                unit2 = Vector3.INSTANCE.getX();
            }
            return fromColumns(eye, unit2, unaryMinus.cross(unit2).getUnit(), unaryMinus);
        }

        public final CFrame rx(float a) {
            float cos = (float) Math.cos(a);
            float sin = (float) Math.sin(a);
            return new CFrame(0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, cos, -sin, 0.0f, sin, cos);
        }

        public final CFrame ry(float a) {
            float cos = (float) Math.cos(a);
            float sin = (float) Math.sin(a);
            return new CFrame(0.0f, 0.0f, 0.0f, cos, 0.0f, sin, 0.0f, 1.0f, 0.0f, -sin, 0.0f, cos);
        }

        public final CFrame rz(float a) {
            float cos = (float) Math.cos(a);
            float sin = (float) Math.sin(a);
            return new CFrame(0.0f, 0.0f, 0.0f, cos, -sin, 0.0f, sin, cos, 0.0f, 0.0f, 0.0f, 1.0f);
        }
    }

    public CFrame(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.r00 = f4;
        this.r01 = f5;
        this.r02 = f6;
        this.r10 = f7;
        this.r11 = f8;
        this.r12 = f9;
        this.r20 = f10;
        this.r21 = f11;
        this.r22 = f12;
    }

    public /* synthetic */ CFrame(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, (i & 8) != 0 ? 1.0f : f4, (i & 16) != 0 ? 0.0f : f5, (i & 32) != 0 ? 0.0f : f6, (i & 64) != 0 ? 0.0f : f7, (i & 128) != 0 ? 1.0f : f8, (i & 256) != 0 ? 0.0f : f9, (i & 512) != 0 ? 0.0f : f10, (i & 1024) != 0 ? 0.0f : f11, (i & 2048) != 0 ? 1.0f : f12);
    }

    public static final /* synthetic */ CFrame access$getIDENTITY$cp() {
        return IDENTITY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence toString$lambda$0(float f) {
        return DataTypesKt.fmtNum(f);
    }

    public final Vector3 column(int i) {
        switch (i) {
            case 0:
                return getRightVector();
            case 1:
                return getUpVector();
            default:
                return getBackVector();
        }
    }

    public final float[] components() {
        return new float[]{this.x, this.y, this.z, this.r00, this.r01, this.r02, this.r10, this.r11, this.r12, this.r20, this.r21, this.r22};
    }

    public boolean equals(Object other) {
        return (other instanceof CFrame) && Arrays.equals(components(), ((CFrame) other).components());
    }

    public final Vector3 getBackVector() {
        return new Vector3(this.r02, this.r12, this.r22);
    }

    public final Vector3 getLookVector() {
        return new Vector3(-this.r02, -this.r12, -this.r22);
    }

    public final Vector3 getPosition() {
        return new Vector3(this.x, this.y, this.z);
    }

    public final float getR00() {
        return this.r00;
    }

    public final float getR01() {
        return this.r01;
    }

    public final float getR02() {
        return this.r02;
    }

    public final float getR10() {
        return this.r10;
    }

    public final float getR11() {
        return this.r11;
    }

    public final float getR12() {
        return this.r12;
    }

    public final float getR20() {
        return this.r20;
    }

    public final float getR21() {
        return this.r21;
    }

    public final float getR22() {
        return this.r22;
    }

    public final Vector3 getRightVector() {
        return new Vector3(this.r00, this.r10, this.r20);
    }

    public final Vector3 getUpVector() {
        return new Vector3(this.r01, this.r11, this.r21);
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getZ() {
        return this.z;
    }

    public int hashCode() {
        return Arrays.hashCode(components());
    }

    public final CFrame inverse() {
        Vector3 vectorToObject = vectorToObject(getPosition().unaryMinus());
        return new CFrame(vectorToObject.getX(), vectorToObject.getY(), vectorToObject.getZ(), this.r00, this.r10, this.r20, this.r01, this.r11, this.r21, this.r02, this.r12, this.r22);
    }

    public final CFrame lerp(CFrame o, float t) {
        Intrinsics.checkNotNullParameter(o, "o");
        float[] quaternion = toQuaternion();
        float[] quaternion2 = o.toQuaternion();
        float f = (quaternion[0] * quaternion2[0]) + (quaternion[1] * quaternion2[1]) + (quaternion[2] * quaternion2[2]) + (quaternion[3] * quaternion2[3]);
        if (f < 0.0f) {
            for (int i = 0; i < 4; i++) {
                quaternion2[i] = -quaternion2[i];
            }
            f = -f;
        }
        float[] fArr = new float[4];
        if (f > 0.9995f) {
            for (int i2 = 0; i2 < 4; i2++) {
                fArr[i2] = quaternion[i2] + ((quaternion2[i2] - quaternion[i2]) * t);
            }
        } else {
            float sin = (float) Math.sin((float) Math.acos(RangesKt.coerceIn(f, -1.0f, 1.0f)));
            float sin2 = ((float) Math.sin((1.0f - t) * r11)) / sin;
            float sin3 = ((float) Math.sin(t * r11)) / sin;
            for (int i3 = 0; i3 < 4; i3++) {
                fArr[i3] = (quaternion[i3] * sin2) + (quaternion2[i3] * sin3);
            }
        }
        return INSTANCE.fromQuaternion(getPosition().lerp(o.getPosition(), t), fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    public final CFrame minus(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return new CFrame(this.x - v.getX(), this.y - v.getY(), this.z - v.getZ(), this.r00, this.r01, this.r02, this.r10, this.r11, this.r12, this.r20, this.r21, this.r22);
    }

    public final CFrame orthonormalize() {
        Vector3 unit = getRightVector().getUnit();
        Vector3 upVector = getUpVector();
        Vector3 unit2 = upVector.minus(unit.times(unit.dot(upVector))).getUnit();
        return INSTANCE.fromColumns(getPosition(), unit, unit2, unit.cross(unit2));
    }

    public final CFrame plus(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return new CFrame(v.getX() + this.x, v.getY() + this.y, v.getZ() + this.z, this.r00, this.r01, this.r02, this.r10, this.r11, this.r12, this.r20, this.r21, this.r22);
    }

    public final Vector3 pointToObject(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return vectorToObject(v.minus(getPosition()));
    }

    public final Vector3 pointToWorld(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return times(v);
    }

    public final CFrame rotationOnly() {
        return new CFrame(0.0f, 0.0f, 0.0f, this.r00, this.r01, this.r02, this.r10, this.r11, this.r12, this.r20, this.r21, this.r22);
    }

    public final CFrame times(CFrame o) {
        Intrinsics.checkNotNullParameter(o, "o");
        float f = (this.r00 * o.r00) + (this.r01 * o.r10) + (this.r02 * o.r20);
        float f2 = (this.r00 * o.r01) + (this.r01 * o.r11) + (this.r02 * o.r21);
        float f3 = (this.r00 * o.r02) + (this.r01 * o.r12) + (this.r02 * o.r22);
        float f4 = (this.r10 * o.r00) + (this.r11 * o.r10) + (this.r12 * o.r20);
        float f5 = (this.r10 * o.r01) + (this.r11 * o.r11) + (this.r12 * o.r21);
        float f6 = (this.r10 * o.r02) + (this.r11 * o.r12) + (this.r12 * o.r22);
        float f7 = (this.r20 * o.r00) + (this.r21 * o.r10) + (this.r22 * o.r20);
        float f8 = (this.r20 * o.r01) + (this.r21 * o.r11) + (this.r22 * o.r21);
        float f9 = (this.r20 * o.r02) + (this.r21 * o.r12) + (this.r22 * o.r22);
        Vector3 times = times(o.getPosition());
        return new CFrame(times.getX(), times.getY(), times.getZ(), f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public final Vector3 times(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return vectorToWorld(v).plus(getPosition());
    }

    public final Vector3 toEulerXYZ() {
        float atan2;
        float f;
        float asin = (float) Math.asin(RangesKt.coerceIn(this.r02, -1.0f, 1.0f));
        if (Math.abs(this.r02) < 0.99999f) {
            atan2 = (float) Math.atan2(-this.r12, this.r22);
            f = (float) Math.atan2(-this.r01, this.r00);
        } else {
            atan2 = (float) Math.atan2(this.r21, this.r11);
            f = 0.0f;
        }
        return new Vector3(atan2, asin, f);
    }

    public final Vector3 toOrientation() {
        float atan2;
        float f;
        float asin = (float) Math.asin(RangesKt.coerceIn(-this.r12, -1.0f, 1.0f));
        if (Math.abs(this.r12) < 0.99999f) {
            atan2 = (float) Math.atan2(this.r02, this.r22);
            f = (float) Math.atan2(this.r10, this.r11);
        } else {
            atan2 = (float) Math.atan2(-this.r20, this.r00);
            f = 0.0f;
        }
        return new Vector3(asin, atan2, f);
    }

    public final float[] toQuaternion() {
        float[] fArr = new float[4];
        if (this.r00 + this.r11 + this.r22 > 0.0f) {
            float sqrt = ((float) Math.sqrt(1.0f + r0)) * 2.0f;
            fArr[3] = 0.25f * sqrt;
            fArr[0] = (this.r21 - this.r12) / sqrt;
            fArr[1] = (this.r02 - this.r20) / sqrt;
            fArr[2] = (this.r10 - this.r01) / sqrt;
        } else if (this.r00 > this.r11 && this.r00 > this.r22) {
            float sqrt2 = ((float) Math.sqrt(((this.r00 + 1.0f) - this.r11) - this.r22)) * 2.0f;
            fArr[3] = (this.r21 - this.r12) / sqrt2;
            fArr[0] = 0.25f * sqrt2;
            fArr[1] = (this.r01 + this.r10) / sqrt2;
            fArr[2] = (this.r02 + this.r20) / sqrt2;
        } else if (this.r11 > this.r22) {
            float sqrt3 = ((float) Math.sqrt(((this.r11 + 1.0f) - this.r00) - this.r22)) * 2.0f;
            fArr[3] = (this.r02 - this.r20) / sqrt3;
            fArr[0] = (this.r01 + this.r10) / sqrt3;
            fArr[1] = 0.25f * sqrt3;
            fArr[2] = (this.r12 + this.r21) / sqrt3;
        } else {
            float sqrt4 = ((float) Math.sqrt(((this.r22 + 1.0f) - this.r00) - this.r11)) * 2.0f;
            fArr[3] = (this.r10 - this.r01) / sqrt4;
            fArr[0] = (this.r02 + this.r20) / sqrt4;
            fArr[1] = (this.r12 + this.r21) / sqrt4;
            fArr[2] = 0.25f * sqrt4;
        }
        return fArr;
    }

    public String toString() {
        return ArraysKt.joinToString$default(components(), (CharSequence) ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new CFrame$$ExternalSyntheticLambda0(), 30, (Object) null);
    }

    public final Vector3 vectorToObject(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return new Vector3((this.r00 * v.getX()) + (this.r10 * v.getY()) + (this.r20 * v.getZ()), (this.r01 * v.getX()) + (this.r11 * v.getY()) + (this.r21 * v.getZ()), (this.r02 * v.getX()) + (this.r12 * v.getY()) + (this.r22 * v.getZ()));
    }

    public final Vector3 vectorToWorld(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return new Vector3((this.r00 * v.getX()) + (this.r01 * v.getY()) + (this.r02 * v.getZ()), (this.r10 * v.getX()) + (this.r11 * v.getY()) + (this.r12 * v.getZ()), (this.r20 * v.getX()) + (this.r21 * v.getY()) + (this.r22 * v.getZ()));
    }

    public final CFrame withPosition(Vector3 p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return new CFrame(p.getX(), p.getY(), p.getZ(), this.r00, this.r01, this.r02, this.r10, this.r11, this.r12, this.r20, this.r21, this.r22);
    }
}
