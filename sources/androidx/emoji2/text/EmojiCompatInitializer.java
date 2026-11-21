package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements DefaultLifecycleObserver {
        final /* synthetic */ Lifecycle val$lifecycle;

        AnonymousClass1(Lifecycle lifecycle) {
            this.val$lifecycle = lifecycle;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(LifecycleOwner lifecycleOwner) {
            EmojiCompatInitializer.this.loadEmojiCompatAfterDelay();
            this.val$lifecycle.removeObserver(this);
        }
    }

    /* loaded from: classes.dex */
    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            setMetadataLoadStrategy(1);
        }
    }

    /* loaded from: classes.dex */
    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 extends EmojiCompat.MetadataRepoLoaderCallback {
            final /* synthetic */ ThreadPoolExecutor val$executor;
            final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback val$loaderCallback;

            AnonymousClass1(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
                this.val$loaderCallback = metadataRepoLoaderCallback;
                this.val$executor = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public void onFailed(Throwable th) {
                try {
                    this.val$loaderCallback.onFailed(th);
                } finally {
                    this.val$executor.shutdown();
                }
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public void onLoaded(MetadataRepo metadataRepo) {
                try {
                    this.val$loaderCallback.onLoaded(metadataRepo);
                } finally {
                    this.val$executor.shutdown();
                }
            }
        }

        BackgroundDefaultLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        void doLoad(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig create = DefaultEmojiCompatConfig.create(this.mContext);
                if (create == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                create.setLoadingExecutor(threadPoolExecutor);
                create.getMetadataRepoLoader().load(new AnonymousClass1(metadataRepoLoaderCallback, threadPoolExecutor));
            } catch (Throwable th) {
                metadataRepoLoaderCallback.onFailed(th);
                threadPoolExecutor.shutdown();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$load$0$androidx-emoji2-text-EmojiCompatInitializer$BackgroundDefaultLoader, reason: not valid java name */
        public /* synthetic */ void m130x5cc8028a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
            doLoad(metadataRepoLoaderCallback, threadPoolExecutor);
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor createBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            createBackgroundPriorityExecutor.execute(new EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0(this, metadataRepoLoaderCallback, createBackgroundPriorityExecutor));
        }
    }

    /* loaded from: classes.dex */
    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Boolean create(Context context) {
        int i = Build.VERSION.SDK_INT;
        EmojiCompat.init(new BackgroundDefaultConfig(context));
        delayUntilFirstResume(context);
        return true;
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Boolean create(Context context) {
        return create(context);
    }

    void delayUntilFirstResume(Context context) {
        Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new AnonymousClass1(lifecycle));
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), STARTUP_THREAD_CREATION_DELAY_MS);
    }
}
