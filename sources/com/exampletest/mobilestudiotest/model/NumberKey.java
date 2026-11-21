package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/NumberKey;", "", "time", "", "value", "envelope", "<init>", "(FFF)V", "getTime", "()F", "getValue", "getEnvelope", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NumberKey {
    private final float envelope;
    private final float time;
    private final float value;

    public NumberKey(float f, float f2, float f3) {
        this.time = f;
        this.value = f2;
        this.envelope = f3;
    }

    public static /* synthetic */ NumberKey copy$default(NumberKey numberKey, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = numberKey.time;
        }
        if ((i & 2) != 0) {
            f2 = numberKey.value;
        }
        if ((i & 4) != 0) {
            f3 = numberKey.envelope;
        }
        return numberKey.copy(f, f2, f3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getTime() {
        return this.time;
    }

    /* renamed from: component2, reason: from getter */
    public final float getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final float getEnvelope() {
        return this.envelope;
    }

    public final NumberKey copy(float time, float value, float envelope) {
        return new NumberKey(time, value, envelope);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NumberKey)) {
            return false;
        }
        NumberKey numberKey = (NumberKey) other;
        return Float.compare(this.time, numberKey.time) == 0 && Float.compare(this.value, numberKey.value) == 0 && Float.compare(this.envelope, numberKey.envelope) == 0;
    }

    public final float getEnvelope() {
        return this.envelope;
    }

    public final float getTime() {
        return this.time;
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((Float.hashCode(this.time) * 31) + Float.hashCode(this.value)) * 31) + Float.hashCode(this.envelope);
    }

    public String toString() {
        return "NumberKey(time=" + this.time + ", value=" + this.value + ", envelope=" + this.envelope + ")";
    }
}
