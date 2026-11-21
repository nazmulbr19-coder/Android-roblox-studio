package com.exampletest.mobilestudiotest.lua;

import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* compiled from: RobloxGlobals.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J(\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/Noise;", "", "<init>", "()V", "p", "", "fade", "", "t", "lerp", "a", "b", "grad", "h", "", "x", "y", "z", "perlin", "x0", "y0", "z0", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Noise {
    public static final Noise INSTANCE = new Noise();
    private static final int[] p;

    static {
        int[] iArr = new int[512];
        List shuffled = CollectionsKt.shuffled(RangesKt.until(0, 256), new Random(1337L));
        for (int i = 0; i < 512; i++) {
            iArr[i] = ((Number) shuffled.get(i & 255)).intValue();
        }
        p = iArr;
    }

    private Noise() {
    }

    private final double fade(double t) {
        return t * t * t * ((((6.0d * t) - 15.0d) * t) + 10.0d);
    }

    private final double grad(int h, double x, double y, double z) {
        int i = h & 15;
        double d = i < 8 ? x : y;
        double d2 = i < 4 ? y : (i == 12 || i == 14) ? x : z;
        return ((i & 1) == 0 ? d : -d) + ((i & 2) == 0 ? d2 : -d2);
    }

    private final double lerp(double t, double a, double b) {
        return ((b - a) * t) + a;
    }

    public final double perlin(double x0, double y0, double z0) {
        int floor = ((int) Math.floor(x0)) & 255;
        int floor2 = ((int) Math.floor(y0)) & 255;
        int floor3 = ((int) Math.floor(z0)) & 255;
        double floor4 = x0 - Math.floor(x0);
        double floor5 = y0 - Math.floor(y0);
        double floor6 = z0 - Math.floor(z0);
        double fade = fade(floor4);
        double fade2 = fade(floor5);
        double fade3 = fade(floor6);
        int i = p[floor] + floor2;
        int i2 = p[i] + floor3;
        int i3 = p[i + 1] + floor3;
        int i4 = p[floor + 1] + floor2;
        int i5 = p[i4] + floor3;
        int i6 = p[i4 + 1] + floor3;
        return lerp(fade3, lerp(fade2, lerp(fade, grad(p[i2], floor4, floor5, floor6), grad(p[i5], floor4 - 1.0d, floor5, floor6)), lerp(fade, grad(p[i3], floor4, floor5 - 1.0d, floor6), grad(p[i6], floor4 - 1.0d, floor5 - 1.0d, floor6))), lerp(fade2, lerp(fade, grad(p[i2 + 1], floor4, floor5, floor6 - 1.0d), grad(p[i5 + 1], floor4 - 1.0d, floor5, floor6 - 1.0d)), lerp(fade, grad(p[i3 + 1], floor4, floor5 - 1.0d, floor6 - 1.0d), grad(p[i6 + 1], floor4 - 1.0d, floor5 - 1.0d, floor6 - 1.0d))));
    }
}
