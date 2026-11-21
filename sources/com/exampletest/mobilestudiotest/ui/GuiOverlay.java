package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.exampletest.mobilestudiotest.core.PluginWidget;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.lua.EnumItemV;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.lua.LuaTypes;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.ColorKey;
import com.exampletest.mobilestudiotest.model.ColorSequence;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.NumberKey;
import com.exampletest.mobilestudiotest.model.NumberSequence;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.UDim;
import com.exampletest.mobilestudiotest.model.UDim2;
import com.exampletest.mobilestudiotest.model.Vector2;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.ImageLoader;
import com.exampletest.mobilestudiotest.render.FlyCamera;
import com.exampletest.mobilestudiotest.render.ViewState;
import com.github.luben.zstd.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

/* compiled from: GuiOverlay.kt */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0002DG\b\u0007\u0018\u0000 â\u00012\u00020\u0001:\u0010à\u0001á\u0001â\u0001ã\u0001ä\u0001å\u0001æ\u0001ç\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020 H\u0002J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020SH\u0002J&\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020YJ\u0010\u0010Z\u001a\u00020;2\u0006\u0010[\u001a\u00020\\H\u0014J\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010^\u001a\u00020\u0019J\u0010\u0010_\u001a\u0004\u0018\u00010'2\u0006\u0010`\u001a\u00020\u0018J%\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010`\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000f¢\u0006\u0002\u0010eJ\u000e\u0010f\u001a\u00020 2\u0006\u0010g\u001a\u00020\u0018J\u0018\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010`\u001a\u00020\u00182\u0006\u0010j\u001a\u00020bJ\u001e\u0010k\u001a\u00020;2\u0006\u0010l\u001a\u00020i2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000fJ\u0006\u0010o\u001a\u00020;J\b\u0010r\u001a\u00020;H\u0002J\b\u0010s\u001a\u00020;H\u0002J\u0018\u0010t\u001a\u00020;2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u0019H\u0002J \u0010u\u001a\u00020;2\u0006\u0010v\u001a\u00020\u00182\u0006\u0010w\u001a\u00020\u000f2\u0006\u0010x\u001a\u00020\u000fH\u0002J\b\u0010{\u001a\u00020;H\u0002J\u0010\u0010|\u001a\u00020;2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010}\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020\u000fH\u0002J\"\u0010\u007f\u001a\u00020 2\u0006\u0010[\u001a\u00020\\2\u0007\u0010\u0080\u0001\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u000fH\u0002J\u001a\u0010\u0082\u0001\u001a\u00020 2\u0006\u0010[\u001a\u00020\\2\u0007\u0010\u0083\u0001\u001a\u00020 H\u0002J\u0016\u0010\u0084\u0001\u001a\u00030\u0085\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0002J%\u0010\u0088\u0001\u001a\u00020b2\b\u0010`\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0089\u0001\u001a\u00020L2\u0007\u0010\u008a\u0001\u001a\u00020bH\u0002J%\u0010\u008b\u0001\u001a\u00020\u000f2\b\u0010`\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0089\u0001\u001a\u00020L2\u0007\u0010\u008a\u0001\u001a\u00020\u000fH\u0002J\u001d\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u008d\u0001\u001a\u00020\u00182\u0007\u0010\u008e\u0001\u001a\u00020LH\u0002J\u0011\u0010\u008f\u0001\u001a\u00020 2\u0006\u0010g\u001a\u00020\u0018H\u0002J\u0013\u0010\u0090\u0001\u001a\u0004\u0018\u00010L2\u0006\u0010g\u001a\u00020\u0018H\u0002J#\u0010\u0091\u0001\u001a\u00020\u00192\u0007\u0010\u008d\u0001\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J,\u0010\u0093\u0001\u001a\u00020+2\u0006\u0010g\u001a\u00020\u00182\u0007\u0010\u0094\u0001\u001a\u00020\u000f2\u0007\u0010\u0095\u0001\u001a\u00020\u000f2\u0007\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J#\u0010\u0096\u0001\u001a\u00020+2\u0006\u0010g\u001a\u00020\u00182\u0007\u0010\u0097\u0001\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J\u001a\u0010\u0098\u0001\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u00182\u0007\u0010\u0099\u0001\u001a\u00020\u000fH\u0002J1\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180*2\u0007\u0010\u009b\u0001\u001a\u00020\u00182\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180*2\b\u0010v\u001a\u0004\u0018\u00010\u0018H\u0002J+\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u009e\u00010*2\u0007\u0010\u009b\u0001\u001a\u00020\u00182\u0007\u0010\u0097\u0001\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J5\u0010\u009f\u0001\u001a\u00020;2\u0006\u0010[\u001a\u00020\\2\u0007\u0010\u009b\u0001\u001a\u00020\u00182\u0007\u0010\u0097\u0001\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000f2\u0007\u0010 \u0001\u001a\u00020\u0019H\u0002J$\u0010¡\u0001\u001a\u00020;2\u0006\u0010[\u001a\u00020\\2\b\u0010¢\u0001\u001a\u00030\u009e\u00012\u0007\u0010 \u0001\u001a\u00020\u0019H\u0002J3\u0010£\u0001\u001a\u00020;2\u0006\u0010[\u001a\u00020\\2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000f2\u0007\u0010 \u0001\u001a\u00020\u0019H\u0002J\u001e\u0010¤\u0001\u001a\u00020b2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010¥\u0001\u001a\u00020bH\u0002J\u001a\u0010¦\u0001\u001a\u00020b2\u0006\u0010g\u001a\u00020b2\u0007\u0010§\u0001\u001a\u00020\u000fH\u0002J\"\u0010¨\u0001\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J&\u0010©\u0001\u001a\u0005\u0018\u00010ª\u00012\u0007\u0010«\u0001\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00192\u0007\u0010¬\u0001\u001a\u00020\u000fH\u0002J*\u0010\u00ad\u0001\u001a\u00020;2\u0006\u0010[\u001a\u00020\\2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J3\u0010®\u0001\u001a\u00020;2\u0006\u0010[\u001a\u00020\\2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00192\u0007\u0010¯\u0001\u001a\u00020\u000f2\u0007\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J\u001a\u0010°\u0001\u001a\u00030±\u00012\u0006\u0010g\u001a\u00020\u00182\u0006\u0010X\u001a\u00020YH\u0002J<\u0010²\u0001\u001a\u00020;2\u0006\u0010[\u001a\u00020\\2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010X\u001a\u00020Y2\b\u0010³\u0001\u001a\u00030±\u00012\u0006\u0010^\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J@\u0010´\u0001\u001a\u00020;2\u0006\u0010[\u001a\u00020\\2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u000f2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u0018H\u0002J#\u0010·\u0001\u001a\u00020;2\u0006\u0010[\u001a\u00020\\2\u0007\u0010¸\u0001\u001a\u00020O2\u0007\u0010\u008d\u0001\u001a\u00020\rH\u0002J\u0019\u0010¹\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ\u000f\u0010º\u0001\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0018J\u0017\u0010»\u0001\u001a\u00020 2\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ\u0017\u0010¼\u0001\u001a\u00020 2\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ\u0019\u0010½\u0001\u001a\u0004\u0018\u00010\u00152\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ!\u0010¾\u0001\u001a\u00020;2\u0006\u0010l\u001a\u00020\u00152\u0007\u0010¿\u0001\u001a\u00020\u000f2\u0007\u0010À\u0001\u001a\u00020\u000fJ\u0011\u0010Á\u0001\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0018H\u0002J\u001c\u0010Â\u0001\u001a\u00020;2\u0007\u0010Ã\u0001\u001a\u00020L2\b\u0010Ä\u0001\u001a\u00030Å\u0001H\u0002J\u0019\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ(\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120*2\u0007\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fH\u0002J \u0010É\u0001\u001a\u00020;2\u0007\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ\"\u0010Ê\u0001\u001a\u00020;2\u0007\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fH\u0002J+\u0010Ë\u0001\u001a\u00020;2\u0007\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000f2\u0007\u0010Ì\u0001\u001a\u00020 H\u0002J \u0010Í\u0001\u001a\u00020 2\u0007\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ\u001b\u0010Î\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fH\u0002J\u0011\u0010Ï\u0001\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u0018H\u0002J \u0010Ð\u0001\u001a\u00020;2\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000f2\u0007\u0010Ñ\u0001\u001a\u00020bJ \u0010Ò\u0001\u001a\u00020;2\u0007\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ)\u0010Ó\u0001\u001a\u00020;2\u0007\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000f2\u0007\u0010Ô\u0001\u001a\u00020 J\u001a\u0010×\u0001\u001a\u00030Ø\u00012\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fH\u0002J9\u0010Ù\u0001\u001a\u00030Å\u00012\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000f2\u0007\u0010Ú\u0001\u001a\u00020b2\t\b\u0002\u0010Û\u0001\u001a\u00020 2\t\b\u0002\u0010Ü\u0001\u001a\u00020 H\u0002J\u0012\u0010Ý\u0001\u001a\u00020;2\u0007\u0010\u0081\u0001\u001a\u00020\u0012H\u0002J\u0017\u0010Þ\u0001\u001a\u00020 2\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fJ\u0019\u0010ß\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0016\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u0011j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u001e\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u0011j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0&X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00101\u001a\u0004\u0018\u00010\u00182\b\u00100\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R.\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020;\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00180*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ER\u0010\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0004\n\u0002\u0010HR\u000e\u0010p\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010y\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020L0\u00170\u0011j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020L0\u0017`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010Ç\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120*0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006è\u0001"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/GuiOverlay;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "<init>", "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/core/Studio;)V", "fill", "Landroid/graphics/Paint;", "stroke", "imgPaint", "textPaint", "Landroid/text/TextPaint;", "d", "", "hits", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Hit;", "Lkotlin/collections/ArrayList;", "scrolls", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Scroll;", "picks", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Landroid/graphics/RectF;", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "newHits", "newScrolls", "newPicks", "hasContent", "", "getHasContent", "()Z", "setHasContent", "(Z)V", "boxes", "Ljava/util/IdentityHashMap;", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$EditBox;", "newBoxes", "guides", "", "", "getGuides", "()Ljava/util/List;", "setGuides", "(Ljava/util/List;)V", "_", "selectedGui", "getSelectedGui", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "setSelectedGui", "(Lcom/exampletest/mobilestudiotest/model/Instance;)V", "pressed", "getPressed", "setPressed", "onCoreMenu", "Lkotlin/Function2;", "", "getOnCoreMenu", "()Lkotlin/jvm/functions/Function2;", "setOnCoreMenu", "(Lkotlin/jvm/functions/Function2;)V", "billboards", "billboardScan", "", "layouts", "com/exampletest/mobilestudiotest/ui/GuiOverlay$layouts$1", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$layouts$1;", "scaledSizes", "com/exampletest/mobilestudiotest/ui/GuiOverlay$scaledSizes$1", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$scaledSizes$1;", "content", "", "text", "", "rich", "layoutFor", "Landroid/text/StaticLayout;", "k", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$TKey;", "scaledSize", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$SKey;", "renderSurface", "gui", "cw", "ch", "bmp", "Landroid/graphics/Bitmap;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "handlePoints", "r", "editBox", "i", "handleAt", "", "x", "y", "(Lcom/exampletest/mobilestudiotest/model/Instance;FF)Ljava/lang/Integer;", "seeThrough", "c", "beginDrag", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$DragState;", "handle", "dragTo", "s", "dx", "dy", "endDrag", "absUnit", "absInset", "useGameUnits", "usePluginUnits", "setAbs", "setContentSize", "layout", "wPx", "hPx", "absChanged", "absRounds", "fireAbsChanges", "drawTopBar", "pluginScale", "viewH", "drawPluginWidgets", "w", "h", "drawBillboards", "playing", "udim", "Lcom/exampletest/mobilestudiotest/model/UDim2;", "v", "", "enumOf", "prop", "def", "num", "child", "p", "cls", "isText", "textOf", "padded", "scale", "constrain", "w0", "h0", "sizeOf", "area", "scaleFor", "parentScale", "sortKids", "parent", "kids", "layoutChildren", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Node;", "drawChildren", "clip", "drawNode", "n", "drawScrolling", "colorOf", "default", "alpha", "transparency", "cornerOf", "gradientShader", "Landroid/graphics/Shader;", "g", "baseTransparency", "drawObject", "drawImage", "corner", "sourceRect", "Landroid/graphics/Rect;", "drawSliced", "src", "drawText", "uiStroke", "gradient", "drawRichStroke", "sl", "buttonAt", "isPluginUi", "pluginUiAt", "blocksAt", "scrollAt", "scrollBy", "dxPx", "dyPx", "mouseFor", "uisFire", NotificationCompat.CATEGORY_EVENT, "input", "Lorg/luaj/vm2/LuaValue;", "pluginFrameAt", "pressExtras", "extrasFor", "press", "releaseExtras", "hover", "enter", "canWheel", "pluginObjectAt", "pluginRt", "pluginWheel", "z", "pluginPointerMove", BuildConfig.BUILD_TYPE, "click", "lastPointer", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "guiPoint", "Lcom/exampletest/mobilestudiotest/model/Vector2;", "touchInput", "state", "mouse", "movement", "editTextBox", "tap", "pick", "Hit", "Scroll", "Companion", "EditBox", "TKey", "SKey", "DragState", "Node", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuiOverlay extends View {
    public static final int BUTTON = 0;
    public static final int CORE_MENU = 3;
    public static final int SINK = 2;
    public static final int TEXTBOX = 1;
    public static final float TOPBAR_INSET = 58.0f;
    public static final int WIDGET_CLOSE = 4;
    private final ArrayList<Pair<Instance, String>> absChanged;
    private float absInset;
    private int absRounds;
    private float absUnit;
    private long billboardScan;
    private List<? extends Instance> billboards;
    private IdentityHashMap<Instance, EditBox> boxes;
    private final float d;
    private final Paint fill;
    private volatile List<float[]> guides;
    private volatile boolean hasContent;
    private ArrayList<Hit> hits;
    private final Paint imgPaint;
    private Vector3 lastPointer;
    private final GuiOverlay$layouts$1 layouts;
    private IdentityHashMap<Instance, EditBox> newBoxes;
    private ArrayList<Hit> newHits;
    private ArrayList<Pair<Instance, RectF>> newPicks;
    private ArrayList<Scroll> newScrolls;
    private Function2<? super Float, ? super Float, Unit> onCoreMenu;
    private ArrayList<Pair<Instance, RectF>> picks;
    private final IdentityHashMap<Hit, List<Hit>> pressExtras;
    private Instance pressed;
    private LuaRuntime rt;
    private final GuiOverlay$scaledSizes$1 scaledSizes;
    private ArrayList<Scroll> scrolls;
    private final Paint stroke;
    private final Studio studio;
    private final TextPaint textPaint;

    /* compiled from: GuiOverlay.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$DragState;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "handle", "", "start", "Landroid/graphics/RectF;", "area", "unit", "", "pos", "Lcom/exampletest/mobilestudiotest/model/UDim2;", "size", "anchor", "Lcom/exampletest/mobilestudiotest/model/Vector2;", "inLayout", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;ILandroid/graphics/RectF;Landroid/graphics/RectF;FLcom/exampletest/mobilestudiotest/model/UDim2;Lcom/exampletest/mobilestudiotest/model/UDim2;Lcom/exampletest/mobilestudiotest/model/Vector2;Z)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getHandle", "()I", "getStart", "()Landroid/graphics/RectF;", "getArea", "getUnit", "()F", "getPos", "()Lcom/exampletest/mobilestudiotest/model/UDim2;", "getSize", "getAnchor", "()Lcom/exampletest/mobilestudiotest/model/Vector2;", "getInLayout", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DragState {
        private final Vector2 anchor;
        private final RectF area;
        private final int handle;
        private final boolean inLayout;
        private final Instance inst;
        private final UDim2 pos;
        private final UDim2 size;
        private final RectF start;
        private final float unit;

        public DragState(Instance inst, int i, RectF start, RectF area, float f, UDim2 pos, UDim2 size, Vector2 anchor, boolean z) {
            Intrinsics.checkNotNullParameter(inst, "inst");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(area, "area");
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            this.inst = inst;
            this.handle = i;
            this.start = start;
            this.area = area;
            this.unit = f;
            this.pos = pos;
            this.size = size;
            this.anchor = anchor;
            this.inLayout = z;
        }

        public final Vector2 getAnchor() {
            return this.anchor;
        }

        public final RectF getArea() {
            return this.area;
        }

        public final int getHandle() {
            return this.handle;
        }

        public final boolean getInLayout() {
            return this.inLayout;
        }

        public final Instance getInst() {
            return this.inst;
        }

        public final UDim2 getPos() {
            return this.pos;
        }

        public final UDim2 getSize() {
            return this.size;
        }

        public final RectF getStart() {
            return this.start;
        }

        public final float getUnit() {
            return this.unit;
        }
    }

    /* compiled from: GuiOverlay.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$EditBox;", "", "rect", "Landroid/graphics/RectF;", "area", "scale", "", "inLayout", "", "<init>", "(Landroid/graphics/RectF;Landroid/graphics/RectF;FZ)V", "getRect", "()Landroid/graphics/RectF;", "getArea", "getScale", "()F", "getInLayout", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class EditBox {
        private final RectF area;
        private final boolean inLayout;
        private final RectF rect;
        private final float scale;

        public EditBox(RectF rect, RectF area, float f, boolean z) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(area, "area");
            this.rect = rect;
            this.area = area;
            this.scale = f;
            this.inLayout = z;
        }

        public final RectF getArea() {
            return this.area;
        }

        public final boolean getInLayout() {
            return this.inLayout;
        }

        public final RectF getRect() {
            return this.rect;
        }

        public final float getScale() {
            return this.scale;
        }
    }

    /* compiled from: GuiOverlay.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Hit;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "rect", "Landroid/graphics/RectF;", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "kind", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Landroid/graphics/RectF;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;I)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getRect", "()Landroid/graphics/RectF;", "getRt", "()Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "getKind", "()I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Hit {
        private final Instance inst;
        private final int kind;
        private final RectF rect;
        private final LuaRuntime rt;

        public Hit(Instance inst, RectF rect, LuaRuntime luaRuntime, int i) {
            Intrinsics.checkNotNullParameter(inst, "inst");
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.inst = inst;
            this.rect = rect;
            this.rt = luaRuntime;
            this.kind = i;
        }

        public final Instance getInst() {
            return this.inst;
        }

        public final int getKind() {
            return this.kind;
        }

        public final RectF getRect() {
            return this.rect;
        }

        public final LuaRuntime getRt() {
            return this.rt;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GuiOverlay.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Node;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "rect", "Landroid/graphics/RectF;", "scale", "", "area", "inLayout", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Landroid/graphics/RectF;FLandroid/graphics/RectF;Z)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getRect", "()Landroid/graphics/RectF;", "getScale", "()F", "getArea", "getInLayout", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Node {
        private final RectF area;
        private final boolean inLayout;
        private final Instance inst;
        private final RectF rect;
        private final float scale;

        public Node(Instance inst, RectF rect, float f, RectF rectF, boolean z) {
            Intrinsics.checkNotNullParameter(inst, "inst");
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.inst = inst;
            this.rect = rect;
            this.scale = f;
            this.area = rectF;
            this.inLayout = z;
        }

        public /* synthetic */ Node(Instance instance, RectF rectF, float f, RectF rectF2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(instance, rectF, f, (i & 8) != 0 ? null : rectF2, (i & 16) != 0 ? false : z);
        }

        public final RectF getArea() {
            return this.area;
        }

        public final boolean getInLayout() {
            return this.inLayout;
        }

        public final Instance getInst() {
            return this.inst;
        }

        public final RectF getRect() {
            return this.rect;
        }

        public final float getScale() {
            return this.scale;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GuiOverlay.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b!\b\u0082\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003Jc\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rHÆ\u0001J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\nHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001d¨\u0006."}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$SKey;", "", "text", "", "rich", "", "tf", "Landroid/graphics/Typeface;", "bold", "w", "", "h", "max", "", "min", "lineHeight", "<init>", "(Ljava/lang/String;ZLandroid/graphics/Typeface;ZIIFFF)V", "getText", "()Ljava/lang/String;", "getRich", "()Z", "getTf", "()Landroid/graphics/Typeface;", "getBold", "getW", "()I", "getH", "getMax", "()F", "getMin", "getLineHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SKey {
        private final boolean bold;
        private final int h;
        private final float lineHeight;
        private final float max;
        private final float min;
        private final boolean rich;
        private final String text;
        private final Typeface tf;
        private final int w;

        public SKey(String text, boolean z, Typeface tf, boolean z2, int i, int i2, float f, float f2, float f3) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(tf, "tf");
            this.text = text;
            this.rich = z;
            this.tf = tf;
            this.bold = z2;
            this.w = i;
            this.h = i2;
            this.max = f;
            this.min = f2;
            this.lineHeight = f3;
        }

        public static /* synthetic */ SKey copy$default(SKey sKey, String str, boolean z, Typeface typeface, boolean z2, int i, int i2, float f, float f2, float f3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = sKey.text;
            }
            if ((i3 & 2) != 0) {
                z = sKey.rich;
            }
            if ((i3 & 4) != 0) {
                typeface = sKey.tf;
            }
            if ((i3 & 8) != 0) {
                z2 = sKey.bold;
            }
            if ((i3 & 16) != 0) {
                i = sKey.w;
            }
            if ((i3 & 32) != 0) {
                i2 = sKey.h;
            }
            if ((i3 & 64) != 0) {
                f = sKey.max;
            }
            if ((i3 & 128) != 0) {
                f2 = sKey.min;
            }
            if ((i3 & 256) != 0) {
                f3 = sKey.lineHeight;
            }
            float f4 = f2;
            float f5 = f3;
            int i4 = i2;
            float f6 = f;
            int i5 = i;
            Typeface typeface2 = typeface;
            return sKey.copy(str, z, typeface2, z2, i5, i4, f6, f4, f5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getRich() {
            return this.rich;
        }

        /* renamed from: component3, reason: from getter */
        public final Typeface getTf() {
            return this.tf;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getBold() {
            return this.bold;
        }

        /* renamed from: component5, reason: from getter */
        public final int getW() {
            return this.w;
        }

        /* renamed from: component6, reason: from getter */
        public final int getH() {
            return this.h;
        }

        /* renamed from: component7, reason: from getter */
        public final float getMax() {
            return this.max;
        }

        /* renamed from: component8, reason: from getter */
        public final float getMin() {
            return this.min;
        }

        /* renamed from: component9, reason: from getter */
        public final float getLineHeight() {
            return this.lineHeight;
        }

        public final SKey copy(String text, boolean rich, Typeface tf, boolean bold, int w, int h, float max, float min, float lineHeight) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(tf, "tf");
            return new SKey(text, rich, tf, bold, w, h, max, min, lineHeight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SKey)) {
                return false;
            }
            SKey sKey = (SKey) other;
            return Intrinsics.areEqual(this.text, sKey.text) && this.rich == sKey.rich && Intrinsics.areEqual(this.tf, sKey.tf) && this.bold == sKey.bold && this.w == sKey.w && this.h == sKey.h && Float.compare(this.max, sKey.max) == 0 && Float.compare(this.min, sKey.min) == 0 && Float.compare(this.lineHeight, sKey.lineHeight) == 0;
        }

        public final boolean getBold() {
            return this.bold;
        }

        public final int getH() {
            return this.h;
        }

        public final float getLineHeight() {
            return this.lineHeight;
        }

        public final float getMax() {
            return this.max;
        }

        public final float getMin() {
            return this.min;
        }

        public final boolean getRich() {
            return this.rich;
        }

        public final String getText() {
            return this.text;
        }

        public final Typeface getTf() {
            return this.tf;
        }

        public final int getW() {
            return this.w;
        }

        public int hashCode() {
            return (((((((((((((((this.text.hashCode() * 31) + Boolean.hashCode(this.rich)) * 31) + this.tf.hashCode()) * 31) + Boolean.hashCode(this.bold)) * 31) + Integer.hashCode(this.w)) * 31) + Integer.hashCode(this.h)) * 31) + Float.hashCode(this.max)) * 31) + Float.hashCode(this.min)) * 31) + Float.hashCode(this.lineHeight);
        }

        public String toString() {
            return "SKey(text=" + this.text + ", rich=" + this.rich + ", tf=" + this.tf + ", bold=" + this.bold + ", w=" + this.w + ", h=" + this.h + ", max=" + this.max + ", min=" + this.min + ", lineHeight=" + this.lineHeight + ")";
        }
    }

    /* compiled from: GuiOverlay.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Scroll;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "rect", "Landroid/graphics/RectF;", "maxX", "", "maxY", "unit", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Landroid/graphics/RectF;FFF)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getRect", "()Landroid/graphics/RectF;", "getMaxX", "()F", "getMaxY", "getUnit", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Scroll {
        private final Instance inst;
        private final float maxX;
        private final float maxY;
        private final RectF rect;
        private final float unit;

        public Scroll(Instance inst, RectF rect, float f, float f2, float f3) {
            Intrinsics.checkNotNullParameter(inst, "inst");
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.inst = inst;
            this.rect = rect;
            this.maxX = f;
            this.maxY = f2;
            this.unit = f3;
        }

        public final Instance getInst() {
            return this.inst;
        }

        public final float getMaxX() {
            return this.maxX;
        }

        public final float getMaxY() {
            return this.maxY;
        }

        public final RectF getRect() {
            return this.rect;
        }

        public final float getUnit() {
            return this.unit;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GuiOverlay.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0082\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003Jc\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\fHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00060"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$TKey;", "", "text", "", "rich", "", "tf", "Landroid/graphics/Typeface;", "bold", "size", "", "width", "", "align", "Landroid/text/Layout$Alignment;", "lineHeight", "truncate", "<init>", "(Ljava/lang/String;ZLandroid/graphics/Typeface;ZFILandroid/text/Layout$Alignment;FZ)V", "getText", "()Ljava/lang/String;", "getRich", "()Z", "getTf", "()Landroid/graphics/Typeface;", "getBold", "getSize", "()F", "getWidth", "()I", "getAlign", "()Landroid/text/Layout$Alignment;", "getLineHeight", "getTruncate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class TKey {
        private final Layout.Alignment align;
        private final boolean bold;
        private final float lineHeight;
        private final boolean rich;
        private final float size;
        private final String text;
        private final Typeface tf;
        private final boolean truncate;
        private final int width;

        public TKey(String text, boolean z, Typeface tf, boolean z2, float f, int i, Layout.Alignment align, float f2, boolean z3) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(tf, "tf");
            Intrinsics.checkNotNullParameter(align, "align");
            this.text = text;
            this.rich = z;
            this.tf = tf;
            this.bold = z2;
            this.size = f;
            this.width = i;
            this.align = align;
            this.lineHeight = f2;
            this.truncate = z3;
        }

        public static /* synthetic */ TKey copy$default(TKey tKey, String str, boolean z, Typeface typeface, boolean z2, float f, int i, Layout.Alignment alignment, float f2, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = tKey.text;
            }
            if ((i2 & 2) != 0) {
                z = tKey.rich;
            }
            if ((i2 & 4) != 0) {
                typeface = tKey.tf;
            }
            if ((i2 & 8) != 0) {
                z2 = tKey.bold;
            }
            if ((i2 & 16) != 0) {
                f = tKey.size;
            }
            if ((i2 & 32) != 0) {
                i = tKey.width;
            }
            if ((i2 & 64) != 0) {
                alignment = tKey.align;
            }
            if ((i2 & 128) != 0) {
                f2 = tKey.lineHeight;
            }
            if ((i2 & 256) != 0) {
                z3 = tKey.truncate;
            }
            float f3 = f2;
            boolean z4 = z3;
            int i3 = i;
            Layout.Alignment alignment2 = alignment;
            float f4 = f;
            Typeface typeface2 = typeface;
            return tKey.copy(str, z, typeface2, z2, f4, i3, alignment2, f3, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getRich() {
            return this.rich;
        }

        /* renamed from: component3, reason: from getter */
        public final Typeface getTf() {
            return this.tf;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getBold() {
            return this.bold;
        }

        /* renamed from: component5, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        /* renamed from: component6, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component7, reason: from getter */
        public final Layout.Alignment getAlign() {
            return this.align;
        }

        /* renamed from: component8, reason: from getter */
        public final float getLineHeight() {
            return this.lineHeight;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getTruncate() {
            return this.truncate;
        }

        public final TKey copy(String text, boolean rich, Typeface tf, boolean bold, float size, int width, Layout.Alignment align, float lineHeight, boolean truncate) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(tf, "tf");
            Intrinsics.checkNotNullParameter(align, "align");
            return new TKey(text, rich, tf, bold, size, width, align, lineHeight, truncate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TKey)) {
                return false;
            }
            TKey tKey = (TKey) other;
            return Intrinsics.areEqual(this.text, tKey.text) && this.rich == tKey.rich && Intrinsics.areEqual(this.tf, tKey.tf) && this.bold == tKey.bold && Float.compare(this.size, tKey.size) == 0 && this.width == tKey.width && this.align == tKey.align && Float.compare(this.lineHeight, tKey.lineHeight) == 0 && this.truncate == tKey.truncate;
        }

        public final Layout.Alignment getAlign() {
            return this.align;
        }

        public final boolean getBold() {
            return this.bold;
        }

        public final float getLineHeight() {
            return this.lineHeight;
        }

        public final boolean getRich() {
            return this.rich;
        }

        public final float getSize() {
            return this.size;
        }

        public final String getText() {
            return this.text;
        }

        public final Typeface getTf() {
            return this.tf;
        }

        public final boolean getTruncate() {
            return this.truncate;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((((((((((((((this.text.hashCode() * 31) + Boolean.hashCode(this.rich)) * 31) + this.tf.hashCode()) * 31) + Boolean.hashCode(this.bold)) * 31) + Float.hashCode(this.size)) * 31) + Integer.hashCode(this.width)) * 31) + this.align.hashCode()) * 31) + Float.hashCode(this.lineHeight)) * 31) + Boolean.hashCode(this.truncate);
        }

        public String toString() {
            return "TKey(text=" + this.text + ", rich=" + this.rich + ", tf=" + this.tf + ", bold=" + this.bold + ", size=" + this.size + ", width=" + this.width + ", align=" + this.align + ", lineHeight=" + this.lineHeight + ", truncate=" + this.truncate + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiOverlay(Context ctx, Studio studio) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(studio, "studio");
        this.studio = studio;
        this.fill = new Paint(1);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        this.stroke = paint;
        this.imgPaint = new Paint(3);
        this.textPaint = new TextPaint(1);
        this.d = getResources().getDisplayMetrics().density;
        this.hits = new ArrayList<>();
        this.scrolls = new ArrayList<>();
        this.picks = new ArrayList<>();
        this.newHits = new ArrayList<>();
        this.newScrolls = new ArrayList<>();
        this.newPicks = new ArrayList<>();
        this.boxes = new IdentityHashMap<>();
        this.newBoxes = new IdentityHashMap<>();
        this.guides = CollectionsKt.emptyList();
        this.billboards = CollectionsKt.emptyList();
        ImageLoader.INSTANCE.getListeners().add(new GuiOverlay$$ExternalSyntheticLambda2(this));
        this.layouts = new GuiOverlay$layouts$1();
        this.scaledSizes = new GuiOverlay$scaledSizes$1();
        this.absInset = 58.0f;
        this.absChanged = new ArrayList<>();
        this.pressExtras = new IdentityHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$2(GuiOverlay guiOverlay, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        guiOverlay.postInvalidate();
        return Unit.INSTANCE;
    }

    private final int alpha(int c, float transparency) {
        return (16777215 & c) | (((int) ((1.0f - RangesKt.coerceIn(transparency, 0.0f, 1.0f)) * ((c >>> 24) & 255))) << 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Instance canWheel$lambda$92$lambda$89(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getParent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean canWheel$lambda$92$lambda$90(Instance it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !Intrinsics.areEqual(it.getClassName(), "CoreGui");
    }

    private final Instance child(Instance p, String cls) {
        Object obj;
        Iterator<T> it = p.getChildren().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Instance) obj).getClassName(), cls)) {
                break;
            }
        }
        return (Instance) obj;
    }

    private final int colorOf(Object v, int r3) {
        Color3 color3 = v instanceof Color3 ? (Color3) v : null;
        return color3 != null ? color3.toArgb() : r3;
    }

    private final float[] constrain(Instance c, float w0, float h0, float scale) {
        float f = w0;
        float f2 = h0;
        Iterator<Instance> it = c.getChildren().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                return new float[]{f, f2};
            }
            Instance next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Instance instance = next;
            String className = instance.getClassName();
            if (Intrinsics.areEqual(className, "UIAspectRatioConstraint")) {
                Float valueOf = Float.valueOf(num(instance, "AspectRatio", 1.0f));
                Float f3 = valueOf.floatValue() > 0.0f ? valueOf : null;
                float floatValue = f3 != null ? f3.floatValue() : 1.0f;
                if (enumOf(instance, "AspectType", 0) == 0) {
                    if (f2 <= 0.0f || f / f2 <= floatValue) {
                        f2 = f / floatValue;
                    } else {
                        f = f2 * floatValue;
                    }
                } else if (enumOf(instance, "DominantAxis", 0) == 0) {
                    f2 = f / floatValue;
                } else {
                    f = f2 * floatValue;
                }
            } else if (Intrinsics.areEqual(className, "UISizeConstraint")) {
                Object obj = instance.get("MinSize");
                Vector2 vector2 = obj instanceof Vector2 ? (Vector2) obj : null;
                if (vector2 == null) {
                    vector2 = new Vector2(0.0f, 0.0f);
                }
                Object obj2 = instance.get("MaxSize");
                Vector2 vector22 = obj2 instanceof Vector2 ? (Vector2) obj2 : null;
                if (vector22 == null) {
                    vector22 = new Vector2(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
                }
                f = RangesKt.coerceIn(f, vector2.getX() * this.d * scale, Math.max(vector2.getX(), vector22.getX()) * this.d * scale);
                f2 = RangesKt.coerceIn(f2, vector2.getY() * this.d * scale, Math.max(vector2.getY(), vector22.getY()) * this.d * scale);
            }
        }
    }

    private final CharSequence content(String text, boolean rich) {
        return rich ? RichText.INSTANCE.parse(text) : text;
    }

    private final float cornerOf(Instance c, RectF r, float scale) {
        Instance child = child(c, "UICorner");
        if (child == null) {
            return 0.0f;
        }
        Object obj = child.get("CornerRadius");
        UDim uDim = obj instanceof UDim ? (UDim) obj : null;
        return RangesKt.coerceIn(uDim != null ? (uDim.getScale() * Math.min(r.width(), r.height())) + (uDim.getOffset() * this.d * scale) : this.d * 8.0f * scale, 0.0f, Math.min(r.width(), r.height()) / 2.0f);
    }

    private static final Pair<Float, Float> dragTo$lambda$23$best(float f, List<Float> list, List<Float> list2) {
        float f2 = f;
        Pair<Float, Float> pair = null;
        Iterator<Float> it = list.iterator();
        while (it.hasNext()) {
            float floatValue = it.next().floatValue();
            Iterator<Float> it2 = list2.iterator();
            while (it2.hasNext()) {
                float floatValue2 = it2.next().floatValue();
                float f3 = floatValue2 - floatValue;
                if (Math.abs(f3) < f2) {
                    f2 = Math.abs(f3);
                    pair = TuplesKt.to(Float.valueOf(f3), Float.valueOf(floatValue2));
                }
            }
        }
        return pair;
    }

    private static final float dragTo$snapV(float f, float f2, float f3) {
        return (Math.round((f2 - f3) / f) * f) + f3;
    }

    private final boolean drawBillboards(Canvas canvas, boolean playing) {
        char c;
        boolean z;
        Vector3 plus;
        float f;
        PlaySession play;
        Instance player;
        Instance findFirstChild$default;
        List<Instance> descendants$default;
        List<Instance> descendants$default2;
        GuiOverlay guiOverlay = this;
        long currentTimeMillis = System.currentTimeMillis();
        char c2 = 2;
        boolean z2 = false;
        Instance instance = null;
        if (currentTimeMillis - guiOverlay.billboardScan > 500) {
            guiOverlay.billboardScan = currentTimeMillis;
            ArrayList arrayList = new ArrayList();
            Instance findService = guiOverlay.studio.getModel().findService("Workspace");
            if (findService != null && (descendants$default2 = Instance.descendants$default(findService, null, 1, null)) != null) {
                for (Instance instance2 : descendants$default2) {
                    if (Intrinsics.areEqual(instance2.getClassName(), "BillboardGui")) {
                        arrayList.add(instance2);
                    }
                }
            }
            if (playing && (play = guiOverlay.studio.getPlay()) != null && (player = play.getPlayer()) != null && (findFirstChild$default = Instance.findFirstChild$default(player, "PlayerGui", false, 2, null)) != null && (descendants$default = Instance.descendants$default(findFirstChild$default, null, 1, null)) != null) {
                for (Instance instance3 : descendants$default) {
                    if (Intrinsics.areEqual(instance3.getClassName(), "BillboardGui") && (instance3.get("Adornee") instanceof Instance)) {
                        arrayList.add(instance3);
                    }
                }
            }
            guiOverlay.billboards = arrayList;
        }
        if (guiOverlay.billboards.isEmpty()) {
            return false;
        }
        ViewState view = guiOverlay.studio.getView();
        FlyCamera camera = guiOverlay.studio.getCamera();
        float tan = (float) Math.tan(Math.toRadians(camera.getFov() / 2.0d));
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends Instance> it = guiOverlay.billboards.iterator();
        while (it.hasNext()) {
            Instance next = it.next();
            if (next.getParent() == null) {
                instance = null;
            } else if (!Intrinsics.areEqual(next.get("Enabled"), Boolean.valueOf(z2))) {
                Object obj = next.get("Adornee");
                Instance instance4 = obj instanceof Instance ? (Instance) obj : instance;
                if (instance4 != null || (instance4 = next.getParent()) != null) {
                    if (instance4.isA("BasePart")) {
                        Vector3 position = PartData.INSTANCE.cframe(instance4).getPosition();
                        c = c2;
                        CFrame rotationOnly = PartData.INSTANCE.cframe(instance4).rotationOnly();
                        z = z2;
                        Object obj2 = next.get("ExtentsOffset");
                        Vector3 vector3 = obj2 instanceof Vector3 ? (Vector3) obj2 : null;
                        if (vector3 == null) {
                            vector3 = Vector3.INSTANCE.getZERO();
                        }
                        plus = position.plus(rotationOnly.times(vector3));
                        f = 1.0f;
                    } else {
                        c = c2;
                        z = z2;
                        if (Intrinsics.areEqual(instance4.getClassName(), "Attachment")) {
                            Instance parent = instance4.getParent();
                            if (parent != null) {
                                if (!parent.isA("BasePart")) {
                                    parent = null;
                                }
                                if (parent != null) {
                                    CFrame cframe = PartData.INSTANCE.cframe(parent);
                                    Object obj3 = instance4.get("CFrame");
                                    f = 1.0f;
                                    CFrame cFrame = obj3 instanceof CFrame ? (CFrame) obj3 : null;
                                    if (cFrame == null) {
                                        cFrame = CFrame.INSTANCE.getIDENTITY();
                                    }
                                    plus = cframe.times(cFrame.getPosition());
                                    if (plus != null) {
                                    }
                                }
                            }
                            c2 = c;
                            z2 = z;
                            instance = null;
                        } else {
                            f = 1.0f;
                            if (instance4.isA("Model")) {
                                Object obj4 = instance4.get("PrimaryPart");
                                Instance instance5 = obj4 instanceof Instance ? (Instance) obj4 : null;
                                if (instance5 == null) {
                                    instance5 = instance4.findFirstChildWhichIsA("BasePart", true);
                                }
                                if (instance5 == null || (plus = PartData.INSTANCE.cframe(instance5).getPosition()) == null) {
                                    c2 = c;
                                    z2 = z;
                                    it = it;
                                    instance = null;
                                }
                            } else {
                                c2 = c;
                                z2 = z;
                                instance = null;
                            }
                        }
                    }
                    Object obj5 = next.get("StudsOffset");
                    Vector3 vector32 = obj5 instanceof Vector3 ? (Vector3) obj5 : null;
                    if (vector32 == null) {
                        vector32 = Vector3.INSTANCE.getZERO();
                    }
                    Object obj6 = next.get("StudsOffsetWorldSpace");
                    Vector3 vector33 = obj6 instanceof Vector3 ? (Vector3) obj6 : null;
                    if (vector33 == null) {
                        vector33 = Vector3.INSTANCE.getZERO();
                    }
                    Vector3 minus = plus.plus(vector33).plus(camera.getRight().times(vector32.getX())).plus(camera.getUp().times(vector32.getY())).minus(camera.getForward().times(vector32.getZ()));
                    float distTo = view.distTo(minus);
                    Object obj7 = next.get("MaxDistance");
                    Iterator<? extends Instance> it2 = it;
                    Number number = obj7 instanceof Number ? (Number) obj7 : null;
                    if (distTo > (number != null ? number.floatValue() : Float.POSITIVE_INFINITY)) {
                        c2 = c;
                        z2 = z;
                        it = it2;
                        instance = null;
                    } else if (distTo < 0.1f) {
                        c2 = c;
                        z2 = z;
                        it = it2;
                        instance = null;
                    } else {
                        float[] project = view.project(minus);
                        if (project == null) {
                            c2 = c;
                            z2 = z;
                            it = it2;
                            instance = null;
                        } else if (project[c] <= f) {
                            arrayList2.add(new Triple(next, project, Float.valueOf(distTo)));
                            c2 = c;
                            z2 = z;
                            it = it2;
                            instance = null;
                        } else {
                            c2 = c;
                            z2 = z;
                            it = it2;
                            instance = null;
                        }
                    }
                }
            }
        }
        boolean z3 = z2;
        if (arrayList2.isEmpty()) {
            return z3;
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.size() > 1) {
            CollectionsKt.sortWith(arrayList3, new GuiOverlay$drawBillboards$$inlined$sortByDescending$1());
        }
        Iterator it3 = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next2 = it3.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            Triple triple = (Triple) next2;
            Instance instance6 = (Instance) triple.component1();
            float[] fArr = (float[]) triple.component2();
            float height = guiOverlay.getHeight() / ((((Number) triple.component3()).floatValue() * 2.0f) * tan);
            UDim2 udim = guiOverlay.udim(instance6.get("Size"));
            float xs = (udim.getXs() * height) + (udim.getXo() * guiOverlay.d);
            float ys = (udim.getYs() * height) + (udim.getYo() * guiOverlay.d);
            if (xs < 1.0f) {
                guiOverlay = this;
            } else if (ys >= 1.0f) {
                Object obj8 = instance6.get("SizeOffset");
                Vector2 vector2 = obj8 instanceof Vector2 ? (Vector2) obj8 : null;
                if (vector2 == null) {
                    vector2 = new Vector2(0.0f, 0.0f);
                }
                Vector2 vector22 = vector2;
                float x = (fArr[z3 ? 1 : 0] - (xs / 2.0f)) + (vector22.getX() * xs);
                float y = (fArr[1] - (ys / 2.0f)) - (vector22.getY() * ys);
                RectF rectF = new RectF(x, y, x + xs, y + ys);
                if (RectF.intersects(rectF, new RectF(0.0f, 0.0f, getWidth(), getHeight()))) {
                    boolean areEqual = Intrinsics.areEqual(instance6.get("ClipsDescendants"), (Object) true);
                    if (areEqual) {
                        canvas.save();
                        canvas.clipRect(rectF);
                    }
                    drawChildren(canvas, instance6, rectF, 1.0f, areEqual ? rectF : new RectF(0.0f, 0.0f, getWidth(), getHeight()));
                    if (areEqual) {
                        canvas.restore();
                        guiOverlay = this;
                    } else {
                        guiOverlay = this;
                    }
                } else {
                    guiOverlay = this;
                }
            }
        }
        return true;
    }

    private final void drawChildren(Canvas canvas, Instance parent, RectF area, float scale, RectF clip) {
        Iterator<Node> it = layoutChildren(parent, padded(parent, area, scale), scale).iterator();
        while (it.hasNext()) {
            drawNode(canvas, it.next(), clip);
        }
    }

    private final void drawImage(Canvas canvas, Instance c, RectF r, float corner, float scale) {
        Object obj;
        String obj2;
        Bitmap bitmap;
        float num = num(c, "ImageTransparency", 0.0f);
        if (num >= 1.0f || (obj = c.get("Image")) == null || (obj2 = obj.toString()) == null || (bitmap = ImageLoader.INSTANCE.get(obj2)) == null) {
            return;
        }
        this.imgPaint.setAlpha((int) ((1.0f - num) * 255.0f));
        int colorOf = colorOf(c.get("ImageColor3"), -1);
        this.imgPaint.setColorFilter((colorOf & ViewCompat.MEASURED_SIZE_MASK) != 16777215 ? new LightingColorFilter(16777215 & colorOf, 0) : null);
        Rect sourceRect = sourceRect(c, bitmap);
        canvas.save();
        if (corner > 0.0f) {
            Path path = new Path();
            path.addRoundRect(r, corner, corner, Path.Direction.CW);
            canvas.clipPath(path);
        }
        switch (enumOf(c, "ScaleType", 0)) {
            case 1:
                drawSliced(canvas, c, bitmap, sourceRect, r, scale);
                break;
            case 2:
                Object obj3 = c.get("TileSize");
                if (obj3 == null) {
                    obj3 = new UDim2(1.0f, 0, 1.0f, 0);
                }
                UDim2 udim = udim(obj3);
                float coerceAtLeast = RangesKt.coerceAtLeast((udim.getXs() * r.width()) + (udim.getXo() * this.d * scale), 2.0f);
                float coerceAtLeast2 = RangesKt.coerceAtLeast((udim.getYs() * r.height()) + (udim.getYo() * this.d * scale), 2.0f);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, sourceRect.left, sourceRect.top, RangesKt.coerceAtLeast(sourceRect.width(), 1), RangesKt.coerceAtLeast(sourceRect.height(), 1));
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
                BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                Matrix matrix = new Matrix();
                matrix.setScale(coerceAtLeast / createBitmap.getWidth(), coerceAtLeast2 / createBitmap.getHeight());
                matrix.postTranslate(r.left, r.top);
                bitmapShader.setLocalMatrix(matrix);
                this.imgPaint.setShader(bitmapShader);
                canvas.drawRect(r, this.imgPaint);
                this.imgPaint.setShader(null);
                break;
            case 3:
                float min = Math.min(r.width() / sourceRect.width(), r.height() / sourceRect.height());
                float width = sourceRect.width() * min;
                float height = sourceRect.height() * min;
                canvas.drawBitmap(bitmap, sourceRect, new RectF(r.centerX() - (width / 2.0f), r.centerY() - (height / 2.0f), r.centerX() + (width / 2.0f), r.centerY() + (height / 2.0f)), this.imgPaint);
                break;
            case 4:
                float max = Math.max(r.width() / sourceRect.width(), r.height() / sourceRect.height());
                float width2 = r.width() / max;
                float height2 = r.height() / max;
                canvas.drawBitmap(bitmap, new Rect((int) (sourceRect.exactCenterX() - (width2 / 2.0f)), (int) (sourceRect.exactCenterY() - (height2 / 2.0f)), (int) (sourceRect.exactCenterX() + (width2 / 2.0f)), (int) (sourceRect.exactCenterY() + (height2 / 2.0f))), r, this.imgPaint);
                break;
            default:
                canvas.drawBitmap(bitmap, sourceRect, r, this.imgPaint);
                break;
        }
        canvas.restore();
    }

    private final void drawNode(Canvas canvas, Node n, RectF clip) {
        Canvas canvas2;
        RectF rectF;
        Instance inst = n.getInst();
        RectF rect = n.getRect();
        setAbs(inst, rect);
        if ((rect.width() <= 0.0f || rect.height() <= 0.0f) && !Intrinsics.areEqual(inst.getClassName(), "ScrollingFrame") && Intrinsics.areEqual(inst.get("ClipsDescendants"), (Object) true)) {
            return;
        }
        float num = num(inst, "Rotation", 0.0f);
        float num2 = Intrinsics.areEqual(inst.getClassName(), "CanvasGroup") ? num(inst, "GroupTransparency", 0.0f) : 0.0f;
        if (num2 >= 0.999f) {
            return;
        }
        int save = canvas.save();
        if (!(num == 0.0f)) {
            canvas.rotate(num, rect.centerX(), rect.centerY());
        }
        if (num2 > 0.001f) {
            canvas.saveLayerAlpha(rect, (int) ((1.0f - num2) * 255.0f));
        }
        drawObject(canvas, inst, rect, n.getScale());
        RectF rectF2 = new RectF(rect);
        RectF rectF3 = new RectF(rect);
        if (!rectF3.intersect(clip)) {
            rectF3.setEmpty();
        }
        if (n.getArea() != null && !this.studio.isPlaying()) {
            this.newBoxes.put(inst, new EditBox(new RectF(rect), new RectF(n.getArea()), n.getScale(), n.getInLayout()));
        }
        if (!rectF3.isEmpty()) {
            this.newPicks.add(TuplesKt.to(inst, new RectF(rect)));
            if (Intrinsics.areEqual(inst.getClassName(), "TextBox")) {
                this.newHits.add(new Hit(inst, rectF3, this.rt, 1));
            } else if (inst.isA("GuiButton")) {
                this.newHits.add(new Hit(inst, rectF3, this.rt, 0));
            } else if (Intrinsics.areEqual(inst.get("Active"), (Object) true)) {
                this.newHits.add(new Hit(inst, rectF3, this.rt, 2));
            }
        }
        if (Intrinsics.areEqual(inst.getClassName(), "ScrollingFrame")) {
            canvas2 = canvas;
            drawScrolling(canvas2, inst, rect, n.getScale(), clip);
        } else {
            canvas2 = canvas;
            boolean areEqual = Intrinsics.areEqual(inst.get("ClipsDescendants"), (Object) true);
            if (areEqual) {
                rectF = new RectF(rectF2);
                if (!rectF.intersect(clip)) {
                    rectF.setEmpty();
                }
            } else {
                rectF = clip;
            }
            if (areEqual) {
                canvas2.clipRect(rect);
            }
            drawChildren(canvas2, inst, rect, n.getScale(), rectF);
        }
        canvas2.restoreToCount(save);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    private final void drawObject(Canvas canvas, Instance c, RectF r, float scale) {
        boolean z;
        float f;
        Instance instance;
        int i;
        Instance instance2;
        float f2;
        Instance instance3;
        float f3;
        float f4;
        float f5;
        float f6 = 0.0f;
        float num = num(c, "BackgroundTransparency", 0.0f);
        float cornerOf = cornerOf(c, r, scale);
        Iterator it = c.getChildren().iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                f = f6;
                instance = 0;
                break;
            }
            instance = it.next();
            Instance instance4 = (Instance) instance;
            f = f6;
            if (Intrinsics.areEqual(instance4.getClassName(), "UIGradient") && !Intrinsics.areEqual(instance4.get("Enabled"), (Object) false)) {
                break;
            } else {
                f6 = f;
            }
        }
        Instance instance5 = instance;
        ArrayList<Instance> children = c.getChildren();
        Iterator it2 = children.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i = z;
                instance2 = 0;
                break;
            }
            instance2 = it2.next();
            Instance instance6 = (Instance) instance2;
            i = z;
            ArrayList<Instance> arrayList = children;
            if ((!Intrinsics.areEqual(instance6.getClassName(), "UIStroke") || Intrinsics.areEqual(instance6.get("Enabled"), Boolean.valueOf((boolean) i))) ? i == true ? 1 : 0 : true) {
                break;
            }
            z = i == true ? 1 : 0;
            children = arrayList;
        }
        Instance instance7 = instance2;
        boolean z2 = instance7 != null && isText(c) && enumOf(instance7, "ApplyStrokeMode", i) == 0;
        if (num < 1.0f) {
            this.fill.setColor(alpha(colorOf(c.get("BackgroundColor3"), -6053211), num));
            this.fill.setShader(instance5 != null ? gradientShader(instance5, r, num) : null);
            if (cornerOf > f) {
                canvas.drawRoundRect(r, cornerOf, cornerOf, this.fill);
            } else {
                canvas.drawRect(r, this.fill);
            }
            this.fill.setShader(null);
            if (this.pressed == c && !Intrinsics.areEqual(c.get("AutoButtonColor"), (Object) false)) {
                this.fill.setColor(BasicMeasure.EXACTLY);
                if (cornerOf > f) {
                    canvas.drawRoundRect(r, cornerOf, cornerOf, this.fill);
                } else {
                    canvas.drawRect(r, this.fill);
                }
            }
            float f7 = f;
            float num2 = num(c, "BorderSizePixel", f7) * scale;
            if (num2 > f7) {
                if ((cornerOf == f7) && instance7 == null) {
                    this.stroke.setShader(null);
                    this.stroke.setColor(alpha(colorOf(c.get("BorderColor3"), -14996939), num));
                    this.stroke.setStrokeWidth(this.d * num2);
                    switch (enumOf(c, "BorderMode", 0)) {
                        case 0:
                            f4 = this.d * num2;
                            f5 = f4 / 2.0f;
                            break;
                        case 1:
                            f5 = 0.0f;
                            break;
                        default:
                            f4 = (-num2) * this.d;
                            f5 = f4 / 2.0f;
                            break;
                    }
                    float f8 = f5;
                    canvas.drawRect(r.left - f8, r.top - f8, r.right + f8, r.bottom + f8, this.stroke);
                }
            }
        }
        if (instance7 == null || z2) {
            f2 = 1.0f;
        } else {
            float num3 = num(instance7, "Thickness", 1.0f) * this.d * scale;
            this.stroke.setShader(null);
            this.stroke.setColor(alpha(colorOf(instance7.get("Color"), ViewCompat.MEASURED_STATE_MASK), num(instance7, "Transparency", 0.0f)));
            this.stroke.setStrokeWidth(num3);
            this.stroke.setStrokeJoin(Paint.Join.ROUND);
            f2 = 1.0f;
            RectF rectF = new RectF(r.left - (num3 / 2.0f), r.top - (num3 / 2.0f), r.right + (num3 / 2.0f), r.bottom + (num3 / 2.0f));
            if (cornerOf > 0.0f) {
                canvas.drawRoundRect(rectF, (num3 / 2.0f) + cornerOf, (num3 / 2.0f) + cornerOf, this.stroke);
            } else {
                canvas.drawRect(rectF, this.stroke);
            }
        }
        if (Intrinsics.areEqual(c.getClassName(), "ImageLabel") || Intrinsics.areEqual(c.getClassName(), "ImageButton")) {
            instance3 = c;
            drawImage(canvas, instance3, r, cornerOf, scale);
            f3 = scale;
        } else {
            instance3 = c;
            f3 = scale;
        }
        if (isText(instance3)) {
            drawText(canvas, instance3, padded(instance3, r, f3), f3, z2 ? instance7 : null, num >= f2 ? instance5 : null);
        }
    }

    private final boolean drawPluginWidgets(Canvas canvas, float w, float h) {
        float f = h;
        boolean z = false;
        float f2 = 12.0f;
        float f3 = this.d * 12.0f;
        float pluginScale = pluginScale(f);
        usePluginUnits();
        Iterator<PluginWidget> it = this.studio.getPluginWidgets().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        float f4 = f3;
        while (it.hasNext()) {
            PluginWidget next = it.next();
            Instance inst = next.getInst();
            if (Intrinsics.areEqual(inst.get("Enabled"), (Object) true)) {
                Object obj = inst.getAttributes().get("__w");
                Number number = obj instanceof Number ? (Number) obj : null;
                float coerceAtMost = RangesKt.coerceAtMost((number != null ? number.floatValue() : 300.0f) * pluginScale, (w / this.d) * 0.6f) * this.d;
                Object obj2 = inst.getAttributes().get("__h");
                Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
                float coerceAtMost2 = RangesKt.coerceAtMost((number2 != null ? number2.floatValue() : 300.0f) * pluginScale, (f / this.d) * 0.8f) * this.d;
                float f5 = (w - coerceAtMost) - (this.d * f2);
                this.fill.setShader(null);
                this.fill.setColor(-13750738);
                canvas.drawRect(f5, f4, f5 + coerceAtMost, (this.d * 24.0f) + f4 + coerceAtMost2, this.fill);
                this.fill.setColor(Ui.INSTANCE.getHEADER());
                canvas.drawRect(f5, f4, f5 + coerceAtMost, f4 + (this.d * 24.0f), this.fill);
                this.textPaint.setColor(Ui.INSTANCE.getTEXT());
                this.textPaint.setTextSize(this.d * 13.0f);
                this.textPaint.setTypeface(Typeface.DEFAULT);
                this.textPaint.setShader(null);
                Object obj3 = inst.get("Title");
                String str = obj3 instanceof String ? (String) obj3 : null;
                if (str == null) {
                    str = inst.getName();
                }
                float f6 = f2;
                canvas.drawText(str, f5 + (this.d * 8.0f), (this.d * 17.0f) + f4, this.textPaint);
                this.stroke.setColor(Ui.INSTANCE.getTEXT());
                this.stroke.setStrokeWidth(this.d * 1.6f);
                this.stroke.setShader(null);
                float f7 = (f5 + coerceAtMost) - (this.d * 14.0f);
                float f8 = f4 + (this.d * f6);
                float f9 = this.d * 4.5f;
                float f10 = f4;
                canvas.drawLine(f7 - f9, f8 - f9, f7 + f9, f8 + f9, this.stroke);
                canvas.drawLine(f7 + f9, f8 - f9, f7 - f9, f8 + f9, this.stroke);
                float f11 = pluginScale;
                this.newHits.add(new Hit(inst, new RectF((f5 + coerceAtMost) - (this.d * 28.0f), f10, f5 + coerceAtMost, (this.d * 24.0f) + f10), next.getRt(), 4));
                RectF rectF = new RectF(f5, (this.d * 24.0f) + f10, f5 + coerceAtMost, (this.d * 24.0f) + f10 + coerceAtMost2);
                canvas.save();
                canvas.clipRect(rectF);
                LuaRuntime luaRuntime = this.rt;
                this.rt = next.getRt();
                setAbs(inst, new RectF(rectF));
                drawChildren(canvas, inst, rectF, f11, rectF);
                this.rt = luaRuntime;
                canvas.restore();
                f4 = f10 + coerceAtMost2 + (this.d * 36.0f);
                f = h;
                pluginScale = f11;
                z = true;
                f2 = f6;
            } else {
                f = h;
            }
        }
        useGameUnits();
        return z;
    }

    private final void drawRichStroke(Canvas canvas, StaticLayout sl, TextPaint p) {
        String obj = sl.getText().toString();
        StaticLayout.Builder.obtain(obj, 0, obj.length(), p, sl.getWidth()).setAlignment(sl.getAlignment()).setIncludePad(false).setLineSpacing(0.0f, sl.getSpacingMultiplier()).build().draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0212 A[LOOP:2: B:57:0x020c->B:59:0x0212, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawScrolling(android.graphics.Canvas r27, com.exampletest.mobilestudiotest.model.Instance r28, android.graphics.RectF r29, float r30, android.graphics.RectF r31) {
        /*
            Method dump skipped, instructions count: 685
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.GuiOverlay.drawScrolling(android.graphics.Canvas, com.exampletest.mobilestudiotest.model.Instance, android.graphics.RectF, float, android.graphics.RectF):void");
    }

    private static final RectF drawScrolling$canvasRect(RectF rectF, Vector2 vector2, float f, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
        return new RectF(rectF.left - (vector2.getX() * f), rectF.top - (vector2.getY() * f), (rectF.left - (vector2.getX() * f)) + floatRef.element, (rectF.top - (vector2.getY() * f)) + floatRef2.element);
    }

    private final void drawSliced(Canvas canvas, Instance c, Bitmap bmp, Rect src, RectF r, float scale) {
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        Object obj = c.get("SliceCenter");
        com.exampletest.mobilestudiotest.model.Rect rect = obj instanceof com.exampletest.mobilestudiotest.model.Rect ? (com.exampletest.mobilestudiotest.model.Rect) obj : null;
        if (rect != null && rect.getMaxX() > rect.getMinX()) {
            if (rect.getMaxY() > rect.getMinY()) {
                float coerceAtLeast = RangesKt.coerceAtLeast(rect.getMinX() + rect.getMaxX(), 1.0f);
                float coerceAtLeast2 = RangesKt.coerceAtLeast(rect.getMinY() + rect.getMaxY(), 1.0f);
                float width = src.width() / coerceAtLeast;
                float height = src.height() / coerceAtLeast2;
                float num = num(c, "SliceScale", 1.0f) * this.d * scale;
                float minX = rect.getMinX() * width;
                float minY = rect.getMinY() * height;
                float maxX = (coerceAtLeast - rect.getMaxX()) * width;
                float maxY = (coerceAtLeast2 - rect.getMaxY()) * height;
                float minX2 = rect.getMinX() * num;
                float minY2 = rect.getMinY() * num;
                float maxX2 = (coerceAtLeast - rect.getMaxX()) * num;
                float maxY2 = (coerceAtLeast2 - rect.getMaxY()) * num;
                if (minX2 + maxX2 > r.width()) {
                    float width2 = r.width() / (minX2 + maxX2);
                    minX2 *= width2;
                    maxX2 *= width2;
                }
                if (minY2 + maxY2 > r.height()) {
                    float height2 = r.height() / (minY2 + maxY2);
                    minY2 *= height2;
                    maxY2 *= height2;
                }
                float[] fArr = {src.left, src.left + minX, src.right - maxX, src.right};
                int i2 = 3;
                float[] fArr2 = {src.top, src.top + minY, src.bottom - maxY, src.bottom};
                float[] fArr3 = {r.left, r.left + minX2, r.right - maxX2, r.right};
                float[] fArr4 = {r.top, r.top + minY2, r.bottom - maxY2, r.bottom};
                int i3 = 0;
                while (true) {
                    float[] fArr5 = fArr3;
                    int i4 = i2;
                    if (i3 >= i4) {
                        return;
                    }
                    int i5 = i3;
                    int i6 = 0;
                    while (i6 < i4) {
                        if (fArr[i5 + 1] <= fArr[i5] || fArr2[i6 + 1] <= fArr2[i6] || fArr5[i5 + 1] <= fArr5[i5]) {
                            i = i6;
                            f = coerceAtLeast;
                            f2 = num;
                            f3 = coerceAtLeast2;
                            f4 = width;
                        } else if (fArr4[i6 + 1] <= fArr4[i6]) {
                            i = i6;
                            f = coerceAtLeast;
                            f2 = num;
                            f3 = coerceAtLeast2;
                            f4 = width;
                        } else {
                            i = i6;
                            f = coerceAtLeast;
                            f2 = num;
                            f3 = coerceAtLeast2;
                            f4 = width;
                            canvas.drawBitmap(bmp, new Rect((int) fArr[i5], (int) fArr2[i], (int) fArr[i5 + 1], (int) fArr2[i + 1]), new RectF(fArr5[i5], fArr4[i], fArr5[i5 + 1], fArr4[i + 1]), this.imgPaint);
                        }
                        i6 = i + 1;
                        coerceAtLeast = f;
                        num = f2;
                        coerceAtLeast2 = f3;
                        width = f4;
                        i4 = 3;
                    }
                    i3 = i5 + 1;
                    fArr3 = fArr5;
                    i2 = 3;
                }
            }
        }
        canvas.drawBitmap(bmp, src, r, this.imgPaint);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0182 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0386  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawText(android.graphics.Canvas r39, com.exampletest.mobilestudiotest.model.Instance r40, android.graphics.RectF r41, float r42, com.exampletest.mobilestudiotest.model.Instance r43, com.exampletest.mobilestudiotest.model.Instance r44) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.GuiOverlay.drawText(android.graphics.Canvas, com.exampletest.mobilestudiotest.model.Instance, android.graphics.RectF, float, com.exampletest.mobilestudiotest.model.Instance, com.exampletest.mobilestudiotest.model.Instance):void");
    }

    private final void drawTopBar(Canvas canvas) {
        float f = this.d * 20.0f;
        float f2 = (this.d * 12.0f) + f;
        float f3 = (this.d * 8.0f) + f;
        this.fill.setShader(null);
        this.fill.setColor(-1946157056);
        canvas.drawCircle(f2, f3, f, this.fill);
        this.stroke.setColor(-1);
        this.stroke.setStrokeWidth(this.d * 2.6f);
        this.stroke.setShader(null);
        canvas.save();
        canvas.rotate(15.0f, f2, f3);
        float f4 = this.d * 8.0f;
        canvas.drawRoundRect(f2 - f4, f3 - f4, f2 + f4, f3 + f4, this.d * 2.0f, this.d * 2.0f, this.stroke);
        this.fill.setColor(-1);
        canvas.drawRect(f2 - (this.d * 2.2f), f3 - (this.d * 2.2f), (this.d * 2.2f) + f2, (this.d * 2.2f) + f3, this.fill);
        canvas.restore();
        this.newHits.add(new Hit(this.studio.getModel(), new RectF(f2 - f, f3 - f, f2 + f, f3 + f), null, 3));
        float f5 = f2 + (2.0f * f) + (this.d * 8.0f);
        this.fill.setColor(-1946157056);
        canvas.drawCircle(f5, f3, f, this.fill);
        this.fill.setColor(-1);
        canvas.drawRoundRect(f5 - (this.d * 9.0f), f3 - (this.d * 7.0f), (this.d * 9.0f) + f5, (this.d * 5.0f) + f3, this.d * 4.0f, this.d * 4.0f, this.fill);
        Path path = new Path();
        path.moveTo(f5 - (this.d * 4.0f), (this.d * 4.0f) + f3);
        path.lineTo(f5 - (this.d * 6.0f), (this.d * 10.0f) + f3);
        path.lineTo((this.d * 1.0f) + f5, (this.d * 4.0f) + f3);
        path.close();
        canvas.drawPath(path, this.fill);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
    
        if (r11 != null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void editTextBox(com.exampletest.mobilestudiotest.ui.GuiOverlay.Hit r13) {
        /*
            r12 = this;
            com.exampletest.mobilestudiotest.model.Instance r1 = r13.getInst()
            com.exampletest.mobilestudiotest.lua.LuaRuntime r0 = r13.getRt()
            if (r0 != 0) goto Lb
            return
        Lb:
            r2 = r0
            com.exampletest.mobilestudiotest.ui.Ui r3 = com.exampletest.mobilestudiotest.ui.Ui.INSTANCE
            android.content.Context r4 = r12.getContext()
            java.lang.String r0 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            com.exampletest.mobilestudiotest.core.Studio r0 = r12.studio
            java.lang.Object r5 = r0.getLock()
            monitor-enter(r5)
            r0 = 0
            java.lang.String r6 = "Text"
            java.lang.Object r6 = r1.get(r6)     // Catch: java.lang.Throwable -> Lbf
            boolean r7 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> Lbf
            r11 = 0
            if (r7 == 0) goto L2d
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> Lbf
            goto L2e
        L2d:
            r6 = r11
        L2e:
            if (r6 != 0) goto L32
            java.lang.String r6 = ""
        L32:
            monitor-exit(r5)
            r9 = 28
            r10 = 0
            r5 = r6
            r6 = 0
            r7 = 0
            r8 = 0
            android.widget.EditText r3 = com.exampletest.mobilestudiotest.ui.Ui.input$default(r3, r4, r5, r6, r7, r8, r9, r10)
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            android.content.Context r4 = r12.getContext()
            r5 = 16974374(0x1030226, float:2.4062441E-38)
            r0.<init>(r4, r5)
            com.exampletest.mobilestudiotest.core.Studio r4 = r12.studio
            java.lang.Object r4 = r4.getLock()
            monitor-enter(r4)
            r5 = 0
            java.lang.String r6 = "PlaceholderText"
            java.lang.Object r6 = r1.get(r6)     // Catch: java.lang.Throwable -> Lbc
            boolean r7 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> Lbc
            if (r7 == 0) goto L5f
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> Lbc
            goto L60
        L5f:
            r6 = r11
        L60:
            monitor-exit(r4)
            r4 = 0
            if (r6 == 0) goto L7a
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r5 = r6.length()
            if (r5 != 0) goto L6e
            r5 = 1
            goto L6f
        L6e:
            r5 = r4
        L6f:
            if (r5 == 0) goto L74
            r5 = 0
            goto L75
        L74:
            r11 = r6
        L75:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L7a
            goto L7c
        L7a:
            java.lang.String r11 = "Enter text"
        L7c:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            android.app.AlertDialog$Builder r0 = r0.setTitle(r11)
            r5 = r3
            android.view.View r5 = (android.view.View) r5
            android.app.AlertDialog$Builder r0 = r0.setView(r5)
            java.lang.String r5 = "OK"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            com.exampletest.mobilestudiotest.ui.GuiOverlay$$ExternalSyntheticLambda0 r6 = new com.exampletest.mobilestudiotest.ui.GuiOverlay$$ExternalSyntheticLambda0
            r6.<init>(r12, r1, r3, r2)
            android.app.AlertDialog$Builder r0 = r0.setPositiveButton(r5, r6)
            java.lang.String r5 = "Cancel"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            com.exampletest.mobilestudiotest.ui.GuiOverlay$$ExternalSyntheticLambda1 r6 = new com.exampletest.mobilestudiotest.ui.GuiOverlay$$ExternalSyntheticLambda1
            r6.<init>(r12, r2, r1)
            android.app.AlertDialog$Builder r0 = r0.setNegativeButton(r5, r6)
            r0.show()
            com.exampletest.mobilestudiotest.core.Studio r0 = r12.studio
            java.lang.Object r5 = r0.getLock()
            monitor-enter(r5)
            r0 = 0
            java.lang.String r6 = "Focused"
            org.luaj.vm2.LuaValue[] r4 = new org.luaj.vm2.LuaValue[r4]     // Catch: java.lang.Throwable -> Lb9
            r2.fire(r1, r6, r4)     // Catch: java.lang.Throwable -> Lb9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r5)
            return
        Lb9:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        Lbc:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        Lbf:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.GuiOverlay.editTextBox(com.exampletest.mobilestudiotest.ui.GuiOverlay$Hit):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void editTextBox$lambda$107(GuiOverlay guiOverlay, Instance instance, EditText editText, LuaRuntime luaRuntime, DialogInterface dialogInterface, int i) {
        Throwable th;
        synchronized (guiOverlay.studio.getLock()) {
            try {
                try {
                    Instance.set$default(instance, "Text", editText.getText().toString(), false, 4, null);
                    LuaBoolean TRUE = LuaValue.TRUE;
                    Intrinsics.checkNotNullExpressionValue(TRUE, "TRUE");
                    LuaValue NIL = LuaValue.NIL;
                    Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
                    luaRuntime.fire(instance, "FocusLost", TRUE, NIL);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void editTextBox$lambda$109(GuiOverlay guiOverlay, LuaRuntime luaRuntime, Instance instance, DialogInterface dialogInterface, int i) {
        synchronized (guiOverlay.studio.getLock()) {
            LuaBoolean FALSE = LuaValue.FALSE;
            Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            luaRuntime.fire(instance, "FocusLost", FALSE, NIL);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final int enumOf(Instance i, String prop, int def) {
        Object obj = i != null ? i.get(prop) : null;
        EnumValue enumValue = obj instanceof EnumValue ? (EnumValue) obj : null;
        return enumValue != null ? enumValue.getValue() : def;
    }

    private final List<Hit> extrasFor(Hit h, float x, float y) {
        int indexOf = this.hits.indexOf(h);
        if (indexOf < 0) {
            return CollectionsKt.emptyList();
        }
        List<Hit> subList = this.hits.subList(indexOf + 1, this.hits.size());
        Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : subList) {
            Hit hit = (Hit) obj;
            if (hit.getKind() == 2 && hit.getRt() != null && hit.getRect().contains(x, y) && isPluginUi(hit.getInst())) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.asReversed(arrayList);
    }

    private final void fireAbsChanges() {
        if (this.absChanged.isEmpty()) {
            this.absRounds = 0;
            return;
        }
        ArrayList arrayList = new ArrayList(this.absChanged);
        this.absChanged.clear();
        LuaRuntime[] luaRuntimeArr = new LuaRuntime[2];
        luaRuntimeArr[0] = this.studio.getEditRuntime();
        PlaySession play = this.studio.getPlay();
        luaRuntimeArr[1] = play != null ? play.getRt() : null;
        List<LuaRuntime> distinct = CollectionsKt.distinct(CollectionsKt.listOfNotNull((Object[]) luaRuntimeArr));
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Instance instance = (Instance) pair.component1();
            String str = (String) pair.component2();
            for (LuaRuntime luaRuntime : distinct) {
                if (luaRuntime.hasConn(instance, "Changed:" + str)) {
                    luaRuntime.fire(instance, "Changed:" + str, new LuaValue[0]);
                }
                if (luaRuntime.hasConn(instance, "Changed")) {
                    LuaString valueOf = LuaValue.valueOf(str);
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                    luaRuntime.fire(instance, "Changed", valueOf);
                }
            }
        }
        this.absRounds++;
        if (this.absRounds <= 30) {
            postInvalidate();
        }
    }

    private final Shader gradientShader(Instance g, RectF r, float baseTransparency) {
        ArrayList emptyList;
        List emptyList2;
        List<NumberKey> keys;
        List<ColorKey> keys2;
        Object obj = g.get("Color");
        ColorSequence colorSequence = obj instanceof ColorSequence ? (ColorSequence) obj : null;
        Object obj2 = g.get("Transparency");
        NumberSequence numberSequence = obj2 instanceof NumberSequence ? (NumberSequence) obj2 : null;
        float f = 1.0f;
        List listOf = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)});
        if (colorSequence == null || (keys2 = colorSequence.getKeys()) == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<ColorKey> list = keys2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf(((ColorKey) it.next()).getTime()));
            }
            emptyList = arrayList;
        }
        List plus = CollectionsKt.plus((Collection) listOf, (Iterable) emptyList);
        if (numberSequence == null || (keys = numberSequence.getKeys()) == null) {
            emptyList2 = CollectionsKt.emptyList();
        } else {
            List<NumberKey> list2 = keys;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(((NumberKey) it2.next()).getTime()));
            }
            emptyList2 = arrayList2;
        }
        List sorted = CollectionsKt.sorted(CollectionsKt.distinct(CollectionsKt.plus((Collection) plus, emptyList2)));
        List list3 = sorted;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator it3 = list3.iterator();
        while (it3.hasNext()) {
            float floatValue = ((Number) it3.next()).floatValue();
            float f2 = f;
            arrayList3.add(Integer.valueOf(alpha(gradientShader$colorAt(colorSequence, floatValue).toArgb(), f2 - ((f2 - baseTransparency) * (f2 - gradientShader$transAt(numberSequence, floatValue))))));
            f = f2;
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList3);
        double radians = Math.toRadians(num(g, "Rotation", 0.0f));
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        Object obj3 = g.get("Offset");
        Vector2 vector2 = obj3 instanceof Vector2 ? (Vector2) obj3 : null;
        if (vector2 == null) {
            vector2 = new Vector2(0.0f, 0.0f);
        }
        float abs = (Math.abs(r.width() * cos) + Math.abs(r.height() * sin)) / 2.0f;
        float centerX = r.centerX() + (vector2.getX() * r.width());
        float centerY = r.centerY() + (vector2.getY() * r.height());
        return new LinearGradient(centerX - (cos * abs), centerY - (sin * abs), centerX + (cos * abs), centerY + (sin * abs), intArray, CollectionsKt.toFloatArray(sorted), Shader.TileMode.CLAMP);
    }

    private static final Color3 gradientShader$colorAt(ColorSequence colorSequence, float f) {
        List<ColorKey> keys;
        if (colorSequence == null || (keys = colorSequence.getKeys()) == null) {
            return new Color3(1.0f, 1.0f, 1.0f);
        }
        if (keys.isEmpty()) {
            return new Color3(1.0f, 1.0f, 1.0f);
        }
        int size = keys.size() - 1;
        for (int i = 0; i < size; i++) {
            if (f <= keys.get(i + 1).getTime()) {
                ColorKey colorKey = keys.get(i);
                ColorKey colorKey2 = keys.get(i + 1);
                return colorKey.getColor().lerp(colorKey2.getColor(), RangesKt.coerceIn(colorKey2.getTime() > colorKey.getTime() ? (f - colorKey.getTime()) / (colorKey2.getTime() - colorKey.getTime()) : 0.0f, 0.0f, 1.0f));
            }
        }
        return ((ColorKey) CollectionsKt.last((List) keys)).getColor();
    }

    private static final float gradientShader$transAt(NumberSequence numberSequence, float f) {
        List<NumberKey> keys;
        if (numberSequence == null || (keys = numberSequence.getKeys()) == null || keys.isEmpty()) {
            return 0.0f;
        }
        int size = keys.size() - 1;
        for (int i = 0; i < size; i++) {
            if (f <= keys.get(i + 1).getTime()) {
                NumberKey numberKey = keys.get(i);
                NumberKey numberKey2 = keys.get(i + 1);
                return numberKey.getValue() + ((numberKey2.getValue() - numberKey.getValue()) * RangesKt.coerceIn(numberKey2.getTime() > numberKey.getTime() ? (f - numberKey.getTime()) / (numberKey2.getTime() - numberKey.getTime()) : 0.0f, 0.0f, 1.0f));
            }
        }
        return ((NumberKey) CollectionsKt.last((List) keys)).getValue();
    }

    private final Vector2 guiPoint(float x, float y) {
        boolean z = this.studio.getPlay() == null;
        float f = this.d;
        if (z) {
            f *= this.studio.editGuiScale();
        }
        Vector2 vector2 = new Vector2(x / f, (y / f) - (z ? 0.0f : 58.0f));
        if (z) {
            this.studio.setLastEditPointer(vector2);
        }
        return vector2;
    }

    private final void hover(Hit h, float x, float y, boolean enter) {
        LuaRuntime rt = h.getRt();
        if (rt == null) {
            return;
        }
        Vector2 guiPoint = guiPoint(x, y);
        Instance inst = h.getInst();
        String str = enter ? "MouseEnter" : "MouseLeave";
        LuaNumber valueOf = LuaValue.valueOf(guiPoint.getX());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        LuaNumber valueOf2 = LuaValue.valueOf(guiPoint.getY());
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
        rt.fire(inst, str, valueOf, valueOf2);
        Instance inst2 = h.getInst();
        String str2 = enter ? "InputBegan" : "InputEnded";
        LuaValue[] luaValueArr = new LuaValue[1];
        luaValueArr[0] = touchInput(x, y, enter ? 0 : 2, true, true);
        rt.fire(inst2, str2, luaValueArr);
    }

    private final boolean isText(Instance c) {
        return Intrinsics.areEqual(c.getClassName(), "TextLabel") || Intrinsics.areEqual(c.getClassName(), "TextButton") || Intrinsics.areEqual(c.getClassName(), "TextBox");
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x04f7, code lost:
    
        r4 = r30;
        r1.add(new com.exampletest.mobilestudiotest.ui.GuiOverlay.Node(r3, new android.graphics.RectF(r4, r2, r4 + r4, r2 + r42), scaleFor(r3, r56), null, false, 24, null));
        r13 = r29;
        r3 = r38;
        r2 = r40;
        r4 = r41;
        r6 = r6;
        r8 = r8;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x04ba, code lost:
    
        r42 = r2;
        r2 = r5.bottom - r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x04c1, code lost:
    
        r42 = r2;
        r2 = r5.top + ((r19 - r42) / 2.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x04d0, code lost:
    
        r42 = r2;
        r2 = r11;
        r11 = r11 + (r42 + r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x04d7, code lost:
    
        switch(r10) {
            case 0: goto L195;
            case 1: goto L193;
            case 2: goto L194;
            default: goto L193;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x04da, code lost:
    
        r31 = r2;
        r2 = r5.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x04ef, code lost:
    
        r30 = r2;
        r2 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x04df, code lost:
    
        r31 = r2;
        r2 = r5.right - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x04e5, code lost:
    
        r31 = r2;
        r2 = r5.left + ((r18 - r4) / 2.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0531, code lost:
    
        r2 = kotlin.Unit.INSTANCE;
        r22 = true;
        r23 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0432, code lost:
    
        r11 = r5.right - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0436, code lost:
    
        r11 = r5.left + ((r18 - r4) / 2.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x043e, code lost:
    
        switch(r3) {
            case 0: goto L176;
            case 1: goto L174;
            case 2: goto L175;
            default: goto L174;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0441, code lost:
    
        r11 = r5.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0444, code lost:
    
        r11 = r5.bottom - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0448, code lost:
    
        r11 = r5.top + ((r19 - r4) / 2.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x041c, code lost:
    
        r10 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0415, code lost:
    
        r9 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x040f, code lost:
    
        r20 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03cf, code lost:
    
        r10 = (float[]) r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03d6, code lost:
    
        if (r25 == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x03d8, code lost:
    
        r13 = r10[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x03e5, code lost:
    
        if (r9.hasNext() == false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x03e7, code lost:
    
        r10 = (float[]) r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x03ee, code lost:
    
        if (r25 == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x03f0, code lost:
    
        r17 = r10[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x03f9, code lost:
    
        r13 = java.lang.Math.max(r13, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03f5, code lost:
    
        r17 = r10[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0400, code lost:
    
        r17 = java.lang.Float.valueOf(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x03dd, code lost:
    
        r13 = r10[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x032e, code lost:
    
        r13 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x033c, code lost:
    
        r12 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0320, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0311, code lost:
    
        r6 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02fc, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x00ee, code lost:
    
        if (r2.equals("UIPageLayout") != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x02f1, code lost:
    
        if (r2.equals("UIListLayout") != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e7, code lost:
    
        if (r2.equals("UITableLayout") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x02f8, code lost:
    
        if (enumOf(r14, "FillDirection", 1) != 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x02fa, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0305, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r14.getClassName(), "UIPageLayout") == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0307, code lost:
    
        r6 = kotlin.collections.CollectionsKt.take(r16, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0313, code lost:
    
        r8 = r14.get("Padding");
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x031b, code lost:
    
        if ((r8 instanceof com.exampletest.mobilestudiotest.model.UDim) == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x031d, code lost:
    
        r8 = (com.exampletest.mobilestudiotest.model.UDim) r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0321, code lost:
    
        if (r8 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0323, code lost:
    
        r12 = r8.getScale();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0329, code lost:
    
        if (r2 == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x032b, code lost:
    
        r13 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0330, code lost:
    
        r12 = (r12 * r13) + ((r9.getOffset() * r53.d) * r56);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x033d, code lost:
    
        r4 = r6;
        r25 = r2;
        r2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, 10));
        r27 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x035b, code lost:
    
        if (r27.hasNext() == false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x035d, code lost:
    
        r2.add(sizeOf((com.exampletest.mobilestudiotest.model.Instance) r27.next(), r5, r56));
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0373, code lost:
    
        r2 = r2;
        r4 = r2.iterator();
        r9 = 0.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0386, code lost:
    
        if (r4.hasNext() == false) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0388, code lost:
    
        r13 = (float[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0391, code lost:
    
        if (r25 == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0393, code lost:
    
        r28 = r13[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x039e, code lost:
    
        r9 = r9 + r28;
        r12 = r12;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x039a, code lost:
    
        r28 = r13[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x03ab, code lost:
    
        r28 = r12;
        r4 = ((float) r9) + (r28 * kotlin.ranges.RangesKt.coerceAtLeast(r6.size() - 1, 0));
        r9 = r2.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x03ca, code lost:
    
        if (r9.hasNext() != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x03cc, code lost:
    
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0406, code lost:
    
        if (r17 == null) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0408, code lost:
    
        r20 = r17.floatValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0411, code lost:
    
        if (r25 == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0413, code lost:
    
        r9 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0417, code lost:
    
        if (r25 == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0419, code lost:
    
        r10 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x041d, code lost:
    
        setContentSize(r14, r9, r10);
        r10 = enumOf(r14, "HorizontalAlignment", 1);
        r3 = enumOf(r14, "VerticalAlignment", 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x042a, code lost:
    
        if (r25 == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x042c, code lost:
    
        switch(r10) {
            case 0: goto L172;
            case 1: goto L170;
            case 2: goto L171;
            default: goto L170;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x042f, code lost:
    
        r11 = r5.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x044f, code lost:
    
        r9 = r6;
        r13 = 0;
        r17 = r9.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x045d, code lost:
    
        if (r17.hasNext() == false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x045f, code lost:
    
        r27 = r17.next();
        r29 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0465, code lost:
    
        if (r13 >= 0) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0467, code lost:
    
        kotlin.collections.CollectionsKt.throwIndexOverflow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x046a, code lost:
    
        r38 = r3;
        r3 = (com.exampletest.mobilestudiotest.model.Instance) r27;
        r30 = (float[]) r2.get(r13);
        r40 = r2;
        r41 = r4;
        r2 = kotlin.TuplesKt.to(java.lang.Float.valueOf(r30[0]), java.lang.Float.valueOf(r30[1]));
        r4 = ((java.lang.Number) r2.component1()).floatValue();
        r2 = ((java.lang.Number) r2.component2()).floatValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x04aa, code lost:
    
        if (r25 == false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x04ac, code lost:
    
        r30 = r11;
        r11 = r11 + (r4 + r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x04b2, code lost:
    
        switch(r38) {
            case 0: goto L189;
            case 1: goto L187;
            case 2: goto L188;
            default: goto L187;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x04b5, code lost:
    
        r42 = r2;
        r2 = r5.top;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x062c A[LOOP:5: B:118:0x0626->B:120:0x062c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0551  */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v54, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.exampletest.mobilestudiotest.ui.GuiOverlay.Node> layoutChildren(com.exampletest.mobilestudiotest.model.Instance r54, android.graphics.RectF r55, float r56) {
        /*
            Method dump skipped, instructions count: 1720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.GuiOverlay.layoutChildren(com.exampletest.mobilestudiotest.model.Instance, android.graphics.RectF, float):java.util.List");
    }

    private final StaticLayout layoutFor(TKey k) {
        StaticLayout staticLayout;
        GuiOverlay$layouts$1 guiOverlay$layouts$1 = this.layouts;
        StaticLayout staticLayout2 = guiOverlay$layouts$1.get((Object) k);
        if (staticLayout2 == null) {
            TextPaint textPaint = new TextPaint(1);
            textPaint.setTypeface(k.getTf());
            textPaint.setTextSize(k.getSize());
            textPaint.setFakeBoldText(k.getBold());
            CharSequence content = content(k.getText(), k.getRich());
            if (k.getTruncate()) {
                CharSequence ellipsize = TextUtils.ellipsize(content, textPaint, k.getWidth(), TextUtils.TruncateAt.END);
                Intrinsics.checkNotNullExpressionValue(ellipsize, "ellipsize(...)");
                content = ellipsize;
            }
            staticLayout = StaticLayout.Builder.obtain(content, 0, content.length(), textPaint, RangesKt.coerceAtLeast(k.getWidth(), 1)).setAlignment(k.getAlign()).setIncludePad(false).setLineSpacing(0.0f, k.getLineHeight()).build();
            Intrinsics.checkNotNullExpressionValue(staticLayout, "build(...)");
            guiOverlay$layouts$1.put(k, staticLayout);
        } else {
            staticLayout = staticLayout2;
        }
        return staticLayout;
    }

    private final boolean mouseFor(Instance i) {
        return this.studio.getPlay() == null && isPluginUi(i);
    }

    private final float num(Instance i, String prop, float def) {
        Object obj = i != null ? i.get(prop) : null;
        Number number = obj instanceof Number ? (Number) obj : null;
        return number != null ? number.floatValue() : def;
    }

    private final RectF padded(Instance p, RectF r, float scale) {
        Instance child = child(p, "UIPadding");
        return child == null ? r : new RectF(r.left + padded$u(child, this, scale, "PaddingLeft", r.width()), r.top + padded$u(child, this, scale, "PaddingTop", r.height()), r.right - padded$u(child, this, scale, "PaddingRight", r.width()), r.bottom - padded$u(child, this, scale, "PaddingBottom", r.height()));
    }

    private static final float padded$u(Instance instance, GuiOverlay guiOverlay, float f, String str, float f2) {
        Object obj = instance.get(str);
        UDim uDim = obj instanceof UDim ? (UDim) obj : null;
        if (uDim != null) {
            return (uDim.getScale() * f2) + (uDim.getOffset() * guiOverlay.d * f);
        }
        return 0.0f;
    }

    private final Instance pluginObjectAt(float x, float y) {
        Pair<Instance, RectF> pair;
        if (this.studio.getPlay() != null) {
            return null;
        }
        ArrayList<Pair<Instance, RectF>> arrayList = this.picks;
        ListIterator<Pair<Instance, RectF>> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                pair = null;
                break;
            }
            pair = listIterator.previous();
            Pair<Instance, RectF> pair2 = pair;
            if (pair2.component2().contains(x, y) && isPluginUi(pair2.component1())) {
                break;
            }
        }
        Pair<Instance, RectF> pair3 = pair;
        if (pair3 != null) {
            return pair3.getFirst();
        }
        return null;
    }

    private final LuaRuntime pluginRt(Instance i) {
        Object obj;
        LuaRuntime rt;
        Iterator<T> it = this.studio.getPluginWidgets().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            PluginWidget pluginWidget = (PluginWidget) obj;
            if (i == pluginWidget.getInst() || i.isDescendantOf(pluginWidget.getInst())) {
                break;
            }
        }
        PluginWidget pluginWidget2 = (PluginWidget) obj;
        return (pluginWidget2 == null || (rt = pluginWidget2.getRt()) == null) ? this.studio.getEditRuntime() : rt;
    }

    private final float pluginScale(float viewH) {
        return this.studio.editGuiScale();
    }

    private static final LuaValue pluginWheel$lambda$95$wheel(LuaTypes luaTypes, GuiOverlay guiOverlay, float f, float f2, int i) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("UserInputType", luaTypes.wrap(new EnumItemV("UserInputType", "MouseWheel", 3)));
        luaTable.set("UserInputState", luaTypes.wrap(new EnumItemV("UserInputState", "Change", 1)));
        Vector2 guiPoint = guiOverlay.guiPoint(f, f2);
        luaTable.set("Position", luaTypes.wrap(new Vector3(guiPoint.getX(), guiPoint.getY(), i)));
        luaTable.set("Delta", luaTypes.wrap(new Vector3(0.0f, 0.0f, i)));
        luaTable.set("KeyCode", luaTypes.wrap(new EnumItemV("KeyCode", "Unknown", 0)));
        return luaTable;
    }

    private final void releaseExtras(Hit h, float x, float y) {
        List<Hit> remove = this.pressExtras.remove(h);
        if (remove == null) {
            return;
        }
        for (Hit hit : remove) {
            Intrinsics.checkNotNullExpressionValue(hit, "next(...)");
            Hit hit2 = hit;
            LuaRuntime rt = hit2.getRt();
            if (rt != null) {
                rt.fire(hit2.getInst(), "InputEnded", touchInput$default(this, x, y, 2, true, false, 16, null));
            }
            hover(hit2, x, y, false);
        }
    }

    private final float scaleFor(Instance c, float parentScale) {
        Instance child = child(c, "UIScale");
        return (child != null ? num(child, "Scale", 1.0f) : 1.0f) * parentScale;
    }

    private final float scaledSize(SKey k) {
        Float f;
        GuiOverlay$scaledSizes$1 guiOverlay$scaledSizes$1 = this.scaledSizes;
        Float f2 = guiOverlay$scaledSizes$1.get((Object) k);
        if (f2 == null) {
            TextPaint textPaint = new TextPaint(1);
            textPaint.setTypeface(k.getTf());
            textPaint.setFakeBoldText(k.getBold());
            CharSequence content = content(k.getText(), k.getRich());
            List<String> split = new Regex("\\s+").split(content.toString(), 0);
            ArrayList arrayList = new ArrayList();
            for (Object obj : split) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            float coerceAtLeast = RangesKt.coerceAtLeast(k.getMin(), 1.0f);
            float coerceAtLeast2 = RangesKt.coerceAtLeast(k.getMax(), coerceAtLeast);
            if (!scaledSize$lambda$9$fits(textPaint, arrayList2, content, k, coerceAtLeast2)) {
                for (int i = 0; i < 12; i++) {
                    float f3 = (coerceAtLeast + coerceAtLeast2) / 2.0f;
                    if (scaledSize$lambda$9$fits(textPaint, arrayList2, content, k, f3)) {
                        coerceAtLeast = f3;
                    } else {
                        coerceAtLeast2 = f3;
                    }
                }
                coerceAtLeast2 = coerceAtLeast;
            }
            f = Float.valueOf(coerceAtLeast2);
            guiOverlay$scaledSizes$1.put(k, f);
        } else {
            f = f2;
        }
        return f.floatValue();
    }

    private static final boolean scaledSize$lambda$9$fits(TextPaint textPaint, List<String> list, CharSequence charSequence, SKey sKey, float f) {
        boolean z;
        textPaint.setTextSize(f);
        List<String> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (textPaint.measureText((String) it.next()) > ((float) sKey.getW())) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        StaticLayout build = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, RangesKt.coerceAtLeast(sKey.getW(), 1)).setIncludePad(false).setLineSpacing(0.0f, sKey.getLineHeight()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build.getHeight() <= sKey.getH();
    }

    private final void setAbs(Instance c, RectF r) {
        if (this.absUnit <= 0.0f) {
            useGameUnits();
        }
        float f = this.absUnit;
        float f2 = r.left / f;
        float f3 = (r.top / f) - this.absInset;
        float width = r.width() / f;
        float height = r.height() / f;
        boolean z = Math.abs(c.getAbsW() - width) > 0.25f || Math.abs(c.getAbsH() - height) > 0.25f;
        boolean z2 = Math.abs(c.getAbsX() - f2) > 0.25f || Math.abs(c.getAbsY() - f3) > 0.25f;
        c.setAbsX(f2);
        c.setAbsY(f3);
        c.setAbsW(width);
        c.setAbsH(height);
        if (z) {
            this.absChanged.add(TuplesKt.to(c, "AbsoluteSize"));
        }
        if (z2) {
            this.absChanged.add(TuplesKt.to(c, "AbsolutePosition"));
        }
    }

    private final void setContentSize(Instance layout, float wPx, float hPx) {
        if (this.absUnit <= 0.0f) {
            useGameUnits();
        }
        float f = wPx / this.absUnit;
        float f2 = hPx / this.absUnit;
        if (Math.abs(layout.getAbsW() - f) > 0.25f || Math.abs(layout.getAbsH() - f2) > 0.25f) {
            this.absChanged.add(TuplesKt.to(layout, "AbsoluteContentSize"));
        }
        layout.setAbsW(f);
        layout.setAbsH(f2);
    }

    private final float[] sizeOf(Instance c, RectF area, float scale) {
        char c2;
        char c3;
        char c4;
        RectF rectF;
        float max;
        float max2;
        UDim2 udim = udim(c.get("Size"));
        float width = area.width();
        float height = area.height();
        float xs = (udim.getXs() * width) + (udim.getXo() * this.d * scale);
        float ys = (udim.getYs() * height) + (udim.getYo() * this.d * scale);
        switch (enumOf(c, "SizeConstraint", 0)) {
            case 1:
                ys = (udim.getYs() * width) + (udim.getYo() * this.d * scale);
                break;
            case 2:
                xs = (udim.getXs() * height) + (udim.getXo() * this.d * scale);
                break;
        }
        int enumOf = enumOf(c, "AutomaticSize", 0);
        if (enumOf != 0 && isText(c)) {
            String textOf = textOf(c);
            if (textOf == null) {
                textOf = "";
            }
            String str = textOf;
            this.textPaint.setTypeface(Fonts.INSTANCE.of(c).getTypeface());
            c2 = 0;
            this.textPaint.setTextSize(num(c, "TextSize", 14.0f) * this.d * scale);
            Iterator it = StringsKt.split$default((CharSequence) str, new char[]{'\n'}, false, 0, 6, (Object) null).iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            c3 = 1;
            float measureText = this.textPaint.measureText((String) it.next());
            while (it.hasNext()) {
                measureText = Math.max(measureText, this.textPaint.measureText((String) it.next()));
            }
            float f = measureText + (this.d * 2.0f);
            float size = r9.size() * this.textPaint.getFontSpacing();
            switch (enumOf) {
                case 1:
                case 3:
                    xs = Math.max(xs, f);
                    break;
            }
            switch (enumOf) {
                case 2:
                case 3:
                    ys = Math.max(ys, Intrinsics.areEqual(c.get("TextWrapped"), (Object) true) ? layoutFor(new TKey(str, Intrinsics.areEqual(c.get("RichText"), (Object) true), r12.getTypeface(), r12.getFakeBold(), this.textPaint.getTextSize(), (int) Math.max(xs, 1.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, false)).getHeight() : size);
                    break;
            }
        } else {
            c2 = 0;
            c3 = 1;
        }
        float[] constrain = constrain(c, xs, ys, scale);
        float f2 = constrain[c2];
        float f3 = constrain[c3];
        Instance child = child(c, "UIScale");
        if (child != null) {
            float num = num(child, "Scale", 1.0f);
            f2 *= num;
            f3 *= num;
        }
        if (enumOf != 0 && !Intrinsics.areEqual(c.getClassName(), "ScrollingFrame")) {
            ArrayList<Instance> children = c.getChildren();
            if ((children instanceof Collection) && children.isEmpty()) {
                c4 = c2;
            } else {
                Iterator<T> it2 = children.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Instance instance = (Instance) it2.next();
                        float[] fArr = constrain;
                        if (((Intrinsics.areEqual(instance.getClassName(), "UIListLayout") || Intrinsics.areEqual(instance.getClassName(), "UIGridLayout") || Intrinsics.areEqual(instance.getClassName(), "UITableLayout") || Intrinsics.areEqual(instance.getClassName(), "UIPageLayout")) ? c3 : c2) != 0) {
                            c4 = c3;
                        } else {
                            constrain = fArr;
                        }
                    } else {
                        c4 = c2;
                    }
                }
            }
            if (c4 != 0) {
                rectF = new RectF(0.0f, 0.0f, f2, f3);
            } else {
                switch (enumOf) {
                    case 1:
                    case 3:
                        max = Math.max(f2, width);
                        break;
                    case 2:
                    default:
                        max = f2;
                        break;
                }
                switch (enumOf) {
                    case 2:
                    case 3:
                        max2 = Math.max(f3, height);
                        break;
                    default:
                        max2 = f3;
                        break;
                }
                rectF = new RectF(0.0f, 0.0f, max, max2);
            }
            float f4 = f2;
            float f5 = f3;
            for (Node node : layoutChildren(c, padded(c, rectF, scale), scaleFor(c, scale))) {
                f4 = Math.max(f4, node.getRect().right);
                f5 = Math.max(f5, node.getRect().bottom);
            }
            Instance child2 = child(c, "UIPadding");
            if (child2 != null) {
                Object obj = child2.get("PaddingRight");
                f4 += (obj instanceof UDim ? (UDim) obj : null) != null ? r15.getOffset() * this.d * scale : 0.0f;
                Object obj2 = child2.get("PaddingBottom");
                f5 += (obj2 instanceof UDim ? (UDim) obj2 : null) != null ? r18.getOffset() * this.d * scale : 0.0f;
            }
            switch (enumOf) {
                case 1:
                case 3:
                    f2 = f4;
                    break;
            }
            switch (enumOf) {
                case 2:
                case 3:
                    f3 = f5;
                    break;
            }
        }
        float max3 = Math.max(f2, 0.0f);
        float max4 = Math.max(f3, 0.0f);
        float[] fArr2 = new float[2];
        fArr2[c2] = max3;
        fArr2[c3] = max4;
        return fArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<Instance> sortKids(Instance parent, List<? extends Instance> kids, Instance layout) {
        if (layout == null) {
            return kids;
        }
        switch (enumOf(layout, "SortOrder", 2)) {
            case 0:
                return CollectionsKt.sortedWith(kids, new GuiOverlay$sortKids$$inlined$sortedBy$1());
            case 1:
            default:
                return kids;
            case 2:
                return CollectionsKt.sortedWith(kids, new GuiOverlay$sortKids$$inlined$sortedBy$2());
        }
    }

    private final Rect sourceRect(Instance c, Bitmap bmp) {
        Object obj = c.get("ImageRectSize");
        Vector2 vector2 = obj instanceof Vector2 ? (Vector2) obj : null;
        Object obj2 = c.get("ImageRectOffset");
        Vector2 vector22 = obj2 instanceof Vector2 ? (Vector2) obj2 : null;
        if (vector22 == null) {
            vector22 = new Vector2(0.0f, 0.0f);
        }
        if (vector2 == null || vector2.getX() <= 0.0f || vector2.getY() <= 0.0f) {
            return new Rect(0, 0, bmp.getWidth(), bmp.getHeight());
        }
        float f = 64.0f;
        while (f < Math.max(vector22.getX() + vector2.getX(), vector22.getY() + vector2.getY())) {
            f *= 2.0f;
        }
        float width = bmp.getWidth() / f;
        return new Rect((int) (vector22.getX() * width), (int) (vector22.getY() * width), RangesKt.coerceAtMost((int) ((vector22.getX() + vector2.getX()) * width), bmp.getWidth()), RangesKt.coerceAtMost((int) ((vector22.getY() + vector2.getY()) * width), bmp.getHeight()));
    }

    private final String textOf(Instance c) {
        String className = c.getClassName();
        switch (className.hashCode()) {
            case -935338273:
                if (!className.equals("TextButton")) {
                    return null;
                }
                break;
            case 246787390:
                if (!className.equals("TextBox")) {
                    return null;
                }
                Object obj = c.get("Text");
                String str = obj instanceof String ? (String) obj : null;
                if (str == null) {
                    return null;
                }
                String str2 = str;
                if (str2.length() == 0) {
                    Object obj2 = c.get("PlaceholderText");
                    str2 = obj2 instanceof String ? (String) obj2 : null;
                }
                return str2;
            case 948280743:
                if (!className.equals("TextLabel")) {
                    return null;
                }
                break;
            default:
                return null;
        }
        Object obj3 = c.get("Text");
        if (obj3 instanceof String) {
            return (String) obj3;
        }
        return null;
    }

    private final LuaValue touchInput(float x, float y, int state, boolean mouse, boolean movement) {
        String str;
        LuaTypes luaTypes = LuaTypes.INSTANCE;
        LuaTable luaTable = new LuaTable();
        luaTable.set("UserInputType", luaTypes.wrap(movement ? new EnumItemV("UserInputType", "MouseMovement", 4) : mouse ? new EnumItemV("UserInputType", "MouseButton1", 0) : new EnumItemV("UserInputType", "Touch", 7)));
        switch (state) {
            case 0:
                str = "Begin";
                break;
            case 1:
                str = "Change";
                break;
            default:
                str = "End";
                break;
        }
        luaTable.set("UserInputState", luaTypes.wrap(new EnumItemV("UserInputState", str, state)));
        Vector2 guiPoint = guiPoint(x, y);
        Vector3 vector3 = new Vector3(guiPoint.getX(), guiPoint.getY(), 0.0f);
        luaTable.set("Position", luaTypes.wrap(vector3));
        Vector3 vector32 = this.lastPointer;
        luaTable.set("Delta", luaTypes.wrap((state != 1 || vector32 == null) ? Vector3.INSTANCE.getZERO() : vector3.minus(vector32)));
        luaTable.set("KeyCode", luaTypes.wrap(new EnumItemV("KeyCode", "Unknown", 0)));
        this.lastPointer = vector3;
        return luaTable;
    }

    static /* synthetic */ LuaValue touchInput$default(GuiOverlay guiOverlay, float f, float f2, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        return guiOverlay.touchInput(f, f2, i, z, z2);
    }

    private final UDim2 udim(Object v) {
        UDim2 uDim2 = v instanceof UDim2 ? (UDim2) v : null;
        return uDim2 == null ? new UDim2(0.0f, 0, 0.0f, 0) : uDim2;
    }

    private final void uisFire(String event, LuaValue input) {
        Instance findService = this.studio.getEditModel().findService("UserInputService");
        if (findService == null) {
            return;
        }
        LuaRuntime editRuntime = this.studio.getEditRuntime();
        LuaBoolean TRUE = LuaValue.TRUE;
        Intrinsics.checkNotNullExpressionValue(TRUE, "TRUE");
        editRuntime.fire(findService, event, input, TRUE);
    }

    private final void useGameUnits() {
        this.absUnit = this.d;
        this.absInset = 58.0f;
    }

    private final void usePluginUnits() {
        this.absUnit = this.d * this.studio.editGuiScale();
        this.absInset = 0.0f;
    }

    public final DragState beginDrag(Instance i, int handle) {
        Intrinsics.checkNotNullParameter(i, "i");
        synchronized (this.studio.getLock()) {
            EditBox editBox = this.boxes.get(i);
            if (editBox == null) {
                return null;
            }
            RectF rectF = new RectF(editBox.getRect());
            RectF rectF2 = new RectF(editBox.getArea());
            float scale = this.d * editBox.getScale();
            UDim2 udim = udim(i.get("Position"));
            UDim2 udim2 = udim(i.get("Size"));
            Object obj = i.get("AnchorPoint");
            Vector2 vector2 = obj instanceof Vector2 ? (Vector2) obj : null;
            if (vector2 == null) {
                vector2 = new Vector2(0.0f, 0.0f);
            }
            return new DragState(i, handle, rectF, rectF2, scale, udim, udim2, vector2, editBox.getInLayout());
        }
    }

    public final boolean blocksAt(float x, float y) {
        ArrayList<Hit> arrayList = this.hits;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (Hit hit : arrayList) {
            if (hit.getRect().contains(x, y) && !(hit.getKind() == 2 && seeThrough(hit.getInst()))) {
                return true;
            }
        }
        return false;
    }

    public final Hit buttonAt(float x, float y) {
        Hit hit;
        ArrayList<Hit> arrayList = this.hits;
        ListIterator<Hit> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                hit = null;
                break;
            }
            hit = listIterator.previous();
            Hit hit2 = hit;
            if (hit2.getKind() != 2 && hit2.getRect().contains(x, y)) {
                break;
            }
        }
        return hit;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean canWheel(com.exampletest.mobilestudiotest.ui.GuiOverlay.Hit r18, float r19, float r20) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.GuiOverlay.canWheel(com.exampletest.mobilestudiotest.ui.GuiOverlay$Hit, float, float):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dragTo(com.exampletest.mobilestudiotest.ui.GuiOverlay.DragState r33, float r34, float r35) {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.GuiOverlay.dragTo(com.exampletest.mobilestudiotest.ui.GuiOverlay$DragState, float, float):void");
    }

    public final EditBox editBox(Instance i) {
        Intrinsics.checkNotNullParameter(i, "i");
        return this.boxes.get(i);
    }

    public final void endDrag() {
        this.guides = CollectionsKt.emptyList();
        postInvalidate();
    }

    public final List<float[]> getGuides() {
        return this.guides;
    }

    public final boolean getHasContent() {
        return this.hasContent;
    }

    public final Function2<Float, Float, Unit> getOnCoreMenu() {
        return this.onCoreMenu;
    }

    public final Instance getPressed() {
        return this.pressed;
    }

    public final Instance getSelectedGui() {
        Object obj = null;
        if (this.studio.isPlaying()) {
            return null;
        }
        Iterator<T> it = this.studio.getSelection().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Instance) next).isA("GuiObject")) {
                obj = next;
                break;
            }
        }
        return (Instance) obj;
    }

    public final Integer handleAt(Instance i, float x, float y) {
        Intrinsics.checkNotNullParameter(i, "i");
        EditBox editBox = this.boxes.get(i);
        if (editBox == null) {
            return null;
        }
        float f = this.d * 16.0f;
        int i2 = 0;
        for (Object obj : handlePoints(editBox.getRect())) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            float[] fArr = (float[]) obj;
            if (Math.abs(fArr[0] - x) <= f && Math.abs(fArr[1] - y) <= f) {
                return Integer.valueOf(i2);
            }
            i2 = i3;
        }
        return (!editBox.getRect().contains(x, y) || seeThrough(i)) ? null : -1;
    }

    public final List<float[]> handlePoints(RectF r) {
        Intrinsics.checkNotNullParameter(r, "r");
        return CollectionsKt.listOf((Object[]) new float[][]{new float[]{r.left, r.top}, new float[]{r.centerX(), r.top}, new float[]{r.right, r.top}, new float[]{r.right, r.centerY()}, new float[]{r.right, r.bottom}, new float[]{r.centerX(), r.bottom}, new float[]{r.left, r.bottom}, new float[]{r.left, r.centerY()}});
    }

    public final boolean isPluginUi(Instance i) {
        boolean z;
        Intrinsics.checkNotNullParameter(i, "i");
        CopyOnWriteArrayList<PluginWidget> pluginWidgets = this.studio.getPluginWidgets();
        if (!(pluginWidgets instanceof Collection) || !pluginWidgets.isEmpty()) {
            Iterator<T> it = pluginWidgets.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                PluginWidget pluginWidget = (PluginWidget) it.next();
                if (i == pluginWidget.getInst() || i.isDescendantOf(pluginWidget.getInst())) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        for (Instance parent = i.getParent(); parent != null; parent = parent.getParent()) {
            if (Intrinsics.areEqual(parent.getClassName(), "CoreGui")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0219, code lost:
    
        if (r13.intValue() != r4) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0256 A[Catch: all -> 0x027a, TRY_LEAVE, TryCatch #4 {all -> 0x027a, blocks: (B:119:0x01d1, B:71:0x01d7, B:75:0x01e8, B:79:0x0208, B:96:0x023e, B:99:0x024c, B:101:0x0256, B:105:0x0270, B:112:0x0213), top: B:118:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0242 A[Catch: all -> 0x027c, TRY_ENTER, TryCatch #5 {all -> 0x027c, blocks: (B:67:0x01c7, B:73:0x01e2, B:76:0x01ee, B:87:0x0227, B:90:0x022f, B:97:0x0245, B:103:0x025f, B:108:0x0242), top: B:66:0x01c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010c A[Catch: all -> 0x03f8, TryCatch #3 {all -> 0x03f8, blocks: (B:5:0x0012, B:7:0x0044, B:9:0x004a, B:11:0x0052, B:13:0x0058, B:16:0x007e, B:18:0x008a, B:21:0x0097, B:23:0x00aa, B:25:0x00b0, B:26:0x00b7, B:27:0x00ce, B:29:0x00d4, B:31:0x00f2, B:35:0x010c, B:43:0x0120, B:44:0x014d, B:46:0x0153, B:48:0x0171, B:52:0x018c, B:60:0x0199, B:61:0x01ba, B:135:0x028c, B:139:0x0295, B:189:0x00b3, B:191:0x0084, B:192:0x005b, B:193:0x0060, B:195:0x006e, B:197:0x0074, B:198:0x0077), top: B:4:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018c A[Catch: all -> 0x03f8, TryCatch #3 {all -> 0x03f8, blocks: (B:5:0x0012, B:7:0x0044, B:9:0x004a, B:11:0x0052, B:13:0x0058, B:16:0x007e, B:18:0x008a, B:21:0x0097, B:23:0x00aa, B:25:0x00b0, B:26:0x00b7, B:27:0x00ce, B:29:0x00d4, B:31:0x00f2, B:35:0x010c, B:43:0x0120, B:44:0x014d, B:46:0x0153, B:48:0x0171, B:52:0x018c, B:60:0x0199, B:61:0x01ba, B:135:0x028c, B:139:0x0295, B:189:0x00b3, B:191:0x0084, B:192:0x005b, B:193:0x0060, B:195:0x006e, B:197:0x0074, B:198:0x0077), top: B:4:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x023e A[Catch: all -> 0x027a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x027a, blocks: (B:119:0x01d1, B:71:0x01d7, B:75:0x01e8, B:79:0x0208, B:96:0x023e, B:99:0x024c, B:101:0x0256, B:105:0x0270, B:112:0x0213), top: B:118:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024c A[Catch: all -> 0x027a, TRY_ENTER, TryCatch #4 {all -> 0x027a, blocks: (B:119:0x01d1, B:71:0x01d7, B:75:0x01e8, B:79:0x0208, B:96:0x023e, B:99:0x024c, B:101:0x0256, B:105:0x0270, B:112:0x0213), top: B:118:0x01d1 }] */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v22 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r29) {
        /*
            Method dump skipped, instructions count: 1020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.GuiOverlay.onDraw(android.graphics.Canvas):void");
    }

    public final Instance pick(float x, float y) {
        Instance findService;
        Pair<Instance, RectF> pair;
        if (this.studio.getPlay() != null || (findService = this.studio.getModel().findService("StarterGui")) == null) {
            return null;
        }
        ArrayList<Pair<Instance, RectF>> arrayList = this.picks;
        ListIterator<Pair<Instance, RectF>> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                pair = null;
                break;
            }
            pair = listIterator.previous();
            Pair<Instance, RectF> pair2 = pair;
            Instance component1 = pair2.component1();
            if (pair2.component2().contains(x, y) && component1.isDescendantOf(findService) && !seeThrough(component1)) {
                break;
            }
        }
        Pair<Instance, RectF> pair3 = pair;
        if (pair3 != null) {
            return pair3.getFirst();
        }
        return null;
    }

    public final Hit pluginFrameAt(float x, float y) {
        Hit hit = null;
        if (this.studio.getPlay() != null) {
            return null;
        }
        ArrayList<Hit> arrayList = this.hits;
        ListIterator<Hit> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Hit previous = listIterator.previous();
            Hit hit2 = previous;
            if (hit2.getKind() == 2 && hit2.getRt() != null && hit2.getRect().contains(x, y) && isPluginUi(hit2.getInst())) {
                hit = previous;
                break;
            }
        }
        return hit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v6 */
    public final void pluginPointerMove(Hit h, float x, float y) {
        ?? r20;
        int i;
        boolean z;
        boolean z2;
        int i2;
        Intrinsics.checkNotNullParameter(h, "h");
        if (mouseFor(h.getInst())) {
            synchronized (this.studio.getLock()) {
                boolean z3 = false;
                LuaValue luaValue = touchInput(x, y, 1, true, true);
                LuaRuntime rt = h.getRt();
                boolean z4 = false;
                int i3 = 1;
                if (rt != null) {
                    rt.fire(h.getInst(), "InputChanged", luaValue);
                }
                List<Hit> list = this.pressExtras.get(h);
                if (list != null) {
                    for (Hit hit : list) {
                        LuaRuntime rt2 = hit.getRt();
                        if (rt2 != null) {
                            Instance inst = hit.getInst();
                            LuaValue[] luaValueArr = new LuaValue[i3];
                            z = z3;
                            z2 = z4;
                            i2 = i3;
                            luaValueArr[z2 ? 1 : 0] = touchInput(x, y, 1, true, true);
                            rt2.fire(inst, "InputChanged", luaValueArr);
                        } else {
                            z = z3;
                            z2 = z4;
                            i2 = i3;
                        }
                        i3 = i2;
                        z3 = z;
                        z4 = z2;
                    }
                    r20 = z4;
                    i = i3;
                } else {
                    r20 = 0;
                    i = 1;
                }
                Vector2 guiPoint = guiPoint(x, y);
                LuaRuntime rt3 = h.getRt();
                if (rt3 != null) {
                    Instance inst2 = h.getInst();
                    LuaValue[] luaValueArr2 = new LuaValue[2];
                    LuaNumber valueOf = LuaValue.valueOf(guiPoint.getX());
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                    luaValueArr2[r20] = valueOf;
                    LuaNumber valueOf2 = LuaValue.valueOf(guiPoint.getY());
                    Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
                    luaValueArr2[i] = valueOf2;
                    rt3.fire(inst2, "MouseMoved", luaValueArr2);
                }
                uisFire("InputChanged", touchInput(x, y, 1, true, true));
                Unit unit = Unit.INSTANCE;
            }
            postInvalidate();
        }
    }

    public final boolean pluginUiAt(float x, float y) {
        ArrayList<Hit> arrayList = this.hits;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (Hit hit : arrayList) {
            if (hit.getRect().contains(x, y) && (hit.getKind() == 4 || (isPluginUi(hit.getInst()) && !(hit.getKind() == 2 && seeThrough(hit.getInst()))))) {
                return true;
            }
        }
        return false;
    }

    public final void pluginWheel(float x, float y, int z) {
        Instance pluginObjectAt = pluginObjectAt(x, y);
        if (pluginObjectAt == null) {
            return;
        }
        LuaRuntime pluginRt = pluginRt(pluginObjectAt);
        synchronized (this.studio.getLock()) {
            LuaTypes luaTypes = LuaTypes.INSTANCE;
            for (Instance instance = pluginObjectAt; instance != null && !Intrinsics.areEqual(instance.getClassName(), "CoreGui"); instance = instance.getParent()) {
                if (pluginRt.hasConn(instance, "InputChanged")) {
                    pluginRt.fire(instance, "InputChanged", pluginWheel$lambda$95$wheel(luaTypes, this, x, y, z));
                }
            }
            uisFire("InputChanged", pluginWheel$lambda$95$wheel(luaTypes, this, x, y, z));
            Unit unit = Unit.INSTANCE;
        }
        postInvalidate();
    }

    public final void press(Hit h, float x, float y) {
        GuiOverlay guiOverlay;
        Intrinsics.checkNotNullParameter(h, "h");
        if (h.getKind() != 0 && h.getKind() != 2) {
            return;
        }
        if (h.getKind() == 0) {
            this.pressed = h.getInst();
        }
        LuaRuntime rt = h.getRt();
        if (rt == null) {
            return;
        }
        boolean mouseFor = mouseFor(h.getInst());
        synchronized (this.studio.getLock()) {
            boolean z = false;
            try {
                List<Hit> extrasFor = mouseFor ? extrasFor(h, x, y) : CollectionsKt.emptyList();
                if (extrasFor.isEmpty()) {
                    this.pressExtras.remove(h);
                } else {
                    this.pressExtras.put(h, extrasFor);
                }
                int i = 1;
                if (mouseFor) {
                    for (Hit hit : extrasFor) {
                        Intrinsics.checkNotNullExpressionValue(hit, "next(...)");
                        hover(hit, x, y, true);
                    }
                    hover(h, x, y, true);
                }
                for (Hit hit2 : extrasFor) {
                    Intrinsics.checkNotNullExpressionValue(hit2, "next(...)");
                    Hit hit3 = hit2;
                    LuaRuntime rt2 = hit3.getRt();
                    if (rt2 != null) {
                        Instance inst = hit3.getInst();
                        LuaValue[] luaValueArr = new LuaValue[i];
                        luaValueArr[0] = touchInput$default(this, x, y, 0, true, false, 16, null);
                        rt2.fire(inst, "InputBegan", luaValueArr);
                        z = z;
                        i = i;
                    }
                }
                int i2 = i;
                if (h.getKind() == 0) {
                    Vector2 guiPoint = guiPoint(x, y);
                    Instance inst2 = h.getInst();
                    LuaValue[] luaValueArr2 = new LuaValue[2];
                    LuaNumber valueOf = LuaValue.valueOf(guiPoint.getX());
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                    luaValueArr2[0] = valueOf;
                    LuaNumber valueOf2 = LuaValue.valueOf(guiPoint.getY());
                    Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
                    luaValueArr2[i2] = valueOf2;
                    rt.fire(inst2, "MouseButton1Down", luaValueArr2);
                }
                Instance inst3 = h.getInst();
                LuaValue[] luaValueArr3 = new LuaValue[i2];
                try {
                    try {
                        luaValueArr3[0] = touchInput$default(this, x, y, 0, mouseFor, false, 16, null);
                        rt.fire(inst3, "InputBegan", luaValueArr3);
                        if (mouseFor) {
                            guiOverlay = this;
                            guiOverlay.uisFire("InputBegan", touchInput$default(guiOverlay, x, y, 0, true, false, 16, null));
                        } else {
                            guiOverlay = this;
                        }
                        Unit unit = Unit.INSTANCE;
                        guiOverlay.invalidate();
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

    public final void release(Hit h, float x, float y, boolean click) {
        GuiOverlay guiOverlay;
        float f;
        float f2;
        GuiOverlay guiOverlay2;
        float f3;
        float f4;
        Function2<? super Float, ? super Float, Unit> function2;
        Intrinsics.checkNotNullParameter(h, "h");
        if (this.pressed == h.getInst()) {
            this.pressed = null;
        }
        invalidate();
        switch (h.getKind()) {
            case 0:
                LuaRuntime rt = h.getRt();
                if (rt == null) {
                    return;
                }
                boolean mouseFor = mouseFor(h.getInst());
                synchronized (this.studio.getLock()) {
                    try {
                        releaseExtras(h, x, y);
                        Vector2 guiPoint = guiPoint(x, y);
                        Instance inst = h.getInst();
                        LuaNumber valueOf = LuaValue.valueOf(guiPoint.getX());
                        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                        LuaNumber valueOf2 = LuaValue.valueOf(guiPoint.getY());
                        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
                        rt.fire(inst, "MouseButton1Up", valueOf, valueOf2);
                        Instance inst2 = h.getInst();
                        LuaValue[] luaValueArr = new LuaValue[1];
                        try {
                            luaValueArr[0] = touchInput$default(this, x, y, 2, mouseFor, false, 16, null);
                            rt.fire(inst2, "InputEnded", luaValueArr);
                            if (mouseFor) {
                                guiOverlay = this;
                                try {
                                    guiOverlay.uisFire("InputEnded", touchInput$default(guiOverlay, x, y, 2, true, false, 16, null));
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            } else {
                                guiOverlay = this;
                            }
                            if (click) {
                                rt.fire(h.getInst(), "MouseButton1Click", new LuaValue[0]);
                                Instance inst3 = h.getInst();
                                LuaValue[] luaValueArr2 = new LuaValue[2];
                                f = x;
                                f2 = y;
                                try {
                                    luaValueArr2[0] = touchInput$default(guiOverlay, f, f2, 2, false, false, 24, null);
                                    LuaInteger valueOf3 = LuaValue.valueOf(1);
                                    Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(...)");
                                    luaValueArr2[1] = valueOf3;
                                    rt.fire(inst3, "Activated", luaValueArr2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                f = x;
                                f2 = y;
                            }
                            if (mouseFor) {
                                guiOverlay.hover(h, f, f2, false);
                            }
                            Unit unit = Unit.INSTANCE;
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            case 1:
                if (click) {
                    editTextBox(h);
                    return;
                }
                return;
            case 2:
                LuaRuntime rt2 = h.getRt();
                if (rt2 == null) {
                    return;
                }
                boolean mouseFor2 = mouseFor(h.getInst());
                synchronized (this.studio.getLock()) {
                    try {
                        releaseExtras(h, x, y);
                        Instance inst4 = h.getInst();
                        LuaValue[] luaValueArr3 = new LuaValue[1];
                        try {
                            try {
                                luaValueArr3[0] = touchInput$default(this, x, y, 2, mouseFor2, false, 16, null);
                                rt2.fire(inst4, "InputEnded", luaValueArr3);
                                if (mouseFor2) {
                                    guiOverlay2 = this;
                                    f3 = x;
                                    f4 = y;
                                    try {
                                        guiOverlay2.uisFire("InputEnded", touchInput$default(guiOverlay2, f3, f4, 2, true, false, 16, null));
                                    } catch (Throwable th5) {
                                        th = th5;
                                        throw th;
                                    }
                                } else {
                                    guiOverlay2 = this;
                                    f3 = x;
                                    f4 = y;
                                }
                                if (mouseFor2) {
                                    guiOverlay2.hover(h, f3, f4, false);
                                }
                                Unit unit2 = Unit.INSTANCE;
                                return;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
            case 3:
                if (click && (function2 = this.onCoreMenu) != null) {
                    function2.invoke(Float.valueOf(x), Float.valueOf(y));
                }
                return;
            case 4:
                if (click) {
                    synchronized (this.studio.getLock()) {
                        Instance.set$default(h.getInst(), "Enabled", false, false, 4, null);
                        Unit unit3 = Unit.INSTANCE;
                    }
                    postInvalidate();
                }
                return;
            default:
                return;
        }
    }

    public final void renderSurface(Instance gui, float cw, float ch, Bitmap bmp) {
        Intrinsics.checkNotNullParameter(gui, "gui");
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        bmp.eraseColor(0);
        Canvas canvas = new Canvas(bmp);
        canvas.scale(bmp.getWidth() / cw, bmp.getHeight() / ch);
        ArrayList<Hit> arrayList = this.newHits;
        ArrayList<Scroll> arrayList2 = this.newScrolls;
        ArrayList<Pair<Instance, RectF>> arrayList3 = this.newPicks;
        LuaRuntime luaRuntime = this.rt;
        this.newHits = new ArrayList<>();
        this.newScrolls = new ArrayList<>();
        this.newPicks = new ArrayList<>();
        RectF rectF = new RectF(0.0f, 0.0f, cw, ch);
        float f = this.absUnit;
        float f2 = this.absInset;
        this.absUnit = 1.0f;
        this.absInset = 0.0f;
        try {
            drawChildren(canvas, gui, rectF, 1.0f / this.d, rectF);
        } finally {
            this.newHits = arrayList;
            this.newScrolls = arrayList2;
            this.newPicks = arrayList3;
            this.rt = luaRuntime;
            this.absUnit = f;
            this.absInset = f2;
        }
    }

    public final Scroll scrollAt(float x, float y) {
        Scroll scroll;
        ArrayList<Scroll> arrayList = this.scrolls;
        ListIterator<Scroll> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                scroll = null;
                break;
            }
            scroll = listIterator.previous();
            if (scroll.getRect().contains(x, y)) {
                break;
            }
        }
        return scroll;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
    
        if ((r3 == r2.getY()) == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void scrollBy(com.exampletest.mobilestudiotest.ui.GuiOverlay.Scroll r12, float r13, float r14) {
        /*
            r11 = this;
            java.lang.String r0 = "s"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.exampletest.mobilestudiotest.core.Studio r0 = r11.studio
            java.lang.Object r1 = r0.getLock()
            monitor-enter(r1)
            r0 = 0
            com.exampletest.mobilestudiotest.model.Instance r2 = r12.getInst()     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "CanvasPosition"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L80
            boolean r3 = r2 instanceof com.exampletest.mobilestudiotest.model.Vector2     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto L1e
            com.exampletest.mobilestudiotest.model.Vector2 r2 = (com.exampletest.mobilestudiotest.model.Vector2) r2     // Catch: java.lang.Throwable -> L80
            goto L1f
        L1e:
            r2 = 0
        L1f:
            r3 = 0
            if (r2 != 0) goto L27
            com.exampletest.mobilestudiotest.model.Vector2 r2 = new com.exampletest.mobilestudiotest.model.Vector2     // Catch: java.lang.Throwable -> L80
            r2.<init>(r3, r3)     // Catch: java.lang.Throwable -> L80
        L27:
            float r4 = r2.getX()     // Catch: java.lang.Throwable -> L80
            float r5 = r12.getUnit()     // Catch: java.lang.Throwable -> L80
            float r5 = r13 / r5
            float r4 = r4 - r5
            float r5 = r12.getMaxX()     // Catch: java.lang.Throwable -> L80
            float r4 = kotlin.ranges.RangesKt.coerceIn(r4, r3, r5)     // Catch: java.lang.Throwable -> L80
            float r5 = r2.getY()     // Catch: java.lang.Throwable -> L80
            float r6 = r12.getUnit()     // Catch: java.lang.Throwable -> L80
            float r6 = r14 / r6
            float r5 = r5 - r6
            float r6 = r12.getMaxY()     // Catch: java.lang.Throwable -> L80
            float r3 = kotlin.ranges.RangesKt.coerceIn(r5, r3, r6)     // Catch: java.lang.Throwable -> L80
            float r5 = r2.getX()     // Catch: java.lang.Throwable -> L80
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L59
            r5 = r6
            goto L5a
        L59:
            r5 = r7
        L5a:
            if (r5 == 0) goto L67
            float r5 = r2.getY()     // Catch: java.lang.Throwable -> L80
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L65
            r6 = r7
        L65:
            if (r6 != 0) goto L78
        L67:
            com.exampletest.mobilestudiotest.model.Instance r5 = r12.getInst()     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "CanvasPosition"
            com.exampletest.mobilestudiotest.model.Vector2 r7 = new com.exampletest.mobilestudiotest.model.Vector2     // Catch: java.lang.Throwable -> L80
            r7.<init>(r4, r3)     // Catch: java.lang.Throwable -> L80
            r9 = 4
            r10 = 0
            r8 = 0
            com.exampletest.mobilestudiotest.model.Instance.set$default(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L80
        L78:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L80
            monitor-exit(r1)
            r11.invalidate()
            return
        L80:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.GuiOverlay.scrollBy(com.exampletest.mobilestudiotest.ui.GuiOverlay$Scroll, float, float):void");
    }

    public final boolean seeThrough(Instance c) {
        String obj;
        boolean z;
        Intrinsics.checkNotNullParameter(c, "c");
        if (Intrinsics.areEqual(c.get("Visible"), (Object) false)) {
            return true;
        }
        if (num(c, "BackgroundTransparency", 0.0f) < 0.999f) {
            return false;
        }
        String str = "";
        if (c.isA("TextLabel") || c.isA("TextButton") || Intrinsics.areEqual(c.getClassName(), "TextBox")) {
            Object obj2 = c.get("Text");
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            if (str2 == null) {
                str2 = "";
            }
            if (!StringsKt.isBlank(str2) && num(c, "TextTransparency", 0.0f) < 0.999f) {
                return false;
            }
        }
        if (Intrinsics.areEqual(c.getClassName(), "ImageLabel") || Intrinsics.areEqual(c.getClassName(), "ImageButton")) {
            Object obj3 = c.get("Image");
            if (obj3 != null && (obj = obj3.toString()) != null) {
                str = obj;
            }
            if (!StringsKt.isBlank(str) && num(c, "ImageTransparency", 0.0f) < 0.999f) {
                return false;
            }
        }
        ArrayList<Instance> children = c.getChildren();
        if (!(children instanceof Collection) || !children.isEmpty()) {
            Iterator<T> it = children.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Instance instance = (Instance) it.next();
                if (Intrinsics.areEqual(instance.getClassName(), "UIStroke") && !Intrinsics.areEqual(instance.get("Enabled"), (Object) false) && num(instance, "Transparency", 0.0f) < 0.999f) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
        }
        return !z;
    }

    public final void setGuides(List<float[]> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.guides = list;
    }

    public final void setHasContent(boolean z) {
        this.hasContent = z;
    }

    public final void setOnCoreMenu(Function2<? super Float, ? super Float, Unit> function2) {
        this.onCoreMenu = function2;
    }

    public final void setPressed(Instance instance) {
        this.pressed = instance;
    }

    public final void setSelectedGui(Instance instance) {
    }

    public final boolean tap(float x, float y) {
        Hit buttonAt = buttonAt(x, y);
        if (buttonAt == null) {
            return false;
        }
        if (this.studio.getPlay() == null && buttonAt.getRt() == this.studio.getEditRuntime() && buttonAt.getKind() != 4 && !isPluginUi(buttonAt.getInst())) {
            return false;
        }
        press(buttonAt, x, y);
        release(buttonAt, x, y, true);
        return true;
    }
}
