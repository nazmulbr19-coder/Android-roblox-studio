package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.model.CFrame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: KeyframeAnim.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Quat;", "", "<init>", "()V", "of", "", "cf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "norm", "q", "slerp", "a", "b0", "t", "", "toCFrame", "x", "y", "z", "lerp", "b", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class Quat {
    public static final Quat INSTANCE = new Quat();

    private Quat() {
    }

    private final float[] norm(float[] q) {
        float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.sqrt((q[0] * q[0]) + (q[1] * q[1]) + (q[2] * q[2]) + (q[3] * q[3])), 1.0E-9f);
        for (int i = 0; i < 4; i++) {
            q[i] = q[i] / coerceAtLeast;
        }
        return q;
    }

    public final CFrame lerp(CFrame a, CFrame b, float t) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return t <= 0.0f ? a : t >= 1.0f ? b : toCFrame(slerp(of(a), of(b), t), a.getX() + ((b.getX() - a.getX()) * t), a.getY() + ((b.getY() - a.getY()) * t), a.getZ() + ((b.getZ() - a.getZ()) * t));
    }

    public final float[] of(CFrame cf) {
        Intrinsics.checkNotNullParameter(cf, "cf");
        float r00 = cf.getR00();
        float r01 = cf.getR01();
        float r02 = cf.getR02();
        float r10 = cf.getR10();
        float r11 = cf.getR11();
        float r12 = cf.getR12();
        float r20 = cf.getR20();
        float r21 = cf.getR21();
        float r22 = cf.getR22();
        float[] fArr = new float[4];
        if (r00 + r11 + r22 > 0.0f) {
            float sqrt = ((float) Math.sqrt(r10 + 1.0f)) * 2.0f;
            fArr[3] = 0.25f * sqrt;
            fArr[0] = (r21 - r12) / sqrt;
            fArr[1] = (r02 - r20) / sqrt;
            fArr[2] = (r10 - r01) / sqrt;
        } else if (r00 > r11 && r00 > r22) {
            float sqrt2 = ((float) Math.sqrt(((r00 + 1.0f) - r11) - r22)) * 2.0f;
            fArr[3] = (r21 - r12) / sqrt2;
            fArr[0] = 0.25f * sqrt2;
            fArr[1] = (r01 + r10) / sqrt2;
            fArr[2] = (r02 + r20) / sqrt2;
        } else if (r11 > r22) {
            float sqrt3 = ((float) Math.sqrt(((r11 + 1.0f) - r00) - r22)) * 2.0f;
            fArr[3] = (r02 - r20) / sqrt3;
            fArr[0] = (r01 + r10) / sqrt3;
            fArr[1] = 0.25f * sqrt3;
            fArr[2] = (r12 + r21) / sqrt3;
        } else {
            float sqrt4 = ((float) Math.sqrt(((r22 + 1.0f) - r00) - r11)) * 2.0f;
            fArr[3] = (r10 - r01) / sqrt4;
            fArr[0] = (r02 + r20) / sqrt4;
            fArr[1] = (r12 + r21) / sqrt4;
            fArr[2] = 0.25f * sqrt4;
        }
        return norm(fArr);
    }

    public final float[] slerp(float[] a, float[] b0, float t) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b0, "b0");
        float[] fArr = b0;
        int i = 0;
        float f = (a[0] * fArr[0]) + (a[1] * fArr[1]) + (a[2] * fArr[2]) + (a[3] * fArr[3]);
        if (f < 0.0f) {
            fArr = new float[]{-fArr[0], -fArr[1], -fArr[2], -fArr[3]};
            f = -f;
        }
        if (f > 0.9995f) {
            float[] fArr2 = new float[4];
            while (i < 4) {
                fArr2[i] = a[i] + ((fArr[i] - a[i]) * t);
                i++;
            }
            return norm(fArr2);
        }
        float sin = (float) Math.sin((float) Math.acos(RangesKt.coerceIn(f, -1.0f, 1.0f)));
        float sin2 = ((float) Math.sin((1.0f - t) * r3)) / sin;
        float sin3 = ((float) Math.sin(t * r3)) / sin;
        float[] fArr3 = new float[4];
        while (i < 4) {
            fArr3[i] = (a[i] * sin2) + (fArr[i] * sin3);
            i++;
        }
        return fArr3;
    }

    public final CFrame toCFrame(float[] q, float x, float y, float z) {
        Intrinsics.checkNotNullParameter(q, "q");
        float f = q[0];
        float f2 = q[1];
        float f3 = q[2];
        float f4 = q[3];
        return new CFrame(x, y, z, 1.0f - (((f2 * f2) + (f3 * f3)) * 2.0f), 2.0f * ((f * f2) - (f3 * f4)), 2.0f * ((f * f3) + (f2 * f4)), 2.0f * ((f * f2) + (f3 * f4)), 1.0f - (((f * f) + (f3 * f3)) * 2.0f), 2.0f * ((f2 * f3) - (f * f4)), 2.0f * ((f * f3) - (f2 * f4)), 2.0f * ((f2 * f3) + (f * f4)), 1.0f - (2.0f * ((f * f) + (f2 * f2))));
    }
}
