package androidx.dynamicanimation.animation;

import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float UNSET = Float.MAX_VALUE;
    private AnimationHandler mAnimationHandler;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;
    public static final ViewProperty TRANSLATION_X = new AnonymousClass1("translationX");
    public static final ViewProperty TRANSLATION_Y = new AnonymousClass2("translationY");
    public static final ViewProperty TRANSLATION_Z = new AnonymousClass3("translationZ");
    public static final ViewProperty SCALE_X = new AnonymousClass4("scaleX");
    public static final ViewProperty SCALE_Y = new AnonymousClass5("scaleY");
    public static final ViewProperty ROTATION = new AnonymousClass6(Key.ROTATION);
    public static final ViewProperty ROTATION_X = new AnonymousClass7("rotationX");
    public static final ViewProperty ROTATION_Y = new AnonymousClass8("rotationY");
    public static final ViewProperty X = new AnonymousClass9("x");
    public static final ViewProperty Y = new AnonymousClass10("y");
    public static final ViewProperty Z = new AnonymousClass11("z");
    public static final ViewProperty ALPHA = new AnonymousClass12("alpha");
    public static final ViewProperty SCROLL_X = new AnonymousClass13("scrollX");
    public static final ViewProperty SCROLL_Y = new AnonymousClass14("scrollY");

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ViewProperty {
        AnonymousClass1(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setTranslationX(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$10, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass10 extends ViewProperty {
        AnonymousClass10(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setY(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$11, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass11 extends ViewProperty {
        AnonymousClass11(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return ViewCompat.getZ(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            ViewCompat.setZ(view, f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$12, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass12 extends ViewProperty {
        AnonymousClass12(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setAlpha(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$13, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass13 extends ViewProperty {
        AnonymousClass13(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScrollX((int) f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$14, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass14 extends ViewProperty {
        AnonymousClass14(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScrollY((int) f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$15, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass15 extends FloatPropertyCompat {
        final /* synthetic */ FloatValueHolder val$floatValueHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass15(String str, FloatValueHolder floatValueHolder) {
            super(str);
            this.val$floatValueHolder = floatValueHolder;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(Object obj) {
            return this.val$floatValueHolder.getValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(Object obj, float f) {
            this.val$floatValueHolder.setValue(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends ViewProperty {
        AnonymousClass2(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setTranslationY(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends ViewProperty {
        AnonymousClass3(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            ViewCompat.setTranslationZ(view, f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends ViewProperty {
        AnonymousClass4(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScaleX(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends ViewProperty {
        AnonymousClass5(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScaleY(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 extends ViewProperty {
        AnonymousClass6(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotation(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$7, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass7 extends ViewProperty {
        AnonymousClass7(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotationX(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$8, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass8 extends ViewProperty {
        AnonymousClass8(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotationY(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$9, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass9 extends ViewProperty {
        AnonymousClass9(String str) {
            super(str, null);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setX(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }
    }

    /* loaded from: classes.dex */
    static class MassState {
        float mValue;
        float mVelocity;
    }

    /* loaded from: classes.dex */
    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2);
    }

    /* loaded from: classes.dex */
    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2);
    }

    /* loaded from: classes.dex */
    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }

        /* synthetic */ ViewProperty(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicAnimation(FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -this.mMaxValue;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new AnonymousClass15("FloatValueHolder", floatValueHolder);
        this.mMinVisibleChange = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -this.mMaxValue;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = k;
        this.mProperty = floatPropertyCompat;
        if (this.mProperty == ROTATION || this.mProperty == ROTATION_X || this.mProperty == ROTATION_Y) {
            this.mMinVisibleChange = 0.1f;
            return;
        }
        if (this.mProperty == ALPHA) {
            this.mMinVisibleChange = 0.00390625f;
        } else if (this.mProperty == SCALE_X || this.mProperty == SCALE_Y) {
            this.mMinVisibleChange = 0.002f;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
    }

    private void endAnimationInternal(boolean z) {
        this.mRunning = false;
        getAnimationHandler().removeCallback(this);
        this.mLastFrameTime = 0L;
        this.mStartValueIsSet = false;
        for (int i = 0; i < this.mEndListeners.size(); i++) {
            if (this.mEndListeners.get(i) != null) {
                this.mEndListeners.get(i).onAnimationEnd(this, z, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t) {
        int indexOf = arrayList.indexOf(t);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (this.mRunning) {
            return;
        }
        this.mRunning = true;
        if (!this.mStartValueIsSet) {
            this.mValue = getPropertyValue();
        }
        if (this.mValue > this.mMaxValue || this.mValue < this.mMinValue) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        getAnimationHandler().addAnimationFrameCallback(this, 0L);
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (isRunning()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
            this.mUpdateListeners.add(onAnimationUpdateListener);
        }
        return this;
    }

    public void cancel() {
        if (!getAnimationHandler().isCurrentThread()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        }
        if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long j) {
        if (this.mLastFrameTime == 0) {
            this.mLastFrameTime = j;
            setPropertyValue(this.mValue);
            return false;
        }
        long j2 = j - this.mLastFrameTime;
        this.mLastFrameTime = j;
        boolean updateValueAndVelocity = updateValueAndVelocity(getAnimationHandler().getDurationScale() == 0.0f ? 2147483647L : ((float) j2) / r0);
        this.mValue = Math.min(this.mValue, this.mMaxValue);
        this.mValue = Math.max(this.mValue, this.mMinValue);
        setPropertyValue(this.mValue);
        if (updateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return updateValueAndVelocity;
    }

    abstract float getAcceleration(float f, float f2);

    public AnimationHandler getAnimationHandler() {
        return this.mAnimationHandler != null ? this.mAnimationHandler : AnimationHandler.getInstance();
    }

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public FrameCallbackScheduler getScheduler() {
        return this.mAnimationHandler != null ? this.mAnimationHandler.getScheduler() : AnimationHandler.getInstance().getScheduler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    abstract boolean isAtEquilibrium(float f, float f2);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f) {
        this.mMaxValue = f;
        return this;
    }

    public T setMinValue(float f) {
        this.mMinValue = f;
        return this;
    }

    public T setMinimumVisibleChange(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.mMinVisibleChange = f;
        setValueThreshold(0.75f * f);
        return this;
    }

    void setPropertyValue(float f) {
        this.mProperty.setValue(this.mTarget, f);
        for (int i = 0; i < this.mUpdateListeners.size(); i++) {
            if (this.mUpdateListeners.get(i) != null) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public void setScheduler(FrameCallbackScheduler frameCallbackScheduler) {
        if (this.mAnimationHandler == null || this.mAnimationHandler.getScheduler() != frameCallbackScheduler) {
            if (this.mRunning) {
                throw new AndroidRuntimeException("Animations are still running and the animationhandler should not be set at this timming");
            }
            this.mAnimationHandler = new AnimationHandler(frameCallbackScheduler);
        }
    }

    public T setStartValue(float f) {
        this.mValue = f;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f) {
        this.mVelocity = f;
        return this;
    }

    abstract void setValueThreshold(float f);

    public void start() {
        if (!getAnimationHandler().isCurrentThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.mRunning) {
            return;
        }
        startAnimationInternal();
    }

    abstract boolean updateValueAndVelocity(long j);
}
