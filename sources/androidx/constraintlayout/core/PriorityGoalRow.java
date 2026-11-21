package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor;
    private SolverVariable[] mArrayGoals;
    Cache mCache;
    private int mNumGoals;
    private SolverVariable[] mSortArray;
    private int mTableSize;

    /* renamed from: androidx.constraintlayout.core.PriorityGoalRow$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Comparator<SolverVariable> {
        AnonymousClass1() {
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.id - solverVariable2.id;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return compare2(solverVariable, solverVariable2);
        }
    }

    /* loaded from: classes.dex */
    class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;

        GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.mRow = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                fArr[i] = fArr[i] + solverVariable.mGoalStrengthVector[i];
                if (Math.abs(this.mVariable.mGoalStrengthVector[i]) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f) {
            if (!this.mVariable.inGoal) {
                for (int i = 0; i < 9; i++) {
                    float f2 = solverVariable.mGoalStrengthVector[i];
                    if (f2 != 0.0f) {
                        float f3 = f * f2;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        this.mVariable.mGoalStrengthVector[i] = f3;
                    } else {
                        this.mVariable.mGoalStrengthVector[i] = 0.0f;
                    }
                }
                return true;
            }
            boolean z = true;
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                fArr[i2] = fArr[i2] + (solverVariable.mGoalStrengthVector[i2] * f);
                if (Math.abs(this.mVariable.mGoalStrengthVector[i2]) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i2] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (!z) {
                return false;
            }
            PriorityGoalRow.access$000(PriorityGoalRow.this, this.mVariable);
            return false;
        }

        public void init(SolverVariable solverVariable) {
            this.mVariable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i = 8; i >= 0; i--) {
                float f = this.mVariable.mGoalStrengthVector[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i = 0; i < 9; i++) {
                if (this.mVariable.mGoalStrengthVector[i] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            for (int i = 8; i >= 0; i--) {
                float f = solverVariable.mGoalStrengthVector[i];
                float f2 = this.mVariable.mGoalStrengthVector[i];
                if (f2 != f) {
                    return f2 < f;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.mVariable != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.mVariable.mGoalStrengthVector[i] + " ";
                }
            }
            return str + "] " + this.mVariable;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mTableSize = 128;
        this.mArrayGoals = new SolverVariable[this.mTableSize];
        this.mSortArray = new SolverVariable[this.mTableSize];
        this.mNumGoals = 0;
        this.mAccessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    static /* synthetic */ void access$000(PriorityGoalRow priorityGoalRow, SolverVariable solverVariable) {
        priorityGoalRow.removeGoal(solverVariable);
    }

    private void addToGoal(SolverVariable solverVariable) {
        if (this.mNumGoals + 1 > this.mArrayGoals.length) {
            this.mArrayGoals = (SolverVariable[]) Arrays.copyOf(this.mArrayGoals, this.mArrayGoals.length * 2);
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(this.mArrayGoals, this.mArrayGoals.length * 2);
        }
        this.mArrayGoals[this.mNumGoals] = solverVariable;
        this.mNumGoals++;
        if (this.mNumGoals > 1 && this.mArrayGoals[this.mNumGoals - 1].id > solverVariable.id) {
            for (int i = 0; i < this.mNumGoals; i++) {
                this.mSortArray[i] = this.mArrayGoals[i];
            }
            Arrays.sort(this.mSortArray, 0, this.mNumGoals, new AnonymousClass1());
            for (int i2 = 0; i2 < this.mNumGoals; i2++) {
                this.mArrayGoals[i2] = this.mSortArray[i2];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    private void removeGoal(SolverVariable solverVariable) {
        for (int i = 0; i < this.mNumGoals; i++) {
            if (this.mArrayGoals[i] == solverVariable) {
                for (int i2 = i; i2 < this.mNumGoals - 1; i2++) {
                    this.mArrayGoals[i2] = this.mArrayGoals[i2 + 1];
                }
                this.mNumGoals--;
                solverVariable.inGoal = false;
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.mAccessor.init(solverVariable);
        this.mAccessor.reset();
        solverVariable.mGoalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.mNumGoals; i2++) {
            SolverVariable solverVariable = this.mArrayGoals[i2];
            if (!zArr[solverVariable.id]) {
                this.mAccessor.init(solverVariable);
                if (i == -1) {
                    if (this.mAccessor.isNegative()) {
                        i = i2;
                    }
                } else if (this.mAccessor.isSmallerThan(this.mArrayGoals[i])) {
                    i = i2;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.mArrayGoals[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.mNumGoals == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.mConstantValue + ") : ";
        for (int i = 0; i < this.mNumGoals; i++) {
            this.mAccessor.init(this.mArrayGoals[i]);
            str = str + this.mAccessor + " ";
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable variable = arrayRowVariables.getVariable(i);
            float variableValue = arrayRowVariables.getVariableValue(i);
            this.mAccessor.init(variable);
            if (this.mAccessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.mConstantValue += arrayRow.mConstantValue * variableValue;
        }
        removeGoal(solverVariable);
    }
}
