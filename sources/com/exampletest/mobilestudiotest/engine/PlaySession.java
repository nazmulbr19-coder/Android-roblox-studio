package com.exampletest.mobilestudiotest.engine;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.Settings;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.engine.AnimPlayer;
import com.exampletest.mobilestudiotest.engine.Avatar;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.lua.EnumItemV;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.lua.LuaTypes;
import com.exampletest.mobilestudiotest.lua.LuaTypesKt;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.DataTypesKt;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Enums;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.exampletest.mobilestudiotest.model.NumberRange;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Ray;
import com.exampletest.mobilestudiotest.model.TreeListener;
import com.exampletest.mobilestudiotest.model.Vector2;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.render.FlyCamera;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* compiled from: PlaySession.kt */
@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0019\n\u0002\u0010\u0014\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\bA\n\u0002\u0018\u0002\n\u0002\b1\u0018\u0000 \u0099\u00032\u00020\u0001:\u0014\u0094\u0003\u0095\u0003\u0096\u0003\u0097\u0003\u0098\u0003\u0099\u0003\u009a\u0003\u009b\u0003\u009c\u0003\u009d\u0003B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001J\u0013\u0010\u009d\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u001fH\u0002J\n\u0010\u009f\u0001\u001a\u00030\u009b\u0001H\u0002J\u0013\u0010 \u0001\u001a\u00030\u009b\u00012\u0007\u0010¡\u0001\u001a\u00020\u0011H\u0002J\n\u0010¢\u0001\u001a\u00030\u009b\u0001H\u0002J\u0012\u0010£\u0001\u001a\u00020\u001f2\u0007\u0010¤\u0001\u001a\u00020\u0011H\u0002J\u0011\u0010¥\u0001\u001a\u00030\u009b\u00012\u0007\u0010¤\u0001\u001a\u00020\u0011J\u001a\u0010¦\u0001\u001a\u00030\u009b\u00012\u0007\u0010§\u0001\u001a\u00020\u00112\u0007\u0010¨\u0001\u001a\u00020\u0011J\u001a\u0010©\u0001\u001a\u00030\u009b\u00012\u0007\u0010§\u0001\u001a\u00020\u00112\u0007\u0010¨\u0001\u001a\u00020\u0011J\u0012\u0010ª\u0001\u001a\u00020\u001f2\u0007\u0010«\u0001\u001a\u00020\u0011H\u0002J\u0014\u0010¬\u0001\u001a\u00020\u001f2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010\u00ad\u0001\u001a\u00030\u009b\u00012\u0007\u0010§\u0001\u001a\u00020\u00112\u0007\u0010¨\u0001\u001a\u00020\u0011H\u0016J\u001c\u0010®\u0001\u001a\u00030\u009b\u00012\u0007\u0010§\u0001\u001a\u00020\u00112\u0007\u0010¨\u0001\u001a\u00020\u0011H\u0016J\u001c\u0010¯\u0001\u001a\u00030\u009b\u00012\u0007\u0010°\u0001\u001a\u00020\u00112\u0007\u0010±\u0001\u001a\u00020WH\u0016J\n\u0010¹\u0001\u001a\u00030\u009b\u0001H\u0002J\b\u0010º\u0001\u001a\u00030\u009b\u0001J\u0007\u0010¾\u0001\u001a\u00020oJ\u0015\u0010¿\u0001\u001a\u00020\u001f2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001H\u0002J\u0014\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030Ã\u0001H\u0002J\u0014\u0010Ä\u0001\u001a\u00030\u009b\u00012\b\u0010Å\u0001\u001a\u00030Æ\u0001H\u0002J\u001e\u0010Ç\u0001\u001a\u00030\u009b\u00012\u0007\u0010È\u0001\u001a\u00020\u00112\t\b\u0002\u0010É\u0001\u001a\u00020\u001fH\u0002J\u001c\u0010Ê\u0001\u001a\u00030\u009b\u00012\u0007\u0010Ë\u0001\u001a\u00020\u00112\u0007\u0010Ì\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010Í\u0001\u001a\u00020\u00112\u0007\u0010±\u0001\u001a\u00020WH\u0002J\b\u0010Î\u0001\u001a\u00030\u009b\u0001J\b\u0010Ï\u0001\u001a\u00030\u009b\u0001J\u0011\u0010Ð\u0001\u001a\u00030\u009b\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u001fJ\t\u0010Ò\u0001\u001a\u00020!H\u0002J-\u0010â\u0001\u001a\u00020!2\u0007\u0010ã\u0001\u001a\u00020!2\u0007\u0010ä\u0001\u001a\u00020!2\u0007\u0010å\u0001\u001a\u00020!2\u0007\u0010æ\u0001\u001a\u00020!H\u0002J.\u0010ç\u0001\u001a\u00030\u009b\u00012\u0007\u0010±\u0001\u001a\u00020W2\u0007\u0010è\u0001\u001a\u00020!2\u0007\u0010é\u0001\u001a\u00020!2\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\t\u0010ê\u0001\u001a\u00020WH\u0002J\u001c\u0010ë\u0001\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!2\u0007\u0010ê\u0001\u001a\u00020WH\u0002JD\u0010ì\u0001\u001a\u00030\u009b\u00012\u0007\u0010±\u0001\u001a\u00020W2\u0007\u0010í\u0001\u001a\u00020!2\t\b\u0002\u0010î\u0001\u001a\u00020!2\t\b\u0002\u0010ï\u0001\u001a\u00020!2\u0007\u0010å\u0001\u001a\u00020!2\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\u001c\u0010ð\u0001\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!2\u0007\u0010ê\u0001\u001a\u00020WH\u0002J\u0013\u0010ñ\u0001\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\u0014\u0010ù\u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010ú\u0001\u001a\u00020\u0011H\u0002J+\u0010û\u0001\u001a\t\u0018\u00010õ\u0001R\u00020\u00002\u0007\u0010ú\u0001\u001a\u00020\u00112\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010ý\u0001\u001a\u00020fJ1\u0010þ\u0001\u001a\u00030\u009b\u00012\f\u0010ÿ\u0001\u001a\u00070õ\u0001R\u00020\u00002\u0007\u0010\u0080\u0002\u001a\u00020!2\u0007\u0010\u0081\u0002\u001a\u00020!2\u0007\u0010\u0082\u0002\u001a\u00020!J\u001f\u0010\u0083\u0002\u001a\u00030\u009b\u00012\f\u0010ÿ\u0001\u001a\u00070õ\u0001R\u00020\u00002\u0007\u0010\u0080\u0002\u001a\u00020!Ji\u0010\u0084\u0002\u001a\u00030\u009b\u00012\f\u0010ÿ\u0001\u001a\u00070õ\u0001R\u00020\u00002\u000b\b\u0002\u0010\u0082\u0002\u001a\u0004\u0018\u00010!2\u000b\b\u0002\u0010\u0081\u0002\u001a\u0004\u0018\u00010!2\u000b\b\u0002\u0010\u0080\u0002\u001a\u0004\u0018\u00010!2\u000b\b\u0002\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u001f2\u000b\b\u0002\u0010\u0086\u0002\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010!¢\u0006\u0003\u0010\u0087\u0002J\u0017\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020f0\u0089\u00022\u0007\u0010ú\u0001\u001a\u00020\u0011J\u0018\u0010\u008a\u0002\u001a\u00030\u009b\u00012\f\u0010ÿ\u0001\u001a\u00070õ\u0001R\u00020\u0000H\u0002J\u0013\u0010\u008b\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\u001d\u0010\u008e\u0002\u001a\u00030\u009b\u00012\u0007\u0010\u008f\u0002\u001a\u00020\u00112\b\u0010\u0090\u0002\u001a\u00030÷\u0001H\u0002J)\u0010\u0091\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008d\u00020\u0089\u0002\u0018\u00010³\u00012\u0007\u0010\u008f\u0002\u001a\u00020\u0011H\u0002J\u0013\u0010\u0092\u0002\u001a\u00020$2\b\u0010\u0093\u0002\u001a\u00030´\u0001H\u0002J\u0013\u0010\u0094\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\n\u0010\u0097\u0002\u001a\u00030\u009b\u0001H\u0002J\u0013\u0010\u0098\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\t\u0010\u0099\u0002\u001a\u00020\u001cH\u0002J\u0013\u0010\u009a\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u009b\u00020\u0089\u0002H\u0002J%\u0010\u009c\u0002\u001a\u00020\u001f2\u0011\u0010\u009d\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u009b\u00020\u0089\u00022\u0007\u0010\u009e\u0002\u001a\u00020\u001fH\u0002J\u001b\u0010\u009f\u0002\u001a\u00030\u009b\u00012\u0007\u0010±\u0001\u001a\u00020W2\u0006\u0010J\u001a\u00020oH\u0002J\u0013\u0010 \u0002\u001a\u00030\u009b\u00012\u0007\u0010¡\u0002\u001a\u00020\u001fH\u0002J\u0013\u0010¢\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\u0013\u0010£\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\t\u0010¤\u0002\u001a\u00020!H\u0002J\u0016\u0010¥\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0³\u0001H\u0002J\n\u0010¦\u0002\u001a\u00030\u009b\u0001H\u0002J\u0012\u0010§\u0002\u001a\u00020\u001f2\u0007\u0010\u0090\u0002\u001a\u00020\u0011H\u0002J\u0010\u0010¨\u0002\u001a\u00020\u001f2\u0007\u0010\u0090\u0002\u001a\u00020\u0011J%\u0010©\u0002\u001a\u00030\u008a\u00012\u0007\u0010í\u0001\u001a\u00020o2\u0007\u0010î\u0001\u001a\u00020o2\u0007\u0010ï\u0001\u001a\u00020oH\u0002J\u001c\u0010ª\u0002\u001a\u00030«\u00022\u0007\u0010¬\u0002\u001a\u00020\u001c2\u0007\u0010\u00ad\u0002\u001a\u00020\u001cH\u0002J\u0013\u0010®\u0002\u001a\u00030\u009b\u00012\u0007\u0010\u0090\u0002\u001a\u00020\u0011H\u0002J\u0013\u0010¯\u0002\u001a\u00030\u009b\u00012\u0007\u0010\u0090\u0002\u001a\u00020\u0011H\u0002J\u0013\u0010°\u0002\u001a\u00030\u009b\u00012\u0007\u0010\u0090\u0002\u001a\u00020\u0011H\u0002J-\u0010±\u0002\u001a\t\u0012\u0004\u0012\u00020\u00110\u0089\u00022\u0007\u0010¬\u0002\u001a\u00020\u001c2\u0007\u0010\u00ad\u0002\u001a\u00020\u001c2\t\b\u0002\u0010²\u0002\u001a\u00020\u001fH\u0002J\n\u0010³\u0002\u001a\u00030\u009b\u0001H\u0002J\u0013\u0010´\u0002\u001a\u00030à\u00012\u0007\u0010µ\u0002\u001a\u00020oH\u0002J\u0014\u0010¶\u0002\u001a\u00030\u009b\u00012\b\u0010\u00ad\u0002\u001a\u00030\u0082\u0001H\u0002J\u0016\u0010·\u0002\u001a\u0004\u0018\u00010\u00112\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010¸\u0002\u001a\u0004\u0018\u00010\u001c2\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010¹\u0002\u001a\u0004\u0018\u00010$2\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010º\u0002\u001a\u00020!2\u0007\u0010«\u0001\u001a\u00020\u00112\u0007\u0010»\u0002\u001a\u00020W2\u0007\u0010¼\u0002\u001a\u00020!H\u0002J\u001b\u0010½\u0002\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u00112\u0007\u0010»\u0002\u001a\u00020WH\u0002J\u0013\u0010¾\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J?\u0010¿\u0002\u001a\u00020\u001c2\u0007\u0010À\u0002\u001a\u00020\u001c2\u0007\u0010Á\u0002\u001a\u00020\u001c2\u0007\u0010Â\u0002\u001a\u00020\u001c2\u0007\u0010Ã\u0002\u001a\u00020\u001c2\u0007\u0010Ä\u0002\u001a\u00020!2\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\n\u0010Å\u0002\u001a\u00030\u009b\u0001H\u0002J\u0013\u0010Æ\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\u001c\u0010Ç\u0002\u001a\u00030\u009b\u00012\u0007\u0010¬\u0002\u001a\u00020\u00112\u0007\u0010\u00ad\u0002\u001a\u00020\u0011H\u0002J\u001c\u0010È\u0002\u001a\u00030\u009b\u00012\u0007\u0010¬\u0002\u001a\u00020\u00112\u0007\u0010\u00ad\u0002\u001a\u00020\u0011H\u0002J\u0017\u0010É\u0002\u001a\t\u0012\u0004\u0012\u00020\u00110\u0089\u00022\u0007\u0010\u0090\u0002\u001a\u00020\u0011J\n\u0010Ê\u0002\u001a\u00030\u009b\u0001H\u0002J\u0011\u0010Î\u0002\u001a\u00030\u009b\u00012\u0007\u0010Ï\u0002\u001a\u00020!J\u0016\u0010Ð\u0002\u001a\u000f\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0³\u0001H\u0002J\u0012\u0010Ñ\u0002\u001a\u00020!2\u0007\u0010¬\u0002\u001a\u00020!H\u0002J\u0013\u0010Ò\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\n\u0010Ó\u0002\u001a\u00030\u009b\u0001H\u0002J\b\u0010Ô\u0002\u001a\u00030\u009b\u0001J\u001a\u0010Õ\u0002\u001a\u00030\u009b\u00012\u0007\u0010Ö\u0002\u001a\u00020!2\u0007\u0010×\u0002\u001a\u00020!J\u0011\u0010Ø\u0002\u001a\u00030\u009b\u00012\u0007\u0010Ù\u0002\u001a\u00020!J\b\u0010Ü\u0002\u001a\u00030\u009b\u0001J\u001e\u0010Ý\u0002\u001a\u0005\u0018\u00010\u009b\u00022\u0007\u0010Þ\u0002\u001a\u00020!2\u0007\u0010ß\u0002\u001a\u00020!H\u0002J8\u0010à\u0002\u001a\u00020f2\u0007\u0010Þ\u0002\u001a\u00020!2\u0007\u0010ß\u0002\u001a\u00020!2\u0007\u0010á\u0002\u001a\u00020W2\u0007\u0010â\u0002\u001a\u00020o2\t\b\u0002\u0010ã\u0002\u001a\u00020PH\u0002J\u001a\u0010ç\u0002\u001a\u00030\u009b\u00012\u0007\u0010Þ\u0002\u001a\u00020!2\u0007\u0010ß\u0002\u001a\u00020!J\u001a\u0010è\u0002\u001a\u00030\u009b\u00012\u0007\u0010Þ\u0002\u001a\u00020!2\u0007\u0010ß\u0002\u001a\u00020!J\u001a\u0010é\u0002\u001a\u00030\u009b\u00012\u0007\u0010Þ\u0002\u001a\u00020!2\u0007\u0010ß\u0002\u001a\u00020!J\u001a\u0010ê\u0002\u001a\u00030\u009b\u00012\u0007\u0010Þ\u0002\u001a\u00020!2\u0007\u0010ß\u0002\u001a\u00020!J\b\u0010ë\u0002\u001a\u00030\u009b\u0001J\b\u0010ì\u0002\u001a\u00030í\u0002J\u0010\u0010î\u0002\u001a\u00020o2\u0007\u0010±\u0001\u001a\u00020WJ\u0013\u0010ï\u0002\u001a\u00030\u009b\u00012\u0007\u0010ð\u0002\u001a\u00020hH\u0002J\u001c\u0010ñ\u0002\u001a\u00030\u009b\u00012\u0007\u0010ò\u0002\u001a\u00020W2\t\b\u0002\u0010ó\u0002\u001a\u00020oJ\u0011\u0010ô\u0002\u001a\u00030\u009b\u00012\u0007\u0010õ\u0002\u001a\u00020WJ\u001a\u0010ö\u0002\u001a\u00030\u009b\u00012\u0007\u0010÷\u0002\u001a\u00020\u00112\u0007\u0010ò\u0002\u001a\u00020WJ\u0013\u0010ø\u0002\u001a\u00030\u009b\u00012\u0007\u0010æ\u0001\u001a\u00020!H\u0002J\u001b\u0010ù\u0002\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020W0³\u00010\u0089\u0002J\u000e\u0010ú\u0002\u001a\t\u0012\u0004\u0012\u00020\u00110\u0089\u0002J\u0011\u0010û\u0002\u001a\u00030\u009b\u00012\u0007\u0010ü\u0002\u001a\u00020\u0011J\b\u0010ý\u0002\u001a\u00030\u009b\u0001J\u0011\u0010þ\u0002\u001a\u00030\u009b\u00012\u0007\u0010ÿ\u0002\u001a\u00020\u0011J$\u0010\u0080\u0003\u001a\u00030\u009b\u00012\u0007\u0010±\u0001\u001a\u00020W2\b\u0010\u0081\u0003\u001a\u00030í\u00022\u0007\u0010\u0082\u0003\u001a\u00020\u001fJ\u0011\u0010\u0083\u0003\u001a\u00030\u009b\u00012\u0007\u0010±\u0001\u001a\u00020WJ\b\u0010\u0084\u0003\u001a\u00030\u009b\u0001J\u001a\u0010\u0085\u0003\u001a\u00030\u009b\u00012\u0007\u0010±\u0001\u001a\u00020W2\u0007\u0010\u0086\u0003\u001a\u00020WJ\u001a\u0010\u0087\u0003\u001a\u00030\u009b\u00012\u0007\u0010±\u0001\u001a\u00020W2\u0007\u0010\u0088\u0003\u001a\u00020\u001fJ\u0012\u0010\u0089\u0003\u001a\u0004\u0018\u00010\u001c2\u0007\u0010\u0090\u0002\u001a\u00020\u0011J\u001a\u0010\u008a\u0003\u001a\u00030\u009b\u00012\u0007\u0010\u0090\u0002\u001a\u00020\u00112\u0007\u0010À\u0002\u001a\u00020\u001cJ\u0010\u0010\u008b\u0003\u001a\u00020\u001c2\u0007\u0010\u008c\u0003\u001a\u00020\u0011J\u0010\u0010\u008d\u0003\u001a\u00020\u001f2\u0007\u0010\u008c\u0003\u001a\u00020\u0011J\u0011\u0010¡\u0002\u001a\u00030\u009b\u00012\u0007\u0010\u008c\u0003\u001a\u00020\u0011J\u001a\u0010\u008e\u0003\u001a\u00030\u009b\u00012\u0007\u0010\u008c\u0003\u001a\u00020\u00112\u0007\u0010ä\u0001\u001a\u00020\u001cJ\u001a\u0010\u008f\u0003\u001a\u00030\u009b\u00012\u0007\u0010\u008c\u0003\u001a\u00020\u00112\u0007\u0010\u0090\u0003\u001a\u00020\u001cJ\"\u0010\u0092\u0003\u001a\u00020!2\u0007\u0010¬\u0002\u001a\u00020!2\u0007\u0010\u00ad\u0002\u001a\u00020!2\u0007\u0010\u0093\u0003\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\u001a\u0010>\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R\u000e\u0010A\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R\u001e\u0010K\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u001e\u0010M\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u00103R\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR-\u0010U\u001a\u001e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020X0Vj\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020X`Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0013\"\u0004\b^\u0010\u0015R\u001e\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\u00110`j\b\u0012\u0004\u0012\u00020\u0011`aX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010b\u001a\u0004\u0018\u00010\u00112\b\u0010J\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0013R\u001a\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010g\u001a\u0012\u0012\u0004\u0012\u00020h0`j\b\u0012\u0004\u0012\u00020h`a¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR!\u0010k\u001a\u0012\u0012\u0004\u0012\u00020l0`j\b\u0012\u0004\u0012\u00020l`a¢\u0006\b\n\u0000\u001a\u0004\bm\u0010jR\u001a\u0010n\u001a\u00020oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u00103\"\u0004\bv\u00105R\u001a\u0010w\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u00103\"\u0004\by\u00105R\u001a\u0010z\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u00103\"\u0004\b|\u00105R\u001a\u0010}\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00103\"\u0004\b\u007f\u00105R\u001f\u0010\u0080\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00110`j\b\u0012\u0004\u0012\u00020\u0011`aX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0081\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0082\u00010`j\t\u0012\u0005\u0012\u00030\u0082\u0001`aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0083\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u0082\u00010)X\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010\u0084\u0001\u001a+\u0012\r\u0012\u000b \u0086\u0001*\u0004\u0018\u00010\u00110\u0011 \u0086\u0001*\u0014\u0012\r\u0012\u000b \u0086\u0001*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u0087\u00010\u0085\u0001X\u0082\u0004¢\u0006\u0002\n\u0000RO\u0010\u0088\u0001\u001aB\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110`j\b\u0012\u0004\u0012\u00020\u0011`a0\u0089\u0001j \u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110`j\b\u0012\u0004\u0012\u00020\u0011`a`\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u008c\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u008d\u00010)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u008e\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00110`j\b\u0012\u0004\u0012\u00020\u0011`aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0091\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00110\u0085\u00010)X\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010\u0092\u0001\u001a+\u0012\r\u0012\u000b \u0086\u0001*\u0004\u0018\u00010\u00110\u0011 \u0086\u0001*\u0014\u0012\r\u0012\u000b \u0086\u0001*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u0087\u00010\u0085\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020W0\u0087\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020W0\u0087\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0096\u0001\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010\u0013R\u0016\u0010\u0098\u0001\u001a\u00020!8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0099\u0001\u00108R;\u0010²\u0001\u001a.\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030´\u0001\u0012\u0004\u0012\u00020\u001f0³\u00010`j\u0016\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030´\u0001\u0012\u0004\u0012\u00020\u001f0³\u0001`aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010µ\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010¶\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010·\u0001\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¸\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010»\u0001\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010¼\u0001\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0005\n\u0003\u0010½\u0001R\u000f\u0010Ó\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ô\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Õ\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ö\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010×\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ø\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ù\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Û\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ü\u0001\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ý\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010Þ\u0001\u001a \u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020!0\u0089\u0001j\u000f\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020!`\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010ß\u0001\u001a\"\u0012\u0004\u0012\u00020W\u0012\u0005\u0012\u00030à\u00010\u0089\u0001j\u0010\u0012\u0004\u0012\u00020W\u0012\u0005\u0012\u00030à\u0001`\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010á\u0001\u001a\u00020WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010ô\u0001\u001a\u001c\u0012\t\u0012\u00070õ\u0001R\u00020\u00000`j\r\u0012\t\u0012\u00070õ\u0001R\u00020\u0000`aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010ö\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030÷\u00010)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ø\u0001\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u008c\u0002\u001a#\u0012\u0004\u0012\u00020\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008d\u00020\u0089\u00020³\u00010)X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0095\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u0096\u00020`j\t\u0012\u0005\u0012\u00030\u0096\u0002`aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ë\u0002\u001a\u00030à\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ì\u0002\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Í\u0002\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ú\u0002\u001a\u00020\u001f8F¢\u0006\u0007\u001a\u0005\bÛ\u0002\u00103R\u0016\u0010ä\u0002\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bå\u0002\u0010\u0013R\u0011\u0010æ\u0002\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0091\u0003\u001a\u00020\u001f8F¢\u0006\u0007\u001a\u0005\b\u0091\u0003\u00103¨\u0006\u009e\u0003"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession;", "Lcom/exampletest/mobilestudiotest/model/TreeListener;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "dm", "Lcom/exampletest/mobilestudiotest/model/DataModel;", "<init>", "(Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/model/DataModel;)V", "getStudio", "()Lcom/exampletest/mobilestudiotest/core/Studio;", "getDm", "()Lcom/exampletest/mobilestudiotest/model/DataModel;", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "getRt", "()Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "player", "Lcom/exampletest/mobilestudiotest/model/Instance;", "getPlayer", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "setPlayer", "(Lcom/exampletest/mobilestudiotest/model/Instance;)V", "character", "getCharacter", "setCharacter", "hrp", "humanoid", "pos", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "vel", "grounded", "", "facing", "", "lastDir", "lastWritten", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "charMinY", "charMaxY", "charHalfXZ", "offsets", "Ljava/util/IdentityHashMap;", "dead", "deadTimer", "jumpRequested", "moveToTarget", "scriptMoveDir", "time", "", "controlsEnabled", "getControlsEnabled", "()Z", "setControlsEnabled", "(Z)V", "camYaw", "getCamYaw", "()F", "setCamYaw", "(F)V", "camPitch", "getCamPitch", "setCamPitch", "camDist", "getCamDist", "setCamDist", "yawTarget", "pitchTarget", "distTarget", "occluded", "subjectY", "lastCamInput", "keyTurn", "getKeyTurn", "setKeyTurn", "value", "shiftLock", "getShiftLock", "firstPerson", "getFirstPerson", "lastTouchDp", "Lcom/exampletest/mobilestudiotest/model/Vector2;", "getLastTouchDp", "()Lcom/exampletest/mobilestudiotest/model/Vector2;", "setLastTouchDp", "(Lcom/exampletest/mobilestudiotest/model/Vector2;)V", "actions", "Ljava/util/LinkedHashMap;", "", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$ActionButton;", "Lkotlin/collections/LinkedHashMap;", "getActions", "()Ljava/util/LinkedHashMap;", "activePrompt", "getActivePrompt", "setActivePrompt", "prompts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "equipped", "getEquipped", "toolOffsets", "mouseTable", "Lorg/luaj/vm2/LuaTable;", "chatLines", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$ChatLine;", "getChatLines", "()Ljava/util/ArrayList;", "bubbles", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$Bubble;", "getBubbles", "chatVersion", "", "getChatVersion", "()I", "setChatVersion", "(I)V", "coreChat", "getCoreChat", "setCoreChat", "corePlayerList", "getCorePlayerList", "setCorePlayerList", "coreBackpack", "getCoreBackpack", "setCoreBackpack", "coreHealth", "getCoreHealth", "setCoreHealth", "movers", "bodies", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$Body;", "bodyOf", "statics", "", "kotlin.jvm.PlatformType", "", "grid", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "cellsOf", "", "bigParts", "physicsDirty", "writing", "touching", "startedScripts", "CELL", "HOLD_TOGETHER", "MOVER_CLASSES", "runService", "getRunService", "gravity", "getGravity", "start", "", "stop", "resetGui", "initial", "installBridge", "addPlayerModule", "ps", "setupTextChat", "isRunnable", "s", "maybeRunScript", "onChildAdded", "parent", "child", "onChildRemoved", "physicsRelevant", "i", "inWorkspace", "childAdded", "childRemoved", "propChanged", "inst", "name", "jointOrder", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$Joint;", "rigid", "isR15", "avatarApplied", "dressable", "lateAvatar", "spawnCharacter", "playAsTemplate", "playAsYaw", "Ljava/lang/Float;", "gameAvatarType", "wantR15", "spec", "Lcom/exampletest/mobilestudiotest/engine/Avatar$Spec;", "clampScales", "Lcom/exampletest/mobilestudiotest/engine/Avatar$Scales;", "loadCharacterTemplate", "bytes", "", "makePlayAs", "src", "faceModel", "buildJoints", "model", "root", "buildR6", "respawn", "resetCharacter", "setJumpHeld", "down", "health", "walkT", "idleT", "airTime", "jumpHeld", "renderFacing", "jumpAnimTime", "climbing", "seated", "seatCooldown", "emote", "emoteTime", "motorAngle", "r15Pose", "", "lastState", "approach", "cur", TypedValues.AttributesType.S_TARGET, "rate", "dt", "motor", "desired", "maxVel", "pose", "animateR6", "setR15", "x", "y", "z", "animateR15", "animate", "animator", "Lcom/exampletest/mobilestudiotest/engine/DefaultAnimate;", "scriptTracks", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$ScriptTrack;", "rigPlayers", "Lcom/exampletest/mobilestudiotest/engine/AnimPlayer;", "customAnimateAt", "rigOf", "owner", "loadTrack", "anim", "table", "playTrack", "st", "fade", "weight", "speed", "stopTrack", "adjustTrack", "looped", "priority", "(Lcom/exampletest/mobilestudiotest/engine/PlaySession$ScriptTrack;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Float;)V", "playingTrackTables", "", "startTrack", "stepScriptTracks", "rigJoints", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$RigJoint;", "poseRig", "rig", "p", "buildRig", "transformFor", "j", "writeCharacter", "debris", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$Debris;", "breakApart", "stepDebris", "facingVec", "frontHits", "Lcom/exampletest/mobilestudiotest/engine/RayHit;", "canClimb", "hits", "alreadyClimbing", "setState", "leaveSeat", "jump", "trySit", "stepCharacter", "respawnTime", "charBox", "collideCharacter", "isCharacterPart", "hiddenInFirstPerson", "cellKey", "cellRange", "", "a", "b", "insertGrid", "removeGrid", "updateGrid", "query", "withBodies", "rebuildPhysics", "physProps", "mat", "measure", "attPart", "attWorld", "attAxis", "num", "n", "d", "vec", "applyMovers", "drive", "v", "pred", "want", "maxF", "mass", "solveDistanceConstraints", "stepBodies", "touchBegin", "touchEnd", "touchingParts", "checkCharacterTouches", "prof", "profN", "profT", "step", "dt0", "zoomLimits", "wrapAngle", "updateCamera", "updatePrompts", "requestJump", "cameraDrag", "dx", "dy", "cameraZoom", "factor", "shiftLockAllowed", "getShiftLockAllowed", "toggleShiftLock", "aimMouse", "xPx", "yPx", "touchInput", "state", "stateValue", "delta", "uisService", "getUisService", "lastPointer", "pointerDown", "pointerMove", "pointerUp", "tap", "triggerPrompt", "mouseValue", "Lorg/luaj/vm2/LuaValue;", "nameColor", "addLine", "l", "systemMessage", "text", TypedValues.Custom.S_COLOR, "sendChat", "raw", "bubble", "part", "stepBubbles", "leaderstats", "backpackTools", "equip", "tool", "unequip", "toggleTool", "t", "bindAction", "fn", "touchButton", "unbindAction", "unbindAll", "setActionTitle", "title", "pressAction", "begin", "velocityOf", "setVelocity", "moveDirection", "h", "isGrounded", "moveTo", "scriptMove", "dir", "isDead", "max3", "c", "ActionButton", "ChatLine", "Bubble", "Body", "Joint", "Companion", "ScriptTrack", "RigJoint", "Debris", "End", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PlaySession implements TreeListener {
    public static final int AVATAR_PLAYER_CHOICE = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float CELL;
    private final Set<String> HOLD_TOGETHER;
    private final Set<String> MOVER_CLASSES;
    private final LinkedHashMap<String, ActionButton> actions;
    private volatile Instance activePrompt;
    private float airTime;
    private DefaultAnimate animator;
    private int avatarApplied;
    private final ArrayList<Instance> bigParts;
    private final ArrayList<Body> bodies;
    private final IdentityHashMap<Instance, Body> bodyOf;
    private final ArrayList<Bubble> bubbles;
    private float camDist;
    private float camPitch;
    private float camYaw;
    private final IdentityHashMap<Instance, long[]> cellsOf;
    private float charHalfXZ;
    private float charMaxY;
    private float charMinY;
    private Instance character;
    private final ArrayList<ChatLine> chatLines;
    private volatile int chatVersion;
    private boolean climbing;
    private boolean controlsEnabled;
    private boolean coreBackpack;
    private boolean coreChat;
    private boolean coreHealth;
    private boolean corePlayerList;
    private double customAnimateAt;
    private boolean dead;
    private float deadTimer;
    private final ArrayList<Debris> debris;
    private float distTarget;
    private final DataModel dm;
    private boolean dressable;
    private String emote;
    private float emoteTime;
    private Instance equipped;
    private float facing;
    private boolean firstPerson;
    private final HashMap<Long, ArrayList<Instance>> grid;
    private boolean grounded;
    private Instance hrp;
    private Instance humanoid;
    private float idleT;
    private boolean isR15;
    private final ArrayList<Pair<Joint, Boolean>> jointOrder;
    private float jumpAnimTime;
    private boolean jumpHeld;
    private boolean jumpRequested;
    private volatile float keyTurn;
    private double lastCamInput;
    private Vector3 lastDir;
    private Vector2 lastPointer;
    private String lastState;
    private volatile Vector2 lastTouchDp;
    private CFrame lastWritten;
    private final HashMap<String, Float> motorAngle;
    private LuaTable mouseTable;
    private Vector3 moveToTarget;
    private final ArrayList<Instance> movers;
    private float occluded;
    private final IdentityHashMap<Instance, CFrame> offsets;
    private boolean physicsDirty;
    private float pitchTarget;
    private Instance playAsTemplate;
    private Float playAsYaw;
    private Instance player;
    private Vector3 pos;
    private final float[] prof;
    private int profN;
    private float profT;
    private ArrayList<Instance> prompts;
    private final HashMap<String, float[]> r15Pose;
    private float renderFacing;
    private final IdentityHashMap<Instance, Pair<Instance, List<RigJoint>>> rigJoints;
    private final IdentityHashMap<Instance, AnimPlayer> rigPlayers;
    private final IdentityHashMap<Instance, CFrame> rigid;
    private final LuaRuntime rt;
    private Vector3 scriptMoveDir;
    private final ArrayList<ScriptTrack> scriptTracks;
    private float seatCooldown;
    private Instance seated;
    private boolean shiftLock;
    private final Set<Instance> startedScripts;
    private final Set<Instance> statics;
    private final Studio studio;
    private float subjectY;
    private double time;
    private final IdentityHashMap<Instance, CFrame> toolOffsets;
    private final IdentityHashMap<Instance, Set<Instance>> touching;
    private Vector3 vel;
    private float walkT;
    private boolean writing;
    private float yawTarget;

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$ActionButton;", "", "name", "", "fn", "Lorg/luaj/vm2/LuaValue;", "title", "<init>", "(Ljava/lang/String;Lorg/luaj/vm2/LuaValue;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getFn", "()Lorg/luaj/vm2/LuaValue;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class ActionButton {
        private final LuaValue fn;
        private final String name;
        private String title;

        public ActionButton(String name, LuaValue fn, String title) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(fn, "fn");
            Intrinsics.checkNotNullParameter(title, "title");
            this.name = name;
            this.fn = fn;
            this.title = title;
        }

        public final LuaValue getFn() {
            return this.fn;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006-"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$Body;", "", "parts", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "vel", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "<init>", "(Ljava/util/List;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getParts", "()Ljava/util/List;", "getVel", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "setVel", "(Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "sleeping", "", "getSleeping", "()Z", "setSleeping", "(Z)V", "restTime", "", "getRestTime", "()F", "setRestTime", "(F)V", "mass", "getMass", "setMass", "friction", "getFriction", "setFriction", "elasticity", "getElasticity", "setElasticity", "min", "getMin", "setMin", "max", "getMax", "setMax", "hasBox", "getHasBox", "setHasBox", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private static final class Body {
        private float elasticity;
        private float friction;
        private boolean hasBox;
        private float mass;
        private Vector3 max;
        private Vector3 min;
        private final List<Instance> parts;
        private float restTime;
        private boolean sleeping;
        private Vector3 vel;

        /* JADX WARN: Multi-variable type inference failed */
        public Body(List<? extends Instance> parts, Vector3 vel) {
            Intrinsics.checkNotNullParameter(parts, "parts");
            Intrinsics.checkNotNullParameter(vel, "vel");
            this.parts = parts;
            this.vel = vel;
            this.mass = 1.0f;
            this.friction = 0.3f;
            this.elasticity = 0.5f;
            this.min = Vector3.INSTANCE.getZERO();
            this.max = Vector3.INSTANCE.getZERO();
        }

        public final float getElasticity() {
            return this.elasticity;
        }

        public final float getFriction() {
            return this.friction;
        }

        public final boolean getHasBox() {
            return this.hasBox;
        }

        public final float getMass() {
            return this.mass;
        }

        public final Vector3 getMax() {
            return this.max;
        }

        public final Vector3 getMin() {
            return this.min;
        }

        public final List<Instance> getParts() {
            return this.parts;
        }

        public final float getRestTime() {
            return this.restTime;
        }

        public final boolean getSleeping() {
            return this.sleeping;
        }

        public final Vector3 getVel() {
            return this.vel;
        }

        public final void setElasticity(float f) {
            this.elasticity = f;
        }

        public final void setFriction(float f) {
            this.friction = f;
        }

        public final void setHasBox(boolean z) {
            this.hasBox = z;
        }

        public final void setMass(float f) {
            this.mass = f;
        }

        public final void setMax(Vector3 vector3) {
            Intrinsics.checkNotNullParameter(vector3, "<set-?>");
            this.max = vector3;
        }

        public final void setMin(Vector3 vector3) {
            Intrinsics.checkNotNullParameter(vector3, "<set-?>");
            this.min = vector3;
        }

        public final void setRestTime(float f) {
            this.restTime = f;
        }

        public final void setSleeping(boolean z) {
            this.sleeping = z;
        }

        public final void setVel(Vector3 vector3) {
            Intrinsics.checkNotNullParameter(vector3, "<set-?>");
            this.vel = vector3;
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$Bubble;", "", "part", "Lcom/exampletest/mobilestudiotest/model/Instance;", "text", "", "age", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Ljava/lang/String;F)V", "getPart", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getText", "()Ljava/lang/String;", "getAge", "()F", "setAge", "(F)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Bubble {
        private float age;
        private final Instance part;
        private final String text;

        public Bubble(Instance part, String text, float f) {
            Intrinsics.checkNotNullParameter(part, "part");
            Intrinsics.checkNotNullParameter(text, "text");
            this.part = part;
            this.text = text;
            this.age = f;
        }

        public /* synthetic */ Bubble(Instance instance, String str, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(instance, str, (i & 4) != 0 ? 0.0f : f);
        }

        public final float getAge() {
            return this.age;
        }

        public final Instance getPart() {
            return this.part;
        }

        public final String getText() {
            return this.text;
        }

        public final void setAge(float f) {
            this.age = f;
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$ChatLine;", "", TypedValues.TransitionType.S_FROM, "", "text", TypedValues.Custom.S_COLOR, "", "system", "", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZJ)V", "getFrom", "()Ljava/lang/String;", "getText", "getColor", "()I", "getSystem", "()Z", "getTime", "()J", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class ChatLine {
        private final int color;
        private final String from;
        private final boolean system;
        private final String text;
        private final long time;

        public ChatLine(String str, String text, int i, boolean z, long j) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.from = str;
            this.text = text;
            this.color = i;
            this.system = z;
            this.time = j;
        }

        public /* synthetic */ ChatLine(String str, String str2, int i, boolean z, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i, z, (i2 & 16) != 0 ? System.currentTimeMillis() : j);
        }

        public final int getColor() {
            return this.color;
        }

        public final String getFrom() {
            return this.from;
        }

        public final boolean getSystem() {
            return this.system;
        }

        public final String getText() {
            return this.text;
        }

        public final long getTime() {
            return this.time;
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$Companion;", "", "<init>", "()V", "AVATAR_PLAYER_CHOICE", "", "buildR6Rig", "Lcom/exampletest/mobilestudiotest/model/Instance;", "name", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static final void buildR6Rig$motor(String str, Instance instance, Instance instance2, CFrame cFrame, CFrame cFrame2, Instance instance3) {
            Instance create = InstanceFactory.INSTANCE.create("Motor6D");
            create.setName(str);
            create.set("Part0", instance, false);
            create.set("Part1", instance2, false);
            create.set("C0", cFrame, false);
            create.set("C1", cFrame2, false);
            create.set("MaxVelocity", Float.valueOf(0.1f), false);
            create.attachRaw(instance3);
        }

        private static final Instance buildR6Rig$part(Instance instance, String str, Vector3 vector3, Vector3 vector32, Color3 color3, boolean z) {
            Instance create = InstanceFactory.INSTANCE.create("Part");
            create.setName(str);
            create.set("size", vector3, false);
            create.set("CFrame", CFrame.INSTANCE.at(vector32), false);
            create.set("Color3uint8", color3, false);
            create.set("Material", new EnumValue(256), false);
            boolean z2 = true;
            Iterator it = CollectionsKt.listOf((Object[]) new String[]{"TopSurface", "BottomSurface", "LeftSurface", "RightSurface", "FrontSurface", "BackSurface"}).iterator();
            while (it.hasNext()) {
                create.set((String) it.next(), new EnumValue(0), false);
            }
            if (!Intrinsics.areEqual(str, "Torso") && !Intrinsics.areEqual(str, "Head")) {
                z2 = false;
            }
            create.set("CanCollide", Boolean.valueOf(z2), false);
            if (z) {
                create.set("Transparency", Float.valueOf(1.0f), false);
                create.set("CanCollide", false, false);
            }
            create.attachRaw(instance);
            return create;
        }

        static /* synthetic */ Instance buildR6Rig$part$default(Instance instance, String str, Vector3 vector3, Vector3 vector32, Color3 color3, boolean z, int i, Object obj) {
            if ((i & 32) != 0) {
                z = false;
            }
            return buildR6Rig$part(instance, str, vector3, vector32, color3, z);
        }

        public final Instance buildR6Rig(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Instance create = InstanceFactory.INSTANCE.create("Model");
            create.setName(name);
            Color3 fromRGB = Color3.INSTANCE.fromRGB(245, 205, 48);
            Color3 fromRGB2 = Color3.INSTANCE.fromRGB(13, 105, 172);
            Color3 fromRGB3 = Color3.INSTANCE.fromRGB(164, 189, 71);
            Instance buildR6Rig$part = buildR6Rig$part(create, "HumanoidRootPart", new Vector3(2.0f, 2.0f, 1.0f), Vector3.INSTANCE.getZERO(), fromRGB2, true);
            Instance buildR6Rig$part$default = buildR6Rig$part$default(create, "Torso", new Vector3(2.0f, 2.0f, 1.0f), Vector3.INSTANCE.getZERO(), fromRGB2, false, 32, null);
            Instance buildR6Rig$part$default2 = buildR6Rig$part$default(create, "Head", new Vector3(2.0f, 1.0f, 1.0f), new Vector3(0.0f, 1.5f, 0.0f), fromRGB, false, 32, null);
            Instance create2 = InstanceFactory.INSTANCE.create("SpecialMesh");
            create2.setName("Mesh");
            create2.set("MeshType", new EnumValue(0), false);
            create2.set("Scale", new Vector3(1.25f, 1.25f, 1.25f), false);
            create2.attachRaw(buildR6Rig$part$default2);
            Instance create3 = InstanceFactory.INSTANCE.create("Decal");
            create3.setName("face");
            create3.set("Texture", "rbxasset://textures/face.png", false);
            create3.set("Face", new EnumValue(5), false);
            create3.attachRaw(buildR6Rig$part$default2);
            Instance buildR6Rig$part$default3 = buildR6Rig$part$default(create, "Left Arm", new Vector3(1.0f, 2.0f, 1.0f), new Vector3(-1.5f, 0.0f, 0.0f), fromRGB, false, 32, null);
            Instance buildR6Rig$part$default4 = buildR6Rig$part$default(create, "Right Arm", new Vector3(1.0f, 2.0f, 1.0f), new Vector3(1.5f, 0.0f, 0.0f), fromRGB, false, 32, null);
            Instance buildR6Rig$part$default5 = buildR6Rig$part$default(create, "Left Leg", new Vector3(1.0f, 2.0f, 1.0f), new Vector3(-0.5f, -2.0f, 0.0f), fromRGB3, false, 32, null);
            Instance buildR6Rig$part$default6 = buildR6Rig$part$default(create, "Right Leg", new Vector3(1.0f, 2.0f, 1.0f), new Vector3(0.5f, -2.0f, 0.0f), fromRGB3, false, 32, null);
            CFrame times = CFrame.INSTANCE.rx(1.5707964f).times(CFrame.INSTANCE.ry(3.1415927f));
            buildR6Rig$motor("RootJoint", buildR6Rig$part, buildR6Rig$part$default, times, times, buildR6Rig$part);
            buildR6Rig$motor("Neck", buildR6Rig$part$default, buildR6Rig$part$default2, CFrame.INSTANCE.at(new Vector3(0.0f, 1.0f, 0.0f)).times(times), CFrame.INSTANCE.at(new Vector3(0.0f, -0.5f, 0.0f)).times(times), buildR6Rig$part$default);
            buildR6Rig$motor("Right Shoulder", buildR6Rig$part$default, buildR6Rig$part$default4, CFrame.INSTANCE.at(new Vector3(1.0f, 0.5f, 0.0f)).times(CFrame.INSTANCE.ry(1.5707964f)), CFrame.INSTANCE.at(new Vector3(-0.5f, 0.5f, 0.0f)).times(CFrame.INSTANCE.ry(1.5707964f)), buildR6Rig$part$default);
            buildR6Rig$motor("Left Shoulder", buildR6Rig$part$default, buildR6Rig$part$default3, CFrame.INSTANCE.at(new Vector3(-1.0f, 0.5f, 0.0f)).times(CFrame.INSTANCE.ry(-1.5707964f)), CFrame.INSTANCE.at(new Vector3(0.5f, 0.5f, 0.0f)).times(CFrame.INSTANCE.ry(-1.5707964f)), buildR6Rig$part$default);
            buildR6Rig$motor("Right Hip", buildR6Rig$part$default, buildR6Rig$part$default6, CFrame.INSTANCE.at(new Vector3(1.0f, -1.0f, 0.0f)).times(CFrame.INSTANCE.ry(1.5707964f)), CFrame.INSTANCE.at(new Vector3(0.5f, 1.0f, 0.0f)).times(CFrame.INSTANCE.ry(1.5707964f)), buildR6Rig$part$default);
            buildR6Rig$motor("Left Hip", buildR6Rig$part$default, buildR6Rig$part$default5, CFrame.INSTANCE.at(new Vector3(-1.0f, -1.0f, 0.0f)).times(CFrame.INSTANCE.ry(-1.5707964f)), CFrame.INSTANCE.at(new Vector3(-0.5f, 1.0f, 0.0f)).times(CFrame.INSTANCE.ry(-1.5707964f)), buildR6Rig$part$default);
            Instance create4 = InstanceFactory.INSTANCE.create("BodyColors");
            create4.setName("Body Colors");
            Iterator it = CollectionsKt.listOf((Object[]) new String[]{"HeadColor3", "LeftArmColor3", "RightArmColor3"}).iterator();
            while (it.hasNext()) {
                create4.set((String) it.next(), fromRGB, false);
            }
            create4.set("TorsoColor3", fromRGB2, false);
            Iterator it2 = CollectionsKt.listOf((Object[]) new String[]{"LeftLegColor3", "RightLegColor3"}).iterator();
            while (it2.hasNext()) {
                create4.set((String) it2.next(), fromRGB3, false);
            }
            create4.attachRaw(create);
            Instance create5 = InstanceFactory.INSTANCE.create("Humanoid");
            create5.set("RigType", new EnumValue(0), false);
            create5.attachRaw(create);
            InstanceFactory.INSTANCE.create("Animator").attachRaw(create5);
            return create;
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$Debris;", "", "part", "Lcom/exampletest/mobilestudiotest/model/Instance;", "vel", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "spin", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getPart", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getVel", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "setVel", "(Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getSpin", "setSpin", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private static final class Debris {
        private final Instance part;
        private Vector3 spin;
        private Vector3 vel;

        public Debris(Instance part, Vector3 vel, Vector3 spin) {
            Intrinsics.checkNotNullParameter(part, "part");
            Intrinsics.checkNotNullParameter(vel, "vel");
            Intrinsics.checkNotNullParameter(spin, "spin");
            this.part = part;
            this.vel = vel;
            this.spin = spin;
        }

        public final Instance getPart() {
            return this.part;
        }

        public final Vector3 getSpin() {
            return this.spin;
        }

        public final Vector3 getVel() {
            return this.vel;
        }

        public final void setSpin(Vector3 vector3) {
            Intrinsics.checkNotNullParameter(vector3, "<set-?>");
            this.spin = vector3;
        }

        public final void setVel(Vector3 vector3) {
            Intrinsics.checkNotNullParameter(vector3, "<set-?>");
            this.vel = vector3;
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$End;", "", "part", "Lcom/exampletest/mobilestudiotest/model/Instance;", "<init>", "(Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lcom/exampletest/mobilestudiotest/model/Instance;)V", "getPart", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "body", "Lcom/exampletest/mobilestudiotest/engine/PlaySession$Body;", "getBody", "()Lcom/exampletest/mobilestudiotest/engine/PlaySession$Body;", "isChar", "", "()Z", "invMass", "", "getInvMass", "()F", "x", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "v", "getV", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "setV", "(Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "move", "", "d", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private final class End {
        private final Body body;
        private final boolean isChar;
        private final Instance part;

        public End(Instance instance) {
            this.part = instance;
            Instance instance2 = this.part;
            this.body = instance2 != null ? (Body) PlaySession.access$getBodyOf$p(PlaySession.this).get(instance2) : null;
            this.isChar = this.body == null && this.part != null && PlaySession.access$isCharacterPart(PlaySession.this, this.part);
        }

        public final Body getBody() {
            return this.body;
        }

        public final float getInvMass() {
            return this.body != null ? 1.0f / this.body.getMass() : this.isChar ? 0.06666667f : 0.0f;
        }

        public final Instance getPart() {
            return this.part;
        }

        public final Vector3 getV() {
            Vector3 vel;
            Body body = this.body;
            return (body == null || (vel = body.getVel()) == null) ? this.isChar ? PlaySession.access$getVel$p(PlaySession.this) : Vector3.INSTANCE.getZERO() : vel;
        }

        /* renamed from: isChar, reason: from getter */
        public final boolean getIsChar() {
            return this.isChar;
        }

        public final void move(Vector3 d) {
            Intrinsics.checkNotNullParameter(d, "d");
            if (this.body == null) {
                if (this.isChar) {
                    PlaySession.access$setPos$p(PlaySession.this, PlaySession.access$getPos$p(PlaySession.this).plus(d));
                }
            } else {
                for (Instance instance : this.body.getParts()) {
                    instance.set("CFrame", PartData.INSTANCE.cframe(instance).plus(d), false);
                }
                this.body.setSleeping(false);
                this.body.setRestTime(0.0f);
            }
        }

        public final void setV(Vector3 x) {
            Intrinsics.checkNotNullParameter(x, "x");
            if (this.body != null) {
                this.body.setVel(x);
                this.body.setSleeping(false);
                this.body.setRestTime(0.0f);
            } else if (this.isChar) {
                PlaySession.access$setVel$p(PlaySession.this, x);
            }
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$Joint;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "p0", "p1", "motor", "", "fixed", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/model/Instance;ZLcom/exampletest/mobilestudiotest/model/CFrame;)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getP0", "getP1", "getMotor", "()Z", "getFixed", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "name", "", "getName", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private static final class Joint {
        private final CFrame fixed;
        private final Instance inst;
        private final boolean motor;
        private final Instance p0;
        private final Instance p1;

        public Joint(Instance inst, Instance p0, Instance p1, boolean z, CFrame cFrame) {
            Intrinsics.checkNotNullParameter(inst, "inst");
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            this.inst = inst;
            this.p0 = p0;
            this.p1 = p1;
            this.motor = z;
            this.fixed = cFrame;
        }

        public final CFrame getFixed() {
            return this.fixed;
        }

        public final Instance getInst() {
            return this.inst;
        }

        public final boolean getMotor() {
            return this.motor;
        }

        public final String getName() {
            return this.inst.getName();
        }

        public final Instance getP0() {
            return this.p0;
        }

        public final Instance getP1() {
            return this.p1;
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$RigJoint;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "p0", "p1", "motor", "", "fixed", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/model/Instance;ZLcom/exampletest/mobilestudiotest/model/CFrame;)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getP0", "getP1", "getMotor", "()Z", "getFixed", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private static final class RigJoint {
        private final CFrame fixed;
        private final Instance inst;
        private final boolean motor;
        private final Instance p0;
        private final Instance p1;

        public RigJoint(Instance inst, Instance p0, Instance p1, boolean z, CFrame cFrame) {
            Intrinsics.checkNotNullParameter(inst, "inst");
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            this.inst = inst;
            this.p0 = p0;
            this.p1 = p1;
            this.motor = z;
            this.fixed = cFrame;
        }

        public final CFrame getFixed() {
            return this.fixed;
        }

        public final Instance getInst() {
            return this.inst;
        }

        public final boolean getMotor() {
            return this.motor;
        }

        public final Instance getP0() {
            return this.p0;
        }

        public final Instance getP1() {
            return this.p1;
        }
    }

    /* compiled from: PlaySession.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001e\u0010)\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00106\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0013\u0010;\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b>\u0010\u001aR\u0011\u0010?\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b@\u0010 R\u0011\u0010A\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bB\u0010 R\u0011\u0010C\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bD\u0010 R\u0011\u0010E\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bF\u0010 ¨\u0006G"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/PlaySession$ScriptTrack;", "", "rig", "Lcom/exampletest/mobilestudiotest/model/Instance;", "id", "", "inline", "Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "table", "Lorg/luaj/vm2/LuaTable;", "<init>", "(Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lcom/exampletest/mobilestudiotest/model/Instance;Ljava/lang/Long;Lcom/exampletest/mobilestudiotest/engine/AnimClip;Lorg/luaj/vm2/LuaTable;)V", "getRig", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "Ljava/lang/Long;", "getTable", "()Lorg/luaj/vm2/LuaTable;", "track", "Lcom/exampletest/mobilestudiotest/engine/AnimPlayer$Track;", "getTrack", "()Lcom/exampletest/mobilestudiotest/engine/AnimPlayer$Track;", "setTrack", "(Lcom/exampletest/mobilestudiotest/engine/AnimPlayer$Track;)V", "wantPlay", "", "getWantPlay", "()Z", "setWantPlay", "(Z)V", "fade", "", "getFade", "()F", "setFade", "(F)V", "weight", "getWeight", "setWeight", "speed", "getSpeed", "setSpeed", "looped", "getLooped", "()Ljava/lang/Boolean;", "setLooped", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "priority", "", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "loopsSeen", "getLoopsSeen", "()I", "setLoopsSeen", "(I)V", "clip", "getClip", "()Lcom/exampletest/mobilestudiotest/engine/AnimClip;", "isPlaying", "length", "getLength", "time", "getTime", "weightNow", "getWeightNow", "weightTarget", "getWeightTarget", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public final class ScriptTrack {
        private float fade;
        private final Long id;
        private final AnimClip inline;
        private Boolean looped;
        private int loopsSeen;
        private Integer priority;
        private final Instance rig;
        private float speed;
        private final LuaTable table;
        final /* synthetic */ PlaySession this$0;
        private AnimPlayer.Track track;
        private boolean wantPlay;
        private float weight;

        public ScriptTrack(PlaySession playSession, Instance rig, Long l, AnimClip animClip, LuaTable table) {
            Intrinsics.checkNotNullParameter(rig, "rig");
            Intrinsics.checkNotNullParameter(table, "table");
            this.this$0 = playSession;
            this.rig = rig;
            this.id = l;
            this.inline = animClip;
            this.table = table;
            this.fade = 0.1f;
            this.weight = 1.0f;
            this.speed = 1.0f;
        }

        public final AnimClip getClip() {
            AnimClip animClip = this.inline;
            if (animClip != null) {
                return animClip;
            }
            Long l = this.id;
            if (l == null) {
                return null;
            }
            return AnimLibrary.INSTANCE.get(l.longValue());
        }

        public final float getFade() {
            return this.fade;
        }

        public final float getLength() {
            AnimClip clip = getClip();
            if (clip != null) {
                return clip.getLength();
            }
            return 0.0f;
        }

        public final Boolean getLooped() {
            return this.looped;
        }

        public final int getLoopsSeen() {
            return this.loopsSeen;
        }

        public final Integer getPriority() {
            return this.priority;
        }

        public final Instance getRig() {
            return this.rig;
        }

        public final float getSpeed() {
            return this.speed;
        }

        public final LuaTable getTable() {
            return this.table;
        }

        public final float getTime() {
            AnimPlayer.Track track = this.track;
            if (track != null) {
                return track.getTime();
            }
            return 0.0f;
        }

        public final AnimPlayer.Track getTrack() {
            return this.track;
        }

        public final boolean getWantPlay() {
            return this.wantPlay;
        }

        public final float getWeight() {
            return this.weight;
        }

        public final float getWeightNow() {
            AnimPlayer.Track track = this.track;
            if (track != null) {
                return track.getWeight();
            }
            return 0.0f;
        }

        public final float getWeightTarget() {
            if (this.wantPlay) {
                return this.weight;
            }
            return 0.0f;
        }

        public final boolean isPlaying() {
            return this.wantPlay;
        }

        public final void setFade(float f) {
            this.fade = f;
        }

        public final void setLooped(Boolean bool) {
            this.looped = bool;
        }

        public final void setLoopsSeen(int i) {
            this.loopsSeen = i;
        }

        public final void setPriority(Integer num) {
            this.priority = num;
        }

        public final void setSpeed(float f) {
            this.speed = f;
        }

        public final void setTrack(AnimPlayer.Track track) {
            this.track = track;
        }

        public final void setWantPlay(boolean z) {
            this.wantPlay = z;
        }

        public final void setWeight(float f) {
            this.weight = f;
        }
    }

    public PlaySession(Studio studio, DataModel dm) {
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(dm, "dm");
        this.studio = studio;
        this.dm = dm;
        LuaRuntime luaRuntime = new LuaRuntime(this.studio, this.dm, true);
        luaRuntime.setPlay(this);
        this.rt = luaRuntime;
        this.pos = new Vector3(0.0f, 10.0f, 0.0f);
        this.vel = Vector3.INSTANCE.getZERO();
        this.lastDir = Vector3.INSTANCE.getZERO();
        this.charMinY = -3.0f;
        this.charMaxY = 2.0f;
        this.charHalfXZ = 1.0f;
        this.offsets = new IdentityHashMap<>();
        this.controlsEnabled = true;
        this.camPitch = -0.35f;
        this.camDist = 14.0f;
        this.pitchTarget = -0.35f;
        this.distTarget = 14.0f;
        this.occluded = 1000.0f;
        this.subjectY = Float.NaN;
        this.lastCamInput = -10.0d;
        this.actions = new LinkedHashMap<>();
        this.prompts = new ArrayList<>();
        this.toolOffsets = new IdentityHashMap<>();
        this.chatLines = new ArrayList<>();
        this.bubbles = new ArrayList<>();
        this.coreChat = true;
        this.corePlayerList = true;
        this.coreBackpack = true;
        this.coreHealth = true;
        this.movers = new ArrayList<>();
        this.bodies = new ArrayList<>();
        this.bodyOf = new IdentityHashMap<>();
        this.statics = Collections.newSetFromMap(new IdentityHashMap());
        this.grid = new HashMap<>();
        this.cellsOf = new IdentityHashMap<>();
        this.bigParts = new ArrayList<>();
        this.physicsDirty = true;
        this.touching = new IdentityHashMap<>();
        this.startedScripts = Collections.newSetFromMap(new IdentityHashMap());
        this.CELL = 32.0f;
        this.HOLD_TOGETHER = SetsKt.setOf((Object[]) new String[]{"RigidConstraint", "HingeConstraint", "BallSocketConstraint", "CylindricalConstraint", "PrismaticConstraint", "UniversalConstraint", "TorsionSpringConstraint", "PlaneConstraint", "SpringConstraint"});
        this.MOVER_CLASSES = SetsKt.setOf((Object[]) new String[]{"BodyForce", "BodyThrust", "BodyVelocity", "BodyPosition", "RocketPropulsion", "VectorForce", "LineForce", "LinearVelocity", "AlignPosition", "SpringConstraint", "RopeConstraint", "RodConstraint"});
        this.jointOrder = new ArrayList<>();
        this.rigid = new IdentityHashMap<>();
        this.avatarApplied = -1;
        this.motorAngle = new HashMap<>();
        this.r15Pose = new HashMap<>();
        this.lastState = "Running";
        this.scriptTracks = new ArrayList<>();
        this.rigPlayers = new IdentityHashMap<>();
        this.customAnimateAt = -100.0d;
        this.rigJoints = new IdentityHashMap<>();
        this.debris = new ArrayList<>();
        this.prof = new float[8];
    }

    public static final /* synthetic */ IdentityHashMap access$getBodyOf$p(PlaySession playSession) {
        return playSession.bodyOf;
    }

    public static final /* synthetic */ Vector3 access$getPos$p(PlaySession playSession) {
        return playSession.pos;
    }

    public static final /* synthetic */ Vector3 access$getVel$p(PlaySession playSession) {
        return playSession.vel;
    }

    public static final /* synthetic */ boolean access$isCharacterPart(PlaySession playSession, Instance instance) {
        return playSession.isCharacterPart(instance);
    }

    public static final /* synthetic */ void access$setPos$p(PlaySession playSession, Vector3 vector3) {
        playSession.pos = vector3;
    }

    public static final /* synthetic */ void access$setVel$p(PlaySession playSession, Vector3 vector3) {
        playSession.vel = vector3;
    }

    private final void addLine(ChatLine l) {
        this.chatLines.add(l);
        while (this.chatLines.size() > 200) {
            this.chatLines.remove(0);
        }
        this.chatVersion++;
    }

    private final void addPlayerModule(Instance ps) {
        Instance addPlayerModule$module = addPlayerModule$module("PlayerModule", "\n            local bridge = __MobileStudioPlayer\n            local Controls = {}\n            Controls.__index = Controls\n            function Controls:Enable(enable) bridge.setControlsEnabled(enable ~= false) end\n            function Controls:Disable() bridge.setControlsEnabled(false) end\n            function Controls:GetMoveVector() return bridge.getMoveVector() end\n            function Controls:GetActiveController() return self end\n            function Controls:SelectTouchModule() end\n            function Controls:GetIsJumping() return false end\n            local controls = setmetatable({}, Controls)\n            local Cameras = {}\n            Cameras.__index = Cameras\n            function Cameras:GetCameraControlChoice() return nil end\n            function Cameras:SetIsMouseLocked(on) bridge.setShiftLock(on) end\n            function Cameras:GetIsMouseLocked() return bridge.isShiftLock() end\n            local cameras = setmetatable({}, Cameras)\n            local PlayerModule = {}\n            function PlayerModule:GetControls() return controls end\n            function PlayerModule:GetCameras() return cameras end\n            function PlayerModule:GetClickToMoveController() return controls end\n            return PlayerModule\n        ", ps);
        addPlayerModule$module("ControlModule", "local pm = require(script.Parent)\nreturn pm:GetControls()", addPlayerModule$module);
        addPlayerModule$module("CameraModule", "local pm = require(script.Parent)\nreturn pm:GetCameras()", addPlayerModule$module);
    }

    private static final Instance addPlayerModule$module(String str, String str2, Instance instance) {
        Instance create = InstanceFactory.INSTANCE.create("ModuleScript");
        create.setName(str);
        create.set("Source", StringsKt.trimIndent(str2) + "\n", false);
        create.attachRaw(instance);
        return create;
    }

    public static /* synthetic */ void adjustTrack$default(PlaySession playSession, ScriptTrack scriptTrack, Float f, Float f2, Float f3, Boolean bool, Integer num, Float f4, int i, Object obj) {
        if ((i & 2) != 0) {
            f = null;
        }
        if ((i & 4) != 0) {
            f2 = null;
        }
        if ((i & 8) != 0) {
            f3 = null;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            f4 = null;
        }
        playSession.adjustTrack(scriptTrack, f, f2, f3, bool, num, f4);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.engine.RayHit aimMouse(float r18, float r19) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.aimMouse(float, float):com.exampletest.mobilestudiotest.engine.RayHit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean aimMouse$lambda$137(PlaySession playSession, Instance instance, Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (playSession.isCharacterPart(it) || Intrinsics.areEqual(it.get("Transparency"), Float.valueOf(1.0f)) || (instance != null && (it == instance || it.isDescendantOf(instance)))) ? false : true;
    }

    private final void animate(float dt) {
        float f;
        this.airTime = (this.grounded || this.climbing || this.seated != null) ? 0.0f : this.airTime + dt;
        if (this.jumpAnimTime > 0.0f) {
            this.jumpAnimTime -= dt;
        }
        if (this.emote != null) {
            this.emoteTime += dt;
            if (((float) Math.sqrt((this.vel.getX() * this.vel.getX()) + (this.vel.getZ() * this.vel.getZ()))) > 0.5f || !this.grounded || (!Intrinsics.areEqual(this.emote, "dance") && this.emoteTime > 2.5f)) {
                this.emote = null;
            }
        }
        String pose = pose();
        if (this.isR15) {
            animateR15(dt, pose);
        } else {
            animateR6(dt, pose);
        }
        float abs = Intrinsics.areEqual(pose, "Climbing") ? Math.abs(this.vel.getY()) : (float) Math.sqrt((this.vel.getX() * this.vel.getX()) + (this.vel.getZ() * this.vel.getZ()));
        DefaultAnimate defaultAnimate = this.animator;
        if (defaultAnimate != null) {
            f = dt;
            defaultAnimate.step(f, pose, abs, this.equipped != null, this.emote, this.jumpAnimTime);
        } else {
            f = dt;
        }
        float f2 = this.facing - this.renderFacing;
        while (f2 > 3.141592653589793d) {
            f2 -= 6.2831855f;
        }
        while (f2 < -3.141592653589793d) {
            f2 += 6.2831855f;
        }
        this.renderFacing += (1.0f - ((float) Math.exp((-18.0f) * f))) * f2;
    }

    private final void animateR15(float dt, String pose) {
        float f;
        PlaySession playSession;
        float f2;
        PlaySession playSession2 = this;
        float sqrt = (float) Math.sqrt((playSession2.vel.getX() * playSession2.vel.getX()) + (playSession2.vel.getZ() * playSession2.vel.getZ()));
        Instance instance = playSession2.humanoid;
        Object obj = instance != null ? instance.get("WalkSpeed") : null;
        Number number = obj instanceof Number ? (Number) obj : null;
        float coerceAtLeast = RangesKt.coerceAtLeast(number != null ? number.floatValue() : 16.0f, 1.0f);
        playSession2.idleT += dt;
        switch (pose.hashCode()) {
            case -1822467708:
                f = 14.0f;
                if (pose.equals("Seated")) {
                    animateR15$all$default(14.0f, this, dt, 0.35f, 0.35f, 0.6f, 0.6f, 1.57f, 1.57f, -1.57f, -1.57f, 0.0f, 0.0f, 0.0f, 14336, null);
                    playSession = this;
                    break;
                }
                f2 = f;
                playSession2 = this;
                float sin = (float) Math.sin(playSession2.idleT * 1.6f);
                float f3 = f2;
                PlaySession playSession3 = playSession2;
                animateR15$all$default(f3, playSession3, dt, sin * 0.04f, 0.04f * sin, 0.08f, 0.08f, 0.0f, 0.0f, 0.0f, 0.0f, sin * 0.025f, 0.0f, 8.0f, 4096, null);
                playSession = playSession3;
                playSession.walkT = 0.0f;
                break;
            case -1474121689:
                f = 14.0f;
                if (pose.equals("FreeFall")) {
                    animateR15$all$default(14.0f, this, dt, 2.8f, 2.8f, 0.2f, 0.2f, 0.5f, -0.25f, -0.7f, -0.3f, 0.0f, 0.0f, 8.0f, 6144, null);
                    playSession = this;
                    break;
                }
                f2 = f;
                playSession2 = this;
                float sin2 = (float) Math.sin(playSession2.idleT * 1.6f);
                float f32 = f2;
                PlaySession playSession32 = playSession2;
                animateR15$all$default(f32, playSession32, dt, sin2 * 0.04f, 0.04f * sin2, 0.08f, 0.08f, 0.0f, 0.0f, 0.0f, 0.0f, sin2 * 0.025f, 0.0f, 8.0f, 4096, null);
                playSession = playSession32;
                playSession.walkT = 0.0f;
                break;
            case -1079530081:
                f2 = 14.0f;
                if (pose.equals("Running")) {
                    float coerceIn = RangesKt.coerceIn(sqrt / coerceAtLeast, 0.4f, 1.6f);
                    playSession2.walkT += dt * 9.0f * coerceIn;
                    float sin3 = (float) Math.sin(playSession2.walkT);
                    float cos = (float) Math.cos(playSession2.walkT);
                    float coerceAtMost = RangesKt.coerceAtMost(coerceIn, 1.2f) * 0.7f;
                    animateR15$all(14.0f, playSession2, dt, (-0.6f) * sin3 * RangesKt.coerceAtMost(coerceIn, 1.2f), 0.6f * sin3 * RangesKt.coerceAtMost(coerceIn, 1.2f), (Math.max(0.0f, -sin3) * 0.2f) + 0.25f, (Math.max(0.0f, sin3) * 0.2f) + 0.25f, coerceAtMost * sin3, (-coerceAtMost) * sin3, Math.max(0.0f, -cos) * (-0.9f), Math.max(0.0f, cos) * (-0.9f), 0.05f, 0.08f * sin3, 22.0f);
                    playSession = this;
                    break;
                }
                float sin22 = (float) Math.sin(playSession2.idleT * 1.6f);
                float f322 = f2;
                PlaySession playSession322 = playSession2;
                animateR15$all$default(f322, playSession322, dt, sin22 * 0.04f, 0.04f * sin22, 0.08f, 0.08f, 0.0f, 0.0f, 0.0f, 0.0f, sin22 * 0.025f, 0.0f, 8.0f, 4096, null);
                playSession = playSession322;
                playSession.walkT = 0.0f;
                break;
            case 409511124:
                if (!pose.equals("Jumping")) {
                    f2 = 14.0f;
                    playSession2 = this;
                    float sin222 = (float) Math.sin(playSession2.idleT * 1.6f);
                    float f3222 = f2;
                    PlaySession playSession3222 = playSession2;
                    animateR15$all$default(f3222, playSession3222, dt, sin222 * 0.04f, 0.04f * sin222, 0.08f, 0.08f, 0.0f, 0.0f, 0.0f, 0.0f, sin222 * 0.025f, 0.0f, 8.0f, 4096, null);
                    playSession = playSession3222;
                    playSession.walkT = 0.0f;
                    break;
                } else {
                    animateR15$all$default(14.0f, this, dt, 2.4f, 2.4f, 0.4f, 0.4f, 0.35f, -0.1f, -0.5f, -0.2f, 0.0f, 0.0f, 18.0f, 6144, null);
                    playSession = this;
                    break;
                }
            case 980073773:
                if (!pose.equals("Climbing")) {
                    f2 = 14.0f;
                    float sin2222 = (float) Math.sin(playSession2.idleT * 1.6f);
                    float f32222 = f2;
                    PlaySession playSession32222 = playSession2;
                    animateR15$all$default(f32222, playSession32222, dt, sin2222 * 0.04f, 0.04f * sin2222, 0.08f, 0.08f, 0.0f, 0.0f, 0.0f, 0.0f, sin2222 * 0.025f, 0.0f, 8.0f, 4096, null);
                    playSession = playSession32222;
                    playSession.walkT = 0.0f;
                    break;
                } else {
                    playSession2.walkT += 8.0f * dt * RangesKt.coerceIn(Math.abs(playSession2.vel.getY()) / (0.7f * coerceAtLeast), 0.0f, 1.2f);
                    float sin4 = (float) Math.sin(playSession2.walkT);
                    animateR15$all$default(14.0f, this, dt, (sin4 * 0.5f) + 2.6f, 2.6f - (sin4 * 0.5f), 0.6f, 0.6f, (sin4 * 0.5f) + 0.55f, 0.55f - (0.5f * sin4), (-0.8f) - (sin4 * 0.4f), (0.4f * sin4) - 0.8f, 0.0f, 0.0f, 20.0f, 6144, null);
                    playSession = this;
                    break;
                }
            default:
                f2 = 14.0f;
                float sin22222 = (float) Math.sin(playSession2.idleT * 1.6f);
                float f322222 = f2;
                PlaySession playSession322222 = playSession2;
                animateR15$all$default(f322222, playSession322222, dt, sin22222 * 0.04f, 0.04f * sin22222, 0.08f, 0.08f, 0.0f, 0.0f, 0.0f, 0.0f, sin22222 * 0.025f, 0.0f, 8.0f, 4096, null);
                playSession = playSession322222;
                playSession.walkT = 0.0f;
                break;
        }
        if (playSession.equipped != null && playSession.emote == null) {
            setR15$default(playSession, "RightShoulder", 1.57f, 0.0f, 0.0f, 20.0f, dt, 12, null);
        }
        String str = playSession.emote;
        if (str != null) {
            switch (str.hashCode()) {
                case 3642105:
                    if (str.equals("wave")) {
                        playSession.setR15("RightShoulder", 2.4f, 0.0f, ((float) Math.sin(playSession.emoteTime * 9.0f)) * 0.3f, 20.0f, dt);
                        return;
                    }
                    return;
                case 94627149:
                    if (str.equals("cheer")) {
                        setR15$default(this, "RightShoulder", 2.9f, 0.0f, 0.0f, 20.0f, dt, 12, null);
                        setR15$default(this, "LeftShoulder", 2.9f, 0.0f, 0.0f, 20.0f, dt, 12, null);
                        return;
                    }
                    return;
                case 95350707:
                    if (str.equals("dance")) {
                        float sin5 = (float) Math.sin(playSession.emoteTime * 5.0f);
                        setR15$default(playSession, "RightShoulder", sin5 + 1.4f, 0.0f, 0.0f, 20.0f, dt, 12, null);
                        setR15$default(this, "LeftShoulder", 1.4f - sin5, 0.0f, 0.0f, 20.0f, dt, 12, null);
                        setR15$default(this, "Waist", 0.0f, sin5 * 0.3f, 0.0f, 20.0f, dt, 8, null);
                        return;
                    }
                    return;
                case 106845584:
                    if (str.equals("point")) {
                        setR15$default(playSession, "RightShoulder", 1.57f, 0.0f, 0.0f, 20.0f, dt, 12, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static final void animateR15$all(float f, PlaySession playSession, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        setR15$default(playSession, "RightShoulder", f3, 0.0f, 0.0f, f13, f2, 12, null);
        setR15$default(playSession, "LeftShoulder", f4, 0.0f, 0.0f, f13, f2, 12, null);
        setR15$default(playSession, "RightElbow", f5, 0.0f, 0.0f, f13, f2, 12, null);
        setR15$default(playSession, "LeftElbow", f6, 0.0f, 0.0f, f13, f2, 12, null);
        setR15$default(playSession, "RightHip", f7, 0.0f, 0.0f, f13, f2, 12, null);
        setR15$default(playSession, "LeftHip", f8, 0.0f, 0.0f, f13, f2, 12, null);
        setR15$default(playSession, "RightKnee", f9, 0.0f, 0.0f, f13, f2, 12, null);
        setR15$default(playSession, "LeftKnee", f10, 0.0f, 0.0f, f13, f2, 12, null);
        setR15$default(playSession, "Waist", f11, f12, 0.0f, f13, f2, 8, null);
    }

    static /* synthetic */ void animateR15$all$default(float f, PlaySession playSession, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int i, Object obj) {
        animateR15$all(f, playSession, f2, f3, f4, f5, f6, f7, f8, f9, f10, (i & 2048) != 0 ? 0.0f : f11, (i & 4096) != 0 ? 0.0f : f12, (i & 8192) != 0 ? f : f13);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c4, code lost:
    
        if (r31.equals("FreeFall") != false) goto L27;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0064. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0224  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void animateR6(float r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.animateR6(float, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:276:0x0470, code lost:
    
        if (r11 != null) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x03c8, code lost:
    
        if (r6 != null) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x05da, code lost:
    
        if (r1 != null) goto L260;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0071. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x0537. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x06b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0527 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0666  */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void applyMovers(float r26) {
        /*
            Method dump skipped, instructions count: 1968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.applyMovers(float):void");
    }

    private final float approach(float cur, float target, float rate, float dt) {
        return ((target - cur) * (1.0f - ((float) Math.exp((-rate) * dt)))) + cur;
    }

    private final CFrame attAxis(Instance a) {
        Instance attPart = attPart(a);
        if (attPart == null) {
            return null;
        }
        CFrame cframe = PartData.INSTANCE.cframe(attPart);
        Intrinsics.checkNotNull(a);
        Object obj = a.get("CFrame");
        CFrame cFrame = obj instanceof CFrame ? (CFrame) obj : null;
        if (cFrame == null) {
            cFrame = CFrame.INSTANCE.getIDENTITY();
        }
        return cframe.times(cFrame);
    }

    private final Instance attPart(Instance a) {
        Instance parent;
        if (a == null || (parent = a.getParent()) == null || !parent.isA("BasePart")) {
            return null;
        }
        return parent;
    }

    private final Vector3 attWorld(Instance a) {
        Vector3 zero;
        Instance attPart = attPart(a);
        if (attPart == null) {
            return null;
        }
        CFrame cframe = PartData.INSTANCE.cframe(attPart);
        Intrinsics.checkNotNull(a);
        Object obj = a.get("CFrame");
        CFrame cFrame = obj instanceof CFrame ? (CFrame) obj : null;
        if (cFrame == null || (zero = cFrame.getPosition()) == null) {
            zero = Vector3.INSTANCE.getZERO();
        }
        return cframe.times(zero);
    }

    private final void breakApart() {
        this.debris.clear();
        Random random = new Random();
        Iterator<Map.Entry<Instance, CFrame>> it = this.offsets.entrySet().iterator();
        while (it.hasNext()) {
            Instance key = it.next().getKey();
            if (key != this.hrp && key.getParent() != null) {
                PartData partData = PartData.INSTANCE;
                Intrinsics.checkNotNull(key);
                Vector3 minus = partData.cframe(key).getPosition().minus(this.pos);
                Vector3 vector3 = new Vector3(minus.getX(), 0.0f, minus.getZ());
                this.debris.add(new Debris(key, this.vel.times(0.5f).plus(vector3.getMagnitude() > 0.01f ? vector3.getUnit().times(6.0f) : Vector3.INSTANCE.getZERO()).plus(new Vector3((random.nextFloat() - 0.5f) * 8.0f, (random.nextFloat() * 6.0f) + 4.0f, (random.nextFloat() - 0.5f) * 8.0f)), new Vector3((random.nextFloat() - 0.5f) * 10.0f, (random.nextFloat() - 0.5f) * 10.0f, (random.nextFloat() - 0.5f) * 10.0f)));
            }
        }
        Instance instance = this.character;
        List<Instance> descendants$default = instance != null ? Instance.descendants$default(instance, null, 1, null) : null;
        if (descendants$default == null) {
            descendants$default = CollectionsKt.emptyList();
        }
        for (Instance instance2 : descendants$default) {
            if (Intrinsics.areEqual(instance2.getClassName(), "Motor6D")) {
                instance2.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean bubble$lambda$157(Instance instance, PlaySession playSession, Bubble it) {
        int i;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getPart() != instance) {
            return false;
        }
        ArrayList<Bubble> arrayList = playSession.bubbles;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            i = 0;
        } else {
            i = 0;
            Iterator<T> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if ((((Bubble) it2.next()).getPart() == instance) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i >= 3;
    }

    private final void buildJoints(Instance model, Instance root) {
        this.jointOrder.clear();
        this.rigid.clear();
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        List descendants$default = Instance.descendants$default(model, null, 1, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : descendants$default) {
            if (((Instance) obj).isA("BasePart")) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            newSetFromMap.add((Instance) it.next());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Instance instance : Instance.descendants$default(model, null, 1, null)) {
            if (instance.isA("JointInstance")) {
                Object obj2 = instance.get("Part0");
                Instance instance2 = obj2 instanceof Instance ? (Instance) obj2 : null;
                Object obj3 = instance.get("Part1");
                Instance instance3 = obj3 instanceof Instance ? (Instance) obj3 : null;
                if (instance2 != null && instance3 != null && newSetFromMap.contains(instance2) && newSetFromMap.contains(instance3) && instance2 != instance3) {
                    arrayList2.add(new Joint(instance, instance2, instance3, instance.isA("Motor"), null));
                }
            } else if (Intrinsics.areEqual(instance.getClassName(), "WeldConstraint") && !Intrinsics.areEqual(instance.get("Enabled"), (Object) false)) {
                Object obj4 = instance.get("Part0Internal");
                if (obj4 == null) {
                    obj4 = instance.get("Part0");
                }
                Instance instance4 = obj4 instanceof Instance ? (Instance) obj4 : null;
                Object obj5 = instance.get("Part1Internal");
                if (obj5 == null) {
                    obj5 = instance.get("Part1");
                }
                Instance instance5 = obj5 instanceof Instance ? (Instance) obj5 : null;
                if (instance4 != null && instance5 != null && newSetFromMap.contains(instance4) && newSetFromMap.contains(instance5) && instance4 != instance5) {
                    arrayList2.add(new Joint(instance, instance4, instance5, false, PartData.INSTANCE.cframe(instance4).inverse().times(PartData.INSTANCE.cframe(instance5))));
                }
            }
        }
        Set newSetFromMap2 = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap2.add(root);
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(root);
        Set newSetFromMap3 = Collections.newSetFromMap(new IdentityHashMap());
        while (!arrayDeque.isEmpty()) {
            Instance instance6 = (Instance) arrayDeque.removeFirst();
            Iterator it2 = arrayList2.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next = it2.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Joint joint = (Joint) next;
                if (!newSetFromMap3.contains(joint)) {
                    if (joint.getP0() == instance6 && !newSetFromMap2.contains(joint.getP1())) {
                        newSetFromMap3.add(joint);
                        newSetFromMap2.add(joint.getP1());
                        this.jointOrder.add(TuplesKt.to(joint, true));
                        arrayDeque.add(joint.getP1());
                    } else if (joint.getP1() == instance6 && !newSetFromMap2.contains(joint.getP0())) {
                        newSetFromMap3.add(joint);
                        newSetFromMap2.add(joint.getP0());
                        this.jointOrder.add(TuplesKt.to(joint, false));
                        arrayDeque.add(joint.getP0());
                    }
                }
            }
        }
        for (Map.Entry<Instance, CFrame> entry : this.offsets.entrySet()) {
            Instance key = entry.getKey();
            CFrame value = entry.getValue();
            if (!newSetFromMap2.contains(key)) {
                this.rigid.put(key, value);
            }
        }
    }

    private final Instance buildR6(String name) {
        return INSTANCE.buildR6Rig(name);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0201  */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15, types: [com.exampletest.mobilestudiotest.model.CFrame] */
    /* JADX WARN: Type inference failed for: r11v18, types: [com.exampletest.mobilestudiotest.model.CFrame] */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.exampletest.mobilestudiotest.model.CFrame] */
    /* JADX WARN: Type inference failed for: r12v13, types: [com.exampletest.mobilestudiotest.model.CFrame] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<com.exampletest.mobilestudiotest.model.Instance, java.util.List<com.exampletest.mobilestudiotest.engine.PlaySession.RigJoint>> buildRig(com.exampletest.mobilestudiotest.model.Instance r20) {
        /*
            Method dump skipped, instructions count: 733
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.buildRig(com.exampletest.mobilestudiotest.model.Instance):kotlin.Pair");
    }

    private final boolean canClimb(List<RayHit> hits, boolean alreadyClimbing) {
        boolean z;
        boolean z2;
        Instance part;
        int i;
        int i2;
        if (hits.isEmpty()) {
            return false;
        }
        List<RayHit> list = hits;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!(((RayHit) it.next()) == null)) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        List<RayHit> list2 = hits;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                RayHit rayHit = (RayHit) it2.next();
                if (Intrinsics.areEqual((rayHit == null || (part = rayHit.getPart()) == null) ? null : part.getClassName(), "TrussPart")) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
        }
        if (z2 || alreadyClimbing) {
            return true;
        }
        int i3 = 0;
        Iterator<RayHit> it3 = hits.iterator();
        while (true) {
            i = -1;
            if (!it3.hasNext()) {
                i3 = -1;
                break;
            }
            if (it3.next() != null) {
                break;
            }
            i3++;
        }
        ListIterator<RayHit> listIterator = hits.listIterator(hits.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            if (listIterator.previous() != null) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i3 < 0 || i - i3 < 2) {
            return false;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = i3;
        if (i7 <= i) {
            while (true) {
                if (hits.get(i7) == null) {
                    i5++;
                    i6 = Math.max(i6, i5);
                } else {
                    if (i5 > 0) {
                        i4++;
                    }
                    i5 = 0;
                }
                if (i7 == i) {
                    break;
                }
                i7++;
            }
        }
        List<RayHit> list3 = hits;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 0;
            Iterator<T> it4 = list3.iterator();
            while (it4.hasNext()) {
                if ((((RayHit) it4.next()) != null) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        List filterNotNull = CollectionsKt.filterNotNull(hits);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterNotNull, 10));
        Iterator it5 = filterNotNull.iterator();
        while (it5.hasNext()) {
            arrayList.add(Float.valueOf(((RayHit) it5.next()).getT()));
        }
        ArrayList arrayList2 = arrayList;
        return CollectionsKt.maxOrThrow((Iterable<Double>) arrayList2) - CollectionsKt.minOrThrow((Iterable<Double>) arrayList2) <= 0.7f && i >= hits.size() / 2 && i4 >= 1 && ((float) i6) * 0.4f <= 2.4f && i2 >= 2 && i2 < hits.size();
    }

    private final long cellKey(int x, int y, int z) {
        return ((x & 2097151) << 42) | ((y & 2097151) << 21) | (z & 2097151);
    }

    private final int[] cellRange(Vector3 a, Vector3 b) {
        return new int[]{(int) Math.floor(a.getX() / this.CELL), (int) Math.floor(a.getY() / this.CELL), (int) Math.floor(a.getZ() / this.CELL), (int) Math.floor(b.getX() / this.CELL), (int) Math.floor(b.getY() / this.CELL), (int) Math.floor(b.getZ() / this.CELL)};
    }

    private final Pair<Vector3, Vector3> charBox() {
        return TuplesKt.to(new Vector3(this.pos.getX(), this.pos.getY() + ((this.charMinY + this.charMaxY) / 2.0f), this.pos.getZ()), new Vector3(this.charHalfXZ, (this.charMaxY - this.charMinY) / 2.0f, this.charHalfXZ));
    }

    private final void checkCharacterTouches() {
        Instance instance = this.character;
        if (instance == null || this.dead) {
            return;
        }
        boolean z = false;
        Instance findFirstChild$default = Instance.findFirstChild$default(instance, "Torso", false, 2, null);
        if (findFirstChild$default == null && (findFirstChild$default = Instance.findFirstChild$default(instance, "UpperTorso", false, 2, null)) == null && (findFirstChild$default = this.hrp) == null) {
            return;
        }
        Instance findFirstChild$default2 = Instance.findFirstChild$default(instance, "Left Leg", false, 2, null);
        if (findFirstChild$default2 == null && (findFirstChild$default2 = Instance.findFirstChild$default(instance, "LeftFoot", false, 2, null)) == null) {
            findFirstChild$default2 = findFirstChild$default;
        }
        Pair<Vector3, Vector3> charBox = charBox();
        Vector3 component1 = charBox.component1();
        Vector3 component2 = charBox.component2();
        Vector3 vector3 = new Vector3(0.15f, 0.15f, 0.15f);
        ConvexShape aabbShape = Geometry.INSTANCE.aabbShape(component1, component2.plus(vector3));
        Set<Instance> newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        for (Instance instance2 : query(component1.minus(component2).minus(vector3), component1.plus(component2).plus(vector3), true)) {
            if (isCharacterPart(instance2)) {
                z = false;
            } else if (!Intrinsics.areEqual(instance2.get("CanTouch"), Boolean.valueOf(z))) {
                if (Geometry.INSTANCE.contact(aabbShape, component1.minus(component2).minus(vector3), component1.plus(component2).plus(vector3), instance2) != null) {
                    newSetFromMap.add(instance2);
                }
                z = false;
            }
        }
        Set<Instance> set = this.touching.get(findFirstChild$default);
        List list = set != null ? CollectionsKt.toList(set) : null;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List list2 = list;
        Set<Instance> set2 = this.touching.get(findFirstChild$default2);
        List list3 = set2 != null ? CollectionsKt.toList(set2) : null;
        if (list3 == null) {
            list3 = CollectionsKt.emptyList();
        }
        List<Instance> plus = CollectionsKt.plus((Collection) list2, (Iterable) list3);
        for (Instance instance3 : newSetFromMap) {
            Geometry geometry = Geometry.INSTANCE;
            Intrinsics.checkNotNull(instance3);
            Instance instance4 = geometry.partAabb(instance3).getSecond().getY() < component1.getY() - (component2.getY() * 0.4f) ? findFirstChild$default2 : findFirstChild$default;
            Set<Instance> set3 = this.touching.get(findFirstChild$default);
            if (!(set3 != null && set3.contains(instance3))) {
                Set<Instance> set4 = this.touching.get(findFirstChild$default2);
                if (!(set4 != null && set4.contains(instance3))) {
                    touchBegin(instance4, instance3);
                }
            }
        }
        for (Instance instance5 : plus) {
            if (!newSetFromMap.contains(instance5)) {
                touchEnd(findFirstChild$default, instance5);
                touchEnd(findFirstChild$default2, instance5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance childAdded$lambda$24(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getParent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean childAdded$lambda$25(PlaySession playSession, Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != playSession.dm.getWorkspace();
    }

    private final Avatar.Scales clampScales(Avatar.Scales s) {
        Instance findService = this.dm.findService("StarterPlayer");
        return findService == null ? s : new Avatar.Scales(clampScales$c(findService, s.getHeight(), "Height"), clampScales$c(findService, s.getWidth(), "Width"), clampScales$c(findService, s.getDepth(), "Width"), clampScales$c(findService, s.getHead(), "Head"));
    }

    private static final float clampScales$c(Instance instance, float f, String str) {
        Object obj = instance.get("GameSettingsScaleRange" + str);
        NumberRange numberRange = obj instanceof NumberRange ? (NumberRange) obj : null;
        return numberRange == null ? f : (numberRange.getMax() < numberRange.getMin() || numberRange.getMax() <= 0.0f) ? f : RangesKt.coerceIn(f, numberRange.getMin(), numberRange.getMax());
    }

    private final void collideCharacter() {
        int i;
        Pair<Vector3, Float> contact;
        boolean z = false;
        int i2 = 0;
        while (i2 < 3) {
            Pair<Vector3, Vector3> charBox = charBox();
            Vector3 component1 = charBox.component1();
            Vector3 component2 = charBox.component2();
            ConvexShape aabbShape = Geometry.INSTANCE.aabbShape(component1, component2);
            boolean z2 = false;
            Iterator<Instance> it = query(component1.minus(component2), component1.plus(component2), true).iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = i2;
                    break;
                }
                Instance next = it.next();
                if (Intrinsics.areEqual(next.get("CanCollide"), Boolean.valueOf(z))) {
                    z = false;
                } else if (!isCharacterPart(next) && (contact = Geometry.INSTANCE.contact(aabbShape, component1.minus(component2), component1.plus(component2), next)) != null) {
                    Vector3 component12 = contact.component1();
                    float floatValue = contact.component2().floatValue();
                    float magnitude = component12.getMagnitude();
                    if (magnitude >= 1.0E-4f) {
                        Vector3 div = component12.div(magnitude);
                        if (div.getY() > 0.55f) {
                            i = i2;
                            this.pos = new Vector3(this.pos.getX(), this.pos.getY() + (magnitude / div.getY()), this.pos.getZ());
                            if (this.vel.getY() < 0.0f) {
                                this.vel = new Vector3(this.vel.getX(), 0.0f, this.vel.getZ());
                            }
                            this.grounded = true;
                        } else {
                            i = i2;
                            if (div.getY() < -0.55f) {
                                this.pos = this.pos.plus(component12);
                                if (this.vel.getY() > 0.0f) {
                                    this.vel = new Vector3(this.vel.getX(), 0.0f, this.vel.getZ());
                                }
                            } else {
                                float y = floatValue - (component1.getY() - component2.getY());
                                if (y <= 0.0f || y > 2.1f || this.vel.getY() > 1.0f || this.climbing) {
                                    this.pos = this.pos.plus(new Vector3(component12.getX(), 0.0f, component12.getZ()));
                                } else {
                                    this.pos = new Vector3(this.pos.getX(), this.pos.getY() + y + 0.01f, this.pos.getZ());
                                }
                            }
                        }
                        z2 = true;
                    } else {
                        z = false;
                    }
                }
            }
            if (!z2) {
                return;
            }
            i2 = i + 1;
            z = false;
        }
    }

    private final Vector3 drive(Vector3 v, Vector3 pred, Vector3 want, Vector3 maxF, float mass, float dt) {
        return new Vector3(drive$ax(dt, mass, v.getX(), pred.getX(), want.getX(), maxF.getX()), drive$ax(dt, mass, v.getY(), pred.getY(), want.getY(), maxF.getY()), drive$ax(dt, mass, v.getZ(), pred.getZ(), want.getZ(), maxF.getZ()));
    }

    private static final float drive$ax(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = (f6 * f) / f2;
        return RangesKt.coerceIn(f5 - f4, -f7, f7) + f3;
    }

    private final Vector3 facingVec() {
        return new Vector3(-((float) Math.sin(this.facing)), 0.0f, -((float) Math.cos(this.facing)));
    }

    private final List<RayHit> frontHits() {
        Vector3 facingVec = facingVec();
        float f = this.charHalfXZ + 1.1f;
        ArrayList arrayList = new ArrayList();
        List query$default = query$default(this, this.pos.plus(new Vector3((-f) - 1.0f, this.charMinY, (-f) - 1.0f)), this.pos.plus(new Vector3(f + 1.0f, this.charMaxY, 1.0f + f)), false, 4, null);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : query$default) {
            Instance instance = (Instance) obj;
            boolean z = false;
            List list = query$default;
            if (!Intrinsics.areEqual(instance.get("CanCollide"), (Object) false) && !isCharacterPart(instance)) {
                z = true;
            }
            if (z) {
                arrayList2.add(obj);
            }
            query$default = list;
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        for (float f2 = this.charMinY + 0.3f; f2 <= this.charMaxY - 0.2f; f2 += 0.4f) {
            arrayList.add(Geometry.INSTANCE.raycast(arrayList3, new Vector3(this.pos.getX(), this.pos.getY() + f2, this.pos.getZ()), facingVec, f, new PlaySession$$ExternalSyntheticLambda12()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean frontHits$lambda$89(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    private final float getGravity() {
        Object obj = this.dm.getWorkspace().get("Gravity");
        Number number = obj instanceof Number ? (Number) obj : null;
        if (number != null) {
            return number.floatValue();
        }
        return 196.2f;
    }

    private final Instance getRunService() {
        Instance service = this.dm.getService("RunService");
        service.setArchivable(false);
        return service;
    }

    private final Instance getUisService() {
        Instance service = this.dm.getService("UserInputService");
        service.setArchivable(false);
        return service;
    }

    private final float health() {
        Object obj;
        Instance instance = this.humanoid;
        if (instance != null) {
            obj = instance.get("Health_XML");
            if (obj == null) {
                obj = instance.get("Health");
            }
        } else {
            obj = null;
        }
        Number number = obj instanceof Number ? (Number) obj : null;
        if (number != null) {
            return number.floatValue();
        }
        return 100.0f;
    }

    private final boolean inWorkspace(Instance i) {
        Instance workspace = this.dm.getWorkspace();
        return i != null && (i == workspace || i.isDescendantOf(workspace));
    }

    private final void insertGrid(Instance p) {
        Vector3 vector3;
        Vector3 vector32;
        int[] iArr;
        char c;
        char c2;
        ArrayList<Instance> arrayList;
        int i;
        Pair<Vector3, Vector3> partAabb = Geometry.INSTANCE.partAabb(p);
        Vector3 component1 = partAabb.component1();
        Vector3 component2 = partAabb.component2();
        int[] cellRange = cellRange(component1, component2);
        char c3 = 1;
        char c4 = 4;
        char c5 = 5;
        char c6 = 2;
        long j = ((cellRange[3] - cellRange[0]) + 1) * ((cellRange[4] - cellRange[1]) + 1) * ((cellRange[5] - cellRange[2]) + 1);
        if (j > 512) {
            this.bigParts.add(p);
            this.cellsOf.put(p, new long[0]);
            return;
        }
        long[] jArr = new long[(int) j];
        int i2 = 0;
        int i3 = cellRange[0];
        int i4 = cellRange[3];
        if (i3 <= i4) {
            while (true) {
                int i5 = cellRange[c3];
                int i6 = cellRange[c4];
                if (i5 <= i6) {
                    while (true) {
                        c2 = c5;
                        int i7 = cellRange[c6];
                        int i8 = cellRange[c2];
                        if (i7 <= i8) {
                            while (true) {
                                long cellKey = cellKey(i3, i5, i7);
                                HashMap<Long, ArrayList<Instance>> hashMap = this.grid;
                                vector3 = component2;
                                Long valueOf = Long.valueOf(cellKey);
                                ArrayList<Instance> arrayList2 = hashMap.get(valueOf);
                                if (arrayList2 == null) {
                                    vector32 = component1;
                                    iArr = cellRange;
                                    c = 4;
                                    arrayList = new ArrayList<>(4);
                                    hashMap.put(valueOf, arrayList);
                                } else {
                                    vector32 = component1;
                                    iArr = cellRange;
                                    c = 4;
                                    arrayList = arrayList2;
                                }
                                arrayList.add(p);
                                i = i2 + 1;
                                jArr[i2] = cellKey;
                                if (i7 == i8) {
                                    break;
                                }
                                i7++;
                                i2 = i;
                                component2 = vector3;
                                component1 = vector32;
                                cellRange = iArr;
                            }
                            i2 = i;
                        } else {
                            vector3 = component2;
                            vector32 = component1;
                            iArr = cellRange;
                            c = c4;
                        }
                        if (i5 == i6) {
                            break;
                        }
                        i5++;
                        c4 = c;
                        c5 = c2;
                        component2 = vector3;
                        component1 = vector32;
                        cellRange = iArr;
                        c6 = 2;
                    }
                } else {
                    vector3 = component2;
                    vector32 = component1;
                    iArr = cellRange;
                    c = c4;
                    c2 = c5;
                }
                if (i3 == i4) {
                    break;
                }
                i3++;
                c4 = c;
                c5 = c2;
                component2 = vector3;
                component1 = vector32;
                cellRange = iArr;
                c3 = 1;
                c6 = 2;
            }
        }
        this.cellsOf.put(p, jArr);
    }

    private final void installBridge() {
        LuaTable luaTable = new LuaTable();
        luaTable.set("setControlsEnabled", LuaTypesKt.fnv(new PlaySession$$ExternalSyntheticLambda8(this)));
        luaTable.set("getMoveVector", LuaTypesKt.fnv(new PlaySession$$ExternalSyntheticLambda9(this)));
        luaTable.set("setShiftLock", LuaTypesKt.fnv(new PlaySession$$ExternalSyntheticLambda10(this)));
        luaTable.set("isShiftLock", LuaTypesKt.fnv(new PlaySession$$ExternalSyntheticLambda11(this)));
        this.rt.getGlobals().set("__MobileStudioPlayer", luaTable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs installBridge$lambda$11(PlaySession playSession, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        playSession.controlsEnabled = a.arg1().toboolean();
        if (!playSession.controlsEnabled) {
            playSession.lastDir = Vector3.INSTANCE.getZERO();
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs installBridge$lambda$12(PlaySession playSession, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        return LuaTypes.INSTANCE.wrap(playSession.controlsEnabled ? new Vector3(playSession.studio.getMoveX(), 0.0f, playSession.studio.getMoveY()) : Vector3.INSTANCE.getZERO());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs installBridge$lambda$13(PlaySession playSession, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        playSession.shiftLock = a.arg1().toboolean();
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs installBridge$lambda$14(PlaySession playSession, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        LuaBoolean valueOf = LuaValue.valueOf(playSession.shiftLock);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    private final boolean isCharacterPart(Instance p) {
        Instance instance = this.character;
        if (instance == null) {
            return false;
        }
        return p.isDescendantOf(instance);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean isRunnable(com.exampletest.mobilestudiotest.model.Instance r14) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.isRunnable(com.exampletest.mobilestudiotest.model.Instance):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance isRunnable$lambda$19(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getParent();
    }

    private static final boolean isRunnable$under(Instance instance, String str) {
        Iterator it = SequencesKt.generateSequence(instance.getParent(), new PlaySession$$ExternalSyntheticLambda3()).iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((Instance) it.next()).getClassName(), str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance isRunnable$under$lambda$17(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getParent();
    }

    private static final boolean isRunnable$underInst(Instance instance, Instance instance2) {
        return instance2 != null && instance.isDescendantOf(instance2);
    }

    private final void lateAvatar() {
        Avatar.Spec current;
        Instance instance;
        Instance instance2;
        if (!this.dressable || this.dead || (current = Avatar.INSTANCE.getCurrent()) == null || this.avatarApplied == Avatar.INSTANCE.getVersion() || (instance = this.character) == null || (instance2 = this.hrp) == null) {
            return;
        }
        if (current.getCharacter() != null) {
            spawnCharacter();
            return;
        }
        if (wantR15(current) || this.isR15) {
            spawnCharacter();
            return;
        }
        this.avatarApplied = Avatar.INSTANCE.getVersion();
        this.writing = true;
        try {
            List<Instance> applyTo = Avatar.INSTANCE.applyTo(instance, current);
            CFrame cframe = PartData.INSTANCE.cframe(instance2);
            for (Instance instance3 : applyTo) {
                this.offsets.put(instance3, cframe.inverse().times(PartData.INSTANCE.cframe(instance3)));
            }
            buildJoints(instance, instance2);
            this.writing = false;
            this.physicsDirty = true;
            Instance instance4 = this.player;
            if (instance4 != null) {
                this.rt.fire(instance4, "CharacterAppearanceLoaded", this.rt.wrap(instance));
            }
        } catch (Throwable th) {
            this.writing = false;
            throw th;
        }
    }

    private final void leaveSeat(boolean jump) {
        Instance instance = this.seated;
        if (instance == null) {
            return;
        }
        this.seated = null;
        this.seatCooldown = 1.0f;
        Instance.set$default(instance, "Occupant", null, false, 4, null);
        Instance instance2 = this.humanoid;
        if (instance2 != null) {
            Instance.set$default(instance2, "Sit", false, false, 4, null);
            LuaRuntime luaRuntime = this.rt;
            LuaBoolean FALSE = LuaValue.FALSE;
            Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            luaRuntime.fire(instance2, "Seated", FALSE, NIL);
        }
        if (jump) {
            Vector3 facingVec = facingVec();
            this.vel = new Vector3(facingVec.getX() * 4.0f, 45.0f, facingVec.getZ() * 4.0f);
            this.pos = this.pos.plus(new Vector3(0.0f, 0.5f, 0.0f));
        }
        setState("Jumping", 3);
    }

    private final void loadCharacterTemplate(byte[] bytes) {
        Instance create;
        try {
            try {
                List<Instance> roots = RbxFile.INSTANCE.read(bytes).getRoots();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = roots.iterator();
                while (true) {
                    boolean z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    Instance instance = (Instance) next;
                    if (!instance.isA("Model") && !instance.isA("BasePart") && !Intrinsics.areEqual(instance.getClassName(), "Folder")) {
                        z = false;
                    }
                    if (z) {
                        arrayList.add(next);
                    }
                }
                ArrayList<Instance> arrayList2 = arrayList;
                if (arrayList2.isEmpty()) {
                    OutputLog.INSTANCE.warn("Playtest character: the saved file has no model or part");
                    return;
                }
                if (arrayList2.size() != 1 || Intrinsics.areEqual(((Instance) arrayList2.get(0)).getClassName(), "Folder")) {
                    create = InstanceFactory.INSTANCE.create("Model");
                    create.setName(arrayList2.size() == 1 ? ((Instance) arrayList2.get(0)).getName() : "Character");
                    for (Instance instance2 : arrayList2) {
                        if (Intrinsics.areEqual(instance2.getClassName(), "Folder")) {
                            Iterator it2 = CollectionsKt.toList(instance2.getChildren()).iterator();
                            while (it2.hasNext()) {
                                ((Instance) it2.next()).attachRaw(create);
                            }
                        } else {
                            instance2.attachRaw(create);
                        }
                    }
                } else {
                    create = (Instance) arrayList2.get(0);
                }
                makePlayAs(create, false);
                if (this.playAsTemplate != null) {
                    OutputLog.INSTANCE.info("Playing as " + create.getName() + " (File → Playtest Avatar)");
                }
            } catch (Exception e) {
                e = e;
                OutputLog.INSTANCE.warn("Playtest character: couldn't read the saved model (" + e.getMessage() + ")");
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void makePlayAs(com.exampletest.mobilestudiotest.model.Instance r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.makePlayAs(com.exampletest.mobilestudiotest.model.Instance, boolean):void");
    }

    static /* synthetic */ void makePlayAs$default(PlaySession playSession, Instance instance, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        playSession.makePlayAs(instance, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void measure(com.exampletest.mobilestudiotest.engine.PlaySession.Body r19) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.measure(com.exampletest.mobilestudiotest.engine.PlaySession$Body):void");
    }

    private final void motor(String name, float desired, float maxVel, float dt) {
        Float f = this.motorAngle.get(name);
        float floatValue = f != null ? f.floatValue() : 0.0f;
        float f2 = 60.0f * maxVel * dt;
        this.motorAngle.put(name, Float.valueOf(Math.abs(desired - floatValue) <= f2 ? desired : (Math.signum(desired - floatValue) * f2) + floatValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (r4.equals("Button1Up") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r4.equals("WheelBackward") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r4.equals("KeyDown") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r4.equals("WheelForward") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r4.equals("KeyUp") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r4.equals("Move") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        if (r4.equals("Idle") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        if (r4.equals("Button2Down") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        if (r4.equals("Button1Down") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if (r4.equals("Button2Up") != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue mouseValue$lambda$151(com.exampletest.mobilestudiotest.engine.PlaySession r2, org.luaj.vm2.LuaTable r3, org.luaj.vm2.LuaValue r4, org.luaj.vm2.LuaValue r5) {
        /*
            java.lang.String r0 = "<unused var>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = "k"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            java.lang.String r4 = r5.tojstring()
            if (r4 == 0) goto Lbe
            int r0 = r4.hashCode()
            switch(r0) {
                case -1891370348: goto Lab;
                case -268889839: goto L97;
                case -135444383: goto L84;
                case -134520862: goto L7b;
                case 73783: goto L67;
                case 2274292: goto L5e;
                case 2404337: goto L55;
                case 72391994: goto L4b;
                case 136075018: goto L41;
                case 848725889: goto L37;
                case 1562021950: goto L2d;
                case 2015499802: goto L23;
                case 2015500763: goto L19;
                default: goto L17;
            }
        L17:
            goto Lbe
        L19:
            java.lang.String r0 = "Button2Up"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbe
            goto L8c
        L23:
            java.lang.String r0 = "Button1Up"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L8c
            goto Lbe
        L2d:
            java.lang.String r0 = "WheelBackward"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L8c
            goto Lbe
        L37:
            java.lang.String r0 = "KeyDown"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L8c
            goto Lbe
        L41:
            java.lang.String r0 = "WheelForward"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L8c
            goto Lbe
        L4b:
            java.lang.String r0 = "KeyUp"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L8c
            goto Lbe
        L55:
            java.lang.String r0 = "Move"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L8c
            goto Lbe
        L5e:
            java.lang.String r0 = "Idle"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L8c
            goto Lbe
        L67:
            java.lang.String r0 = "IsA"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbe
            com.exampletest.mobilestudiotest.engine.PlaySession$$ExternalSyntheticLambda5 r0 = new com.exampletest.mobilestudiotest.engine.PlaySession$$ExternalSyntheticLambda5
            r0.<init>()
            org.luaj.vm2.lib.VarArgFunction r0 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(r0)
            org.luaj.vm2.LuaValue r0 = (org.luaj.vm2.LuaValue) r0
            goto Lc5
        L7b:
            java.lang.String r0 = "Button2Down"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L8c
            goto Lbe
        L84:
            java.lang.String r0 = "Button1Down"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbe
        L8c:
            com.exampletest.mobilestudiotest.lua.LuaRuntime r0 = r2.rt
            com.exampletest.mobilestudiotest.lua.InstanceApi r0 = r0.getApi()
            org.luaj.vm2.LuaValue r0 = r0.signal(r3, r4)
            goto Lc5
        L97:
            java.lang.String r0 = "GetPropertyChangedSignal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbe
            com.exampletest.mobilestudiotest.engine.PlaySession$$ExternalSyntheticLambda6 r0 = new com.exampletest.mobilestudiotest.engine.PlaySession$$ExternalSyntheticLambda6
            r0.<init>(r2, r3)
            org.luaj.vm2.lib.VarArgFunction r0 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(r0)
            org.luaj.vm2.LuaValue r0 = (org.luaj.vm2.LuaValue) r0
            goto Lc5
        Lab:
            java.lang.String r0 = "Changed"
            boolean r1 = r4.equals(r0)
            if (r1 == 0) goto Lbe
            com.exampletest.mobilestudiotest.lua.LuaRuntime r1 = r2.rt
            com.exampletest.mobilestudiotest.lua.InstanceApi r1 = r1.getApi()
            org.luaj.vm2.LuaValue r0 = r1.signal(r3, r0)
            goto Lc5
        Lbe:
            org.luaj.vm2.LuaValue r0 = org.luaj.vm2.LuaValue.NIL
            java.lang.String r1 = "NIL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        Lc5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.mouseValue$lambda$151(com.exampletest.mobilestudiotest.engine.PlaySession, org.luaj.vm2.LuaTable, org.luaj.vm2.LuaValue, org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs mouseValue$lambda$151$lambda$149(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaBoolean valueOf = LuaValue.valueOf(SetsKt.setOf((Object[]) new String[]{"Mouse", "PlayerMouse", "Instance"}).contains(a.arg(2).tojstring()));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs mouseValue$lambda$151$lambda$150(PlaySession playSession, LuaTable luaTable, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return playSession.rt.getApi().signal(luaTable, "Changed:" + a.arg(2).tojstring());
    }

    private final float num(Instance i, String n, float d) {
        Object obj = i.get(n);
        Number number = obj instanceof Number ? (Number) obj : null;
        return number != null ? number.floatValue() : d;
    }

    private final float[] physProps(int mat) {
        switch (mat) {
            case 256:
            case 288:
                return new float[]{0.7f, 0.3f, 0.5f};
            case ClothingCompositor.TORSO_H /* 272 */:
                return new float[]{0.7f, 0.2f, 0.5f};
            case 512:
            case 528:
                return new float[]{0.35f, 0.48f, 0.2f};
            case 784:
                return new float[]{2.56f, 0.2f, 0.17f};
            case 788:
            case 800:
            case 804:
            case 820:
            case 832:
            case 836:
            case 880:
            case 896:
            case 912:
                return new float[]{2.69f, 0.4f, 0.2f};
            case 816:
                return new float[]{2.4f, 0.7f, 0.2f};
            case 848:
                return new float[]{1.92f, 0.8f, 0.15f};
            case 864:
                return new float[]{2.4f, 0.4f, 0.17f};
            case 1040:
            case 1088:
                return new float[]{7.85f, 0.4f, 0.25f};
            case 1056:
                return new float[]{7.85f, 0.35f, 0.25f};
            case 1072:
                return new float[]{2.7f, 0.4f, 0.25f};
            case 1280:
            case 1284:
            case 1344:
            case 1360:
                return new float[]{0.9f, 0.4f, 0.1f};
            case 1296:
                return new float[]{1.6f, 0.5f, 0.05f};
            case 1312:
                return new float[]{0.7f, 0.35f, 0.05f};
            case 1328:
                return new float[]{0.9f, 0.3f, 0.03f};
            case 1376:
                return new float[]{2.36f, 0.8f, 0.2f};
            case 1392:
                return new float[]{2.16f, 0.5f, 0.05f};
            case 1536:
            case 1552:
                return new float[]{0.919f, 0.02f, 0.15f};
            case 1568:
                return new float[]{2.4f, 0.25f, 0.2f};
            case 2311:
                return new float[]{1.3f, 1.5f, 0.95f};
            default:
                return new float[]{0.7f, 0.3f, 0.5f};
        }
    }

    private final boolean physicsRelevant(Instance i) {
        if (i.isA("BasePart") || i.isA("JointInstance") || Intrinsics.areEqual(i.getClassName(), "WeldConstraint") || i.isA("Constraint") || i.isA("BodyMover") || Intrinsics.areEqual(i.getClassName(), "Attachment") || i.isA("Humanoid")) {
            return true;
        }
        Iterator<Instance> it = i.getChildren().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            if (physicsRelevant(it.next())) {
                return true;
            }
        }
        return false;
    }

    private final String pose() {
        return this.seated != null ? "Seated" : this.climbing ? "Climbing" : (this.grounded || (this.jumpAnimTime <= 0.0f && this.vel.getY() <= 0.5f) || this.airTime >= 0.4f) ? (this.grounded || this.airTime <= 0.1f) ? ((float) Math.sqrt((double) ((this.vel.getX() * this.vel.getX()) + (this.vel.getZ() * this.vel.getZ())))) > 0.5f ? "Running" : "Standing" : "FreeFall" : "Jumping";
    }

    private final void poseRig(Instance rig, AnimPlayer p) {
        Pair<Instance, List<RigJoint>> pair;
        CFrame.Companion companion;
        CFrame cFrame;
        CFrame times;
        IdentityHashMap<Instance, Pair<Instance, List<RigJoint>>> identityHashMap = this.rigJoints;
        Pair<Instance, List<RigJoint>> pair2 = identityHashMap.get(rig);
        if (pair2 == null) {
            pair = buildRig(rig);
            if (pair == null) {
                return;
            } else {
                identityHashMap.put(rig, pair);
            }
        } else {
            pair = pair2;
        }
        Pair<Instance, List<RigJoint>> pair3 = pair;
        Instance component1 = pair3.component1();
        List<RigJoint> component2 = pair3.component2();
        if (component1.getParent() == null) {
            this.rigJoints.remove(rig);
            return;
        }
        IdentityHashMap identityHashMap2 = new IdentityHashMap();
        identityHashMap2.put(component1, PartData.INSTANCE.cframe(component1));
        this.writing = true;
        try {
            for (RigJoint rigJoint : component2) {
                CFrame cFrame2 = (CFrame) identityHashMap2.get(rigJoint.getP0());
                if (cFrame2 != null) {
                    if (rigJoint.getFixed() != null) {
                        times = cFrame2.times(rigJoint.getFixed());
                    } else {
                        Object obj = rigJoint.getInst().get("C0");
                        CFrame cFrame3 = obj instanceof CFrame ? (CFrame) obj : null;
                        if (cFrame3 == null) {
                            cFrame3 = CFrame.INSTANCE.getIDENTITY();
                        }
                        Object obj2 = rigJoint.getInst().get("C1");
                        CFrame cFrame4 = obj2 instanceof CFrame ? (CFrame) obj2 : null;
                        if (cFrame4 == null) {
                            cFrame4 = CFrame.INSTANCE.getIDENTITY();
                        }
                        CFrame times2 = cFrame2.times(cFrame3);
                        if (rigJoint.getMotor()) {
                            try {
                                cFrame = p.transform(rigJoint.getP1().getName());
                                if (cFrame == null) {
                                    companion = CFrame.INSTANCE;
                                }
                                times = times2.times(cFrame).times(cFrame4.inverse());
                            } catch (Throwable th) {
                                th = th;
                                this.writing = false;
                                throw th;
                            }
                        } else {
                            companion = CFrame.INSTANCE;
                        }
                        cFrame = companion.getIDENTITY();
                        times = times2.times(cFrame).times(cFrame4.inverse());
                    }
                    identityHashMap2.put(rigJoint.getP1(), times);
                    Instance.set$default(rigJoint.getP1(), "CFrame", times, false, 4, null);
                }
            }
            this.writing = false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final List<Instance> query(Vector3 a, Vector3 b, boolean withBodies) {
        int i;
        int i2;
        int[] cellRange = cellRange(a, b);
        ArrayList arrayList = new ArrayList();
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Iterator<Instance> it = this.bigParts.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            if (newSetFromMap.add(next)) {
                arrayList.add(next);
            }
        }
        char c = 1;
        char c2 = 4;
        char c3 = 5;
        if (((cellRange[3] - cellRange[0]) + 1) * ((cellRange[4] - cellRange[1]) + 1) * ((cellRange[5] - cellRange[2]) + 1) <= 4096 && (i = cellRange[0]) <= (i2 = cellRange[3])) {
            while (true) {
                int i3 = cellRange[c];
                int i4 = cellRange[c2];
                if (i3 <= i4) {
                    while (true) {
                        int i5 = cellRange[2];
                        int i6 = cellRange[c3];
                        if (i5 <= i6) {
                            while (true) {
                                ArrayList<Instance> arrayList2 = this.grid.get(Long.valueOf(cellKey(i, i3, i5)));
                                if (arrayList2 != null) {
                                    Iterator<Instance> it2 = arrayList2.iterator();
                                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                                    while (it2.hasNext()) {
                                        Instance next2 = it2.next();
                                        if (newSetFromMap.add(next2)) {
                                            arrayList.add(next2);
                                        }
                                    }
                                }
                                if (i5 == i6) {
                                    break;
                                }
                                i5++;
                            }
                        }
                        if (i3 == i4) {
                            break;
                        }
                        i3++;
                        c3 = 5;
                    }
                }
                if (i == i2) {
                    break;
                }
                i++;
                c2 = 4;
                c = 1;
                c3 = 5;
            }
        }
        if (withBodies) {
            Iterator<Body> it3 = this.bodies.iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                Body next3 = it3.next();
                Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                Body body = next3;
                if (!body.getHasBox() || Geometry.INSTANCE.aabbOverlap(a, b, body.getMin(), body.getMax(), 0.5f)) {
                    for (Instance instance : body.getParts()) {
                        if (newSetFromMap.add(instance)) {
                            arrayList.add(instance);
                        }
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            Pair<Vector3, Vector3> partAabb = Geometry.INSTANCE.partAabb((Instance) obj);
            if (Geometry.INSTANCE.aabbOverlap(a, b, partAabb.component1(), partAabb.component2(), 0.05f)) {
                arrayList3.add(obj);
            }
        }
        return arrayList3;
    }

    static /* synthetic */ List query$default(PlaySession playSession, Vector3 vector3, Vector3 vector32, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return playSession.query(vector3, vector32, z);
    }

    private final void rebuildPhysics() {
        Iterator it;
        ArrayList arrayList;
        boolean z;
        boolean z2;
        boolean z3;
        IdentityHashMap identityHashMap;
        Object obj;
        Instance instance;
        Instance instance2;
        List<Instance> list;
        Iterator it2;
        this.physicsDirty = false;
        IdentityHashMap identityHashMap2 = new IdentityHashMap();
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Iterator<Body> it3 = this.bodies.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Body next = it3.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Body body = next;
            for (Instance instance3 : body.getParts()) {
                identityHashMap2.put(instance3, body.getVel());
                if (body.getSleeping()) {
                    newSetFromMap.add(instance3);
                }
            }
        }
        this.bodies.clear();
        this.bodyOf.clear();
        this.statics.clear();
        this.grid.clear();
        this.cellsOf.clear();
        this.bigParts.clear();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Instance workspace = this.dm.getWorkspace();
        List<Instance> renderParts = this.studio.renderParts();
        boolean z4 = true;
        List<Instance> descendants$default = Instance.descendants$default(workspace, null, 1, null);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : descendants$default) {
            boolean z5 = z4;
            if (Intrinsics.areEqual(((Instance) obj2).getClassName(), "ProximityPrompt")) {
                arrayList2.add(obj2);
            }
            z4 = z5;
        }
        boolean z6 = z4;
        this.prompts = new ArrayList<>(arrayList2);
        IdentityHashMap identityHashMap3 = new IdentityHashMap();
        Set<Instance> newSetFromMap2 = Collections.newSetFromMap(new IdentityHashMap());
        for (Instance instance4 : renderParts) {
            if (!isCharacterPart(instance4) && !Intrinsics.areEqual(instance4.getClassName(), "Terrain")) {
                if (this.equipped != null) {
                    Instance instance5 = this.equipped;
                    Intrinsics.checkNotNull(instance5);
                    if (instance4.isDescendantOf(instance5)) {
                    }
                }
                newSetFromMap2.add(instance4);
            }
        }
        Iterator it4 = descendants$default.iterator();
        while (it4.hasNext()) {
            Instance instance6 = (Instance) it4.next();
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Instance instance7 = workspace;
            if (instance6.isA("JointInstance")) {
                Object obj3 = instance6.get("Part0");
                instance = obj3 instanceof Instance ? (Instance) obj3 : null;
                Object obj4 = instance6.get("Part1");
                instance2 = obj4 instanceof Instance ? (Instance) obj4 : null;
                list = renderParts;
                it2 = it4;
            } else {
                list = renderParts;
                it2 = it4;
                if (Intrinsics.areEqual(instance6.getClassName(), "WeldConstraint") && !Intrinsics.areEqual(instance6.get("Enabled"), (Object) false)) {
                    Object obj5 = instance6.get("Part0Internal");
                    if (obj5 == null) {
                        obj5 = instance6.get("Part0");
                    }
                    instance = obj5 instanceof Instance ? (Instance) obj5 : null;
                    Object obj6 = instance6.get("Part1Internal");
                    if (obj6 == null) {
                        obj6 = instance6.get("Part1");
                    }
                    instance2 = obj6 instanceof Instance ? (Instance) obj6 : null;
                } else if (!this.HOLD_TOGETHER.contains(instance6.getClassName()) || Intrinsics.areEqual(instance6.get("Enabled"), (Object) false)) {
                    linkedHashMap = linkedHashMap2;
                    renderParts = list;
                    workspace = instance7;
                    it4 = it2;
                } else {
                    Object obj7 = instance6.get("Attachment0");
                    instance = attPart(obj7 instanceof Instance ? (Instance) obj7 : null);
                    Object obj8 = instance6.get("Attachment1");
                    instance2 = attPart(obj8 instanceof Instance ? (Instance) obj8 : null);
                    if (Intrinsics.areEqual(instance6.getClassName(), "SpringConstraint")) {
                        if (!(instance != null ? Intrinsics.areEqual(instance.get("Anchored"), Boolean.valueOf(z6)) : false)) {
                            if (instance2 != null ? Intrinsics.areEqual(instance2.get("Anchored"), Boolean.valueOf(z6)) : false) {
                            }
                        }
                        linkedHashMap = linkedHashMap2;
                        renderParts = list;
                        workspace = instance7;
                        it4 = it2;
                    }
                }
            }
            if (instance == null || instance2 == null || !newSetFromMap2.contains(instance) || !newSetFromMap2.contains(instance2)) {
                linkedHashMap = linkedHashMap2;
                renderParts = list;
                workspace = instance7;
                it4 = it2;
            } else {
                rebuildPhysics$union(identityHashMap3, instance, instance2);
                linkedHashMap = linkedHashMap2;
                renderParts = list;
                workspace = instance7;
                it4 = it2;
            }
        }
        LinkedHashMap linkedHashMap3 = linkedHashMap;
        for (Instance instance8 : newSetFromMap2) {
            LinkedHashMap linkedHashMap4 = linkedHashMap3;
            Intrinsics.checkNotNull(instance8);
            Instance rebuildPhysics$find = rebuildPhysics$find(identityHashMap3, instance8);
            Object obj9 = linkedHashMap4.get(rebuildPhysics$find);
            if (obj9 == null) {
                obj = new ArrayList();
                identityHashMap = identityHashMap3;
                linkedHashMap4.put(rebuildPhysics$find, obj);
            } else {
                identityHashMap = identityHashMap3;
                obj = obj9;
            }
            ((ArrayList) obj).add(instance8);
            identityHashMap3 = identityHashMap;
        }
        Iterator it5 = linkedHashMap3.entrySet().iterator();
        while (it5.hasNext()) {
            ArrayList arrayList3 = (ArrayList) ((Map.Entry) it5.next()).getValue();
            ArrayList arrayList4 = arrayList3;
            if ((arrayList4 instanceof Collection) && arrayList4.isEmpty()) {
                it = it5;
                arrayList = arrayList3;
                z = false;
            } else {
                Iterator it6 = arrayList4.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        it = it5;
                        arrayList = arrayList3;
                        z = false;
                        break;
                    } else {
                        it = it5;
                        arrayList = arrayList3;
                        if (Intrinsics.areEqual(((Instance) it6.next()).get("Anchored"), Boolean.valueOf(z6))) {
                            z = z6;
                            break;
                        } else {
                            it5 = it;
                            arrayList3 = arrayList;
                        }
                    }
                }
            }
            if (z) {
                this.statics.addAll(arrayList);
                it5 = it;
            } else {
                ArrayList arrayList5 = arrayList;
                Vector3 vector3 = (Vector3) identityHashMap2.get(CollectionsKt.first((List) arrayList));
                if (vector3 == null) {
                    vector3 = Vector3.INSTANCE.getZERO();
                }
                Body body2 = new Body(arrayList5, vector3);
                measure(body2);
                ArrayList arrayList6 = arrayList;
                if (!(arrayList6 instanceof Collection) || !arrayList6.isEmpty()) {
                    Iterator it7 = arrayList6.iterator();
                    while (true) {
                        if (it7.hasNext()) {
                            if (!newSetFromMap.contains((Instance) it7.next())) {
                                z2 = false;
                                break;
                            }
                        } else {
                            z2 = z6;
                            break;
                        }
                    }
                } else {
                    z2 = z6;
                }
                if (z2) {
                    z3 = z6;
                    body2.setSleeping(z3);
                } else {
                    z3 = z6;
                }
                this.bodies.add(body2);
                Iterator it8 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it8, "iterator(...)");
                while (it8.hasNext()) {
                    this.bodyOf.put((Instance) it8.next(), body2);
                }
                z6 = z3;
                it5 = it;
            }
        }
        for (Instance instance9 : this.statics) {
            Intrinsics.checkNotNull(instance9);
            insertGrid(instance9);
        }
        this.movers.clear();
        for (Instance instance10 : descendants$default) {
            if (this.MOVER_CLASSES.contains(instance10.getClassName()) && !Intrinsics.areEqual(instance10.get("Enabled"), (Object) false)) {
                this.movers.add(instance10);
            }
        }
    }

    private static final Instance rebuildPhysics$find(IdentityHashMap<Instance, Instance> identityHashMap, Instance instance) {
        Instance instance2 = instance;
        while (true) {
            Instance instance3 = identityHashMap.get(instance2);
            if (instance3 == null || instance3 == instance2) {
                return instance2;
            }
            instance2 = instance3;
        }
    }

    private static final void rebuildPhysics$union(IdentityHashMap<Instance, Instance> identityHashMap, Instance instance, Instance instance2) {
        Instance rebuildPhysics$find = rebuildPhysics$find(identityHashMap, instance);
        Instance rebuildPhysics$find2 = rebuildPhysics$find(identityHashMap, instance2);
        if (rebuildPhysics$find != rebuildPhysics$find2) {
            identityHashMap.put(rebuildPhysics$find, rebuildPhysics$find2);
        }
    }

    private final void removeGrid(Instance p) {
        long[] remove = this.cellsOf.remove(p);
        if (remove == null) {
            return;
        }
        if (remove.length == 0) {
            this.bigParts.remove(p);
        }
        for (long j : remove) {
            ArrayList<Instance> arrayList = this.grid.get(Long.valueOf(j));
            if (arrayList != null) {
                arrayList.remove(p);
            }
        }
    }

    private final void resetGui(boolean initial) {
        Instance findFirstChild$default;
        ArrayList<Instance> children;
        Instance instance = this.player;
        if (instance == null || (findFirstChild$default = Instance.findFirstChild$default(instance, "PlayerGui", false, 2, null)) == null) {
            return;
        }
        if (!initial) {
            for (Instance instance2 : CollectionsKt.toList(findFirstChild$default.getChildren())) {
                if (!Intrinsics.areEqual(instance2.get("ResetOnSpawn"), (Object) false)) {
                    instance2.destroy();
                }
            }
        }
        Instance findService = this.dm.findService("StarterGui");
        if (findService == null || (children = findService.getChildren()) == null) {
            return;
        }
        for (Instance instance3 : children) {
            if (initial || !Intrinsics.areEqual(instance3.get("ResetOnSpawn"), (Object) false)) {
                Instance.setParent$default(instance3.cloneTree(), findFirstChild$default, 0, 2, null);
            }
        }
    }

    private final float respawnTime() {
        Instance findService = this.dm.findService("Players");
        Object obj = findService != null ? findService.get("RespawnTime") : null;
        Number number = obj instanceof Number ? (Number) obj : null;
        if (number != null) {
            return number.floatValue();
        }
        return 5.0f;
    }

    private final Instance rigOf(Instance owner) {
        Instance parent = owner.getParent();
        if (Intrinsics.areEqual(owner.getClassName(), "Animator")) {
            parent = parent != null ? parent.getParent() : null;
        }
        if (parent == null) {
            return null;
        }
        Instance instance = parent;
        if (instance.isA("Model") || instance.isA("BasePart") || Intrinsics.areEqual(instance.getClassName(), "WorldModel")) {
            return parent;
        }
        return null;
    }

    private final void setR15(String name, float x, float y, float z, float rate, float dt) {
        float[] fArr;
        HashMap<String, float[]> hashMap = this.r15Pose;
        float[] fArr2 = hashMap.get(name);
        if (fArr2 == null) {
            fArr = new float[]{0.0f, 0.0f, 0.0f};
            hashMap.put(name, fArr);
        } else {
            fArr = fArr2;
        }
        float[] fArr3 = fArr;
        fArr3[0] = approach(fArr3[0], x, rate, dt);
        fArr3[1] = approach(fArr3[1], y, rate, dt);
        fArr3[2] = approach(fArr3[2], z, rate, dt);
    }

    static /* synthetic */ void setR15$default(PlaySession playSession, String str, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        if ((i & 8) != 0) {
            f3 = 0.0f;
        }
        playSession.setR15(str, f, f2, f3, f4, f5);
    }

    private final void setState(String name, int value) {
        Instance instance;
        Integer num;
        if (Intrinsics.areEqual(name, this.lastState) || (instance = this.humanoid) == null) {
            return;
        }
        LinkedHashMap<String, Integer> linkedHashMap = Enums.INSTANCE.getTypes().get("HumanoidStateType");
        this.rt.fire(instance, "StateChanged", LuaTypes.INSTANCE.wrap(new EnumItemV("HumanoidStateType", this.lastState, (linkedHashMap == null || (num = linkedHashMap.get(this.lastState)) == null) ? 8 : num.intValue())), LuaTypes.INSTANCE.wrap(new EnumItemV("HumanoidStateType", name, value)));
        this.lastState = name;
    }

    private final void setupTextChat() {
        Instance service = this.dm.getService("TextChatService");
        Instance findFirstChild$default = Instance.findFirstChild$default(service, "TextChannels", false, 2, null);
        if (findFirstChild$default == null) {
            findFirstChild$default = InstanceFactory.INSTANCE.create("Folder");
            findFirstChild$default.setName("TextChannels");
            findFirstChild$default.setArchivable(false);
            findFirstChild$default.attachRaw(service);
        }
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"RBXGeneral", "RBXSystem"})) {
            if (Instance.findFirstChild$default(findFirstChild$default, str, false, 2, null) == null) {
                Instance create = InstanceFactory.INSTANCE.create("TextChannel");
                create.setName(str);
                create.setArchivable(false);
                create.attachRaw(findFirstChild$default);
            }
        }
    }

    private final void solveDistanceConstraints() {
        Vector3 attWorld;
        boolean z;
        float f;
        Pair pair;
        float f2;
        PlaySession playSession = this;
        if (playSession.movers.isEmpty()) {
            return;
        }
        int i = 0;
        while (i < 4) {
            Iterator<Instance> it = playSession.movers.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Instance next = it.next();
                if (next.getParent() == null) {
                    playSession = this;
                } else if (!Intrinsics.areEqual(next.get("Enabled"), (Object) false)) {
                    boolean areEqual = Intrinsics.areEqual(next.getClassName(), "RopeConstraint");
                    boolean areEqual2 = Intrinsics.areEqual(next.getClassName(), "RodConstraint");
                    boolean z2 = Intrinsics.areEqual(next.getClassName(), "SpringConstraint") && Intrinsics.areEqual(next.get("LimitsEnabled"), (Object) true);
                    if (areEqual || areEqual2 || z2) {
                        Object obj = next.get("Attachment0");
                        Instance instance = obj instanceof Instance ? (Instance) obj : null;
                        Object obj2 = next.get("Attachment1");
                        Instance instance2 = obj2 instanceof Instance ? (Instance) obj2 : null;
                        Vector3 attWorld2 = playSession.attWorld(instance);
                        if (attWorld2 != null && (attWorld = playSession.attWorld(instance2)) != null) {
                            End end = new End(playSession.attPart(instance));
                            End end2 = new End(playSession.attPart(instance2));
                            if (end.getBody() != null) {
                                z = true;
                                if (end.getBody() != end2.getBody()) {
                                }
                            } else {
                                z = true;
                            }
                            float invMass = end.getInvMass() + end2.getInvMass();
                            if (invMass == 0.0f ? z : false) {
                                playSession = this;
                            } else {
                                Vector3 minus = attWorld.minus(attWorld2);
                                float magnitude = minus.getMagnitude();
                                if (magnitude >= 1.0E-4f) {
                                    int i2 = i;
                                    Vector3 div = minus.div(magnitude);
                                    Iterator<Instance> it2 = it;
                                    if (areEqual) {
                                        f = magnitude;
                                        if (Intrinsics.areEqual(next.get("WinchEnabled"), Boolean.valueOf(z)) && i2 == 0) {
                                            float num = playSession.num(next, "Length", 5.0f);
                                            float num2 = playSession.num(next, "WinchTarget", num);
                                            float num3 = playSession.num(next, "WinchSpeed", 2.0f) / 60.0f;
                                            next.set("Length", Float.valueOf(Math.abs(num2 - num) <= num3 ? num2 : num + (Math.signum(num2 - num) * num3)), false);
                                        }
                                        pair = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(playSession.num(next, "Length", 5.0f)));
                                    } else {
                                        f = magnitude;
                                        if (areEqual2) {
                                            float num4 = playSession.num(next, "Length", 5.0f);
                                            pair = TuplesKt.to(Float.valueOf(num4), Float.valueOf(num4));
                                        } else {
                                            pair = TuplesKt.to(Float.valueOf(playSession.num(next, "MinLength", 0.0f)), Float.valueOf(playSession.num(next, "MaxLength", 5.0f)));
                                        }
                                    }
                                    float floatValue = ((Number) pair.component1()).floatValue();
                                    float floatValue2 = ((Number) pair.component2()).floatValue();
                                    float f3 = f > floatValue2 ? f - floatValue2 : f < floatValue ? f - floatValue : 0.0f;
                                    if (f3 != 0.0f) {
                                        z = false;
                                    }
                                    if (z) {
                                        playSession = this;
                                        i = i2;
                                        it = it2;
                                    } else {
                                        end.move(div.times((end.getInvMass() * f3) / invMass));
                                        end2.move(div.times(((-f3) * end2.getInvMass()) / invMass));
                                        float dot = end2.getV().minus(end.getV()).dot(div);
                                        if ((f3 <= 0.0f || dot <= 0.0f) && (f3 >= 0.0f || dot >= 0.0f)) {
                                            playSession = this;
                                            i = i2;
                                            it = it2;
                                        } else {
                                            float f4 = 1.0f;
                                            if (areEqual) {
                                                f2 = dot;
                                                f4 = playSession.num(next, "Restitution", 0.0f) + 1.0f;
                                            } else {
                                                f2 = dot;
                                            }
                                            float f5 = (f2 * f4) / invMass;
                                            end.setV(end.getV().plus(div.times(f5 * end.getInvMass())));
                                            end2.setV(end2.getV().minus(div.times(end2.getInvMass() * f5)));
                                            playSession = this;
                                            i = i2;
                                            it = it2;
                                        }
                                    }
                                } else {
                                    playSession = this;
                                }
                            }
                        }
                    }
                }
            }
            i++;
            playSession = this;
        }
    }

    private final void startTrack(ScriptTrack st) {
        AnimPlayer animPlayer;
        AnimClip clip = st.getClip();
        if (clip == null) {
            return;
        }
        IdentityHashMap<Instance, AnimPlayer> identityHashMap = this.rigPlayers;
        Instance rig = st.getRig();
        AnimPlayer animPlayer2 = identityHashMap.get(rig);
        if (animPlayer2 == null) {
            animPlayer = new AnimPlayer();
            identityHashMap.put(rig, animPlayer);
        } else {
            animPlayer = animPlayer2;
        }
        AnimPlayer animPlayer3 = animPlayer;
        float fade = st.getFade();
        float weight = st.getWeight();
        float speed = st.getSpeed();
        AnimPlayer.Companion companion = AnimPlayer.INSTANCE;
        Integer priority = st.getPriority();
        AnimPlayer.Track play = animPlayer3.play(clip, "script", fade, weight, speed, companion.rank(priority != null ? priority.intValue() : clip.getPriority()));
        Boolean looped = st.getLooped();
        if (looped != null) {
            play.setLooped(looped.booleanValue());
        }
        st.setTrack(play);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void stepBodies(float r34) {
        /*
            Method dump skipped, instructions count: 1550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.stepBodies(float):void");
    }

    private final void stepBubbles(float dt) {
        if (this.bubbles.isEmpty()) {
            return;
        }
        Iterator<Bubble> it = this.bubbles.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Bubble next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Bubble bubble = next;
            bubble.setAge(bubble.getAge() + dt);
            if (bubble.getAge() > 12.0f || bubble.getPart().getParent() == null) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v5, types: [T] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r1v57, types: [T, com.exampletest.mobilestudiotest.model.Vector3] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r8v26, types: [T] */
    /* JADX WARN: Type inference failed for: r8v36, types: [T, com.exampletest.mobilestudiotest.model.Vector3] */
    /* JADX WARN: Type inference failed for: r8v63 */
    /* JADX WARN: Type inference failed for: r8v64 */
    private final void stepCharacter(float dt) {
        Instance instance;
        float floatValue;
        boolean z;
        float f;
        float f2;
        boolean z2;
        Instance instance2 = this.hrp;
        if (instance2 == null || (instance = this.humanoid) == null) {
            return;
        }
        Instance instance3 = this.character;
        if (((instance3 != null ? instance3.getParent() : null) == null || instance2.getParent() == null) && !this.dead) {
            this.dead = true;
            this.deadTimer = respawnTime();
        }
        if (!this.dead && health() <= 0.0f) {
            this.dead = true;
            this.deadTimer = respawnTime();
            leaveSeat(false);
            this.rt.fire(instance, "Died", new LuaValue[0]);
            setState("Dead", 15);
            OutputLog outputLog = OutputLog.INSTANCE;
            Instance instance4 = this.player;
            outputLog.info((instance4 != null ? instance4.getName() : null) + " died");
            if (!Intrinsics.areEqual(instance.get("BreakJointsOnDeath"), (Object) false)) {
                breakApart();
            }
        }
        if (this.dead) {
            stepDebris(dt);
            this.deadTimer -= dt;
            if (this.deadTimer <= 0.0f) {
                Instance findService = this.dm.findService("Players");
                if (findService != null ? Intrinsics.areEqual(findService.get("CharacterAutoLoads"), (Object) false) : false) {
                    return;
                }
                this.debris.clear();
                respawn();
                return;
            }
            return;
        }
        CFrame cframe = PartData.INSTANCE.cframe(instance2);
        CFrame cFrame = this.lastWritten;
        if (cFrame != null && !Intrinsics.areEqual(cframe, cFrame) && this.seated == null) {
            this.pos = cframe.getPosition();
            this.vel = Vector3.INSTANCE.getZERO();
            if (Math.abs(cframe.getLookVector().getY()) < 0.99f) {
                this.facing = (float) Math.atan2(-r8.getX(), -r8.getZ());
                this.renderFacing = this.facing;
            }
        }
        if (Intrinsics.areEqual(instance.get("Sit"), (Object) false) && this.seated != null) {
            leaveSeat(false);
        }
        Object obj = instance.get("WalkSpeed");
        Number number = obj instanceof Number ? (Number) obj : null;
        float floatValue2 = number != null ? number.floatValue() : 16.0f;
        float gravity = getGravity();
        if (Intrinsics.areEqual(instance.get("UseJumpPower"), (Object) false)) {
            float f3 = gravity * 2.0f;
            Object obj2 = instance.get("JumpHeight");
            floatValue = (float) Math.sqrt(f3 * ((obj2 instanceof Number ? (Number) obj2 : null) != null ? r13.floatValue() : 7.2f));
        } else {
            Object obj3 = instance.get("JumpPower");
            Number number2 = obj3 instanceof Number ? (Number) obj3 : null;
            floatValue = number2 != null ? number2.floatValue() : 50.0f;
        }
        float f4 = floatValue;
        Vector3 vector3 = new Vector3(-((float) Math.sin(this.camYaw)), 0.0f, -((float) Math.cos(this.camYaw)));
        Vector3 vector32 = new Vector3((float) Math.cos(this.camYaw), 0.0f, -((float) Math.sin(this.camYaw)));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.controlsEnabled ? vector32.times(this.studio.getMoveX()).plus(vector3.times(-this.studio.getMoveY())) : Vector3.INSTANCE.getZERO();
        if (((Vector3) objectRef.element).getMagnitude() > 1.0f) {
            objectRef.element = ((Vector3) objectRef.element).getUnit();
        }
        Vector3 vector33 = this.scriptMoveDir;
        if (vector33 == null) {
            z = 0;
        } else if (vector33.getMagnitude() > 0.01f) {
            z = 0;
            Vector3 vector34 = new Vector3(vector33.getX(), 0.0f, vector33.getZ());
            float magnitude = vector34.getMagnitude();
            ?? r15 = vector34;
            if (magnitude > 1.0f) {
                r15 = vector34.getUnit();
            }
            objectRef.element = r15;
        } else {
            z = 0;
        }
        Vector3 vector35 = this.moveToTarget;
        if (vector35 != null) {
            f = 0.05f;
            Vector3 vector36 = new Vector3(vector35.getX() - this.pos.getX(), 0.0f, vector35.getZ() - this.pos.getZ());
            if (vector36.getMagnitude() < 1.2f) {
                this.moveToTarget = null;
                LuaRuntime luaRuntime = this.rt;
                LuaValue[] luaValueArr = new LuaValue[1];
                LuaBoolean TRUE = LuaValue.TRUE;
                Intrinsics.checkNotNullExpressionValue(TRUE, "TRUE");
                luaValueArr[z] = TRUE;
                luaRuntime.fire(instance, "MoveToFinished", luaValueArr);
            } else if (((Vector3) objectRef.element).getMagnitude() < 0.05f) {
                objectRef.element = vector36.getUnit();
            }
        } else {
            f = 0.05f;
        }
        this.lastDir = (Vector3) objectRef.element;
        if (this.seated != null) {
            if (!this.jumpRequested) {
                writeCharacter(dt);
                return;
            }
            leaveSeat(true);
        }
        List<RayHit> frontHits = (this.climbing || ((Vector3) objectRef.element).getMagnitude() > 0.1f) ? frontHits() : CollectionsKt.emptyList();
        Vector3 facingVec = facingVec();
        boolean z3 = (((Vector3) objectRef.element).getMagnitude() <= 0.1f || ((Vector3) objectRef.element).getUnit().dot(facingVec) <= 0.3f) ? z : true;
        if (!this.climbing) {
            f2 = gravity;
            if (z3 && canClimb(frontHits, false) && (this.grounded || this.vel.getY() < 5.0f)) {
                this.climbing = true;
                setState("Climbing", 12);
            }
        } else if (this.jumpRequested) {
            this.climbing = z;
            f2 = gravity;
            this.vel = new Vector3((-facingVec.getX()) * 25.0f, f4 * 0.6f, (-facingVec.getZ()) * 25.0f);
            this.jumpRequested = this.jumpHeld;
            setState("Jumping", 3);
            LuaRuntime luaRuntime2 = this.rt;
            LuaBoolean TRUE2 = LuaValue.TRUE;
            Intrinsics.checkNotNullExpressionValue(TRUE2, "TRUE");
            luaRuntime2.fire(instance, "Jumping", TRUE2);
        } else {
            f2 = gravity;
            boolean z4 = z;
            if (!canClimb(frontHits, true)) {
                this.climbing = z4;
                if (this.vel.getY() > 0.0f) {
                    this.vel = new Vector3(facingVec.getX() * 8.0f, 22.0f, facingVec.getZ() * 8.0f);
                }
                setState("Freefall", 5);
            }
        }
        if (this.climbing) {
            float dot = 0.7f * floatValue2 * (((Vector3) objectRef.element).getMagnitude() > f ? ((Vector3) objectRef.element).dot(facingVec) : 0.0f);
            this.vel = new Vector3(facingVec.getX() * 2.0f, dot, facingVec.getZ() * 2.0f);
            if (Math.abs(dot) > 0.1f) {
                LuaRuntime luaRuntime3 = this.rt;
                LuaNumber valueOf = LuaValue.valueOf(dot);
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                z2 = false;
                luaRuntime3.fire(instance, "Climbing", valueOf);
            } else {
                z2 = false;
            }
            this.grounded = z2;
        } else {
            Vector3 times = ((Vector3) objectRef.element).times(floatValue2);
            this.vel = new Vector3(times.getX(), this.vel.getY() - (f2 * dt), times.getZ());
            if (Intrinsics.areEqual(instance.get("Jump"), (Object) true)) {
                this.jumpRequested = true;
                instance.set("Jump", false, false);
            }
            if (this.jumpRequested && this.grounded) {
                this.vel = new Vector3(this.vel.getX(), f4, this.vel.getZ());
                this.grounded = false;
                this.jumpAnimTime = 0.3f;
                this.emote = null;
                setState("Jumping", 3);
                LuaRuntime luaRuntime4 = this.rt;
                LuaBoolean TRUE3 = LuaValue.TRUE;
                Intrinsics.checkNotNullExpressionValue(TRUE3, "TRUE");
                luaRuntime4.fire(instance, "Jumping", TRUE3);
            }
        }
        this.jumpRequested = this.jumpHeld;
        boolean z5 = this.shiftLock || this.firstPerson;
        if (!this.climbing) {
            if (z5) {
                this.facing = this.camYaw;
            } else if (((Vector3) objectRef.element).getMagnitude() > f && !Intrinsics.areEqual(instance.get("AutoRotate"), (Object) false)) {
                this.facing = (float) Math.atan2(-((Vector3) objectRef.element).getX(), -((Vector3) objectRef.element).getZ());
            }
        }
        float magnitude2 = this.vel.getMagnitude() * dt;
        int coerceIn = RangesKt.coerceIn((int) Math.ceil(magnitude2 / 0.6f), 1, 12);
        float f5 = dt / coerceIn;
        boolean z6 = this.grounded;
        this.grounded = false;
        int i = 0;
        while (i < coerceIn) {
            this.pos = this.pos.plus(this.vel.times(f5));
            collideCharacter();
            i++;
            magnitude2 = magnitude2;
            coerceIn = coerceIn;
        }
        if (this.climbing) {
            this.grounded = false;
        }
        if (!z6 && this.grounded) {
            setState("Landed", 7);
            setState("Running", 8);
        } else if (z6 && !this.grounded && !this.climbing && this.vel.getY() <= 0.0f) {
            setState("Freefall", 5);
            LuaRuntime luaRuntime5 = this.rt;
            LuaBoolean TRUE4 = LuaValue.TRUE;
            Intrinsics.checkNotNullExpressionValue(TRUE4, "TRUE");
            luaRuntime5.fire(instance, "FreeFalling", TRUE4);
        }
        trySit(dt);
        Object obj4 = this.dm.getWorkspace().get("FallenPartsDestroyHeight");
        Number number3 = obj4 instanceof Number ? (Number) obj4 : null;
        if (this.pos.getY() < (number3 != null ? number3.floatValue() : -500.0f)) {
            Instance.set$default(instance, instance.getProps().containsKey("Health") ? "Health" : "Health_XML", Float.valueOf(0.0f), false, 4, null);
        }
        writeCharacter(dt);
    }

    private final void stepDebris(float dt) {
        Pair<Vector3, Float> contact;
        Vector3 first;
        float gravity = getGravity();
        this.writing = true;
        boolean z = false;
        try {
            Iterator<Debris> it = this.debris.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Debris next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Debris debris = next;
                Instance part = debris.getPart();
                if (part.getParent() != null) {
                    debris.setVel(new Vector3(debris.getVel().getX(), debris.getVel().getY() - (gravity * dt), debris.getVel().getZ()));
                    CFrame plus = PartData.INSTANCE.cframe(part).plus(debris.getVel().times(dt));
                    float magnitude = debris.getSpin().getMagnitude();
                    if (magnitude > 0.01f) {
                        plus = CFrame.INSTANCE.at(plus.getPosition()).times(CFrame.INSTANCE.fromAxisAngle(debris.getSpin().div(magnitude), magnitude * dt)).times(plus.rotationOnly()).orthonormalize();
                    }
                    Instance.set$default(part, "CFrame", plus, false, 4, null);
                    Pair<Vector3, Vector3> partAabb = Geometry.INSTANCE.partAabb(part);
                    Vector3 component1 = partAabb.component1();
                    Vector3 component2 = partAabb.component2();
                    ConvexShape shapeOf$default = Geometry.shapeOf$default(Geometry.INSTANCE, part, null, 2, null);
                    Vector3 zero = Vector3.INSTANCE.getZERO();
                    Vector3 vector3 = zero;
                    for (Instance instance : query$default(this, component1, component2, false, 4, null)) {
                        if (!Intrinsics.areEqual(instance.get("CanCollide"), Boolean.valueOf(z)) && !isCharacterPart(instance) && (contact = Geometry.INSTANCE.contact(shapeOf$default, component1, component2, instance)) != null && (first = contact.getFirst()) != null && first.getMagnitude() > vector3.getMagnitude()) {
                            vector3 = first;
                        }
                    }
                    if (vector3.getMagnitude() > 1.0E-4f) {
                        Instance.set$default(part, "CFrame", PartData.INSTANCE.cframe(part).plus(vector3), false, 4, null);
                        Vector3 unit = vector3.getUnit();
                        float dot = debris.getVel().dot(unit);
                        if (dot < 0.0f) {
                            debris.setVel(debris.getVel().minus(unit.times(1.3f * dot)));
                        }
                        debris.setVel(new Vector3(debris.getVel().getX() * 0.8f, debris.getVel().getY(), debris.getVel().getZ() * 0.8f));
                        debris.setSpin(debris.getSpin().times(0.7f));
                        z = false;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
            }
        } finally {
            this.writing = false;
        }
    }

    private final void stepScriptTracks(float dt) {
        if (this.scriptTracks.isEmpty() && this.rigPlayers.isEmpty()) {
            return;
        }
        Iterator<ScriptTrack> it = this.scriptTracks.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ScriptTrack next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ScriptTrack scriptTrack = next;
            if (scriptTrack.getRig().getParent() == null) {
                it.remove();
            } else {
                if (scriptTrack.getWantPlay() && scriptTrack.getTrack() == null) {
                    startTrack(scriptTrack);
                }
                AnimPlayer.Track track = scriptTrack.getTrack();
                if (track != null) {
                    if (scriptTrack.getRig() == this.character && track.getPriority() <= 1 && scriptTrack.getWantPlay()) {
                        this.customAnimateAt = this.time;
                    }
                    if (track.getLoops() > scriptTrack.getLoopsSeen()) {
                        scriptTrack.setLoopsSeen(track.getLoops());
                        this.rt.fire(scriptTrack.getTable(), "DidLoop", new LuaValue[0]);
                    }
                    if (track.getEnded() && !track.getLooped() && scriptTrack.getWantPlay()) {
                        scriptTrack.setWantPlay(false);
                        AnimPlayer animPlayer = this.rigPlayers.get(scriptTrack.getRig());
                        if (animPlayer != null) {
                            animPlayer.stop(track, 0.15f);
                        }
                        scriptTrack.setTrack(null);
                        this.rt.fire(scriptTrack.getTable(), "Stopped", new LuaValue[0]);
                        this.rt.fire(scriptTrack.getTable(), "Ended", new LuaValue[0]);
                    }
                }
            }
        }
        Iterator<Map.Entry<Instance, AnimPlayer>> it2 = this.rigPlayers.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<Instance, AnimPlayer> next2 = it2.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            Map.Entry<Instance, AnimPlayer> entry = next2;
            Instance key = entry.getKey();
            AnimPlayer value = entry.getValue();
            if (key.getParent() == null) {
                it2.remove();
            } else {
                value.step(dt);
                if (key != this.character && !value.getTracks().isEmpty()) {
                    Intrinsics.checkNotNull(key);
                    Intrinsics.checkNotNull(value);
                    poseRig(key, value);
                }
                if (value.getTracks().isEmpty() && key != this.character) {
                    it2.remove();
                    this.rigJoints.remove(key);
                }
            }
        }
    }

    public static /* synthetic */ void systemMessage$default(PlaySession playSession, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1644826;
        }
        playSession.systemMessage(str, i);
    }

    private final void touchBegin(Instance a, Instance b) {
        Set<Instance> set;
        Set<Instance> set2;
        if (Intrinsics.areEqual(a.get("CanTouch"), (Object) false) || Intrinsics.areEqual(b.get("CanTouch"), (Object) false)) {
            return;
        }
        IdentityHashMap<Instance, Set<Instance>> identityHashMap = this.touching;
        Set<Instance> set3 = identityHashMap.get(a);
        if (set3 == null) {
            set = Collections.newSetFromMap(new IdentityHashMap());
            identityHashMap.put(a, set);
        } else {
            set = set3;
        }
        if (set.add(b)) {
            IdentityHashMap<Instance, Set<Instance>> identityHashMap2 = this.touching;
            Set<Instance> set4 = identityHashMap2.get(b);
            if (set4 == null) {
                set2 = Collections.newSetFromMap(new IdentityHashMap());
                identityHashMap2.put(b, set2);
            } else {
                set2 = set4;
            }
            set2.add(a);
            this.rt.fire(a, "Touched", this.rt.wrap(b));
            this.rt.fire(b, "Touched", this.rt.wrap(a));
        }
    }

    private final void touchEnd(Instance a, Instance b) {
        Set<Instance> set = this.touching.get(a);
        if (set != null && set.remove(b)) {
            Set<Instance> set2 = this.touching.get(b);
            if (set2 != null) {
                set2.remove(a);
            }
            this.rt.fire(a, "TouchEnded", this.rt.wrap(b));
            this.rt.fire(b, "TouchEnded", this.rt.wrap(a));
        }
    }

    private final LuaTable touchInput(float xPx, float yPx, String state, int stateValue, Vector2 delta) {
        float density = this.studio.getDensity();
        LuaTable luaTable = new LuaTable();
        luaTable.set("UserInputType", LuaTypes.INSTANCE.wrap(new EnumItemV("UserInputType", "Touch", 7)));
        luaTable.set("UserInputState", LuaTypes.INSTANCE.wrap(new EnumItemV("UserInputState", state, stateValue)));
        luaTable.set("KeyCode", LuaTypes.INSTANCE.wrap(new EnumItemV("KeyCode", "Unknown", 0)));
        luaTable.set("Position", LuaTypes.INSTANCE.wrap(new Vector3(xPx / density, yPx / density, 0.0f)));
        luaTable.set("Delta", LuaTypes.INSTANCE.wrap(new Vector3(delta.getX() / density, delta.getY() / density, 0.0f)));
        return luaTable;
    }

    static /* synthetic */ LuaTable touchInput$default(PlaySession playSession, float f, float f2, String str, int i, Vector2 vector2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            vector2 = new Vector2(0.0f, 0.0f);
        }
        return playSession.touchInput(f, f2, str, i, vector2);
    }

    private final CFrame transformFor(Joint j) {
        CFrame transform;
        CFrame transformOver;
        if (!j.getMotor()) {
            return CFrame.INSTANCE.getIDENTITY();
        }
        AnimPlayer animPlayer = this.rigPlayers.get(this.character);
        if (this.time - this.customAnimateAt < 1.0d) {
            transform = CFrame.INSTANCE.getIDENTITY();
        } else {
            DefaultAnimate defaultAnimate = this.animator;
            transform = defaultAnimate != null ? defaultAnimate.transform(j.getP1().getName()) : null;
        }
        if (animPlayer != null && !animPlayer.getTracks().isEmpty() && (transformOver = animPlayer.transformOver(transform, j.getP1().getName())) != null) {
            return transformOver;
        }
        if (transform != null) {
            return transform;
        }
        if (!this.isR15) {
            Float f = this.motorAngle.get(j.getName());
            if (f != null) {
                CFrame rz = CFrame.INSTANCE.rz(f.floatValue());
                if (rz != null) {
                    return rz;
                }
            }
            return CFrame.INSTANCE.getIDENTITY();
        }
        float[] fArr = this.r15Pose.get(j.getName());
        if (fArr == null) {
            return CFrame.INSTANCE.getIDENTITY();
        }
        CFrame rx = CFrame.INSTANCE.rx(fArr[0]);
        if (!(fArr[1] == 0.0f)) {
            rx = CFrame.INSTANCE.ry(fArr[1]).times(rx);
        }
        return !(fArr[2] == 0.0f) ? rx.times(CFrame.INSTANCE.rz(fArr[2])) : rx;
    }

    private final void trySit(float dt) {
        if (this.seated != null || this.seatCooldown > 0.0f || this.dead) {
            this.seatCooldown -= dt;
            return;
        }
        Pair<Vector3, Vector3> charBox = charBox();
        Vector3 component1 = charBox.component1();
        Vector3 component2 = charBox.component2();
        for (Instance instance : query(component1.minus(component2).minus(new Vector3(0.2f, 0.4f, 0.2f)), component1.plus(component2).plus(new Vector3(0.2f, 0.2f, 0.2f)), true)) {
            if (Intrinsics.areEqual(instance.getClassName(), "Seat") || Intrinsics.areEqual(instance.getClassName(), "VehicleSeat")) {
                if (!Intrinsics.areEqual(instance.get("Disabled"), (Object) true) && !(instance.get("Occupant") instanceof Instance)) {
                    Pair<Vector3, Vector3> partAabb = Geometry.INSTANCE.partAabb(instance);
                    Vector3 component12 = partAabb.component1();
                    Vector3 component22 = partAabb.component2();
                    if (this.pos.getY() + this.charMaxY >= component12.getY() && this.pos.getY() + this.charMinY <= component22.getY() + 0.6f) {
                        this.seated = instance;
                        this.vel = Vector3.INSTANCE.getZERO();
                        Vector3 lookVector = PartData.INSTANCE.cframe(instance).getLookVector();
                        this.facing = (float) Math.atan2(-lookVector.getX(), -lookVector.getZ());
                        Instance.set$default(instance, "Occupant", this.humanoid, false, 4, null);
                        Instance instance2 = this.humanoid;
                        if (instance2 != null) {
                            Instance.set$default(instance2, "Sit", true, false, 4, null);
                            LuaRuntime luaRuntime = this.rt;
                            LuaBoolean TRUE = LuaValue.TRUE;
                            Intrinsics.checkNotNullExpressionValue(TRUE, "TRUE");
                            luaRuntime.fire(instance2, "Seated", TRUE, this.rt.wrap(instance));
                        }
                        setState("Seated", 13);
                        return;
                    }
                }
            }
        }
    }

    private final void updateCamera(float dt) {
        Instance instance;
        float f;
        Vector3 vector3;
        Vector3 vector32;
        Vector3 vector33;
        Instance instance2;
        boolean z;
        Object obj = this.dm.getWorkspace().get("CurrentCamera");
        Instance instance3 = obj instanceof Instance ? (Instance) obj : null;
        FlyCamera camera = this.studio.getCamera();
        Object obj2 = instance3 != null ? instance3.get("CameraType") : null;
        EnumValue enumValue = obj2 instanceof EnumValue ? (EnumValue) obj2 : null;
        float f2 = 1.0f;
        if ((enumValue != null ? enumValue.getValue() : 5) != 6 || instance3 == null) {
            Pair<Float, Float> zoomLimits = zoomLimits();
            float floatValue = zoomLimits.component1().floatValue();
            float floatValue2 = zoomLimits.component2().floatValue();
            Instance instance4 = this.player;
            Object obj3 = instance4 != null ? instance4.get("CameraMode") : null;
            EnumValue enumValue2 = obj3 instanceof EnumValue ? (EnumValue) obj3 : null;
            boolean z2 = true;
            boolean z3 = enumValue2 != null && enumValue2.getValue() == 1;
            this.distTarget = z3 ? floatValue : RangesKt.coerceIn(this.distTarget, floatValue, floatValue2);
            if (!(this.keyTurn == 0.0f)) {
                this.yawTarget += this.keyTurn * dt * 2.6f;
                this.lastCamInput = this.time;
            }
            if (!Intrinsics.areEqual(Settings.INSTANCE.getCameraMode(), "Follow") || this.shiftLock || this.firstPerson) {
                instance = instance3;
            } else {
                instance = instance3;
                if (this.time - this.lastCamInput > 0.8d && this.lastDir.getMagnitude() > 0.2f && this.grounded) {
                    float wrapAngle = wrapAngle(((float) Math.atan2(-this.lastDir.getX(), -this.lastDir.getZ())) - this.yawTarget);
                    if (Math.abs(wrapAngle) < 2.2f) {
                        this.yawTarget += (1.0f - ((float) Math.exp((-0.9f) * dt))) * wrapAngle;
                    }
                }
            }
            boolean cameraSmoothing = Settings.INSTANCE.getCameraSmoothing();
            float exp = cameraSmoothing ? 1.0f - ((float) Math.exp((-22.0f) * dt)) : 1.0f;
            this.camYaw += (this.yawTarget - this.camYaw) * exp;
            this.camPitch += (this.pitchTarget - this.camPitch) * exp;
            float f3 = this.camDist;
            float f4 = this.distTarget - this.camDist;
            if (cameraSmoothing) {
                f = 1.0f;
                f2 = 1.0f - ((float) Math.exp((-14.0f) * dt));
            } else {
                f = 1.0f;
            }
            this.camDist = f3 + (f4 * f2);
            if (!z3 && this.camDist >= f) {
                z2 = false;
            }
            this.firstPerson = z2;
            Instance instance5 = this.hrp;
            if (instance5 == null || (vector3 = PartData.INSTANCE.cframe(instance5).getPosition()) == null) {
                vector3 = this.pos;
            }
            Vector3 vector34 = vector3;
            boolean z4 = this.isR15;
            Vector3 plus = vector34.plus(new Vector3(0.0f, 1.5f, 0.0f));
            this.subjectY = (Float.isNaN(this.subjectY) || Math.abs(this.subjectY - plus.getY()) > 6.0f || this.dead) ? plus.getY() : approach(this.subjectY, plus.getY(), 18.0f, dt);
            camera.setYaw(this.camYaw);
            camera.setPitch(this.camPitch);
            Vector3 plus2 = new Vector3(plus.getX(), this.subjectY, plus.getZ()).plus((!this.shiftLock || this.firstPerson) ? Vector3.INSTANCE.getZERO() : camera.getRight().times(1.75f));
            float f5 = this.camDist;
            if (this.firstPerson) {
                vector32 = plus2;
                vector33 = plus;
                this.occluded = f5;
            } else {
                Vector3 unaryMinus = camera.getForward().unaryMinus();
                Vector3 plus3 = plus2.plus(unaryMinus.times(f5));
                vector33 = plus;
                RayHit raycast = Geometry.INSTANCE.raycast(query$default(this, new Vector3(Math.min(plus2.getX(), plus3.getX()), Math.min(plus2.getY(), plus3.getY()), Math.min(plus2.getZ(), plus3.getZ())).minus(new Vector3(0.5f, 0.5f, 0.5f)), new Vector3(Math.max(plus2.getX(), plus3.getX()), Math.max(plus2.getY(), plus3.getY()), Math.max(plus2.getZ(), plus3.getZ())).plus(new Vector3(0.5f, 0.5f, 0.5f)), false, 4, null), plus2, unaryMinus, f5, new PlaySession$$ExternalSyntheticLambda4(this));
                vector32 = plus2;
                float coerceAtLeast = raycast != null ? RangesKt.coerceAtLeast(raycast.getT() - 0.4f, 0.5f) : f5;
                this.occluded = coerceAtLeast < this.occluded ? coerceAtLeast : approach(this.occluded, coerceAtLeast, 6.0f, dt);
                f5 = Math.min(f5, this.occluded);
            }
            camera.setPos(vector32.minus(camera.getForward().times(f5)));
            if (instance != null) {
                instance2 = instance;
                z = false;
                instance2.set("CFrame", camera.cframe(), false);
            } else {
                instance2 = instance;
                z = false;
            }
            if (instance2 != null) {
                instance2.set("Focus", CFrame.INSTANCE.at(vector33), z);
            }
        } else {
            Object obj4 = instance3.get("CFrame");
            CFrame cFrame = obj4 instanceof CFrame ? (CFrame) obj4 : null;
            if (cFrame != null) {
                camera.setFromCFrame(cFrame);
            }
            this.firstPerson = false;
            instance2 = instance3;
            f = 1.0f;
        }
        Object obj5 = instance2 != null ? instance2.get("FieldOfView") : null;
        Number number = obj5 instanceof Number ? (Number) obj5 : null;
        if (number != null) {
            camera.setFov(RangesKt.coerceIn(number.floatValue(), f, 120.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean updateCamera$lambda$133(PlaySession playSession, Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return (playSession.isCharacterPart(p) || Intrinsics.areEqual(p.get("CanCollide"), (Object) false) || PartData.INSTANCE.transparency(p) >= 0.25f) ? false : true;
    }

    private final void updateGrid(Instance p) {
        removeGrid(p);
        insertGrid(p);
    }

    private final void updatePrompts() {
        Instance parent;
        Vector3 position;
        Vector3 zero;
        Instance instance = this.hrp;
        if (instance == null || this.dead || this.prompts.isEmpty()) {
            this.activePrompt = null;
            return;
        }
        Vector3 position2 = PartData.INSTANCE.cframe(instance).getPosition();
        Instance instance2 = null;
        float f = Float.MAX_VALUE;
        Iterator<Instance> it = this.prompts.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            if (next.getParent() != null && !Intrinsics.areEqual(next.get("Enabled"), (Object) false) && (parent = next.getParent()) != null) {
                if (parent.isA("BasePart")) {
                    position = PartData.INSTANCE.cframe(parent).getPosition();
                } else if (Intrinsics.areEqual(parent.getClassName(), "Attachment")) {
                    Instance parent2 = parent.getParent();
                    if (parent2 != null) {
                        CFrame cframe = PartData.INSTANCE.cframe(parent2);
                        Object obj = parent.get("CFrame");
                        CFrame cFrame = obj instanceof CFrame ? (CFrame) obj : null;
                        if (cFrame == null || (zero = cFrame.getPosition()) == null) {
                            zero = Vector3.INSTANCE.getZERO();
                        }
                        position = cframe.times(zero);
                    } else {
                        position = null;
                    }
                } else {
                    position = parent.isA("Model") ? this.rt.getApi().modelPivot(parent).getPosition() : null;
                }
                if (position != null) {
                    float magnitude = position.minus(position2).getMagnitude();
                    Object obj2 = next.get("MaxActivationDistance");
                    Number number = obj2 instanceof Number ? (Number) obj2 : null;
                    if (magnitude <= (number != null ? number.floatValue() : 10.0f) && magnitude < f) {
                        f = magnitude;
                        instance2 = next;
                    }
                }
            }
        }
        this.activePrompt = instance2;
    }

    private final Vector3 vec(Instance i, String n) {
        Object obj = i.get(n);
        Vector3 vector3 = obj instanceof Vector3 ? (Vector3) obj : null;
        return vector3 == null ? Vector3.INSTANCE.getZERO() : vector3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    private final boolean wantR15(Avatar.Spec spec) {
        switch (gameAvatarType()) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                if (spec != null && spec.getR15()) {
                    return true;
                }
                return false;
        }
    }

    private final float wrapAngle(float a) {
        float f = a;
        while (f > 3.141592653589793d) {
            f -= 6.2831855f;
        }
        while (f < -3.141592653589793d) {
            f += 6.2831855f;
        }
        return f;
    }

    private final void writeCharacter(float dt) {
        Instance findFirstChild$default;
        Instance findFirstChild$default2;
        CFrame cFrame;
        CFrame times;
        CFrame times2;
        Instance instance = this.hrp;
        if (instance == null) {
            return;
        }
        animate(dt);
        Instance instance2 = this.seated;
        CFrame times3 = instance2 != null ? PartData.INSTANCE.cframe(instance2).times(CFrame.INSTANCE.at(new Vector3(0.0f, (PartData.INSTANCE.size(instance2).getY() / 2.0f) + (this.isR15 ? (-this.charMinY) - 1.4f : 1.5f), 0.0f))) : CFrame.INSTANCE.at(this.pos).times(CFrame.INSTANCE.ry(this.renderFacing));
        if (instance2 != null) {
            this.pos = times3.getPosition();
        }
        this.writing = true;
        try {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            identityHashMap.put(instance, times3);
            Iterator<Pair<Joint, Boolean>> it = this.jointOrder.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<Joint, Boolean> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Pair<Joint, Boolean> pair = next;
                Joint component1 = pair.component1();
                boolean booleanValue = pair.component2().booleanValue();
                Object obj = component1.getInst().get("C0");
                CFrame cFrame2 = obj instanceof CFrame ? (CFrame) obj : null;
                if (cFrame2 == null) {
                    cFrame2 = CFrame.INSTANCE.getIDENTITY();
                }
                Object obj2 = component1.getInst().get("C1");
                cFrame = obj2 instanceof CFrame ? (CFrame) obj2 : null;
                if (cFrame == null) {
                    cFrame = CFrame.INSTANCE.getIDENTITY();
                }
                if (booleanValue) {
                    CFrame cFrame3 = (CFrame) identityHashMap.get(component1.getP0());
                    if (cFrame3 != null) {
                        IdentityHashMap identityHashMap2 = identityHashMap;
                        Instance p1 = component1.getP1();
                        CFrame fixed = component1.getFixed();
                        if (fixed == null || (times = cFrame3.times(fixed)) == null) {
                            times = cFrame3.times(cFrame2).times(transformFor(component1)).times(cFrame.inverse());
                        }
                        identityHashMap2.put(p1, times);
                    }
                } else {
                    CFrame cFrame4 = (CFrame) identityHashMap.get(component1.getP1());
                    if (cFrame4 != null) {
                        IdentityHashMap identityHashMap3 = identityHashMap;
                        Instance p0 = component1.getP0();
                        CFrame fixed2 = component1.getFixed();
                        if (fixed2 == null || (times2 = cFrame4.times(fixed2.inverse())) == null) {
                            times2 = cFrame4.times(cFrame).times(transformFor(component1).inverse()).times(cFrame2.inverse());
                        }
                        identityHashMap3.put(p0, times2);
                    }
                }
            }
            for (Map.Entry<Instance, CFrame> entry : this.rigid.entrySet()) {
                Instance key = entry.getKey();
                CFrame value = entry.getValue();
                Intrinsics.checkNotNull(value);
                identityHashMap.put(key, times3.times(value));
            }
            for (Map.Entry entry2 : identityHashMap.entrySet()) {
                Instance instance3 = (Instance) entry2.getKey();
                CFrame cFrame5 = (CFrame) entry2.getValue();
                if (instance3.getParent() != null) {
                    if (instance3 == instance) {
                        this.lastWritten = cFrame5;
                    }
                    Instance.set$default(instance3, "CFrame", cFrame5, false, 4, null);
                }
            }
            Instance instance4 = this.equipped;
            if (instance4 != null && (findFirstChild$default = Instance.findFirstChild$default(instance4, "Handle", false, 2, null)) != null) {
                Instance instance5 = this.character;
                if (instance5 == null || (findFirstChild$default2 = Instance.findFirstChild$default(instance5, "Right Arm", false, 2, null)) == null) {
                    Instance instance6 = this.character;
                    findFirstChild$default2 = instance6 != null ? Instance.findFirstChild$default(instance6, "RightHand", false, 2, null) : null;
                    if (findFirstChild$default2 == null) {
                    }
                }
                Object obj3 = instance4.get("Grip");
                cFrame = obj3 instanceof CFrame ? (CFrame) obj3 : null;
                if (cFrame == null) {
                    cFrame = CFrame.INSTANCE.getIDENTITY();
                }
                CFrame times4 = PartData.INSTANCE.cframe(findFirstChild$default2).times(new CFrame(0.0f, this.isR15 ? -0.15f : -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4088, null)).times(CFrame.INSTANCE.rx(-1.5708f)).times(cFrame.inverse());
                Instance.set$default(findFirstChild$default, "CFrame", times4, false, 4, null);
                for (Map.Entry<Instance, CFrame> entry3 : this.toolOffsets.entrySet()) {
                    Instance key2 = entry3.getKey();
                    CFrame value2 = entry3.getValue();
                    if (key2 != findFirstChild$default) {
                        Intrinsics.checkNotNull(value2);
                        Instance.set$default(key2, "CFrame", times4.times(value2), false, 4, null);
                    }
                }
            }
        } finally {
            this.writing = false;
        }
    }

    private final Pair<Float, Float> zoomLimits() {
        Instance instance = this.player;
        Object obj = instance != null ? instance.get("CameraMinZoomDistance") : null;
        Number number = obj instanceof Number ? (Number) obj : null;
        float floatValue = number != null ? number.floatValue() : 0.5f;
        Object obj2 = instance != null ? instance.get("CameraMaxZoomDistance") : null;
        Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
        return TuplesKt.to(Float.valueOf(RangesKt.coerceIn(floatValue, 0.5f, 400.0f)), Float.valueOf(RangesKt.coerceIn(Math.max(floatValue, number2 != null ? number2.floatValue() : 128.0f), 0.5f, 400.0f)));
    }

    public final void adjustTrack(ScriptTrack st, Float speed, Float weight, Float fade, Boolean looped, Integer priority, Float time) {
        Intrinsics.checkNotNullParameter(st, "st");
        if (speed != null) {
            float floatValue = speed.floatValue();
            st.setSpeed(floatValue);
            AnimPlayer.Track track = st.getTrack();
            if (track != null) {
                track.setSpeed(floatValue);
            }
        }
        if (weight != null) {
            float floatValue2 = weight.floatValue();
            st.setWeight(floatValue2);
            AnimPlayer.Track track2 = st.getTrack();
            if (track2 != null) {
                track2.setTargetWeight(floatValue2);
                if (fade != null) {
                    float floatValue3 = fade.floatValue();
                    track2.setFadeRate(floatValue3 <= 0.001f ? 1000.0f : 1.0f / floatValue3);
                }
            }
        }
        if (looped != null) {
            boolean booleanValue = looped.booleanValue();
            st.setLooped(Boolean.valueOf(booleanValue));
            AnimPlayer.Track track3 = st.getTrack();
            if (track3 != null) {
                track3.setLooped(booleanValue);
            }
        }
        if (priority != null) {
            int intValue = priority.intValue();
            st.setPriority(Integer.valueOf(intValue));
            AnimPlayer.Track track4 = st.getTrack();
            if (track4 != null) {
                track4.setPriority(AnimPlayer.INSTANCE.rank(intValue));
            }
        }
        if (time != null) {
            float floatValue4 = time.floatValue();
            AnimPlayer.Track track5 = st.getTrack();
            if (track5 != null) {
                track5.setTime(RangesKt.coerceIn(floatValue4, 0.0f, track5.getClip().getLength()));
            }
        }
    }

    public final List<Instance> backpackTools() {
        Instance findFirstChild$default;
        Instance instance = this.player;
        if (instance == null || (findFirstChild$default = Instance.findFirstChild$default(instance, "Backpack", false, 2, null)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList<Instance> children = findFirstChild$default.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            Instance instance2 = (Instance) obj;
            if (Intrinsics.areEqual(instance2.getClassName(), "Tool") || Intrinsics.areEqual(instance2.getClassName(), "HopperBin")) {
                arrayList.add(obj);
            }
        }
        List<Instance> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        Instance instance3 = this.equipped;
        if (instance3 != null && !mutableList.contains(instance3)) {
            mutableList.add(0, instance3);
        }
        return mutableList;
    }

    public final void bindAction(String name, LuaValue fn, boolean touchButton) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fn, "fn");
        if (touchButton) {
            this.actions.put(name, new ActionButton(name, fn, name));
        }
    }

    public final void bubble(Instance part, String text) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(text, "text");
        CollectionsKt.removeAll((List) this.bubbles, (Function1) new PlaySession$$ExternalSyntheticLambda1(part, this));
        this.bubbles.add(new Bubble(part, StringsKt.take(text, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION), 0.0f, 4, null));
    }

    public final void cameraDrag(float dx, float dy) {
        float playCameraSensitivity = Settings.INSTANCE.getPlayCameraSensitivity() * 0.0075f;
        this.yawTarget -= dx * playCameraSensitivity;
        this.pitchTarget = RangesKt.coerceIn(this.pitchTarget - (dy * playCameraSensitivity), -1.4f, 1.4f);
        this.lastCamInput = this.time;
    }

    public final void cameraZoom(float factor) {
        Pair<Float, Float> zoomLimits = zoomLimits();
        this.distTarget = RangesKt.coerceIn(this.distTarget / factor, zoomLimits.component1().floatValue(), zoomLimits.component2().floatValue());
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void childAdded(Instance parent, Instance child) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!this.physicsDirty && inWorkspace(parent) && physicsRelevant(child)) {
            List plus = CollectionsKt.plus((Collection) CollectionsKt.listOf(child), (Iterable) Instance.descendants$default(child, null, 1, null));
            List list = plus;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Instance instance = (Instance) it.next();
                    if (instance.isA("JointInstance") || Intrinsics.areEqual(instance.getClassName(), "WeldConstraint") || instance.isA("Constraint") || instance.isA("BodyMover") || instance.isA("Humanoid")) {
                        z = true;
                        break;
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                this.physicsDirty = true;
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : plus) {
                Instance instance2 = (Instance) obj;
                if (instance2.isA("BasePart") && !Intrinsics.areEqual(instance2.getClassName(), "Terrain")) {
                    arrayList.add(obj);
                }
            }
            ArrayList<Instance> arrayList2 = arrayList;
            ArrayList arrayList3 = arrayList2;
            if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                Iterator it2 = arrayList3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                    Instance instance3 = (Instance) it2.next();
                    if (!(Intrinsics.areEqual(instance3.get("Anchored"), (Object) true) && !isCharacterPart(instance3))) {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = true;
            }
            if (z2) {
                for (Instance instance4 : arrayList2) {
                    if (this.statics.add(instance4)) {
                        insertGrid(instance4);
                    }
                }
                return;
            }
            Iterator it3 = SequencesKt.takeWhile(SequencesKt.generateSequence(child.getParent(), new PlaySession$$ExternalSyntheticLambda13()), new PlaySession$$ExternalSyntheticLambda14(this)).iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (((Instance) it3.next()).isA("Model")) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (child.isA("BasePart")) {
                ArrayList<Instance> children = child.getChildren();
                if (!(children instanceof Collection) || !children.isEmpty()) {
                    Iterator<T> it4 = children.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            if (((Instance) it4.next()).isA("BasePart")) {
                                z4 = false;
                                break;
                            }
                        } else {
                            z4 = true;
                            break;
                        }
                    }
                } else {
                    z4 = true;
                }
                if (z4 && !z3 && !Intrinsics.areEqual(child.get("Anchored"), (Object) true) && !isCharacterPart(child)) {
                    Body body = new Body(CollectionsKt.listOf(child), Vector3.INSTANCE.getZERO());
                    measure(body);
                    this.bodies.add(body);
                    this.bodyOf.put(child, body);
                    return;
                }
            }
            this.physicsDirty = true;
        }
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void childRemoved(Instance parent, Instance child) {
        boolean z;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!this.physicsDirty && inWorkspace(parent) && physicsRelevant(child)) {
            List<Instance> plus = CollectionsKt.plus((Collection) CollectionsKt.listOf(child), (Iterable) Instance.descendants$default(child, null, 1, null));
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.addAll(plus);
            for (Instance instance : plus) {
                if (this.statics.contains(instance)) {
                    this.statics.remove(instance);
                    removeGrid(instance);
                } else {
                    Body body = this.bodyOf.get(instance);
                    if (body != null) {
                        List<Instance> parts = body.getParts();
                        if (!(parts instanceof Collection) || !parts.isEmpty()) {
                            Iterator<T> it = parts.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = true;
                                    break;
                                }
                                Instance instance2 = (Instance) it.next();
                                z = false;
                                if (!(newSetFromMap.contains(instance2) || instance2.getParent() == null)) {
                                    break;
                                }
                            }
                        } else {
                            z = true;
                        }
                        if (!z) {
                            this.physicsDirty = true;
                            return;
                        }
                        this.bodies.remove(body);
                        Iterator<Instance> it2 = body.getParts().iterator();
                        while (it2.hasNext()) {
                            this.bodyOf.remove(it2.next());
                        }
                    } else if (instance.isA("JointInstance") || Intrinsics.areEqual(instance.getClassName(), "WeldConstraint")) {
                        this.physicsDirty = true;
                        return;
                    } else if (instance.isA("Constraint") || instance.isA("BodyMover")) {
                        this.movers.remove(instance);
                    }
                }
            }
        }
    }

    public final void equip(Instance tool) {
        Intrinsics.checkNotNullParameter(tool, "tool");
        Instance instance = this.character;
        if (instance == null || this.equipped == tool) {
            return;
        }
        unequip();
        Instance.setParent$default(tool, instance, 0, 2, null);
        this.equipped = tool;
        this.toolOffsets.clear();
        Instance findFirstChild$default = Instance.findFirstChild$default(tool, "Handle", false, 2, null);
        if (findFirstChild$default != null) {
            CFrame cframe = PartData.INSTANCE.cframe(findFirstChild$default);
            for (Instance instance2 : Instance.descendants$default(tool, null, 1, null)) {
                if (instance2.isA("BasePart")) {
                    this.toolOffsets.put(instance2, cframe.inverse().times(PartData.INSTANCE.cframe(instance2)));
                }
            }
        }
        this.physicsDirty = true;
        this.rt.fire(tool, "Equipped", mouseValue());
    }

    public final int gameAvatarType() {
        Instance findService = this.dm.findService("StarterPlayer");
        Object obj = findService != null ? findService.get("GameSettingsAvatar") : null;
        EnumValue enumValue = obj instanceof EnumValue ? (EnumValue) obj : null;
        if (enumValue != null) {
            return enumValue.getValue();
        }
        return 2;
    }

    public final LinkedHashMap<String, ActionButton> getActions() {
        return this.actions;
    }

    public final Instance getActivePrompt() {
        return this.activePrompt;
    }

    public final ArrayList<Bubble> getBubbles() {
        return this.bubbles;
    }

    public final float getCamDist() {
        return this.camDist;
    }

    public final float getCamPitch() {
        return this.camPitch;
    }

    public final float getCamYaw() {
        return this.camYaw;
    }

    public final Instance getCharacter() {
        return this.character;
    }

    public final ArrayList<ChatLine> getChatLines() {
        return this.chatLines;
    }

    public final int getChatVersion() {
        return this.chatVersion;
    }

    public final boolean getControlsEnabled() {
        return this.controlsEnabled;
    }

    public final boolean getCoreBackpack() {
        return this.coreBackpack;
    }

    public final boolean getCoreChat() {
        return this.coreChat;
    }

    public final boolean getCoreHealth() {
        return this.coreHealth;
    }

    public final boolean getCorePlayerList() {
        return this.corePlayerList;
    }

    public final DataModel getDm() {
        return this.dm;
    }

    public final Instance getEquipped() {
        return this.equipped;
    }

    public final boolean getFirstPerson() {
        return this.firstPerson;
    }

    public final float getKeyTurn() {
        return this.keyTurn;
    }

    public final Vector2 getLastTouchDp() {
        return this.lastTouchDp;
    }

    public final Instance getPlayer() {
        return this.player;
    }

    public final LuaRuntime getRt() {
        return this.rt;
    }

    public final boolean getShiftLock() {
        return this.shiftLock;
    }

    public final boolean getShiftLockAllowed() {
        if (!Settings.INSTANCE.getShiftLockSwitch()) {
            return false;
        }
        Instance findService = this.dm.findService("StarterPlayer");
        return !(findService != null ? Intrinsics.areEqual(findService.get("EnableMouseLockOption"), (Object) false) : false);
    }

    public final Studio getStudio() {
        return this.studio;
    }

    public final boolean hiddenInFirstPerson(Instance p) {
        Instance instance;
        Intrinsics.checkNotNullParameter(p, "p");
        if (!this.firstPerson || (instance = this.character) == null || !p.isDescendantOf(instance)) {
            return false;
        }
        Instance instance2 = this.equipped;
        return instance2 == null || !p.isDescendantOf(instance2);
    }

    /* renamed from: isDead, reason: from getter */
    public final boolean getDead() {
        return this.dead;
    }

    public final boolean isGrounded(Instance h) {
        Intrinsics.checkNotNullParameter(h, "h");
        return h == this.humanoid && this.grounded;
    }

    public final void jump(Instance h) {
        Intrinsics.checkNotNullParameter(h, "h");
        if (h == this.humanoid) {
            this.jumpRequested = true;
        }
    }

    public final List<Pair<String, String>> leaderstats() {
        Instance findFirstChild$default;
        Instance instance = this.player;
        if (instance == null || (findFirstChild$default = Instance.findFirstChild$default(instance, "leaderstats", false, 2, null)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList<Instance> children = findFirstChild$default.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            if (((Instance) obj).isA("ValueBase")) {
                arrayList.add(obj);
            }
        }
        List<Instance> take = CollectionsKt.take(arrayList, 4);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        for (Instance instance2 : take) {
            Object obj2 = instance2.get("Value");
            arrayList2.add(TuplesKt.to(instance2.getName(), obj2 instanceof Double ? (!Intrinsics.areEqual((Double) obj2, Math.floor(((Number) obj2).doubleValue())) || Math.abs(((Number) obj2).doubleValue()) >= 1.0E15d) ? DataTypesKt.fmtNum((float) ((Number) obj2).doubleValue()) : String.valueOf((long) ((Number) obj2).doubleValue()) : obj2 instanceof Float ? DataTypesKt.fmtNum(((Number) obj2).floatValue()) : obj2 instanceof Number ? String.valueOf(((Number) obj2).longValue()) : obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() ? "true" : "false" : obj2 instanceof Instance ? ((Instance) obj2).getName() : obj2 == null ? "-" : obj2.toString()));
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.engine.PlaySession.ScriptTrack loadTrack(com.exampletest.mobilestudiotest.model.Instance r11, com.exampletest.mobilestudiotest.model.Instance r12, org.luaj.vm2.LuaTable r13) {
        /*
            r10 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.exampletest.mobilestudiotest.model.Instance r0 = r10.rigOf(r11)
            r1 = 0
            if (r0 != 0) goto L12
            return r1
        L12:
            r4 = r0
            if (r12 == 0) goto L4c
            r0 = 1
            java.util.List r0 = com.exampletest.mobilestudiotest.model.Instance.descendants$default(r12, r1, r0, r1)
            if (r0 == 0) goto L4c
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 0
            java.util.Iterator r3 = r0.iterator()
        L23:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L3e
            java.lang.Object r5 = r3.next()
            r6 = r5
            com.exampletest.mobilestudiotest.model.Instance r6 = (com.exampletest.mobilestudiotest.model.Instance) r6
            r7 = 0
            java.lang.String r8 = r6.getClassName()
            java.lang.String r9 = "KeyframeSequence"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r6 == 0) goto L23
            goto L3f
        L3e:
            r5 = r1
        L3f:
            com.exampletest.mobilestudiotest.model.Instance r5 = (com.exampletest.mobilestudiotest.model.Instance) r5
            if (r5 == 0) goto L4c
            r0 = 0
            com.exampletest.mobilestudiotest.engine.AnimLibrary r2 = com.exampletest.mobilestudiotest.engine.AnimLibrary.INSTANCE
            com.exampletest.mobilestudiotest.engine.AnimClip r0 = r2.fromInstance(r5)
            r6 = r0
            goto L4d
        L4c:
            r6 = r1
        L4d:
            com.exampletest.mobilestudiotest.net.AssetFetcher r0 = com.exampletest.mobilestudiotest.net.AssetFetcher.INSTANCE
            if (r12 == 0) goto L58
            java.lang.String r2 = "AnimationId"
            java.lang.Object r2 = r12.get(r2)
            goto L59
        L58:
            r2 = r1
        L59:
            java.lang.Long r5 = r0.idOf(r2)
            if (r6 != 0) goto L62
            if (r5 != 0) goto L62
            return r1
        L62:
            if (r6 != 0) goto L70
            com.exampletest.mobilestudiotest.engine.AnimLibrary r0 = com.exampletest.mobilestudiotest.engine.AnimLibrary.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            long r1 = r5.longValue()
            r0.get(r1)
        L70:
            com.exampletest.mobilestudiotest.engine.PlaySession$ScriptTrack r2 = new com.exampletest.mobilestudiotest.engine.PlaySession$ScriptTrack
            r3 = r10
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r13 = r2
            r0 = 0
            java.util.ArrayList<com.exampletest.mobilestudiotest.engine.PlaySession$ScriptTrack> r1 = r10.scriptTracks
            r1.add(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.loadTrack(com.exampletest.mobilestudiotest.model.Instance, com.exampletest.mobilestudiotest.model.Instance, org.luaj.vm2.LuaTable):com.exampletest.mobilestudiotest.engine.PlaySession$ScriptTrack");
    }

    public final float max3(float a, float b, float c) {
        return Math.max(a, Math.max(b, c));
    }

    public final void maybeRunScript(Instance s) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (this.rt.getStopped() || this.startedScripts.contains(s) || !s.isA("BaseScript") || !isRunnable(s)) {
            return;
        }
        this.startedScripts.add(s);
        LuaRuntime.runScript$default(this.rt, s, null, 2, null);
    }

    public final LuaValue mouseValue() {
        LuaTable luaTable = this.mouseTable;
        if (luaTable != null) {
            return luaTable;
        }
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set("Hit", LuaTypes.INSTANCE.wrap(CFrame.INSTANCE.getIDENTITY()));
        luaTable2.set("Target", LuaValue.NIL);
        luaTable2.set("X", 0);
        luaTable2.set("Y", 0);
        luaTable2.set("ViewSizeX", LuaValue.valueOf(this.studio.viewportSizeDp().getX()));
        luaTable2.set("ViewSizeY", LuaValue.valueOf(this.studio.viewportSizeDp().getY()));
        luaTable2.set("Icon", "");
        luaTable2.set("TargetFilter", LuaValue.NIL);
        luaTable2.set("Origin", LuaTypes.INSTANCE.wrap(this.studio.getCamera().cframe()));
        luaTable2.set("UnitRay", LuaTypes.INSTANCE.wrap(new Ray(this.studio.getCamera().getPos(), this.studio.getCamera().getForward())));
        luaTable2.set("ClassName", "PlayerMouse");
        luaTable2.set("Name", "Instance");
        LuaTable luaTable3 = new LuaTable();
        luaTable3.set("__type", "Instance");
        luaTable3.set(LuaValue.INDEX, LuaTypesKt.fn2(new PlaySession$$ExternalSyntheticLambda2(this, luaTable2)));
        luaTable2.setmetatable(luaTable3);
        this.mouseTable = luaTable2;
        return luaTable2;
    }

    public final Vector3 moveDirection(Instance h) {
        Intrinsics.checkNotNullParameter(h, "h");
        return h == this.humanoid ? this.lastDir : Vector3.INSTANCE.getZERO();
    }

    public final void moveTo(Instance h, Vector3 target) {
        Intrinsics.checkNotNullParameter(h, "h");
        Intrinsics.checkNotNullParameter(target, "target");
        if (h == this.humanoid) {
            this.moveToTarget = target;
        }
    }

    public final int nameColor(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int[] iArr = {-186045, -16669953, -16599209, -9751940, -2456255, -668368, -1525048, -2636390};
        int i = 0;
        int length = name.length();
        for (int i2 = 0; i2 < length; i2++) {
            int charAt = name.charAt(i2);
            int length2 = name.length() - i2;
            if (name.length() % 2 == 1) {
                length2--;
            }
            if (length2 % 4 >= 2) {
                charAt = -charAt;
            }
            i += charAt;
        }
        return iArr[Math.floorMod(i, iArr.length)];
    }

    public final void onChildAdded(Instance parent, Instance child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        maybeRunScript(child);
        Iterator it = Instance.descendants$default(child, null, 1, null).iterator();
        while (it.hasNext()) {
            maybeRunScript((Instance) it.next());
        }
    }

    public final void onChildRemoved(Instance parent, Instance child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
    }

    public final void playTrack(ScriptTrack st, float fade, float weight, float speed) {
        AnimPlayer animPlayer;
        Intrinsics.checkNotNullParameter(st, "st");
        AnimPlayer.Track track = st.getTrack();
        if (track != null && (animPlayer = this.rigPlayers.get(st.getRig())) != null) {
            animPlayer.stop(track, fade);
        }
        st.setTrack(null);
        st.setWantPlay(true);
        st.setFade(fade);
        st.setWeight(weight);
        st.setSpeed(speed);
        st.setLoopsSeen(0);
        startTrack(st);
        this.rt.fire(st.getTable(), "Played", new LuaValue[0]);
    }

    public final List<LuaTable> playingTrackTables(Instance owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Instance rigOf = rigOf(owner);
        if (rigOf == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList<ScriptTrack> arrayList = this.scriptTracks;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            ScriptTrack scriptTrack = (ScriptTrack) obj;
            if (scriptTrack.getRig() == rigOf && scriptTrack.getWantPlay()) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(((ScriptTrack) it.next()).getTable());
        }
        return arrayList4;
    }

    public final void pointerDown(float xPx, float yPx) {
        aimMouse(xPx, yPx);
        this.lastPointer = new Vector2(xPx, yPx);
        LuaTable luaTable = this.mouseTable;
        if (luaTable != null) {
            this.rt.fire(luaTable, "Button1Down", new LuaValue[0]);
        }
        LuaRuntime luaRuntime = this.rt;
        Instance uisService = getUisService();
        LuaBoolean FALSE = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
        luaRuntime.fire(uisService, "InputBegan", touchInput$default(this, xPx, yPx, "Begin", 0, null, 16, null), FALSE);
        LuaRuntime luaRuntime2 = this.rt;
        Instance uisService2 = getUisService();
        LuaBoolean FALSE2 = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE2, "FALSE");
        luaRuntime2.fire(uisService2, "TouchStarted", touchInput$default(this, xPx, yPx, "Begin", 0, null, 16, null), FALSE2);
    }

    public final void pointerMove(float xPx, float yPx) {
        aimMouse(xPx, yPx);
        Vector2 vector2 = this.lastPointer;
        if (vector2 == null) {
            vector2 = new Vector2(xPx, yPx);
        }
        this.lastPointer = new Vector2(xPx, yPx);
        LuaTable luaTable = this.mouseTable;
        if (luaTable != null) {
            this.rt.fire(luaTable, "Move", new LuaValue[0]);
        }
        LuaTable luaTable2 = touchInput(xPx, yPx, "Change", 1, new Vector2(xPx - vector2.getX(), yPx - vector2.getY()));
        LuaRuntime luaRuntime = this.rt;
        Instance uisService = getUisService();
        LuaBoolean FALSE = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
        luaRuntime.fire(uisService, "InputChanged", luaTable2, FALSE);
        LuaRuntime luaRuntime2 = this.rt;
        Instance uisService2 = getUisService();
        LuaBoolean FALSE2 = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE2, "FALSE");
        luaRuntime2.fire(uisService2, "TouchMoved", luaTable2, FALSE2);
    }

    public final void pointerUp(float xPx, float yPx) {
        aimMouse(xPx, yPx);
        this.lastPointer = null;
        LuaTable luaTable = this.mouseTable;
        if (luaTable != null) {
            this.rt.fire(luaTable, "Button1Up", new LuaValue[0]);
        }
        LuaRuntime luaRuntime = this.rt;
        Instance uisService = getUisService();
        LuaBoolean FALSE = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
        luaRuntime.fire(uisService, "InputEnded", touchInput$default(this, xPx, yPx, "End", 2, null, 16, null), FALSE);
        LuaRuntime luaRuntime2 = this.rt;
        Instance uisService2 = getUisService();
        LuaBoolean FALSE2 = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE2, "FALSE");
        luaRuntime2.fire(uisService2, "TouchEnded", touchInput$default(this, xPx, yPx, "End", 2, null, 16, null), FALSE2);
    }

    public final void pressAction(String name, boolean begin) {
        Intrinsics.checkNotNullParameter(name, "name");
        ActionButton actionButton = this.actions.get(name);
        if (actionButton == null) {
            return;
        }
        EnumItemV enumItemV = begin ? new EnumItemV("UserInputState", "Begin", 0) : new EnumItemV("UserInputState", "End", 2);
        LuaTable luaTable = new LuaTable();
        luaTable.set("UserInputType", LuaTypes.INSTANCE.wrap(new EnumItemV("UserInputType", "Touch", 7)));
        luaTable.set("UserInputState", LuaTypes.INSTANCE.wrap(enumItemV));
        luaTable.set("KeyCode", LuaTypes.INSTANCE.wrap(new EnumItemV("KeyCode", "Unknown", 0)));
        luaTable.set("Position", LuaTypes.INSTANCE.wrap(Vector3.INSTANCE.getZERO()));
        LuaRuntime luaRuntime = this.rt;
        LuaValue fn = actionButton.getFn();
        Varargs varargsOf = LuaValue.varargsOf(new LuaValue[]{LuaValue.valueOf(name), LuaTypes.INSTANCE.wrap(enumItemV), luaTable});
        Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
        luaRuntime.spawn(fn, varargsOf);
    }

    @Override // com.exampletest.mobilestudiotest.model.TreeListener
    public void propChanged(Instance inst, String name) {
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.writing) {
            return;
        }
        switch (name.hashCode()) {
            case -906536396:
                if (name.equals("Anchored")) {
                    Body body = this.bodyOf.get(inst);
                    if (!Intrinsics.areEqual(inst.get("Anchored"), (Object) true) || body == null || body.getParts().size() != 1) {
                        this.physicsDirty = true;
                        return;
                    }
                    this.bodies.remove(body);
                    this.bodyOf.remove(inst);
                    if (this.statics.add(inst)) {
                        insertGrid(inst);
                        return;
                    }
                    return;
                }
                return;
            case 2577441:
                if (!name.equals("Size")) {
                    return;
                }
                break;
            case 3530753:
                if (!name.equals("size")) {
                    return;
                }
                break;
            case 1986292458:
                if (!name.equals("CFrame")) {
                    return;
                }
                break;
            default:
                return;
        }
        if (this.statics.contains(inst)) {
            updateGrid(inst);
        }
        Body body2 = this.bodyOf.get(inst);
        if (body2 != null) {
            body2.setSleeping(false);
            body2.setRestTime(0.0f);
        }
    }

    public final void requestJump() {
        this.jumpRequested = true;
    }

    public final void resetCharacter() {
        Instance instance = this.humanoid;
        if (instance == null || this.dead) {
            return;
        }
        Instance.set$default(instance, instance.getProps().containsKey("Health") ? "Health" : "Health_XML", Float.valueOf(0.0f), false, 4, null);
    }

    public final void respawn() {
        resetGui(false);
        spawnCharacter();
    }

    public final void scriptMove(Instance h, Vector3 dir) {
        Intrinsics.checkNotNullParameter(h, "h");
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (h == this.humanoid) {
            this.scriptMoveDir = dir;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b8, code lost:
    
        if (r8.equals("point") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ea, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r8, "dance", false, 2, (java.lang.Object) null) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ec, code lost:
    
        r15 = "dance";
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ee, code lost:
    
        r15 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bf, code lost:
    
        if (r8.equals("dance") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
    
        if (r8.equals("cheer") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
    
        if (r8.equals("wave") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00da, code lost:
    
        if (r8.equals("dance3") != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
    
        if (r8.equals("dance2") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0165, code lost:
    
        if (r3 != null) goto L82;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sendChat(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.sendChat(java.lang.String):void");
    }

    public final void setActionTitle(String name, String title) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        ActionButton actionButton = this.actions.get(name);
        if (actionButton != null) {
            actionButton.setTitle(title);
        }
    }

    public final void setActivePrompt(Instance instance) {
        this.activePrompt = instance;
    }

    public final void setCamDist(float f) {
        this.camDist = f;
    }

    public final void setCamPitch(float f) {
        this.camPitch = f;
    }

    public final void setCamYaw(float f) {
        this.camYaw = f;
    }

    public final void setCharacter(Instance instance) {
        this.character = instance;
    }

    public final void setChatVersion(int i) {
        this.chatVersion = i;
    }

    public final void setControlsEnabled(boolean z) {
        this.controlsEnabled = z;
    }

    public final void setCoreBackpack(boolean z) {
        this.coreBackpack = z;
    }

    public final void setCoreChat(boolean z) {
        this.coreChat = z;
    }

    public final void setCoreHealth(boolean z) {
        this.coreHealth = z;
    }

    public final void setCorePlayerList(boolean z) {
        this.corePlayerList = z;
    }

    public final void setJumpHeld(boolean down) {
        this.jumpHeld = down;
        if (down) {
            this.jumpRequested = true;
        }
    }

    public final void setKeyTurn(float f) {
        this.keyTurn = f;
    }

    public final void setLastTouchDp(Vector2 vector2) {
        this.lastTouchDp = vector2;
    }

    public final void setPlayer(Instance instance) {
        this.player = instance;
    }

    public final void setVelocity(Instance p, Vector3 v) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(v, "v");
        if (isCharacterPart(p)) {
            this.vel = v;
            if (v.getY() > 0.0f) {
                this.grounded = false;
                this.climbing = false;
                return;
            }
            return;
        }
        Body body = this.bodyOf.get(p);
        if (body != null) {
            body.setVel(v);
            body.setSleeping(false);
            body.setRestTime(0.0f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f6, code lost:
    
        if ((r11.getCharacter() == null) != false) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0442 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0329 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0205  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void spawnCharacter() {
        /*
            Method dump skipped, instructions count: 1268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.engine.PlaySession.spawnCharacter():void");
    }

    public final void start() {
        String str;
        List descendants$default;
        ArrayList<Instance> children;
        Instance findFirstChild$default;
        ArrayList<Instance> children2;
        Instance instance;
        ArrayList<Instance> arrayList;
        this.dm.getListeners().add(this);
        OutputLog.INSTANCE.info("Playtest started");
        installBridge();
        setupTextChat();
        for (Instance instance2 : Instance.descendants$default(this.dm, null, 1, null)) {
            if (Intrinsics.areEqual(instance2.getClassName(), "Script")) {
                maybeRunScript(instance2);
            }
        }
        Instance service = this.dm.getService("Players");
        Instance create = InstanceFactory.INSTANCE.create("Player");
        Context app = this.studio.getApp();
        boolean z = (RobloxApi.INSTANCE.isGuest(app) || RobloxApi.INSTANCE.userId(app) == 0) ? false : true;
        String str2 = "Player1";
        if (z) {
            String userName = RobloxApi.INSTANCE.userName(app);
            if (!(userName.length() == 0)) {
                str2 = userName;
            }
            str2 = str2;
        }
        create.setName(str2);
        create.set("UserId", Long.valueOf(z ? RobloxApi.INSTANCE.userId(app) : 1L), false);
        create.getPropTypes().put("UserId", 27);
        if (z) {
            String displayName = RobloxApi.INSTANCE.displayName(app);
            if (displayName.length() == 0) {
                displayName = str2;
            }
            str = displayName;
        } else {
            str = str2;
        }
        create.set("DisplayName", str, false);
        create.set("Character", null, false);
        create.set("Team", null, false);
        create.set("Neutral", true, false);
        create.set("AccountAge", 365, false);
        Instance findService = this.dm.findService("StarterPlayer");
        Object obj = findService != null ? findService.get("CameraMaxZoomDistance") : null;
        Number number = obj instanceof Number ? (Number) obj : null;
        create.set("CameraMaxZoomDistance", Float.valueOf(number != null ? number.floatValue() : 128.0f), false);
        Object obj2 = findService != null ? findService.get("CameraMinZoomDistance") : null;
        Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
        create.set("CameraMinZoomDistance", Float.valueOf(number2 != null ? number2.floatValue() : 0.5f), false);
        Object obj3 = findService != null ? findService.get("CameraMode") : null;
        EnumValue enumValue = obj3 instanceof EnumValue ? (EnumValue) obj3 : null;
        if (enumValue == null) {
            enumValue = new EnumValue(0);
        }
        create.set("CameraMode", enumValue, false);
        Instance create2 = InstanceFactory.INSTANCE.create("Backpack");
        create2.setName("Backpack");
        create2.attachRaw(create);
        Instance create3 = InstanceFactory.INSTANCE.create("PlayerGui");
        create3.setName("PlayerGui");
        create3.attachRaw(create);
        Instance create4 = InstanceFactory.INSTANCE.create("PlayerScripts");
        create4.setName("PlayerScripts");
        create4.attachRaw(create);
        addPlayerModule(create4);
        this.player = create;
        Instance.setParent$default(create, service, 0, 2, null);
        this.rt.fire(service, "PlayerAdded", this.rt.wrap(create));
        if (findService != null && (findFirstChild$default = Instance.findFirstChild$default(findService, "StarterPlayerScripts", false, 2, null)) != null && (children2 = findFirstChild$default.getChildren()) != null) {
            ArrayList<Instance> arrayList2 = children2;
            for (Instance instance3 : arrayList2) {
                if (Intrinsics.areEqual(instance3.getName(), "PlayerModule")) {
                    instance = service;
                    arrayList = arrayList2;
                } else {
                    instance = service;
                    arrayList = arrayList2;
                    Instance.setParent$default(instance3.cloneTree(), Instance.findFirstChild$default(create, "PlayerScripts", false, 2, null), 0, 2, null);
                }
                service = instance;
                arrayList2 = arrayList;
            }
        }
        resetGui(true);
        Instance findService2 = this.dm.findService("StarterPack");
        if (findService2 != null && (children = findService2.getChildren()) != null) {
            ArrayList<Instance> arrayList3 = children;
            boolean z2 = false;
            for (Iterator it = arrayList3.iterator(); it.hasNext(); it = it) {
                Instance.setParent$default(((Instance) it.next()).cloneTree(), Instance.findFirstChild$default(create, "Backpack", false, 2, null), 0, 2, null);
                arrayList3 = arrayList3;
                z2 = z2;
            }
        }
        Instance findService3 = this.dm.findService("ReplicatedFirst");
        if (findService3 != null && (descendants$default = Instance.descendants$default(findService3, null, 1, null)) != null) {
            Iterator it2 = descendants$default.iterator();
            while (it2.hasNext()) {
                maybeRunScript((Instance) it2.next());
            }
        }
        spawnCharacter();
        systemMessage("Chat '/?' or '/help' for a list of chat commands.", -4934476);
    }

    public final void step(float dt0) {
        float coerceIn = RangesKt.coerceIn(dt0, 0.0f, 0.05f);
        this.time += coerceIn;
        long nanoTime = System.nanoTime();
        if (this.physicsDirty) {
            rebuildPhysics();
        }
        long nanoTime2 = System.nanoTime();
        Instance runService = getRunService();
        LuaRuntime luaRuntime = this.rt;
        LuaNumber valueOf = LuaValue.valueOf(coerceIn);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        luaRuntime.fire(runService, "RenderStepped", valueOf);
        LuaRuntime luaRuntime2 = this.rt;
        LuaNumber valueOf2 = LuaValue.valueOf(coerceIn);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
        luaRuntime2.fire(runService, "PreRender", valueOf2);
        LuaRuntime luaRuntime3 = this.rt;
        LuaNumber valueOf3 = LuaValue.valueOf(this.time);
        Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(...)");
        LuaNumber valueOf4 = LuaValue.valueOf(coerceIn);
        Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(...)");
        luaRuntime3.fire(runService, "Stepped", valueOf3, valueOf4);
        LuaRuntime luaRuntime4 = this.rt;
        LuaNumber valueOf5 = LuaValue.valueOf(coerceIn);
        Intrinsics.checkNotNullExpressionValue(valueOf5, "valueOf(...)");
        luaRuntime4.fire(runService, "PreSimulation", valueOf5);
        long nanoTime3 = System.nanoTime();
        if (this.physicsDirty) {
            rebuildPhysics();
        }
        if (this.avatarApplied != Avatar.INSTANCE.getVersion()) {
            lateAvatar();
        }
        stepScriptTracks(coerceIn);
        stepCharacter(coerceIn);
        long nanoTime4 = System.nanoTime();
        stepBodies(coerceIn);
        long nanoTime5 = System.nanoTime();
        checkCharacterTouches();
        updatePrompts();
        stepBubbles(coerceIn);
        long nanoTime6 = System.nanoTime();
        LuaRuntime luaRuntime5 = this.rt;
        LuaNumber valueOf6 = LuaValue.valueOf(coerceIn);
        Intrinsics.checkNotNullExpressionValue(valueOf6, "valueOf(...)");
        luaRuntime5.fire(runService, "PostSimulation", valueOf6);
        LuaRuntime luaRuntime6 = this.rt;
        LuaNumber valueOf7 = LuaValue.valueOf(coerceIn);
        Intrinsics.checkNotNullExpressionValue(valueOf7, "valueOf(...)");
        luaRuntime6.fire(runService, "Heartbeat", valueOf7);
        long nanoTime7 = System.nanoTime();
        this.rt.step(coerceIn);
        long nanoTime8 = System.nanoTime();
        updateCamera(coerceIn);
        long[] jArr = {nanoTime, nanoTime2, nanoTime3, nanoTime4, nanoTime5, nanoTime6, nanoTime7, nanoTime8, System.nanoTime()};
        int i = 0;
        for (int i2 = 8; i < i2; i2 = 8) {
            float[] fArr = this.prof;
            fArr[i] = fArr[i] + (((float) (jArr[i + 1] - jArr[i])) / 1000000.0f);
            i++;
            jArr = jArr;
        }
        this.profN++;
        this.profT += coerceIn;
        if (this.profT > 5.0f) {
            float f = this.profN;
            String format = String.format("play: rebuild %.1f preEvents %.1f character %.1f bodies %.1f (%d) touches %.1f postEvents %.1f scripts %.1f camera %.1f", Arrays.copyOf(new Object[]{Float.valueOf(this.prof[0] / f), Float.valueOf(this.prof[1] / f), Float.valueOf(this.prof[2] / f), Float.valueOf(this.prof[3] / f), Integer.valueOf(this.bodies.size()), Float.valueOf(this.prof[4] / f), Float.valueOf(this.prof[5] / f), Float.valueOf(this.prof[6] / f), Float.valueOf(this.prof[7] / f)}, 9));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            Log.i("MobileStudioGfx", format);
            ArraysKt.fill$default(this.prof, 0.0f, 0, 0, 6, (Object) null);
            this.profN = 0;
            this.profT = 0.0f;
        }
    }

    public final void stop() {
        this.dm.getListeners().remove(this);
        this.rt.shutdown();
        OutputLog.INSTANCE.info("Playtest stopped");
    }

    public final void stopTrack(ScriptTrack st, float fade) {
        AnimPlayer animPlayer;
        Intrinsics.checkNotNullParameter(st, "st");
        boolean wantPlay = st.getWantPlay();
        st.setWantPlay(false);
        AnimPlayer.Track track = st.getTrack();
        if (track != null && (animPlayer = this.rigPlayers.get(st.getRig())) != null) {
            animPlayer.stop(track, fade);
        }
        st.setTrack(null);
        if (wantPlay) {
            this.rt.fire(st.getTable(), "Stopped", new LuaValue[0]);
            this.rt.fire(st.getTable(), "Ended", new LuaValue[0]);
        }
    }

    public final void systemMessage(String text, int color) {
        Intrinsics.checkNotNullParameter(text, "text");
        addLine(new ChatLine(null, text, color, true, 0L, 16, null));
    }

    public final void tap(float xPx, float yPx) {
        int i;
        Vector3 vector3;
        float density = this.studio.getDensity();
        Vector3 component1 = this.studio.getView().screenRay(xPx, yPx).component1();
        RayHit aimMouse = aimMouse(xPx, yPx);
        Instance uisService = getUisService();
        LuaRuntime luaRuntime = this.rt;
        LuaTable luaTable = new LuaTable();
        luaTable.set(1, LuaTypes.INSTANCE.wrap(new Vector2(xPx / density, yPx / density)));
        Unit unit = Unit.INSTANCE;
        LuaBoolean FALSE = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
        luaRuntime.fire(uisService, "TouchTap", luaTable, FALSE);
        if (aimMouse != null) {
            LuaRuntime luaRuntime2 = this.rt;
            i = 0;
            LuaBoolean FALSE2 = LuaValue.FALSE;
            Intrinsics.checkNotNullExpressionValue(FALSE2, "FALSE");
            luaRuntime2.fire(uisService, "TouchTapInWorld", LuaTypes.INSTANCE.wrap(new Vector2(xPx / density, yPx / density)), FALSE2);
            Instance part = aimMouse.getPart();
            while (true) {
                if (part == null || part == this.dm.getWorkspace()) {
                    break;
                }
                Instance findFirstChildOfClass = part.findFirstChildOfClass("ClickDetector");
                if (findFirstChildOfClass != null) {
                    Object obj = findFirstChildOfClass.get("MaxActivationDistance");
                    Number number = obj instanceof Number ? (Number) obj : null;
                    float floatValue = number != null ? number.floatValue() : 32.0f;
                    Instance instance = this.hrp;
                    if (instance == null || (vector3 = PartData.INSTANCE.cframe(instance).getPosition()) == null) {
                        vector3 = component1;
                    }
                    if (aimMouse.getPosition().minus(vector3).getMagnitude() <= floatValue) {
                        this.rt.fire(findFirstChildOfClass, "MouseClick", this.rt.wrap(this.player));
                    }
                } else {
                    part = part.getParent();
                }
            }
        } else {
            i = 0;
        }
        Instance instance2 = this.equipped;
        if (instance2 != null) {
            this.rt.fire(instance2, "Activated", new LuaValue[i]);
        }
    }

    public final void toggleShiftLock() {
        if (getShiftLockAllowed()) {
            this.shiftLock = !this.shiftLock;
        } else {
            this.shiftLock = false;
        }
    }

    public final void toggleTool(Instance t) {
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.equipped == t) {
            unequip();
        } else {
            equip(t);
        }
    }

    public final List<Instance> touchingParts(Instance p) {
        List<Instance> list;
        Intrinsics.checkNotNullParameter(p, "p");
        Set<Instance> set = this.touching.get(p);
        return (set == null || (list = CollectionsKt.toList(set)) == null) ? CollectionsKt.emptyList() : list;
    }

    public final void triggerPrompt() {
        Instance instance = this.activePrompt;
        if (instance == null) {
            return;
        }
        this.rt.fire(instance, "Triggered", this.rt.wrap(this.player));
        LuaRuntime luaRuntime = this.rt;
        Instance service = this.dm.getService("ProximityPromptService");
        service.setArchivable(false);
        luaRuntime.fire(service, "PromptTriggered", this.rt.wrap(instance), this.rt.wrap(this.player));
        this.rt.fire(instance, "TriggerEnded", this.rt.wrap(this.player));
    }

    public final void unbindAction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.actions.remove(name);
    }

    public final void unbindAll() {
        this.actions.clear();
    }

    public final void unequip() {
        Instance instance = this.equipped;
        if (instance == null) {
            return;
        }
        this.equipped = null;
        Instance instance2 = this.player;
        Instance.setParent$default(instance, instance2 != null ? Instance.findFirstChild$default(instance2, "Backpack", false, 2, null) : null, 0, 2, null);
        this.physicsDirty = true;
        this.rt.fire(instance, "Unequipped", new LuaValue[0]);
    }

    public final Vector3 velocityOf(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        if (isCharacterPart(p)) {
            return this.vel;
        }
        Body body = this.bodyOf.get(p);
        if (body != null) {
            return body.getVel();
        }
        return null;
    }
}
