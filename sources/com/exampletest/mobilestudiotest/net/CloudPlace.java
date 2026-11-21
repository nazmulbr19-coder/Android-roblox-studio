package com.exampletest.mobilestudiotest.net;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RobloxCloud.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/CloudPlace;", "", "universeId", "", "placeId", "name", "", "<init>", "(JJLjava/lang/String;)V", "getUniverseId", "()J", "getPlaceId", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class CloudPlace {
    private final String name;
    private final long placeId;
    private final long universeId;

    public CloudPlace(long j, long j2, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.universeId = j;
        this.placeId = j2;
        this.name = name;
    }

    public static /* synthetic */ CloudPlace copy$default(CloudPlace cloudPlace, long j, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cloudPlace.universeId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = cloudPlace.placeId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = cloudPlace.name;
        }
        return cloudPlace.copy(j3, j4, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUniverseId() {
        return this.universeId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPlaceId() {
        return this.placeId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final CloudPlace copy(long universeId, long placeId, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CloudPlace(universeId, placeId, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudPlace)) {
            return false;
        }
        CloudPlace cloudPlace = (CloudPlace) other;
        return this.universeId == cloudPlace.universeId && this.placeId == cloudPlace.placeId && Intrinsics.areEqual(this.name, cloudPlace.name);
    }

    public final String getName() {
        return this.name;
    }

    public final long getPlaceId() {
        return this.placeId;
    }

    public final long getUniverseId() {
        return this.universeId;
    }

    public int hashCode() {
        return (((Long.hashCode(this.universeId) * 31) + Long.hashCode(this.placeId)) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "CloudPlace(universeId=" + this.universeId + ", placeId=" + this.placeId + ", name=" + this.name + ")";
    }
}
