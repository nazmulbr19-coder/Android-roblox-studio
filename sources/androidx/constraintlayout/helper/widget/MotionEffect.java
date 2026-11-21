package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int mFadeMove;
    private float mMotionEffectAlpha;
    private int mMotionEffectEnd;
    private int mMotionEffectStart;
    private boolean mMotionEffectStrictMove;
    private int mMotionEffectTranslationX;
    private int mMotionEffectTranslationY;
    private int mViewTransitionId;

    public MotionEffect(Context context) {
        super(context);
        this.mMotionEffectAlpha = 0.1f;
        this.mMotionEffectStart = 49;
        this.mMotionEffectEnd = 50;
        this.mMotionEffectTranslationX = 0;
        this.mMotionEffectTranslationY = 0;
        this.mMotionEffectStrictMove = true;
        this.mViewTransitionId = -1;
        this.mFadeMove = -1;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMotionEffectAlpha = 0.1f;
        this.mMotionEffectStart = 49;
        this.mMotionEffectEnd = 50;
        this.mMotionEffectTranslationX = 0;
        this.mMotionEffectTranslationY = 0;
        this.mMotionEffectStrictMove = true;
        this.mViewTransitionId = -1;
        this.mFadeMove = -1;
        init(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMotionEffectAlpha = 0.1f;
        this.mMotionEffectStart = 49;
        this.mMotionEffectEnd = 50;
        this.mMotionEffectTranslationX = 0;
        this.mMotionEffectTranslationY = 0;
        this.mMotionEffectStrictMove = true;
        this.mViewTransitionId = -1;
        this.mFadeMove = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    this.mMotionEffectStart = obtainStyledAttributes.getInt(index, this.mMotionEffectStart);
                    this.mMotionEffectStart = Math.max(Math.min(this.mMotionEffectStart, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    this.mMotionEffectEnd = obtainStyledAttributes.getInt(index, this.mMotionEffectEnd);
                    this.mMotionEffectEnd = Math.max(Math.min(this.mMotionEffectEnd, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.mMotionEffectTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMotionEffectTranslationX);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.mMotionEffectTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMotionEffectTranslationY);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.mMotionEffectAlpha = obtainStyledAttributes.getFloat(index, this.mMotionEffectAlpha);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.mFadeMove = obtainStyledAttributes.getInt(index, this.mFadeMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.mMotionEffectStrictMove = obtainStyledAttributes.getBoolean(index, this.mMotionEffectStrictMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.mViewTransitionId = obtainStyledAttributes.getResourceId(index, this.mViewTransitionId);
                }
            }
            if (this.mMotionEffectStart == this.mMotionEffectEnd) {
                if (this.mMotionEffectStart > 0) {
                    this.mMotionEffectStart--;
                } else {
                    this.mMotionEffectEnd++;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
        int i;
        int i2;
        View[] viewArr;
        HashMap<View, MotionController> hashMap2 = hashMap;
        View[] views = getViews((ConstraintLayout) getParent());
        if (views == null) {
            Log.v(TAG, Debug.getLoc() + " views = null");
            return;
        }
        Key keyAttributes = new KeyAttributes();
        Key keyAttributes2 = new KeyAttributes();
        keyAttributes.setValue("alpha", Float.valueOf(this.mMotionEffectAlpha));
        keyAttributes2.setValue("alpha", Float.valueOf(this.mMotionEffectAlpha));
        keyAttributes.setFramePosition(this.mMotionEffectStart);
        keyAttributes2.setFramePosition(this.mMotionEffectEnd);
        KeyPosition keyPosition = new KeyPosition();
        keyPosition.setFramePosition(this.mMotionEffectStart);
        keyPosition.setType(0);
        keyPosition.setValue("percentX", 0);
        keyPosition.setValue("percentY", 0);
        KeyPosition keyPosition2 = new KeyPosition();
        keyPosition2.setFramePosition(this.mMotionEffectEnd);
        keyPosition2.setType(0);
        int i3 = 1;
        keyPosition2.setValue("percentX", 1);
        keyPosition2.setValue("percentY", 1);
        Key key = null;
        Key key2 = null;
        if (this.mMotionEffectTranslationX > 0) {
            key = new KeyAttributes();
            key2 = new KeyAttributes();
            key.setValue("translationX", Integer.valueOf(this.mMotionEffectTranslationX));
            key.setFramePosition(this.mMotionEffectEnd);
            key2.setValue("translationX", 0);
            key2.setFramePosition(this.mMotionEffectEnd - 1);
        }
        Key key3 = null;
        Key key4 = null;
        if (this.mMotionEffectTranslationY > 0) {
            key3 = new KeyAttributes();
            key4 = new KeyAttributes();
            key3.setValue("translationY", Integer.valueOf(this.mMotionEffectTranslationY));
            key3.setFramePosition(this.mMotionEffectEnd);
            key4.setValue("translationY", 0);
            key4.setFramePosition(this.mMotionEffectEnd - 1);
        }
        int i4 = this.mFadeMove;
        int i5 = 3;
        if (this.mFadeMove == -1) {
            int[] iArr = new int[4];
            int i6 = 0;
            i2 = 2;
            while (true) {
                i = i3;
                if (i6 >= views.length) {
                    break;
                }
                MotionController motionController = hashMap2.get(views[i6]);
                if (motionController != null) {
                    float finalX = motionController.getFinalX() - motionController.getStartX();
                    float finalY = motionController.getFinalY() - motionController.getStartY();
                    if (finalY < 0.0f) {
                        iArr[i] = iArr[i] + 1;
                    }
                    if (finalY > 0.0f) {
                        iArr[0] = iArr[0] + 1;
                    }
                    if (finalX > 0.0f) {
                        iArr[3] = iArr[3] + 1;
                    }
                    if (finalX < 0.0f) {
                        iArr[2] = iArr[2] + 1;
                    }
                }
                i6++;
                i3 = i;
            }
            int i7 = iArr[0];
            int i8 = 0;
            int i9 = 1;
            for (int i10 = 4; i9 < i10; i10 = 4) {
                if (i7 < iArr[i9]) {
                    i7 = iArr[i9];
                    i8 = i9;
                }
                i9++;
            }
            i4 = i8;
        } else {
            i = 1;
            i2 = 2;
        }
        int i11 = 0;
        while (i11 < views.length) {
            MotionController motionController2 = hashMap2.get(views[i11]);
            if (motionController2 == null) {
                viewArr = views;
            } else {
                float finalX2 = motionController2.getFinalX() - motionController2.getStartX();
                float finalY2 = motionController2.getFinalY() - motionController2.getStartY();
                boolean z = true;
                if (i4 == 0) {
                    if (finalY2 > 0.0f && (!this.mMotionEffectStrictMove || finalX2 == 0.0f)) {
                        z = false;
                    }
                } else if (i4 == i) {
                    if (finalY2 < 0.0f && (!this.mMotionEffectStrictMove || finalX2 == 0.0f)) {
                        z = false;
                    }
                } else if (i4 == i2) {
                    if (finalX2 < 0.0f && (!this.mMotionEffectStrictMove || finalY2 == 0.0f)) {
                        z = false;
                    }
                } else if (i4 == i5 && finalX2 > 0.0f && (!this.mMotionEffectStrictMove || finalY2 == 0.0f)) {
                    z = false;
                }
                if (z) {
                    viewArr = views;
                    if (this.mViewTransitionId == -1) {
                        motionController2.addKey(keyAttributes);
                        motionController2.addKey(keyAttributes2);
                        motionController2.addKey(keyPosition);
                        motionController2.addKey(keyPosition2);
                        if (this.mMotionEffectTranslationX > 0) {
                            motionController2.addKey(key);
                            motionController2.addKey(key2);
                        }
                        if (this.mMotionEffectTranslationY > 0) {
                            motionController2.addKey(key3);
                            motionController2.addKey(key4);
                        }
                    } else {
                        motionLayout.applyViewTransition(this.mViewTransitionId, motionController2);
                    }
                } else {
                    viewArr = views;
                }
            }
            i11++;
            hashMap2 = hashMap;
            views = viewArr;
            i5 = 3;
            i = 1;
            i2 = 2;
        }
    }
}
