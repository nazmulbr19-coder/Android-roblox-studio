package com.exampletest.mobilestudiotest.lua;

import java.util.Random;
import kotlin.Metadata;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/RandomV;", "", "seed", "", "<init>", "(J)V", "rng", "Ljava/util/Random;", "getRng", "()Ljava/util/Random;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RandomV {
    private final Random rng;

    public RandomV(long j) {
        this.rng = new Random(j);
    }

    public final Random getRng() {
        return this.rng;
    }
}
