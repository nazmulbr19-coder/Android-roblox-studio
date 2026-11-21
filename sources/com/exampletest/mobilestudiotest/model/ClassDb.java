package com.exampletest.mobilestudiotest.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Instance.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/ClassDb;", "", "<init>", "()V", "parents", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "superclass", "c", "isA", "", TypedValues.AttributesType.S_TARGET, "serviceNames", "", "getServiceNames", "()Ljava/util/List;", "otherServices", "", "isServiceName", "n", "insertable", "getInsertable", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClassDb {
    public static final ClassDb INSTANCE = new ClassDb();
    private static final List<String> insertable;
    private static final Set<String> otherServices;
    private static final HashMap<String, String> parents;
    private static final List<String> serviceNames;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        parents$lambda$0$p(hashMap, "Instance", "PVInstance", "LuaSourceContainer", "GuiBase", "Light", "ValueBase", "Humanoid", "Folder", "Configuration", "JointInstance", "WeldConstraint", "Constraint", "Attachment", "Sound", "ClickDetector", "DataModelMesh", "FaceInstance", "UIBase", "BackpackItem", "Accoutrement", "Player", "Camera", "Animator", "Animation", "Team", "BindableEvent", "BindableFunction", "RemoteEvent", "RemoteFunction", "ParticleEmitter", "Fire", "Smoke", "Sparkles", "Trail", "Beam", "Highlight", "ProximityPrompt", "Explosion", "ForceField", "Plugin", "PluginToolbar", "PluginToolbarButton", "Sky", "Atmosphere", "PostEffect", "Clouds", "Script Context", "DataModel");
        parents$lambda$0$p(hashMap, "PVInstance", "BasePart", "Model");
        parents$lambda$0$p(hashMap, "Model", "WorldRoot", "Status");
        parents$lambda$0$p(hashMap, "WorldRoot", "Workspace", "WorldModel");
        parents$lambda$0$p(hashMap, "BasePart", "FormFactorPart", "TriangleMeshPart", "Terrain", "TrussPart", "VehicleSeat");
        parents$lambda$0$p(hashMap, "FormFactorPart", "Part", "WedgePart", "CornerWedgePart");
        parents$lambda$0$p(hashMap, "Part", "SpawnLocation", "Seat", "Platform", "SkateboardPlatform");
        parents$lambda$0$p(hashMap, "TriangleMeshPart", "MeshPart", "PartOperation");
        parents$lambda$0$p(hashMap, "PartOperation", "UnionOperation", "NegateOperation", "IntersectOperation");
        parents$lambda$0$p(hashMap, "LuaSourceContainer", "BaseScript", "ModuleScript");
        parents$lambda$0$p(hashMap, "BaseScript", "Script");
        parents$lambda$0$p(hashMap, "Script", "LocalScript");
        parents$lambda$0$p(hashMap, "GuiBase", "GuiBase2d", "GuiBase3d");
        parents$lambda$0$p(hashMap, "GuiBase2d", "GuiObject", "LayerCollector");
        parents$lambda$0$p(hashMap, "LayerCollector", "ScreenGui", "BillboardGui", "SurfaceGuiBase", "PluginGui");
        parents$lambda$0$p(hashMap, "SurfaceGuiBase", "SurfaceGui");
        parents$lambda$0$p(hashMap, "PluginGui", "DockWidgetPluginGui", "QWidgetPluginGui");
        parents$lambda$0$p(hashMap, "GuiObject", "Frame", "GuiLabel", "GuiButton", "TextBox", "ScrollingFrame", "ViewportFrame", "CanvasGroup", "VideoFrame");
        parents$lambda$0$p(hashMap, "GuiLabel", "TextLabel", "ImageLabel");
        parents$lambda$0$p(hashMap, "GuiButton", "TextButton", "ImageButton");
        parents$lambda$0$p(hashMap, "Light", "PointLight", "SpotLight", "SurfaceLight");
        parents$lambda$0$p(hashMap, "ValueBase", "StringValue", "IntValue", "NumberValue", "BoolValue", "ObjectValue", "Vector3Value", "CFrameValue", "Color3Value", "BrickColorValue", "RayValue");
        parents$lambda$0$p(hashMap, "JointInstance", "Weld", "Snap", "Motor", "ManualWeld", "Glue");
        parents$lambda$0$p(hashMap, "Motor", "Motor6D");
        parents$lambda$0$p(hashMap, "DataModelMesh", "FileMesh", "BevelMesh");
        parents$lambda$0$p(hashMap, "FileMesh", "SpecialMesh");
        parents$lambda$0$p(hashMap, "BevelMesh", "BlockMesh", "CylinderMesh");
        parents$lambda$0$p(hashMap, "FaceInstance", "Decal");
        parents$lambda$0$p(hashMap, "Decal", "Texture");
        parents$lambda$0$p(hashMap, "UIBase", "UIComponent");
        parents$lambda$0$p(hashMap, "UIComponent", "UILayout", "UICorner", "UIStroke", "UIPadding", "UIGradient", "UIScale", "UIConstraint", "UIAspectRatioConstraint", "UISizeConstraint");
        parents$lambda$0$p(hashMap, "UILayout", "UIGridStyleLayout");
        parents$lambda$0$p(hashMap, "UIGridStyleLayout", "UIListLayout", "UIGridLayout", "UITableLayout", "UIPageLayout");
        parents$lambda$0$p(hashMap, "BackpackItem", "Tool", "HopperBin");
        parents$lambda$0$p(hashMap, "Accoutrement", "Accessory", "Hat");
        parents$lambda$0$p(hashMap, "Constraint", "PrismaticConstraint", "CylindricalConstraint", "TorsionSpringConstraint", "PlaneConstraint", "RopeConstraint", "RodConstraint", "SpringConstraint", "HingeConstraint", "BallSocketConstraint", "AlignPosition", "AlignOrientation", "LinearVelocity", "VectorForce", "AngularVelocity", "LineForce", "NoCollisionConstraint", "RigidConstraint", "Torque", "UniversalConstraint", "SlidingBallConstraint");
        parents$lambda$0$p(hashMap, "SlidingBallConstraint", "PrismaticConstraint", "CylindricalConstraint");
        parents$lambda$0$p(hashMap, "Instance", "BodyMover", "PostEffect", "SoundEffect", "SoundGroup", "AnimationController", "HumanoidDescription", "BodyColors", "CharacterAppearance", "SurfaceAppearance", "Keyframe", "KeyframeSequence", "Pose", "KeyframeMarker", "PathfindingModifier", "PathfindingLink", "Dialog", "DialogChoice", "DragDetector", "UnreliableRemoteEvent", "Wire", "AudioPlayer", "AudioEmitter", "AudioListener", "AudioDeviceOutput", "AudioDeviceInput", "AudioFader", "AudioReverb", "AudioEqualizer", "AudioEcho", "AudioAnalyzer", "IKControl", "WrapLayer", "WrapTarget", "TextChatCommand", "TextChannel", "Actor", "StyleSheet", "StyleRule", "ClickDetector", "MaterialVariant", "AdvancedDragger", "BubbleChatConfiguration");
        parents$lambda$0$p(hashMap, "Model", "Actor");
        parents$lambda$0$p(hashMap, "Attachment", "Bone");
        parents$lambda$0$p(hashMap, "CharacterAppearance", "Clothing", "ShirtGraphic", "CharacterMesh", "BodyColors");
        parents$lambda$0$p(hashMap, "Clothing", "Shirt", "Pants");
        parents$lambda$0$p(hashMap, "BodyMover", "BodyAngularVelocity", "BodyForce", "BodyGyro", "BodyPosition", "BodyThrust", "BodyVelocity", "RocketPropulsion");
        parents$lambda$0$p(hashMap, "PostEffect", "BloomEffect", "BlurEffect", "ColorCorrectionEffect", "DepthOfFieldEffect", "SunRaysEffect");
        parents$lambda$0$p(hashMap, "SoundEffect", "ChorusSoundEffect", "CompressorSoundEffect", "DistortionSoundEffect", "EchoSoundEffect", "EqualizerSoundEffect", "FlangeSoundEffect", "PitchShiftSoundEffect", "ReverbSoundEffect", "TremoloSoundEffect");
        parents$lambda$0$p(hashMap, "GuiBase3d", "PVAdornment", "SelectionLasso", "InstanceAdornment");
        parents$lambda$0$p(hashMap, "PVAdornment", "HandleAdornment", "SelectionBox", "SelectionSphere", "HandlesBase", "SurfaceSelection");
        parents$lambda$0$p(hashMap, "HandleAdornment", "BoxHandleAdornment", "ConeHandleAdornment", "CylinderHandleAdornment", "SphereHandleAdornment", "LineHandleAdornment", "ImageHandleAdornment", "WireframeHandleAdornment");
        parents$lambda$0$p(hashMap, "HandlesBase", "Handles", "ArcHandles");
        parents$lambda$0$p(hashMap, "InstanceAdornment", "Highlight");
        parents$lambda$0$p(hashMap, "UIConstraint", "UIAspectRatioConstraint", "UISizeConstraint", "UITextSizeConstraint");
        parents$lambda$0$p(hashMap, "UIComponent", "UIFlexItem", "UIDragDetector");
        parents$lambda$0$p(hashMap, "ValueBase", "IntConstrainedValue", "DoubleConstrainedValue");
        parents = hashMap;
        serviceNames = CollectionsKt.listOf((Object[]) new String[]{"Workspace", "Players", "Lighting", "MaterialService", "ReplicatedFirst", "ReplicatedStorage", "ServerScriptService", "ServerStorage", "StarterGui", "StarterPack", "StarterPlayer", "Teams", "SoundService", "Chat", "TextChatService", "LocalizationService", "TestService"});
        otherServices = SetsKt.setOf((Object[]) new String[]{"RunService", "TweenService", "Debris", "HttpService", "UserInputService", "ContextActionService", "CollectionService", "MarketplaceService", "DataStoreService", "Selection", "ChangeHistoryService", "PathfindingService", "TextService", "GuiService", "BadgeService", "PhysicsService", "InsertService", "CoreGui", "StudioService", "ProximityPromptService", "VRService", "HapticService", "GroupService", "MessagingService", "AssetService", "SocialService", "PolicyService", "ScriptContext", "KeyframeSequenceProvider", "AnimationClipProvider", "TeleportService", "MemoryStoreService", "RbxAnalyticsService", "AnalyticsService", "ContentProvider", "LogService", "ScriptEditorService", "Stats", "DraggerService", "PluginGuiService", "StudioAssetService", "AvatarEditorService", "VoiceChatService", "ExperienceNotificationService", "LocalizationService", "NotificationService", "GamepadService", "KeyboardService", "MouseService", "AssetImportService"});
        insertable = CollectionsKt.sorted(CollectionsKt.distinct(CollectionsKt.listOf((Object[]) new String[]{"Part", "WedgePart", "CornerWedgePart", "TrussPart", "SpawnLocation", "Seat", "VehicleSeat", "MeshPart", "Model", "Folder", "Actor", "WorldModel", "Configuration", "Camera", "Attachment", "Bone", "Script", "LocalScript", "ModuleScript", "ScreenGui", "BillboardGui", "SurfaceGui", "Frame", "ScrollingFrame", "TextLabel", "TextButton", "TextBox", "ImageLabel", "ImageButton", "ViewportFrame", "VideoFrame", "CanvasGroup", "UICorner", "UIStroke", "UIListLayout", "UIGridLayout", "UIPageLayout", "UITableLayout", "UIPadding", "UIGradient", "UIScale", "UIAspectRatioConstraint", "UISizeConstraint", "UITextSizeConstraint", "UIFlexItem", "UIDragDetector", "PointLight", "SpotLight", "SurfaceLight", "ParticleEmitter", "Fire", "Smoke", "Sparkles", "Trail", "Beam", "Explosion", "ForceField", "Highlight", "SelectionBox", "SelectionSphere", "BoxHandleAdornment", "ConeHandleAdornment", "CylinderHandleAdornment", "SphereHandleAdornment", "LineHandleAdornment", "ImageHandleAdornment", "Sky", "Atmosphere", "Clouds", "BloomEffect", "BlurEffect", "ColorCorrectionEffect", "DepthOfFieldEffect", "SunRaysEffect", "Sound", "SoundGroup", "ChorusSoundEffect", "CompressorSoundEffect", "DistortionSoundEffect", "EchoSoundEffect", "EqualizerSoundEffect", "FlangeSoundEffect", "PitchShiftSoundEffect", "ReverbSoundEffect", "TremoloSoundEffect", "AudioPlayer", "AudioEmitter", "AudioListener", "AudioDeviceOutput", "AudioFader", "AudioReverb", "AudioEqualizer", "Wire", "WeldConstraint", "Weld", "Motor6D", "RopeConstraint", "RodConstraint", "SpringConstraint", "HingeConstraint", "BallSocketConstraint", "PrismaticConstraint", "CylindricalConstraint", "TorsionSpringConstraint", "UniversalConstraint", "PlaneConstraint", "RigidConstraint", "NoCollisionConstraint", "AlignPosition", "AlignOrientation", "LinearVelocity", "AngularVelocity", "VectorForce", "LineForce", "Torque", "BodyVelocity", "BodyPosition", "BodyGyro", "BodyForce", "BodyAngularVelocity", "BodyThrust", "RocketPropulsion", "SpecialMesh", "BlockMesh", "CylinderMesh", "SurfaceAppearance", "Decal", "Texture", "MaterialVariant", "Humanoid", "HumanoidDescription", "Animator", "AnimationController", "Animation", "KeyframeSequence", "IKControl", "Shirt", "Pants", "ShirtGraphic", "BodyColors", "Accessory", "Tool", "ClickDetector", "ProximityPrompt", "DragDetector", "Dialog", "DialogChoice", "PathfindingModifier", "PathfindingLink", "RemoteEvent", "RemoteFunction", "UnreliableRemoteEvent", "BindableEvent", "BindableFunction", "StringValue", "IntValue", "NumberValue", "BoolValue", "ObjectValue", "Vector3Value", "CFrameValue", "Color3Value", "BrickColorValue", "RayValue", "Team", "TextChatCommand"})));
    }

    private ClassDb() {
    }

    private static final void parents$lambda$0$p(HashMap<String, String> hashMap, String str, String... strArr) {
        for (String str2 : strArr) {
            hashMap.put(str2, str);
        }
    }

    public final List<String> getInsertable() {
        return insertable;
    }

    public final List<String> getServiceNames() {
        return serviceNames;
    }

    public final boolean isA(String c, String target) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(target, "target");
        if (Intrinsics.areEqual(target, "Instance")) {
            return true;
        }
        String str = c;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 20) {
                return false;
            }
            if (Intrinsics.areEqual(str, target)) {
                return true;
            }
            if (Intrinsics.areEqual(str, "Instance")) {
                return false;
            }
            String str2 = parents.get(str);
            if (str2 == null) {
                str2 = "Instance";
            }
            str = str2;
            i = i2;
        }
    }

    public final boolean isServiceName(String n) {
        Intrinsics.checkNotNullParameter(n, "n");
        return serviceNames.contains(n) || otherServices.contains(n);
    }

    public final String superclass(String c) {
        Intrinsics.checkNotNullParameter(c, "c");
        String str = parents.get(c);
        if (str != null) {
            return str;
        }
        if (Intrinsics.areEqual(c, "Instance")) {
            return null;
        }
        isServiceName(c);
        return "Instance";
    }
}
