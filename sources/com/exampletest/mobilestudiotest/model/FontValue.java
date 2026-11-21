package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/FontValue;", "", "family", "", "weight", "", "style", "cachedFaceId", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getFamily", "()Ljava/lang/String;", "getWeight", "()I", "getStyle", "getCachedFaceId", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FontValue {
    private final String cachedFaceId;
    private final String family;
    private final int style;
    private final int weight;

    public FontValue(String family, int i, int i2, String cachedFaceId) {
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(cachedFaceId, "cachedFaceId");
        this.family = family;
        this.weight = i;
        this.style = i2;
        this.cachedFaceId = cachedFaceId;
    }

    public static /* synthetic */ FontValue copy$default(FontValue fontValue, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = fontValue.family;
        }
        if ((i3 & 2) != 0) {
            i = fontValue.weight;
        }
        if ((i3 & 4) != 0) {
            i2 = fontValue.style;
        }
        if ((i3 & 8) != 0) {
            str2 = fontValue.cachedFaceId;
        }
        return fontValue.copy(str, i, i2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFamily() {
        return this.family;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWeight() {
        return this.weight;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStyle() {
        return this.style;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCachedFaceId() {
        return this.cachedFaceId;
    }

    public final FontValue copy(String family, int weight, int style, String cachedFaceId) {
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(cachedFaceId, "cachedFaceId");
        return new FontValue(family, weight, style, cachedFaceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FontValue)) {
            return false;
        }
        FontValue fontValue = (FontValue) other;
        return Intrinsics.areEqual(this.family, fontValue.family) && this.weight == fontValue.weight && this.style == fontValue.style && Intrinsics.areEqual(this.cachedFaceId, fontValue.cachedFaceId);
    }

    public final String getCachedFaceId() {
        return this.cachedFaceId;
    }

    public final String getFamily() {
        return this.family;
    }

    public final int getStyle() {
        return this.style;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((this.family.hashCode() * 31) + Integer.hashCode(this.weight)) * 31) + Integer.hashCode(this.style)) * 31) + this.cachedFaceId.hashCode();
    }

    public String toString() {
        return StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(this.family, '/', (String) null, 2, (Object) null), '.', (String) null, 2, (Object) null) + " (" + this.weight + ")";
    }
}
