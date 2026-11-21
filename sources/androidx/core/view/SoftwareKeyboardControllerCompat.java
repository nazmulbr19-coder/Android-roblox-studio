package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class SoftwareKeyboardControllerCompat {
    private final Impl mImpl;

    /* loaded from: classes.dex */
    private static class Impl {
        Impl() {
        }

        void hide() {
        }

        void show() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Impl20 extends Impl {
        private final View mView;

        Impl20(View view) {
            this.mView = view;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$show$0(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void hide() {
            if (this.mView != null) {
                ((InputMethodManager) this.mView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void show() {
            View view = this.mView;
            if (view == null) {
                return;
            }
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
            } else {
                view = view.getRootView().findFocus();
            }
            if (view == null) {
                view = this.mView.getRootView().findViewById(R.id.content);
            }
            if (view == null || !view.hasWindowFocus()) {
                return;
            }
            View view2 = view;
            view2.post(new SoftwareKeyboardControllerCompat$Impl20$$ExternalSyntheticLambda0(view2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Impl30 extends Impl20 {
        private View mView;
        private WindowInsetsController mWindowInsetsController;

        Impl30(View view) {
            super(view);
            this.mView = view;
        }

        Impl30(WindowInsetsController windowInsetsController) {
            super(null);
            this.mWindowInsetsController = windowInsetsController;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$hide$0(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i) {
            atomicBoolean.set((i & 8) != 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void hide() {
            WindowInsetsController windowInsetsController = null;
            if (this.mWindowInsetsController != null) {
                windowInsetsController = this.mWindowInsetsController;
            } else if (this.mView != null) {
                windowInsetsController = this.mView.getWindowInsetsController();
            }
            if (windowInsetsController == null) {
                super.hide();
                return;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0 softwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0 = new SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0(atomicBoolean);
            windowInsetsController.addOnControllableInsetsChangedListener(softwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0);
            if (!atomicBoolean.get() && this.mView != null) {
                ((InputMethodManager) this.mView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
            windowInsetsController.removeOnControllableInsetsChangedListener(softwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0);
            windowInsetsController.hide(WindowInsets.Type.ime());
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void show() {
            if (this.mView != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) this.mView.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = null;
            if (this.mWindowInsetsController != null) {
                windowInsetsController = this.mWindowInsetsController;
            } else if (this.mView != null) {
                windowInsetsController = this.mView.getWindowInsetsController();
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.show();
        }
    }

    public SoftwareKeyboardControllerCompat(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(view);
        } else {
            this.mImpl = new Impl20(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController);
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }
}
