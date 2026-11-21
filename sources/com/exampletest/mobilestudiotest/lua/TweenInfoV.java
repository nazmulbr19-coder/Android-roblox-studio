package com.exampletest.mobilestudiotest.lua;

import kotlin.Metadata;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/TweenInfoV;", "", "time", "", "style", "", "direction", "repeatCount", "reverses", "", "delay", "<init>", "(FIIIZF)V", "getTime", "()F", "getStyle", "()I", "getDirection", "getRepeatCount", "getReverses", "()Z", "getDelay", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TweenInfoV {
    private final float delay;
    private final int direction;
    private final int repeatCount;
    private final boolean reverses;
    private final int style;
    private final float time;

    public TweenInfoV(float f, int i, int i2, int i3, boolean z, float f2) {
        this.time = f;
        this.style = i;
        this.direction = i2;
        this.repeatCount = i3;
        this.reverses = z;
        this.delay = f2;
    }

    public static /* synthetic */ TweenInfoV copy$default(TweenInfoV tweenInfoV, float f, int i, int i2, int i3, boolean z, float f2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f = tweenInfoV.time;
        }
        if ((i4 & 2) != 0) {
            i = tweenInfoV.style;
        }
        if ((i4 & 4) != 0) {
            i2 = tweenInfoV.direction;
        }
        if ((i4 & 8) != 0) {
            i3 = tweenInfoV.repeatCount;
        }
        if ((i4 & 16) != 0) {
            z = tweenInfoV.reverses;
        }
        if ((i4 & 32) != 0) {
            f2 = tweenInfoV.delay;
        }
        boolean z2 = z;
        float f3 = f2;
        return tweenInfoV.copy(f, i, i2, i3, z2, f3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getTime() {
        return this.time;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStyle() {
        return this.style;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDirection() {
        return this.direction;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRepeatCount() {
        return this.repeatCount;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getReverses() {
        return this.reverses;
    }

    /* renamed from: component6, reason: from getter */
    public final float getDelay() {
        return this.delay;
    }

    public final TweenInfoV copy(float time, int style, int direction, int repeatCount, boolean reverses, float delay) {
        return new TweenInfoV(time, style, direction, repeatCount, reverses, delay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TweenInfoV)) {
            return false;
        }
        TweenInfoV tweenInfoV = (TweenInfoV) other;
        return Float.compare(this.time, tweenInfoV.time) == 0 && this.style == tweenInfoV.style && this.direction == tweenInfoV.direction && this.repeatCount == tweenInfoV.repeatCount && this.reverses == tweenInfoV.reverses && Float.compare(this.delay, tweenInfoV.delay) == 0;
    }

    public final float getDelay() {
        return this.delay;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final boolean getReverses() {
        return this.reverses;
    }

    public final int getStyle() {
        return this.style;
    }

    public final float getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.time) * 31) + Integer.hashCode(this.style)) * 31) + Integer.hashCode(this.direction)) * 31) + Integer.hashCode(this.repeatCount)) * 31) + Boolean.hashCode(this.reverses)) * 31) + Float.hashCode(this.delay);
    }

    public String toString() {
        return "TweenInfoV(time=" + this.time + ", style=" + this.style + ", direction=" + this.direction + ", repeatCount=" + this.repeatCount + ", reverses=" + this.reverses + ", delay=" + this.delay + ")";
    }
}
