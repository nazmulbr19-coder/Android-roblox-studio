package com.google.android.material.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

/* loaded from: classes.dex */
public class ScaledDrawableWrapper extends DrawableWrapperCompat {
    private boolean mutated;
    private ScaledDrawableWrapperState state;

    /* loaded from: classes.dex */
    private static final class ScaledDrawableWrapperState extends Drawable.ConstantState {
        private final int height;
        private final int width;
        private Drawable.ConstantState wrappedDrawableState;

        ScaledDrawableWrapperState(Drawable.ConstantState constantState, int i, int i2) {
            this.wrappedDrawableState = constantState;
            this.width = i;
            this.height = i2;
        }

        static /* synthetic */ int access$000(ScaledDrawableWrapperState scaledDrawableWrapperState) {
            return scaledDrawableWrapperState.width;
        }

        static /* synthetic */ int access$100(ScaledDrawableWrapperState scaledDrawableWrapperState) {
            return scaledDrawableWrapperState.height;
        }

        static /* synthetic */ Drawable.ConstantState access$202(ScaledDrawableWrapperState scaledDrawableWrapperState, Drawable.ConstantState constantState) {
            scaledDrawableWrapperState.wrappedDrawableState = constantState;
            return constantState;
        }

        boolean canConstantState() {
            return this.wrappedDrawableState != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            if (this.wrappedDrawableState != null) {
                return this.wrappedDrawableState.getChangingConfigurations();
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(), this.width, this.height);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(resources), this.width, this.height);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(resources, theme), this.width, this.height);
        }
    }

    public ScaledDrawableWrapper(Drawable drawable, int i, int i2) {
        super(drawable);
        this.state = new ScaledDrawableWrapperState(getConstantStateFrom(drawable), i, i2);
    }

    private Drawable.ConstantState getConstantStateFrom(Drawable drawable) {
        if (drawable != null) {
            return drawable.getConstantState();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.state.canConstantState()) {
            return this.state;
        }
        return null;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return ScaledDrawableWrapperState.access$100(this.state);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return ScaledDrawableWrapperState.access$000(this.state);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                drawable.mutate();
            }
            this.state = new ScaledDrawableWrapperState(getConstantStateFrom(drawable), ScaledDrawableWrapperState.access$000(this.state), ScaledDrawableWrapperState.access$100(this.state));
            this.mutated = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat
    public void setDrawable(Drawable drawable) {
        super.setDrawable(drawable);
        if (this.state != null) {
            ScaledDrawableWrapperState.access$202(this.state, getConstantStateFrom(drawable));
            this.mutated = false;
        }
    }
}
