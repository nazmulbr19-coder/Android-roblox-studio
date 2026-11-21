package com.exampletest.mobilestudiotest.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.exampletest.mobilestudiotest.core.Theme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Settings.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b^\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"J\u0014\u0010$\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\"J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010'\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b(\u0010)R$\u0010*\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u00102\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.R$\u0010:\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u00104\"\u0004\b<\u00106R$\u0010=\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010\u001e\"\u0004\b?\u0010 R$\u0010@\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R$\u0010C\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR$\u0010K\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u00104\"\u0004\bM\u00106R$\u0010N\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010,\"\u0004\bP\u0010.R$\u0010Q\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u00104\"\u0004\bS\u00106R$\u0010T\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u00104\"\u0004\bV\u00106R$\u0010W\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u00104\"\u0004\bY\u00106R$\u0010Z\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R$\u0010]\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u00104\"\u0004\b_\u00106R$\u0010`\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u001e\"\u0004\bb\u0010 R$\u0010c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u00104\"\u0004\be\u00106R$\u0010f\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010E\"\u0004\bh\u0010GR$\u0010i\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bj\u00104\"\u0004\bk\u00106R$\u0010l\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bm\u0010,\"\u0004\bn\u0010.R$\u0010o\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bp\u0010,\"\u0004\bq\u0010.R$\u0010r\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bs\u00104\"\u0004\bt\u00106R$\u0010u\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bv\u00104\"\u0004\bw\u00106R$\u0010x\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\by\u00104\"\u0004\bz\u00106R$\u0010{\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u00104\"\u0004\b}\u00106R%\u0010~\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010,\"\u0005\b\u0080\u0001\u0010.¨\u0006\u0081\u0001"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/Settings;", "", "<init>", "()V", "prefs", "Landroid/content/SharedPreferences;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "init", "ctx", "Landroid/content/Context;", "p", "f", "", "k", "", "d", "b", "", "s", "i", "", "changed", "v", "themeName", "getThemeName", "()Ljava/lang/String;", "setThemeName", "(Ljava/lang/String;)V", "customThemes", "", "Lcom/exampletest/mobilestudiotest/core/Theme;", "saveCustomThemes", "list", "allThemes", "theme", "getTheme", "()Lcom/exampletest/mobilestudiotest/core/Theme;", "flySpeed", "getFlySpeed", "()F", "setFlySpeed", "(F)V", "cameraSensitivity", "getCameraSensitivity", "setCameraSensitivity", "cameraSmoothing", "getCameraSmoothing", "()Z", "setCameraSmoothing", "(Z)V", "playCameraSensitivity", "getPlayCameraSensitivity", "setPlayCameraSensitivity", "shiftLockSwitch", "getShiftLockSwitch", "setShiftLockSwitch", "cameraMode", "getCameraMode", "setCameraMode", "movementMode", "getMovementMode", "setMovementMode", "graphicsQuality", "getGraphicsQuality", "()I", "setGraphicsQuality", "(I)V", "volume", "getVolume", "setVolume", "hideWindowsInPlaytest", "getHideWindowsInPlaytest", "setHideWindowsInPlaytest", "editorFontSize", "getEditorFontSize", "setEditorFontSize", "autocomplete", "getAutocomplete", "setAutocomplete", "autoIndent", "getAutoIndent", "setAutoIndent", "autoCloseBrackets", "getAutoCloseBrackets", "setAutoCloseBrackets", "modernMaterials", "getModernMaterials", "setModernMaterials", "showFps", "getShowFps", "setShowFps", "renderDistance", "getRenderDistance", "setRenderDistance", "guiSmartGuides", "getGuiSmartGuides", "setGuiSmartGuides", "guiGrid", "getGuiGrid", "setGuiGrid", "confirmDelete", "getConfirmDelete", "setConfirmDelete", "moveSnap", "getMoveSnap", "setMoveSnap", "rotSnap", "getRotSnap", "setRotSnap", "moveSnapOn", "getMoveSnapOn", "setMoveSnapOn", "rotSnapOn", "getRotSnapOn", "setRotSnapOn", "selectInsideModels", "getSelectInsideModels", "setSelectInsideModels", "dragCollisions", "getDragCollisions", "setDragCollisions", "pluginUiScale", "getPluginUiScale", "setPluginUiScale", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Settings {
    public static final Settings INSTANCE = new Settings();
    private static final CopyOnWriteArrayList<Function0<Unit>> listeners = new CopyOnWriteArrayList<>();
    private static SharedPreferences prefs;

    private Settings() {
    }

    private final boolean b(String k, boolean d) {
        SharedPreferences sharedPreferences = prefs;
        return sharedPreferences != null ? sharedPreferences.getBoolean(k, d) : d;
    }

    private final float f(String k, float d) {
        SharedPreferences sharedPreferences = prefs;
        return sharedPreferences != null ? sharedPreferences.getFloat(k, d) : d;
    }

    private final int i(String k, int d) {
        SharedPreferences sharedPreferences = prefs;
        return sharedPreferences != null ? sharedPreferences.getInt(k, d) : d;
    }

    private final SharedPreferences p() {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        throw new IllegalStateException("Settings.init not called");
    }

    private final String s(String k, String d) {
        String string;
        SharedPreferences sharedPreferences = prefs;
        return (sharedPreferences == null || (string = sharedPreferences.getString(k, d)) == null) ? d : string;
    }

    public final List<Theme> allThemes() {
        return CollectionsKt.plus((Collection) Theme.INSTANCE.getBuiltIn(), (Iterable) customThemes());
    }

    public final void changed() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    public final List<Theme> customThemes() {
        String string;
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (string = sharedPreferences.getString("customThemes", null)) == null) {
            return CollectionsKt.emptyList();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            IntRange until = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                Theme.Companion companion = Theme.INSTANCE;
                JSONObject jSONObject = jSONArray.getJSONObject(nextInt);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                arrayList.add(companion.fromJson(jSONObject));
            }
            return arrayList;
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    public final boolean getAutoCloseBrackets() {
        return b("autoClose", true);
    }

    public final boolean getAutoIndent() {
        return b("autoIndent", true);
    }

    public final boolean getAutocomplete() {
        return b("autocomplete", true);
    }

    public final String getCameraMode() {
        return s("cameraMode", "Follow");
    }

    public final float getCameraSensitivity() {
        return f("camSens", 1.0f);
    }

    public final boolean getCameraSmoothing() {
        return b("camSmooth", true);
    }

    public final boolean getConfirmDelete() {
        return b("confirmDel", false);
    }

    public final boolean getDragCollisions() {
        return b("dragCollisions", false);
    }

    public final float getEditorFontSize() {
        return f("editorFont", 13.0f);
    }

    public final float getFlySpeed() {
        return f("flySpeed", 1.0f);
    }

    public final int getGraphicsQuality() {
        return i("gfx", 10);
    }

    public final int getGuiGrid() {
        return i("guiGrid", 0);
    }

    public final boolean getGuiSmartGuides() {
        return b("guiGuides", true);
    }

    public final boolean getHideWindowsInPlaytest() {
        return b("hidePlay", false);
    }

    public final CopyOnWriteArrayList<Function0<Unit>> getListeners() {
        return listeners;
    }

    public final boolean getModernMaterials() {
        return b("modernMaterials", true);
    }

    public final float getMoveSnap() {
        return f("moveSnap", 1.0f);
    }

    public final boolean getMoveSnapOn() {
        return b("moveSnapOn", true);
    }

    public final String getMovementMode() {
        return s("movementMode", "Dynamic Thumbstick");
    }

    public final float getPlayCameraSensitivity() {
        return f("playSens", 1.0f);
    }

    public final float getPluginUiScale() {
        return f("pluginScale", 0.0f);
    }

    public final String getRenderDistance() {
        return s("renderDist", "Automatic");
    }

    public final float getRotSnap() {
        return f("rotSnap", 15.0f);
    }

    public final boolean getRotSnapOn() {
        return b("rotSnapOn", true);
    }

    public final boolean getSelectInsideModels() {
        return b("selInside", false);
    }

    public final boolean getShiftLockSwitch() {
        return b("shiftLockSwitch", true);
    }

    public final boolean getShowFps() {
        return b("showFps", true);
    }

    public final Theme getTheme() {
        Object obj;
        Iterator<T> it = allThemes().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Theme) obj).getName(), INSTANCE.getThemeName())) {
                break;
            }
        }
        Theme theme = (Theme) obj;
        return theme == null ? Theme.INSTANCE.getDARK() : theme;
    }

    public final String getThemeName() {
        return s("theme", "Dark");
    }

    public final int getVolume() {
        return i("volume", 10);
    }

    public final void init(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (prefs == null) {
            prefs = ctx.getApplicationContext().getSharedPreferences("studio_settings", 0);
        }
    }

    public final void saveCustomThemes(List<Theme> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(((Theme) it.next()).toJson());
        }
        p().edit().putString("customThemes", jSONArray.toString()).apply();
    }

    public final void setAutoCloseBrackets(boolean z) {
        p().edit().putBoolean("autoClose", z).apply();
    }

    public final void setAutoIndent(boolean z) {
        p().edit().putBoolean("autoIndent", z).apply();
    }

    public final void setAutocomplete(boolean z) {
        p().edit().putBoolean("autocomplete", z).apply();
    }

    public final void setCameraMode(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        p().edit().putString("cameraMode", v).apply();
    }

    public final void setCameraSensitivity(float f) {
        p().edit().putFloat("camSens", f).apply();
    }

    public final void setCameraSmoothing(boolean z) {
        p().edit().putBoolean("camSmooth", z).apply();
    }

    public final void setConfirmDelete(boolean z) {
        p().edit().putBoolean("confirmDel", z).apply();
    }

    public final void setDragCollisions(boolean z) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putBoolean = edit.putBoolean("dragCollisions", z)) == null) {
            return;
        }
        putBoolean.apply();
    }

    public final void setEditorFontSize(float f) {
        p().edit().putFloat("editorFont", f).apply();
    }

    public final void setFlySpeed(float f) {
        p().edit().putFloat("flySpeed", f).apply();
    }

    public final void setGraphicsQuality(int i) {
        p().edit().putInt("gfx", i).apply();
    }

    public final void setGuiGrid(int i) {
        p().edit().putInt("guiGrid", i).apply();
    }

    public final void setGuiSmartGuides(boolean z) {
        p().edit().putBoolean("guiGuides", z).apply();
    }

    public final void setHideWindowsInPlaytest(boolean z) {
        p().edit().putBoolean("hidePlay", z).apply();
    }

    public final void setModernMaterials(boolean z) {
        p().edit().putBoolean("modernMaterials", z).apply();
        changed();
    }

    public final void setMoveSnap(float f) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putFloat;
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putFloat = edit.putFloat("moveSnap", f)) == null) {
            return;
        }
        putFloat.apply();
    }

    public final void setMoveSnapOn(boolean z) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putBoolean = edit.putBoolean("moveSnapOn", z)) == null) {
            return;
        }
        putBoolean.apply();
    }

    public final void setMovementMode(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        p().edit().putString("movementMode", v).apply();
    }

    public final void setPlayCameraSensitivity(float f) {
        p().edit().putFloat("playSens", f).apply();
    }

    public final void setPluginUiScale(float f) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putFloat;
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putFloat = edit.putFloat("pluginScale", f)) == null) {
            return;
        }
        putFloat.apply();
    }

    public final void setRenderDistance(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        p().edit().putString("renderDist", v).apply();
    }

    public final void setRotSnap(float f) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putFloat;
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putFloat = edit.putFloat("rotSnap", f)) == null) {
            return;
        }
        putFloat.apply();
    }

    public final void setRotSnapOn(boolean z) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putBoolean = edit.putBoolean("rotSnapOn", z)) == null) {
            return;
        }
        putBoolean.apply();
    }

    public final void setSelectInsideModels(boolean z) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putBoolean = edit.putBoolean("selInside", z)) == null) {
            return;
        }
        putBoolean.apply();
    }

    public final void setShiftLockSwitch(boolean z) {
        p().edit().putBoolean("shiftLockSwitch", z).apply();
    }

    public final void setShowFps(boolean z) {
        p().edit().putBoolean("showFps", z).apply();
    }

    public final void setThemeName(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        p().edit().putString("theme", v).apply();
    }

    public final void setVolume(int i) {
        p().edit().putInt("volume", i).apply();
    }
}
