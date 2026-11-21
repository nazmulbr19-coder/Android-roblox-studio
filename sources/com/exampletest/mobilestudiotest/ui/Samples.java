package com.exampletest.mobilestudiotest.ui;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.exampletest.mobilestudiotest.model.UDim2;
import com.exampletest.mobilestudiotest.model.Vector2;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ToolboxPanel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u0002R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Samples;", "", "<init>", "()V", "part", "Lcom/exampletest/mobilestudiotest/model/Instance;", "name", "", "size", "Lcom/exampletest/mobilestudiotest/model/Vector3;", TypedValues.Custom.S_COLOR, "Lcom/exampletest/mobilestudiotest/model/Color3;", "neon", "", "script", "", "parent", "src", "cls", "all", "", "Lcom/exampletest/mobilestudiotest/ui/Samples$Sample;", "getAll", "()Ljava/util/List;", "Sample", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Samples {
    public static final Samples INSTANCE = new Samples();
    private static final List<Sample> all = CollectionsKt.listOf((Object[]) new Sample[]{new Sample("Part", "Kill Brick", new Samples$$ExternalSyntheticLambda0()), new Sample("Script", "Spinner", new Samples$$ExternalSyntheticLambda1()), new Sample("SpawnLocation", "Jump Pad", new Samples$$ExternalSyntheticLambda2()), new Sample("ClickDetector", "Click Color", new Samples$$ExternalSyntheticLambda3()), new Sample("ProximityPrompt", "Tween Door", new Samples$$ExternalSyntheticLambda4()), new Sample("ScreenGui", "Click Counter GUI", new Samples$$ExternalSyntheticLambda5()), new Sample("Folder", "Falling Blocks", new Samples$$ExternalSyntheticLambda6())});

    /* compiled from: ToolboxPanel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Samples$Sample;", "", "icon", "", "name", "build", "Lkotlin/Function0;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getIcon", "()Ljava/lang/String;", "getName", "getBuild", "()Lkotlin/jvm/functions/Function0;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Sample {
        private final Function0<Instance> build;
        private final String icon;
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public Sample(String icon, String name, Function0<? extends Instance> build) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(build, "build");
            this.icon = icon;
            this.name = name;
            this.build = build;
        }

        public final Function0<Instance> getBuild() {
            return this.build;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getName() {
            return this.name;
        }
    }

    private Samples() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance all$lambda$1() {
        Instance part = INSTANCE.part("KillBrick", new Vector3(8.0f, 1.0f, 8.0f), new Color3(1.0f, 0.1f, 0.1f), true);
        script$default(INSTANCE, part, "KillScript", "\n                    local part = script.Parent\n                    part.Touched:Connect(function(hit)\n                        local humanoid = hit.Parent:FindFirstChildOfClass(\"Humanoid\")\n                        if humanoid then\n                            humanoid.Health = 0\n                        end\n                    end)\n                ", null, 8, null);
        return part;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance all$lambda$10() {
        Instance create = InstanceFactory.INSTANCE.create("ScreenGui");
        create.setName("ClickCounter");
        Instance create2 = InstanceFactory.INSTANCE.create("TextButton");
        create2.setName("Button");
        create2.set("Size", new UDim2(0.0f, 220, 0.0f, 60), false);
        create2.set("Position", new UDim2(0.5f, 0, 0.0f, 20), false);
        create2.set("AnchorPoint", new Vector2(0.5f, 0.0f), false);
        create2.set("BackgroundColor3", Color3.INSTANCE.fromRGB(14, 122, 206), false);
        create2.set("TextColor3", new Color3(1.0f, 1.0f, 1.0f), false);
        create2.set("TextSize", Float.valueOf(22.0f), false);
        create2.set("Font", new EnumValue(19), false);
        create2.set("Text", "Clicks: 0", false);
        create2.attachRaw(create);
        InstanceFactory.INSTANCE.create("UICorner").attachRaw(create2);
        INSTANCE.script(create2, "Counter", "\n                local button = script.Parent\n                local clicks = 0\n                button.MouseButton1Click:Connect(function()\n                    clicks += 1\n                    button.Text = `Clicks: {clicks}`\n                end)\n            ", "LocalScript");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance all$lambda$11() {
        Instance create = InstanceFactory.INSTANCE.create("Folder");
        create.setName("FallingBlocks");
        for (int i = 0; i < 6; i++) {
            Instance part$default = part$default(INSTANCE, "Block" + i, new Vector3(2.0f, 2.0f, 2.0f), Color3.INSTANCE.fromHSV(i / 6.0f, 0.7f, 1.0f), false, 8, null);
            part$default.set("Anchored", false, false);
            part$default.set("CFrame", new CFrame((i % 3) * 3.0f, 10.0f + (i * 3.0f), (i / 3) * 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null), false);
            part$default.attachRaw(create);
        }
        return create;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance all$lambda$3() {
        Instance part$default = part$default(INSTANCE, "Spinner", new Vector3(12.0f, 1.0f, 2.0f), Color3.INSTANCE.fromRGB(255, 176, 0), false, 8, null);
        script$default(INSTANCE, part$default, "Spin", "\n                    local RunService = game:GetService(\"RunService\")\n                    local part = script.Parent\n                    local speed = 2 -- radians per second\n                    RunService.Heartbeat:Connect(function(dt)\n                        part.CFrame = part.CFrame * CFrame.Angles(0, speed * dt, 0)\n                    end)\n                ", null, 8, null);
        return part$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance all$lambda$5() {
        Instance part = INSTANCE.part("JumpPad", new Vector3(6.0f, 0.5f, 6.0f), Color3.INSTANCE.fromRGB(0, 255, 120), true);
        script$default(INSTANCE, part, "Launch", "\n                    local pad = script.Parent\n                    local debounce = {}\n                    pad.Touched:Connect(function(hit)\n                        local character = hit.Parent\n                        local root = character and character:FindFirstChild(\"HumanoidRootPart\")\n                        if root and not debounce[character] then\n                            debounce[character] = true\n                            root.AssemblyLinearVelocity = Vector3.new(0, 120, 0)\n                            task.wait(0.5)\n                            debounce[character] = nil\n                        end\n                    end)\n                ", null, 8, null);
        return part;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance all$lambda$7() {
        Instance part$default = part$default(INSTANCE, "ColorButton", new Vector3(4.0f, 4.0f, 4.0f), Color3.INSTANCE.fromRGB(13, 105, 172), false, 8, null);
        InstanceFactory.INSTANCE.create("ClickDetector").attachRaw(part$default);
        script$default(INSTANCE, part$default, "OnClick", "\n                    local part = script.Parent\n                    part.ClickDetector.MouseClick:Connect(function(player)\n                        part.Color = Color3.fromHSV(math.random(), 0.8, 1)\n                        print(player.Name .. \" changed the color!\")\n                    end)\n                ", null, 8, null);
        return part$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance all$lambda$9() {
        Instance part$default = part$default(INSTANCE, "Door", new Vector3(6.0f, 10.0f, 1.0f), Color3.INSTANCE.fromRGB(124, 92, 70), false, 8, null);
        Instance create = InstanceFactory.INSTANCE.create("ProximityPrompt");
        create.set("ActionText", "Open", false);
        create.attachRaw(part$default);
        script$default(INSTANCE, part$default, "DoorScript", "\n                    local TweenService = game:GetService(\"TweenService\")\n                    local door = script.Parent\n                    local closed = door.CFrame\n                    local open = closed * CFrame.new(0, 9, 0)\n                    local isOpen = false\n                    local info = TweenInfo.new(0.6, Enum.EasingStyle.Quad, Enum.EasingDirection.Out)\n\n                    door.ProximityPrompt.Triggered:Connect(function()\n                        isOpen = not isOpen\n                        door.ProximityPrompt.ActionText = if isOpen then \"Close\" else \"Open\"\n                        TweenService:Create(door, info, { CFrame = if isOpen then open else closed }):Play()\n                    end)\n                ", null, 8, null);
        return part$default;
    }

    private final Instance part(String name, Vector3 size, Color3 color, boolean neon) {
        Instance create = InstanceFactory.INSTANCE.create("Part");
        create.setName(name);
        create.set("size", size, false);
        create.set("Color3uint8", color, false);
        create.set("Anchored", true, false);
        if (neon) {
            create.set("Material", new EnumValue(288), false);
        }
        return create;
    }

    static /* synthetic */ Instance part$default(Samples samples, String str, Vector3 vector3, Color3 color3, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return samples.part(str, vector3, color3, z);
    }

    private final void script(Instance parent, String name, String src, String cls) {
        Instance create = InstanceFactory.INSTANCE.create(cls);
        create.setName(name);
        create.set("Source", StringsKt.trimIndent(src) + "\n", false);
        create.attachRaw(parent);
    }

    static /* synthetic */ void script$default(Samples samples, Instance instance, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "Script";
        }
        samples.script(instance, str, str2, str3);
    }

    public final List<Sample> getAll() {
        return all;
    }
}
