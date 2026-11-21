package com.exampletest.mobilestudiotest.model;

import androidx.core.view.ViewCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Color3;", "", "r", "", "g", "b", "<init>", "(FFF)V", "getR", "()F", "getG", "getB", "toArgb", "", "lerp", "o", "t", "toHex", "", "toHSV", "", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Color3 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float b;
    private final float g;
    private final float r;

    /* compiled from: DataTypes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Color3$Companion;", "", "<init>", "()V", "c8", "", "f", "", "fromRGB", "Lcom/exampletest/mobilestudiotest/model/Color3;", "r", "g", "b", "fromArgb", "c", "fromHex", "h", "", "fromHSV", "s", "v", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final /* synthetic */ int access$c8(Companion companion, float f) {
            return companion.c8(f);
        }

        private final int c8(float f) {
            return MathKt.roundToInt(RangesKt.coerceIn(f, 0.0f, 1.0f) * 255.0f);
        }

        public final Color3 fromArgb(int c) {
            return fromRGB((c >> 16) & 255, (c >> 8) & 255, c & 255);
        }

        public final Color3 fromHSV(float h, float s, float v) {
            int i = (int) (h * 6.0f);
            float f = (6.0f * h) - i;
            float f2 = (1.0f - s) * v;
            float f3 = (1.0f - (f * s)) * v;
            float f4 = (1.0f - ((1.0f - f) * s)) * v;
            switch (((i % 6) + 6) % 6) {
                case 0:
                    return new Color3(v, f4, f2);
                case 1:
                    return new Color3(f3, v, f2);
                case 2:
                    return new Color3(f2, v, f4);
                case 3:
                    return new Color3(f2, f3, v);
                case 4:
                    return new Color3(f4, f2, v);
                default:
                    return new Color3(v, f2, f3);
            }
        }

        public final Color3 fromHex(String h) {
            Integer intOrNull;
            Intrinsics.checkNotNullParameter(h, "h");
            String removePrefix = StringsKt.removePrefix(StringsKt.trim((CharSequence) h).toString(), (CharSequence) "#");
            if (removePrefix.length() == 6 && (intOrNull = StringsKt.toIntOrNull(removePrefix, 16)) != null) {
                return Color3.INSTANCE.fromArgb(intOrNull.intValue());
            }
            return null;
        }

        public final Color3 fromRGB(int r, int g, int b) {
            return new Color3(r / 255.0f, g / 255.0f, b / 255.0f);
        }
    }

    public Color3(float f, float f2, float f3) {
        this.r = f;
        this.g = f2;
        this.b = f3;
    }

    public static /* synthetic */ Color3 copy$default(Color3 color3, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = color3.r;
        }
        if ((i & 2) != 0) {
            f2 = color3.g;
        }
        if ((i & 4) != 0) {
            f3 = color3.b;
        }
        return color3.copy(f, f2, f3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getR() {
        return this.r;
    }

    /* renamed from: component2, reason: from getter */
    public final float getG() {
        return this.g;
    }

    /* renamed from: component3, reason: from getter */
    public final float getB() {
        return this.b;
    }

    public final Color3 copy(float r, float g, float b) {
        return new Color3(r, g, b);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Color3)) {
            return false;
        }
        Color3 color3 = (Color3) other;
        return Float.compare(this.r, color3.r) == 0 && Float.compare(this.g, color3.g) == 0 && Float.compare(this.b, color3.b) == 0;
    }

    public final float getB() {
        return this.b;
    }

    public final float getG() {
        return this.g;
    }

    public final float getR() {
        return this.r;
    }

    public int hashCode() {
        return (((Float.hashCode(this.r) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.b);
    }

    public final Color3 lerp(Color3 o, float t) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Color3(this.r + ((o.r - this.r) * t), this.g + ((o.g - this.g) * t), this.b + ((o.b - this.b) * t));
    }

    public final int toArgb() {
        return (Companion.access$c8(INSTANCE, this.r) << 16) | ViewCompat.MEASURED_STATE_MASK | (Companion.access$c8(INSTANCE, this.g) << 8) | Companion.access$c8(INSTANCE, this.b);
    }

    public final float[] toHSV() {
        float f;
        float max = Math.max(this.r, Math.max(this.g, this.b));
        float min = max - Math.min(this.r, Math.min(this.g, this.b));
        if (min == 0.0f) {
            f = 0.0f;
        } else {
            if (max == this.r) {
                f = ((this.g - this.b) / min) % 6.0f;
            } else {
                f = (max > this.g ? 1 : (max == this.g ? 0 : -1)) == 0 ? ((this.b - this.r) / min) + 2.0f : ((this.r - this.g) / min) + 4.0f;
            }
        }
        float f2 = f / 6.0f;
        if (f2 < 0.0f) {
            f2 += 1.0f;
        }
        return new float[]{f2, (max > 0.0f ? 1 : (max == 0.0f ? 0 : -1)) == 0 ? 0.0f : min / max, max};
    }

    public final String toHex() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02X%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(Companion.access$c8(INSTANCE, this.r)), Integer.valueOf(Companion.access$c8(INSTANCE, this.g)), Integer.valueOf(Companion.access$c8(INSTANCE, this.b))}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public String toString() {
        return Companion.access$c8(INSTANCE, this.r) + ", " + Companion.access$c8(INSTANCE, this.g) + ", " + Companion.access$c8(INSTANCE, this.b);
    }
}
