package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class LinearSystem {
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    private static final boolean DO_NOT_USE = false;
    public static final boolean FULL_DEBUG = false;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    ArrayRow[] mRows;
    private Row mTempGoal;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean USE_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean OPTIMIZED_ENGINE = false;
    public static long ARRAY_ROW_CREATION = 0;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    private int mPoolSize = 1000;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int mTableSize = 32;
    private int mMaxColumns = this.mTableSize;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[this.mTableSize];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = this.mTableSize;
    private SolverVariable[] mPoolVariables = new SolverVariable[this.mPoolSize];
    private int mPoolVariablesCount = 0;

    /* loaded from: classes.dex */
    interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* loaded from: classes.dex */
    static class ValuesRow extends ArrayRow {
        ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[this.mTableSize];
        releaseRows();
        this.mCache = new Cache();
        this.mGoal = new PriorityGoalRow(this.mCache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.mCache.mSolverVariablePool.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        if (this.mPoolVariablesCount >= this.mPoolSize) {
            this.mPoolSize *= 2;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, this.mPoolSize);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i + 1;
        solverVariableArr[i] = acquire;
        return acquire;
    }

    private void addRow(ArrayRow arrayRow) {
        if (SIMPLIFY_SYNONYMS && arrayRow.mIsSimpleDefinition) {
            arrayRow.mVariable.setFinalValue(this, arrayRow.mConstantValue);
        } else {
            this.mRows[this.mNumRows] = arrayRow;
            arrayRow.mVariable.mDefinitionId = this.mNumRows;
            this.mNumRows++;
            arrayRow.mVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i = 0;
            while (i < this.mNumRows) {
                if (this.mRows[i] == null) {
                    System.out.println("WTF");
                }
                if (this.mRows[i] != null && this.mRows[i].mIsSimpleDefinition) {
                    ArrayRow arrayRow2 = this.mRows[i];
                    arrayRow2.mVariable.setFinalValue(this, arrayRow2.mConstantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.mOptimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.mArrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i] = null;
                    int i2 = i + 1;
                    for (int i3 = i + 1; i3 < this.mNumRows; i3++) {
                        this.mRows[i3 - 1] = this.mRows[i3];
                        if (this.mRows[i3 - 1].mVariable.mDefinitionId == i3) {
                            this.mRows[i3 - 1].mVariable.mDefinitionId = i3 - 1;
                        }
                        i2 = i3;
                    }
                    if (i2 < this.mNumRows) {
                        this.mRows[i2] = null;
                    }
                    this.mNumRows--;
                    i--;
                }
                i++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.mVariable.computedValue = arrayRow.mConstantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        if (sMetrics != null) {
            sMetrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            str = (str + this.mRows[i]) + "\n";
        }
        System.out.println(str + this.mGoal + "\n");
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private int enforceBFS(Row row) throws Exception {
        float f;
        boolean z;
        float f2;
        long j;
        boolean z2;
        int i = 0;
        boolean z3 = false;
        int i2 = 0;
        while (true) {
            f = 0.0f;
            if (i2 >= this.mNumRows) {
                break;
            }
            if (this.mRows[i2].mVariable.mType != SolverVariable.Type.UNRESTRICTED && this.mRows[i2].mConstantValue < 0.0f) {
                z3 = true;
                break;
            }
            i2++;
        }
        if (z3) {
            boolean z4 = false;
            i = 0;
            while (!z4) {
                long j2 = 1;
                if (sMetrics != null) {
                    sMetrics.bfs++;
                }
                i++;
                float f3 = Float.MAX_VALUE;
                int i3 = 0;
                int i4 = -1;
                int i5 = -1;
                int i6 = 0;
                while (i6 < this.mNumRows) {
                    ArrayRow arrayRow = this.mRows[i6];
                    if (arrayRow.mVariable.mType == SolverVariable.Type.UNRESTRICTED) {
                        z = z3;
                        f2 = f;
                        j = j2;
                    } else if (arrayRow.mIsSimpleDefinition) {
                        z = z3;
                        f2 = f;
                        j = j2;
                    } else if (arrayRow.mConstantValue < f) {
                        int i7 = 9;
                        if (SKIP_COLUMNS) {
                            int currentSize = arrayRow.variables.getCurrentSize();
                            f2 = f;
                            int i8 = 0;
                            while (i8 < currentSize) {
                                long j3 = j2;
                                SolverVariable variable = arrayRow.variables.getVariable(i8);
                                float f4 = arrayRow.variables.get(variable);
                                if (f4 <= f2) {
                                    z2 = z3;
                                } else {
                                    z2 = z3;
                                    int i9 = 0;
                                    while (i9 < i7) {
                                        float f5 = variable.mStrengthVector[i9] / f4;
                                        if ((f5 < f3 && i9 == i3) || i9 > i3) {
                                            f3 = f5;
                                            i4 = i6;
                                            i5 = variable.id;
                                            i3 = i9;
                                        }
                                        i9++;
                                        i7 = 9;
                                    }
                                }
                                i8++;
                                j2 = j3;
                                z3 = z2;
                                i7 = 9;
                            }
                            z = z3;
                            j = j2;
                        } else {
                            z = z3;
                            f2 = f;
                            j = j2;
                            for (int i10 = 1; i10 < this.mNumColumns; i10++) {
                                SolverVariable solverVariable = this.mCache.mIndexedVariables[i10];
                                float f6 = arrayRow.variables.get(solverVariable);
                                if (f6 > f2) {
                                    for (int i11 = 0; i11 < 9; i11++) {
                                        float f7 = solverVariable.mStrengthVector[i11] / f6;
                                        if ((f7 < f3 && i11 == i3) || i11 > i3) {
                                            f3 = f7;
                                            i4 = i6;
                                            i5 = i10;
                                            i3 = i11;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        z = z3;
                        f2 = f;
                        j = j2;
                    }
                    i6++;
                    f = f2;
                    j2 = j;
                    z3 = z;
                }
                boolean z5 = z3;
                float f8 = f;
                long j4 = j2;
                if (i4 != -1) {
                    ArrayRow arrayRow2 = this.mRows[i4];
                    arrayRow2.mVariable.mDefinitionId = -1;
                    if (sMetrics != null) {
                        sMetrics.pivots += j4;
                    }
                    arrayRow2.pivot(this.mCache.mIndexedVariables[i5]);
                    arrayRow2.mVariable.mDefinitionId = i4;
                    arrayRow2.mVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                } else {
                    z4 = true;
                }
                if (i > this.mNumColumns / 2) {
                    z4 = true;
                }
                f = f8;
                z3 = z5;
            }
        }
        return i;
    }

    private String getDisplaySize(int i) {
        int i2 = ((i * 4) / 1024) / 1024;
        if (i2 > 0) {
            return "" + i2 + " Mb";
        }
        int i3 = (i * 4) / 1024;
        return i3 > 0 ? "" + i3 + " Kb" : "" + (i * 4) + " bytes";
    }

    private String getDisplayStrength(int i) {
        return i == 1 ? "LOW" : i == 2 ? "MEDIUM" : i == 3 ? "HIGH" : i == 4 ? "HIGHEST" : i == 5 ? "EQUALITY" : i == 8 ? "FIXED" : i == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        this.mTableSize *= 2;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, this.mTableSize);
        this.mCache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(this.mCache.mIndexedVariables, this.mTableSize);
        this.mAlreadyTestedCandidates = new boolean[this.mTableSize];
        this.mMaxColumns = this.mTableSize;
        this.mMaxRows = this.mTableSize;
        if (sMetrics != null) {
            sMetrics.tableSizeIncrease++;
            sMetrics.maxTableSize = Math.max(sMetrics.maxTableSize, this.mTableSize);
            sMetrics.lastTableSize = sMetrics.maxTableSize;
        }
    }

    private int optimize(Row row, boolean z) {
        if (sMetrics != null) {
            sMetrics.optimize++;
        }
        boolean z2 = false;
        int i = 0;
        for (int i2 = 0; i2 < this.mNumColumns; i2++) {
            this.mAlreadyTestedCandidates[i2] = false;
        }
        while (!z2) {
            if (sMetrics != null) {
                sMetrics.iterations++;
            }
            i++;
            if (i >= this.mNumColumns * 2) {
                return i;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                if (this.mAlreadyTestedCandidates[pivotCandidate.id]) {
                    return i;
                }
                this.mAlreadyTestedCandidates[pivotCandidate.id] = true;
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.mNumRows; i4++) {
                    ArrayRow arrayRow = this.mRows[i4];
                    if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.mIsSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f2 = arrayRow.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow.mConstantValue) / f2;
                            if (f3 < f) {
                                f = f3;
                                i3 = i4;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i3];
                    arrayRow2.mVariable.mDefinitionId = -1;
                    if (sMetrics != null) {
                        sMetrics.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    arrayRow2.mVariable.mDefinitionId = i3;
                    arrayRow2.mVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z2 = true;
            }
        }
        return i;
    }

    private void releaseRows() {
        if (OPTIMIZED_ENGINE) {
            for (int i = 0; i < this.mNumRows; i++) {
                ArrayRow arrayRow = this.mRows[i];
                if (arrayRow != null) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i] = null;
            }
            return;
        }
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow arrayRow2 = this.mRows[i2];
            if (arrayRow2 != null) {
                this.mCache.mArrayRowPool.release(arrayRow2);
            }
            this.mRows[i2] = null;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow createRow = createRow();
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (i * Math.sin(f)));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(f) * i));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable pickPivot;
        if (arrayRow == null) {
            return;
        }
        if (sMetrics != null) {
            sMetrics.constraints++;
            if (arrayRow.mIsSimpleDefinition) {
                sMetrics.simpleconstraints++;
            }
        }
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z = false;
        if (!arrayRow.mIsSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.mVariable = createExtraVariable;
                int i = this.mNumRows;
                addRow(arrayRow);
                if (this.mNumRows == i + 1) {
                    z = true;
                    this.mTempGoal.initFromRow(arrayRow);
                    optimize(this.mTempGoal, true);
                    if (createExtraVariable.mDefinitionId == -1) {
                        if (arrayRow.mVariable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                            if (sMetrics != null) {
                                sMetrics.pivots++;
                            }
                            arrayRow.pivot(pickPivot);
                        }
                        if (!arrayRow.mIsSimpleDefinition) {
                            arrayRow.mVariable.updateReferencesWithNewDefinition(this, arrayRow);
                        }
                        if (OPTIMIZED_ENGINE) {
                            this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                        } else {
                            this.mCache.mArrayRowPool.release(arrayRow);
                        }
                        this.mNumRows--;
                    }
                }
            }
            if (!arrayRow.hasKeyVariable()) {
                return;
            }
        }
        if (z) {
            return;
        }
        addRow(arrayRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (sMetrics != null) {
            sMetrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && i2 == 8 && solverVariable2.isFinalValue && solverVariable.mDefinitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i);
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        if (sMetrics != null) {
            sMetrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && solverVariable.mDefinitionId == -1) {
            solverVariable.setFinalValue(this, i);
            for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i2];
                if (solverVariable2 != null && solverVariable2.mIsSynonym && solverVariable2.mSynonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, i + solverVariable2.mSynonymDelta);
                }
            }
            return;
        }
        int i3 = solverVariable.mDefinitionId;
        if (solverVariable.mDefinitionId == -1) {
            ArrayRow createRow = createRow();
            createRow.createRowDefinition(solverVariable, i);
            addConstraint(createRow);
            return;
        }
        ArrayRow arrayRow = this.mRows[i3];
        if (arrayRow.mIsSimpleDefinition) {
            arrayRow.mConstantValue = i;
            return;
        }
        if (arrayRow.variables.getCurrentSize() == 0) {
            arrayRow.mIsSimpleDefinition = true;
            arrayRow.mConstantValue = i;
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.createRowEquals(solverVariable, i);
            addConstraint(createRow2);
        }
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            addSingleError(createRow, (int) ((-1.0f) * createRow.variables.get(createSlackVariable)), i2);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            addSingleError(createRow, (int) ((-1.0f) * createRow.variables.get(createSlackVariable)), i2);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 8) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    void addSingleError(ArrayRow arrayRow, int i, int i2) {
        arrayRow.addSingleError(createErrorVariable(i2, null), i);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        if (solverVariable.mDefinitionId != -1 || i != 0) {
            addEquality(solverVariable, solverVariable2, i, 8);
            return;
        }
        if (solverVariable2.mIsSynonym) {
            i += (int) solverVariable2.mSynonymDelta;
            solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.mSynonym];
        }
        if (!solverVariable.mIsSynonym) {
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
        } else {
            int i2 = i - ((int) solverVariable.mSynonymDelta);
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.mSynonym];
        }
    }

    final void cleanupRows() {
        int i = 0;
        while (i < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
            }
            if (arrayRow.mIsSimpleDefinition) {
                arrayRow.mVariable.computedValue = arrayRow.mConstantValue;
                arrayRow.mVariable.removeFromRow(arrayRow);
                for (int i2 = i; i2 < this.mNumRows - 1; i2++) {
                    this.mRows[i2] = this.mRows[i2 + 1];
                }
                this.mRows[this.mNumRows - 1] = null;
                this.mNumRows--;
                i--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.mArrayRowPool.release(arrayRow);
                }
            }
            i++;
        }
    }

    public SolverVariable createErrorVariable(int i, String str) {
        if (sMetrics != null) {
            sMetrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        acquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        if (sMetrics != null) {
            sMetrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariable = null;
        if (obj instanceof ConstraintAnchor) {
            solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
            if (solverVariable == null) {
                ((ConstraintAnchor) obj).resetSolverVariable(this.mCache);
                solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
            }
            if (solverVariable.id == -1 || solverVariable.id > this.mVariablesID || this.mCache.mIndexedVariables[solverVariable.id] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                this.mVariablesID++;
                this.mNumColumns++;
                solverVariable.id = this.mVariablesID;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire;
        if (OPTIMIZED_ENGINE) {
            acquire = this.mCache.mOptimizedArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        } else {
            acquire = this.mCache.mArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        if (sMetrics != null) {
            sMetrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = " num vars " + this.mVariablesID + "\n";
        for (int i = 0; i < this.mVariablesID + 1; i++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String str2 = str + "\n";
        for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
            SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i2];
            if (solverVariable2 != null && solverVariable2.mIsSynonym) {
                str2 = str2 + " ~[" + i2 + "] => " + solverVariable2 + " = " + this.mCache.mIndexedVariables[solverVariable2.mSynonym] + " + " + solverVariable2.mSynonymDelta + "\n";
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            str3 = (str3 + this.mRows[i3].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str3 = str3 + "Goal: " + this.mGoal + "\n";
        }
        System.out.println(str3);
    }

    void displaySystemInformation() {
        int i = 0;
        for (int i2 = 0; i2 < this.mTableSize; i2++) {
            if (this.mRows[i2] != null) {
                i += this.mRows[i2].sizeInBytes();
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.mNumRows; i4++) {
            if (this.mRows[i4] != null) {
                i3 += this.mRows[i4].sizeInBytes();
            }
        }
        System.out.println("Linear System -> Table size: " + this.mTableSize + " (" + getDisplaySize(this.mTableSize * this.mTableSize) + ") -- row sizes: " + getDisplaySize(i) + ", actual size: " + getDisplaySize(i3) + " rows: " + this.mNumRows + "/" + this.mMaxRows + " cols: " + this.mNumColumns + "/" + this.mMaxColumns + " 0 occupied cells, " + getDisplaySize(0));
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            if (this.mRows[i].mVariable.mType == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i].toReadableString()) + "\n";
            }
        }
        System.out.println(str + this.mGoal + "\n");
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int i = 0;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            if (this.mRows[i2] != null) {
                i += this.mRows[i2].sizeInBytes();
            }
        }
        return i;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    ArrayRow getRow(int i) {
        return this.mRows[i];
    }

    float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        if (sMetrics != null) {
            sMetrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        if (sMetrics != null) {
            sMetrics.graphOptimizer++;
        }
        boolean z = true;
        int i = 0;
        while (true) {
            if (i >= this.mNumRows) {
                break;
            }
            if (!this.mRows[i].mIsSimpleDefinition) {
                z = false;
                break;
            }
            i++;
        }
        if (!z) {
            minimizeGoal(this.mGoal);
            return;
        }
        if (sMetrics != null) {
            sMetrics.fullySolved++;
        }
        computeValues();
    }

    void minimizeGoal(Row row) throws Exception {
        if (sMetrics != null) {
            sMetrics.minimizeGoal++;
            sMetrics.maxVariables = Math.max(sMetrics.maxVariables, this.mNumColumns);
            sMetrics.maxRows = Math.max(sMetrics.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        if (!arrayRow.mIsSimpleDefinition || arrayRow.mVariable == null) {
            return;
        }
        if (arrayRow.mVariable.mDefinitionId != -1) {
            for (int i = arrayRow.mVariable.mDefinitionId; i < this.mNumRows - 1; i++) {
                SolverVariable solverVariable = this.mRows[i + 1].mVariable;
                if (solverVariable.mDefinitionId == i + 1) {
                    solverVariable.mDefinitionId = i;
                }
                this.mRows[i] = this.mRows[i + 1];
            }
            this.mNumRows--;
        }
        if (!arrayRow.mVariable.isFinalValue) {
            arrayRow.mVariable.setFinalValue(this, arrayRow.mConstantValue);
        }
        if (OPTIMIZED_ENGINE) {
            this.mCache.mOptimizedArrayRowPool.release(arrayRow);
        } else {
            this.mCache.mArrayRowPool.release(arrayRow);
        }
    }

    public void reset() {
        for (int i = 0; i < this.mCache.mIndexedVariables.length; i++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
        }
        this.mCache.mSolverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        if (this.mVariables != null) {
            this.mVariables.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            if (this.mRows[i2] != null) {
                this.mRows[i2].mUsed = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }
}
