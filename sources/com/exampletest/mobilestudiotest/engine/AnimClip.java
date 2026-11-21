package com.exampletest.mobilestudiotest.engine;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyframeAnim.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "", "length", "", "looped", "", "priority", "", "joints", "", "", "", "Lcom/exampletest/mobilestudiotest/engine/AnimClip$Key;", "<init>", "(FZILjava/util/Map;)V", "getLength", "()F", "getLooped", "()Z", "getPriority", "()I", "jointNames", "", "getJointNames", "()Ljava/util/Set;", "sample", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "joint", "t", "Key", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AnimClip {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, Key[]> joints;
    private final float length;
    private final boolean looped;
    private final int priority;

    /* compiled from: KeyframeAnim.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/AnimClip$Companion;", "", "<init>", "()V", "ease", "", "x", "style", "", "dir0", "bounceOut", "t", TypedValues.TransitionType.S_FROM, "Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "seq", "Lcom/exampletest/mobilestudiotest/model/Instance;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float bounceOut(float t) {
            if (t < 0.36363637f) {
                return 7.5625f * t * t;
            }
            if (t < 0.72727275f) {
                float f = t - 0.54545456f;
                return (7.5625f * f * f) + 0.75f;
            }
            if (t < 0.90909094f) {
                float f2 = t - 0.8181818f;
                return (7.5625f * f2 * f2) + 0.9375f;
            }
            float f3 = t - 0.95454544f;
            return (7.5625f * f3 * f3) + 0.984375f;
        }

        private static final float ease$inF(int i, float f) {
            switch (i) {
                case 2:
                    return (f <= 0.0f || f >= 1.0f) ? f : (-((float) Math.pow(2.0d, (f - 1.0f) * 10.0f))) * ((float) Math.sin(((f - 1.075f) * 6.2831855f) / 0.3f));
                case 3:
                default:
                    return f * f * f;
                case 4:
                    return 1.0f - AnimClip.INSTANCE.bounceOut(1.0f - f);
            }
        }

        private static final void from$walk(HashMap<String, ArrayList<Key>> hashMap, float f, Instance instance) {
            ArrayList<Key> arrayList;
            Iterator<Instance> it = instance.getChildren().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Instance next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Instance instance2 = next;
                if (Intrinsics.areEqual(instance2.getClassName(), "Pose")) {
                    Object obj = instance2.get("Weight");
                    Number number = obj instanceof Number ? (Number) obj : null;
                    if ((number != null ? number.floatValue() : 1.0f) > 0.0f) {
                        Object obj2 = instance2.get("CFrame");
                        CFrame cFrame = obj2 instanceof CFrame ? (CFrame) obj2 : null;
                        if (cFrame == null) {
                            cFrame = CFrame.INSTANCE.getIDENTITY();
                        }
                        Object obj3 = instance2.get("EasingStyle");
                        EnumValue enumValue = obj3 instanceof EnumValue ? (EnumValue) obj3 : null;
                        int value = enumValue != null ? enumValue.getValue() : 0;
                        Object obj4 = instance2.get("EasingDirection");
                        EnumValue enumValue2 = obj4 instanceof EnumValue ? (EnumValue) obj4 : null;
                        int value2 = enumValue2 != null ? enumValue2.getValue() : 0;
                        HashMap<String, ArrayList<Key>> hashMap2 = hashMap;
                        String name = instance2.getName();
                        ArrayList<Key> arrayList2 = hashMap2.get(name);
                        if (arrayList2 == null) {
                            arrayList = new ArrayList<>();
                            hashMap2.put(name, arrayList);
                        } else {
                            arrayList = arrayList2;
                        }
                        arrayList.add(new Key(f, cFrame, value, value2));
                    }
                    from$walk(hashMap, f, instance2);
                }
            }
        }

        public final float ease(float x, int style, int dir0) {
            if (style == 0) {
                return x;
            }
            if (style == 1) {
                return 0.0f;
            }
            switch ((style == 5 || dir0 == 2) ? dir0 : 1 - dir0) {
                case 0:
                    return ease$inF(style, x);
                case 1:
                    return 1.0f - ease$inF(style, 1.0f - x);
                default:
                    return x < 0.5f ? ease$inF(style, x * 2.0f) / 2.0f : 1.0f - (ease$inF(style, (1.0f - x) * 2.0f) / 2.0f);
            }
        }

        public final AnimClip from(Instance seq) {
            Intrinsics.checkNotNullParameter(seq, "seq");
            if (!Intrinsics.areEqual(seq.getClassName(), "KeyframeSequence")) {
                return null;
            }
            HashMap hashMap = new HashMap();
            float f = 0.0f;
            Iterator<Instance> it = seq.getChildren().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Instance next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Instance instance = next;
                if (Intrinsics.areEqual(instance.getClassName(), "Keyframe")) {
                    Object obj = instance.get("Time");
                    Number number = obj instanceof Number ? (Number) obj : null;
                    float floatValue = number != null ? number.floatValue() : 0.0f;
                    if (floatValue > f) {
                        f = floatValue;
                    }
                    from$walk(hashMap, floatValue, instance);
                }
            }
            if (hashMap.isEmpty()) {
                return null;
            }
            HashMap hashMap2 = hashMap;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(hashMap2.size()));
            for (Object obj2 : hashMap2.entrySet()) {
                linkedHashMap.put(((Map.Entry) obj2).getKey(), (Key[]) CollectionsKt.sortedWith((ArrayList) ((Map.Entry) obj2).getValue(), new AnimClip$Companion$from$lambda$2$$inlined$sortedBy$1()).toArray(new Key[0]));
                hashMap = hashMap;
            }
            boolean z = !Intrinsics.areEqual(seq.get("Loop"), (Object) false);
            Object obj3 = seq.get("Priority");
            EnumValue enumValue = obj3 instanceof EnumValue ? (EnumValue) obj3 : null;
            return new AnimClip(f, z, enumValue != null ? enumValue.getValue() : 0, linkedHashMap);
        }
    }

    /* compiled from: KeyframeAnim.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/AnimClip$Key;", "", "t", "", "cf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "style", "", "dir", "<init>", "(FLcom/exampletest/mobilestudiotest/model/CFrame;II)V", "getT", "()F", "getCf", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "getStyle", "()I", "getDir", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Key {
        private final CFrame cf;
        private final int dir;
        private final int style;
        private final float t;

        public Key(float f, CFrame cf, int i, int i2) {
            Intrinsics.checkNotNullParameter(cf, "cf");
            this.t = f;
            this.cf = cf;
            this.style = i;
            this.dir = i2;
        }

        public final CFrame getCf() {
            return this.cf;
        }

        public final int getDir() {
            return this.dir;
        }

        public final int getStyle() {
            return this.style;
        }

        public final float getT() {
            return this.t;
        }
    }

    public AnimClip(float f, boolean z, int i, Map<String, Key[]> joints) {
        Intrinsics.checkNotNullParameter(joints, "joints");
        this.length = f;
        this.looped = z;
        this.priority = i;
        this.joints = joints;
    }

    public final Set<String> getJointNames() {
        return this.joints.keySet();
    }

    public final float getLength() {
        return this.length;
    }

    public final boolean getLooped() {
        return this.looped;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final CFrame sample(String joint, float t) {
        Intrinsics.checkNotNullParameter(joint, "joint");
        Key[] keyArr = this.joints.get(joint);
        if (keyArr == null) {
            return null;
        }
        if (keyArr.length == 1 || t <= keyArr[0].getT()) {
            return keyArr[0].getCf();
        }
        Key key = keyArr[keyArr.length - 1];
        if (t >= key.getT()) {
            return key.getCf();
        }
        int i = 0;
        while (i < keyArr.length - 2 && keyArr[i + 1].getT() <= t) {
            i++;
        }
        Key key2 = keyArr[i];
        Key key3 = keyArr[i + 1];
        float t2 = key3.getT() - key2.getT();
        return t2 <= 1.0E-5f ? key3.getCf() : Quat.INSTANCE.lerp(key2.getCf(), key3.getCf(), INSTANCE.ease((t - key2.getT()) / t2, key2.getStyle(), key2.getDir()));
    }
}
