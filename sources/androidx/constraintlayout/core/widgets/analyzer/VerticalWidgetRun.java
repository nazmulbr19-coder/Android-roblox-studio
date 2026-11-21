package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    private static final boolean FORCE_USE = true;
    public DependencyNode baseline;
    DimensionDependency mBaselineDimension;

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.baseline = new DependencyNode(this);
        this.mBaselineDimension = null;
        this.start.mType = DependencyNode.Type.TOP;
        this.end.mType = DependencyNode.Type.BOTTOM;
        this.baseline.mType = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        if (this.mWidget.measured) {
            this.mDimension.resolve(this.mWidget.getHeight());
        }
        if (!this.mDimension.resolved) {
            this.mDimensionBehavior = this.mWidget.getVerticalDimensionBehaviour();
            if (this.mWidget.hasBaseline()) {
                this.mBaselineDimension = new BaselineDimensionDependency(this);
            }
            if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.mWidget.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (parent2.getHeight() - this.mWidget.mTop.getMargin()) - this.mWidget.mBottom.getMargin();
                    addTarget(this.start, parent2.mVerticalRun.start, this.mWidget.mTop.getMargin());
                    addTarget(this.end, parent2.mVerticalRun.end, -this.mWidget.mBottom.getMargin());
                    this.mDimension.resolve(height);
                    return;
                }
                if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.mDimension.resolve(this.mWidget.getHeight());
                }
            }
        } else if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.mWidget.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            addTarget(this.start, parent.mVerticalRun.start, this.mWidget.mTop.getMargin());
            addTarget(this.end, parent.mVerticalRun.end, -this.mWidget.mBottom.getMargin());
            return;
        }
        if (this.mDimension.resolved && this.mWidget.measured) {
            if (this.mWidget.mListAnchors[2].mTarget != null && this.mWidget.mListAnchors[3].mTarget != null) {
                if (this.mWidget.isInVerticalChain()) {
                    this.start.mMargin = this.mWidget.mListAnchors[2].getMargin();
                    this.end.mMargin = -this.mWidget.mListAnchors[3].getMargin();
                } else {
                    DependencyNode target = getTarget(this.mWidget.mListAnchors[2]);
                    if (target != null) {
                        addTarget(this.start, target, this.mWidget.mListAnchors[2].getMargin());
                    }
                    DependencyNode target2 = getTarget(this.mWidget.mListAnchors[3]);
                    if (target2 != null) {
                        addTarget(this.end, target2, -this.mWidget.mListAnchors[3].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                }
                if (this.mWidget.hasBaseline()) {
                    addTarget(this.baseline, this.start, this.mWidget.getBaselineDistance());
                    return;
                }
                return;
            }
            if (this.mWidget.mListAnchors[2].mTarget != null) {
                DependencyNode target3 = getTarget(this.mWidget.mListAnchors[2]);
                if (target3 != null) {
                    addTarget(this.start, target3, this.mWidget.mListAnchors[2].getMargin());
                    addTarget(this.end, this.start, this.mDimension.value);
                    if (this.mWidget.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.mWidget.getBaselineDistance());
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.mWidget.mListAnchors[3].mTarget != null) {
                DependencyNode target4 = getTarget(this.mWidget.mListAnchors[3]);
                if (target4 != null) {
                    addTarget(this.end, target4, -this.mWidget.mListAnchors[3].getMargin());
                    addTarget(this.start, this.end, -this.mDimension.value);
                }
                if (this.mWidget.hasBaseline()) {
                    addTarget(this.baseline, this.start, this.mWidget.getBaselineDistance());
                    return;
                }
                return;
            }
            if (this.mWidget.mListAnchors[4].mTarget != null) {
                DependencyNode target5 = getTarget(this.mWidget.mListAnchors[4]);
                if (target5 != null) {
                    addTarget(this.baseline, target5, 0);
                    addTarget(this.start, this.baseline, -this.mWidget.getBaselineDistance());
                    addTarget(this.end, this.start, this.mDimension.value);
                    return;
                }
                return;
            }
            if ((this.mWidget instanceof Helper) || this.mWidget.getParent() == null || this.mWidget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) {
                return;
            }
            addTarget(this.start, this.mWidget.getParent().mVerticalRun.start, this.mWidget.getY());
            addTarget(this.end, this.start, this.mDimension.value);
            if (this.mWidget.hasBaseline()) {
                addTarget(this.baseline, this.start, this.mWidget.getBaselineDistance());
                return;
            }
            return;
        }
        if (!this.mDimension.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            switch (this.mWidget.mMatchConstraintDefaultHeight) {
                case 2:
                    ConstraintWidget parent3 = this.mWidget.getParent();
                    if (parent3 != null) {
                        DimensionDependency dimensionDependency = parent3.mVerticalRun.mDimension;
                        this.mDimension.mTargets.add(dimensionDependency);
                        dimensionDependency.mDependencies.add(this.mDimension);
                        this.mDimension.delegateToWidgetRun = true;
                        this.mDimension.mDependencies.add(this.start);
                        this.mDimension.mDependencies.add(this.end);
                        break;
                    }
                    break;
                case 3:
                    if (!this.mWidget.isInVerticalChain() && this.mWidget.mMatchConstraintDefaultWidth != 3) {
                        DimensionDependency dimensionDependency2 = this.mWidget.mHorizontalRun.mDimension;
                        this.mDimension.mTargets.add(dimensionDependency2);
                        dimensionDependency2.mDependencies.add(this.mDimension);
                        this.mDimension.delegateToWidgetRun = true;
                        this.mDimension.mDependencies.add(this.start);
                        this.mDimension.mDependencies.add(this.end);
                        break;
                    }
                    break;
            }
        } else {
            this.mDimension.addDependency(this);
        }
        if (this.mWidget.mListAnchors[2].mTarget != null && this.mWidget.mListAnchors[3].mTarget != null) {
            if (this.mWidget.isInVerticalChain()) {
                this.start.mMargin = this.mWidget.mListAnchors[2].getMargin();
                this.end.mMargin = -this.mWidget.mListAnchors[3].getMargin();
            } else {
                DependencyNode target6 = getTarget(this.mWidget.mListAnchors[2]);
                DependencyNode target7 = getTarget(this.mWidget.mListAnchors[3]);
                if (target6 != null) {
                    target6.addDependency(this);
                }
                if (target7 != null) {
                    target7.addDependency(this);
                }
                this.mRunType = WidgetRun.RunType.CENTER;
            }
            if (this.mWidget.hasBaseline()) {
                addTarget(this.baseline, this.start, 1, this.mBaselineDimension);
            }
        } else if (this.mWidget.mListAnchors[2].mTarget != null) {
            DependencyNode target8 = getTarget(this.mWidget.mListAnchors[2]);
            if (target8 != null) {
                addTarget(this.start, target8, this.mWidget.mListAnchors[2].getMargin());
                addTarget(this.end, this.start, 1, this.mDimension);
                if (this.mWidget.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.mBaselineDimension);
                }
                if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.mWidget.getDimensionRatio() > 0.0f && this.mWidget.mHorizontalRun.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mWidget.mHorizontalRun.mDimension.mDependencies.add(this.mDimension);
                    this.mDimension.mTargets.add(this.mWidget.mHorizontalRun.mDimension);
                    this.mDimension.updateDelegate = this;
                }
            }
        } else if (this.mWidget.mListAnchors[3].mTarget != null) {
            DependencyNode target9 = getTarget(this.mWidget.mListAnchors[3]);
            if (target9 != null) {
                addTarget(this.end, target9, -this.mWidget.mListAnchors[3].getMargin());
                addTarget(this.start, this.end, -1, this.mDimension);
                if (this.mWidget.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.mBaselineDimension);
                }
            }
        } else if (this.mWidget.mListAnchors[4].mTarget != null) {
            DependencyNode target10 = getTarget(this.mWidget.mListAnchors[4]);
            if (target10 != null) {
                addTarget(this.baseline, target10, 0);
                addTarget(this.start, this.baseline, -1, this.mBaselineDimension);
                addTarget(this.end, this.start, 1, this.mDimension);
            }
        } else if (!(this.mWidget instanceof Helper) && this.mWidget.getParent() != null) {
            addTarget(this.start, this.mWidget.getParent().mVerticalRun.start, this.mWidget.getY());
            addTarget(this.end, this.start, 1, this.mDimension);
            if (this.mWidget.hasBaseline()) {
                addTarget(this.baseline, this.start, 1, this.mBaselineDimension);
            }
            if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.mWidget.getDimensionRatio() > 0.0f && this.mWidget.mHorizontalRun.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mWidget.mHorizontalRun.mDimension.mDependencies.add(this.mDimension);
                this.mDimension.mTargets.add(this.mWidget.mHorizontalRun.mDimension);
                this.mDimension.updateDelegate = this;
            }
        }
        if (this.mDimension.mTargets.size() == 0) {
            this.mDimension.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved) {
            this.mWidget.setY(this.start.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.mRunGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.mDimension.clear();
        this.mResolved = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.mResolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.mDimension.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        return this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.mWidget.mMatchConstraintDefaultHeight == 0;
    }

    public String toString() {
        return "VerticalRun " + this.mWidget.getDebugName();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        switch (this.mRunType) {
            case START:
                updateRunStart(dependency);
                break;
            case END:
                updateRunEnd(dependency);
                break;
            case CENTER:
                updateRunCenter(dependency, this.mWidget.mTop, this.mWidget.mBottom, 1);
                return;
        }
        if (this.mDimension.readyToSolve && !this.mDimension.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            switch (this.mWidget.mMatchConstraintDefaultHeight) {
                case 2:
                    ConstraintWidget parent = this.mWidget.getParent();
                    if (parent != null && parent.mVerticalRun.mDimension.resolved) {
                        this.mDimension.resolve((int) ((parent.mVerticalRun.mDimension.value * this.mWidget.mMatchConstraintPercentHeight) + 0.5f));
                        break;
                    }
                    break;
                case 3:
                    if (this.mWidget.mHorizontalRun.mDimension.resolved) {
                        int i = 0;
                        switch (this.mWidget.getDimensionRatioSide()) {
                            case -1:
                                i = (int) ((this.mWidget.mHorizontalRun.mDimension.value / this.mWidget.getDimensionRatio()) + 0.5f);
                                break;
                            case 0:
                                i = (int) ((this.mWidget.mHorizontalRun.mDimension.value * this.mWidget.getDimensionRatio()) + 0.5f);
                                break;
                            case 1:
                                i = (int) ((this.mWidget.mHorizontalRun.mDimension.value / this.mWidget.getDimensionRatio()) + 0.5f);
                                break;
                        }
                        this.mDimension.resolve(i);
                        break;
                    }
                    break;
            }
        }
        if (this.start.readyToSolve && this.end.readyToSolve) {
            if (this.start.resolved && this.end.resolved && this.mDimension.resolved) {
                return;
            }
            if (!this.mDimension.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.mWidget.mMatchConstraintDefaultWidth == 0 && !this.mWidget.isInVerticalChain()) {
                DependencyNode dependencyNode = this.start.mTargets.get(0);
                DependencyNode dependencyNode2 = this.end.mTargets.get(0);
                int i2 = dependencyNode.value + this.start.mMargin;
                int i3 = dependencyNode2.value + this.end.mMargin;
                this.start.resolve(i2);
                this.end.resolve(i3);
                this.mDimension.resolve(i3 - i2);
                return;
            }
            if (!this.mDimension.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.mTargets.size() > 0 && this.end.mTargets.size() > 0) {
                int i4 = (this.end.mTargets.get(0).value + this.end.mMargin) - (this.start.mTargets.get(0).value + this.start.mMargin);
                if (i4 < this.mDimension.wrapValue) {
                    this.mDimension.resolve(i4);
                } else {
                    this.mDimension.resolve(this.mDimension.wrapValue);
                }
            }
            if (this.mDimension.resolved && this.start.mTargets.size() > 0 && this.end.mTargets.size() > 0) {
                DependencyNode dependencyNode3 = this.start.mTargets.get(0);
                DependencyNode dependencyNode4 = this.end.mTargets.get(0);
                int i5 = dependencyNode3.value + this.start.mMargin;
                int i6 = dependencyNode4.value + this.end.mMargin;
                float verticalBiasPercent = this.mWidget.getVerticalBiasPercent();
                if (dependencyNode3 == dependencyNode4) {
                    i5 = dependencyNode3.value;
                    i6 = dependencyNode4.value;
                    verticalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (i5 + 0.5f + (((i6 - i5) - this.mDimension.value) * verticalBiasPercent)));
                this.end.resolve(this.start.value + this.mDimension.value);
            }
        }
    }
}
