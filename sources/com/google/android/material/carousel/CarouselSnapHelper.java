package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* loaded from: classes.dex */
public class CarouselSnapHelper extends SnapHelper {
    private static final float HORIZONTAL_SNAP_SPEED = 100.0f;
    private static final float VERTICAL_SNAP_SPEED = 50.0f;
    private final boolean disableFling;
    private RecyclerView recyclerView;

    /* renamed from: com.google.android.material.carousel.CarouselSnapHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends LinearSmoothScroller {
        final /* synthetic */ RecyclerView.LayoutManager val$layoutManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, RecyclerView.LayoutManager layoutManager) {
            super(context);
            this.val$layoutManager = layoutManager;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return this.val$layoutManager.canScrollVertically() ? 50.0f / displayMetrics.densityDpi : CarouselSnapHelper.HORIZONTAL_SNAP_SPEED / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            if (CarouselSnapHelper.access$000(CarouselSnapHelper.this) != null) {
                int[] access$100 = CarouselSnapHelper.access$100(CarouselSnapHelper.this, CarouselSnapHelper.access$000(CarouselSnapHelper.this).getLayoutManager(), view, true);
                int i = access$100[0];
                int i2 = access$100[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    public CarouselSnapHelper() {
        this(true);
    }

    public CarouselSnapHelper(boolean z) {
        this.disableFling = z;
    }

    static /* synthetic */ RecyclerView access$000(CarouselSnapHelper carouselSnapHelper) {
        return carouselSnapHelper.recyclerView;
    }

    static /* synthetic */ int[] access$100(CarouselSnapHelper carouselSnapHelper, RecyclerView.LayoutManager layoutManager, View view, boolean z) {
        return carouselSnapHelper.calculateDistanceToSnap(layoutManager, view, z);
    }

    private int[] calculateDistanceToSnap(RecyclerView.LayoutManager layoutManager, View view, boolean z) {
        if (!(layoutManager instanceof CarouselLayoutManager)) {
            return new int[]{0, 0};
        }
        int distanceToFirstFocalKeyline = distanceToFirstFocalKeyline(view, (CarouselLayoutManager) layoutManager, z);
        return layoutManager.canScrollHorizontally() ? new int[]{distanceToFirstFocalKeyline, 0} : layoutManager.canScrollVertically() ? new int[]{0, distanceToFirstFocalKeyline} : new int[]{0, 0};
    }

    private int distanceToFirstFocalKeyline(View view, CarouselLayoutManager carouselLayoutManager, boolean z) {
        return carouselLayoutManager.getOffsetToScrollToPositionForSnap(carouselLayoutManager.getPosition(view), z);
    }

    private View findViewNearestFirstKeyline(RecyclerView.LayoutManager layoutManager) {
        int childCount = layoutManager.getChildCount();
        if (childCount == 0 || !(layoutManager instanceof CarouselLayoutManager)) {
            return null;
        }
        View view = null;
        int i = Integer.MAX_VALUE;
        CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) layoutManager;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs(carouselLayoutManager.getOffsetToScrollToPositionForSnap(layoutManager.getPosition(childAt), false));
            if (abs < i) {
                i = abs;
                view = childAt;
            }
        }
        return view;
    }

    private boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        return layoutManager.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        return calculateDistanceToSnap(layoutManager, view, false);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new AnonymousClass1(this.recyclerView.getContext(), layoutManager);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return findViewNearestFirstKeyline(layoutManager);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        if (!this.disableFling || (itemCount = layoutManager.getItemCount()) == 0) {
            return -1;
        }
        View view = null;
        int i3 = Integer.MIN_VALUE;
        View view2 = null;
        int i4 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int distanceToFirstFocalKeyline = distanceToFirstFocalKeyline(childAt, (CarouselLayoutManager) layoutManager, false);
                if (distanceToFirstFocalKeyline <= 0 && distanceToFirstFocalKeyline > i3) {
                    i3 = distanceToFirstFocalKeyline;
                    view = childAt;
                }
                if (distanceToFirstFocalKeyline >= 0 && distanceToFirstFocalKeyline < i4) {
                    i4 = distanceToFirstFocalKeyline;
                    view2 = childAt;
                }
            }
        }
        boolean isForwardFling = isForwardFling(layoutManager, i, i2);
        if (isForwardFling && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (!isForwardFling && view != null) {
            return layoutManager.getPosition(view);
        }
        View view3 = isForwardFling ? view : view2;
        if (view3 == null) {
            return -1;
        }
        int position = (isReverseLayout(layoutManager) == isForwardFling ? -1 : 1) + layoutManager.getPosition(view3);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }
}
