package com.exampletest.mobilestudiotest.lua;

import androidx.core.app.NotificationCompat;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ThreeArgFunction;

/* compiled from: InstanceApi.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/exampletest/mobilestudiotest/lua/InstanceApi$animationTrack$9", "Lorg/luaj/vm2/lib/ThreeArgFunction;", NotificationCompat.CATEGORY_CALL, "Lorg/luaj/vm2/LuaValue;", "self", "k", "v", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InstanceApi$animationTrack$9 extends ThreeArgFunction {
    final /* synthetic */ Ref.ObjectRef<Boolean> $looped;
    final /* synthetic */ PlaySession $play;
    final /* synthetic */ Ref.ObjectRef<Integer> $priority;
    final /* synthetic */ PlaySession.ScriptTrack $st;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstanceApi$animationTrack$9(Ref.ObjectRef<Boolean> objectRef, PlaySession.ScriptTrack scriptTrack, Ref.ObjectRef<Integer> objectRef2, PlaySession playSession) {
        this.$looped = objectRef;
        this.$st = scriptTrack;
        this.$priority = objectRef2;
        this.$play = playSession;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Boolean] */
    @Override // org.luaj.vm2.lib.ThreeArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue self, LuaValue k, LuaValue v) {
        PlaySession playSession;
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(k, "k");
        Intrinsics.checkNotNullParameter(v, "v");
        String str = k.tojstring();
        if (str != null) {
            switch (str.hashCode()) {
                case -2013223325:
                    if (str.equals("Looped")) {
                        this.$looped.element = Boolean.valueOf(v.toboolean());
                        PlaySession.ScriptTrack scriptTrack = this.$st;
                        if (scriptTrack != null) {
                            PlaySession playSession2 = this.$play;
                            Ref.ObjectRef<Boolean> objectRef = this.$looped;
                            if (playSession2 == null) {
                                break;
                            } else {
                                PlaySession.adjustTrack$default(playSession2, scriptTrack, null, null, null, objectRef.element, null, null, 110, null);
                                break;
                            }
                        }
                    }
                    break;
                case -1100816956:
                    if (str.equals("Priority")) {
                        Ref.ObjectRef<Integer> objectRef2 = this.$priority;
                        Object obj = v.isuserdata() ? v.touserdata() : null;
                        EnumItemV enumItemV = (EnumItemV) (obj instanceof EnumItemV ? obj : null);
                        objectRef2.element = Integer.valueOf(enumItemV != null ? enumItemV.getValue() : v.optint(1000));
                        PlaySession.ScriptTrack scriptTrack2 = this.$st;
                        if (scriptTrack2 != null) {
                            PlaySession playSession3 = this.$play;
                            Ref.ObjectRef<Integer> objectRef3 = this.$priority;
                            if (playSession3 == null) {
                                break;
                            } else {
                                PlaySession.adjustTrack$default(playSession3, scriptTrack2, null, null, null, null, objectRef3.element, null, 94, null);
                                break;
                            }
                        }
                    }
                    break;
                case 1254721334:
                    if (str.equals("TimePosition")) {
                        PlaySession.ScriptTrack scriptTrack3 = this.$st;
                        if (scriptTrack3 != null && (playSession = this.$play) != null) {
                            PlaySession.adjustTrack$default(playSession, scriptTrack3, null, null, null, null, null, Float.valueOf((float) v.optdouble(0.0d)), 62, null);
                            break;
                        }
                    }
                    break;
            }
            LuaValue NONE = LuaValue.NONE;
            Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            return NONE;
        }
        ((LuaTable) self).rawset(k, v);
        LuaValue NONE2 = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE2, "NONE");
        return NONE2;
    }
}
