package com.exampletest.mobilestudiotest.render;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Meshes.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Mesh;", "", "vbo", "", "count", "mode", "stride", "cpu", "", "<init>", "(IIII[F)V", "getVbo", "()I", "getCount", "getMode", "getStride", "getCpu", "()[F", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Mesh {
    private final int count;
    private final float[] cpu;
    private final int mode;
    private final int stride;
    private final int vbo;

    public Mesh(int i, int i2, int i3, int i4, float[] fArr) {
        this.vbo = i;
        this.count = i2;
        this.mode = i3;
        this.stride = i4;
        this.cpu = fArr;
    }

    public /* synthetic */ Mesh(int i, int i2, int i3, int i4, float[] fArr, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i5 & 8) != 0 ? 6 : i4, (i5 & 16) != 0 ? null : fArr);
    }

    public final int getCount() {
        return this.count;
    }

    public final float[] getCpu() {
        return this.cpu;
    }

    public final int getMode() {
        return this.mode;
    }

    public final int getStride() {
        return this.stride;
    }

    public final int getVbo() {
        return this.vbo;
    }
}
