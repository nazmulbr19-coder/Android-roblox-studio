package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import org.luaj.vm2.LuaDouble;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"fmtNum", "", "f", "", "", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DataTypesKt {
    public static final String fmtNum(double d) {
        if (Double.isNaN(d)) {
            return LuaDouble.JSTR_NAN;
        }
        if (Double.isInfinite(d)) {
            return d > 0.0d ? LuaDouble.JSTR_POSINF : LuaDouble.JSTR_NEGINF;
        }
        double round = Math.round(d * 1000.0d) / 1000.0d;
        return (!((round > Math.rint(round) ? 1 : (round == Math.rint(round) ? 0 : -1)) == 0) || Math.abs(round) >= 1.0E15d) ? String.valueOf(round) : String.valueOf((long) round);
    }

    public static final String fmtNum(float f) {
        return fmtNum(f);
    }
}
