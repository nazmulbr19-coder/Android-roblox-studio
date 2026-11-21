package com.exampletest.mobilestudiotest.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Instance.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0006\b\u0016\u0018\u0000 c2\u00020\u0001:\u0001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010F\u001a\u0004\u0018\u00010\u00012\u0006\u0010C\u001a\u00020\u0003H\u0086\u0002J\"\u0010G\u001a\u00020H2\u0006\u0010C\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010I\u001a\u00020 J\b\u0010J\u001a\u00020 H\u0002J\b\u0010K\u001a\u0004\u0018\u00010LJ\u000e\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020\u0000J\u001a\u0010O\u001a\u00020H2\b\u0010P\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010Q\u001a\u00020\u0010J\u000e\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020\u0000J\u0006\u0010T\u001a\u00020HJ\b\u0010U\u001a\u00020HH\u0002J\u000e\u0010V\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0003J\u001a\u0010X\u001a\u0004\u0018\u00010\u00002\u0006\u0010Y\u001a\u00020\u00032\b\b\u0002\u0010Z\u001a\u00020 J\u0010\u0010[\u001a\u0004\u0018\u00010\u00002\u0006\u0010W\u001a\u00020\u0003J\u001a\u0010\\\u001a\u0004\u0018\u00010\u00002\u0006\u0010W\u001a\u00020\u00032\b\b\u0002\u0010Z\u001a\u00020 J\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00000^2\u000e\b\u0002\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00000^J\u0006\u0010`\u001a\u00020\u0003J\u0006\u0010a\u001a\u00020\u0000J\b\u0010b\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R1\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u001bj\b\u0012\u0004\u0012\u00020\u0000`\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R1\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\rR\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001a\u0010:\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001a\u0010=\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u0012\u0010@\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R$\u0010C\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\u0005¨\u0006d"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Instance;", "", "className", "", "<init>", "(Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "props", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getProps", "()Ljava/util/LinkedHashMap;", "propTypes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getPropTypes", "()Ljava/util/HashMap;", "value", "parent", "getParent", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "setParent$app", "(Lcom/exampletest/mobilestudiotest/model/Instance;)V", "children", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getChildren", "()Ljava/util/ArrayList;", "isService", "", "()Z", "setService", "(Z)V", "archivable", "getArchivable", "setArchivable", "destroyed", "getDestroyed", "setDestroyed", "loadedRef", "getLoadedRef", "()I", "setLoadedRef", "(I)V", "attributes", "getAttributes", "absX", "", "getAbsX", "()F", "setAbsX", "(F)V", "absY", "getAbsY", "setAbsY", "absW", "getAbsW", "setAbsW", "absH", "getAbsH", "setAbsH", "version", "renderRec", "v", "name", "getName", "setName", "get", "set", "", "notify", "affectsParentShape", "root", "Lcom/exampletest/mobilestudiotest/model/DataModel;", "isDescendantOf", "other", "setParent", "newParent", "index", "attachRaw", "p", "destroy", "markDestroyed", "isA", "cls", "findFirstChild", "n", "recursive", "findFirstChildOfClass", "findFirstChildWhichIsA", "descendants", "", "out", "fullName", "cloneTree", "toString", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public class Instance {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static volatile long changeCount;
    private float absH;
    private float absW;
    private float absX;
    private float absY;
    private boolean archivable;
    private final LinkedHashMap<String, Object> attributes;
    private final ArrayList<Instance> children;
    private String className;
    private boolean destroyed;
    private boolean isService;
    private int loadedRef;
    private Instance parent;
    private final HashMap<String, Integer> propTypes;
    private final LinkedHashMap<String, Object> props;
    public Object renderRec;
    public int version;

    /* compiled from: Instance.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\fJ!\u0010\r\u001a\u00020\u000e2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nH\u0000¢\u0006\u0002\b\u000fR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Instance$Companion;", "", "<init>", "()V", "changeCount", "", "copyInto", "Lcom/exampletest/mobilestudiotest/model/Instance;", "src", "map", "Ljava/util/IdentityHashMap;", "dst", "copyInto$app", "remapRefs", "", "remapRefs$app", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Instance copyInto$app(Instance src, IdentityHashMap<Instance, Instance> map, Instance dst) {
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(dst, "dst");
            dst.getProps().putAll(src.getProps());
            dst.getPropTypes().putAll(src.getPropTypes());
            dst.setService(src.getIsService());
            dst.getAttributes().putAll(src.getAttributes());
            map.put(src, dst);
            Iterator<Instance> it = src.getChildren().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Instance next = it.next();
                if (next.getArchivable()) {
                    copyInto$app(next, map, new Instance(next.getClassName())).attachRaw(dst);
                }
            }
            return dst;
        }

        public final void remapRefs$app(IdentityHashMap<Instance, Instance> map) {
            Instance instance;
            Intrinsics.checkNotNullParameter(map, "map");
            Iterator<Instance> it = map.values().iterator();
            while (it.hasNext()) {
                for (Map.Entry<String, Object> entry : it.next().getProps().entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Instance) {
                        Instance instance2 = map.get(value);
                        if (instance2 != null) {
                            entry.setValue(instance2);
                        }
                    } else if ((value instanceof ContentValue) && ((ContentValue) value).getObj() != null && (instance = map.get(((ContentValue) value).getObj())) != null) {
                        entry.setValue(ContentValue.copy$default((ContentValue) value, 0, null, instance, 3, null));
                    }
                }
            }
        }
    }

    public Instance(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        this.className = className;
        this.props = new LinkedHashMap<>();
        this.propTypes = new HashMap<>();
        this.children = new ArrayList<>();
        this.archivable = true;
        this.loadedRef = -1;
        this.attributes = new LinkedHashMap<>();
    }

    private final boolean affectsParentShape() {
        String str = this.className;
        switch (str.hashCode()) {
            case -1418764294:
                if (str.equals("BlockMesh")) {
                    return true;
                }
                break;
            case -671103575:
                if (str.equals("FileMesh")) {
                    return true;
                }
                break;
            case 795242022:
                if (str.equals("SpecialMesh")) {
                    return true;
                }
                break;
            case 978161873:
                if (str.equals("SurfaceAppearance")) {
                    return true;
                }
                break;
            case 1108929283:
                if (str.equals("CylinderMesh")) {
                    return true;
                }
                break;
            case 1242205543:
                if (str.equals("BevelMesh")) {
                    return true;
                }
                break;
        }
        Instance instance = this.parent;
        return (instance != null && instance.isA("PartOperation")) && isA("BasePart");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List descendants$default(Instance instance, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: descendants");
        }
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return instance.descendants(list);
    }

    public static /* synthetic */ Instance findFirstChild$default(Instance instance, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findFirstChild");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return instance.findFirstChild(str, z);
    }

    public static /* synthetic */ Instance findFirstChildWhichIsA$default(Instance instance, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findFirstChildWhichIsA");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return instance.findFirstChildWhichIsA(str, z);
    }

    private final void markDestroyed() {
        this.destroyed = true;
        Iterator it = CollectionsKt.toList(this.children).iterator();
        while (it.hasNext()) {
            ((Instance) it.next()).markDestroyed();
        }
    }

    public static /* synthetic */ void set$default(Instance instance, String str, Object obj, boolean z, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: set");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        instance.set(str, obj, z);
    }

    public static /* synthetic */ void setParent$default(Instance instance, Instance instance2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setParent");
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        instance.setParent(instance2, i);
    }

    public final void attachRaw(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        this.parent = p;
        p.children.add(this);
    }

    public final Instance cloneTree() {
        IdentityHashMap<Instance, Instance> identityHashMap = new IdentityHashMap<>();
        Instance copyInto$app = INSTANCE.copyInto$app(this, identityHashMap, new Instance(this.className));
        INSTANCE.remapRefs$app(identityHashMap);
        return copyInto$app;
    }

    public final List<Instance> descendants(List<Instance> out) {
        Intrinsics.checkNotNullParameter(out, "out");
        Iterator<Instance> it = this.children.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            out.add(next);
            next.descendants(out);
        }
        return out;
    }

    public final void destroy() {
        if (this.destroyed) {
            return;
        }
        setParent$default(this, null, 0, 2, null);
        markDestroyed();
    }

    public final Instance findFirstChild(String n, boolean recursive) {
        Intrinsics.checkNotNullParameter(n, "n");
        Iterator<Instance> it = this.children.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            if (Intrinsics.areEqual(next.getName(), n)) {
                return next;
            }
        }
        if (!recursive) {
            return null;
        }
        Iterator<Instance> it2 = this.children.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Instance findFirstChild = it2.next().findFirstChild(n, true);
            if (findFirstChild != null) {
                return findFirstChild;
            }
        }
        return null;
    }

    public final Instance findFirstChildOfClass(String cls) {
        Object obj;
        Intrinsics.checkNotNullParameter(cls, "cls");
        Iterator<T> it = this.children.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Instance) obj).className, cls)) {
                break;
            }
        }
        return (Instance) obj;
    }

    public final Instance findFirstChildWhichIsA(String cls, boolean recursive) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Iterator<Instance> it = this.children.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            if (next.isA(cls)) {
                return next;
            }
        }
        if (!recursive) {
            return null;
        }
        Iterator<Instance> it2 = this.children.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Instance findFirstChildWhichIsA = it2.next().findFirstChildWhichIsA(cls, true);
            if (findFirstChildWhichIsA != null) {
                return findFirstChildWhichIsA;
            }
        }
        return null;
    }

    public final String fullName() {
        ArrayList arrayList = new ArrayList();
        for (Instance instance = this; instance != null && !(instance instanceof DataModel); instance = instance.parent) {
            arrayList.add(instance.getName());
        }
        return CollectionsKt.joinToString$default(CollectionsKt.reversed(arrayList), ".", null, null, 0, null, null, 62, null);
    }

    public final Object get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.props.get(name);
    }

    public final float getAbsH() {
        return this.absH;
    }

    public final float getAbsW() {
        return this.absW;
    }

    public final float getAbsX() {
        return this.absX;
    }

    public final float getAbsY() {
        return this.absY;
    }

    public final boolean getArchivable() {
        return this.archivable;
    }

    public final LinkedHashMap<String, Object> getAttributes() {
        return this.attributes;
    }

    public final ArrayList<Instance> getChildren() {
        return this.children;
    }

    public final String getClassName() {
        return this.className;
    }

    public final boolean getDestroyed() {
        return this.destroyed;
    }

    public final int getLoadedRef() {
        return this.loadedRef;
    }

    public final String getName() {
        Object obj = this.props.get("Name");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? this.className : str;
    }

    public final Instance getParent() {
        return this.parent;
    }

    public final HashMap<String, Integer> getPropTypes() {
        return this.propTypes;
    }

    public final LinkedHashMap<String, Object> getProps() {
        return this.props;
    }

    public final boolean isA(String cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        return ClassDb.INSTANCE.isA(this.className, cls);
    }

    public final boolean isDescendantOf(Instance other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (Instance instance = this.parent; instance != null; instance = instance.parent) {
            if (instance == other) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isService, reason: from getter */
    public final boolean getIsService() {
        return this.isService;
    }

    public final DataModel root() {
        for (Instance instance = this; instance != null; instance = instance.parent) {
            if (instance instanceof DataModel) {
                return (DataModel) instance;
            }
        }
        return null;
    }

    public final void set(String name, Object value, boolean notify) {
        DataModel root;
        Instance instance;
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.props.get(name);
        if (this.props.containsKey(name) && Intrinsics.areEqual(obj, value)) {
            return;
        }
        this.props.put(name, value);
        this.version++;
        if (affectsParentShape() && (instance = this.parent) != null) {
            instance.version++;
        }
        long j = changeCount;
        Companion companion = INSTANCE;
        changeCount = j + 1;
        if (!this.propTypes.containsKey(name)) {
            this.propTypes.put(name, Integer.valueOf(PropType.INSTANCE.infer(value)));
        }
        if (!notify || (root = root()) == null) {
            return;
        }
        root.firePropChanged(this, name);
    }

    public final void setAbsH(float f) {
        this.absH = f;
    }

    public final void setAbsW(float f) {
        this.absW = f;
    }

    public final void setAbsX(float f) {
        this.absX = f;
    }

    public final void setAbsY(float f) {
        this.absY = f;
    }

    public final void setArchivable(boolean z) {
        this.archivable = z;
    }

    public final void setClassName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.className = str;
    }

    public final void setDestroyed(boolean z) {
        this.destroyed = z;
    }

    public final void setLoadedRef(int i) {
        this.loadedRef = i;
    }

    public final void setName(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        set$default(this, "Name", v, false, 4, null);
    }

    public final void setParent(Instance newParent, int index) {
        if (newParent == this.parent) {
            return;
        }
        if (newParent != null && (newParent == this || newParent.isDescendantOf(this))) {
            throw new IllegalArgumentException("Attempt to set parent of " + getName() + " to " + newParent.getName() + " would result in circular reference");
        }
        Instance instance = this.parent;
        this.version++;
        long j = changeCount;
        Companion companion = INSTANCE;
        changeCount = j + 1;
        boolean affectsParentShape = affectsParentShape();
        if (instance != null) {
            if (affectsParentShape) {
                instance.version++;
            }
            instance.children.remove(this);
            this.parent = null;
            DataModel root = instance.root();
            if (root != null) {
                root.fireChildRemoved(instance, this);
            }
        }
        if (newParent != null) {
            if (affectsParentShape) {
                newParent.version++;
            }
            if (index >= 0 && index <= newParent.children.size()) {
                newParent.children.add(index, this);
            } else {
                newParent.children.add(this);
            }
            this.parent = newParent;
            DataModel root2 = newParent.root();
            if (root2 != null) {
                root2.fireChildAdded(newParent, this);
            }
        }
    }

    public final void setParent$app(Instance instance) {
        this.parent = instance;
    }

    public final void setService(boolean z) {
        this.isService = z;
    }

    public String toString() {
        return getName();
    }
}
