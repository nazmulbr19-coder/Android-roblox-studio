package com.exampletest.mobilestudiotest.lua;

import com.exampletest.mobilestudiotest.model.Instance;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LuaRuntime.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/Tween;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "info", "Lcom/exampletest/mobilestudiotest/lua/TweenInfoV;", "goals", "", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/lua/TweenInfoV;Ljava/util/Map;)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getInfo", "()Lcom/exampletest/mobilestudiotest/lua/TweenInfoV;", "getGoals", "()Ljava/util/Map;", "state", "", "getState", "()I", "setState", "(I)V", "elapsed", "", "getElapsed", "()F", "setElapsed", "(F)V", "start", "getStart", "setStart", "(Ljava/util/Map;)V", "repeatsDone", "getRepeatsDone", "setRepeatsDone", "reversing", "", "getReversing", "()Z", "setReversing", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Tween {
    private float elapsed;
    private final Map<String, Object> goals;
    private final TweenInfoV info;
    private final Instance inst;
    private int repeatsDone;
    private boolean reversing;
    private Map<String, ? extends Object> start;
    private int state;

    public Tween(Instance inst, TweenInfoV info, Map<String, ? extends Object> goals) {
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(goals, "goals");
        this.inst = inst;
        this.info = info;
        this.goals = goals;
        this.start = MapsKt.emptyMap();
    }

    public final float getElapsed() {
        return this.elapsed;
    }

    public final Map<String, Object> getGoals() {
        return this.goals;
    }

    public final TweenInfoV getInfo() {
        return this.info;
    }

    public final Instance getInst() {
        return this.inst;
    }

    public final int getRepeatsDone() {
        return this.repeatsDone;
    }

    public final boolean getReversing() {
        return this.reversing;
    }

    public final Map<String, Object> getStart() {
        return this.start;
    }

    public final int getState() {
        return this.state;
    }

    public final void setElapsed(float f) {
        this.elapsed = f;
    }

    public final void setRepeatsDone(int i) {
        this.repeatsDone = i;
    }

    public final void setReversing(boolean z) {
        this.reversing = z;
    }

    public final void setStart(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.start = map;
    }

    public final void setState(int i) {
        this.state = i;
    }
}
