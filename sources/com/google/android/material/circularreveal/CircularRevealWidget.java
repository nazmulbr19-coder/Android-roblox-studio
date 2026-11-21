package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.math.MathUtils;

/* loaded from: classes.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* loaded from: classes.dex */
    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = new CircularRevealEvaluator();
        private final RevealInfo revealInfo = new RevealInfo((AnonymousClass1) null);

        /* renamed from: evaluate, reason: avoid collision after fix types in other method */
        public RevealInfo evaluate2(float f, RevealInfo revealInfo, RevealInfo revealInfo2) {
            this.revealInfo.set(MathUtils.lerp(revealInfo.centerX, revealInfo2.centerX, f), MathUtils.lerp(revealInfo.centerY, revealInfo2.centerY, f), MathUtils.lerp(revealInfo.radius, revealInfo2.radius, f));
            return this.revealInfo;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ RevealInfo evaluate(float f, RevealInfo revealInfo, RevealInfo revealInfo2) {
            return evaluate2(f, revealInfo, revealInfo2);
        }
    }

    /* loaded from: classes.dex */
    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");

        private CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public RevealInfo get2(CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ RevealInfo get(CircularRevealWidget circularRevealWidget) {
            return get2(circularRevealWidget);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            set2(circularRevealWidget, revealInfo);
        }
    }

    /* loaded from: classes.dex */
    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        private CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Integer get2(CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Integer get(CircularRevealWidget circularRevealWidget) {
            return get2(circularRevealWidget);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularRevealWidget circularRevealWidget, Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CircularRevealWidget circularRevealWidget, Integer num) {
            set2(circularRevealWidget, num);
        }
    }

    /* loaded from: classes.dex */
    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        private RevealInfo() {
        }

        public RevealInfo(float f, float f2, float f3) {
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }

        /* synthetic */ RevealInfo(AnonymousClass1 anonymousClass1) {
            this();
        }

        public RevealInfo(RevealInfo revealInfo) {
            this(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }

        public boolean isInvalid() {
            return this.radius == Float.MAX_VALUE;
        }

        public void set(float f, float f2, float f3) {
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }

        public void set(RevealInfo revealInfo) {
            set(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas canvas);

    Drawable getCircularRevealOverlayDrawable();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(RevealInfo revealInfo);
}
