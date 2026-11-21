package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EdgeToEdge.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u000b\u001a\u00020\f*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0011\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DefaultLightScrim", "", "getDefaultLightScrim$annotations", "()V", "getDefaultLightScrim", "()I", "DefaultDarkScrim", "getDefaultDarkScrim$annotations", "getDefaultDarkScrim", "Impl", "Landroidx/activity/EdgeToEdgeImpl;", "enableEdgeToEdge", "", "Landroidx/activity/ComponentActivity;", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "enable", "activity"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EdgeToEdge {
    private static EdgeToEdgeImpl Impl;
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);

    public static final void enable(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        enable$default(componentActivity, null, null, 3, null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle statusBarStyle) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        enable$default(componentActivity, statusBarStyle, null, 2, null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle) {
        EdgeToEdgeImpl edgeToEdgeImpl;
        boolean z;
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        EdgeToEdgeImpl edgeToEdgeImpl2 = Impl;
        if (edgeToEdgeImpl2 == null) {
            EdgeToEdgeApi23 edgeToEdgeApi35 = Build.VERSION.SDK_INT >= 35 ? new EdgeToEdgeApi35() : Build.VERSION.SDK_INT >= 30 ? new EdgeToEdgeApi30() : Build.VERSION.SDK_INT >= 29 ? new EdgeToEdgeApi29() : Build.VERSION.SDK_INT >= 28 ? new EdgeToEdgeApi28() : Build.VERSION.SDK_INT >= 26 ? new EdgeToEdgeApi26() : new EdgeToEdgeApi23();
            Impl = edgeToEdgeApi35;
            edgeToEdgeImpl = edgeToEdgeApi35;
        } else {
            edgeToEdgeImpl = edgeToEdgeImpl2;
        }
        EdgeToEdge$$ExternalSyntheticLambda0 edgeToEdge$$ExternalSyntheticLambda0 = new EdgeToEdge$$ExternalSyntheticLambda0(edgeToEdgeImpl, statusBarStyle, navigationBarStyle, componentActivity, decorView);
        ViewGroup viewGroup = (ViewGroup) decorView;
        Iterator<View> it = ViewGroupKt.getChildren(viewGroup).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().getTag() instanceof EdgeToEdgeImpl) {
                z = true;
                break;
            }
        }
        if (!z) {
            EdgeToEdge$enableEdgeToEdge$1$2 edgeToEdge$enableEdgeToEdge$1$2 = new EdgeToEdge$enableEdgeToEdge$1$2(edgeToEdge$$ExternalSyntheticLambda0, ((ViewGroup) decorView).getContext());
            edgeToEdge$enableEdgeToEdge$1$2.setTag(edgeToEdgeImpl);
            edgeToEdge$enableEdgeToEdge$1$2.setVisibility(8);
            edgeToEdge$enableEdgeToEdge$1$2.setWillNotDraw(true);
            viewGroup.addView(edgeToEdge$enableEdgeToEdge$1$2);
        }
        edgeToEdge$$ExternalSyntheticLambda0.run();
        Window window = componentActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        edgeToEdgeImpl.adjustLayoutInDisplayCutoutMode(window);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.INSTANCE, 0, 0, null, 4, null);
        }
        if ((i & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.INSTANCE, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void enableEdgeToEdge$lambda$1(EdgeToEdgeImpl edgeToEdgeImpl, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, ComponentActivity componentActivity, View view) {
        Window window = componentActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        Function1<Resources, Boolean> detectDarkMode$activity = systemBarStyle.getDetectDarkMode$activity();
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        boolean booleanValue = detectDarkMode$activity.invoke(resources).booleanValue();
        Function1<Resources, Boolean> detectDarkMode$activity2 = systemBarStyle2.getDetectDarkMode$activity();
        Resources resources2 = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        edgeToEdgeImpl.setUp(systemBarStyle, systemBarStyle2, window, view, booleanValue, detectDarkMode$activity2.invoke(resources2).booleanValue());
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }
}
