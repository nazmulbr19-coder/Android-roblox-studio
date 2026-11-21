package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState;

    /* renamed from: com.google.android.material.transformation.ExpandableBehavior$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View val$child;
        final /* synthetic */ ExpandableWidget val$dep;
        final /* synthetic */ int val$expectedState;

        AnonymousClass1(View view, int i, ExpandableWidget expandableWidget) {
            this.val$child = view;
            this.val$expectedState = i;
            this.val$dep = expandableWidget;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.val$child.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.access$000(ExpandableBehavior.this) == this.val$expectedState) {
                ExpandableBehavior.this.onExpandedStateChange((View) this.val$dep, this.val$child, this.val$dep.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
    }

    static /* synthetic */ int access$000(ExpandableBehavior expandableBehavior) {
        return expandableBehavior.currentState;
    }

    private boolean didStateChange(boolean z) {
        return z ? this.currentState == 0 || this.currentState == 2 : this.currentState == 1;
    }

    public static <T extends ExpandableBehavior> T from(View view, Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof ExpandableBehavior) {
            return cls.cast(behavior);
        }
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ExpandableWidget findExpandableWidget(CoordinatorLayout coordinatorLayout, View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View view2 = dependencies.get(i);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = expandableWidget.isExpanded() ? 1 : 2;
        return onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    protected abstract boolean onExpandedStateChange(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        ExpandableWidget findExpandableWidget;
        if (view.isLaidOut() || (findExpandableWidget = findExpandableWidget(coordinatorLayout, view)) == null || !didStateChange(findExpandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = findExpandableWidget.isExpanded() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(view, this.currentState, findExpandableWidget));
        return false;
    }
}
