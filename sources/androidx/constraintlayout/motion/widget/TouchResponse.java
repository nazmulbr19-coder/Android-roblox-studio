package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class TouchResponse {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-7f;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    static final int FLAG_SUPPORT_SCROLL_UP = 4;
    private static final int SEC_TO_MILLISECONDS = 1000;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float[] mAnchorDpDt;
    private int mAutoCompleteMode;
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    boolean mIsRotateMode;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
    float mRotateCenterX;
    float mRotateCenterY;
    private int mRotationCenterId;
    private int mSpringBoundary;
    private float mSpringDamping;
    private float mSpringMass;
    private float mSpringStiffness;
    private float mSpringStopThreshold;
    private int[] mTempLoc;
    private int mTouchAnchorId;
    private int mTouchAnchorSide;
    private float mTouchAnchorX;
    private float mTouchAnchorY;
    private float mTouchDirectionX;
    private float mTouchDirectionY;
    private int mTouchRegionId;
    private int mTouchSide;
    private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: androidx.constraintlayout.motion.widget.TouchResponse$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnTouchListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.TouchResponse$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {
        AnonymousClass2() {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TouchResponse(MotionLayout motionLayout, OnSwipe onSwipe) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = motionLayout;
        this.mTouchAnchorId = onSwipe.getTouchAnchorId();
        this.mTouchAnchorSide = onSwipe.getTouchAnchorSide();
        if (this.mTouchAnchorSide != -1) {
            this.mTouchAnchorX = TOUCH_SIDES[this.mTouchAnchorSide][0];
            this.mTouchAnchorY = TOUCH_SIDES[this.mTouchAnchorSide][1];
        }
        this.mTouchSide = onSwipe.getDragDirection();
        if (this.mTouchSide < TOUCH_DIRECTION.length) {
            this.mTouchDirectionX = TOUCH_DIRECTION[this.mTouchSide][0];
            this.mTouchDirectionY = TOUCH_DIRECTION[this.mTouchSide][1];
        } else {
            this.mTouchDirectionY = Float.NaN;
            this.mTouchDirectionX = Float.NaN;
            this.mIsRotateMode = true;
        }
        this.mMaxVelocity = onSwipe.getMaxVelocity();
        this.mMaxAcceleration = onSwipe.getMaxAcceleration();
        this.mMoveWhenScrollAtTop = onSwipe.getMoveWhenScrollAtTop();
        this.mDragScale = onSwipe.getDragScale();
        this.mDragThreshold = onSwipe.getDragThreshold();
        this.mTouchRegionId = onSwipe.getTouchRegionId();
        this.mOnTouchUp = onSwipe.getOnTouchUp();
        this.mFlags = onSwipe.getNestedScrollFlags();
        this.mLimitBoundsTo = onSwipe.getLimitBoundsTo();
        this.mRotationCenterId = onSwipe.getRotationCenterId();
        this.mSpringBoundary = onSwipe.getSpringBoundary();
        this.mSpringDamping = onSwipe.getSpringDamping();
        this.mSpringMass = onSwipe.getSpringMass();
        this.mSpringStiffness = onSwipe.getSpringStiffness();
        this.mSpringStopThreshold = onSwipe.getSpringStopThreshold();
        this.mAutoCompleteMode = onSwipe.getAutoCompleteMode();
    }

    private void fill(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                this.mTouchAnchorSide = typedArray.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorX = TOUCH_SIDES[this.mTouchAnchorSide][0];
                this.mTouchAnchorY = TOUCH_SIDES[this.mTouchAnchorSide][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                this.mTouchSide = typedArray.getInt(index, this.mTouchSide);
                if (this.mTouchSide < TOUCH_DIRECTION.length) {
                    this.mTouchDirectionX = TOUCH_DIRECTION[this.mTouchSide][0];
                    this.mTouchDirectionY = TOUCH_DIRECTION[this.mTouchSide][1];
                } else {
                    this.mTouchDirectionY = Float.NaN;
                    this.mTouchDirectionX = Float.NaN;
                    this.mIsRotateMode = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(index, this.mDragScale);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.mRotationCenterId = typedArray.getResourceId(index, this.mRotationCenterId);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.mSpringDamping = typedArray.getFloat(index, this.mSpringDamping);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.mSpringMass = typedArray.getFloat(index, this.mSpringMass);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.mSpringStiffness = typedArray.getFloat(index, this.mSpringStiffness);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.mSpringStopThreshold = typedArray.getFloat(index, this.mSpringStopThreshold);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.mSpringBoundary = typedArray.getInt(index, this.mSpringBoundary);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.mAutoCompleteMode = typedArray.getInt(index, this.mAutoCompleteMode);
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dot(float f, float f2) {
        return (this.mTouchDirectionX * f) + (this.mTouchDirectionY * f2);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public int getFlags() {
        return this.mFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        if (this.mLimitBoundsTo == -1 || (findViewById = viewGroup.findViewById(this.mLimitBoundsTo)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getProgressDirection(float f, float f2) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        if (this.mTouchDirectionX != 0.0f) {
            if (this.mAnchorDpDt[0] == 0.0f) {
                this.mAnchorDpDt[0] = 1.0E-7f;
            }
            return (this.mTouchDirectionX * f) / this.mAnchorDpDt[0];
        }
        if (this.mAnchorDpDt[1] == 0.0f) {
            this.mAnchorDpDt[1] = 1.0E-7f;
        }
        return (this.mTouchDirectionY * f2) / this.mAnchorDpDt[1];
    }

    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        if (this.mTouchRegionId == -1 || (findViewById = viewGroup.findViewById(this.mTouchRegionId)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDragStarted() {
        return this.mDragStarted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    public void processTouchEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i, MotionScene motionScene) {
        char c;
        ?? r21;
        float f;
        ?? r22;
        if (this.mIsRotateMode) {
            processTouchRotateEvent(motionEvent, motionTracker, i, motionScene);
            return;
        }
        motionTracker.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mDragStarted = false;
                return;
            case 1:
                this.mDragStarted = false;
                motionTracker.computeCurrentVelocity(1000);
                float xVelocity = motionTracker.getXVelocity();
                float yVelocity = motionTracker.getYVelocity();
                float progress = this.mMotionLayout.getProgress();
                float f2 = progress;
                if (this.mTouchAnchorId != -1) {
                    this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                    c = 0;
                } else {
                    float min = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                    this.mAnchorDpDt[1] = this.mTouchDirectionY * min;
                    c = 0;
                    this.mAnchorDpDt[0] = this.mTouchDirectionX * min;
                }
                float f3 = (this.mTouchDirectionX * this.mAnchorDpDt[c]) + (this.mTouchDirectionY * this.mAnchorDpDt[1]);
                float f4 = this.mTouchDirectionX != 0.0f ? xVelocity / this.mAnchorDpDt[0] : yVelocity / this.mAnchorDpDt[1];
                if (!Float.isNaN(f4)) {
                    f2 += f4 / 3.0f;
                }
                if (f2 == 0.0f || f2 == 1.0f || this.mOnTouchUp == 3) {
                    if (0.0f >= f2 || 1.0f <= f2) {
                        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        return;
                    }
                    return;
                }
                float f5 = ((double) f2) < 0.5d ? 0.0f : 1.0f;
                if (this.mOnTouchUp == 6) {
                    if (progress + f4 < 0.0f) {
                        f4 = Math.abs(f4);
                    }
                    f5 = 1.0f;
                }
                if (this.mOnTouchUp == 7) {
                    if (progress + f4 > 1.0f) {
                        f4 = -Math.abs(f4);
                    }
                    f5 = 0.0f;
                }
                this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, f5, f4);
                if (0.0f >= progress || 1.0f <= progress) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            case 2:
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if (Math.abs((this.mTouchDirectionX * rawX) + (this.mTouchDirectionY * rawY)) > this.mDragThreshold || this.mDragStarted) {
                    float progress2 = this.mMotionLayout.getProgress();
                    if (!this.mDragStarted) {
                        this.mDragStarted = true;
                        this.mMotionLayout.setProgress(progress2);
                    }
                    if (this.mTouchAnchorId != -1) {
                        r21 = 1;
                        r22 = 0;
                        f = progress2;
                        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                    } else {
                        r21 = 1;
                        f = progress2;
                        r22 = 0;
                        float min2 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                        this.mAnchorDpDt[1] = this.mTouchDirectionY * min2;
                        this.mAnchorDpDt[0] = this.mTouchDirectionX * min2;
                    }
                    if (Math.abs(((this.mTouchDirectionX * this.mAnchorDpDt[r22]) + (this.mTouchDirectionY * this.mAnchorDpDt[r21])) * this.mDragScale) < 0.01d) {
                        this.mAnchorDpDt[r22] = 0.01f;
                        this.mAnchorDpDt[r21] = 0.01f;
                    }
                    float max = Math.max(Math.min(f + (this.mTouchDirectionX != 0.0f ? rawX / this.mAnchorDpDt[r22] : rawY / this.mAnchorDpDt[r21]), 1.0f), 0.0f);
                    if (this.mOnTouchUp == 6) {
                        max = Math.max(max, 0.01f);
                    }
                    if (this.mOnTouchUp == 7) {
                        max = Math.min(max, 0.99f);
                    }
                    float progress3 = this.mMotionLayout.getProgress();
                    if (max != progress3) {
                        if (progress3 == 0.0f || progress3 == 1.0f) {
                            this.mMotionLayout.endTrigger(progress3 == 0.0f ? r21 : r22);
                        }
                        this.mMotionLayout.setProgress(max);
                        motionTracker.computeCurrentVelocity(1000);
                        this.mMotionLayout.mLastVelocity = this.mTouchDirectionX != 0.0f ? motionTracker.getXVelocity() / this.mAnchorDpDt[r22] : motionTracker.getYVelocity() / this.mAnchorDpDt[r21];
                    } else {
                        this.mMotionLayout.mLastVelocity = 0.0f;
                    }
                    this.mLastTouchX = motionEvent.getRawX();
                    this.mLastTouchY = motionEvent.getRawY();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02f1  */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void processTouchRotateEvent(android.view.MotionEvent r31, androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker r32, int r33, androidx.constraintlayout.motion.widget.MotionScene r34) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.TouchResponse.processTouchRotateEvent(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker, int, androidx.constraintlayout.motion.widget.MotionScene):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollMove(float f, float f2) {
        float f3 = (this.mTouchDirectionX * f) + (this.mTouchDirectionY * f2);
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        if (Math.abs((this.mTouchDirectionX * this.mAnchorDpDt[0]) + (this.mTouchDirectionY * this.mAnchorDpDt[1])) < 0.01d) {
            this.mAnchorDpDt[0] = 0.01f;
            this.mAnchorDpDt[1] = 0.01f;
        }
        float max = Math.max(Math.min(progress + (this.mTouchDirectionX != 0.0f ? (this.mTouchDirectionX * f) / this.mAnchorDpDt[0] : (this.mTouchDirectionY * f2) / this.mAnchorDpDt[1]), 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollUp(float f, float f2) {
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f3 = (this.mTouchDirectionX * this.mAnchorDpDt[0]) + (this.mTouchDirectionY * this.mAnchorDpDt[1]);
        float f4 = this.mTouchDirectionX != 0.0f ? (this.mTouchDirectionX * f) / this.mAnchorDpDt[0] : (this.mTouchDirectionY * f2) / this.mAnchorDpDt[1];
        if (!Float.isNaN(f4)) {
            progress += f4 / 3.0f;
        }
        if (progress == 0.0f || progress == 1.0f || this.mOnTouchUp == 3) {
            return;
        }
        this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f4);
    }

    public void setAnchorId(int i) {
        this.mTouchAnchorId = i;
    }

    void setAutoCompleteMode(int i) {
        this.mAutoCompleteMode = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDown(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
    }

    public void setMaxAcceleration(float f) {
        this.mMaxAcceleration = f;
    }

    public void setMaxVelocity(float f) {
        this.mMaxVelocity = f;
    }

    public void setRTL(boolean z) {
        if (z) {
            TOUCH_DIRECTION[4] = TOUCH_DIRECTION[3];
            TOUCH_DIRECTION[5] = TOUCH_DIRECTION[2];
            TOUCH_SIDES[5] = TOUCH_SIDES[2];
            TOUCH_SIDES[6] = TOUCH_SIDES[1];
        } else {
            TOUCH_DIRECTION[4] = TOUCH_DIRECTION[2];
            TOUCH_DIRECTION[5] = TOUCH_DIRECTION[3];
            TOUCH_SIDES[5] = TOUCH_SIDES[1];
            TOUCH_SIDES[6] = TOUCH_SIDES[2];
        }
        this.mTouchAnchorX = TOUCH_SIDES[this.mTouchAnchorSide][0];
        this.mTouchAnchorY = TOUCH_SIDES[this.mTouchAnchorSide][1];
        if (this.mTouchSide >= TOUCH_DIRECTION.length) {
            return;
        }
        this.mTouchDirectionX = TOUCH_DIRECTION[this.mTouchSide][0];
        this.mTouchDirectionY = TOUCH_DIRECTION[this.mTouchSide][1];
    }

    public void setTouchAnchorLocation(float f, float f2) {
        this.mTouchAnchorX = f;
        this.mTouchAnchorY = f2;
    }

    public void setTouchUpMode(int i) {
        this.mOnTouchUp = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUpTouchEvent(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
        this.mDragStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupTouch() {
        View view = null;
        if (this.mTouchAnchorId != -1 && (view = this.mMotionLayout.findViewById(this.mTouchAnchorId)) == null) {
            Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new AnonymousClass1());
            nestedScrollView.setOnScrollChangeListener(new AnonymousClass2());
        }
    }

    public String toString() {
        return Float.isNaN(this.mTouchDirectionX) ? Key.ROTATION : this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
