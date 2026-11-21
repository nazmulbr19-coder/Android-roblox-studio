package androidx.constraintlayout.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ConstraintLayout.LayoutParams)) {
            throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
        }
        this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
        this.mView = view;
    }

    private String sideToString(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public ConstraintProperties addToHorizontalChain(int i, int i2) {
        connect(1, i, i == 0 ? 1 : 2, 0);
        connect(2, i2, i2 == 0 ? 2 : 1, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i, int i2) {
        connect(6, i, i == 0 ? 6 : 7, 0);
        connect(7, i2, i2 == 0 ? 7 : 6, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i, int i2) {
        connect(3, i, i == 0 ? 3 : 4, 0);
        connect(4, i2, i2 == 0 ? 4 : 3, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f) {
        this.mView.setAlpha(f);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (i3 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i2 == 1 || i2 == 2) {
            connect(1, i, i2, i3);
            connect(2, i4, i5, i6);
            this.mParams.horizontalBias = f;
        } else if (i2 == 6 || i2 == 7) {
            connect(6, i, i2, i3);
            connect(7, i4, i5, i6);
            this.mParams.horizontalBias = f;
        } else {
            connect(3, i, i2, i3);
            connect(4, i4, i5, i6);
            this.mParams.verticalBias = f;
        }
        return this;
    }

    public ConstraintProperties centerHorizontally(int i) {
        if (i == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, 2, 0, i, 1, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(1, i, i2, i3);
        connect(2, i4, i5, i6);
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i) {
        if (i == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, 7, 0, i, 6, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(6, i, i2, i3);
        connect(7, i4, i5, i6);
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerVertically(int i) {
        if (i == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, 4, 0, i, 3, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerVertically(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(3, i, i2, i3);
        connect(4, i4, i5, i6);
        this.mParams.verticalBias = f;
        return this;
    }

    public ConstraintProperties connect(int i, int i2, int i3, int i4) {
        switch (i) {
            case 1:
                if (i3 == 1) {
                    this.mParams.leftToLeft = i2;
                    ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams.leftToRight = -1;
                } else {
                    if (i3 != 2) {
                        throw new IllegalArgumentException("Left to " + sideToString(i3) + " undefined");
                    }
                    this.mParams.leftToRight = i2;
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams3.leftToLeft = -1;
                }
                this.mParams.leftMargin = i4;
                return this;
            case 2:
                if (i3 == 1) {
                    this.mParams.rightToLeft = i2;
                    ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams5.rightToRight = -1;
                } else {
                    if (i3 != 2) {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    this.mParams.rightToRight = i2;
                    ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                    layoutParams7.rightToLeft = -1;
                }
                this.mParams.rightMargin = i4;
                return this;
            case 3:
                if (i3 == 3) {
                    this.mParams.topToTop = i2;
                    ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                    layoutParams9.topToBottom = -1;
                    ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                    layoutParams11.baselineToBaseline = -1;
                    ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams14 = this.mParams;
                    layoutParams13.baselineToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams15 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams16 = this.mParams;
                    layoutParams15.baselineToBottom = -1;
                } else {
                    if (i3 != 4) {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    this.mParams.topToBottom = i2;
                    ConstraintLayout.LayoutParams layoutParams17 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams18 = this.mParams;
                    layoutParams17.topToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams19 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams20 = this.mParams;
                    layoutParams19.baselineToBaseline = -1;
                    ConstraintLayout.LayoutParams layoutParams21 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams22 = this.mParams;
                    layoutParams21.baselineToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams23 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams24 = this.mParams;
                    layoutParams23.baselineToBottom = -1;
                }
                this.mParams.topMargin = i4;
                return this;
            case 4:
                if (i3 == 4) {
                    this.mParams.bottomToBottom = i2;
                    ConstraintLayout.LayoutParams layoutParams25 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams26 = this.mParams;
                    layoutParams25.bottomToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams27 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams28 = this.mParams;
                    layoutParams27.baselineToBaseline = -1;
                    ConstraintLayout.LayoutParams layoutParams29 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams30 = this.mParams;
                    layoutParams29.baselineToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams31 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams32 = this.mParams;
                    layoutParams31.baselineToBottom = -1;
                } else {
                    if (i3 != 3) {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    this.mParams.bottomToTop = i2;
                    ConstraintLayout.LayoutParams layoutParams33 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams34 = this.mParams;
                    layoutParams33.bottomToBottom = -1;
                    ConstraintLayout.LayoutParams layoutParams35 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams36 = this.mParams;
                    layoutParams35.baselineToBaseline = -1;
                    ConstraintLayout.LayoutParams layoutParams37 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams38 = this.mParams;
                    layoutParams37.baselineToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams39 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams40 = this.mParams;
                    layoutParams39.baselineToBottom = -1;
                }
                this.mParams.bottomMargin = i4;
                return this;
            case 5:
                if (i3 == 5) {
                    this.mParams.baselineToBaseline = i2;
                    ConstraintLayout.LayoutParams layoutParams41 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams42 = this.mParams;
                    layoutParams41.bottomToBottom = -1;
                    ConstraintLayout.LayoutParams layoutParams43 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams44 = this.mParams;
                    layoutParams43.bottomToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams45 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams46 = this.mParams;
                    layoutParams45.topToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams47 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams48 = this.mParams;
                    layoutParams47.topToBottom = -1;
                } else if (i3 == 3) {
                    this.mParams.baselineToTop = i2;
                    ConstraintLayout.LayoutParams layoutParams49 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams50 = this.mParams;
                    layoutParams49.bottomToBottom = -1;
                    ConstraintLayout.LayoutParams layoutParams51 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams52 = this.mParams;
                    layoutParams51.bottomToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams53 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams54 = this.mParams;
                    layoutParams53.topToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams55 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams56 = this.mParams;
                    layoutParams55.topToBottom = -1;
                } else {
                    if (i3 != 4) {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    this.mParams.baselineToBottom = i2;
                    ConstraintLayout.LayoutParams layoutParams57 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams58 = this.mParams;
                    layoutParams57.bottomToBottom = -1;
                    ConstraintLayout.LayoutParams layoutParams59 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams60 = this.mParams;
                    layoutParams59.bottomToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams61 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams62 = this.mParams;
                    layoutParams61.topToTop = -1;
                    ConstraintLayout.LayoutParams layoutParams63 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams64 = this.mParams;
                    layoutParams63.topToBottom = -1;
                }
                this.mParams.baselineMargin = i4;
                return this;
            case 6:
                if (i3 == 6) {
                    this.mParams.startToStart = i2;
                    ConstraintLayout.LayoutParams layoutParams65 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams66 = this.mParams;
                    layoutParams65.startToEnd = -1;
                } else {
                    if (i3 != 7) {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    this.mParams.startToEnd = i2;
                    ConstraintLayout.LayoutParams layoutParams67 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams68 = this.mParams;
                    layoutParams67.startToStart = -1;
                }
                this.mParams.setMarginStart(i4);
                return this;
            case 7:
                if (i3 == 7) {
                    this.mParams.endToEnd = i2;
                    ConstraintLayout.LayoutParams layoutParams69 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams70 = this.mParams;
                    layoutParams69.endToStart = -1;
                } else {
                    if (i3 != 6) {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    this.mParams.endToStart = i2;
                    ConstraintLayout.LayoutParams layoutParams71 = this.mParams;
                    ConstraintLayout.LayoutParams layoutParams72 = this.mParams;
                    layoutParams71.endToEnd = -1;
                }
                this.mParams.setMarginEnd(i4);
                return this;
            default:
                throw new IllegalArgumentException(sideToString(i) + " to " + sideToString(i3) + " unknown");
        }
    }

    public ConstraintProperties constrainDefaultHeight(int i) {
        this.mParams.matchConstraintDefaultHeight = i;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i) {
        this.mParams.matchConstraintDefaultWidth = i;
        return this;
    }

    public ConstraintProperties constrainHeight(int i) {
        this.mParams.height = i;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i) {
        this.mParams.matchConstraintMaxHeight = i;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i) {
        this.mParams.matchConstraintMaxWidth = i;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i) {
        this.mParams.matchConstraintMinHeight = i;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i) {
        this.mParams.matchConstraintMinWidth = i;
        return this;
    }

    public ConstraintProperties constrainWidth(int i) {
        this.mParams.width = i;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f) {
        int i = Build.VERSION.SDK_INT;
        this.mView.setElevation(f);
        return this;
    }

    public ConstraintProperties goneMargin(int i, int i2) {
        switch (i) {
            case 1:
                this.mParams.goneLeftMargin = i2;
                return this;
            case 2:
                this.mParams.goneRightMargin = i2;
                return this;
            case 3:
                this.mParams.goneTopMargin = i2;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i2;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.goneStartMargin = i2;
                return this;
            case 7:
                this.mParams.goneEndMargin = i2;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties horizontalBias(float f) {
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i) {
        this.mParams.horizontalChainStyle = i;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f) {
        this.mParams.horizontalWeight = f;
        return this;
    }

    public ConstraintProperties margin(int i, int i2) {
        switch (i) {
            case 1:
                this.mParams.leftMargin = i2;
                return this;
            case 2:
                this.mParams.rightMargin = i2;
                return this;
            case 3:
                this.mParams.topMargin = i2;
                return this;
            case 4:
                this.mParams.bottomMargin = i2;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.setMarginStart(i2);
                return this;
            case 7:
                this.mParams.setMarginEnd(i2);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeConstraints(int i) {
        switch (i) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.mParams;
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                layoutParams.leftToRight = -1;
                ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                layoutParams3.leftToLeft = -1;
                ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                layoutParams5.leftMargin = -1;
                ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                layoutParams7.goneLeftMargin = Integer.MIN_VALUE;
                return this;
            case 2:
                ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                layoutParams9.rightToRight = -1;
                ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                layoutParams11.rightToLeft = -1;
                ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams14 = this.mParams;
                layoutParams13.rightMargin = -1;
                ConstraintLayout.LayoutParams layoutParams15 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams16 = this.mParams;
                layoutParams15.goneRightMargin = Integer.MIN_VALUE;
                return this;
            case 3:
                ConstraintLayout.LayoutParams layoutParams17 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams18 = this.mParams;
                layoutParams17.topToBottom = -1;
                ConstraintLayout.LayoutParams layoutParams19 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams20 = this.mParams;
                layoutParams19.topToTop = -1;
                ConstraintLayout.LayoutParams layoutParams21 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams22 = this.mParams;
                layoutParams21.topMargin = -1;
                ConstraintLayout.LayoutParams layoutParams23 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams24 = this.mParams;
                layoutParams23.goneTopMargin = Integer.MIN_VALUE;
                return this;
            case 4:
                ConstraintLayout.LayoutParams layoutParams25 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams26 = this.mParams;
                layoutParams25.bottomToTop = -1;
                ConstraintLayout.LayoutParams layoutParams27 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams28 = this.mParams;
                layoutParams27.bottomToBottom = -1;
                ConstraintLayout.LayoutParams layoutParams29 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams30 = this.mParams;
                layoutParams29.bottomMargin = -1;
                ConstraintLayout.LayoutParams layoutParams31 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams32 = this.mParams;
                layoutParams31.goneBottomMargin = Integer.MIN_VALUE;
                return this;
            case 5:
                ConstraintLayout.LayoutParams layoutParams33 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams34 = this.mParams;
                layoutParams33.baselineToBaseline = -1;
                return this;
            case 6:
                ConstraintLayout.LayoutParams layoutParams35 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams36 = this.mParams;
                layoutParams35.startToEnd = -1;
                ConstraintLayout.LayoutParams layoutParams37 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams38 = this.mParams;
                layoutParams37.startToStart = -1;
                ConstraintLayout.LayoutParams layoutParams39 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams40 = this.mParams;
                layoutParams39.setMarginStart(-1);
                ConstraintLayout.LayoutParams layoutParams41 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams42 = this.mParams;
                layoutParams41.goneStartMargin = Integer.MIN_VALUE;
                return this;
            case 7:
                ConstraintLayout.LayoutParams layoutParams43 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams44 = this.mParams;
                layoutParams43.endToStart = -1;
                ConstraintLayout.LayoutParams layoutParams45 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams46 = this.mParams;
                layoutParams45.endToEnd = -1;
                ConstraintLayout.LayoutParams layoutParams47 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams48 = this.mParams;
                layoutParams47.setMarginEnd(-1);
                ConstraintLayout.LayoutParams layoutParams49 = this.mParams;
                ConstraintLayout.LayoutParams layoutParams50 = this.mParams;
                layoutParams49.goneEndMargin = Integer.MIN_VALUE;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (r5 == (-1)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
    
        if (r1 == (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r5 == (-1)) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.constraintlayout.widget.ConstraintProperties removeFromHorizontalChain() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintProperties.removeFromHorizontalChain():androidx.constraintlayout.widget.ConstraintProperties");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r1 == (-1)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r1 == (-1)) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.constraintlayout.widget.ConstraintProperties removeFromVerticalChain() {
        /*
            r12 = this;
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r0 = r12.mParams
            int r0 = r0.topToBottom
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r1 = r12.mParams
            int r1 = r1.bottomToTop
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = r12.mParams
            r2 = 4
            r3 = 3
            r4 = -1
            if (r0 != r4) goto L14
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r5 = r12.mParams
            if (r1 != r4) goto L14
            goto L6e
        L14:
            android.view.View r5 = r12.mView
            android.view.ViewParent r5 = r5.getParent()
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.view.View r5 = r5.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintProperties r6 = new androidx.constraintlayout.widget.ConstraintProperties
            r6.<init>(r5)
            android.view.View r7 = r12.mView
            android.view.ViewParent r7 = r7.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            android.view.View r7 = r7.findViewById(r1)
            androidx.constraintlayout.widget.ConstraintProperties r8 = new androidx.constraintlayout.widget.ConstraintProperties
            r8.<init>(r7)
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r9 = r12.mParams
            r9 = 0
            if (r0 == r4) goto L46
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = r12.mParams
            if (r1 == r4) goto L46
            r6.connect(r2, r1, r3, r9)
            r8.connect(r3, r0, r2, r9)
            goto L6e
        L46:
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = r12.mParams
            if (r0 != r4) goto L4f
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = r12.mParams
            if (r1 != r4) goto L4f
            goto L6e
        L4f:
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = r12.mParams
            int r10 = r10.bottomToBottom
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r11 = r12.mParams
            if (r10 == r4) goto L5f
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = r12.mParams
            int r4 = r4.bottomToBottom
            r6.connect(r2, r4, r2, r9)
            goto L6e
        L5f:
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = r12.mParams
            int r10 = r10.topToTop
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r11 = r12.mParams
            if (r10 == r4) goto L6e
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = r12.mParams
            int r4 = r4.topToTop
            r8.connect(r3, r4, r3, r9)
        L6e:
            r12.removeConstraints(r3)
            r12.removeConstraints(r2)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintProperties.removeFromVerticalChain():androidx.constraintlayout.widget.ConstraintProperties");
    }

    public ConstraintProperties rotation(float f) {
        this.mView.setRotation(f);
        return this;
    }

    public ConstraintProperties rotationX(float f) {
        this.mView.setRotationX(f);
        return this;
    }

    public ConstraintProperties rotationY(float f) {
        this.mView.setRotationY(f);
        return this;
    }

    public ConstraintProperties scaleX(float f) {
        this.mView.setScaleY(f);
        return this;
    }

    public ConstraintProperties scaleY(float f) {
        return this;
    }

    public ConstraintProperties transformPivot(float f, float f2) {
        this.mView.setPivotX(f);
        this.mView.setPivotY(f2);
        return this;
    }

    public ConstraintProperties transformPivotX(float f) {
        this.mView.setPivotX(f);
        return this;
    }

    public ConstraintProperties transformPivotY(float f) {
        this.mView.setPivotY(f);
        return this;
    }

    public ConstraintProperties translation(float f, float f2) {
        this.mView.setTranslationX(f);
        this.mView.setTranslationY(f2);
        return this;
    }

    public ConstraintProperties translationX(float f) {
        this.mView.setTranslationX(f);
        return this;
    }

    public ConstraintProperties translationY(float f) {
        this.mView.setTranslationY(f);
        return this;
    }

    public ConstraintProperties translationZ(float f) {
        int i = Build.VERSION.SDK_INT;
        this.mView.setTranslationZ(f);
        return this;
    }

    public ConstraintProperties verticalBias(float f) {
        this.mParams.verticalBias = f;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i) {
        this.mParams.verticalChainStyle = i;
        return this;
    }

    public ConstraintProperties verticalWeight(float f) {
        this.mParams.verticalWeight = f;
        return this;
    }

    public ConstraintProperties visibility(int i) {
        this.mView.setVisibility(i);
        return this;
    }
}
