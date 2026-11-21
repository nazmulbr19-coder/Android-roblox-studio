package com.exampletest.mobilestudiotest.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: StaticBatches.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ6\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Frustum;", "", "<init>", "()V", "p", "", "set", "", "m", "sphere", "", "x", "", "y", "z", "r", "box", "x0", "y0", "z0", "x1", "y1", "z1", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Frustum {
    private final float[] p = new float[24];

    public final boolean box(float x0, float y0, float z0, float x1, float y1, float z1) {
        for (int i = 0; i < 24; i += 4) {
            float f = this.p[i];
            float f2 = this.p[i + 1];
            float f3 = this.p[i + 2];
            if ((f * (f >= 0.0f ? x1 : x0)) + (f2 * (f2 >= 0.0f ? y1 : y0)) + (f3 * (f3 >= 0.0f ? z1 : z0)) + this.p[i + 3] < 0.0f) {
                return false;
            }
        }
        return true;
    }

    public final void set(float[] m) {
        Intrinsics.checkNotNullParameter(m, "m");
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = 0;
            while (i3 < 2) {
                float f = i3 == 0 ? 1.0f : -1.0f;
                float f2 = m[3] + (m[i2] * f);
                float f3 = m[7] + (m[i2 + 4] * f);
                float f4 = m[11] + (m[i2 + 8] * f);
                float f5 = m[15] + (m[i2 + 12] * f);
                float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4)), 1.0E-9f);
                this.p[i] = f2 / coerceAtLeast;
                this.p[i + 1] = f3 / coerceAtLeast;
                this.p[i + 2] = f4 / coerceAtLeast;
                this.p[i + 3] = f5 / coerceAtLeast;
                i += 4;
                i3++;
            }
        }
    }

    public final boolean sphere(float x, float y, float z, float r) {
        for (int i = 0; i < 24; i += 4) {
            if ((this.p[i] * x) + (this.p[i + 1] * y) + (this.p[i + 2] * z) + this.p[i + 3] < (-r)) {
                return false;
            }
        }
        return true;
    }
}
