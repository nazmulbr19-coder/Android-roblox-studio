package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DependencyGraph {
    private static final boolean DEBUG = false;
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer mContainer;
    private ConstraintWidgetContainer mWidgetcontainer;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private ArrayList<WidgetRun> mRuns = new ArrayList<>();
    private ArrayList<RunGroup> mRunGroups = new ArrayList<>();
    private BasicMeasure.Measurer mMeasurer = null;
    private BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    ArrayList<RunGroup> mGroups = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mWidgetcontainer = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        RunGroup runGroup2;
        int i3;
        DependencyNode dependencyNode3;
        ArrayList<RunGroup> arrayList2;
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun.mRunGroup != null || widgetRun == this.mWidgetcontainer.mHorizontalRun) {
            return;
        }
        if (widgetRun == this.mWidgetcontainer.mVerticalRun) {
            return;
        }
        if (runGroup == null) {
            RunGroup runGroup3 = new RunGroup(widgetRun, i2);
            arrayList.add(runGroup3);
            runGroup2 = runGroup3;
        } else {
            runGroup2 = runGroup;
        }
        widgetRun.mRunGroup = runGroup2;
        runGroup2.add(widgetRun);
        for (Dependency dependency : widgetRun.start.mDependencies) {
            if (dependency instanceof DependencyNode) {
                i3 = i;
                dependencyNode3 = dependencyNode2;
                arrayList2 = arrayList;
                applyGroup((DependencyNode) dependency, i3, 0, dependencyNode3, arrayList2, runGroup2);
            } else {
                i3 = i;
                dependencyNode3 = dependencyNode2;
                arrayList2 = arrayList;
            }
            i = i3;
            dependencyNode2 = dependencyNode3;
            arrayList = arrayList2;
        }
        int i4 = i;
        DependencyNode dependencyNode4 = dependencyNode2;
        ArrayList<RunGroup> arrayList3 = arrayList;
        for (Dependency dependency2 : widgetRun.end.mDependencies) {
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i4, 1, dependencyNode4, arrayList3, runGroup2);
            }
        }
        if (i4 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.mDependencies) {
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i4, 2, dependencyNode4, arrayList3, runGroup2);
                }
            }
        }
        for (DependencyNode dependencyNode5 : widgetRun.start.mTargets) {
            if (dependencyNode5 == dependencyNode4) {
                runGroup2.dual = true;
            }
            applyGroup(dependencyNode5, i4, 0, dependencyNode4, arrayList3, runGroup2);
        }
        for (DependencyNode dependencyNode6 : widgetRun.end.mTargets) {
            if (dependencyNode6 == dependencyNode4) {
                runGroup2.dual = true;
            }
            applyGroup(dependencyNode6, i4, 1, dependencyNode4, arrayList3, runGroup2);
        }
        if (i4 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
            Iterator<DependencyNode> it = ((VerticalWidgetRun) widgetRun).baseline.mTargets.iterator();
            while (it.hasNext()) {
                applyGroup(it.next(), i4, 2, dependencyNode4, arrayList3, runGroup2);
            }
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        int i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = next.mListDimensionBehaviors[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = next.mListDimensionBehaviors[1];
            if (next.getVisibility() == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.getDimensionRatio() > 0.0f) {
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        if (next.mMatchConstraintDefaultWidth == 0) {
                            next.mMatchConstraintDefaultWidth = 3;
                        }
                        if (next.mMatchConstraintDefaultHeight == 0) {
                            next.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) ? ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : dimensionBehaviour5;
                next.mHorizontalRun.mDimensionBehavior = dimensionBehaviour4;
                next.mHorizontalRun.matchConstraintsType = next.mMatchConstraintDefaultWidth;
                next.mVerticalRun.mDimensionBehavior = dimensionBehaviour6;
                next.mVerticalRun.matchConstraintsType = next.mMatchConstraintDefaultHeight;
                if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    if (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED) {
                        dimensionBehaviour = dimensionBehaviour4;
                    } else if (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        dimensionBehaviour = dimensionBehaviour4;
                    }
                    int width = next.getWidth();
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        int width2 = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                        i = width2;
                    } else {
                        dimensionBehaviour2 = dimensionBehaviour;
                        i = width;
                    }
                    int height = next.getHeight();
                    if (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        height = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    measure(next, dimensionBehaviour2, i, dimensionBehaviour6, height);
                    next.mHorizontalRun.mDimension.resolve(next.getWidth());
                    next.mVerticalRun.mDimension.resolve(next.getHeight());
                    next.measured = true;
                }
                if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                    if (next.mMatchConstraintDefaultWidth == 3) {
                        if (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                        }
                        int height2 = next.getHeight();
                        measure(next, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((height2 * next.mDimensionRatio) + 0.5f), ConstraintWidget.DimensionBehaviour.FIXED, height2);
                        next.mHorizontalRun.mDimension.resolve(next.getWidth());
                        next.mVerticalRun.mDimension.resolve(next.getHeight());
                        next.measured = true;
                    } else if (next.mMatchConstraintDefaultWidth == 1) {
                        measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour6, 0);
                        next.mHorizontalRun.mDimension.wrapValue = next.getWidth();
                    } else {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviour6;
                        if (next.mMatchConstraintDefaultWidth == 2) {
                            if (constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                measure(next, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((constraintWidgetContainer.getWidth() * next.mMatchConstraintPercentWidth) + 0.5f), dimensionBehaviour7, next.getHeight());
                                next.mHorizontalRun.mDimension.resolve(next.getWidth());
                                next.mVerticalRun.mDimension.resolve(next.getHeight());
                                next.measured = true;
                            } else {
                                dimensionBehaviour6 = dimensionBehaviour7;
                            }
                        } else if (next.mListAnchors[0].mTarget == null || next.mListAnchors[1].mTarget == null) {
                            measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour7, 0);
                            next.mHorizontalRun.mDimension.resolve(next.getWidth());
                            next.mVerticalRun.mDimension.resolve(next.getHeight());
                            next.measured = true;
                        } else {
                            dimensionBehaviour6 = dimensionBehaviour7;
                        }
                    }
                }
                if (dimensionBehaviour6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    dimensionBehaviour3 = dimensionBehaviour4;
                } else if (dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.FIXED) {
                    dimensionBehaviour3 = dimensionBehaviour4;
                } else if (next.mMatchConstraintDefaultHeight == 3) {
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                    }
                    int width3 = next.getWidth();
                    float f = next.mDimensionRatio;
                    if (next.getDimensionRatioSide() == -1) {
                        f = 1.0f / f;
                    }
                    measure(next, ConstraintWidget.DimensionBehaviour.FIXED, width3, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((width3 * f) + 0.5f));
                    next.mHorizontalRun.mDimension.resolve(next.getWidth());
                    next.mVerticalRun.mDimension.resolve(next.getHeight());
                    next.measured = true;
                } else if (next.mMatchConstraintDefaultHeight == 1) {
                    measure(next, dimensionBehaviour4, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                    next.mVerticalRun.mDimension.wrapValue = next.getHeight();
                } else {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = dimensionBehaviour4;
                    if (next.mMatchConstraintDefaultHeight != 2) {
                        dimensionBehaviour3 = dimensionBehaviour8;
                        if (next.mListAnchors[2].mTarget == null || next.mListAnchors[3].mTarget == null) {
                            measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour6, 0);
                            next.mHorizontalRun.mDimension.resolve(next.getWidth());
                            next.mVerticalRun.mDimension.resolve(next.getHeight());
                            next.measured = true;
                        }
                    } else if (constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        measure(next, dimensionBehaviour8, next.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, (int) ((constraintWidgetContainer.getHeight() * next.mMatchConstraintPercentHeight) + 0.5f));
                        next.mHorizontalRun.mDimension.resolve(next.getWidth());
                        next.mVerticalRun.mDimension.resolve(next.getHeight());
                        next.measured = true;
                    } else {
                        dimensionBehaviour3 = dimensionBehaviour8;
                    }
                }
                if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (next.mMatchConstraintDefaultWidth == 1 || next.mMatchConstraintDefaultHeight == 1) {
                        measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                        next.mHorizontalRun.mDimension.wrapValue = next.getWidth();
                        next.mVerticalRun.mDimension.wrapValue = next.getHeight();
                    } else if (next.mMatchConstraintDefaultHeight == 2 && next.mMatchConstraintDefaultWidth == 2 && constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED && constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
                        measure(next, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((constraintWidgetContainer.getWidth() * next.mMatchConstraintPercentWidth) + 0.5f), ConstraintWidget.DimensionBehaviour.FIXED, (int) ((constraintWidgetContainer.getHeight() * next.mMatchConstraintPercentHeight) + 0.5f));
                        next.mHorizontalRun.mDimension.resolve(next.getWidth());
                        next.mVerticalRun.mDimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                }
            }
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        int size = this.mGroups.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j = Math.max(j, this.mGroups.get(i2).computeWrapSize(constraintWidgetContainer, i));
        }
        return (int) j;
    }

    private void displayGraph() {
        String str = "digraph {\n";
        Iterator<WidgetRun> it = this.mRuns.iterator();
        while (it.hasNext()) {
            str = generateDisplayGraph(it.next(), str);
        }
        System.out.println("content:<<\n" + (str + "\n}\n") + "\n>>");
    }

    private void findGroup(WidgetRun widgetRun, int i, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.start.mDependencies) {
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.mDependencies) {
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i, 1, widgetRun.start, arrayList, null);
            }
        }
        int i2 = i;
        if (i2 == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.mDependencies) {
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i2, 2, null, arrayList, null);
                }
                i2 = i;
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun chainRun, String str) {
        int i = chainRun.orientation;
        StringBuilder sb = new StringBuilder("subgraph ");
        sb.append("cluster_");
        sb.append(chainRun.mWidget.getDebugName());
        if (i == 0) {
            sb.append("_h");
        } else {
            sb.append("_v");
        }
        sb.append(" {\n");
        String str2 = "";
        Iterator<WidgetRun> it = chainRun.mWidgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            sb.append(next.mWidget.getDebugName());
            if (i == 0) {
                sb.append("_HORIZONTAL");
            } else {
                sb.append("_VERTICAL");
            }
            sb.append(";\n");
            str2 = generateDisplayGraph(next, str2);
        }
        sb.append("}\n");
        return str + str2 + ((Object) sb);
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String str) {
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        StringBuilder sb = new StringBuilder(str);
        if (!(widgetRun instanceof HelperReferences) && dependencyNode.mDependencies.isEmpty() && dependencyNode2.mDependencies.isEmpty() && dependencyNode.mTargets.isEmpty() && dependencyNode2.mTargets.isEmpty()) {
            return str;
        }
        sb.append(nodeDefinition(widgetRun));
        boolean isCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
        String generateDisplayNode = generateDisplayNode(dependencyNode2, isCenteredConnection, generateDisplayNode(dependencyNode, isCenteredConnection, str));
        if (widgetRun instanceof VerticalWidgetRun) {
            generateDisplayNode = generateDisplayNode(((VerticalWidgetRun) widgetRun).baseline, isCenteredConnection, generateDisplayNode);
        }
        if ((widgetRun instanceof HorizontalWidgetRun) || ((widgetRun instanceof ChainRun) && ((ChainRun) widgetRun).orientation == 0)) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = widgetRun.mWidget.getHorizontalDimensionBehaviour();
            if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.mTargets.isEmpty() && dependencyNode2.mTargets.isEmpty()) {
                    sb.append("\n");
                    sb.append(dependencyNode2.name());
                    sb.append(" -> ");
                    sb.append(dependencyNode.name());
                    sb.append("\n");
                } else if (dependencyNode.mTargets.isEmpty() && !dependencyNode2.mTargets.isEmpty()) {
                    sb.append("\n");
                    sb.append(dependencyNode.name());
                    sb.append(" -> ");
                    sb.append(dependencyNode2.name());
                    sb.append("\n");
                }
            } else if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.mWidget.getDimensionRatio() > 0.0f) {
                sb.append("\n");
                sb.append(widgetRun.mWidget.getDebugName());
                sb.append("_HORIZONTAL -> ");
                sb.append(widgetRun.mWidget.getDebugName());
                sb.append("_VERTICAL;\n");
            }
        } else if ((widgetRun instanceof VerticalWidgetRun) || ((widgetRun instanceof ChainRun) && ((ChainRun) widgetRun).orientation == 1)) {
            ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = widgetRun.mWidget.getVerticalDimensionBehaviour();
            if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.mTargets.isEmpty() && dependencyNode2.mTargets.isEmpty()) {
                    sb.append("\n");
                    sb.append(dependencyNode2.name());
                    sb.append(" -> ");
                    sb.append(dependencyNode.name());
                    sb.append("\n");
                } else if (dependencyNode.mTargets.isEmpty() && !dependencyNode2.mTargets.isEmpty()) {
                    sb.append("\n");
                    sb.append(dependencyNode.name());
                    sb.append(" -> ");
                    sb.append(dependencyNode2.name());
                    sb.append("\n");
                }
            } else if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.mWidget.getDimensionRatio() > 0.0f) {
                sb.append("\n");
                sb.append(widgetRun.mWidget.getDebugName());
                sb.append("_VERTICAL -> ");
                sb.append(widgetRun.mWidget.getDebugName());
                sb.append("_HORIZONTAL;\n");
            }
        }
        return widgetRun instanceof ChainRun ? generateChainDisplayGraph((ChainRun) widgetRun, generateDisplayNode) : sb.toString();
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean z, String str) {
        StringBuilder sb = new StringBuilder(str);
        Iterator<DependencyNode> it = dependencyNode.mTargets.iterator();
        while (it.hasNext()) {
            String str2 = ("\n" + dependencyNode.name()) + " -> " + it.next().name();
            if (dependencyNode.mMargin > 0 || z || (dependencyNode.mRun instanceof HelperReferences)) {
                String str3 = str2 + "[";
                if (dependencyNode.mMargin > 0) {
                    str3 = str3 + "label=\"" + dependencyNode.mMargin + "\"";
                    if (z) {
                        str3 = str3 + ",";
                    }
                }
                if (z) {
                    str3 = str3 + " style=dashed ";
                }
                if (dependencyNode.mRun instanceof HelperReferences) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            sb.append(str2 + "\n");
        }
        return sb.toString();
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        int i = 0;
        int i2 = 0;
        Iterator<DependencyNode> it = dependencyNode.mTargets.iterator();
        while (it.hasNext()) {
            if (it.next() != dependencyNode2) {
                i++;
            }
        }
        Iterator<DependencyNode> it2 = dependencyNode2.mTargets.iterator();
        while (it2.hasNext()) {
            if (it2.next() != dependencyNode) {
                i2++;
            }
        }
        return i > 0 && i2 > 0;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        this.mMeasure.horizontalBehavior = dimensionBehaviour;
        this.mMeasure.verticalBehavior = dimensionBehaviour2;
        this.mMeasure.horizontalDimension = i;
        this.mMeasure.verticalDimension = i2;
        this.mMeasurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun widgetRun) {
        boolean z = widgetRun instanceof VerticalWidgetRun;
        String debugName = widgetRun.mWidget.getDebugName();
        StringBuilder sb = new StringBuilder(debugName);
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = !z ? widgetRun.mWidget.getHorizontalDimensionBehaviour() : widgetRun.mWidget.getVerticalDimensionBehaviour();
        RunGroup runGroup = widgetRun.mRunGroup;
        if (z) {
            sb.append("_VERTICAL");
        } else {
            sb.append("_HORIZONTAL");
        }
        sb.append(" [shape=none, label=<");
        sb.append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
        sb.append("  <TR>");
        if (z) {
            sb.append("    <TD ");
            if (widgetRun.start.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
        } else {
            sb.append("    <TD ");
            if (widgetRun.start.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
        }
        sb.append("    <TD BORDER=\"1\" ");
        if (widgetRun.mDimension.resolved && !widgetRun.mWidget.measured) {
            sb.append(" BGCOLOR=\"green\" ");
        } else if (widgetRun.mDimension.resolved) {
            sb.append(" BGCOLOR=\"lightgray\" ");
        } else if (widgetRun.mWidget.measured) {
            sb.append(" BGCOLOR=\"yellow\" ");
        }
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            sb.append("style=\"dashed\"");
        }
        sb.append(">");
        sb.append(debugName);
        if (runGroup != null) {
            sb.append(" [");
            sb.append(runGroup.mGroupIndex + 1);
            sb.append("/");
            sb.append(RunGroup.index);
            sb.append("]");
        }
        sb.append(" </TD>");
        if (z) {
            sb.append("    <TD ");
            if (((VerticalWidgetRun) widgetRun).baseline.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
            sb.append("    <TD ");
            if (widgetRun.end.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
        } else {
            sb.append("    <TD ");
            if (widgetRun.end.resolved) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
        }
        sb.append("  </TR></TABLE>");
        sb.append(">];\n");
        return sb.toString();
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.mWidgetcontainer.mHorizontalRun, 0, this.mGroups);
        findGroup(this.mWidgetcontainer.mVerticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.mContainer.mHorizontalRun.clear();
        this.mContainer.mVerticalRun.clear();
        arrayList.add(this.mContainer.mHorizontalRun);
        arrayList.add(this.mContainer.mVerticalRun);
        HashSet hashSet = null;
        Iterator<ConstraintWidget> it = this.mContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.mHorizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.mVerticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.mWidget != this.mContainer) {
                next2.apply();
            }
        }
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.mNeedBuildGraph) {
            buildGraph();
            boolean z = false;
            Iterator<ConstraintWidget> it = this.mWidgetcontainer.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.isTerminalWidget[0] = true;
                next.isTerminalWidget[1] = true;
                if (next instanceof Barrier) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            Iterator<RunGroup> it2 = this.mGroups.iterator();
            while (it2.hasNext()) {
                it2.next().defineTerminalWidgets(dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
    }

    public boolean directMeasure(boolean z) {
        boolean z2 = z & true;
        if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
            Iterator<ConstraintWidget> it = this.mWidgetcontainer.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                next.mHorizontalRun.reset();
                next.mVerticalRun.reset();
            }
            this.mWidgetcontainer.ensureWidgetRuns();
            this.mWidgetcontainer.measured = false;
            this.mWidgetcontainer.mHorizontalRun.reset();
            this.mWidgetcontainer.mVerticalRun.reset();
            this.mNeedRedoMeasures = false;
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.mWidgetcontainer.setX(0);
        this.mWidgetcontainer.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mWidgetcontainer.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mWidgetcontainer.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph) {
            buildGraph();
        }
        int x = this.mWidgetcontainer.getX();
        int y = this.mWidgetcontainer.getY();
        this.mWidgetcontainer.mHorizontalRun.start.resolve(x);
        this.mWidgetcontainer.mVerticalRun.start.resolve(y);
        measureWidgets();
        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            if (z2) {
                Iterator<WidgetRun> it2 = this.mRuns.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().supportsWrapComputation()) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.mWidgetcontainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                this.mWidgetcontainer.setWidth(computeWrap(this.mWidgetcontainer, 0));
                this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(this.mWidgetcontainer.getWidth());
            }
            if (z2 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.mWidgetcontainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                this.mWidgetcontainer.setHeight(computeWrap(this.mWidgetcontainer, 1));
                this.mWidgetcontainer.mVerticalRun.mDimension.resolve(this.mWidgetcontainer.getHeight());
            }
        }
        boolean z3 = false;
        if (this.mWidgetcontainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.mWidgetcontainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int width = this.mWidgetcontainer.getWidth() + x;
            this.mWidgetcontainer.mHorizontalRun.end.resolve(width);
            this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(width - x);
            measureWidgets();
            if (this.mWidgetcontainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.mWidgetcontainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = this.mWidgetcontainer.getHeight() + y;
                this.mWidgetcontainer.mVerticalRun.end.resolve(height);
                this.mWidgetcontainer.mVerticalRun.mDimension.resolve(height - y);
            }
            measureWidgets();
            z3 = true;
        }
        Iterator<WidgetRun> it3 = this.mRuns.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.mWidget != this.mWidgetcontainer || next2.mResolved) {
                next2.applyToWidget();
            }
        }
        boolean z4 = true;
        Iterator<WidgetRun> it4 = this.mRuns.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            WidgetRun next3 = it4.next();
            if (z3 || next3.mWidget != this.mWidgetcontainer) {
                if (!next3.start.resolved) {
                    z4 = false;
                    break;
                }
                if (!next3.end.resolved && !(next3 instanceof GuidelineReference)) {
                    z4 = false;
                    break;
                }
                if (!next3.mDimension.resolved && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)) {
                    z4 = false;
                    break;
                }
            }
        }
        this.mWidgetcontainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mWidgetcontainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z4;
    }

    public boolean directMeasureSetup(boolean z) {
        if (this.mNeedBuildGraph) {
            Iterator<ConstraintWidget> it = this.mWidgetcontainer.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                next.mHorizontalRun.mDimension.resolved = false;
                next.mHorizontalRun.mResolved = false;
                next.mHorizontalRun.reset();
                next.mVerticalRun.mDimension.resolved = false;
                next.mVerticalRun.mResolved = false;
                next.mVerticalRun.reset();
            }
            this.mWidgetcontainer.ensureWidgetRuns();
            this.mWidgetcontainer.measured = false;
            this.mWidgetcontainer.mHorizontalRun.mDimension.resolved = false;
            this.mWidgetcontainer.mHorizontalRun.mResolved = false;
            this.mWidgetcontainer.mHorizontalRun.reset();
            this.mWidgetcontainer.mVerticalRun.mDimension.resolved = false;
            this.mWidgetcontainer.mVerticalRun.mResolved = false;
            this.mWidgetcontainer.mVerticalRun.reset();
            buildGraph();
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.mWidgetcontainer.setX(0);
        this.mWidgetcontainer.setY(0);
        this.mWidgetcontainer.mHorizontalRun.start.resolve(0);
        this.mWidgetcontainer.mVerticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        boolean z2 = z & true;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mWidgetcontainer.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mWidgetcontainer.getDimensionBehaviour(1);
        int x = this.mWidgetcontainer.getX();
        int y = this.mWidgetcontainer.getY();
        if (z2 && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
            Iterator<WidgetRun> it = this.mRuns.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.orientation == i && !next.supportsWrapComputation()) {
                    z2 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z2 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.mWidgetcontainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    this.mWidgetcontainer.setWidth(computeWrap(this.mWidgetcontainer, 0));
                    this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(this.mWidgetcontainer.getWidth());
                }
            } else if (z2 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.mWidgetcontainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                this.mWidgetcontainer.setHeight(computeWrap(this.mWidgetcontainer, 1));
                this.mWidgetcontainer.mVerticalRun.mDimension.resolve(this.mWidgetcontainer.getHeight());
            }
        }
        boolean z3 = false;
        if (i == 0) {
            if (this.mWidgetcontainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.mWidgetcontainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int width = this.mWidgetcontainer.getWidth() + x;
                this.mWidgetcontainer.mHorizontalRun.end.resolve(width);
                this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(width - x);
                z3 = true;
            }
        } else if (this.mWidgetcontainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.mWidgetcontainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int height = this.mWidgetcontainer.getHeight() + y;
            this.mWidgetcontainer.mVerticalRun.end.resolve(height);
            this.mWidgetcontainer.mVerticalRun.mDimension.resolve(height - y);
            z3 = true;
        }
        measureWidgets();
        Iterator<WidgetRun> it2 = this.mRuns.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.orientation == i && (next2.mWidget != this.mWidgetcontainer || next2.mResolved)) {
                next2.applyToWidget();
            }
        }
        boolean z4 = true;
        Iterator<WidgetRun> it3 = this.mRuns.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            WidgetRun next3 = it3.next();
            if (next3.orientation == i && (z3 || next3.mWidget != this.mWidgetcontainer)) {
                if (!next3.start.resolved) {
                    z4 = false;
                    break;
                }
                if (!next3.end.resolved) {
                    z4 = false;
                    break;
                }
                if (!(next3 instanceof ChainRun) && !next3.mDimension.resolved) {
                    z4 = false;
                    break;
                }
            }
        }
        this.mWidgetcontainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mWidgetcontainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z4;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        DependencyGraph dependencyGraph = this;
        Iterator<ConstraintWidget> it = dependencyGraph.mWidgetcontainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = next.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = next.mListDimensionBehaviors[1];
                int i = next.mMatchConstraintDefaultWidth;
                int i2 = next.mMatchConstraintDefaultHeight;
                boolean z2 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i == 1);
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                boolean z3 = z;
                boolean z4 = next.mHorizontalRun.mDimension.resolved;
                boolean z5 = next.mVerticalRun.mDimension.resolved;
                if (z4 && z5) {
                    dependencyGraph.measure(next, ConstraintWidget.DimensionBehaviour.FIXED, next.mHorizontalRun.mDimension.value, ConstraintWidget.DimensionBehaviour.FIXED, next.mVerticalRun.mDimension.value);
                    next.measured = true;
                } else if (z4 && z3) {
                    measure(next, ConstraintWidget.DimensionBehaviour.FIXED, next.mHorizontalRun.mDimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.mVerticalRun.mDimension.value);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.mVerticalRun.mDimension.wrapValue = next.getHeight();
                    } else {
                        next.mVerticalRun.mDimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z5 && z2) {
                    measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.mHorizontalRun.mDimension.value, ConstraintWidget.DimensionBehaviour.FIXED, next.mVerticalRun.mDimension.value);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.mHorizontalRun.mDimension.wrapValue = next.getWidth();
                    } else {
                        next.mHorizontalRun.mDimension.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && next.mVerticalRun.mBaselineDimension != null) {
                    next.mVerticalRun.mBaselineDimension.resolve(next.getBaselineDistance());
                }
                dependencyGraph = this;
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }
}
