package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/OptionalCFrame;", "", "cframe", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "<init>", "(Lcom/exampletest/mobilestudiotest/model/CFrame;)V", "getCframe", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "toString", "", "component1", "copy", "equals", "", "other", "hashCode", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OptionalCFrame {
    private final CFrame cframe;

    public OptionalCFrame(CFrame cFrame) {
        this.cframe = cFrame;
    }

    public static /* synthetic */ OptionalCFrame copy$default(OptionalCFrame optionalCFrame, CFrame cFrame, int i, Object obj) {
        if ((i & 1) != 0) {
            cFrame = optionalCFrame.cframe;
        }
        return optionalCFrame.copy(cFrame);
    }

    /* renamed from: component1, reason: from getter */
    public final CFrame getCframe() {
        return this.cframe;
    }

    public final OptionalCFrame copy(CFrame cframe) {
        return new OptionalCFrame(cframe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OptionalCFrame) && Intrinsics.areEqual(this.cframe, ((OptionalCFrame) other).cframe);
    }

    public final CFrame getCframe() {
        return this.cframe;
    }

    public int hashCode() {
        if (this.cframe == null) {
            return 0;
        }
        return this.cframe.hashCode();
    }

    public String toString() {
        String cFrame;
        CFrame cFrame2 = this.cframe;
        return (cFrame2 == null || (cFrame = cFrame2.toString()) == null) ? "nil" : cFrame;
    }
}
