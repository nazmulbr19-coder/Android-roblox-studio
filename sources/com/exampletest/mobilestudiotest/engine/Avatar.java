package com.exampletest.mobilestudiotest.engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.format.RbxDocument;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: Avatar.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\n\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bJ\u0018\u00100\u001a\n \u0011*\u0004\u0018\u000101012\u0006\u00102\u001a\u00020%H\u0002J\u000e\u00103\u001a\u0002042\u0006\u00102\u001a\u00020%J\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0005062\u0006\u00102\u001a\u00020%J\u000e\u00108\u001a\u0002092\u0006\u00102\u001a\u00020%J*\u0010:\u001a\u00020\f2\u0006\u00102\u001a\u00020%2\u0006\u0010;\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002072\b\b\u0002\u0010=\u001a\u00020\u0005J\u0016\u0010>\u001a\u00020\f2\u0006\u00102\u001a\u00020%2\u0006\u0010?\u001a\u000209J\u000e\u0010@\u001a\u00020\u00052\u0006\u00102\u001a\u00020%J\u0010\u0010A\u001a\u00020B2\u0006\u00102\u001a\u00020%H\u0002J\u000e\u0010C\u001a\u00020\u00052\u0006\u00102\u001a\u00020%J\u000e\u0010D\u001a\u00020\u001b2\u0006\u00102\u001a\u00020%J\u001e\u0010E\u001a\u00020\f2\u0006\u00102\u001a\u00020%2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0005J\u000e\u0010I\u001a\u00020\f2\u0006\u00102\u001a\u00020%J\u000e\u0010J\u001a\u00020\f2\u0006\u00102\u001a\u00020%J\b\u0010K\u001a\u00020\u0013H\u0002J\u0010\u0010L\u001a\u00020\u00132\u0006\u00102\u001a\u00020%H\u0002J\u0014\u0010M\u001a\u0004\u0018\u00010-2\b\u0010N\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010O\u001a\u00020\u00132\u0006\u0010<\u001a\u0002072\u0006\u0010P\u001a\u00020\u0005H\u0002J\u001c\u0010Q\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010R\u001a\u00020\u0005H\u0002J\u0010\u0010S\u001a\u00020\u00132\u0006\u0010?\u001a\u000209H\u0002J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020W0'2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u0013J\u001e\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0'2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u0013H\u0002J\u001a\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020W2\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0012\u0010b\u001a\u0004\u0018\u00010\u00052\u0006\u0010c\u001a\u00020\u0005H\u0002J \u0010d\u001a\u00020U2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020f2\u0006\u0010h\u001a\u00020fH\u0002J\u0018\u0010l\u001a\u00020W2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010m\u001a\u00020UH\u0002J\u0010\u0010n\u001a\u00020W2\u0006\u0010o\u001a\u00020jH\u0002J\u0016\u0010p\u001a\b\u0012\u0004\u0012\u00020W0'2\u0006\u0010F\u001a\u00020GH\u0002J\u0014\u0010q\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002JX\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0+2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020-0+2\b\u0010t\u001a\u0004\u0018\u00010\u00052\b\u0010u\u001a\u0004\u0018\u00010\u00052\b\u0010v\u001a\u0004\u0018\u00010\u00052\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020G0+J\\\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0+2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020-0+2\b\u0010y\u001a\u0004\u0018\u00010\b2\b\u0010z\u001a\u0004\u0018\u00010\b2\b\u0010{\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010|\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\b0}J\u0010\u0010~\u001a\u0004\u0018\u00010\u00052\u0006\u0010c\u001a\u00020\u0005J\u0011\u0010\u007f\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0080\u0001\u001a\u00020\u0005J\u0017\u0010\u0082\u0001\u001a\u00020W2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020-0+¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R,\u0010T\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020U060'0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050'¢\u0006\b\n\u0000\u001a\u0004\b]\u0010)R*\u0010^\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020`0_j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020``aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020j0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Avatar;", "", "<init>", "()V", "TEX_PREFIX", "", "generated", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "texture", "content", "putTexture", "", "bmp", "PREFS", "pool", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "value", "Lcom/exampletest/mobilestudiotest/engine/Avatar$Spec;", "current", "getCurrent", "()Lcom/exampletest/mobilestudiotest/engine/Avatar$Spec;", "", "version", "getVersion", "()I", "", "loading", "getLoading", "()Z", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "app", "Landroid/content/Context;", "PARTS", "", "getPARTS", "()Ljava/util/List;", "colorKeys", "", "CLASSIC_COLORS", "Lcom/exampletest/mobilestudiotest/model/Color3;", "getCLASSIC_COLORS", "()Ljava/util/Map;", "prefs", "Landroid/content/SharedPreferences;", "ctx", "mode", "Lcom/exampletest/mobilestudiotest/engine/Avatar$Mode;", "otherUser", "Lkotlin/Pair;", "", "custom", "Lorg/json/JSONObject;", "setMode", "m", "userId", "userName", "setCustom", "o", "describe", "characterFile", "Ljava/io/File;", "characterName", "hasCharacter", "setCharacter", "bytes", "", "name", "clearCharacter", "refresh", "classic", "resolve", "hex", "s", "fromUser", "label", "template", "prop", "fromCustom", "r6Attachments", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "applyTo", "Lcom/exampletest/mobilestudiotest/model/Instance;", "model", "spec", "addAccessories", "findBodyAttachment", "R15_PARTS", "getR15_PARTS", "GROUPS", "Ljava/util/LinkedHashMap;", "Lcom/exampletest/mobilestudiotest/engine/Avatar$Group;", "Lkotlin/collections/LinkedHashMap;", "groupOf", "part", "v", "x", "", "y", "z", "DEFAULT_R15", "Lcom/exampletest/mobilestudiotest/engine/Avatar$Tpl;", "DEFAULT_HEAD_TEXTURE", "attachment", "pos", "templatePart", "t", "r15PartsIn", "bitmapOf", "composeClothing", "colors", "shirt", "pants", "tshirt", "bodyParts", "composeClothingBitmaps", "shirtB", "pantsB", "teeB", "ownTexture", "Lkotlin/Function1;", "r15GroupOf", "r15ColorKey", "group", "texSerial", "buildR15", "Mode", "Scales", "Spec", "Group", "Tpl"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class Avatar {
    private static final long DEFAULT_HEAD_TEXTURE = 111092388570647L;
    private static final String PREFS = "avatar";
    public static final String TEX_PREFIX = "mobilestudio-avatar://";
    private static Context app;
    private static volatile Spec current;
    private static volatile boolean loading;
    private static int texSerial;
    private static volatile int version;
    public static final Avatar INSTANCE = new Avatar();
    private static final ConcurrentHashMap<String, Bitmap> generated = new ConcurrentHashMap<>();
    private static final ExecutorService pool = Executors.newSingleThreadExecutor();
    private static final CopyOnWriteArrayList<Function0<Unit>> listeners = new CopyOnWriteArrayList<>();
    private static final List<String> PARTS = CollectionsKt.listOf((Object[]) new String[]{"Head", "Torso", "Left Arm", "Right Arm", "Left Leg", "Right Leg"});
    private static final Map<String, String> colorKeys = MapsKt.mapOf(TuplesKt.to("Head", "head"), TuplesKt.to("Torso", "torso"), TuplesKt.to("Left Arm", "leftArm"), TuplesKt.to("Right Arm", "rightArm"), TuplesKt.to("Left Leg", "leftLeg"), TuplesKt.to("Right Leg", "rightLeg"));
    private static final Map<String, Color3> CLASSIC_COLORS = MapsKt.mapOf(TuplesKt.to("Head", Color3.INSTANCE.fromRGB(245, 205, 48)), TuplesKt.to("Left Arm", Color3.INSTANCE.fromRGB(245, 205, 48)), TuplesKt.to("Right Arm", Color3.INSTANCE.fromRGB(245, 205, 48)), TuplesKt.to("Torso", Color3.INSTANCE.fromRGB(13, 105, 172)), TuplesKt.to("Left Leg", Color3.INSTANCE.fromRGB(164, 189, 71)), TuplesKt.to("Right Leg", Color3.INSTANCE.fromRGB(164, 189, 71)));
    private static final Map<String, List<Pair<String, Vector3>>> r6Attachments = MapsKt.mapOf(TuplesKt.to("Head", CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("HatAttachment", new Vector3(0.0f, 0.6f, 0.0f)), TuplesKt.to("HairAttachment", new Vector3(0.0f, 0.6f, 0.0f)), TuplesKt.to("FaceFrontAttachment", new Vector3(0.0f, 0.0f, -0.6f)), TuplesKt.to("FaceCenterAttachment", Vector3.INSTANCE.getZERO())})), TuplesKt.to("Torso", CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("NeckAttachment", new Vector3(0.0f, 1.0f, 0.0f)), TuplesKt.to("BodyFrontAttachment", new Vector3(0.0f, 0.0f, -0.5f)), TuplesKt.to("BodyBackAttachment", new Vector3(0.0f, 0.0f, 0.5f)), TuplesKt.to("LeftCollarAttachment", new Vector3(-1.0f, 1.0f, 0.0f)), TuplesKt.to("RightCollarAttachment", new Vector3(1.0f, 1.0f, 0.0f)), TuplesKt.to("WaistFrontAttachment", new Vector3(0.0f, -1.0f, -0.5f)), TuplesKt.to("WaistCenterAttachment", new Vector3(0.0f, -1.0f, 0.0f)), TuplesKt.to("WaistBackAttachment", new Vector3(0.0f, -1.0f, 0.5f))})), TuplesKt.to("Left Arm", CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("LeftShoulderAttachment", new Vector3(0.0f, 1.0f, 0.0f)), TuplesKt.to("LeftGripAttachment", new Vector3(0.0f, -1.0f, 0.0f))})), TuplesKt.to("Right Arm", CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("RightShoulderAttachment", new Vector3(0.0f, 1.0f, 0.0f)), TuplesKt.to("RightGripAttachment", new Vector3(0.0f, -1.0f, 0.0f))})), TuplesKt.to("Left Leg", CollectionsKt.listOf(TuplesKt.to("LeftFootAttachment", new Vector3(0.0f, -1.0f, 0.0f)))), TuplesKt.to("Right Leg", CollectionsKt.listOf(TuplesKt.to("RightFootAttachment", new Vector3(0.0f, -1.0f, 0.0f)))));
    private static final List<String> R15_PARTS = CollectionsKt.listOf((Object[]) new String[]{"Head", "UpperTorso", "LowerTorso", "LeftUpperArm", "LeftLowerArm", "LeftHand", "RightUpperArm", "RightLowerArm", "RightHand", "LeftUpperLeg", "LeftLowerLeg", "LeftFoot", "RightUpperLeg", "RightLowerLeg", "RightFoot"});
    private static final LinkedHashMap<String, Group> GROUPS = MapsKt.linkedMapOf(TuplesKt.to("Torso", new Group(CollectionsKt.listOf((Object[]) new String[]{"UpperTorso", "LowerTorso"}), "Torso", 27)), TuplesKt.to("RightArm", new Group(CollectionsKt.listOf((Object[]) new String[]{"RightUpperArm", "RightLowerArm", "RightHand"}), "Right Arm", 28)), TuplesKt.to("LeftArm", new Group(CollectionsKt.listOf((Object[]) new String[]{"LeftUpperArm", "LeftLowerArm", "LeftHand"}), "Left Arm", 29)), TuplesKt.to("LeftLeg", new Group(CollectionsKt.listOf((Object[]) new String[]{"LeftUpperLeg", "LeftLowerLeg", "LeftFoot"}), "Left Leg", 30)), TuplesKt.to("RightLeg", new Group(CollectionsKt.listOf((Object[]) new String[]{"RightUpperLeg", "RightLowerLeg", "RightFoot"}), "Right Leg", 31)));
    private static final List<Tpl> DEFAULT_R15 = CollectionsKt.listOf((Object[]) new Tpl[]{new Tpl("LowerTorso", INSTANCE.v(2.0f, 0.4f, 1.0f), 7430071109L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("RootRigAttachment", INSTANCE.v(0.0f, -0.2f, 0.0f)), TuplesKt.to("WaistRigAttachment", INSTANCE.v(0.0f, 0.2f, 0.0f)), TuplesKt.to("LeftHipRigAttachment", INSTANCE.v(-0.5f, -0.2f, 0.0f)), TuplesKt.to("RightHipRigAttachment", INSTANCE.v(0.5f, -0.2f, 0.0f)), TuplesKt.to("WaistCenterAttachment", INSTANCE.v(0.0f, -0.2f, 0.0f)), TuplesKt.to("WaistFrontAttachment", INSTANCE.v(0.0f, -0.2f, -0.5f)), TuplesKt.to("WaistBackAttachment", INSTANCE.v(0.0f, -0.2f, 0.5f))})), new Tpl("UpperTorso", INSTANCE.v(2.0f, 1.6f, 1.0f), 7430071038L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("WaistRigAttachment", INSTANCE.v(0.0f, -0.8f, 0.0f)), TuplesKt.to("NeckRigAttachment", INSTANCE.v(0.0f, 0.8f, 0.0f)), TuplesKt.to("LeftShoulderRigAttachment", INSTANCE.v(-1.0f, 0.563f, 0.0f)), TuplesKt.to("RightShoulderRigAttachment", INSTANCE.v(1.0f, 0.563f, 0.0f)), TuplesKt.to("NeckAttachment", INSTANCE.v(0.0f, 0.8f, 0.0f)), TuplesKt.to("BodyFrontAttachment", INSTANCE.v(0.0f, -0.2f, -0.5f)), TuplesKt.to("BodyBackAttachment", INSTANCE.v(0.0f, -0.2f, 0.5f)), TuplesKt.to("LeftCollarAttachment", INSTANCE.v(-1.0f, 0.8f, 0.0f)), TuplesKt.to("RightCollarAttachment", INSTANCE.v(1.0f, 0.8f, 0.0f))})), new Tpl("LeftUpperArm", INSTANCE.v(1.0f, 1.169f, 1.0f), 7430071044L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("LeftShoulderRigAttachment", INSTANCE.v(0.5f, 0.394f, 0.0f)), TuplesKt.to("LeftElbowRigAttachment", INSTANCE.v(0.0f, -0.334f, 0.0f)), TuplesKt.to("LeftShoulderAttachment", INSTANCE.v(0.0f, 0.584f, 0.0f))})), new Tpl("LeftLowerArm", INSTANCE.v(1.0f, 1.052f, 1.0f), 7430071005L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("LeftElbowRigAttachment", INSTANCE.v(0.0f, 0.259f, 0.0f)), TuplesKt.to("LeftWristRigAttachment", INSTANCE.v(0.0f, -0.501f, 0.0f))})), new Tpl("LeftHand", INSTANCE.v(1.0f, 0.3f, 1.0f), 7430070991L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("LeftWristRigAttachment", INSTANCE.v(0.0f, 0.125f, 0.0f)), TuplesKt.to("LeftGripAttachment", INSTANCE.v(0.0f, -0.15f, 0.0f))})), new Tpl("RightUpperArm", INSTANCE.v(1.0f, 1.169f, 1.0f), 7430071041L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("RightShoulderRigAttachment", INSTANCE.v(-0.5f, 0.394f, 0.0f)), TuplesKt.to("RightElbowRigAttachment", INSTANCE.v(0.0f, -0.334f, 0.0f)), TuplesKt.to("RightShoulderAttachment", INSTANCE.v(0.0f, 0.584f, 0.0f))})), new Tpl("RightLowerArm", INSTANCE.v(1.0f, 1.052f, 1.0f), 7430071013L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("RightElbowRigAttachment", INSTANCE.v(0.0f, 0.259f, 0.0f)), TuplesKt.to("RightWristRigAttachment", INSTANCE.v(0.0f, -0.501f, 0.0f))})), new Tpl("RightHand", INSTANCE.v(1.0f, 0.3f, 1.0f), 7430070997L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("RightWristRigAttachment", INSTANCE.v(0.0f, 0.125f, 0.0f)), TuplesKt.to("RightGripAttachment", INSTANCE.v(0.0f, -0.15f, 0.0f))})), new Tpl("LeftUpperLeg", INSTANCE.v(1.0f, 1.217f, 1.0f), 7430071065L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("LeftHipRigAttachment", INSTANCE.v(0.0f, 0.421f, 0.0f)), TuplesKt.to("LeftKneeRigAttachment", INSTANCE.v(0.0f, -0.401f, 0.0f))})), new Tpl("LeftLowerLeg", INSTANCE.v(1.0f, 1.193f, 1.0f), 7430071049L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("LeftKneeRigAttachment", INSTANCE.v(0.0f, 0.379f, 0.0f)), TuplesKt.to("LeftAnkleRigAttachment", INSTANCE.v(0.0f, -0.547f, 0.0f))})), new Tpl("LeftFoot", INSTANCE.v(1.0f, 0.3f, 1.0f), 7430071039L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("LeftAnkleRigAttachment", INSTANCE.v(0.0f, 0.102f, 0.0f)), TuplesKt.to("LeftFootAttachment", INSTANCE.v(0.0f, -0.15f, 0.0f))})), new Tpl("RightUpperLeg", INSTANCE.v(1.0f, 1.217f, 1.0f), 7430071119L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("RightHipRigAttachment", INSTANCE.v(0.0f, 0.421f, 0.0f)), TuplesKt.to("RightKneeRigAttachment", INSTANCE.v(0.0f, -0.401f, 0.0f))})), new Tpl("RightLowerLeg", INSTANCE.v(1.0f, 1.193f, 1.0f), 7430071105L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("RightKneeRigAttachment", INSTANCE.v(0.0f, 0.379f, 0.0f)), TuplesKt.to("RightAnkleRigAttachment", INSTANCE.v(0.0f, -0.547f, 0.0f))})), new Tpl("RightFoot", INSTANCE.v(1.0f, 0.3f, 1.0f), 7430071082L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("RightAnkleRigAttachment", INSTANCE.v(0.0f, 0.102f, 0.0f)), TuplesKt.to("RightFootAttachment", INSTANCE.v(0.0f, -0.15f, 0.0f))})), new Tpl("Head", INSTANCE.v(1.196f, 1.203f, 1.198f), 123480233606534L, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("NeckRigAttachment", INSTANCE.v(0.0f, -0.586f, 0.0f)), TuplesKt.to("HatAttachment", INSTANCE.v(0.0f, 0.6f, 0.0f)), TuplesKt.to("HairAttachment", INSTANCE.v(0.0f, 0.6f, 0.0f)), TuplesKt.to("FaceFrontAttachment", INSTANCE.v(0.0f, 0.0f, -0.6f)), TuplesKt.to("FaceCenterAttachment", INSTANCE.v(0.0f, 0.0f, 0.0f))}))});

    /* compiled from: Avatar.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Avatar$Group;", "", "parts", "", "", "colorKey", "assetType", "", "<init>", "(Ljava/util/List;Ljava/lang/String;I)V", "getParts", "()Ljava/util/List;", "getColorKey", "()Ljava/lang/String;", "getAssetType", "()I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private static final class Group {
        private final int assetType;
        private final String colorKey;
        private final List<String> parts;

        public Group(List<String> parts, String colorKey, int i) {
            Intrinsics.checkNotNullParameter(parts, "parts");
            Intrinsics.checkNotNullParameter(colorKey, "colorKey");
            this.parts = parts;
            this.colorKey = colorKey;
            this.assetType = i;
        }

        public final int getAssetType() {
            return this.assetType;
        }

        public final String getColorKey() {
            return this.colorKey;
        }

        public final List<String> getParts() {
            return this.parts;
        }
    }

    /* compiled from: Avatar.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Avatar$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "ACCOUNT", "USER", "CUSTOM", "CLASSIC", "CHARACTER", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public enum Mode {
        ACCOUNT,
        USER,
        CUSTOM,
        CLASSIC,
        CHARACTER;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: Avatar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Avatar$Scales;", "", "height", "", "width", "depth", "head", "<init>", "(FFFF)V", "getHeight", "()F", "getWidth", "getDepth", "getHead", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Scales {
        private final float depth;
        private final float head;
        private final float height;
        private final float width;

        public Scales() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }

        public Scales(float f, float f2, float f3, float f4) {
            this.height = f;
            this.width = f2;
            this.depth = f3;
            this.head = f4;
        }

        public /* synthetic */ Scales(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1.0f : f2, (i & 4) != 0 ? 1.0f : f3, (i & 8) != 0 ? 1.0f : f4);
        }

        public final float getDepth() {
            return this.depth;
        }

        public final float getHead() {
            return this.head;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getWidth() {
            return this.width;
        }
    }

    /* compiled from: Avatar.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0003\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Avatar$Spec;", "", "colors", "", "", "Lcom/exampletest/mobilestudiotest/model/Color3;", "shirt", "pants", "tshirt", "face", "accessories", "", "", "label", "r15", "", "scales", "Lcom/exampletest/mobilestudiotest/engine/Avatar$Scales;", "bodyParts", "", "clothing", "Landroid/graphics/Bitmap;", "character", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLcom/exampletest/mobilestudiotest/engine/Avatar$Scales;Ljava/util/Map;Ljava/util/Map;[B)V", "getColors", "()Ljava/util/Map;", "getShirt", "()Ljava/lang/String;", "getPants", "getTshirt", "getFace", "getAccessories", "()Ljava/util/List;", "getLabel", "getR15", "()Z", "getScales", "()Lcom/exampletest/mobilestudiotest/engine/Avatar$Scales;", "getBodyParts", "getClothing", "getCharacter", "()[B", "forRig", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Spec {
        private final List<byte[]> accessories;
        private final Map<Integer, byte[]> bodyParts;
        private final byte[] character;
        private final Map<String, Bitmap> clothing;
        private final Map<String, Color3> colors;
        private final String face;
        private final String label;
        private final String pants;
        private final boolean r15;
        private final Scales scales;
        private final String shirt;
        private final String tshirt;

        public Spec(Map<String, Color3> colors, String str, String str2, String str3, String str4, List<byte[]> accessories, String label, boolean z, Scales scales, Map<Integer, byte[]> bodyParts, Map<String, Bitmap> clothing, byte[] bArr) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(accessories, "accessories");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(scales, "scales");
            Intrinsics.checkNotNullParameter(bodyParts, "bodyParts");
            Intrinsics.checkNotNullParameter(clothing, "clothing");
            this.colors = colors;
            this.shirt = str;
            this.pants = str2;
            this.tshirt = str3;
            this.face = str4;
            this.accessories = accessories;
            this.label = label;
            this.r15 = z;
            this.scales = scales;
            this.bodyParts = bodyParts;
            this.clothing = clothing;
            this.character = bArr;
        }

        public /* synthetic */ Spec(Map map, String str, String str2, String str3, String str4, List list, String str5, boolean z, Scales scales, Map map2, Map map3, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, str, str2, str3, str4, list, str5, (i & 128) != 0 ? false : z, (i & 256) != 0 ? new Scales(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : scales, (i & 512) != 0 ? MapsKt.emptyMap() : map2, (i & 1024) != 0 ? MapsKt.emptyMap() : map3, (i & 2048) != 0 ? null : bArr);
        }

        public static /* synthetic */ Spec forRig$default(Spec spec, boolean z, Scales scales, int i, Object obj) {
            if ((i & 2) != 0) {
                scales = spec.scales;
            }
            return spec.forRig(z, scales);
        }

        public final Spec forRig(boolean r15, Scales scales) {
            Intrinsics.checkNotNullParameter(scales, "scales");
            return new Spec(this.colors, this.shirt, this.pants, this.tshirt, this.face, this.accessories, this.label, r15, scales, this.bodyParts, this.clothing, this.character);
        }

        public final List<byte[]> getAccessories() {
            return this.accessories;
        }

        public final Map<Integer, byte[]> getBodyParts() {
            return this.bodyParts;
        }

        public final byte[] getCharacter() {
            return this.character;
        }

        public final Map<String, Bitmap> getClothing() {
            return this.clothing;
        }

        public final Map<String, Color3> getColors() {
            return this.colors;
        }

        public final String getFace() {
            return this.face;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getPants() {
            return this.pants;
        }

        public final boolean getR15() {
            return this.r15;
        }

        public final Scales getScales() {
            return this.scales;
        }

        public final String getShirt() {
            return this.shirt;
        }

        public final String getTshirt() {
            return this.tshirt;
        }
    }

    /* compiled from: Avatar.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n0\t¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Avatar$Tpl;", "", "name", "", "size", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "mesh", "", "atts", "", "Lkotlin/Pair;", "<init>", "(Ljava/lang/String;Lcom/exampletest/mobilestudiotest/model/Vector3;JLjava/util/List;)V", "getName", "()Ljava/lang/String;", "getSize", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getMesh", "()J", "getAtts", "()Ljava/util/List;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private static final class Tpl {
        private final List<Pair<String, Vector3>> atts;
        private final long mesh;
        private final String name;
        private final Vector3 size;

        public Tpl(String name, Vector3 size, long j, List<Pair<String, Vector3>> atts) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(atts, "atts");
            this.name = name;
            this.size = size;
            this.mesh = j;
            this.atts = atts;
        }

        public final List<Pair<String, Vector3>> getAtts() {
            return this.atts;
        }

        public final long getMesh() {
            return this.mesh;
        }

        public final String getName() {
            return this.name;
        }

        public final Vector3 getSize() {
            return this.size;
        }
    }

    /* compiled from: Avatar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.ACCOUNT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Mode.USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mode.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Mode.CLASSIC.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Mode.CHARACTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Avatar() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    private final List<Instance> addAccessories(Instance model, Spec spec) {
        Instance instance;
        boolean z;
        Object obj;
        Iterator<byte[]> it;
        byte[] bArr;
        Iterator<Instance> it2;
        ?? r6;
        Object obj2;
        ArrayList arrayList = new ArrayList();
        Iterator<byte[]> it3 = spec.getAccessories().iterator();
        while (it3.hasNext()) {
            byte[] next = it3.next();
            try {
                RbxDocument read = RbxFile.INSTANCE.read(next);
                Iterator<Instance> it4 = read.getRoots().iterator();
                while (it4.hasNext()) {
                    Instance next2 = it4.next();
                    boolean z2 = true;
                    if (next2.isA("Accoutrement")) {
                        instance = next2;
                    } else {
                        Iterator it5 = Instance.descendants$default(next2, null, 1, null).iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it5.next();
                            if (((Instance) obj2).isA("Accoutrement")) {
                                break;
                            }
                        }
                        instance = (Instance) obj2;
                        if (instance != null) {
                        }
                    }
                    Instance findFirstChild$default = Instance.findFirstChild$default(instance, "Handle", false, 2, null);
                    if (findFirstChild$default != null) {
                        boolean isA = findFirstChild$default.isA("BasePart");
                        Instance instance2 = findFirstChild$default;
                        if (!isA) {
                            instance2 = 0;
                        }
                        if (instance2 != 0) {
                            Iterator<T> it6 = instance2.getChildren().iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    z = z2;
                                    obj = null;
                                    break;
                                }
                                obj = it6.next();
                                Instance instance3 = (Instance) obj;
                                z = z2;
                                if ((!Intrinsics.areEqual(instance3.getClassName(), "Attachment") || INSTANCE.findBodyAttachment(model, instance3.getName()) == null) ? false : z) {
                                    break;
                                }
                                z2 = z;
                            }
                            Instance instance4 = (Instance) obj;
                            Instance create = InstanceFactory.INSTANCE.create("Weld");
                            create.setName("AccessoryWeld");
                            RbxDocument rbxDocument = read;
                            if (instance4 != null) {
                                it = it3;
                                bArr = next;
                                Instance findBodyAttachment = findBodyAttachment(model, instance4.getName());
                                Intrinsics.checkNotNull(findBodyAttachment);
                                Instance parent = findBodyAttachment.getParent();
                                Intrinsics.checkNotNull(parent);
                                Object obj3 = findBodyAttachment.get("CFrame");
                                CFrame cFrame = obj3 instanceof CFrame ? (CFrame) obj3 : null;
                                if (cFrame == null) {
                                    cFrame = CFrame.INSTANCE.getIDENTITY();
                                }
                                Object obj4 = instance4.get("CFrame");
                                it2 = it4;
                                CFrame cFrame2 = obj4 instanceof CFrame ? (CFrame) obj4 : null;
                                if (cFrame2 == null) {
                                    cFrame2 = CFrame.INSTANCE.getIDENTITY();
                                }
                                r6 = 0;
                                create.set("Part0", parent, false);
                                create.set("Part1", instance2, false);
                                create.set("C0", cFrame, false);
                                create.set("C1", cFrame2, false);
                                instance2.set("CFrame", PartData.INSTANCE.cframe(parent).times(cFrame).times(cFrame2.inverse()), false);
                            } else {
                                it = it3;
                                bArr = next;
                                it2 = it4;
                                Instance findFirstChild$default2 = Instance.findFirstChild$default(model, "Head", false, 2, null);
                                if (findFirstChild$default2 == null) {
                                    read = rbxDocument;
                                    it3 = it;
                                    next = bArr;
                                    it4 = it2;
                                } else {
                                    Object obj5 = instance.get("AttachmentPoint");
                                    CFrame cFrame3 = obj5 instanceof CFrame ? (CFrame) obj5 : null;
                                    if (cFrame3 == null) {
                                        cFrame3 = CFrame.INSTANCE.getIDENTITY();
                                    }
                                    CFrame cFrame4 = new CFrame(0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null);
                                    r6 = 0;
                                    create.set("Part0", findFirstChild$default2, false);
                                    create.set("Part1", instance2, false);
                                    create.set("C0", cFrame4, false);
                                    create.set("C1", cFrame3, false);
                                    instance2.set("CFrame", PartData.INSTANCE.cframe(findFirstChild$default2).times(cFrame4).times(cFrame3.inverse()), false);
                                }
                            }
                            instance2.set("CanCollide", Boolean.valueOf((boolean) r6), r6);
                            instance2.set("Massless", Boolean.valueOf(z), r6);
                            instance2.set("Anchored", Boolean.valueOf(z), r6);
                            create.attachRaw(instance2);
                            Instance.setParent$default(instance, model, r6, 2, null);
                            arrayList.add(instance2);
                            List descendants$default = Instance.descendants$default(instance, null, z ? 1 : 0, null);
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj6 : descendants$default) {
                                Instance instance5 = (Instance) obj6;
                                if ((!instance5.isA("BasePart") || instance5 == instance2) ? r6 : true) {
                                    arrayList2.add(obj6);
                                }
                            }
                            arrayList.addAll(arrayList2);
                            read = rbxDocument;
                            it3 = it;
                            next = bArr;
                            it4 = it2;
                        }
                    }
                    read = read;
                    it3 = it3;
                    next = next;
                    it4 = it4;
                }
            } catch (Exception e) {
                it3 = it3;
            }
        }
        return arrayList;
    }

    private final Instance attachment(String name, Vector3 pos) {
        Instance create = InstanceFactory.INSTANCE.create("Attachment");
        create.setName(name);
        create.set("CFrame", CFrame.INSTANCE.at(pos), false);
        return create;
    }

    private final Bitmap bitmapOf(String content) {
        Long idOf = AssetFetcher.INSTANCE.idOf(content);
        if (idOf == null) {
            return null;
        }
        return AssetFetcher.INSTANCE.imageBlocking(idOf.longValue());
    }

    private final File characterFile(Context ctx) {
        return new File(ctx.getApplicationContext().getFilesDir(), "playtest_character.rbxm");
    }

    private final Spec classic() {
        return new Spec(CLASSIC_COLORS, null, null, null, null, CollectionsKt.emptyList(), "Classic", false, null, null, null, null, 3968, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Bitmap composeClothing$lambda$51(Map map, int i) {
        String str;
        byte[] bArr = (byte[]) map.get(Integer.valueOf(i));
        if (bArr == null) {
            return null;
        }
        Iterator<T> it = INSTANCE.r15PartsIn(bArr).iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            str = PartData.INSTANCE.textureContent((Instance) it.next());
            if (str != null) {
                break;
            }
        }
        if (str != null) {
            return INSTANCE.bitmapOf(str);
        }
        return null;
    }

    public static /* synthetic */ Map composeClothingBitmaps$default(Avatar avatar, Map map, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Function1 function1, int i, Object obj) {
        return avatar.composeClothingBitmaps(map, bitmap, bitmap2, bitmap3, (i & 16) != 0 ? Avatar$composeClothingBitmaps$1.INSTANCE : function1);
    }

    private final Instance findBodyAttachment(Instance model, String name) {
        Instance findFirstChild$default;
        Iterator it = CollectionsKt.plus((Collection) PARTS, (Iterable) R15_PARTS).iterator();
        while (it.hasNext()) {
            Instance findFirstChild$default2 = Instance.findFirstChild$default(model, (String) it.next(), false, 2, null);
            if (findFirstChild$default2 != null && (findFirstChild$default = Instance.findFirstChild$default(findFirstChild$default2, name, false, 2, null)) != null && Intrinsics.areEqual(findFirstChild$default.getClassName(), "Attachment")) {
                return findFirstChild$default;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.engine.Avatar.Spec fromCustom(org.json.JSONObject r27) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.Avatar.fromCustom(org.json.JSONObject):com.exampletest.mobilestudiotest.engine.Avatar$Spec");
    }

    private static final String fromCustom$id(JSONObject jSONObject, String str) {
        RobloxApi robloxApi = RobloxApi.INSTANCE;
        String optString = jSONObject.optString(str);
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        Long parseAssetId = robloxApi.parseAssetId(optString);
        if (parseAssetId == null) {
            return null;
        }
        return "rbxassetid://" + parseAssetId.longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.engine.Avatar.Spec fromUser(long r39, java.lang.String r41) {
        /*
            Method dump skipped, instructions count: 930
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.Avatar.fromUser(long, java.lang.String):com.exampletest.mobilestudiotest.engine.Avatar$Spec");
    }

    private final String groupOf(String part) {
        Object obj;
        Set<Map.Entry<String, Group>> entrySet = GROUPS.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Group) ((Map.Entry) obj).getValue()).getParts().contains(part)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return (String) entry.getKey();
        }
        return null;
    }

    private final Color3 hex(String s) {
        if (s != null) {
            return Color3.INSTANCE.fromHex(s);
        }
        return null;
    }

    private final SharedPreferences prefs(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences(PREFS, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.exampletest.mobilestudiotest.model.Instance> r15PartsIn(byte[] r20) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.Avatar.r15PartsIn(byte[]):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void refresh$lambda$3(Context context) {
        Spec classic;
        try {
            Avatar avatar = INSTANCE;
            Intrinsics.checkNotNull(context);
            classic = avatar.resolve(context);
        } catch (Exception e) {
            OutputLog outputLog = OutputLog.INSTANCE;
            String message = e.getMessage();
            outputLog.warn("Avatar: " + (message != null ? message : e));
            classic = INSTANCE.classic();
        }
        Avatar avatar2 = INSTANCE;
        current = classic;
        Avatar avatar3 = INSTANCE;
        int i = version;
        Avatar avatar4 = INSTANCE;
        version = i + 1;
        Avatar avatar5 = INSTANCE;
        loading = false;
        Avatar avatar6 = INSTANCE;
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    private final Spec resolve(Context ctx) {
        switch (WhenMappings.$EnumSwitchMapping$0[mode(ctx).ordinal()]) {
            case 1:
                long userId = RobloxApi.INSTANCE.userId(ctx);
                if (RobloxApi.INSTANCE.isGuest(ctx) || userId == 0) {
                    return classic();
                }
                return fromUser(userId, "@" + RobloxApi.INSTANCE.userName(ctx));
            case 2:
                Pair<Long, String> otherUser = otherUser(ctx);
                long longValue = otherUser.component1().longValue();
                return longValue == 0 ? classic() : fromUser(longValue, "@" + otherUser.component2());
            case 3:
                return fromCustom(custom(ctx));
            case 4:
                return classic();
            case 5:
                File characterFile = characterFile(ctx);
                if (!characterFile.isFile()) {
                    return classic();
                }
                Map<String, Color3> map = CLASSIC_COLORS;
                List emptyList = CollectionsKt.emptyList();
                String characterName = characterName(ctx);
                if (characterName.length() == 0) {
                    characterName = "Character";
                }
                return new Spec(map, null, null, null, null, emptyList, characterName, false, null, null, null, FilesKt.readBytes(characterFile), 1920, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ void setMode$default(Avatar avatar, Context context, Mode mode, long j, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str = "";
        }
        avatar.setMode(context, mode, j2, str);
    }

    private final String template(String content, String prop) {
        String str;
        String str2;
        Long idOf = AssetFetcher.INSTANCE.idOf(content);
        if (idOf == null) {
            return content;
        }
        try {
            List<Instance> roots = RbxFile.INSTANCE.read(AssetFetcher.INSTANCE.load(idOf.longValue())).getRoots();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = roots.iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    break;
                }
                Instance instance = (Instance) it.next();
                CollectionsKt.addAll(arrayList, CollectionsKt.plus((Collection) CollectionsKt.listOf(instance), (Iterable) Instance.descendants$default(instance, null, 1, null)));
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Instance instance2 = (Instance) it2.next();
                try {
                    Object obj = instance2.get(prop);
                    if (obj == null) {
                        obj = instance2.get("Texture");
                    }
                    if (obj == null || (str2 = obj.toString()) == null || StringsKt.isBlank(str2)) {
                        str2 = null;
                    }
                    if (str2 != null) {
                        str = str2;
                        break;
                    }
                } catch (Exception e) {
                    return content;
                }
            }
            return str == null ? content : str;
        } catch (Exception e2) {
        }
    }

    private final Instance templatePart(Tpl t) {
        Instance create = InstanceFactory.INSTANCE.create("MeshPart");
        create.setName(t.getName());
        create.set("size", t.getSize(), false);
        create.set("MeshId", "rbxassetid://" + t.getMesh(), false);
        create.set("TextureID", Intrinsics.areEqual(t.getName(), "Head") ? "rbxassetid://111092388570647" : "", false);
        for (Pair<String, Vector3> pair : t.getAtts()) {
            attachment(pair.component1(), pair.component2()).attachRaw(create);
        }
        return create;
    }

    private final Vector3 v(float x, float y, float z) {
        return new Vector3(x, y, z);
    }

    public final List<Instance> applyTo(Instance model, Spec spec) {
        Instance findFirstChild$default;
        Instance findFirstChild$default2;
        Color3 color3;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(spec, "spec");
        for (String str : PARTS) {
            Instance findFirstChild$default3 = Instance.findFirstChild$default(model, str, false, 2, null);
            if (findFirstChild$default3 != null && (color3 = spec.getColors().get(str)) != null) {
                PartData.INSTANCE.setColor(findFirstChild$default3, color3);
            }
        }
        Instance findFirstChildOfClass = model.findFirstChildOfClass("BodyColors");
        if (findFirstChildOfClass != null) {
            Color3 color32 = spec.getColors().get("Head");
            if (color32 != null) {
                findFirstChildOfClass.set("HeadColor3", color32, false);
            }
            Color3 color33 = spec.getColors().get("Torso");
            if (color33 != null) {
                findFirstChildOfClass.set("TorsoColor3", color33, false);
            }
            Color3 color34 = spec.getColors().get("Left Arm");
            if (color34 != null) {
                findFirstChildOfClass.set("LeftArmColor3", color34, false);
            }
            Color3 color35 = spec.getColors().get("Right Arm");
            if (color35 != null) {
                findFirstChildOfClass.set("RightArmColor3", color35, false);
            }
            Color3 color36 = spec.getColors().get("Left Leg");
            if (color36 != null) {
                findFirstChildOfClass.set("LeftLegColor3", color36, false);
            }
            Color3 color37 = spec.getColors().get("Right Leg");
            if (color37 != null) {
                findFirstChildOfClass.set("RightLegColor3", color37, false);
            }
        }
        ArrayList<Instance> children = model.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            Instance instance = (Instance) obj;
            if (Intrinsics.areEqual(instance.getClassName(), "Shirt") || Intrinsics.areEqual(instance.getClassName(), "Pants") || Intrinsics.areEqual(instance.getClassName(), "ShirtGraphic") || instance.isA("Accoutrement")) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Instance) it.next()).destroy();
        }
        String shirt = spec.getShirt();
        if (shirt != null) {
            Instance create = InstanceFactory.INSTANCE.create("Shirt");
            create.setName("Shirt");
            create.set("ShirtTemplate", shirt, false);
            Instance.setParent$default(create, model, 0, 2, null);
        }
        String pants = spec.getPants();
        if (pants != null) {
            Instance create2 = InstanceFactory.INSTANCE.create("Pants");
            create2.setName("Pants");
            create2.set("PantsTemplate", pants, false);
            Instance.setParent$default(create2, model, 0, 2, null);
        }
        String tshirt = spec.getTshirt();
        if (tshirt != null) {
            Instance create3 = InstanceFactory.INSTANCE.create("ShirtGraphic");
            create3.setName("Shirt Graphic");
            create3.set("Graphic", tshirt, false);
            Instance.setParent$default(create3, model, 0, 2, null);
        }
        String face = spec.getFace();
        if (face != null && (findFirstChild$default = Instance.findFirstChild$default(model, "Head", false, 2, null)) != null && (findFirstChild$default2 = Instance.findFirstChild$default(findFirstChild$default, "face", false, 2, null)) != null) {
            Instance.set$default(findFirstChild$default2, "Texture", face, false, 4, null);
        }
        for (Map.Entry<String, List<Pair<String, Vector3>>> entry : r6Attachments.entrySet()) {
            String key = entry.getKey();
            List<Pair<String, Vector3>> value = entry.getValue();
            Instance findFirstChild$default4 = Instance.findFirstChild$default(model, key, false, 2, null);
            if (findFirstChild$default4 != null) {
                for (Pair<String, Vector3> pair : value) {
                    String component1 = pair.component1();
                    Vector3 component2 = pair.component2();
                    if (Instance.findFirstChild$default(findFirstChild$default4, component1, false, 2, null) == null) {
                        Instance create4 = InstanceFactory.INSTANCE.create("Attachment");
                        create4.setName(component1);
                        create4.set("CFrame", CFrame.INSTANCE.at(component2), false);
                        create4.attachRaw(findFirstChild$default4);
                    }
                }
            }
        }
        return addAccessories(model, spec);
    }

    /* JADX WARN: Code restructure failed: missing block: B:300:0x08d6, code lost:
    
        if (r0 != null) goto L282;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x065c A[LOOP:13: B:178:0x0629->B:186:0x065c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0667 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x080c A[LOOP:16: B:242:0x07a3->B:254:0x080c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0817 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0879 A[LOOP:17: B:269:0x0847->B:277:0x0879, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0883 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0939 A[LOOP:19: B:303:0x0908->B:311:0x0939, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0943 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a7 A[LOOP:4: B:34:0x016c->B:44:0x01a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03a0  */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r27v24 */
    /* JADX WARN: Type inference failed for: r27v25 */
    /* JADX WARN: Type inference failed for: r27v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.Set] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.model.Instance buildR15(java.lang.String r42, com.exampletest.mobilestudiotest.engine.Avatar.Spec r43) {
        /*
            Method dump skipped, instructions count: 2922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.Avatar.buildR15(java.lang.String, com.exampletest.mobilestudiotest.engine.Avatar$Spec):com.exampletest.mobilestudiotest.model.Instance");
    }

    public final String characterName(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String string = prefs(ctx).getString("characterName", "");
        return string != null ? string : "";
    }

    public final void clearCharacter(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        characterFile(ctx).delete();
        prefs(ctx).edit().remove("characterName").apply();
        if (mode(ctx) == Mode.CHARACTER) {
            setMode$default(this, ctx, Mode.ACCOUNT, 0L, null, 12, null);
        }
    }

    public final Map<String, Bitmap> composeClothing(Map<String, Color3> colors, String shirt, String pants, String tshirt, Map<Integer, byte[]> bodyParts) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(bodyParts, "bodyParts");
        return composeClothingBitmaps(colors, bitmapOf(shirt), bitmapOf(pants), bitmapOf(tshirt), new Avatar$$ExternalSyntheticLambda0(bodyParts));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
    
        if (r8.equals("LeftArm") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x007d, code lost:
    
        r9 = kotlin.collections.CollectionsKt.listOfNotNull(r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x007a, code lost:
    
        if (r8.equals("RightArm") == false) goto L24;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0057. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.String, android.graphics.Bitmap> composeClothingBitmaps(java.util.Map<java.lang.String, com.exampletest.mobilestudiotest.model.Color3> r25, android.graphics.Bitmap r26, android.graphics.Bitmap r27, android.graphics.Bitmap r28, kotlin.jvm.functions.Function1<? super java.lang.Integer, android.graphics.Bitmap> r29) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.Avatar.composeClothingBitmaps(java.util.Map, android.graphics.Bitmap, android.graphics.Bitmap, android.graphics.Bitmap, kotlin.jvm.functions.Function1):java.util.Map");
    }

    public final JSONObject custom(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            String string = prefs(ctx).getString("custom", "{}");
            Intrinsics.checkNotNull(string);
            return new JSONObject(string);
        } catch (Exception e) {
            return new JSONObject();
        }
    }

    public final String describe(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        switch (WhenMappings.$EnumSwitchMapping$0[mode(ctx).ordinal()]) {
            case 1:
                if (RobloxApi.INSTANCE.isGuest(ctx)) {
                    return "Classic (guest)";
                }
                return "My avatar (@" + RobloxApi.INSTANCE.userName(ctx) + ")";
            case 2:
                return "@" + ((Object) otherUser(ctx).getSecond()) + "'s avatar";
            case 3:
                return "Custom avatar";
            case 4:
                return "Classic";
            case 5:
                String characterName = characterName(ctx);
                if (characterName.length() == 0) {
                    characterName = "custom model";
                }
                return "Character: " + ((Object) characterName);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Map<String, Color3> getCLASSIC_COLORS() {
        return CLASSIC_COLORS;
    }

    public final Spec getCurrent() {
        return current;
    }

    public final CopyOnWriteArrayList<Function0<Unit>> getListeners() {
        return listeners;
    }

    public final boolean getLoading() {
        return loading;
    }

    public final List<String> getPARTS() {
        return PARTS;
    }

    public final List<String> getR15_PARTS() {
        return R15_PARTS;
    }

    public final int getVersion() {
        return version;
    }

    public final boolean hasCharacter(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return characterFile(ctx).isFile();
    }

    public final Mode mode(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            String string = prefs(ctx).getString("mode", "ACCOUNT");
            Intrinsics.checkNotNull(string);
            return Mode.valueOf(string);
        } catch (Exception e) {
            return Mode.ACCOUNT;
        }
    }

    public final Pair<Long, String> otherUser(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Long valueOf = Long.valueOf(prefs(ctx).getLong("userId", 0L));
        String string = prefs(ctx).getString("userName", "");
        return TuplesKt.to(valueOf, string != null ? string : "");
    }

    public final void putTexture(String content, Bitmap bmp) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        generated.put(content, bmp);
    }

    public final String r15ColorKey(String group) {
        Intrinsics.checkNotNullParameter(group, "group");
        Group group2 = GROUPS.get(group);
        if (group2 != null) {
            return group2.getColorKey();
        }
        return null;
    }

    public final String r15GroupOf(String part) {
        Intrinsics.checkNotNullParameter(part, "part");
        return groupOf(part);
    }

    public final void refresh(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        app = ctx.getApplicationContext();
        Context applicationContext = ctx.getApplicationContext();
        loading = true;
        pool.execute(new Avatar$$ExternalSyntheticLambda1(applicationContext));
    }

    public final void setCharacter(Context ctx, byte[] bytes, String name) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(name, "name");
        File characterFile = characterFile(ctx);
        File file = new File(characterFile.getPath() + ".tmp");
        FilesKt.writeBytes(file, bytes);
        if (!file.renameTo(characterFile)) {
            characterFile.delete();
            file.renameTo(characterFile);
        }
        prefs(ctx).edit().putString("characterName", name).putString("mode", "CHARACTER").apply();
        refresh(ctx);
    }

    public final void setCustom(Context ctx, JSONObject o) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(o, "o");
        prefs(ctx).edit().putString("custom", o.toString()).putString("mode", "CUSTOM").apply();
        refresh(ctx);
    }

    public final void setMode(Context ctx, Mode m, long userId, String userName) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(userName, "userName");
        SharedPreferences.Editor putString = prefs(ctx).edit().putString("mode", m.name());
        if (m == Mode.USER) {
            putString.putLong("userId", userId).putString("userName", userName);
        }
        putString.apply();
        refresh(ctx);
    }

    public final Bitmap texture(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return generated.get(content);
    }
}
