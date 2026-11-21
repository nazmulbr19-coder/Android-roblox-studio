package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {
    private static final String TAG = "CircularFlow";
    private float[] mAngles;
    ConstraintLayout mContainer;
    private int mCountAngle;
    private int mCountRadius;
    private int[] mRadius;
    private String mReferenceAngles;
    private Float mReferenceDefaultAngle;
    private Integer mReferenceDefaultRadius;
    private String mReferenceRadius;
    int mViewCenter;
    private static int sDefaultRadius = 0;
    private static float sDefaultAngle = 0.0f;

    public CircularFlow(Context context) {
        super(context);
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void addAngle(String str) {
        if (str == null || str.length() == 0 || this.myContext == null || this.mAngles == null) {
            return;
        }
        if (this.mCountAngle + 1 > this.mAngles.length) {
            this.mAngles = Arrays.copyOf(this.mAngles, this.mAngles.length + 1);
        }
        this.mAngles[this.mCountAngle] = Integer.parseInt(str);
        this.mCountAngle++;
    }

    private void addRadius(String str) {
        if (str == null || str.length() == 0 || this.myContext == null || this.mRadius == null) {
            return;
        }
        if (this.mCountRadius + 1 > this.mRadius.length) {
            this.mRadius = Arrays.copyOf(this.mRadius, this.mRadius.length + 1);
        }
        this.mRadius[this.mCountRadius] = (int) (Integer.parseInt(str) * this.myContext.getResources().getDisplayMetrics().density);
        this.mCountRadius++;
    }

    private void anchorReferences() {
        this.mContainer = (ConstraintLayout) getParent();
        for (int i = 0; i < this.mCount; i++) {
            View viewById = this.mContainer.getViewById(this.mIds[i]);
            if (viewById != null) {
                int i2 = sDefaultRadius;
                float f = sDefaultAngle;
                if (this.mRadius != null && i < this.mRadius.length) {
                    i2 = this.mRadius[i];
                } else if (this.mReferenceDefaultRadius == null || this.mReferenceDefaultRadius.intValue() == -1) {
                    Log.e(TAG, "Added radius to view with id: " + this.mMap.get(Integer.valueOf(viewById.getId())));
                } else {
                    this.mCountRadius++;
                    if (this.mRadius == null) {
                        this.mRadius = new int[1];
                    }
                    this.mRadius = getRadius();
                    this.mRadius[this.mCountRadius - 1] = i2;
                }
                if (this.mAngles != null && i < this.mAngles.length) {
                    f = this.mAngles[i];
                } else if (this.mReferenceDefaultAngle == null || this.mReferenceDefaultAngle.floatValue() == -1.0f) {
                    Log.e(TAG, "Added angle to view with id: " + this.mMap.get(Integer.valueOf(viewById.getId())));
                } else {
                    this.mCountAngle++;
                    if (this.mAngles == null) {
                        this.mAngles = new float[1];
                    }
                    this.mAngles = getAngles();
                    this.mAngles[this.mCountAngle - 1] = f;
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.circleAngle = f;
                layoutParams.circleConstraint = this.mViewCenter;
                layoutParams.circleRadius = i2;
                viewById.setLayoutParams(layoutParams);
            }
        }
        applyLayoutFeatures();
    }

    private float[] removeAngle(float[] fArr, int i) {
        return (fArr == null || i < 0 || i >= this.mCountAngle) ? fArr : removeElementFromArray(fArr, i);
    }

    private static float[] removeElementFromArray(float[] fArr, int i) {
        float[] fArr2 = new float[fArr.length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < fArr.length; i3++) {
            if (i3 != i) {
                fArr2[i2] = fArr[i3];
                i2++;
            }
        }
        return fArr2;
    }

    private static int[] removeElementFromArray(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i3 != i) {
                iArr2[i2] = iArr[i3];
                i2++;
            }
        }
        return iArr2;
    }

    private int[] removeRadius(int[] iArr, int i) {
        return (iArr == null || i < 0 || i >= this.mCountRadius) ? iArr : removeElementFromArray(iArr, i);
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCountAngle = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                addAngle(str.substring(i).trim());
                return;
            } else {
                addAngle(str.substring(i, indexOf).trim());
                i = indexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCountRadius = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                addRadius(str.substring(i).trim());
                return;
            } else {
                addRadius(str.substring(i, indexOf).trim());
                i = indexOf + 1;
            }
        }
    }

    public void addViewToCircularFlow(View view, int i, float f) {
        if (containsId(view.getId())) {
            return;
        }
        addView(view);
        this.mCountAngle++;
        this.mAngles = getAngles();
        this.mAngles[this.mCountAngle - 1] = f;
        this.mCountRadius++;
        this.mRadius = getRadius();
        this.mRadius[this.mCountRadius - 1] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        anchorReferences();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.mAngles, this.mCountAngle);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.mRadius, this.mCountRadius);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.mViewCenter = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    this.mReferenceAngles = obtainStyledAttributes.getString(index);
                    setAngles(this.mReferenceAngles);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    this.mReferenceRadius = obtainStyledAttributes.getString(index);
                    setRadius(this.mReferenceRadius);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    this.mReferenceDefaultAngle = Float.valueOf(obtainStyledAttributes.getFloat(index, sDefaultAngle));
                    setDefaultAngle(this.mReferenceDefaultAngle.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    this.mReferenceDefaultRadius = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, sDefaultRadius));
                    setDefaultRadius(this.mReferenceDefaultRadius.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isUpdatable(View view) {
        return containsId(view.getId()) && indexFromId(view.getId()) != -1;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mReferenceAngles != null) {
            this.mAngles = new float[1];
            setAngles(this.mReferenceAngles);
        }
        if (this.mReferenceRadius != null) {
            this.mRadius = new int[1];
            setRadius(this.mReferenceRadius);
        }
        if (this.mReferenceDefaultAngle != null) {
            setDefaultAngle(this.mReferenceDefaultAngle.floatValue());
        }
        if (this.mReferenceDefaultRadius != null) {
            setDefaultRadius(this.mReferenceDefaultRadius.intValue());
        }
        anchorReferences();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int removeView(View view) {
        int removeView = super.removeView(view);
        if (removeView == -1) {
            return removeView;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.mContainer);
        constraintSet.clear(view.getId(), 8);
        constraintSet.applyTo(this.mContainer);
        if (removeView < this.mAngles.length) {
            this.mAngles = removeAngle(this.mAngles, removeView);
            this.mCountAngle--;
        }
        if (removeView < this.mRadius.length) {
            this.mRadius = removeRadius(this.mRadius, removeView);
            this.mCountRadius--;
        }
        anchorReferences();
        return removeView;
    }

    public void setDefaultAngle(float f) {
        sDefaultAngle = f;
    }

    public void setDefaultRadius(int i) {
        sDefaultRadius = i;
    }

    public void updateAngle(View view, float f) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.mAngles.length) {
            return;
        }
        this.mAngles = getAngles();
        this.mAngles[indexFromId] = f;
        anchorReferences();
    }

    public void updateRadius(View view, int i) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.mRadius.length) {
            return;
        }
        this.mRadius = getRadius();
        this.mRadius[indexFromId] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        anchorReferences();
    }

    public void updateReference(View view, int i, float f) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (getAngles().length > indexFromId) {
            this.mAngles = getAngles();
            this.mAngles[indexFromId] = f;
        }
        if (getRadius().length > indexFromId) {
            this.mRadius = getRadius();
            this.mRadius[indexFromId] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        }
        anchorReferences();
    }
}
