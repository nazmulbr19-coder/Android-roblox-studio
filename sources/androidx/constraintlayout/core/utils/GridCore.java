package androidx.constraintlayout.core.utils;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class GridCore extends VirtualLayout {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int SPANS_RESPECT_WIDGET_ORDER = 2;
    public static final int SUB_GRID_BY_COL_ROW = 1;
    public static final int VERTICAL = 1;
    private ConstraintWidget[] mBoxWidgets;
    private String mColumnWeights;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    ConstraintWidgetContainer mContainer;
    private int mFlags;
    private float mHorizontalGaps;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private String mRowWeights;
    private int mRows;
    private int mRowsSet;
    private String mSkips;
    private int[][] mSpanMatrix;
    private String mSpans;
    private float mVerticalGaps;
    private boolean mExtraSpaceHandled = false;
    private int mNextAvailableIndex = 0;
    Set<String> mSpanIds = new HashSet();
    private int mSpanIndex = 0;

    public GridCore() {
        updateActualRowsAndColumns();
        initMatrices();
    }

    public GridCore(int i, int i2) {
        this.mRowsSet = i;
        this.mColumnsSet = i2;
        if (i > 50) {
            this.mRowsSet = 3;
        }
        if (i2 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initMatrices();
    }

    private void addConstraints() {
        setBoxWidgetVerticalChains();
        setBoxWidgetHorizontalChains();
        arrangeWidgets();
    }

    private void arrangeWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            if (!this.mSpanIds.contains(this.mWidgets[i].stringId)) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return;
                }
                if (!isSpansRespectWidgetOrder() || this.mSpanMatrix == null || this.mSpanIndex >= this.mSpanMatrix.length || this.mSpanMatrix[this.mSpanIndex][0] != nextPosition) {
                    connectWidget(this.mWidgets[i], rowByIndex, colByIndex, 1, 1);
                } else {
                    this.mPositionMatrix[rowByIndex][colByIndex] = true;
                    if (invalidatePositions(rowByIndex, colByIndex, this.mSpanMatrix[this.mSpanIndex][1], this.mSpanMatrix[this.mSpanIndex][2])) {
                        connectWidget(this.mWidgets[i], rowByIndex, colByIndex, this.mSpanMatrix[this.mSpanIndex][1], this.mSpanMatrix[this.mSpanIndex][2]);
                        this.mSpanIndex++;
                    }
                }
            }
        }
    }

    private void clearHorizontalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setHorizontalWeight(-1.0f);
        constraintWidget.mLeft.reset();
        constraintWidget.mRight.reset();
    }

    private void clearVerticalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setVerticalWeight(-1.0f);
        constraintWidget.mTop.reset();
        constraintWidget.mBottom.reset();
        constraintWidget.mBaseline.reset();
    }

    private void connectWidget(ConstraintWidget constraintWidget, int i, int i2, int i3, int i4) {
        constraintWidget.mLeft.connect(this.mBoxWidgets[i2].mLeft, 0);
        constraintWidget.mTop.connect(this.mBoxWidgets[i].mTop, 0);
        constraintWidget.mRight.connect(this.mBoxWidgets[(i2 + i4) - 1].mRight, 0);
        constraintWidget.mBottom.connect(this.mBoxWidgets[(i + i3) - 1].mBottom, 0);
    }

    private void createBoxes() {
        int max = Math.max(this.mRows, this.mColumns);
        if (this.mBoxWidgets == null) {
            this.mBoxWidgets = new ConstraintWidget[max];
            for (int i = 0; i < this.mBoxWidgets.length; i++) {
                this.mBoxWidgets[i] = makeNewWidget();
            }
            return;
        }
        if (max != this.mBoxWidgets.length) {
            ConstraintWidget[] constraintWidgetArr = new ConstraintWidget[max];
            for (int i2 = 0; i2 < max; i2++) {
                if (i2 < this.mBoxWidgets.length) {
                    constraintWidgetArr[i2] = this.mBoxWidgets[i2];
                } else {
                    constraintWidgetArr[i2] = makeNewWidget();
                }
            }
            for (int i3 = max; i3 < this.mBoxWidgets.length; i3++) {
                this.mContainer.remove(this.mBoxWidgets[i3]);
            }
            this.mBoxWidgets = constraintWidgetArr;
        }
    }

    private void fillConstraintMatrix(boolean z) {
        int[][] parseSpans;
        int[][] parseSpans2;
        if (z) {
            for (int i = 0; i < this.mPositionMatrix.length; i++) {
                for (int i2 = 0; i2 < this.mPositionMatrix[0].length; i2++) {
                    this.mPositionMatrix[i][i2] = true;
                }
            }
            for (int i3 = 0; i3 < this.mConstraintMatrix.length; i3++) {
                for (int i4 = 0; i4 < this.mConstraintMatrix[0].length; i4++) {
                    this.mConstraintMatrix[i3][i4] = -1;
                }
            }
        }
        this.mNextAvailableIndex = 0;
        if (this.mSkips != null && !this.mSkips.trim().isEmpty() && (parseSpans2 = parseSpans(this.mSkips, false)) != null) {
            handleSkips(parseSpans2);
        }
        if (this.mSpans == null || this.mSpans.trim().isEmpty() || (parseSpans = parseSpans(this.mSpans, true)) == null) {
            return;
        }
        handleSpans(parseSpans);
    }

    private int getColByIndex(int i) {
        return this.mOrientation == 1 ? i / this.mRows : i % this.mColumns;
    }

    private int getNextPosition() {
        int i = 0;
        boolean z = false;
        while (!z) {
            if (this.mNextAvailableIndex >= this.mRows * this.mColumns) {
                return -1;
            }
            i = this.mNextAvailableIndex;
            int rowByIndex = getRowByIndex(this.mNextAvailableIndex);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            if (this.mPositionMatrix[rowByIndex][colByIndex]) {
                this.mPositionMatrix[rowByIndex][colByIndex] = false;
                z = true;
            }
            this.mNextAvailableIndex++;
        }
        return i;
    }

    private int getRowByIndex(int i) {
        return this.mOrientation == 1 ? i % this.mRows : i / this.mColumns;
    }

    private void handleSkips(int[][] iArr) {
        for (int[] iArr2 : iArr) {
            if (!invalidatePositions(getRowByIndex(iArr2[0]), getColByIndex(iArr2[0]), iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        if (isSpansRespectWidgetOrder()) {
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            int rowByIndex = getRowByIndex(iArr[i][0]);
            int colByIndex = getColByIndex(iArr[i][0]);
            if (!invalidatePositions(rowByIndex, colByIndex, iArr[i][1], iArr[i][2])) {
                return;
            }
            connectWidget(this.mWidgets[i], rowByIndex, colByIndex, iArr[i][1], iArr[i][2]);
            this.mSpanIds.add(this.mWidgets[i].stringId);
        }
    }

    private void initMatrices() {
        boolean z = false;
        if (this.mConstraintMatrix != null && this.mConstraintMatrix.length == this.mWidgetsCount && this.mPositionMatrix != null && this.mPositionMatrix.length == this.mRows && this.mPositionMatrix[0].length == this.mColumns) {
            z = true;
        }
        if (!z) {
            initVariables();
        }
        fillConstraintMatrix(z);
    }

    private void initVariables() {
        this.mPositionMatrix = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        for (boolean[] zArr : this.mPositionMatrix) {
            Arrays.fill(zArr, true);
        }
        if (this.mWidgetsCount > 0) {
            this.mConstraintMatrix = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, this.mWidgetsCount, 4);
            for (int[] iArr : this.mConstraintMatrix) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    private boolean invalidatePositions(int i, int i2, int i3, int i4) {
        for (int i5 = i; i5 < i + i3; i5++) {
            for (int i6 = i2; i6 < i2 + i4; i6++) {
                if (i5 >= this.mPositionMatrix.length || i6 >= this.mPositionMatrix[0].length || !this.mPositionMatrix[i5][i6]) {
                    return false;
                }
                this.mPositionMatrix[i5][i6] = false;
            }
        }
        return true;
    }

    private boolean isSpansRespectWidgetOrder() {
        return (this.mFlags & 2) > 0;
    }

    private boolean isSubGridByColRow() {
        return (this.mFlags & 1) > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$parseSpans$0(String str, String str2) {
        return Integer.parseInt(str.split(":")[0]) - Integer.parseInt(str2.split(":")[0]);
    }

    private ConstraintWidget makeNewWidget() {
        ConstraintWidget constraintWidget = new ConstraintWidget();
        constraintWidget.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        constraintWidget.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        constraintWidget.stringId = String.valueOf(constraintWidget.hashCode());
        return constraintWidget;
    }

    private int[][] parseSpans(String str, boolean z) {
        int i = 0;
        int i2 = 0;
        try {
            String[] split = str.split(",");
            Arrays.sort(split, new GridCore$$ExternalSyntheticLambda0());
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, split.length, 3);
            if (this.mRows == 1 || this.mColumns == 1) {
                for (int i3 = 0; i3 < split.length; i3++) {
                    String[] split2 = split[i3].trim().split(":");
                    iArr[i3][0] = Integer.parseInt(split2[0]);
                    iArr[i3][1] = 1;
                    iArr[i3][2] = 1;
                    if (this.mColumns == 1) {
                        iArr[i3][1] = Integer.parseInt(split2[1]);
                        i += iArr[i3][1];
                        if (z) {
                            i--;
                        }
                    }
                    if (this.mRows == 1) {
                        iArr[i3][2] = Integer.parseInt(split2[1]);
                        i2 += iArr[i3][2];
                        if (z) {
                            i2--;
                        }
                    }
                }
                if (i != 0 && !this.mExtraSpaceHandled) {
                    setRows(this.mRows + i);
                }
                if (i2 != 0 && !this.mExtraSpaceHandled) {
                    setColumns(this.mColumns + i2);
                }
                this.mExtraSpaceHandled = true;
            } else {
                for (int i4 = 0; i4 < split.length; i4++) {
                    String[] split3 = split[i4].trim().split(":");
                    String[] split4 = split3[1].split("x");
                    iArr[i4][0] = Integer.parseInt(split3[0]);
                    if (isSubGridByColRow()) {
                        iArr[i4][1] = Integer.parseInt(split4[1]);
                        iArr[i4][2] = Integer.parseInt(split4[0]);
                    } else {
                        iArr[i4][1] = Integer.parseInt(split4[0]);
                        iArr[i4][2] = Integer.parseInt(split4[1]);
                    }
                }
            }
            return iArr;
        } catch (Exception e) {
            return null;
        }
    }

    private float[] parseWeights(int i, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] split = str.split(",");
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 < split.length) {
                try {
                    fArr[i2] = Float.parseFloat(split[i2]);
                } catch (Exception e) {
                    System.err.println("Error parsing `" + split[i2] + "`: " + e.getMessage());
                    fArr[i2] = 1.0f;
                }
            } else {
                fArr[i2] = 1.0f;
            }
        }
        return fArr;
    }

    private void setBoxWidgetHorizontalChains() {
        int max = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] parseWeights = parseWeights(this.mColumns, this.mColumnWeights);
        if (this.mColumns == 1) {
            clearHorizontalAttributes(constraintWidget);
            constraintWidget.mLeft.connect(this.mLeft, 0);
            constraintWidget.mRight.connect(this.mRight, 0);
            return;
        }
        for (int i = 0; i < this.mColumns; i++) {
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i];
            clearHorizontalAttributes(constraintWidget2);
            if (parseWeights != null) {
                constraintWidget2.setHorizontalWeight(parseWeights[i]);
            }
            if (i > 0) {
                constraintWidget2.mLeft.connect(this.mBoxWidgets[i - 1].mRight, 0);
            } else {
                constraintWidget2.mLeft.connect(this.mLeft, 0);
            }
            if (i < this.mColumns - 1) {
                constraintWidget2.mRight.connect(this.mBoxWidgets[i + 1].mLeft, 0);
            } else {
                constraintWidget2.mRight.connect(this.mRight, 0);
            }
            if (i > 0) {
                constraintWidget2.mLeft.mMargin = (int) this.mHorizontalGaps;
            }
        }
        for (int i2 = this.mColumns; i2 < max; i2++) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i2];
            clearHorizontalAttributes(constraintWidget3);
            constraintWidget3.mLeft.connect(this.mLeft, 0);
            constraintWidget3.mRight.connect(this.mRight, 0);
        }
    }

    private void setBoxWidgetVerticalChains() {
        int max = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] parseWeights = parseWeights(this.mRows, this.mRowWeights);
        if (this.mRows == 1) {
            clearVerticalAttributes(constraintWidget);
            constraintWidget.mTop.connect(this.mTop, 0);
            constraintWidget.mBottom.connect(this.mBottom, 0);
            return;
        }
        for (int i = 0; i < this.mRows; i++) {
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i];
            clearVerticalAttributes(constraintWidget2);
            if (parseWeights != null) {
                constraintWidget2.setVerticalWeight(parseWeights[i]);
            }
            if (i > 0) {
                constraintWidget2.mTop.connect(this.mBoxWidgets[i - 1].mBottom, 0);
            } else {
                constraintWidget2.mTop.connect(this.mTop, 0);
            }
            if (i < this.mRows - 1) {
                constraintWidget2.mBottom.connect(this.mBoxWidgets[i + 1].mTop, 0);
            } else {
                constraintWidget2.mBottom.connect(this.mBottom, 0);
            }
            if (i > 0) {
                constraintWidget2.mTop.mMargin = (int) this.mVerticalGaps;
            }
        }
        for (int i2 = this.mRows; i2 < max; i2++) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i2];
            clearVerticalAttributes(constraintWidget3);
            constraintWidget3.mTop.connect(this.mTop, 0);
            constraintWidget3.mBottom.connect(this.mBottom, 0);
        }
    }

    private void setupGrid(boolean z) {
        int[][] parseSpans;
        if (this.mRows < 1 || this.mColumns < 1) {
            return;
        }
        if (z) {
            for (int i = 0; i < this.mPositionMatrix.length; i++) {
                for (int i2 = 0; i2 < this.mPositionMatrix[0].length; i2++) {
                    this.mPositionMatrix[i][i2] = true;
                }
            }
            this.mSpanIds.clear();
        }
        this.mNextAvailableIndex = 0;
        if (this.mSkips != null && !this.mSkips.trim().isEmpty() && (parseSpans = parseSpans(this.mSkips, false)) != null) {
            handleSkips(parseSpans);
        }
        if (this.mSpans != null && !this.mSpans.trim().isEmpty()) {
            this.mSpanMatrix = parseSpans(this.mSpans, true);
        }
        createBoxes();
        if (this.mSpanMatrix != null) {
            handleSpans(this.mSpanMatrix);
        }
    }

    private void updateActualRowsAndColumns() {
        if (this.mRowsSet != 0 && this.mColumnsSet != 0) {
            this.mRows = this.mRowsSet;
            this.mColumns = this.mColumnsSet;
        } else if (this.mColumnsSet > 0) {
            this.mColumns = this.mColumnsSet;
            this.mRows = ((this.mWidgetsCount + this.mColumns) - 1) / this.mColumnsSet;
        } else if (this.mRowsSet > 0) {
            this.mRows = this.mRowsSet;
            this.mColumns = ((this.mWidgetsCount + this.mRowsSet) - 1) / this.mRowsSet;
        } else {
            this.mRows = (int) (Math.sqrt(this.mWidgetsCount) + 1.5d);
            this.mColumns = ((this.mWidgetsCount + this.mRows) - 1) / this.mRows;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        addConstraints();
    }

    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    public ConstraintWidgetContainer getContainer() {
        return this.mContainer;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public String getRowWeights() {
        return this.mRowWeights;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i2, int i3, int i4) {
        super.measure(i, i2, i3, i4);
        this.mContainer = (ConstraintWidgetContainer) getParent();
        setupGrid(false);
        this.mContainer.add(this.mBoxWidgets);
    }

    public void setColumnWeights(String str) {
        if (this.mColumnWeights == null || !this.mColumnWeights.equals(str)) {
            this.mColumnWeights = str;
        }
    }

    public void setColumns(int i) {
        if (i <= 50 && this.mColumnsSet != i) {
            this.mColumnsSet = i;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setContainer(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mContainer = constraintWidgetContainer;
    }

    public void setFlags(int i) {
        this.mFlags = i;
    }

    public void setHorizontalGaps(float f) {
        if (f >= 0.0f && this.mHorizontalGaps != f) {
            this.mHorizontalGaps = f;
        }
    }

    public void setOrientation(int i) {
        if ((i == 0 || i == 1) && this.mOrientation != i) {
            this.mOrientation = i;
        }
    }

    public void setRowWeights(String str) {
        if (this.mRowWeights == null || !this.mRowWeights.equals(str)) {
            this.mRowWeights = str;
        }
    }

    public void setRows(int i) {
        if (i <= 50 && this.mRowsSet != i) {
            this.mRowsSet = i;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setSkips(String str) {
        if (this.mSkips == null || !this.mSkips.equals(str)) {
            this.mExtraSpaceHandled = false;
            this.mSkips = str;
        }
    }

    public void setSpans(CharSequence charSequence) {
        if (this.mSpans == null || !this.mSpans.equals(charSequence.toString())) {
            this.mExtraSpaceHandled = false;
            this.mSpans = charSequence.toString();
        }
    }

    public void setVerticalGaps(float f) {
        if (f >= 0.0f && this.mVerticalGaps != f) {
            this.mVerticalGaps = f;
        }
    }
}
