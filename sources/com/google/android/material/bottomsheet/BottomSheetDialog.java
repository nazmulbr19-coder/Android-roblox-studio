package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.insets.Protection;
import androidx.core.view.insets.ProtectionLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.List;

/* loaded from: classes.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private MaterialBackOrchestrator backOrchestrator;
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private EdgeToEdgeCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;
    private ProtectionLayout protectionLayout;
    private List<Protection> protectionsList;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements OnApplyWindowInsetsListener {
        AnonymousClass1() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (BottomSheetDialog.access$000(BottomSheetDialog.this) != null) {
                BottomSheetDialog.access$100(BottomSheetDialog.this).removeBottomSheetCallback(BottomSheetDialog.access$000(BottomSheetDialog.this));
            }
            if (windowInsetsCompat != null) {
                BottomSheetDialog.access$002(BottomSheetDialog.this, new EdgeToEdgeCallback(BottomSheetDialog.access$200(BottomSheetDialog.this), windowInsetsCompat, null));
                BottomSheetDialog.access$000(BottomSheetDialog.this).setWindow(BottomSheetDialog.this.getWindow());
                BottomSheetDialog.access$100(BottomSheetDialog.this).addBottomSheetCallback(BottomSheetDialog.access$000(BottomSheetDialog.this));
            }
            return windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BottomSheetDialog.this.cancelable && BottomSheetDialog.this.isShowing() && BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends AccessibilityDelegateCompat {
        AnonymousClass3() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!BottomSheetDialog.this.cancelable) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i != 1048576 || !BottomSheetDialog.this.cancelable) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            BottomSheetDialog.this.cancel();
            return true;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements View.OnTouchListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends BottomSheetBehavior.BottomSheetCallback {
        AnonymousClass5() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            if (i == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    private static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        private final WindowInsetsCompat insetsCompat;
        private final Boolean lightBottomSheet;
        private boolean lightStatusBar;
        private Window window;

        private EdgeToEdgeCallback(View view, WindowInsetsCompat windowInsetsCompat) {
            this.insetsCompat = windowInsetsCompat;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            ColorStateList fillColor = materialShapeDrawable != null ? materialShapeDrawable.getFillColor() : view.getBackgroundTintList();
            if (fillColor != null) {
                this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(fillColor.getDefaultColor()));
                return;
            }
            Integer backgroundColor = ViewUtils.getBackgroundColor(view);
            if (backgroundColor != null) {
                this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(backgroundColor.intValue()));
            } else {
                this.lightBottomSheet = null;
            }
        }

        /* synthetic */ EdgeToEdgeCallback(View view, WindowInsetsCompat windowInsetsCompat, AnonymousClass1 anonymousClass1) {
            this(view, windowInsetsCompat);
        }

        private void setPaddingForPosition(View view) {
            if (view.getTop() < this.insetsCompat.getSystemWindowInsetTop()) {
                if (this.window != null) {
                    EdgeToEdgeUtils.setLightStatusBar(this.window, this.lightBottomSheet == null ? this.lightStatusBar : this.lightBottomSheet.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                if (this.window != null) {
                    EdgeToEdgeUtils.setLightStatusBar(this.window, this.lightStatusBar);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        void onLayout(View view) {
            setPaddingForPosition(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
            setPaddingForPosition(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            setPaddingForPosition(view);
        }

        void setWindow(Window window) {
            if (this.window == window) {
                return;
            }
            this.window = window;
            if (window != null) {
                this.lightStatusBar = WindowCompat.getInsetsController(window, window.getDecorView()).isAppearanceLightStatusBars();
            }
        }
    }

    public BottomSheetDialog(Context context) {
        this(context, 0);
        initialize();
    }

    public BottomSheetDialog(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5();
        supportRequestWindowFeature(1);
        initialize();
    }

    protected BottomSheetDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5();
        supportRequestWindowFeature(1);
        this.cancelable = z;
        initialize();
    }

    static /* synthetic */ EdgeToEdgeCallback access$000(BottomSheetDialog bottomSheetDialog) {
        return bottomSheetDialog.edgeToEdgeCallback;
    }

    static /* synthetic */ EdgeToEdgeCallback access$002(BottomSheetDialog bottomSheetDialog, EdgeToEdgeCallback edgeToEdgeCallback) {
        bottomSheetDialog.edgeToEdgeCallback = edgeToEdgeCallback;
        return edgeToEdgeCallback;
    }

    static /* synthetic */ BottomSheetBehavior access$100(BottomSheetDialog bottomSheetDialog) {
        return bottomSheetDialog.behavior;
    }

    static /* synthetic */ FrameLayout access$200(BottomSheetDialog bottomSheetDialog) {
        return bottomSheetDialog.bottomSheet;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            this.container = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.protectionLayout = (ProtectionLayout) this.container.findViewById(R.id.protection_layout);
            if (this.protectionsList != null) {
                setProtections(this.protectionsList);
            }
            this.coordinator = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
            this.bottomSheet = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
            this.behavior = BottomSheetBehavior.from(this.bottomSheet);
            this.behavior.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
            this.backOrchestrator = new MaterialBackOrchestrator(this.behavior, this.bottomSheet);
        }
        return this.container;
    }

    private static int getThemeResId(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
    }

    private void initialize() {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge});
        this.edgeToEdgeEnabled = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    @Deprecated
    public static void setLightStatusBar(View view, boolean z) {
        int i = Build.VERSION.SDK_INT;
        int systemUiVisibility = view.getSystemUiVisibility();
        view.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    private void updateListeningForBackCallbacks() {
        if (this.backOrchestrator == null) {
            return;
        }
        if (this.cancelable) {
            this.backOrchestrator.startListeningForBackCallbacks();
        } else {
            this.backOrchestrator.stopListeningForBackCallbacks();
        }
    }

    private View wrapInBottomSheet(int i, View view, ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            ViewCompat.setOnApplyWindowInsetsListener(this.container, new AnonymousClass1());
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new AnonymousClass2());
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3());
        this.bottomSheet.setOnTouchListener(new AnonymousClass4());
        return this.container;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        if (!this.dismissWithAnimation || behavior.getState() == 5) {
            super.cancel();
        } else {
            behavior.setState(5);
        }
    }

    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.edgeToEdgeEnabled && Color.alpha(EdgeToEdgeUtils.getNavigationBarColor(window)) < 255;
            if (this.container != null) {
                this.container.setFitsSystemWindows(!z);
            }
            if (this.coordinator != null) {
                this.coordinator.setFitsSystemWindows(!z);
            }
            WindowCompat.setDecorFitsSystemWindows(window, z ? false : true);
            if (this.edgeToEdgeCallback != null) {
                this.edgeToEdgeCallback.setWindow(window);
            }
        }
        updateListeningForBackCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            EdgeToEdgeUtils.setStatusBarColor(window, 0);
            window.addFlags(Integer.MIN_VALUE);
            int i = Build.VERSION.SDK_INT;
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        if (this.edgeToEdgeCallback != null) {
            this.edgeToEdgeCallback.setWindow(null);
        }
        if (this.backOrchestrator != null) {
            this.backOrchestrator.stopListeningForBackCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        if (this.behavior == null || this.behavior.getState() != 5) {
            return;
        }
        this.behavior.setState(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.cancelable != z) {
            this.cancelable = z;
            if (this.behavior != null) {
                this.behavior.setHideable(z);
            }
            if (getWindow() != null) {
                updateListeningForBackCallbacks();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(wrapInBottomSheet(i, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public void setDismissWithAnimation(boolean z) {
        this.dismissWithAnimation = z;
    }

    public void setProtections(List<Protection> list) {
        this.protectionsList = list;
        if (this.protectionLayout != null) {
            this.protectionLayout.setProtections(list);
            this.protectionLayout.setVisibility(list.isEmpty() ? 8 : 0);
        }
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }
}
