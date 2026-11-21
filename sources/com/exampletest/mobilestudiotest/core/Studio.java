package com.exampletest.mobilestudiotest.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.exampletest.mobilestudiotest.audio.AudioEngine;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.PlaceFactory;
import com.exampletest.mobilestudiotest.core.UndoManager;
import com.exampletest.mobilestudiotest.engine.Geometry;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.engine.RayHit;
import com.exampletest.mobilestudiotest.format.RbxBinaryWriter;
import com.exampletest.mobilestudiotest.format.RbxDocument;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.lua.LuaTypes;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.ClassDb;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Ray;
import com.exampletest.mobilestudiotest.model.TreeListener;
import com.exampletest.mobilestudiotest.model.Vector2;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import com.exampletest.mobilestudiotest.render.FlyCamera;
import com.exampletest.mobilestudiotest.render.ViewState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

/* compiled from: Studio.kt */
@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0002µ\u0001\u0018\u0000 Ù\u00022\u00020\u0001:\u0004Ø\u0002Ù\u0002B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u00102\u0007\u0010\u009f\u0001\u001a\u00020\u0010J\u0012\u0010²\u0001\u001a\u00020\u001d2\u0007\u0010³\u0001\u001a\u00020)H\u0002J\n\u0010·\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010¸\u0001\u001a\u00030\u009d\u0001H\u0002J\b\u0010¹\u0001\u001a\u00030\u009d\u0001J\u0010\u0010º\u0001\u001a\u00020\u001d2\u0007\u0010»\u0001\u001a\u00020fJ\u0007\u0010¼\u0001\u001a\u00020\u0010J\u0007\u0010½\u0001\u001a\u00020\u0010J\b\u0010¾\u0001\u001a\u00030¿\u0001J\u0012\u0010Ì\u0001\u001a\u00020\u001d2\u0007\u0010³\u0001\u001a\u00020)H\u0002J\u000e\u0010Ñ\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u000e\u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u000e\u0010Ó\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u000e\u0010Ô\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u000e\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u000e\u0010Ö\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u000e\u0010×\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\b\u0010Ø\u0001\u001a\u00030\u009d\u0001J\u0011\u0010ã\u0001\u001a\u00030\u009d\u00012\u0007\u0010ä\u0001\u001a\u00020\u0010J\b\u0010ê\u0001\u001a\u00030\u009d\u0001J\u0011\u0010ë\u0001\u001a\u00030\u009d\u00012\u0007\u0010ì\u0001\u001a\u00020)J\b\u0010í\u0001\u001a\u00030\u009d\u0001J\b\u0010î\u0001\u001a\u00030\u009d\u0001J:\u0010ï\u0001\u001a\u00030\u009d\u00012\u0007\u0010ð\u0001\u001a\u00020\u00142\t\u0010ñ\u0001\u001a\u0004\u0018\u00010`2\u0007\u0010ò\u0001\u001a\u00020f2\u0007\u0010ó\u0001\u001a\u00020\u001d2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010oJ\u0014\u0010ô\u0001\u001a\u00030\u009d\u00012\n\b\u0002\u0010õ\u0001\u001a\u00030ö\u0001J\n\u0010÷\u0001\u001a\u00030\u009d\u0001H\u0002J\b\u0010ø\u0001\u001a\u00030ù\u0001J\n\u0010ú\u0001\u001a\u0005\u0018\u00010ù\u0001J\u001a\u0010û\u0001\u001a\u0005\u0018\u00010ù\u00012\u000e\u0010ü\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u001c\u0010ý\u0001\u001a\u00030\u009d\u00012\t\u0010ñ\u0001\u001a\u0004\u0018\u00010`2\u0007\u0010ò\u0001\u001a\u00020fJ\b\u0010þ\u0001\u001a\u00030\u009d\u0001J\u001f\u0010ÿ\u0001\u001a\u00030\u009d\u00012\b\u0010\u0080\u0002\u001a\u00030\u0081\u00022\u000b\b\u0002\u0010\u0082\u0002\u001a\u0004\u0018\u00010)J\u0018\u0010\u0083\u0002\u001a\u00030\u009d\u00012\u000e\u0010ü\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u0011\u0010\u0084\u0002\u001a\u00030\u009d\u00012\u0007\u0010³\u0001\u001a\u00020)J\u0018\u0010\u0085\u0002\u001a\u00030\u009d\u00012\u000e\u0010ü\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\n\u0010\u0086\u0002\u001a\u00030\u009d\u0001H\u0002J\b\u0010\u0087\u0002\u001a\u00030\u009d\u0001J$\u0010\u0088\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u0089\u0002\u001a\u00020)2\u0007\u0010ò\u0001\u001a\u00020f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\u008a\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u0089\u0002\u001a\u00020)2\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010)J\u0012\u0010\u008c\u0002\u001a\u00030\u0098\u00012\b\u0010\u008d\u0002\u001a\u00030\u0098\u0001J\u001a\u0010\u008e\u0002\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0007\u0010\u008f\u0002\u001a\u00020\u0010H\u0002J\u0012\u0010\u0090\u0002\u001a\u00020\u001d2\u0007\u0010\u0091\u0002\u001a\u00020fH\u0002J\u0012\u0010\u0092\u0002\u001a\u00020\u001d2\u0007\u0010\u0089\u0002\u001a\u00020)H\u0002J\u001d\u0010\u0093\u0002\u001a\u00020)2\u0007\u0010\u0091\u0002\u001a\u00020f2\u000b\b\u0002\u0010\u0094\u0002\u001a\u0004\u0018\u00010)J\u0012\u0010\u0095\u0002\u001a\u00030\u009d\u00012\b\u0010\u0096\u0002\u001a\u00030Í\u0001J\u0012\u0010\u0097\u0002\u001a\u00020\u001d2\u0007\u0010³\u0001\u001a\u00020)H\u0002J\b\u0010\u0098\u0002\u001a\u00030\u009d\u0001J\b\u0010\u0099\u0002\u001a\u00030\u009d\u0001J\b\u0010\u009a\u0002\u001a\u00030\u009d\u0001J\b\u0010\u009b\u0002\u001a\u00030\u009d\u0001J\u0013\u0010\u009c\u0002\u001a\u00030\u009d\u00012\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010)J\b\u0010 \u0002\u001a\u00030\u009d\u0001J\b\u0010¡\u0002\u001a\u00030\u009d\u0001J\u000e\u0010¢\u0002\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u0010\u0010£\u0002\u001a\u00030\u009d\u00012\u0006\u0010-\u001a\u00020\u001dJ\b\u0010¤\u0002\u001a\u00030\u009d\u0001J\u0011\u0010¥\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u008f\u0002\u001a\u00020)J\u0011\u0010¦\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u008f\u0002\u001a\u00020)J#\u0010§\u0002\u001a\u00030\u009d\u00012\u0007\u0010¨\u0002\u001a\u00020)2\u0007\u0010©\u0002\u001a\u00020f2\u0007\u0010ª\u0002\u001a\u00020#J\u0007\u0010«\u0002\u001a\u00020\u001dJ\u001a\u0010¬\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u00ad\u0002\u001a\u00020)2\u0007\u0010ª\u0002\u001a\u00020#J\u0011\u0010®\u0002\u001a\u00030\u009d\u00012\u0007\u0010¨\u0002\u001a\u00020{J#\u0010À\u0002\u001a\u00030\u009d\u00012\u0007\u0010Á\u0002\u001a\u00020)2\u0007\u0010ª\u0002\u001a\u00020#2\u0007\u0010Â\u0002\u001a\u00020\u001dJ\u0013\u0010Ã\u0002\u001a\u00030\u009d\u00012\t\u0010Á\u0002\u001a\u0004\u0018\u00010)J\"\u0010Ä\u0002\u001a\u00020\u001d2\u0007\u0010Å\u0002\u001a\u00020f2\u0007\u0010Æ\u0002\u001a\u00020\u00102\u0007\u0010Ç\u0002\u001a\u00020\u0010J\u001b\u0010Ï\u0002\u001a\u0004\u0018\u00010f2\u0007\u0010Ð\u0002\u001a\u00020f2\u0007\u0010Ñ\u0002\u001a\u00020fJ#\u0010Ò\u0002\u001a\u00030\u009d\u00012\u0007\u0010Ð\u0002\u001a\u00020f2\u0007\u0010Ñ\u0002\u001a\u00020f2\u0007\u0010Ó\u0002\u001a\u00020fJ\u0011\u0010Ô\u0002\u001a\u00030\u009d\u00012\u0007\u0010Õ\u0002\u001a\u00020fJ\u0012\u0010Ö\u0002\u001a\u00030\u0081\u00022\b\u0010×\u0002\u001a\u00030ù\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\"\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010$\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R!\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R$\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020.@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u00107R$\u00108\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u00107R$\u0010;\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u00107R\u001a\u0010>\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u00107R\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010I\u001a\u00020J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR$\u0010M\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0012\"\u0004\bO\u0010PR$\u0010Q\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\u0012\"\u0004\bS\u0010PR$\u0010T\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u00107R$\u0010W\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010\u001e\"\u0004\bY\u00107R$\u0010Z\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\u001e\"\u0004\b\\\u00107R\u001e\u0010]\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u001eR\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u001e\"\u0004\bm\u00107R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sRe\u0010t\u001aV\u0012\u0004\u0012\u00020f\u0012 \u0012\u001e\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020f0uj\u000e\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020f`v0uj*\u0012\u0004\u0012\u00020f\u0012 \u0012\u001e\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020f0uj\u000e\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020f`v`v¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0017\u0010y\u001a\b\u0012\u0004\u0012\u00020{0z¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0018\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0z¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010}R\u0015\u0010\u0081\u0001\u001a\u00030\u0082\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0016\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0087\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0012\"\u0005\b\u0089\u0001\u0010PR\u001d\u0010\u008a\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0012\"\u0005\b\u008c\u0001\u0010PR\u001d\u0010\u008d\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u001e\"\u0005\b\u008f\u0001\u00107R\u001d\u0010\u0090\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u001e\"\u0005\b\u0092\u0001\u00107R'\u0010\u0093\u0001\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010\u0012\"\u0005\b\u0095\u0001\u0010PR%\u0010\u0096\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0098\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0097\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0099\u0001\u001a\u00030\u0098\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030¡\u00010z¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010}R/\u0010£\u0001\u001a\u0012\u0012\u0004\u0012\u00020)\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010¤\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R/\u0010©\u0001\u001a\u0012\u0012\u0004\u0012\u00020f\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010¤\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010¦\u0001\"\u0006\b«\u0001\u0010¨\u0001R\u000f\u0010¬\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u00ad\u0001\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020f0±\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010´\u0001\u001a\u00030µ\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¶\u0001R\"\u0010À\u0001\u001a\u0005\u0018\u00010¿\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R\u001f\u0010Å\u0001\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010Æ\u0001\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010Ç\u0001\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010È\u0001\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010É\u0001\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010Ê\u0001\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ë\u0001\u001a\t\u0012\u0004\u0012\u00020f0±\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010Î\u0001\u001a\u00030Í\u00012\u0007\u0010\u0013\u001a\u00030Í\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u001d\u0010Ù\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010\u001e\"\u0005\bÛ\u0001\u00107R#\u0010Ü\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009d\u00010Þ\u00010Ý\u0001¢\u0006\n\n\u0000\u001a\u0006\bß\u0001\u0010à\u0001R\u0010\u0010á\u0001\u001a\u00030â\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010å\u0001\u001a\u0005\u0018\u00010\u0098\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001R\u0013\u0010\u009e\u0002\u001a\u00020\u001d8F¢\u0006\u0007\u001a\u0005\b\u009f\u0002\u0010\u001eR\"\u0010¯\u0002\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0005\u0012\u00030±\u00020°\u0002¢\u0006\n\n\u0000\u001a\u0006\b²\u0002\u0010³\u0002R%\u0010´\u0002\u001a\u0004\u0018\u00010)2\b\u0010\u0013\u001a\u0004\u0018\u00010)@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\bµ\u0002\u0010¶\u0002R \u0010·\u0002\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b¸\u0002\u0010\u001eR\u0011\u0010¹\u0002\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000RQ\u0010º\u0002\u001a4\u0012\u0004\u0012\u00020f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020f0\u0086\u0001\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030Í\u0001\u0012\u0005\u0012\u00030\u009d\u00010¤\u0001\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010»\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¼\u0002\u0010½\u0002\"\u0006\b¾\u0002\u0010¿\u0002R+\u0010È\u0002\u001a\r Ê\u0002*\u0005\u0018\u00010É\u00020É\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÍ\u0002\u0010Î\u0002\u001a\u0006\bË\u0002\u0010Ì\u0002¨\u0006\u0002"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/Studio;", "", "app", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getApp", "()Landroid/content/Context;", "lock", "getLock", "()Ljava/lang/Object;", "main", "Landroid/os/Handler;", "getMain", "()Landroid/os/Handler;", "density", "", "getDensity", "()F", "value", "Lcom/exampletest/mobilestudiotest/model/DataModel;", "editModel", "getEditModel", "()Lcom/exampletest/mobilestudiotest/model/DataModel;", "playModel", "getPlayModel", "model", "getModel", "isPlaying", "", "()Z", "Lcom/exampletest/mobilestudiotest/engine/PlaySession;", "play", "getPlay", "()Lcom/exampletest/mobilestudiotest/engine/PlaySession;", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "editRuntime", "getEditRuntime", "()Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "selection", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lkotlin/collections/ArrayList;", "getSelection", "()Ljava/util/ArrayList;", "v", "Lcom/exampletest/mobilestudiotest/core/Tool;", "tool", "getTool", "()Lcom/exampletest/mobilestudiotest/core/Tool;", "setTool", "(Lcom/exampletest/mobilestudiotest/core/Tool;)V", "multiSelect", "getMultiSelect", "setMultiSelect", "(Z)V", "boxSelect", "getBoxSelect", "setBoxSelect", "selectInsideModels", "getSelectInsideModels", "setSelectInsideModels", "modifierHeld", "getModifierHeld", "setModifierHeld", "camera", "Lcom/exampletest/mobilestudiotest/render/FlyCamera;", "getCamera", "()Lcom/exampletest/mobilestudiotest/render/FlyCamera;", "view", "Lcom/exampletest/mobilestudiotest/render/ViewState;", "getView", "()Lcom/exampletest/mobilestudiotest/render/ViewState;", "undo", "Lcom/exampletest/mobilestudiotest/core/UndoManager;", "getUndo", "()Lcom/exampletest/mobilestudiotest/core/UndoManager;", "moveSnap", "getMoveSnap", "setMoveSnap", "(F)V", "rotSnap", "getRotSnap", "setRotSnap", "snapEnabled", "getSnapEnabled", "setSnapEnabled", "rotSnapEnabled", "getRotSnapEnabled", "setRotSnapEnabled", "collisionsEnabled", "getCollisionsEnabled", "setCollisionsEnabled", "dirty", "getDirty", "fileUri", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "setFileUri", "(Landroid/net/Uri;)V", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "fileIsXml", "getFileIsXml", "setFileIsXml", "cloud", "Lcom/exampletest/mobilestudiotest/net/CloudPlace;", "getCloud", "()Lcom/exampletest/mobilestudiotest/net/CloudPlace;", "setCloud", "(Lcom/exampletest/mobilestudiotest/net/CloudPlace;)V", "dataStores", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getDataStores", "()Ljava/util/HashMap;", "pluginButtons", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/exampletest/mobilestudiotest/core/PluginButton;", "getPluginButtons", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "pluginWidgets", "Lcom/exampletest/mobilestudiotest/core/PluginWidget;", "getPluginWidgets", "plugins", "Lcom/exampletest/mobilestudiotest/core/PluginManager;", "getPlugins", "()Lcom/exampletest/mobilestudiotest/core/PluginManager;", "clipboard", "", "moveX", "getMoveX", "setMoveX", "moveY", "getMoveY", "setMoveY", "flyUp", "getFlyUp", "setFlyUp", "flyDown", "getFlyDown", "setFlyDown", "flySpeed", "getFlySpeed", "setFlySpeed", "editCamSaved", "Lkotlin/Triple;", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "camVel", "pendingYaw", "pendingPitch", "rotateEditCamera", "", "dYaw", "dPitch", "listeners", "Lcom/exampletest/mobilestudiotest/core/Studio$Listener;", "getListeners", "openScriptHandler", "Lkotlin/Function1;", "getOpenScriptHandler", "()Lkotlin/jvm/functions/Function1;", "setOpenScriptHandler", "(Lkotlin/jvm/functions/Function1;)V", "toastHandler", "getToastHandler", "setToastHandler", "partsDirty", "partsCache", "treePosted", "propsPosted", "RENDER_CLASSES", "", "renderRelevant", "i", "treeListener", "com/exampletest/mobilestudiotest/core/Studio$treeListener$1", "Lcom/exampletest/mobilestudiotest/core/Studio$treeListener$1;", "postTree", "postProps", "markDirty", "toast", NotificationCompat.CATEGORY_MESSAGE, "editGuiScale", "guiUnit", "viewportSizeDp", "Lcom/exampletest/mobilestudiotest/model/Vector2;", "lastEditPointer", "getLastEditPointer", "()Lcom/exampletest/mobilestudiotest/model/Vector2;", "setLastEditPointer", "(Lcom/exampletest/mobilestudiotest/model/Vector2;)V", "decalsCache", "constraintsCache", "surfaceGuisCache", "clothingCache", "adornCache", "soundsCache", "ADORNMENTS", "insideOperation", "", "renderListVersion", "getRenderListVersion", "()I", "renderParts", "renderConstraints", "renderDecals", "renderSurfaceGuis", "renderClothing", "renderAdornments", "audibleSounds", "invalidateRenderLists", "shadowsEnabled", "getShadowsEnabled", "setShadowsEnabled", "glJobs", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function0;", "getGlJobs", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "lastJobEnd", "", TypedValues.AttributesType.S_FRAME, "dt0", "playHereAt", "getPlayHereAt", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "setPlayHereAt", "(Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "playHere", "playAs", TypedValues.AttributesType.S_TARGET, "startPlay", "stopPlay", "replaceEditModel", "dm", "uri", "name", "isXml", "newPlace", "template", "Lcom/exampletest/mobilestudiotest/core/PlaceFactory$Template;", "resetCameraFromModel", "serializePlace", "", "serializeSelection", "serializeInstances", "list", "markSaved", "markSavedToCloud", "insertDocument", "doc", "Lcom/exampletest/mobilestudiotest/format/RbxDocument;", "parent", "select", "toggleSelect", "selectFromScript", "fireSelectionChangedLua", "pruneSelection", "setProp", "inst", "reparent", "newParent", "spawnPoint", "size", "snap", "s", "usesAttachments", "cls", "insertLinked", "insertObject", "parentOverride", "insertPart", "shape", "deletable", "deleteSelection", "duplicateSelection", "copySelection", "cutSelection", "paste", "into", "hasClipboard", "getHasClipboard", "groupSelection", "ungroupSelection", "selectedParts", "setAnchored", "focusSelection", "openScript", "requestOpenScript", "addPluginButton", "b", "pluginName", "rt", "notifyPluginButtons", "addPluginWidget", "w", "clickPluginButton", "pluginMice", "Ljava/util/IdentityHashMap;", "Lorg/luaj/vm2/LuaTable;", "getPluginMice", "()Ljava/util/IdentityHashMap;", "activePlugin", "getActivePlugin", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "activePluginExclusive", "getActivePluginExclusive", "activePluginRt", "pluginMenuHandler", "Lkotlin/Function3;", "getPluginMenuHandler", "()Lkotlin/jvm/functions/Function3;", "setPluginMenuHandler", "(Lkotlin/jvm/functions/Function3;)V", "activatePlugin", "p", "exclusiveMouse", "deactivatePlugin", "pluginMouseEvent", NotificationCompat.CATEGORY_EVENT, "xPx", "yPx", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "pluginSetting", "id", "key", "setPluginSetting", "json", "runCommand", "code", "loadDocumentBytes", "bytes", "Listener", "Companion"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Studio {
    public static final String PLAY_AS_TAG = "__MobileStudioPlayAs";
    private final Set<String> ADORNMENTS;
    private final Set<String> RENDER_CLASSES;
    private volatile Instance activePlugin;
    private boolean activePluginExclusive;
    private LuaRuntime activePluginRt;
    private final ArrayList<Instance> adornCache;
    private final Context app;
    private boolean boxSelect;
    private Vector3 camVel;
    private final FlyCamera camera;
    private List<? extends Instance> clipboard;
    private final ArrayList<Instance> clothingCache;
    private CloudPlace cloud;
    private final ArrayList<Instance> constraintsCache;
    private final HashMap<String, HashMap<String, String>> dataStores;
    private final ArrayList<Instance> decalsCache;
    private final float density;
    private boolean dirty;
    private Triple<Vector3, Float, Float> editCamSaved;
    private DataModel editModel;
    private LuaRuntime editRuntime;
    private boolean fileIsXml;
    private String fileName;
    private Uri fileUri;
    private volatile boolean flyDown;
    private volatile boolean flyUp;
    private final ConcurrentLinkedQueue<Function0<Unit>> glJobs;
    private volatile Vector2 lastEditPointer;
    private long lastJobEnd;
    private final CopyOnWriteArrayList<Listener> listeners;
    private final Object lock;
    private final Handler main;
    private volatile boolean modifierHeld;
    private volatile float moveX;
    private volatile float moveY;
    private boolean multiSelect;
    private Function1<? super Instance, Unit> openScriptHandler;
    private final ArrayList<Instance> partsCache;
    private volatile boolean partsDirty;
    private float pendingPitch;
    private float pendingYaw;
    private PlaySession play;
    private volatile Vector3 playHereAt;
    private DataModel playModel;
    private final CopyOnWriteArrayList<PluginButton> pluginButtons;
    private Function3<? super String, ? super List<String>, ? super Function1<? super Integer, Unit>, Unit> pluginMenuHandler;
    private final IdentityHashMap<Instance, LuaTable> pluginMice;
    private final CopyOnWriteArrayList<PluginWidget> pluginWidgets;
    private final PluginManager plugins;

    /* renamed from: prefs$delegate, reason: from kotlin metadata */
    private final Lazy prefs;
    private boolean propsPosted;
    private int renderListVersion;
    private final ArrayList<Instance> selection;
    private volatile boolean shadowsEnabled;
    private final ArrayList<Instance> soundsCache;
    private final ArrayList<Instance> surfaceGuisCache;
    private Function1<? super String, Unit> toastHandler;
    private Tool tool;
    private final Studio$treeListener$1 treeListener;
    private boolean treePosted;
    private final UndoManager undo;
    private final ViewState view;

    /* compiled from: Studio.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/Studio$Listener;", "", "onTreeChanged", "", "onSelectionChanged", "onPropsChanged", "onModelReplaced", "onPlayStateChanged", "onToolChanged", "onPluginsChanged", "onDirtyChanged", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Listener {

        /* compiled from: Studio.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static void onDirtyChanged(Listener listener) {
                Listener.access$onDirtyChanged$jd(listener);
            }

            @Deprecated
            public static void onModelReplaced(Listener listener) {
                Listener.access$onModelReplaced$jd(listener);
            }

            @Deprecated
            public static void onPlayStateChanged(Listener listener) {
                Listener.access$onPlayStateChanged$jd(listener);
            }

            @Deprecated
            public static void onPluginsChanged(Listener listener) {
                Listener.access$onPluginsChanged$jd(listener);
            }

            @Deprecated
            public static void onPropsChanged(Listener listener) {
                Listener.access$onPropsChanged$jd(listener);
            }

            @Deprecated
            public static void onSelectionChanged(Listener listener) {
                Listener.access$onSelectionChanged$jd(listener);
            }

            @Deprecated
            public static void onToolChanged(Listener listener) {
                Listener.access$onToolChanged$jd(listener);
            }

            @Deprecated
            public static void onTreeChanged(Listener listener) {
                Listener.access$onTreeChanged$jd(listener);
            }
        }

        static /* synthetic */ void access$onDirtyChanged$jd(Listener listener) {
            super.onDirtyChanged();
        }

        static /* synthetic */ void access$onModelReplaced$jd(Listener listener) {
            super.onModelReplaced();
        }

        static /* synthetic */ void access$onPlayStateChanged$jd(Listener listener) {
            super.onPlayStateChanged();
        }

        static /* synthetic */ void access$onPluginsChanged$jd(Listener listener) {
            super.onPluginsChanged();
        }

        static /* synthetic */ void access$onPropsChanged$jd(Listener listener) {
            super.onPropsChanged();
        }

        static /* synthetic */ void access$onSelectionChanged$jd(Listener listener) {
            super.onSelectionChanged();
        }

        static /* synthetic */ void access$onToolChanged$jd(Listener listener) {
            super.onToolChanged();
        }

        static /* synthetic */ void access$onTreeChanged$jd(Listener listener) {
            super.onTreeChanged();
        }

        default void onDirtyChanged() {
        }

        default void onModelReplaced() {
        }

        default void onPlayStateChanged() {
        }

        default void onPluginsChanged() {
        }

        default void onPropsChanged() {
        }

        default void onSelectionChanged() {
        }

        default void onToolChanged() {
        }

        default void onTreeChanged() {
        }
    }

    public Studio(Context app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        this.lock = new Object();
        this.main = new Handler(Looper.getMainLooper());
        this.density = this.app.getResources().getDisplayMetrics().density;
        this.editModel = PlaceFactory.newPlace$default(PlaceFactory.INSTANCE, null, 1, null);
        this.selection = new ArrayList<>();
        this.tool = Tool.MOVE;
        this.camera = new FlyCamera();
        this.view = new ViewState();
        this.undo = new UndoManager(this);
        this.fileName = "Place1.rbxl";
        this.dataStores = new HashMap<>();
        this.pluginButtons = new CopyOnWriteArrayList<>();
        this.pluginWidgets = new CopyOnWriteArrayList<>();
        this.plugins = new PluginManager(this);
        this.clipboard = CollectionsKt.emptyList();
        this.camVel = Vector3.INSTANCE.getZERO();
        this.listeners = new CopyOnWriteArrayList<>();
        this.partsDirty = true;
        this.partsCache = new ArrayList<>();
        this.RENDER_CLASSES = SetsKt.setOf((Object[]) new String[]{"Decal", "Texture", "SurfaceGui", "Shirt", "Pants", "ShirtGraphic", "Sound", "SelectionBox", "Highlight", "BoxHandleAdornment", "SelectionSphere", "Handles", "ArcHandles", "RopeConstraint", "RodConstraint", "SpringConstraint"});
        this.treeListener = new Studio$treeListener$1(this);
        this.editModel.getListeners().add(this.treeListener);
        this.editRuntime = new LuaRuntime(this, this.editModel, false);
        resetCameraFromModel();
        this.decalsCache = new ArrayList<>();
        this.constraintsCache = new ArrayList<>();
        this.surfaceGuisCache = new ArrayList<>();
        this.clothingCache = new ArrayList<>();
        this.adornCache = new ArrayList<>();
        this.soundsCache = new ArrayList<>();
        this.ADORNMENTS = SetsKt.setOf((Object[]) new String[]{"SelectionBox", "Highlight", "BoxHandleAdornment", "SelectionSphere", "Handles", "ArcHandles"});
        this.shadowsEnabled = true;
        this.glJobs = new ConcurrentLinkedQueue<>();
        this.pluginMice = new IdentityHashMap<>();
        this.prefs = LazyKt.lazy(new Studio$$ExternalSyntheticLambda7(this));
    }

    public static final /* synthetic */ void access$postProps(Studio studio) {
        studio.postProps();
    }

    public static final /* synthetic */ void access$postTree(Studio studio) {
        studio.postTree();
    }

    public static final /* synthetic */ boolean access$renderRelevant(Studio studio, Instance instance) {
        return studio.renderRelevant(instance);
    }

    public static final /* synthetic */ void access$setPartsDirty$p(Studio studio, boolean z) {
        studio.partsDirty = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void activatePlugin$lambda$104(Studio studio) {
        Iterator<T> it = studio.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onPluginsChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void deactivatePlugin$lambda$106(Studio studio) {
        Iterator<T> it = studio.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onPluginsChanged();
        }
    }

    private final boolean deletable(Instance i) {
        return (i.getIsService() || i.getParent() == null || i == getModel().getWorkspace().get("CurrentCamera")) ? false : true;
    }

    private final void fireSelectionChangedLua() {
        Instance findService = this.editModel.findService("Selection");
        if (findService == null || isPlaying()) {
            return;
        }
        this.editRuntime.fire(findService, "SelectionChanged", new LuaValue[0]);
    }

    private final SharedPreferences getPrefs() {
        return (SharedPreferences) this.prefs.getValue();
    }

    public static /* synthetic */ void insertDocument$default(Studio studio, RbxDocument rbxDocument, Instance instance, int i, Object obj) {
        if ((i & 2) != 0) {
            instance = null;
        }
        studio.insertDocument(rbxDocument, instance);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v6 */
    private final boolean insertLinked(Instance inst) {
        ?? r7;
        Instance create;
        Iterable iterable;
        ArrayList<Instance> arrayList = this.selection;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            Instance instance = (Instance) obj;
            if (instance.isA("BasePart") || Intrinsics.areEqual(instance.getClassName(), "Attachment")) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.size() != 2) {
            return false;
        }
        this.undo.begin("Insert " + inst.getClassName());
        ArrayList<Instance> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        for (Instance instance2 : arrayList4) {
            if (Intrinsics.areEqual(instance2.getClassName(), "Attachment")) {
                iterable = arrayList4;
                create = instance2;
            } else {
                create = InstanceFactory.INSTANCE.create("Attachment");
                iterable = arrayList4;
                create.setName(StringsKt.removeSuffix(inst.getClassName(), (CharSequence) "Constraint") + "Attachment");
                reparent(create, instance2);
            }
            arrayList5.add(create);
            arrayList4 = iterable;
        }
        ArrayList arrayList6 = arrayList5;
        inst.set("Attachment0", arrayList6.get(0), false);
        inst.set("Attachment1", arrayList6.get(1), false);
        float magnitude = insertLinked$world((Instance) arrayList6.get(0)).minus(insertLinked$world((Instance) arrayList6.get(1))).getMagnitude();
        if (Intrinsics.areEqual(inst.getClassName(), "RopeConstraint") || Intrinsics.areEqual(inst.getClassName(), "RodConstraint")) {
            r7 = 0;
            inst.set("Length", Float.valueOf(magnitude), false);
        } else {
            r7 = 0;
        }
        if (Intrinsics.areEqual(inst.getClassName(), "SpringConstraint")) {
            inst.set("FreeLength", Float.valueOf(magnitude), r7);
        }
        Object obj2 = arrayList3.get(r7);
        if (!((Instance) obj2).isA("BasePart")) {
            obj2 = null;
        }
        Instance instance3 = (Instance) obj2;
        if (instance3 == null && (instance3 = ((Instance) arrayList3.get(0)).getParent()) == null) {
            instance3 = getModel().getWorkspace();
        }
        reparent(inst, instance3);
        this.undo.commit();
        this.selection.clear();
        this.selection.add(inst);
        return true;
    }

    private static final Vector3 insertLinked$world(Instance instance) {
        Vector3 zero;
        Instance parent = instance.getParent();
        if (parent != null) {
            if (!parent.isA("BasePart")) {
                parent = null;
            }
            if (parent != null) {
                CFrame cframe = PartData.INSTANCE.cframe(parent);
                Object obj = instance.get("CFrame");
                CFrame cFrame = obj instanceof CFrame ? (CFrame) obj : null;
                if (cFrame == null || (zero = cFrame.getPosition()) == null) {
                    zero = Vector3.INSTANCE.getZERO();
                }
                return cframe.times(zero);
            }
        }
        return Vector3.INSTANCE.getZERO();
    }

    public static /* synthetic */ Instance insertObject$default(Studio studio, String str, Instance instance, int i, Object obj) {
        if ((i & 2) != 0) {
            instance = null;
        }
        return studio.insertObject(str, instance);
    }

    private final boolean insideOperation(Instance i) {
        for (Instance parent = i.getParent(); parent != null && !(parent instanceof DataModel); parent = parent.getParent()) {
            if (parent.isA("PartOperation")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void markDirty$lambda$9(Studio studio) {
        Iterator<T> it = studio.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onDirtyChanged();
        }
    }

    public static /* synthetic */ void newPlace$default(Studio studio, PlaceFactory.Template template, int i, Object obj) {
        if ((i & 1) != 0) {
            template = PlaceFactory.Template.BASEPLATE;
        }
        studio.newPlace(template);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void notifyPluginButtons$lambda$101(Studio studio) {
        Iterator<T> it = studio.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onPluginsChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean playHere$lambda$20$lambda$19(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !Intrinsics.areEqual(it.get("CanCollide"), (Object) false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean pluginMouseEvent$lambda$109$lambda$108(Instance instance, Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!Intrinsics.areEqual(it.get("Locked"), (Object) true)) {
            if (instance == null) {
                return true;
            }
            if (it != instance && !it.isDescendantOf(instance)) {
                return true;
            }
        }
        return false;
    }

    private final void postProps() {
        if (this.propsPosted) {
            return;
        }
        this.propsPosted = true;
        this.main.postDelayed(new Studio$$ExternalSyntheticLambda1(this), 200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void postProps$lambda$7(Studio studio) {
        studio.propsPosted = false;
        Iterator<T> it = studio.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onPropsChanged();
        }
    }

    private final void postTree() {
        if (this.treePosted) {
            return;
        }
        this.treePosted = true;
        this.main.postDelayed(new Studio$$ExternalSyntheticLambda10(this), 120L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void postTree$lambda$5(Studio studio) {
        studio.treePosted = false;
        Iterator<T> it = studio.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onTreeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SharedPreferences prefs_delegate$lambda$110(Studio studio) {
        return studio.app.getSharedPreferences("plugin_settings", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean pruneSelection$lambda$61$lambda$60(Studio studio, Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.root() != studio.getModel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pruneSelection$lambda$63(Studio studio) {
        for (Listener listener : studio.listeners) {
            listener.onSelectionChanged();
            listener.onTreeChanged();
        }
    }

    private final boolean renderRelevant(Instance i) {
        if (i.isA("BasePart") || this.RENDER_CLASSES.contains(i.getClassName()) || i.getIsService()) {
            return true;
        }
        Iterator<Instance> it = i.getChildren().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (renderRelevant(next)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void replaceEditModel$default(Studio studio, DataModel dataModel, Uri uri, String str, boolean z, CloudPlace cloudPlace, int i, Object obj) {
        if ((i & 16) != 0) {
            cloudPlace = null;
        }
        studio.replaceEditModel(dataModel, uri, str, z, cloudPlace);
    }

    private final void resetCameraFromModel() {
        Object obj = this.editModel.getWorkspace().get("CurrentCamera");
        Instance instance = obj instanceof Instance ? (Instance) obj : null;
        Object obj2 = instance != null ? instance.get("CFrame") : null;
        CFrame cFrame = obj2 instanceof CFrame ? (CFrame) obj2 : null;
        if (cFrame != null && cFrame.getPosition().getMagnitude() > 0.01f) {
            this.camera.setFromCFrame(cFrame);
            return;
        }
        this.camera.setPos(new Vector3(0.0f, 20.0f, 40.0f));
        this.camera.setYaw(0.0f);
        this.camera.setPitch(-0.4f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void selectFromScript$lambda$59(Studio studio) {
        Iterator<T> it = studio.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onSelectionChanged();
        }
    }

    private final float snap(float v, float s) {
        return MathKt.roundToInt(v / s) * s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean spawnPoint$lambda$68(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startPlay$lambda$28$lambda$25(PlaySession playSession, Instance snd) {
        String str;
        Intrinsics.checkNotNullParameter(snd, "snd");
        LuaRuntime rt = playSession.getRt();
        LuaValue[] luaValueArr = new LuaValue[1];
        Object obj = snd.get("SoundId");
        if (obj == null || (str = obj.toString()) == null) {
            str = "";
        }
        LuaString valueOf = LuaValue.valueOf(str);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        luaValueArr[0] = valueOf;
        rt.fire(snd, "Loaded", luaValueArr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startPlay$lambda$28$lambda$26(PlaySession playSession, Instance snd) {
        String str;
        Intrinsics.checkNotNullParameter(snd, "snd");
        LuaRuntime rt = playSession.getRt();
        LuaValue[] luaValueArr = new LuaValue[1];
        Object obj = snd.get("SoundId");
        if (obj == null || (str = obj.toString()) == null) {
            str = "";
        }
        LuaString valueOf = LuaValue.valueOf(str);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        luaValueArr[0] = valueOf;
        rt.fire(snd, "Ended", luaValueArr);
        if (Intrinsics.areEqual(snd.getAttributes().get("__oneShot"), (Object) true) || (Intrinsics.areEqual(snd.get("PlayOnRemove"), (Object) true) && snd.getParent() == null)) {
            snd.destroy();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startPlay$lambda$28$lambda$27(Studio studio, PlaySession playSession) {
        if (studio.play == playSession) {
            try {
                playSession.start();
            } catch (Exception e) {
                OutputLog.INSTANCE.error("Playtest failed to start: " + e);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void toast$lambda$10(Studio studio, String str) {
        Function1<? super String, Unit> function1 = studio.toastHandler;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean toggleSelect$lambda$56$lambda$55(Instance instance, Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it == instance;
    }

    private final boolean usesAttachments(String cls) {
        return ClassDb.INSTANCE.isA(cls, "Constraint") || Intrinsics.areEqual(cls, "Beam") || Intrinsics.areEqual(cls, "Trail") || Intrinsics.areEqual(cls, "PathfindingLink");
    }

    public final void activatePlugin(Instance p, LuaRuntime rt, boolean exclusiveMouse) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(rt, "rt");
        Instance instance = this.activePlugin;
        if (instance != null && instance != p) {
            deactivatePlugin(instance);
        }
        this.activePlugin = p;
        this.activePluginRt = rt;
        this.activePluginExclusive = exclusiveMouse;
        this.main.post(new Studio$$ExternalSyntheticLambda16(this));
    }

    public final void addPluginButton(Instance b, String pluginName, LuaRuntime rt) {
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        Intrinsics.checkNotNullParameter(rt, "rt");
        this.pluginButtons.add(new PluginButton(b, pluginName, rt));
        notifyPluginButtons();
    }

    public final void addPluginWidget(Instance w, LuaRuntime rt) {
        Intrinsics.checkNotNullParameter(w, "w");
        Intrinsics.checkNotNullParameter(rt, "rt");
        this.pluginWidgets.add(new PluginWidget(w, rt));
    }

    public final List<Instance> audibleSounds() {
        renderParts();
        return this.soundsCache;
    }

    public final void clickPluginButton(PluginButton b) {
        Intrinsics.checkNotNullParameter(b, "b");
        synchronized (this.lock) {
            if (Intrinsics.areEqual(b.getInst().get("Enabled"), (Object) false)) {
                return;
            }
            b.getRt().fire(b.getInst(), "Click", new LuaValue[0]);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void copySelection() {
        synchronized (this.lock) {
            ArrayList<Instance> arrayList = this.selection;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (deletable((Instance) obj)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add(((Instance) it.next()).cloneTree());
            }
            this.clipboard = arrayList4;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void cutSelection() {
        copySelection();
        deleteSelection();
    }

    public final void deactivatePlugin(Instance p) {
        Instance instance = this.activePlugin;
        if (instance == null) {
            return;
        }
        if (p == null || p == instance) {
            this.activePlugin = null;
            LuaRuntime luaRuntime = this.activePluginRt;
            if (luaRuntime != null) {
                luaRuntime.fire(instance, "Deactivation", new LuaValue[0]);
            }
            this.activePluginRt = null;
            this.main.post(new Studio$$ExternalSyntheticLambda14(this));
        }
    }

    public final void deleteSelection() {
        synchronized (this.lock) {
            this.undo.begin("Delete");
            for (Instance instance : CollectionsKt.toList(this.selection)) {
                if (deletable(instance)) {
                    reparent(instance, null);
                }
            }
            this.undo.commit();
            this.selection.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onSelectionChanged();
        }
    }

    public final void duplicateSelection() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.lock) {
            this.undo.begin("Duplicate");
            for (Instance instance : CollectionsKt.toList(this.selection)) {
                if (deletable(instance)) {
                    Instance cloneTree = instance.cloneTree();
                    reparent(cloneTree, instance.getParent());
                    arrayList.add(cloneTree);
                }
            }
            this.undo.commit();
            if (!arrayList.isEmpty()) {
                this.selection.clear();
                this.selection.addAll(arrayList);
            }
            Unit unit = Unit.INSTANCE;
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onSelectionChanged();
        }
    }

    public final float editGuiScale() {
        float pluginUiScale = Settings.INSTANCE.getPluginUiScale();
        return pluginUiScale > 0.0f ? pluginUiScale : RangesKt.coerceIn((this.view.getHeight() / this.density) / 520.0f, 0.6f, 1.0f);
    }

    public final void focusSelection() {
        synchronized (this.lock) {
            Pair<Vector3, Vector3> boundsOf = Geometry.INSTANCE.boundsOf(selectedParts());
            if (boundsOf == null) {
                return;
            }
            this.camera.focusOn(boundsOf.getFirst().plus(boundsOf.getSecond()).div(2.0f), boundsOf.getSecond().minus(boundsOf.getFirst()).getMagnitude() / 2.0f);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0069, code lost:
    
        if ((r13.pendingPitch == 0.0f) != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void frame(float r14) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.core.Studio.frame(float):void");
    }

    public final Instance getActivePlugin() {
        return this.activePlugin;
    }

    public final boolean getActivePluginExclusive() {
        return this.activePluginExclusive;
    }

    public final Context getApp() {
        return this.app;
    }

    public final boolean getBoxSelect() {
        return this.boxSelect;
    }

    public final FlyCamera getCamera() {
        return this.camera;
    }

    public final CloudPlace getCloud() {
        return this.cloud;
    }

    public final boolean getCollisionsEnabled() {
        return Settings.INSTANCE.getDragCollisions();
    }

    public final HashMap<String, HashMap<String, String>> getDataStores() {
        return this.dataStores;
    }

    public final float getDensity() {
        return this.density;
    }

    public final boolean getDirty() {
        return this.dirty;
    }

    public final DataModel getEditModel() {
        return this.editModel;
    }

    public final LuaRuntime getEditRuntime() {
        return this.editRuntime;
    }

    public final boolean getFileIsXml() {
        return this.fileIsXml;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Uri getFileUri() {
        return this.fileUri;
    }

    public final boolean getFlyDown() {
        return this.flyDown;
    }

    public final float getFlySpeed() {
        return Settings.INSTANCE.getFlySpeed();
    }

    public final boolean getFlyUp() {
        return this.flyUp;
    }

    public final ConcurrentLinkedQueue<Function0<Unit>> getGlJobs() {
        return this.glJobs;
    }

    public final boolean getHasClipboard() {
        return !this.clipboard.isEmpty();
    }

    public final Vector2 getLastEditPointer() {
        return this.lastEditPointer;
    }

    public final CopyOnWriteArrayList<Listener> getListeners() {
        return this.listeners;
    }

    public final Object getLock() {
        return this.lock;
    }

    public final Handler getMain() {
        return this.main;
    }

    public final DataModel getModel() {
        DataModel dataModel = this.playModel;
        return dataModel == null ? this.editModel : dataModel;
    }

    public final boolean getModifierHeld() {
        return this.modifierHeld;
    }

    public final float getMoveSnap() {
        return Settings.INSTANCE.getMoveSnap();
    }

    public final float getMoveX() {
        return this.moveX;
    }

    public final float getMoveY() {
        return this.moveY;
    }

    public final boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final Function1<Instance, Unit> getOpenScriptHandler() {
        return this.openScriptHandler;
    }

    public final PlaySession getPlay() {
        return this.play;
    }

    public final Vector3 getPlayHereAt() {
        return this.playHereAt;
    }

    public final DataModel getPlayModel() {
        return this.playModel;
    }

    public final CopyOnWriteArrayList<PluginButton> getPluginButtons() {
        return this.pluginButtons;
    }

    public final Function3<String, List<String>, Function1<? super Integer, Unit>, Unit> getPluginMenuHandler() {
        return this.pluginMenuHandler;
    }

    public final IdentityHashMap<Instance, LuaTable> getPluginMice() {
        return this.pluginMice;
    }

    public final CopyOnWriteArrayList<PluginWidget> getPluginWidgets() {
        return this.pluginWidgets;
    }

    public final PluginManager getPlugins() {
        return this.plugins;
    }

    public final int getRenderListVersion() {
        return this.renderListVersion;
    }

    public final float getRotSnap() {
        return Settings.INSTANCE.getRotSnap();
    }

    public final boolean getRotSnapEnabled() {
        return Settings.INSTANCE.getRotSnapOn();
    }

    public final boolean getSelectInsideModels() {
        return Settings.INSTANCE.getSelectInsideModels();
    }

    public final ArrayList<Instance> getSelection() {
        return this.selection;
    }

    public final boolean getShadowsEnabled() {
        return this.shadowsEnabled;
    }

    public final boolean getSnapEnabled() {
        return Settings.INSTANCE.getMoveSnapOn();
    }

    public final Function1<String, Unit> getToastHandler() {
        return this.toastHandler;
    }

    public final Tool getTool() {
        return this.tool;
    }

    public final UndoManager getUndo() {
        return this.undo;
    }

    public final ViewState getView() {
        return this.view;
    }

    public final void groupSelection() {
        synchronized (this.lock) {
            ArrayList<Instance> arrayList = this.selection;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (deletable((Instance) obj)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            if (arrayList3.isEmpty()) {
                return;
            }
            Instance parent = ((Instance) CollectionsKt.first((List) arrayList3)).getParent();
            if (parent == null) {
                return;
            }
            this.undo.begin("Group");
            Instance create = InstanceFactory.INSTANCE.create("Model");
            reparent(create, parent);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                reparent((Instance) it.next(), create);
            }
            this.undo.commit();
            this.selection.clear();
            this.selection.add(create);
            Iterator<T> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                ((Listener) it2.next()).onSelectionChanged();
            }
        }
    }

    public final float guiUnit() {
        return this.play != null ? this.density : this.density * editGuiScale();
    }

    public final void insertDocument(RbxDocument doc, Instance parent) {
        boolean z;
        Instance instance;
        Object obj;
        Instance instance2;
        Intrinsics.checkNotNullParameter(doc, "doc");
        ArrayList arrayList = new ArrayList();
        synchronized (this.lock) {
            boolean z2 = false;
            this.undo.begin("Insert model");
            Iterator<Instance> it = doc.getRoots().iterator();
            while (true) {
                boolean z3 = true;
                if (!it.hasNext()) {
                    break;
                }
                Instance next = it.next();
                if (parent == null) {
                    if (Intrinsics.areEqual(next.getClassName(), "MaterialVariant")) {
                        z = z2;
                    } else {
                        if (Intrinsics.areEqual(next.getClassName(), "Folder") && !next.getChildren().isEmpty()) {
                            List descendants$default = Instance.descendants$default(next, null, 1, null);
                            if (!(descendants$default instanceof Collection) || !descendants$default.isEmpty()) {
                                Iterator it2 = descendants$default.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z3 = true;
                                        break;
                                    }
                                    Instance instance3 = (Instance) it2.next();
                                    if (!(Intrinsics.areEqual(instance3.getClassName(), "MaterialVariant") || Intrinsics.areEqual(instance3.getClassName(), "Folder"))) {
                                        z3 = false;
                                        break;
                                    }
                                }
                            }
                            if (z3) {
                                z = z2;
                            }
                        }
                        if (next.isA("LayerCollector") && !Intrinsics.areEqual(next.getClassName(), "BillboardGui") && !Intrinsics.areEqual(next.getClassName(), "SurfaceGui")) {
                            instance = getModel().getService("StarterGui");
                            z = z2;
                        } else if (next.isA("GuiObject")) {
                            Instance service = getModel().getService("StarterGui");
                            Iterator<T> it3 = service.getChildren().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    z = z2;
                                    obj = null;
                                    break;
                                }
                                Object next2 = it3.next();
                                z = z2;
                                if (Intrinsics.areEqual(((Instance) next2).getClassName(), "ScreenGui")) {
                                    obj = next2;
                                    break;
                                }
                                z2 = z;
                            }
                            Instance instance4 = (Instance) obj;
                            if (instance4 == null) {
                                instance2 = InstanceFactory.INSTANCE.create("ScreenGui");
                                reparent(instance2, service);
                            } else {
                                instance2 = instance4;
                            }
                            instance = instance2;
                        } else {
                            z = z2;
                            instance = getModel().getWorkspace();
                        }
                    }
                    instance = getModel().getService("MaterialService");
                } else {
                    z = z2;
                    instance = parent;
                }
                reparent(next, instance);
                arrayList.add(next);
                z2 = z;
            }
            ArrayList<Instance> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            for (Instance instance5 : arrayList2) {
                List plus = CollectionsKt.plus((Collection) CollectionsKt.listOf(instance5), (Iterable) Instance.descendants$default(instance5, null, 1, null));
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : plus) {
                    ArrayList arrayList5 = arrayList2;
                    if (((Instance) obj2).isA("BasePart")) {
                        ArrayList arrayList6 = arrayList4;
                        arrayList6.add(obj2);
                        arrayList4 = arrayList6;
                    }
                    arrayList2 = arrayList5;
                }
                CollectionsKt.addAll(arrayList3, arrayList4);
                arrayList2 = arrayList2;
            }
            ArrayList<Instance> arrayList7 = arrayList3;
            Pair<Vector3, Vector3> boundsOf = Geometry.INSTANCE.boundsOf(arrayList7);
            if (boundsOf != null) {
                Vector3 component1 = boundsOf.component1();
                Vector3 component2 = boundsOf.component2();
                Vector3 minus = spawnPoint(component2.minus(component1)).minus(component1.plus(component2).div(2.0f));
                for (Instance instance6 : arrayList7) {
                    setProp(instance6, "CFrame", PartData.INSTANCE.cframe(instance6).plus(minus));
                }
            }
            this.undo.commit();
            this.selection.clear();
            this.selection.addAll(arrayList);
        }
        Iterator<T> it4 = this.listeners.iterator();
        while (it4.hasNext()) {
            ((Listener) it4.next()).onSelectionChanged();
        }
    }

    public final Instance insertObject(String cls, Instance parentOverride) {
        Instance instance;
        Object obj;
        Instance instance2;
        boolean insertLinked;
        Intrinsics.checkNotNullParameter(cls, "cls");
        Instance create = InstanceFactory.INSTANCE.create(cls);
        if (parentOverride == null && usesAttachments(cls)) {
            synchronized (this.lock) {
                insertLinked = insertLinked(create);
            }
            if (insertLinked) {
                Iterator<T> it = this.listeners.iterator();
                while (it.hasNext()) {
                    ((Listener) it.next()).onSelectionChanged();
                }
                return create;
            }
        }
        synchronized (this.lock) {
            Instance instance3 = (Instance) CollectionsKt.firstOrNull((List) this.selection);
            if (parentOverride != null) {
                instance = parentOverride;
            } else if (create.isA("BasePart") || Intrinsics.areEqual(create.getClassName(), "Model")) {
                instance = getModel().getWorkspace();
            } else if (create.isA("GuiObject")) {
                if (instance3 != null) {
                    instance = instance3.isA("GuiBase2d") ? instance3 : null;
                    if (instance != null) {
                    }
                }
                Instance service = getModel().getService("StarterGui");
                Iterator<T> it2 = service.getChildren().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it2.next();
                    if (Intrinsics.areEqual(((Instance) next).getClassName(), "ScreenGui")) {
                        obj = next;
                        break;
                    }
                }
                Instance instance4 = (Instance) obj;
                if (instance4 == null) {
                    instance2 = InstanceFactory.INSTANCE.create("ScreenGui");
                    reparent(instance2, service);
                } else {
                    instance2 = instance4;
                }
                instance = instance2;
            } else if (Intrinsics.areEqual(create.getClassName(), "ScreenGui")) {
                instance = getModel().getService("StarterGui");
            } else if (Intrinsics.areEqual(create.getClassName(), "MaterialVariant")) {
                if (instance3 != null) {
                    Instance instance5 = Intrinsics.areEqual(instance3.getClassName(), "MaterialService") || instance3.isDescendantOf(getModel().getService("MaterialService")) ? instance3 : null;
                    if (instance5 != null) {
                        instance = instance5;
                    }
                }
                instance = getModel().getService("MaterialService");
            } else {
                instance = instance3 == null ? getModel().getWorkspace() : instance3;
            }
            this.undo.begin("Insert " + cls);
            if (create.isA("BasePart")) {
                create.set("CFrame", CFrame.INSTANCE.at(spawnPoint(PartData.INSTANCE.size(create))), false);
            }
            reparent(create, instance);
            this.undo.commit();
            this.selection.clear();
            this.selection.add(create);
        }
        Iterator<T> it3 = this.listeners.iterator();
        while (it3.hasNext()) {
            ((Listener) it3.next()).onSelectionChanged();
        }
        return create;
    }

    public final void insertPart(int shape) {
        String str;
        switch (shape) {
            case 3:
                str = "WedgePart";
                break;
            case 4:
                str = "CornerWedgePart";
                break;
            default:
                str = "Part";
                break;
        }
        Instance insertObject$default = insertObject$default(this, str, null, 2, null);
        synchronized (this.lock) {
            switch (shape) {
                case 0:
                    Instance.set$default(insertObject$default, "shape", new EnumValue(0), false, 4, null);
                    Instance.set$default(insertObject$default, "size", new Vector3(2.0f, 2.0f, 2.0f), false, 4, null);
                    break;
                case 2:
                    Instance.set$default(insertObject$default, "shape", new EnumValue(2), false, 4, null);
                    Instance.set$default(insertObject$default, "size", new Vector3(2.0f, 2.0f, 2.0f), false, 4, null);
                    break;
            }
            Instance.set$default(insertObject$default, "Anchored", true, false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void invalidateRenderLists() {
        this.partsDirty = true;
    }

    public final boolean isPlaying() {
        return this.playModel != null;
    }

    public final RbxDocument loadDocumentBytes(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return RbxFile.INSTANCE.read(bytes);
    }

    public final void markDirty() {
        if (this.dirty) {
            return;
        }
        this.dirty = true;
        this.main.post(new Studio$$ExternalSyntheticLambda8(this));
    }

    public final void markSaved(Uri uri, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.fileUri = uri;
        this.fileName = name;
        this.fileIsXml = false;
        this.dirty = false;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onDirtyChanged();
        }
    }

    public final void markSavedToCloud() {
        this.dirty = false;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onDirtyChanged();
        }
    }

    public final void newPlace(PlaceFactory.Template template) {
        Intrinsics.checkNotNullParameter(template, "template");
        replaceEditModel$default(this, PlaceFactory.INSTANCE.newPlace(template), null, "Place1.rbxl", false, null, 16, null);
    }

    public final boolean notifyPluginButtons() {
        return this.main.post(new Studio$$ExternalSyntheticLambda6(this));
    }

    public final void openScript(Instance s) {
        Intrinsics.checkNotNullParameter(s, "s");
        Function1<? super Instance, Unit> function1 = this.openScriptHandler;
        if (function1 != null) {
            function1.invoke(s);
        }
    }

    public final void paste(Instance into) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.lock) {
            if (this.clipboard.isEmpty()) {
                return;
            }
            this.undo.begin("Paste");
            Iterator<? extends Instance> it = this.clipboard.iterator();
            while (it.hasNext()) {
                Instance cloneTree = it.next().cloneTree();
                reparent(cloneTree, into == null ? getModel().getWorkspace() : into);
                arrayList.add(cloneTree);
            }
            this.undo.commit();
            this.selection.clear();
            this.selection.addAll(arrayList);
            Iterator<T> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                ((Listener) it2.next()).onSelectionChanged();
            }
        }
    }

    public final void playAs(Instance target) {
        List<? extends Instance> list;
        Intrinsics.checkNotNullParameter(target, "target");
        synchronized (this.lock) {
            if (isPlaying()) {
                return;
            }
            if (target.isA("BasePart")) {
                list = CollectionsKt.listOf(target);
            } else {
                List descendants$default = Instance.descendants$default(target, null, 1, null);
                ArrayList arrayList = new ArrayList();
                for (Object obj : descendants$default) {
                    if (((Instance) obj).isA("BasePart")) {
                        arrayList.add(obj);
                    }
                }
                list = arrayList;
            }
            if (list.isEmpty()) {
                toast(target.getName() + " has no parts to play as");
                return;
            }
            target.getAttributes().put(PLAY_AS_TAG, true);
            Pair<Vector3, Vector3> boundsOf = Geometry.INSTANCE.boundsOf(list);
            if (boundsOf != null) {
                Vector3 component1 = boundsOf.component1();
                Vector3 component2 = boundsOf.component2();
                this.playHereAt = new Vector3((component1.getX() + component2.getX()) / 2.0f, component1.getY(), (component1.getZ() + component2.getZ()) / 2.0f);
                Unit unit = Unit.INSTANCE;
            }
            try {
                startPlay();
                synchronized (this.lock) {
                    target.getAttributes().remove(PLAY_AS_TAG);
                }
            } catch (Throwable th) {
                synchronized (this.lock) {
                    target.getAttributes().remove(PLAY_AS_TAG);
                    throw th;
                }
            }
        }
    }

    public final void playHere() {
        Vector3 plus;
        synchronized (this.lock) {
            Pair<Vector3, Vector3> screenRay = this.view.screenRay(this.view.getWidth() / 2.0f, this.view.getHeight() / 2.0f);
            RayHit raycast = Geometry.INSTANCE.raycast(renderParts(), screenRay.component1(), screenRay.component2(), 2000.0f, new Studio$$ExternalSyntheticLambda15());
            if (raycast == null || (plus = raycast.getPosition()) == null) {
                plus = this.camera.getPos().plus(this.camera.getForward().times(12.0f));
            }
            this.playHereAt = plus;
            Unit unit = Unit.INSTANCE;
        }
        startPlay();
    }

    public final boolean pluginMouseEvent(String event, float xPx, float yPx) {
        Vector3 plus;
        Intrinsics.checkNotNullParameter(event, "event");
        synchronized (this.lock) {
            Instance instance = this.activePlugin;
            if (instance == null) {
                return false;
            }
            LuaRuntime luaRuntime = this.activePluginRt;
            if (luaRuntime == null) {
                return false;
            }
            LuaTable luaTable = this.pluginMice.get(instance);
            if (luaTable == null) {
                return false;
            }
            Pair<Vector3, Vector3> screenRay = this.view.screenRay(xPx, yPx);
            Vector3 component1 = screenRay.component1();
            Vector3 component2 = screenRay.component2();
            LuaValue luaValue = luaTable.get("TargetFilter");
            if (!luaValue.isuserdata()) {
                luaValue = null;
            }
            Object obj = luaValue != null ? luaValue.touserdata() : null;
            RayHit raycast = Geometry.INSTANCE.raycast(renderParts(), component1, component2, 5000.0f, new Studio$$ExternalSyntheticLambda17(obj instanceof Instance ? (Instance) obj : null));
            if (raycast == null || (plus = raycast.getPosition()) == null) {
                plus = component1.plus(component2.times(1000.0f));
            }
            LuaTypes luaTypes = LuaTypes.INSTANCE;
            luaTable.set("Hit", luaTypes.wrap(CFrame.Companion.lookAt$default(CFrame.INSTANCE, component1, plus, null, 4, null).withPosition(plus)));
            luaTable.set("Target", luaRuntime.wrap(raycast != null ? raycast.getPart() : null));
            float guiUnit = guiUnit();
            this.lastEditPointer = new Vector2(xPx / guiUnit, yPx / guiUnit);
            luaTable.set("X", LuaValue.valueOf(xPx / guiUnit));
            luaTable.set("Y", LuaValue.valueOf(yPx / guiUnit));
            luaTable.set("UnitRay", luaTypes.wrap(new Ray(component1, component2)));
            luaTable.set("Origin", luaTypes.wrap(CFrame.Companion.lookAt$default(CFrame.INSTANCE, component1, component1.plus(component2), null, 4, null)));
            luaTable.set("ViewSizeX", LuaValue.valueOf(this.view.getWidth() / guiUnit));
            luaTable.set("ViewSizeY", LuaValue.valueOf(this.view.getHeight() / guiUnit));
            luaRuntime.fire(luaTable, event, new LuaValue[0]);
            return true;
        }
    }

    public final String pluginSetting(String id, String key) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        return getPrefs().getString(id + "/" + key, null);
    }

    public final void pruneSelection() {
        synchronized (this.lock) {
            CollectionsKt.removeAll((List) this.selection, (Function1) new Studio$$ExternalSyntheticLambda3(this));
        }
        this.main.post(new Studio$$ExternalSyntheticLambda4(this));
    }

    public final List<Instance> renderAdornments() {
        renderParts();
        return this.adornCache;
    }

    public final List<Instance> renderClothing() {
        renderParts();
        return this.clothingCache;
    }

    public final List<Instance> renderConstraints() {
        renderParts();
        return this.constraintsCache;
    }

    public final List<Instance> renderDecals() {
        renderParts();
        return this.decalsCache;
    }

    public final List<Instance> renderParts() {
        List<Instance> descendants$default;
        Instance player;
        Instance findFirstChild$default;
        List<Instance> descendants$default2;
        List<Instance> descendants$default3;
        Instance player2;
        Instance findFirstChild$default2;
        List<Instance> descendants$default4;
        List<Instance> descendants$default5;
        Instance player3;
        List<Instance> descendants$default6;
        if (this.partsDirty) {
            this.partsDirty = false;
            this.renderListVersion++;
            this.partsCache.clear();
            this.decalsCache.clear();
            this.constraintsCache.clear();
            this.surfaceGuisCache.clear();
            this.clothingCache.clear();
            this.adornCache.clear();
            this.soundsCache.clear();
            Instance findService = getModel().findService("Workspace");
            if (findService != null && (descendants$default6 = Instance.descendants$default(findService, null, 1, null)) != null) {
                for (Instance instance : descendants$default6) {
                    if (!instance.isA("BasePart")) {
                        if (Intrinsics.areEqual(instance.getClassName(), "Decal") || Intrinsics.areEqual(instance.getClassName(), "Texture")) {
                            Instance parent = instance.getParent();
                            if (parent != null && parent.isA("BasePart")) {
                                this.decalsCache.add(instance);
                            }
                        }
                        if (Intrinsics.areEqual(instance.getClassName(), "SurfaceGui")) {
                            this.surfaceGuisCache.add(instance);
                        } else if (Intrinsics.areEqual(instance.getClassName(), "Shirt") || Intrinsics.areEqual(instance.getClassName(), "Pants") || Intrinsics.areEqual(instance.getClassName(), "ShirtGraphic")) {
                            this.clothingCache.add(instance);
                        } else if (this.ADORNMENTS.contains(instance.getClassName())) {
                            this.adornCache.add(instance);
                        } else if (Intrinsics.areEqual(instance.getClassName(), "Sound")) {
                            this.soundsCache.add(instance);
                        } else if (Intrinsics.areEqual(instance.getClassName(), "RopeConstraint") || Intrinsics.areEqual(instance.getClassName(), "RodConstraint") || Intrinsics.areEqual(instance.getClassName(), "SpringConstraint")) {
                            this.constraintsCache.add(instance);
                        }
                    } else if (!Intrinsics.areEqual(instance.getClassName(), "Terrain") && !insideOperation(instance)) {
                        this.partsCache.add(instance);
                    }
                }
            }
            PlaySession playSession = this.play;
            Instance findFirstChild$default3 = (playSession == null || (player3 = playSession.getPlayer()) == null) ? null : Instance.findFirstChild$default(player3, "PlayerGui", false, 2, null);
            if (findFirstChild$default3 != null && (descendants$default5 = Instance.descendants$default(findFirstChild$default3, null, 1, null)) != null) {
                for (Instance instance2 : descendants$default5) {
                    if (Intrinsics.areEqual(instance2.getClassName(), "SurfaceGui") && (instance2.get("Adornee") instanceof Instance)) {
                        this.surfaceGuisCache.add(instance2);
                    } else if (Intrinsics.areEqual(instance2.getClassName(), "Sound")) {
                        this.soundsCache.add(instance2);
                    } else if (this.ADORNMENTS.contains(instance2.getClassName())) {
                        this.adornCache.add(instance2);
                    }
                }
            }
            PlaySession playSession2 = this.play;
            if (playSession2 != null && (player2 = playSession2.getPlayer()) != null && (findFirstChild$default2 = Instance.findFirstChild$default(player2, "Backpack", false, 2, null)) != null && (descendants$default4 = Instance.descendants$default(findFirstChild$default2, null, 1, null)) != null) {
                for (Instance instance3 : descendants$default4) {
                    if (this.ADORNMENTS.contains(instance3.getClassName())) {
                        this.adornCache.add(instance3);
                    }
                }
            }
            if (this.play != null) {
                Instance findService2 = getModel().findService("SoundService");
                if (findService2 != null && (descendants$default3 = Instance.descendants$default(findService2, null, 1, null)) != null) {
                    for (Instance instance4 : descendants$default3) {
                        if (Intrinsics.areEqual(instance4.getClassName(), "Sound")) {
                            this.soundsCache.add(instance4);
                        }
                    }
                }
                PlaySession playSession3 = this.play;
                if (playSession3 != null && (player = playSession3.getPlayer()) != null && (findFirstChild$default = Instance.findFirstChild$default(player, "PlayerScripts", false, 2, null)) != null && (descendants$default2 = Instance.descendants$default(findFirstChild$default, null, 1, null)) != null) {
                    for (Instance instance5 : descendants$default2) {
                        if (Intrinsics.areEqual(instance5.getClassName(), "Sound")) {
                            this.soundsCache.add(instance5);
                        }
                    }
                }
            }
            Instance findService3 = getModel().findService("CoreGui");
            if (findService3 != null && (descendants$default = Instance.descendants$default(findService3, null, 1, null)) != null) {
                for (Instance instance6 : descendants$default) {
                    if (this.ADORNMENTS.contains(instance6.getClassName())) {
                        this.adornCache.add(instance6);
                    }
                }
            }
        }
        return this.partsCache;
    }

    public final List<Instance> renderSurfaceGuis() {
        renderParts();
        return this.surfaceGuisCache;
    }

    public final void reparent(Instance inst, Instance newParent) {
        ArrayList<Instance> children;
        Intrinsics.checkNotNullParameter(inst, "inst");
        synchronized (this.lock) {
            Instance parent = inst.getParent();
            int i = -1;
            if (parent != null && (children = parent.getChildren()) != null) {
                int i2 = 0;
                Iterator<Instance> it = children.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next() == inst) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            Instance.setParent$default(inst, newParent, 0, 2, null);
            this.undo.record(new UndoManager.Op.Parent(inst, parent, i, newParent));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void replaceEditModel(DataModel dm, Uri uri, String name, boolean isXml, CloudPlace cloud) {
        Intrinsics.checkNotNullParameter(dm, "dm");
        Intrinsics.checkNotNullParameter(name, "name");
        this.cloud = cloud;
        if (isPlaying()) {
            stopPlay();
        }
        synchronized (this.lock) {
            this.editModel.getListeners().remove(this.treeListener);
            this.editRuntime.shutdown();
            this.pluginButtons.clear();
            this.pluginWidgets.clear();
            this.editModel = dm;
            dm.getListeners().add(this.treeListener);
            this.editRuntime = new LuaRuntime(this, dm, false);
            this.selection.clear();
            this.undo.clear();
            this.partsDirty = true;
            this.fileUri = uri;
            this.fileName = name;
            this.fileIsXml = isXml;
            this.dirty = false;
            resetCameraFromModel();
            Unit unit = Unit.INSTANCE;
        }
        for (Listener listener : this.listeners) {
            listener.onModelReplaced();
            listener.onSelectionChanged();
            listener.onDirtyChanged();
            listener.onPluginsChanged();
        }
        this.plugins.loadAll();
    }

    public final void requestOpenScript(Instance s) {
        Intrinsics.checkNotNullParameter(s, "s");
        openScript(s);
    }

    public final void rotateEditCamera(float dYaw, float dPitch) {
        float cameraSensitivity = Settings.INSTANCE.getCameraSensitivity();
        if (!Settings.INSTANCE.getCameraSmoothing()) {
            this.camera.rotate(dYaw * cameraSensitivity, dPitch * cameraSensitivity);
        } else {
            this.pendingYaw += dYaw * cameraSensitivity;
            this.pendingPitch += dPitch * cameraSensitivity;
        }
    }

    public final void runCommand(String code) {
        LuaRuntime luaRuntime;
        Intrinsics.checkNotNullParameter(code, "code");
        OutputLog.INSTANCE.add(OutputLog.Level.INFO, "> " + code);
        synchronized (this.lock) {
            PlaySession playSession = this.play;
            if (playSession == null || (luaRuntime = playSession.getRt()) == null) {
                luaRuntime = this.editRuntime;
            }
            luaRuntime.runCommand(code);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void select(List<? extends Instance> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            this.selection.clear();
            this.selection.addAll(CollectionsKt.distinct(list));
            fireSelectionChangedLua();
            Unit unit = Unit.INSTANCE;
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onSelectionChanged();
        }
    }

    public final void selectFromScript(List<? extends Instance> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.selection.clear();
        this.selection.addAll(CollectionsKt.distinct(list));
        this.main.post(new Studio$$ExternalSyntheticLambda5(this));
    }

    public final List<Instance> selectedParts() {
        ArrayList arrayList = new ArrayList();
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Iterator<Instance> it = this.selection.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Instance instance = next;
            if (instance.isA("BasePart") && newSetFromMap.add(instance)) {
                arrayList.add(instance);
            }
            if (!instance.getIsService() && (instance.isA("Model") || Intrinsics.areEqual(instance.getClassName(), "Folder"))) {
                for (Object obj : Instance.descendants$default(instance, null, 1, null)) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    Instance instance2 = (Instance) obj;
                    if (instance2.isA("BasePart") && newSetFromMap.add(instance2)) {
                        arrayList.add(instance2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0085 A[Catch: all -> 0x00a6, TryCatch #0 {, blocks: (B:5:0x000d, B:6:0x001e, B:8:0x0024, B:10:0x0032, B:12:0x003c, B:18:0x0085, B:23:0x004a, B:24:0x004e, B:26:0x0054, B:28:0x0066, B:40:0x008b, B:46:0x009a), top: B:4:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] serializeInstances(java.util.List<? extends com.exampletest.mobilestudiotest.model.Instance> r22) {
        /*
            r21 = this;
            r1 = r22
            java.lang.String r0 = "list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r2 = r21
            java.lang.Object r3 = r2.lock
            monitor-enter(r3)
            r0 = 0
            r4 = r1
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> La6
            r5 = 0
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La6
            r6.<init>()     // Catch: java.lang.Throwable -> La6
            java.util.Collection r6 = (java.util.Collection) r6     // Catch: java.lang.Throwable -> La6
            r7 = r4
            r8 = 0
            java.util.Iterator r9 = r7.iterator()     // Catch: java.lang.Throwable -> La6
        L1e:
            boolean r10 = r9.hasNext()     // Catch: java.lang.Throwable -> La6
            if (r10 == 0) goto L8b
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> La6
            r11 = r10
            com.exampletest.mobilestudiotest.model.Instance r11 = (com.exampletest.mobilestudiotest.model.Instance) r11     // Catch: java.lang.Throwable -> La6
            r12 = 0
            boolean r13 = r11.getIsService()     // Catch: java.lang.Throwable -> La6
            if (r13 != 0) goto L80
            r13 = r1
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch: java.lang.Throwable -> La6
            r15 = 0
            boolean r14 = r13 instanceof java.util.Collection     // Catch: java.lang.Throwable -> La6
            r16 = 1
            if (r14 == 0) goto L4a
            r14 = r13
            java.util.Collection r14 = (java.util.Collection) r14     // Catch: java.lang.Throwable -> La6
            boolean r14 = r14.isEmpty()     // Catch: java.lang.Throwable -> La6
            if (r14 == 0) goto L4a
            r20 = r0
            r0 = r16
            goto L7b
        L4a:
            java.util.Iterator r14 = r13.iterator()     // Catch: java.lang.Throwable -> La6
        L4e:
            boolean r17 = r14.hasNext()     // Catch: java.lang.Throwable -> La6
            if (r17 == 0) goto L77
            java.lang.Object r17 = r14.next()     // Catch: java.lang.Throwable -> La6
            r18 = r17
            com.exampletest.mobilestudiotest.model.Instance r18 = (com.exampletest.mobilestudiotest.model.Instance) r18     // Catch: java.lang.Throwable -> La6
            r19 = r18
            r18 = 0
            r20 = r0
            r0 = r19
            if (r0 == r11) goto L6f
            boolean r19 = r11.isDescendantOf(r0)     // Catch: java.lang.Throwable -> La6
            if (r19 == 0) goto L6f
            r0 = r16
            goto L70
        L6f:
            r0 = 0
        L70:
            if (r0 == 0) goto L74
            r0 = 0
            goto L7b
        L74:
            r0 = r20
            goto L4e
        L77:
            r20 = r0
            r0 = r16
        L7b:
            if (r0 == 0) goto L82
            r14 = r16
            goto L83
        L80:
            r20 = r0
        L82:
            r14 = 0
        L83:
            if (r14 == 0) goto L88
            r6.add(r10)     // Catch: java.lang.Throwable -> La6
        L88:
            r0 = r20
            goto L1e
        L8b:
            r20 = r0
            r0 = r6
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> La6
            boolean r4 = r0.isEmpty()     // Catch: java.lang.Throwable -> La6
            if (r4 == 0) goto L9a
            r4 = 0
            goto La4
        L9a:
            com.exampletest.mobilestudiotest.format.RbxBinaryWriter r4 = com.exampletest.mobilestudiotest.format.RbxBinaryWriter.INSTANCE     // Catch: java.lang.Throwable -> La6
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()     // Catch: java.lang.Throwable -> La6
            byte[] r4 = r4.write(r0, r5)     // Catch: java.lang.Throwable -> La6
        La4:
            monitor-exit(r3)
            return r4
        La6:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.core.Studio.serializeInstances(java.util.List):byte[]");
    }

    public final byte[] serializePlace() {
        byte[] write;
        synchronized (this.lock) {
            Object obj = this.editModel.getWorkspace().get("CurrentCamera");
            Instance instance = obj instanceof Instance ? (Instance) obj : null;
            if (instance != null) {
                instance.set("CFrame", this.camera.cframe(), false);
            }
            RbxBinaryWriter rbxBinaryWriter = RbxBinaryWriter.INSTANCE;
            ArrayList<Instance> children = this.editModel.getChildren();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : children) {
                if (((Instance) obj2).getArchivable()) {
                    arrayList.add(obj2);
                }
            }
            write = rbxBinaryWriter.write(arrayList, this.editModel.getMeta());
        }
        return write;
    }

    public final byte[] serializeSelection() {
        byte[] serializeInstances;
        synchronized (this.lock) {
            serializeInstances = serializeInstances(CollectionsKt.toList(this.selection));
        }
        return serializeInstances;
    }

    public final void setAnchored(boolean v) {
        synchronized (this.lock) {
            this.undo.begin("Anchor");
            Iterator<Instance> it = selectedParts().iterator();
            while (it.hasNext()) {
                setProp(it.next(), "Anchored", Boolean.valueOf(v));
            }
            this.undo.commit();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setBoxSelect(boolean z) {
        this.boxSelect = z;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onToolChanged();
        }
    }

    public final void setCloud(CloudPlace cloudPlace) {
        this.cloud = cloudPlace;
    }

    public final void setCollisionsEnabled(boolean z) {
        Settings.INSTANCE.setDragCollisions(z);
    }

    public final void setFileIsXml(boolean z) {
        this.fileIsXml = z;
    }

    public final void setFileName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileName = str;
    }

    public final void setFileUri(Uri uri) {
        this.fileUri = uri;
    }

    public final void setFlyDown(boolean z) {
        this.flyDown = z;
    }

    public final void setFlySpeed(float f) {
        Settings.INSTANCE.setFlySpeed(RangesKt.coerceIn(f, 0.05f, 200.0f));
    }

    public final void setFlyUp(boolean z) {
        this.flyUp = z;
    }

    public final void setLastEditPointer(Vector2 vector2) {
        this.lastEditPointer = vector2;
    }

    public final void setModifierHeld(boolean z) {
        this.modifierHeld = z;
    }

    public final void setMoveSnap(float f) {
        Settings.INSTANCE.setMoveSnap(f);
    }

    public final void setMoveX(float f) {
        this.moveX = f;
    }

    public final void setMoveY(float f) {
        this.moveY = f;
    }

    public final void setMultiSelect(boolean z) {
        this.multiSelect = z;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onToolChanged();
        }
    }

    public final void setOpenScriptHandler(Function1<? super Instance, Unit> function1) {
        this.openScriptHandler = function1;
    }

    public final void setPlayHereAt(Vector3 vector3) {
        this.playHereAt = vector3;
    }

    public final void setPluginMenuHandler(Function3<? super String, ? super List<String>, ? super Function1<? super Integer, Unit>, Unit> function3) {
        this.pluginMenuHandler = function3;
    }

    public final void setPluginSetting(String id, String key, String json) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(json, "json");
        getPrefs().edit().putString(id + "/" + key, json).apply();
    }

    public final void setProp(Instance inst, String name, Object value) {
        Instance instance;
        List descendants$default;
        Object obj;
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(name, "name");
        synchronized (this.lock) {
            try {
                boolean containsKey = inst.getProps().containsKey(name);
                Object obj2 = inst.getProps().get(name);
                if (containsKey && Intrinsics.areEqual(obj2, value)) {
                    return;
                }
                Instance.set$default(inst, name, value, false, 4, null);
                try {
                    try {
                        this.undo.record(new UndoManager.Op.Prop(inst, name, obj2, value, containsKey));
                        if ((Intrinsics.areEqual(name, "MaterialVariant") || Intrinsics.areEqual(name, "MaterialVariantSerialized")) && inst.isA("BasePart")) {
                            String obj3 = value != null ? value.toString() : null;
                            if (obj3 == null) {
                                obj3 = "";
                            }
                            if (obj3.length() == 0) {
                                instance = null;
                            } else {
                                Instance findService = getModel().findService("MaterialService");
                                if (findService == null || (descendants$default = Instance.descendants$default(findService, null, 1, null)) == null) {
                                    instance = null;
                                } else {
                                    Iterator it = descendants$default.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            obj = null;
                                            break;
                                        }
                                        obj = it.next();
                                        Instance instance2 = (Instance) obj;
                                        if (Intrinsics.areEqual(instance2.getClassName(), "MaterialVariant") && Intrinsics.areEqual(instance2.getName(), obj3)) {
                                            break;
                                        }
                                    }
                                    instance = (Instance) obj;
                                }
                            }
                            Object obj4 = instance != null ? instance.get("BaseMaterial") : null;
                            EnumValue enumValue = obj4 instanceof EnumValue ? (EnumValue) obj4 : null;
                            Integer valueOf = enumValue != null ? Integer.valueOf(enumValue.getValue()) : null;
                            if (valueOf != null && PartData.INSTANCE.material(inst) != valueOf.intValue()) {
                                setProp(inst, "Material", new EnumValue(valueOf.intValue()));
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public final void setRotSnap(float f) {
        Settings.INSTANCE.setRotSnap(f);
    }

    public final void setRotSnapEnabled(boolean z) {
        Settings.INSTANCE.setRotSnapOn(z);
    }

    public final void setSelectInsideModels(boolean z) {
        Settings.INSTANCE.setSelectInsideModels(z);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onToolChanged();
        }
    }

    public final void setShadowsEnabled(boolean z) {
        this.shadowsEnabled = z;
    }

    public final void setSnapEnabled(boolean z) {
        Settings.INSTANCE.setMoveSnapOn(z);
    }

    public final void setToastHandler(Function1<? super String, Unit> function1) {
        this.toastHandler = function1;
    }

    public final void setTool(Tool v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.tool = v;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onToolChanged();
        }
    }

    public final Vector3 spawnPoint(Vector3 size) {
        Intrinsics.checkNotNullParameter(size, "size");
        Pair<Vector3, Vector3> screenRay = this.view.screenRay(this.view.getWidth() / 2.0f, this.view.getHeight() / 2.0f);
        RayHit raycast = Geometry.INSTANCE.raycast(renderParts(), screenRay.component1(), screenRay.component2(), 600.0f, new Studio$$ExternalSyntheticLambda9());
        Vector3 plus = raycast != null ? raycast.getPosition().plus(new Vector3(0.0f, size.getY() / 2.0f, 0.0f)) : this.camera.getPos().plus(this.camera.getForward().times(20.0f));
        return (!getSnapEnabled() || getMoveSnap() <= 0.0f) ? plus : new Vector3(snap(plus.getX(), getMoveSnap()), plus.getY(), snap(plus.getZ(), getMoveSnap()));
    }

    public final void startPlay() {
        synchronized (this.lock) {
            if (isPlaying()) {
                return;
            }
            this.undo.commit();
            this.selection.clear();
            this.editCamSaved = new Triple<>(this.camera.getPos(), Float.valueOf(this.camera.getYaw()), Float.valueOf(this.camera.getPitch()));
            DataModel cloneModel = this.editModel.cloneModel();
            this.playModel = cloneModel;
            cloneModel.getListeners().add(this.treeListener);
            this.partsDirty = true;
            this.moveX = 0.0f;
            this.moveY = 0.0f;
            PlaySession playSession = new PlaySession(this, cloneModel);
            this.play = playSession;
            AudioEngine audioEngine = AudioEngine.INSTANCE;
            audioEngine.setOnLoaded(new Studio$$ExternalSyntheticLambda11(playSession));
            audioEngine.setOnEnded(new Studio$$ExternalSyntheticLambda12(playSession));
            this.glJobs.add(new Studio$$ExternalSyntheticLambda13(this, playSession));
            for (Listener listener : this.listeners) {
                listener.onSelectionChanged();
                listener.onModelReplaced();
                listener.onPlayStateChanged();
            }
        }
    }

    public final void stopPlay() {
        CopyOnWriteArrayList<TreeListener> listeners;
        synchronized (this.lock) {
            PlaySession playSession = this.play;
            if (playSession == null) {
                return;
            }
            playSession.stop();
            AudioEngine.INSTANCE.stopAll();
            DataModel dataModel = this.playModel;
            if (dataModel != null && (listeners = dataModel.getListeners()) != null) {
                listeners.remove(this.treeListener);
            }
            this.playModel = null;
            this.play = null;
            this.selection.clear();
            this.partsDirty = true;
            Triple<Vector3, Float, Float> triple = this.editCamSaved;
            if (triple != null) {
                Vector3 component1 = triple.component1();
                float floatValue = triple.component2().floatValue();
                float floatValue2 = triple.component3().floatValue();
                this.camera.setPos(component1);
                this.camera.setYaw(floatValue);
                this.camera.setPitch(floatValue2);
            }
            this.camera.setFov(70.0f);
            this.moveX = 0.0f;
            this.moveY = 0.0f;
            Unit unit = Unit.INSTANCE;
            for (Listener listener : this.listeners) {
                listener.onSelectionChanged();
                listener.onModelReplaced();
                listener.onPlayStateChanged();
            }
        }
    }

    public final boolean toast(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return this.main.post(new Studio$$ExternalSyntheticLambda2(this, msg));
    }

    public final void toggleSelect(Instance i) {
        Intrinsics.checkNotNullParameter(i, "i");
        synchronized (this.lock) {
            ArrayList<Instance> arrayList = this.selection;
            boolean z = false;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator<T> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((Instance) it.next()) == i) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                CollectionsKt.removeAll((List) this.selection, (Function1) new Studio$$ExternalSyntheticLambda0(i));
            } else {
                this.selection.add(i);
            }
            fireSelectionChangedLua();
            Unit unit = Unit.INSTANCE;
        }
        Iterator<T> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            ((Listener) it2.next()).onSelectionChanged();
        }
    }

    public final void ungroupSelection() {
        synchronized (this.lock) {
            ArrayList<Instance> arrayList = this.selection;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                Instance instance = (Instance) obj;
                if ((Intrinsics.areEqual(instance.getClassName(), "Model") || Intrinsics.areEqual(instance.getClassName(), "Folder")) && deletable(instance)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList<Instance> arrayList3 = arrayList2;
            if (arrayList3.isEmpty()) {
                return;
            }
            this.undo.begin("Ungroup");
            ArrayList arrayList4 = new ArrayList();
            for (Instance instance2 : arrayList3) {
                Instance parent = instance2.getParent();
                for (Instance instance3 : CollectionsKt.toList(instance2.getChildren())) {
                    reparent(instance3, parent);
                    arrayList4.add(instance3);
                }
                reparent(instance2, null);
            }
            this.undo.commit();
            this.selection.clear();
            this.selection.addAll(arrayList4);
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onSelectionChanged();
            }
        }
    }

    public final Vector2 viewportSizeDp() {
        float guiUnit = guiUnit();
        return new Vector2(this.view.getWidth() / guiUnit, this.view.getHeight() / guiUnit);
    }
}
