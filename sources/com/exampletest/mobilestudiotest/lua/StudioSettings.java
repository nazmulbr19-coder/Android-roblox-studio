package com.exampletest.mobilestudiotest.lua;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.exampletest.mobilestudiotest.model.Color3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* compiled from: RobloxGlobals.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/StudioSettings;", "", "<init>", "()V", "rgb", "Lcom/exampletest/mobilestudiotest/model/Color3;", "r", "", "g", "b", "palette", "", "", "shade", "c", "k", "", TypedValues.Custom.S_COLOR, "styleName", "modifier", "enumName", "v", "Lorg/luaj/vm2/LuaValue;", "create", "Lorg/luaj/vm2/LuaTable;", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StudioSettings {
    public static final StudioSettings INSTANCE = new StudioSettings();
    private static final Map<String, Color3> palette = MapsKt.mapOf(TuplesKt.to("MainBackground", INSTANCE.rgb(46, 46, 46)), TuplesKt.to("Titlebar", INSTANCE.rgb(53, 53, 53)), TuplesKt.to("TitlebarText", INSTANCE.rgb(170, 170, 170)), TuplesKt.to("Dropdown", INSTANCE.rgb(46, 46, 46)), TuplesKt.to("Tooltip", INSTANCE.rgb(66, 66, 66)), TuplesKt.to("Notification", INSTANCE.rgb(66, 66, 66)), TuplesKt.to("ScrollBar", INSTANCE.rgb(56, 56, 56)), TuplesKt.to("ScrollBarBackground", INSTANCE.rgb(41, 41, 41)), TuplesKt.to("TabBar", INSTANCE.rgb(46, 46, 46)), TuplesKt.to("Tab", INSTANCE.rgb(53, 53, 53)), TuplesKt.to("FilterButtonDefault", INSTANCE.rgb(46, 46, 46)), TuplesKt.to("FilterButtonHover", INSTANCE.rgb(66, 66, 66)), TuplesKt.to("FilterButtonChecked", INSTANCE.rgb(30, 30, 30)), TuplesKt.to("FilterButtonAccent", INSTANCE.rgb(53, 181, 255)), TuplesKt.to("FilterButtonBorder", INSTANCE.rgb(26, 26, 26)), TuplesKt.to("RibbonTab", INSTANCE.rgb(53, 53, 53)), TuplesKt.to("RibbonTabTopBar", INSTANCE.rgb(53, 181, 255)), TuplesKt.to("RibbonButton", INSTANCE.rgb(37, 37, 37)), TuplesKt.to("Button", INSTANCE.rgb(60, 60, 60)), TuplesKt.to("ButtonBorder", INSTANCE.rgb(34, 34, 34)), TuplesKt.to("ButtonText", INSTANCE.rgb(204, 204, 204)), TuplesKt.to("MainButton", INSTANCE.rgb(0, 162, 255)), TuplesKt.to("DialogButton", INSTANCE.rgb(60, 60, 60)), TuplesKt.to("DialogButtonText", INSTANCE.rgb(204, 204, 204)), TuplesKt.to("DialogButtonBorder", INSTANCE.rgb(34, 34, 34)), TuplesKt.to("DialogMainButton", INSTANCE.rgb(0, 162, 255)), TuplesKt.to("DialogMainButtonText", INSTANCE.rgb(255, 255, 255)), TuplesKt.to("InputFieldBackground", INSTANCE.rgb(37, 37, 37)), TuplesKt.to("InputFieldBorder", INSTANCE.rgb(26, 26, 26)), TuplesKt.to("CheckedFieldBackground", INSTANCE.rgb(37, 37, 37)), TuplesKt.to("CheckedFieldBorder", INSTANCE.rgb(34, 34, 34)), TuplesKt.to("CheckedFieldIndicator", INSTANCE.rgb(53, 181, 255)), TuplesKt.to("HeaderSection", INSTANCE.rgb(53, 53, 53)), TuplesKt.to("Midlight", INSTANCE.rgb(34, 34, 34)), TuplesKt.to("Mid", INSTANCE.rgb(34, 34, 34)), TuplesKt.to("Dark", INSTANCE.rgb(34, 34, 34)), TuplesKt.to("Light", INSTANCE.rgb(66, 66, 66)), TuplesKt.to("Shadow", INSTANCE.rgb(26, 26, 26)), TuplesKt.to("Item", INSTANCE.rgb(46, 46, 46)), TuplesKt.to("TableItem", INSTANCE.rgb(46, 46, 46)), TuplesKt.to("Separator", INSTANCE.rgb(34, 34, 34)), TuplesKt.to("Border", INSTANCE.rgb(26, 26, 26)), TuplesKt.to("MainText", INSTANCE.rgb(204, 204, 204)), TuplesKt.to("SubText", INSTANCE.rgb(170, 170, 170)), TuplesKt.to("DimmedText", INSTANCE.rgb(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY)), TuplesKt.to("BrightText", INSTANCE.rgb(229, 229, 229)), TuplesKt.to("InfoText", INSTANCE.rgb(170, 170, 170)), TuplesKt.to("LinkText", INSTANCE.rgb(53, 181, 255)), TuplesKt.to("WarningText", INSTANCE.rgb(255, 142, 60)), TuplesKt.to("ErrorText", INSTANCE.rgb(255, 68, 68)), TuplesKt.to("SensitiveText", INSTANCE.rgb(177, 138, 255)), TuplesKt.to("ScriptBackground", INSTANCE.rgb(37, 37, 37)), TuplesKt.to("ScriptText", INSTANCE.rgb(204, 204, 204)), TuplesKt.to("ScriptSelectionBackground", INSTANCE.rgb(11, 90, 175)), TuplesKt.to("StatusBar", INSTANCE.rgb(46, 46, 46)), TuplesKt.to("CurrentMarker", INSTANCE.rgb(66, 66, 66)), TuplesKt.to("ColorPickerFrame", INSTANCE.rgb(34, 34, 34)), TuplesKt.to("GameSettingsTableItem", INSTANCE.rgb(53, 53, 53)), TuplesKt.to("GameSettingsTooltip", INSTANCE.rgb(66, 66, 66)), TuplesKt.to("EmulatorBar", INSTANCE.rgb(41, 41, 41)), TuplesKt.to("EmulatorDropDown", INSTANCE.rgb(37, 37, 37)), TuplesKt.to("ViewPortBackground", INSTANCE.rgb(37, 37, 37)), TuplesKt.to("AttributeCog", INSTANCE.rgb(170, 170, 170)));

    private StudioSettings() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs create$lambda$1(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTypes luaTypes = LuaTypes.INSTANCE;
        StudioSettings studioSettings = INSTANCE;
        StudioSettings studioSettings2 = INSTANCE;
        LuaValue arg = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        String enumName = studioSettings2.enumName(arg);
        StudioSettings studioSettings3 = INSTANCE;
        LuaValue arg2 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        String enumName2 = studioSettings3.enumName(arg2);
        if (enumName2.length() == 0) {
            enumName2 = "Default";
        }
        return luaTypes.wrap(studioSettings.color(enumName, enumName2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs create$lambda$3(LuaRuntime luaRuntime, LuaTable luaTable, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return luaRuntime.getApi().signal(luaTable, "Changed:" + a.arg(2).tojstring());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs create$lambda$4(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaBoolean FALSE = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
        return FALSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs create$lambda$5(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaString valueOf = LuaValue.valueOf("");
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs create$lambda$6(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaInteger valueOf = LuaValue.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue create$lambda$9(LuaValue t, LuaValue k) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(k, "k");
        LuaTable luaTable = new LuaTable();
        ((LuaTable) t).rawset(k, luaTable);
        return luaTable;
    }

    private final String enumName(LuaValue v) {
        String name;
        EnumItemV enumItemV = null;
        if (v.isuserdata()) {
            Object obj = v.touserdata();
            if (obj instanceof EnumItemV) {
                enumItemV = (EnumItemV) obj;
            }
        }
        if (enumItemV != null && (name = enumItemV.getName()) != null) {
            return name;
        }
        if (!v.isstring()) {
            return "";
        }
        String str = v.tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        return str;
    }

    private final Color3 rgb(int r, int g, int b) {
        return Color3.INSTANCE.fromRGB(r, g, b);
    }

    private final Color3 shade(Color3 c, float k) {
        return new Color3(RangesKt.coerceIn(c.getR() * k, 0.0f, 1.0f), RangesKt.coerceIn(c.getG() * k, 0.0f, 1.0f), RangesKt.coerceIn(c.getB() * k, 0.0f, 1.0f));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0061. Please report as an issue. */
    public final Color3 color(String styleName, String modifier) {
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Color3 color3 = palette.get(styleName);
        if (color3 == null) {
            color3 = StringsKt.contains$default((CharSequence) styleName, (CharSequence) "Text", false, 2, (Object) null) ? rgb(204, 204, 204) : (StringsKt.contains$default((CharSequence) styleName, (CharSequence) "Border", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) styleName, (CharSequence) "Separator", false, 2, (Object) null)) ? rgb(26, 26, 26) : rgb(46, 46, 46);
        }
        boolean contains$default = StringsKt.contains$default((CharSequence) styleName, (CharSequence) "Text", false, 2, (Object) null);
        switch (modifier.hashCode()) {
            case 69916956:
                if (modifier.equals("Hover") && !contains$default) {
                    return shade(color3, 1.18f);
                }
                return color3;
            case 335584924:
                if (modifier.equals("Disabled")) {
                    return contains$default ? rgb(85, 85, 85) : shade(color3, 0.9f);
                }
                return color3;
            case 1256216251:
                if (modifier.equals("Selected")) {
                    return contains$default ? rgb(255, 255, 255) : SetsKt.setOf((Object[]) new String[]{"Item", "TableItem", "Button", "RibbonButton"}).contains(styleName) ? rgb(11, 90, 175) : shade(color3, 1.25f);
                }
                return color3;
            case 1346388994:
                if (modifier.equals("Pressed") && !contains$default) {
                    return shade(color3, 0.85f);
                }
                return color3;
            default:
                return color3;
        }
    }

    public final LuaTable create(LuaRuntime rt) {
        Intrinsics.checkNotNullParameter(rt, "rt");
        LuaTable luaTable = new LuaTable();
        luaTable.set("Name", "Dark");
        luaTable.set("GetColor", LuaTypesKt.fnv(new StudioSettings$$ExternalSyntheticLambda0()));
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set("__type", "Instance");
        luaTable.setmetatable(luaTable2);
        LuaTable luaTable3 = new LuaTable();
        luaTable3.set("Theme", luaTable);
        luaTable3.set("ThemeChanged", rt.getApi().signal(luaTable3, "ThemeChanged"));
        luaTable3.set("GetPropertyChangedSignal", LuaTypesKt.fnv(new StudioSettings$$ExternalSyntheticLambda1(rt, luaTable3)));
        luaTable3.set("Grid Size", 1);
        luaTable3.set("Script Editor Color Preset", LuaTypes.INSTANCE.wrap(new EnumItemV("StudioScriptEditorColorPresets", "RobloxDefault", 0)));
        LuaTable luaTable4 = new LuaTable();
        luaTable4.set("Studio", luaTable3);
        luaTable4.set("GetFFlag", LuaTypesKt.fnv(new StudioSettings$$ExternalSyntheticLambda2()));
        luaTable4.set("GetFVariable", LuaTypesKt.fnv(new StudioSettings$$ExternalSyntheticLambda3()));
        luaTable4.set("GetFInt", LuaTypesKt.fnv(new StudioSettings$$ExternalSyntheticLambda4()));
        LuaTable luaTable5 = new LuaTable();
        luaTable5.set("QualityLevel", LuaTypes.INSTANCE.wrap(new EnumItemV("QualityLevel", "Automatic", 0)));
        Unit unit = Unit.INSTANCE;
        luaTable4.set("Rendering", luaTable5);
        LuaTable luaTable6 = new LuaTable();
        luaTable6.set(LuaValue.INDEX, LuaTypesKt.fn2(new StudioSettings$$ExternalSyntheticLambda5()));
        luaTable4.setmetatable(luaTable6);
        return luaTable4;
    }
}
