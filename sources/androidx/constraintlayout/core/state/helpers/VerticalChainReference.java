package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* loaded from: classes.dex */
public class VerticalChainReference extends ChainReference {
    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mHelperState.constraints(it.next()).clearVertical();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            ConstraintReference constraints = this.mHelperState.constraints(next);
            if (constraintReference == null) {
                constraintReference = constraints;
                if (this.mTopToTop != null) {
                    constraintReference.topToTop(this.mTopToTop).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
                } else if (this.mTopToBottom != null) {
                    constraintReference.topToBottom(this.mTopToBottom).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
                } else {
                    String obj = constraints.getKey().toString();
                    constraintReference.topToTop(State.PARENT).margin(Float.valueOf(getPreMargin(obj))).marginGone(Float.valueOf(getPreGoneMargin(obj)));
                }
            }
            if (constraintReference2 != null) {
                String obj2 = constraintReference2.getKey().toString();
                String obj3 = constraints.getKey().toString();
                constraintReference2.bottomToTop(constraints.getKey()).margin(Float.valueOf(getPostMargin(obj2))).marginGone(Float.valueOf(getPostGoneMargin(obj2)));
                constraints.topToBottom(constraintReference2.getKey()).margin(Float.valueOf(getPreMargin(obj3))).marginGone(Float.valueOf(getPreGoneMargin(obj3)));
            }
            float weight = getWeight(next.toString());
            if (weight != -1.0f) {
                constraints.setVerticalChainWeight(weight);
            }
            constraintReference2 = constraints;
        }
        if (constraintReference2 != null) {
            if (this.mBottomToTop != null) {
                constraintReference2.bottomToTop(this.mBottomToTop).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
            } else if (this.mBottomToBottom != null) {
                constraintReference2.bottomToBottom(this.mBottomToBottom).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
            } else {
                String obj4 = constraintReference2.getKey().toString();
                constraintReference2.bottomToBottom(State.PARENT).margin(Float.valueOf(getPostMargin(obj4))).marginGone(Float.valueOf(getPostGoneMargin(obj4)));
            }
        }
        if (constraintReference == null) {
            return;
        }
        if (this.mBias != 0.5f) {
            constraintReference.verticalBias(this.mBias);
        }
        switch (this.mStyle) {
            case SPREAD:
                constraintReference.setVerticalChainStyle(0);
                return;
            case SPREAD_INSIDE:
                constraintReference.setVerticalChainStyle(1);
                return;
            case PACKED:
                constraintReference.setVerticalChainStyle(2);
                return;
            default:
                return;
        }
    }
}
