package com.exampletest.mobilestudiotest.lua;

import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PropNames;
import com.exampletest.mobilestudiotest.model.TreeListener;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;

/* compiled from: LuaRuntime.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/exampletest/mobilestudiotest/lua/LuaRuntime$treeListener$1", "Lcom/exampletest/mobilestudiotest/model/TreeListener;", "childAdded", "", "parent", "Lcom/exampletest/mobilestudiotest/model/Instance;", "child", "childRemoved", "propChanged", "inst", "name", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaRuntime$treeListener$1 implements TreeListener {
    final /* synthetic */ LuaRuntime this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LuaRuntime$treeListener$1(LuaRuntime luaRuntime) {
        this.this$0 = luaRuntime;
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void childAdded(Instance parent, Instance child) {
        PlaySession play;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.this$0.getStopped()) {
            return;
        }
        if (this.this$0.hasConn(parent, "ChildAdded")) {
            this.this$0.fire(parent, "ChildAdded", this.this$0.wrap(child));
        }
        for (Instance instance = parent; instance != null; instance = instance.getParent()) {
            if (this.this$0.hasConn(instance, "DescendantAdded")) {
                this.this$0.fire(instance, "DescendantAdded", this.this$0.wrap(child));
                Iterator it = Instance.descendants$default(child, null, 1, null).iterator();
                while (it.hasNext()) {
                    this.this$0.fire(instance, "DescendantAdded", this.this$0.wrap((Instance) it.next()));
                }
            }
        }
        LuaRuntime.access$notifyAncestry(this.this$0, child);
        if (!LuaRuntime.access$getChildWaits$p(this.this$0).isEmpty()) {
            LuaRuntime.access$checkChildWaits(this.this$0);
        }
        if (!this.this$0.getIsPlay() || (play = this.this$0.getPlay()) == null) {
            return;
        }
        play.onChildAdded(parent, child);
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void childRemoved(Instance parent, Instance child) {
        PlaySession play;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.this$0.getStopped()) {
            return;
        }
        if (this.this$0.hasConn(parent, "ChildRemoved")) {
            this.this$0.fire(parent, "ChildRemoved", this.this$0.wrap(child));
        }
        for (Instance instance = parent; instance != null; instance = instance.getParent()) {
            if (this.this$0.hasConn(instance, "DescendantRemoving")) {
                this.this$0.fire(instance, "DescendantRemoving", this.this$0.wrap(child));
            }
        }
        LuaRuntime.access$notifyAncestry(this.this$0, child);
        if (child.getDestroyed()) {
            if (this.this$0.hasConn(child, "Destroying")) {
                this.this$0.fire(child, "Destroying", new LuaValue[0]);
            }
            LuaRuntime.access$disconnectTree(this.this$0, child);
        }
        if (!this.this$0.getIsPlay() || (play = this.this$0.getPlay()) == null) {
            return;
        }
        play.onChildRemoved(parent, child);
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void propChanged(Instance inst, String name) {
        PlaySession play;
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.this$0.getStopped()) {
            return;
        }
        if (Intrinsics.areEqual(name, "Name") && !LuaRuntime.access$getChildWaits$p(this.this$0).isEmpty()) {
            LuaRuntime.access$checkChildWaits(this.this$0);
        }
        if (this.this$0.getIsPlay() && Intrinsics.areEqual(name, "Disabled") && inst.isA("BaseScript") && Intrinsics.areEqual(inst.get("Disabled"), (Object) false) && (play = this.this$0.getPlay()) != null) {
            play.maybeRunScript(inst);
        }
        HashMap hashMap = (HashMap) LuaRuntime.access$getConns$p(this.this$0).get(inst);
        if (hashMap == null) {
            return;
        }
        String display = PropNames.INSTANCE.display(name);
        if (hashMap.containsKey("Changed")) {
            if (inst.isA("ValueBase") && Intrinsics.areEqual(display, "Value")) {
                this.this$0.fire(inst, "Changed", this.this$0.toLua(inst.get(name), inst, name));
            } else {
                LuaRuntime luaRuntime = this.this$0;
                LuaString valueOf = LuaValue.valueOf(display);
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                luaRuntime.fire(inst, "Changed", valueOf);
            }
        }
        if (hashMap.containsKey("Changed:" + display)) {
            this.this$0.fire(inst, "Changed:" + display, new LuaValue[0]);
        }
        if (Intrinsics.areEqual(display, "CFrame")) {
            if (hashMap.containsKey("Changed:Position")) {
                this.this$0.fire(inst, "Changed:Position", new LuaValue[0]);
            }
            if (hashMap.containsKey("Changed:Orientation")) {
                this.this$0.fire(inst, "Changed:Orientation", new LuaValue[0]);
            }
        }
        if ((Intrinsics.areEqual(display, "Health_XML") || Intrinsics.areEqual(display, "Health")) && hashMap.containsKey("HealthChanged")) {
            LuaRuntime luaRuntime2 = this.this$0;
            LuaValue[] luaValueArr = new LuaValue[1];
            LuaRuntime luaRuntime3 = this.this$0;
            Object obj = inst.get("Health_XML");
            if (obj == null) {
                obj = inst.get("Health");
            }
            luaValueArr[0] = LuaRuntime.toLua$default(luaRuntime3, obj, null, null, 6, null);
            luaRuntime2.fire(inst, "HealthChanged", luaValueArr);
        }
    }
}
