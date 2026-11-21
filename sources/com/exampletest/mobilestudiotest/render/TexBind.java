package com.exampletest.mobilestudiotest.render;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* compiled from: StaticBatches.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/TexBind;", "", TypedValues.Custom.S_COLOR, "", "normal", "scale", "", "<init>", "(IIF)V", "getColor", "()I", "getNormal", "getScale", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class TexBind {
    private final int color;
    private final int normal;
    private final float scale;

    public TexBind(int i, int i2, float f) {
        this.color = i;
        this.normal = i2;
        this.scale = f;
    }

    public static /* synthetic */ TexBind copy$default(TexBind texBind, int i, int i2, float f, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = texBind.color;
        }
        if ((i3 & 2) != 0) {
            i2 = texBind.normal;
        }
        if ((i3 & 4) != 0) {
            f = texBind.scale;
        }
        return texBind.copy(i, i2, f);
    }

    /* renamed from: component1, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNormal() {
        return this.normal;
    }

    /* renamed from: component3, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    public final TexBind copy(int color, int normal, float scale) {
        return new TexBind(color, normal, scale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TexBind)) {
            return false;
        }
        TexBind texBind = (TexBind) other;
        return this.color == texBind.color && this.normal == texBind.normal && Float.compare(this.scale, texBind.scale) == 0;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getNormal() {
        return this.normal;
    }

    public final float getScale() {
        return this.scale;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.color) * 31) + Integer.hashCode(this.normal)) * 31) + Float.hashCode(this.scale);
    }

    public String toString() {
        return "TexBind(color=" + this.color + ", normal=" + this.normal + ", scale=" + this.scale + ")";
    }
}
