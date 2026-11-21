package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {
    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mHelperState.constraints(it.next()).clearHorizontal();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            ConstraintReference constraints = this.mHelperState.constraints(next);
            if (constraintReference == null) {
                constraintReference = constraints;
                if (this.mStartToStart != null) {
                    constraintReference.startToStart(this.mStartToStart).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                } else if (this.mStartToEnd != null) {
                    constraintReference.startToEnd(this.mStartToEnd).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                } else if (this.mLeftToLeft != null) {
                    constraintReference.startToStart(this.mLeftToLeft).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                } else if (this.mLeftToRight != null) {
                    constraintReference.startToEnd(this.mLeftToRight).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                } else {
                    String obj = constraints.getKey().toString();
                    constraintReference.startToStart(State.PARENT).margin(Float.valueOf(getPreMargin(obj))).marginGone(Float.valueOf(getPreGoneMargin(obj)));
                }
            }
            if (constraintReference2 != null) {
                String obj2 = constraintReference2.getKey().toString();
                String obj3 = constraints.getKey().toString();
                constraintReference2.endToStart(constraints.getKey()).margin(Float.valueOf(getPostMargin(obj2))).marginGone(Float.valueOf(getPostGoneMargin(obj2)));
                constraints.startToEnd(constraintReference2.getKey()).margin(Float.valueOf(getPreMargin(obj3))).marginGone(Float.valueOf(getPreGoneMargin(obj3)));
            }
            float weight = getWeight(next.toString());
            if (weight != -1.0f) {
                constraints.setHorizontalChainWeight(weight);
            }
            constraintReference2 = constraints;
        }
        if (constraintReference2 != null) {
            if (this.mEndToStart != null) {
                constraintReference2.endToStart(this.mEndToStart).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
            } else if (this.mEndToEnd != null) {
                constraintReference2.endToEnd(this.mEndToEnd).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
            } else if (this.mRightToLeft != null) {
                constraintReference2.endToStart(this.mRightToLeft).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
            } else if (this.mRightToRight != null) {
                constraintReference2.endToEnd(this.mRightToRight).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
            } else {
                String obj4 = constraintReference2.getKey().toString();
                constraintReference2.endToEnd(State.PARENT).margin(Float.valueOf(getPostMargin(obj4))).marginGone(Float.valueOf(getPostGoneMargin(obj4)));
            }
        }
        if (constraintReference == null) {
            return;
        }
        if (this.mBias != 0.5f) {
            constraintReference.horizontalBias(this.mBias);
        }
        switch (this.mStyle) {
            case SPREAD:
                constraintReference.setHorizontalChainStyle(0);
                return;
            case SPREAD_INSIDE:
                constraintReference.setHorizontalChainStyle(1);
                return;
            case PACKED:
                constraintReference.setHorizontalChainStyle(2);
                return;
            default:
                return;
        }
    }
}
