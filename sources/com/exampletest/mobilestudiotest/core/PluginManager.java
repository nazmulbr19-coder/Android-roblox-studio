package com.exampletest.mobilestudiotest.core;

import android.content.SharedPreferences;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import org.luaj.vm2.LuaValue;

/* compiled from: PluginManager.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010\u001d\u001a\u00020\u001bJ\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/PluginManager;", "", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "<init>", "(Lcom/exampletest/mobilestudiotest/core/Studio;)V", "dir", "Ljava/io/File;", "getDir", "()Ljava/io/File;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "list", "", "isEnabled", "", "f", "setEnabled", "", DebugKt.DEBUG_PROPERTY_VALUE_ON, "detect", "Lkotlin/Pair;", "", "", "bytes", "install", "name", "remove", "loadGen", "", "loadAll", "loaded", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lkotlin/collections/ArrayList;", "load", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PluginManager {
    private int loadGen;
    private final ArrayList<Instance> loaded;

    /* renamed from: prefs$delegate, reason: from kotlin metadata */
    private final Lazy prefs;
    private final Studio studio;

    public PluginManager(Studio studio) {
        Intrinsics.checkNotNullParameter(studio, "studio");
        this.studio = studio;
        this.prefs = LazyKt.lazy(new PluginManager$$ExternalSyntheticLambda3(this));
        this.loaded = new ArrayList<>();
    }

    private final SharedPreferences getPrefs() {
        return (SharedPreferences) this.prefs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void load$lambda$14(PluginManager pluginManager, Instance instance) {
        CopyOnWriteArrayList<PluginButton> pluginButtons = pluginManager.studio.getPluginButtons();
        boolean z = true;
        if (!(pluginButtons instanceof Collection) || !pluginButtons.isEmpty()) {
            Iterator<T> it = pluginButtons.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((PluginButton) it.next()).getPluginName(), instance.getName())) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            OutputLog.INSTANCE.warn("Plugin " + instance.getName() + " hasn't added a toolbar button yet. If it uses features this app doesn't have, its errors are shown above.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadAll$lambda$11(int i, PluginManager pluginManager, List list) {
        loadAll$next(i, pluginManager, list, 0);
    }

    private static final void loadAll$next(int i, PluginManager pluginManager, List<? extends File> list, int i2) {
        if (i != pluginManager.loadGen) {
            return;
        }
        if (i2 >= list.size()) {
            pluginManager.studio.notifyPluginButtons();
            return;
        }
        pluginManager.load(list.get(i2));
        pluginManager.studio.notifyPluginButtons();
        pluginManager.studio.getMain().post(new PluginManager$$ExternalSyntheticLambda0(i2, i, pluginManager, list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadAll$next$lambda$10(int i, int i2, PluginManager pluginManager, List list) {
        loadAll$next(i2, pluginManager, list, i + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SharedPreferences prefs_delegate$lambda$1(PluginManager pluginManager) {
        return pluginManager.studio.getApp().getSharedPreferences("plugins_state", 0);
    }

    public final Pair<byte[], String> detect(byte[] bytes) {
        boolean z;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] unwrap = RbxFile.INSTANCE.unwrap(bytes);
        if (RbxFile.INSTANCE.isBinary(unwrap)) {
            return TuplesKt.to(unwrap, "rbxm");
        }
        if (RbxFile.INSTANCE.isXml(unwrap)) {
            return TuplesKt.to(unwrap, "rbxmx");
        }
        boolean z2 = false;
        String str = new String(unwrap, 0, Math.min(unwrap.length, 4096), Charsets.UTF_8);
        String str2 = str;
        int i = 0;
        while (true) {
            if (i >= str2.length()) {
                z = true;
                break;
            }
            if (str2.charAt(i) == 0) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            String str3 = str;
            int i2 = 0;
            for (int i3 = 0; i3 < str3.length(); i3++) {
                char charAt = str3.charAt(i3);
                if ((!Character.isISOControl(charAt) || charAt == '\n' || charAt == '\r' || charAt == '\t') ? false : true) {
                    i2++;
                }
            }
            if (i2 < 4) {
                z2 = true;
            }
        }
        if (z2 && new Regex("\\b(local|function|end|return|plugin|game|print|require)\\b").containsMatchIn(str)) {
            return TuplesKt.to(unwrap, "lua");
        }
        throw new IllegalArgumentException("This file isn't a Roblox plugin. Expected a model file (.rbxm/.rbxmx, or a .bin downloaded from Roblox) or Lua source.");
    }

    public final File getDir() {
        File file = new File(this.studio.getApp().getFilesDir(), "plugins");
        file.mkdirs();
        return file;
    }

    public final File install(String name, byte[] bytes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Pair<byte[], String> detect = detect(bytes);
        byte[] component1 = detect.component1();
        String component2 = detect.component2();
        String substringAfterLast$default = StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(name, '/', (String) null, 2, (Object) null), '\\', (String) null, 2, (Object) null);
        Set of = SetsKt.setOf((Object[]) new String[]{"rbxm", "rbxmx", "lua", "luau", "txt", "bin", "rbxl", "rbxlx"});
        String lowerCase = StringsKt.substringAfterLast(substringAfterLast$default, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (of.contains(lowerCase)) {
            substringAfterLast$default = StringsKt.substringBeforeLast$default(substringAfterLast$default, '.', (String) null, 2, (Object) null);
        }
        String obj = StringsKt.trim((CharSequence) new Regex("[^A-Za-z0-9._ -]").replace(substringAfterLast$default, "_")).toString();
        if (StringsKt.isBlank(obj)) {
            obj = "Plugin";
        }
        File file = new File(getDir(), StringsKt.take(obj, 60) + "." + component2);
        FilesKt.writeBytes(file, component1);
        setEnabled(file, true);
        return file;
    }

    public final boolean isEnabled(File f) {
        Intrinsics.checkNotNullParameter(f, "f");
        return !getPrefs().getBoolean("off:" + f.getName(), false);
    }

    public final List<File> list() {
        File[] listFiles = getDir().listFiles();
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                if (file.isFile()) {
                    arrayList.add(file);
                }
            }
            List<File> sortedWith = CollectionsKt.sortedWith(arrayList, new PluginManager$list$$inlined$sortedBy$1());
            if (sortedWith != null) {
                return sortedWith;
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v14 */
    public final void load(File f) {
        String str;
        Intrinsics.checkNotNullParameter(f, "f");
        try {
            Instance create = InstanceFactory.INSTANCE.create("Plugin");
            create.setName(FilesKt.getNameWithoutExtension(f));
            ArrayList arrayList = new ArrayList();
            String lowerCase = FilesKt.getExtension(f).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            byte[] readBytes = FilesKt.readBytes(f);
            boolean z = false;
            if (SetsKt.setOf((Object[]) new String[]{"lua", "luau", "txt"}).contains(lowerCase)) {
                str = "lua";
            } else {
                try {
                    str = detect(readBytes).getSecond();
                } catch (Exception e) {
                    str = lowerCase;
                }
            }
            if (Intrinsics.areEqual(str, "lua")) {
                Instance create2 = InstanceFactory.INSTANCE.create("Script");
                create2.setName(FilesKt.getNameWithoutExtension(f));
                create2.set("Source", new String(RbxFile.INSTANCE.unwrap(readBytes), Charsets.UTF_8), false);
                create2.attachRaw(create);
                arrayList.add(create2);
            } else {
                Iterator<Instance> it = RbxFile.INSTANCE.read(readBytes).getRoots().iterator();
                while (it.hasNext()) {
                    it.next().attachRaw(create);
                }
                for (Instance instance : Instance.descendants$default(create, null, 1, null)) {
                    if (Intrinsics.areEqual(instance.get("Disabled"), (Object) true)) {
                        z = false;
                    } else if (!Intrinsics.areEqual(instance.get("Enabled"), Boolean.valueOf(z))) {
                        Object obj = instance.get("RunContext");
                        EnumValue enumValue = obj instanceof EnumValue ? (EnumValue) obj : null;
                        ?? value = enumValue != null ? enumValue.getValue() : z;
                        if ((Intrinsics.areEqual(instance.getClassName(), "Script") && (value == 0 || value == 3)) || Intrinsics.areEqual(instance.getClassName(), "LocalScript")) {
                            arrayList.add(instance);
                        }
                        z = false;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                OutputLog.INSTANCE.warn("Plugin " + f.getName() + " has no Scripts to run");
                return;
            }
            synchronized (this.studio.getLock()) {
                LuaRuntime editRuntime = this.studio.getEditRuntime();
                LuaValue wrap = editRuntime.wrap(create);
                this.loaded.add(create);
                Iterator it2 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    editRuntime.runScript((Instance) it2.next(), MapsKt.mapOf(TuplesKt.to("plugin", wrap)));
                }
                Unit unit = Unit.INSTANCE;
            }
            OutputLog.INSTANCE.info("Loaded plugin " + FilesKt.getNameWithoutExtension(f));
            this.studio.getMain().postDelayed(new PluginManager$$ExternalSyntheticLambda1(this, create), 4000L);
        } catch (Exception e2) {
            OutputLog.INSTANCE.error("Failed to load plugin " + f.getName() + ": " + e2.getMessage());
        }
    }

    public final void loadAll() {
        ArrayList<Instance> children;
        List list;
        List<File> list2 = list();
        synchronized (this.studio.getLock()) {
            Iterator<Instance> it = this.loaded.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Instance next = it.next();
                this.studio.getEditRuntime().fire(next, "Unloading", new LuaValue[0]);
                this.studio.getPluginMice().remove(next);
            }
            this.loaded.clear();
            this.studio.deactivatePlugin(null);
            this.studio.getPluginButtons().clear();
            this.studio.getPluginWidgets().clear();
            Instance findService = this.studio.getEditModel().findService("CoreGui");
            if (findService != null && (children = findService.getChildren()) != null && (list = CollectionsKt.toList(children)) != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((Instance) it2.next()).destroy();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        this.loadGen++;
        int i = this.loadGen;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (isEnabled((File) obj)) {
                arrayList.add(obj);
            }
        }
        this.studio.notifyPluginButtons();
        this.studio.getMain().post(new PluginManager$$ExternalSyntheticLambda2(i, this, arrayList));
    }

    public final void remove(File f) {
        Intrinsics.checkNotNullParameter(f, "f");
        f.delete();
        getPrefs().edit().remove("off:" + f.getName()).apply();
    }

    public final void setEnabled(File f, boolean on) {
        Intrinsics.checkNotNullParameter(f, "f");
        getPrefs().edit().putBoolean("off:" + f.getName(), !on).apply();
    }
}
