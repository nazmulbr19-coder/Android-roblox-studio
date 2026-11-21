package com.exampletest.mobilestudiotest.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Enums.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007J)\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013\"\u00020\u0011¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005J\u0016\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\tJ\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000b¨\u0006\u001f"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/PartData;", "", "<init>", "()V", "cframe", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "p", "Lcom/exampletest/mobilestudiotest/model/Instance;", "size", "Lcom/exampletest/mobilestudiotest/model/Vector3;", TypedValues.Custom.S_COLOR, "Lcom/exampletest/mobilestudiotest/model/Color3;", "transparency", "", "material", "", "content", "", "keys", "", "(Lcom/exampletest/mobilestudiotest/model/Instance;[Ljava/lang/String;)Ljava/lang/String;", "meshContent", "textureContent", "shape", "setCFrame", "", "cf", "setSize", "s", "setColor", "c", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PartData {
    public static final PartData INSTANCE = new PartData();

    private PartData() {
    }

    public final CFrame cframe(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        Object obj = p.get("CFrame");
        CFrame cFrame = obj instanceof CFrame ? (CFrame) obj : null;
        return cFrame == null ? CFrame.INSTANCE.getIDENTITY() : cFrame;
    }

    public final Color3 color(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        Object obj = p.get("Color3uint8");
        Color3 color3 = obj instanceof Color3 ? (Color3) obj : null;
        if (color3 != null) {
            return color3;
        }
        Object obj2 = p.get("Color");
        Color3 color32 = obj2 instanceof Color3 ? (Color3) obj2 : null;
        if (color32 != null) {
            return color32;
        }
        Object obj3 = p.get("BrickColor");
        BrickColorV brickColorV = obj3 instanceof BrickColorV ? (BrickColorV) obj3 : null;
        return brickColorV != null ? brickColorV.getColor() : Color3.INSTANCE.fromRGB(163, 162, 165);
    }

    public final String content(Instance p, String... keys) {
        String obj;
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(keys, "keys");
        int length = keys.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return null;
            }
            Object obj2 = p.get(keys[i]);
            if (obj2 != null && (obj = obj2.toString()) != null) {
                String str = StringsKt.isBlank(obj) ? null : obj;
                if (str != null) {
                    return str;
                }
            }
            i++;
        }
    }

    public final int material(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        Object obj = p.get("Material");
        EnumValue enumValue = obj instanceof EnumValue ? (EnumValue) obj : null;
        if (enumValue != null) {
            return enumValue.getValue();
        }
        return 256;
    }

    public final String meshContent(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return content(p, "MeshId", "MeshID", "MeshContent");
    }

    public final void setCFrame(Instance p, CFrame cf) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(cf, "cf");
        Instance.set$default(p, "CFrame", cf, false, 4, null);
    }

    public final void setColor(Instance p, Color3 c) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(c, "c");
        if (p.getProps().containsKey("Color3uint8")) {
            Instance.set$default(p, "Color3uint8", c, false, 4, null);
        } else if (p.getProps().containsKey("Color")) {
            Instance.set$default(p, "Color", c, false, 4, null);
        } else {
            Instance.set$default(p, "Color3uint8", c, false, 4, null);
            p.getPropTypes().put("Color3uint8", 26);
        }
        if (p.getProps().containsKey("BrickColor")) {
            Instance.set$default(p, "BrickColor", new BrickColorV(BrickColors.INSTANCE.closest(c)), false, 4, null);
        }
    }

    public final void setSize(Instance p, Vector3 s) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(s, "s");
        if (!p.getProps().containsKey("Size") || p.getProps().containsKey("size")) {
            Instance.set$default(p, "size", s, false, 4, null);
        } else {
            Instance.set$default(p, "Size", s, false, 4, null);
        }
    }

    public final int shape(Instance p) {
        Object obj;
        Intrinsics.checkNotNullParameter(p, "p");
        String className = p.getClassName();
        if (Intrinsics.areEqual(className, "WedgePart")) {
            return 3;
        }
        if (Intrinsics.areEqual(className, "CornerWedgePart")) {
            return 4;
        }
        Object obj2 = p.get("shape");
        if (obj2 == null) {
            obj2 = p.get("Shape");
        }
        EnumValue enumValue = obj2 instanceof EnumValue ? (EnumValue) obj2 : null;
        if (enumValue != null) {
            return enumValue.getValue();
        }
        Iterator<T> it = p.getChildren().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Instance) obj).getClassName(), "SpecialMesh")) {
                break;
            }
        }
        Instance instance = (Instance) obj;
        if (instance == null) {
            return 1;
        }
        Object obj3 = instance.get("MeshType");
        EnumValue enumValue2 = obj3 instanceof EnumValue ? (EnumValue) obj3 : null;
        Integer valueOf = enumValue2 != null ? Integer.valueOf(enumValue2.getValue()) : null;
        if (valueOf == null || valueOf.intValue() != 3) {
            return (valueOf == null || valueOf.intValue() != 2) ? 1 : 3;
        }
        return 0;
    }

    public final Vector3 size(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        Object obj = p.get("size");
        if (obj == null) {
            obj = p.get("Size");
        }
        Vector3 vector3 = obj instanceof Vector3 ? (Vector3) obj : null;
        return vector3 == null ? new Vector3(4.0f, 1.0f, 2.0f) : vector3;
    }

    public final String textureContent(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return content(p, "TextureID", "TextureId", "TextureContent");
    }

    public final float transparency(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        Object obj = p.get("Transparency");
        Number number = obj instanceof Number ? (Number) obj : null;
        if (number != null) {
            return number.floatValue();
        }
        return 0.0f;
    }
}
