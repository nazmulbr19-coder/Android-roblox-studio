package androidx.core.view.insets;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class SystemBarStateMonitor {
    private int mColorHint;
    private final View mDetector;
    private final ArrayList<Callback> mCallbacks = new ArrayList<>();
    private Insets mInsets = Insets.NONE;
    private Insets mInsetsIgnoringVisibility = Insets.NONE;

    /* renamed from: androidx.core.view.insets.SystemBarStateMonitor$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends View {
        final /* synthetic */ ViewGroup val$rootView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, ViewGroup viewGroup) {
            super(context);
            this.val$rootView = viewGroup;
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            Drawable background = this.val$rootView.getBackground();
            int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
            if (SystemBarStateMonitor.m118$$Nest$fgetmColorHint(SystemBarStateMonitor.this) != color) {
                SystemBarStateMonitor.m119$$Nest$fputmColorHint(SystemBarStateMonitor.this, color);
                for (int size = SystemBarStateMonitor.m117$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).size() - 1; size >= 0; size--) {
                    ((Callback) SystemBarStateMonitor.m117$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).get(size)).onColorHintChanged(color);
                }
            }
        }
    }

    /* renamed from: androidx.core.view.insets.SystemBarStateMonitor$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends WindowInsetsAnimationCompat.Callback {
        private final HashMap<WindowInsetsAnimationCompat, Integer> mAnimationSidesMap;

        AnonymousClass2(int i) {
            super(i);
            this.mAnimationSidesMap = new HashMap<>();
        }

        private boolean animatesSystemBars(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            return (windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.systemBars()) != 0;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            if (animatesSystemBars(windowInsetsAnimationCompat)) {
                this.mAnimationSidesMap.remove(windowInsetsAnimationCompat);
                for (int size = SystemBarStateMonitor.m117$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).size() - 1; size >= 0; size--) {
                    ((Callback) SystemBarStateMonitor.m117$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).get(size)).onAnimationEnd();
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            if (animatesSystemBars(windowInsetsAnimationCompat)) {
                for (int size = SystemBarStateMonitor.m117$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).size() - 1; size >= 0; size--) {
                    ((Callback) SystemBarStateMonitor.m117$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).get(size)).onAnimationStart();
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
            RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
            int i = 0;
            for (int size = list.size() - 1; size >= 0; size--) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = list.get(size);
                Integer num = this.mAnimationSidesMap.get(windowInsetsAnimationCompat);
                if (num != null) {
                    int intValue = num.intValue();
                    float alpha = windowInsetsAnimationCompat.getAlpha();
                    if ((intValue & 1) != 0) {
                        rectF.left = alpha;
                    }
                    if ((intValue & 2) != 0) {
                        rectF.top = alpha;
                    }
                    if ((intValue & 4) != 0) {
                        rectF.right = alpha;
                    }
                    if ((intValue & 8) != 0) {
                        rectF.bottom = alpha;
                    }
                    i |= intValue;
                }
            }
            Insets m120$$Nest$mgetInsets = SystemBarStateMonitor.m120$$Nest$mgetInsets(SystemBarStateMonitor.this, windowInsetsCompat);
            for (int size2 = SystemBarStateMonitor.m117$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).size() - 1; size2 >= 0; size2--) {
                ((Callback) SystemBarStateMonitor.m117$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).get(size2)).onAnimationProgress(i, m120$$Nest$mgetInsets, rectF);
            }
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
            if (!animatesSystemBars(windowInsetsAnimationCompat)) {
                return boundsCompat;
            }
            Insets upperBound = boundsCompat.getUpperBound();
            Insets lowerBound = boundsCompat.getLowerBound();
            int i = upperBound.left != lowerBound.left ? 0 | 1 : 0;
            if (upperBound.top != lowerBound.top) {
                i |= 2;
            }
            if (upperBound.right != lowerBound.right) {
                i |= 4;
            }
            if (upperBound.bottom != lowerBound.bottom) {
                i |= 8;
            }
            this.mAnimationSidesMap.put(windowInsetsAnimationCompat, Integer.valueOf(i));
            return boundsCompat;
        }
    }

    /* renamed from: androidx.core.view.insets.SystemBarStateMonitor$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements View.OnAttachStateChangeListener {
        final /* synthetic */ View val$child;
        final /* synthetic */ ViewGroup val$group;
        final /* synthetic */ int val$index;

        AnonymousClass3(ViewGroup viewGroup, View view, int i) {
            this.val$group = viewGroup;
            this.val$child = view;
            this.val$index = i;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.val$group.addView(this.val$child, this.val$index);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.val$group.addView(this.val$child, this.val$index);
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    interface Callback {
        void onAnimationEnd();

        void onAnimationProgress(int i, Insets insets, RectF rectF);

        void onAnimationStart();

        void onColorHintChanged(int i);

        void onInsetsChanged(Insets insets, Insets insets2);
    }

    /* renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m117$$Nest$fgetmCallbacks(SystemBarStateMonitor systemBarStateMonitor) {
        return systemBarStateMonitor.mCallbacks;
    }

    /* renamed from: -$$Nest$fgetmColorHint, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m118$$Nest$fgetmColorHint(SystemBarStateMonitor systemBarStateMonitor) {
        return systemBarStateMonitor.mColorHint;
    }

    /* renamed from: -$$Nest$fputmColorHint, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m119$$Nest$fputmColorHint(SystemBarStateMonitor systemBarStateMonitor, int i) {
        systemBarStateMonitor.mColorHint = i;
    }

    /* renamed from: -$$Nest$mgetInsets, reason: not valid java name */
    static /* bridge */ /* synthetic */ Insets m120$$Nest$mgetInsets(SystemBarStateMonitor systemBarStateMonitor, WindowInsetsCompat windowInsetsCompat) {
        return systemBarStateMonitor.getInsets(windowInsetsCompat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemBarStateMonitor(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        this.mColorHint = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        this.mDetector = new AnonymousClass1(viewGroup.getContext(), viewGroup);
        this.mDetector.setVisibility(8);
        this.mDetector.setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this.mDetector, new SystemBarStateMonitor$$ExternalSyntheticLambda0(this));
        ViewCompat.setWindowInsetsAnimationCallback(this.mDetector, new AnonymousClass2(0));
        addViewWhenReady(viewGroup, this.mDetector, 0);
    }

    private static void addViewWhenReady(ViewGroup viewGroup, View view, int i) {
        View view2 = null;
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                break;
            }
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.isAttachedToWindow() != viewGroup.isAttachedToWindow()) {
                view2 = childAt;
                break;
            }
            childCount--;
        }
        if (view2 == null) {
            viewGroup.addView(view, i);
        } else {
            view2.addOnAttachStateChangeListener(new AnonymousClass3(viewGroup, view, i));
        }
    }

    private Insets getInsets(WindowInsetsCompat windowInsetsCompat) {
        return Insets.min(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()), windowInsetsCompat.getInsets(WindowInsetsCompat.Type.tappableElement()));
    }

    private Insets getInsetsIgnoringVisibility(WindowInsetsCompat windowInsetsCompat) {
        return Insets.min(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()), windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCallback(Callback callback) {
        if (this.mCallbacks.contains(callback)) {
            return;
        }
        this.mCallbacks.add(callback);
        callback.onInsetsChanged(this.mInsets, this.mInsetsIgnoringVisibility);
        callback.onColorHintChanged(this.mColorHint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachFromWindow() {
        this.mDetector.post(new SystemBarStateMonitor$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCallback() {
        return !this.mCallbacks.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$detachFromWindow$1$androidx-core-view-insets-SystemBarStateMonitor, reason: not valid java name */
    public /* synthetic */ void m121xf3edbe07() {
        ViewParent parent = this.mDetector.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mDetector);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$androidx-core-view-insets-SystemBarStateMonitor, reason: not valid java name */
    public /* synthetic */ WindowInsetsCompat m122lambda$new$0$androidxcoreviewinsetsSystemBarStateMonitor(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = getInsets(windowInsetsCompat);
        Insets insetsIgnoringVisibility = getInsetsIgnoringVisibility(windowInsetsCompat);
        if (!insets.equals(this.mInsets) || !insetsIgnoringVisibility.equals(this.mInsetsIgnoringVisibility)) {
            this.mInsets = insets;
            this.mInsetsIgnoringVisibility = insetsIgnoringVisibility;
            for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                this.mCallbacks.get(size).onInsetsChanged(insets, insetsIgnoringVisibility);
            }
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }
}
