package androidx.constraintlayout.core.dsl;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Constraint {
    public static final Constraint PARENT = new Constraint("parent");
    static int UNSET = Integer.MIN_VALUE;
    static Map<ChainMode, String> chainModeMap = new HashMap();
    private final String mId;
    String helperType = null;
    String helperJason = null;
    private HAnchor mLeft = new HAnchor(HSide.LEFT);
    private HAnchor mRight = new HAnchor(HSide.RIGHT);
    private VAnchor mTop = new VAnchor(VSide.TOP);
    private VAnchor mBottom = new VAnchor(VSide.BOTTOM);
    private HAnchor mStart = new HAnchor(HSide.START);
    private HAnchor mEnd = new HAnchor(HSide.END);
    private VAnchor mBaseline = new VAnchor(VSide.BASELINE);
    private int mWidth = UNSET;
    private int mHeight = UNSET;
    private float mHorizontalBias = Float.NaN;
    private float mVerticalBias = Float.NaN;
    private String mDimensionRatio = null;
    private String mCircleConstraint = null;
    private int mCircleRadius = Integer.MIN_VALUE;
    private float mCircleAngle = Float.NaN;
    private int mEditorAbsoluteX = Integer.MIN_VALUE;
    private int mEditorAbsoluteY = Integer.MIN_VALUE;
    private float mVerticalWeight = Float.NaN;
    private float mHorizontalWeight = Float.NaN;
    private ChainMode mHorizontalChainStyle = null;
    private ChainMode mVerticalChainStyle = null;
    private Behaviour mWidthDefault = null;
    private Behaviour mHeightDefault = null;
    private int mWidthMax = UNSET;
    private int mHeightMax = UNSET;
    private int mWidthMin = UNSET;
    private int mHeightMin = UNSET;
    private float mWidthPercent = Float.NaN;
    private float mHeightPercent = Float.NaN;
    private String[] mReferenceIds = null;
    private boolean mConstrainedWidth = false;
    private boolean mConstrainedHeight = false;

    /* loaded from: classes.dex */
    public class Anchor {
        Anchor mConnection = null;
        int mGoneMargin = Integer.MIN_VALUE;
        int mMargin;
        final Side mSide;

        Anchor(Side side) {
            this.mSide = side;
        }

        public void build(StringBuilder sb) {
            if (this.mConnection != null) {
                sb.append(this.mSide.toString().toLowerCase()).append(":").append(this).append(",\n");
            }
        }

        public String getId() {
            return Constraint.access$000(Constraint.this);
        }

        Constraint getParent() {
            return Constraint.this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            if (this.mConnection != null) {
                sb.append("'").append(this.mConnection.getId()).append("',").append("'").append(this.mConnection.mSide.toString().toLowerCase()).append("'");
            }
            if (this.mMargin != 0) {
                sb.append(",").append(this.mMargin);
            }
            if (this.mGoneMargin != Integer.MIN_VALUE) {
                if (this.mMargin == 0) {
                    sb.append(",0,").append(this.mGoneMargin);
                } else {
                    sb.append(",").append(this.mGoneMargin);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public enum Behaviour {
        SPREAD,
        WRAP,
        PERCENT,
        RATIO,
        RESOLVED
    }

    /* loaded from: classes.dex */
    public enum ChainMode {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    /* loaded from: classes.dex */
    public class HAnchor extends Anchor {
        HAnchor(HSide hSide) {
            super(Side.valueOf(hSide.name()));
        }
    }

    /* loaded from: classes.dex */
    public enum HSide {
        LEFT,
        RIGHT,
        START,
        END
    }

    /* loaded from: classes.dex */
    public enum Side {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        START,
        END,
        BASELINE
    }

    /* loaded from: classes.dex */
    public class VAnchor extends Anchor {
        VAnchor(VSide vSide) {
            super(Side.valueOf(vSide.name()));
        }
    }

    /* loaded from: classes.dex */
    public enum VSide {
        TOP,
        BOTTOM,
        BASELINE
    }

    static {
        chainModeMap.put(ChainMode.SPREAD, "spread");
        chainModeMap.put(ChainMode.SPREAD_INSIDE, "spread_inside");
        chainModeMap.put(ChainMode.PACKED, "packed");
    }

    public Constraint(String str) {
        this.mId = str;
    }

    static /* synthetic */ String access$000(Constraint constraint) {
        return constraint.mId;
    }

    protected void append(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(":").append(f).append(",\n");
    }

    public String convertStringArrayToString(String[] strArr) {
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while (i < strArr.length) {
            sb.append(i == 0 ? "'" : ",'");
            sb.append(strArr[i]);
            sb.append("'");
            i++;
        }
        sb.append("]");
        return sb.toString();
    }

    public VAnchor getBaseline() {
        return this.mBaseline;
    }

    public VAnchor getBottom() {
        return this.mBottom;
    }

    public float getCircleAngle() {
        return this.mCircleAngle;
    }

    public String getCircleConstraint() {
        return this.mCircleConstraint;
    }

    public int getCircleRadius() {
        return this.mCircleRadius;
    }

    public String getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getEditorAbsoluteX() {
        return this.mEditorAbsoluteX;
    }

    public int getEditorAbsoluteY() {
        return this.mEditorAbsoluteY;
    }

    public HAnchor getEnd() {
        return this.mEnd;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Behaviour getHeightDefault() {
        return this.mHeightDefault;
    }

    public int getHeightMax() {
        return this.mHeightMax;
    }

    public int getHeightMin() {
        return this.mHeightMin;
    }

    public float getHeightPercent() {
        return this.mHeightPercent;
    }

    public float getHorizontalBias() {
        return this.mHorizontalBias;
    }

    public ChainMode getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public float getHorizontalWeight() {
        return this.mHorizontalWeight;
    }

    public HAnchor getLeft() {
        return this.mLeft;
    }

    public String[] getReferenceIds() {
        return this.mReferenceIds;
    }

    public HAnchor getRight() {
        return this.mRight;
    }

    public HAnchor getStart() {
        return this.mStart;
    }

    public VAnchor getTop() {
        return this.mTop;
    }

    public float getVerticalBias() {
        return this.mVerticalBias;
    }

    public ChainMode getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public float getVerticalWeight() {
        return this.mVerticalWeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public Behaviour getWidthDefault() {
        return this.mWidthDefault;
    }

    public int getWidthMax() {
        return this.mWidthMax;
    }

    public int getWidthMin() {
        return this.mWidthMin;
    }

    public float getWidthPercent() {
        return this.mWidthPercent;
    }

    public boolean isConstrainedHeight() {
        return this.mConstrainedHeight;
    }

    public boolean isConstrainedWidth() {
        return this.mConstrainedWidth;
    }

    public void linkToBaseline(VAnchor vAnchor) {
        linkToBaseline(vAnchor, 0);
    }

    public void linkToBaseline(VAnchor vAnchor, int i) {
        linkToBaseline(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToBaseline(VAnchor vAnchor, int i, int i2) {
        this.mBaseline.mConnection = vAnchor;
        this.mBaseline.mMargin = i;
        this.mBaseline.mGoneMargin = i2;
    }

    public void linkToBottom(VAnchor vAnchor) {
        linkToBottom(vAnchor, 0);
    }

    public void linkToBottom(VAnchor vAnchor, int i) {
        linkToBottom(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToBottom(VAnchor vAnchor, int i, int i2) {
        this.mBottom.mConnection = vAnchor;
        this.mBottom.mMargin = i;
        this.mBottom.mGoneMargin = i2;
    }

    public void linkToEnd(HAnchor hAnchor) {
        linkToEnd(hAnchor, 0);
    }

    public void linkToEnd(HAnchor hAnchor, int i) {
        linkToEnd(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToEnd(HAnchor hAnchor, int i, int i2) {
        this.mEnd.mConnection = hAnchor;
        this.mEnd.mMargin = i;
        this.mEnd.mGoneMargin = i2;
    }

    public void linkToLeft(HAnchor hAnchor) {
        linkToLeft(hAnchor, 0);
    }

    public void linkToLeft(HAnchor hAnchor, int i) {
        linkToLeft(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToLeft(HAnchor hAnchor, int i, int i2) {
        this.mLeft.mConnection = hAnchor;
        this.mLeft.mMargin = i;
        this.mLeft.mGoneMargin = i2;
    }

    public void linkToRight(HAnchor hAnchor) {
        linkToRight(hAnchor, 0);
    }

    public void linkToRight(HAnchor hAnchor, int i) {
        linkToRight(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToRight(HAnchor hAnchor, int i, int i2) {
        this.mRight.mConnection = hAnchor;
        this.mRight.mMargin = i;
        this.mRight.mGoneMargin = i2;
    }

    public void linkToStart(HAnchor hAnchor) {
        linkToStart(hAnchor, 0);
    }

    public void linkToStart(HAnchor hAnchor, int i) {
        linkToStart(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToStart(HAnchor hAnchor, int i, int i2) {
        this.mStart.mConnection = hAnchor;
        this.mStart.mMargin = i;
        this.mStart.mGoneMargin = i2;
    }

    public void linkToTop(VAnchor vAnchor) {
        linkToTop(vAnchor, 0);
    }

    public void linkToTop(VAnchor vAnchor, int i) {
        linkToTop(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToTop(VAnchor vAnchor, int i, int i2) {
        this.mTop.mConnection = vAnchor;
        this.mTop.mMargin = i;
        this.mTop.mGoneMargin = i2;
    }

    public void setCircleAngle(float f) {
        this.mCircleAngle = f;
    }

    public void setCircleConstraint(String str) {
        this.mCircleConstraint = str;
    }

    public void setCircleRadius(int i) {
        this.mCircleRadius = i;
    }

    public void setConstrainedHeight(boolean z) {
        this.mConstrainedHeight = z;
    }

    public void setConstrainedWidth(boolean z) {
        this.mConstrainedWidth = z;
    }

    public void setDimensionRatio(String str) {
        this.mDimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i) {
        this.mEditorAbsoluteX = i;
    }

    public void setEditorAbsoluteY(int i) {
        this.mEditorAbsoluteY = i;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setHeightDefault(Behaviour behaviour) {
        this.mHeightDefault = behaviour;
    }

    public void setHeightMax(int i) {
        this.mHeightMax = i;
    }

    public void setHeightMin(int i) {
        this.mHeightMin = i;
    }

    public void setHeightPercent(float f) {
        this.mHeightPercent = f;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalChainStyle(ChainMode chainMode) {
        this.mHorizontalChainStyle = chainMode;
    }

    public void setHorizontalWeight(float f) {
        this.mHorizontalWeight = f;
    }

    public void setReferenceIds(String[] strArr) {
        this.mReferenceIds = strArr;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalChainStyle(ChainMode chainMode) {
        this.mVerticalChainStyle = chainMode;
    }

    public void setVerticalWeight(float f) {
        this.mVerticalWeight = f;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setWidthDefault(Behaviour behaviour) {
        this.mWidthDefault = behaviour;
    }

    public void setWidthMax(int i) {
        this.mWidthMax = i;
    }

    public void setWidthMin(int i) {
        this.mWidthMin = i;
    }

    public void setWidthPercent(float f) {
        this.mWidthPercent = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.mId + ":{\n");
        this.mLeft.build(sb);
        this.mRight.build(sb);
        this.mTop.build(sb);
        this.mBottom.build(sb);
        this.mStart.build(sb);
        this.mEnd.build(sb);
        this.mBaseline.build(sb);
        if (this.mWidth != UNSET) {
            sb.append("width:").append(this.mWidth).append(",\n");
        }
        if (this.mHeight != UNSET) {
            sb.append("height:").append(this.mHeight).append(",\n");
        }
        append(sb, "horizontalBias", this.mHorizontalBias);
        append(sb, "verticalBias", this.mVerticalBias);
        if (this.mDimensionRatio != null) {
            sb.append("dimensionRatio:'").append(this.mDimensionRatio).append("',\n");
        }
        if (this.mCircleConstraint != null && (!Float.isNaN(this.mCircleAngle) || this.mCircleRadius != Integer.MIN_VALUE)) {
            sb.append("circular:['").append(this.mCircleConstraint).append("'");
            if (!Float.isNaN(this.mCircleAngle)) {
                sb.append(",").append(this.mCircleAngle);
            }
            if (this.mCircleRadius != Integer.MIN_VALUE) {
                if (Float.isNaN(this.mCircleAngle)) {
                    sb.append(",0,").append(this.mCircleRadius);
                } else {
                    sb.append(",").append(this.mCircleRadius);
                }
            }
            sb.append("],\n");
        }
        append(sb, "verticalWeight", this.mVerticalWeight);
        append(sb, "horizontalWeight", this.mHorizontalWeight);
        if (this.mHorizontalChainStyle != null) {
            sb.append("horizontalChainStyle:'").append(chainModeMap.get(this.mHorizontalChainStyle)).append("',\n");
        }
        if (this.mVerticalChainStyle != null) {
            sb.append("verticalChainStyle:'").append(chainModeMap.get(this.mVerticalChainStyle)).append("',\n");
        }
        if (this.mWidthDefault != null) {
            if (this.mWidthMax == UNSET && this.mWidthMin == UNSET) {
                sb.append("width:'").append(this.mWidthDefault.toString().toLowerCase()).append("',\n");
            } else {
                sb.append("width:{value:'").append(this.mWidthDefault.toString().toLowerCase()).append("'");
                if (this.mWidthMax != UNSET) {
                    sb.append(",max:").append(this.mWidthMax);
                }
                if (this.mWidthMin != UNSET) {
                    sb.append(",min:").append(this.mWidthMin);
                }
                sb.append("},\n");
            }
        }
        if (this.mHeightDefault != null) {
            if (this.mHeightMax == UNSET && this.mHeightMin == UNSET) {
                sb.append("height:'").append(this.mHeightDefault.toString().toLowerCase()).append("',\n");
            } else {
                sb.append("height:{value:'").append(this.mHeightDefault.toString().toLowerCase()).append("'");
                if (this.mHeightMax != UNSET) {
                    sb.append(",max:").append(this.mHeightMax);
                }
                if (this.mHeightMin != UNSET) {
                    sb.append(",min:").append(this.mHeightMin);
                }
                sb.append("},\n");
            }
        }
        if (!Double.isNaN(this.mWidthPercent)) {
            sb.append("width:'").append((int) this.mWidthPercent).append("%',\n");
        }
        if (!Double.isNaN(this.mHeightPercent)) {
            sb.append("height:'").append((int) this.mHeightPercent).append("%',\n");
        }
        if (this.mReferenceIds != null) {
            sb.append("referenceIds:").append(convertStringArrayToString(this.mReferenceIds)).append(",\n");
        }
        if (this.mConstrainedWidth) {
            sb.append("constrainedWidth:").append(this.mConstrainedWidth).append(",\n");
        }
        if (this.mConstrainedHeight) {
            sb.append("constrainedHeight:").append(this.mConstrainedHeight).append(",\n");
        }
        sb.append("},\n");
        return sb.toString();
    }
}
