package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ReplaceWith;
import androidx.core.R;

/* loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    private static final WindowInsets CONSUMED = WindowInsetsCompat.CONSUMED.toWindowInsets();
    static boolean sCompatInsetsDispatchInstalled = false;

    private ViewGroupCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
        Object tag = view.getTag(R.id.tag_on_apply_window_listener);
        Object tag2 = view.getTag(R.id.tag_window_insets_animation_callback);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = tag instanceof View.OnApplyWindowInsetsListener ? (View.OnApplyWindowInsetsListener) tag : tag2 instanceof View.OnApplyWindowInsetsListener ? (View.OnApplyWindowInsetsListener) tag2 : null;
        WindowInsets[] windowInsetsArr = {CONSUMED};
        view.setOnApplyWindowInsetsListener(new ViewGroupCompat$$ExternalSyntheticLambda0(windowInsetsArr, onApplyWindowInsetsListener));
        view.dispatchApplyWindowInsets(windowInsets);
        Object tag3 = view.getTag(R.id.tag_compat_insets_dispatch);
        view.setOnApplyWindowInsetsListener(tag3 instanceof View.OnApplyWindowInsetsListener ? (View.OnApplyWindowInsetsListener) tag3 : onApplyWindowInsetsListener);
        if (windowInsetsArr[0] != null && !windowInsetsArr[0].isConsumed() && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                dispatchApplyWindowInsets(viewGroup.getChildAt(i), windowInsetsArr[0]);
            }
        }
        return windowInsetsArr[0] != null ? windowInsetsArr[0] : CONSUMED;
    }

    @ReplaceWith(expression = "group.getLayoutMode()")
    @Deprecated
    public static int getLayoutMode(ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    public static void installCompatInsetsDispatch(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return;
        }
        View.OnApplyWindowInsetsListener viewGroupCompat$$ExternalSyntheticLambda1 = new ViewGroupCompat$$ExternalSyntheticLambda1();
        view.setTag(R.id.tag_compat_insets_dispatch, viewGroupCompat$$ExternalSyntheticLambda1);
        view.setOnApplyWindowInsetsListener(viewGroupCompat$$ExternalSyntheticLambda1);
        sCompatInsetsDispatchInstalled = true;
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsets lambda$dispatchApplyWindowInsets$1(WindowInsets[] windowInsetsArr, View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
        windowInsetsArr[0] = onApplyWindowInsetsListener != null ? onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets) : view.onApplyWindowInsets(windowInsets);
        return CONSUMED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsets lambda$installCompatInsetsDispatch$0(View view, WindowInsets windowInsets) {
        dispatchApplyWindowInsets(view, windowInsets);
        return CONSUMED;
    }

    @ReplaceWith(expression = "group.onRequestSendAccessibilityEvent(child, event)")
    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    @ReplaceWith(expression = "group.setLayoutMode(mode)")
    @Deprecated
    public static void setLayoutMode(ViewGroup viewGroup, int i) {
        viewGroup.setLayoutMode(i);
    }

    @ReplaceWith(expression = "group.setMotionEventSplittingEnabled(split)")
    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        viewGroup.setTransitionGroup(z);
    }
}
