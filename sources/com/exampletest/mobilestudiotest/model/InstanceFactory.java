package com.exampletest.mobilestudiotest.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Instance.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/InstanceFactory;", "", "<init>", "()V", "GREY", "Lcom/exampletest/mobilestudiotest/model/Color3;", "create", "Lcom/exampletest/mobilestudiotest/model/Instance;", "cls", "", "extraDefaults", "", "i", "defaultSource", "part", "gui", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InstanceFactory {
    public static final InstanceFactory INSTANCE = new InstanceFactory();
    private static final Color3 GREY = Color3.INSTANCE.fromRGB(163, 162, 165);

    private InstanceFactory() {
    }

    private final String defaultSource(String cls) {
        return Intrinsics.areEqual(cls, "ModuleScript") ? "local module = {}\n\nreturn module\n" : "print(\"Hello world!\")\n";
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0084. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:153:0x0b2a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0b2f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0b38  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0b56  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0b6e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0b7f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0b93  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void extraDefaults(com.exampletest.mobilestudiotest.model.Instance r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 4224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.model.InstanceFactory.extraDefaults(com.exampletest.mobilestudiotest.model.Instance, java.lang.String):void");
    }

    private static final void extraDefaults$s(Instance instance, String str, Object obj) {
        if (instance.getProps().containsKey(str)) {
            return;
        }
        instance.set(str, obj, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00bd, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00c0, code lost:
    
        r14.set("Text", r5, false);
        r14.set("TextColor3", new com.exampletest.mobilestudiotest.model.Color3(0.0f, 0.0f, 0.0f), false);
        r14.set("TextSize", java.lang.Float.valueOf(14.0f), false);
        r14.set("TextScaled", false, false);
        r14.set("TextWrapped", false, false);
        r14.set("TextXAlignment", new com.exampletest.mobilestudiotest.model.EnumValue(2), false);
        r14.set("TextYAlignment", new com.exampletest.mobilestudiotest.model.EnumValue(1), false);
        r14.set("TextTransparency", r2, false);
        r14.set("Font", new com.exampletest.mobilestudiotest.model.EnumValue(3), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x010d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r15, "TextBox") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x010f, code lost:
    
        r14.set("PlaceholderText", "", false);
        r14.set("ClearTextOnFocus", true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00bf, code lost:
    
        r5 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x009f, code lost:
    
        if (r15.equals("TextBox") != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a8, code lost:
    
        if (r15.equals("TextButton") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0098, code lost:
    
        if (r15.equals("TextLabel") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00ab, code lost:
    
        r14.set("Size", new com.exampletest.mobilestudiotest.model.UDim2(0.0f, androidx.recyclerview.widget.ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 0.0f, 50), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00bb, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r15, "TextBox") == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void gui(com.exampletest.mobilestudiotest.model.Instance r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.model.InstanceFactory.gui(com.exampletest.mobilestudiotest.model.Instance, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0100, code lost:
    
        r11.set("shape", new com.exampletest.mobilestudiotest.model.EnumValue(1), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00ce, code lost:
    
        if (r12.equals("Part") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00fd, code lost:
    
        if (r12.equals("SpawnLocation") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00c5, code lost:
    
        if (r12.equals("Seat") == false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void part(com.exampletest.mobilestudiotest.model.Instance r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.model.InstanceFactory.part(com.exampletest.mobilestudiotest.model.Instance, java.lang.String):void");
    }

    public final Instance create(String cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Instance instance = new Instance(cls);
        instance.set("Name", cls, false);
        if (ClassDb.INSTANCE.isServiceName(cls)) {
            instance.setService(true);
        }
        if (ClassDb.INSTANCE.isA(cls, "BasePart")) {
            part(instance, cls);
        } else if (ClassDb.INSTANCE.isA(cls, "LuaSourceContainer")) {
            instance.set("Source", defaultSource(cls), false);
            if (!Intrinsics.areEqual(cls, "ModuleScript")) {
                instance.set("Disabled", false, false);
            }
        } else if (Intrinsics.areEqual(cls, "Model")) {
            instance.set("WorldPivotData", new OptionalCFrame(null), false);
            instance.set("PrimaryPart", null, false);
        } else if (Intrinsics.areEqual(cls, "Humanoid")) {
            instance.set("Health_XML", Float.valueOf(100.0f), false);
            instance.set("MaxHealth", Float.valueOf(100.0f), false);
            instance.set("WalkSpeed", Float.valueOf(16.0f), false);
            instance.set("JumpPower", Float.valueOf(50.0f), false);
            instance.set("HipHeight", Float.valueOf(0.0f), false);
            instance.set("DisplayName", "", false);
        } else if (ClassDb.INSTANCE.isA(cls, "GuiObject")) {
            gui(instance, cls);
        } else if (Intrinsics.areEqual(cls, "ScreenGui")) {
            instance.set("Enabled", true, false);
            instance.set("ResetOnSpawn", true, false);
            instance.set("IgnoreGuiInset", false, false);
        } else if (ClassDb.INSTANCE.isA(cls, "Light")) {
            instance.set("Brightness", Float.valueOf(1.0f), false);
            instance.set("Color", new Color3(1.0f, 1.0f, 1.0f), false);
            instance.set("Range", Float.valueOf(8.0f), false);
            instance.set("Enabled", true, false);
            instance.set("Shadows", false, false);
        } else if (Intrinsics.areEqual(cls, "StringValue")) {
            instance.set("Value", "", false);
        } else if (Intrinsics.areEqual(cls, "IntValue")) {
            instance.set("Value", 0L, false);
        } else if (Intrinsics.areEqual(cls, "NumberValue")) {
            instance.set("Value", Double.valueOf(0.0d), false);
        } else if (Intrinsics.areEqual(cls, "BoolValue")) {
            instance.set("Value", false, false);
        } else if (Intrinsics.areEqual(cls, "ObjectValue")) {
            instance.set("Value", null, false);
        } else if (Intrinsics.areEqual(cls, "Vector3Value")) {
            instance.set("Value", Vector3.INSTANCE.getZERO(), false);
        } else if (Intrinsics.areEqual(cls, "CFrameValue")) {
            instance.set("Value", CFrame.INSTANCE.getIDENTITY(), false);
        } else if (Intrinsics.areEqual(cls, "Color3Value")) {
            instance.set("Value", new Color3(0.0f, 0.0f, 0.0f), false);
        } else if (Intrinsics.areEqual(cls, "Sound")) {
            instance.set("SoundId", "", false);
            instance.set("Volume", Float.valueOf(0.5f), false);
            instance.set("Looped", false, false);
            instance.set("Playing", false, false);
        } else if (Intrinsics.areEqual(cls, "UICorner")) {
            instance.set("CornerRadius", new UDim(0.0f, 8), false);
        } else if (Intrinsics.areEqual(cls, "UIStroke")) {
            instance.set("Color", new Color3(0.0f, 0.0f, 0.0f), false);
            instance.set("Thickness", Float.valueOf(1.0f), false);
            instance.set("Transparency", Float.valueOf(0.0f), false);
        } else if (Intrinsics.areEqual(cls, "UIListLayout")) {
            instance.set("Padding", new UDim(0.0f, 0), false);
            instance.set("FillDirection", new EnumValue(1), false);
            instance.set("SortOrder", new EnumValue(2), false);
        } else if (Intrinsics.areEqual(cls, "UIPadding")) {
            Iterator it = CollectionsKt.listOf((Object[]) new String[]{"PaddingTop", "PaddingBottom", "PaddingLeft", "PaddingRight"}).iterator();
            while (it.hasNext()) {
                instance.set((String) it.next(), new UDim(0.0f, 0), false);
            }
        } else if (Intrinsics.areEqual(cls, "Attachment")) {
            instance.set("CFrame", CFrame.INSTANCE.getIDENTITY(), false);
        } else if (Intrinsics.areEqual(cls, "Weld") || Intrinsics.areEqual(cls, "Motor6D")) {
            instance.set("Part0", null, false);
            instance.set("Part1", null, false);
            instance.set("C0", CFrame.INSTANCE.getIDENTITY(), false);
            instance.set("C1", CFrame.INSTANCE.getIDENTITY(), false);
        } else if (Intrinsics.areEqual(cls, "WeldConstraint")) {
            instance.set("Part0Internal", null, false);
            instance.set("Part1Internal", null, false);
        } else if (Intrinsics.areEqual(cls, "ClickDetector")) {
            instance.set("MaxActivationDistance", Float.valueOf(32.0f), false);
        } else if (Intrinsics.areEqual(cls, "Decal") || Intrinsics.areEqual(cls, "Texture")) {
            instance.set("Texture", "", false);
            instance.set("Face", new EnumValue(5), false);
            instance.set("Transparency", Float.valueOf(0.0f), false);
        } else if (Intrinsics.areEqual(cls, "SpecialMesh")) {
            instance.set("MeshType", new EnumValue(6), false);
            instance.set("Scale", Vector3.INSTANCE.getONE(), false);
            instance.set("MeshId", "", false);
        } else if (Intrinsics.areEqual(cls, "Tool")) {
            instance.set("RequiresHandle", true, false);
            instance.set("CanBeDropped", true, false);
            instance.set("ToolTip", "", false);
        } else if (Intrinsics.areEqual(cls, "Camera")) {
            instance.set("CFrame", CFrame.INSTANCE.getIDENTITY(), false);
            instance.set("FieldOfView", Float.valueOf(70.0f), false);
            instance.set("CameraType", new EnumValue(0), false);
        } else if (Intrinsics.areEqual(cls, "Lighting")) {
            instance.set("ClockTime", Float.valueOf(14.0f), false);
            instance.set("Brightness", Float.valueOf(2.0f), false);
            instance.set("Ambient", Color3.INSTANCE.fromRGB(70, 70, 70), false);
            instance.set("OutdoorAmbient", Color3.INSTANCE.fromRGB(128, 128, 128), false);
        } else if (Intrinsics.areEqual(cls, "Workspace")) {
            instance.set("Gravity", Float.valueOf(196.2f), false);
            instance.set("FallenPartsDestroyHeight", Float.valueOf(-500.0f), false);
        } else if (Intrinsics.areEqual(cls, "Players")) {
            instance.set("MaxPlayers", 12, false);
            instance.set("RespawnTime", Float.valueOf(5.0f), false);
        } else if (Intrinsics.areEqual(cls, "ProximityPrompt")) {
            instance.set("ActionText", "Interact", false);
            instance.set("ObjectText", "", false);
            instance.set("MaxActivationDistance", Float.valueOf(10.0f), false);
            instance.set("HoldDuration", Float.valueOf(0.0f), false);
        } else if (Intrinsics.areEqual(cls, "ParticleEmitter")) {
            instance.set("Rate", Float.valueOf(20.0f), false);
            instance.set("Enabled", true, false);
        } else if (Intrinsics.areEqual(cls, "Highlight")) {
            instance.set("FillColor", new Color3(1.0f, 0.0f, 0.0f), false);
            instance.set("OutlineColor", new Color3(1.0f, 1.0f, 1.0f), false);
            instance.set("FillTransparency", Float.valueOf(0.5f), false);
            instance.set("Enabled", true, false);
        } else if (Intrinsics.areEqual(cls, "BillboardGui") || Intrinsics.areEqual(cls, "SurfaceGui")) {
            instance.set("Enabled", true, false);
            instance.set("Adornee", null, false);
        } else if (Intrinsics.areEqual(cls, "Team")) {
            instance.set("TeamColor", new BrickColorV(194), false);
            instance.set("AutoAssignable", true, false);
        } else if (Intrinsics.areEqual(cls, "Animation")) {
            instance.set("AnimationId", "", false);
        } else if (Intrinsics.areEqual(cls, "MaterialVariant")) {
            instance.set("BaseMaterial", new EnumValue(256), false);
            Iterator it2 = CollectionsKt.listOf((Object[]) new String[]{"ColorMap", "NormalMap", "MetalnessMap", "RoughnessMap"}).iterator();
            while (it2.hasNext()) {
                instance.set((String) it2.next(), "", false);
            }
            instance.set("StudsPerTile", Float.valueOf(10.0f), false);
            instance.set("MaterialPattern", new EnumValue(0), false);
        } else if (Intrinsics.areEqual(cls, "MaterialService")) {
            instance.set("Use2022MaterialsXml", true, false);
            LinkedHashMap<String, Integer> linkedHashMap = Enums.INSTANCE.getTypes().get("Material");
            Intrinsics.checkNotNull(linkedHashMap);
            for (String str : linkedHashMap.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                String str2 = str;
                if (!SetsKt.setOf((Object[]) new String[]{"Air", "Water", "Neon", "Glass", "ForceField"}).contains(str2)) {
                    instance.set(str2 + "Name", str2, false);
                }
            }
        }
        extraDefaults(instance, cls);
        return instance;
    }
}
