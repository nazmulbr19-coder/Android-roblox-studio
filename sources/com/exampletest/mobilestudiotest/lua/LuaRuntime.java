package com.exampletest.mobilestudiotest.lua;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.model.BinaryString;
import com.exampletest.mobilestudiotest.model.BrickColorV;
import com.exampletest.mobilestudiotest.model.BrickColors;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.ContentValue;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Enums;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.OptionalCFrame;
import com.exampletest.mobilestudiotest.model.SharedStr;
import com.exampletest.mobilestudiotest.model.TreeListener;
import com.exampletest.mobilestudiotest.model.UDim2;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LoadState;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.compiler.DumpState;
import org.luaj.vm2.lib.DebugLib;
import org.luaj.vm2.lib.jse.JsePlatform;

/* compiled from: LuaRuntime.kt */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0016\u0018\u0000 ¸\u00012\u00020\u0001:\u0006¶\u0001·\u0001¸\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u000201J\u0006\u0010`\u001a\u00020LJ\u0010\u0010a\u001a\u00020B2\b\u0010b\u001a\u0004\u0018\u00010AJ(\u0010c\u001a\u00020B2\b\u0010d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010f\u001a\u0004\u0018\u000108J7\u0010g\u001a\u0004\u0018\u00010\u00012\u0006\u0010d\u001a\u00020B2\b\u0010h\u001a\u0004\u0018\u00010i2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010f\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010jJ\u0016\u0010k\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u00012\u0006\u0010l\u001a\u000208J&\u0010m\u001a\u0002092\u0006\u0010e\u001a\u00020\u00012\u0006\u0010l\u001a\u0002082\u0006\u0010n\u001a\u00020B2\u0006\u0010o\u001a\u00020\u0007J\u000e\u0010p\u001a\u00020L2\u0006\u0010q\u001a\u000209J\u0010\u0010r\u001a\u00020L2\u0006\u0010s\u001a\u00020AH\u0002J\u0016\u0010t\u001a\u0002022\u0006\u0010e\u001a\u00020\u00012\u0006\u0010l\u001a\u000208J/\u0010u\u001a\u00020L2\u0006\u0010e\u001a\u00020\u00012\u0006\u0010l\u001a\u0002082\u0012\u0010v\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0w\"\u00020B¢\u0006\u0002\u0010xJ\u001e\u0010y\u001a\u00020L2\u0006\u0010e\u001a\u00020\u00012\u0006\u0010l\u001a\u0002082\u0006\u0010v\u001a\u000202J\b\u0010z\u001a\u0004\u0018\u000101J\u0018\u0010{\u001a\u0004\u0018\u0001022\u0006\u0010n\u001a\u00020B2\u0006\u0010v\u001a\u000202J\u000e\u0010|\u001a\u0002012\u0006\u0010n\u001a\u00020BJ\u0016\u0010}\u001a\u0002012\u0006\u0010n\u001a\u00020B2\u0006\u0010v\u001a\u000202J\u0016\u0010~\u001a\u00020L2\u0006\u0010_\u001a\u0002012\u0006\u0010v\u001a\u000202J\u000f\u0010\u007f\u001a\u00020L2\u0007\u0010\u0080\u0001\u001a\u000208J\u0010\u0010\u0081\u0001\u001a\u0002082\u0007\u0010\u0082\u0001\u001a\u000208J\u0010\u0010\u0083\u0001\u001a\u0002022\u0007\u0010\u0084\u0001\u001a\u00020\"J\u0018\u0010\u0085\u0001\u001a\u00020L2\u0007\u0010\u0084\u0001\u001a\u00020\"2\u0006\u0010_\u001a\u000201J\u0017\u0010\u0086\u0001\u001a\u00020L2\u0006\u0010_\u001a\u0002012\u0006\u0010v\u001a\u000202J\u001e\u0010\u0088\u0001\u001a\u00020L2\u0007\u0010\u0084\u0001\u001a\u00020\"2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020L0KJ\u000f\u0010\u0089\u0001\u001a\u00020L2\u0006\u0010_\u001a\u000201J)\u0010\u008a\u0001\u001a\u0002022\u0007\u0010\u008b\u0001\u001a\u00020A2\u0006\u0010l\u001a\u0002082\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\"¢\u0006\u0003\u0010\u008d\u0001J\t\u0010\u008e\u0001\u001a\u00020LH\u0002J\u0010\u0010\u008f\u0001\u001a\u00020L2\u0007\u0010\u0090\u0001\u001a\u00020\"J\u0013\u0010\u0091\u0001\u001a\u00020L2\b\u0010\u0090\u0001\u001a\u00030\u0092\u0001H\u0002J\u0010\u0010\u0093\u0001\u001a\u00020L2\u0007\u0010\u0094\u0001\u001a\u00020=J\"\u0010\u0095\u0001\u001a\u00020B2\u0007\u0010\u0096\u0001\u001a\u0002082\u0007\u0010\u0097\u0001\u001a\u0002082\u0007\u0010\u0098\u0001\u001a\u00020\u0014J\u001c\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u0096\u0001\u001a\u0002082\u0007\u0010\u0097\u0001\u001a\u000208H\u0002J\u001e\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0007\u0010\u0097\u0001\u001a\u0002082\u0007\u0010\u0096\u0001\u001a\u000208H\u0002J\u001e\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0007\u0010\u0097\u0001\u001a\u0002082\u0007\u0010\u0096\u0001\u001a\u000208H\u0002J%\u0010\u009e\u0001\u001a\u00020L2\u0007\u0010\u0097\u0001\u001a\u0002082\u0007\u0010\u0096\u0001\u001a\u0002082\b\u0010\u009f\u0001\u001a\u00030\u009a\u0001H\u0002J*\u0010 \u0001\u001a\u00020\u00142\t\u0010¡\u0001\u001a\u0004\u0018\u00010A2\u0016\b\u0002\u0010¢\u0001\u001a\u000f\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020B0£\u0001J(\u0010¤\u0001\u001a\u00020L2\u0007\u0010¡\u0001\u001a\u00020A2\u0016\b\u0002\u0010¢\u0001\u001a\u000f\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020B0£\u0001J\u0010\u0010©\u0001\u001a\u00020L2\u0007\u0010ª\u0001\u001a\u000208J\u0010\u0010«\u0001\u001a\u00020B2\u0007\u0010¬\u0001\u001a\u00020AJ\t\u0010³\u0001\u001a\u0004\u0018\u00010\u0014J\u000f\u0010´\u0001\u001a\u00020L2\u0006\u0010s\u001a\u00020AJ\u0011\u0010µ\u0001\u001a\u00020L2\u0006\u0010s\u001a\u00020AH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010/\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202000,j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020200`.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u0002040,j\b\u0012\u0004\u0012\u000204`.X\u0082\u0004¢\u0006\u0002\n\u0000RV\u00105\u001aJ\u0012\u0004\u0012\u00020\u0001\u0012@\u0012>\u0012\u0004\u0012\u000208\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002090,j\b\u0012\u0004\u0012\u000209`.07j\u001e\u0012\u0004\u0012\u000208\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002090,j\b\u0012\u0004\u0012\u000209`.`:06X\u0082\u0004¢\u0006\u0002\n\u0000RV\u0010;\u001aJ\u0012\u0004\u0012\u00020\u0001\u0012@\u0012>\u0012\u0004\u0012\u000208\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002010,j\b\u0012\u0004\u0012\u000201`.07j\u001e\u0012\u0004\u0012\u000208\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002010,j\b\u0012\u0004\u0012\u000201`.`:06X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010<\u001a\u0012\u0012\u0004\u0012\u00020=0,j\b\u0012\u0004\u0012\u00020=`.¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001d\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B06¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B0FX\u0082\u0004¢\u0006\u0002\n\u0000R9\u0010G\u001a*\u0012\u0004\u0012\u00020A\u0012 \u0012\u001e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020B07j\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020B`:06¢\u0006\b\n\u0000\u001a\u0004\bH\u0010DR\u001d\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K0J¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010O\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0016R\u000e\u0010Q\u001a\u00020RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010U\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\b\u0012\u0004\u0012\u0002080YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010Z\u001a\u00020[¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]RC\u0010\u0087\u0001\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K000,j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K00`.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010¥\u0001\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0005\b¦\u0001\u0010\u0016R,\u0010\u00ad\u0001\u001a\u000f\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020B0£\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R+\u0010²\u0001\u001a\u001e\u0012\u0004\u0012\u000201\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140,j\b\u0012\u0004\u0012\u00020\u0014`.06X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "dm", "Lcom/exampletest/mobilestudiotest/model/DataModel;", "isPlay", "", "<init>", "(Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/model/DataModel;Z)V", "getStudio", "()Lcom/exampletest/mobilestudiotest/core/Studio;", "getDm", "()Lcom/exampletest/mobilestudiotest/model/DataModel;", "()Z", "globals", "Lorg/luaj/vm2/Globals;", "getGlobals", "()Lorg/luaj/vm2/Globals;", "instanceMeta", "Lorg/luaj/vm2/LuaTable;", "getInstanceMeta", "()Lorg/luaj/vm2/LuaTable;", "api", "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", "getApi", "()Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", "play", "Lcom/exampletest/mobilestudiotest/engine/PlaySession;", "getPlay", "()Lcom/exampletest/mobilestudiotest/engine/PlaySession;", "setPlay", "(Lcom/exampletest/mobilestudiotest/engine/PlaySession;)V", "time", "", "getTime", "()D", "setTime", "(D)V", "stopped", "getStopped", "setStopped", "(Z)V", "waiting", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime$Waiting;", "Lkotlin/collections/ArrayList;", "deferred", "Lkotlin/Pair;", "Lorg/luaj/vm2/LuaThread;", "Lorg/luaj/vm2/Varargs;", "childWaits", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime$ChildWait;", "conns", "Ljava/util/IdentityHashMap;", "Ljava/util/HashMap;", "", "Lcom/exampletest/mobilestudiotest/lua/Connection;", "Lkotlin/collections/HashMap;", "signalWaiters", "tweens", "Lcom/exampletest/mobilestudiotest/lua/Tween;", "getTweens", "()Ljava/util/ArrayList;", "moduleCache", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lorg/luaj/vm2/LuaValue;", "getModuleCache", "()Ljava/util/IdentityHashMap;", "wrappers", "Ljava/util/WeakHashMap;", "callbacks", "getCallbacks", "mainQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function0;", "", "getMainQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "sharedTable", "getSharedTable", "resumeStart", "", "sethook", "hookFn", "debugGetinfo", "getDebugGetinfo", "()Lorg/luaj/vm2/LuaValue;", "directEvents", "", "treeListener", "Lcom/exampletest/mobilestudiotest/model/TreeListener;", "getTreeListener", "()Lcom/exampletest/mobilestudiotest/model/TreeListener;", "setHook", "co", "shutdown", "wrap", "inst", "toLua", "v", "owner", "prop", "fromLua", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "(Lorg/luaj/vm2/LuaValue;Ljava/lang/Integer;Lcom/exampletest/mobilestudiotest/model/Instance;Ljava/lang/String;)Ljava/lang/Object;", "hasConn", "name", "connect", "fn", "once", "disconnect", "c", "disconnectTree", "i", "waitSignal", "fire", "args", "", "(Ljava/lang/Object;Ljava/lang/String;[Lorg/luaj/vm2/LuaValue;)V", "fireArgs", "currentCoroutine", "callDirect", "newThread", "spawn", "resume", "reportError", NotificationCompat.CATEGORY_MESSAGE, "cleanError", "m", "yieldFor", "seconds", "delay", "defer", "timers", "after", "cancel", "waitForChild", "parent", "timeout", "(Lcom/exampletest/mobilestudiotest/model/Instance;Ljava/lang/String;Ljava/lang/Double;)Lorg/luaj/vm2/Varargs;", "checkChildWaits", "step", "dt", "stepTweens", "", "playTween", "tw", "compile", "source", "chunkName", "env", "compileLuau", "Lorg/luaj/vm2/Prototype;", "diskFile", "Ljava/io/File;", "fromDisk", "toDisk", "p", "envFor", "script", "extra", "", "runScript", "commandEnv", "getCommandEnv", "commandEnv$delegate", "Lkotlin/Lazy;", "runCommand", "code", "require", "module", "extraEnvForModules", "getExtraEnvForModules", "()Ljava/util/Map;", "setExtraEnvForModules", "(Ljava/util/Map;)V", "moduleEnvs", "loadingModuleEnv", "onAncestryChanged", "notifyAncestry", "Waiting", "ChildWait", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaRuntime {
    private static final long WAIT_BUDGET_NS = 12000000;
    private static volatile File luacDir;
    private static volatile String stamp;
    private final InstanceApi api;
    private final IdentityHashMap<Instance, HashMap<String, LuaValue>> callbacks;
    private final ArrayList<ChildWait> childWaits;

    /* renamed from: commandEnv$delegate, reason: from kotlin metadata */
    private final Lazy commandEnv;
    private final IdentityHashMap<Object, HashMap<String, ArrayList<Connection>>> conns;
    private final LuaValue debugGetinfo;
    private final ArrayList<Pair<LuaThread, Varargs>> deferred;
    private final Set<String> directEvents;
    private final DataModel dm;
    private Map<String, ? extends LuaValue> extraEnvForModules;
    private final Globals globals;
    private final LuaValue hookFn;
    private final LuaTable instanceMeta;
    private final boolean isPlay;
    private final ConcurrentLinkedQueue<Function0<Unit>> mainQueue;
    private final IdentityHashMap<Instance, LuaValue> moduleCache;
    private final IdentityHashMap<LuaThread, ArrayList<LuaTable>> moduleEnvs;
    private PlaySession play;
    private long resumeStart;
    private final LuaValue sethook;
    private final LuaTable sharedTable;
    private final IdentityHashMap<Object, HashMap<String, ArrayList<LuaThread>>> signalWaiters;
    private boolean stopped;
    private final Studio studio;
    private double time;
    private final ArrayList<Pair<Double, Function0<Unit>>> timers;
    private final TreeListener treeListener;
    private final ArrayList<Tween> tweens;
    private final ArrayList<Waiting> waiting;
    private final WeakHashMap<Instance, LuaValue> wrappers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LuaRuntime$Companion$protoCache$1 protoCache = new LuaRuntime$Companion$protoCache$1();

    /* compiled from: LuaRuntime.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuaRuntime$ChildWait;", "", "parent", "Lcom/exampletest/mobilestudiotest/model/Instance;", "name", "", "co", "Lorg/luaj/vm2/LuaThread;", "deadline", "", "start", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Ljava/lang/String;Lorg/luaj/vm2/LuaThread;DD)V", "getParent", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getName", "()Ljava/lang/String;", "getCo", "()Lorg/luaj/vm2/LuaThread;", "getDeadline", "()D", "getStart", "warned", "", "getWarned", "()Z", "setWarned", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    private static final class ChildWait {
        private final LuaThread co;
        private final double deadline;
        private final String name;
        private final Instance parent;
        private final double start;
        private boolean warned;

        public ChildWait(Instance parent, String name, LuaThread co, double d, double d2) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(co, "co");
            this.parent = parent;
            this.name = name;
            this.co = co;
            this.deadline = d;
            this.start = d2;
        }

        public final LuaThread getCo() {
            return this.co;
        }

        public final double getDeadline() {
            return this.deadline;
        }

        public final String getName() {
            return this.name;
        }

        public final Instance getParent() {
            return this.parent;
        }

        public final double getStart() {
            return this.start;
        }

        public final boolean getWarned() {
            return this.warned;
        }

        public final void setWarned(boolean z) {
            this.warned = z;
        }
    }

    /* compiled from: LuaRuntime.kt */
    @Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuaRuntime$Companion;", "", "<init>", "()V", "WAIT_BUDGET_NS", "", "protoCache", "com/exampletest/mobilestudiotest/lua/LuaRuntime$Companion$protoCache$1", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime$Companion$protoCache$1;", "stamp", "", "luacDir", "Ljava/io/File;", "buildStamp", "ctx", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final /* synthetic */ String access$buildStamp(Companion companion, Context context) {
            return companion.buildStamp(context);
        }

        private final String buildStamp(Context ctx) {
            String access$getStamp$cp = LuaRuntime.access$getStamp$cp();
            if (access$getStamp$cp == null) {
                try {
                    access$getStamp$cp = String.valueOf(ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).lastUpdateTime);
                } catch (Exception e) {
                    access$getStamp$cp = "0";
                }
                Companion companion = LuaRuntime.INSTANCE;
                LuaRuntime.access$setStamp$cp(access$getStamp$cp);
            }
            return access$getStamp$cp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LuaRuntime.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuaRuntime$Waiting;", "", "co", "Lorg/luaj/vm2/LuaThread;", "at", "", "start", "<init>", "(Lorg/luaj/vm2/LuaThread;DD)V", "getCo", "()Lorg/luaj/vm2/LuaThread;", "getAt", "()D", "getStart", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Waiting {
        private final double at;
        private final LuaThread co;
        private final double start;

        public Waiting(LuaThread co, double d, double d2) {
            Intrinsics.checkNotNullParameter(co, "co");
            this.co = co;
            this.at = d;
            this.start = d2;
        }

        public final double getAt() {
            return this.at;
        }

        public final LuaThread getCo() {
            return this.co;
        }

        public final double getStart() {
            return this.start;
        }
    }

    public LuaRuntime(Studio studio, DataModel dm, boolean z) {
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(dm, "dm");
        this.studio = studio;
        this.dm = dm;
        this.isPlay = z;
        Globals standardGlobals = JsePlatform.standardGlobals();
        Intrinsics.checkNotNullExpressionValue(standardGlobals, "standardGlobals(...)");
        this.globals = standardGlobals;
        this.instanceMeta = new LuaTable();
        this.api = new InstanceApi(this);
        this.waiting = new ArrayList<>();
        this.deferred = new ArrayList<>();
        this.childWaits = new ArrayList<>();
        this.conns = new IdentityHashMap<>();
        this.signalWaiters = new IdentityHashMap<>();
        this.tweens = new ArrayList<>();
        this.moduleCache = new IdentityHashMap<>();
        this.wrappers = new WeakHashMap<>();
        this.callbacks = new IdentityHashMap<>();
        this.mainQueue = new ConcurrentLinkedQueue<>();
        this.sharedTable = new LuaTable();
        this.directEvents = SetsKt.setOf((Object[]) new String[]{"Heartbeat", "RenderStepped", "Stepped", "PreSimulation", "PostSimulation", "PreRender", "Changed", "AttributeChanged"});
        this.treeListener = new LuaRuntime$treeListener$1(this);
        this.globals.load(new DebugLib());
        LuaValue luaValue = this.globals.get("debug").get("sethook");
        Intrinsics.checkNotNullExpressionValue(luaValue, "get(...)");
        this.sethook = luaValue;
        LuaValue luaValue2 = this.globals.get("debug").get("getinfo");
        Intrinsics.checkNotNullExpressionValue(luaValue2, "get(...)");
        this.debugGetinfo = luaValue2;
        this.hookFn = LuaTypesKt.fnv(new LuaRuntime$$ExternalSyntheticLambda2(this));
        LuaTable luaTable = new LuaTable();
        luaTable.set("traceback", this.globals.get("debug").get("traceback"));
        luaTable.set("profilebegin", LuaTypesKt.fnv(new LuaRuntime$$ExternalSyntheticLambda3()));
        luaTable.set("profileend", LuaTypesKt.fnv(new LuaRuntime$$ExternalSyntheticLambda4()));
        luaTable.set("info", LuaTypesKt.fnv(new LuaRuntime$$ExternalSyntheticLambda5()));
        this.globals.set("debug", luaTable);
        LuaSandbox.INSTANCE.lockDown(this.globals);
        LuaThread running = this.globals.running;
        Intrinsics.checkNotNullExpressionValue(running, "running");
        setHook(running);
        LuaTypes.INSTANCE.install(this.globals);
        RobloxGlobals.INSTANCE.install(this);
        this.dm.getListeners().add(this.treeListener);
        this.timers = new ArrayList<>();
        this.commandEnv = LazyKt.lazy(new LuaRuntime$$ExternalSyntheticLambda6(this));
        this.extraEnvForModules = MapsKt.emptyMap();
        this.moduleEnvs = new IdentityHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs _init_$lambda$0(LuaRuntime luaRuntime, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        if (luaRuntime.stopped) {
            throw new LuaError("Script stopped");
        }
        if (luaRuntime.resumeStart != 0 && System.currentTimeMillis() - luaRuntime.resumeStart > 10000) {
            throw new LuaError("Script timeout: exhausted allowed execution time");
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs _init_$lambda$1(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs _init_$lambda$2(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs _init_$lambda$3(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaString valueOf = LuaValue.valueOf(a.arg(1).tojstring());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    public static final /* synthetic */ void access$checkChildWaits(LuaRuntime luaRuntime) {
        luaRuntime.checkChildWaits();
    }

    public static final /* synthetic */ void access$disconnectTree(LuaRuntime luaRuntime, Instance instance) {
        luaRuntime.disconnectTree(instance);
    }

    public static final /* synthetic */ ArrayList access$getChildWaits$p(LuaRuntime luaRuntime) {
        return luaRuntime.childWaits;
    }

    public static final /* synthetic */ IdentityHashMap access$getConns$p(LuaRuntime luaRuntime) {
        return luaRuntime.conns;
    }

    public static final /* synthetic */ String access$getStamp$cp() {
        return stamp;
    }

    public static final /* synthetic */ void access$notifyAncestry(LuaRuntime luaRuntime, Instance instance) {
        luaRuntime.notifyAncestry(instance);
    }

    public static final /* synthetic */ void access$setStamp$cp(String str) {
        stamp = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean cancel$lambda$13(LuaThread luaThread, Waiting it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCo() == luaThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean cancel$lambda$14(LuaThread luaThread, Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFirst() == luaThread;
    }

    private final void checkChildWaits() {
        ArrayList<ChildWait> arrayList = this.childWaits;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ChildWait childWait = (ChildWait) next;
            if (Instance.findFirstChild$default(childWait.getParent(), childWait.getName(), false, 2, null) != null) {
                arrayList2.add(next);
            }
        }
        ArrayList<ChildWait> arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return;
        }
        this.childWaits.removeAll(arrayList3);
        for (ChildWait childWait2 : arrayList3) {
            this.deferred.add(TuplesKt.to(childWait2.getCo(), wrap(Instance.findFirstChild$default(childWait2.getParent(), childWait2.getName(), false, 2, null))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaTable commandEnv_delegate$lambda$38(LuaRuntime luaRuntime) {
        return envFor$default(luaRuntime, null, null, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
    
        if ((r6 != null && kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) "local variables", false, 2, (java.lang.Object) null)) == false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final org.luaj.vm2.Prototype compileLuau(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "="
            java.lang.String r1 = "getBytes(...)"
            r2 = 0
            r3 = 2
            r4 = 0
            org.luaj.vm2.Globals r5 = r9.globals     // Catch: java.lang.Exception -> L39
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L39
            com.exampletest.mobilestudiotest.lua.LuauTranspiler r7 = com.exampletest.mobilestudiotest.lua.LuauTranspiler.INSTANCE     // Catch: java.lang.Exception -> L39
            java.lang.String r7 = com.exampletest.mobilestudiotest.lua.LuauTranspiler.transpile$default(r7, r10, r4, r3, r2)     // Catch: java.lang.Exception -> L39
            java.nio.charset.Charset r8 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Exception -> L39
            byte[] r7 = r7.getBytes(r8)     // Catch: java.lang.Exception -> L39
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch: java.lang.Exception -> L39
            r6.<init>(r7)     // Catch: java.lang.Exception -> L39
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch: java.lang.Exception -> L39
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L39
            r7.<init>()     // Catch: java.lang.Exception -> L39
            java.lang.StringBuilder r7 = r7.append(r0)     // Catch: java.lang.Exception -> L39
            java.lang.StringBuilder r7 = r7.append(r11)     // Catch: java.lang.Exception -> L39
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L39
            org.luaj.vm2.Prototype r5 = r5.compilePrototype(r6, r7)     // Catch: java.lang.Exception -> L39
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.Exception -> L39
            goto Lad
        L39:
            r5 = move-exception
            boolean r6 = r5 instanceof java.lang.NullPointerException
            r7 = 1
            if (r6 != 0) goto L78
            boolean r6 = r5 instanceof org.luaj.vm2.LuaError
            if (r6 == 0) goto L77
            r6 = r5
            org.luaj.vm2.LuaError r6 = (org.luaj.vm2.LuaError) r6
            java.lang.String r6 = r6.getMessage()
            if (r6 == 0) goto L5a
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r8 = "upvalue"
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r8, r4, r3, r2)
            if (r6 != r7) goto L5a
            r6 = r7
            goto L5b
        L5a:
            r6 = r4
        L5b:
            if (r6 != 0) goto L78
            r6 = r5
            org.luaj.vm2.LuaError r6 = (org.luaj.vm2.LuaError) r6
            java.lang.String r6 = r6.getMessage()
            if (r6 == 0) goto L74
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r8 = "local variables"
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r2 = kotlin.text.StringsKt.contains$default(r6, r8, r4, r3, r2)
            if (r2 != r7) goto L74
            r2 = r7
            goto L75
        L74:
            r2 = r4
        L75:
            if (r2 != 0) goto L78
        L77:
            goto L79
        L78:
            r4 = r7
        L79:
            if (r4 == 0) goto Lae
            org.luaj.vm2.Globals r2 = r9.globals
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            com.exampletest.mobilestudiotest.lua.LuauTranspiler r6 = com.exampletest.mobilestudiotest.lua.LuauTranspiler.INSTANCE
            java.lang.String r6 = r6.transpile(r10, r7)
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8
            byte[] r6 = r6.getBytes(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r3.<init>(r6)
            java.io.InputStream r3 = (java.io.InputStream) r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r0 = r0.toString()
            org.luaj.vm2.Prototype r0 = r2.compilePrototype(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r5 = r0
        Lad:
            return r5
        Lae:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaRuntime.compileLuau(java.lang.String, java.lang.String):org.luaj.vm2.Prototype");
    }

    private final void disconnectTree(Instance i) {
        this.conns.remove(i);
        this.signalWaiters.remove(i);
        this.callbacks.remove(i);
        Iterator<Instance> it = i.getChildren().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            disconnectTree(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e A[Catch: all -> 0x00c5, TryCatch #1 {all -> 0x00c5, blocks: (B:39:0x0064, B:41:0x006a, B:45:0x007e, B:47:0x0081, B:57:0x008a, B:58:0x009a, B:60:0x00a0, B:63:0x00b5), top: B:38:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.io.File diskFile(java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaRuntime.diskFile(java.lang.String, java.lang.String):java.io.File");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence diskFile$lambda$34(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LuaTable envFor$default(LuaRuntime luaRuntime, Instance instance, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return luaRuntime.envFor(instance, map);
    }

    private final Prototype fromDisk(String chunkName, String source) {
        File diskFile;
        if (source.length() >= 2000 && (diskFile = diskFile(chunkName, source)) != null) {
            if (!diskFile.isFile()) {
                diskFile = null;
            }
            if (diskFile != null) {
                try {
                    InputStream fileInputStream = new FileInputStream(diskFile);
                    BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
                    try {
                        Prototype undump = LoadState.undump(bufferedInputStream, "=" + chunkName);
                        CloseableKt.closeFinally(bufferedInputStream, null);
                        return undump;
                    } finally {
                    }
                } catch (Exception e) {
                    diskFile.delete();
                    return null;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Object fromLua$default(LuaRuntime luaRuntime, LuaValue luaValue, Integer num, Instance instance, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            instance = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return luaRuntime.fromLua(luaValue, num, instance, str);
    }

    private final LuaTable getCommandEnv() {
        return (LuaTable) this.commandEnv.getValue();
    }

    private final void notifyAncestry(Instance i) {
        if (this.conns.isEmpty()) {
            return;
        }
        onAncestryChanged(i);
        for (Instance instance : Instance.descendants$default(i, null, 1, null)) {
            if (this.conns.containsKey(instance)) {
                onAncestryChanged(instance);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean playTween$lambda$23(Tween tween, Tween it) {
        boolean z;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it == tween || it.getInst() != tween.getInst()) {
            return false;
        }
        Set<String> keySet = it.getGoals().keySet();
        if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
            Iterator<T> it2 = keySet.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                if (tween.getGoals().containsKey((String) it2.next())) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void runScript$default(LuaRuntime luaRuntime, Instance instance, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        luaRuntime.runScript(instance, map);
    }

    private final void stepTweens(float dt) {
        if (this.tweens.isEmpty()) {
            return;
        }
        for (Tween tween : CollectionsKt.toList(this.tweens)) {
            if (tween.getState() == 2 || tween.getState() == 1) {
                tween.setElapsed(tween.getElapsed() + dt);
                if (tween.getState() == 1) {
                    if (tween.getElapsed() >= tween.getInfo().getDelay()) {
                        tween.setState(2);
                        tween.setElapsed(0.0f);
                        Set<String> keySet = tween.getGoals().keySet();
                        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(keySet, 10)), 16));
                        for (Object obj : keySet) {
                            linkedHashMap.put(obj, this.api.getK(tween.getInst(), (String) obj));
                        }
                        tween.setStart(linkedHashMap);
                    }
                }
                float coerceAtLeast = RangesKt.coerceAtLeast(tween.getInfo().getTime(), 1.0E-4f);
                float coerceIn = RangesKt.coerceIn(tween.getElapsed() / coerceAtLeast, 0.0f, 1.0f);
                if (tween.getReversing()) {
                    coerceIn = 1.0f - coerceIn;
                }
                float ease = LuaTypes.INSTANCE.ease(tween.getInfo().getStyle(), tween.getInfo().getDirection(), coerceIn);
                for (Map.Entry<String, Object> entry : tween.getGoals().entrySet()) {
                    String key = entry.getKey();
                    try {
                        this.api.setK(tween.getInst(), key, LuaTypes.INSTANCE.lerpValue(tween.getStart().get(key), entry.getValue(), ease));
                    } catch (Exception e) {
                    }
                }
                if (tween.getElapsed() >= coerceAtLeast) {
                    if (tween.getInfo().getReverses() && !tween.getReversing()) {
                        tween.setReversing(true);
                        tween.setElapsed(0.0f);
                    } else if (tween.getInfo().getRepeatCount() < 0 || tween.getRepeatsDone() < tween.getInfo().getRepeatCount()) {
                        tween.setRepeatsDone(tween.getRepeatsDone() + 1);
                        tween.setReversing(false);
                        tween.setElapsed(0.0f);
                    } else {
                        tween.setState(4);
                        this.tweens.remove(tween);
                        fire(tween, "Completed", LuaTypes.INSTANCE.wrap(new EnumItemV("PlaybackState", "Completed", 4)));
                    }
                }
            }
        }
    }

    private final void toDisk(String chunkName, String source, Prototype p) {
        File diskFile;
        if (source.length() < 2000 || (diskFile = diskFile(chunkName, source)) == null) {
            return;
        }
        try {
            File file = new File(diskFile.getPath() + ".tmp");
            OutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192);
            try {
                DumpState.dump(p, bufferedOutputStream, false);
                CloseableKt.closeFinally(bufferedOutputStream, null);
                file.renameTo(diskFile);
            } finally {
            }
        } catch (Exception e) {
        }
    }

    public static /* synthetic */ LuaValue toLua$default(LuaRuntime luaRuntime, Object obj, Instance instance, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            instance = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return luaRuntime.toLua(obj, instance, str);
    }

    public final void after(double seconds, Function0<Unit> fn) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        this.timers.add(TuplesKt.to(Double.valueOf(this.time + RangesKt.coerceAtLeast(seconds, 0.0d)), fn));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        if (r0 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs callDirect(org.luaj.vm2.LuaValue r7, org.luaj.vm2.Varargs r8) {
        /*
            r6 = this;
            java.lang.String r0 = "fn"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            long r0 = r6.resumeStart
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L21
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r6.resumeStart
            long r0 = r0 - r4
            r4 = 10000(0x2710, double:4.9407E-320)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 != 0) goto L2a
            long r4 = java.lang.System.currentTimeMillis()
            r6.resumeStart = r4
        L2a:
            r1 = 0
            org.luaj.vm2.Varargs r1 = r7.invoke(r8)     // Catch: java.lang.RuntimeException -> L33 java.lang.StackOverflowError -> L3e org.luaj.vm2.LuaError -> L47 java.lang.Throwable -> L5b
            if (r0 != 0) goto L59
            goto L57
        L33:
            r4 = move-exception
            java.lang.String r5 = r4.toString()     // Catch: java.lang.Throwable -> L5b
            r6.reportError(r5)     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L59
            goto L57
        L3e:
            r4 = move-exception
            java.lang.String r5 = "stack overflow"
            r6.reportError(r5)     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L59
            goto L57
        L47:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()     // Catch: java.lang.Throwable -> L5b
            if (r5 != 0) goto L52
            java.lang.String r5 = r4.toString()     // Catch: java.lang.Throwable -> L5b
        L52:
            r6.reportError(r5)     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L59
        L57:
            r6.resumeStart = r2
        L59:
            return r1
        L5b:
            r1 = move-exception
            if (r0 != 0) goto L60
            r6.resumeStart = r2
        L60:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaRuntime.callDirect(org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    public final void cancel(LuaThread co) {
        Intrinsics.checkNotNullParameter(co, "co");
        CollectionsKt.removeAll((List) this.waiting, (Function1) new LuaRuntime$$ExternalSyntheticLambda7(co));
        CollectionsKt.removeAll((List) this.deferred, (Function1) new LuaRuntime$$ExternalSyntheticLambda8(co));
    }

    public final String cleanError(String m) {
        Intrinsics.checkNotNullParameter(m, "m");
        return new Regex("(^|\\s)=(?=[^=:\\n]+:\\d+)").replace(m, "$1");
    }

    public final LuaValue compile(String source, String chunkName, LuaTable env) {
        Pair pair;
        Prototype prototype;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(chunkName, "chunkName");
        Intrinsics.checkNotNullParameter(env, "env");
        String str = chunkName + "\u0000" + source.length() + ":" + source.hashCode();
        synchronized (protoCache) {
            pair = (Pair) protoCache.get((Object) str);
        }
        Prototype prototype2 = null;
        if (pair != null) {
            if (!Intrinsics.areEqual(pair.getFirst(), source)) {
                pair = null;
            }
            if (pair != null) {
                prototype2 = (Prototype) pair.getSecond();
            }
        }
        if (prototype2 == null) {
            prototype = fromDisk(chunkName, source);
            if (prototype == null) {
                prototype = compileLuau(source, chunkName);
                toDisk(chunkName, source, prototype);
            }
            Prototype prototype3 = prototype;
            synchronized (protoCache) {
                protoCache.put(str, TuplesKt.to(source, prototype3));
                Unit unit = Unit.INSTANCE;
            }
        } else {
            prototype = prototype2;
        }
        LuaFunction load = this.globals.loader.load(prototype, "=" + chunkName, env);
        Intrinsics.checkNotNullExpressionValue(load, "load(...)");
        return load;
    }

    public final Connection connect(Object owner, String name, LuaValue fn, boolean once) {
        HashMap<String, ArrayList<Connection>> hashMap;
        ArrayList<Connection> arrayList;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fn, "fn");
        Connection connection = new Connection(owner, name, fn, once);
        IdentityHashMap<Object, HashMap<String, ArrayList<Connection>>> identityHashMap = this.conns;
        HashMap<String, ArrayList<Connection>> hashMap2 = identityHashMap.get(owner);
        if (hashMap2 == null) {
            hashMap = new HashMap<>();
            identityHashMap.put(owner, hashMap);
        } else {
            hashMap = hashMap2;
        }
        HashMap<String, ArrayList<Connection>> hashMap3 = hashMap;
        ArrayList<Connection> arrayList2 = hashMap3.get(name);
        if (arrayList2 == null) {
            arrayList = new ArrayList<>();
            hashMap3.put(name, arrayList);
        } else {
            arrayList = arrayList2;
        }
        arrayList.add(connection);
        return connection;
    }

    public final LuaThread currentCoroutine() {
        LuaThread luaThread = this.globals.running;
        if (luaThread == null || luaThread.isMainThread()) {
            return null;
        }
        return luaThread;
    }

    public final void defer(LuaThread co, Varargs args) {
        Intrinsics.checkNotNullParameter(co, "co");
        Intrinsics.checkNotNullParameter(args, "args");
        this.deferred.add(TuplesKt.to(co, args));
    }

    public final void delay(double seconds, LuaThread co) {
        Intrinsics.checkNotNullParameter(co, "co");
        this.waiting.add(new Waiting(co, this.time + RangesKt.coerceAtLeast(seconds, 0.0d), this.time));
    }

    public final void disconnect(Connection c) {
        ArrayList<Connection> arrayList;
        Intrinsics.checkNotNullParameter(c, "c");
        c.setConnected(false);
        HashMap<String, ArrayList<Connection>> hashMap = this.conns.get(c.getOwner());
        if (hashMap == null || (arrayList = hashMap.get(c.getName())) == null) {
            return;
        }
        arrayList.remove(c);
    }

    public final LuaTable envFor(Instance script, Map<String, ? extends LuaValue> extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Globals globals = new Globals();
        globals.debuglib = this.globals.debuglib;
        LuaTable luaTable = new LuaTable();
        luaTable.set(LuaValue.INDEX, this.globals);
        globals.setmetatable(luaTable);
        globals.set("script", wrap(script));
        for (Map.Entry<String, ? extends LuaValue> entry : extra.entrySet()) {
            globals.set(entry.getKey(), entry.getValue());
        }
        return globals;
    }

    public final void fire(Object owner, String name, LuaValue... args) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Varargs varargsOf = LuaValue.varargsOf(args);
        Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
        fireArgs(owner, name, varargsOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r10, "Attr:", false, 2, (java.lang.Object) null) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void fireArgs(java.lang.Object r9, java.lang.String r10, org.luaj.vm2.Varargs r11) {
        /*
            r8 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r8.stopped
            if (r0 == 0) goto L14
            return
        L14:
            java.util.IdentityHashMap<java.lang.Object, java.util.HashMap<java.lang.String, java.util.ArrayList<com.exampletest.mobilestudiotest.lua.Connection>>> r0 = r8.conns
            java.lang.Object r0 = r0.get(r9)
            java.util.HashMap r0 = (java.util.HashMap) r0
            r1 = 0
            if (r0 == 0) goto L26
            java.lang.Object r0 = r0.get(r10)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            goto L27
        L26:
            r0 = r1
        L27:
            if (r0 == 0) goto L85
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L85
            java.util.Set<java.lang.String> r2 = r8.directEvents
            boolean r2 = r2.contains(r10)
            if (r2 != 0) goto L4d
            java.lang.String r2 = "Changed:"
            r3 = 0
            r4 = 2
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r10, r2, r3, r4, r1)
            if (r2 != 0) goto L4d
            java.lang.String r2 = "Attr:"
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r10, r2, r3, r4, r1)
            if (r2 != 0) goto L4d
            goto L4e
        L4d:
            r3 = 1
        L4e:
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            java.util.Iterator r2 = r2.iterator()
        L59:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L85
            java.lang.Object r4 = r2.next()
            com.exampletest.mobilestudiotest.lua.Connection r4 = (com.exampletest.mobilestudiotest.lua.Connection) r4
            boolean r5 = r4.getConnected()
            if (r5 == 0) goto L59
            boolean r5 = r4.getOnce()
            if (r5 == 0) goto L74
            r8.disconnect(r4)
        L74:
            org.luaj.vm2.LuaValue r5 = r4.getFn()
            if (r3 == 0) goto L7e
            r8.callDirect(r5, r11)
            goto L59
        L7e:
            org.luaj.vm2.LuaThread r5 = r8.spawn(r5, r11)
            org.luaj.vm2.Varargs r5 = (org.luaj.vm2.Varargs) r5
            goto L59
        L85:
            java.util.IdentityHashMap<java.lang.Object, java.util.HashMap<java.lang.String, java.util.ArrayList<org.luaj.vm2.LuaThread>>> r2 = r8.signalWaiters
            java.lang.Object r2 = r2.get(r9)
            java.util.HashMap r2 = (java.util.HashMap) r2
            if (r2 == 0) goto L95
            java.lang.Object r1 = r2.remove(r10)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
        L95:
            if (r1 == 0) goto Lb3
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r4 = r2.iterator()
        L9f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lb2
            java.lang.Object r5 = r4.next()
            r6 = r5
            org.luaj.vm2.LuaThread r6 = (org.luaj.vm2.LuaThread) r6
            r7 = 0
            r8.resume(r6, r11)
            goto L9f
        Lb2:
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaRuntime.fireArgs(java.lang.Object, java.lang.String, org.luaj.vm2.Varargs):void");
    }

    public final Object fromLua(LuaValue v, Integer type, Instance inst, String prop) {
        Integer num;
        Intrinsics.checkNotNullParameter(v, "v");
        r2 = null;
        String str = null;
        if (v.isnil()) {
            if (type == null || type.intValue() != 30) {
                return null;
            }
            return new OptionalCFrame(null);
        }
        Object obj = v.isuserdata() ? v.touserdata() : null;
        if (type != null && type.intValue() == 2) {
            return Boolean.valueOf(v.toboolean());
        }
        if (type != null && type.intValue() == 3) {
            return Integer.valueOf(obj instanceof EnumItemV ? ((EnumItemV) obj).getValue() : (int) v.checkdouble());
        }
        if (type != null && type.intValue() == 4) {
            return Float.valueOf((float) v.checkdouble());
        }
        if (type != null && type.intValue() == 5) {
            return Double.valueOf(v.checkdouble());
        }
        if (type != null && type.intValue() == 27) {
            return Long.valueOf((long) v.checkdouble());
        }
        if (type != null && type.intValue() == 1) {
            if (v.isstring() || v.isnumber()) {
                return v.tojstring();
            }
            throw new LuaError("string expected, got " + LuaTypes.INSTANCE.typeOf(v));
        }
        if (type != null && type.intValue() == 18) {
            if (obj instanceof EnumItemV) {
                return new EnumValue(((EnumItemV) obj).getValue());
            }
            if (v.isnumber()) {
                return new EnumValue(v.toint());
            }
            if (!v.isstring()) {
                throw new LuaError("EnumItem expected");
            }
            if (inst != null && prop != null) {
                str = Enums.INSTANCE.typeForProp(inst.getClassName(), prop);
            }
            LinkedHashMap<String, Integer> linkedHashMap = Enums.INSTANCE.getTypes().get(str);
            if (linkedHashMap == null || (num = linkedHashMap.get(v.tojstring())) == null) {
                throw new LuaError("Invalid value \"" + v.tojstring() + "\" for enum " + (str == null ? "?" : str));
            }
            return new EnumValue(num.intValue());
        }
        if (type != null && type.intValue() == 11) {
            return obj instanceof BrickColorV ? (BrickColorV) obj : obj instanceof Color3 ? new BrickColorV(BrickColors.INSTANCE.closest((Color3) obj)) : new BrickColorV(v.checkint());
        }
        if ((type != null && type.intValue() == 12) || (type != null && type.intValue() == 26)) {
            if (obj instanceof Color3) {
                return (Color3) obj;
            }
            if (obj instanceof BrickColorV) {
                return ((BrickColorV) obj).getColor();
            }
            throw new LuaError("Color3 expected, got " + LuaTypes.INSTANCE.typeOf(v));
        }
        if (type != null && type.intValue() == 19) {
            Instance instance = obj instanceof Instance ? (Instance) obj : null;
            if (instance != null) {
                return instance;
            }
            throw new LuaError("Instance expected, got " + LuaTypes.INSTANCE.typeOf(v));
        }
        if (type != null && type.intValue() == 30) {
            return new OptionalCFrame(obj instanceof CFrame ? (CFrame) obj : null);
        }
        if (type != null && type.intValue() == 34) {
            if (obj instanceof Instance) {
                return new ContentValue(2, "", (Instance) obj);
            }
            String str2 = v.tojstring();
            Intrinsics.checkNotNullExpressionValue(str2, "tojstring(...)");
            return new ContentValue(1, str2, null, 4, null);
        }
        if (type != null && type.intValue() == 14) {
            Vector3 vector3 = obj instanceof Vector3 ? (Vector3) obj : null;
            if (vector3 != null) {
                return vector3;
            }
            throw new LuaError("Vector3 expected, got " + LuaTypes.INSTANCE.typeOf(v));
        }
        if (type != null && type.intValue() == 16) {
            CFrame cFrame = obj instanceof CFrame ? (CFrame) obj : null;
            if (cFrame != null) {
                return cFrame;
            }
            throw new LuaError("CFrame expected, got " + LuaTypes.INSTANCE.typeOf(v));
        }
        if (type != null && type.intValue() == 7) {
            UDim2 uDim2 = obj instanceof UDim2 ? (UDim2) obj : null;
            if (uDim2 != null) {
                return uDim2;
            }
            throw new LuaError("UDim2 expected, got " + LuaTypes.INSTANCE.typeOf(v));
        }
        if (obj != null) {
            return obj instanceof EnumItemV ? new EnumValue(((EnumItemV) obj).getValue()) : obj;
        }
        if (v.isboolean()) {
            return Boolean.valueOf(v.toboolean());
        }
        if (v.isnumber()) {
            return Double.valueOf(v.todouble());
        }
        if (v.isstring()) {
            return v.tojstring();
        }
        throw new LuaError("Unable to assign value of type " + LuaTypes.INSTANCE.typeOf(v));
    }

    public final InstanceApi getApi() {
        return this.api;
    }

    public final IdentityHashMap<Instance, HashMap<String, LuaValue>> getCallbacks() {
        return this.callbacks;
    }

    public final LuaValue getDebugGetinfo() {
        return this.debugGetinfo;
    }

    public final DataModel getDm() {
        return this.dm;
    }

    public final Map<String, LuaValue> getExtraEnvForModules() {
        return this.extraEnvForModules;
    }

    public final Globals getGlobals() {
        return this.globals;
    }

    public final LuaTable getInstanceMeta() {
        return this.instanceMeta;
    }

    public final ConcurrentLinkedQueue<Function0<Unit>> getMainQueue() {
        return this.mainQueue;
    }

    public final IdentityHashMap<Instance, LuaValue> getModuleCache() {
        return this.moduleCache;
    }

    public final PlaySession getPlay() {
        return this.play;
    }

    public final LuaTable getSharedTable() {
        return this.sharedTable;
    }

    public final boolean getStopped() {
        return this.stopped;
    }

    public final Studio getStudio() {
        return this.studio;
    }

    public final double getTime() {
        return this.time;
    }

    public final TreeListener getTreeListener() {
        return this.treeListener;
    }

    public final ArrayList<Tween> getTweens() {
        return this.tweens;
    }

    public final boolean hasConn(Object owner, String name) {
        ArrayList<LuaThread> arrayList;
        ArrayList<Connection> arrayList2;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap<String, ArrayList<Connection>> hashMap = this.conns.get(owner);
        if (!((hashMap == null || (arrayList2 = hashMap.get(name)) == null || !(arrayList2.isEmpty() ^ true)) ? false : true)) {
            HashMap<String, ArrayList<LuaThread>> hashMap2 = this.signalWaiters.get(owner);
            if (!((hashMap2 == null || (arrayList = hashMap2.get(name)) == null || !(arrayList.isEmpty() ^ true)) ? false : true)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isPlay, reason: from getter */
    public final boolean getIsPlay() {
        return this.isPlay;
    }

    public final LuaTable loadingModuleEnv() {
        ArrayList<LuaTable> arrayList = this.moduleEnvs.get(this.globals.running);
        if (arrayList != null) {
            return (LuaTable) CollectionsKt.lastOrNull((List) arrayList);
        }
        return null;
    }

    public final LuaThread newThread(LuaValue fn) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        LuaThread luaThread = new LuaThread(this.globals, fn);
        setHook(luaThread);
        return luaThread;
    }

    public final void onAncestryChanged(Instance i) {
        Intrinsics.checkNotNullParameter(i, "i");
        if (hasConn(i, "AncestryChanged")) {
            fire(i, "AncestryChanged", wrap(i), wrap(i.getParent()));
        }
    }

    public final void playTween(Tween tw) {
        Intrinsics.checkNotNullParameter(tw, "tw");
        CollectionsKt.removeAll((List) this.tweens, (Function1) new LuaRuntime$$ExternalSyntheticLambda1(tw));
        if (tw.getState() == 3) {
            tw.setState(2);
            if (this.tweens.contains(tw)) {
                return;
            }
            this.tweens.add(tw);
            return;
        }
        tw.setElapsed(0.0f);
        tw.setRepeatsDone(0);
        tw.setReversing(false);
        if (tw.getInfo().getDelay() > 0.0f) {
            tw.setState(1);
        } else {
            tw.setState(2);
            Set<String> keySet = tw.getGoals().keySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(keySet, 10)), 16));
            for (Object obj : keySet) {
                linkedHashMap.put(obj, this.api.getK(tw.getInst(), (String) obj));
            }
            tw.setStart(linkedHashMap);
        }
        if (this.tweens.contains(tw)) {
            return;
        }
        this.tweens.add(tw);
    }

    public final void reportError(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (this.stopped) {
            return;
        }
        OutputLog.INSTANCE.error(cleanError(msg));
    }

    public final LuaValue require(Instance module) {
        ArrayList<LuaTable> arrayList;
        Intrinsics.checkNotNullParameter(module, "module");
        LuaValue luaValue = this.moduleCache.get(module);
        if (luaValue != null) {
            return luaValue;
        }
        if (!module.isA("ModuleScript")) {
            throw new LuaError("Attempted to call require with invalid argument(s).");
        }
        Instance instance = module;
        while (true) {
            if ((instance != null ? instance.getParent() : null) == null) {
                break;
            }
            instance = instance.getParent();
        }
        LuaTable envFor = envFor(module, Intrinsics.areEqual(instance != null ? instance.getClassName() : null, "Plugin") ? MapsKt.plus(this.extraEnvForModules, TuplesKt.to("plugin", wrap(instance))) : this.extraEnvForModules);
        Object obj = module.get("Source");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        LuaValue compile = compile(str, module.fullName(), envFor);
        LuaThread luaThread = this.globals.running;
        IdentityHashMap<LuaThread, ArrayList<LuaTable>> identityHashMap = this.moduleEnvs;
        ArrayList<LuaTable> arrayList2 = identityHashMap.get(luaThread);
        if (arrayList2 == null) {
            arrayList = new ArrayList<>();
            identityHashMap.put(luaThread, arrayList);
        } else {
            arrayList = arrayList2;
        }
        ArrayList<LuaTable> arrayList3 = arrayList;
        arrayList3.add(envFor);
        try {
            LuaValue call = compile.call();
            if (call.isnil()) {
                throw new LuaError("Module code did not return exactly one value");
            }
            this.moduleCache.put(module, call);
            Intrinsics.checkNotNull(call);
            return call;
        } finally {
            arrayList3.remove(arrayList3.size() - 1);
            if (arrayList3.isEmpty()) {
                this.moduleEnvs.remove(luaThread);
            }
        }
    }

    public final void resume(LuaThread co, Varargs args) {
        Intrinsics.checkNotNullParameter(co, "co");
        Intrinsics.checkNotNullParameter(args, "args");
        if (this.stopped || !Intrinsics.areEqual(co.getStatus(), "suspended")) {
            return;
        }
        long j = this.resumeStart;
        this.resumeStart = System.currentTimeMillis();
        try {
            Varargs resume = co.resume(args);
            if (!resume.arg1().toboolean()) {
                LuaValue arg = resume.arg(2);
                String str = arg.isnil() ? "error" : arg.tojstring();
                Intrinsics.checkNotNull(str);
                reportError(str);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void runCommand(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        try {
            LuaValue compile = compile(code, "CommandBar", getCommandEnv());
            LuaValue NONE = LuaValue.NONE;
            Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            spawn(compile, NONE);
        } catch (LuaError e) {
            OutputLog outputLog = OutputLog.INSTANCE;
            String message = e.getMessage();
            if (message == null) {
                message = "Syntax error";
            }
            outputLog.error(cleanError(message));
        }
    }

    public final void runScript(Instance script, Map<String, ? extends LuaValue> extra) {
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Object obj = script.get("Source");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return;
        }
        try {
            LuaValue compile = compile(str, script.fullName(), envFor(script, extra));
            LuaValue NONE = LuaValue.NONE;
            Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            spawn(compile, NONE);
        } catch (LuaError e) {
            OutputLog outputLog = OutputLog.INSTANCE;
            String message = e.getMessage();
            if (message == null) {
                message = "Syntax error in " + script.fullName();
            }
            outputLog.error(cleanError(message));
        }
    }

    public final void setExtraEnvForModules(Map<String, ? extends LuaValue> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraEnvForModules = map;
    }

    public final void setHook(LuaThread co) {
        Intrinsics.checkNotNullParameter(co, "co");
        try {
            this.sethook.invoke(LuaValue.varargsOf(new LuaValue[]{co, this.hookFn, LuaValue.valueOf(""), LuaValue.valueOf(5000)}));
        } catch (Exception e) {
        }
    }

    public final void setPlay(PlaySession playSession) {
        this.play = playSession;
    }

    public final void setStopped(boolean z) {
        this.stopped = z;
    }

    public final void setTime(double d) {
        this.time = d;
    }

    public final void shutdown() {
        this.stopped = true;
        this.dm.getListeners().remove(this.treeListener);
        this.waiting.clear();
        this.deferred.clear();
        this.childWaits.clear();
        this.conns.clear();
        this.signalWaiters.clear();
        this.tweens.clear();
    }

    public final LuaThread spawn(LuaValue fn, Varargs args) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        Intrinsics.checkNotNullParameter(args, "args");
        LuaThread newThread = newThread(fn);
        resume(newThread, args);
        return newThread;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x023b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void step(double r17) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.LuaRuntime.step(double):void");
    }

    public final LuaValue toLua(Object v, Instance owner, String prop) {
        LuaValue luaValue;
        LuaRuntime luaRuntime = this;
        if (v == null) {
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            return NIL;
        }
        if (v instanceof LuaValue) {
            return (LuaValue) v;
        }
        if (v instanceof String) {
            LuaString valueOf = LuaValue.valueOf((String) v);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf;
        }
        if (v instanceof Boolean) {
            LuaBoolean valueOf2 = LuaValue.valueOf(((Boolean) v).booleanValue());
            Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
            return valueOf2;
        }
        if (v instanceof Integer) {
            LuaInteger valueOf3 = LuaValue.valueOf(((Number) v).intValue());
            Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(...)");
            return valueOf3;
        }
        if (v instanceof Long) {
            LuaNumber valueOf4 = LuaValue.valueOf(((Number) v).longValue());
            Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(...)");
            return valueOf4;
        }
        if (v instanceof Float) {
            LuaNumber valueOf5 = LuaValue.valueOf(((Number) v).floatValue());
            Intrinsics.checkNotNullExpressionValue(valueOf5, "valueOf(...)");
            return valueOf5;
        }
        if (v instanceof Double) {
            LuaNumber valueOf6 = LuaValue.valueOf(((Number) v).doubleValue());
            Intrinsics.checkNotNullExpressionValue(valueOf6, "valueOf(...)");
            return valueOf6;
        }
        if (v instanceof Instance) {
            return luaRuntime.wrap((Instance) v);
        }
        if (v instanceof EnumValue) {
            String typeForProp = (owner == null || prop == null) ? null : Enums.INSTANCE.typeForProp(owner.getClassName(), prop);
            String itemName = Enums.INSTANCE.itemName(typeForProp, ((EnumValue) v).getValue());
            if (typeForProp != null && itemName != null) {
                return LuaTypes.INSTANCE.wrap(new EnumItemV(typeForProp, itemName, ((EnumValue) v).getValue()));
            }
            LuaInteger valueOf7 = LuaValue.valueOf(((EnumValue) v).getValue());
            Intrinsics.checkNotNullExpressionValue(valueOf7, "valueOf(...)");
            return valueOf7;
        }
        if (v instanceof BinaryString) {
            LuaString valueOf8 = LuaValue.valueOf(((BinaryString) v).getBytes());
            Intrinsics.checkNotNullExpressionValue(valueOf8, "valueOf(...)");
            return valueOf8;
        }
        if (v instanceof SharedStr) {
            LuaString valueOf9 = LuaValue.valueOf(((SharedStr) v).getBytes());
            Intrinsics.checkNotNullExpressionValue(valueOf9, "valueOf(...)");
            return valueOf9;
        }
        if (v instanceof OptionalCFrame) {
            CFrame cframe = ((OptionalCFrame) v).getCframe();
            if (cframe == null || (luaValue = LuaTypes.INSTANCE.wrap(cframe)) == null) {
                luaValue = LuaValue.NIL;
            }
            Intrinsics.checkNotNull(luaValue);
            return luaValue;
        }
        if (v instanceof ContentValue) {
            if (((ContentValue) v).getSourceType() == 2) {
                return luaRuntime.wrap(((ContentValue) v).getObj());
            }
            LuaString valueOf10 = LuaValue.valueOf(((ContentValue) v).getUri());
            Intrinsics.checkNotNullExpressionValue(valueOf10, "valueOf(...)");
            return valueOf10;
        }
        if (!(v instanceof RaycastResultV) && (v instanceof List)) {
            LuaTable luaTable = new LuaTable();
            Iterator it = ((Iterable) v).iterator();
            while (it.hasNext()) {
                luaTable.insert(0, toLua$default(luaRuntime, it.next(), null, null, 6, null));
                luaRuntime = this;
            }
            return luaTable;
        }
        return LuaTypes.INSTANCE.wrap(v);
    }

    public final Varargs waitForChild(Instance parent, String name, Double timeout) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(name, "name");
        Instance findFirstChild$default = Instance.findFirstChild$default(parent, name, false, 2, null);
        if (findFirstChild$default != null) {
            return wrap(findFirstChild$default);
        }
        LuaThread currentCoroutine = currentCoroutine();
        if (currentCoroutine == null) {
            throw new LuaError("WaitForChild must be called from a yieldable thread");
        }
        this.childWaits.add(new ChildWait(parent, name, currentCoroutine, timeout == null ? Double.MAX_VALUE : this.time + timeout.doubleValue(), this.time));
        Varargs yield = this.globals.yield(LuaValue.NONE);
        Intrinsics.checkNotNullExpressionValue(yield, "yield(...)");
        return yield;
    }

    public final Varargs waitSignal(Object owner, String name) {
        HashMap<String, ArrayList<LuaThread>> hashMap;
        ArrayList<LuaThread> arrayList;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        LuaThread currentCoroutine = currentCoroutine();
        if (currentCoroutine == null) {
            throw new LuaError("Wait can only be called from a yieldable thread");
        }
        IdentityHashMap<Object, HashMap<String, ArrayList<LuaThread>>> identityHashMap = this.signalWaiters;
        HashMap<String, ArrayList<LuaThread>> hashMap2 = identityHashMap.get(owner);
        if (hashMap2 == null) {
            hashMap = new HashMap<>();
            identityHashMap.put(owner, hashMap);
        } else {
            hashMap = hashMap2;
        }
        HashMap<String, ArrayList<LuaThread>> hashMap3 = hashMap;
        ArrayList<LuaThread> arrayList2 = hashMap3.get(name);
        if (arrayList2 == null) {
            arrayList = new ArrayList<>();
            hashMap3.put(name, arrayList);
        } else {
            arrayList = arrayList2;
        }
        arrayList.add(currentCoroutine);
        Varargs yield = this.globals.yield(LuaValue.NONE);
        Intrinsics.checkNotNullExpressionValue(yield, "yield(...)");
        return yield;
    }

    public final LuaValue wrap(Instance inst) {
        LuaUserdata luaUserdata;
        if (inst == null) {
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            return NIL;
        }
        WeakHashMap<Instance, LuaValue> weakHashMap = this.wrappers;
        LuaValue luaValue = weakHashMap.get(inst);
        if (luaValue == null) {
            luaUserdata = new LuaUserdata(inst, this.instanceMeta);
            weakHashMap.put(inst, luaUserdata);
        } else {
            luaUserdata = luaValue;
        }
        return luaUserdata;
    }

    public final Varargs yieldFor(double seconds) {
        LuaThread currentCoroutine = currentCoroutine();
        if (currentCoroutine == null) {
            throw new LuaError("attempt to yield across a non-yieldable boundary (use task.spawn)");
        }
        this.waiting.add(new Waiting(currentCoroutine, this.time + RangesKt.coerceAtLeast(seconds, 0.0d), this.time));
        Varargs yield = this.globals.yield(LuaValue.NONE);
        Intrinsics.checkNotNullExpressionValue(yield, "yield(...)");
        return yield;
    }
}
