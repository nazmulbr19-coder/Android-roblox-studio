package com.exampletest.mobilestudiotest.lua;

import com.exampletest.mobilestudiotest.model.Instance;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006 "}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/RaycastParamsV;", "", "<init>", "()V", "filter", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "getFilter", "()Ljava/util/List;", "setFilter", "(Ljava/util/List;)V", "filterType", "", "getFilterType", "()I", "setFilterType", "(I)V", "ignoreWater", "", "getIgnoreWater", "()Z", "setIgnoreWater", "(Z)V", "collisionGroup", "", "getCollisionGroup", "()Ljava/lang/String;", "setCollisionGroup", "(Ljava/lang/String;)V", "respectCanCollide", "getRespectCanCollide", "setRespectCanCollide", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RaycastParamsV {
    private int filterType;
    private boolean ignoreWater;
    private boolean respectCanCollide;
    private List<? extends Instance> filter = CollectionsKt.emptyList();
    private String collisionGroup = "Default";

    public final String getCollisionGroup() {
        return this.collisionGroup;
    }

    public final List<Instance> getFilter() {
        return this.filter;
    }

    public final int getFilterType() {
        return this.filterType;
    }

    public final boolean getIgnoreWater() {
        return this.ignoreWater;
    }

    public final boolean getRespectCanCollide() {
        return this.respectCanCollide;
    }

    public final void setCollisionGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.collisionGroup = str;
    }

    public final void setFilter(List<? extends Instance> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.filter = list;
    }

    public final void setFilterType(int i) {
        this.filterType = i;
    }

    public final void setIgnoreWater(boolean z) {
        this.ignoreWater = z;
    }

    public final void setRespectCanCollide(boolean z) {
        this.respectCanCollide = z;
    }
}
