package com.exampletest.mobilestudiotest.ui;

import android.graphics.drawable.Drawable;
import com.exampletest.mobilestudiotest.model.ClassDb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BuiltinIcons.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0011\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0012\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0014\u001a)\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\n0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0018\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0019\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u001a\u001a#\u0012\u0004\u0012\u00020\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u001f\u001a#\u0012\u0004\u0012\u00020\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\"\u001a#\u0012\u0004\u0012\u00020\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u000b¢\u0006\u0002\b\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/BuiltinIcons;", "", "<init>", "()V", "W", "", "script", "Lkotlin/Function1;", "Lcom/exampletest/mobilestudiotest/ui/IconPainter;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/exampletest/mobilestudiotest/ui/D;", "localScript", "moduleScript", "part", "model", "folder", "person", "humanoid", "gui", "valueTag", "Lkotlin/Function2;", "", "constraint", "weld", "light", "instanceIcons", "", "instance", "Landroid/graphics/drawable/Drawable;", "cls", "generalIcons", "general", "name", "uiIcons", "ui", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BuiltinIcons {
    private static final int W = -1;
    private static final Map<String, Function1<IconPainter, Unit>> generalIcons;
    private static final Map<String, Function1<IconPainter, Unit>> instanceIcons;
    private static final Map<String, Function1<IconPainter, Unit>> uiIcons;
    public static final BuiltinIcons INSTANCE = new BuiltinIcons();
    private static final Function1<IconPainter, Unit> script = new BuiltinIcons$$ExternalSyntheticLambda1();
    private static final Function1<IconPainter, Unit> localScript = new BuiltinIcons$$ExternalSyntheticLambda112();
    private static final Function1<IconPainter, Unit> moduleScript = new BuiltinIcons$$ExternalSyntheticLambda125();
    private static final Function1<IconPainter, Unit> part = new BuiltinIcons$$ExternalSyntheticLambda136();
    private static final Function1<IconPainter, Unit> model = new BuiltinIcons$$ExternalSyntheticLambda147();
    private static final Function1<IconPainter, Unit> folder = new BuiltinIcons$$ExternalSyntheticLambda158();
    private static final Function1<IconPainter, Unit> person = new BuiltinIcons$$ExternalSyntheticLambda169();
    private static final Function1<IconPainter, Unit> humanoid = new BuiltinIcons$$ExternalSyntheticLambda180();
    private static final Function1<IconPainter, Unit> gui = new BuiltinIcons$$ExternalSyntheticLambda191();
    private static final Function2<Integer, String, Function1<IconPainter, Unit>> valueTag = new BuiltinIcons$$ExternalSyntheticLambda202();
    private static final Function1<IconPainter, Unit> constraint = new BuiltinIcons$$ExternalSyntheticLambda12();
    private static final Function1<IconPainter, Unit> weld = new BuiltinIcons$$ExternalSyntheticLambda23();
    private static final Function1<IconPainter, Unit> light = new BuiltinIcons$$ExternalSyntheticLambda34();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Part", part);
        hashMap.put("BasePart", part);
        hashMap.put("FormFactorPart", part);
        hashMap.put("Platform", part);
        hashMap.put("WedgePart", new BuiltinIcons$$ExternalSyntheticLambda45());
        hashMap.put("CornerWedgePart", new BuiltinIcons$$ExternalSyntheticLambda56());
        hashMap.put("TrussPart", new BuiltinIcons$$ExternalSyntheticLambda67());
        hashMap.put("SpawnLocation", new BuiltinIcons$$ExternalSyntheticLambda78());
        hashMap.put("Seat", new BuiltinIcons$$ExternalSyntheticLambda89());
        hashMap.put("MeshPart", new BuiltinIcons$$ExternalSyntheticLambda100());
        hashMap.put("UnionOperation", new BuiltinIcons$$ExternalSyntheticLambda111());
        hashMap.put("PartOperation", new BuiltinIcons$$ExternalSyntheticLambda115());
        hashMap.put("IntersectOperation", new BuiltinIcons$$ExternalSyntheticLambda116());
        hashMap.put("NegateOperation", new BuiltinIcons$$ExternalSyntheticLambda117());
        hashMap.put("Terrain", new BuiltinIcons$$ExternalSyntheticLambda118());
        hashMap.put("Model", model);
        hashMap.put("WorldModel", model);
        hashMap.put("Status", model);
        hashMap.put("Folder", folder);
        hashMap.put("StarterPlayerScripts", folder);
        hashMap.put("StarterCharacterScripts", folder);
        hashMap.put("Configuration", new BuiltinIcons$$ExternalSyntheticLambda119());
        hashMap.put("Workspace", new BuiltinIcons$$ExternalSyntheticLambda120());
        hashMap.put("Camera", new BuiltinIcons$$ExternalSyntheticLambda121());
        hashMap.put("Players", person);
        hashMap.put("Player", person);
        hashMap.put("StarterPlayer", new BuiltinIcons$$ExternalSyntheticLambda122());
        hashMap.put("Lighting", light);
        hashMap.put("PointLight", new BuiltinIcons$$ExternalSyntheticLambda123());
        hashMap.put("SpotLight", new BuiltinIcons$$ExternalSyntheticLambda124());
        hashMap.put("SurfaceLight", new BuiltinIcons$$ExternalSyntheticLambda126());
        hashMap.put("MaterialService", new BuiltinIcons$$ExternalSyntheticLambda127());
        hashMap.put("ReplicatedFirst", new BuiltinIcons$$ExternalSyntheticLambda128());
        hashMap.put("ReplicatedStorage", new BuiltinIcons$$ExternalSyntheticLambda129());
        hashMap.put("ServerStorage", new BuiltinIcons$$ExternalSyntheticLambda130());
        hashMap.put("ServerScriptService", new BuiltinIcons$$ExternalSyntheticLambda131());
        hashMap.put("StarterGui", gui);
        hashMap.put("PlayerGui", gui);
        hashMap.put("CoreGui", gui);
        hashMap.put("StarterPack", new BuiltinIcons$$ExternalSyntheticLambda132());
        hashMap.put("Backpack", new BuiltinIcons$$ExternalSyntheticLambda133());
        hashMap.put("PlayerScripts", localScript);
        hashMap.put("Teams", new BuiltinIcons$$ExternalSyntheticLambda134());
        hashMap.put("Team", new BuiltinIcons$$ExternalSyntheticLambda135());
        hashMap.put("SoundService", new BuiltinIcons$$ExternalSyntheticLambda137());
        hashMap.put("Sound", new BuiltinIcons$$ExternalSyntheticLambda138());
        hashMap.put("SoundGroup", new BuiltinIcons$$ExternalSyntheticLambda139());
        hashMap.put("Chat", new BuiltinIcons$$ExternalSyntheticLambda140());
        hashMap.put("TextChatService", new BuiltinIcons$$ExternalSyntheticLambda141());
        hashMap.put("LocalizationService", new BuiltinIcons$$ExternalSyntheticLambda142());
        hashMap.put("TestService", new BuiltinIcons$$ExternalSyntheticLambda143());
        hashMap.put("Script", script);
        hashMap.put("LocalScript", localScript);
        hashMap.put("ModuleScript", moduleScript);
        hashMap.put("LuaSourceContainer", script);
        hashMap.put("BaseScript", script);
        hashMap.put("ScreenGui", new BuiltinIcons$$ExternalSyntheticLambda144());
        hashMap.put("BillboardGui", new BuiltinIcons$$ExternalSyntheticLambda145());
        hashMap.put("SurfaceGui", new BuiltinIcons$$ExternalSyntheticLambda146());
        hashMap.put("Frame", new BuiltinIcons$$ExternalSyntheticLambda148());
        hashMap.put("TextLabel", new BuiltinIcons$$ExternalSyntheticLambda149());
        hashMap.put("TextButton", new BuiltinIcons$$ExternalSyntheticLambda150());
        hashMap.put("TextBox", new BuiltinIcons$$ExternalSyntheticLambda151());
        hashMap.put("ImageLabel", new BuiltinIcons$$ExternalSyntheticLambda152());
        hashMap.put("ImageButton", new BuiltinIcons$$ExternalSyntheticLambda153());
        hashMap.put("ScrollingFrame", new BuiltinIcons$$ExternalSyntheticLambda154());
        hashMap.put("ViewportFrame", new BuiltinIcons$$ExternalSyntheticLambda155());
        hashMap.put("CanvasGroup", new BuiltinIcons$$ExternalSyntheticLambda156());
        hashMap.put("VideoFrame", new BuiltinIcons$$ExternalSyntheticLambda157());
        hashMap.put("UICorner", new BuiltinIcons$$ExternalSyntheticLambda159());
        hashMap.put("UIStroke", new BuiltinIcons$$ExternalSyntheticLambda160());
        hashMap.put("UIGradient", new BuiltinIcons$$ExternalSyntheticLambda161());
        hashMap.put("UIPadding", new BuiltinIcons$$ExternalSyntheticLambda162());
        hashMap.put("UIListLayout", new BuiltinIcons$$ExternalSyntheticLambda163());
        hashMap.put("UIGridLayout", new BuiltinIcons$$ExternalSyntheticLambda164());
        hashMap.put("UITableLayout", new BuiltinIcons$$ExternalSyntheticLambda165());
        hashMap.put("UIPageLayout", new BuiltinIcons$$ExternalSyntheticLambda166());
        hashMap.put("UIScale", new BuiltinIcons$$ExternalSyntheticLambda167());
        hashMap.put("UIAspectRatioConstraint", new BuiltinIcons$$ExternalSyntheticLambda168());
        hashMap.put("UISizeConstraint", new BuiltinIcons$$ExternalSyntheticLambda170());
        hashMap.put("UITextSizeConstraint", new BuiltinIcons$$ExternalSyntheticLambda171());
        hashMap.put("Decal", new BuiltinIcons$$ExternalSyntheticLambda172());
        hashMap.put("Texture", new BuiltinIcons$$ExternalSyntheticLambda173());
        hashMap.put("SpecialMesh", new BuiltinIcons$$ExternalSyntheticLambda174());
        hashMap.put("BlockMesh", new BuiltinIcons$$ExternalSyntheticLambda175());
        hashMap.put("CylinderMesh", new BuiltinIcons$$ExternalSyntheticLambda176());
        hashMap.put("Humanoid", humanoid);
        hashMap.put("HumanoidDescription", humanoid);
        hashMap.put("Animator", new BuiltinIcons$$ExternalSyntheticLambda177());
        hashMap.put("AnimationController", new BuiltinIcons$$ExternalSyntheticLambda178());
        hashMap.put("Animation", new BuiltinIcons$$ExternalSyntheticLambda179());
        hashMap.put("KeyframeSequence", new BuiltinIcons$$ExternalSyntheticLambda181());
        hashMap.put("Tool", new BuiltinIcons$$ExternalSyntheticLambda182());
        hashMap.put("HopperBin", new BuiltinIcons$$ExternalSyntheticLambda183());
        hashMap.put("Accessory", new BuiltinIcons$$ExternalSyntheticLambda184());
        hashMap.put("Hat", new BuiltinIcons$$ExternalSyntheticLambda185());
        hashMap.put("Shirt", new BuiltinIcons$$ExternalSyntheticLambda186());
        hashMap.put("ShirtGraphic", new BuiltinIcons$$ExternalSyntheticLambda187());
        hashMap.put("Pants", new BuiltinIcons$$ExternalSyntheticLambda188());
        hashMap.put("BodyColors", new BuiltinIcons$$ExternalSyntheticLambda189());
        hashMap.put("Attachment", new BuiltinIcons$$ExternalSyntheticLambda190());
        hashMap.put("Bone", new BuiltinIcons$$ExternalSyntheticLambda192());
        hashMap.put("Weld", weld);
        hashMap.put("ManualWeld", weld);
        hashMap.put("Snap", weld);
        hashMap.put("Glue", weld);
        hashMap.put("WeldConstraint", weld);
        hashMap.put("NoCollisionConstraint", new BuiltinIcons$$ExternalSyntheticLambda193());
        hashMap.put("Motor", new BuiltinIcons$$ExternalSyntheticLambda194());
        hashMap.put("Motor6D", new BuiltinIcons$$ExternalSyntheticLambda195());
        hashMap.put("Constraint", constraint);
        hashMap.put("ClickDetector", new BuiltinIcons$$ExternalSyntheticLambda196());
        hashMap.put("ProximityPrompt", new BuiltinIcons$$ExternalSyntheticLambda197());
        hashMap.put("ParticleEmitter", new BuiltinIcons$$ExternalSyntheticLambda198());
        hashMap.put("Fire", new BuiltinIcons$$ExternalSyntheticLambda199());
        hashMap.put("Smoke", new BuiltinIcons$$ExternalSyntheticLambda200());
        hashMap.put("Sparkles", new BuiltinIcons$$ExternalSyntheticLambda201());
        hashMap.put("Trail", new BuiltinIcons$$ExternalSyntheticLambda2());
        hashMap.put("Beam", new BuiltinIcons$$ExternalSyntheticLambda3());
        hashMap.put("Explosion", new BuiltinIcons$$ExternalSyntheticLambda4());
        hashMap.put("Highlight", new BuiltinIcons$$ExternalSyntheticLambda5());
        hashMap.put("ForceField", new BuiltinIcons$$ExternalSyntheticLambda6());
        hashMap.put("SelectionBox", new BuiltinIcons$$ExternalSyntheticLambda7());
        hashMap.put("Sky", new BuiltinIcons$$ExternalSyntheticLambda8());
        hashMap.put("Clouds", new BuiltinIcons$$ExternalSyntheticLambda9());
        hashMap.put("Atmosphere", new BuiltinIcons$$ExternalSyntheticLambda10());
        hashMap.put("BloomEffect", new BuiltinIcons$$ExternalSyntheticLambda11());
        hashMap.put("BlurEffect", new BuiltinIcons$$ExternalSyntheticLambda13());
        hashMap.put("ColorCorrectionEffect", new BuiltinIcons$$ExternalSyntheticLambda14());
        hashMap.put("SunRaysEffect", new BuiltinIcons$$ExternalSyntheticLambda15());
        hashMap.put("DepthOfFieldEffect", new BuiltinIcons$$ExternalSyntheticLambda16());
        Function2<Integer, String, Function1<IconPainter, Unit>> function2 = valueTag;
        Integer valueOf = Integer.valueOf(IconPainter.PURPLE);
        hashMap.put("StringValue", function2.invoke(valueOf, "S"));
        hashMap.put("IntValue", valueTag.invoke(valueOf, "#"));
        hashMap.put("NumberValue", valueTag.invoke(valueOf, "#"));
        hashMap.put("BoolValue", valueTag.invoke(valueOf, "B"));
        hashMap.put("ObjectValue", valueTag.invoke(valueOf, "O"));
        hashMap.put("Vector3Value", valueTag.invoke(valueOf, "V"));
        hashMap.put("CFrameValue", valueTag.invoke(valueOf, "C"));
        Function2<Integer, String, Function1<IconPainter, Unit>> function22 = valueTag;
        Integer valueOf2 = Integer.valueOf(IconPainter.RED);
        hashMap.put("Color3Value", function22.invoke(valueOf2, "C"));
        hashMap.put("BrickColorValue", valueTag.invoke(valueOf2, "B"));
        hashMap.put("RayValue", valueTag.invoke(valueOf, "R"));
        hashMap.put("ValueBase", valueTag.invoke(valueOf, "V"));
        hashMap.put("RemoteEvent", new BuiltinIcons$$ExternalSyntheticLambda17());
        hashMap.put("UnreliableRemoteEvent", new BuiltinIcons$$ExternalSyntheticLambda18());
        hashMap.put("RemoteFunction", new BuiltinIcons$$ExternalSyntheticLambda19());
        hashMap.put("BindableEvent", new BuiltinIcons$$ExternalSyntheticLambda20());
        hashMap.put("BindableFunction", new BuiltinIcons$$ExternalSyntheticLambda21());
        hashMap.put("Plugin", new BuiltinIcons$$ExternalSyntheticLambda22());
        hashMap.put("Dialog", new BuiltinIcons$$ExternalSyntheticLambda24());
        hashMap.put("DialogChoice", new BuiltinIcons$$ExternalSyntheticLambda25());
        hashMap.put("Selection", new BuiltinIcons$$ExternalSyntheticLambda26());
        hashMap.put("DataModel", new BuiltinIcons$$ExternalSyntheticLambda27());
        hashMap.put("Message", new BuiltinIcons$$ExternalSyntheticLambda28());
        hashMap.put("Hint", new BuiltinIcons$$ExternalSyntheticLambda29());
        hashMap.put("VehicleSeat", new BuiltinIcons$$ExternalSyntheticLambda30());
        instanceIcons = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Select", new BuiltinIcons$$ExternalSyntheticLambda31());
        hashMap2.put("Move", new BuiltinIcons$$ExternalSyntheticLambda32());
        hashMap2.put("Scale", new BuiltinIcons$$ExternalSyntheticLambda33());
        hashMap2.put("Rotate", new BuiltinIcons$$ExternalSyntheticLambda35());
        hashMap2.put("Part_Block", part);
        hashMap2.put("Part", part);
        hashMap2.put("Part_Sphere", new BuiltinIcons$$ExternalSyntheticLambda36());
        hashMap2.put("Part_Cylinder", new BuiltinIcons$$ExternalSyntheticLambda37());
        hashMap2.put("Part_Wedge", new BuiltinIcons$$ExternalSyntheticLambda38());
        hashMap2.put("Part_CornerWedge", new BuiltinIcons$$ExternalSyntheticLambda39());
        Function1<IconPainter, Unit> function1 = instanceIcons.get("SpawnLocation");
        Intrinsics.checkNotNull(function1);
        hashMap2.put("Spawn", function1);
        hashMap2.put("InsertObject", new BuiltinIcons$$ExternalSyntheticLambda40());
        hashMap2.put("Anchor", new BuiltinIcons$$ExternalSyntheticLambda41());
        hashMap2.put("Group", new BuiltinIcons$$ExternalSyntheticLambda42());
        hashMap2.put("Union", new BuiltinIcons$$ExternalSyntheticLambda43());
        hashMap2.put("Intersect", new BuiltinIcons$$ExternalSyntheticLambda44());
        hashMap2.put("Negate", new BuiltinIcons$$ExternalSyntheticLambda46());
        hashMap2.put("Separate", new BuiltinIcons$$ExternalSyntheticLambda47());
        hashMap2.put("BoxSelect", new BuiltinIcons$$ExternalSyntheticLambda48());
        hashMap2.put("Ungroup", new BuiltinIcons$$ExternalSyntheticLambda49());
        hashMap2.put("Duplicate", new BuiltinIcons$$ExternalSyntheticLambda50());
        hashMap2.put("Delete", new BuiltinIcons$$ExternalSyntheticLambda51());
        hashMap2.put("ZoomTo", new BuiltinIcons$$ExternalSyntheticLambda52());
        hashMap2.put("FindAll", new BuiltinIcons$$ExternalSyntheticLambda53());
        hashMap2.put("Move_P", new BuiltinIcons$$ExternalSyntheticLambda54());
        hashMap2.put("Rotate_P", new BuiltinIcons$$ExternalSyntheticLambda55());
        hashMap2.put("Color", new BuiltinIcons$$ExternalSyntheticLambda57());
        hashMap2.put("Material", new BuiltinIcons$$ExternalSyntheticLambda58());
        hashMap2.put("Surface", new BuiltinIcons$$ExternalSyntheticLambda59());
        hashMap2.put("Cleanup", new BuiltinIcons$$ExternalSyntheticLambda60());
        hashMap2.put("CommandBar", new BuiltinIcons$$ExternalSyntheticLambda61());
        hashMap2.put("Explorer", new BuiltinIcons$$ExternalSyntheticLambda62());
        hashMap2.put("Properties", new BuiltinIcons$$ExternalSyntheticLambda63());
        hashMap2.put("Toolbox", new BuiltinIcons$$ExternalSyntheticLambda64());
        hashMap2.put("Output", new BuiltinIcons$$ExternalSyntheticLambda65());
        hashMap2.put("SwitchWindows", new BuiltinIcons$$ExternalSyntheticLambda66());
        hashMap2.put("Effects", new BuiltinIcons$$ExternalSyntheticLambda68());
        hashMap2.put("ViewSelector", new BuiltinIcons$$ExternalSyntheticLambda69());
        hashMap2.put("Fwd", new BuiltinIcons$$ExternalSyntheticLambda70());
        hashMap2.put("Fly", new BuiltinIcons$$ExternalSyntheticLambda71());
        hashMap2.put("ManagePlugins", new BuiltinIcons$$ExternalSyntheticLambda72());
        hashMap2.put("PluginsFolder", new BuiltinIcons$$ExternalSyntheticLambda73());
        hashMap2.put("Place", new BuiltinIcons$$ExternalSyntheticLambda74());
        hashMap2.put("Settings", new BuiltinIcons$$ExternalSyntheticLambda75());
        hashMap2.put("Open", new BuiltinIcons$$ExternalSyntheticLambda76());
        hashMap2.put("Save", new BuiltinIcons$$ExternalSyntheticLambda77());
        hashMap2.put("Back", new BuiltinIcons$$ExternalSyntheticLambda79());
        hashMap2.put("History", new BuiltinIcons$$ExternalSyntheticLambda80());
        hashMap2.put("Download", new BuiltinIcons$$ExternalSyntheticLambda81());
        hashMap2.put("Publish", new BuiltinIcons$$ExternalSyntheticLambda82());
        hashMap2.put("Cloud", new BuiltinIcons$$ExternalSyntheticLambda83());
        hashMap2.put("Account", new BuiltinIcons$$ExternalSyntheticLambda84());
        hashMap2.put(StartScreen.HOME, new BuiltinIcons$$ExternalSyntheticLambda85());
        hashMap2.put("Shared", new BuiltinIcons$$ExternalSyntheticLambda86());
        hashMap2.put("Info", new BuiltinIcons$$ExternalSyntheticLambda87());
        hashMap2.put("Video", new BuiltinIcons$$ExternalSyntheticLambda88());
        hashMap2.put("Theme", new BuiltinIcons$$ExternalSyntheticLambda90());
        hashMap2.put("HideWindows", new BuiltinIcons$$ExternalSyntheticLambda91());
        hashMap2.put("ShowWindows", new BuiltinIcons$$ExternalSyntheticLambda92());
        hashMap2.put("RunScript", new BuiltinIcons$$ExternalSyntheticLambda93());
        hashMap2.put("Play", new BuiltinIcons$$ExternalSyntheticLambda94());
        hashMap2.put("Stop", new BuiltinIcons$$ExternalSyntheticLambda95());
        hashMap2.put("Undo", new BuiltinIcons$$ExternalSyntheticLambda96());
        hashMap2.put("Redo", new BuiltinIcons$$ExternalSyntheticLambda97());
        hashMap2.put("SelectAll", new BuiltinIcons$$ExternalSyntheticLambda98());
        hashMap2.put("CollapseAll", new BuiltinIcons$$ExternalSyntheticLambda99());
        hashMap2.put("ScriptAnalysis", new BuiltinIcons$$ExternalSyntheticLambda101());
        hashMap2.put("Audio", new BuiltinIcons$$ExternalSyntheticLambda102());
        Function1<IconPainter, Unit> function12 = instanceIcons.get("MeshPart");
        Intrinsics.checkNotNull(function12);
        hashMap2.put("Mesh", function12);
        Function1<IconPainter, Unit> function13 = instanceIcons.get("Decal");
        Intrinsics.checkNotNull(function13);
        hashMap2.put("Decal", function13);
        hashMap2.put("Model", model);
        Function1<IconPainter, Unit> function14 = instanceIcons.get("Plugin");
        Intrinsics.checkNotNull(function14);
        hashMap2.put("Plugin", function14);
        hashMap2.put("Link", new BuiltinIcons$$ExternalSyntheticLambda103());
        hashMap2.put("Pin", new BuiltinIcons$$ExternalSyntheticLambda104());
        hashMap2.put("Copy", new BuiltinIcons$$ExternalSyntheticLambda105());
        hashMap2.put("Cut", new BuiltinIcons$$ExternalSyntheticLambda106());
        hashMap2.put("Paste", new BuiltinIcons$$ExternalSyntheticLambda107());
        hashMap2.put("Lock", new BuiltinIcons$$ExternalSyntheticLambda108());
        hashMap2.put("Collisions", new BuiltinIcons$$ExternalSyntheticLambda109());
        generalIcons = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("CloseWidget", new BuiltinIcons$$ExternalSyntheticLambda110());
        hashMap3.put("Float", new BuiltinIcons$$ExternalSyntheticLambda113());
        hashMap3.put("Grip", new BuiltinIcons$$ExternalSyntheticLambda114());
        uiIcons = hashMap3;
    }

    private BuiltinIcons() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit constraint$lambda$11(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        iconPainter.chain(IconPainter.ORANGE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit folder$lambda$5(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        iconPainter.poly(-2513632, 2.0f, 6.0f, 9.0f, 6.0f, 11.0f, 8.0f, 22.0f, 8.0f, 22.0f, 20.0f, 2.0f, 20.0f);
        iconPainter.rect(2.0f, 9.5f, 22.0f, 20.0f, IconPainter.YELLOW, 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$130(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(put.getFg(), 6.0f, 2.5f, 6.0f, 19.5f, 10.0f, 15.5f, 13.0f, 22.0f, 16.0f, 20.8f, 13.0f, 14.5f, 18.5f, 14.5f);
        put.spoly(Ui.INSTANCE.getPANEL(), 1.0f, 6.0f, 2.5f, 6.0f, 19.5f, 10.0f, 15.5f, 13.0f, 22.0f, 16.0f, 20.8f, 13.0f, 14.5f, 18.5f, 14.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$131(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.line(12.0f, 3.0f, 12.0f, 21.0f, put.getFg(), 2.0f);
        put.line(3.0f, 12.0f, 21.0f, 12.0f, put.getFg(), 2.0f);
        put.arrowHead(12.0f, 3.0f, 0.0f, 3.0f, IconPainter.GREEN);
        put.arrowHead(12.0f, 21.0f, 180.0f, 3.0f, IconPainter.GREEN);
        put.arrowHead(3.0f, 12.0f, 270.0f, 3.0f, IconPainter.RED);
        put.arrowHead(21.0f, 12.0f, 90.0f, 3.0f, IconPainter.RED);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$132(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 9.0f, 15.0f, 21.0f, put.getFg(), 1.8f, 1.0f);
        put.line(10.0f, 14.0f, 20.0f, 4.0f, IconPainter.BLUE, 2.0f);
        put.arrowHead(20.5f, 3.5f, 45.0f, 3.0f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$133(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(4.0f, 4.0f, 20.0f, 20.0f, 200.0f, 280.0f, put.getFg(), 2.2f);
        put.arrowHead(5.0f, 9.5f, 200.0f, 3.2f, IconPainter.BLUE);
        put.circle(12.0f, 12.0f, 2.0f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$134(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.0f, IconPainter.GRAY_L);
        put.circle(9.5f, 9.0f, 4.5f, IconPainter.GRAY_T);
        put.circle(13.5f, 14.5f, 4.5f, 570425344);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$135(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.rect$default(put, 5.0f, 7.0f, 19.0f, 18.0f, IconPainter.GRAY_L, 0.0f, 32, null);
        put.arc(5.0f, 15.0f, 19.0f, 21.0f, 0.0f, 180.0f, IconPainter.GRAY_R, 0.1f);
        put.pie(5.0f, 15.0f, 19.0f, 21.0f, 0.0f, 180.0f, IconPainter.GRAY_L);
        put.pie(5.0f, 4.0f, 19.0f, 10.0f, 0.0f, 360.0f, IconPainter.GRAY_T);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$136(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.GRAY_L, 3.0f, 20.0f, 21.0f, 20.0f, 21.0f, 5.0f);
        put.poly(IconPainter.GRAY_T, 3.0f, 20.0f, 21.0f, 5.0f, 21.0f, 8.5f, 6.5f, 20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$137(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.GRAY_L, 3.0f, 20.0f, 12.0f, 3.0f, 12.0f, 20.0f);
        put.poly(IconPainter.GRAY_R, 12.0f, 3.0f, 21.0f, 20.0f, 12.0f, 20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$138(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 3.0f, 21.0f, 21.0f, put.getFg(), 1.6f, 3.0f);
        put.line(12.0f, 7.0f, 12.0f, 17.0f, IconPainter.GREEN, 2.4f);
        put.line(7.0f, 12.0f, 17.0f, 12.0f, IconPainter.GREEN, 2.4f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$139(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.ring(12.0f, 5.0f, 2.2f, put.getFg(), 1.8f);
        put.line(12.0f, 7.0f, 12.0f, 20.0f, put.getFg(), 2.0f);
        put.line(8.0f, 10.0f, 16.0f, 10.0f, put.getFg(), 2.0f);
        put.arc(4.0f, 10.0f, 20.0f, 21.0f, 20.0f, 140.0f, put.getFg(), 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$140(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(2.5f, 2.5f, 21.5f, 21.5f, IconPainter.BLUE, 1.4f, 2.0f);
        IconPainter.cube$default(put, 8.5f, 10.0f, 4.5f, 0, 0, 0, 56, null);
        IconPainter.cube$default(put, 15.5f, 13.5f, 4.5f, 0, 0, 0, 56, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$141(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 7.0f, 15.0f, 19.0f, IconPainter.BLUE, 1.5f);
        put.circle(15.0f, 10.0f, 6.5f, IconPainter.BLUE);
        put.circle(15.0f, 10.0f, 4.6f, IconPainter.LBLUE);
        put.rect(5.0f, 9.0f, 13.0f, 17.0f, IconPainter.LBLUE, 1.0f);
        IconPainter.rect$default(put, 9.0f, 9.0f, 15.0f, 15.0f, IconPainter.LBLUE, 0.0f, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$142(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 7.0f, 15.0f, 19.0f, IconPainter.GRAY_L, 1.4f, 1.5f);
        put.srect(9.0f, 3.0f, 21.0f, 15.0f, IconPainter.GRAY_L, 1.4f, 1.5f);
        put.rect(9.0f, 7.0f, 15.0f, 15.0f, IconPainter.BLUE, 0.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$143(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 7.0f, 15.0f, 19.0f, IconPainter.GRAY_L, 1.5f);
        put.circle(15.0f, 10.0f, 6.5f, -1611124);
        put.circle(15.0f, 10.0f, 4.6f, -744520);
        put.line(12.0f, 10.0f, 18.0f, 10.0f, -1, 1.8f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$144(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.5f, 9.0f, 11.0f, 18.0f, IconPainter.BLUE, 1.5f);
        put.circle(17.0f, 8.0f, 5.0f, IconPainter.BLUE);
        put.line(9.0f, 6.0f, 14.0f, 13.0f, IconPainter.GRAY_L, 1.4f);
        put.pline(IconPainter.GRAY_L, 1.4f, 4.0f, 21.0f, 12.0f, 21.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$145(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 5.0f, 21.0f, 19.0f, IconPainter.BLUE, 1.5f, 1.0f);
        put.rect(7.0f, 9.0f, 13.0f, 15.0f, IconPainter.GRAY_L, 1.0f);
        put.pline(-1, 1.6f, 14.0f, 13.0f, 19.0f, 18.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$146(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.cube$default(put, 7.0f, 9.0f, 4.5f, 0, 0, 0, 56, null);
        IconPainter.cube$default(put, 17.0f, 15.0f, 4.5f, 0, 0, 0, 56, null);
        put.line(4.0f, 20.0f, 20.0f, 4.0f, IconPainter.RED, 1.6f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$147(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.box$default(put, 3.0f, 3.0f, 15.0f, 15.0f, IconPainter.GRAY_T, IconPainter.GRAY_R, 0.0f, 0.0f, 192, null);
        IconPainter.box$default(put, 9.0f, 9.0f, 21.0f, 21.0f, IconPainter.LBLUE, IconPainter.DBLUE, 0.0f, 0.0f, 192, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$148(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(6.0f, 7.0f, 18.0f, 21.0f, IconPainter.RED, 1.5f);
        put.rect(4.0f, 4.5f, 20.0f, 7.0f, IconPainter.RED, 1.0f);
        put.rect(9.5f, 2.5f, 14.5f, 4.5f, IconPainter.RED, 0.8f);
        Iterator it = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(9.5f), Float.valueOf(12.0f), Float.valueOf(14.5f)}).iterator();
        while (it.hasNext()) {
            float floatValue = ((Number) it.next()).floatValue();
            put.line(floatValue, 10.0f, floatValue, 18.0f, -1, 1.2f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$149(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.magnifier(put.getFg());
        put.circle(10.0f, 10.0f, 2.0f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$150(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.magnifier(put.getFg());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$151(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        for (int i = 0; i < 4; i++) {
            put.line((i * 5.33f) + 4.0f, 3.0f, (i * 5.33f) + 4.0f, 21.0f, Ui.INSTANCE.getDIM(), 1.0f);
            put.line(3.0f, (i * 5.33f) + 4.0f, 21.0f, (i * 5.33f) + 4.0f, Ui.INSTANCE.getDIM(), 1.0f);
        }
        put.circle(14.7f, 9.3f, 2.6f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$152(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.line(4.0f, 20.0f, 20.0f, 20.0f, put.getFg(), 1.8f);
        put.line(4.0f, 20.0f, 16.0f, 6.0f, put.getFg(), 1.8f);
        put.arc(-4.0f, 12.0f, 12.0f, 28.0f, -50.0f, 50.0f, IconPainter.BLUE, 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$153(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.5f, -1518160);
        put.circle(8.0f, 8.0f, 2.2f, IconPainter.RED);
        put.circle(13.5f, 6.5f, 2.2f, IconPainter.YELLOW);
        put.circle(17.5f, 11.0f, 2.2f, IconPainter.BLUE);
        put.circle(8.0f, 14.0f, 2.2f, IconPainter.GREEN);
        put.circle(14.0f, 16.5f, 2.5f, Ui.INSTANCE.getPANEL());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$154(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.5f, -6522284);
        for (int i = 0; i < 4; i++) {
            put.arc((i * 1.5f) + 3.0f, (i * 3.0f) + 6.0f, 21.0f - (i * 1.5f), 30.0f, 225.0f, 90.0f, -8758728, 1.3f);
        }
        put.circle(8.5f, 8.5f, 2.5f, 1157627903);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$155(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.cube$default(put, 12.0f, 12.0f, 9.0f, 0, 0, 0, 56, null);
        Float valueOf = Float.valueOf(12.0f);
        Float valueOf2 = Float.valueOf(8.5f);
        Float valueOf3 = Float.valueOf(8.3f);
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(valueOf, Float.valueOf(6.5f)), TuplesKt.to(valueOf2, valueOf3), TuplesKt.to(Float.valueOf(15.5f), valueOf3), TuplesKt.to(valueOf, Float.valueOf(10.0f))})) {
            put.circle(((Number) pair.component1()).floatValue(), ((Number) pair.component2()).floatValue(), 1.1f, IconPainter.GRAY_R);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$156(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.RED, 4.0f, 15.0f, 13.0f, 6.0f, 20.0f, 13.0f, 11.0f, 22.0f);
        put.poly(-673863, 4.0f, 15.0f, 8.0f, 11.0f, 15.0f, 18.0f, 11.0f, 22.0f);
        put.line(2.0f, 22.0f, 22.0f, 22.0f, put.getFg(), 1.4f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$157(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.0f, 4.0f, 22.0f, 20.0f, IconPainter.DARK, 2.0f);
        put.pline(IconPainter.GREEN, 1.8f, 6.0f, 9.0f, 9.0f, 12.0f, 6.0f, 15.0f);
        put.line(11.0f, 15.0f, 16.0f, 15.0f, -1, 1.8f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$158(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 9.0f, 8.0f, IconPainter.YELLOW, 1.0f);
        put.line(6.0f, 8.0f, 6.0f, 18.5f, put.getFg(), 1.4f);
        put.line(6.0f, 12.5f, 11.0f, 12.5f, put.getFg(), 1.4f);
        put.line(6.0f, 18.5f, 11.0f, 18.5f, put.getFg(), 1.4f);
        put.rect(11.0f, 10.0f, 20.0f, 15.0f, IconPainter.BLUE, 1.0f);
        put.rect(11.0f, 16.0f, 20.0f, 21.0f, IconPainter.GRAY_L, 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$159(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        int i = 0;
        while (i < 4) {
            float f = 4.5f + (i * 5.0f);
            put.line(3.0f, f, 9.0f, f, put.getFg(), 1.5f);
            put.rect(11.0f, f - 1.6f, 21.0f, f + 1.6f, i == 1 ? IconPainter.BLUE : IconPainter.GRAY_L, 1.0f);
            i++;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$160(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.0f, 8.0f, 22.0f, 20.0f, IconPainter.RED, 2.0f);
        put.arc(8.0f, 3.0f, 16.0f, 11.0f, 180.0f, 180.0f, put.getFg(), 2.0f);
        IconPainter.rect$default(put, 2.0f, 12.0f, 22.0f, 13.5f, -4900804, 0.0f, 32, null);
        put.rect(10.0f, 11.0f, 14.0f, 15.0f, IconPainter.YELLOW, 0.8f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$161(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.0f, 3.0f, 22.0f, 21.0f, IconPainter.DARK, 2.0f);
        put.line(5.0f, 8.0f, 15.0f, 8.0f, -1, 1.4f);
        put.line(5.0f, 12.0f, 18.0f, 12.0f, IconPainter.YELLOW, 1.4f);
        put.line(5.0f, 16.0f, 12.0f, 16.0f, -34182, 1.4f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$162(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(2.5f, 3.5f, 21.5f, 20.5f, put.getFg(), 1.5f, 1.5f);
        put.line(9.0f, 3.5f, 9.0f, 20.5f, put.getFg(), 1.2f);
        put.line(9.0f, 12.0f, 21.5f, 12.0f, put.getFg(), 1.2f);
        put.rect(2.5f, 3.5f, 9.0f, 20.5f, 1429965803, 1.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$163(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 4.5f, IconPainter.YELLOW);
        for (int i = 0; i < 8; i++) {
            double radians = Math.toRadians(i * 45.0d);
            put.line((((float) Math.cos(radians)) * 7.0f) + 12.0f, (((float) Math.sin(radians)) * 7.0f) + 12.0f, (((float) Math.cos(radians)) * 9.8f) + 12.0f, (((float) Math.sin(radians)) * 9.8f) + 12.0f, IconPainter.YELLOW, 1.8f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$164(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.cube(12.0f, 12.0f, 8.0f, IconPainter.LBLUE, IconPainter.BLUE, IconPainter.DBLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$165(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.BLUE, 3.0f, 5.0f, 12.0f, 12.0f, 3.0f, 19.0f);
        put.poly(IconPainter.BLUE, 12.0f, 5.0f, 21.0f, 12.0f, 12.0f, 19.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$166(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(3.0f, 5.0f, 21.0f, 23.0f, 180.0f, 180.0f, put.getFg(), 2.2f);
        put.line(12.0f, 14.0f, 17.0f, 8.0f, IconPainter.RED, 2.2f);
        put.circle(12.0f, 14.0f, 1.8f, put.getFg());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$167(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(4.0f, 7.0f, 18.0f, 21.0f, IconPainter.BLUE, 2.0f);
        put.circle(11.0f, 6.5f, 3.0f, IconPainter.BLUE);
        put.circle(18.5f, 14.0f, 3.0f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$168(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(4.0f, 4.0f, 20.0f, 20.0f, 30.0f, 300.0f, put.getFg(), 2.2f);
        put.arrowHead(18.8f, 8.0f, 160.0f, 3.0f, put.getFg());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$169(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 21.0f, IconPainter.GREEN, 2.0f);
        put.poly(-13726889, 5.0f, 19.0f, 10.0f, 9.0f, 14.0f, 15.0f, 16.0f, 12.0f, 19.0f, 19.0f);
        put.circle(16.0f, 7.0f, 2.0f, IconPainter.YELLOW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$170(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.gear(12.0f, 12.0f, 8.0f, put.getFg(), Ui.INSTANCE.getPANEL());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$171(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(-2513632, 2.0f, 5.0f, 9.0f, 5.0f, 11.0f, 7.0f, 20.0f, 7.0f, 20.0f, 10.0f, 2.0f, 10.0f);
        put.poly(IconPainter.YELLOW, 2.0f, 20.0f, 5.0f, 10.0f, 23.0f, 10.0f, 20.0f, 20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$172(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 21.0f, IconPainter.BLUE, 2.0f);
        put.rect(7.0f, 3.0f, 17.0f, 9.0f, -1, 0.5f);
        IconPainter.rect$default(put, 13.5f, 4.0f, 15.5f, 8.0f, IconPainter.BLUE, 0.0f, 32, null);
        put.rect(6.0f, 13.0f, 18.0f, 21.0f, IconPainter.PAPER, 0.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$173(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.line(20.0f, 12.0f, 5.0f, 12.0f, put.getFg(), 2.2f);
        put.arrowHead(4.0f, 12.0f, 270.0f, 3.5f, put.getFg());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$174(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(3.0f, 3.0f, 21.0f, 21.0f, 120.0f, 300.0f, put.getFg(), 2.0f);
        put.arrowHead(4.5f, 16.0f, 200.0f, 3.0f, put.getFg());
        put.pline(put.getFg(), 1.8f, 12.0f, 7.0f, 12.0f, 12.0f, 15.5f, 14.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$175(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.line(12.0f, 3.0f, 12.0f, 15.0f, IconPainter.BLUE, 2.4f);
        put.arrowHead(12.0f, 16.0f, 180.0f, 4.0f, IconPainter.BLUE);
        put.pline(put.getFg(), 2.0f, 3.0f, 15.0f, 3.0f, 21.0f, 21.0f, 21.0f, 21.0f, 15.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$176(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.cloud(12.0f, 13.0f, 8.5f, IconPainter.BLUE);
        put.line(12.0f, 19.0f, 12.0f, 10.0f, -1, 2.2f);
        put.arrowHead(12.0f, 9.0f, 0.0f, 3.5f, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$177(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.cloud(12.0f, 13.0f, 8.5f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$178(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 10.0f, IconPainter.BLUE);
        put.person(12.0f, 13.5f, 9.0f, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$179(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.BLUE, 2.5f, 11.5f, 12.0f, 3.0f, 21.5f, 11.5f);
        put.rect(5.0f, 11.0f, 19.0f, 21.0f, IconPainter.LBLUE, 1.0f);
        put.rect(10.0f, 14.5f, 14.0f, 21.0f, IconPainter.DBLUE, 0.6f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$180(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(8.5f, 12.0f, 7.0f, IconPainter.TEAL);
        put.person(8.5f, 13.0f, 6.5f, -1);
        put.circle(15.5f, 12.0f, 7.0f, IconPainter.BLUE);
        put.person(15.5f, 13.0f, 6.5f, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$181(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 10.0f, IconPainter.BLUE);
        put.circle(12.0f, 7.2f, 1.5f, -1);
        put.rect(10.8f, 10.0f, 13.2f, 17.5f, -1, 0.8f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$182(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.0f, 5.0f, 22.0f, 19.0f, IconPainter.RED, 5.0f);
        put.poly(-1, 10.0f, 8.5f, 16.0f, 12.0f, 10.0f, 15.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$183(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.0f, put.getFg());
        put.pie(3.0f, 3.0f, 21.0f, 21.0f, -90.0f, 180.0f, Ui.INSTANCE.getPANEL());
        put.ring(12.0f, 12.0f, 9.0f, put.getFg(), 1.4f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$184(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 3.0f, 21.0f, 21.0f, put.getFg(), 1.4f, 2.0f);
        put.pline(IconPainter.BLUE, 2.0f, 6.0f, 10.0f, 6.0f, 6.0f, 10.0f, 6.0f);
        put.pline(IconPainter.BLUE, 2.0f, 14.0f, 6.0f, 18.0f, 6.0f, 18.0f, 10.0f);
        put.pline(IconPainter.BLUE, 2.0f, 6.0f, 14.0f, 6.0f, 18.0f, 10.0f, 18.0f);
        put.pline(IconPainter.BLUE, 2.0f, 14.0f, 18.0f, 18.0f, 18.0f, 18.0f, 14.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$185(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 3.0f, 21.0f, 21.0f, put.getFg(), 1.4f, 2.0f);
        put.rect(3.0f, 3.0f, 8.0f, 21.0f, 1715178475, 2.0f);
        put.rect(16.0f, 3.0f, 21.0f, 21.0f, 1715178475, 2.0f);
        IconPainter.rect$default(put, 8.0f, 15.0f, 16.0f, 21.0f, 1715178475, 0.0f, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$186(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.GREEN, 6.0f, 4.0f, 20.0f, 12.0f, 6.0f, 20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$187(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.GREEN, 6.0f, 3.5f, 20.0f, 12.0f, 6.0f, 20.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$188(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(5.0f, 5.0f, 19.0f, 19.0f, IconPainter.RED, 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$189(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(5.0f, 6.0f, 20.0f, 21.0f, 180.0f, 230.0f, put.getFg(), 2.2f);
        put.arrowHead(5.5f, 11.5f, 0.0f, 3.2f, put.getFg());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$190(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(4.0f, 6.0f, 19.0f, 21.0f, 130.0f, 230.0f, put.getFg(), 2.2f);
        put.arrowHead(18.5f, 11.5f, 0.0f, 3.2f, put.getFg());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$191(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 3.0f, 13.0f, 13.0f, put.getFg(), 1.5f, 1.5f);
        put.srect(11.0f, 11.0f, 21.0f, 21.0f, IconPainter.BLUE, 1.5f, 1.5f);
        put.pline(IconPainter.BLUE, 1.6f, 13.5f, 16.0f, 15.5f, 18.0f, 18.5f, 14.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$192(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 3.0f, 21.0f, 21.0f, put.getFg(), 1.5f, 2.0f);
        put.line(7.0f, 12.0f, 17.0f, 12.0f, put.getFg(), 2.2f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$193(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.page$default(put, IconPainter.GREEN, 0, 2, null);
        put.pline(IconPainter.GREEN, 2.2f, 9.5f, 13.0f, 12.0f, 16.0f, 17.0f, 9.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$194(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.speaker(IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$195(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.chain(put.getFg());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$196(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 8.0f, 5.0f, IconPainter.RED);
        put.line(12.0f, 12.0f, 12.0f, 21.0f, put.getFg(), 1.8f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$197(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 3.0f, 14.0f, 16.0f, put.getFg(), 1.5f, 1.5f);
        put.rect(9.0f, 8.0f, 21.0f, 21.0f, IconPainter.LBLUE, 1.5f);
        put.srect(9.0f, 8.0f, 21.0f, 21.0f, IconPainter.BLUE, 1.4f, 1.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$198(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.ring(7.0f, 17.5f, 3.2f, put.getFg(), 1.8f);
        put.ring(17.0f, 17.5f, 3.2f, put.getFg(), 1.8f);
        put.line(9.0f, 15.0f, 17.0f, 3.0f, put.getFg(), 1.8f);
        put.line(15.0f, 15.0f, 7.0f, 3.0f, put.getFg(), 1.8f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$199(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(4.0f, 4.0f, 20.0f, 22.0f, -4617650, 2.0f);
        put.rect(8.5f, 2.5f, 15.5f, 6.5f, IconPainter.GRAY_L, 1.0f);
        put.rect(7.0f, 8.0f, 17.0f, 20.0f, IconPainter.PAPER, 1.0f);
        put.line(9.0f, 12.0f, 15.0f, 12.0f, IconPainter.GRAY_R, 1.2f);
        put.line(9.0f, 15.5f, 15.0f, 15.5f, IconPainter.GRAY_R, 1.2f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$200(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(7.0f, 3.0f, 17.0f, 15.0f, 180.0f, 180.0f, put.getFg(), 2.2f);
        put.line(7.0f, 9.0f, 7.0f, 11.0f, put.getFg(), 2.2f);
        put.line(17.0f, 9.0f, 17.0f, 11.0f, put.getFg(), 2.2f);
        put.rect(4.5f, 10.5f, 19.5f, 21.0f, IconPainter.YELLOW, 2.0f);
        put.circle(12.0f, 15.5f, 1.8f, IconPainter.DARK);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit generalIcons$lambda$202$lambda$201(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.box$default(put, 2.5f, 9.0f, 11.5f, 18.0f, IconPainter.GRAY_T, IconPainter.GRAY_R, 0.0f, 0.0f, 192, null);
        IconPainter.box$default(put, 12.5f, 6.0f, 21.5f, 15.0f, IconPainter.LBLUE, IconPainter.DBLUE, 0.0f, 0.0f, 192, null);
        put.poly(IconPainter.YELLOW, 12.0f, 2.0f, 13.5f, 6.5f, 10.5f, 6.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit gui$lambda$8(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        iconPainter.rect(3.0f, 4.0f, 21.0f, 20.0f, -10853776, 1.5f);
        iconPainter.rect(4.5f, 8.0f, 19.5f, 18.5f, IconPainter.LBLUE, 0.5f);
        iconPainter.rect(4.5f, 5.3f, 8.0f, 6.8f, IconPainter.RED, 0.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit humanoid$lambda$7(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        iconPainter.person(12.0f, 13.0f, 10.0f, IconPainter.GREEN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$100(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.YELLOW, 12.0f, 2.0f, 14.0f, 10.0f, 22.0f, 12.0f, 14.0f, 14.0f, 12.0f, 22.0f, 10.0f, 14.0f, 2.0f, 12.0f, 10.0f, 10.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$101(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(2.0f, 6.0f, 14.0f, 18.0f, 180.0f, 180.0f, IconPainter.PURPLE, 2.4f);
        put.arc(12.0f, 6.0f, 22.0f, 18.0f, 0.0f, 180.0f, IconPainter.PURPLE, 2.4f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$102(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(4.0f, 18.0f, 2.5f, IconPainter.TEAL);
        put.circle(20.0f, 6.0f, 2.5f, IconPainter.TEAL);
        put.pline(-8397613, 3.0f, 4.0f, 18.0f, 10.0f, 9.0f, 14.0f, 15.0f, 20.0f, 6.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$103(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.ORANGE, 12.0f, 1.0f, 14.5f, 8.0f, 22.0f, 6.0f, 16.5f, 12.0f, 22.0f, 18.0f, 14.5f, 16.0f, 12.0f, 23.0f, 9.5f, 16.0f, 2.0f, 18.0f, 7.5f, 12.0f, 2.0f, 6.0f, 9.5f, 8.0f);
        put.circle(12.0f, 12.0f, 3.5f, IconPainter.YELLOW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$104(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(5.0f, 5.0f, 19.0f, 19.0f, 1441089613, 2.0f);
        put.srect(5.0f, 5.0f, 19.0f, 19.0f, IconPainter.RED, 2.0f, 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$105(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.spoly(IconPainter.BLUE, 2.0f, 12.0f, 2.0f, 20.5f, 7.0f, 20.5f, 17.0f, 12.0f, 22.0f, 3.5f, 17.0f, 3.5f, 7.0f);
        put.poly(1144753131, 12.0f, 2.0f, 20.5f, 7.0f, 20.5f, 17.0f, 12.0f, 22.0f, 3.5f, 17.0f, 3.5f, 7.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$106(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.srect$default(put, 4.0f, 4.0f, 20.0f, 20.0f, IconPainter.BLUE, 1.8f, 0.0f, 64, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$107(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(16.0f, 8.0f, 4.5f, IconPainter.YELLOW);
        put.cloud(10.0f, 14.0f, 7.0f, -1);
        put.cloud(10.0f, 14.0f, 6.0f, -2299915);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$108(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.cloud(12.0f, 13.0f, 8.0f, -4667430);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$109(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(2.0f, 8.0f, 22.0f, 28.0f, 180.0f, 180.0f, IconPainter.LBLUE, 2.4f);
        put.arc(5.0f, 11.0f, 19.0f, 25.0f, 180.0f, 180.0f, IconPainter.BLUE, 2.4f);
        put.arc(8.0f, 14.0f, 16.0f, 22.0f, 180.0f, 180.0f, IconPainter.DBLUE, 2.4f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$110(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 8.0f, 1442829133);
        put.circle(12.0f, 12.0f, 4.5f, IconPainter.YELLOW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$111(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 8.0f, 1144753131);
        put.circle(12.0f, 12.0f, 5.0f, -2009363477);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$112(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.pie(3.0f, 3.0f, 21.0f, 21.0f, 0.0f, 120.0f, IconPainter.RED);
        put.pie(3.0f, 3.0f, 21.0f, 21.0f, 120.0f, 120.0f, IconPainter.GREEN);
        put.pie(3.0f, 3.0f, 21.0f, 21.0f, 240.0f, 120.0f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$113(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 4.0f, IconPainter.YELLOW);
        for (int i = 0; i < 8; i++) {
            double radians = Math.toRadians(i * 45.0d);
            put.line((((float) Math.cos(radians)) * 6.0f) + 12.0f, (((float) Math.sin(radians)) * 6.0f) + 12.0f, (((float) Math.cos(radians)) * 9.5f) + 12.0f, (((float) Math.sin(radians)) * 9.5f) + 12.0f, IconPainter.YELLOW, 1.6f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$114(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.ring(12.0f, 12.0f, 8.0f, IconPainter.DARK, 2.0f);
        put.ring(12.0f, 12.0f, 4.0f, IconPainter.BLUE, 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$115(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 21.0f, IconPainter.ORANGE, 4.0f);
        put.bolt(12.0f, 12.0f, 7.0f, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$116(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 21.0f, -3573206, 4.0f);
        put.bolt(12.0f, 12.0f, 7.0f, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$117(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 21.0f, IconPainter.PURPLE, 4.0f);
        IconPainter.text$default(put, "f", 12.0f, 12.0f, 13.0f, -1, false, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$118(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 21.0f, IconPainter.GREEN, 4.0f);
        put.bolt(12.0f, 12.0f, 7.0f, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$119(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 21.0f, IconPainter.GREEN, 4.0f);
        IconPainter.text$default(put, "f", 12.0f, 12.0f, 13.0f, -1, false, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$120(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(4.0f, 7.0f, 18.0f, 21.0f, IconPainter.BLUE, 2.0f);
        put.circle(11.0f, 6.5f, 3.0f, IconPainter.BLUE);
        put.circle(18.5f, 14.0f, 3.0f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$121(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.0f, 3.0f, 15.0f, 12.0f, IconPainter.BLUE, 3.0f);
        put.rect(9.0f, 10.0f, 22.0f, 19.0f, IconPainter.TEAL, 3.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$122(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(4.0f, 6.0f, 20.0f, 18.0f, IconPainter.TEAL, 3.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$123(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.DARK, 7.0f, 4.0f, 7.0f, 19.0f, 10.5f, 15.5f, 13.0f, 21.0f, 15.5f, 20.0f, 13.0f, 14.5f, 18.0f, 14.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$124(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.5f, IconPainter.BLUE);
        put.ring(12.0f, 12.0f, 9.5f, IconPainter.DBLUE, 1.2f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$125(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 6.0f, 21.0f, 18.0f, IconPainter.DARK, 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$126(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 9.0f, 21.0f, 15.0f, IconPainter.DARK, 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$127(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(5.0f, 3.0f, 9.0f, 15.0f, IconPainter.DARK, 1.0f);
        put.rect(5.0f, 12.0f, 19.0f, 15.5f, IconPainter.DARK, 1.0f);
        put.circle(7.0f, 19.0f, 2.5f, IconPainter.DARK);
        put.circle(17.0f, 19.0f, 2.5f, IconPainter.DARK);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$14(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.GRAY_L, 3.0f, 20.0f, 21.0f, 20.0f, 21.0f, 5.0f);
        put.poly(IconPainter.GRAY_T, 3.0f, 20.0f, 21.0f, 5.0f, 21.0f, 8.5f, 6.5f, 20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$15(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.GRAY_L, 3.0f, 20.0f, 12.0f, 3.0f, 12.0f, 20.0f);
        put.poly(IconPainter.GRAY_R, 12.0f, 3.0f, 21.0f, 20.0f, 12.0f, 20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$16(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.srect$default(put, 5.0f, 2.0f, 19.0f, 22.0f, -7498852, 2.0f, 0.0f, 64, null);
        for (int i = 0; i < 3; i++) {
            float f = (i * 6.66f) + 2.0f;
            put.line(5.0f, f, 19.0f, f + 6.66f, -7498852, 1.5f);
            put.line(19.0f, f, 5.0f, f + 6.66f, -7498852, 1.5f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$17(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.GRAY_T, 12.0f, 10.0f, 22.0f, 14.5f, 12.0f, 19.0f, 2.0f, 14.5f);
        put.poly(IconPainter.GRAY_L, 2.0f, 14.5f, 12.0f, 19.0f, 12.0f, 21.5f, 2.0f, 17.0f);
        put.poly(IconPainter.GRAY_R, 12.0f, 19.0f, 22.0f, 14.5f, 22.0f, 17.0f, 12.0f, 21.5f);
        put.pline(IconPainter.GREEN, 2.4f, 8.0f, 8.0f, 12.0f, 4.0f, 16.0f, 8.0f);
        put.line(12.0f, 4.0f, 12.0f, 12.0f, IconPainter.GREEN, 2.4f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$18(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(5.0f, 3.0f, 9.0f, 15.0f, IconPainter.BROWN, 1.0f);
        put.rect(5.0f, 12.0f, 19.0f, 15.5f, IconPainter.BROWN, 1.0f);
        put.line(6.5f, 15.0f, 6.5f, 21.0f, -8760792, 2.0f);
        put.line(17.5f, 15.0f, 17.5f, 21.0f, -8760792, 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$19(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(-8407312, 12.0f, 3.0f, 21.0f, 19.0f, 3.0f, 19.0f);
        put.spoly(IconPainter.DBLUE, 1.3f, 12.0f, 3.0f, 21.0f, 19.0f, 3.0f, 19.0f);
        put.pline(IconPainter.DBLUE, 1.1f, 7.5f, 11.0f, 12.0f, 19.0f, 16.5f, 11.0f, 7.5f, 11.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$20(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 9.0f, 14.0f, 20.0f, -8599169, 1.5f);
        put.circle(15.0f, 9.5f, 6.5f, IconPainter.GREEN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$21(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 9.0f, 14.0f, 20.0f, -8599169, 1.5f);
        put.circle(15.0f, 9.5f, 6.5f, IconPainter.GREEN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$22(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 9.0f, 14.0f, 20.0f, IconPainter.GREEN, 1.4f, 1.5f);
        put.ring(15.0f, 9.5f, 6.5f, IconPainter.GREEN, 1.4f);
        put.pie(8.5f, 3.0f, 21.5f, 16.0f, 90.0f, 90.0f, IconPainter.GREEN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$23(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 9.0f, 14.0f, 20.0f, IconPainter.RED, 1.4f, 1.5f);
        put.circle(15.0f, 9.5f, 6.5f, -1013107);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$24(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(-7706043, 1.0f, 20.0f, 9.0f, 6.0f, 15.0f, 15.0f, 18.0f, 10.0f, 23.0f, 20.0f);
        put.poly(IconPainter.GREEN, 1.0f, 20.0f, 5.0f, 13.0f, 9.0f, 16.0f, 13.0f, 13.0f, 18.0f, 17.0f, 23.0f, 20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$25(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.gear(12.0f, 12.0f, 8.0f, -7498852, Ui.INSTANCE.getPANEL());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$26(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.5f, IconPainter.BLUE);
        put.poly(IconPainter.GREEN, 7.0f, 6.0f, 11.0f, 5.0f, 12.5f, 8.0f, 10.0f, 11.0f, 11.0f, 14.0f, 8.0f, 16.0f, 6.0f, 12.0f, 5.0f, 9.0f);
        put.poly(IconPainter.GREEN, 15.0f, 11.0f, 19.0f, 10.0f, 20.0f, 14.0f, 17.0f, 18.0f, 15.0f, 15.0f);
        put.ring(12.0f, 12.0f, 9.5f, IconPainter.DBLUE, 1.2f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$27(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 7.0f, 21.0f, 19.0f, IconPainter.DARK, 2.0f);
        put.rect(8.0f, 4.5f, 13.0f, 7.5f, IconPainter.DARK, 1.0f);
        put.circle(12.0f, 13.0f, 4.3f, -6306064);
        put.ring(12.0f, 13.0f, 4.3f, -3091238, 1.3f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$28(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.person(10.0f, 13.0f, 9.0f, IconPainter.BLUE);
        put.poly(IconPainter.GREEN, 16.0f, 13.0f, 22.0f, 16.5f, 16.0f, 20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$29(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 11.0f, 9.0f, 871547440);
        put.bulb(12.0f, 11.0f, IconPainter.YELLOW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$30(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(1727185456, 9.0f, 6.0f, 15.0f, 6.0f, 21.0f, 22.0f, 3.0f, 22.0f);
        put.rect(8.0f, 2.0f, 16.0f, 7.0f, -7498852, 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$31(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(4.0f, 3.0f, 20.0f, 7.0f, -7498852, 1.0f);
        Iterator it = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(7.0f), Float.valueOf(12.0f), Float.valueOf(17.0f)}).iterator();
        while (it.hasNext()) {
            float floatValue = ((Number) it.next()).floatValue();
            put.line(floatValue, 9.0f, floatValue, 20.0f, IconPainter.YELLOW, 1.8f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$32(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.0f, -5197643);
        put.pie(3.0f, 3.0f, 21.0f, 21.0f, -45.0f, 180.0f, IconPainter.GRAY_R);
        put.circle(9.0f, 9.0f, 2.0f, 1728053247);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$33(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 8.0f, 17.0f, 20.0f, IconPainter.TEAL, 1.5f);
        put.rect(3.0f, 8.0f, 17.0f, 11.0f, -14709630, 1.0f);
        put.pline(IconPainter.BLUE, 2.2f, 14.0f, 3.5f, 21.0f, 3.5f);
        put.arrowHead(21.0f, 3.5f, 90.0f, 2.2f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$34(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 7.0f, 21.0f, 20.0f, IconPainter.TEAL, 1.5f);
        put.rect(2.0f, 5.0f, 22.0f, 9.0f, -14709630, 1.0f);
        put.rect(9.0f, 11.0f, 15.0f, 13.0f, -1, 0.8f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$35(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        for (int i = 0; i < 3; i++) {
            float f = 3.5f + (i * 6.2f);
            put.rect(3.0f, f, 21.0f, f + 5.0f, IconPainter.DARK, 1.2f);
            put.circle(18.0f, f + 2.5f, 1.0f, IconPainter.GREEN);
            put.line(6.0f, f + 2.5f, 12.0f, f + 2.5f, -7498852, 1.2f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$36(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        for (int i = 0; i < 2; i++) {
            float f = 3.5f + (i * 6.2f);
            put.rect(2.0f, f, 15.0f, f + 5.0f, IconPainter.DARK, 1.2f);
            put.circle(12.5f, 2.5f + f, 1.0f, IconPainter.GREEN);
        }
        put.rect(11.0f, 10.0f, 22.0f, 22.0f, IconPainter.PAPER, 1.0f);
        IconPainter.rect$default(put, 11.0f, 10.0f, 13.0f, 22.0f, IconPainter.BLUE, 0.0f, 32, null);
        put.line(15.0f, 14.0f, 20.0f, 14.0f, IconPainter.BLUE, 1.2f);
        put.line(15.0f, 17.5f, 19.0f, 17.5f, IconPainter.BLUE, 1.2f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$37(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(5.0f, 7.0f, 19.0f, 21.0f, IconPainter.BROWN, 3.0f);
        put.arc(8.0f, 2.5f, 16.0f, 10.0f, 180.0f, 180.0f, -8760792, 1.8f);
        put.rect(5.0f, 11.0f, 19.0f, 15.0f, -7446740, 1.0f);
        put.rect(10.5f, 12.0f, 13.5f, 14.0f, IconPainter.YELLOW, 0.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$38(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(5.0f, 7.0f, 19.0f, 21.0f, IconPainter.BROWN, 3.0f);
        put.arc(8.0f, 2.5f, 16.0f, 10.0f, 180.0f, 180.0f, -8760792, 1.8f);
        put.rect(5.0f, 11.0f, 19.0f, 15.0f, -7446740, 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$39(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.line(5.0f, 3.0f, 5.0f, 21.0f, IconPainter.DARK, 1.8f);
        put.poly(IconPainter.RED, 5.5f, 4.0f, 19.0f, 7.0f, 5.5f, 11.0f);
        put.poly(IconPainter.BLUE, 5.5f, 11.0f, 19.0f, 14.0f, 5.5f, 17.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$40(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.line(5.0f, 3.0f, 5.0f, 21.0f, IconPainter.DARK, 1.8f);
        put.poly(IconPainter.BLUE, 5.5f, 4.0f, 20.0f, 8.5f, 5.5f, 13.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$41(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.speaker(IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$42(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.speaker(IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$43(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.speaker(IconPainter.TEAL);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$44(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.5f, 4.0f, 21.5f, 16.0f, IconPainter.BLUE, 4.0f);
        put.poly(IconPainter.BLUE, 6.0f, 15.0f, 5.0f, 21.0f, 11.0f, 15.5f);
        Iterator it = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(8.0f), Float.valueOf(12.0f), Float.valueOf(16.0f)}).iterator();
        while (it.hasNext()) {
            put.circle(((Number) it.next()).floatValue(), 10.0f, 1.4f, -1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$45(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.5f, 4.0f, 21.5f, 16.0f, IconPainter.BLUE, 4.0f);
        put.poly(IconPainter.BLUE, 6.0f, 15.0f, 5.0f, 21.0f, 11.0f, 15.5f);
        Iterator it = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(8.0f), Float.valueOf(12.0f), Float.valueOf(16.0f)}).iterator();
        while (it.hasNext()) {
            put.circle(((Number) it.next()).floatValue(), 10.0f, 1.4f, -1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$46(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.5f, IconPainter.TEAL);
        IconPainter.text$default(put, "A", 12.0f, 12.0f, 11.0f, -1, false, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$47(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.5f, IconPainter.GREEN);
        put.pline(-1, 2.4f, 7.5f, 12.5f, 10.8f, 15.8f, 16.8f, 8.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$48(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.monitor(IconPainter.LBLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$49(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 13.0f, IconPainter.GUI, 1.5f);
        put.line(12.0f, 13.0f, 12.0f, 21.0f, IconPainter.DARK, 2.0f);
        put.line(6.0f, 7.0f, 18.0f, 7.0f, -1, 1.3f);
        put.line(6.0f, 10.0f, 14.0f, 10.0f, -1, 1.3f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$50(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.GUI, 4.0f, 7.0f, 20.0f, 3.0f, 20.0f, 17.0f, 4.0f, 21.0f);
        put.line(7.0f, 10.0f, 17.0f, 7.5f, -1, 1.3f);
        put.line(7.0f, 13.5f, 14.0f, 12.0f, -1, 1.3f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$51(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.frame(-4660536, IconPainter.GUI);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$52(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.frame(-4660536, IconPainter.GUI);
        IconPainter.text$default(put, "T", 12.0f, 12.0f, 11.0f, -13726889, false, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$53(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.5f, 6.0f, 21.5f, 18.0f, IconPainter.GUI, 4.0f);
        IconPainter.text$default(put, "T", 12.0f, 12.0f, 10.0f, -1, false, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$54(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.frame(-1, IconPainter.GUI);
        put.line(12.0f, 8.0f, 12.0f, 16.0f, IconPainter.DARK, 1.5f);
        put.line(10.0f, 8.0f, 14.0f, 8.0f, IconPainter.DARK, 1.2f);
        put.line(10.0f, 16.0f, 14.0f, 16.0f, IconPainter.DARK, 1.2f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$55(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 5.0f, 21.0f, 19.0f, IconPainter.GUI, 1.4f, 1.5f);
        put.picture(4.5f, 6.5f, 19.5f, 17.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$56(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.5f, 4.5f, 21.5f, 19.5f, IconPainter.GUI, 4.0f);
        put.picture(5.0f, 7.0f, 19.0f, 17.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$57(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.frame(-4660536, IconPainter.GUI);
        put.rect(17.0f, 7.0f, 19.5f, 12.0f, -13726889, 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$58(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.frame(-4660536, IconPainter.GUI);
        IconPainter.cube$default(put, 12.0f, 11.5f, 5.0f, 0, 0, 0, 56, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$59(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.box$default(put, 7.0f, 3.0f, 21.0f, 15.0f, -4660536, IconPainter.GUI, 0.0f, 0.0f, 192, null);
        IconPainter.box$default(put, 3.0f, 9.0f, 17.0f, 21.0f, -2691105, IconPainter.GUI, 0.0f, 0.0f, 192, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$60(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.frame(IconPainter.DARK, IconPainter.GUI);
        put.poly(-1, 10.0f, 8.5f, 16.0f, 12.0f, 10.0f, 15.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$61(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.pline(IconPainter.GUI, 2.6f, 5.0f, 20.0f, 5.0f, 12.0f);
        put.arc(5.0f, 5.0f, 19.0f, 19.0f, 180.0f, 90.0f, IconPainter.GUI, 2.6f);
        put.line(12.0f, 5.0f, 20.0f, 5.0f, IconPainter.GUI, 2.6f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$62(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(4.0f, 6.0f, 20.0f, 18.0f, IconPainter.GUI, 3.0f, 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$63(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.gradientRect$default(put, 3.0f, 6.0f, 21.0f, 18.0f, IconPainter.DBLUE, IconPainter.RED, 0.0f, 64, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$64(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 4.0f, 21.0f, 20.0f, IconPainter.GUI, 1.4f, 1.0f);
        put.rect(7.0f, 8.0f, 17.0f, 16.0f, -4660536, 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$65(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        for (int i = 0; i < 3; i++) {
            put.rect(4.0f, (i * 5.5f) + 4.5f, 20.0f, (i * 5.5f) + 8.5f, IconPainter.GUI, 1.0f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$66(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                put.rect((i * 8.5f) + 4.0f, (i2 * 8.5f) + 4.0f, (i * 8.5f) + 11.5f, (i2 * 8.5f) + 11.5f, IconPainter.GUI, 1.0f);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$67(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.srect$default(put, 3.0f, 4.0f, 21.0f, 20.0f, IconPainter.GUI, 1.4f, 0.0f, 64, null);
        put.line(3.0f, 9.5f, 21.0f, 9.5f, IconPainter.GUI, 1.2f);
        put.line(3.0f, 15.0f, 21.0f, 15.0f, IconPainter.GUI, 1.2f);
        put.line(10.0f, 4.0f, 10.0f, 20.0f, IconPainter.GUI, 1.2f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$68(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        IconPainter.box$default(put, 7.0f, 3.0f, 20.0f, 17.0f, -2691105, IconPainter.GUI, 0.0f, 0.0f, 192, null);
        IconPainter.box$default(put, 4.0f, 7.0f, 17.0f, 21.0f, -4660536, IconPainter.GUI, 0.0f, 0.0f, 192, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$69(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 3.0f, 21.0f, 21.0f, IconPainter.GUI, 1.4f, 1.0f);
        put.line(7.0f, 17.0f, 17.0f, 7.0f, -13726889, 2.0f);
        put.arrowHead(17.0f, 7.0f, 45.0f, 2.5f, -13726889);
        put.arrowHead(7.0f, 17.0f, 225.0f, 2.5f, -13726889);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$70(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 6.0f, 21.0f, 18.0f, IconPainter.GUI, 1.6f, 1.0f);
        IconPainter.text$default(put, "16:9", 12.0f, 12.0f, 6.5f, -13726889, false, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$71(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 6.0f, 21.0f, 18.0f, IconPainter.GUI, 1.6f, 1.0f);
        put.line(6.0f, 12.0f, 18.0f, 12.0f, -13726889, 1.6f);
        put.arrowHead(6.0f, 12.0f, 270.0f, 2.3f, -13726889);
        put.arrowHead(18.0f, 12.0f, 90.0f, 2.3f, -13726889);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$72(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(3.0f, 6.0f, 21.0f, 18.0f, IconPainter.GUI, 1.6f, 1.0f);
        IconPainter.text$default(put, "Tt", 12.0f, 12.0f, 8.0f, -13726889, false, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$73(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(-5197643, 3.0f, 5.0f, 21.0f, 3.0f, 21.0f, 21.0f, 3.0f, 19.0f);
        put.picture(5.0f, 6.0f, 19.0f, 18.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$74(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                IconPainter.rect$default(put, (i * 6.0f) + 3.0f, (i2 * 6.0f) + 3.0f, (i * 6.0f) + 9.0f, (i2 * 6.0f) + 9.0f, (i + i2) % 2 == 0 ? IconPainter.DARK : IconPainter.GRAY_T, 0.0f, 32, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$75(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.spoly(IconPainter.DBLUE, 1.4f, 12.0f, 3.0f, 21.0f, 19.0f, 3.0f, 19.0f);
        put.pline(IconPainter.DBLUE, 1.1f, 7.5f, 11.0f, 12.0f, 19.0f, 16.5f, 11.0f, 7.5f, 11.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$76(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.spoly(IconPainter.DBLUE, 1.4f, 12.0f, 3.0f, 20.0f, 7.5f, 20.0f, 16.5f, 12.0f, 21.0f, 4.0f, 16.5f, 4.0f, 7.5f);
        put.pline(IconPainter.DBLUE, 1.1f, 4.0f, 7.5f, 12.0f, 12.0f, 20.0f, 7.5f);
        put.line(12.0f, 12.0f, 12.0f, 21.0f, IconPainter.DBLUE, 1.1f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$77(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.arc(5.0f, 3.0f, 19.0f, 9.0f, 0.0f, 360.0f, IconPainter.DBLUE, 1.4f);
        put.line(5.0f, 6.0f, 5.0f, 18.0f, IconPainter.DBLUE, 1.4f);
        put.line(19.0f, 6.0f, 19.0f, 18.0f, IconPainter.DBLUE, 1.4f);
        put.arc(5.0f, 15.0f, 19.0f, 21.0f, 0.0f, 180.0f, IconPainter.DBLUE, 1.4f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$78(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(14.0f, 4.5f, 2.3f, IconPainter.PURPLE);
        put.pline(IconPainter.PURPLE, 2.2f, 13.0f, 8.0f, 11.0f, 14.0f, 6.0f, 18.0f);
        put.pline(IconPainter.PURPLE, 2.2f, 11.0f, 14.0f, 15.0f, 17.0f, 15.0f, 22.0f);
        put.pline(IconPainter.PURPLE, 2.2f, 7.0f, 10.0f, 12.5f, 8.0f, 18.0f, 11.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$79(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(14.0f, 4.5f, 2.3f, IconPainter.PURPLE);
        put.pline(IconPainter.PURPLE, 2.2f, 13.0f, 8.0f, 11.0f, 14.0f, 6.0f, 18.0f);
        put.pline(IconPainter.PURPLE, 2.2f, 11.0f, 14.0f, 15.0f, 17.0f, 15.0f, 22.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$80(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 5.0f, 21.0f, 19.0f, IconPainter.PURPLE, 1.5f);
        Iterator it = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(5.0f), Float.valueOf(9.0f), Float.valueOf(13.0f), Float.valueOf(17.0f)}).iterator();
        while (it.hasNext()) {
            float floatValue = ((Number) it.next()).floatValue();
            put.rect(floatValue, 6.0f, floatValue + 2.0f, 8.0f, -1, 0.4f);
            put.rect(floatValue, 16.0f, floatValue + 2.0f, 18.0f, -1, 0.4f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$81(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 5.0f, 21.0f, 19.0f, IconPainter.PURPLE, 1.5f);
        Iterator it = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(7.0f), Float.valueOf(12.0f), Float.valueOf(17.0f)}).iterator();
        while (it.hasNext()) {
            float floatValue = ((Number) it.next()).floatValue();
            put.poly(-1, floatValue, 9.0f, floatValue + 2.5f, 12.0f, floatValue, 15.0f, floatValue - 2.5f, 12.0f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$82(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(4.0f, 3.0f, 16.0f, 9.0f, -7498852, 1.2f);
        put.line(10.0f, 9.0f, 10.0f, 21.0f, IconPainter.BROWN, 3.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$83(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(4.0f, 3.0f, 16.0f, 9.0f, -7498852, 1.2f);
        put.line(10.0f, 9.0f, 10.0f, 21.0f, IconPainter.BROWN, 3.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$84(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.0f, 15.0f, 22.0f, 18.0f, IconPainter.DARK, 1.5f);
        put.rect(6.0f, 5.0f, 18.0f, 16.0f, IconPainter.DARK, 1.5f);
        IconPainter.rect$default(put, 6.0f, 12.0f, 18.0f, 14.0f, IconPainter.RED, 0.0f, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$85(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(2.0f, 15.0f, 22.0f, 18.0f, IconPainter.DARK, 1.5f);
        put.rect(6.0f, 5.0f, 18.0f, 16.0f, IconPainter.DARK, 1.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$86(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.BLUE, 8.0f, 3.0f, 16.0f, 3.0f, 22.0f, 8.0f, 19.0f, 11.0f, 17.0f, 9.0f, 17.0f, 21.0f, 7.0f, 21.0f, 7.0f, 9.0f, 5.0f, 11.0f, 2.0f, 8.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$87(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.TEAL, 8.0f, 3.0f, 16.0f, 3.0f, 22.0f, 8.0f, 19.0f, 11.0f, 17.0f, 9.0f, 17.0f, 21.0f, 7.0f, 21.0f, 7.0f, 9.0f, 5.0f, 11.0f, 2.0f, 8.0f);
        put.circle(12.0f, 12.0f, 2.5f, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$88(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(-11904384, 6.0f, 3.0f, 18.0f, 3.0f, 20.0f, 21.0f, 14.0f, 21.0f, 12.0f, 9.0f, 10.0f, 21.0f, 4.0f, 21.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$89(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(12.0f, 12.0f, 9.5f, -1518160);
        put.circle(8.0f, 9.0f, 2.0f, IconPainter.RED);
        put.circle(13.0f, 7.0f, 2.0f, IconPainter.YELLOW);
        put.circle(17.0f, 11.0f, 2.0f, IconPainter.BLUE);
        put.circle(9.0f, 15.0f, 2.0f, IconPainter.GREEN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$90(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.ring(12.0f, 12.0f, 7.0f, IconPainter.GREEN, 2.2f);
        put.circle(12.0f, 12.0f, 2.6f, IconPainter.GREEN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$91(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.line(6.0f, 18.0f, 18.0f, 6.0f, -1518160, 3.0f);
        put.circle(6.0f, 18.0f, 2.5f, -1518160);
        put.circle(18.0f, 6.0f, 2.5f, -1518160);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$92(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.chain(IconPainter.RED);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$93(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(7.0f, 12.0f, 4.0f, -7498852);
        put.circle(17.0f, 12.0f, 4.0f, -7498852);
        put.line(7.0f, 12.0f, 17.0f, 12.0f, IconPainter.DARK, 2.5f);
        put.circle(17.0f, 12.0f, 1.5f, IconPainter.YELLOW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$94(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.circle(7.0f, 12.0f, 4.0f, -7498852);
        put.circle(17.0f, 12.0f, 4.0f, -7498852);
        put.line(7.0f, 12.0f, 17.0f, 12.0f, IconPainter.DARK, 2.5f);
        put.circle(17.0f, 12.0f, 1.5f, IconPainter.YELLOW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$95(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.DARK, 7.0f, 4.0f, 7.0f, 19.0f, 10.5f, 15.5f, 13.0f, 21.0f, 15.5f, 20.0f, 13.0f, 14.5f, 18.0f, 14.5f);
        put.line(13.0f, 3.0f, 14.0f, 6.0f, IconPainter.ORANGE, 1.6f);
        put.line(17.0f, 6.0f, 15.0f, 8.0f, IconPainter.ORANGE, 1.6f);
        put.line(18.0f, 10.5f, 15.5f, 10.5f, IconPainter.ORANGE, 1.6f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$96(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.rect(3.0f, 3.0f, 21.0f, 21.0f, IconPainter.DARK, 4.0f);
        put.srect(5.5f, 5.5f, 18.5f, 18.5f, -1, 1.4f, 3.0f);
        IconPainter.text$default(put, "E", 12.0f, 12.0f, 9.0f, -1, false, 32, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$97(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        Float valueOf = Float.valueOf(9.0f);
        Float valueOf2 = Float.valueOf(15.0f);
        for (Triple triple : CollectionsKt.listOf((Object[]) new Triple[]{new Triple(Float.valueOf(6.0f), Float.valueOf(7.0f), Float.valueOf(2.0f)), new Triple(Float.valueOf(14.0f), Float.valueOf(5.0f), Float.valueOf(1.4f)), new Triple(Float.valueOf(18.0f), Float.valueOf(12.0f), Float.valueOf(2.4f)), new Triple(valueOf, valueOf2, Float.valueOf(2.6f)), new Triple(valueOf2, Float.valueOf(19.0f), Float.valueOf(1.6f))})) {
            put.circle(((Number) triple.component1()).floatValue(), ((Number) triple.component2()).floatValue(), ((Number) triple.component3()).floatValue(), IconPainter.ORANGE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$98(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.poly(IconPainter.ORANGE, 12.0f, 2.0f, 18.0f, 11.0f, 18.0f, 16.0f, 15.0f, 21.0f, 9.0f, 21.0f, 6.0f, 16.0f, 6.0f, 11.0f, 9.0f, 13.0f);
        put.poly(IconPainter.YELLOW, 12.0f, 9.0f, 15.0f, 15.0f, 14.0f, 19.0f, 10.0f, 19.0f, 9.0f, 15.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit instanceIcons$lambda$128$lambda$99(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.cloud(12.0f, 12.0f, 8.0f, -6643544);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit light$lambda$13(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        iconPainter.bulb(12.0f, 11.0f, IconPainter.YELLOW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit localScript$lambda$1(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        IconPainter.page$default(iconPainter, IconPainter.TEAL, 0, 2, null);
        iconPainter.pageLines(-8409152);
        iconPainter.person(15.0f, 16.5f, 6.0f, IconPainter.TEAL);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit model$lambda$4(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        IconPainter.cube$default(iconPainter, 7.5f, 8.5f, 5.0f, 0, 0, 0, 56, null);
        IconPainter.cube$default(iconPainter, 16.5f, 8.5f, 5.0f, 0, 0, 0, 56, null);
        IconPainter.cube$default(iconPainter, 12.0f, 16.5f, 5.0f, 0, 0, 0, 56, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit moduleScript$lambda$2(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        IconPainter.page$default(iconPainter, IconPainter.PURPLE, 0, 2, null);
        iconPainter.pline(IconPainter.PURPLE, 1.6f, 12.0f, 8.0f, 10.0f, 10.0f, 10.0f, 12.0f, 9.0f, 13.0f, 10.0f, 14.0f, 10.0f, 16.0f, 12.0f, 18.0f);
        iconPainter.pline(IconPainter.PURPLE, 1.6f, 14.5f, 8.0f, 16.5f, 10.0f, 16.5f, 12.0f, 17.5f, 13.0f, 16.5f, 14.0f, 16.5f, 16.0f, 14.5f, 18.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit part$lambda$3(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        IconPainter.cube$default(iconPainter, 12.0f, 12.0f, 9.0f, 0, 0, 0, 56, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit person$lambda$6(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        iconPainter.person(12.0f, 13.0f, 10.0f, IconPainter.BLUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit script$lambda$0(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        IconPainter.page$default(iconPainter, IconPainter.BLUE, 0, 2, null);
        iconPainter.pageLines(-10711082);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit uiIcons$lambda$207$lambda$204(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.line(6.0f, 6.0f, 18.0f, 18.0f, put.getFg(), 2.0f);
        put.line(18.0f, 6.0f, 6.0f, 18.0f, put.getFg(), 2.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit uiIcons$lambda$207$lambda$205(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        put.srect(4.0f, 7.0f, 17.0f, 20.0f, put.getFg(), 1.5f, 1.5f);
        put.srect(8.0f, 3.0f, 21.0f, 16.0f, IconPainter.BLUE, 1.5f, 1.5f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit uiIcons$lambda$207$lambda$206(IconPainter put) {
        Intrinsics.checkNotNullParameter(put, "$this$put");
        Iterator it = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(9.0f), Float.valueOf(15.0f)}).iterator();
        while (it.hasNext()) {
            float floatValue = ((Number) it.next()).floatValue();
            Iterator it2 = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(6.0f), Float.valueOf(12.0f), Float.valueOf(18.0f)}).iterator();
            while (it2.hasNext()) {
                put.circle(floatValue, ((Number) it2.next()).floatValue(), 1.6f, Ui.INSTANCE.getDIM());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Function1 valueTag$lambda$10(int i, String l) {
        Intrinsics.checkNotNullParameter(l, "l");
        return new BuiltinIcons$$ExternalSyntheticLambda0(i, l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit valueTag$lambda$10$lambda$9(int i, String str, IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        iconPainter.tag(i, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit weld$lambda$12(IconPainter iconPainter) {
        Intrinsics.checkNotNullParameter(iconPainter, "<this>");
        iconPainter.chain(-7498852);
        return Unit.INSTANCE;
    }

    public final Drawable general(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Function1<IconPainter, Unit> function1 = generalIcons.get(name);
        return function1 != null ? new VectorIcon(function1) : null;
    }

    public final Drawable instance(String cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        String str = cls;
        int i = 0;
        while (str != null) {
            int i2 = i + 1;
            if (i < 12) {
                Function1<IconPainter, Unit> function1 = instanceIcons.get(str);
                if (function1 != null) {
                    return new VectorIcon(function1);
                }
                if (!Intrinsics.areEqual(str, "Instance")) {
                    if (StringsKt.endsWith$default(str, "Constraint", false, 2, (Object) null) && ClassDb.INSTANCE.isA(str, "Constraint")) {
                        return new VectorIcon(constraint);
                    }
                    str = ClassDb.INSTANCE.superclass(str);
                    i = i2;
                }
            }
        }
        return null;
    }

    public final Drawable ui(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Function1<IconPainter, Unit> function1 = uiIcons.get(name);
        return function1 != null ? new VectorIcon(function1) : null;
    }
}
