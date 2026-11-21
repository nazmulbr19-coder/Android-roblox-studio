package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    /* renamed from: androidx.dynamicanimation.animation.FloatPropertyCompat$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends FloatPropertyCompat<T> {
        final /* synthetic */ FloatProperty val$property;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, FloatProperty floatProperty) {
            super(str);
            this.val$property = floatProperty;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(T t) {
            return ((Float) this.val$property.get(t)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(T t, float f) {
            this.val$property.setValue(t, f);
        }
    }

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new AnonymousClass1(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T t);

    public abstract void setValue(T t, float f);
}
