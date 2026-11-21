package com.google.android.material.motion;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import java.util.Objects;
import kotlin.time.DurationKt;

/* loaded from: classes.dex */
public final class MaterialBackOrchestrator {
    private final BackCallbackDelegate backCallbackDelegate;
    private final MaterialBackHandler backHandler;
    private final View view;

    /* loaded from: classes.dex */
    private static class Api33BackCallbackDelegate implements BackCallbackDelegate {
        private OnBackInvokedCallback onBackInvokedCallback;

        private Api33BackCallbackDelegate() {
        }

        /* synthetic */ Api33BackCallbackDelegate(AnonymousClass1 anonymousClass1) {
            this();
        }

        OnBackInvokedCallback createOnBackInvokedCallback(MaterialBackHandler materialBackHandler) {
            Objects.requireNonNull(materialBackHandler);
            return new MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0(materialBackHandler);
        }

        boolean isListeningForBackCallbacks() {
            return this.onBackInvokedCallback != null;
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        public void startListeningForBackCallbacks(MaterialBackHandler materialBackHandler, View view, boolean z) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if (this.onBackInvokedCallback == null && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                this.onBackInvokedCallback = createOnBackInvokedCallback(materialBackHandler);
                findOnBackInvokedDispatcher.registerOnBackInvokedCallback(z ? DurationKt.NANOS_IN_MILLIS : 0, this.onBackInvokedCallback);
            }
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        public void stopListeningForBackCallbacks(View view) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if (this.onBackInvokedCallback == null || (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
            this.onBackInvokedCallback = null;
        }
    }

    /* loaded from: classes.dex */
    private static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {

        /* renamed from: com.google.android.material.motion.MaterialBackOrchestrator$Api34BackCallbackDelegate$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements OnBackAnimationCallback {
            final /* synthetic */ MaterialBackHandler val$backHandler;

            AnonymousClass1(MaterialBackHandler materialBackHandler) {
                this.val$backHandler = materialBackHandler;
            }

            public void onBackCancelled() {
                if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                    this.val$backHandler.cancelBackProgress();
                }
            }

            public void onBackInvoked() {
                this.val$backHandler.handleBackInvoked();
            }

            public void onBackProgressed(BackEvent backEvent) {
                if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                    this.val$backHandler.updateBackProgress(new BackEventCompat(backEvent));
                }
            }

            public void onBackStarted(BackEvent backEvent) {
                if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                    this.val$backHandler.startBackProgress(new BackEventCompat(backEvent));
                }
            }
        }

        private Api34BackCallbackDelegate() {
            super(null);
        }

        /* synthetic */ Api34BackCallbackDelegate(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate
        OnBackInvokedCallback createOnBackInvokedCallback(MaterialBackHandler materialBackHandler) {
            return new AnonymousClass1(materialBackHandler);
        }
    }

    /* loaded from: classes.dex */
    private interface BackCallbackDelegate {
        void startListeningForBackCallbacks(MaterialBackHandler materialBackHandler, View view, boolean z);

        void stopListeningForBackCallbacks(View view);
    }

    public <T extends View & MaterialBackHandler> MaterialBackOrchestrator(T t) {
        this(t, t);
    }

    public MaterialBackOrchestrator(MaterialBackHandler materialBackHandler, View view) {
        this.backCallbackDelegate = createBackCallbackDelegate();
        this.backHandler = materialBackHandler;
        this.view = view;
    }

    private static BackCallbackDelegate createBackCallbackDelegate() {
        if (Build.VERSION.SDK_INT >= 34) {
            return new Api34BackCallbackDelegate(null);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return new Api33BackCallbackDelegate(null);
        }
        return null;
    }

    private void startListeningForBackCallbacks(boolean z) {
        if (this.backCallbackDelegate != null) {
            this.backCallbackDelegate.startListeningForBackCallbacks(this.backHandler, this.view, z);
        }
    }

    public boolean shouldListenForBackCallbacks() {
        return this.backCallbackDelegate != null;
    }

    public void startListeningForBackCallbacks() {
        startListeningForBackCallbacks(false);
    }

    public void startListeningForBackCallbacksWithPriorityOverlay() {
        startListeningForBackCallbacks(true);
    }

    public void stopListeningForBackCallbacks() {
        if (this.backCallbackDelegate != null) {
            this.backCallbackDelegate.stopListeningForBackCallbacks(this.view);
        }
    }
}
