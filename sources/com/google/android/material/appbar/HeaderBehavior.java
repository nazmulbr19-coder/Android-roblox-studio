package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;

/* loaded from: classes.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    /* loaded from: classes.dex */
    private class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.layout == null || HeaderBehavior.this.scroller == null) {
                return;
            }
            if (!HeaderBehavior.this.scroller.computeScrollOffset()) {
                HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
            } else {
                HeaderBehavior.this.setHeaderTopBottomOffset(this.parent, this.layout, HeaderBehavior.this.scroller.getCurrY());
                this.layout.postOnAnimation(this);
            }
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    boolean canDragView(V v) {
        return false;
    }

    final boolean fling(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.flingRunnable != null) {
            v.removeCallbacks(this.flingRunnable);
            this.flingRunnable = null;
        }
        if (this.scroller == null) {
            this.scroller = new OverScroller(v.getContext());
        }
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.scroller.computeScrollOffset()) {
            onFlingFinished(coordinatorLayout, v);
            return false;
        }
        this.flingRunnable = new FlingRunnable(coordinatorLayout, v);
        v.postOnAnimation(this.flingRunnable);
        return true;
    }

    int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            if (this.activePointerId == -1 || (findPointerIndex = motionEvent.findPointerIndex(this.activePointerId)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            this.isBeingDragged = canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y2);
            if (this.isBeingDragged) {
                this.lastMotionY = y2;
                this.activePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                if (this.scroller != null && !this.scroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        if (this.velocityTracker != null) {
            this.velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            r6 = 0
            int r1 = r14.getActionMasked()
            r7 = 1
            r8 = -1
            r9 = 0
            switch(r1) {
                case 1: goto L47;
                case 2: goto L27;
                case 3: goto L6c;
                case 4: goto Lb;
                case 5: goto Lb;
                case 6: goto Ld;
                default: goto Lb;
            }
        Lb:
            goto L7c
        Ld:
            int r1 = r14.getActionIndex()
            if (r1 != 0) goto L15
            r1 = r7
            goto L16
        L15:
            r1 = r9
        L16:
            int r3 = r14.getPointerId(r1)
            r11.activePointerId = r3
            float r3 = r14.getY(r1)
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r3 = (int) r3
            r11.lastMotionY = r3
            goto L7c
        L27:
            int r1 = r11.activePointerId
            int r10 = r14.findPointerIndex(r1)
            if (r10 != r8) goto L30
            return r9
        L30:
            float r1 = r14.getY(r10)
            int r8 = (int) r1
            int r1 = r11.lastMotionY
            int r3 = r1 - r8
            r11.lastMotionY = r8
            int r4 = r11.getMaxDragOffset(r13)
            r5 = 0
            r0 = r11
            r1 = r12
            r2 = r13
            r0.scroll(r1, r2, r3, r4, r5)
            goto L7c
        L47:
            android.view.VelocityTracker r1 = r11.velocityTracker
            if (r1 == 0) goto L6c
            r6 = 1
            android.view.VelocityTracker r1 = r11.velocityTracker
            r1.addMovement(r14)
            android.view.VelocityTracker r1 = r11.velocityTracker
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            android.view.VelocityTracker r1 = r11.velocityTracker
            int r3 = r11.activePointerId
            float r5 = r1.getYVelocity(r3)
            int r1 = r11.getScrollRangeForDragFling(r13)
            int r3 = -r1
            r4 = 0
            r0 = r11
            r1 = r12
            r2 = r13
            r0.fling(r1, r2, r3, r4, r5)
        L6c:
            r11.isBeingDragged = r9
            r11.activePointerId = r8
            android.view.VelocityTracker r1 = r11.velocityTracker
            if (r1 == 0) goto L7c
            android.view.VelocityTracker r1 = r11.velocityTracker
            r1.recycle()
            r1 = 0
            r11.velocityTracker = r1
        L7c:
            android.view.VelocityTracker r1 = r11.velocityTracker
            if (r1 == 0) goto L85
            android.view.VelocityTracker r1 = r11.velocityTracker
            r1.addMovement(r14)
        L85:
            boolean r1 = r11.isBeingDragged
            if (r1 != 0) goto L8c
            if (r6 != 0) goto L8c
            r7 = r9
        L8c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (clamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(clamp);
        return topAndBottomOffset - clamp;
    }
}
