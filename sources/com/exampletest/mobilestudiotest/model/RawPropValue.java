package com.exampletest.mobilestudiotest.model;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/RawPropValue;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "payload", "", "index", "count", "<init>", "(I[BII)V", "getType", "()I", "getPayload", "()[B", "getIndex", "getCount", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RawPropValue {
    private final int count;
    private final int index;
    private final byte[] payload;
    private final int type;

    public RawPropValue(int i, byte[] payload, int i2, int i3) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.type = i;
        this.payload = payload;
        this.index = i2;
        this.count = i3;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getIndex() {
        return this.index;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final int getType() {
        return this.type;
    }

    public String toString() {
        return "<unsupported type 0x" + Integer.toHexString(this.type) + ">";
    }
}
