package com.exampletest.mobilestudiotest.render;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.Axes;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.Faces;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AdornHandles.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/AdornHandles;", "", "<init>", "()V", "normals", "", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "NORMAL_NAMES", "", "getNORMAL_NAMES", "()Ljava/util/List;", "AXIS_NAMES", "getAXIS_NAMES", "isHandles", "", "a", "Lcom/exampletest/mobilestudiotest/model/Instance;", "adornee", "tips", "Lcom/exampletest/mobilestudiotest/render/AdornHandles$Tip;", "view", "Lcom/exampletest/mobilestudiotest/render/ViewState;", "Tip", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AdornHandles {
    public static final AdornHandles INSTANCE = new AdornHandles();
    private static final List<Vector3> normals = CollectionsKt.listOf((Object[]) new Vector3[]{Vector3.INSTANCE.getX(), Vector3.INSTANCE.getY(), Vector3.INSTANCE.getZ(), Vector3.INSTANCE.getX().unaryMinus(), Vector3.INSTANCE.getY().unaryMinus(), Vector3.INSTANCE.getZ().unaryMinus()});
    private static final List<String> NORMAL_NAMES = CollectionsKt.listOf((Object[]) new String[]{"Right", "Top", "Back", "Left", "Bottom", "Front"});
    private static final List<String> AXIS_NAMES = CollectionsKt.listOf((Object[]) new String[]{"X", "Y", "Z"});

    /* compiled from: AdornHandles.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/AdornHandles$Tip;", "", "id", "", "axis", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "base", "tip", "radius", "", TypedValues.Custom.S_COLOR, "Lcom/exampletest/mobilestudiotest/model/Color3;", "<init>", "(ILcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;FLcom/exampletest/mobilestudiotest/model/Color3;)V", "getId", "()I", "getAxis", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getBase", "getTip", "getRadius", "()F", "getColor", "()Lcom/exampletest/mobilestudiotest/model/Color3;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Tip {
        private final Vector3 axis;
        private final Vector3 base;
        private final Color3 color;
        private final int id;
        private final float radius;
        private final Vector3 tip;

        public Tip(int i, Vector3 axis, Vector3 base, Vector3 tip, float f, Color3 color) {
            Intrinsics.checkNotNullParameter(axis, "axis");
            Intrinsics.checkNotNullParameter(base, "base");
            Intrinsics.checkNotNullParameter(tip, "tip");
            Intrinsics.checkNotNullParameter(color, "color");
            this.id = i;
            this.axis = axis;
            this.base = base;
            this.tip = tip;
            this.radius = f;
            this.color = color;
        }

        public final Vector3 getAxis() {
            return this.axis;
        }

        public final Vector3 getBase() {
            return this.base;
        }

        public final Color3 getColor() {
            return this.color;
        }

        public final int getId() {
            return this.id;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final Vector3 getTip() {
            return this.tip;
        }
    }

    private AdornHandles() {
    }

    private final Instance adornee(Instance a) {
        Object obj = a.get("Adornee");
        Instance instance = obj instanceof Instance ? (Instance) obj : null;
        if (instance == null || !instance.isA("BasePart")) {
            return null;
        }
        return instance;
    }

    public final List<String> getAXIS_NAMES() {
        return AXIS_NAMES;
    }

    public final List<String> getNORMAL_NAMES() {
        return NORMAL_NAMES;
    }

    public final boolean isHandles(Instance a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return Intrinsics.areEqual(a.getClassName(), "Handles") || Intrinsics.areEqual(a.getClassName(), "ArcHandles");
    }

    public final List<Tip> tips(Instance a, ViewState view) {
        Instance adornee;
        int i;
        Color3 color3;
        Instance instance;
        int i2;
        float f;
        Color3 color32;
        Color3 color33;
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!Intrinsics.areEqual(a.get("Visible"), (Object) false) && (adornee = adornee(a)) != null) {
            CFrame cframe = PartData.INSTANCE.cframe(adornee);
            Vector3 size = PartData.INSTANCE.size(adornee);
            float coerceAtLeast = RangesKt.coerceAtLeast(view.distTo(cframe.getPosition()), 1.0f);
            float f2 = 0.06f * coerceAtLeast;
            float f3 = coerceAtLeast * 0.018f;
            ArrayList arrayList = new ArrayList();
            float f4 = 0.3f;
            if (Intrinsics.areEqual(a.getClassName(), "Handles")) {
                Object obj = a.get("Faces");
                Faces faces = obj instanceof Faces ? (Faces) obj : null;
                int mask = faces != null ? faces.getMask() : 63;
                Object obj2 = a.get("Color3");
                Color3 color34 = obj2 instanceof Color3 ? (Color3) obj2 : null;
                int i3 = 0;
                while (i3 < 6) {
                    if ((mask & (1 << i3)) != 0) {
                        Vector3 vector3 = normals.get(i3);
                        Vector3 vectorToWorld = cframe.vectorToWorld(vector3);
                        Vector3 plus = cframe.getPosition().plus(vectorToWorld.times(((Math.abs(vector3.getX()) * size.getX()) / 2.0f) + ((Math.abs(vector3.getY()) * size.getY()) / 2.0f) + ((Math.abs(vector3.getZ()) * size.getZ()) / 2.0f)));
                        if (color34 == null) {
                            switch (i3 % 3) {
                                case 0:
                                    color33 = new Color3(0.95f, 0.25f, 0.25f);
                                    break;
                                case 1:
                                    color33 = new Color3(f4, 0.9f, f4);
                                    break;
                                default:
                                    instance = adornee;
                                    color32 = new Color3(0.25f, 0.5f, 1.0f);
                                    break;
                            }
                            instance = adornee;
                            color32 = color33;
                        } else {
                            instance = adornee;
                            color32 = color34;
                        }
                        Vector3 plus2 = plus.plus(vectorToWorld.times(f2));
                        f = 0.3f;
                        i2 = i3;
                        arrayList.add(new Tip(i2, vectorToWorld, plus, plus2, f3, color32));
                    } else {
                        instance = adornee;
                        i2 = i3;
                        f = f4;
                    }
                    i3 = i2 + 1;
                    f4 = f;
                    adornee = instance;
                }
            } else {
                float f5 = 0.3f;
                float f6 = 0.9f;
                Object obj3 = a.get("Axes");
                Axes axes = obj3 instanceof Axes ? (Axes) obj3 : null;
                int mask2 = axes != null ? axes.getMask() : 7;
                float max = (Math.max(size.getX(), Math.max(size.getY(), size.getZ())) / 2.0f) + f2;
                int i4 = 0;
                while (i4 < 3) {
                    if (((1 << i4) & mask2) != 0) {
                        Vector3 vectorToWorld2 = cframe.vectorToWorld(normals.get(i4));
                        switch (i4) {
                            case 0:
                                color3 = new Color3(0.95f, 0.25f, 0.25f);
                                break;
                            case 1:
                                color3 = new Color3(f5, f6, f5);
                                break;
                            default:
                                color3 = new Color3(0.25f, 0.5f, 1.0f);
                                break;
                        }
                        i = i4;
                        arrayList.add(new Tip(i, vectorToWorld2, cframe.getPosition(), cframe.getPosition().plus(cframe.vectorToWorld(normals.get((i4 + 1) % 3)).times(max)), f3 * 1.1f, color3));
                    } else {
                        i = i4;
                    }
                    i4 = i + 1;
                    f5 = 0.3f;
                    f6 = 0.9f;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
