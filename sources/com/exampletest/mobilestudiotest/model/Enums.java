package com.exampletest.mobilestudiotest.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.engine.ClothingCompositor;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import com.google.android.material.card.MaterialCardViewHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Enums.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\bR9\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Enums;", "", "<init>", "()V", "types", "", "", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getTypes", "()Ljava/util/Map;", "typeForProp", "cls", "prop", "itemName", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "value", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Enums {
    public static final Enums INSTANCE = new Enums();
    private static final Map<String, LinkedHashMap<String, Integer>> types;

    static {
        HashMap hashMap = new HashMap();
        Integer num = 12;
        types$lambda$11$e(hashMap, "Material", TuplesKt.to("Plastic", 256), TuplesKt.to("SmoothPlastic", Integer.valueOf(ClothingCompositor.TORSO_H)), TuplesKt.to("Neon", 288), TuplesKt.to("Wood", 512), TuplesKt.to("WoodPlanks", 528), TuplesKt.to("Marble", 784), TuplesKt.to("Basalt", 788), TuplesKt.to("Slate", 800), TuplesKt.to("CrackedLava", 804), TuplesKt.to("Concrete", 816), TuplesKt.to("Limestone", 820), TuplesKt.to("Granite", 832), TuplesKt.to("Pavement", 836), TuplesKt.to("Brick", 848), TuplesKt.to("Pebble", 864), TuplesKt.to("Cobblestone", 880), TuplesKt.to("Rock", 896), TuplesKt.to("Sandstone", 912), TuplesKt.to("CorrodedMetal", 1040), TuplesKt.to("DiamondPlate", 1056), TuplesKt.to("Foil", 1072), TuplesKt.to("Metal", 1088), TuplesKt.to("Grass", 1280), TuplesKt.to("LeafyGrass", 1284), TuplesKt.to("Sand", 1296), TuplesKt.to("Fabric", 1312), TuplesKt.to("Snow", 1328), TuplesKt.to("Mud", 1344), TuplesKt.to("Ground", 1360), TuplesKt.to("Asphalt", 1376), TuplesKt.to("Salt", 1392), TuplesKt.to("Ice", 1536), TuplesKt.to("Glacier", 1552), TuplesKt.to("Glass", 1568), TuplesKt.to("ForceField", 1584), TuplesKt.to("Air", 1792), TuplesKt.to("Water", 2048), TuplesKt.to("Cardboard", 2304), TuplesKt.to("Carpet", 2305), TuplesKt.to("CeramicTiles", 2306), TuplesKt.to("ClayRoofTiles", 2307), TuplesKt.to("RoofShingles", 2308), TuplesKt.to("Leather", 2309), TuplesKt.to("Plaster", 2310), TuplesKt.to("Rubber", 2311));
        types$lambda$11$e(hashMap, "PartType", TuplesKt.to("Ball", 0), TuplesKt.to("Block", 1), TuplesKt.to("Cylinder", 2), TuplesKt.to("Wedge", 3), TuplesKt.to("CornerWedge", 4));
        types$lambda$11$e(hashMap, "MaterialPattern", TuplesKt.to("Regular", 0), TuplesKt.to("Organic", 1));
        types$lambda$11$e(hashMap, "SurfaceType", TuplesKt.to("Smooth", 0), TuplesKt.to("Glue", 1), TuplesKt.to("Weld", 2), TuplesKt.to("Studs", 3), TuplesKt.to("Inlet", 4), TuplesKt.to("Universal", 5), TuplesKt.to("Hinge", 6), TuplesKt.to("Motor", 7), TuplesKt.to("SteppingMotor", 8), TuplesKt.to("SmoothNoOutlines", 10));
        types$lambda$11$seq(hashMap, "EasingStyle", "Linear", "Sine", "Back", "Quad", "Quart", "Quint", "Bounce", "Elastic", "Exponential", "Circular", "Cubic");
        types$lambda$11$seq(hashMap, "EasingDirection", "In", "Out", "InOut");
        types$lambda$11$seq(hashMap, "TextXAlignment", "Left", "Right", "Center");
        types$lambda$11$seq(hashMap, "TextYAlignment", "Top", "Center", "Bottom");
        types$lambda$11$seq(hashMap, "FillDirection", "Horizontal", "Vertical");
        types$lambda$11$seq(hashMap, "HorizontalAlignment", "Center", "Left", "Right");
        types$lambda$11$seq(hashMap, "VerticalAlignment", "Center", "Top", "Bottom");
        types$lambda$11$e(hashMap, "SortOrder", TuplesKt.to("Name", 0), TuplesKt.to(TypedValues.Custom.NAME, 1), TuplesKt.to("LayoutOrder", 2));
        types$lambda$11$seq(hashMap, "ZIndexBehavior", "Global", "Sibling");
        types$lambda$11$seq(hashMap, "ScaleType", "Stretch", "Slice", "Tile", "Fit", "Crop");
        types$lambda$11$seq(hashMap, "AutomaticSize", "None", "X", "Y", "XY");
        types$lambda$11$seq(hashMap, "NormalId", "Right", "Top", "Back", "Left", "Bottom", "Front");
        types$lambda$11$e(hashMap, "RunContext", TuplesKt.to("Legacy", 0), TuplesKt.to("Server", 1), TuplesKt.to("Client", 2), TuplesKt.to("Plugin", 3));
        types$lambda$11$e(hashMap, "RaycastFilterType", TuplesKt.to("Exclude", 0), TuplesKt.to("Include", 1), TuplesKt.to("Blacklist", 0), TuplesKt.to("Whitelist", 1));
        types$lambda$11$e(hashMap, "HumanoidStateType", TuplesKt.to("FallingDown", 0), TuplesKt.to("Ragdoll", 1), TuplesKt.to("GettingUp", 2), TuplesKt.to("Jumping", 3), TuplesKt.to("Swimming", 4), TuplesKt.to("Freefall", 5), TuplesKt.to("Flying", 6), TuplesKt.to("Landed", 7), TuplesKt.to("Running", 8), TuplesKt.to("RunningNoPhysics", 10), TuplesKt.to("StrafingNoPhysics", 11), TuplesKt.to("Climbing", num), TuplesKt.to("Seated", 13), TuplesKt.to("PlatformStanding", 14), TuplesKt.to("Dead", 15), TuplesKt.to("Physics", 16), TuplesKt.to("None", 18));
        types$lambda$11$e(hashMap, "UserInputType", TuplesKt.to("MouseButton1", 0), TuplesKt.to("MouseButton2", 1), TuplesKt.to("MouseButton3", 2), TuplesKt.to("MouseWheel", 3), TuplesKt.to("MouseMovement", 4), TuplesKt.to("Touch", 7), TuplesKt.to("Keyboard", 8), TuplesKt.to("Focus", 9), TuplesKt.to("Gamepad1", num), TuplesKt.to("None", 18));
        types$lambda$11$e(hashMap, "UserInputState", TuplesKt.to("Begin", 0), TuplesKt.to("Change", 1), TuplesKt.to("End", 2), TuplesKt.to("Cancel", 3), TuplesKt.to("None", 4));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Unknown", 0);
        linkedHashMap.put("Backspace", 8);
        linkedHashMap.put("Tab", 9);
        linkedHashMap.put("Clear", num);
        linkedHashMap.put("Return", 13);
        linkedHashMap.put("Pause", 19);
        linkedHashMap.put("Escape", 27);
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Space", "QuotedDouble", "Hash", "Dollar", "Percent", "Ampersand", "Quote", "LeftParenthesis", "RightParenthesis", "Asterisk", "Plus", "Comma", "Minus", "Period", "Slash"});
        List list = listOf;
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj, Integer.valueOf(i + 32));
            i = i2;
            listOf = listOf;
            list = list;
        }
        List listOf2 = CollectionsKt.listOf((Object[]) new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"});
        boolean z = false;
        int i3 = 0;
        for (Object obj2 : listOf2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj2, Integer.valueOf(i3 + 48));
            i3 = i4;
            listOf2 = listOf2;
            z = z;
        }
        List listOf3 = CollectionsKt.listOf((Object[]) new String[]{"Colon", "Semicolon", "LessThan", "Equals", "GreaterThan", "Question", "At"});
        boolean z2 = false;
        int i5 = 0;
        for (Object obj3 : listOf3) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj3, Integer.valueOf(i5 + 58));
            i5 = i6;
            listOf3 = listOf3;
            z2 = z2;
        }
        List listOf4 = CollectionsKt.listOf((Object[]) new String[]{"LeftBracket", "BackSlash", "RightBracket", "Caret", "Underscore", "Backquote"});
        boolean z3 = false;
        int i7 = 0;
        for (Object obj4 : listOf4) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj4, Integer.valueOf(i7 + 91));
            i7 = i8;
            listOf4 = listOf4;
            z3 = z3;
        }
        for (char c = 'A'; c < '['; c = (char) (c + 1)) {
            linkedHashMap.put(String.valueOf(c), Integer.valueOf((c - 'A') + 97));
        }
        List listOf5 = CollectionsKt.listOf((Object[]) new String[]{"LeftCurly", "Pipe", "RightCurly", "Tilde", "Delete"});
        boolean z4 = false;
        int i9 = 0;
        for (Object obj5 : listOf5) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj5, Integer.valueOf(i9 + 123));
            i9 = i10;
            listOf5 = listOf5;
            z4 = z4;
        }
        List listOf6 = CollectionsKt.listOf((Object[]) new String[]{"KeypadZero", "KeypadOne", "KeypadTwo", "KeypadThree", "KeypadFour", "KeypadFive", "KeypadSix", "KeypadSeven", "KeypadEight", "KeypadNine", "KeypadPeriod", "KeypadDivide", "KeypadMultiply", "KeypadMinus", "KeypadPlus", "KeypadEnter", "KeypadEquals", "Up", "Down", "Right", "Left", "Insert", StartScreen.HOME, "End", "PageUp", "PageDown"});
        boolean z5 = false;
        int i11 = 0;
        for (Object obj6 : listOf6) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj6, Integer.valueOf(i11 + 256));
            i11 = i12;
            listOf6 = listOf6;
            num = num;
            z5 = z5;
        }
        Integer num2 = num;
        int i13 = 1;
        for (int i14 = 16; i13 < i14; i14 = 16) {
            linkedHashMap.put("F" + i13, Integer.valueOf(i13 + 281));
            i13++;
        }
        List listOf7 = CollectionsKt.listOf((Object[]) new String[]{"NumLock", "CapsLock", "ScrollLock", "RightShift", "LeftShift", "RightControl", "LeftControl", "RightAlt", "LeftAlt", "RightMeta", "LeftMeta", "LeftSuper", "RightSuper", "Mode", "Compose", "Help", "Print", "SysReq", "Break", "Menu", "Power", "Euro", "Undo"});
        boolean z6 = false;
        int i15 = 0;
        for (Object obj7 : listOf7) {
            int i16 = i15 + 1;
            if (i15 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj7, Integer.valueOf(i15 + MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION));
            i15 = i16;
            listOf7 = listOf7;
            z6 = z6;
        }
        List listOf8 = CollectionsKt.listOf((Object[]) new String[]{"ButtonX", "ButtonY", "ButtonA", "ButtonB", "ButtonR1", "ButtonL1", "ButtonR2", "ButtonL2", "ButtonR3", "ButtonL3", "ButtonStart", "ButtonSelect", "DPadLeft", "DPadRight", "DPadUp", "DPadDown", "Thumbstick1", "Thumbstick2"});
        boolean z7 = false;
        int i17 = 0;
        for (Object obj8 : listOf8) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj8, Integer.valueOf(i17 + 1000));
            i17 = i18;
            listOf8 = listOf8;
            z7 = z7;
        }
        Unit unit = Unit.INSTANCE;
        hashMap.put("KeyCode", linkedHashMap);
        types$lambda$11$e(hashMap, "CameraType", TuplesKt.to("Fixed", 0), TuplesKt.to("Attach", 1), TuplesKt.to("Watch", 2), TuplesKt.to("Track", 3), TuplesKt.to("Follow", 4), TuplesKt.to(TypedValues.Custom.NAME, 5), TuplesKt.to("Scriptable", 6), TuplesKt.to("Orbital", 7));
        types$lambda$11$e(hashMap, "Font", TuplesKt.to("Legacy", 0), TuplesKt.to("Arial", 1), TuplesKt.to("ArialBold", 2), TuplesKt.to("SourceSans", 3), TuplesKt.to("SourceSansBold", 4), TuplesKt.to("SourceSansLight", 5), TuplesKt.to("SourceSansItalic", 6), TuplesKt.to("Bodoni", 7), TuplesKt.to("Garamond", 8), TuplesKt.to("Cartoon", 9), TuplesKt.to("Code", 10), TuplesKt.to("Highway", 11), TuplesKt.to("SciFi", num2), TuplesKt.to("Arcade", 13), TuplesKt.to("Fantasy", 14), TuplesKt.to("Antique", 15), TuplesKt.to("SourceSansSemibold", 16), TuplesKt.to("Gotham", 17), TuplesKt.to("GothamMedium", 18), TuplesKt.to("GothamBold", 19), TuplesKt.to("GothamBlack", 20), TuplesKt.to("AmaticSC", 21), TuplesKt.to("Bangers", 22), TuplesKt.to("Creepster", 23), TuplesKt.to("DenkOne", 24), TuplesKt.to("Fondamento", 25), TuplesKt.to("FredokaOne", 26), TuplesKt.to("GrenzeGotisch", 27), TuplesKt.to("IndieFlower", 28), TuplesKt.to("JosefinSans", 29), TuplesKt.to("Jura", 30), TuplesKt.to("Kalam", 31), TuplesKt.to("LuckiestGuy", 32), TuplesKt.to("Merriweather", 33), TuplesKt.to("Michroma", 34), TuplesKt.to("Nunito", 35), TuplesKt.to("Oswald", 36), TuplesKt.to("PatrickHand", 37), TuplesKt.to("PermanentMarker", 38), TuplesKt.to("Roboto", 39), TuplesKt.to("RobotoCondensed", 40), TuplesKt.to("RobotoMono", 41), TuplesKt.to("Sarpanch", 42), TuplesKt.to("SpecialElite", 43), TuplesKt.to("TitilliumWeb", 44), TuplesKt.to("Ubuntu", 45), TuplesKt.to("BuilderSans", 46));
        types$lambda$11$e(hashMap, "MeshType", TuplesKt.to("Head", 0), TuplesKt.to("Torso", 1), TuplesKt.to("Wedge", 2), TuplesKt.to("Sphere", 3), TuplesKt.to("Cylinder", 4), TuplesKt.to("FileMesh", 5), TuplesKt.to("Brick", 6), TuplesKt.to("Prism", 7), TuplesKt.to("Pyramid", 8));
        types$lambda$11$e(hashMap, "FormFactor", TuplesKt.to("Symmetric", 0), TuplesKt.to("Brick", 1), TuplesKt.to("Plate", 2), TuplesKt.to(TypedValues.Custom.NAME, 3));
        types$lambda$11$e(hashMap, "SizeConstraint", TuplesKt.to("RelativeXY", 0), TuplesKt.to("RelativeXX", 1), TuplesKt.to("RelativeYY", 2));
        types$lambda$11$e(hashMap, "BorderMode", TuplesKt.to("Outline", 0), TuplesKt.to("Middle", 1), TuplesKt.to("Inset", 2));
        types$lambda$11$e(hashMap, "ApplyStrokeMode", TuplesKt.to("Contextual", 0), TuplesKt.to("Border", 1));
        types$lambda$11$e(hashMap, "Technology", TuplesKt.to("Legacy", 0), TuplesKt.to("Voxel", 1), TuplesKt.to("Compatibility", 2), TuplesKt.to("ShadowMap", 3), TuplesKt.to("Future", 4));
        types$lambda$11$e(hashMap, "ScrollingDirection", TuplesKt.to("X", 1), TuplesKt.to("Y", 2), TuplesKt.to("XY", 4));
        types$lambda$11$e(hashMap, "HighlightDepthMode", TuplesKt.to("AlwaysOnTop", 0), TuplesKt.to("Occluded", 1));
        types$lambda$11$e(hashMap, "ScreenInsets", TuplesKt.to("None", 0), TuplesKt.to("DeviceSafeInsets", 1), TuplesKt.to("CoreUISafeInsets", 2), TuplesKt.to("TopbarSafeInsets", 3));
        types$lambda$11$e(hashMap, "ResamplerMode", TuplesKt.to("Default", 0), TuplesKt.to("Pixelated", 1));
        types$lambda$11$e(hashMap, "Limb", TuplesKt.to("Head", 0), TuplesKt.to("Torso", 1), TuplesKt.to("LeftArm", 2), TuplesKt.to("RightArm", 3), TuplesKt.to("LeftLeg", 4), TuplesKt.to("RightLeg", 5), TuplesKt.to("Unknown", 6));
        types$lambda$11$e(hashMap, "HumanoidRigType", TuplesKt.to("R6", 0), TuplesKt.to("R15", 1));
        types$lambda$11$e(hashMap, "GameAvatarType", TuplesKt.to("R6", 0), TuplesKt.to("R15", 1), TuplesKt.to("PlayerChoice", 2));
        types$lambda$11$e(hashMap, "R15CollisionType", TuplesKt.to("OuterBox", 0), TuplesKt.to("InnerBox", 1));
        types$lambda$11$e(hashMap, "AnimationPriority", TuplesKt.to("Idle", 0), TuplesKt.to("Movement", 1), TuplesKt.to("Action", 2), TuplesKt.to("Core", 1000));
        types$lambda$11$e(hashMap, "CoreGuiType", TuplesKt.to("PlayerList", 0), TuplesKt.to("Health", 1), TuplesKt.to("Backpack", 2), TuplesKt.to("Chat", 3), TuplesKt.to("All", 4), TuplesKt.to("EmotesMenu", 5), TuplesKt.to("SelfView", 6), TuplesKt.to("Captures", 7));
        types$lambda$11$e(hashMap, "CameraMode", TuplesKt.to("Classic", 0), TuplesKt.to("LockFirstPerson", 1));
        types$lambda$11$e(hashMap, "TextChatMessageStatus", TuplesKt.to("Unknown", 0), TuplesKt.to("Success", 1), TuplesKt.to("Sending", 2));
        types$lambda$11$e(hashMap, "CollisionFidelity", TuplesKt.to("Default", 0), TuplesKt.to("Hull", 1), TuplesKt.to("Box", 2), TuplesKt.to("PreciseConvexDecomposition", 3));
        types$lambda$11$e(hashMap, "RenderFidelity", TuplesKt.to("Automatic", 0), TuplesKt.to("Precise", 1), TuplesKt.to("Performance", 2));
        types$lambda$11$e(hashMap, "FluidFidelity", TuplesKt.to("Automatic", 0), TuplesKt.to("UseCollisionGeometry", 1), TuplesKt.to("UsePreciseGeometry", 2));
        types = hashMap;
    }

    private Enums() {
    }

    private static final void types$lambda$11$e(HashMap<String, LinkedHashMap<String, Integer>> hashMap, String str, Pair<String, Integer>... pairArr) {
        hashMap.put(str, MapsKt.linkedMapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
    }

    private static final void types$lambda$11$seq(HashMap<String, LinkedHashMap<String, Integer>> hashMap, String str, String... strArr) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        int i = 0;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            linkedHashMap.put(strArr[i2], Integer.valueOf(i));
            i2++;
            i++;
        }
        Unit unit = Unit.INSTANCE;
        hashMap.put(str, linkedHashMap);
    }

    public final Map<String, LinkedHashMap<String, Integer>> getTypes() {
        return types;
    }

    public final String itemName(String type, int value) {
        LinkedHashMap<String, Integer> linkedHashMap;
        Object obj;
        Map<String, LinkedHashMap<String, Integer>> map = types;
        if (type == null || (linkedHashMap = map.get(type)) == null) {
            return null;
        }
        Set<Map.Entry<String, Integer>> entrySet = linkedHashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer num = (Integer) ((Map.Entry) obj).getValue();
            if (num != null && num.intValue() == value) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return (String) entry.getKey();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
    
        if (r5.equals("Material") == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
    
        return "Material";
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x015c, code lost:
    
        if (r5.equals("BaseMaterial") != false) goto L100;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0012. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01af A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0187 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String typeForProp(java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.model.Enums.typeForProp(java.lang.String, java.lang.String):java.lang.String");
    }
}
