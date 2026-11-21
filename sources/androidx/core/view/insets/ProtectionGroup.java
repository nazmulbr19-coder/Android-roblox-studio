package androidx.core.view.insets;

import android.graphics.RectF;
import androidx.core.graphics.Insets;
import androidx.core.view.insets.SystemBarStateMonitor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class ProtectionGroup implements SystemBarStateMonitor.Callback {
    private int mAnimationCount;
    private boolean mDisposed;
    private final SystemBarStateMonitor mMonitor;
    private final ArrayList<Protection> mProtections = new ArrayList<>();
    private Insets mInsets = Insets.NONE;
    private Insets mInsetsIgnoringVisibility = Insets.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtectionGroup(SystemBarStateMonitor systemBarStateMonitor, List<Protection> list) {
        addProtections(list, false);
        addProtections(list, true);
        systemBarStateMonitor.addCallback(this);
        this.mMonitor = systemBarStateMonitor;
    }

    private void addProtections(List<Protection> list, boolean z) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protection protection = list.get(i);
            if (protection.occupiesCorners() == z) {
                Object controller = protection.getController();
                if (controller != null) {
                    throw new IllegalStateException(protection + " (" + (i + 1) + "/" + size + ") is already controlled by " + controller + " but is still added to " + this);
                }
                protection.setController(this);
                this.mProtections.add(protection);
            }
        }
    }

    private void updateInsets() {
        Insets insets = Insets.NONE;
        for (int size = this.mProtections.size() - 1; size >= 0; size--) {
            insets = Insets.max(insets, this.mProtections.get(size).dispatchInsets(this.mInsets, this.mInsetsIgnoringVisibility, insets));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispose() {
        if (this.mDisposed) {
            return;
        }
        this.mDisposed = true;
        this.mMonitor.removeCallback(this);
        for (int size = this.mProtections.size() - 1; size >= 0; size--) {
            this.mProtections.get(size).setController(null);
        }
        this.mProtections.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Protection getProtection(int i) {
        return this.mProtections.get(i);
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onAnimationEnd() {
        boolean z = this.mAnimationCount > 0;
        this.mAnimationCount--;
        if (z && this.mAnimationCount == 0) {
            updateInsets();
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onAnimationProgress(int i, Insets insets, RectF rectF) {
        Insets insets2 = this.mInsetsIgnoringVisibility;
        for (int size = this.mProtections.size() - 1; size >= 0; size--) {
            Protection protection = this.mProtections.get(size);
            int side = protection.getSide();
            if ((side & i) != 0) {
                protection.setSystemVisible(true);
                switch (side) {
                    case 1:
                        if (insets2.left > 0) {
                            protection.setSystemInsetAmount(insets.left / insets2.left);
                        }
                        protection.setSystemAlpha(rectF.left);
                        break;
                    case 2:
                        if (insets2.top > 0) {
                            protection.setSystemInsetAmount(insets.top / insets2.top);
                        }
                        protection.setSystemAlpha(rectF.top);
                        break;
                    case 4:
                        if (insets2.right > 0) {
                            protection.setSystemInsetAmount(insets.right / insets2.right);
                        }
                        protection.setSystemAlpha(rectF.right);
                        break;
                    case 8:
                        if (insets2.bottom > 0) {
                            protection.setSystemInsetAmount(insets.bottom / insets2.bottom);
                        }
                        protection.setSystemAlpha(rectF.bottom);
                        break;
                }
            }
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onAnimationStart() {
        this.mAnimationCount++;
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onColorHintChanged(int i) {
        for (int size = this.mProtections.size() - 1; size >= 0; size--) {
            this.mProtections.get(size).dispatchColorHint(i);
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onInsetsChanged(Insets insets, Insets insets2) {
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets2;
        updateInsets();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.mProtections.size();
    }
}
