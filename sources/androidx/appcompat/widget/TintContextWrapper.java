package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;

@Deprecated
/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {
    private TintContextWrapper(Context context) {
        super(context);
    }

    public static Context wrap(Context context) {
        return context;
    }
}
