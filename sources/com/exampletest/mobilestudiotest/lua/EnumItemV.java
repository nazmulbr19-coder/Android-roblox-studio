package com.exampletest.mobilestudiotest.lua;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/EnumItemV;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "name", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getType", "()Ljava/lang/String;", "getName", "getValue", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnumItemV {
    private final String name;
    private final String type;
    private final int value;

    public EnumItemV(String type, String name, int i) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = type;
        this.name = name;
        this.value = i;
    }

    public static /* synthetic */ EnumItemV copy$default(EnumItemV enumItemV, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = enumItemV.type;
        }
        if ((i2 & 2) != 0) {
            str2 = enumItemV.name;
        }
        if ((i2 & 4) != 0) {
            i = enumItemV.value;
        }
        return enumItemV.copy(str, str2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final EnumItemV copy(String type, String name, int value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        return new EnumItemV(type, name, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnumItemV)) {
            return false;
        }
        EnumItemV enumItemV = (EnumItemV) other;
        return Intrinsics.areEqual(this.type, enumItemV.type) && Intrinsics.areEqual(this.name, enumItemV.name) && this.value == enumItemV.value;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.value);
    }

    public String toString() {
        return "EnumItemV(type=" + this.type + ", name=" + this.name + ", value=" + this.value + ")";
    }
}
