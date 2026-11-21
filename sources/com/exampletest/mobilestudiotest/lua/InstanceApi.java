package com.exampletest.mobilestudiotest.lua;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.engine.Geometry;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.engine.RayHit;
import com.exampletest.mobilestudiotest.model.BinaryString;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Enums;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.OptionalCFrame;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.PropNames;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

/* compiled from: InstanceApi.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020'H\u0002J\u0018\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\nJ\u0016\u0010+\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\nJ \u00100\u001a\u0002012\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u0001J\u001f\u00103\u001a\u0004\u0018\u0001042\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\nH\u0002¢\u0006\u0002\u00105J\u0016\u00106\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'2\u0006\u00107\u001a\u00020\nJ\u001e\u00108\u001a\u0002012\u0006\u0010&\u001a\u00020'2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u000bJ\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020'0<2\u0006\u0010)\u001a\u00020'J\u001a\u0010=\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020'2\u0006\u00109\u001a\u00020\nH\u0002J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020'J\u0016\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020?J\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020\n0E2\u0006\u0010)\u001a\u00020'H\u0002J\u001e\u0010F\u001a\u0002012\u0006\u0010)\u001a\u00020'2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0<H\u0002J\u0016\u0010H\u001a\u00020\u00112\f\u0010I\u001a\b\u0012\u0004\u0012\u00020'0<H\u0002J\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020'0<2\u0006\u0010:\u001a\u00020\u000bH\u0002J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020'0<H\u0002J\u001c\u0010L\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0M2\u0006\u0010N\u001a\u00020\u000bH\u0002J,\u0010O\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020Q2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0MH\u0002J\u0010\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020'H\u0002J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010:\u001a\u000204H\u0002J\u001a\u0010[\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020'2\b\u0010\\\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010]\u001a\u00020'2\u0006\u0010^\u001a\u00020_2\u0006\u0010 \u001a\u00020\nH\u0002J\u0016\u0010`\u001a\u00020_2\u0006\u0010 \u001a\u00020\n2\u0006\u0010^\u001a\u00020_J\u0016\u0010a\u001a\u00020_2\u0006\u0010 \u001a\u00020\n2\u0006\u0010^\u001a\u00020_J\u0016\u0010b\u001a\u00020_2\u0006\u0010 \u001a\u00020\n2\u0006\u0010^\u001a\u00020_J\u001e\u0010c\u001a\u00020_2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\n2\u0006\u0010^\u001a\u00020_J\u001e\u0010d\u001a\u00020_2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\n2\u0006\u0010^\u001a\u00020_J\u001e\u0010e\u001a\u00020_2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\n2\u0006\u0010^\u001a\u00020_R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\u000ej\b\u0012\u0004\u0012\u00020\n`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00160\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010/\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00160\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010T\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0<0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010W\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002040X0<X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", "", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "<init>", "(Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;)V", "getRt", "()Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "methodCache", "Ljava/util/HashMap;", "", "Lorg/luaj/vm2/LuaValue;", "Lkotlin/collections/HashMap;", "warnedMissing", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "signalMeta", "Lorg/luaj/vm2/LuaTable;", "getSignalMeta", "()Lorg/luaj/vm2/LuaTable;", "connMeta", "commonMethods", "", "classMethods", "", "events", "getEvents", "()Ljava/util/Set;", "sequenceClasses", "universalEvents", "signal", "owner", "name", "connectionValue", "c", "Lcom/exampletest/mobilestudiotest/lua/Connection;", "methodAllowed", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "isPart", "i", "getK", "hasK", "CONSTRAINT_READOUTS", "BASE_PROPS", "PART_PROPS", "SPECIAL_PROPS", "setK", "", "value", "typeHint", "", "(Lcom/exampletest/mobilestudiotest/model/Instance;Ljava/lang/String;)Ljava/lang/Integer;", "index", "key0", "newIndex", "key", "v", "partsIn", "", "contentAlias", "modelPivot", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "m", "pivotTo", TypedValues.AttributesType.S_TARGET, "cf", "tags", "", "setTags", "t", "listToLua", "l", "instList", "workspaceParts", "filterFrom", "Lkotlin/Function1;", "params", "raycastResult", "o", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "d", "filter", "MEMBER_OWNERS", "isEditCamera", "cam", "PRIORITIES", "Lkotlin/Pair;", "priorityItem", "Lcom/exampletest/mobilestudiotest/lua/EnumItemV;", "animationTrack", "anim", "self", "a", "Lorg/luaj/vm2/Varargs;", "callMethod", "collectionCall", "workspaceCall", "modelCall", "partCall", "humanoidCall", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InstanceApi {
    private final Set<String> BASE_PROPS;
    private final Set<String> CONSTRAINT_READOUTS;
    private final Map<String, List<String>> MEMBER_OWNERS;
    private final Set<String> PART_PROPS;
    private final List<Pair<String, Integer>> PRIORITIES;
    private final Map<String, Set<String>> SPECIAL_PROPS;
    private final Map<String, Set<String>> classMethods;
    private final Set<String> commonMethods;
    private final LuaTable connMeta;
    private final Set<String> events;
    private final HashMap<String, LuaValue> methodCache;
    private final LuaRuntime rt;
    private final Set<String> sequenceClasses;
    private final LuaTable signalMeta;
    private final Set<String> universalEvents;
    private final HashSet<String> warnedMissing;

    /* compiled from: InstanceApi.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/exampletest/mobilestudiotest/lua/InstanceApi$2", "Lorg/luaj/vm2/lib/ThreeArgFunction;", NotificationCompat.CATEGORY_CALL, "Lorg/luaj/vm2/LuaValue;", "self", "key", "v", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.exampletest.mobilestudiotest.lua.InstanceApi$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends ThreeArgFunction {
        AnonymousClass2() {
        }

        @Override // org.luaj.vm2.lib.ThreeArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue self, LuaValue key, LuaValue v) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(v, "v");
            InstanceApi instanceApi = InstanceApi.this;
            Object obj = self.touserdata();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.Instance");
            String str = key.tojstring();
            Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
            instanceApi.newIndex((Instance) obj, str, v);
            LuaValue NONE = LuaValue.NONE;
            Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            return NONE;
        }
    }

    public InstanceApi(LuaRuntime rt) {
        Intrinsics.checkNotNullParameter(rt, "rt");
        this.rt = rt;
        this.methodCache = new HashMap<>();
        this.warnedMissing = new HashSet<>();
        this.signalMeta = new LuaTable();
        this.connMeta = new LuaTable();
        char c = 6;
        char c2 = 21;
        this.commonMethods = SetsKt.setOf((Object[]) new String[]{"FindFirstChild", "FindFirstChildOfClass", "FindFirstChildWhichIsA", "FindFirstAncestor", "FindFirstAncestorOfClass", "FindFirstAncestorWhichIsA", "FindFirstDescendant", "WaitForChild", "GetChildren", "GetDescendants", "IsA", "IsDescendantOf", "IsAncestorOf", "Destroy", "Remove", "Clone", "ClearAllChildren", "GetFullName", "GetAttribute", "SetAttribute", "GetAttributes", "GetAttributeChangedSignal", "GetPropertyChangedSignal", "GetService", "FindService", "GetTags", "HasTag", "AddTag", "RemoveTag", "GetActor", "GetDebugId", "IsPropertyModified", "ResetPropertyToDefault"});
        this.classMethods = MapsKt.mapOf(TuplesKt.to("BasePart", SetsKt.setOf((Object[]) new String[]{"GetMass", "ApplyImpulse", "ApplyAngularImpulse", "GetConnectedParts", "GetTouchingParts", "GetRootPart", "SetNetworkOwner", "GetNetworkOwner", "CanSetNetworkOwnership", "BreakJoints", "MakeJoints", "Resize", "GetVelocityAtPosition", "GetPivot", "PivotTo", "IsGrounded", "GetJoints"})), TuplesKt.to("Model", SetsKt.setOf((Object[]) new String[]{"GetPivot", "PivotTo", "MoveTo", "SetPrimaryPartCFrame", "GetPrimaryPartCFrame", "GetBoundingBox", "GetExtentsSize", "BreakJoints", "MakeJoints", "TranslateBy", "GetModelCFrame", "GetModelSize", "ScaleTo", "GetScale"})), TuplesKt.to("Humanoid", SetsKt.setOf((Object[]) new String[]{"TakeDamage", "MoveTo", "ChangeState", "GetState", "LoadAnimation", "EquipTool", "UnequipTools", "GetPlayingAnimationTracks", "SetStateEnabled", "GetStateEnabled", "Move", "ApplyDescription", "GetAppliedDescription", "AddAccessory", "GetAccessories"})), TuplesKt.to("Animator", SetsKt.setOf((Object[]) new String[]{"LoadAnimation", "GetPlayingAnimationTracks"})), TuplesKt.to("AnimationController", SetsKt.setOf((Object[]) new String[]{"LoadAnimation", "GetPlayingAnimationTracks"})), TuplesKt.to("Workspace", SetsKt.setOf((Object[]) new String[]{"Raycast", "FindPartOnRay", "FindPartOnRayWithIgnoreList", "FindPartOnRayWithWhitelist", "GetPartBoundsInBox", "GetPartBoundsInRadius", "GetPartsInPart", "GetServerTimeNow", "GetRealPhysicsFPS", "Spherecast", "Blockcast", "FindPartsInRegion3", "FindPartsInRegion3WithIgnoreList", "FindPartsInRegion3WithWhiteList", "IsRegion3Empty", "IsRegion3EmptyWithIgnoreList", "JoinToOutsiders", "UnjoinFromOutsiders", "BulkMoveTo", "ArePartsTouchingOthers", "GetNumAwakeParts", "PGSIsEnabled", "SetInsertPoint", "ZoomToExtents", "CalculateJumpPower", "CalculateJumpHeight", "GetPhysicsThrottling", "Shapecast"})), TuplesKt.to("Players", SetsKt.setOf((Object[]) new String[]{"GetPlayers", "GetPlayerFromCharacter", "GetPlayerByUserId", "GetUserIdFromNameAsync", "GetNameFromUserIdAsync", "GetUserThumbnailAsync", "GetHumanoidDescriptionFromUserId"})), TuplesKt.to("Player", SetsKt.setOf((Object[]) new String[]{"Kick", "LoadCharacter", "GetMouse", "IsInGroup", "GetRankInGroup", "GetRoleInGroup", "DistanceFromCharacter", "IsFriendsWith", "HasAppearanceLoaded", "GetJoinData", "ClearCharacterAppearance", "GetNetworkPing"})), TuplesKt.to("RunService", SetsKt.setOf((Object[]) new String[]{"IsStudio", "IsRunning", "IsServer", "IsClient", "IsEdit", "IsRunMode", "BindToRenderStep", "UnbindFromRenderStep"})), TuplesKt.to("TweenService", SetsKt.setOf((Object[]) new String[]{"Create", "GetValue"})), TuplesKt.to("Debris", SetsKt.setOf((Object[]) new String[]{"AddItem", "addItem"})), TuplesKt.to("HttpService", SetsKt.setOf((Object[]) new String[]{"JSONEncode", "JSONDecode", "GenerateGUID", "UrlEncode", "GetAsync", "PostAsync", "RequestAsync"})), TuplesKt.to("CollectionService", SetsKt.setOf((Object[]) new String[]{"GetTagged", "AddTag", "RemoveTag", "HasTag", "GetTags", "GetInstanceAddedSignal", "GetInstanceRemovedSignal", "GetAllTags"})), TuplesKt.to("Selection", SetsKt.setOf((Object[]) new String[]{"Get", "Set", "Add", "Remove"})), TuplesKt.to("ChangeHistoryService", SetsKt.setOf((Object[]) new String[]{"SetWaypoint", "TryBeginRecording", "FinishRecording", "Undo", "Redo", "ResetWaypoints", "SetEnabled", "GetCanUndo", "GetCanRedo"})), TuplesKt.to("DataStoreService", SetsKt.setOf((Object[]) new String[]{"GetDataStore", "GetGlobalDataStore", "GetOrderedDataStore"})), TuplesKt.to("MarketplaceService", SetsKt.setOf((Object[]) new String[]{"PromptPurchase", "PromptGamePassPurchase", "PromptProductPurchase", "UserOwnsGamePassAsync", "GetProductInfo", "PlayerOwnsAsset"})), TuplesKt.to("UserInputService", SetsKt.setOf((Object[]) new String[]{"GetMouseLocation", "IsKeyDown", "GetFocusedTextBox", "IsMouseButtonPressed", "GetKeysPressed", "GetLastInputType", "GetConnectedGamepads"})), TuplesKt.to("ContextActionService", SetsKt.setOf((Object[]) new String[]{"BindAction", "UnbindAction", "BindActionAtPriority", "SetTitle", "SetImage", "SetPosition", "SetDescription", "GetButton", "UnbindAllActions"})), TuplesKt.to("StarterGui", SetsKt.setOf((Object[]) new String[]{"SetCore", "GetCore", "SetCoreGuiEnabled", "GetCoreGuiEnabled"})), TuplesKt.to("BindableEvent", SetsKt.setOf("Fire")), TuplesKt.to("BindableFunction", SetsKt.setOf("Invoke")), TuplesKt.to("RemoteEvent", SetsKt.setOf((Object[]) new String[]{"FireServer", "FireClient", "FireAllClients"})), TuplesKt.to("UnreliableRemoteEvent", SetsKt.setOf((Object[]) new String[]{"FireServer", "FireClient", "FireAllClients"})), TuplesKt.to("RemoteFunction", SetsKt.setOf((Object[]) new String[]{"InvokeServer", "InvokeClient"})), TuplesKt.to("Sound", SetsKt.setOf((Object[]) new String[]{"Play", "Stop", "Pause", "Resume"})), TuplesKt.to("GuiObject", SetsKt.setOf((Object[]) new String[]{"TweenPosition", "TweenSize", "TweenSizeAndPosition"})), TuplesKt.to("TextBox", SetsKt.setOf((Object[]) new String[]{"CaptureFocus", "ReleaseFocus", "IsFocused"})), TuplesKt.to("TextService", SetsKt.setOf((Object[]) new String[]{"GetTextSize", "FilterStringAsync"})), TuplesKt.to("Plugin", SetsKt.setOf((Object[]) new String[]{"CreateToolbar", "GetSetting", "SetSetting", "CreateDockWidgetPluginGui", "CreateDockWidgetPluginGuiAsync", "CreateQWidgetPluginGui", "OpenScript", "GetMouse", "Activate", "Deactivate", "IsActivated", "IsActivatedWithExclusiveMouse", "GetStudioUserId", "CreatePluginAction", "CreatePluginMenu", "SelectRibbonTool", "GetSelectedRibbonTool", "Union", "Negate", "Separate", "Intersect", "StartDrag", "OpenWikiPage", "SaveSelectedToRoblox", "GetJoinMode", "PromptForExistingAssetId", "ImportFbxRig", "GetItem", "SetItem", "GetGridSize", "IsLoaded", "PromptSaveSelection"})), TuplesKt.to("PluginGui", SetsKt.setOf((Object[]) new String[]{"BindToClose", "GetRelativeMousePosition"})), TuplesKt.to("PluginToolbar", SetsKt.setOf("CreateButton")), TuplesKt.to("PluginToolbarButton", SetsKt.setOf("SetActive")), TuplesKt.to("ParticleEmitter", SetsKt.setOf((Object[]) new String[]{"Emit", "Clear"})), TuplesKt.to("Camera", SetsKt.setOf((Object[]) new String[]{"WorldToScreenPoint", "WorldToViewportPoint", "ScreenPointToRay", "ViewportPointToRay", "GetPartsObscuringTarget"})), TuplesKt.to("Lighting", SetsKt.setOf((Object[]) new String[]{"GetMinutesAfterMidnight", "SetMinutesAfterMidnight", "GetSunDirection", "GetMoonDirection"})), TuplesKt.to("SoundService", SetsKt.setOf("PlayLocalSound")), TuplesKt.to("PathfindingService", SetsKt.setOf((Object[]) new String[]{"CreatePath", "FindPathAsync"})), TuplesKt.to("BadgeService", SetsKt.setOf((Object[]) new String[]{"AwardBadge", "UserHasBadgeAsync", "GetBadgeInfoAsync"})), TuplesKt.to("TeleportService", SetsKt.setOf((Object[]) new String[]{"Teleport", "TeleportAsync", "TeleportToPlaceInstance"})), TuplesKt.to("InsertService", SetsKt.setOf("LoadAsset")), TuplesKt.to("Teams", SetsKt.setOf("GetTeams")), TuplesKt.to("Team", SetsKt.setOf("GetPlayers")), TuplesKt.to("PhysicsService", SetsKt.setOf((Object[]) new String[]{"RegisterCollisionGroup", "CollisionGroupSetCollidable", "SetPartCollisionGroup", "CreateCollisionGroup", "CollisionGroupsAreCollidable", "GetRegisteredCollisionGroups"})), TuplesKt.to("Tool", SetsKt.setOf((Object[]) new String[]{"Activate", "Deactivate"})), TuplesKt.to("ProximityPrompt", SetsKt.setOf((Object[]) new String[]{"InputHoldBegin", "InputHoldEnd"})), TuplesKt.to("PlayerGui", SetsKt.setOf((Object[]) new String[]{"SetTopbarTransparency", "GetGuiObjectsAtPosition"})), TuplesKt.to("MessagingService", SetsKt.setOf((Object[]) new String[]{"PublishAsync", "SubscribeAsync"})), TuplesKt.to("Chat", SetsKt.setOf((Object[]) new String[]{"Chat", "FilterStringForBroadcast"})), TuplesKt.to("TextChannel", SetsKt.setOf((Object[]) new String[]{"SendAsync", "DisplaySystemMessage"})), TuplesKt.to("GuiService", SetsKt.setOf((Object[]) new String[]{"GetGuiInset", "IsTenFootInterface"})), TuplesKt.to("LocalizationService", SetsKt.setOf((Object[]) new String[]{"GetTranslatorForPlayerAsync", "GetCountryRegionForPlayerAsync"})), TuplesKt.to("PolicyService", SetsKt.setOf("GetPolicyInfoForPlayerAsync")), TuplesKt.to("StudioService", SetsKt.setOf((Object[]) new String[]{"GetUserId", "PromptImportFile"})), TuplesKt.to("RbxAnalyticsService", SetsKt.setOf((Object[]) new String[]{"GetSessionId", "GetClientId", "GetPlaySessionId", "ReportStats", "SendEventDeferred", "SendEventImmediately", "ReportCounter", "ReportInfluxSeries", "TrackEvent", "FireLogEvent", "SetRBXEvent"})), TuplesKt.to("DataModel", SetsKt.setOf((Object[]) new String[]{"BindToClose", "IsLoaded", "GetJobsInfo", "SetPlaceId", "GetObjects"})));
        this.events = SetsKt.setOf((Object[]) new String[]{"Touched", "TouchEnded", "ChildAdded", "ChildRemoved", "DescendantAdded", "DescendantRemoving", "Changed", "AncestryChanged", "Destroying", "AttributeChanged", "Heartbeat", "RenderStepped", "Stepped", "PreSimulation", "PostSimulation", "PreRender", "PlayerAdded", "PlayerRemoving", "CharacterAdded", "CharacterRemoving", "CharacterAppearanceLoaded", "Died", "HealthChanged", "Running", "Jumping", "StateChanged", "MoveToFinished", "FreeFalling", "Seated", "MouseButton1Click", "MouseButton1Down", "MouseButton1Up", "MouseButton2Click", "Activated", "MouseEnter", "MouseLeave", "FocusLost", "Focused", "Event", "OnServerEvent", "OnClientEvent", "MouseClick", "RightMouseClick", "MouseHoverEnter", "MouseHoverLeave", "Triggered", "TriggerEnded", "PromptShown", "PromptHidden", "PromptTriggered", "Completed", "Click", "SelectionChanged", "InputBegan", "InputEnded", "InputChanged", "TouchTapInWorld", "TouchTap", "TouchStarted", "TouchEnded", "TouchMoved", "Equipped", "Unequipped", "Deactivated", "Played", "Ended", "Paused", "Resumed", "Loaded", "Chatted", "Idled", "Button1Down", "Button1Up", "Move", "Blocked", "PromptPurchaseFinished", "PromptGamePassPurchaseFinished", "ServerScriptServiceChanged", "WindowFocused", "WindowFocusReleased", "Unloading", "Close", "BindToClose", "Deactivation", "ChildAddedToCharacter", "ReturnPressedFromOnScreenKeyboard", "TextChanged", "MessageReceived", "OnIncomingMessage", "LastInputTypeChanged", "JumpRequest", "MouseDrag", "Unloading", "Deactivation", "Loaded", "PromptProductPurchaseFinished", "PromptPurchaseFinished", "PromptGamePassPurchaseFinished", "PromptBundlePurchaseFinished", "Loaded", "GraphicsQualityChangeRequest", "OnTeleport", "ChildRemoving", "ClockTimeChanged", "PlaybackStateChanged", "DidLoop", "Stopped", "KeyframeReached", "OnUndo", "OnRedo", "OnRecordingStarted", "OnRecordingFinished", "WaypointSet", "Activated", "PromptDismissed", "DragBegin", "DragContinue", "DragEnd", "MouseButton2Down", "MouseButton2Up", "MouseWheelForward", "MouseWheelBackward", "WheelBackward", "WheelForward", "Button2Down", "Button2Up", "KeyDown", "KeyUp", "SelectionGained", "SelectionLost"});
        this.sequenceClasses = SetsKt.setOf((Object[]) new String[]{"UIGradient", "ParticleEmitter", "Beam", "Trail"});
        this.universalEvents = SetsKt.setOf((Object[]) new String[]{"ChildAdded", "ChildRemoved", "DescendantAdded", "DescendantRemoving", "Changed", "AncestryChanged", "Destroying", "AttributeChanged"});
        LuaTable instanceMeta = this.rt.getInstanceMeta();
        instanceMeta.set("__type", "Instance");
        instanceMeta.set(LuaValue.INDEX, LuaTypesKt.fn2(new InstanceApi$$ExternalSyntheticLambda15(this)));
        instanceMeta.set(LuaValue.NEWINDEX, new AnonymousClass2());
        instanceMeta.set(LuaValue.TOSTRING, LuaTypesKt.fn1(new InstanceApi$$ExternalSyntheticLambda16()));
        this.signalMeta.set("__type", "RBXScriptSignal");
        this.signalMeta.set(LuaValue.INDEX, LuaTypesKt.fn2(new InstanceApi$$ExternalSyntheticLambda17(this)));
        this.signalMeta.set(LuaValue.TOSTRING, LuaTypesKt.fn1(new InstanceApi$$ExternalSyntheticLambda18()));
        this.connMeta.set("__type", "RBXScriptConnection");
        this.connMeta.set(LuaValue.INDEX, LuaTypesKt.fn2(new InstanceApi$$ExternalSyntheticLambda19(this)));
        this.CONSTRAINT_READOUTS = SetsKt.setOf((Object[]) new String[]{"CurrentPosition", "CurrentAngle", "CurrentDistance", "CurrentLength"});
        this.BASE_PROPS = SetsKt.setOf((Object[]) new String[]{"Name", "ClassName", "Parent", "Archivable"});
        this.PART_PROPS = SetsKt.setOf((Object[]) new String[]{"Position", "Orientation", "Rotation", "Size", "Color", "BrickColor", "CFrame", "AssemblyLinearVelocity", "Velocity", "AssemblyAngularVelocity", "RotVelocity", "Mass", "AssemblyMass", "PivotOffset", "AssemblyRootPart", "Anchored", "CanCollide", "Transparency", "Material", "Shape", "CanTouch", "CanQuery", "Locked", "Massless", "Reflectance", "CastShadow"});
        this.SPECIAL_PROPS = MapsKt.mapOf(TuplesKt.to("DataModel", SetsKt.setOf((Object[]) new String[]{"PlaceId", "GameId", "CreatorId", "CreatorType", "PlaceVersion", "JobId", "PrivateServerId", "PrivateServerOwnerId"})), TuplesKt.to("ImageLabel", SetsKt.setOf("IsLoaded")), TuplesKt.to("ImageButton", SetsKt.setOf("IsLoaded")), TuplesKt.to("StudioService", SetsKt.setOf((Object[]) new String[]{"GridSize", "RotateIncrement", "UseLocalSpace", "DraggerSolveConstraints", "ShowConstraintDetails", "ActiveScript", "StudioLocaleId", "Theme"})), TuplesKt.to("DraggerService", SetsKt.setOf((Object[]) new String[]{"HoverThickness", "AlignDraggedObjects", "ShowHover", "AnimateHover", "PivotSnapToGeometry", "ShowPivotIndicator", "JointsEnabled", "CollisionsEnabled", "AngleSnapEnabled", "AngleSnapIncrement", "LinearSnapEnabled", "LinearSnapIncrement", "HoverAnimateFrequency", "GeometrySnapColor"})), TuplesKt.to("Players", SetsKt.setOf((Object[]) new String[]{"LocalPlayer", "MaxPlayers"})), TuplesKt.to("Humanoid", SetsKt.setOf((Object[]) new String[]{"Health", "RootPart", "MoveDirection", "FloorMaterial", "Jump", "SeatPart", "Sit", "PlatformStand", "AutoRotate", "UseJumpPower", "JumpHeight", "RigType"})), TuplesKt.to("Workspace", SetsKt.setOf((Object[]) new String[]{"DistributedGameTime", "CurrentCamera", "Gravity", "StreamingEnabled"})), TuplesKt.to("Camera", SetsKt.setOf((Object[]) new String[]{"ViewportSize", "CFrame", "Focus", "CameraSubject", "CameraType", "FieldOfView"})), TuplesKt.to("Lighting", SetsKt.setOf((Object[]) new String[]{"TimeOfDay", "ClockTime", "Brightness", "Ambient", "OutdoorAmbient", "FogEnd", "FogStart", "FogColor", "GlobalShadows"})), TuplesKt.to("UserInputService", SetsKt.setOf((Object[]) new String[]{"TouchEnabled", "KeyboardEnabled", "MouseEnabled", "GamepadEnabled", "VREnabled", "MouseBehavior", "MouseIconEnabled", "AccelerometerEnabled", "GyroscopeEnabled", "ModalEnabled"})), TuplesKt.to("HttpService", SetsKt.setOf("HttpEnabled")), TuplesKt.to("RunService", SetsKt.setOf("ClientGitHash")), TuplesKt.to("Player", SetsKt.setOf((Object[]) new String[]{"PlayerGui", "Backpack", "Character", "UserId", "DisplayName", "Team", "TeamColor", "Neutral", "AccountAge", "MembershipType", "RespawnLocation", "CameraMode", "CameraMaxZoomDistance", "CameraMinZoomDistance", "DevTouchMovementMode"})), TuplesKt.to("TextBox", SetsKt.setOf((Object[]) new String[]{"TextBounds", "ContentText", "TextFits"})), TuplesKt.to("TextLabel", SetsKt.setOf((Object[]) new String[]{"TextBounds", "ContentText", "TextFits"})), TuplesKt.to("TextButton", SetsKt.setOf((Object[]) new String[]{"TextBounds", "ContentText", "TextFits"})), TuplesKt.to("StarterGui", SetsKt.setOf((Object[]) new String[]{"ShowDevelopmentGui", "ResetPlayerGuiOnSpawn"})), TuplesKt.to("Sound", SetsKt.setOf((Object[]) new String[]{"TimePosition", "TimeLength", "IsPlaying", "IsLoaded", "PlaybackSpeed", "PlaybackLoudness"})));
        HashMap hashMap = new HashMap();
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"TextLabel", "TextButton", "TextBox", "Message", "Hint"});
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"Text", "TextScaled", "TextSize", "TextBounds", "TextColor3", "TextWrapped", "TextXAlignment", "TextYAlignment", "Font", "FontFace", "TextTransparency", "TextStrokeTransparency", "TextStrokeColor3", "RichText", "LineHeight", "MaxVisibleGraphemes", "TextFits", "ContentText", "TextTruncate", "TextDirection", "TextWrap"}).iterator();
        while (it.hasNext()) {
            hashMap.put((String) it.next(), listOf);
            c2 = c2;
        }
        char c3 = c2;
        Iterator it2 = CollectionsKt.listOf((Object[]) new String[]{"PlaceholderText", "PlaceholderColor3", "ClearTextOnFocus", "MultiLine", "CursorPosition", "SelectionStart", "TextEditable", "ShowNativeInput"}).iterator();
        while (it2.hasNext()) {
            hashMap.put((String) it2.next(), CollectionsKt.listOf("TextBox"));
            c = c;
        }
        char c4 = c;
        String[] strArr = new String[7];
        strArr[0] = "ScaleType";
        strArr[1] = "SliceCenter";
        strArr[2] = "SliceScale";
        strArr[3] = "ImageRectOffset";
        strArr[4] = "ImageRectSize";
        strArr[5] = "TileSize";
        strArr[c4] = "ResampleMode";
        Iterator it3 = CollectionsKt.listOf((Object[]) strArr).iterator();
        while (it3.hasNext()) {
            hashMap.put((String) it3.next(), CollectionsKt.listOf((Object[]) new String[]{"ImageLabel", "ImageButton"}));
        }
        hashMap.put("Image", CollectionsKt.listOf((Object[]) new String[]{"ImageLabel", "ImageButton", "ImageHandleAdornment"}));
        Iterator it4 = CollectionsKt.listOf((Object[]) new String[]{"ImageColor3", "ImageTransparency"}).iterator();
        while (it4.hasNext()) {
            hashMap.put((String) it4.next(), CollectionsKt.listOf((Object[]) new String[]{"ImageLabel", "ImageButton", "ViewportFrame"}));
        }
        String[] strArr2 = new String[12];
        strArr2[0] = "BackgroundColor3";
        strArr2[1] = "BackgroundTransparency";
        strArr2[2] = "BorderColor3";
        strArr2[3] = "BorderSizePixel";
        strArr2[4] = "BorderMode";
        strArr2[5] = "AnchorPoint";
        strArr2[c4] = "AutomaticSize";
        strArr2[7] = "ClipsDescendants";
        strArr2[8] = "LayoutOrder";
        strArr2[9] = "SizeConstraint";
        strArr2[10] = "Selectable";
        strArr2[11] = "Interactable";
        Iterator it5 = CollectionsKt.listOf((Object[]) strArr2).iterator();
        while (it5.hasNext()) {
            hashMap.put((String) it5.next(), CollectionsKt.listOf("GuiObject"));
        }
        Iterator it6 = CollectionsKt.listOf((Object[]) new String[]{"AutoButtonColor", "Modal", "Selected"}).iterator();
        while (it6.hasNext()) {
            hashMap.put((String) it6.next(), CollectionsKt.listOf("GuiButton"));
        }
        String[] strArr3 = new String[24];
        strArr3[0] = "Anchored";
        strArr3[1] = "CanCollide";
        strArr3[2] = "CanTouch";
        strArr3[3] = "CanQuery";
        strArr3[4] = "CastShadow";
        strArr3[5] = "Massless";
        strArr3[c4] = "Reflectance";
        strArr3[7] = "Material";
        strArr3[8] = "MaterialVariant";
        strArr3[9] = "AssemblyLinearVelocity";
        strArr3[10] = "AssemblyAngularVelocity";
        strArr3[11] = "AssemblyMass";
        strArr3[12] = "AssemblyRootPart";
        strArr3[13] = "CollisionGroup";
        strArr3[14] = "CustomPhysicalProperties";
        strArr3[15] = "TopSurface";
        strArr3[16] = "BottomSurface";
        strArr3[17] = "FrontSurface";
        strArr3[18] = "BackSurface";
        strArr3[19] = "LeftSurface";
        strArr3[20] = "RightSurface";
        strArr3[c3] = "BrickColor";
        strArr3[22] = "Locked";
        strArr3[23] = "RootPriority";
        Iterator it7 = CollectionsKt.listOf((Object[]) strArr3).iterator();
        while (it7.hasNext()) {
            hashMap.put((String) it7.next(), CollectionsKt.listOf("BasePart"));
        }
        hashMap.put("Value", CollectionsKt.listOf((Object[]) new String[]{"ValueBase", "IntConstrainedValue", "DoubleConstrainedValue"}));
        hashMap.put("PrimaryPart", CollectionsKt.listOf("Model"));
        hashMap.put("WorldPivot", CollectionsKt.listOf("PVInstance"));
        hashMap.put("Source", CollectionsKt.listOf("LuaSourceContainer"));
        hashMap.put("Disabled", CollectionsKt.listOf("BaseScript"));
        Iterator it8 = CollectionsKt.listOf((Object[]) new String[]{"SoundId", "IsPaused", "RollOffMode", "SoundGroup"}).iterator();
        while (it8.hasNext()) {
            hashMap.put((String) it8.next(), CollectionsKt.listOf("Sound"));
        }
        hashMap.put("Volume", CollectionsKt.listOf((Object[]) new String[]{"Sound", "SoundGroup", "AudioPlayer", "AudioFader", "VideoFrame"}));
        Iterator it9 = CollectionsKt.listOf((Object[]) new String[]{"TimePosition", "TimeLength", "IsPlaying"}).iterator();
        while (it9.hasNext()) {
            hashMap.put((String) it9.next(), CollectionsKt.listOf((Object[]) new String[]{"Sound", "AudioPlayer", "VideoFrame"}));
        }
        hashMap.put("Looped", CollectionsKt.listOf((Object[]) new String[]{"Sound", "VideoFrame"}));
        hashMap.put("PlaybackSpeed", CollectionsKt.listOf((Object[]) new String[]{"Sound", "AudioPlayer"}));
        String[] strArr4 = new String[8];
        strArr4[0] = "WalkSpeed";
        strArr4[1] = "JumpPower";
        strArr4[2] = "JumpHeight";
        strArr4[3] = "Health";
        strArr4[4] = "MaxHealth";
        strArr4[5] = "HipHeight";
        strArr4[c4] = "RigType";
        strArr4[7] = "UseJumpPower";
        Iterator it10 = CollectionsKt.listOf((Object[]) strArr4).iterator();
        while (it10.hasNext()) {
            hashMap.put((String) it10.next(), CollectionsKt.listOf("Humanoid"));
        }
        hashMap.put("DisplayName", CollectionsKt.listOf((Object[]) new String[]{"Humanoid", "Player"}));
        this.MEMBER_OWNERS = hashMap;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("Idle", 0);
        pairArr[1] = TuplesKt.to("Movement", 1);
        pairArr[2] = TuplesKt.to("Action", 2);
        pairArr[3] = TuplesKt.to("Action2", 3);
        pairArr[4] = TuplesKt.to("Action3", 4);
        pairArr[5] = TuplesKt.to("Action4", 5);
        pairArr[c4] = TuplesKt.to("Core", 1000);
        this.PRIORITIES = CollectionsKt.listOf((Object[]) pairArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$0(InstanceApi instanceApi, LuaValue self, LuaValue key) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = self.touserdata();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.Instance");
        String str = key.tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        return instanceApi.index((Instance) obj, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$1(LuaValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = it.touserdata();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.Instance");
        LuaString valueOf = LuaValue.valueOf(((Instance) obj).getName());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        if (r1.equals("wait") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(new com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda13(r4, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if (r1.equals("Wait") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (r1.equals("ConnectParallel") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        if (r1.equals("Connect") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0029, code lost:
    
        if (r1.equals("connect") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0079, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(new com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda11(r4, r0));
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001f. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue _init_$lambda$5(com.exampletest.mobilestudiotest.lua.InstanceApi r4, org.luaj.vm2.LuaValue r5, org.luaj.vm2.LuaValue r6) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object r0 = r5.touserdata()
            java.lang.String r1 = "null cannot be cast to non-null type com.exampletest.mobilestudiotest.lua.SignalRef"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            com.exampletest.mobilestudiotest.lua.SignalRef r0 = (com.exampletest.mobilestudiotest.lua.SignalRef) r0
            java.lang.String r1 = r6.tojstring()
            if (r1 == 0) goto L7a
            int r2 = r1.hashCode()
            switch(r2) {
                case -1678962486: goto L66;
                case -309774095: goto L5d;
                case 2462369: goto L49;
                case 2688405: goto L35;
                case 3641717: goto L2c;
                case 951351530: goto L23;
                default: goto L22;
            }
        L22:
            goto L7a
        L23:
            java.lang.String r2 = "connect"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L7a
            goto L6e
        L2c:
            java.lang.String r2 = "wait"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L7a
            goto L3d
        L35:
            java.lang.String r2 = "Wait"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L7a
        L3d:
            com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda13 r1 = new com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda13
            r1.<init>(r4, r0)
            org.luaj.vm2.lib.VarArgFunction r1 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(r1)
            org.luaj.vm2.LuaValue r1 = (org.luaj.vm2.LuaValue) r1
            goto L79
        L49:
            java.lang.String r2 = "Once"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L7a
            com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda12 r1 = new com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda12
            r1.<init>(r4, r0)
            org.luaj.vm2.lib.VarArgFunction r1 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(r1)
            org.luaj.vm2.LuaValue r1 = (org.luaj.vm2.LuaValue) r1
            goto L79
        L5d:
            java.lang.String r2 = "ConnectParallel"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L7a
            goto L6e
        L66:
            java.lang.String r2 = "Connect"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L7a
        L6e:
            com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda11 r1 = new com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda11
            r1.<init>(r4, r0)
            org.luaj.vm2.lib.VarArgFunction r1 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(r1)
            org.luaj.vm2.LuaValue r1 = (org.luaj.vm2.LuaValue) r1
        L79:
            return r1
        L7a:
            org.luaj.vm2.LuaError r1 = new org.luaj.vm2.LuaError
            java.lang.String r2 = r6.tojstring()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r3 = " is not a valid member of RBXScriptSignal"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi._init_$lambda$5(com.exampletest.mobilestudiotest.lua.InstanceApi, org.luaj.vm2.LuaValue, org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$6(LuaValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = it.touserdata();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.lua.SignalRef");
        LuaString valueOf = LuaValue.valueOf("Signal " + ((SignalRef) obj).getName());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
    
        if (r1.equals("disconnect") == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if (r1.equals("Disconnect") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue _init_$lambda$8(com.exampletest.mobilestudiotest.lua.InstanceApi r3, org.luaj.vm2.LuaValue r4, org.luaj.vm2.LuaValue r5) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.Object r0 = r4.touserdata()
            java.lang.String r1 = "null cannot be cast to non-null type com.exampletest.mobilestudiotest.lua.Connection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            com.exampletest.mobilestudiotest.lua.Connection r0 = (com.exampletest.mobilestudiotest.lua.Connection) r0
            java.lang.String r1 = r5.tojstring()
            if (r1 == 0) goto L58
            int r2 = r1.hashCode()
            switch(r2) {
                case -1771096900: goto L44;
                case 530405532: goto L3b;
                case 1424757481: goto L23;
                default: goto L22;
            }
        L22:
            goto L58
        L23:
            java.lang.String r2 = "Connected"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L58
            boolean r1 = r0.getConnected()
            org.luaj.vm2.LuaBoolean r1 = org.luaj.vm2.LuaValue.valueOf(r1)
            java.lang.String r2 = "valueOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            org.luaj.vm2.LuaValue r1 = (org.luaj.vm2.LuaValue) r1
            goto L5f
        L3b:
            java.lang.String r2 = "disconnect"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4c
            goto L58
        L44:
            java.lang.String r2 = "Disconnect"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L58
        L4c:
            com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda2 r1 = new com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda2
            r1.<init>(r3, r0)
            org.luaj.vm2.lib.VarArgFunction r1 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(r1)
            org.luaj.vm2.LuaValue r1 = (org.luaj.vm2.LuaValue) r1
            goto L5f
        L58:
            org.luaj.vm2.LuaValue r1 = org.luaj.vm2.LuaValue.NIL
            java.lang.String r2 = "NIL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi._init_$lambda$8(com.exampletest.mobilestudiotest.lua.InstanceApi, org.luaj.vm2.LuaValue, org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
    }

    private final LuaTable animationTrack(Instance owner, Instance anim) {
        LuaTable luaTable = new LuaTable();
        PlaySession play = this.rt.getPlay();
        PlaySession.ScriptTrack loadTrack = play != null ? play.loadTrack(owner, anim, luaTable) : null;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 1.0f;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        luaTable.set("Play", LuaTypesKt.fnv(new InstanceApi$$ExternalSyntheticLambda3(floatRef, loadTrack, play, booleanRef)));
        luaTable.set("Stop", LuaTypesKt.fnv(new InstanceApi$$ExternalSyntheticLambda4(loadTrack, play, booleanRef, this, luaTable)));
        luaTable.set("AdjustSpeed", LuaTypesKt.fnv(new InstanceApi$$ExternalSyntheticLambda5(floatRef, loadTrack, play)));
        luaTable.set("AdjustWeight", LuaTypesKt.fnv(new InstanceApi$$ExternalSyntheticLambda6(loadTrack, play)));
        luaTable.set("GetMarkerReachedSignal", LuaTypesKt.fnv(new InstanceApi$$ExternalSyntheticLambda7(this, luaTable)));
        luaTable.set("GetTimeOfKeyframe", LuaTypesKt.fnv(new InstanceApi$$ExternalSyntheticLambda8()));
        luaTable.set("Destroy", LuaTypesKt.fnv(new InstanceApi$$ExternalSyntheticLambda9(loadTrack, play)));
        luaTable.set("Animation", this.rt.wrap(anim));
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set(LuaValue.INDEX, LuaTypesKt.fn2(new InstanceApi$$ExternalSyntheticLambda10(loadTrack, booleanRef, floatRef, objectRef, this, objectRef2, anim, luaTable)));
        luaTable2.set(LuaValue.NEWINDEX, new InstanceApi$animationTrack$9(objectRef, loadTrack, objectRef2, play));
        luaTable.setmetatable(luaTable2);
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs animationTrack$lambda$30(Ref.FloatRef floatRef, PlaySession.ScriptTrack scriptTrack, PlaySession playSession, Ref.BooleanRef booleanRef, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        float optdouble = (float) a.arg(2).optdouble(0.1d);
        float optdouble2 = (float) a.arg(3).optdouble(1.0d);
        float optdouble3 = (float) a.arg(4).optdouble(floatRef.element);
        floatRef.element = optdouble3;
        if (scriptTrack == null) {
            booleanRef.element = true;
        } else if (playSession != null) {
            playSession.playTrack(scriptTrack, optdouble, optdouble2, optdouble3);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs animationTrack$lambda$31(PlaySession.ScriptTrack scriptTrack, PlaySession playSession, Ref.BooleanRef booleanRef, InstanceApi instanceApi, LuaTable luaTable, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        float optdouble = (float) a.arg(2).optdouble(0.1d);
        if (scriptTrack != null) {
            if (playSession != null) {
                playSession.stopTrack(scriptTrack, optdouble);
            }
        } else if (booleanRef.element) {
            booleanRef.element = false;
            instanceApi.rt.fire(luaTable, "Stopped", new LuaValue[0]);
            instanceApi.rt.fire(luaTable, "Ended", new LuaValue[0]);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs animationTrack$lambda$33(Ref.FloatRef floatRef, PlaySession.ScriptTrack scriptTrack, PlaySession playSession, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        floatRef.element = (float) a.arg(2).optdouble(1.0d);
        if (scriptTrack != null && playSession != null) {
            PlaySession.adjustTrack$default(playSession, scriptTrack, Float.valueOf(floatRef.element), null, null, null, null, null, 124, null);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs animationTrack$lambda$35(PlaySession.ScriptTrack scriptTrack, PlaySession playSession, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        if (scriptTrack != null && playSession != null) {
            PlaySession.adjustTrack$default(playSession, scriptTrack, null, Float.valueOf((float) a.arg(2).optdouble(1.0d)), Float.valueOf((float) a.arg(3).optdouble(0.1d)), null, null, null, 114, null);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs animationTrack$lambda$36(InstanceApi instanceApi, LuaTable luaTable, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return instanceApi.signal(luaTable, "Marker:" + a.arg(2).tojstring());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs animationTrack$lambda$37(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaInteger valueOf = LuaValue.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs animationTrack$lambda$39(PlaySession.ScriptTrack scriptTrack, PlaySession playSession, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        if (scriptTrack != null && playSession != null) {
            playSession.stopTrack(scriptTrack, 0.0f);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
    
        if (r12.equals("Ended") == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d8, code lost:
    
        if (r12.equals("Stopped") == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e2, code lost:
    
        if (r12.equals("KeyframeReached") == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ec, code lost:
    
        if (r12.equals("DidLoop") == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011e, code lost:
    
        if (r12.equals("Played") != false) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue animationTrack$lambda$40(com.exampletest.mobilestudiotest.engine.PlaySession.ScriptTrack r4, kotlin.jvm.internal.Ref.BooleanRef r5, kotlin.jvm.internal.Ref.FloatRef r6, kotlin.jvm.internal.Ref.ObjectRef r7, com.exampletest.mobilestudiotest.lua.InstanceApi r8, kotlin.jvm.internal.Ref.ObjectRef r9, com.exampletest.mobilestudiotest.model.Instance r10, org.luaj.vm2.LuaTable r11, org.luaj.vm2.LuaValue r12, org.luaj.vm2.LuaValue r13) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.animationTrack$lambda$40(com.exampletest.mobilestudiotest.engine.PlaySession$ScriptTrack, kotlin.jvm.internal.Ref$BooleanRef, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$ObjectRef, com.exampletest.mobilestudiotest.lua.InstanceApi, kotlin.jvm.internal.Ref$ObjectRef, com.exampletest.mobilestudiotest.model.Instance, org.luaj.vm2.LuaTable, org.luaj.vm2.LuaValue, org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
    }

    private final LuaValue connectionValue(Connection c) {
        return new LuaUserdata(c, this.connMeta);
    }

    private final String contentAlias(Instance inst, String key) {
        if (inst.getProps().containsKey(key)) {
            return null;
        }
        switch (key.hashCode()) {
            case -1926308098:
                if (!key.equals("TextureContent")) {
                    return null;
                }
                if (Intrinsics.areEqual(inst.getClassName(), "MeshPart")) {
                    return "TextureID";
                }
                if (inst.isA("Decal")) {
                    return "Texture";
                }
                return null;
            case -1813296724:
                if (key.equals("MeshContent")) {
                    return "MeshId";
                }
                return null;
            case 1147523044:
                if (key.equals("NormalMapContent")) {
                    return "NormalMap";
                }
                return null;
            case 1714113214:
                if (key.equals("ImageContent")) {
                    return "Image";
                }
                return null;
            case 1832176416:
                if (key.equals("ColorMapContent")) {
                    return "ColorMap";
                }
                return null;
            default:
                return null;
        }
    }

    private final Function1<Instance, Boolean> filterFrom(LuaValue params) {
        if (!params.istable()) {
            return new InstanceApi$$ExternalSyntheticLambda0();
        }
        LuaValue luaValue = params.get("FilterDescendantsInstances");
        Intrinsics.checkNotNullExpressionValue(luaValue, "get(...)");
        List<Instance> instList = instList(luaValue);
        LuaValue luaValue2 = params.get("FilterType");
        Intrinsics.checkNotNullExpressionValue(luaValue2, "get(...)");
        Object obj = luaValue2.isuserdata() ? luaValue2.touserdata() : null;
        EnumItemV enumItemV = (EnumItemV) (obj instanceof EnumItemV ? obj : null);
        boolean z = false;
        if (enumItemV != null && enumItemV.getValue() == 1) {
            z = true;
        }
        return new InstanceApi$$ExternalSyntheticLambda1(instList, z, params.get("RespectCanCollide").toboolean());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean filterFrom$lambda$25(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !Intrinsics.areEqual(it.get("CanQuery"), (Object) false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean filterFrom$lambda$27(List list, boolean z, boolean z2, Instance p) {
        boolean z3;
        Intrinsics.checkNotNullParameter(p, "p");
        List list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                Instance instance = (Instance) it.next();
                if (p == instance || p.isDescendantOf(instance)) {
                    z3 = true;
                    break;
                }
            }
        } else {
            z3 = false;
        }
        return (!(z ? z3 : !z3) || Intrinsics.areEqual(p.get("CanQuery"), (Object) false) || (z2 && Intrinsics.areEqual(p.get("CanCollide"), (Object) false))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs index$lambda$12$lambda$11(InstanceApi instanceApi, String str, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return instanceApi.callMethod(str, a);
    }

    private final List<Instance> instList(LuaValue v) {
        if (!v.istable()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int length = v.length();
        if (1 <= length) {
            while (true) {
                LuaValue luaValue = v.get(i);
                Intrinsics.checkNotNullExpressionValue(luaValue, "get(...)");
                Object obj = luaValue.isuserdata() ? luaValue.touserdata() : null;
                Instance instance = (Instance) (obj instanceof Instance ? obj : null);
                if (instance != null) {
                    arrayList.add(instance);
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private final boolean isEditCamera(Instance cam) {
        Instance workspace = this.rt.getStudio().getEditModel().getWorkspace();
        return cam.getParent() == workspace && (workspace.get("CurrentCamera") == cam || workspace.get("CurrentCamera") == null);
    }

    private final boolean isPart(Instance i) {
        return i.isA("BasePart");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$5$lambda$2(InstanceApi instanceApi, SignalRef signalRef, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaRuntime luaRuntime = instanceApi.rt;
        Object owner = signalRef.getOwner();
        String name = signalRef.getName();
        LuaFunction checkfunction = a.arg(2).checkfunction();
        Intrinsics.checkNotNullExpressionValue(checkfunction, "checkfunction(...)");
        return instanceApi.connectionValue(luaRuntime.connect(owner, name, checkfunction, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$5$lambda$3(InstanceApi instanceApi, SignalRef signalRef, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaRuntime luaRuntime = instanceApi.rt;
        Object owner = signalRef.getOwner();
        String name = signalRef.getName();
        LuaFunction checkfunction = a.arg(2).checkfunction();
        Intrinsics.checkNotNullExpressionValue(checkfunction, "checkfunction(...)");
        return instanceApi.connectionValue(luaRuntime.connect(owner, name, checkfunction, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$5$lambda$4(InstanceApi instanceApi, SignalRef signalRef, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        return instanceApi.rt.waitSignal(signalRef.getOwner(), signalRef.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$8$lambda$7(InstanceApi instanceApi, Connection connection, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        instanceApi.rt.disconnect(connection);
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    private final LuaTable listToLua(List<? extends Instance> l) {
        LuaTable luaTable = new LuaTable();
        Iterator<? extends Instance> it = l.iterator();
        while (it.hasNext()) {
            luaTable.insert(0, this.rt.wrap(it.next()));
        }
        return luaTable;
    }

    private final boolean methodAllowed(Instance inst, String name) {
        if (this.commonMethods.contains(name)) {
            return true;
        }
        for (Map.Entry<String, Set<String>> entry : this.classMethods.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().contains(name) && inst.isA(key)) {
                return true;
            }
        }
        return false;
    }

    private final EnumItemV priorityItem(int v) {
        Object obj;
        String str;
        Iterator<T> it = this.PRIORITIES.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Number) ((Pair) obj).getSecond()).intValue() == v) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair == null || (str = (String) pair.getFirst()) == null) {
            str = "Core";
        }
        return new EnumItemV("AnimationPriority", str, v);
    }

    private final LuaValue raycastResult(Vector3 o, Vector3 d, Function1<? super Instance, Boolean> filter) {
        float magnitude = d.getMagnitude();
        if (magnitude < 1.0E-6f) {
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            return NIL;
        }
        RayHit raycast = Geometry.INSTANCE.raycast(workspaceParts(), o, d.div(magnitude), magnitude, filter);
        if (raycast == null) {
            LuaValue NIL2 = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL2, "NIL");
            return NIL2;
        }
        LuaTable luaTable = new LuaTable();
        luaTable.set("Instance", this.rt.wrap(raycast.getPart()));
        luaTable.set("Position", LuaTypes.INSTANCE.wrap(raycast.getPosition()));
        luaTable.set("Normal", LuaTypes.INSTANCE.wrap(raycast.getNormal()));
        luaTable.set("Distance", LuaValue.valueOf(raycast.getT()));
        int material = PartData.INSTANCE.material(raycast.getPart());
        LuaTypes luaTypes = LuaTypes.INSTANCE;
        String itemName = Enums.INSTANCE.itemName("Material", material);
        if (itemName == null) {
            itemName = "Plastic";
        }
        luaTable.set("Material", luaTypes.wrap(new EnumItemV("Material", itemName, material)));
        return luaTable;
    }

    private final Instance self(Varargs a, String name) {
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        Instance instance = (Instance) (obj instanceof Instance ? obj : null);
        if (instance != null) {
            return instance;
        }
        throw new LuaError("Expected ':' not '.' calling member function " + name);
    }

    private final void setTags(Instance i, List<String> t) {
        byte[] bytes = CollectionsKt.joinToString$default(t, "\u0000", null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        Instance.set$default(i, "Tags", new BinaryString(bytes), false, 4, null);
        i.getPropTypes().put("Tags", 1);
    }

    private final List<String> tags(Instance i) {
        Object obj = i.get("Tags");
        List split$default = StringsKt.split$default((CharSequence) (obj instanceof BinaryString ? new String(((BinaryString) obj).getBytes(), Charsets.UTF_8) : obj instanceof String ? (String) obj : ""), new char[]{0}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : split$default) {
            if (((String) obj2).length() > 0) {
                arrayList.add(obj2);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01b2, code lost:
    
        if (r19.equals("CameraSubject") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0320, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r19, "Value") == false) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x032c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r18.getClassName(), "ObjectValue") != false) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
    
        return 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01bc, code lost:
    
        if (r19.equals("FieldOfView") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01d0, code lost:
    
        if (r19.equals("BorderSizePixel") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
    
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01da, code lost:
    
        if (r19.equals("DisplayOrder") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01f8, code lost:
    
        if (r19.equals("MaxHealth") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0202, code lost:
    
        if (r19.equals("BorderColor3") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:?, code lost:
    
        return 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x020c, code lost:
    
        if (r19.equals("JumpHeight") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0216, code lost:
    
        if (r19.equals("ClockTime") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0220, code lost:
    
        if (r19.equals("Thickness") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x022a, code lost:
    
        if (r19.equals("TextureID") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x023e, code lost:
    
        if (r19.equals("TextStrokeColor3") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0246, code lost:
    
        if (r19.equals("Position") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0371, code lost:
    
        if (r18.isA("GuiObject") == false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:?, code lost:
    
        return 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0250, code lost:
    
        if (r19.equals("PrimaryPart") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x025a, code lost:
    
        if (r19.equals("Ambient") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0264, code lost:
    
        if (r19.equals("PlaceholderText") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x026e, code lost:
    
        if (r19.equals("TextXAlignment") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0278, code lost:
    
        if (r19.equals("Adornee") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0282, code lost:
    
        if (r19.equals("BackgroundColor3") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x028c, code lost:
    
        if (r19.equals("TextYAlignment") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0296, code lost:
    
        if (r19.equals("Material") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x02b4, code lost:
    
        if (r19.equals("Texture") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x02be, code lost:
    
        if (r19.equals("FogStart") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x02c8, code lost:
    
        if (r19.equals("FogColor") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x02d2, code lost:
    
        if (r19.equals("ScaleType") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x02e8, code lost:
    
        if (r19.equals("Value") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x02f2, code lost:
    
        if (r19.equals("Title") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x02fc, code lost:
    
        if (r19.equals("Shape") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0306, code lost:
    
        if (r19.equals("Range") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0310, code lost:
    
        if (r19.equals("Part1") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x031a, code lost:
    
        if (r19.equals("Part0") != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x033b, code lost:
    
        if (r19.equals("Image") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0345, code lost:
    
        if (r19.equals("Angle") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x034d, code lost:
    
        if (r19.equals("Rotation") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0357, code lost:
    
        if (r19.equals("OutdoorAmbient") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0361, code lost:
    
        if (r19.equals("Text") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0369, code lost:
    
        if (r19.equals("Size") != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0384, code lost:
    
        if (r19.equals("Font") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x038e, code lost:
    
        if (r19.equals("TextTransparency") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0398, code lost:
    
        if (r19.equals("CameraType") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x03b6, code lost:
    
        if (r19.equals("PlaybackSpeed") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x03c0, code lost:
    
        if (r19.equals("HipHeight") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x03ca, code lost:
    
        if (r19.equals("SoundId") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x03de, code lost:
    
        if (r19.equals("LayoutOrder") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x03e8, code lost:
    
        if (r19.equals("WalkSpeed") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x03fc, code lost:
    
        if (r19.equals("TextColor3") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0406, code lost:
    
        if (r19.equals("ImageColor3") != false) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (r19.equals("RotVelocity") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0414, code lost:
    
        if (r19.equals("TextSize") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0428, code lost:
    
        if (r19.equals("BackgroundTransparency") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0432, code lost:
    
        if (r19.equals("TextStrokeTransparency") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x043c, code lost:
    
        if (r19.equals("AnimationId") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0450, code lost:
    
        if (r19.equals("ImageTransparency") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x045a, code lost:
    
        if (r19.equals("AutomaticSize") != false) goto L319;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x046a, code lost:
    
        if (r19.equals("JumpPower") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ca, code lost:
    
        return 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0473, code lost:
    
        if (r19.equals("ZIndex") != false) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0481, code lost:
    
        if (r19.equals("Brightness") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x048a, code lost:
    
        if (r19.equals("Volume") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x049a, code lost:
    
        if (r19.equals("Transparency") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x04ac, code lost:
    
        if (r19.equals("MeshId") != false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
    
        if (r19.equals("AssemblyLinearVelocity") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x04c8, code lost:
    
        if (r19.equals("Reflectance") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        if (r19.equals("Position") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
    
        if (r19.equals("Orientation") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0091, code lost:
    
        if (r19.equals("AssemblyAngularVelocity") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
    
        if (r19.equals("Rotation") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00aa, code lost:
    
        if (r19.equals("Size") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
    
        if (r19.equals("Velocity") != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0022, code lost:
    
        if (r19.equals("Archivable") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002d, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x013b, code lost:
    
        if (r19.equals("Size") == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0153, code lost:
    
        return 21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0142, code lost:
    
        if (r19.equals("Transparency") == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014b, code lost:
    
        if (r19.equals("Squash") != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        if (r19.equals("Enabled") != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x018a, code lost:
    
        if (r19.equals("FogEnd") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:?, code lost:
    
        return 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0194, code lost:
    
        if (r19.equals("FillDirection") == false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:?, code lost:
    
        return 18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x019e, code lost:
    
        if (r19.equals("SortOrder") == false) goto L354;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0057. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:66:0x0126. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:86:0x0175. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Integer typeHint(com.exampletest.mobilestudiotest.model.Instance r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 1648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.typeHint(com.exampletest.mobilestudiotest.model.Instance, java.lang.String):java.lang.Integer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean workspaceCall$lambda$52(List list, boolean z, Instance p) {
        boolean z2;
        Intrinsics.checkNotNullParameter(p, "p");
        List list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                Instance instance = (Instance) it.next();
                if (p == instance || p.isDescendantOf(instance)) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
        }
        return z ? z2 : !z2;
    }

    private final List<Instance> workspaceParts() {
        Instance findService = this.rt.getDm().findService("Workspace");
        return findService == null ? CollectionsKt.emptyList() : this.rt.getDm() == this.rt.getStudio().getModel() ? this.rt.getStudio().renderParts() : partsIn(findService);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0301, code lost:
    
        r6 = r19.rt.getDm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x030b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r20, "FindService") == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x030d, code lost:
    
        r2 = r19.rt;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r2 = r2.wrap(r6.findService(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x031b, code lost:
    
        r2 = r19.rt;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r7 = r6.findService(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0324, code lost:
    
        if (r7 != null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0326, code lost:
    
        r7 = r6.getService(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0336, code lost:
    
        if (com.exampletest.mobilestudiotest.model.ClassDb.INSTANCE.getServiceNames().contains(r0) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0338, code lost:
    
        r7.setArchivable(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x033c, code lost:
    
        r2 = r2.wrap(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x029b, code lost:
    
        if (r20.equals("FindService") != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x04d7, code lost:
    
        if (r20.equals("Destroy") == false) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0587, code lost:
    
        if (r3.getIsService() != false) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x058b, code lost:
    
        if ((r3 instanceof com.exampletest.mobilestudiotest.model.DataModel) != false) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0591, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r20, "Destroy") == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0593, code lost:
    
        r3.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x059c, code lost:
    
        r0 = org.luaj.vm2.LuaValue.NONE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0597, code lost:
    
        com.exampletest.mobilestudiotest.model.Instance.setParent$default(r3, null, 0, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x05c2, code lost:
    
        throw new org.luaj.vm2.LuaError("Cannot destroy " + r3.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0581, code lost:
    
        if (r20.equals("Remove") != false) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0169, code lost:
    
        if (r20.equals("children") == false) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return listToLua(kotlin.collections.CollectionsKt.toList(r3.getChildren()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ce, code lost:
    
        if (r20.equals("GetChildren") != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0265, code lost:
    
        if (r20.equals("GetService") == false) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x029d, code lost:
    
        r0 = r6.checkjstring();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02ab, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3.getClassName(), "UserSettings") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02ad, code lost:
    
        r8 = r3.getChildren().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02bc, code lost:
    
        if (r8.hasNext() == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02be, code lost:
    
        r9 = r8.next();
        r10 = (com.exampletest.mobilestudiotest.model.Instance) r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02ce, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r10.getClassName(), r0) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02d8, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r10.getName(), r0) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02da, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02dd, code lost:
    
        if (r10 == false) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02df, code lost:
    
        r6 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02e2, code lost:
    
        r6 = (com.exampletest.mobilestudiotest.model.Instance) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02e4, code lost:
    
        if (r6 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02e6, code lost:
    
        r2 = r19.rt.wrap(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02ed, code lost:
    
        if (r2 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02f7, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02f0, code lost:
    
        r2 = org.luaj.vm2.LuaValue.NIL;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "NIL");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02dc, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02fa, code lost:
    
        if ((r3 instanceof com.exampletest.mobilestudiotest.model.DataModel) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02fc, code lost:
    
        r6 = (com.exampletest.mobilestudiotest.model.DataModel) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02ff, code lost:
    
        if (r6 != null) goto L97;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0061. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs callMethod(java.lang.String r20, org.luaj.vm2.Varargs r21) {
        /*
            Method dump skipped, instructions count: 1760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.callMethod(java.lang.String, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
    
        if (r14.equals("AddTag") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0095, code lost:
    
        if (r14.equals("GetTags") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
    
        if (r14.equals("RemoveTag") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015d, code lost:
    
        if (r14.equals("HasTag") == false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs collectionCall(java.lang.String r14, org.luaj.vm2.Varargs r15) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.collectionCall(java.lang.String, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    public final Set<String> getEvents() {
        return this.events;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x026e, code lost:
    
        if (r12.equals("CurrentPosition") == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x028b, code lost:
    
        r0 = r11.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x028f, code lost:
    
        if (r0 != null) goto L575;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0295, code lost:
    
        return java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0277, code lost:
    
        if (r12.equals("CurrentAngle") == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0280, code lost:
    
        if (r12.equals("CurrentDistance") != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0289, code lost:
    
        if (r12.equals("CurrentLength") != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x03ec, code lost:
    
        if (r12.equals("AccelerometerEnabled") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x043e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x03f5, code lost:
    
        if (r12.equals("MouseEnabled") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x03fe, code lost:
    
        if (r12.equals("VREnabled") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0407, code lost:
    
        if (r12.equals("MouseIconEnabled") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0424, code lost:
    
        r0 = r11.get(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0428, code lost:
    
        if (r0 != null) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x042f, code lost:
    
        return new com.exampletest.mobilestudiotest.model.EnumValue(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0410, code lost:
    
        if (r12.equals("KeyboardEnabled") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0419, code lost:
    
        if (r12.equals("GyroscopeEnabled") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0422, code lost:
    
        if (r12.equals("MouseBehavior") != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0436, code lost:
    
        if (r12.equals("GamepadEnabled") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x04be, code lost:
    
        if (r0.equals("TextLabel") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x07ae, code lost:
    
        switch(r12.hashCode()) {
            case -940855710: goto L513;
            case -939412113: goto L509;
            case 1278718246: goto L505;
            default: goto L569;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x07b8, code lost:
    
        if (r12.equals("ContentText") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x07c0, code lost:
    
        return r11.get("Text");
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x07c7, code lost:
    
        if (r12.equals("TextFits") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x07cd, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x07d4, code lost:
    
        if (r12.equals("TextBounds") != false) goto L516;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x07d8, code lost:
    
        r0 = r11.get("TextSize");
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x07e0, code lost:
    
        if ((r0 instanceof java.lang.Number) == false) goto L519;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (r12.equals("RotVelocity") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x07e2, code lost:
    
        r0 = (java.lang.Number) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x07e6, code lost:
    
        if (r0 == null) goto L522;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x07e8, code lost:
    
        r0 = r0.floatValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x07ef, code lost:
    
        r2 = r11.get("Text");
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x07f9, code lost:
    
        if ((r2 instanceof java.lang.String) == false) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x07fb, code lost:
    
        r4 = (java.lang.String) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x07fe, code lost:
    
        if (r4 == null) goto L528;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0800, code lost:
    
        r9 = r4.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x080c, code lost:
    
        return new com.exampletest.mobilestudiotest.model.Vector2((r9 * r0) * 0.5f, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x07ed, code lost:
    
        r0 = 14.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x07e5, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        return com.exampletest.mobilestudiotest.model.Vector3.INSTANCE.getZERO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        if (r12.equals("AssemblyMass") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0100, code lost:
    
        r0 = com.exampletest.mobilestudiotest.model.PartData.INSTANCE.size(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x011c, code lost:
    
        return java.lang.Float.valueOf(((r0.getX() * r0.getY()) * r0.getZ()) * 0.7f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0565, code lost:
    
        if (r0.equals("ImageLabel") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0819, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r12, "IsLoaded") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x081f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x056f, code lost:
    
        if (r0.equals("TextBox") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
    
        if (r12.equals("AssemblyLinearVelocity") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0163, code lost:
    
        r0 = r10.rt.getPlay();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0169, code lost:
    
        if (r0 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x016b, code lost:
    
        r0 = r0.velocityOf(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x016f, code lost:
    
        if (r0 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0628, code lost:
    
        if (r12.equals("ShowConstraintDetails") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0640, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x063a, code lost:
    
        if (r12.equals("DraggerSolveConstraints") != false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0178, code lost:
    
        return com.exampletest.mobilestudiotest.model.Vector3.INSTANCE.getZERO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x0702, code lost:
    
        if (r12.equals("AnimateHover") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x0790, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x070c, code lost:
    
        if (r12.equals("PivotSnapToGeometry") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x074a, code lost:
    
        if (r12.equals("ShowHover") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x0753, code lost:
    
        if (r12.equals("AlignDraggedObjects") == false) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x078a, code lost:
    
        if (r12.equals("ShowPivotIndicator") != false) goto L493;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x07a8, code lost:
    
        if (r0.equals("TextButton") != false) goto L502;
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x0813, code lost:
    
        if (r0.equals("ImageButton") != false) goto L532;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ba, code lost:
    
        if (r12.equals("AssemblyAngularVelocity") != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00fe, code lost:
    
        if (r12.equals("Mass") != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0161, code lost:
    
        if (r12.equals("Velocity") != false) goto L85;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:137:0x0264. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:152:0x02a3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:231:0x03d4. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x005a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:418:0x061d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:455:0x06b6. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getK(com.exampletest.mobilestudiotest.model.Instance r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 2652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.getK(com.exampletest.mobilestudiotest.model.Instance, java.lang.String):java.lang.Object");
    }

    public final LuaRuntime getRt() {
        return this.rt;
    }

    public final LuaTable getSignalMeta() {
        return this.signalMeta;
    }

    public final boolean hasK(Instance inst, String name) {
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.BASE_PROPS.contains(name)) {
            return true;
        }
        if (isPart(inst) && this.PART_PROPS.contains(name)) {
            return true;
        }
        if (inst.isA("Model") && Intrinsics.areEqual(name, "WorldPivot")) {
            return true;
        }
        boolean z = false;
        if (inst.isA("GuiBase2d") && StringsKt.startsWith$default(name, "Absolute", false, 2, (Object) null)) {
            return true;
        }
        if (inst.isA("UIGridStyleLayout") && (Intrinsics.areEqual(name, "AbsoluteContentSize") || (Intrinsics.areEqual(name, "AbsoluteCellSize") && Intrinsics.areEqual(inst.getClassName(), "UIGridLayout")))) {
            return true;
        }
        if (inst.isA("BaseScript") && Intrinsics.areEqual(name, "Enabled")) {
            return true;
        }
        if (inst.isA("Constraint") && this.CONSTRAINT_READOUTS.contains(name)) {
            return true;
        }
        Set<String> set = this.SPECIAL_PROPS.get(inst.getClassName());
        if (set != null && set.contains(name)) {
            z = true;
        }
        if (z) {
            return true;
        }
        return inst.getProps().containsKey(PropNames.INSTANCE.resolve(inst, name));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0299, code lost:
    
        if (r22.equals("ApplyDescription") == false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x030c, code lost:
    
        if (r22.equals("AddAccessory") == false) goto L160;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs humanoidCall(com.exampletest.mobilestudiotest.model.Instance r21, java.lang.String r22, org.luaj.vm2.Varargs r23) {
        /*
            Method dump skipped, instructions count: 862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.humanoidCall(com.exampletest.mobilestudiotest.model.Instance, java.lang.String, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    public final LuaValue index(Instance inst, String key0) {
        LuaValue luaValue;
        Instance findFirstChild$default;
        VarArgFunction varArgFunction;
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(key0, "key0");
        String str = key0;
        boolean z = true;
        if ((str.length() > 0) && Character.isLowerCase(str.charAt(0))) {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String str2 = upperCase + substring;
            if (methodAllowed(inst, str2)) {
                str = str2;
            }
        }
        switch (str.hashCode()) {
            case -1911556918:
                if (str.equals("Parent")) {
                    return this.rt.wrap(inst.getParent());
                }
                break;
            case 2420395:
                if (str.equals("Name")) {
                    LuaString valueOf = LuaValue.valueOf(inst.getName());
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                    return valueOf;
                }
                break;
            case 1994079235:
                if (str.equals("ClassName")) {
                    LuaString valueOf2 = LuaValue.valueOf(inst.getClassName());
                    Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
                    return valueOf2;
                }
                break;
        }
        if (methodAllowed(inst, str)) {
            HashMap<String, LuaValue> hashMap = this.methodCache;
            String str3 = str;
            LuaValue luaValue2 = hashMap.get(str3);
            if (luaValue2 == null) {
                varArgFunction = LuaTypesKt.fnv(new InstanceApi$$ExternalSyntheticLambda20(this, str));
                hashMap.put(str3, varArgFunction);
            } else {
                varArgFunction = luaValue2;
            }
            return varArgFunction;
        }
        if ((inst.isA("BaseScript") || inst.isA("ModuleScript")) && Intrinsics.areEqual(str, "Source")) {
            Object obj = inst.get("Source");
            String str4 = obj instanceof String ? (String) obj : null;
            LuaString valueOf3 = LuaValue.valueOf(str4 != null ? str4 : "");
            Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(...)");
            return valueOf3;
        }
        if (hasK(inst, str)) {
            return this.rt.toLua(getK(inst, str), inst, PropNames.INSTANCE.resolve(inst, str));
        }
        if (this.events.contains(str)) {
            return (this.universalEvents.contains(str) || (findFirstChild$default = Instance.findFirstChild$default(inst, str, false, 2, null)) == null) ? signal(inst, str) : this.rt.wrap(findFirstChild$default);
        }
        HashMap<String, LuaValue> hashMap2 = this.rt.getCallbacks().get(inst);
        if (hashMap2 != null && (luaValue = hashMap2.get(str)) != null) {
            return luaValue;
        }
        Instance findFirstChild$default2 = Instance.findFirstChild$default(inst, str, false, 2, null);
        if (findFirstChild$default2 != null) {
            return this.rt.wrap(findFirstChild$default2);
        }
        String contentAlias = contentAlias(inst, str);
        if (contentAlias != null) {
            if (hasK(inst, contentAlias)) {
                return this.rt.toLua(getK(inst, contentAlias), inst, contentAlias);
            }
            LuaString valueOf4 = LuaValue.valueOf("");
            Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(...)");
            return valueOf4;
        }
        List<String> list = this.MEMBER_OWNERS.get(str);
        if (list != null) {
            List<String> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (inst.isA((String) it.next())) {
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                throw new LuaError(((Object) str) + " is not a valid member of " + inst.getClassName() + " \"" + inst.fullName() + "\"");
            }
        }
        if (this.warnedMissing.add(inst.getClassName() + "." + ((Object) str))) {
            OutputLog.INSTANCE.warn(((Object) str) + " is not a known member of " + inst.getClassName() + " (treated as nil)");
        }
        LuaValue NIL = LuaValue.NIL;
        Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
        return NIL;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02c1, code lost:
    
        if (r14.equals("GetPrimaryPartCFrame") == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r14.equals("GetPivot") == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x02c4, code lost:
    
        r0 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x02cc, code lost:
    
        if (r13.isA("BasePart") == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x02ce, code lost:
    
        r1 = com.exampletest.mobilestudiotest.model.PartData.INSTANCE.cframe(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return r0.wrap(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x02d5, code lost:
    
        r1 = modelPivot(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        if (r14.equals("SetPrimaryPartCFrame") == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d0, code lost:
    
        r0 = r15.arg(2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00de, code lost:
    
        if (r0.isuserdata() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e0, code lost:
    
        r4 = r0.touserdata();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e8, code lost:
    
        if ((r4 instanceof com.exampletest.mobilestudiotest.model.CFrame) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ea, code lost:
    
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00eb, code lost:
    
        r5 = (com.exampletest.mobilestudiotest.model.CFrame) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ed, code lost:
    
        if (r5 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ef, code lost:
    
        pivotTo(r13, r5);
        r0 = org.luaj.vm2.LuaValue.NONE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x011b, code lost:
    
        throw new org.luaj.vm2.LuaError("CFrame expected, got " + com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.typeOf(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e5, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ce, code lost:
    
        if (r14.equals("PivotTo") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0212, code lost:
    
        if (r14.equals("GetModelCFrame") == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x021c, code lost:
    
        if (r14.equals("GetModelSize") == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0228, code lost:
    
        r0 = com.exampletest.mobilestudiotest.engine.Geometry.INSTANCE.boundsOf(partsIn(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0232, code lost:
    
        if (r0 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0234, code lost:
    
        r0 = kotlin.TuplesKt.to(com.exampletest.mobilestudiotest.model.Vector3.INSTANCE.getZERO(), com.exampletest.mobilestudiotest.model.Vector3.INSTANCE.getZERO());
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r0.getSecond().minus(r0.getFirst()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0226, code lost:
    
        if (r14.equals("GetExtentsSize") != false) goto L75;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001b. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs modelCall(com.exampletest.mobilestudiotest.model.Instance r13, java.lang.String r14, org.luaj.vm2.Varargs r15) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.modelCall(com.exampletest.mobilestudiotest.model.Instance, java.lang.String, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    public final CFrame modelPivot(Instance m) {
        CFrame cframe;
        Intrinsics.checkNotNullParameter(m, "m");
        Object obj = m.get("PrimaryPart");
        Instance instance = obj instanceof Instance ? (Instance) obj : null;
        if (instance != null) {
            return PartData.INSTANCE.cframe(instance);
        }
        Object obj2 = m.get("WorldPivotData");
        OptionalCFrame optionalCFrame = obj2 instanceof OptionalCFrame ? (OptionalCFrame) obj2 : null;
        if (optionalCFrame != null && (cframe = optionalCFrame.getCframe()) != null) {
            return cframe;
        }
        Pair<Vector3, Vector3> boundsOf = Geometry.INSTANCE.boundsOf(partsIn(m));
        return boundsOf == null ? CFrame.INSTANCE.getIDENTITY() : CFrame.INSTANCE.at(boundsOf.getFirst().plus(boundsOf.getSecond()).div(2.0f));
    }

    public final void newIndex(Instance inst, String key, LuaValue v) {
        HashMap<String, LuaValue> hashMap;
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(v, "v");
        String contentAlias = contentAlias(inst, key);
        String str = "";
        if (contentAlias != null && (v.isstring() || v.isnil())) {
            LuaString valueOf = v.isnil() ? LuaValue.valueOf("") : v;
            Intrinsics.checkNotNull(valueOf);
            newIndex(inst, contentAlias, valueOf);
            return;
        }
        if (Intrinsics.areEqual(key, "OnServerInvoke") || Intrinsics.areEqual(key, "OnClientInvoke") || Intrinsics.areEqual(key, "OnInvoke") || (v.isfunction() && !inst.getProps().containsKey(key))) {
            IdentityHashMap<Instance, HashMap<String, LuaValue>> callbacks = this.rt.getCallbacks();
            HashMap<String, LuaValue> hashMap2 = callbacks.get(inst);
            if (hashMap2 == null) {
                hashMap = new HashMap<>();
                callbacks.put(inst, hashMap);
            } else {
                hashMap = hashMap2;
            }
            hashMap.put(key, v);
            return;
        }
        if (Intrinsics.areEqual(key, "Source") && inst.isA("LuaSourceContainer")) {
            if (this.rt.getIsPlay()) {
                throw new LuaError("The current thread cannot write 'Source' (lacking capability PluginOrOpenCloud)");
            }
            Instance.set$default(inst, "Source", v.tojstring(), false, 4, null);
            return;
        }
        Integer typeHint = typeHint(inst, key);
        try {
            try {
                setK(inst, key, this.rt.fromLua(v, typeHint, inst, PropNames.INSTANCE.resolve(inst, key)));
            } catch (ClassCastException e) {
                throw new LuaError("Unable to assign property " + key + ". " + LuaTypes.INSTANCE.typeOf(v) + " is not the correct type");
            }
        } catch (LuaError e2) {
            String str2 = ((typeHint == null || typeHint.intValue() != 4) && (typeHint == null || typeHint.intValue() != 5) && ((typeHint == null || typeHint.intValue() != 3) && (typeHint == null || typeHint.intValue() != 27))) ? (typeHint == null || typeHint.intValue() != 2) ? (typeHint == null || typeHint.intValue() != 1) ? (typeHint == null || typeHint.intValue() != 18) ? null : "EnumItem" : TypedValues.Custom.S_STRING : TypedValues.Custom.S_BOOLEAN : "number";
            if (str2 == null) {
                String message = e2.getMessage();
                if (message != null) {
                    str = message;
                }
            } else {
                str = str2 + " expected, got " + LuaTypes.INSTANCE.typeOf(v);
            }
            throw new LuaError("Unable to assign property " + key + ". " + str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (r9.equals("GetPivot") == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0136, code lost:
    
        if (r9.equals("PivotTo") != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs partCall(com.exampletest.mobilestudiotest.model.Instance r8, java.lang.String r9, org.luaj.vm2.Varargs r10) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.partCall(com.exampletest.mobilestudiotest.model.Instance, java.lang.String, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    public final List<Instance> partsIn(Instance i) {
        Intrinsics.checkNotNullParameter(i, "i");
        ArrayList arrayList = new ArrayList();
        if (i.isA("BasePart")) {
            arrayList.add(i);
        }
        for (Instance instance : Instance.descendants$default(i, null, 1, null)) {
            if (instance.isA("BasePart")) {
                arrayList.add(instance);
            }
        }
        return arrayList;
    }

    public final void pivotTo(Instance target, CFrame cf) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(cf, "cf");
        if (target.isA("BasePart")) {
            PartData.INSTANCE.setCFrame(target, cf);
            return;
        }
        CFrame times = cf.times(modelPivot(target).inverse());
        for (Instance instance : partsIn(target)) {
            PartData.INSTANCE.setCFrame(instance, times.times(PartData.INSTANCE.cframe(instance)));
        }
        if (target.getProps().containsKey("WorldPivotData") && target.get("PrimaryPart") == null) {
            Instance.set$default(target, "WorldPivotData", new OptionalCFrame(cf), false, 4, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0116, code lost:
    
        if (r20.equals("AssemblyLinearVelocity") == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x022f, code lost:
    
        r0 = r18.rt.getPlay();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0235, code lost:
    
        if (r0 == null) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0237, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.Vector3");
        r0.setVelocity(r19, (com.exampletest.mobilestudiotest.model.Vector3) r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0240, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x022d, code lost:
    
        if (r20.equals("Velocity") != false) goto L92;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:48:0x00ef. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setK(com.exampletest.mobilestudiotest.model.Instance r19, java.lang.String r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 1238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.setK(com.exampletest.mobilestudiotest.model.Instance, java.lang.String, java.lang.Object):void");
    }

    public final LuaValue signal(Object owner, String name) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        return new LuaUserdata(new SignalRef(owner, name), this.signalMeta);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01d4, code lost:
    
        if (r30.equals("IsRegion3EmptyWithIgnoreList") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x094e, code lost:
    
        r3 = r31.arg(2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x095c, code lost:
    
        if (r3.isuserdata() == false) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x095e, code lost:
    
        r9 = r3.touserdata();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0966, code lost:
    
        if ((r9 instanceof com.exampletest.mobilestudiotest.lua.Region3V) != false) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0968, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0969, code lost:
    
        r9 = (com.exampletest.mobilestudiotest.lua.Region3V) r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x096b, code lost:
    
        if (r9 == null) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x096e, code lost:
    
        r3 = r31.arg(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0977, code lost:
    
        if (r3.istable() == false) goto L347;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0979, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
        r4 = instList(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x09a8, code lost:
    
        r7 = kotlin.jvm.internal.Intrinsics.areEqual(r30, "FindPartsInRegion3WithWhiteList");
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x09b5, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r30, "Is", false, 2, (java.lang.Object) null) == false) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x09b7, code lost:
    
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x09cb, code lost:
    
        r12 = new java.util.ArrayList();
        r13 = workspaceParts().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x09dc, code lost:
    
        if (r13.hasNext() == false) goto L416;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x09de, code lost:
    
        r14 = r13.next();
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x09eb, code lost:
    
        if ((r15 instanceof java.util.Collection) == false) goto L370;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x09f4, code lost:
    
        if (r15.isEmpty() == false) goto L370;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x09f6, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0a1f, code lost:
    
        if (r7 == false) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0a21, code lost:
    
        if (r5 != false) goto L387;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0a23, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0a28, code lost:
    
        if (r11 != false) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006a, code lost:
    
        if (r30.equals("FindPartOnRayWithIgnoreList") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0a2a, code lost:
    
        r11 = com.exampletest.mobilestudiotest.engine.Geometry.INSTANCE.partAabb(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0a54, code lost:
    
        if (com.exampletest.mobilestudiotest.engine.Geometry.aabbOverlap$default(com.exampletest.mobilestudiotest.engine.Geometry.INSTANCE, r11.component1(), r11.component2(), r9.getMin(), r9.getMax(), 0.0f, 16, null) == false) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0a56, code lost:
    
        r12.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0a5d, code lost:
    
        if (r12.size() < r10) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x080e, code lost:
    
        r3 = r31.arg(2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0a6e, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r30, "Is", false, 2, (java.lang.Object) null) == false) goto L400;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0a70, code lost:
    
        r5 = org.luaj.vm2.LuaValue.valueOf(r12.isEmpty());
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0a80, code lost:
    
        r5 = r5;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0a79, code lost:
    
        r5 = listToLua(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0a25, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0a27, code lost:
    
        r11 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x081c, code lost:
    
        if (r3.isuserdata() == false) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x09f8, code lost:
    
        r11 = r15.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0a00, code lost:
    
        if (r11.hasNext() == false) goto L423;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0a02, code lost:
    
        r5 = (com.exampletest.mobilestudiotest.model.Instance) r11.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0a0c, code lost:
    
        if (r14 == r5) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0a12, code lost:
    
        if (r14.isDescendantOf(r5) != false) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0a14, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0a17, code lost:
    
        if (r5 == false) goto L381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x081e, code lost:
    
        r10 = r3.touserdata();
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0a19, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0a16, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0a1d, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x09bb, code lost:
    
        r10 = kotlin.ranges.RangesKt.coerceAtLeast(r31.arg(4).optint(20), 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0985, code lost:
    
        if (r3.isuserdata() == false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0987, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0990, code lost:
    
        if (r3.isuserdata() == false) goto L352;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0992, code lost:
    
        r8 = r3.touserdata();
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x099a, code lost:
    
        if ((r8 instanceof com.exampletest.mobilestudiotest.model.Instance) != false) goto L356;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x099c, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x099d, code lost:
    
        r4 = kotlin.collections.CollectionsKt.listOfNotNull((com.exampletest.mobilestudiotest.model.Instance) r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0997, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x09a4, code lost:
    
        r4 = kotlin.collections.CollectionsKt.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0aaa, code lost:
    
        throw new org.luaj.vm2.LuaError("Region3 expected, got " + com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.typeOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0826, code lost:
    
        if ((r10 instanceof com.exampletest.mobilestudiotest.model.Ray) != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0963, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x01de, code lost:
    
        if (r30.equals("SetInsertPoint") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x07ff, code lost:
    
        r3 = org.luaj.vm2.LuaValue.NONE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "NONE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0828, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0829, code lost:
    
        r10 = (com.exampletest.mobilestudiotest.model.Ray) r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x082b, code lost:
    
        if (r10 == null) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02c1, code lost:
    
        if (r30.equals("UnjoinFromOutsiders") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0837, code lost:
    
        if (r31.arg(3).istable() == false) goto L308;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0839, code lost:
    
        r3 = r31.arg(3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "arg(...)");
        r3 = instList(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0873, code lost:
    
        r7 = kotlin.jvm.internal.Intrinsics.areEqual(r30, "FindPartOnRayWithWhitelist");
        r8 = r10.getDirection().getMagnitude();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0885, code lost:
    
        if (r8 >= 1.0E-6f) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x03f4, code lost:
    
        if (r30.equals("FindPartsInRegion3") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x03fe, code lost:
    
        if (r30.equals("IsRegion3Empty") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0408, code lost:
    
        if (r30.equals("FindPartsInRegion3WithIgnoreList") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0412, code lost:
    
        if (r30.equals("Spherecast") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x055d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r30, "Blockcast") == false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x055f, code lost:
    
        r3 = r31.arg(2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x056d, code lost:
    
        if (r3.isuserdata() == false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x056f, code lost:
    
        r7 = r3.touserdata();
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0577, code lost:
    
        if ((r7 instanceof com.exampletest.mobilestudiotest.model.CFrame) != false) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0579, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x057a, code lost:
    
        r7 = (com.exampletest.mobilestudiotest.model.CFrame) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x08a9, code lost:
    
        if (r6 != null) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x057c, code lost:
    
        if (r7 == null) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x057e, code lost:
    
        r3 = r7.getPosition();
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x05c4, code lost:
    
        r4 = r31.arg(4);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x05d3, code lost:
    
        if (r4.isuserdata() == false) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x05d5, code lost:
    
        r8 = r4.touserdata();
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x05dd, code lost:
    
        if ((r8 instanceof com.exampletest.mobilestudiotest.model.Vector3) == false) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x05df, code lost:
    
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x05e0, code lost:
    
        r6 = (com.exampletest.mobilestudiotest.model.Vector3) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x05e2, code lost:
    
        if (r6 == null) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x08ab, code lost:
    
        r3 = org.luaj.vm2.LuaValue.varargsOf(org.luaj.vm2.LuaValue.NIL, com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r10.getOrigin().plus(r10.getDirection())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x05e4, code lost:
    
        r4 = r31.arg(5);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:?, code lost:
    
        return raycastResult(r3, r6, filterFrom(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0618, code lost:
    
        throw new org.luaj.vm2.LuaError("Vector3 expected, got " + com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.typeOf(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x05da, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x05a3, code lost:
    
        throw new org.luaj.vm2.LuaError("CFrame expected, got " + com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.typeOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0574, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x05a4, code lost:
    
        r3 = r31.arg(2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05b2, code lost:
    
        if (r3.isuserdata() == false) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x091f, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x05b4, code lost:
    
        r7 = r3.touserdata();
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x05bc, code lost:
    
        if ((r7 instanceof com.exampletest.mobilestudiotest.model.Vector3) != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x05be, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x05bf, code lost:
    
        r7 = (com.exampletest.mobilestudiotest.model.Vector3) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x05c1, code lost:
    
        if (r7 == null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x05c3, code lost:
    
        r3 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0639, code lost:
    
        throw new org.luaj.vm2.LuaError("Vector3 expected, got " + com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.typeOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x05b9, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x042f, code lost:
    
        if (r30.equals("FindPartOnRay") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0439, code lost:
    
        if (r30.equals("JoinToOutsiders") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x08c7, code lost:
    
        r8 = new org.luaj.vm2.LuaValue[4];
        r8[0] = r29.rt.wrap(r6.getPart());
        r8[1] = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r6.getPosition());
        r8[2] = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r6.getNormal());
        r5 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r11 = com.exampletest.mobilestudiotest.model.Enums.INSTANCE.itemName("Material", com.exampletest.mobilestudiotest.model.PartData.INSTANCE.material(r6.getPart()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0903, code lost:
    
        if (r11 != null) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0905, code lost:
    
        r11 = "Plastic";
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0907, code lost:
    
        r8[3] = r5.wrap(new com.exampletest.mobilestudiotest.lua.EnumItemV("Material", r11, com.exampletest.mobilestudiotest.model.PartData.INSTANCE.material(r6.getPart())));
        r3 = org.luaj.vm2.LuaValue.varargsOf(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0557, code lost:
    
        if (r30.equals("Blockcast") != false) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x088a, code lost:
    
        r6 = com.exampletest.mobilestudiotest.engine.Geometry.INSTANCE.raycast(workspaceParts(), r10.getOrigin(), r10.getDirection().div(r8), r8, new com.exampletest.mobilestudiotest.lua.InstanceApi$$ExternalSyntheticLambda14(r3, r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x084d, code lost:
    
        if (r31.arg(3).isuserdata() == false) goto L318;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x084f, code lost:
    
        r3 = r31.arg(3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x085b, code lost:
    
        if (r3.isuserdata() == false) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x085d, code lost:
    
        r8 = r3.touserdata();
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x07fd, code lost:
    
        if (r30.equals("ZoomToExtents") != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0865, code lost:
    
        if ((r8 instanceof com.exampletest.mobilestudiotest.model.Instance) != false) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x080c, code lost:
    
        if (r30.equals("FindPartOnRayWithWhitelist") != false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x094a, code lost:
    
        if (r30.equals("FindPartsInRegion3WithWhiteList") == false) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0867, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0868, code lost:
    
        r3 = kotlin.collections.CollectionsKt.listOfNotNull((com.exampletest.mobilestudiotest.model.Instance) r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0862, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x086f, code lost:
    
        r3 = kotlin.collections.CollectionsKt.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0945, code lost:
    
        throw new org.luaj.vm2.LuaError("Ray expected, got " + com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.typeOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0823, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x002c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0389 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0342 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0521 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v150 */
    /* JADX WARN: Type inference failed for: r3v151 */
    /* JADX WARN: Type inference failed for: r3v152 */
    /* JADX WARN: Type inference failed for: r3v154 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs workspaceCall(java.lang.String r30, org.luaj.vm2.Varargs r31) {
        /*
            Method dump skipped, instructions count: 2854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.InstanceApi.workspaceCall(java.lang.String, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }
}
