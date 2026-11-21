package androidx.constraintlayout.core.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridEngine {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int VERTICAL = 1;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    private int mNextAvailableIndex = 0;
    private int mNumWidgets;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    private String mStrSkips;
    private String mStrSpans;

    public GridEngine() {
    }

    public GridEngine(int i, int i2) {
        this.mRowsSet = i;
        this.mColumnsSet = i2;
        if (i > 50) {
            this.mRowsSet = 3;
        }
        if (i2 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initVariables();
    }

    public GridEngine(int i, int i2, int i3) {
        this.mRowsSet = i;
        this.mColumnsSet = i2;
        this.mNumWidgets = i3;
        if (i > 50) {
            this.mRowsSet = 3;
        }
        if (i2 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        if (i3 > this.mRows * this.mColumns || i3 < 1) {
            this.mNumWidgets = this.mRows * this.mColumns;
        }
        initVariables();
        fillConstraintMatrix(false);
    }

    private void addAllConstraintPositions() {
        for (int i = 0; i < this.mNumWidgets; i++) {
            if (leftOfWidget(i) == -1) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return;
                } else {
                    addConstraintPosition(i, rowByIndex, colByIndex, 1, 1);
                }
            }
        }
    }

    private void addConstraintPosition(int i, int i2, int i3, int i4, int i5) {
        this.mConstraintMatrix[i][0] = i3;
        this.mConstraintMatrix[i][1] = i2;
        this.mConstraintMatrix[i][2] = (i3 + i5) - 1;
        this.mConstraintMatrix[i][3] = (i2 + i4) - 1;
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
        if (this.mStrSkips != null && !this.mStrSkips.trim().isEmpty() && (parseSpans2 = parseSpans(this.mStrSkips)) != null) {
            handleSkips(parseSpans2);
        }
        if (this.mStrSpans != null && !this.mStrSpans.trim().isEmpty() && (parseSpans = parseSpans(this.mStrSpans)) != null) {
            handleSpans(parseSpans);
        }
        addAllConstraintPositions();
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
        for (int i = 0; i < iArr.length && invalidatePositions(getRowByIndex(iArr[i][0]), getColByIndex(iArr[i][0]), iArr[i][1], iArr[i][2]); i++) {
        }
    }

    private void handleSpans(int[][] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            int rowByIndex = getRowByIndex(iArr[i][0]);
            int colByIndex = getColByIndex(iArr[i][0]);
            if (!invalidatePositions(rowByIndex, colByIndex, iArr[i][1], iArr[i][2])) {
                return;
            }
            addConstraintPosition(i, rowByIndex, colByIndex, iArr[i][1], iArr[i][2]);
        }
    }

    private void initVariables() {
        this.mPositionMatrix = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        for (boolean[] zArr : this.mPositionMatrix) {
            Arrays.fill(zArr, true);
        }
        if (this.mNumWidgets > 0) {
            this.mConstraintMatrix = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, this.mNumWidgets, 4);
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

    private boolean isSpansValid(CharSequence charSequence) {
        return charSequence != null;
    }

    private int[][] parseSpans(String str) {
        if (!isSpansValid(str)) {
            return null;
        }
        String[] split = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, split.length, 3);
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            String[] split3 = split2[1].split("x");
            iArr[i][0] = Integer.parseInt(split2[0]);
            iArr[i][1] = Integer.parseInt(split3[0]);
            iArr[i][2] = Integer.parseInt(split3[1]);
        }
        return iArr;
    }

    private void updateActualRowsAndColumns() {
        if (this.mRowsSet != 0 && this.mColumnsSet != 0) {
            this.mRows = this.mRowsSet;
            this.mColumns = this.mColumnsSet;
        } else if (this.mColumnsSet > 0) {
            this.mColumns = this.mColumnsSet;
            this.mRows = ((this.mNumWidgets + this.mColumns) - 1) / this.mColumnsSet;
        } else if (this.mRowsSet > 0) {
            this.mRows = this.mRowsSet;
            this.mColumns = ((this.mNumWidgets + this.mRowsSet) - 1) / this.mRowsSet;
        } else {
            this.mRows = (int) (Math.sqrt(this.mNumWidgets) + 1.5d);
            this.mColumns = ((this.mNumWidgets + this.mRows) - 1) / this.mRows;
        }
    }

    public int bottomOfWidget(int i) {
        if (this.mConstraintMatrix == null || i >= this.mConstraintMatrix.length) {
            return 0;
        }
        return this.mConstraintMatrix[i][3];
    }

    public int leftOfWidget(int i) {
        if (this.mConstraintMatrix == null || i >= this.mConstraintMatrix.length) {
            return 0;
        }
        return this.mConstraintMatrix[i][0];
    }

    public int rightOfWidget(int i) {
        if (this.mConstraintMatrix == null || i >= this.mConstraintMatrix.length) {
            return 0;
        }
        return this.mConstraintMatrix[i][2];
    }

    public void setColumns(int i) {
        if (i <= 50 && this.mColumnsSet != i) {
            this.mColumnsSet = i;
            updateActualRowsAndColumns();
        }
    }

    public void setNumWidgets(int i) {
        if (i > this.mRows * this.mColumns) {
            return;
        }
        this.mNumWidgets = i;
    }

    public void setOrientation(int i) {
        if ((i == 0 || i == 1) && this.mOrientation != i) {
            this.mOrientation = i;
        }
    }

    public void setRows(int i) {
        if (i <= 50 && this.mRowsSet != i) {
            this.mRowsSet = i;
            updateActualRowsAndColumns();
        }
    }

    public void setSkips(String str) {
        if (this.mStrSkips == null || !this.mStrSkips.equals(str)) {
            this.mStrSkips = str;
        }
    }

    public void setSpans(CharSequence charSequence) {
        if (this.mStrSpans == null || !this.mStrSpans.equals(charSequence.toString())) {
            this.mStrSpans = charSequence.toString();
        }
    }

    public void setup() {
        boolean z = this.mConstraintMatrix != null && this.mConstraintMatrix.length == this.mNumWidgets && this.mPositionMatrix != null && this.mPositionMatrix.length == this.mRows && this.mPositionMatrix[0].length == this.mColumns;
        if (!z) {
            initVariables();
        }
        fillConstraintMatrix(z);
    }

    public int topOfWidget(int i) {
        if (this.mConstraintMatrix == null || i >= this.mConstraintMatrix.length) {
            return 0;
        }
        return this.mConstraintMatrix[i][1];
    }
}
