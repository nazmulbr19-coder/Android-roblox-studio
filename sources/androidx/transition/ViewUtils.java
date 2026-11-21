package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* loaded from: classes.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS;
    private static final ViewUtilsApi19 IMPL;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA;

    /* renamed from: androidx.transition.ViewUtils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends Property<View, Float> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(View view) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(view));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, Float f) {
            ViewUtils.setTransitionAlpha(view, f.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f) {
            set2(view, f);
        }
    }

    /* renamed from: androidx.transition.ViewUtils$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends Property<View, Rect> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Rect get2(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Rect get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Rect rect) {
            set2(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else {
            int i = Build.VERSION.SDK_INT;
            IMPL = new ViewUtilsApi23();
        }
        TRANSITION_ALPHA = new AnonymousClass1(Float.class, "translationAlpha");
        CLIP_BOUNDS = new AnonymousClass2(Rect.class, "clipBounds");
    }

    private ViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearNonTransitionAlpha(View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveNonTransitionAlpha(View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAnimationMatrix(View view, Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setTransitionAlpha(View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setTransitionVisibility(View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void transformMatrixToGlobal(View view, Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void transformMatrixToLocal(View view, Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }
}
