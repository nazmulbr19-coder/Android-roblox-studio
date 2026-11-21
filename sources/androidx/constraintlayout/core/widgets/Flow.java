package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    /* loaded from: classes.dex */
    private class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget mBiggest = null;
        int mBiggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
            this.mOrientation = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i2;
        }

        static /* synthetic */ ConstraintWidget access$2000(WidgetsList widgetsList) {
            return widgetsList.mBiggest;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.mBiggest = null;
            this.mBiggestDimension = 0;
            int i = this.mCount;
            for (int i2 = 0; i2 < i && this.mStartIndex + i2 < Flow.access$400(Flow.this); i2++) {
                ConstraintWidget constraintWidget = Flow.access$500(Flow.this)[this.mStartIndex + i2];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int access$000 = Flow.access$000(Flow.this);
                    if (constraintWidget.getVisibility() == 8) {
                        access$000 = 0;
                    }
                    this.mWidth += width + access$000;
                    int access$300 = Flow.access$300(Flow.this, constraintWidget, this.mMax);
                    if (this.mBiggest == null || this.mBiggestDimension < access$300) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = access$300;
                        this.mHeight = access$300;
                    }
                } else {
                    int access$200 = Flow.access$200(Flow.this, constraintWidget, this.mMax);
                    int access$3002 = Flow.access$300(Flow.this, constraintWidget, this.mMax);
                    int access$100 = Flow.access$100(Flow.this);
                    if (constraintWidget.getVisibility() == 8) {
                        access$100 = 0;
                    }
                    this.mHeight += access$3002 + access$100;
                    if (this.mBiggest == null || this.mBiggestDimension < access$200) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = access$200;
                        this.mWidth = access$200;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int access$200 = Flow.access$200(Flow.this, constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    access$200 = 0;
                }
                int access$000 = Flow.access$000(Flow.this);
                if (constraintWidget.getVisibility() == 8) {
                    access$000 = 0;
                }
                this.mWidth += access$200 + access$000;
                int access$300 = Flow.access$300(Flow.this, constraintWidget, this.mMax);
                if (this.mBiggest == null || this.mBiggestDimension < access$300) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = access$300;
                    this.mHeight = access$300;
                }
            } else {
                int access$2002 = Flow.access$200(Flow.this, constraintWidget, this.mMax);
                int access$3002 = Flow.access$300(Flow.this, constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    access$3002 = 0;
                }
                int access$100 = Flow.access$100(Flow.this);
                if (constraintWidget.getVisibility() == 8) {
                    access$100 = 0;
                }
                this.mHeight += access$3002 + access$100;
                if (this.mBiggest == null || this.mBiggestDimension < access$2002) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = access$2002;
                    this.mWidth = access$2002;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.mBiggestDimension = 0;
            this.mBiggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void createConstraints(boolean z, int i, boolean z2) {
            int i2 = this.mCount;
            for (int i3 = 0; i3 < i2 && this.mStartIndex + i3 < Flow.access$400(Flow.this); i3++) {
                ConstraintWidget constraintWidget = Flow.access$500(Flow.this)[this.mStartIndex + i3];
                if (constraintWidget != null) {
                    constraintWidget.resetAnchors();
                }
            }
            if (i2 == 0 || this.mBiggest == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i4 = -1;
            int i5 = -1;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i6;
                if (z) {
                    i7 = (i2 - 1) - i6;
                }
                if (this.mStartIndex + i7 >= Flow.access$400(Flow.this)) {
                    break;
                }
                ConstraintWidget constraintWidget2 = Flow.access$500(Flow.this)[this.mStartIndex + i7];
                if (constraintWidget2 != null && constraintWidget2.getVisibility() == 0) {
                    if (i4 == -1) {
                        i4 = i6;
                    }
                    i5 = i6;
                }
            }
            ConstraintWidget constraintWidget3 = null;
            if (this.mOrientation != 0) {
                ConstraintWidget constraintWidget4 = this.mBiggest;
                constraintWidget4.setHorizontalChainStyle(Flow.access$800(Flow.this));
                int i8 = this.mPaddingLeft;
                if (i > 0) {
                    i8 += Flow.access$000(Flow.this);
                }
                if (z) {
                    constraintWidget4.mRight.connect(this.mRight, i8);
                    if (z2) {
                        constraintWidget4.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget4.mRight, 0);
                    }
                } else {
                    constraintWidget4.mLeft.connect(this.mLeft, i8);
                    if (z2) {
                        constraintWidget4.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget4.mLeft, 0);
                    }
                }
                for (int i9 = 0; i9 < i2 && this.mStartIndex + i9 < Flow.access$400(Flow.this); i9++) {
                    ConstraintWidget constraintWidget5 = Flow.access$500(Flow.this)[this.mStartIndex + i9];
                    if (constraintWidget5 != null) {
                        if (i9 == 0) {
                            constraintWidget5.connect(constraintWidget5.mTop, this.mTop, this.mPaddingTop);
                            int access$600 = Flow.access$600(Flow.this);
                            float access$1400 = Flow.access$1400(Flow.this);
                            if (this.mStartIndex == 0 && Flow.access$1500(Flow.this) != -1) {
                                access$600 = Flow.access$1500(Flow.this);
                                access$1400 = Flow.access$1600(Flow.this);
                            } else if (z2 && Flow.access$1700(Flow.this) != -1) {
                                access$600 = Flow.access$1700(Flow.this);
                                access$1400 = Flow.access$1800(Flow.this);
                            }
                            constraintWidget5.setVerticalChainStyle(access$600);
                            constraintWidget5.setVerticalBiasPercent(access$1400);
                        }
                        if (i9 == i2 - 1) {
                            constraintWidget5.connect(constraintWidget5.mBottom, this.mBottom, this.mPaddingBottom);
                        }
                        if (constraintWidget3 != null) {
                            constraintWidget5.mTop.connect(constraintWidget3.mBottom, Flow.access$100(Flow.this));
                            if (i9 == i4) {
                                constraintWidget5.mTop.setGoneMargin(this.mPaddingTop);
                            }
                            constraintWidget3.mBottom.connect(constraintWidget5.mTop, 0);
                            if (i9 == i5 + 1) {
                                constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                            }
                        }
                        if (constraintWidget5 != constraintWidget4) {
                            if (z) {
                                switch (Flow.access$1900(Flow.this)) {
                                    case 0:
                                        constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                                        break;
                                    case 1:
                                        constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                        break;
                                    case 2:
                                        constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                        constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                                        break;
                                }
                            } else {
                                switch (Flow.access$1900(Flow.this)) {
                                    case 0:
                                        constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                        break;
                                    case 1:
                                        constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                                        break;
                                    case 2:
                                        if (z3) {
                                            constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                            constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                                            break;
                                        } else {
                                            constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                            constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                                            break;
                                        }
                                }
                            }
                        }
                        constraintWidget3 = constraintWidget5;
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget6 = this.mBiggest;
            constraintWidget6.setVerticalChainStyle(Flow.access$600(Flow.this));
            int i10 = this.mPaddingTop;
            if (i > 0) {
                i10 += Flow.access$100(Flow.this);
            }
            constraintWidget6.mTop.connect(this.mTop, i10);
            if (z2) {
                constraintWidget6.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget6.mTop, 0);
            }
            ConstraintWidget constraintWidget7 = constraintWidget6;
            if (Flow.access$700(Flow.this) == 3 && !constraintWidget6.hasBaseline()) {
                int i11 = 0;
                while (true) {
                    if (i11 >= i2) {
                        break;
                    }
                    int i12 = i11;
                    if (z) {
                        i12 = (i2 - 1) - i11;
                    }
                    if (this.mStartIndex + i12 >= Flow.access$400(Flow.this)) {
                        break;
                    }
                    ConstraintWidget constraintWidget8 = Flow.access$500(Flow.this)[this.mStartIndex + i12];
                    if (constraintWidget8.hasBaseline()) {
                        constraintWidget7 = constraintWidget8;
                        break;
                    }
                    i11++;
                }
            }
            for (int i13 = 0; i13 < i2; i13++) {
                int i14 = i13;
                if (z) {
                    i14 = (i2 - 1) - i13;
                }
                if (this.mStartIndex + i14 >= Flow.access$400(Flow.this)) {
                    return;
                }
                ConstraintWidget constraintWidget9 = Flow.access$500(Flow.this)[this.mStartIndex + i14];
                if (constraintWidget9 != null) {
                    if (i13 == 0) {
                        constraintWidget9.connect(constraintWidget9.mLeft, this.mLeft, this.mPaddingLeft);
                    }
                    if (i14 == 0) {
                        int access$800 = Flow.access$800(Flow.this);
                        float access$900 = Flow.access$900(Flow.this);
                        if (z) {
                            access$900 = 1.0f - access$900;
                        }
                        if (this.mStartIndex == 0 && Flow.access$1000(Flow.this) != -1) {
                            access$800 = Flow.access$1000(Flow.this);
                            float access$1100 = Flow.access$1100(Flow.this);
                            if (z) {
                                access$1100 = 1.0f - access$1100;
                            }
                            access$900 = access$1100;
                        } else if (z2 && Flow.access$1200(Flow.this) != -1) {
                            access$800 = Flow.access$1200(Flow.this);
                            float access$1300 = Flow.access$1300(Flow.this);
                            if (z) {
                                access$1300 = 1.0f - access$1300;
                            }
                            access$900 = access$1300;
                        }
                        constraintWidget9.setHorizontalChainStyle(access$800);
                        constraintWidget9.setHorizontalBiasPercent(access$900);
                    }
                    if (i13 == i2 - 1) {
                        constraintWidget9.connect(constraintWidget9.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget9.mLeft.connect(constraintWidget3.mRight, Flow.access$000(Flow.this));
                        if (i13 == i4) {
                            constraintWidget9.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget3.mRight.connect(constraintWidget9.mLeft, 0);
                        if (i13 == i5 + 1) {
                            constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget9 != constraintWidget6) {
                        if (Flow.access$700(Flow.this) != 3 || !constraintWidget7.hasBaseline() || constraintWidget9 == constraintWidget7 || !constraintWidget9.hasBaseline()) {
                            switch (Flow.access$700(Flow.this)) {
                                case 0:
                                    constraintWidget9.mTop.connect(constraintWidget6.mTop, 0);
                                    break;
                                case 1:
                                    constraintWidget9.mBottom.connect(constraintWidget6.mBottom, 0);
                                    break;
                                default:
                                    if (z3) {
                                        constraintWidget9.mTop.connect(this.mTop, this.mPaddingTop);
                                        constraintWidget9.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                        break;
                                    } else {
                                        constraintWidget9.mTop.connect(constraintWidget6.mTop, 0);
                                        constraintWidget9.mBottom.connect(constraintWidget6.mBottom, 0);
                                        break;
                                    }
                            }
                        } else {
                            constraintWidget9.mBaseline.connect(constraintWidget7.mBaseline, 0);
                        }
                    }
                    constraintWidget3 = constraintWidget9;
                }
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.access$100(Flow.this) : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.access$000(Flow.this) : this.mWidth;
        }

        public void measureMatchConstraints(int i) {
            if (this.mNbMatchConstraintsWidgets == 0) {
                return;
            }
            int i2 = this.mCount;
            int i3 = i / this.mNbMatchConstraintsWidgets;
            for (int i4 = 0; i4 < i2 && this.mStartIndex + i4 < Flow.access$400(Flow.this); i4++) {
                ConstraintWidget constraintWidget = Flow.access$500(Flow.this)[this.mStartIndex + i4];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    int i5 = i3;
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i5);
                    i3 = i5;
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i) {
            this.mStartIndex = i;
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
            this.mMax = i6;
        }
    }

    static /* synthetic */ int access$000(Flow flow) {
        return flow.mHorizontalGap;
    }

    static /* synthetic */ int access$100(Flow flow) {
        return flow.mVerticalGap;
    }

    static /* synthetic */ int access$1000(Flow flow) {
        return flow.mFirstHorizontalStyle;
    }

    static /* synthetic */ float access$1100(Flow flow) {
        return flow.mFirstHorizontalBias;
    }

    static /* synthetic */ int access$1200(Flow flow) {
        return flow.mLastHorizontalStyle;
    }

    static /* synthetic */ float access$1300(Flow flow) {
        return flow.mLastHorizontalBias;
    }

    static /* synthetic */ float access$1400(Flow flow) {
        return flow.mVerticalBias;
    }

    static /* synthetic */ int access$1500(Flow flow) {
        return flow.mFirstVerticalStyle;
    }

    static /* synthetic */ float access$1600(Flow flow) {
        return flow.mFirstVerticalBias;
    }

    static /* synthetic */ int access$1700(Flow flow) {
        return flow.mLastVerticalStyle;
    }

    static /* synthetic */ float access$1800(Flow flow) {
        return flow.mLastVerticalBias;
    }

    static /* synthetic */ int access$1900(Flow flow) {
        return flow.mHorizontalAlign;
    }

    static /* synthetic */ int access$200(Flow flow, ConstraintWidget constraintWidget, int i) {
        return flow.getWidgetWidth(constraintWidget, i);
    }

    static /* synthetic */ int access$300(Flow flow, ConstraintWidget constraintWidget, int i) {
        return flow.getWidgetHeight(constraintWidget, i);
    }

    static /* synthetic */ int access$400(Flow flow) {
        return flow.mDisplayedWidgetsCount;
    }

    static /* synthetic */ ConstraintWidget[] access$500(Flow flow) {
        return flow.mDisplayedWidgets;
    }

    static /* synthetic */ int access$600(Flow flow) {
        return flow.mVerticalStyle;
    }

    static /* synthetic */ int access$700(Flow flow) {
        return flow.mVerticalAlign;
    }

    static /* synthetic */ int access$800(Flow flow) {
        return flow.mHorizontalStyle;
    }

    static /* synthetic */ float access$900(Flow flow) {
        return flow.mHorizontalBias;
    }

    private void createAlignedConstraints(boolean z) {
        ConstraintWidget constraintWidget;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i = 0; i < this.mDisplayedWidgetsCount; i++) {
            this.mDisplayedWidgets[i].resetAnchors();
        }
        int i2 = this.mAlignedDimensions[0];
        int i3 = this.mAlignedDimensions[1];
        ConstraintWidget constraintWidget2 = null;
        float f = this.mHorizontalBias;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4;
            if (z) {
                i5 = (i2 - i4) - 1;
                f = 1.0f - this.mHorizontalBias;
            }
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i5];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i4 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(f);
                }
                if (i4 == i2 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i4 > 0 && constraintWidget2 != null) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
        }
        for (int i6 = 0; i6 < i3; i6++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i6];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i6 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i6 == i3 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i6 > 0 && constraintWidget2 != null) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i7 = 0; i7 < i2; i7++) {
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = (i8 * i2) + i7;
                if (this.mOrientation == 1) {
                    i9 = (i7 * i3) + i8;
                }
                if (i9 < this.mDisplayedWidgets.length && (constraintWidget = this.mDisplayedWidgets[i9]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i7];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i8];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    private int getWidgetHeight(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            constraintWidget2 = constraintWidget;
        } else {
            if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                return 0;
            }
            if (constraintWidget.mMatchConstraintDefaultHeight == 2) {
                int i2 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                if (i2 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i2);
                }
                return i2;
            }
            constraintWidget2 = constraintWidget;
            if (constraintWidget2.mMatchConstraintDefaultHeight == 1) {
                return constraintWidget2.getHeight();
            }
            if (constraintWidget2.mMatchConstraintDefaultHeight == 3) {
                return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget2.getHeight();
    }

    private int getWidgetWidth(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            constraintWidget2 = constraintWidget;
        } else {
            if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                return 0;
            }
            if (constraintWidget.mMatchConstraintDefaultWidth == 2) {
                int i2 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                if (i2 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i2, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i2;
            }
            constraintWidget2 = constraintWidget;
            if (constraintWidget2.mMatchConstraintDefaultWidth == 1) {
                return constraintWidget2.getWidth();
            }
            if (constraintWidget2.mMatchConstraintDefaultWidth == 3) {
                return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget2.getWidth();
    }

    private void measureAligned(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        ConstraintWidget constraintWidget;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        if (i2 == 0) {
            i5 = this.mMaxElementsWrap;
            if (i5 <= 0) {
                int i6 = 0;
                i5 = 0;
                for (int i7 = 0; i7 < i; i7++) {
                    if (i7 > 0) {
                        i6 += this.mHorizontalGap;
                    }
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i7];
                    if (constraintWidget2 != null) {
                        i6 += getWidgetWidth(constraintWidget2, i3);
                        if (i6 > i3) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            }
        } else {
            i4 = this.mMaxElementsWrap;
            if (i4 <= 0) {
                int i8 = 0;
                i4 = 0;
                for (int i9 = 0; i9 < i; i9++) {
                    if (i9 > 0) {
                        i8 += this.mVerticalGap;
                    }
                    ConstraintWidget constraintWidget3 = constraintWidgetArr[i9];
                    if (constraintWidget3 != null) {
                        i8 += getWidgetHeight(constraintWidget3, i3);
                        if (i8 > i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
        }
        if (this.mAlignedDimensions == null) {
            this.mAlignedDimensions = new int[2];
        }
        if ((i4 == 0 && i2 == 1) || (i5 == 0 && i2 == 0)) {
            z = true;
        }
        while (!z) {
            if (i2 == 0) {
                i4 = (int) Math.ceil(i / i5);
            } else {
                i5 = (int) Math.ceil(i / i4);
            }
            if (this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInCols.length < i5) {
                this.mAlignedBiggestElementsInCols = new ConstraintWidget[i5];
            } else {
                Arrays.fill(this.mAlignedBiggestElementsInCols, (Object) null);
            }
            if (this.mAlignedBiggestElementsInRows == null || this.mAlignedBiggestElementsInRows.length < i4) {
                this.mAlignedBiggestElementsInRows = new ConstraintWidget[i4];
            } else {
                Arrays.fill(this.mAlignedBiggestElementsInRows, (Object) null);
            }
            for (int i10 = 0; i10 < i5; i10++) {
                for (int i11 = 0; i11 < i4; i11++) {
                    int i12 = (i11 * i5) + i10;
                    if (i2 == 1) {
                        i12 = (i10 * i4) + i11;
                    }
                    if (i12 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i12]) != null) {
                        int widgetWidth = getWidgetWidth(constraintWidget, i3);
                        if (this.mAlignedBiggestElementsInCols[i10] == null || this.mAlignedBiggestElementsInCols[i10].getWidth() < widgetWidth) {
                            this.mAlignedBiggestElementsInCols[i10] = constraintWidget;
                        }
                        int widgetHeight = getWidgetHeight(constraintWidget, i3);
                        if (this.mAlignedBiggestElementsInRows[i11] == null || this.mAlignedBiggestElementsInRows[i11].getHeight() < widgetHeight) {
                            this.mAlignedBiggestElementsInRows[i11] = constraintWidget;
                        }
                    }
                }
            }
            int i13 = 0;
            for (int i14 = 0; i14 < i5; i14++) {
                ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInCols[i14];
                if (constraintWidget4 != null) {
                    if (i14 > 0) {
                        i13 += this.mHorizontalGap;
                    }
                    i13 += getWidgetWidth(constraintWidget4, i3);
                }
            }
            int i15 = 0;
            for (int i16 = 0; i16 < i4; i16++) {
                ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInRows[i16];
                if (constraintWidget5 != null) {
                    if (i16 > 0) {
                        i15 += this.mVerticalGap;
                    }
                    i15 += getWidgetHeight(constraintWidget5, i3);
                }
            }
            iArr[0] = i13;
            iArr[1] = i15;
            if (i2 == 0) {
                if (i13 <= i3) {
                    z = true;
                } else if (i5 > 1) {
                    i5--;
                } else {
                    z = true;
                }
            } else if (i15 <= i3) {
                z = true;
            } else if (i4 > 1) {
                i4--;
            } else {
                z = true;
            }
        }
        this.mAlignedDimensions[0] = i5;
        this.mAlignedDimensions[1] = i4;
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        WidgetsList widgetsList;
        int i4;
        if (i == 0) {
            return;
        }
        this.mChainList.clear();
        int i5 = i3;
        WidgetsList widgetsList2 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i5);
        this.mChainList.add(widgetsList2);
        int i6 = 0;
        if (i2 == 0) {
            int i7 = 0;
            WidgetsList widgetsList3 = widgetsList2;
            int i8 = 0;
            while (i8 < i) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i8];
                int widgetWidth = getWidgetWidth(constraintWidget, i5);
                int i9 = constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? i6 + 1 : i6;
                boolean z = (i7 == i5 || (this.mHorizontalGap + i7) + widgetWidth > i5) && WidgetsList.access$2000(widgetsList3) != null;
                if ((z || i8 <= 0 || this.mMaxElementsWrap <= 0 || i8 % this.mMaxElementsWrap != 0) ? z : true) {
                    WidgetsList widgetsList4 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i5);
                    widgetsList4.setStartIndex(i8);
                    this.mChainList.add(widgetsList4);
                    widgetsList3 = widgetsList4;
                    i7 = widgetWidth;
                } else {
                    i7 = i8 > 0 ? i7 + this.mHorizontalGap + widgetWidth : widgetWidth;
                }
                widgetsList3.add(constraintWidget);
                i8++;
                i6 = i9;
            }
            widgetsList = widgetsList3;
        } else {
            int i10 = 0;
            WidgetsList widgetsList5 = widgetsList2;
            int i11 = 0;
            while (i11 < i) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i11];
                int widgetHeight = getWidgetHeight(constraintWidget2, i5);
                int i12 = constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? i6 + 1 : i6;
                boolean z2 = (i10 == i5 || (this.mVerticalGap + i10) + widgetHeight > i5) && WidgetsList.access$2000(widgetsList5) != null;
                if ((z2 || i11 <= 0 || this.mMaxElementsWrap <= 0 || i11 % this.mMaxElementsWrap != 0) ? z2 : true) {
                    WidgetsList widgetsList6 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i5);
                    widgetsList6.setStartIndex(i11);
                    this.mChainList.add(widgetsList6);
                    widgetsList5 = widgetsList6;
                    i10 = widgetHeight;
                } else {
                    i10 = i11 > 0 ? i10 + this.mVerticalGap + widgetHeight : widgetHeight;
                }
                widgetsList5.add(constraintWidget2);
                i11++;
                i5 = i3;
                i6 = i12;
            }
            widgetsList = widgetsList5;
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = this.mTop;
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        boolean z3 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i6 > 0 && z3) {
            int i13 = 0;
            while (i13 < size) {
                boolean z4 = z3;
                WidgetsList widgetsList7 = this.mChainList.get(i13);
                if (i2 == 0) {
                    i4 = i6;
                    widgetsList7.measureMatchConstraints(i3 - widgetsList7.getWidth());
                } else {
                    i4 = i6;
                    widgetsList7.measureMatchConstraints(i3 - widgetsList7.getHeight());
                }
                i13++;
                z3 = z4;
                i6 = i4;
            }
        }
        int i14 = paddingLeft;
        int i15 = paddingTop;
        int i16 = paddingRight;
        int i17 = paddingBottom;
        int i18 = 0;
        ConstraintAnchor constraintAnchor5 = constraintAnchor;
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        ConstraintAnchor constraintAnchor7 = constraintAnchor3;
        int i19 = 0;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        for (int i20 = 0; i20 < size; i20++) {
            WidgetsList widgetsList8 = this.mChainList.get(i20);
            if (i2 == 0) {
                if (i20 < size - 1) {
                    i17 = 0;
                    constraintAnchor8 = WidgetsList.access$2000(this.mChainList.get(i20 + 1)).mTop;
                } else {
                    ConstraintAnchor constraintAnchor9 = this.mBottom;
                    i17 = getPaddingBottom();
                    constraintAnchor8 = constraintAnchor9;
                }
                ConstraintAnchor constraintAnchor10 = WidgetsList.access$2000(widgetsList8).mBottom;
                widgetsList8.setup(i2, constraintAnchor5, constraintAnchor6, constraintAnchor7, constraintAnchor8, i14, i15, i16, i17, i3);
                i18 = Math.max(i18, widgetsList8.getWidth());
                i19 += widgetsList8.getHeight();
                if (i20 > 0) {
                    i19 += this.mVerticalGap;
                }
                constraintAnchor6 = constraintAnchor10;
                i15 = 0;
            } else {
                if (i20 < size - 1) {
                    i16 = 0;
                    constraintAnchor7 = WidgetsList.access$2000(this.mChainList.get(i20 + 1)).mLeft;
                } else {
                    ConstraintAnchor constraintAnchor11 = this.mRight;
                    i16 = getPaddingRight();
                    constraintAnchor7 = constraintAnchor11;
                }
                ConstraintAnchor constraintAnchor12 = WidgetsList.access$2000(widgetsList8).mRight;
                widgetsList8.setup(i2, constraintAnchor5, constraintAnchor6, constraintAnchor7, constraintAnchor8, i14, i15, i16, i17, i3);
                i18 += widgetsList8.getWidth();
                i19 = Math.max(i19, widgetsList8.getHeight());
                if (i20 > 0) {
                    i18 += this.mHorizontalGap;
                    constraintAnchor5 = constraintAnchor12;
                    i14 = 0;
                } else {
                    constraintAnchor5 = constraintAnchor12;
                    i14 = 0;
                }
            }
        }
        iArr[0] = i18;
        iArr[1] = i19;
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        WidgetsList widgetsList;
        int i4;
        if (i == 0) {
            return;
        }
        this.mChainList.clear();
        int i5 = i3;
        WidgetsList widgetsList2 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i5);
        this.mChainList.add(widgetsList2);
        int i6 = 0;
        if (i2 == 0) {
            int i7 = 0;
            int i8 = 0;
            WidgetsList widgetsList3 = widgetsList2;
            int i9 = 0;
            while (i9 < i) {
                i8++;
                ConstraintWidget constraintWidget = constraintWidgetArr[i9];
                int widgetWidth = getWidgetWidth(constraintWidget, i5);
                int i10 = constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? i6 + 1 : i6;
                boolean z = (i7 == i5 || (this.mHorizontalGap + i7) + widgetWidth > i5) && WidgetsList.access$2000(widgetsList3) != null;
                if ((z || i9 <= 0 || this.mMaxElementsWrap <= 0 || i8 <= this.mMaxElementsWrap) ? z : true) {
                    WidgetsList widgetsList4 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i5);
                    widgetsList4.setStartIndex(i9);
                    this.mChainList.add(widgetsList4);
                    widgetsList3 = widgetsList4;
                    i8 = 1;
                    i7 = widgetWidth;
                } else {
                    i7 = i9 > 0 ? i7 + this.mHorizontalGap + widgetWidth : widgetWidth;
                }
                widgetsList3.add(constraintWidget);
                i9++;
                i6 = i10;
            }
            widgetsList = widgetsList3;
        } else {
            int i11 = 0;
            int i12 = 0;
            WidgetsList widgetsList5 = widgetsList2;
            int i13 = 0;
            while (i13 < i) {
                i12++;
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i13];
                int widgetHeight = getWidgetHeight(constraintWidget2, i5);
                int i14 = constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? i6 + 1 : i6;
                boolean z2 = (i11 == i5 || (this.mVerticalGap + i11) + widgetHeight > i5) && WidgetsList.access$2000(widgetsList5) != null;
                if ((z2 || i13 <= 0 || this.mMaxElementsWrap <= 0 || i12 <= this.mMaxElementsWrap) ? z2 : true) {
                    WidgetsList widgetsList6 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i5);
                    widgetsList6.setStartIndex(i13);
                    this.mChainList.add(widgetsList6);
                    widgetsList5 = widgetsList6;
                    i12 = 1;
                    i11 = widgetHeight;
                } else {
                    i11 = i13 > 0 ? i11 + this.mVerticalGap + widgetHeight : widgetHeight;
                }
                widgetsList5.add(constraintWidget2);
                i13++;
                i5 = i3;
                i6 = i14;
            }
            widgetsList = widgetsList5;
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = this.mTop;
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        boolean z3 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i6 > 0 && z3) {
            int i15 = 0;
            while (i15 < size) {
                boolean z4 = z3;
                WidgetsList widgetsList7 = this.mChainList.get(i15);
                if (i2 == 0) {
                    i4 = i6;
                    widgetsList7.measureMatchConstraints(i3 - widgetsList7.getWidth());
                } else {
                    i4 = i6;
                    widgetsList7.measureMatchConstraints(i3 - widgetsList7.getHeight());
                }
                i15++;
                z3 = z4;
                i6 = i4;
            }
        }
        int i16 = paddingLeft;
        int i17 = paddingTop;
        int i18 = paddingRight;
        int i19 = paddingBottom;
        int i20 = 0;
        ConstraintAnchor constraintAnchor5 = constraintAnchor;
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        ConstraintAnchor constraintAnchor7 = constraintAnchor3;
        int i21 = 0;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        for (int i22 = 0; i22 < size; i22++) {
            WidgetsList widgetsList8 = this.mChainList.get(i22);
            if (i2 == 0) {
                if (i22 < size - 1) {
                    i19 = 0;
                    constraintAnchor8 = WidgetsList.access$2000(this.mChainList.get(i22 + 1)).mTop;
                } else {
                    ConstraintAnchor constraintAnchor9 = this.mBottom;
                    i19 = getPaddingBottom();
                    constraintAnchor8 = constraintAnchor9;
                }
                ConstraintAnchor constraintAnchor10 = WidgetsList.access$2000(widgetsList8).mBottom;
                widgetsList8.setup(i2, constraintAnchor5, constraintAnchor6, constraintAnchor7, constraintAnchor8, i16, i17, i18, i19, i3);
                i20 = Math.max(i20, widgetsList8.getWidth());
                i21 += widgetsList8.getHeight();
                if (i22 > 0) {
                    i21 += this.mVerticalGap;
                }
                constraintAnchor6 = constraintAnchor10;
                i17 = 0;
            } else {
                if (i22 < size - 1) {
                    i18 = 0;
                    constraintAnchor7 = WidgetsList.access$2000(this.mChainList.get(i22 + 1)).mLeft;
                } else {
                    ConstraintAnchor constraintAnchor11 = this.mRight;
                    i18 = getPaddingRight();
                    constraintAnchor7 = constraintAnchor11;
                }
                ConstraintAnchor constraintAnchor12 = WidgetsList.access$2000(widgetsList8).mRight;
                widgetsList8.setup(i2, constraintAnchor5, constraintAnchor6, constraintAnchor7, constraintAnchor8, i16, i17, i18, i19, i3);
                i20 += widgetsList8.getWidth();
                i21 = Math.max(i21, widgetsList8.getHeight());
                if (i22 > 0) {
                    i20 += this.mHorizontalGap;
                    constraintAnchor5 = constraintAnchor12;
                    i16 = 0;
                } else {
                    constraintAnchor5 = constraintAnchor12;
                    i16 = 0;
                }
            }
        }
        iArr[0] = i20;
        iArr[1] = i21;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        WidgetsList widgetsList;
        if (i == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList2.setup(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i3);
            widgetsList = widgetsList2;
        }
        for (int i4 = 0; i4 < i; i4++) {
            widgetsList.add(constraintWidgetArr[i4]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        boolean z2 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        switch (this.mWrapMode) {
            case 0:
                if (this.mChainList.size() > 0) {
                    this.mChainList.get(0).createConstraints(z2, 0, true);
                    break;
                }
                break;
            case 1:
                int size = this.mChainList.size();
                int i = 0;
                while (i < size) {
                    this.mChainList.get(i).createConstraints(z2, i, i == size + (-1));
                    i++;
                }
                break;
            case 2:
                createAlignedConstraints(z2);
                break;
            case 3:
                int size2 = this.mChainList.size();
                int i2 = 0;
                while (i2 < size2) {
                    this.mChainList.get(i2).createConstraints(z2, i2, i2 == size2 + (-1));
                    i2++;
                }
                break;
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public float getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r19v1 */
    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i2, int i3, int i4) {
        boolean z;
        ConstraintWidget[] constraintWidgetArr;
        int i5;
        ?? r18;
        boolean z2 = false;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i6 = this.mOrientation == 1 ? (i4 - paddingTop) - paddingBottom : (i2 - paddingLeft) - paddingRight;
        if (this.mOrientation == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            z = z2;
            if (i8 >= this.mWidgetsCount) {
                break;
            }
            ConstraintWidget[] constraintWidgetArr3 = constraintWidgetArr2;
            if (this.mWidgets[i8].getVisibility() == 8) {
                i7++;
            }
            i8++;
            z2 = z ? 1 : 0;
            constraintWidgetArr2 = constraintWidgetArr3;
        }
        ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr2;
        int i9 = this.mWidgetsCount;
        if (i7 > 0) {
            ConstraintWidget[] constraintWidgetArr5 = new ConstraintWidget[this.mWidgetsCount - i7];
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = i9;
                if (i11 >= this.mWidgetsCount) {
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i11];
                ConstraintWidget[] constraintWidgetArr6 = constraintWidgetArr5;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr6[i10] = constraintWidget;
                    i10++;
                }
                i11++;
                i9 = i12;
                constraintWidgetArr5 = constraintWidgetArr6;
            }
            ConstraintWidget[] constraintWidgetArr7 = constraintWidgetArr5;
            i5 = i10;
            constraintWidgetArr = constraintWidgetArr7;
        } else {
            constraintWidgetArr = constraintWidgetArr4;
            i5 = i9;
        }
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i5;
        switch (this.mWrapMode) {
            case 0:
                r18 = 1;
                measureNoWrap(constraintWidgetArr, i5, this.mOrientation, i6, iArr);
                break;
            case 1:
                r18 = 1;
                measureChainWrap(constraintWidgetArr, i5, this.mOrientation, i6, iArr);
                break;
            case 2:
                r18 = 1;
                measureAligned(constraintWidgetArr, i5, this.mOrientation, i6, iArr);
                break;
            case 3:
                r18 = 1;
                measureChainWrap_new(constraintWidgetArr, i5, this.mOrientation, i6, iArr);
                break;
            default:
                r18 = 1;
                break;
        }
        int i13 = iArr[z ? 1 : 0] + paddingLeft + paddingRight;
        int i14 = iArr[r18] + paddingTop + paddingBottom;
        int i15 = 0;
        int i16 = 0;
        if (i == 1073741824) {
            i15 = i2;
        } else if (i == Integer.MIN_VALUE) {
            i15 = Math.min(i13, i2);
        } else if (i == 0) {
            i15 = i13;
        }
        if (i3 == 1073741824) {
            i16 = i4;
        } else if (i3 == Integer.MIN_VALUE) {
            i16 = Math.min(i14, i4);
        } else if (i3 == 0) {
            i16 = i14;
        }
        setMeasure(i15, i16);
        setWidth(i15);
        setHeight(i16);
        needsCallbackFromSolver(this.mWidgetsCount > 0 ? r18 : z ? 1 : 0);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFirstHorizontalStyle = i;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.mFirstVerticalStyle = i;
    }

    public void setHorizontalAlign(int i) {
        this.mHorizontalAlign = i;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setHorizontalStyle(int i) {
        this.mHorizontalStyle = i;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.mLastHorizontalStyle = i;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int i) {
        this.mLastVerticalStyle = i;
    }

    public void setMaxElementsWrap(int i) {
        this.mMaxElementsWrap = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setVerticalAlign(int i) {
        this.mVerticalAlign = i;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }

    public void setVerticalStyle(int i) {
        this.mVerticalStyle = i;
    }

    public void setWrapMode(int i) {
        this.mWrapMode = i;
    }
}
