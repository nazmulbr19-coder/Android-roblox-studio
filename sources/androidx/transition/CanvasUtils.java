package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static void disableZ(Canvas canvas) {
            canvas.disableZ();
        }

        static void enableZ(Canvas canvas) {
            canvas.enableZ();
        }
    }

    private CanvasUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void enableZ(Canvas canvas, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 29) {
            if (z) {
                Api29Impl.enableZ(canvas);
                return;
            } else {
                Api29Impl.disableZ(canvas);
                return;
            }
        }
        if (Build.VERSION.SDK_INT == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!sOrderMethodsFetched) {
            try {
                sReorderBarrierMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                sReorderBarrierMethod.setAccessible(true);
                sInorderBarrierMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                sInorderBarrierMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            sOrderMethodsFetched = true;
        }
        if (z) {
            try {
                if (sReorderBarrierMethod != null) {
                    sReorderBarrierMethod.invoke(canvas, new Object[0]);
                }
            } catch (IllegalAccessException e2) {
                return;
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        if (z || sInorderBarrierMethod == null) {
            return;
        }
        sInorderBarrierMethod.invoke(canvas, new Object[0]);
    }
}
