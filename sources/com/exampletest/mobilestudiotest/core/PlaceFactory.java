package com.exampletest.mobilestudiotest.core;

import androidx.core.app.NotificationCompat;
import com.exampletest.mobilestudiotest.format.RbxDocument;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.ClassDb;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlaceFactory.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/PlaceFactory;", "", "<init>", "()V", "required", "", "", "newPlace", "Lcom/exampletest/mobilestudiotest/model/DataModel;", "template", "Lcom/exampletest/mobilestudiotest/core/PlaceFactory$Template;", NotificationCompat.CATEGORY_SERVICE, "Lcom/exampletest/mobilestudiotest/model/Instance;", "dm", "cls", "fromDocument", "doc", "Lcom/exampletest/mobilestudiotest/format/RbxDocument;", "ensureTerrain", "", "ws", "Template", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlaceFactory {
    public static final PlaceFactory INSTANCE = new PlaceFactory();
    private static final List<String> required = CollectionsKt.listOf((Object[]) new String[]{"Workspace", "Players", "Lighting", "MaterialService", "ReplicatedFirst", "ReplicatedStorage", "ServerScriptService", "ServerStorage", "StarterGui", "StarterPack", "StarterPlayer", "Teams", "SoundService", "TextChatService"});

    /* compiled from: PlaceFactory.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/PlaceFactory$Template;", "", "title", "", "subtitle", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getSubtitle", "BASEPLATE", "CLASSIC", "EMPTY", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Template {
        BASEPLATE("Baseplate", "A large grey baseplate and a spawn"),
        CLASSIC("Classic Baseplate", "The classic studded baseplate"),
        EMPTY("Empty Place", "Just a spawn location, no ground");

        private final String subtitle;
        private final String title;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        Template(String str, String str2) {
            this.title = str;
            this.subtitle = str2;
        }

        public static EnumEntries<Template> getEntries() {
            return $ENTRIES;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    private PlaceFactory() {
    }

    private final void ensureTerrain(Instance ws) {
        if (ws.findFirstChildOfClass("Terrain") != null) {
            return;
        }
        Instance create = InstanceFactory.INSTANCE.create("Terrain");
        create.setName("Terrain");
        create.set("Anchored", true, false);
        create.set("Locked", true, false);
        create.set("WaterColor", Color3.INSTANCE.fromRGB(12, 84, 92), false);
        create.set("WaterTransparency", Float.valueOf(0.3f), false);
        create.set("WaterReflectance", Float.valueOf(1.0f), false);
        create.set("WaterWaveSize", Float.valueOf(0.15f), false);
        create.set("WaterWaveSpeed", Float.valueOf(10.0f), false);
        create.setService(false);
        create.attachRaw(ws);
    }

    public static /* synthetic */ DataModel newPlace$default(PlaceFactory placeFactory, Template template, int i, Object obj) {
        if ((i & 1) != 0) {
            template = Template.BASEPLATE;
        }
        return placeFactory.newPlace(template);
    }

    private final Instance service(DataModel dm, String cls) {
        Instance findService = dm.findService(cls);
        if (findService != null) {
            return findService;
        }
        Instance create = InstanceFactory.INSTANCE.create(cls);
        create.setService(true);
        create.attachRaw(dm);
        return create;
    }

    public final DataModel fromDocument(RbxDocument doc) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        DataModel dataModel = new DataModel();
        dataModel.getMeta().putAll(doc.getMeta());
        for (Instance instance : doc.getRoots()) {
            if (ClassDb.INSTANCE.isServiceName(instance.getClassName())) {
                instance.setService(true);
            }
            instance.attachRaw(dataModel);
        }
        Iterator<String> it = required.iterator();
        while (it.hasNext()) {
            service(dataModel, it.next());
        }
        Instance findService = dataModel.findService("Workspace");
        Intrinsics.checkNotNull(findService);
        if (findService.get("CurrentCamera") == null) {
            Object findFirstChildOfClass = findService.findFirstChildOfClass("Camera");
            if (findFirstChildOfClass == null) {
                findFirstChildOfClass = InstanceFactory.INSTANCE.create("Camera");
                findFirstChildOfClass.attachRaw(findService);
            }
            findService.set("CurrentCamera", findFirstChildOfClass, false);
        }
        ensureTerrain(findService);
        return dataModel;
    }

    public final DataModel newPlace(Template template) {
        Intrinsics.checkNotNullParameter(template, "template");
        DataModel dataModel = new DataModel();
        dataModel.getMeta().put("ExplicitAutoJoints", "true");
        Iterator<String> it = required.iterator();
        while (it.hasNext()) {
            service(dataModel, it.next());
        }
        Instance findService = dataModel.findService("Workspace");
        Intrinsics.checkNotNull(findService);
        Instance create = InstanceFactory.INSTANCE.create("Camera");
        create.set("CFrame", CFrame.Companion.lookAt$default(CFrame.INSTANCE, new Vector3(0.0f, 20.0f, 40.0f), Vector3.INSTANCE.getZERO(), null, 4, null), false);
        create.attachRaw(findService);
        findService.set("CurrentCamera", create, false);
        ensureTerrain(findService);
        if (template != Template.EMPTY) {
            Instance create2 = InstanceFactory.INSTANCE.create("Part");
            create2.setName("Baseplate");
            create2.set("Anchored", true, false);
            create2.set("Locked", true, false);
            if (template == Template.CLASSIC) {
                create2.set("size", new Vector3(512.0f, 20.0f, 512.0f), false);
                create2.set("CFrame", new CFrame(0.0f, -10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null), false);
                create2.set("Color3uint8", Color3.INSTANCE.fromRGB(99, 95, 98), false);
                create2.set("TopSurface", new EnumValue(3), false);
            } else {
                create2.set("size", new Vector3(2048.0f, 16.0f, 2048.0f), false);
                create2.set("CFrame", new CFrame(0.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null), false);
                create2.set("Color3uint8", Color3.INSTANCE.fromRGB(91, 93, 105), false);
                Instance create3 = InstanceFactory.INSTANCE.create("Texture");
                create3.setName("Texture");
                create3.set("Texture", "rbxassetid://6372755229", false);
                create3.set("Face", new EnumValue(1), false);
                create3.set("StudsPerTileU", Float.valueOf(8.0f), false);
                create3.set("StudsPerTileV", Float.valueOf(8.0f), false);
                create3.set("Transparency", Float.valueOf(0.8f), false);
                create3.attachRaw(create2);
            }
            create2.attachRaw(findService);
        }
        Instance create4 = InstanceFactory.INSTANCE.create("SpawnLocation");
        create4.set("CFrame", new CFrame(0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null), false);
        create4.set("Color3uint8", Color3.INSTANCE.fromRGB(163, 162, 165), false);
        create4.attachRaw(findService);
        Instance findService2 = dataModel.findService("StarterPlayer");
        Intrinsics.checkNotNull(findService2);
        InstanceFactory.INSTANCE.create("StarterPlayerScripts").attachRaw(findService2);
        InstanceFactory.INSTANCE.create("StarterCharacterScripts").attachRaw(findService2);
        return dataModel;
    }
}
