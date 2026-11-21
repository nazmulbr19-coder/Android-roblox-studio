package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003JO\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/PhysicalProps;", "", "flags", "", "density", "", "friction", "elasticity", "frictionWeight", "elasticityWeight", "acoustic", "<init>", "(IFFFFFF)V", "getFlags", "()I", "getDensity", "()F", "getFriction", "getElasticity", "getFrictionWeight", "getElasticityWeight", "getAcoustic", "custom", "", "getCustom", "()Z", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PhysicalProps {
    private final float acoustic;
    private final float density;
    private final float elasticity;
    private final float elasticityWeight;
    private final int flags;
    private final float friction;
    private final float frictionWeight;

    public PhysicalProps(int i, float f, float f2, float f3, float f4, float f5, float f6) {
        this.flags = i;
        this.density = f;
        this.friction = f2;
        this.elasticity = f3;
        this.frictionWeight = f4;
        this.elasticityWeight = f5;
        this.acoustic = f6;
    }

    public /* synthetic */ PhysicalProps(int i, float f, float f2, float f3, float f4, float f5, float f6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? 0.7f : f, (i2 & 4) != 0 ? 0.3f : f2, (i2 & 8) != 0 ? 0.5f : f3, (i2 & 16) != 0 ? 1.0f : f4, (i2 & 32) != 0 ? 1.0f : f5, (i2 & 64) == 0 ? f6 : 1.0f);
    }

    public static /* synthetic */ PhysicalProps copy$default(PhysicalProps physicalProps, int i, float f, float f2, float f3, float f4, float f5, float f6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = physicalProps.flags;
        }
        if ((i2 & 2) != 0) {
            f = physicalProps.density;
        }
        if ((i2 & 4) != 0) {
            f2 = physicalProps.friction;
        }
        if ((i2 & 8) != 0) {
            f3 = physicalProps.elasticity;
        }
        if ((i2 & 16) != 0) {
            f4 = physicalProps.frictionWeight;
        }
        if ((i2 & 32) != 0) {
            f5 = physicalProps.elasticityWeight;
        }
        if ((i2 & 64) != 0) {
            f6 = physicalProps.acoustic;
        }
        float f7 = f5;
        float f8 = f6;
        float f9 = f4;
        float f10 = f2;
        return physicalProps.copy(i, f, f10, f3, f9, f7, f8);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* renamed from: component2, reason: from getter */
    public final float getDensity() {
        return this.density;
    }

    /* renamed from: component3, reason: from getter */
    public final float getFriction() {
        return this.friction;
    }

    /* renamed from: component4, reason: from getter */
    public final float getElasticity() {
        return this.elasticity;
    }

    /* renamed from: component5, reason: from getter */
    public final float getFrictionWeight() {
        return this.frictionWeight;
    }

    /* renamed from: component6, reason: from getter */
    public final float getElasticityWeight() {
        return this.elasticityWeight;
    }

    /* renamed from: component7, reason: from getter */
    public final float getAcoustic() {
        return this.acoustic;
    }

    public final PhysicalProps copy(int flags, float density, float friction, float elasticity, float frictionWeight, float elasticityWeight, float acoustic) {
        return new PhysicalProps(flags, density, friction, elasticity, frictionWeight, elasticityWeight, acoustic);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhysicalProps)) {
            return false;
        }
        PhysicalProps physicalProps = (PhysicalProps) other;
        return this.flags == physicalProps.flags && Float.compare(this.density, physicalProps.density) == 0 && Float.compare(this.friction, physicalProps.friction) == 0 && Float.compare(this.elasticity, physicalProps.elasticity) == 0 && Float.compare(this.frictionWeight, physicalProps.frictionWeight) == 0 && Float.compare(this.elasticityWeight, physicalProps.elasticityWeight) == 0 && Float.compare(this.acoustic, physicalProps.acoustic) == 0;
    }

    public final float getAcoustic() {
        return this.acoustic;
    }

    public final boolean getCustom() {
        return (this.flags & 1) != 0;
    }

    public final float getDensity() {
        return this.density;
    }

    public final float getElasticity() {
        return this.elasticity;
    }

    public final float getElasticityWeight() {
        return this.elasticityWeight;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final float getFriction() {
        return this.friction;
    }

    public final float getFrictionWeight() {
        return this.frictionWeight;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.flags) * 31) + Float.hashCode(this.density)) * 31) + Float.hashCode(this.friction)) * 31) + Float.hashCode(this.elasticity)) * 31) + Float.hashCode(this.frictionWeight)) * 31) + Float.hashCode(this.elasticityWeight)) * 31) + Float.hashCode(this.acoustic);
    }

    public String toString() {
        if (!getCustom()) {
            return "Default";
        }
        return DataTypesKt.fmtNum(this.density) + ", " + DataTypesKt.fmtNum(this.friction) + ", " + DataTypesKt.fmtNum(this.elasticity);
    }
}
