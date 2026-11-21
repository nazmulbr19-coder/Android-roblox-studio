package com.exampletest.mobilestudiotest.ui;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.model.ClassDb;
import com.exampletest.mobilestudiotest.model.Instance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.luaj.vm2.parser.LuaParserConstants;

/* compiled from: Autocomplete.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006NOPQRSB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J4\u0010\u001b\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001d0\u001c2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J$\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0\f2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020'H\u0002J\u0018\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010+\u001a\u00020'H\u0002J \u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00052\u0006\u0010(\u001a\u00020\u00062\u0006\u0010.\u001a\u00020'H\u0002J:\u0010/\u001a\u0004\u0018\u00010\u00182\u0006\u00100\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u00062\u0006\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020'H\u0002J:\u00105\u001a\u0004\u0018\u00010\u00182\u0006\u00100\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u00062\u0006\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020'H\u0002J*\u00106\u001a\u0004\u0018\u00010\u00182\u0006\u00107\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00104\u001a\u00020'H\u0002J@\u00108\u001a\u0004\u0018\u00010\u00182\f\u00109\u001a\b\u0012\u0004\u0012\u00020-0\u00052\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u00062\u0006\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020'H\u0002J\"\u0010:\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020-2\u0006\u0010 \u001a\u00020!H\u0002J\u001e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010<\u001a\u00020'H\u0002J$\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u00052\u0006\u0010@\u001a\u00020\u0006H\u0002J2\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u00062\u0006\u0010C\u001a\u00020'2\b\b\u0002\u0010D\u001a\u00020#J\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00020>0\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010F\u001a\u00020%H\u0002J\u0010\u0010G\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J2\u0010L\u001a\u0004\u0018\u00010B2\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u00062\u0006\u0010C\u001a\u00020'2\u0006\u0010M\u001a\u00020'H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006T"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete;", "", "<init>", "()V", "keywords", "", "", "globals", "libs", "", "dataStatics", "dataMembers", "Lkotlin/Pair;", "m", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Members;", "props", "methods", "events", "classMembers", "propTypes", "methodReturns", "nameHints", "clsOf", "t", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "classChain", "cls", "membersFor", "Lkotlin/Triple;", "", "typeFromHint", "s", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "isId", "", "c", "", "lexState", "", "text", "pos", "longLevel", "at", "chainBefore", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Step;", "end", "resolveRoot", "name", "script", "Lcom/exampletest/mobilestudiotest/model/Instance;", "before", "depth", "resolveLocal", "resolveExpr", "expr", "resolveSteps", "steps", "member", "localNames", "upTo", "rank", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Item;", "items", "prefix", "complete", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Result;", "cursor", "explicit", "membersOf", "acc", "isSimpleName", "extraEnums", "serviceList", "getServiceList", "()Ljava/util/List;", "completeString", "quoteAt", "Kind", "Item", "Result", "Members", "T", "Step", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Autocomplete {
    public static final Autocomplete INSTANCE = new Autocomplete();
    private static final List<String> keywords = CollectionsKt.listOf((Object[]) new String[]{"and", "break", "do", "else", "elseif", "end", "false", "for", "function", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while", "continue", "export", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY});
    private static final List<String> globals = CollectionsKt.listOf((Object[]) new String[]{"game", "workspace", "script", "plugin", "shared", "_G", "print", "warn", "error", "assert", "pcall", "xpcall", "typeof", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "tostring", "tonumber", "pairs", "ipairs", "next", "select", "unpack", "require", "setmetatable", "getmetatable", "rawget", "rawset", "rawequal", "rawlen", "wait", "spawn", "delay", "tick", "time", "elapsedTime", "collectgarbage", "gcinfo", "newproxy", "version", "settings", "UserSettings"});
    private static final Map<String, List<String>> libs = MapsKt.mapOf(TuplesKt.to(AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_MATH, CollectionsKt.listOf((Object[]) new String[]{"abs", "acos", "asin", "atan", "atan2", "ceil", "clamp", "cos", "cosh", "deg", "exp", "floor", "fmod", "frexp", "huge", "ldexp", "log", "log10", "max", "min", "modf", "noise", "pi", "pow", "rad", "random", "randomseed", "round", "sign", "sin", "sinh", "sqrt", "tan", "tanh", "lerp", "map"})), TuplesKt.to(TypedValues.Custom.S_STRING, CollectionsKt.listOf((Object[]) new String[]{"byte", "char", "find", "format", "gmatch", "gsub", "len", "lower", "match", "rep", "reverse", "split", "sub", "upper", "pack", "packsize", "unpack"})), TuplesKt.to("table", CollectionsKt.listOf((Object[]) new String[]{"clear", "clone", "concat", "create", "find", "freeze", "insert", "isfrozen", "maxn", "move", "pack", "remove", "sort", "unpack"})), TuplesKt.to("task", CollectionsKt.listOf((Object[]) new String[]{"wait", "spawn", "defer", "delay", "cancel", "synchronize", "desynchronize"})), TuplesKt.to("coroutine", CollectionsKt.listOf((Object[]) new String[]{"create", "resume", "running", NotificationCompat.CATEGORY_STATUS, "wrap", "yield", "isyieldable", "close"})), TuplesKt.to("os", CollectionsKt.listOf((Object[]) new String[]{"time", "clock", "date", "difftime"})), TuplesKt.to("bit32", CollectionsKt.listOf((Object[]) new String[]{"band", "bor", "bxor", "bnot", "lshift", "rshift", "arshift", "btest", "extract", "replace", "lrotate", "rrotate", "countlz", "countrz"})), TuplesKt.to("utf8", CollectionsKt.listOf((Object[]) new String[]{"char", "charpattern", "codepoint", "codes", "len", TypedValues.CycleType.S_WAVE_OFFSET})), TuplesKt.to("debug", CollectionsKt.listOf((Object[]) new String[]{"traceback", "info", "profilebegin", "profileend"})), TuplesKt.to("buffer", CollectionsKt.listOf((Object[]) new String[]{"create", "fromstring", "tostring", "len", "readi8", "readu8", "readi32", "readu32", "readf32", "readf64", "writei8", "writeu8", "writei32", "writeu32", "writef32", "writef64", "readstring", "writestring", "copy", "fill"})));
    private static final Map<String, List<String>> dataStatics = MapsKt.mapOf(TuplesKt.to("Vector3", CollectionsKt.listOf((Object[]) new String[]{"new", "zero", "one", "xAxis", "yAxis", "zAxis", "FromNormalId", "FromAxis"})), TuplesKt.to("Vector2", CollectionsKt.listOf((Object[]) new String[]{"new", "zero", "one", "xAxis", "yAxis"})), TuplesKt.to("CFrame", CollectionsKt.listOf((Object[]) new String[]{"new", "Angles", "fromEulerAnglesXYZ", "fromEulerAnglesYXZ", "fromOrientation", "fromAxisAngle", "lookAt", "fromMatrix", "identity", "lookAlong"})), TuplesKt.to("Color3", CollectionsKt.listOf((Object[]) new String[]{"new", "fromRGB", "fromHSV", "fromHex"})), TuplesKt.to("UDim2", CollectionsKt.listOf((Object[]) new String[]{"new", "fromScale", "fromOffset"})), TuplesKt.to("UDim", CollectionsKt.listOf("new")), TuplesKt.to("BrickColor", CollectionsKt.listOf((Object[]) new String[]{"new", "random", "palette", "White", "Black", "Red", "Blue", "Green", "Yellow", "Gray", "DarkGray"})), TuplesKt.to("Instance", CollectionsKt.listOf((Object[]) new String[]{"new", "fromExisting"})), TuplesKt.to("TweenInfo", CollectionsKt.listOf("new")), TuplesKt.to("Ray", CollectionsKt.listOf("new")), TuplesKt.to("NumberRange", CollectionsKt.listOf("new")), TuplesKt.to("NumberSequence", CollectionsKt.listOf("new")), TuplesKt.to("ColorSequence", CollectionsKt.listOf("new")), TuplesKt.to("NumberSequenceKeypoint", CollectionsKt.listOf("new")), TuplesKt.to("ColorSequenceKeypoint", CollectionsKt.listOf("new")), TuplesKt.to("Random", CollectionsKt.listOf("new")), TuplesKt.to("Rect", CollectionsKt.listOf("new")), TuplesKt.to("Region3", CollectionsKt.listOf("new")), TuplesKt.to("RaycastParams", CollectionsKt.listOf("new")), TuplesKt.to("OverlapParams", CollectionsKt.listOf("new")), TuplesKt.to("DateTime", CollectionsKt.listOf((Object[]) new String[]{"now", "fromUnixTimestamp", "fromUnixTimestampMillis", "fromIsoDate", "fromLocalTime", "fromUniversalTime"})), TuplesKt.to("Font", CollectionsKt.listOf((Object[]) new String[]{"new", "fromEnum", "fromName", "fromId"})), TuplesKt.to("PhysicalProperties", CollectionsKt.listOf("new")), TuplesKt.to("Axes", CollectionsKt.listOf("new")), TuplesKt.to("Faces", CollectionsKt.listOf("new")));
    private static final Map<String, Pair<List<String>, List<String>>> dataMembers = MapsKt.mapOf(TuplesKt.to("Vector3", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"X", "Y", "Z", "Magnitude", "Unit"}), CollectionsKt.listOf((Object[]) new String[]{"Dot", "Cross", "Lerp", "FuzzyEq", "Abs", "Ceil", "Floor", "Sign", "Angle", "Max", "Min"}))), TuplesKt.to("Vector2", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"X", "Y", "Magnitude", "Unit"}), CollectionsKt.listOf((Object[]) new String[]{"Dot", "Cross", "Lerp", "FuzzyEq", "Abs", "Ceil", "Floor", "Sign", "Angle", "Max", "Min"}))), TuplesKt.to("CFrame", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"Position", "LookVector", "RightVector", "UpVector", "XVector", "YVector", "ZVector", "X", "Y", "Z", "Rotation"}), CollectionsKt.listOf((Object[]) new String[]{"Inverse", "Lerp", "Orthonormalize", "ToWorldSpace", "ToObjectSpace", "PointToWorldSpace", "PointToObjectSpace", "VectorToWorldSpace", "VectorToObjectSpace", "GetComponents", "ToEulerAnglesXYZ", "ToEulerAnglesYXZ", "ToOrientation", "ToAxisAngle", "FuzzyEq"}))), TuplesKt.to("Color3", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"R", "G", "B"}), CollectionsKt.listOf((Object[]) new String[]{"Lerp", "ToHSV", "ToHex"}))), TuplesKt.to("UDim2", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"X", "Y", "Width", "Height"}), CollectionsKt.listOf("Lerp"))), TuplesKt.to("UDim", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"Scale", "Offset"}), CollectionsKt.emptyList())), TuplesKt.to("BrickColor", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"Name", "Number", "Color", "r", "g", "b"}), CollectionsKt.emptyList())), TuplesKt.to("Random", TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new String[]{"NextNumber", "NextInteger", "NextUnitVector", "Shuffle", "Clone"}))), TuplesKt.to("RaycastParams", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"FilterDescendantsInstances", "FilterType", "IgnoreWater", "CollisionGroup", "RespectCanCollide", "BruteForceAllSlow"}), CollectionsKt.listOf("AddToFilter"))), TuplesKt.to("OverlapParams", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"FilterDescendantsInstances", "FilterType", "MaxParts", "CollisionGroup", "RespectCanCollide"}), CollectionsKt.listOf("AddToFilter"))), TuplesKt.to("Ray", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"Origin", "Direction", "Unit"}), CollectionsKt.listOf((Object[]) new String[]{"ClosestPoint", "Distance"}))), TuplesKt.to("TweenInfo", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"Time", "EasingStyle", "EasingDirection", "RepeatCount", "Reverses", "DelayTime"}), CollectionsKt.emptyList())), TuplesKt.to("RaycastResult", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"Instance", "Position", "Normal", "Material", "Distance"}), CollectionsKt.emptyList())), TuplesKt.to("Tween", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"PlaybackState", "TweenInfo", "Instance"}), CollectionsKt.listOf((Object[]) new String[]{"Play", "Pause", "Cancel"}))), TuplesKt.to("RBXScriptSignal", TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new String[]{"Connect", "Once", "Wait", "ConnectParallel"}))), TuplesKt.to("RBXScriptConnection", TuplesKt.to(CollectionsKt.listOf("Connected"), CollectionsKt.listOf("Disconnect"))), TuplesKt.to("AnimationTrack", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"IsPlaying", "Length", "Looped", "Priority", "Speed", "TimePosition", "WeightCurrent", "Animation"}), CollectionsKt.listOf((Object[]) new String[]{"Play", "Stop", "AdjustSpeed", "AdjustWeight", "GetMarkerReachedSignal", "GetTimeOfKeyframe"}))), TuplesKt.to("DataStore", TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new String[]{"GetAsync", "SetAsync", "UpdateAsync", "RemoveAsync", "IncrementAsync", "GetSortedAsync", "ListKeysAsync"}))), TuplesKt.to("Path", TuplesKt.to(CollectionsKt.listOf("Status"), CollectionsKt.listOf((Object[]) new String[]{"ComputeAsync", "GetWaypoints", "CheckOcclusionAsync"}))), TuplesKt.to("Mouse", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"Hit", "Target", "X", "Y", "Origin", "UnitRay", "Icon", "TargetFilter", "ViewSizeX", "ViewSizeY"}), CollectionsKt.emptyList())), TuplesKt.to("InputObject", TuplesKt.to(CollectionsKt.listOf((Object[]) new String[]{"UserInputType", "UserInputState", "KeyCode", "Position", "Delta"}), CollectionsKt.listOf("IsModifierKeyDown"))));
    private static final Map<String, Members> classMembers = MapsKt.mapOf(TuplesKt.to("Instance", INSTANCE.m("Name Parent ClassName Archivable", "FindFirstChild WaitForChild GetChildren GetDescendants Destroy Clone IsA FindFirstChildOfClass FindFirstChildWhichIsA FindFirstAncestor FindFirstAncestorOfClass FindFirstAncestorWhichIsA FindFirstDescendant GetAttribute SetAttribute GetAttributes GetAttributeChangedSignal GetPropertyChangedSignal ClearAllChildren GetFullName IsDescendantOf IsAncestorOf AddTag RemoveTag HasTag GetTags", "Changed ChildAdded ChildRemoved DescendantAdded DescendantRemoving AncestryChanged Destroying AttributeChanged")), TuplesKt.to("PVInstance", m$default(INSTANCE, "", "GetPivot PivotTo", null, 4, null)), TuplesKt.to("BasePart", INSTANCE.m("Position CFrame Size Orientation Rotation Anchored CanCollide CanTouch CanQuery Transparency Color BrickColor Material MaterialVariant Reflectance Locked Massless CastShadow CollisionGroup AssemblyLinearVelocity AssemblyAngularVelocity AssemblyMass AssemblyRootPart TopSurface BottomSurface FrontSurface BackSurface LeftSurface RightSurface", "GetMass ApplyImpulse ApplyAngularImpulse GetTouchingParts GetConnectedParts GetJoints BreakJoints SetNetworkOwner GetNetworkOwner GetRootPart GetVelocityAtPosition CanSetNetworkOwnership", "Touched TouchEnded")), TuplesKt.to("Part", m$default(INSTANCE, "Shape", null, null, 6, null)), TuplesKt.to("MeshPart", m$default(INSTANCE, "MeshId TextureID DoubleSided", null, null, 6, null)), TuplesKt.to("SpawnLocation", m$default(INSTANCE, "Enabled Neutral TeamColor Duration AllowTeamChangeOnTouch", null, null, 6, null)), TuplesKt.to("Seat", m$default(INSTANCE, "Disabled Occupant", "Sit", null, 4, null)), TuplesKt.to("VehicleSeat", m$default(INSTANCE, "Disabled Occupant MaxSpeed Torque Throttle Steer TurnSpeed", "Sit", null, 4, null)), TuplesKt.to("Model", m$default(INSTANCE, "PrimaryPart WorldPivot", "MoveTo GetBoundingBox GetExtentsSize ScaleTo GetScale TranslateBy SetPrimaryPartCFrame GetPrimaryPartCFrame", null, 4, null)), TuplesKt.to("Workspace", m$default(INSTANCE, "Gravity CurrentCamera FallenPartsDestroyHeight DistributedGameTime Terrain StreamingEnabled", "Raycast Blockcast Spherecast Shapecast GetPartBoundsInBox GetPartBoundsInRadius GetPartsInPart GetServerTimeNow GetRealPhysicsFPS FindPartOnRay", null, 4, null)), TuplesKt.to("Humanoid", INSTANCE.m("Health MaxHealth WalkSpeed JumpPower JumpHeight UseJumpPower HipHeight AutoRotate Sit Jump MoveDirection RootPart SeatPart DisplayName RigType FloorMaterial PlatformStand WalkToPoint NameDisplayDistance HealthDisplayType BreakJointsOnDeath", "TakeDamage MoveTo Move ChangeState GetState LoadAnimation EquipTool UnequipTools GetPlayingAnimationTracks SetStateEnabled GetStateEnabled ApplyDescription GetAppliedDescription AddAccessory GetAccessories", "Died HealthChanged Running Jumping StateChanged MoveToFinished FreeFalling Seated Climbing Touched")), TuplesKt.to("Players", INSTANCE.m("LocalPlayer MaxPlayers RespawnTime CharacterAutoLoads", "GetPlayers GetPlayerFromCharacter GetPlayerByUserId GetUserIdFromNameAsync GetNameFromUserIdAsync GetUserThumbnailAsync GetHumanoidDescriptionFromUserId", "PlayerAdded PlayerRemoving")), TuplesKt.to("Player", INSTANCE.m("Character UserId DisplayName Team TeamColor Neutral AccountAge MembershipType CameraMaxZoomDistance CameraMinZoomDistance CameraMode RespawnLocation PlayerGui Backpack PlayerScripts", "Kick LoadCharacter GetMouse IsInGroup GetRankInGroup GetRoleInGroup DistanceFromCharacter GetNetworkPing", "CharacterAdded CharacterRemoving CharacterAppearanceLoaded Chatted Idled")), TuplesKt.to("GuiObject", INSTANCE.m("Position Size AnchorPoint BackgroundColor3 BackgroundTransparency BorderColor3 BorderSizePixel Visible ZIndex LayoutOrder Rotation AbsolutePosition AbsoluteSize ClipsDescendants Active AutomaticSize SizeConstraint Selectable Interactable", "TweenPosition TweenSize TweenSizeAndPosition", "MouseEnter MouseLeave InputBegan InputEnded InputChanged")), TuplesKt.to("GuiButton", INSTANCE.m("AutoButtonColor Modal Selected", "", "MouseButton1Click MouseButton1Down MouseButton1Up MouseButton2Click Activated")), TuplesKt.to("TextLabel", m$default(INSTANCE, "Text TextColor3 TextSize TextScaled TextWrapped Font FontFace RichText TextXAlignment TextYAlignment TextTransparency TextStrokeColor3 TextStrokeTransparency TextTruncate LineHeight MaxVisibleGraphemes TextBounds", null, null, 6, null)), TuplesKt.to("TextButton", m$default(INSTANCE, "Text TextColor3 TextSize TextScaled TextWrapped Font FontFace RichText TextXAlignment TextYAlignment TextTransparency TextStrokeColor3 TextStrokeTransparency", null, null, 6, null)), TuplesKt.to("TextBox", INSTANCE.m("Text PlaceholderText PlaceholderColor3 ClearTextOnFocus MultiLine TextEditable TextColor3 TextSize TextScaled Font FontFace", "CaptureFocus ReleaseFocus IsFocused", "FocusLost Focused ReturnPressedFromOnScreenKeyboard")), TuplesKt.to("ImageLabel", m$default(INSTANCE, "Image ImageColor3 ImageTransparency ScaleType SliceCenter TileSize ImageRectOffset ImageRectSize ResampleMode", null, null, 6, null)), TuplesKt.to("ImageButton", m$default(INSTANCE, "Image ImageColor3 ImageTransparency HoverImage PressedImage ScaleType SliceCenter", null, null, 6, null)), TuplesKt.to("ScrollingFrame", m$default(INSTANCE, "CanvasSize CanvasPosition AutomaticCanvasSize ScrollBarThickness ScrollingEnabled ScrollingDirection ScrollBarImageColor3 ElasticBehavior", null, null, 6, null)), TuplesKt.to("ScreenGui", m$default(INSTANCE, "Enabled ResetOnSpawn IgnoreGuiInset DisplayOrder ZIndexBehavior ScreenInsets", null, null, 6, null)), TuplesKt.to("BillboardGui", m$default(INSTANCE, "Adornee Size StudsOffset StudsOffsetWorldSpace MaxDistance AlwaysOnTop Enabled LightInfluence", null, null, 6, null)), TuplesKt.to("SurfaceGui", m$default(INSTANCE, "Adornee Face CanvasSize PixelsPerStud SizingMode AlwaysOnTop LightInfluence Enabled", null, null, 6, null)), TuplesKt.to("UICorner", m$default(INSTANCE, "CornerRadius", null, null, 6, null)), TuplesKt.to("UIStroke", m$default(INSTANCE, "Color Thickness Transparency ApplyStrokeMode LineJoinMode Enabled", null, null, 6, null)), TuplesKt.to("UIListLayout", m$default(INSTANCE, "FillDirection HorizontalAlignment VerticalAlignment Padding SortOrder Wraps", null, null, 6, null)), TuplesKt.to("UIGridLayout", m$default(INSTANCE, "CellSize CellPadding FillDirection SortOrder FillDirectionMaxCells", null, null, 6, null)), TuplesKt.to("UIPadding", m$default(INSTANCE, "PaddingTop PaddingBottom PaddingLeft PaddingRight", null, null, 6, null)), TuplesKt.to("UIGradient", m$default(INSTANCE, "Color Transparency Rotation Offset Enabled", null, null, 6, null)), TuplesKt.to("UIScale", m$default(INSTANCE, "Scale", null, null, 6, null)), TuplesKt.to("RunService", INSTANCE.m("", "IsStudio IsServer IsClient IsRunning IsEdit IsRunMode BindToRenderStep UnbindFromRenderStep", "Heartbeat RenderStepped Stepped PreSimulation PostSimulation PreRender PreAnimation")), TuplesKt.to("TweenService", m$default(INSTANCE, "", "Create GetValue", null, 4, null)), TuplesKt.to("UserInputService", INSTANCE.m("TouchEnabled KeyboardEnabled MouseEnabled GamepadEnabled MouseBehavior MouseIconEnabled ModalEnabled", "IsKeyDown IsMouseButtonPressed GetMouseLocation GetFocusedTextBox GetKeysPressed GetLastInputType GetConnectedGamepads", "InputBegan InputEnded InputChanged TouchTap TouchStarted TouchEnded TouchMoved JumpRequest LastInputTypeChanged TouchTapInWorld")), TuplesKt.to("ContextActionService", m$default(INSTANCE, "", "BindAction BindActionAtPriority UnbindAction UnbindAllActions SetTitle SetImage SetPosition SetDescription GetButton", null, 4, null)), TuplesKt.to("DataStoreService", m$default(INSTANCE, "", "GetDataStore GetOrderedDataStore GetGlobalDataStore", null, 4, null)), TuplesKt.to("HttpService", m$default(INSTANCE, "HttpEnabled", "JSONEncode JSONDecode GenerateGUID GetAsync PostAsync RequestAsync UrlEncode", null, 4, null)), TuplesKt.to("MarketplaceService", INSTANCE.m("ProcessReceipt", "PromptPurchase PromptGamePassPurchase PromptProductPurchase UserOwnsGamePassAsync PlayerOwnsAsset GetProductInfo", "PromptGamePassPurchaseFinished PromptPurchaseFinished PromptProductPurchaseFinished")), TuplesKt.to("CollectionService", m$default(INSTANCE, "", "GetTagged AddTag RemoveTag HasTag GetTags GetAllTags GetInstanceAddedSignal GetInstanceRemovedSignal", null, 4, null)), TuplesKt.to("Debris", m$default(INSTANCE, "", "AddItem", null, 4, null)), TuplesKt.to("PathfindingService", m$default(INSTANCE, "", "CreatePath FindPathAsync", null, 4, null)), TuplesKt.to("StarterGui", m$default(INSTANCE, "ShowDevelopmentGui", "SetCore GetCore SetCoreGuiEnabled GetCoreGuiEnabled", null, 4, null)), TuplesKt.to("Lighting", m$default(INSTANCE, "ClockTime TimeOfDay Brightness Ambient OutdoorAmbient FogEnd FogStart FogColor GlobalShadows ExposureCompensation GeographicLatitude Technology", "GetMinutesAfterMidnight SetMinutesAfterMidnight GetSunDirection GetMoonDirection", null, 4, null)), TuplesKt.to("Camera", m$default(INSTANCE, "CFrame Focus FieldOfView CameraType CameraSubject ViewportSize NearPlaneZ", "WorldToScreenPoint WorldToViewportPoint ScreenPointToRay ViewportPointToRay GetPartsObscuringTarget", null, 4, null)), TuplesKt.to("Tool", INSTANCE.m("Handle RequiresHandle CanBeDropped ToolTip Grip Enabled ManualActivationOnly TextureId", "Activate Deactivate", "Activated Deactivated Equipped Unequipped")), TuplesKt.to("ValueBase", INSTANCE.m("Value", "", "Changed")), TuplesKt.to("Sound", INSTANCE.m("SoundId Volume Looped Playing PlaybackSpeed TimePosition TimeLength IsPlaying RollOffMaxDistance SoundGroup", "Play Stop Pause Resume", "Ended Played Paused Resumed Loaded DidLoop")), TuplesKt.to("ClickDetector", INSTANCE.m("MaxActivationDistance CursorIcon", "", "MouseClick RightMouseClick MouseHoverEnter MouseHoverLeave")), TuplesKt.to("ProximityPrompt", INSTANCE.m("ActionText ObjectText HoldDuration MaxActivationDistance KeyboardKeyCode GamepadKeyCode Enabled RequiresLineOfSight Style", "InputHoldBegin InputHoldEnd", "Triggered TriggerEnded PromptShown PromptHidden PromptButtonHoldBegan PromptButtonHoldEnded")), TuplesKt.to("RemoteEvent", INSTANCE.m("", "FireServer FireClient FireAllClients", "OnServerEvent OnClientEvent")), TuplesKt.to("UnreliableRemoteEvent", INSTANCE.m("", "FireServer FireClient FireAllClients", "OnServerEvent OnClientEvent")), TuplesKt.to("RemoteFunction", m$default(INSTANCE, "OnServerInvoke OnClientInvoke", "InvokeServer InvokeClient", null, 4, null)), TuplesKt.to("BindableEvent", INSTANCE.m("", "Fire", "Event")), TuplesKt.to("BindableFunction", m$default(INSTANCE, "OnInvoke", "Invoke", null, 4, null)), TuplesKt.to("Animator", m$default(INSTANCE, "", "LoadAnimation GetPlayingAnimationTracks", null, 4, null)), TuplesKt.to("Animation", m$default(INSTANCE, "AnimationId", null, null, 6, null)), TuplesKt.to("Teams", m$default(INSTANCE, "", "GetTeams", null, 4, null)), TuplesKt.to("Team", INSTANCE.m("TeamColor AutoAssignable", "GetPlayers", "PlayerAdded PlayerRemoved")), TuplesKt.to("TextChatService", INSTANCE.m("ChatVersion", "", "MessageReceived OnIncomingMessage SendingMessage")), TuplesKt.to("TextChannel", INSTANCE.m("", "SendAsync DisplaySystemMessage", "MessageReceived")), TuplesKt.to("Light", m$default(INSTANCE, "Brightness Color Enabled Range Shadows", null, null, 6, null)), TuplesKt.to("SpotLight", m$default(INSTANCE, "Angle Face", null, null, 6, null)), TuplesKt.to("ParticleEmitter", m$default(INSTANCE, "Rate Enabled Lifetime Speed Color Size Transparency Texture SpreadAngle Acceleration Drag LightEmission", "Emit Clear", null, 4, null)), TuplesKt.to("Attachment", m$default(INSTANCE, "CFrame Position Orientation WorldCFrame WorldPosition Axis SecondaryAxis Visible", null, null, 6, null)), TuplesKt.to("Weld", m$default(INSTANCE, "Part0 Part1 C0 C1 Enabled", null, null, 6, null)), TuplesKt.to("Motor6D", m$default(INSTANCE, "Part0 Part1 C0 C1 Transform CurrentAngle DesiredAngle MaxVelocity", null, null, 6, null)), TuplesKt.to("WeldConstraint", m$default(INSTANCE, "Part0 Part1 Enabled", null, null, 6, null)), TuplesKt.to("Decal", m$default(INSTANCE, "Texture Color3 Transparency Face ZIndex", null, null, 6, null)), TuplesKt.to("Texture", m$default(INSTANCE, "StudsPerTileU StudsPerTileV OffsetStudsU OffsetStudsV", null, null, 6, null)), TuplesKt.to("SpecialMesh", m$default(INSTANCE, "MeshType MeshId TextureId Scale Offset VertexColor", null, null, 6, null)), TuplesKt.to("Highlight", m$default(INSTANCE, "Adornee FillColor FillTransparency OutlineColor OutlineTransparency DepthMode Enabled", null, null, 6, null)), TuplesKt.to("BadgeService", m$default(INSTANCE, "", "AwardBadge UserHasBadgeAsync GetBadgeInfoAsync", null, 4, null)), TuplesKt.to("TeleportService", m$default(INSTANCE, "", "Teleport TeleportAsync TeleportToPlaceInstance", null, 4, null)), TuplesKt.to("SoundService", m$default(INSTANCE, "AmbientReverb RespectFilteringEnabled", "PlayLocalSound", null, 4, null)), TuplesKt.to("PlayerGui", m$default(INSTANCE, "ScreenOrientation SelectionImageObject", "SetTopbarTransparency GetGuiObjectsAtPosition", null, 4, null)), TuplesKt.to("Backpack", m$default(INSTANCE, "", null, null, 6, null)), TuplesKt.to("StarterPlayer", m$default(INSTANCE, "CameraMaxZoomDistance CameraMinZoomDistance CameraMode EnableMouseLockOption CharacterWalkSpeed CharacterJumpPower CharacterUseJumpPower DevTouchMovementMode", null, null, 6, null)), TuplesKt.to("GuiService", m$default(INSTANCE, "MenuIsOpen", "GetGuiInset IsTenFootInterface", null, 4, null)));
    private static final Map<String, String> propTypes = MapsKt.mapOf(TuplesKt.to("LocalPlayer", "Player"), TuplesKt.to("Character", "Model"), TuplesKt.to("PlayerGui", "PlayerGui"), TuplesKt.to("Backpack", "Backpack"), TuplesKt.to("PlayerScripts", "PlayerScripts"), TuplesKt.to("CurrentCamera", "Camera"), TuplesKt.to("Terrain", "Terrain"), TuplesKt.to("PrimaryPart", "BasePart"), TuplesKt.to("RootPart", "BasePart"), TuplesKt.to("Humanoid", "Humanoid"), TuplesKt.to("HumanoidRootPart", "BasePart"), TuplesKt.to("Head", "BasePart"), TuplesKt.to("Torso", "BasePart"), TuplesKt.to("Handle", "BasePart"), TuplesKt.to("Adornee", "Instance"), TuplesKt.to("Team", "Team"), TuplesKt.to("Position", "#Vector3"), TuplesKt.to("Size", "#Vector3"), TuplesKt.to("Orientation", "#Vector3"), TuplesKt.to("CFrame", "#CFrame"), TuplesKt.to("Color", "#Color3"), TuplesKt.to("Velocity", "#Vector3"), TuplesKt.to("AssemblyLinearVelocity", "#Vector3"), TuplesKt.to("LookVector", "#Vector3"), TuplesKt.to("RightVector", "#Vector3"), TuplesKt.to("UpVector", "#Vector3"), TuplesKt.to("Unit", "#Vector3"), TuplesKt.to("BackgroundColor3", "#Color3"), TuplesKt.to("TextColor3", "#Color3"), TuplesKt.to("AbsolutePosition", "#Vector2"), TuplesKt.to("AbsoluteSize", "#Vector2"), TuplesKt.to("MoveDirection", "#Vector3"), TuplesKt.to("Focus", "#CFrame"), TuplesKt.to("WorldPivot", "#CFrame"), TuplesKt.to("C0", "#CFrame"), TuplesKt.to("C1", "#CFrame"), TuplesKt.to("BrickColor", "#BrickColor"), TuplesKt.to("Hit", "#CFrame"), TuplesKt.to("Target", "BasePart"), TuplesKt.to("Occupant", "Humanoid"), TuplesKt.to("SeatPart", "BasePart"), TuplesKt.to("Parent", "Instance"));
    private static final Map<String, String> methodReturns = MapsKt.mapOf(TuplesKt.to("GetMouse", "#Mouse"), TuplesKt.to("LoadAnimation", "#AnimationTrack"), TuplesKt.to("Create", "#Tween"), TuplesKt.to("GetDataStore", "#DataStore"), TuplesKt.to("GetOrderedDataStore", "#DataStore"), TuplesKt.to("CreatePath", "#Path"), TuplesKt.to("Raycast", "#RaycastResult"), TuplesKt.to("GetPivot", "#CFrame"), TuplesKt.to("Clone", "@self"), TuplesKt.to("GetPlayerFromCharacter", "Player"), TuplesKt.to("FindFirstAncestorOfClass", "@arg"), TuplesKt.to("FindFirstChildOfClass", "@arg"), TuplesKt.to("FindFirstChildWhichIsA", "@arg"), TuplesKt.to("FindFirstAncestorWhichIsA", "@arg"), TuplesKt.to("GetPropertyChangedSignal", "#RBXScriptSignal"), TuplesKt.to("GetAttributeChangedSignal", "#RBXScriptSignal"), TuplesKt.to("GetInstanceAddedSignal", "#RBXScriptSignal"), TuplesKt.to("Connect", "#RBXScriptConnection"), TuplesKt.to("Once", "#RBXScriptConnection"));
    private static final Map<String, String> nameHints = MapsKt.mapOf(TuplesKt.to("player", "Player"), TuplesKt.to("plr", "Player"), TuplesKt.to("localplayer", "Player"), TuplesKt.to("character", "Model"), TuplesKt.to("char", "Model"), TuplesKt.to("humanoid", "Humanoid"), TuplesKt.to("hum", "Humanoid"), TuplesKt.to("hit", "BasePart"), TuplesKt.to("part", "BasePart"), TuplesKt.to("otherpart", "BasePart"), TuplesKt.to("root", "BasePart"), TuplesKt.to("hrp", "BasePart"), TuplesKt.to("rootpart", "BasePart"), TuplesKt.to("tool", "Tool"), TuplesKt.to("camera", "Camera"), TuplesKt.to("cam", "Camera"), TuplesKt.to("mouse", "#Mouse"), TuplesKt.to("input", "#InputObject"), TuplesKt.to("gui", "ScreenGui"), TuplesKt.to("button", "TextButton"), TuplesKt.to(TypedValues.AttributesType.S_FRAME, "Frame"), TuplesKt.to("label", "TextLabel"), TuplesKt.to("textbox", "TextBox"), TuplesKt.to("sound", "Sound"), TuplesKt.to("remote", "RemoteEvent"), TuplesKt.to(NotificationCompat.CATEGORY_EVENT, "RemoteEvent"), TuplesKt.to("animator", "Animator"), TuplesKt.to("track", "#AnimationTrack"), TuplesKt.to("tween", "#Tween"), TuplesKt.to("model", "Model"), TuplesKt.to("folder", "Folder"), TuplesKt.to("leaderstats", "Folder"));
    private static final List<String> extraEnums = CollectionsKt.listOf((Object[]) new String[]{"KeyCode", "UserInputType", "Material", "EasingStyle", "EasingDirection", "HumanoidStateType", "PartType", "SurfaceType", "Font", "NormalId", "CameraType", "RaycastFilterType", "CoreGuiType", "SortOrder", "FillDirection", "HorizontalAlignment", "VerticalAlignment", "TextXAlignment", "TextYAlignment", "AutomaticSize", "ScaleType", "ZIndexBehavior", "PlaybackState", "AnimationPriority", "ContextActionResult"});

    /* compiled from: Autocomplete.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Item;", "", "label", "", "kind", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Kind;", "detail", "insert", "<init>", "(Ljava/lang/String;Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Kind;Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getKind", "()Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Kind;", "getDetail", "getInsert", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Item {
        private final String detail;
        private final String insert;
        private final Kind kind;
        private final String label;

        public Item(String label, Kind kind, String detail, String insert) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(detail, "detail");
            Intrinsics.checkNotNullParameter(insert, "insert");
            this.label = label;
            this.kind = kind;
            this.detail = detail;
            this.insert = insert;
        }

        public /* synthetic */ Item(String str, Kind kind, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, kind, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? str : str3);
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getInsert() {
            return this.insert;
        }

        public final Kind getKind() {
            return this.kind;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* compiled from: Autocomplete.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Kind;", "", "badge", "", TypedValues.Custom.S_COLOR, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getBadge", "()Ljava/lang/String;", "getColor", "()I", "KEYWORD", "GLOBAL", "LIBRARY", "FUNCTION", "METHOD", "PROPERTY", "EVENT", "CLASS", "ENUM", "SERVICE", "VARIABLE", "CHILD", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Kind {
        KEYWORD("kw", -496260),
        GLOBAL("g", -8071433),
        LIBRARY("lib", -8071433),
        FUNCTION("fn", -132195),
        METHOD("m", -132195),
        PROPERTY("p", -6497026),
        EVENT("ev", -14848),
        CLASS("c", -11613776),
        ENUM("e", -4862296),
        SERVICE("s", -11613776),
        VARIABLE("v", -3355444),
        CHILD("ch", -2302806);

        private final String badge;
        private final int color;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        Kind(String str, int i) {
            this.badge = str;
            this.color = i;
        }

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }

        public final String getBadge() {
            return this.badge;
        }

        public final int getColor() {
            return this.color;
        }
    }

    /* compiled from: Autocomplete.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Members;", "", "props", "", "", "methods", "events", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getProps", "()Ljava/util/List;", "getMethods", "getEvents", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Members {
        private final List<String> events;
        private final List<String> methods;
        private final List<String> props;

        public Members(List<String> props, List<String> methods, List<String> events) {
            Intrinsics.checkNotNullParameter(props, "props");
            Intrinsics.checkNotNullParameter(methods, "methods");
            Intrinsics.checkNotNullParameter(events, "events");
            this.props = props;
            this.methods = methods;
            this.events = events;
        }

        public final List<String> getEvents() {
            return this.events;
        }

        public final List<String> getMethods() {
            return this.methods;
        }

        public final List<String> getProps() {
            return this.props;
        }
    }

    /* compiled from: Autocomplete.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Result;", "", "start", "", "end", "prefix", "", "items", "", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Item;", "<init>", "(IILjava/lang/String;Ljava/util/List;)V", "getStart", "()I", "getEnd", "getPrefix", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Result {
        private final int end;
        private final List<Item> items;
        private final String prefix;
        private final int start;

        public Result(int i, int i2, String prefix, List<Item> items) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(items, "items");
            this.start = i;
            this.end = i2;
            this.prefix = prefix;
            this.items = items;
        }

        public final int getEnd() {
            return this.end;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final int getStart() {
            return this.start;
        }
    }

    /* compiled from: Autocomplete.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$Step;", "", "name", "", "acc", "", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_ARG, NotificationCompat.CATEGORY_CALL, "", "<init>", "(Ljava/lang/String;CLjava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getAcc", "()C", "getArg", "getCall", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Step {
        private final char acc;
        private final String arg;
        private final boolean call;
        private final String name;

        public Step(String name, char c, String str, boolean z) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.acc = c;
            this.arg = str;
            this.call = z;
        }

        public final char getAcc() {
            return this.acc;
        }

        public final String getArg() {
            return this.arg;
        }

        public final boolean getCall() {
            return this.call;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: Autocomplete.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "", "<init>", "()V", "Inst", "Cls", "Lib", "DataStatic", "Data", "EnumRoot", "EnumType", "Signal", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Cls;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Data;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$DataStatic;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$EnumRoot;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$EnumType;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Inst;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Lib;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Signal;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static abstract class T {

        /* compiled from: Autocomplete.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Cls;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Cls extends T {
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Cls(String name) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* compiled from: Autocomplete.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Data;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Data extends T {
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Data(String name) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* compiled from: Autocomplete.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$DataStatic;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class DataStatic extends T {
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DataStatic(String name) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* compiled from: Autocomplete.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$EnumRoot;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "<init>", "()V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class EnumRoot extends T {
            public static final EnumRoot INSTANCE = new EnumRoot();

            private EnumRoot() {
                super(null);
            }
        }

        /* compiled from: Autocomplete.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$EnumType;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class EnumType extends T {
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnumType(String name) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* compiled from: Autocomplete.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Inst;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "i", "Lcom/exampletest/mobilestudiotest/model/Instance;", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;)V", "getI", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Inst extends T {
            private final Instance i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Inst(Instance i) {
                super(null);
                Intrinsics.checkNotNullParameter(i, "i");
                this.i = i;
            }

            public final Instance getI() {
                return this.i;
            }
        }

        /* compiled from: Autocomplete.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Lib;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Lib extends T {
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Lib(String name) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* compiled from: Autocomplete.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T$Signal;", "Lcom/exampletest/mobilestudiotest/ui/Autocomplete$T;", "<init>", "()V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Signal extends T {
            public static final Signal INSTANCE = new Signal();

            private Signal() {
                super(null);
            }
        }

        private T() {
        }

        public /* synthetic */ T(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Autocomplete() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0181, code lost:
    
        if (r2.isEmpty() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:?, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0189, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016e, code lost:
    
        if (r2.isEmpty() == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0176, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.exampletest.mobilestudiotest.ui.Autocomplete.Step> chainBefore(java.lang.String r18, int r19) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Autocomplete.chainBefore(java.lang.String, int):java.util.List");
    }

    private final List<String> classChain(String cls) {
        ArrayList arrayList = new ArrayList();
        String str = cls;
        int i = 0;
        while (str != null) {
            int i2 = i + 1;
            if (i < 15) {
                arrayList.add(str);
                if (!Intrinsics.areEqual(str, "Instance")) {
                    str = ClassDb.INSTANCE.superclass(str);
                    i = i2;
                }
            }
        }
        if (!arrayList.contains("Instance")) {
            arrayList.add("Instance");
        }
        return arrayList;
    }

    private final String clsOf(T t) {
        if (t instanceof T.Inst) {
            return ((T.Inst) t).getI().getClassName();
        }
        if (t instanceof T.Cls) {
            return ((T.Cls) t).getName();
        }
        return null;
    }

    public static /* synthetic */ Result complete$default(Autocomplete autocomplete, Studio studio, Instance instance, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        return autocomplete.complete(studio, instance, str, i, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0098, code lost:
    
        if (r0.equals("SetAttribute") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00f9, code lost:
    
        if (r2 == ':') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00fb, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00fc, code lost:
    
        r0 = chainBefore(r30, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0100, code lost:
    
        if (r0 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0102, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0103, code lost:
    
        r11 = r28.getLock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0108, code lost:
    
        monitor-enter(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x010d, code lost:
    
        r12 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0116, code lost:
    
        r2 = com.exampletest.mobilestudiotest.ui.Autocomplete.INSTANCE.resolveSteps(r0, r28, r29, r30, r7, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x011a, code lost:
    
        monitor-exit(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x011d, code lost:
    
        if ((r2 instanceof com.exampletest.mobilestudiotest.ui.Autocomplete.T.Inst) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x011f, code lost:
    
        r4 = r28.getLock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0123, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0125, code lost:
    
        r5 = ((com.exampletest.mobilestudiotest.ui.Autocomplete.T.Inst) r2).getI().getAttributes().keySet();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "<get-keys>(...)");
        r11 = r5.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0144, code lost:
    
        if (r11.hasNext() == false) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0146, code lost:
    
        r18 = (java.lang.String) r11.next();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r18);
        r12.add(new com.exampletest.mobilestudiotest.ui.Autocomplete.Item(r18, com.exampletest.mobilestudiotest.ui.Autocomplete.Kind.PROPERTY, "attribute", null, 8, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x016c, code lost:
    
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0170, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0179, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0180, code lost:
    
        monitor-exit(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0181, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x017b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00a1, code lost:
    
        if (r0.equals("FindFirstDescendant") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x00ae, code lost:
    
        if (r0.equals("GetService") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00b9, code lost:
    
        r5 = getServiceList().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00c8, code lost:
    
        if (r5.hasNext() == false) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x00ca, code lost:
    
        r0.add(new com.exampletest.mobilestudiotest.ui.Autocomplete.Item((java.lang.String) r5.next(), com.exampletest.mobilestudiotest.ui.Autocomplete.Kind.SERVICE, androidx.core.app.NotificationCompat.CATEGORY_SERVICE, null, 8, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x00e9, code lost:
    
        r12 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00b7, code lost:
    
        if (r0.equals("FindService") != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x00f3, code lost:
    
        if (r0.equals("GetAttribute") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
    
        if (r0.equals("FindFirstChild") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a3, code lost:
    
        r13 = r2;
        r0 = 2;
        r12 = r0;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x0082. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x023f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0448 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x044a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.ui.Autocomplete.Result completeString(com.exampletest.mobilestudiotest.core.Studio r28, com.exampletest.mobilestudiotest.model.Instance r29, java.lang.String r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Autocomplete.completeString(com.exampletest.mobilestudiotest.core.Studio, com.exampletest.mobilestudiotest.model.Instance, java.lang.String, int, int):com.exampletest.mobilestudiotest.ui.Autocomplete$Result");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance completeString$lambda$71$lambda$67(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getParent();
    }

    private final List<String> getServiceList() {
        return CollectionsKt.sorted(CollectionsKt.distinct(CollectionsKt.plus((Collection) ClassDb.INSTANCE.getServiceNames(), (Iterable) CollectionsKt.listOf((Object[]) new String[]{"RunService", "TweenService", "Debris", "HttpService", "UserInputService", "ContextActionService", "CollectionService", "MarketplaceService", "DataStoreService", "PathfindingService", "TextService", "GuiService", "BadgeService", "PhysicsService", "InsertService", "TeleportService", "ProximityPromptService", "MessagingService", "MemoryStoreService", "AssetService", "SocialService", "PolicyService", "HapticService", "VRService", "GroupService", "Selection", "ChangeHistoryService", "StudioService"}))));
    }

    private final boolean isId(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }

    private final boolean isSimpleName(String s) {
        boolean z;
        if ((s.length() > 0) && (Character.isLetter(s.charAt(0)) || s.charAt(0) == '_')) {
            String str = s;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                if (!INSTANCE.isId(str.charAt(i))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x010b, code lost:
    
        return kotlin.TuplesKt.to(1, java.lang.Integer.valueOf(r7));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> lexState(java.lang.String r20, int r21) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Autocomplete.lexState(java.lang.String, int):kotlin.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Set<java.lang.String> localNames(java.lang.String r28, int r29) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Autocomplete.localNames(java.lang.String, int):java.util.Set");
    }

    private final int longLevel(String text, int at) {
        if (at >= text.length() || text.charAt(at) != '[') {
            return -1;
        }
        int i = at + 1;
        int i2 = 0;
        while (i < text.length() && text.charAt(i) == '=') {
            i2++;
            i++;
        }
        if (i >= text.length() || text.charAt(i) != '[') {
            return -1;
        }
        return i2;
    }

    private final Members m(String props, String methods, String events) {
        List split$default = StringsKt.split$default((CharSequence) props, new char[]{' '}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        List split$default2 = StringsKt.split$default((CharSequence) methods, new char[]{' '}, false, 0, 6, (Object) null);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : split$default2) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = arrayList3;
        List split$default3 = StringsKt.split$default((CharSequence) events, new char[]{' '}, false, 0, 6, (Object) null);
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : split$default3) {
            if (!StringsKt.isBlank((String) obj3)) {
                arrayList5.add(obj3);
            }
        }
        return new Members(arrayList2, arrayList4, arrayList5);
    }

    static /* synthetic */ Members m$default(Autocomplete autocomplete, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        return autocomplete.m(str, str2, str3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01fb, code lost:
    
        return new com.exampletest.mobilestudiotest.ui.Autocomplete.T.Inst(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01fc, code lost:
    
        r2 = com.exampletest.mobilestudiotest.ui.Autocomplete.propTypes.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0204, code lost:
    
        if (r2 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x020d, code lost:
    
        return com.exampletest.mobilestudiotest.ui.Autocomplete.INSTANCE.typeFromHint(r2, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0215, code lost:
    
        return new com.exampletest.mobilestudiotest.ui.Autocomplete.T.Cls("Instance");
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0190, code lost:
    
        if (r1.equals("FindFirstDescendant") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0199, code lost:
    
        if (r1.equals("GetService") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01a4, code lost:
    
        r1 = r14.getArg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a8, code lost:
    
        if (r1 == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01aa, code lost:
    
        r4 = r15.getModel();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.model.DataModel");
        r4 = r4.findService(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01b8, code lost:
    
        if (r4 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:?, code lost:
    
        return new com.exampletest.mobilestudiotest.ui.Autocomplete.T.Inst(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01cb, code lost:
    
        return new com.exampletest.mobilestudiotest.ui.Autocomplete.T.Cls(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01a2, code lost:
    
        if (r1.equals("FindService") != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01d2, code lost:
    
        if (r1.equals("WaitForChild") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0189, code lost:
    
        if (r1.equals("FindFirstChild") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d5, code lost:
    
        r1 = r14.getArg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d9, code lost:
    
        if (r1 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e2, code lost:
    
        return new com.exampletest.mobilestudiotest.ui.Autocomplete.T.Cls("Instance");
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e3, code lost:
    
        if (r3 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e5, code lost:
    
        r2 = r3.findFirstChild(r1, kotlin.jvm.internal.Intrinsics.areEqual(r14.getName(), "FindFirstDescendant"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f1, code lost:
    
        if (r2 == null) goto L118;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:90:0x017f. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.ui.Autocomplete.T member(com.exampletest.mobilestudiotest.ui.Autocomplete.T r13, com.exampletest.mobilestudiotest.ui.Autocomplete.Step r14, com.exampletest.mobilestudiotest.core.Studio r15) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Autocomplete.member(com.exampletest.mobilestudiotest.ui.Autocomplete$T, com.exampletest.mobilestudiotest.ui.Autocomplete$Step, com.exampletest.mobilestudiotest.core.Studio):com.exampletest.mobilestudiotest.ui.Autocomplete$T");
    }

    private final Triple<Set<String>, Set<String>, Set<String>> membersFor(String cls) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        Iterator<String> it = classChain(cls).iterator();
        while (it.hasNext()) {
            Members members = classMembers.get(it.next());
            if (members != null) {
                linkedHashSet.addAll(members.getProps());
                linkedHashSet2.addAll(members.getMethods());
                linkedHashSet3.addAll(members.getEvents());
            }
        }
        return new Triple<>(linkedHashSet, linkedHashSet2, linkedHashSet3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if (r11.equals("charpattern") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
    
        r12 = com.exampletest.mobilestudiotest.ui.Autocomplete.Kind.PROPERTY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        if (r11.equals("huge") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if (r11.equals("pi") == false) goto L22;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x044b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.exampletest.mobilestudiotest.ui.Autocomplete.Item> membersOf(com.exampletest.mobilestudiotest.ui.Autocomplete.T r29, char r30) {
        /*
            Method dump skipped, instructions count: 1300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Autocomplete.membersOf(com.exampletest.mobilestudiotest.ui.Autocomplete$T, char):java.util.List");
    }

    private final List<Item> rank(List<Item> items, String prefix) {
        if (!(prefix.length() == 0)) {
            String lowerCase = prefix.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return SequencesKt.toList(SequencesKt.take(SequencesKt.sortedWith(SequencesKt.distinctBy(SequencesKt.filter(CollectionsKt.asSequence(items), new Autocomplete$$ExternalSyntheticLambda0(lowerCase, prefix)), new Autocomplete$$ExternalSyntheticLambda1()), ComparisonsKt.compareBy(new Autocomplete$$ExternalSyntheticLambda2(prefix, lowerCase), new Autocomplete$$ExternalSyntheticLambda3(), new Autocomplete$$ExternalSyntheticLambda4())), 40));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (hashSet.add(((Item) obj).getLabel())) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.take(arrayList, 60);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean rank$lambda$32(String str, String str2, Item it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.getLabel().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str, false, 2, (Object) null) && !Intrinsics.areEqual(it.getLabel(), str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String rank$lambda$33(Item it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLabel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable rank$lambda$34(String str, String str2, Item it) {
        int i;
        Intrinsics.checkNotNullParameter(it, "it");
        if (StringsKt.startsWith$default(it.getLabel(), str, false, 2, (Object) null)) {
            i = 0;
        } else {
            String lowerCase = it.getLabel().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            i = StringsKt.startsWith$default(lowerCase, str2, false, 2, (Object) null) ? 1 : 2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable rank$lambda$35(Item it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(it.getLabel().length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable rank$lambda$36(Item it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLabel();
    }

    private final T resolveExpr(String expr, Studio studio, Instance script, int depth) {
        String obj = StringsKt.trim((CharSequence) expr).toString();
        MatchResult find$default = Regex.find$default(new Regex("^(\\w+)\\.new\\s*\\("), obj, 0, 2, null);
        if (find$default != null) {
            String str = find$default.getGroupValues().get(1);
            if (Intrinsics.areEqual(str, "Instance")) {
                MatchResult find$default2 = Regex.find$default(new Regex("Instance\\.new\\s*\\(\\s*[\"'](\\w+)[\"']"), obj, 0, 2, null);
                if (find$default2 != null) {
                    return new T.Cls(find$default2.getGroupValues().get(1));
                }
            } else if (dataStatics.containsKey(str)) {
                return new T.Data(str);
            }
        }
        MatchResult find$default3 = Regex.find$default(new Regex("^(\\w+)\\.(fromRGB|fromHSV|fromHex|Angles|lookAt|fromOrientation|fromScale|fromOffset)\\b"), obj, 0, 2, null);
        if (find$default3 != null) {
            return new T.Data(find$default3.getGroupValues().get(1));
        }
        List<Step> chainBefore = chainBefore(obj + " ", obj.length());
        if (chainBefore == null) {
            return null;
        }
        return resolveSteps(chainBefore, studio, script, obj, obj.length(), depth);
    }

    private final T resolveLocal(String name, Studio studio, Instance script, String text, int before, int depth) {
        T resolveExpr;
        if (depth > 3) {
            return null;
        }
        Regex regex = new Regex("(?:^|[\\s;(])local\\s+" + Regex.INSTANCE.escape(name) + "\\s*(?::\\s*[\\w.<>]+\\s*)?=\\s*([^\\n;]+)");
        String substring = text.substring(0, Math.min(before, text.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        MatchResult matchResult = (MatchResult) SequencesKt.lastOrNull(Regex.findAll$default(regex, substring, 0, 2, null));
        if (matchResult != null && (resolveExpr = resolveExpr(StringsKt.removeSuffix(StringsKt.trim((CharSequence) matchResult.getGroupValues().get(1)).toString(), (CharSequence) ","), studio, script, depth + 1)) != null) {
            return resolveExpr;
        }
        Map<String, String> map = nameHints;
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = map.get(lowerCase);
        if (str != null) {
            return INSTANCE.typeFromHint(str, studio);
        }
        if (!ClassDb.INSTANCE.isServiceName(name)) {
            return null;
        }
        Instance findService = studio.getModel().findService(name);
        return findService != null ? new T.Inst(findService) : new T.Cls(name);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (r4.equals("Workspace") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r4.equals("workspace") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return new com.exampletest.mobilestudiotest.ui.Autocomplete.T.Inst(r0.getWorkspace());
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.ui.Autocomplete.T resolveRoot(java.lang.String r4, com.exampletest.mobilestudiotest.core.Studio r5, com.exampletest.mobilestudiotest.model.Instance r6, java.lang.String r7, int r8, int r9) {
        /*
            r3 = this;
            com.exampletest.mobilestudiotest.model.DataModel r0 = r5.getModel()
            int r1 = r4.hashCode()
            switch(r1) {
                case -1182135179: goto L58;
                case -985174221: goto L46;
                case -907685685: goto L36;
                case 2165025: goto L29;
                case 3165170: goto L15;
                case 1108864149: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L60
        Lc:
            java.lang.String r1 = "workspace"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L61
            goto L60
        L15:
            java.lang.String r1 = "game"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L60
            com.exampletest.mobilestudiotest.ui.Autocomplete$T$Inst r1 = new com.exampletest.mobilestudiotest.ui.Autocomplete$T$Inst
            r2 = r0
            com.exampletest.mobilestudiotest.model.Instance r2 = (com.exampletest.mobilestudiotest.model.Instance) r2
            r1.<init>(r2)
            com.exampletest.mobilestudiotest.ui.Autocomplete$T r1 = (com.exampletest.mobilestudiotest.ui.Autocomplete.T) r1
            goto L92
        L29:
            java.lang.String r1 = "Enum"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L60
            com.exampletest.mobilestudiotest.ui.Autocomplete$T$EnumRoot r1 = com.exampletest.mobilestudiotest.ui.Autocomplete.T.EnumRoot.INSTANCE
            com.exampletest.mobilestudiotest.ui.Autocomplete$T r1 = (com.exampletest.mobilestudiotest.ui.Autocomplete.T) r1
            goto L92
        L36:
            java.lang.String r1 = "script"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L60
            com.exampletest.mobilestudiotest.ui.Autocomplete$T$Inst r1 = new com.exampletest.mobilestudiotest.ui.Autocomplete$T$Inst
            r1.<init>(r6)
            com.exampletest.mobilestudiotest.ui.Autocomplete$T r1 = (com.exampletest.mobilestudiotest.ui.Autocomplete.T) r1
            goto L92
        L46:
            java.lang.String r1 = "plugin"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L60
            com.exampletest.mobilestudiotest.ui.Autocomplete$T$Cls r1 = new com.exampletest.mobilestudiotest.ui.Autocomplete$T$Cls
            java.lang.String r2 = "Plugin"
            r1.<init>(r2)
            com.exampletest.mobilestudiotest.ui.Autocomplete$T r1 = (com.exampletest.mobilestudiotest.ui.Autocomplete.T) r1
            goto L92
        L58:
            java.lang.String r1 = "Workspace"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L61
        L60:
            goto L6d
        L61:
            com.exampletest.mobilestudiotest.ui.Autocomplete$T$Inst r1 = new com.exampletest.mobilestudiotest.ui.Autocomplete$T$Inst
            com.exampletest.mobilestudiotest.model.Instance r2 = r0.getWorkspace()
            r1.<init>(r2)
            com.exampletest.mobilestudiotest.ui.Autocomplete$T r1 = (com.exampletest.mobilestudiotest.ui.Autocomplete.T) r1
            goto L92
        L6d:
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r1 = com.exampletest.mobilestudiotest.ui.Autocomplete.libs
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L7e
            com.exampletest.mobilestudiotest.ui.Autocomplete$T$Lib r1 = new com.exampletest.mobilestudiotest.ui.Autocomplete$T$Lib
            r1.<init>(r4)
            com.exampletest.mobilestudiotest.ui.Autocomplete$T r1 = (com.exampletest.mobilestudiotest.ui.Autocomplete.T) r1
            goto L92
        L7e:
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r1 = com.exampletest.mobilestudiotest.ui.Autocomplete.dataStatics
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L8e
            com.exampletest.mobilestudiotest.ui.Autocomplete$T$DataStatic r1 = new com.exampletest.mobilestudiotest.ui.Autocomplete$T$DataStatic
            r1.<init>(r4)
            com.exampletest.mobilestudiotest.ui.Autocomplete$T r1 = (com.exampletest.mobilestudiotest.ui.Autocomplete.T) r1
            goto L92
        L8e:
            com.exampletest.mobilestudiotest.ui.Autocomplete$T r1 = r3.resolveLocal(r4, r5, r6, r7, r8, r9)
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Autocomplete.resolveRoot(java.lang.String, com.exampletest.mobilestudiotest.core.Studio, com.exampletest.mobilestudiotest.model.Instance, java.lang.String, int, int):com.exampletest.mobilestudiotest.ui.Autocomplete$T");
    }

    private final T resolveSteps(List<Step> steps, Studio studio, Instance script, String text, int before, int depth) {
        T resolveRoot;
        if (steps.isEmpty() || (resolveRoot = resolveRoot(steps.get(0).getName(), studio, script, text, before, depth)) == null) {
            return null;
        }
        Iterator it = CollectionsKt.drop(steps, 1).iterator();
        while (it.hasNext()) {
            T member = member(resolveRoot, (Step) it.next(), studio);
            if (member == null) {
                return null;
            }
            resolveRoot = member;
        }
        return resolveRoot;
    }

    private final T typeFromHint(String s, Studio studio) {
        if (s == null) {
            return null;
        }
        if (!StringsKt.startsWith$default(s, "#", false, 2, (Object) null)) {
            return new T.Cls(s);
        }
        String substring = s.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return new T.Data(substring);
    }

    public final Result complete(Studio studio, Instance script, String text, int cursor, boolean explicit) {
        T resolveSteps;
        List<Item> membersOf;
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(text, "text");
        Result result = null;
        if (cursor >= 0 && cursor <= text.length()) {
            Pair<Integer, Integer> lexState = lexState(text, cursor);
            int intValue = lexState.component1().intValue();
            int intValue2 = lexState.component2().intValue();
            if (intValue == 2) {
                return null;
            }
            if (intValue == 1) {
                return completeString(studio, script, text, cursor, intValue2);
            }
            int i = cursor;
            while (i > 0 && isId(text.charAt(i - 1))) {
                i--;
            }
            String substring = text.substring(i, cursor);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if ((substring.length() > 0) && Character.isDigit(substring.charAt(0))) {
                return null;
            }
            int i2 = i - 1;
            char charAt = i2 >= 0 ? text.charAt(i2) : ' ';
            if (charAt == '.' && i2 > 0 && text.charAt(i2 - 1) == '.') {
                return null;
            }
            switch (charAt) {
                case '.':
                case LuaParserConstants.HEXNUM /* 58 */:
                    List<Step> chainBefore = chainBefore(text, i2);
                    if (chainBefore == null) {
                        return null;
                    }
                    synchronized (studio.getLock()) {
                        resolveSteps = INSTANCE.resolveSteps(chainBefore, studio, script, text, i2, 0);
                    }
                    if (resolveSteps == null) {
                        return null;
                    }
                    synchronized (studio.getLock()) {
                        membersOf = INSTANCE.membersOf(resolveSteps, charAt);
                    }
                    List<Item> rank = rank(membersOf, substring);
                    if (rank.isEmpty()) {
                        return null;
                    }
                    return new Result(i, cursor, substring, rank);
                default:
                    if ((substring.length() == 0) && !explicit) {
                        return null;
                    }
                    String substring2 = text.substring(Math.max(0, i - 16), i);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    if (new Regex("(\\blocal|\\bfunction|\\bfor)\\s+$").containsMatchIn(substring2) && !explicit) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    Set<String> localNames = localNames(text, i);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : localNames) {
                        Result result2 = result;
                        String str = substring2;
                        if (!Intrinsics.areEqual((String) obj, substring)) {
                            arrayList2.add(obj);
                        }
                        result = result2;
                        substring2 = str;
                    }
                    Result result3 = result;
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Item((String) it.next(), Kind.VARIABLE, "local", null, 8, null));
                    }
                    Iterator<T> it2 = keywords.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new Item((String) it2.next(), Kind.KEYWORD, null, null, 12, null));
                    }
                    Iterator<T> it3 = globals.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(new Item((String) it3.next(), Kind.GLOBAL, null, null, 12, null));
                    }
                    Iterator<T> it4 = libs.keySet().iterator();
                    while (it4.hasNext()) {
                        arrayList.add(new Item((String) it4.next(), Kind.LIBRARY, "library", null, 8, null));
                    }
                    Iterator<T> it5 = dataStatics.keySet().iterator();
                    while (it5.hasNext()) {
                        arrayList.add(new Item((String) it5.next(), Kind.CLASS, "datatype", null, 8, null));
                    }
                    arrayList.add(new Item("Enum", Kind.ENUM, null, null, 12, null));
                    List<Item> rank2 = rank(arrayList, substring);
                    return rank2.isEmpty() ? result3 : new Result(i, cursor, substring, rank2);
            }
        }
        return null;
    }
}
