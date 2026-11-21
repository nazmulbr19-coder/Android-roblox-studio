package androidx.core.view.insets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.insets.Protection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ProtectionLayout extends FrameLayout {
    private static final Object PROTECTION_VIEW = new Object();
    private ProtectionGroup mGroup;
    private final List<Protection> mProtections;

    /* renamed from: androidx.core.view.insets.ProtectionLayout$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Protection.Attributes.Callback {
        final /* synthetic */ FrameLayout.LayoutParams val$params;
        final /* synthetic */ View val$view;

        AnonymousClass1(FrameLayout.LayoutParams layoutParams, View view) {
            this.val$params = layoutParams;
            this.val$view = view;
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onAlphaChanged(float f) {
            this.val$view.setAlpha(f);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onDrawableChanged(Drawable drawable) {
            this.val$view.setBackground(drawable);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onHeightChanged(int i) {
            this.val$params.height = i;
            this.val$view.setLayoutParams(this.val$params);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onMarginChanged(Insets insets) {
            this.val$params.leftMargin = insets.left;
            this.val$params.topMargin = insets.top;
            this.val$params.rightMargin = insets.right;
            this.val$params.bottomMargin = insets.bottom;
            this.val$view.setLayoutParams(this.val$params);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onTranslationXChanged(float f) {
            this.val$view.setTranslationX(f);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onTranslationYChanged(float f) {
            this.val$view.setTranslationY(f);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onVisibilityChanged(boolean z) {
            this.val$view.setVisibility(z ? 0 : 8);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onWidthChanged(int i) {
            this.val$params.width = i;
            this.val$view.setLayoutParams(this.val$params);
        }
    }

    public ProtectionLayout(Context context) {
        super(context);
        this.mProtections = new ArrayList();
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mProtections = new ArrayList();
    }

    public ProtectionLayout(Context context, List<Protection> list) {
        super(context);
        this.mProtections = new ArrayList();
        setProtections(list);
    }

    private void addProtectionView(Context context, int i, Protection protection) {
        int width;
        int i2;
        int i3;
        Protection.Attributes attributes = protection.getAttributes();
        switch (protection.getSide()) {
            case 1:
                width = attributes.getWidth();
                i2 = -1;
                i3 = 3;
                break;
            case 2:
                width = -1;
                i2 = attributes.getHeight();
                i3 = 48;
                break;
            case 4:
                width = attributes.getWidth();
                i2 = -1;
                i3 = 5;
                break;
            case 8:
                width = -1;
                i2 = attributes.getHeight();
                i3 = 80;
                break;
            default:
                throw new IllegalArgumentException("Unexpected side: " + protection.getSide());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, i2, i3);
        Insets margin = attributes.getMargin();
        layoutParams.leftMargin = margin.left;
        layoutParams.topMargin = margin.top;
        layoutParams.rightMargin = margin.right;
        layoutParams.bottomMargin = margin.bottom;
        View view = new View(context);
        view.setTag(PROTECTION_VIEW);
        view.setTranslationX(attributes.getTranslationX());
        view.setTranslationY(attributes.getTranslationY());
        view.setAlpha(attributes.getAlpha());
        view.setVisibility(attributes.isVisible() ? 0 : 8);
        view.setBackground(attributes.getDrawable());
        attributes.setCallback(new AnonymousClass1(layoutParams, view));
        addView(view, i, layoutParams);
    }

    private void addProtectionViews() {
        if (this.mProtections.isEmpty()) {
            removeProtectionViews();
            return;
        }
        SystemBarStateMonitor orInstallSystemBarStateMonitor = getOrInstallSystemBarStateMonitor();
        removeProtectionViews();
        this.mGroup = new ProtectionGroup(orInstallSystemBarStateMonitor, this.mProtections);
        int childCount = getChildCount();
        int size = this.mGroup.size();
        for (int i = 0; i < size; i++) {
            addProtectionView(getContext(), i + childCount, this.mGroup.getProtection(i));
        }
    }

    private SystemBarStateMonitor getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            return (SystemBarStateMonitor) tag;
        }
        SystemBarStateMonitor systemBarStateMonitor = new SystemBarStateMonitor(viewGroup);
        viewGroup.setTag(R.id.tag_system_bar_state_monitor, systemBarStateMonitor);
        return systemBarStateMonitor;
    }

    private void maybeUninstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            SystemBarStateMonitor systemBarStateMonitor = (SystemBarStateMonitor) tag;
            if (systemBarStateMonitor.hasCallback()) {
                return;
            }
            systemBarStateMonitor.detachFromWindow();
            viewGroup.setTag(R.id.tag_system_bar_state_monitor, null);
        }
    }

    private void removeProtectionViews() {
        if (this.mGroup != null) {
            removeViews(getChildCount() - this.mGroup.size(), this.mGroup.size());
            int size = this.mGroup.size();
            for (int i = 0; i < size; i++) {
                this.mGroup.getProtection(i).getAttributes().setCallback(null);
            }
            this.mGroup.dispose();
            this.mGroup = null;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getTag() != PROTECTION_VIEW) {
            int childCount = getChildCount() - (this.mGroup != null ? this.mGroup.size() : 0);
            if (i > childCount || i < 0) {
                i = childCount;
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        addProtectionViews();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeProtectionViews();
        maybeUninstallSystemBarStateMonitor();
    }

    public void setProtections(List<Protection> list) {
        this.mProtections.clear();
        this.mProtections.addAll(list);
        if (isAttachedToWindow()) {
            addProtectionViews();
            requestApplyInsets();
        }
    }
}
