package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.exampletest.mobilestudiotest.core.Settings;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.core.Tool;
import com.exampletest.mobilestudiotest.core.UndoManager;
import com.exampletest.mobilestudiotest.engine.ConvexShape;
import com.exampletest.mobilestudiotest.engine.Geometry;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.engine.RayHit;
import com.exampletest.mobilestudiotest.lua.EnumItemV;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.lua.LuaTypes;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.DataTypesKt;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.render.AdornHandles;
import com.exampletest.mobilestudiotest.render.FlyCamera;
import com.exampletest.mobilestudiotest.render.Handle;
import com.exampletest.mobilestudiotest.render.HandleSet;
import com.exampletest.mobilestudiotest.render.Handles;
import com.exampletest.mobilestudiotest.render.SceneRenderer;
import com.exampletest.mobilestudiotest.ui.GuiOverlay;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaValue;

/* compiled from: ViewportView.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0003$%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u00060\u0015R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "<init>", "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/core/Studio;)V", "gl", "Landroid/opengl/GLSurfaceView;", "getGl", "()Landroid/opengl/GLSurfaceView;", "renderer", "Lcom/exampletest/mobilestudiotest/render/SceneRenderer;", "getRenderer", "()Lcom/exampletest/mobilestudiotest/render/SceneRenderer;", "gui", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay;", "getGui", "()Lcom/exampletest/mobilestudiotest/ui/GuiOverlay;", "controls", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "getControls", "()Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "hud", "Lcom/exampletest/mobilestudiotest/ui/PlayHud;", "getHud", "()Lcom/exampletest/mobilestudiotest/ui/PlayHud;", "lastOverlay", "", "lastControls", "hudPosted", "", "onResume", "", "onPause", "MsaaConfigChooser", "Companion", "TouchLayer", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewportView extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile int depthBits = 16;
    private final TouchLayer controls;
    private final GLSurfaceView gl;
    private final GuiOverlay gui;
    private final PlayHud hud;
    private boolean hudPosted;
    private long lastControls;
    private long lastOverlay;
    private final SceneRenderer renderer;
    private final Studio studio;

    /* compiled from: ViewportView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$Companion;", "", "<init>", "()V", "depthBits", "", "getDepthBits", "()I", "setDepthBits", "(I)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getDepthBits() {
            return ViewportView.access$getDepthBits$cp();
        }

        public final void setDepthBits(int i) {
            ViewportView.access$setDepthBits$cp(i);
        }
    }

    /* compiled from: ViewportView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$MsaaConfigChooser;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "<init>", "()V", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class MsaaConfigChooser implements GLSurfaceView.EGLConfigChooser {
        private static final EGLConfig chooseConfig$pick(EGL10 egl10, EGLDisplay eGLDisplay, int i, int i2) {
            List mutableListOf = CollectionsKt.mutableListOf(12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, Integer.valueOf(i2), 12352, 4);
            if (i > 0) {
                CollectionsKt.addAll(mutableListOf, CollectionsKt.listOf((Object[]) new Integer[]{12338, 1, 12337, Integer.valueOf(i)}));
            }
            mutableListOf.add(12344);
            int[] intArray = CollectionsKt.toIntArray(mutableListOf);
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, intArray, null, 0, iArr) || iArr[0] <= 0) {
                return null;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
            egl10.eglChooseConfig(eGLDisplay, intArray, eGLConfigArr, iArr[0], iArr);
            int length = eGLConfigArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                EGLConfig eGLConfig = eGLConfigArr[i3];
                if (eGLConfig != null) {
                    return eGLConfig;
                }
            }
            return null;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            Intrinsics.checkNotNullParameter(egl, "egl");
            Intrinsics.checkNotNullParameter(display, "display");
            EGLConfig chooseConfig$pick = chooseConfig$pick(egl, display, 4, 24);
            if (chooseConfig$pick == null) {
                EGLConfig chooseConfig$pick2 = chooseConfig$pick(egl, display, 2, 24);
                if (chooseConfig$pick2 == null) {
                    EGLConfig chooseConfig$pick3 = chooseConfig$pick(egl, display, 0, 24);
                    if (chooseConfig$pick3 == null) {
                        EGLConfig chooseConfig$pick4 = chooseConfig$pick(egl, display, 4, 16);
                        if (chooseConfig$pick4 == null) {
                            chooseConfig$pick = chooseConfig$pick(egl, display, 2, 16);
                            if (chooseConfig$pick == null && (chooseConfig$pick = chooseConfig$pick(egl, display, 0, 16)) == null) {
                                throw new IllegalStateException("No suitable EGL config");
                            }
                        } else {
                            chooseConfig$pick = chooseConfig$pick4;
                        }
                    } else {
                        chooseConfig$pick = chooseConfig$pick3;
                    }
                } else {
                    chooseConfig$pick = chooseConfig$pick2;
                }
            }
            int[] iArr = new int[1];
            if (egl.eglGetConfigAttrib(display, chooseConfig$pick, 12325, iArr)) {
                ViewportView.INSTANCE.setDepthBits(iArr[0]);
            }
            return chooseConfig$pick;
        }
    }

    /* compiled from: ViewportView.kt */
    @Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0004\u0018\u00002\u00020\u0001:\u000fstuvwxyz{|}~\u007f\u0080\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u00100\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J8\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0012H\u0002J8\u0010;\u001a\u00020,2\u0006\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0012H\u0002J8\u0010<\u001a\u00020,2\u0006\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0012H\u0002J@\u0010=\u001a\u00020,2\u0006\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0012H\u0002J@\u0010?\u001a\u00020,2\u0006\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u0012H\u0002J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020CH\u0017J \u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J(\u0010H\u001a\u00020,2\u000e\u0010I\u001a\n0\u000eR\u00060\u0000R\u00020\u000f2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0002J(\u0010>\u001a\u00020,2\u0006\u0010G\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0012H\u0002J\u0018\u0010M\u001a\u00020,2\u000e\u0010I\u001a\n0NR\u00060\u0000R\u00020\u000fH\u0002J\u0018\u0010O\u001a\u00020,2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0018\u0010P\u001a\u00020,2\u0006\u00106\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u0012H\u0002J\b\u0010Q\u001a\u00020,H\u0002J\b\u0010R\u001a\u00020,H\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020TH\u0002J\u0018\u0010V\u001a\u00020,2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0018\u0010W\u001a\u00020,2\u000e\u0010X\u001a\n0YR\u00060\u0000R\u00020\u000fH\u0002J/\u0010Z\u001a\u0004\u0018\u00010\u00072\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\\2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010^J*\u0010_\u001a\f\u0018\u00010`R\u00060\u0000R\u00020\u000f2\u0006\u0010G\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0018\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0007H\u0002J\u0016\u0010d\u001a\u00020\u00122\f\u0010e\u001a\b\u0012\u0004\u0012\u00020T0fH\u0002J\u0018\u0010g\u001a\u00020,2\u000e\u0010I\u001a\n0`R\u00060\u0000R\u00020\u000fH\u0002J\u0018\u0010h\u001a\u00020,2\u000e\u0010I\u001a\n0`R\u00060\u0000R\u00020\u000fH\u0002J\u0012\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u00020TH\u0002J*\u0010l\u001a\f\u0018\u00010mR\u00060\u0000R\u00020\u000f2\u0006\u0010G\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0018\u0010n\u001a\u00020,2\u000e\u0010I\u001a\n0mR\u00060\u0000R\u00020\u000fH\u0002J*\u0010o\u001a\f\u0018\u00010pR\u00060\u0000R\u00020\u000f2\u0006\u0010G\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0018\u0010q\u001a\u00020,2\u000e\u0010I\u001a\n0pR\u00060\u0000R\u00020\u000fH\u0002J\u0018\u0010r\u001a\u00020,2\u000e\u0010I\u001a\n0pR\u00060\u0000R\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\u000b\u001a.\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n0\u000eR\u00060\u0000R\u00020\u000f0\fj\u0016\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n0\u000eR\u00060\u0000R\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\fj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010 R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0014R\u0014\u0010)\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0014R\u0014\u0010D\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0014¨\u0006\u0081\u0001"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView;Landroid/content/Context;)V", "d", "", "paint", "Landroid/graphics/Paint;", "text", "ptrs", "Ljava/util/HashMap;", "", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "Lkotlin/collections/HashMap;", "busy", "", "getBusy", "()Z", "joyX", "joyY", "pinchDist", "pinchMid", "", "buttons", "", "Landroid/graphics/RectF;", "jumpDown", "joyR", "getJoyR", "()F", "defaultJoyX", "getDefaultJoyX", "defaultJoyY", "getDefaultJoyY", "joyCx", "joyCy", "activeJoy", "getActiveJoy", "fixedStick", "getFixedStick", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawThumbstick", "drawPlayControls", "play", "Lcom/exampletest/mobilestudiotest/engine/PlaySession;", "drawEditControls", "insideIconButton", "c", "name", "x", "y", "r", "active", "boxIconButton", "multiIconButton", "arrowButton", "up", "circleButton", "label", "onTouchEvent", "e", "Landroid/view/MotionEvent;", "additive", "getAdditive", "down", "id", "move", "p", "nx", "ny", "cancel", "finishGuiDrag", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$GuiDrag;", "setJoy", "pressButton", "resetPinch", "camGesture", "selectTarget", "Lcom/exampletest/mobilestudiotest/model/Instance;", "part", "tap", "finishBox", "b", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$BoxSel;", "axisParam", "center", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "axis", "(Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;FF)Ljava/lang/Float;", "tryStartDrag", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Drag;", "snap", "v", "step", "overlapsOthers", "parts", "", "updateDrag", "finishDrag", "runtimeFor", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "a", "tryStartAdorn", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$AdornDrag;", "dragAdorn", "tryStartPartDrag", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$PartDrag;", "updatePartDrag", "finishPartDrag", "Ptr", "Joy", "Btn", "Cam", "GuiPress", "GuiScroll", "GuiDrag", "Sink", "PluginWheel", "Drag", "PartDrag", "BoxSel", "PluginPtr", "AdornDrag", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class TouchLayer extends View {
        private final HashMap<String, RectF> buttons;
        private final float d;
        private float joyCx;
        private float joyCy;
        private float joyX;
        private float joyY;
        private boolean jumpDown;
        private final Paint paint;
        private float pinchDist;
        private float[] pinchMid;
        private final HashMap<Integer, Ptr> ptrs;
        private final Paint text;
        final /* synthetic */ ViewportView this$0;

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003BI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$AdornDrag;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "adorn", "Lcom/exampletest/mobilestudiotest/model/Instance;", "tip", "Lcom/exampletest/mobilestudiotest/render/AdornHandles$Tip;", "axis0", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_ARG, "Lorg/luaj/vm2/LuaValue;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFFLcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/render/AdornHandles$Tip;Ljava/lang/Float;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/LuaValue;)V", "getAdorn", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getTip", "()Lcom/exampletest/mobilestudiotest/render/AdornHandles$Tip;", "getAxis0", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getRt", "()Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "getArg", "()Lorg/luaj/vm2/LuaValue;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class AdornDrag extends Ptr {
            private final Instance adorn;
            private final LuaValue arg;
            private final Float axis0;
            private final LuaRuntime rt;
            final /* synthetic */ TouchLayer this$0;
            private final AdornHandles.Tip tip;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AdornDrag(TouchLayer touchLayer, int i, float f, float f2, Instance adorn, AdornHandles.Tip tip, Float f3, LuaRuntime rt, LuaValue arg) {
                super(i, f, f2);
                Intrinsics.checkNotNullParameter(adorn, "adorn");
                Intrinsics.checkNotNullParameter(tip, "tip");
                Intrinsics.checkNotNullParameter(rt, "rt");
                Intrinsics.checkNotNullParameter(arg, "arg");
                this.this$0 = touchLayer;
                this.adorn = adorn;
                this.tip = tip;
                this.axis0 = f3;
                this.rt = rt;
                this.arg = arg;
            }

            public final Instance getAdorn() {
                return this.adorn;
            }

            public final LuaValue getArg() {
                return this.arg;
            }

            public final Float getAxis0() {
                return this.axis0;
            }

            public final LuaRuntime getRt() {
                return this.rt;
            }

            public final AdornHandles.Tip getTip() {
                return this.tip;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$BoxSel;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "additive", "", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFFZ)V", "getAdditive", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class BoxSel extends Ptr {
            private final boolean additive;

            public BoxSel(int i, float f, float f2, boolean z) {
                super(i, f, f2);
                this.additive = z;
            }

            public final boolean getAdditive() {
                return this.additive;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Btn;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "name", "", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFFLjava/lang/String;)V", "getName", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class Btn extends Ptr {
            private final String name;
            final /* synthetic */ TouchLayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Btn(TouchLayer touchLayer, int i, float f, float f2, String name) {
                super(i, f, f2);
                Intrinsics.checkNotNullParameter(name, "name");
                this.this$0 = touchLayer;
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Cam;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFF)V", "moved", "", "getMoved", "()Z", "setMoved", "(Z)V", "playDown", "getPlayDown", "setPlayDown", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public final class Cam extends Ptr {
            private boolean moved;
            private boolean playDown;

            public Cam(int i, float f, float f2) {
                super(i, f, f2);
            }

            public final boolean getMoved() {
                return this.moved;
            }

            public final boolean getPlayDown() {
                return this.playDown;
            }

            public final void setMoved(boolean z) {
                this.moved = z;
            }

            public final void setPlayDown(boolean z) {
                this.playDown = z;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u0083\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Drag;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "handle", "Lcom/exampletest/mobilestudiotest/render/Handle;", "tool", "Lcom/exampletest/mobilestudiotest/core/Tool;", "parts", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "startCf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "startSize", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "pxPerStud", "screenDir", "", "center", "localAxis", "t0Axis", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFFLcom/exampletest/mobilestudiotest/render/Handle;Lcom/exampletest/mobilestudiotest/core/Tool;Ljava/util/List;Ljava/util/List;Ljava/util/List;F[FLcom/exampletest/mobilestudiotest/model/Vector3;ILjava/lang/Float;)V", "getHandle", "()Lcom/exampletest/mobilestudiotest/render/Handle;", "getTool", "()Lcom/exampletest/mobilestudiotest/core/Tool;", "getParts", "()Ljava/util/List;", "getStartCf", "getStartSize", "getPxPerStud", "()F", "getScreenDir", "()[F", "getCenter", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getLocalAxis", "()I", "getT0Axis", "()Ljava/lang/Float;", "Ljava/lang/Float;", "startedOverlapping", "", "getStartedOverlapping", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class Drag extends Ptr {
            private final Vector3 center;
            private final Handle handle;
            private final int localAxis;
            private final List<Instance> parts;
            private final float pxPerStud;
            private final float[] screenDir;
            private final List<CFrame> startCf;
            private final List<Vector3> startSize;
            private final boolean startedOverlapping;
            private final Float t0Axis;
            final /* synthetic */ TouchLayer this$0;
            private final Tool tool;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Drag(TouchLayer touchLayer, int i, float f, float f2, Handle handle, Tool tool, List<? extends Instance> parts, List<CFrame> startCf, List<Vector3> startSize, float f3, float[] screenDir, Vector3 center, int i2, Float f4) {
                super(i, f, f2);
                Intrinsics.checkNotNullParameter(handle, "handle");
                Intrinsics.checkNotNullParameter(tool, "tool");
                Intrinsics.checkNotNullParameter(parts, "parts");
                Intrinsics.checkNotNullParameter(startCf, "startCf");
                Intrinsics.checkNotNullParameter(startSize, "startSize");
                Intrinsics.checkNotNullParameter(screenDir, "screenDir");
                Intrinsics.checkNotNullParameter(center, "center");
                this.this$0 = touchLayer;
                this.handle = handle;
                this.tool = tool;
                this.parts = parts;
                this.startCf = startCf;
                this.startSize = startSize;
                this.pxPerStud = f3;
                this.screenDir = screenDir;
                this.center = center;
                this.localAxis = i2;
                this.t0Axis = f4;
                this.startedOverlapping = this.tool == Tool.MOVE && ViewportView.access$getStudio$p(this.this$0.this$0).getCollisionsEnabled() && TouchLayer.access$overlapsOthers(this.this$0, this.parts);
            }

            public final Vector3 getCenter() {
                return this.center;
            }

            public final Handle getHandle() {
                return this.handle;
            }

            public final int getLocalAxis() {
                return this.localAxis;
            }

            public final List<Instance> getParts() {
                return this.parts;
            }

            public final float getPxPerStud() {
                return this.pxPerStud;
            }

            public final float[] getScreenDir() {
                return this.screenDir;
            }

            public final List<CFrame> getStartCf() {
                return this.startCf;
            }

            public final List<Vector3> getStartSize() {
                return this.startSize;
            }

            public final boolean getStartedOverlapping() {
                return this.startedOverlapping;
            }

            public final Float getT0Axis() {
                return this.t0Axis;
            }

            public final Tool getTool() {
                return this.tool;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$GuiDrag;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "state", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$DragState;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFFLcom/exampletest/mobilestudiotest/ui/GuiOverlay$DragState;)V", "getState", "()Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$DragState;", "active", "", "getActive", "()Z", "setActive", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class GuiDrag extends Ptr {
            private boolean active;
            private final GuiOverlay.DragState state;
            final /* synthetic */ TouchLayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuiDrag(TouchLayer touchLayer, int i, float f, float f2, GuiOverlay.DragState state) {
                super(i, f, f2);
                Intrinsics.checkNotNullParameter(state, "state");
                this.this$0 = touchLayer;
                this.state = state;
            }

            public final boolean getActive() {
                return this.active;
            }

            public final GuiOverlay.DragState getState() {
                return this.state;
            }

            public final void setActive(boolean z) {
                this.active = z;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$GuiPress;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "hit", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Hit;", "scroll", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Scroll;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFFLcom/exampletest/mobilestudiotest/ui/GuiOverlay$Hit;Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Scroll;)V", "getHit", "()Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Hit;", "getScroll", "()Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Scroll;", "cancelled", "", "getCancelled", "()Z", "setCancelled", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class GuiPress extends Ptr {
            private boolean cancelled;
            private final GuiOverlay.Hit hit;
            private final GuiOverlay.Scroll scroll;
            final /* synthetic */ TouchLayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuiPress(TouchLayer touchLayer, int i, float f, float f2, GuiOverlay.Hit hit, GuiOverlay.Scroll scroll) {
                super(i, f, f2);
                Intrinsics.checkNotNullParameter(hit, "hit");
                this.this$0 = touchLayer;
                this.hit = hit;
                this.scroll = scroll;
            }

            public final boolean getCancelled() {
                return this.cancelled;
            }

            public final GuiOverlay.Hit getHit() {
                return this.hit;
            }

            public final GuiOverlay.Scroll getScroll() {
                return this.scroll;
            }

            public final void setCancelled(boolean z) {
                this.cancelled = z;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$GuiScroll;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "scroll", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Scroll;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFFLcom/exampletest/mobilestudiotest/ui/GuiOverlay$Scroll;)V", "getScroll", "()Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$Scroll;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class GuiScroll extends Ptr {
            private final GuiOverlay.Scroll scroll;
            final /* synthetic */ TouchLayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuiScroll(TouchLayer touchLayer, int i, float f, float f2, GuiOverlay.Scroll scroll) {
                super(i, f, f2);
                Intrinsics.checkNotNullParameter(scroll, "scroll");
                this.this$0 = touchLayer;
                this.scroll = scroll;
            }

            public final GuiOverlay.Scroll getScroll() {
                return this.scroll;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Joy;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFF)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class Joy extends Ptr {
            public Joy(int i, float f, float f2) {
                super(i, f, f2);
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003BS\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$PartDrag;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "parts", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "startCf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "grab", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "center", "half", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFFLjava/util/List;Ljava/util/List;Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getParts", "()Ljava/util/List;", "getStartCf", "getGrab", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getCenter", "getHalf", "active", "", "getActive", "()Z", "setActive", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class PartDrag extends Ptr {
            private boolean active;
            private final Vector3 center;
            private final Vector3 grab;
            private final Vector3 half;
            private final List<Instance> parts;
            private final List<CFrame> startCf;
            final /* synthetic */ TouchLayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public PartDrag(TouchLayer touchLayer, int i, float f, float f2, List<? extends Instance> parts, List<CFrame> startCf, Vector3 grab, Vector3 center, Vector3 half) {
                super(i, f, f2);
                Intrinsics.checkNotNullParameter(parts, "parts");
                Intrinsics.checkNotNullParameter(startCf, "startCf");
                Intrinsics.checkNotNullParameter(grab, "grab");
                Intrinsics.checkNotNullParameter(center, "center");
                Intrinsics.checkNotNullParameter(half, "half");
                this.this$0 = touchLayer;
                this.parts = parts;
                this.startCf = startCf;
                this.grab = grab;
                this.center = center;
                this.half = half;
            }

            public final boolean getActive() {
                return this.active;
            }

            public final Vector3 getCenter() {
                return this.center;
            }

            public final Vector3 getGrab() {
                return this.grab;
            }

            public final Vector3 getHalf() {
                return this.half;
            }

            public final List<Instance> getParts() {
                return this.parts;
            }

            public final List<CFrame> getStartCf() {
                return this.startCf;
            }

            public final void setActive(boolean z) {
                this.active = z;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$PluginPtr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFF)V", "moved", "", "getMoved", "()Z", "setMoved", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class PluginPtr extends Ptr {
            private boolean moved;

            public PluginPtr(int i, float f, float f2) {
                super(i, f, f2);
            }

            public final boolean getMoved() {
                return this.moved;
            }

            public final void setMoved(boolean z) {
                this.moved = z;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$PluginWheel;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFF)V", "acc", "getAcc", "()F", "setAcc", "(F)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class PluginWheel extends Ptr {
            private float acc;

            public PluginWheel(int i, float f, float f2) {
                super(i, f, f2);
            }

            public final float getAcc() {
                return this.acc;
            }

            public final void setAcc(float f) {
                this.acc = f;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\b¢\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "", "id", "", "x", "", "y", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFF)V", "getId", "()I", "getX", "()F", "setX", "(F)V", "getY", "setY", "t0", "", "getT0", "()J", "x0", "getX0", "y0", "getY0", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private abstract class Ptr {
            private final int id;
            private final long t0 = System.currentTimeMillis();
            private float x;
            private final float x0;
            private float y;
            private final float y0;

            public Ptr(int i, float f, float f2) {
                this.id = i;
                this.x = f;
                this.y = f2;
                this.x0 = this.x;
                this.y0 = this.y;
            }

            public final int getId() {
                return this.id;
            }

            public final long getT0() {
                return this.t0;
            }

            public final float getX() {
                return this.x;
            }

            public final float getX0() {
                return this.x0;
            }

            public final float getY() {
                return this.y;
            }

            public final float getY0() {
                return this.y0;
            }

            public final void setX(float f) {
                this.x = f;
            }

            public final void setY(float f) {
                this.y = f;
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Sink;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer$Ptr;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "id", "", "x", "", "y", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;IFF)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private final class Sink extends Ptr {
            public Sink(int i, float f, float f2) {
                super(i, f, f2);
            }
        }

        /* compiled from: ViewportView.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Tool.values().length];
                try {
                    iArr[Tool.MOVE.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Tool.SCALE.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Tool.ROTATE.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TouchLayer(ViewportView viewportView, Context ctx) {
            super(ctx);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.this$0 = viewportView;
            this.d = getResources().getDisplayMetrics().density;
            this.paint = new Paint(1);
            Paint paint = new Paint(1);
            paint.setColor(-1);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setFakeBoldText(true);
            this.text = paint;
            this.ptrs = new HashMap<>();
            this.pinchMid = new float[]{0.0f, 0.0f};
            this.buttons = new HashMap<>();
        }

        public static final /* synthetic */ boolean access$overlapsOthers(TouchLayer touchLayer, List list) {
            return touchLayer.overlapsOthers(list);
        }

        private final void arrowButton(Canvas c, String name, float x, float y, float r, boolean up, boolean active) {
            Path path;
            circleButton(c, name, x, y, r, "", active);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.d * 3.5f);
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            this.paint.setStrokeJoin(Paint.Join.ROUND);
            this.paint.setColor(-1);
            float f = r * 0.38f;
            if (up) {
                path = new Path();
                path.moveTo(x - f, (f * 0.5f) + y);
                path.lineTo(x, y - (0.6f * f));
                path.lineTo(x + f, (0.5f * f) + y);
            } else {
                path = new Path();
                path.moveTo(x - f, y - (f * 0.5f));
                path.lineTo(x, (0.6f * f) + y);
                path.lineTo(x + f, y - (0.5f * f));
            }
            c.drawPath(path, this.paint);
            this.paint.setStyle(Paint.Style.FILL);
        }

        private final Float axisParam(Vector3 center, Vector3 axis, float x, float y) {
            Pair<Vector3, Vector3> screenRay = ViewportView.access$getStudio$p(this.this$0).getView().screenRay(x, y);
            Vector3 component1 = screenRay.component1();
            Vector3 component2 = screenRay.component2();
            Vector3 minus = center.minus(component1);
            float dot = axis.dot(component2);
            float f = 1.0f - (dot * dot);
            if (f < 0.02f) {
                return null;
            }
            return Float.valueOf(((component2.dot(minus) * dot) - axis.dot(minus)) / f);
        }

        private final void boxIconButton(Canvas c, String name, float x, float y, float r, boolean active) {
            circleButton(c, name, x, y, r, "", active);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.d * 2.0f);
            this.paint.setColor(-1);
            this.paint.setPathEffect(new DashPathEffect(new float[]{this.d * 4.0f, this.d * 3.0f}, 0.0f));
            c.drawRect(x - (r * 0.45f), y - (r * 0.38f), (0.45f * r) + x, (0.38f * r) + y, this.paint);
            this.paint.setPathEffect(null);
            this.paint.setStyle(Paint.Style.FILL);
        }

        private final void camGesture() {
            char c;
            char c2;
            Collection<Ptr> values = this.ptrs.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Ptr ptr = (Ptr) next;
                if ((ptr instanceof Cam) || (ptr instanceof PluginPtr) || (ptr instanceof BoxSel)) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.size() < 2) {
                return;
            }
            for (Object obj : arrayList2) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                Ptr ptr2 = (Ptr) obj;
                if (ptr2 instanceof PluginPtr) {
                    HashMap<Integer, Ptr> hashMap = this.ptrs;
                    Integer valueOf = Integer.valueOf(ptr2.getId());
                    Cam cam = new Cam(ptr2.getId(), ptr2.getX(), ptr2.getY());
                    cam.setMoved(true);
                    hashMap.put(valueOf, cam);
                    ViewportView.access$getStudio$p(this.this$0).pluginMouseEvent("Button1Up", ptr2.getX(), ptr2.getY());
                }
                if (ptr2 instanceof BoxSel) {
                    HashMap<Integer, Ptr> hashMap2 = this.ptrs;
                    Integer valueOf2 = Integer.valueOf(ptr2.getId());
                    Cam cam2 = new Cam(ptr2.getId(), ptr2.getX(), ptr2.getY());
                    cam2.setMoved(true);
                    hashMap2.put(valueOf2, cam2);
                }
            }
            Collection<Ptr> values2 = this.ptrs.values();
            Intrinsics.checkNotNullExpressionValue(values2, "<get-values>(...)");
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : values2) {
                if (obj2 instanceof Cam) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            if (arrayList4.size() < 2) {
                return;
            }
            Cam cam3 = (Cam) arrayList4.get(0);
            Cam cam4 = (Cam) arrayList4.get(1);
            cam3.setMoved(true);
            cam4.setMoved(true);
            float hypot = (float) Math.hypot(cam3.getX() - cam4.getX(), cam3.getY() - cam4.getY());
            float x = (cam3.getX() + cam4.getX()) / 2.0f;
            float y = (cam3.getY() + cam4.getY()) / 2.0f;
            if (this.pinchDist > 0.0f) {
                float f = hypot / this.pinchDist;
                float f2 = x - this.pinchMid[0];
                float f3 = y - this.pinchMid[1];
                Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
                ViewportView viewportView = this.this$0;
                synchronized (lock) {
                    try {
                        PlaySession play = ViewportView.access$getStudio$p(viewportView).getPlay();
                        if (play != null) {
                            try {
                                play.cameraZoom(f);
                                c = 0;
                                c2 = 1;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } else {
                            FlyCamera camera = ViewportView.access$getStudio$p(viewportView).getCamera();
                            c = 0;
                            float coerceAtMost = RangesKt.coerceAtMost(ViewportView.access$getStudio$p(viewportView).getFlySpeed(), 8.0f) * 0.08f;
                            c2 = 1;
                            camera.setPos(camera.getPos().plus(camera.getForward().times((hypot - this.pinchDist) * coerceAtMost)));
                            try {
                                camera.setPos(camera.getPos().plus(camera.getRight().times((-f2) * coerceAtMost).plus(camera.getUp().times(f3 * coerceAtMost))));
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } else {
                c = 0;
                c2 = 1;
            }
            this.pinchDist = hypot;
            float[] fArr = new float[2];
            fArr[c] = x;
            fArr[c2] = y;
            this.pinchMid = fArr;
        }

        private final void circleButton(Canvas c, String name, float x, float y, float r, String label, boolean active) {
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(active ? -871671121 : 1493172224);
            c.drawCircle(x, y, r, this.paint);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.d * 2.5f);
            this.paint.setColor(-855638017);
            c.drawCircle(x, y, r, this.paint);
            this.paint.setStyle(Paint.Style.FILL);
            if (label.length() > 0) {
                this.text.setTextSize(RangesKt.coerceAtMost(0.55f * r, this.d * 18.0f));
                c.drawText(label, x, (this.text.getTextSize() * 0.36f) + y, this.text);
            }
            this.buttons.put(name, new RectF(x - r, y - r, x + r, y + r));
        }

        private final void down(int id, float x, float y) {
            Object obj;
            boolean z;
            GuiOverlay.DragState beginDrag;
            boolean isPlaying = ViewportView.access$getStudio$p(this.this$0).isPlaying();
            Set<Map.Entry<String, RectF>> entrySet = this.buttons.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
            Iterator<T> it = entrySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((RectF) ((Map.Entry) obj).getValue()).contains(x, y)) {
                        break;
                    }
                }
            }
            Map.Entry entry = (Map.Entry) obj;
            if (entry != null) {
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "component1(...)");
                String str = (String) key;
                this.ptrs.put(Integer.valueOf(id), new Btn(this, id, x, y, str));
                pressButton(str, true);
                return;
            }
            boolean z2 = false;
            if (isPlaying) {
                GuiOverlay.Hit buttonAt = this.this$0.getGui().buttonAt(x, y);
                if (buttonAt != null) {
                    this.ptrs.put(Integer.valueOf(id), new GuiPress(this, id, x, y, buttonAt, this.this$0.getGui().scrollAt(x, y)));
                    this.this$0.getGui().press(buttonAt, x, y);
                    return;
                }
                GuiOverlay.Scroll scrollAt = this.this$0.getGui().scrollAt(x, y);
                if (scrollAt != null) {
                    this.ptrs.put(Integer.valueOf(id), new GuiScroll(this, id, x, y, scrollAt));
                    return;
                }
                AdornDrag tryStartAdorn = tryStartAdorn(id, x, y);
                if (tryStartAdorn != null) {
                    this.ptrs.put(Integer.valueOf(id), tryStartAdorn);
                    return;
                }
            } else {
                GuiOverlay.Hit buttonAt2 = this.this$0.getGui().buttonAt(x, y);
                if (buttonAt2 != null && (buttonAt2.getKind() == 4 || this.this$0.getGui().isPluginUi(buttonAt2.getInst()))) {
                    this.ptrs.put(Integer.valueOf(id), new GuiPress(this, id, x, y, buttonAt2, this.this$0.getGui().scrollAt(x, y)));
                    this.this$0.getGui().press(buttonAt2, x, y);
                    return;
                }
                GuiOverlay.Scroll scrollAt2 = this.this$0.getGui().scrollAt(x, y);
                if (scrollAt2 != null) {
                    GuiOverlay.Scroll scroll = this.this$0.getGui().isPluginUi(scrollAt2.getInst()) ? scrollAt2 : null;
                    if (scroll != null) {
                        this.ptrs.put(Integer.valueOf(id), new GuiScroll(this, id, x, y, scroll));
                        return;
                    }
                }
                if (this.this$0.getGui().pluginUiAt(x, y)) {
                    GuiOverlay.Hit pluginFrameAt = this.this$0.getGui().pluginFrameAt(x, y);
                    if (pluginFrameAt == null) {
                        this.ptrs.put(Integer.valueOf(id), new PluginWheel(id, x, y));
                        return;
                    }
                    ViewportView viewportView = this.this$0;
                    this.ptrs.put(Integer.valueOf(id), new GuiPress(this, id, x, y, pluginFrameAt, null));
                    viewportView.getGui().press(pluginFrameAt, x, y);
                    return;
                }
                Instance selectedGui = this.this$0.getGui().getSelectedGui();
                if (selectedGui != null) {
                    ViewportView viewportView2 = this.this$0;
                    Integer handleAt = viewportView2.getGui().handleAt(selectedGui, x, y);
                    if (handleAt != null && (beginDrag = viewportView2.getGui().beginDrag(selectedGui, handleAt.intValue())) != null) {
                        this.ptrs.put(Integer.valueOf(id), new GuiDrag(this, id, x, y, beginDrag));
                        return;
                    }
                }
                AdornDrag tryStartAdorn2 = tryStartAdorn(id, x, y);
                if (tryStartAdorn2 != null) {
                    this.ptrs.put(Integer.valueOf(id), tryStartAdorn2);
                    return;
                }
                if (ViewportView.access$getStudio$p(this.this$0).getActivePlugin() != null) {
                    Collection<Ptr> values = this.ptrs.values();
                    Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                    Collection<Ptr> collection = values;
                    if (!collection.isEmpty()) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = true;
                                break;
                            } else if (((Ptr) it2.next()) instanceof PluginPtr) {
                                z = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                    }
                    if (z && ViewportView.access$getStudio$p(this.this$0).pluginMouseEvent("Button1Down", x, y)) {
                        this.ptrs.put(Integer.valueOf(id), new PluginPtr(id, x, y));
                        return;
                    }
                }
                Drag tryStartDrag = tryStartDrag(id, x, y);
                if (tryStartDrag != null) {
                    this.ptrs.put(Integer.valueOf(id), tryStartDrag);
                    return;
                }
                if (ViewportView.access$getStudio$p(this.this$0).getBoxSelect() && this.ptrs.isEmpty()) {
                    this.ptrs.put(Integer.valueOf(id), new BoxSel(id, x, y, getAdditive()));
                    return;
                }
                PartDrag tryStartPartDrag = tryStartPartDrag(id, x, y);
                if (tryStartPartDrag != null) {
                    this.ptrs.put(Integer.valueOf(id), tryStartPartDrag);
                    return;
                }
            }
            if (getFixedStick()) {
                if (((float) Math.hypot(x - getDefaultJoyX(), y - getDefaultJoyY())) < getJoyR() * 1.6f) {
                    z2 = true;
                }
            } else if (x < getWidth() * 0.4f && y > getHeight() * 0.35f) {
                z2 = true;
            }
            boolean z3 = z2;
            if (!getActiveJoy() && z3 && (!isPlaying || !this.this$0.getGui().blocksAt(x, y))) {
                if (!getFixedStick()) {
                    this.joyCx = RangesKt.coerceAtLeast(x, getJoyR() * 0.6f);
                    this.joyCy = RangesKt.coerceAtMost(y, getHeight() - (getJoyR() * 0.6f));
                }
                this.ptrs.put(Integer.valueOf(id), new Joy(id, x, y));
                setJoy(x, y);
                return;
            }
            if (isPlaying && this.this$0.getGui().blocksAt(x, y)) {
                this.ptrs.put(Integer.valueOf(id), new Sink(id, x, y));
                return;
            }
            Cam cam = new Cam(id, x, y);
            this.ptrs.put(Integer.valueOf(id), cam);
            if (isPlaying) {
                cam.setPlayDown(true);
                Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
                ViewportView viewportView3 = this.this$0;
                synchronized (lock) {
                    PlaySession play = ViewportView.access$getStudio$p(viewportView3).getPlay();
                    if (play != null) {
                        play.pointerDown(x, y);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } else {
                postDelayed(new ViewportView$TouchLayer$$ExternalSyntheticLambda1(this, id, cam, this.this$0), 420L);
            }
            resetPinch();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void down$lambda$27(TouchLayer touchLayer, int i, Cam cam, ViewportView viewportView) {
            if (touchLayer.ptrs.get(Integer.valueOf(i)) != cam || cam.getMoved() || touchLayer.ptrs.size() != 1 || ViewportView.access$getStudio$p(viewportView).isPlaying()) {
                return;
            }
            HashMap<Integer, Ptr> hashMap = touchLayer.ptrs;
            Integer valueOf = Integer.valueOf(i);
            BoxSel boxSel = new BoxSel(i, cam.getX(), cam.getY(), touchLayer.getAdditive());
            boxSel.setX(cam.getX());
            boxSel.setY(cam.getY());
            hashMap.put(valueOf, boxSel);
            touchLayer.performHapticFeedback(0);
            touchLayer.invalidate();
        }

        private final void dragAdorn(AdornDrag p) {
            float x;
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView = this.this$0;
            synchronized (lock) {
                if (Intrinsics.areEqual(p.getAdorn().getClassName(), "Handles")) {
                    Float axisParam = axisParam(p.getTip().getBase(), p.getTip().getAxis(), p.getX(), p.getY());
                    if (axisParam == null || p.getAxis0() == null) {
                        float[] project = ViewportView.access$getStudio$p(viewportView).getView().project(p.getTip().getBase());
                        if (project == null) {
                            return;
                        }
                        float[] project2 = ViewportView.access$getStudio$p(viewportView).getView().project(p.getTip().getBase().plus(p.getTip().getAxis()));
                        if (project2 == null) {
                            return;
                        }
                        float f = project2[0] - project[0];
                        float f2 = project2[1] - project[1];
                        float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.hypot(f, f2), 0.5f);
                        x = (((p.getX() - p.getX0()) * f) + ((p.getY() - p.getY0()) * f2)) / (coerceAtLeast * coerceAtLeast);
                    } else {
                        x = axisParam.floatValue() - p.getAxis0().floatValue();
                    }
                    LuaRuntime rt = p.getRt();
                    Instance adorn = p.getAdorn();
                    LuaNumber valueOf = LuaValue.valueOf(x);
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                    rt.fire(adorn, "MouseDrag", p.getArg(), valueOf);
                } else {
                    if (ViewportView.access$getStudio$p(viewportView).getView().project(p.getTip().getBase()) == null) {
                        return;
                    }
                    float atan2 = ((float) Math.atan2(p.getY() - r4[1], p.getX() - r4[0])) - ((float) Math.atan2(p.getY0() - r4[1], p.getX0() - r4[0]));
                    while (atan2 > 3.141592653589793d) {
                        atan2 -= 6.2831855f;
                    }
                    while (atan2 < -3.141592653589793d) {
                        atan2 += 6.2831855f;
                    }
                    float f3 = p.getTip().getAxis().dot(ViewportView.access$getStudio$p(viewportView).getCamera().getForward()) > 0.0f ? 1.0f : -1.0f;
                    LuaRuntime rt2 = p.getRt();
                    Instance adorn2 = p.getAdorn();
                    LuaNumber valueOf2 = LuaValue.valueOf(atan2 * f3);
                    Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
                    LuaNumber valueOf3 = LuaValue.valueOf(0.0d);
                    Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(...)");
                    rt2.fire(adorn2, "MouseDrag", p.getArg(), valueOf2, valueOf3);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void drawEditControls(Canvas canvas) {
            drawThumbstick(canvas);
            float width = (getWidth() - (this.d * 30.0f)) - (this.d * 34.0f);
            arrowButton(canvas, "up", width, getHeight() - (this.d * 170.0f), this.d * 32.0f, true, ViewportView.access$getStudio$p(this.this$0).getFlyUp());
            arrowButton(canvas, "down", width, getHeight() - (this.d * 90.0f), this.d * 32.0f, false, ViewportView.access$getStudio$p(this.this$0).getFlyDown());
            circleButton(canvas, "speed", width - (this.d * 80.0f), getHeight() - (this.d * 90.0f), this.d * 26.0f, "x" + StringsKt.take(DataTypesKt.fmtNum(ViewportView.access$getStudio$p(this.this$0).getFlySpeed()), 4), false);
            boxIconButton(canvas, "boxsel", width - (this.d * 80.0f), getHeight() - (this.d * 170.0f), this.d * 24.0f, ViewportView.access$getStudio$p(this.this$0).getBoxSelect());
            multiIconButton(canvas, "multisel", width - (this.d * 80.0f), getHeight() - (this.d * 234.0f), this.d * 24.0f, ViewportView.access$getStudio$p(this.this$0).getMultiSelect() || ViewportView.access$getStudio$p(this.this$0).getModifierHeld());
            insideIconButton(canvas, "insidesel", width - (this.d * 144.0f), getHeight() - (this.d * 170.0f), this.d * 24.0f, ViewportView.access$getStudio$p(this.this$0).getSelectInsideModels());
            Collection<Ptr> values = this.ptrs.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : values) {
                if (obj instanceof BoxSel) {
                    arrayList.add(obj);
                }
            }
            BoxSel boxSel = (BoxSel) CollectionsKt.firstOrNull((List) arrayList);
            if (boxSel != null) {
                RectF rectF = new RectF(Math.min(boxSel.getX0(), boxSel.getX()), Math.min(boxSel.getY0(), boxSel.getY()), Math.max(boxSel.getX0(), boxSel.getX()), Math.max(boxSel.getY0(), boxSel.getY()));
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(773496831);
                canvas.drawRect(rectF, this.paint);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setStrokeWidth(this.d * 1.5f);
                this.paint.setColor(-15032321);
                canvas.drawRect(rectF, this.paint);
                this.paint.setStyle(Paint.Style.FILL);
            }
            Instance activePlugin = ViewportView.access$getStudio$p(this.this$0).getActivePlugin();
            if (activePlugin != null) {
                this.text.setTextSize(this.d * 12.0f);
                this.text.setFakeBoldText(false);
                String str = activePlugin.getName() + " is active  ✕";
                float measureText = this.text.measureText(str) + (this.d * 24.0f);
                RectF rectF2 = new RectF((getWidth() / 2.0f) - (measureText / 2.0f), this.d * 8.0f, (getWidth() / 2.0f) + (measureText / 2.0f), this.d * 36.0f);
                this.paint.setColor(-871671121);
                canvas.drawRoundRect(rectF2, this.d * 14.0f, this.d * 14.0f, this.paint);
                this.text.setColor(-1);
                canvas.drawText(str, rectF2.centerX(), rectF2.centerY() + (this.d * 4.5f), this.text);
                this.text.setFakeBoldText(true);
                this.buttons.put("plugin_off", rectF2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x027d, code lost:
        
            if (r8 != null) goto L42;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void drawPlayControls(android.graphics.Canvas r34, com.exampletest.mobilestudiotest.engine.PlaySession r35) {
            /*
                Method dump skipped, instructions count: 1376
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.ViewportView.TouchLayer.drawPlayControls(android.graphics.Canvas, com.exampletest.mobilestudiotest.engine.PlaySession):void");
        }

        private final void drawThumbstick(Canvas canvas) {
            boolean activeJoy = getActiveJoy();
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(activeJoy ? 1291845632 : 637534208);
            canvas.drawCircle(this.joyCx, this.joyCy, getJoyR(), this.paint);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.d * 2.0f);
            this.paint.setColor(activeJoy ? -1275068417 : 1308622847);
            canvas.drawCircle(this.joyCx, this.joyCy, getJoyR(), this.paint);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(activeJoy ? -637534209 : 1728053247);
            canvas.drawCircle(this.joyCx + (this.joyX * getJoyR()), this.joyCy + (this.joyY * getJoyR()), getJoyR() * 0.42f, this.paint);
        }

        private final void finishBox(BoxSel b) {
            boolean z;
            float[] project;
            float min = Math.min(b.getX0(), b.getX());
            float max = Math.max(b.getX0(), b.getX());
            float min2 = Math.min(b.getY0(), b.getY());
            float max2 = Math.max(b.getY0(), b.getY());
            if (max - min < this.d * 6.0f && max2 - min2 < this.d * 6.0f) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView = this.this$0;
            synchronized (lock) {
                try {
                    Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
                    for (Instance instance : ViewportView.access$getStudio$p(viewportView).renderParts()) {
                        try {
                            if (!Intrinsics.areEqual(instance.get("Locked"), (Object) true) && (project = ViewportView.access$getStudio$p(viewportView).getView().project(PartData.INSTANCE.cframe(instance).getPosition())) != null) {
                                if (project[0] >= min && project[0] <= max && project[1] >= min2) {
                                    if (project[1] <= max2) {
                                        if (project.length > 2) {
                                            try {
                                                if (project[2] > 1.0f) {
                                                    continue;
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        }
                                        Instance instance2 = instance;
                                        Instance parent = instance.getParent();
                                        Instance workspace = ViewportView.access$getStudio$p(viewportView).getModel().getWorkspace();
                                        if (!ViewportView.access$getStudio$p(viewportView).getSelectInsideModels()) {
                                            while (parent != null && parent != workspace) {
                                                ViewportView viewportView2 = viewportView;
                                                float f = min;
                                                try {
                                                    if (Intrinsics.areEqual(parent.getClassName(), "Model") || parent.isA("PartOperation")) {
                                                        instance2 = parent;
                                                    }
                                                    parent = parent.getParent();
                                                    viewportView = viewportView2;
                                                    min = f;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    throw th;
                                                }
                                            }
                                        }
                                        ViewportView viewportView3 = viewportView;
                                        float f2 = min;
                                        if (newSetFromMap.add(instance2)) {
                                            arrayList.add(instance2);
                                        }
                                        viewportView = viewportView3;
                                        min = f2;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    try {
                        Unit unit = Unit.INSTANCE;
                        if (b.getAdditive()) {
                            Studio access$getStudio$p = ViewportView.access$getStudio$p(this.this$0);
                            List list = CollectionsKt.toList(ViewportView.access$getStudio$p(this.this$0).getSelection());
                            ViewportView viewportView4 = this.this$0;
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj : arrayList) {
                                Instance instance3 = (Instance) obj;
                                float f3 = max;
                                ArrayList<Instance> selection = ViewportView.access$getStudio$p(viewportView4).getSelection();
                                float f4 = min2;
                                if ((selection instanceof Collection) && selection.isEmpty()) {
                                    z = true;
                                } else {
                                    Iterator<T> it = selection.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            z = true;
                                            break;
                                        }
                                        ArrayList<Instance> arrayList3 = selection;
                                        if (((Instance) it.next()) == instance3) {
                                            z = false;
                                            break;
                                        }
                                        selection = arrayList3;
                                    }
                                }
                                if (z) {
                                    arrayList2.add(obj);
                                }
                                max = f3;
                                min2 = f4;
                            }
                            access$getStudio$p.select(CollectionsKt.plus((Collection) list, (Iterable) arrayList2));
                        } else {
                            ViewportView.access$getStudio$p(this.this$0).select(arrayList);
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        ViewportView.access$getStudio$p(this.this$0).toast("Selected " + arrayList.size() + " object" + (arrayList.size() == 1 ? "" : "s"));
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }

        private final void finishDrag(Drag p) {
            String str;
            ViewportView viewportView;
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView2 = this.this$0;
            synchronized (lock) {
                UndoManager undo = ViewportView.access$getStudio$p(viewportView2).getUndo();
                switch (WhenMappings.$EnumSwitchMapping$0[p.getTool().ordinal()]) {
                    case 1:
                        str = "Move";
                        break;
                    case 2:
                        str = "Resize";
                        break;
                    default:
                        str = "Rotate";
                        break;
                }
                undo.begin(str);
                int i = 0;
                for (Object obj : p.getParts()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Instance instance = (Instance) obj;
                    CFrame cframe = PartData.INSTANCE.cframe(instance);
                    if (Intrinsics.areEqual(cframe, p.getStartCf().get(i))) {
                        viewportView = viewportView2;
                    } else {
                        viewportView = viewportView2;
                        ViewportView.access$getStudio$p(viewportView2).getUndo().record(new UndoManager.Op.Prop(instance, "CFrame", p.getStartCf().get(i), cframe, true));
                    }
                    String str2 = instance.getProps().containsKey("size") ? "size" : "Size";
                    Vector3 size = PartData.INSTANCE.size(instance);
                    if (!Intrinsics.areEqual(size, p.getStartSize().get(i))) {
                        ViewportView.access$getStudio$p(viewportView).getUndo().record(new UndoManager.Op.Prop(instance, str2, p.getStartSize().get(i), size, true));
                    }
                    i = i2;
                    viewportView2 = viewportView;
                }
                ViewportView viewportView3 = viewportView2;
                ViewportView.access$getStudio$p(viewportView3).getUndo().commit();
                ViewportView.access$getStudio$p(viewportView3).markDirty();
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void finishGuiDrag(GuiDrag p) {
            GuiOverlay.DragState state = p.getState();
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView = this.this$0;
            synchronized (lock) {
                ViewportView.access$getStudio$p(viewportView).getUndo().begin(state.getHandle() == -1 ? "Move GUI" : "Resize GUI");
                Object obj = state.getInst().get("Position");
                Object obj2 = state.getInst().get("Size");
                if (!Intrinsics.areEqual(obj, state.getPos())) {
                    ViewportView.access$getStudio$p(viewportView).getUndo().record(new UndoManager.Op.Prop(state.getInst(), "Position", state.getPos(), obj, true));
                }
                if (!Intrinsics.areEqual(obj2, state.getSize())) {
                    ViewportView.access$getStudio$p(viewportView).getUndo().record(new UndoManager.Op.Prop(state.getInst(), "Size", state.getSize(), obj2, true));
                }
                ViewportView.access$getStudio$p(viewportView).getUndo().commit();
                ViewportView.access$getStudio$p(viewportView).markDirty();
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void finishPartDrag(PartDrag p) {
            ViewportView viewportView;
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView2 = this.this$0;
            synchronized (lock) {
                ViewportView.access$getStudio$p(viewportView2).getUndo().begin("Drag");
                int i = 0;
                for (Object obj : p.getParts()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Instance instance = (Instance) obj;
                    CFrame cframe = PartData.INSTANCE.cframe(instance);
                    if (Intrinsics.areEqual(cframe, p.getStartCf().get(i))) {
                        viewportView = viewportView2;
                    } else {
                        viewportView = viewportView2;
                        ViewportView.access$getStudio$p(viewportView2).getUndo().record(new UndoManager.Op.Prop(instance, "CFrame", p.getStartCf().get(i), cframe, true));
                    }
                    i = i2;
                    viewportView2 = viewportView;
                }
                ViewportView viewportView3 = viewportView2;
                ViewportView.access$getStudio$p(viewportView3).getUndo().commit();
                ViewportView.access$getStudio$p(viewportView3).markDirty();
                Unit unit = Unit.INSTANCE;
            }
        }

        private final boolean getActiveJoy() {
            Collection<Ptr> values = this.ptrs.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Collection<Ptr> collection = values;
            if (collection.isEmpty()) {
                return false;
            }
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (((Ptr) it.next()) instanceof Joy) {
                    return true;
                }
            }
            return false;
        }

        private final boolean getAdditive() {
            return ViewportView.access$getStudio$p(this.this$0).getMultiSelect() || ViewportView.access$getStudio$p(this.this$0).getModifierHeld();
        }

        private final float getDefaultJoyX() {
            return (this.d * 40.0f) + getJoyR();
        }

        private final float getDefaultJoyY() {
            return (getHeight() - (this.d * 40.0f)) - getJoyR();
        }

        private final boolean getFixedStick() {
            return ViewportView.access$getStudio$p(this.this$0).isPlaying() && Intrinsics.areEqual(Settings.INSTANCE.getMovementMode(), "Thumbstick");
        }

        private final float getJoyR() {
            return this.d * 56.0f;
        }

        private final void insideIconButton(Canvas c, String name, float x, float y, float r, boolean active) {
            circleButton(c, name, x, y, r, "", active);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.d * 1.6f);
            this.paint.setColor(-1);
            this.paint.setPathEffect(new DashPathEffect(new float[]{this.d * 3.0f, this.d * 2.5f}, 0.0f));
            c.drawRect(x - (r * 0.5f), y - (r * 0.42f), (0.5f * r) + x, (0.42f * r) + y, this.paint);
            this.paint.setPathEffect(null);
            this.paint.setStyle(Paint.Style.FILL);
            c.drawRect(x - (r * 0.08f), y - (r * 0.2f), x + (r * 0.3f), (r * 0.2f) + y, this.paint);
            Paint paint = this.paint;
            paint.setAlpha(120);
            Unit unit = Unit.INSTANCE;
            c.drawRect(x - (r * 0.34f), y - (r * 0.05f), x - (r * 0.16f), (r * 0.2f) + y, paint);
            this.paint.setAlpha(255);
        }

        private final void move(Ptr p, float nx, float ny) {
            if (p instanceof Joy) {
                p.setX(nx);
                p.setY(ny);
                setJoy(nx, ny);
                return;
            }
            if (p instanceof Drag) {
                p.setX(nx);
                p.setY(ny);
                updateDrag((Drag) p);
                return;
            }
            if (p instanceof PartDrag) {
                p.setX(nx);
                p.setY(ny);
                if (!((PartDrag) p).getActive() && ((float) Math.hypot(nx - p.getX0(), ny - p.getY0())) > this.d * 8.0f) {
                    ((PartDrag) p).setActive(true);
                }
                if (((PartDrag) p).getActive()) {
                    updatePartDrag((PartDrag) p);
                    return;
                }
                return;
            }
            if (p instanceof BoxSel) {
                p.setX(nx);
                p.setY(ny);
                return;
            }
            if (p instanceof AdornDrag) {
                p.setX(nx);
                p.setY(ny);
                dragAdorn((AdornDrag) p);
                return;
            }
            if (p instanceof PluginPtr) {
                if (((float) Math.hypot(nx - p.getX0(), ny - p.getY0())) > this.d * 6.0f) {
                    ((PluginPtr) p).setMoved(true);
                }
                p.setX(nx);
                p.setY(ny);
                if (this.ptrs.size() == 1) {
                    ViewportView.access$getStudio$p(this.this$0).pluginMouseEvent("Move", nx, ny);
                    return;
                }
                return;
            }
            if (p instanceof GuiDrag) {
                p.setX(nx);
                p.setY(ny);
                if (!((GuiDrag) p).getActive() && ((float) Math.hypot(nx - p.getX0(), ny - p.getY0())) > this.d * 6.0f) {
                    ((GuiDrag) p).setActive(true);
                }
                if (((GuiDrag) p).getActive()) {
                    this.this$0.getGui().dragTo(((GuiDrag) p).getState(), nx - p.getX0(), ny - p.getY0());
                    return;
                }
                return;
            }
            if (p instanceof GuiScroll) {
                this.this$0.getGui().scrollBy(((GuiScroll) p).getScroll(), nx - p.getX(), ny - p.getY());
                p.setX(nx);
                p.setY(ny);
                return;
            }
            if (p instanceof PluginWheel) {
                PluginWheel pluginWheel = (PluginWheel) p;
                pluginWheel.setAcc(pluginWheel.getAcc() + (ny - p.getY()));
                p.setX(nx);
                p.setY(ny);
                float guiUnit = ViewportView.access$getStudio$p(this.this$0).guiUnit() * 18.0f;
                while (Math.abs(((PluginWheel) p).getAcc()) >= guiUnit) {
                    int i = ((PluginWheel) p).getAcc() > 0.0f ? 1 : -1;
                    PluginWheel pluginWheel2 = (PluginWheel) p;
                    pluginWheel2.setAcc(pluginWheel2.getAcc() - (i * guiUnit));
                    this.this$0.getGui().pluginWheel(p.getX0(), p.getY0(), i);
                }
                return;
            }
            int i2 = 0;
            if (p instanceof GuiPress) {
                if (!((GuiPress) p).getCancelled() && ((float) Math.hypot(nx - p.getX0(), ny - p.getY0())) > this.d * 12.0f) {
                    GuiOverlay.Scroll scroll = ((GuiPress) p).getScroll();
                    if (scroll != null) {
                        ((GuiPress) p).setCancelled(true);
                        this.this$0.getGui().release(((GuiPress) p).getHit(), nx, ny, false);
                        GuiScroll guiScroll = new GuiScroll(this, p.getId(), p.getX(), p.getY(), scroll);
                        this.ptrs.put(Integer.valueOf(p.getId()), guiScroll);
                        this.this$0.getGui().scrollBy(scroll, nx - p.getX(), ny - p.getY());
                        guiScroll.setX(nx);
                        guiScroll.setY(ny);
                        return;
                    }
                    if (!ViewportView.access$getStudio$p(this.this$0).isPlaying() && Math.abs(ny - p.getY0()) > Math.abs(nx - p.getX0()) && this.this$0.getGui().canWheel(((GuiPress) p).getHit(), p.getX0(), p.getY0())) {
                        ((GuiPress) p).setCancelled(true);
                        this.this$0.getGui().release(((GuiPress) p).getHit(), nx, ny, false);
                        HashMap<Integer, Ptr> hashMap = this.ptrs;
                        Integer valueOf = Integer.valueOf(p.getId());
                        PluginWheel pluginWheel3 = new PluginWheel(p.getId(), p.getX0(), p.getY0());
                        pluginWheel3.setX(nx);
                        pluginWheel3.setY(ny);
                        pluginWheel3.setAcc(ny - p.getY0());
                        hashMap.put(valueOf, pluginWheel3);
                        return;
                    }
                }
                p.setX(nx);
                p.setY(ny);
                if (((GuiPress) p).getCancelled() || ViewportView.access$getStudio$p(this.this$0).isPlaying()) {
                    return;
                }
                this.this$0.getGui().pluginPointerMove(((GuiPress) p).getHit(), nx, ny);
                return;
            }
            if (!(p instanceof Cam)) {
                p.setX(nx);
                p.setY(ny);
                return;
            }
            float x = nx - p.getX();
            float y = ny - p.getY();
            if (((float) Math.hypot(nx - p.getX0(), ny - p.getY0())) > this.d * 10.0f) {
                ((Cam) p).setMoved(true);
            }
            p.setX(nx);
            p.setY(ny);
            Collection<Ptr> values = this.ptrs.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Collection<Ptr> collection = values;
            if (!collection.isEmpty()) {
                i2 = 0;
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if ((((Ptr) it.next()) instanceof Cam) && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i2 == 1 && ((Cam) p).getMoved()) {
                Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
                ViewportView viewportView = this.this$0;
                synchronized (lock) {
                    PlaySession play = ViewportView.access$getStudio$p(viewportView).getPlay();
                    if (play != null) {
                        play.cameraDrag(x, y);
                        play.pointerMove(nx, ny);
                    } else {
                        ViewportView.access$getStudio$p(viewportView).rotateEditCamera((-x) * 0.005f, (-y) * 0.005f);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        private final void multiIconButton(Canvas c, String name, float x, float y, float r, boolean active) {
            circleButton(c, name, x, y, r, "", active);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.d * 2.0f);
            this.paint.setColor(-1);
            float f = r * 0.32f;
            c.drawRect(x - (f * 1.4f), y - (f * 1.4f), (f * 0.4f) + x, (f * 0.4f) + y, this.paint);
            this.paint.setStyle(Paint.Style.FILL);
            c.drawRect(x - (f * 0.4f), y - (0.4f * f), (f * 1.4f) + x, y + (1.4f * f), this.paint);
        }

        private final boolean overlapsOthers(List<? extends Instance> parts) {
            Pair<Vector3, Float> contact;
            Vector3 first;
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            Iterator<T> it = parts.iterator();
            while (it.hasNext()) {
                newSetFromMap.add((Instance) it.next());
            }
            List<Instance> renderParts = ViewportView.access$getStudio$p(this.this$0).renderParts();
            for (Instance instance : parts) {
                Pair<Vector3, Vector3> partAabb = Geometry.INSTANCE.partAabb(instance);
                Vector3 component1 = partAabb.component1();
                Vector3 component2 = partAabb.component2();
                ConvexShape shapeOf$default = Geometry.shapeOf$default(Geometry.INSTANCE, instance, null, 2, null);
                for (Instance instance2 : renderParts) {
                    if (!newSetFromMap.contains(instance2) && !Intrinsics.areEqual(instance2.get("CanCollide"), (Object) false)) {
                        Pair<Vector3, Vector3> partAabb2 = Geometry.INSTANCE.partAabb(instance2);
                        if (Geometry.INSTANCE.aabbOverlap(component1, component2, partAabb2.component1(), partAabb2.component2(), -0.03f) && (contact = Geometry.INSTANCE.contact(shapeOf$default, component1, component2, instance2)) != null && (first = contact.getFirst()) != null && first.getMagnitude() > 0.03f) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private final void pressButton(String name, boolean down) {
            List<Instance> backpackTools;
            Instance instance;
            PlaySession play = ViewportView.access$getStudio$p(this.this$0).getPlay();
            if (Intrinsics.areEqual(name, "up")) {
                ViewportView.access$getStudio$p(this.this$0).setFlyUp(down);
                return;
            }
            if (Intrinsics.areEqual(name, "down")) {
                ViewportView.access$getStudio$p(this.this$0).setFlyDown(down);
                return;
            }
            if (Intrinsics.areEqual(name, "speed") && down) {
                post(new ViewportView$TouchLayer$$ExternalSyntheticLambda2(this));
                return;
            }
            if (Intrinsics.areEqual(name, "boxsel") && down) {
                post(new ViewportView$TouchLayer$$ExternalSyntheticLambda3(this.this$0));
                return;
            }
            if (Intrinsics.areEqual(name, "multisel") && down) {
                post(new ViewportView$TouchLayer$$ExternalSyntheticLambda4(this.this$0));
                return;
            }
            if (Intrinsics.areEqual(name, "insidesel") && down) {
                post(new ViewportView$TouchLayer$$ExternalSyntheticLambda5(this.this$0));
                return;
            }
            if (Intrinsics.areEqual(name, "plugin_off") && down) {
                Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
                ViewportView viewportView = this.this$0;
                synchronized (lock) {
                    ViewportView.access$getStudio$p(viewportView).deactivatePlugin(null);
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            if (Intrinsics.areEqual(name, "jump")) {
                this.jumpDown = down;
                synchronized (ViewportView.access$getStudio$p(this.this$0).getLock()) {
                    if (play != null) {
                        play.setJumpHeld(down);
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                return;
            }
            if (Intrinsics.areEqual(name, "shiftlock") && down) {
                synchronized (ViewportView.access$getStudio$p(this.this$0).getLock()) {
                    if (play != null) {
                        play.toggleShiftLock();
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
                return;
            }
            if (Intrinsics.areEqual(name, "prompt") && down) {
                synchronized (ViewportView.access$getStudio$p(this.this$0).getLock()) {
                    if (play != null) {
                        play.triggerPrompt();
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
                return;
            }
            if (StringsKt.startsWith$default(name, "action:", false, 2, (Object) null)) {
                synchronized (ViewportView.access$getStudio$p(this.this$0).getLock()) {
                    if (play != null) {
                        play.pressAction(StringsKt.removePrefix(name, (CharSequence) "action:"), down);
                        Unit unit5 = Unit.INSTANCE;
                    }
                }
                return;
            }
            if (StringsKt.startsWith$default(name, "tool:", false, 2, (Object) null) && down) {
                synchronized (ViewportView.access$getStudio$p(this.this$0).getLock()) {
                    int parseInt = Integer.parseInt(StringsKt.removePrefix(name, (CharSequence) "tool:"));
                    if (play != null && (backpackTools = play.backpackTools()) != null && (instance = (Instance) CollectionsKt.getOrNull(backpackTools, parseInt)) != null) {
                        play.toggleTool(instance);
                        Unit unit6 = Unit.INSTANCE;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void pressButton$lambda$36(TouchLayer touchLayer) {
            SettingsDialog settingsDialog = SettingsDialog.INSTANCE;
            Context context = touchLayer.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            settingsDialog.pickFlySpeed(context, new ViewportView$TouchLayer$$ExternalSyntheticLambda6(touchLayer));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit pressButton$lambda$36$lambda$35(TouchLayer touchLayer) {
            touchLayer.invalidate();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void pressButton$lambda$37(ViewportView viewportView) {
            ViewportView.access$getStudio$p(viewportView).setBoxSelect(!ViewportView.access$getStudio$p(viewportView).getBoxSelect());
            ViewportView.access$getStudio$p(viewportView).toast(ViewportView.access$getStudio$p(viewportView).getBoxSelect() ? "Box select: drag to select (long-press works any time)" : "Box select off");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void pressButton$lambda$38(ViewportView viewportView) {
            ViewportView.access$getStudio$p(viewportView).setMultiSelect(!ViewportView.access$getStudio$p(viewportView).getMultiSelect());
            ViewportView.access$getStudio$p(viewportView).toast(ViewportView.access$getStudio$p(viewportView).getMultiSelect() ? "Multi-select: taps add or remove" : "Multi-select off");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void pressButton$lambda$39(ViewportView viewportView) {
            ViewportView.access$getStudio$p(viewportView).setSelectInsideModels(!ViewportView.access$getStudio$p(viewportView).getSelectInsideModels());
            ViewportView.access$getStudio$p(viewportView).toast(ViewportView.access$getStudio$p(viewportView).getSelectInsideModels() ? "Select inside models: taps pick single parts in groups" : "Taps select whole models again");
        }

        private final void resetPinch() {
            this.pinchDist = 0.0f;
        }

        private final LuaRuntime runtimeFor(Instance a) {
            DataModel root = a.root();
            if (root == null) {
                return null;
            }
            PlaySession play = ViewportView.access$getStudio$p(this.this$0).getPlay();
            if (play != null && root == play.getDm()) {
                return play.getRt();
            }
            if (root == ViewportView.access$getStudio$p(this.this$0).getEditModel()) {
                return ViewportView.access$getStudio$p(this.this$0).getEditRuntime();
            }
            return null;
        }

        private final Instance selectTarget(Instance part) {
            if (ViewportView.access$getStudio$p(this.this$0).getSelectInsideModels()) {
                return part;
            }
            Instance instance = null;
            Instance workspace = ViewportView.access$getStudio$p(this.this$0).getModel().getWorkspace();
            for (Instance parent = part.getParent(); parent != null && parent != workspace; parent = parent.getParent()) {
                if (Intrinsics.areEqual(parent.getClassName(), "Model") || parent.isA("PartOperation")) {
                    instance = parent;
                }
            }
            if (instance != null) {
                ArrayList<Instance> selection = ViewportView.access$getStudio$p(this.this$0).getSelection();
                boolean z = true;
                if (!(selection instanceof Collection) || !selection.isEmpty()) {
                    Iterator<T> it = selection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((Instance) it.next()) == instance) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    return instance;
                }
            }
            return part;
        }

        private final void setJoy(float x, float y) {
            float joyR = (x - this.joyCx) / getJoyR();
            float joyR2 = (y - this.joyCy) / getJoyR();
            float hypot = (float) Math.hypot(joyR, joyR2);
            if (hypot > 1.0f) {
                if (!getFixedStick()) {
                    float joyR3 = (hypot - 1.0f) * getJoyR();
                    this.joyCx += (joyR / hypot) * joyR3;
                    this.joyCy += (joyR2 / hypot) * joyR3;
                }
                joyR /= hypot;
                joyR2 /= hypot;
            }
            this.joyX = joyR;
            this.joyY = joyR2;
            ViewportView.access$getStudio$p(this.this$0).setMoveX(joyR);
            ViewportView.access$getStudio$p(this.this$0).setMoveY(joyR2);
        }

        private final float snap(float v, float step) {
            return (!ViewportView.access$getStudio$p(this.this$0).getSnapEnabled() || step <= 0.0f) ? v : MathKt.roundToInt(v / step) * step;
        }

        private final void tap(float x, float y) {
            Instance selectTarget;
            Instance part;
            if (this.this$0.getGui().tap(x, y)) {
                return;
            }
            PlaySession play = ViewportView.access$getStudio$p(this.this$0).getPlay();
            if (play != null) {
                synchronized (ViewportView.access$getStudio$p(this.this$0).getLock()) {
                    play.tap(x, y);
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            if (ViewportView.access$getStudio$p(this.this$0).getActivePlugin() == null || !ViewportView.access$getStudio$p(this.this$0).getPluginMice().containsKey(ViewportView.access$getStudio$p(this.this$0).getActivePlugin())) {
                Instance pick = this.this$0.getGui().pick(x, y);
                if (pick != null) {
                    ViewportView viewportView = this.this$0;
                    boolean additive = getAdditive();
                    Studio access$getStudio$p = ViewportView.access$getStudio$p(viewportView);
                    if (additive) {
                        access$getStudio$p.toggleSelect(pick);
                        return;
                    } else {
                        access$getStudio$p.select(CollectionsKt.listOf(pick));
                        return;
                    }
                }
                Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
                ViewportView viewportView2 = this.this$0;
                synchronized (lock) {
                    Pair<Vector3, Vector3> screenRay = ViewportView.access$getStudio$p(viewportView2).getView().screenRay(x, y);
                    RayHit raycast = Geometry.INSTANCE.raycast(ViewportView.access$getStudio$p(viewportView2).renderParts(), screenRay.component1(), screenRay.component2(), 5000.0f, new ViewportView$TouchLayer$$ExternalSyntheticLambda8());
                    selectTarget = (raycast == null || (part = raycast.getPart()) == null) ? null : selectTarget(part);
                }
                if (selectTarget == null) {
                    if (getAdditive()) {
                        return;
                    }
                    ViewportView.access$getStudio$p(this.this$0).select(CollectionsKt.emptyList());
                } else if (getAdditive()) {
                    ViewportView.access$getStudio$p(this.this$0).toggleSelect(selectTarget);
                } else {
                    ViewportView.access$getStudio$p(this.this$0).select(CollectionsKt.listOf(selectTarget));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean tap$lambda$56$lambda$54(Instance it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return !Intrinsics.areEqual(it.get("Locked"), (Object) true);
        }

        private final AdornDrag tryStartAdorn(int id, float x, float y) {
            Iterator<Instance> it;
            Iterator<Instance> it2;
            char c;
            Iterator<AdornHandles.Tip> it3;
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView = this.this$0;
            synchronized (lock) {
                float f = this.d * 34.0f;
                Iterator<Instance> it4 = ViewportView.access$getStudio$p(viewportView).renderAdornments().iterator();
                Pair pair = null;
                float f2 = f;
                while (true) {
                    char c2 = 1;
                    char c3 = 0;
                    if (!it4.hasNext()) {
                        break;
                    }
                    Instance next = it4.next();
                    if (!AdornHandles.INSTANCE.isHandles(next)) {
                        it = it4;
                    } else if (next.getParent() == null) {
                        it = it4;
                    } else {
                        Iterator<AdornHandles.Tip> it5 = AdornHandles.INSTANCE.tips(next, ViewportView.access$getStudio$p(viewportView).getView()).iterator();
                        while (it5.hasNext()) {
                            AdornHandles.Tip next2 = it5.next();
                            if (ViewportView.access$getStudio$p(viewportView).getView().project(next2.getTip()) == null) {
                                it2 = it4;
                                c = c3;
                                it3 = it5;
                            } else {
                                c = c3;
                                it3 = it5;
                                it2 = it4;
                                float hypot = (float) Math.hypot(r14[c3] - x, r14[c2] - y);
                                if (hypot < f2) {
                                    f2 = hypot;
                                    pair = TuplesKt.to(next, next2);
                                    c3 = c;
                                    it5 = it3;
                                    it4 = it2;
                                    c2 = 1;
                                }
                            }
                            c3 = c;
                            it5 = it3;
                            it4 = it2;
                            c2 = 1;
                        }
                    }
                    it4 = it;
                }
                if (pair == null) {
                    return null;
                }
                Instance instance = (Instance) pair.component1();
                AdornHandles.Tip tip = (AdornHandles.Tip) pair.component2();
                LuaRuntime runtimeFor = runtimeFor(instance);
                if (runtimeFor == null) {
                    return null;
                }
                LuaTypes luaTypes = LuaTypes.INSTANCE;
                LuaValue wrap = Intrinsics.areEqual(instance.getClassName(), "Handles") ? luaTypes.wrap(new EnumItemV("NormalId", AdornHandles.INSTANCE.getNORMAL_NAMES().get(tip.getId()), tip.getId())) : luaTypes.wrap(new EnumItemV("Axis", AdornHandles.INSTANCE.getAXIS_NAMES().get(tip.getId()), tip.getId()));
                runtimeFor.fire(instance, "MouseButton1Down", wrap);
                Float f3 = null;
                if (Intrinsics.areEqual(instance.getClassName(), "Handles")) {
                    f3 = axisParam(tip.getBase(), tip.getAxis(), x, y);
                }
                return new AdornDrag(this, id, x, y, instance, tip, f3, runtimeFor, wrap);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Drag tryStartDrag(int id, float x, float y) {
            boolean z;
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView = this.this$0;
            synchronized (lock) {
                HandleSet compute = Handles.INSTANCE.compute(ViewportView.access$getStudio$p(viewportView));
                if (compute == null) {
                    return null;
                }
                float f = this.d * 40.0f;
                Iterator<Handle> it = compute.getHandles().iterator();
                Handle handle = null;
                float f2 = f;
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Handle next = it.next();
                    if (ViewportView.access$getStudio$p(viewportView).getView().project(next.getTip()) != null) {
                        float hypot = (float) Math.hypot(r9[0] - x, r9[1] - y);
                        if (hypot < f2) {
                            f2 = hypot;
                            handle = next;
                        }
                    }
                }
                if (handle == null) {
                    return null;
                }
                Handle handle2 = handle;
                List<Instance> selectedParts = ViewportView.access$getStudio$p(viewportView).selectedParts();
                if (compute.getTool() == Tool.SCALE && selectedParts.size() != 1) {
                    return null;
                }
                float[] project = ViewportView.access$getStudio$p(viewportView).getView().project(compute.getCenter());
                if (project == null) {
                    return null;
                }
                float[] project2 = ViewportView.access$getStudio$p(viewportView).getView().project(compute.getCenter().plus(handle2.getAxis()));
                if (project2 == null) {
                    return null;
                }
                float f3 = project2[0] - project[0];
                float f4 = project2[1] - project[1];
                float hypot2 = (float) Math.hypot(f3, f4);
                if (hypot2 < 0.5f) {
                    f3 = 0.0f;
                    f4 = -1.0f;
                    hypot2 = 1.0f;
                }
                float f5 = f3;
                float f6 = f4;
                Float axisParam = compute.getTool() != Tool.ROTATE ? axisParam(compute.getCenter(), handle2.getAxis(), x, y) : null;
                Object[] objArr = false;
                Tool tool = compute.getTool();
                List<Instance> list = selectedParts;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(PartData.INSTANCE.cframe((Instance) it2.next()));
                    objArr = objArr;
                    z = z;
                }
                Object[] objArr2 = objArr;
                boolean z2 = z;
                ArrayList arrayList2 = arrayList;
                List<Instance> list2 = selectedParts;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(PartData.INSTANCE.size((Instance) it3.next()));
                    list2 = list2;
                }
                float[] fArr = new float[2];
                fArr[objArr2 == true ? 1 : 0] = f5 / hypot2;
                fArr[z2 ? 1 : 0] = f6 / hypot2;
                return new Drag(this, id, x, y, handle2, tool, selectedParts, arrayList2, arrayList3, hypot2, fArr, compute.getCenter(), handle2.getIndex() % 3, axisParam);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0106 A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0108 A[Catch: all -> 0x01e4, TRY_ENTER, TryCatch #0 {, blocks: (B:11:0x002e, B:16:0x0067, B:18:0x0078, B:22:0x00bc, B:24:0x00c4, B:33:0x0108, B:34:0x0120, B:36:0x0126, B:38:0x0148, B:43:0x0150, B:47:0x015f, B:51:0x0169, B:52:0x018c, B:54:0x0192, B:56:0x01b2, B:60:0x00cf, B:61:0x00d3, B:63:0x00d9, B:65:0x00e8, B:78:0x0087, B:79:0x008b, B:81:0x0091), top: B:10:0x002e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final com.exampletest.mobilestudiotest.ui.ViewportView.TouchLayer.PartDrag tryStartPartDrag(int r24, float r25, float r26) {
            /*
                Method dump skipped, instructions count: 487
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.ViewportView.TouchLayer.tryStartPartDrag(int, float, float):com.exampletest.mobilestudiotest.ui.ViewportView$TouchLayer$PartDrag");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean tryStartPartDrag$lambda$80$lambda$75(Instance it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return !Intrinsics.areEqual(it.get("Locked"), (Object) true);
        }

        private final void up(int id, float x, float y, boolean cancel) {
            Ptr remove = this.ptrs.remove(Integer.valueOf(id));
            if (remove == null) {
                return;
            }
            if (remove instanceof Joy) {
                this.joyX = 0.0f;
                this.joyY = 0.0f;
                ViewportView.access$getStudio$p(this.this$0).setMoveX(0.0f);
                ViewportView.access$getStudio$p(this.this$0).setMoveY(0.0f);
                return;
            }
            boolean z = false;
            if (remove instanceof Btn) {
                pressButton(((Btn) remove).getName(), false);
                return;
            }
            if (remove instanceof Drag) {
                finishDrag((Drag) remove);
                return;
            }
            if (remove instanceof PartDrag) {
                if (((PartDrag) remove).getActive()) {
                    finishPartDrag((PartDrag) remove);
                    return;
                } else {
                    if (cancel) {
                        return;
                    }
                    tap(x, y);
                    return;
                }
            }
            if (remove instanceof BoxSel) {
                if (cancel) {
                    return;
                }
                finishBox((BoxSel) remove);
                return;
            }
            if (remove instanceof AdornDrag) {
                synchronized (ViewportView.access$getStudio$p(this.this$0).getLock()) {
                    ((AdornDrag) remove).getRt().fire(((AdornDrag) remove).getAdorn(), "MouseButton1Up", ((AdornDrag) remove).getArg());
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            if (remove instanceof PluginPtr) {
                ViewportView.access$getStudio$p(this.this$0).pluginMouseEvent("Button1Up", cancel ? remove.getX() : x, cancel ? remove.getY() : y);
                return;
            }
            if (remove instanceof GuiDrag) {
                this.this$0.getGui().endDrag();
                if (((GuiDrag) remove).getActive()) {
                    finishGuiDrag((GuiDrag) remove);
                    return;
                } else {
                    if (cancel) {
                        return;
                    }
                    tap(x, y);
                    return;
                }
            }
            if (remove instanceof GuiPress) {
                if (((GuiPress) remove).getCancelled()) {
                    return;
                }
                GuiOverlay gui = this.this$0.getGui();
                GuiOverlay.Hit hit = ((GuiPress) remove).getHit();
                if (!cancel && ((GuiPress) remove).getHit().getRect().contains(x, y)) {
                    z = true;
                }
                gui.release(hit, x, y, z);
                return;
            }
            if (remove instanceof Cam) {
                if (((Cam) remove).getPlayDown()) {
                    Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
                    ViewportView viewportView = this.this$0;
                    synchronized (lock) {
                        PlaySession play = ViewportView.access$getStudio$p(viewportView).getPlay();
                        if (play != null) {
                            play.pointerUp(cancel ? remove.getX() : x, cancel ? remove.getY() : y);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }
                if (!cancel && !((Cam) remove).getMoved() && System.currentTimeMillis() - remove.getT0() < 400) {
                    Collection<Ptr> values = this.ptrs.values();
                    Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                    Collection<Ptr> collection = values;
                    if (!collection.isEmpty()) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = true;
                                break;
                            } else if (((Ptr) it.next()) instanceof Cam) {
                                break;
                            }
                        }
                    } else {
                        z = true;
                    }
                    if (z) {
                        tap(x, y);
                    }
                }
                resetPinch();
            }
        }

        private final void updateDrag(Drag p) {
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView = this.this$0;
            synchronized (lock) {
                boolean z = false;
                Float axisParam = p.getT0Axis() != null ? axisParam(p.getCenter(), p.getHandle().getAxis(), p.getX(), p.getY()) : null;
                float x = (axisParam == null || p.getT0Axis() == null) ? (((p.getX() - p.getX0()) * p.getScreenDir()[0]) + ((p.getY() - p.getY0()) * p.getScreenDir()[1])) / p.getPxPerStud() : RangesKt.coerceIn(axisParam.floatValue() - p.getT0Axis().floatValue(), -2000.0f, 2000.0f);
                float f = 2.0f;
                float f2 = 0.0f;
                switch (WhenMappings.$EnumSwitchMapping$0[p.getTool().ordinal()]) {
                    case 1:
                        float snap = snap(x, ViewportView.access$getStudio$p(viewportView).getMoveSnap());
                        int i = 0;
                        for (Object obj : p.getParts()) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Instance.set$default((Instance) obj, "CFrame", p.getStartCf().get(i).plus(p.getHandle().getAxis().times(snap)), false, 4, null);
                            i = i2;
                        }
                        if (ViewportView.access$getStudio$p(viewportView).getCollisionsEnabled()) {
                            if (!(snap == 0.0f) && !p.getStartedOverlapping() && overlapsOthers(p.getParts())) {
                                float f3 = 0.0f;
                                float f4 = 1.0f;
                                int i3 = 0;
                                while (i3 < 10) {
                                    float f5 = (f3 + f4) / f;
                                    int i4 = 0;
                                    for (Object obj2 : p.getParts()) {
                                        int i5 = i4 + 1;
                                        if (i4 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        Instance.set$default((Instance) obj2, "CFrame", p.getStartCf().get(i4).plus(p.getHandle().getAxis().times(snap * f5)), false, 4, null);
                                        i4 = i5;
                                        f2 = f2;
                                        viewportView = viewportView;
                                        f3 = f3;
                                    }
                                    ViewportView viewportView2 = viewportView;
                                    float f6 = f3;
                                    float f7 = f2;
                                    if (overlapsOthers(p.getParts())) {
                                        f4 = f5;
                                        f3 = f6;
                                    } else {
                                        f3 = f5;
                                    }
                                    i3++;
                                    f2 = f7;
                                    viewportView = viewportView2;
                                    f = 2.0f;
                                }
                                ViewportView viewportView3 = viewportView;
                                float f8 = f2;
                                float f9 = snap * f3;
                                if (ViewportView.access$getStudio$p(viewportView3).getSnapEnabled() && ViewportView.access$getStudio$p(viewportView3).getMoveSnap() > f8) {
                                    f9 = MathKt.truncate(f9 / ViewportView.access$getStudio$p(viewportView3).getMoveSnap()) * ViewportView.access$getStudio$p(viewportView3).getMoveSnap();
                                }
                                List<Instance> parts = p.getParts();
                                int i6 = 0;
                                for (Object obj3 : parts) {
                                    int i7 = i6 + 1;
                                    if (i6 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    Instance.set$default((Instance) obj3, "CFrame", p.getStartCf().get(i6).plus(p.getHandle().getAxis().times(f9)), false, 4, null);
                                    i6 = i7;
                                    parts = parts;
                                }
                                break;
                            }
                        }
                        break;
                    case 2:
                        Instance instance = p.getParts().get(0);
                        float snap2 = snap(x, ViewportView.access$getStudio$p(viewportView).getMoveSnap());
                        Vector3 vector3 = p.getStartSize().get(0);
                        float x2 = vector3.getX();
                        float y = vector3.getY();
                        float z2 = vector3.getZ();
                        float[] fArr = new float[3];
                        fArr[0] = x2;
                        fArr[1] = y;
                        fArr[2] = z2;
                        float f10 = fArr[p.getLocalAxis()];
                        fArr[p.getLocalAxis()] = RangesKt.coerceAtLeast(f10 + snap2, 0.05f);
                        float f11 = fArr[p.getLocalAxis()] - f10;
                        PartData.INSTANCE.setSize(instance, new Vector3(fArr[0], fArr[1], fArr[2]));
                        Instance.set$default(instance, "CFrame", p.getStartCf().get(0).plus(p.getHandle().getAxis().times(f11 / 2.0f)), false, 4, null);
                        break;
                    case 3:
                        float x3 = ((((p.getX() - p.getX0()) * p.getScreenDir()[0]) + ((p.getY() - p.getY0()) * p.getScreenDir()[1])) / p.getPxPerStud()) * 12.0f;
                        CFrame times = CFrame.INSTANCE.at(p.getCenter()).times(CFrame.INSTANCE.fromAxisAngle(p.getHandle().getAxis(), (float) Math.toRadians((!ViewportView.access$getStudio$p(viewportView).getRotSnapEnabled() || ViewportView.access$getStudio$p(viewportView).getRotSnap() <= 0.0f) ? x3 : MathKt.roundToInt(x3 / ViewportView.access$getStudio$p(viewportView).getRotSnap()) * ViewportView.access$getStudio$p(viewportView).getRotSnap()))).times(CFrame.INSTANCE.at(p.getCenter().unaryMinus()));
                        int i8 = 0;
                        for (Object obj4 : p.getParts()) {
                            int i9 = i8 + 1;
                            if (i8 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Instance.set$default((Instance) obj4, "CFrame", times.times(p.getStartCf().get(i8)).orthonormalize(), false, 4, null);
                            i8 = i9;
                            z = z;
                        }
                        break;
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void updatePartDrag(PartDrag p) {
            Vector3 vector3;
            Vector3 vector32;
            float updatePartDrag$lambda$85$sn;
            Object lock = ViewportView.access$getStudio$p(this.this$0).getLock();
            ViewportView viewportView = this.this$0;
            synchronized (lock) {
                Pair<Vector3, Vector3> screenRay = ViewportView.access$getStudio$p(viewportView).getView().screenRay(p.getX(), p.getY());
                Vector3 component1 = screenRay.component1();
                Vector3 component2 = screenRay.component2();
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
                Iterator<T> it = p.getParts().iterator();
                while (it.hasNext()) {
                    newSetFromMap.add((Instance) it.next());
                }
                RayHit raycast = Geometry.INSTANCE.raycast(ViewportView.access$getStudio$p(viewportView).renderParts(), component1, component2, 5000.0f, new ViewportView$TouchLayer$$ExternalSyntheticLambda7(newSetFromMap));
                Vector3 minus = p.getCenter().minus(p.getGrab());
                if (raycast != null) {
                    Vector3 normal = raycast.getNormal();
                    Vector3 abs = normal.abs();
                    int i = (abs.getY() < abs.getX() || abs.getY() < abs.getZ()) ? abs.getX() >= abs.getZ() ? 0 : 2 : 1;
                    float f = normal.get(i) >= 0.0f ? 1.0f : -1.0f;
                    Vector3 plus = raycast.getPosition().plus(new Vector3(i == 0 ? 0.0f : minus.getX(), i == 1 ? 0.0f : minus.getY(), i == 2 ? 0.0f : minus.getZ())).plus(new Vector3(i == 0 ? p.getHalf().getX() * f : 0.0f, i == 1 ? p.getHalf().getY() * f : 0.0f, i == 2 ? p.getHalf().getZ() * f : 0.0f));
                    if (!ViewportView.access$getStudio$p(viewportView).getSnapEnabled() || ViewportView.access$getStudio$p(viewportView).getMoveSnap() <= 0.0f) {
                        vector3 = plus;
                    } else {
                        float moveSnap = ViewportView.access$getStudio$p(viewportView).getMoveSnap();
                        if (i == 0) {
                            vector32 = plus;
                            updatePartDrag$lambda$85$sn = plus.getX();
                        } else {
                            vector32 = plus;
                            updatePartDrag$lambda$85$sn = updatePartDrag$lambda$85$sn(this, moveSnap, plus.getX(), p.getHalf().getX());
                        }
                        vector3 = new Vector3(updatePartDrag$lambda$85$sn, i == 1 ? vector32.getY() : updatePartDrag$lambda$85$sn(this, moveSnap, vector32.getY(), p.getHalf().getY()), i == 2 ? vector32.getZ() : updatePartDrag$lambda$85$sn(this, moveSnap, vector32.getZ(), p.getHalf().getZ()));
                    }
                } else {
                    if (Math.abs(component2.getY()) < 1.0E-4f) {
                        return;
                    }
                    float y = (p.getGrab().getY() - component1.getY()) / component2.getY();
                    if (y < 0.0f) {
                        return;
                    }
                    Vector3 plus2 = component1.plus(component2.times(y)).plus(minus);
                    if (ViewportView.access$getStudio$p(viewportView).getSnapEnabled() && ViewportView.access$getStudio$p(viewportView).getMoveSnap() > 0.0f) {
                        plus2 = new Vector3(snap(plus2.getX(), ViewportView.access$getStudio$p(viewportView).getMoveSnap()), plus2.getY(), snap(plus2.getZ(), ViewportView.access$getStudio$p(viewportView).getMoveSnap()));
                    }
                    vector3 = plus2;
                }
                Vector3 minus2 = vector3.minus(p.getCenter());
                int i2 = 0;
                for (Object obj : p.getParts()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Instance.set$default((Instance) obj, "CFrame", p.getStartCf().get(i2).plus(minus2), false, 4, null);
                    i2 = i3;
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean updatePartDrag$lambda$85$lambda$83(Set set, Instance it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return !set.contains(it) && PartData.INSTANCE.transparency(it) < 0.99f;
        }

        private static final float updatePartDrag$lambda$85$sn(TouchLayer touchLayer, float f, float f2, float f3) {
            return touchLayer.snap(f2 - f3, f) + f3;
        }

        public final boolean getBusy() {
            return !this.ptrs.isEmpty() || ViewportView.access$getStudio$p(this.this$0).getFlyUp() || ViewportView.access$getStudio$p(this.this$0).getFlyDown();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            this.buttons.clear();
            PlaySession play = ViewportView.access$getStudio$p(this.this$0).getPlay();
            if (!getActiveJoy() || getFixedStick()) {
                this.joyCx = getDefaultJoyX();
                this.joyCy = getDefaultJoyY();
            }
            if (play != null) {
                drawPlayControls(canvas, play);
            } else {
                drawEditControls(canvas);
            }
            if (Settings.INSTANCE.getShowFps()) {
                this.text.setTextSize(this.d * 11.0f);
                this.text.setTextAlign(Paint.Align.RIGHT);
                this.text.setColor(-1711276033);
                this.text.setFakeBoldText(false);
                canvas.drawText(MathKt.roundToInt(this.this$0.getRenderer().getFps()) + " FPS", getWidth() - (this.d * 8.0f), getHeight() - (this.d * 6.0f), this.text);
                this.text.setTextAlign(Paint.Align.CENTER);
                this.text.setColor(-1);
                this.text.setFakeBoldText(true);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            int actionIndex = e.getActionIndex();
            switch (e.getActionMasked()) {
                case 0:
                case 5:
                    down(e.getPointerId(actionIndex), e.getX(actionIndex), e.getY(actionIndex));
                    break;
                case 1:
                case 6:
                    up(e.getPointerId(actionIndex), e.getX(actionIndex), e.getY(actionIndex), false);
                    break;
                case 2:
                    int pointerCount = e.getPointerCount();
                    for (int i = 0; i < pointerCount; i++) {
                        Ptr ptr = this.ptrs.get(Integer.valueOf(e.getPointerId(i)));
                        if (ptr != null) {
                            move(ptr, e.getX(i), e.getY(i));
                        }
                    }
                    camGesture();
                    break;
                case 3:
                    Set<Integer> keySet = this.ptrs.keySet();
                    Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
                    Iterator it = CollectionsKt.toList(keySet).iterator();
                    while (it.hasNext()) {
                        up(((Number) it.next()).intValue(), 0.0f, 0.0f, true);
                    }
                    break;
            }
            invalidate();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewportView(Context ctx, Studio studio) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(studio, "studio");
        this.studio = studio;
        this.gl = new GLSurfaceView(ctx);
        this.renderer = new SceneRenderer(this.studio);
        this.gui = new GuiOverlay(ctx, this.studio);
        this.controls = new TouchLayer(this, ctx);
        this.hud = new PlayHud(ctx, this.studio);
        this.gl.setEGLContextClientVersion(2);
        this.gl.setEGLConfigChooser(new MsaaConfigChooser());
        this.gl.setPreserveEGLContextOnPause(true);
        this.gl.setRenderer(this.renderer);
        this.gl.setRenderMode(1);
        addView(this.gl, new FrameLayout.LayoutParams(-1, -1));
        addView(this.gui, new FrameLayout.LayoutParams(-1, -1));
        addView(this.controls, new FrameLayout.LayoutParams(-1, -1));
        addView(this.hud, new FrameLayout.LayoutParams(-1, -1));
        this.renderer.setOnFrame(new ViewportView$$ExternalSyntheticLambda0(this));
        this.renderer.setSurfacePainter(new ViewportView$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$1(ViewportView viewportView) {
        ArrayList<Instance> children;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - viewportView.lastOverlay > 33) {
            viewportView.lastOverlay = currentTimeMillis;
            Instance findService = viewportView.studio.getModel().findService("CoreGui");
            boolean z = false;
            if (findService != null && (children = findService.getChildren()) != null && (!children.isEmpty())) {
                z = true;
            }
            if (viewportView.gui.getHasContent() || viewportView.studio.isPlaying() || !viewportView.studio.getPluginWidgets().isEmpty() || viewportView.gui.getSelectedGui() != null || z) {
                viewportView.gui.postInvalidate();
            }
            if (viewportView.studio.isPlaying() || viewportView.controls.getBusy() || currentTimeMillis - viewportView.lastControls > 500) {
                viewportView.lastControls = currentTimeMillis;
                viewportView.controls.postInvalidate();
            }
            if (viewportView.studio.isPlaying() && !viewportView.hudPosted) {
                viewportView.hudPosted = true;
                viewportView.hud.post(new ViewportView$$ExternalSyntheticLambda2(viewportView));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$2(ViewportView viewportView, Instance g, float f, float f2, Bitmap bmp) {
        Intrinsics.checkNotNullParameter(g, "g");
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        viewportView.gui.renderSurface(g, f, f2, bmp);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ int access$getDepthBits$cp() {
        return depthBits;
    }

    public static final /* synthetic */ Studio access$getStudio$p(ViewportView viewportView) {
        return viewportView.studio;
    }

    public static final /* synthetic */ void access$setDepthBits$cp(int i) {
        depthBits = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$1$lambda$0(ViewportView viewportView) {
        viewportView.hudPosted = false;
        viewportView.hud.onFrame();
    }

    public final TouchLayer getControls() {
        return this.controls;
    }

    public final GLSurfaceView getGl() {
        return this.gl;
    }

    public final GuiOverlay getGui() {
        return this.gui;
    }

    public final PlayHud getHud() {
        return this.hud;
    }

    public final SceneRenderer getRenderer() {
        return this.renderer;
    }

    public final void onPause() {
        this.gl.onPause();
    }

    public final void onResume() {
        this.gl.onResume();
    }
}
