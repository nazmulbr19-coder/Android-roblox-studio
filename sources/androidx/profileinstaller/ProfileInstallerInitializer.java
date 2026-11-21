package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    /* loaded from: classes.dex */
    private static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* loaded from: classes.dex */
    public static class Result {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$installAfterDelay$1(Context context) {
        writeInBackground(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$writeInBackground$2(Context context) {
        ProfileInstaller.writeProfile(context);
    }

    private static void writeInBackground(Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new ProfileInstallerInitializer$$ExternalSyntheticLambda2(context));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Result create(Context context) {
        int i = Build.VERSION.SDK_INT;
        Choreographer.getInstance().postFrameCallback(new ProfileInstallerInitializer$$ExternalSyntheticLambda0(this, context.getApplicationContext()));
        return new Result();
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Result create(Context context) {
        return create(context);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    void installAfterDelay(Context context) {
        (Build.VERSION.SDK_INT >= 28 ? Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new ProfileInstallerInitializer$$ExternalSyntheticLambda1(context), new Random().nextInt(Math.max(1000, 1)) + DELAY_MS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$create$0$androidx-profileinstaller-ProfileInstallerInitializer, reason: not valid java name */
    public /* synthetic */ void m179x451635a(Context context, long j) {
        installAfterDelay(context);
    }
}
