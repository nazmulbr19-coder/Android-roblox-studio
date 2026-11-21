package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/ContentValue;", "", "sourceType", "", "uri", "", "obj", "Lcom/exampletest/mobilestudiotest/model/Instance;", "<init>", "(ILjava/lang/String;Lcom/exampletest/mobilestudiotest/model/Instance;)V", "getSourceType", "()I", "getUri", "()Ljava/lang/String;", "getObj", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ContentValue {
    private final Instance obj;
    private final int sourceType;
    private final String uri;

    public ContentValue(int i, String uri, Instance instance) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.sourceType = i;
        this.uri = uri;
        this.obj = instance;
    }

    public /* synthetic */ ContentValue(int i, String str, Instance instance, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : instance);
    }

    public static /* synthetic */ ContentValue copy$default(ContentValue contentValue, int i, String str, Instance instance, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = contentValue.sourceType;
        }
        if ((i2 & 2) != 0) {
            str = contentValue.uri;
        }
        if ((i2 & 4) != 0) {
            instance = contentValue.obj;
        }
        return contentValue.copy(i, str, instance);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSourceType() {
        return this.sourceType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component3, reason: from getter */
    public final Instance getObj() {
        return this.obj;
    }

    public final ContentValue copy(int sourceType, String uri, Instance obj) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new ContentValue(sourceType, uri, obj);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentValue)) {
            return false;
        }
        ContentValue contentValue = (ContentValue) other;
        return this.sourceType == contentValue.sourceType && Intrinsics.areEqual(this.uri, contentValue.uri) && Intrinsics.areEqual(this.obj, contentValue.obj);
    }

    public final Instance getObj() {
        return this.obj;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.sourceType) * 31) + this.uri.hashCode()) * 31) + (this.obj == null ? 0 : this.obj.hashCode());
    }

    public String toString() {
        switch (this.sourceType) {
            case 1:
                return this.uri;
            case 2:
                return "Object";
            default:
                return "";
        }
    }
}
