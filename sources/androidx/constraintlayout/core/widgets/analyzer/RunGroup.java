package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int mDirection;
    WidgetRun mFirstRun;
    int mGroupIndex;
    WidgetRun mLastRun;
    public int position = 0;
    public boolean dual = false;
    ArrayList<WidgetRun> mRuns = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunGroup(WidgetRun widgetRun, int i) {
        this.mFirstRun = null;
        this.mLastRun = null;
        this.mGroupIndex = 0;
        this.mGroupIndex = index;
        index++;
        this.mFirstRun = widgetRun;
        this.mLastRun = widgetRun;
        this.mDirection = i;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i) {
        if (!widgetRun.mWidget.isTerminalWidget[i]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.mDependencies) {
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode = (DependencyNode) dependency;
                if (dependencyNode.mRun != widgetRun && dependencyNode == dependencyNode.mRun.start) {
                    if (widgetRun instanceof ChainRun) {
                        Iterator<WidgetRun> it = ((ChainRun) widgetRun).mWidgets.iterator();
                        while (it.hasNext()) {
                            defineTerminalWidget(it.next(), i);
                        }
                    } else if (!(widgetRun instanceof HelperReferences)) {
                        widgetRun.mWidget.isTerminalWidget[i] = false;
                    }
                    defineTerminalWidget(dependencyNode.mRun, i);
                }
            }
        }
        for (Dependency dependency2 : widgetRun.end.mDependencies) {
            if (dependency2 instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency2;
                if (dependencyNode2.mRun != widgetRun && dependencyNode2 == dependencyNode2.mRun.start) {
                    if (widgetRun instanceof ChainRun) {
                        Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).mWidgets.iterator();
                        while (it2.hasNext()) {
                            defineTerminalWidget(it2.next(), i);
                        }
                    } else if (!(widgetRun instanceof HelperReferences)) {
                        widgetRun.mWidget.isTerminalWidget[i] = false;
                    }
                    defineTerminalWidget(dependencyNode2.mRun, i);
                }
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        long j2 = j;
        int size = dependencyNode.mDependencies.size();
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.mDependencies.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j2 = Math.min(j2, traverseEnd(dependencyNode2, dependencyNode2.mMargin + j));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j2;
        }
        long wrapDimension = widgetRun.getWrapDimension();
        return Math.min(Math.min(j2, traverseEnd(widgetRun.start, j - wrapDimension)), (j - wrapDimension) - widgetRun.start.mMargin);
    }

    private long traverseStart(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        long j2 = j;
        int size = dependencyNode.mDependencies.size();
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.mDependencies.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j2 = Math.max(j2, traverseStart(dependencyNode2, dependencyNode2.mMargin + j));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j2;
        }
        long wrapDimension = widgetRun.getWrapDimension();
        return Math.max(Math.max(j2, traverseStart(widgetRun.end, j + wrapDimension)), (j + wrapDimension) - widgetRun.end.mMargin);
    }

    public void add(WidgetRun widgetRun) {
        this.mRuns.add(widgetRun);
        this.mLastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        if (this.mFirstRun instanceof ChainRun) {
            if (((ChainRun) this.mFirstRun).orientation != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(this.mFirstRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(this.mFirstRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = i == 0 ? constraintWidgetContainer.mHorizontalRun.start : constraintWidgetContainer.mVerticalRun.start;
        DependencyNode dependencyNode2 = i == 0 ? constraintWidgetContainer.mHorizontalRun.end : constraintWidgetContainer.mVerticalRun.end;
        boolean contains = this.mFirstRun.start.mTargets.contains(dependencyNode);
        boolean contains2 = this.mFirstRun.end.mTargets.contains(dependencyNode2);
        long wrapDimension = this.mFirstRun.getWrapDimension();
        if (!contains || !contains2) {
            if (contains) {
                return Math.max(traverseStart(this.mFirstRun.start, this.mFirstRun.start.mMargin), this.mFirstRun.start.mMargin + wrapDimension);
            }
            if (contains2) {
                return Math.max(-traverseEnd(this.mFirstRun.end, this.mFirstRun.end.mMargin), (-this.mFirstRun.end.mMargin) + wrapDimension);
            }
            return (this.mFirstRun.start.mMargin + this.mFirstRun.getWrapDimension()) - this.mFirstRun.end.mMargin;
        }
        long traverseStart = traverseStart(this.mFirstRun.start, 0L);
        long traverseEnd = traverseEnd(this.mFirstRun.end, 0L);
        long j = traverseStart - wrapDimension;
        if (j >= (-this.mFirstRun.end.mMargin)) {
            j += this.mFirstRun.end.mMargin;
        }
        long j2 = ((-traverseEnd) - wrapDimension) - this.mFirstRun.start.mMargin;
        if (j2 >= this.mFirstRun.start.mMargin) {
            j2 -= this.mFirstRun.start.mMargin;
        }
        long j3 = this.mFirstRun.mWidget.getBiasPercent(i) > 0.0f ? (((float) j2) / r3) + (((float) j) / (1.0f - r3)) : 0L;
        return (this.mFirstRun.start.mMargin + ((((((float) j3) * r3) + 0.5f) + wrapDimension) + ((((float) j3) * (1.0f - r3)) + 0.5f))) - this.mFirstRun.end.mMargin;
    }

    public void defineTerminalWidgets(boolean z, boolean z2) {
        if (z && (this.mFirstRun instanceof HorizontalWidgetRun)) {
            defineTerminalWidget(this.mFirstRun, 0);
        }
        if (z2 && (this.mFirstRun instanceof VerticalWidgetRun)) {
            defineTerminalWidget(this.mFirstRun, 1);
        }
    }
}
