package com.exampletest.mobilestudiotest.lua;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.model.BrickColorV;
import com.exampletest.mobilestudiotest.model.BrickColors;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.ColorKey;
import com.exampletest.mobilestudiotest.model.ColorSequence;
import com.exampletest.mobilestudiotest.model.Enums;
import com.exampletest.mobilestudiotest.model.FontValue;
import com.exampletest.mobilestudiotest.model.NumberKey;
import com.exampletest.mobilestudiotest.model.NumberRange;
import com.exampletest.mobilestudiotest.model.NumberSequence;
import com.exampletest.mobilestudiotest.model.PhysicalProps;
import com.exampletest.mobilestudiotest.model.Ray;
import com.exampletest.mobilestudiotest.model.Rect;
import com.exampletest.mobilestudiotest.model.UDim;
import com.exampletest.mobilestudiotest.model.UDim2;
import com.exampletest.mobilestudiotest.model.Vector2;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.model.Vector3int16;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0002JS\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0014\u001a\u00020\n2\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00162\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0002\b\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020 J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\fJ\u000e\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0007J\u001e\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u001eJ\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001eH\u0002J$\u00100\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u00101\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u00020\u001eJ\u000e\u00103\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001eR2\u0010\u0004\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuaTypes;", "", "<init>", "()V", "metas", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lorg/luaj/vm2/LuaTable;", "Lkotlin/collections/HashMap;", "typeOf", "", "v", "Lorg/luaj/vm2/LuaValue;", "wrap", "o", "generic", "name", "meta", "", "cls", "typeName", "index", "Lkotlin/Function2;", "extra", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "method", "f", "Lorg/luaj/vm2/Varargs;", "n", "", "v3", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "arg3", "a", "i", "", "enumItem", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "enumLib", "install", "g", "ease", "style", "dir", "t0", "bounceOut", "x", "lerpValue", "b", "t", "absf", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaTypes {
    public static final LuaTypes INSTANCE = new LuaTypes();
    private static final HashMap<Class<?>, LuaTable> metas = new HashMap<>();

    static {
        INSTANCE.meta(Vector3.class, "Vector3", new LuaTypes$$ExternalSyntheticLambda15(), new LuaTypes$$ExternalSyntheticLambda26());
        INSTANCE.meta(Vector2.class, "Vector2", new LuaTypes$$ExternalSyntheticLambda37(), new LuaTypes$$ExternalSyntheticLambda38());
        INSTANCE.meta(CFrame.class, "CFrame", new LuaTypes$$ExternalSyntheticLambda39(), new LuaTypes$$ExternalSyntheticLambda40());
        meta$default(INSTANCE, Color3.class, "Color3", new LuaTypes$$ExternalSyntheticLambda41(), null, 8, null);
        meta$default(INSTANCE, BrickColorV.class, "BrickColor", new LuaTypes$$ExternalSyntheticLambda42(), null, 8, null);
        INSTANCE.meta(UDim.class, "UDim", new LuaTypes$$ExternalSyntheticLambda43(), new LuaTypes$$ExternalSyntheticLambda44());
        INSTANCE.meta(UDim2.class, "UDim2", new LuaTypes$$ExternalSyntheticLambda16(), new LuaTypes$$ExternalSyntheticLambda17());
        INSTANCE.meta(EnumItemV.class, "EnumItem", new LuaTypes$$ExternalSyntheticLambda18(), new LuaTypes$$ExternalSyntheticLambda19());
        INSTANCE.meta(EnumTypeV.class, "Enum", new LuaTypes$$ExternalSyntheticLambda20(), new LuaTypes$$ExternalSyntheticLambda21());
        meta$default(INSTANCE, TweenInfoV.class, "TweenInfo", new LuaTypes$$ExternalSyntheticLambda22(), null, 8, null);
        meta$default(INSTANCE, NumberRange.class, "NumberRange", new LuaTypes$$ExternalSyntheticLambda23(), null, 8, null);
        meta$default(INSTANCE, Ray.class, "Ray", new LuaTypes$$ExternalSyntheticLambda24(), null, 8, null);
        meta$default(INSTANCE, Region3V.class, "Region3", new LuaTypes$$ExternalSyntheticLambda25(), null, 8, null);
        meta$default(INSTANCE, Region3int16V.class, "Region3int16", new LuaTypes$$ExternalSyntheticLambda27(), null, 8, null);
        meta$default(INSTANCE, RandomV.class, "Random", new LuaTypes$$ExternalSyntheticLambda28(), null, 8, null);
        meta$default(INSTANCE, RaycastResultV.class, "RaycastResult", new LuaTypes$$ExternalSyntheticLambda29(), null, 8, null);
        meta$default(INSTANCE, NumberSequence.class, "NumberSequence", new LuaTypes$$ExternalSyntheticLambda30(), null, 8, null);
        meta$default(INSTANCE, NumberKey.class, "NumberSequenceKeypoint", new LuaTypes$$ExternalSyntheticLambda31(), null, 8, null);
        meta$default(INSTANCE, ColorSequence.class, "ColorSequence", new LuaTypes$$ExternalSyntheticLambda32(), null, 8, null);
        meta$default(INSTANCE, ColorKey.class, "ColorSequenceKeypoint", new LuaTypes$$ExternalSyntheticLambda33(), null, 8, null);
        meta$default(INSTANCE, FontValue.class, "Font", new LuaTypes$$ExternalSyntheticLambda34(), null, 8, null);
        meta$default(INSTANCE, Rect.class, "Rect", new LuaTypes$$ExternalSyntheticLambda35(), null, 8, null);
        meta$default(INSTANCE, PhysicalProps.class, "PhysicalProperties", new LuaTypes$$ExternalSyntheticLambda36(), null, 8, null);
    }

    private LuaTypes() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    public static final LuaValue _init_$lambda$100(Object o, String k) {
        LuaTypes luaTypes;
        float maxY;
        float minY;
        LuaTypes luaTypes2;
        Vector2 vector2;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        Rect rect = (Rect) o;
        switch (k.hashCode()) {
            case -2137162425:
                if (k.equals("Height")) {
                    luaTypes = INSTANCE;
                    maxY = rect.getMaxY();
                    minY = rect.getMinY();
                    return luaTypes.n(maxY - minY);
                }
                return null;
            case 77124:
                if (k.equals("Max")) {
                    luaTypes2 = INSTANCE;
                    vector2 = new Vector2(rect.getMaxX(), rect.getMaxY());
                    return luaTypes2.wrap(vector2);
                }
                return null;
            case 77362:
                if (k.equals("Min")) {
                    luaTypes2 = INSTANCE;
                    vector2 = new Vector2(rect.getMinX(), rect.getMinY());
                    return luaTypes2.wrap(vector2);
                }
                return null;
            case 83574182:
                if (k.equals("Width")) {
                    luaTypes = INSTANCE;
                    maxY = rect.getMaxX();
                    minY = rect.getMinX();
                    return luaTypes.n(maxY - minY);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    public static final LuaValue _init_$lambda$101(Object o, String k) {
        LuaTypes luaTypes;
        float frictionWeight;
        LuaTypes luaTypes2;
        float friction;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        PhysicalProps physicalProps = (PhysicalProps) o;
        switch (k.hashCode()) {
            case -1771381198:
                if (k.equals("FrictionWeight")) {
                    luaTypes = INSTANCE;
                    frictionWeight = physicalProps.getFrictionWeight();
                    return luaTypes.n(frictionWeight);
                }
                return null;
            case -1360073958:
                if (k.equals("Friction")) {
                    luaTypes2 = INSTANCE;
                    friction = physicalProps.getFriction();
                    return luaTypes2.n(friction);
                }
                return null;
            case -1077596984:
                if (k.equals("Density")) {
                    luaTypes2 = INSTANCE;
                    friction = physicalProps.getDensity();
                    return luaTypes2.n(friction);
                }
                return null;
            case -224657999:
                if (k.equals("ElasticityWeight")) {
                    luaTypes = INSTANCE;
                    frictionWeight = physicalProps.getElasticityWeight();
                    return luaTypes.n(frictionWeight);
                }
                return null;
            case 1347507673:
                if (k.equals("Elasticity")) {
                    luaTypes2 = INSTANCE;
                    friction = physicalProps.getElasticity();
                    return luaTypes2.n(friction);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        if (r4.equals("unit") == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r0.getUnit());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        if (r4.equals("lerp") == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda154());
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        if (r4.equals("Unit") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ad, code lost:
    
        if (r4.equals("Lerp") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012b, code lost:
    
        if (r4.equals("z") == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0148, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getZ();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return r1.n(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0134, code lost:
    
        if (r4.equals("y") == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0157, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x013d, code lost:
    
        if (r4.equals("x") == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0166, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getX();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0146, code lost:
    
        if (r4.equals("Z") != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0155, code lost:
    
        if (r4.equals("Y") != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0164, code lost:
    
        if (r4.equals("X") != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0177, code lost:
    
        if (r4.equals("Magnitude") == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.n(r0.getMagnitude());
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0180, code lost:
    
        if (r4.equals("magnitude") == false) goto L73;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue _init_$lambda$17(java.lang.Object r3, java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaTypes._init_$lambda$17(java.lang.Object, java.lang.String):org.luaj.vm2.LuaValue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$23(LuaTable meta) {
        Intrinsics.checkNotNullParameter(meta, "$this$meta");
        meta.set(LuaValue.ADD, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda70()));
        meta.set(LuaValue.SUB, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda71()));
        meta.set(LuaValue.MUL, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda72()));
        meta.set(LuaValue.DIV, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda73()));
        meta.set(LuaValue.UNM, LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda74()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (r4.equals("y") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return r1.n(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
    
        if (r4.equals("x") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getX();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
    
        if (r4.equals("Y") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        if (r4.equals("X") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
    
        if (r4.equals("Magnitude") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.n(r0.getMagnitude());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a0, code lost:
    
        if (r4.equals("magnitude") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
    
        if (r4.equals("unit") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r0.getUnit());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        if (r4.equals("Unit") != false) goto L10;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue _init_$lambda$26(java.lang.Object r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "o"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "k"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = r3
            com.exampletest.mobilestudiotest.model.Vector2 r0 = (com.exampletest.mobilestudiotest.model.Vector2) r0
            int r1 = r4.hashCode()
            switch(r1) {
                case -2016783856: goto L9a;
                case -12815888: goto L91;
                case 88: goto L7e;
                case 89: goto L6f;
                case 120: goto L66;
                case 121: goto L5d;
                case 68905: goto L49;
                case 2364823: goto L34;
                case 2641316: goto L20;
                case 3594628: goto L16;
                default: goto L14;
            }
        L14:
            goto La2
        L16:
            java.lang.String r1 = "unit"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L28
            goto La2
        L20:
            java.lang.String r1 = "Unit"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto La2
        L28:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.model.Vector2 r2 = r0.getUnit()
            org.luaj.vm2.LuaValue r1 = r1.wrap(r2)
            goto Laf
        L34:
            java.lang.String r1 = "Lerp"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto La2
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda53 r2 = new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda53
            r2.<init>()
            org.luaj.vm2.LuaValue r1 = r1.method(r2)
            goto Laf
        L49:
            java.lang.String r1 = "Dot"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto La2
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda52 r2 = new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda52
            r2.<init>()
            org.luaj.vm2.LuaValue r1 = r1.method(r2)
            goto Laf
        L5d:
            java.lang.String r1 = "y"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L77
            goto La2
        L66:
            java.lang.String r1 = "x"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L86
            goto La2
        L6f:
            java.lang.String r1 = "Y"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto La2
        L77:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            float r2 = r0.getY()
            goto L8c
        L7e:
            java.lang.String r1 = "X"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto La2
        L86:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            float r2 = r0.getX()
        L8c:
            org.luaj.vm2.LuaValue r1 = r1.n(r2)
            goto Laf
        L91:
            java.lang.String r1 = "Magnitude"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto La3
            goto La2
        L9a:
            java.lang.String r1 = "magnitude"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto La3
        La2:
            goto Lae
        La3:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            float r2 = r0.getMagnitude()
            org.luaj.vm2.LuaValue r1 = r1.n(r2)
            goto Laf
        Lae:
            r1 = 0
        Laf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaTypes._init_$lambda$26(java.lang.Object, java.lang.String):org.luaj.vm2.LuaValue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$32(LuaTable meta) {
        Intrinsics.checkNotNullParameter(meta, "$this$meta");
        meta.set(LuaValue.ADD, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda57()));
        meta.set(LuaValue.SUB, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda58()));
        meta.set(LuaValue.MUL, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda59()));
        meta.set(LuaValue.DIV, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda60()));
        meta.set(LuaValue.UNM, LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda61()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e1, code lost:
    
        if (r7.equals("Inverse") != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0217, code lost:
    
        if (r7.equals("pointToWorldSpace") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda121());
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0221, code lost:
    
        if (r7.equals("ToObjectSpace") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda120());
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x022b, code lost:
    
        if (r7.equals("ToWorldSpace") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda119());
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0235, code lost:
    
        if (r7.equals("ToOrientation") != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r0.getRightVector());
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x024a, code lost:
    
        if (r7.equals("PointToWorldSpace") != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x025f, code lost:
    
        if (r7.equals("toWorldSpace") != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0273, code lost:
    
        if (r7.equals("VectorToWorldSpace") != false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x029b, code lost:
    
        if (r7.equals("PointToObjectSpace") != false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02af, code lost:
    
        if (r7.equals("LookVector") != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02c2, code lost:
    
        if (r7.equals("toObjectSpace") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r7.equals("VectorToObjectSpace") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda124());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        if (r7.equals("UpVector") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r0.getUpVector());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r7.equals("upVector") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0075, code lost:
    
        if (r7.equals("Position") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r0.getPosition());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
    
        if (r7.equals("vectorToWorldSpace") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda123());
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
    
        if (r7.equals("toEulerAnglesYXZ") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda126());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0093, code lost:
    
        if (r7.equals("toEulerAnglesXYZ") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda125());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009d, code lost:
    
        if (r7.equals("pointToObjectSpace") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda122());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
    
        if (r7.equals("lookVector") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
    
        if (r7.equals("inverse") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(r0.getLookVector());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
    
        if (r7.equals("GetComponents") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda115());
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cf, code lost:
    
        if (r7.equals("lerp") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda118());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d9, code lost:
    
        if (r7.equals("Lerp") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ee, code lost:
    
        if (r7.equals("z") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0122, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getZ();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return r1.n(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda114());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f8, code lost:
    
        if (r7.equals("y") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0131, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0102, code lost:
    
        if (r7.equals("x") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0140, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getX();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x010c, code lost:
    
        if (r7.equals("p") != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0120, code lost:
    
        if (r7.equals("Z") != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x012f, code lost:
    
        if (r7.equals("Y") != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x013e, code lost:
    
        if (r7.equals("X") != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x016f, code lost:
    
        if (r7.equals("vectorToObjectSpace") != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0184, code lost:
    
        if (r7.equals("ToEulerAnglesYXZ") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x018e, code lost:
    
        if (r7.equals("ToEulerAnglesXYZ") != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01a3, code lost:
    
        if (r7.equals("rightVector") != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b7, code lost:
    
        if (r7.equals("components") != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        if (r7.equals("RightVector") == false) goto L137;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue _init_$lambda$47(java.lang.Object r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaTypes._init_$lambda$47(java.lang.Object, java.lang.String):org.luaj.vm2.LuaValue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$51(LuaTable meta) {
        Intrinsics.checkNotNullParameter(meta, "$this$meta");
        meta.set(LuaValue.MUL, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda139()));
        meta.set(LuaValue.ADD, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda140()));
        meta.set(LuaValue.SUB, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda141()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        if (r4.equals("lerp") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.method(new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda136());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
    
        if (r4.equals("Lerp") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (r4.equals("r") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getR();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return r1.n(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
    
        if (r4.equals("g") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008f, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getG();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
    
        if (r4.equals("b") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009f, code lost:
    
        r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r2 = r0.getB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
    
        if (r4.equals("R") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
    
        if (r4.equals("G") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
    
        if (r4.equals("B") == false) goto L37;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue _init_$lambda$55(java.lang.Object r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "o"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "k"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = r3
            com.exampletest.mobilestudiotest.model.Color3 r0 = (com.exampletest.mobilestudiotest.model.Color3) r0
            int r1 = r4.hashCode()
            switch(r1) {
                case 66: goto L96;
                case 71: goto L87;
                case 82: goto L78;
                case 98: goto L6f;
                case 103: goto L66;
                case 114: goto L5d;
                case 2364823: goto L49;
                case 3318135: goto L40;
                case 80954416: goto L2b;
                case 80955008: goto L16;
                default: goto L14;
            }
        L14:
            goto L9e
        L16:
            java.lang.String r1 = "ToHex"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L9e
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda138 r2 = new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda138
            r2.<init>()
            org.luaj.vm2.LuaValue r1 = r1.method(r2)
            goto Lab
        L2b:
            java.lang.String r1 = "ToHSV"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L9e
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda137 r2 = new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda137
            r2.<init>()
            org.luaj.vm2.LuaValue r1 = r1.method(r2)
            goto Lab
        L40:
            java.lang.String r1 = "lerp"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L51
            goto L9e
        L49:
            java.lang.String r1 = "Lerp"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L9e
        L51:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda136 r2 = new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda136
            r2.<init>()
            org.luaj.vm2.LuaValue r1 = r1.method(r2)
            goto Lab
        L5d:
            java.lang.String r1 = "r"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L80
            goto L9e
        L66:
            java.lang.String r1 = "g"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L8f
            goto L9e
        L6f:
            java.lang.String r1 = "b"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L9f
            goto L9e
        L78:
            java.lang.String r1 = "R"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L9e
        L80:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            float r2 = r0.getR()
            goto La5
        L87:
            java.lang.String r1 = "G"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L9e
        L8f:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            float r2 = r0.getG()
            goto La5
        L96:
            java.lang.String r1 = "B"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L9f
        L9e:
            goto Laa
        L9f:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            float r2 = r0.getB()
        La5:
            org.luaj.vm2.LuaValue r1 = r1.n(r2)
            goto Lab
        Laa:
            r1 = 0
        Lab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaTypes._init_$lambda$55(java.lang.Object, java.lang.String):org.luaj.vm2.LuaValue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    public static final LuaValue _init_$lambda$56(Object o, String k) {
        LuaTypes luaTypes;
        float b;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        BrickColorV brickColorV = (BrickColorV) o;
        switch (k.hashCode()) {
            case -1950496919:
                if (k.equals("Number")) {
                    return LuaValue.valueOf(brickColorV.getNumber());
                }
                return null;
            case 98:
                if (k.equals("b")) {
                    luaTypes = INSTANCE;
                    b = brickColorV.getColor().getB();
                    return luaTypes.n(b);
                }
                return null;
            case 103:
                if (k.equals("g")) {
                    luaTypes = INSTANCE;
                    b = brickColorV.getColor().getG();
                    return luaTypes.n(b);
                }
                return null;
            case 114:
                if (k.equals("r")) {
                    luaTypes = INSTANCE;
                    b = brickColorV.getColor().getR();
                    return luaTypes.n(b);
                }
                return null;
            case 2420395:
                if (k.equals("Name")) {
                    return LuaValue.valueOf(brickColorV.getName());
                }
                return null;
            case 65290051:
                if (k.equals("Color")) {
                    return INSTANCE.wrap(brickColorV.getColor());
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$57(Object o, String k) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        UDim uDim = (UDim) o;
        if (Intrinsics.areEqual(k, "Scale")) {
            return INSTANCE.n(uDim.getScale());
        }
        if (Intrinsics.areEqual(k, "Offset")) {
            return LuaValue.valueOf(uDim.getOffset());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$60(LuaTable meta) {
        Intrinsics.checkNotNullParameter(meta, "$this$meta");
        meta.set(LuaValue.ADD, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda46()));
        meta.set(LuaValue.SUB, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda47()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r6.equals("Y") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(new com.exampletest.mobilestudiotest.model.UDim(r0.getYs(), r0.getYo()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r6.equals("X") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
    
        if (r6.equals("Height") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (r6.equals("Width") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(new com.exampletest.mobilestudiotest.model.UDim(r0.getXs(), r0.getXo()));
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue _init_$lambda$62(java.lang.Object r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "o"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "k"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = r5
            com.exampletest.mobilestudiotest.model.UDim2 r0 = (com.exampletest.mobilestudiotest.model.UDim2) r0
            int r1 = r6.hashCode()
            switch(r1) {
                case -2137162425: goto L57;
                case 88: goto L3b;
                case 89: goto L32;
                case 2364823: goto L1e;
                case 83574182: goto L15;
                default: goto L14;
            }
        L14:
            goto L5f
        L15:
            java.lang.String r1 = "Width"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L5f
            goto L43
        L1e:
            java.lang.String r1 = "Lerp"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L5f
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda106 r2 = new com.exampletest.mobilestudiotest.lua.LuaTypes$$ExternalSyntheticLambda106
            r2.<init>()
            org.luaj.vm2.LuaValue r1 = r1.method(r2)
            goto L75
        L32:
            java.lang.String r1 = "Y"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L60
            goto L5f
        L3b:
            java.lang.String r1 = "X"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L5f
        L43:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.model.UDim r2 = new com.exampletest.mobilestudiotest.model.UDim
            float r3 = r0.getXs()
            int r4 = r0.getXo()
            r2.<init>(r3, r4)
            org.luaj.vm2.LuaValue r1 = r1.wrap(r2)
            goto L75
        L57:
            java.lang.String r1 = "Height"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L60
        L5f:
            goto L74
        L60:
            com.exampletest.mobilestudiotest.lua.LuaTypes r1 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            com.exampletest.mobilestudiotest.model.UDim r2 = new com.exampletest.mobilestudiotest.model.UDim
            float r3 = r0.getYs()
            int r4 = r0.getYo()
            r2.<init>(r3, r4)
            org.luaj.vm2.LuaValue r1 = r1.wrap(r2)
            goto L75
        L74:
            r1 = 0
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaTypes._init_$lambda$62(java.lang.Object, java.lang.String):org.luaj.vm2.LuaValue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$66(LuaTable meta) {
        Intrinsics.checkNotNullParameter(meta, "$this$meta");
        meta.set(LuaValue.ADD, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda103()));
        meta.set(LuaValue.SUB, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda104()));
        meta.set(LuaValue.UNM, LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda105()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final LuaValue _init_$lambda$68(Object o, String k) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        EnumItemV enumItemV = (EnumItemV) o;
        switch (k.hashCode()) {
            case -2006084613:
                if (k.equals("EnumType")) {
                    return INSTANCE.wrap(new EnumTypeV(enumItemV.getType()));
                }
                return null;
            case 73783:
                if (k.equals("IsA")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda135(enumItemV));
                }
                return null;
            case 2420395:
                if (k.equals("Name")) {
                    return LuaValue.valueOf(enumItemV.getName());
                }
                return null;
            case 82420049:
                if (k.equals("Value")) {
                    return LuaValue.valueOf(enumItemV.getValue());
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$70(LuaTable meta) {
        Intrinsics.checkNotNullParameter(meta, "$this$meta");
        meta.set(LuaValue.TOSTRING, LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda133()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    public static final LuaValue _init_$lambda$76(Object o, String k) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        EnumTypeV enumTypeV = (EnumTypeV) o;
        switch (k.hashCode()) {
            case -1180203659:
                if (k.equals("FromName")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda149(enumTypeV));
                }
                return INSTANCE.enumItem(enumTypeV.getName(), k);
            case 376316073:
                if (k.equals("GetEnumItems")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda148(enumTypeV));
                }
                return INSTANCE.enumItem(enumTypeV.getName(), k);
            case 2075780039:
                if (k.equals("FromValue")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda150(enumTypeV));
                }
                return INSTANCE.enumItem(enumTypeV.getName(), k);
            default:
                return INSTANCE.enumItem(enumTypeV.getName(), k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$78(LuaTable meta) {
        Intrinsics.checkNotNullParameter(meta, "$this$meta");
        meta.set(LuaValue.TOSTRING, LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda102()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    public static final LuaValue _init_$lambda$79(Object o, String k) {
        LuaTypes luaTypes;
        float time;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        TweenInfoV tweenInfoV = (TweenInfoV) o;
        switch (k.hashCode()) {
            case -1681309068:
                if (k.equals("EasingDirection")) {
                    LuaTypes luaTypes2 = INSTANCE;
                    String itemName = Enums.INSTANCE.itemName("EasingDirection", tweenInfoV.getDirection());
                    if (itemName == null) {
                        itemName = "Out";
                    }
                    return luaTypes2.wrap(new EnumItemV("EasingDirection", itemName, tweenInfoV.getDirection()));
                }
                return null;
            case -1055579116:
                if (k.equals("RepeatCount")) {
                    return LuaValue.valueOf(tweenInfoV.getRepeatCount());
                }
                return null;
            case -199856655:
                if (k.equals("Reverses")) {
                    return LuaValue.valueOf(tweenInfoV.getReverses());
                }
                return null;
            case 2606829:
                if (k.equals("Time")) {
                    luaTypes = INSTANCE;
                    time = tweenInfoV.getTime();
                    return luaTypes.n(time);
                }
                return null;
            case 1460280102:
                if (k.equals("EasingStyle")) {
                    LuaTypes luaTypes3 = INSTANCE;
                    String itemName2 = Enums.INSTANCE.itemName("EasingStyle", tweenInfoV.getStyle());
                    if (itemName2 == null) {
                        itemName2 = "Quad";
                    }
                    return luaTypes3.wrap(new EnumItemV("EasingStyle", itemName2, tweenInfoV.getStyle()));
                }
                return null;
            case 1534863056:
                if (k.equals("DelayTime")) {
                    luaTypes = INSTANCE;
                    time = tweenInfoV.getDelay();
                    return luaTypes.n(time);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$80(Object o, String k) {
        LuaTypes luaTypes;
        float max;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        NumberRange numberRange = (NumberRange) o;
        if (Intrinsics.areEqual(k, "Min")) {
            luaTypes = INSTANCE;
            max = numberRange.getMin();
        } else {
            if (!Intrinsics.areEqual(k, "Max")) {
                return null;
            }
            luaTypes = INSTANCE;
            max = numberRange.getMax();
        }
        return luaTypes.n(max);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    public static final LuaValue _init_$lambda$82(Object o, String k) {
        LuaTypes luaTypes;
        Object origin;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        Ray ray = (Ray) o;
        switch (k.hashCode()) {
            case -1924752570:
                if (k.equals("Origin")) {
                    luaTypes = INSTANCE;
                    origin = ray.getOrigin();
                    return luaTypes.wrap(origin);
                }
                return null;
            case -463439145:
                if (k.equals("ClosestPoint")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda1(ray));
                }
                return null;
            case 2641316:
                if (k.equals("Unit")) {
                    luaTypes = INSTANCE;
                    origin = new Ray(ray.getOrigin(), ray.getDirection().getUnit());
                    return luaTypes.wrap(origin);
                }
                return null;
            case 1041377119:
                if (k.equals("Direction")) {
                    luaTypes = INSTANCE;
                    origin = ray.getDirection();
                    return luaTypes.wrap(origin);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final LuaValue _init_$lambda$84(Object o, String k) {
        LuaTypes luaTypes;
        Object size;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        Region3V region3V = (Region3V) o;
        switch (k.hashCode()) {
            case -831874117:
                if (k.equals("ExpandToGrid")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda134(region3V));
                }
                return null;
            case 2577441:
                if (k.equals("Size")) {
                    luaTypes = INSTANCE;
                    size = region3V.getSize();
                    return luaTypes.wrap(size);
                }
                return null;
            case 1986292458:
                if (k.equals("CFrame")) {
                    luaTypes = INSTANCE;
                    size = region3V.getCframe();
                    return luaTypes.wrap(size);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$85(Object o, String k) {
        LuaTypes luaTypes;
        Vector3int16 max;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        Region3int16V region3int16V = (Region3int16V) o;
        if (Intrinsics.areEqual(k, "Min")) {
            luaTypes = INSTANCE;
            max = region3int16V.getMin();
        } else {
            if (!Intrinsics.areEqual(k, "Max")) {
                return null;
            }
            luaTypes = INSTANCE;
            max = region3int16V.getMax();
        }
        return luaTypes.wrap(max);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final LuaValue _init_$lambda$89(Object o, String k) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        Random rng = ((RandomV) o).getRng();
        switch (k.hashCode()) {
            case -64826534:
                if (k.equals("NextUnitVector")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda64(rng));
                }
                return null;
            case 587066428:
                if (k.equals("NextNumber")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda62(rng));
                }
                return null;
            case 682790571:
                if (k.equals("NextInteger")) {
                    return INSTANCE.method(new LuaTypes$$ExternalSyntheticLambda63(rng));
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    public static final LuaValue _init_$lambda$90(Object o, String k) {
        LuaTypes luaTypes;
        Vector3 normal;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        RayHitInfo hit = ((RaycastResultV) o).getHit();
        switch (k.hashCode()) {
            case -1955878649:
                if (k.equals("Normal")) {
                    luaTypes = INSTANCE;
                    normal = hit.getNormal();
                    return luaTypes.wrap(normal);
                }
                return null;
            case 353103893:
                if (k.equals("Distance")) {
                    return INSTANCE.n(hit.getDistance());
                }
                return null;
            case 363710791:
                if (k.equals("Material")) {
                    LuaTypes luaTypes2 = INSTANCE;
                    String itemName = Enums.INSTANCE.itemName("Material", hit.getMaterial());
                    if (itemName == null) {
                        itemName = "Plastic";
                    }
                    return luaTypes2.wrap(new EnumItemV("Material", itemName, hit.getMaterial()));
                }
                return null;
            case 812449097:
                if (k.equals("Position")) {
                    luaTypes = INSTANCE;
                    normal = hit.getPosition();
                    return luaTypes.wrap(normal);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$93(Object o, String k) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        NumberSequence numberSequence = (NumberSequence) o;
        if (!Intrinsics.areEqual(k, "Keypoints")) {
            return null;
        }
        LuaTable luaTable = new LuaTable();
        Iterator<T> it = numberSequence.getKeys().iterator();
        while (it.hasNext()) {
            luaTable.insert(0, INSTANCE.wrap((NumberKey) it.next()));
        }
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final LuaValue _init_$lambda$94(Object o, String k) {
        LuaTypes luaTypes;
        float envelope;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        NumberKey numberKey = (NumberKey) o;
        switch (k.hashCode()) {
            case -1984138256:
                if (k.equals("Envelope")) {
                    luaTypes = INSTANCE;
                    envelope = numberKey.getEnvelope();
                    return luaTypes.n(envelope);
                }
                return null;
            case 2606829:
                if (k.equals("Time")) {
                    luaTypes = INSTANCE;
                    envelope = numberKey.getTime();
                    return luaTypes.n(envelope);
                }
                return null;
            case 82420049:
                if (k.equals("Value")) {
                    luaTypes = INSTANCE;
                    envelope = numberKey.getValue();
                    return luaTypes.n(envelope);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$97(Object o, String k) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        ColorSequence colorSequence = (ColorSequence) o;
        if (!Intrinsics.areEqual(k, "Keypoints")) {
            return null;
        }
        LuaTable luaTable = new LuaTable();
        Iterator<T> it = colorSequence.getKeys().iterator();
        while (it.hasNext()) {
            luaTable.insert(0, INSTANCE.wrap((ColorKey) it.next()));
        }
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue _init_$lambda$98(Object o, String k) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        ColorKey colorKey = (ColorKey) o;
        if (Intrinsics.areEqual(k, "Time")) {
            return INSTANCE.n(colorKey.getTime());
        }
        if (Intrinsics.areEqual(k, "Value")) {
            return INSTANCE.wrap(colorKey.getColor());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final LuaValue _init_$lambda$99(Object o, String k) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(k, "k");
        FontValue fontValue = (FontValue) o;
        switch (k.hashCode()) {
            case -1707725160:
                if (k.equals("Weight")) {
                    return INSTANCE.wrap(new EnumItemV("FontWeight", String.valueOf(fontValue.getWeight()), fontValue.getWeight()));
                }
                return null;
            case 2076325:
                if (k.equals("Bold")) {
                    return LuaValue.valueOf(fontValue.getWeight() >= 700);
                }
                return null;
            case 80227729:
                if (k.equals("Style")) {
                    return INSTANCE.wrap(new EnumItemV("FontStyle", fontValue.getStyle() == 1 ? "Italic" : "Normal", fontValue.getStyle()));
                }
                return null;
            case 2096973700:
                if (k.equals("Family")) {
                    return LuaValue.valueOf(fontValue.getFamily());
                }
                return null;
            default:
                return null;
        }
    }

    private final Vector3 arg3(Varargs a, int i) {
        LuaValue arg = a.arg(i);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj instanceof Vector3 ? obj : null);
        if (vector3 != null) {
            return vector3;
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg));
    }

    private final float bounceOut(float x) {
        if (x < 1.0f / 2.75f) {
            return 7.5625f * x * x;
        }
        if (x < 2.0f / 2.75f) {
            float f = x - (1.5f / 2.75f);
            return (7.5625f * f * f) + 0.75f;
        }
        if (x < 2.5d / 2.75f) {
            float f2 = x - (2.25f / 2.75f);
            return (7.5625f * f2 * f2) + 0.9375f;
        }
        float f3 = x - (2.625f / 2.75f);
        return (7.5625f * f3 * f3) + 0.984375f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    private static final float ease$easeIn(int i, float f) {
        switch (i) {
            case 0:
                return f;
            case 1:
                return 1.0f - ((float) Math.cos((3.1415927f * f) / 2.0f));
            case 2:
                return f * f * (((1.0f + 1.70158f) * f) - 1.70158f);
            case 3:
                return f * f;
            case 4:
                return f * f * f * f;
            case 5:
                return f * f * f * f * f;
            case 6:
                return 1.0f - INSTANCE.bounceOut(1.0f - f);
            case 7:
                if (!(f == 0.0f)) {
                    if (!(f == 1.0f)) {
                        return (-((float) Math.pow(2.0d, (f * 10.0d) - 10.0d))) * ((float) Math.sin(((10.0f * f) - 10.75f) * 2.0943952f));
                    }
                }
                return f;
            case 8:
                if (f == 0.0f) {
                    return 0.0f;
                }
                return (float) Math.pow(2.0d, (f * 10.0d) - 10.0d);
            case 9:
                return 1.0f - ((float) Math.sqrt(1.0f - (f * f)));
            case 10:
                return f * f * f;
            default:
                return f * f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue enumLib$lambda$102(LuaValue luaValue, LuaValue k) {
        Intrinsics.checkNotNullParameter(luaValue, "<unused var>");
        Intrinsics.checkNotNullParameter(k, "k");
        LuaTypes luaTypes = INSTANCE;
        String str = k.tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        return luaTypes.wrap(new EnumTypeV(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs enumLib$lambda$105(Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        LuaTable luaTable = new LuaTable();
        Iterator<T> it = Enums.INSTANCE.getTypes().keySet().iterator();
        while (it.hasNext()) {
            luaTable.insert(0, INSTANCE.wrap(new EnumTypeV((String) it.next())));
        }
        return luaTable;
    }

    private final LuaTable generic(String name) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("__type", name);
        luaTable.set(LuaValue.TOSTRING, LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda100()));
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue generic$lambda$1$lambda$0(LuaValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaString valueOf = LuaValue.valueOf(it.touserdata().toString());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$109(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda66()));
        lib.set("zero", INSTANCE.wrap(Vector3.INSTANCE.getZERO()));
        lib.set("one", INSTANCE.wrap(Vector3.INSTANCE.getONE()));
        lib.set("xAxis", INSTANCE.wrap(Vector3.INSTANCE.getX()));
        lib.set("yAxis", INSTANCE.wrap(Vector3.INSTANCE.getY()));
        lib.set("zAxis", INSTANCE.wrap(Vector3.INSTANCE.getZ()));
        lib.set("FromNormalId", LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda67()));
        lib.set("FromAxis", LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda68()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$109$lambda$106(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float optNum2 = LuaTypesKt.optNum(arg2, 0.0f);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(new Vector3(optNum, optNum2, LuaTypesKt.optNum(arg3, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$109$lambda$107(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Object obj = a.isuserdata() ? a.touserdata() : null;
        EnumItemV enumItemV = (EnumItemV) (obj instanceof EnumItemV ? obj : null);
        return INSTANCE.wrap(CollectionsKt.listOf((Object[]) new Vector3[]{Vector3.INSTANCE.getX(), Vector3.INSTANCE.getY(), Vector3.INSTANCE.getZ(), Vector3.INSTANCE.getX().unaryMinus(), Vector3.INSTANCE.getY().unaryMinus(), Vector3.INSTANCE.getZ().unaryMinus()}).get(RangesKt.coerceIn(enumItemV != null ? enumItemV.getValue() : a.toint(), 0, 5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$109$lambda$108(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        Vector3.Companion companion = Vector3.INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        EnumItemV enumItemV = (EnumItemV) (obj instanceof EnumItemV ? obj : null);
        return luaTypes.wrap(companion.axis(enumItemV != null ? enumItemV.getValue() : a.toint()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$111(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda69()));
        lib.set("zero", INSTANCE.wrap(new Vector2(0.0f, 0.0f)));
        lib.set("one", INSTANCE.wrap(new Vector2(1.0f, 1.0f)));
        lib.set("xAxis", INSTANCE.wrap(new Vector2(1.0f, 0.0f)));
        lib.set("yAxis", INSTANCE.wrap(new Vector2(0.0f, 1.0f)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$111$lambda$110(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        return luaTypes.wrap(new Vector2(optNum, LuaTypesKt.optNum(arg2, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$113(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda10()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$113$lambda$112(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.wrap(new Vector3int16(a.arg(1).optint(0), a.arg(2).optint(0), a.arg(3).optint(0)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$117(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set(AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_NONE_SCRIPT, LuaValue.valueOf(""));
        lib.set("fromUri", LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda54()));
        lib.set("fromAssetId", LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda55()));
        lib.set("fromObject", LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda56()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$117$lambda$114(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaString valueOf = LuaValue.valueOf(a.optjstring(""));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$117$lambda$115(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaString valueOf = LuaValue.valueOf("rbxassetid://" + a.optlong(0L));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$117$lambda$116(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$126(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda2()));
        VarArgFunction fnv = LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda3());
        lib.set("Angles", fnv);
        lib.set("fromEulerAnglesXYZ", fnv);
        VarArgFunction fnv2 = LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda4());
        lib.set("fromOrientation", fnv2);
        lib.set("fromEulerAnglesYXZ", fnv2);
        lib.set("fromEulerAngles", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda5()));
        lib.set("lookAt", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda6()));
        lib.set("lookAlong", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda7()));
        lib.set("fromAxisAngle", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda8()));
        lib.set("fromMatrix", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda9()));
        lib.set("identity", INSTANCE.wrap(CFrame.INSTANCE.getIDENTITY()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$126$lambda$118(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        int narg = a.narg();
        if (narg == 0) {
            return INSTANCE.wrap(CFrame.INSTANCE.getIDENTITY());
        }
        if (narg == 1) {
            LuaTypes luaTypes = INSTANCE;
            CFrame.Companion companion = CFrame.INSTANCE;
            LuaValue arg = a.arg(1);
            Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
            Object obj = arg.isuserdata() ? arg.touserdata() : null;
            Vector3 vector3 = (Vector3) (obj instanceof Vector3 ? obj : null);
            if (vector3 != null) {
                return luaTypes.wrap(companion.at(vector3));
            }
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg));
        }
        if (narg == 2 && a.arg(1).isuserdata()) {
            LuaTypes luaTypes2 = INSTANCE;
            CFrame.Companion companion2 = CFrame.INSTANCE;
            LuaValue arg2 = a.arg(1);
            Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
            Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
            if (!(obj2 instanceof Vector3)) {
                obj2 = null;
            }
            Vector3 vector32 = (Vector3) obj2;
            if (vector32 == null) {
                throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
            }
            LuaValue arg3 = a.arg(2);
            Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
            Object obj3 = arg3.isuserdata() ? arg3.touserdata() : null;
            Vector3 vector33 = (Vector3) (obj3 instanceof Vector3 ? obj3 : null);
            if (vector33 != null) {
                return luaTypes2.wrap(CFrame.Companion.lookAt$default(companion2, vector32, vector33, null, 4, null));
            }
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg3));
        }
        if (narg == 3) {
            LuaTypes luaTypes3 = INSTANCE;
            LuaValue arg4 = a.arg(1);
            Intrinsics.checkNotNullExpressionValue(arg4, "arg(...)");
            float num = LuaTypesKt.num(arg4);
            LuaValue arg5 = a.arg(2);
            Intrinsics.checkNotNullExpressionValue(arg5, "arg(...)");
            float num2 = LuaTypesKt.num(arg5);
            LuaValue arg6 = a.arg(3);
            Intrinsics.checkNotNullExpressionValue(arg6, "arg(...)");
            return luaTypes3.wrap(new CFrame(num, num2, LuaTypesKt.num(arg6), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null));
        }
        if (narg == 7) {
            LuaTypes luaTypes4 = INSTANCE;
            CFrame.Companion companion3 = CFrame.INSTANCE;
            LuaValue arg7 = a.arg(1);
            Intrinsics.checkNotNullExpressionValue(arg7, "arg(...)");
            float num3 = LuaTypesKt.num(arg7);
            LuaValue arg8 = a.arg(2);
            Intrinsics.checkNotNullExpressionValue(arg8, "arg(...)");
            float num4 = LuaTypesKt.num(arg8);
            LuaValue arg9 = a.arg(3);
            Intrinsics.checkNotNullExpressionValue(arg9, "arg(...)");
            Vector3 vector34 = new Vector3(num3, num4, LuaTypesKt.num(arg9));
            LuaValue arg10 = a.arg(4);
            Intrinsics.checkNotNullExpressionValue(arg10, "arg(...)");
            float num5 = LuaTypesKt.num(arg10);
            LuaValue arg11 = a.arg(5);
            Intrinsics.checkNotNullExpressionValue(arg11, "arg(...)");
            float num6 = LuaTypesKt.num(arg11);
            LuaValue arg12 = a.arg(6);
            Intrinsics.checkNotNullExpressionValue(arg12, "arg(...)");
            float num7 = LuaTypesKt.num(arg12);
            LuaValue arg13 = a.arg(7);
            Intrinsics.checkNotNullExpressionValue(arg13, "arg(...)");
            return luaTypes4.wrap(companion3.fromQuaternion(vector34, num5, num6, num7, LuaTypesKt.num(arg13)));
        }
        if (narg < 12) {
            throw new LuaError("Invalid number of arguments: " + narg);
        }
        LuaTypes luaTypes5 = INSTANCE;
        LuaValue arg14 = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg14, "arg(...)");
        float num8 = LuaTypesKt.num(arg14);
        LuaValue arg15 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg15, "arg(...)");
        float num9 = LuaTypesKt.num(arg15);
        LuaValue arg16 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg16, "arg(...)");
        float num10 = LuaTypesKt.num(arg16);
        LuaValue arg17 = a.arg(4);
        Intrinsics.checkNotNullExpressionValue(arg17, "arg(...)");
        float num11 = LuaTypesKt.num(arg17);
        LuaValue arg18 = a.arg(5);
        Intrinsics.checkNotNullExpressionValue(arg18, "arg(...)");
        float num12 = LuaTypesKt.num(arg18);
        LuaValue arg19 = a.arg(6);
        Intrinsics.checkNotNullExpressionValue(arg19, "arg(...)");
        float num13 = LuaTypesKt.num(arg19);
        LuaValue arg20 = a.arg(7);
        Intrinsics.checkNotNullExpressionValue(arg20, "arg(...)");
        float num14 = LuaTypesKt.num(arg20);
        LuaValue arg21 = a.arg(8);
        Intrinsics.checkNotNullExpressionValue(arg21, "arg(...)");
        float num15 = LuaTypesKt.num(arg21);
        LuaValue arg22 = a.arg(9);
        Intrinsics.checkNotNullExpressionValue(arg22, "arg(...)");
        float num16 = LuaTypesKt.num(arg22);
        LuaValue arg23 = a.arg(10);
        Intrinsics.checkNotNullExpressionValue(arg23, "arg(...)");
        float num17 = LuaTypesKt.num(arg23);
        LuaValue arg24 = a.arg(11);
        Intrinsics.checkNotNullExpressionValue(arg24, "arg(...)");
        float num18 = LuaTypesKt.num(arg24);
        LuaValue arg25 = a.arg(12);
        Intrinsics.checkNotNullExpressionValue(arg25, "arg(...)");
        return luaTypes5.wrap(new CFrame(num8, num9, num10, num11, num12, num13, num14, num15, num16, num17, num18, LuaTypesKt.num(arg25)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$126$lambda$119(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        CFrame.Companion companion = CFrame.INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float optNum2 = LuaTypesKt.optNum(arg2, 0.0f);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(companion.angles(optNum, optNum2, LuaTypesKt.optNum(arg3, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$126$lambda$120(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        CFrame.Companion companion = CFrame.INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float optNum2 = LuaTypesKt.optNum(arg2, 0.0f);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(companion.fromOrientation(optNum, optNum2, LuaTypesKt.optNum(arg3, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$126$lambda$121(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        CFrame.Companion companion = CFrame.INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float optNum2 = LuaTypesKt.optNum(arg2, 0.0f);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(companion.angles(optNum, optNum2, LuaTypesKt.optNum(arg3, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$126$lambda$122(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        CFrame.Companion companion = CFrame.INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector3)) {
            obj = null;
        }
        Vector3 vector3 = (Vector3) obj;
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        if (!(obj2 instanceof Vector3)) {
            obj2 = null;
        }
        Vector3 vector32 = (Vector3) obj2;
        if (vector32 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
        }
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        Object obj3 = arg3.isuserdata() ? arg3.touserdata() : null;
        Vector3 vector33 = (Vector3) (obj3 instanceof Vector3 ? obj3 : null);
        if (vector33 == null) {
            vector33 = Vector3.INSTANCE.getY();
        }
        return luaTypes.wrap(companion.lookAt(vector3, vector32, vector33));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$126$lambda$123(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector3)) {
            obj = null;
        }
        Vector3 vector3 = (Vector3) obj;
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaTypes luaTypes = INSTANCE;
        CFrame.Companion companion = CFrame.INSTANCE;
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        if (!(obj2 instanceof Vector3)) {
            obj2 = null;
        }
        Vector3 vector32 = (Vector3) obj2;
        if (vector32 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
        }
        Vector3 plus = vector3.plus(vector32);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        Object obj3 = arg3.isuserdata() ? arg3.touserdata() : null;
        Vector3 vector33 = (Vector3) (obj3 instanceof Vector3 ? obj3 : null);
        if (vector33 == null) {
            vector33 = Vector3.INSTANCE.getY();
        }
        return luaTypes.wrap(companion.lookAt(vector3, plus, vector33));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$126$lambda$124(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        CFrame.Companion companion = CFrame.INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj instanceof Vector3 ? obj : null);
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        return luaTypes.wrap(companion.fromAxisAngle(vector3, LuaTypesKt.num(arg2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$126$lambda$125(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector3)) {
            obj = null;
        }
        Vector3 vector3 = (Vector3) obj;
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        if (!(obj2 instanceof Vector3)) {
            obj2 = null;
        }
        Vector3 vector32 = (Vector3) obj2;
        if (vector32 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
        }
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        Object obj3 = arg3.isuserdata() ? arg3.touserdata() : null;
        if (!(obj3 instanceof Vector3)) {
            obj3 = null;
        }
        Vector3 vector33 = (Vector3) obj3;
        if (vector33 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg3));
        }
        LuaValue arg4 = a.arg(4);
        Intrinsics.checkNotNullExpressionValue(arg4, "arg(...)");
        Object obj4 = arg4.isuserdata() ? arg4.touserdata() : null;
        Vector3 vector34 = (Vector3) (obj4 instanceof Vector3 ? obj4 : null);
        if (vector34 == null) {
            vector34 = vector32.cross(vector33).getUnit();
        }
        return INSTANCE.wrap(CFrame.INSTANCE.fromColumns(vector3, vector32, vector33, vector34));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$132(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda128()));
        lib.set("fromRGB", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda129()));
        lib.set("fromHSV", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda130()));
        lib.set("fromHex", LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda131()));
        lib.set("toHSV", LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda132()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$132$lambda$127(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float optNum2 = LuaTypesKt.optNum(arg2, 0.0f);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(new Color3(optNum, optNum2, LuaTypesKt.optNum(arg3, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$132$lambda$128(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.wrap(Color3.INSTANCE.fromRGB(a.arg(1).optint(0), a.arg(2).optint(0), a.arg(3).optint(0)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$132$lambda$129(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        Color3.Companion companion = Color3.INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float num = LuaTypesKt.num(arg);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float num2 = LuaTypesKt.num(arg2);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(companion.fromHSV(num, num2, LuaTypesKt.num(arg3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$132$lambda$130(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        Color3.Companion companion = Color3.INSTANCE;
        String str = a.tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        Color3 fromHex = companion.fromHex(str);
        if (fromHex != null) {
            return luaTypes.wrap(fromHex);
        }
        throw new LuaError("Unable to convert characters to hex value");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$132$lambda$131(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Object obj = a.isuserdata() ? a.touserdata() : null;
        Color3 color3 = (Color3) (obj instanceof Color3 ? obj : null);
        if (color3 == null) {
            throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(a));
        }
        float[] hsv = color3.toHSV();
        LuaValue arg1 = LuaValue.varargsOf(new LuaValue[]{INSTANCE.n(hsv[0]), INSTANCE.n(hsv[1]), INSTANCE.n(hsv[2])}).arg1();
        Intrinsics.checkNotNullExpressionValue(arg1, "arg1(...)");
        return arg1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$137(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda48()));
        lib.set("random", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda49()));
        lib.set("Random", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda50()));
        for (Map.Entry entry : MapsKt.mapOf(TuplesKt.to("White", 1), TuplesKt.to("Black", 26), TuplesKt.to("Red", 21), TuplesKt.to("Blue", 23), TuplesKt.to("Green", 28), TuplesKt.to("Yellow", 24), TuplesKt.to("Gray", 194), TuplesKt.to("DarkGray", 199)).entrySet()) {
            lib.set((String) entry.getKey(), LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda51(((Number) entry.getValue()).intValue())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$137$lambda$133(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        if (arg.isnumber() && a.narg() >= 3) {
            LuaTypes luaTypes = INSTANCE;
            BrickColors brickColors = BrickColors.INSTANCE;
            LuaValue arg2 = a.arg(1);
            Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
            float num = LuaTypesKt.num(arg2);
            LuaValue arg3 = a.arg(2);
            Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
            float num2 = LuaTypesKt.num(arg3);
            LuaValue arg4 = a.arg(3);
            Intrinsics.checkNotNullExpressionValue(arg4, "arg(...)");
            return luaTypes.wrap(new BrickColorV(brickColors.closest(new Color3(num, num2, LuaTypesKt.num(arg4)))));
        }
        if (arg.isnumber()) {
            return INSTANCE.wrap(new BrickColorV(arg.toint()));
        }
        if (arg.isstring()) {
            LuaTypes luaTypes2 = INSTANCE;
            BrickColors brickColors2 = BrickColors.INSTANCE;
            String str = arg.tojstring();
            Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
            Integer byName = brickColors2.byName(str);
            return luaTypes2.wrap(new BrickColorV(byName != null ? byName.intValue() : 194));
        }
        if (!arg.isuserdata()) {
            return INSTANCE.wrap(new BrickColorV(194));
        }
        LuaTypes luaTypes3 = INSTANCE;
        BrickColors brickColors3 = BrickColors.INSTANCE;
        Intrinsics.checkNotNull(arg);
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        Color3 color3 = (Color3) (obj instanceof Color3 ? obj : null);
        if (color3 != null) {
            return luaTypes3.wrap(new BrickColorV(brickColors3.closest(color3)));
        }
        throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$137$lambda$134(Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        return INSTANCE.wrap(new BrickColorV(((Number) CollectionsKt.random(BrickColors.INSTANCE.getAll(), kotlin.random.Random.INSTANCE)).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$137$lambda$135(Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        return INSTANCE.wrap(new BrickColorV(((Number) CollectionsKt.random(BrickColors.INSTANCE.getAll(), kotlin.random.Random.INSTANCE)).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$137$lambda$136(int i, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        return INSTANCE.wrap(new BrickColorV(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$139(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda101()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$139$lambda$138(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        return luaTypes.wrap(new UDim(LuaTypesKt.optNum(arg, 0.0f), a.arg(2).optint(0)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$143(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda111()));
        lib.set("fromScale", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda112()));
        lib.set("fromOffset", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda113()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$143$lambda$140(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        if (!a.arg(1).isuserdata()) {
            LuaTypes luaTypes = INSTANCE;
            LuaValue arg = a.arg(1);
            Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
            float optNum = LuaTypesKt.optNum(arg, 0.0f);
            LuaValue arg2 = a.arg(2);
            Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
            int optNum2 = (int) LuaTypesKt.optNum(arg2, 0.0f);
            LuaValue arg3 = a.arg(3);
            Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
            float optNum3 = LuaTypesKt.optNum(arg3, 0.0f);
            LuaValue arg4 = a.arg(4);
            Intrinsics.checkNotNullExpressionValue(arg4, "arg(...)");
            return luaTypes.wrap(new UDim2(optNum, optNum2, optNum3, (int) LuaTypesKt.optNum(arg4, 0.0f)));
        }
        LuaValue arg5 = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg5, "arg(...)");
        Object obj = arg5.isuserdata() ? arg5.touserdata() : null;
        if (!(obj instanceof UDim)) {
            obj = null;
        }
        UDim uDim = (UDim) obj;
        if (uDim == null) {
            throw new LuaError("UDim expected, got " + INSTANCE.typeOf(arg5));
        }
        LuaValue arg6 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg6, "arg(...)");
        Object obj2 = arg6.isuserdata() ? arg6.touserdata() : null;
        UDim uDim2 = (UDim) (obj2 instanceof UDim ? obj2 : null);
        if (uDim2 != null) {
            return INSTANCE.wrap(new UDim2(uDim.getScale(), uDim.getOffset(), uDim2.getScale(), uDim2.getOffset()));
        }
        throw new LuaError("UDim expected, got " + INSTANCE.typeOf(arg6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$143$lambda$141(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        return luaTypes.wrap(new UDim2(optNum, 0, LuaTypesKt.optNum(arg2, 0.0f), 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$143$lambda$142(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        int optNum = (int) LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        return luaTypes.wrap(new UDim2(0.0f, optNum, 0.0f, (int) LuaTypesKt.optNum(arg2, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$145(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda147()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$145$lambda$144(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 1.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj = arg2.isuserdata() ? arg2.touserdata() : null;
        if (!(obj instanceof EnumItemV)) {
            obj = null;
        }
        EnumItemV enumItemV = (EnumItemV) obj;
        int value = enumItemV != null ? enumItemV.getValue() : 3;
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        Object obj2 = arg3.isuserdata() ? arg3.touserdata() : null;
        EnumItemV enumItemV2 = (EnumItemV) (obj2 instanceof EnumItemV ? obj2 : null);
        int value2 = enumItemV2 != null ? enumItemV2.getValue() : 1;
        int optint = a.arg(4).optint(0);
        boolean optboolean = a.arg(5).optboolean(false);
        LuaValue arg4 = a.arg(6);
        Intrinsics.checkNotNullExpressionValue(arg4, "arg(...)");
        return luaTypes.wrap(new TweenInfoV(optNum, value, value2, optint, optboolean, LuaTypesKt.optNum(arg4, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$147(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda143()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$147$lambda$146(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector3)) {
            obj = null;
        }
        Vector3 vector3 = (Vector3) obj;
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector3 vector32 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector32 != null) {
            return luaTypes.wrap(new Ray(vector3, vector32));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$149(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda11()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$149$lambda$148(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector3)) {
            obj = null;
        }
        Vector3 vector3 = (Vector3) obj;
        if (vector3 == null) {
            vector3 = Vector3.INSTANCE.getZERO();
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector3 vector32 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector32 == null) {
            vector32 = Vector3.INSTANCE.getZERO();
        }
        return INSTANCE.wrap(new Region3V(vector3.min(vector32), vector3.max(vector32)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$151(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda142()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$151$lambda$150(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector3int16)) {
            obj = null;
        }
        Vector3int16 vector3int16 = (Vector3int16) obj;
        if (vector3int16 == null) {
            vector3int16 = new Vector3int16(0, 0, 0);
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector3int16 vector3int162 = (Vector3int16) (obj2 instanceof Vector3int16 ? obj2 : null);
        if (vector3int162 == null) {
            vector3int162 = new Vector3int16(0, 0, 0);
        }
        return luaTypes.wrap(new Region3int16V(vector3int16, vector3int162));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$153(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda127()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$153$lambda$152(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float num = LuaTypesKt.num(arg);
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        return luaTypes.wrap(new NumberRange(num, LuaTypesKt.optNum(arg2, num)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$155(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda146()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$155$lambda$154(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float num = LuaTypesKt.num(arg);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float num2 = LuaTypesKt.num(arg2);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(new NumberKey(num, num2, LuaTypesKt.optNum(arg3, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$157(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda45()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$157$lambda$156(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float num = LuaTypesKt.num(arg);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj = arg2.isuserdata() ? arg2.touserdata() : null;
        Color3 color3 = (Color3) (obj instanceof Color3 ? obj : null);
        if (color3 != null) {
            return luaTypes.wrap(new ColorKey(num, color3, 0.0f));
        }
        throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$160(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda145()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$160$lambda$159(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        if (!arg.istable()) {
            if (a.narg() < 2) {
                LuaTypes luaTypes = INSTANCE;
                Intrinsics.checkNotNull(arg);
                return luaTypes.wrap(new NumberSequence(CollectionsKt.listOf((Object[]) new NumberKey[]{new NumberKey(0.0f, LuaTypesKt.num(arg), 0.0f), new NumberKey(1.0f, LuaTypesKt.num(arg), 0.0f)})));
            }
            LuaTypes luaTypes2 = INSTANCE;
            Intrinsics.checkNotNull(arg);
            LuaValue arg2 = a.arg(2);
            Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
            return luaTypes2.wrap(new NumberSequence(CollectionsKt.listOf((Object[]) new NumberKey[]{new NumberKey(0.0f, LuaTypesKt.num(arg), 0.0f), new NumberKey(1.0f, LuaTypesKt.num(arg2), 0.0f)})));
        }
        LuaTypes luaTypes3 = INSTANCE;
        IntRange intRange = new IntRange(1, arg.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            LuaValue luaValue = arg.get(((IntIterator) it).nextInt());
            Intrinsics.checkNotNullExpressionValue(luaValue, "get(...)");
            Object obj = luaValue.isuserdata() ? luaValue.touserdata() : null;
            IntRange intRange2 = intRange;
            NumberKey numberKey = (NumberKey) (obj instanceof NumberKey ? obj : null);
            if (numberKey == null) {
                throw new LuaError("NumberSequenceKeypoint expected, got " + INSTANCE.typeOf(luaValue));
            }
            arrayList.add(numberKey);
            intRange = intRange2;
        }
        return luaTypes3.wrap(new NumberSequence(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$163(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda65()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$163$lambda$162(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        if (arg.istable()) {
            LuaTypes luaTypes = INSTANCE;
            IntRange intRange = new IntRange(1, arg.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                LuaValue luaValue = arg.get(((IntIterator) it).nextInt());
                Intrinsics.checkNotNullExpressionValue(luaValue, "get(...)");
                Object obj = luaValue.isuserdata() ? luaValue.touserdata() : null;
                IntRange intRange2 = intRange;
                if (!(obj instanceof ColorKey)) {
                    obj = null;
                }
                ColorKey colorKey = (ColorKey) obj;
                if (colorKey == null) {
                    throw new LuaError("ColorSequenceKeypoint expected, got " + INSTANCE.typeOf(luaValue));
                }
                arrayList.add(colorKey);
                intRange = intRange2;
            }
            return luaTypes.wrap(new ColorSequence(arrayList));
        }
        if (a.narg() < 2) {
            Intrinsics.checkNotNull(arg);
            Object obj2 = arg.isuserdata() ? arg.touserdata() : null;
            Color3 color3 = (Color3) (!(obj2 instanceof Color3) ? null : obj2);
            if (color3 != null) {
                return INSTANCE.wrap(new ColorSequence(CollectionsKt.listOf((Object[]) new ColorKey[]{new ColorKey(0.0f, color3, 0.0f), new ColorKey(1.0f, color3, 0.0f)})));
            }
            throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaTypes luaTypes2 = INSTANCE;
        ColorKey[] colorKeyArr = new ColorKey[2];
        Intrinsics.checkNotNull(arg);
        Object obj3 = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj3 instanceof Color3)) {
            obj3 = null;
        }
        Color3 color32 = (Color3) obj3;
        if (color32 == null) {
            throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg));
        }
        colorKeyArr[0] = new ColorKey(0.0f, color32, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj4 = arg2.isuserdata() ? arg2.touserdata() : null;
        Color3 color33 = (Color3) (!(obj4 instanceof Color3) ? null : obj4);
        if (color33 == null) {
            throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg2));
        }
        colorKeyArr[1] = new ColorKey(1.0f, color33, 0.0f);
        return luaTypes2.wrap(new ColorSequence(CollectionsKt.listOf((Object[]) colorKeyArr)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$165(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda0()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$165$lambda$164(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.wrap(new RandomV(a.arg(1).isnil() ? System.nanoTime() : a.arg(1).tolong()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$167(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda110()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$167$lambda$166(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.0f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float optNum2 = LuaTypesKt.optNum(arg2, 0.0f);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        float optNum3 = LuaTypesKt.optNum(arg3, 0.0f);
        LuaValue arg4 = a.arg(4);
        Intrinsics.checkNotNullExpressionValue(arg4, "arg(...)");
        return luaTypes.wrap(new Rect(optNum, optNum2, optNum3, LuaTypesKt.optNum(arg4, 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$169(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda144()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$169$lambda$168(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        if (a.arg(1).isuserdata()) {
            return INSTANCE.wrap(new PhysicalProps(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 126, null));
        }
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float optNum = LuaTypesKt.optNum(arg, 0.7f);
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        float optNum2 = LuaTypesKt.optNum(arg2, 0.3f);
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        float optNum3 = LuaTypesKt.optNum(arg3, 0.5f);
        LuaValue arg4 = a.arg(4);
        Intrinsics.checkNotNullExpressionValue(arg4, "arg(...)");
        float optNum4 = LuaTypesKt.optNum(arg4, 1.0f);
        LuaValue arg5 = a.arg(5);
        Intrinsics.checkNotNullExpressionValue(arg5, "arg(...)");
        return luaTypes.wrap(new PhysicalProps(1, optNum, optNum2, optNum3, optNum4, LuaTypesKt.optNum(arg5, 1.0f), 0.0f, 64, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$173(LuaTable lib) {
        Intrinsics.checkNotNullParameter(lib, "$this$lib");
        lib.set("new", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda97()));
        lib.set("fromEnum", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda98()));
        lib.set("fromName", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda99()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$173$lambda$170(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        String str = a.arg(1).tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        LuaValue arg = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof EnumItemV)) {
            obj = null;
        }
        EnumItemV enumItemV = (EnumItemV) obj;
        int value = enumItemV != null ? enumItemV.getValue() : 400;
        LuaValue arg2 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        EnumItemV enumItemV2 = (EnumItemV) (obj2 instanceof EnumItemV ? obj2 : null);
        return luaTypes.wrap(new FontValue(str, value, enumItemV2 != null ? enumItemV2.getValue() : 0, ""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$173$lambda$171(Varargs a) {
        String str;
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        EnumItemV enumItemV = (EnumItemV) (obj instanceof EnumItemV ? obj : null);
        if (enumItemV == null || (str = enumItemV.getName()) == null) {
            str = "SourceSansPro";
        }
        return luaTypes.wrap(new FontValue("rbxasset://fonts/families/" + str + ".json", 400, 0, ""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$173$lambda$172(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.wrap(new FontValue("rbxasset://fonts/families/" + a.arg(1).tojstring() + ".json", 400, 0, ""));
    }

    private static final void install$lib(LuaTable luaTable, String str, Function1<? super LuaTable, Unit> function1) {
        LuaTable luaTable2 = new LuaTable();
        function1.invoke(luaTable2);
        luaTable.set(str, luaTable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$10(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Vector3 arg3 = INSTANCE.arg3(a, 1);
        return INSTANCE.wrap(new Vector3((float) Math.floor(arg3.getX()), (float) Math.floor(arg3.getY()), (float) Math.floor(arg3.getZ())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$11(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Vector3 arg3 = INSTANCE.arg3(a, 1);
        return INSTANCE.wrap(new Vector3((float) Math.ceil(arg3.getX()), (float) Math.ceil(arg3.getY()), (float) Math.ceil(arg3.getZ())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$12(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Vector3 arg3 = INSTANCE.arg3(a, 1);
        return INSTANCE.wrap(new Vector3(Math.signum(arg3.getX()), Math.signum(arg3.getY()), Math.signum(arg3.getZ())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$13(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.wrap(INSTANCE.arg3(a, 1).min(INSTANCE.arg3(a, 2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$14(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.wrap(INSTANCE.arg3(a, 1).max(INSTANCE.arg3(a, 2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$15(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.n((float) Math.acos(RangesKt.coerceIn(INSTANCE.arg3(a, 1).getUnit().dot(INSTANCE.arg3(a, 2).getUnit()), -1.0f, 1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$16(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        LuaBoolean valueOf = LuaValue.valueOf(INSTANCE.arg3(a, 1).minus(INSTANCE.arg3(a, 2)).getMagnitude() <= LuaTypesKt.optNum(arg, 1.0E-5f));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$6(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.n(INSTANCE.arg3(a, 1).dot(INSTANCE.arg3(a, 2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$7(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.wrap(INSTANCE.arg3(a, 1).cross(INSTANCE.arg3(a, 2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$8(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        Vector3 arg3 = INSTANCE.arg3(a, 1);
        Vector3 arg32 = INSTANCE.arg3(a, 2);
        LuaValue arg = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        return luaTypes.wrap(arg3.lerp(arg32, LuaTypesKt.num(arg)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$17$lambda$9(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return INSTANCE.wrap(INSTANCE.arg3(a, 1).abs());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$23$lambda$18(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof Vector3)) {
            obj = null;
        }
        Vector3 vector3 = (Vector3) obj;
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        Vector3 vector32 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector32 != null) {
            return luaTypes.wrap(vector3.plus(vector32));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$23$lambda$19(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof Vector3)) {
            obj = null;
        }
        Vector3 vector3 = (Vector3) obj;
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        Vector3 vector32 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector32 != null) {
            return luaTypes.wrap(vector3.minus(vector32));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$23$lambda$20(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a.isnumber()) {
            LuaTypes luaTypes = INSTANCE;
            Object obj = b.isuserdata() ? b.touserdata() : null;
            Vector3 vector3 = (Vector3) (obj instanceof Vector3 ? obj : null);
            if (vector3 != null) {
                return luaTypes.wrap(vector3.times(LuaTypesKt.num(a)));
            }
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(b));
        }
        if (b.isnumber()) {
            LuaTypes luaTypes2 = INSTANCE;
            Object obj2 = a.isuserdata() ? a.touserdata() : null;
            Vector3 vector32 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
            if (vector32 != null) {
                return luaTypes2.wrap(vector32.times(LuaTypesKt.num(b)));
            }
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(a));
        }
        LuaTypes luaTypes3 = INSTANCE;
        Object obj3 = a.isuserdata() ? a.touserdata() : null;
        if (!(obj3 instanceof Vector3)) {
            obj3 = null;
        }
        Vector3 vector33 = (Vector3) obj3;
        if (vector33 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj4 = b.isuserdata() ? b.touserdata() : null;
        Vector3 vector34 = (Vector3) (obj4 instanceof Vector3 ? obj4 : null);
        if (vector34 != null) {
            return luaTypes3.wrap(vector33.times(vector34));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$23$lambda$21(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (b.isnumber()) {
            LuaTypes luaTypes = INSTANCE;
            Object obj = a.isuserdata() ? a.touserdata() : null;
            Vector3 vector3 = (Vector3) (obj instanceof Vector3 ? obj : null);
            if (vector3 != null) {
                return luaTypes.wrap(vector3.div(LuaTypesKt.num(b)));
            }
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(a));
        }
        if (a.isnumber()) {
            Object obj2 = b.isuserdata() ? b.touserdata() : null;
            Vector3 vector32 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
            if (vector32 != null) {
                return INSTANCE.wrap(new Vector3(LuaTypesKt.num(a) / vector32.getX(), LuaTypesKt.num(a) / vector32.getY(), LuaTypesKt.num(a) / vector32.getZ()));
            }
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(b));
        }
        LuaTypes luaTypes2 = INSTANCE;
        Object obj3 = a.isuserdata() ? a.touserdata() : null;
        if (!(obj3 instanceof Vector3)) {
            obj3 = null;
        }
        Vector3 vector33 = (Vector3) obj3;
        if (vector33 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj4 = b.isuserdata() ? b.touserdata() : null;
        Vector3 vector34 = (Vector3) (obj4 instanceof Vector3 ? obj4 : null);
        if (vector34 != null) {
            return luaTypes2.wrap(vector33.div(vector34));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$23$lambda$22(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj instanceof Vector3 ? obj : null);
        if (vector3 != null) {
            return luaTypes.wrap(vector3.unaryMinus());
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$26$lambda$24(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector2)) {
            obj = null;
        }
        Vector2 vector2 = (Vector2) obj;
        if (vector2 == null) {
            throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector2 vector22 = (Vector2) (obj2 instanceof Vector2 ? obj2 : null);
        if (vector22 != null) {
            return luaTypes.n(vector2.dot(vector22));
        }
        throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$26$lambda$25(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector2)) {
            obj = null;
        }
        Vector2 vector2 = (Vector2) obj;
        if (vector2 == null) {
            throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector2 vector22 = (Vector2) (obj2 instanceof Vector2 ? obj2 : null);
        if (vector22 == null) {
            throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(arg2));
        }
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(vector2.lerp(vector22, LuaTypesKt.num(arg3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$32$lambda$27(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof Vector2)) {
            obj = null;
        }
        Vector2 vector2 = (Vector2) obj;
        if (vector2 == null) {
            throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        Vector2 vector22 = (Vector2) (obj2 instanceof Vector2 ? obj2 : null);
        if (vector22 != null) {
            return luaTypes.wrap(vector2.plus(vector22));
        }
        throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$32$lambda$28(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof Vector2)) {
            obj = null;
        }
        Vector2 vector2 = (Vector2) obj;
        if (vector2 == null) {
            throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        Vector2 vector22 = (Vector2) (obj2 instanceof Vector2 ? obj2 : null);
        if (vector22 != null) {
            return luaTypes.wrap(vector2.minus(vector22));
        }
        throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$32$lambda$29(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a.isnumber()) {
            LuaTypes luaTypes = INSTANCE;
            Object obj = b.isuserdata() ? b.touserdata() : null;
            Vector2 vector2 = (Vector2) (obj instanceof Vector2 ? obj : null);
            if (vector2 != null) {
                return luaTypes.wrap(vector2.times(LuaTypesKt.num(a)));
            }
            throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(b));
        }
        if (b.isnumber()) {
            LuaTypes luaTypes2 = INSTANCE;
            Object obj2 = a.isuserdata() ? a.touserdata() : null;
            Vector2 vector22 = (Vector2) (obj2 instanceof Vector2 ? obj2 : null);
            if (vector22 != null) {
                return luaTypes2.wrap(vector22.times(LuaTypesKt.num(b)));
            }
            throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(a));
        }
        LuaTypes luaTypes3 = INSTANCE;
        Object obj3 = a.isuserdata() ? a.touserdata() : null;
        if (!(obj3 instanceof Vector2)) {
            obj3 = null;
        }
        Vector2 vector23 = (Vector2) obj3;
        if (vector23 == null) {
            throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj4 = b.isuserdata() ? b.touserdata() : null;
        Vector2 vector24 = (Vector2) (obj4 instanceof Vector2 ? obj4 : null);
        if (vector24 != null) {
            return luaTypes3.wrap(vector23.times(vector24));
        }
        throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$32$lambda$30(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        Vector2 vector2 = (Vector2) (obj instanceof Vector2 ? obj : null);
        if (vector2 != null) {
            return luaTypes.wrap(vector2.div(LuaTypesKt.num(b)));
        }
        throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$32$lambda$31(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        Vector2 vector2 = (Vector2) (obj instanceof Vector2 ? obj : null);
        if (vector2 != null) {
            return luaTypes.wrap(vector2.unaryMinus());
        }
        throw new LuaError("Vector2 expected, got " + INSTANCE.typeOf(a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$33(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        CFrame cFrame = (CFrame) (obj instanceof CFrame ? obj : null);
        if (cFrame != null) {
            return luaTypes.wrap(cFrame.inverse());
        }
        throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$34(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        CFrame cFrame2 = (CFrame) (obj2 instanceof CFrame ? obj2 : null);
        if (cFrame2 == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg2));
        }
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(cFrame.lerp(cFrame2, LuaTypesKt.num(arg3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$35(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        CFrame cFrame2 = (CFrame) (obj2 instanceof CFrame ? obj2 : null);
        if (cFrame2 != null) {
            return luaTypes.wrap(cFrame.times(cFrame2));
        }
        throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$36(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        CFrame inverse = cFrame.inverse();
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        CFrame cFrame2 = (CFrame) (obj2 instanceof CFrame ? obj2 : null);
        if (cFrame2 != null) {
            return luaTypes.wrap(inverse.times(cFrame2));
        }
        throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$37(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector3 != null) {
            return luaTypes.wrap(cFrame.times(vector3));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$38(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector3 != null) {
            return luaTypes.wrap(cFrame.pointToObject(vector3));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$39(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector3 != null) {
            return luaTypes.wrap(cFrame.vectorToWorld(vector3));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$40(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector3 != null) {
            return luaTypes.wrap(cFrame.vectorToObject(vector3));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$41(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        CFrame cFrame = (CFrame) (obj instanceof CFrame ? obj : null);
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        Vector3 eulerXYZ = cFrame.toEulerXYZ();
        Varargs varargsOf = LuaValue.varargsOf(new LuaValue[]{INSTANCE.n(eulerXYZ.getX()), INSTANCE.n(eulerXYZ.getY()), INSTANCE.n(eulerXYZ.getZ())});
        Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
        return varargsOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$42(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        CFrame cFrame = (CFrame) (obj instanceof CFrame ? obj : null);
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        Vector3 orientation = cFrame.toOrientation();
        Varargs varargsOf = LuaValue.varargsOf(new LuaValue[]{INSTANCE.n(orientation.getX()), INSTANCE.n(orientation.getY()), INSTANCE.n(orientation.getZ())});
        Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
        return varargsOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$44(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        CFrame cFrame = (CFrame) (obj instanceof CFrame ? obj : null);
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        float[] components = cFrame.components();
        ArrayList arrayList = new ArrayList(components.length);
        for (float f : components) {
            arrayList.add(INSTANCE.n(f));
        }
        Varargs varargsOf = LuaValue.varargsOf((LuaValue[]) arrayList.toArray(new LuaValue[0]));
        Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
        return varargsOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$45(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        CFrame cFrame = (CFrame) (obj instanceof CFrame ? obj : null);
        if (cFrame != null) {
            return luaTypes.wrap(cFrame.orthonormalize());
        }
        throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$47$lambda$46(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        CFrame cFrame = (CFrame) (obj instanceof CFrame ? obj : null);
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(arg));
        }
        float[] quaternion = cFrame.toQuaternion();
        float acos = ((float) Math.acos(RangesKt.coerceIn(quaternion[3], -1.0f, 1.0f))) * 2.0f;
        float sqrt = (float) Math.sqrt(RangesKt.coerceAtLeast(1.0f - (quaternion[3] * quaternion[3]), 0.0f));
        Varargs varargsOf = LuaValue.varargsOf(INSTANCE.wrap(sqrt < 1.0E-5f ? Vector3.INSTANCE.getX() : new Vector3(quaternion[0] / sqrt, quaternion[1] / sqrt, quaternion[2] / sqrt)), INSTANCE.n(acos));
        Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
        return varargsOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$51$lambda$48(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Object obj = a.isuserdata() ? a.touserdata() : null;
        CFrame cFrame = (CFrame) (obj instanceof CFrame ? obj : null);
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.touserdata();
        if (obj2 instanceof CFrame) {
            return INSTANCE.wrap(cFrame.times((CFrame) obj2));
        }
        if (obj2 instanceof Vector3) {
            return INSTANCE.wrap(cFrame.times((Vector3) obj2));
        }
        throw new LuaError("invalid argument to CFrame multiplication");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$51$lambda$49(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector3 != null) {
            return luaTypes.wrap(cFrame.plus(vector3));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$51$lambda$50(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        LuaTypes luaTypes = INSTANCE;
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof CFrame)) {
            obj = null;
        }
        CFrame cFrame = (CFrame) obj;
        if (cFrame == null) {
            throw new LuaError("CFrame expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector3 != null) {
            return luaTypes.wrap(cFrame.minus(vector3));
        }
        throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$55$lambda$52(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Color3)) {
            obj = null;
        }
        Color3 color3 = (Color3) obj;
        if (color3 == null) {
            throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Color3 color32 = (Color3) (obj2 instanceof Color3 ? obj2 : null);
        if (color32 == null) {
            throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg2));
        }
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(color3.lerp(color32, LuaTypesKt.num(arg3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$55$lambda$53(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        Color3 color3 = (Color3) (obj instanceof Color3 ? obj : null);
        if (color3 == null) {
            throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg));
        }
        float[] hsv = color3.toHSV();
        Varargs varargsOf = LuaValue.varargsOf(new LuaValue[]{INSTANCE.n(hsv[0]), INSTANCE.n(hsv[1]), INSTANCE.n(hsv[2])});
        Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
        return varargsOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$55$lambda$54(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        Color3 color3 = (Color3) (obj instanceof Color3 ? obj : null);
        if (color3 == null) {
            throw new LuaError("Color3 expected, got " + INSTANCE.typeOf(arg));
        }
        String lowerCase = color3.toHex().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        LuaString valueOf = LuaValue.valueOf(lowerCase);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$60$lambda$58(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof UDim)) {
            obj = null;
        }
        UDim uDim = (UDim) obj;
        if (uDim == null) {
            throw new LuaError("UDim expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        UDim uDim2 = (UDim) (obj2 instanceof UDim ? obj2 : null);
        if (uDim2 != null) {
            return INSTANCE.wrap(new UDim(uDim.getScale() + uDim2.getScale(), uDim.getOffset() + uDim2.getOffset()));
        }
        throw new LuaError("UDim expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$60$lambda$59(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof UDim)) {
            obj = null;
        }
        UDim uDim = (UDim) obj;
        if (uDim == null) {
            throw new LuaError("UDim expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        UDim uDim2 = (UDim) (obj2 instanceof UDim ? obj2 : null);
        if (uDim2 != null) {
            return INSTANCE.wrap(new UDim(uDim.getScale() - uDim2.getScale(), uDim.getOffset() - uDim2.getOffset()));
        }
        throw new LuaError("UDim expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$62$lambda$61(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        LuaValue arg = a.arg(1);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof UDim2)) {
            obj = null;
        }
        UDim2 uDim2 = (UDim2) obj;
        if (uDim2 == null) {
            throw new LuaError("UDim2 expected, got " + INSTANCE.typeOf(arg));
        }
        LuaValue arg2 = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        UDim2 uDim22 = (UDim2) (obj2 instanceof UDim2 ? obj2 : null);
        if (uDim22 == null) {
            throw new LuaError("UDim2 expected, got " + INSTANCE.typeOf(arg2));
        }
        LuaValue arg3 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg3, "arg(...)");
        return luaTypes.wrap(uDim2.lerp(uDim22, LuaTypesKt.num(arg3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$66$lambda$63(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof UDim2)) {
            obj = null;
        }
        UDim2 uDim2 = (UDim2) obj;
        if (uDim2 == null) {
            throw new LuaError("UDim2 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        UDim2 uDim22 = (UDim2) (obj2 instanceof UDim2 ? obj2 : null);
        if (uDim22 != null) {
            return INSTANCE.wrap(new UDim2(uDim2.getXs() + uDim22.getXs(), uDim2.getXo() + uDim22.getXo(), uDim2.getYs() + uDim22.getYs(), uDim2.getYo() + uDim22.getYo()));
        }
        throw new LuaError("UDim2 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$66$lambda$64(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Object obj = a.isuserdata() ? a.touserdata() : null;
        if (!(obj instanceof UDim2)) {
            obj = null;
        }
        UDim2 uDim2 = (UDim2) obj;
        if (uDim2 == null) {
            throw new LuaError("UDim2 expected, got " + INSTANCE.typeOf(a));
        }
        Object obj2 = b.isuserdata() ? b.touserdata() : null;
        UDim2 uDim22 = (UDim2) (obj2 instanceof UDim2 ? obj2 : null);
        if (uDim22 != null) {
            return INSTANCE.wrap(new UDim2(uDim2.getXs() - uDim22.getXs(), uDim2.getXo() - uDim22.getXo(), uDim2.getYs() - uDim22.getYs(), uDim2.getYo() - uDim22.getYo()));
        }
        throw new LuaError("UDim2 expected, got " + INSTANCE.typeOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$66$lambda$65(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Object obj = a.isuserdata() ? a.touserdata() : null;
        UDim2 uDim2 = (UDim2) (obj instanceof UDim2 ? obj : null);
        if (uDim2 != null) {
            return INSTANCE.wrap(new UDim2(-uDim2.getXs(), -uDim2.getXo(), -uDim2.getYs(), -uDim2.getYo()));
        }
        throw new LuaError("UDim2 expected, got " + INSTANCE.typeOf(a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$68$lambda$67(EnumItemV enumItemV, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaBoolean valueOf = LuaValue.valueOf(Intrinsics.areEqual(a.arg(2).tojstring(), enumItemV.getType()));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$70$lambda$69(LuaValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = it.touserdata();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.lua.EnumItemV");
        EnumItemV enumItemV = (EnumItemV) obj;
        LuaString valueOf = LuaValue.valueOf("Enum." + enumItemV.getType() + "." + enumItemV.getName());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$76$lambda$72(EnumTypeV enumTypeV, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        LuaTable luaTable = new LuaTable();
        LinkedHashMap<String, Integer> linkedHashMap = Enums.INSTANCE.getTypes().get(enumTypeV.getName());
        if (linkedHashMap != null) {
            for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
                luaTable.insert(0, INSTANCE.wrap(new EnumItemV(enumTypeV.getName(), entry.getKey(), entry.getValue().intValue())));
            }
        }
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$76$lambda$73(EnumTypeV enumTypeV, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = INSTANCE;
        String name = enumTypeV.getName();
        String str = a.arg(2).tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        LuaValue NIL = luaTypes.enumItem(name, str);
        if (NIL == null) {
            NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
        }
        return NIL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$76$lambda$75(EnumTypeV enumTypeV, Varargs a) {
        LuaValue NIL;
        Intrinsics.checkNotNullParameter(a, "a");
        String itemName = Enums.INSTANCE.itemName(enumTypeV.getName(), a.arg(2).toint());
        if (itemName == null || (NIL = INSTANCE.wrap(new EnumItemV(enumTypeV.getName(), itemName, a.arg(2).toint()))) == null) {
            NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
        }
        return NIL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue lambda$78$lambda$77(LuaValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = it.touserdata();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.exampletest.mobilestudiotest.lua.EnumTypeV");
        LuaString valueOf = LuaValue.valueOf(((EnumTypeV) obj).getName());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$82$lambda$81(Ray ray, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        Vector3 vector3 = (Vector3) (obj instanceof Vector3 ? obj : null);
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + INSTANCE.typeOf(arg));
        }
        Vector3 unit = ray.getDirection().getUnit();
        return INSTANCE.wrap(ray.getOrigin().plus(unit.times(RangesKt.coerceAtLeast(vector3.minus(ray.getOrigin()).dot(unit), 0.0f))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$84$lambda$83(Region3V region3V, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        float coerceAtLeast = RangesKt.coerceAtLeast(LuaTypesKt.num(arg), 0.001f);
        return INSTANCE.wrap(new Region3V(new Vector3(lambda$84$lambda$83$lo(coerceAtLeast, region3V.getMin().getX()), lambda$84$lambda$83$lo(coerceAtLeast, region3V.getMin().getY()), lambda$84$lambda$83$lo(coerceAtLeast, region3V.getMin().getZ())), new Vector3(lambda$84$lambda$83$hi(coerceAtLeast, region3V.getMax().getX()), lambda$84$lambda$83$hi(coerceAtLeast, region3V.getMax().getY()), lambda$84$lambda$83$hi(coerceAtLeast, region3V.getMax().getZ()))));
    }

    private static final float lambda$84$lambda$83$hi(float f, float f2) {
        return ((float) Math.ceil(f2 / f)) * f;
    }

    private static final float lambda$84$lambda$83$lo(float f, float f2) {
        return ((float) Math.floor(f2 / f)) * f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$89$lambda$86(Random random, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        double optNum = LuaTypesKt.optNum(arg, 0.0f);
        Intrinsics.checkNotNullExpressionValue(a.arg(3), "arg(...)");
        LuaNumber valueOf = LuaValue.valueOf((random.nextDouble() * (LuaTypesKt.optNum(r0, 1.0f) - optNum)) + optNum);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$89$lambda$87(Random random, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        int checkint = a.arg(2).checkint();
        LuaInteger valueOf = LuaValue.valueOf(random.nextInt(Math.max(1, (a.arg(3).checkint() - checkint) + 1)) + checkint);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs lambda$89$lambda$88(Random random, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        return INSTANCE.wrap(new Vector3((float) random.nextGaussian(), (float) random.nextGaussian(), (float) random.nextGaussian()).getUnit());
    }

    private final void meta(Class<?> cls, String typeName, Function2<Object, ? super String, ? extends LuaValue> index, Function1<? super LuaTable, Unit> extra) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("__type", typeName);
        luaTable.set(LuaValue.INDEX, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda12(index, typeName)));
        luaTable.set(LuaValue.NEWINDEX, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda13()));
        luaTable.set(LuaValue.TOSTRING, LuaTypesKt.fn1(new LuaTypes$$ExternalSyntheticLambda14()));
        extra.invoke(luaTable);
        metas.put(cls, luaTable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void meta$default(LuaTypes luaTypes, Class cls, String str, Function2 function2, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new LuaTypes$$ExternalSyntheticLambda109();
        }
        luaTypes.meta(cls, str, function2, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit meta$lambda$2(LuaTable luaTable) {
        Intrinsics.checkNotNullParameter(luaTable, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue meta$lambda$3(Function2 function2, String str, LuaValue self, LuaValue key) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(key, "key");
        String str2 = key.tojstring();
        Object obj = self.touserdata();
        Intrinsics.checkNotNullExpressionValue(obj, "touserdata(...)");
        Intrinsics.checkNotNull(str2);
        LuaValue luaValue = (LuaValue) function2.invoke(obj, str2);
        if (luaValue != null) {
            return luaValue;
        }
        throw new LuaError(str2 + " is not a valid member of " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue meta$lambda$4(LuaValue luaValue, LuaValue key) {
        Intrinsics.checkNotNullParameter(luaValue, "<unused var>");
        Intrinsics.checkNotNullParameter(key, "key");
        throw new LuaError(key.tojstring() + " cannot be assigned to");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue meta$lambda$5(LuaValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaString valueOf = LuaValue.valueOf(it.touserdata().toString());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    private final LuaValue method(Function1<? super Varargs, ? extends Varargs> f) {
        return LuaTypesKt.fnv(f);
    }

    private final LuaValue n(float v) {
        LuaNumber valueOf = LuaValue.valueOf(v);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    public final float absf(float x) {
        return Math.abs(x);
    }

    public final float ease(int style, int dir, float t0) {
        float coerceIn = RangesKt.coerceIn(t0, 0.0f, 1.0f);
        switch (dir) {
            case 0:
                return ease$easeIn(style, coerceIn);
            case 1:
                return 1.0f - ease$easeIn(style, 1.0f - coerceIn);
            default:
                return coerceIn < 0.5f ? ease$easeIn(style, coerceIn * 2.0f) / 2.0f : 1.0f - (ease$easeIn(style, (1.0f - coerceIn) * 2.0f) / 2.0f);
        }
    }

    public final LuaValue enumItem(String type, String name) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        LinkedHashMap<String, Integer> linkedHashMap = Enums.INSTANCE.getTypes().get(type);
        Integer num = linkedHashMap != null ? linkedHashMap.get(name) : null;
        if (num != null) {
            return wrap(new EnumItemV(type, name, num.intValue()));
        }
        if ((name.length() == 0) || !Character.isLetter(name.charAt(0))) {
            return null;
        }
        return wrap(new EnumItemV(type, name, (name.hashCode() & SupportMenu.USER_MASK) | 65536));
    }

    public final LuaValue enumLib() {
        LuaTable luaTable = new LuaTable();
        luaTable.set(LuaValue.INDEX, LuaTypesKt.fn2(new LuaTypes$$ExternalSyntheticLambda107()));
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set("GetEnums", LuaTypesKt.fnv(new LuaTypes$$ExternalSyntheticLambda108()));
        luaTable2.setmetatable(luaTable);
        return luaTable2;
    }

    public final void install(LuaTable g) {
        Intrinsics.checkNotNullParameter(g, "g");
        install$lib(g, "Vector3", new LuaTypes$$ExternalSyntheticLambda75());
        install$lib(g, "Vector2", new LuaTypes$$ExternalSyntheticLambda86());
        install$lib(g, "Vector3int16", new LuaTypes$$ExternalSyntheticLambda89());
        install$lib(g, "Content", new LuaTypes$$ExternalSyntheticLambda90());
        install$lib(g, "CFrame", new LuaTypes$$ExternalSyntheticLambda91());
        install$lib(g, "Color3", new LuaTypes$$ExternalSyntheticLambda92());
        install$lib(g, "BrickColor", new LuaTypes$$ExternalSyntheticLambda93());
        install$lib(g, "UDim", new LuaTypes$$ExternalSyntheticLambda94());
        install$lib(g, "UDim2", new LuaTypes$$ExternalSyntheticLambda95());
        install$lib(g, "TweenInfo", new LuaTypes$$ExternalSyntheticLambda96());
        install$lib(g, "Ray", new LuaTypes$$ExternalSyntheticLambda76());
        install$lib(g, "Region3", new LuaTypes$$ExternalSyntheticLambda77());
        install$lib(g, "Region3int16", new LuaTypes$$ExternalSyntheticLambda78());
        install$lib(g, "NumberRange", new LuaTypes$$ExternalSyntheticLambda79());
        install$lib(g, "NumberSequenceKeypoint", new LuaTypes$$ExternalSyntheticLambda80());
        install$lib(g, "ColorSequenceKeypoint", new LuaTypes$$ExternalSyntheticLambda81());
        install$lib(g, "NumberSequence", new LuaTypes$$ExternalSyntheticLambda82());
        install$lib(g, "ColorSequence", new LuaTypes$$ExternalSyntheticLambda83());
        install$lib(g, "Random", new LuaTypes$$ExternalSyntheticLambda84());
        install$lib(g, "Rect", new LuaTypes$$ExternalSyntheticLambda85());
        install$lib(g, "PhysicalProperties", new LuaTypes$$ExternalSyntheticLambda87());
        install$lib(g, "Font", new LuaTypes$$ExternalSyntheticLambda88());
        g.set("Enum", enumLib());
    }

    public final Object lerpValue(Object a, Object b, float t) {
        return ((a instanceof Float) && (b instanceof Number)) ? Float.valueOf(((Number) a).floatValue() + ((((Number) b).floatValue() - ((Number) a).floatValue()) * t)) : ((a instanceof Double) && (b instanceof Number)) ? Double.valueOf(((Number) a).doubleValue() + ((((Number) b).doubleValue() - ((Number) a).doubleValue()) * t)) : ((a instanceof Integer) && (b instanceof Number)) ? Integer.valueOf((int) (((Number) a).doubleValue() + ((((Number) b).doubleValue() - ((Number) a).doubleValue()) * t))) : ((a instanceof Long) && (b instanceof Number)) ? Long.valueOf((long) (((Number) a).doubleValue() + ((((Number) b).doubleValue() - ((Number) a).doubleValue()) * t))) : ((a instanceof Vector3) && (b instanceof Vector3)) ? ((Vector3) a).lerp((Vector3) b, t) : ((a instanceof Vector2) && (b instanceof Vector2)) ? ((Vector2) a).lerp((Vector2) b, t) : ((a instanceof CFrame) && (b instanceof CFrame)) ? ((CFrame) a).lerp((CFrame) b, t) : ((a instanceof Color3) && (b instanceof Color3)) ? ((Color3) a).lerp((Color3) b, t) : ((a instanceof UDim2) && (b instanceof UDim2)) ? ((UDim2) a).lerp((UDim2) b, t) : ((a instanceof UDim) && (b instanceof UDim)) ? new UDim(((UDim) a).getScale() + ((((UDim) b).getScale() - ((UDim) a).getScale()) * t), (int) (((UDim) a).getOffset() + ((((UDim) b).getOffset() - ((UDim) a).getOffset()) * t))) : ((a instanceof Number) && (b instanceof Number)) ? Double.valueOf(((Number) a).doubleValue() + ((((Number) b).doubleValue() - ((Number) a).doubleValue()) * t)) : t >= 1.0f ? b : a;
    }

    public final String typeOf(LuaValue v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (!v.isuserdata()) {
            String typename = v.typename();
            Intrinsics.checkNotNullExpressionValue(typename, "typename(...)");
            return typename;
        }
        LuaValue luaValue = v.getmetatable();
        LuaValue luaValue2 = luaValue != null ? luaValue.get("__type") : null;
        if (luaValue2 == null || !luaValue2.isstring()) {
            return "userdata";
        }
        String str = luaValue2.tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        return str;
    }

    public final LuaValue v3(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return wrap(v);
    }

    public final LuaValue wrap(Object o) {
        Intrinsics.checkNotNullParameter(o, "o");
        LuaTable luaTable = metas.get(o.getClass());
        if (luaTable == null) {
            String simpleName = o.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            luaTable = generic(simpleName);
        }
        return new LuaUserdata(o, luaTable);
    }
}
