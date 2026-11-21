package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    protected static final Class<?> activityThreadClass = getActivityThreadClass();
    protected static final Field mainThreadField = getMainThreadField();
    protected static final Field tokenField = getTokenField();
    protected static final Method performStopActivity3ParamsMethod = getPerformStopActivity3Params(activityThreadClass);
    protected static final Method performStopActivity2ParamsMethod = getPerformStopActivity2Params(activityThreadClass);
    protected static final Method requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(activityThreadClass);

    /* renamed from: androidx.core.app.ActivityRecreator$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ LifecycleCheckCallbacks val$callbacks;
        final /* synthetic */ Object val$token;

        AnonymousClass1(LifecycleCheckCallbacks lifecycleCheckCallbacks, Object obj) {
            this.val$callbacks = lifecycleCheckCallbacks;
            this.val$token = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callbacks.currentlyRecreatingToken = this.val$token;
        }
    }

    /* renamed from: androidx.core.app.ActivityRecreator$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Application val$application;
        final /* synthetic */ LifecycleCheckCallbacks val$callbacks;

        AnonymousClass2(Application application, LifecycleCheckCallbacks lifecycleCheckCallbacks) {
            this.val$application = application;
            this.val$callbacks = lifecycleCheckCallbacks;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
        }
    }

    /* renamed from: androidx.core.app.ActivityRecreator$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Object val$activityThread;
        final /* synthetic */ Object val$token;

        AnonymousClass3(Object obj, Object obj2) {
            this.val$activityThread = obj;
            this.val$token = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ActivityRecreator.performStopActivity3ParamsMethod != null) {
                    ActivityRecreator.performStopActivity3ParamsMethod.invoke(this.val$activityThread, this.val$token, false, "AppCompat recreation");
                } else {
                    ActivityRecreator.performStopActivity2ParamsMethod.invoke(this.val$activityThread, this.val$token, false);
                }
            } catch (RuntimeException e) {
                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                    throw e;
                }
            } catch (Throwable th) {
                Log.e(ActivityRecreator.LOG_TAG, "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private final int mRecreatingHashCode;
        private boolean mStarted = false;
        private boolean mDestroyed = false;
        private boolean mStopQueued = false;

        LifecycleCheckCallbacks(Activity activity) {
            this.mActivity = activity;
            this.mRecreatingHashCode = this.mActivity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.mDestroyed || this.mStopQueued || this.mStarted || !ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, activity)) {
                return;
            }
            this.mStopQueued = true;
            this.currentlyRecreatingToken = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    private ActivityRecreator() {
    }

    private static Class<?> getActivityThreadClass() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Field getMainThreadField() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    private static Method getPerformStopActivity2Params(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            return null;
        }
    }

    private static Method getPerformStopActivity3Params(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            return null;
        }
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> cls) {
        if (!needsRelaunchCall() || cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            return null;
        }
    }

    private static Field getTokenField() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean needsRelaunchCall() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    protected static boolean queueOnStopIfNecessary(Object obj, int i, Activity activity) {
        try {
            Object obj2 = tokenField.get(activity);
            if (obj2 == obj && activity.hashCode() == i) {
                mainHandler.postAtFrontOfQueue(new AnonymousClass3(mainThreadField.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e(LOG_TAG, "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean recreate(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (needsRelaunchCall() && requestRelaunchActivityMethod == null) {
            return false;
        }
        if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null) {
            return false;
        }
        try {
            Object obj2 = tokenField.get(activity);
            if (obj2 == null || (obj = mainThreadField.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
            application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
            mainHandler.post(new AnonymousClass1(lifecycleCheckCallbacks, obj2));
            try {
                if (needsRelaunchCall()) {
                    requestRelaunchActivityMethod.invoke(obj, obj2, null, null, 0, false, null, null, false, false);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                mainHandler.post(new AnonymousClass2(application, lifecycleCheckCallbacks));
            }
        } catch (Throwable th) {
            return false;
        }
    }
}
