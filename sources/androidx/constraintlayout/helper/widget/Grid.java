package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class Grid extends VirtualLayout {
    private static final boolean DEBUG_BOXES = false;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "Grid";
    public static final int VERTICAL = 1;
    private int[] mBoxViewIds;
    private View[] mBoxViews;
    private int mColumns;
    private int mColumnsSet;
    ConstraintLayout mContainer;
    private float mHorizontalGaps;
    private final int mMaxColumns;
    private final int mMaxRows;
    private int mNextAvailableIndex;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    Set<Integer> mSpanIds;
    private String mStrColumnWeights;
    private String mStrRowWeights;
    private String mStrSkips;
    private String mStrSpans;
    private boolean mUseRtl;
    private boolean mValidateInputs;
    private float mVerticalGaps;

    public Grid(Context context) {
        super(context);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    public Grid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    public Grid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    private boolean arrangeWidgets() {
        View[] views = getViews(this.mContainer);
        for (int i = 0; i < this.mCount; i++) {
            if (!this.mSpanIds.contains(Integer.valueOf(this.mIds[i]))) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return false;
                }
                connectView(views[i], rowByIndex, colByIndex, 1, 1);
            }
        }
        return true;
    }

    private void buildBoxes() {
        int max = Math.max(this.mRows, this.mColumns);
        if (this.mBoxViews == null) {
            this.mBoxViews = new View[max];
            for (int i = 0; i < this.mBoxViews.length; i++) {
                this.mBoxViews[i] = makeNewView();
            }
        } else if (max != this.mBoxViews.length) {
            View[] viewArr = new View[max];
            for (int i2 = 0; i2 < max; i2++) {
                if (i2 < this.mBoxViews.length) {
                    viewArr[i2] = this.mBoxViews[i2];
                } else {
                    viewArr[i2] = makeNewView();
                }
            }
            for (int i3 = max; i3 < this.mBoxViews.length; i3++) {
                this.mContainer.removeView(this.mBoxViews[i3]);
            }
            this.mBoxViews = viewArr;
        }
        this.mBoxViewIds = new int[max];
        for (int i4 = 0; i4 < this.mBoxViews.length; i4++) {
            this.mBoxViewIds[i4] = this.mBoxViews[i4].getId();
        }
        setBoxViewVerticalChains();
        setBoxViewHorizontalChains();
    }

    private void clearHParams(View view) {
        ConstraintLayout.LayoutParams params = params(view);
        params.horizontalWeight = -1.0f;
        params.leftToRight = -1;
        params.leftToLeft = -1;
        params.rightToLeft = -1;
        params.rightToRight = -1;
        params.leftMargin = -1;
        view.setLayoutParams(params);
    }

    private void clearVParams(View view) {
        ConstraintLayout.LayoutParams params = params(view);
        params.verticalWeight = -1.0f;
        params.topToBottom = -1;
        params.topToTop = -1;
        params.bottomToTop = -1;
        params.bottomToBottom = -1;
        params.topMargin = -1;
        view.setLayoutParams(params);
    }

    private void connectView(View view, int i, int i2, int i3, int i4) {
        ConstraintLayout.LayoutParams params = params(view);
        params.leftToLeft = this.mBoxViewIds[i2];
        params.topToTop = this.mBoxViewIds[i];
        params.rightToRight = this.mBoxViewIds[(i2 + i4) - 1];
        params.bottomToBottom = this.mBoxViewIds[(i + i3) - 1];
        view.setLayoutParams(params);
    }

    private boolean generateGrid(boolean z) {
        int[][] parseSpans;
        int[][] parseSpans2;
        if (this.mContainer == null || this.mRows < 1 || this.mColumns < 1) {
            return false;
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
        boolean z2 = true;
        buildBoxes();
        if (this.mStrSkips != null && !this.mStrSkips.trim().isEmpty() && (parseSpans2 = parseSpans(this.mStrSkips)) != null) {
            z2 = true & handleSkips(parseSpans2);
        }
        if (this.mStrSpans != null && !this.mStrSpans.trim().isEmpty() && (parseSpans = parseSpans(this.mStrSpans)) != null) {
            z2 &= handleSpans(this.mIds, parseSpans);
        }
        return (z2 && arrangeWidgets()) || !this.mValidateInputs;
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

    private boolean handleSkips(int[][] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (!invalidatePositions(getRowByIndex(iArr[i][0]), getColByIndex(iArr[i][0]), iArr[i][1], iArr[i][2])) {
                return false;
            }
        }
        return true;
    }

    private boolean handleSpans(int[] iArr, int[][] iArr2) {
        View[] views = getViews(this.mContainer);
        for (int i = 0; i < iArr2.length; i++) {
            int rowByIndex = getRowByIndex(iArr2[i][0]);
            int colByIndex = getColByIndex(iArr2[i][0]);
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[i][1], iArr2[i][2])) {
                return false;
            }
            connectView(views[i], rowByIndex, colByIndex, iArr2[i][1], iArr2[i][2]);
            this.mSpanIds.add(Integer.valueOf(iArr[i]));
        }
        return true;
    }

    private void initVariables() {
        this.mPositionMatrix = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        for (boolean[] zArr : this.mPositionMatrix) {
            Arrays.fill(zArr, true);
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
        return true;
    }

    private boolean isWeightsValid(String str) {
        return true;
    }

    private View makeNewView() {
        View view = new View(getContext());
        view.setId(View.generateViewId());
        view.setVisibility(4);
        this.mContainer.addView(view, new ConstraintLayout.LayoutParams(0, 0));
        return view;
    }

    private ConstraintLayout.LayoutParams params(View view) {
        return (ConstraintLayout.LayoutParams) view.getLayoutParams();
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

    private float[] parseWeights(int i, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != i) {
            return null;
        }
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = Float.parseFloat(split[i2].trim());
        }
        return fArr;
    }

    private void setBoxViewHorizontalChains() {
        int id = getId();
        int max = Math.max(this.mRows, this.mColumns);
        float[] parseWeights = parseWeights(this.mColumns, this.mStrColumnWeights);
        ConstraintLayout.LayoutParams params = params(this.mBoxViews[0]);
        if (this.mColumns == 1) {
            clearHParams(this.mBoxViews[0]);
            params.leftToLeft = id;
            params.rightToRight = id;
            this.mBoxViews[0].setLayoutParams(params);
            return;
        }
        for (int i = 0; i < this.mColumns; i++) {
            ConstraintLayout.LayoutParams params2 = params(this.mBoxViews[i]);
            clearHParams(this.mBoxViews[i]);
            if (parseWeights != null) {
                params2.horizontalWeight = parseWeights[i];
            }
            if (i > 0) {
                params2.leftToRight = this.mBoxViewIds[i - 1];
            } else {
                params2.leftToLeft = id;
            }
            if (i < this.mColumns - 1) {
                params2.rightToLeft = this.mBoxViewIds[i + 1];
            } else {
                params2.rightToRight = id;
            }
            if (i > 0) {
                params2.leftMargin = (int) this.mHorizontalGaps;
            }
            this.mBoxViews[i].setLayoutParams(params2);
        }
        for (int i2 = this.mColumns; i2 < max; i2++) {
            ConstraintLayout.LayoutParams params3 = params(this.mBoxViews[i2]);
            clearHParams(this.mBoxViews[i2]);
            params3.leftToLeft = id;
            params3.rightToRight = id;
            this.mBoxViews[i2].setLayoutParams(params3);
        }
    }

    private void setBoxViewVerticalChains() {
        int id = getId();
        int max = Math.max(this.mRows, this.mColumns);
        float[] parseWeights = parseWeights(this.mRows, this.mStrRowWeights);
        if (this.mRows == 1) {
            ConstraintLayout.LayoutParams params = params(this.mBoxViews[0]);
            clearVParams(this.mBoxViews[0]);
            params.topToTop = id;
            params.bottomToBottom = id;
            this.mBoxViews[0].setLayoutParams(params);
            return;
        }
        for (int i = 0; i < this.mRows; i++) {
            ConstraintLayout.LayoutParams params2 = params(this.mBoxViews[i]);
            clearVParams(this.mBoxViews[i]);
            if (parseWeights != null) {
                params2.verticalWeight = parseWeights[i];
            }
            if (i > 0) {
                params2.topToBottom = this.mBoxViewIds[i - 1];
            } else {
                params2.topToTop = id;
            }
            if (i < this.mRows - 1) {
                params2.bottomToTop = this.mBoxViewIds[i + 1];
            } else {
                params2.bottomToBottom = id;
            }
            if (i > 0) {
                params2.topMargin = (int) this.mHorizontalGaps;
            }
            this.mBoxViews[i].setLayoutParams(params2);
        }
        for (int i2 = this.mRows; i2 < max; i2++) {
            ConstraintLayout.LayoutParams params3 = params(this.mBoxViews[i2]);
            clearVParams(this.mBoxViews[i2]);
            params3.topToTop = id;
            params3.bottomToBottom = id;
            this.mBoxViews[i2].setLayoutParams(params3);
        }
    }

    private void updateActualRowsAndColumns() {
        if (this.mRowsSet != 0 && this.mColumnsSet != 0) {
            this.mRows = this.mRowsSet;
            this.mColumns = this.mColumnsSet;
        } else if (this.mColumnsSet > 0) {
            this.mColumns = this.mColumnsSet;
            this.mRows = ((this.mCount + this.mColumns) - 1) / this.mColumnsSet;
        } else if (this.mRowsSet > 0) {
            this.mRows = this.mRowsSet;
            this.mColumns = ((this.mCount + this.mRowsSet) - 1) / this.mRowsSet;
        } else {
            this.mRows = (int) (Math.sqrt(this.mCount) + 1.5d);
            this.mColumns = ((this.mCount + this.mRows) - 1) / this.mRows;
        }
    }

    public String getColumnWeights() {
        return this.mStrColumnWeights;
    }

    public int getColumns() {
        return this.mColumnsSet;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public String getRowWeights() {
        return this.mStrRowWeights;
    }

    public int getRows() {
        return this.mRowsSet;
    }

    public String getSkips() {
        return this.mStrSkips;
    }

    public String getSpans() {
        return this.mStrSpans;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Grid);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Grid_grid_rows) {
                    this.mRowsSet = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_columns) {
                    this.mColumnsSet = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_spans) {
                    this.mStrSpans = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_skips) {
                    this.mStrSkips = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_rowWeights) {
                    this.mStrRowWeights = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_columnWeights) {
                    this.mStrColumnWeights = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_orientation) {
                    this.mOrientation = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.Grid_grid_horizontalGaps) {
                    this.mHorizontalGaps = obtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_verticalGaps) {
                    this.mVerticalGaps = obtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_validateInputs) {
                    this.mValidateInputs = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == R.styleable.Grid_grid_useRtl) {
                    this.mUseRtl = obtainStyledAttributes.getBoolean(index, false);
                }
            }
            updateActualRowsAndColumns();
            initVariables();
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        generateGrid(false);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            Paint paint = new Paint();
            paint.setColor(SupportMenu.CATEGORY_MASK);
            paint.setStyle(Paint.Style.STROKE);
            int top = getTop();
            int left = getLeft();
            int bottom = getBottom();
            int right = getRight();
            View[] viewArr = this.mBoxViews;
            int length = viewArr.length;
            int i = 0;
            while (i < length) {
                View view = viewArr[i];
                int left2 = view.getLeft() - left;
                int top2 = view.getTop() - top;
                int right2 = view.getRight() - left;
                int bottom2 = view.getBottom() - top;
                canvas.drawRect(left2, 0.0f, right2, bottom - r16, paint);
                canvas.drawRect(0.0f, top2, right - r18, bottom2, paint);
                i++;
                top = top;
                left = left;
            }
        }
    }

    public void setColumnWeights(String str) {
        if (isWeightsValid(str)) {
            if (this.mStrColumnWeights == null || !this.mStrColumnWeights.equals(str)) {
                this.mStrColumnWeights = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setColumns(int i) {
        if (i <= 50 && this.mColumnsSet != i) {
            this.mColumnsSet = i;
            updateActualRowsAndColumns();
            initVariables();
            generateGrid(false);
            invalidate();
        }
    }

    public void setHorizontalGaps(float f) {
        if (f >= 0.0f && this.mHorizontalGaps != f) {
            this.mHorizontalGaps = f;
            generateGrid(true);
            invalidate();
        }
    }

    public void setOrientation(int i) {
        if ((i == 0 || i == 1) && this.mOrientation != i) {
            this.mOrientation = i;
            generateGrid(true);
            invalidate();
        }
    }

    public void setRowWeights(String str) {
        if (isWeightsValid(str)) {
            if (this.mStrRowWeights == null || !this.mStrRowWeights.equals(str)) {
                this.mStrRowWeights = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setRows(int i) {
        if (i <= 50 && this.mRowsSet != i) {
            this.mRowsSet = i;
            updateActualRowsAndColumns();
            initVariables();
            generateGrid(false);
            invalidate();
        }
    }

    public void setSkips(String str) {
        if (isSpansValid(str)) {
            if (this.mStrSkips == null || !this.mStrSkips.equals(str)) {
                this.mStrSkips = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setSpans(CharSequence charSequence) {
        if (isSpansValid(charSequence)) {
            if (this.mStrSpans == null || !this.mStrSpans.contentEquals(charSequence)) {
                this.mStrSpans = charSequence.toString();
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setVerticalGaps(float f) {
        if (f >= 0.0f && this.mVerticalGaps != f) {
            this.mVerticalGaps = f;
            generateGrid(true);
            invalidate();
        }
    }
}
