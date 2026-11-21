package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    protected ConstraintWidget.DimensionBehaviour mDimensionBehavior;
    RunGroup mRunGroup;
    ConstraintWidget mWidget;
    public int matchConstraintsType;
    DimensionDependency mDimension = new DimensionDependency(this);
    public int orientation = 0;
    boolean mResolved = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    protected RunType mRunType = RunType.NONE;

    /* loaded from: classes.dex */
    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.mWidget = constraintWidget;
    }

    private void resolveDimension(int i, int i2) {
        switch (this.matchConstraintsType) {
            case 0:
                this.mDimension.resolve(getLimitedDimension(i2, i));
                return;
            case 1:
                this.mDimension.resolve(Math.min(getLimitedDimension(this.mDimension.wrapValue, i), i2));
                return;
            case 2:
                ConstraintWidget parent = this.mWidget.getParent();
                if (parent != null) {
                    if ((i == 0 ? parent.mHorizontalRun : parent.mVerticalRun).mDimension.resolved) {
                        this.mDimension.resolve(getLimitedDimension((int) ((r2.mDimension.value * (i == 0 ? this.mWidget.mMatchConstraintPercentWidth : this.mWidget.mMatchConstraintPercentHeight)) + 0.5f), i));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (this.mWidget.mHorizontalRun.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.mWidget.mHorizontalRun.matchConstraintsType == 3 && this.mWidget.mVerticalRun.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.mWidget.mVerticalRun.matchConstraintsType == 3) {
                    return;
                }
                if ((i == 0 ? this.mWidget.mVerticalRun : this.mWidget.mHorizontalRun).mDimension.resolved) {
                    float dimensionRatio = this.mWidget.getDimensionRatio();
                    this.mDimension.resolve(i == 1 ? (int) ((r0.mDimension.value / dimensionRatio) + 0.5f) : (int) ((r0.mDimension.value * dimensionRatio) + 0.5f));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.mTargets.add(dependencyNode2);
        dependencyNode.mMargin = i;
        dependencyNode2.mDependencies.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.mTargets.add(dependencyNode2);
        dependencyNode.mTargets.add(this.mDimension);
        dependencyNode.mMarginFactor = i;
        dependencyNode.mMarginDependency = dimensionDependency;
        dependencyNode2.mDependencies.add(dependencyNode);
        dimensionDependency.mDependencies.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void apply();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void applyToWidget();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void clear();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getLimitedDimension(int i, int i2) {
        if (i2 == 0) {
            int i3 = this.mWidget.mMatchConstraintMaxWidth;
            int max = Math.max(this.mWidget.mMatchConstraintMinWidth, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            return max != i ? max : i;
        }
        int i4 = this.mWidget.mMatchConstraintMaxHeight;
        int max2 = Math.max(this.mWidget.mMatchConstraintMinHeight, i);
        if (i4 > 0) {
            max2 = Math.min(i4, i);
        }
        return max2 != i ? max2 : i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.mTarget.mOwner;
        switch (constraintAnchor.mTarget.mType) {
            case LEFT:
                return constraintWidget.mHorizontalRun.start;
            case RIGHT:
                return constraintWidget.mHorizontalRun.end;
            case TOP:
                return constraintWidget.mVerticalRun.start;
            case BASELINE:
                return constraintWidget.mVerticalRun.baseline;
            case BOTTOM:
                return constraintWidget.mVerticalRun.end;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        if (constraintAnchor.mTarget == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.mTarget.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.mHorizontalRun : constraintWidget.mVerticalRun;
        switch (constraintAnchor.mTarget.mType) {
            case LEFT:
            case TOP:
                return widgetRun.start;
            case RIGHT:
            case BOTTOM:
                return widgetRun.end;
            case BASELINE:
            default:
                return null;
        }
    }

    public long getWrapDimension() {
        if (this.mDimension.resolved) {
            return this.mDimension.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int i = 0;
        int size = this.start.mTargets.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.start.mTargets.get(i2).mRun != this) {
                i++;
            }
        }
        int size2 = this.end.mTargets.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (this.end.mTargets.get(i3).mRun != this) {
                i++;
            }
        }
        return i >= 2;
    }

    public boolean isDimensionResolved() {
        return this.mDimension.resolved;
    }

    public boolean isResolved() {
        return this.mResolved;
    }

    abstract void reset();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = target.value + constraintAnchor.getMargin();
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i2 = margin2 - margin;
            if (!this.mDimension.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i, i2);
            }
            if (this.mDimension.resolved) {
                if (this.mDimension.value == i2) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                float horizontalBiasPercent = i == 0 ? this.mWidget.getHorizontalBiasPercent() : this.mWidget.getVerticalBiasPercent();
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    horizontalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (margin + 0.5f + (((margin2 - margin) - this.mDimension.value) * horizontalBiasPercent)));
                this.end.resolve(this.start.value + this.mDimension.value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRunEnd(Dependency dependency) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i) {
        if (!this.mDimension.resolved) {
            return 0L;
        }
        long j = this.mDimension.value;
        return isCenterConnection() ? j + (this.start.mMargin - this.end.mMargin) : i == 0 ? j + this.start.mMargin : j - this.end.mMargin;
    }
}
