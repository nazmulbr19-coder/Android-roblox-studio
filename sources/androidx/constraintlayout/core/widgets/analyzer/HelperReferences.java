package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* loaded from: classes.dex */
class HelperReferences extends WidgetRun {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void addDependency(DependencyNode dependencyNode) {
        this.start.mDependencies.add(dependencyNode);
        dependencyNode.mTargets.add(this.start);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        if (this.mWidget instanceof Barrier) {
            this.start.delegateToWidgetRun = true;
            Barrier barrier = (Barrier) this.mWidget;
            int barrierType = barrier.getBarrierType();
            boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
            switch (barrierType) {
                case 0:
                    this.start.mType = DependencyNode.Type.LEFT;
                    for (int i = 0; i < barrier.mWidgetsCount; i++) {
                        ConstraintWidget constraintWidget = barrier.mWidgets[i];
                        if (allowsGoneWidget || constraintWidget.getVisibility() != 8) {
                            DependencyNode dependencyNode = constraintWidget.mHorizontalRun.start;
                            dependencyNode.mDependencies.add(this.start);
                            this.start.mTargets.add(dependencyNode);
                        }
                    }
                    addDependency(this.mWidget.mHorizontalRun.start);
                    addDependency(this.mWidget.mHorizontalRun.end);
                    return;
                case 1:
                    this.start.mType = DependencyNode.Type.RIGHT;
                    for (int i2 = 0; i2 < barrier.mWidgetsCount; i2++) {
                        ConstraintWidget constraintWidget2 = barrier.mWidgets[i2];
                        if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                            DependencyNode dependencyNode2 = constraintWidget2.mHorizontalRun.end;
                            dependencyNode2.mDependencies.add(this.start);
                            this.start.mTargets.add(dependencyNode2);
                        }
                    }
                    addDependency(this.mWidget.mHorizontalRun.start);
                    addDependency(this.mWidget.mHorizontalRun.end);
                    return;
                case 2:
                    this.start.mType = DependencyNode.Type.TOP;
                    for (int i3 = 0; i3 < barrier.mWidgetsCount; i3++) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[i3];
                        if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                            DependencyNode dependencyNode3 = constraintWidget3.mVerticalRun.start;
                            dependencyNode3.mDependencies.add(this.start);
                            this.start.mTargets.add(dependencyNode3);
                        }
                    }
                    addDependency(this.mWidget.mVerticalRun.start);
                    addDependency(this.mWidget.mVerticalRun.end);
                    return;
                case 3:
                    this.start.mType = DependencyNode.Type.BOTTOM;
                    for (int i4 = 0; i4 < barrier.mWidgetsCount; i4++) {
                        ConstraintWidget constraintWidget4 = barrier.mWidgets[i4];
                        if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                            DependencyNode dependencyNode4 = constraintWidget4.mVerticalRun.end;
                            dependencyNode4.mDependencies.add(this.start);
                            this.start.mTargets.add(dependencyNode4);
                        }
                    }
                    addDependency(this.mWidget.mVerticalRun.start);
                    addDependency(this.mWidget.mVerticalRun.end);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.mWidget instanceof Barrier) {
            int barrierType = ((Barrier) this.mWidget).getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                this.mWidget.setX(this.start.value);
            } else {
                this.mWidget.setY(this.start.value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.mRunGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.mWidget;
        int barrierType = barrier.getBarrierType();
        int i = -1;
        int i2 = 0;
        Iterator<DependencyNode> it = this.start.mTargets.iterator();
        while (it.hasNext()) {
            int i3 = it.next().value;
            if (i == -1 || i3 < i) {
                i = i3;
            }
            if (i2 < i3) {
                i2 = i3;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            this.start.resolve(barrier.getMargin() + i);
        } else {
            this.start.resolve(barrier.getMargin() + i2);
        }
    }
}
