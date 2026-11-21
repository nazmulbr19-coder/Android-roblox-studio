package com.google.android.material.listitem;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;

/* loaded from: classes.dex */
class ListItemUtils {
    private ListItemUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isRightAligned(View view) {
        int i = GravityCompat.END;
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams.gravity != -1) {
                i = layoutParams.gravity;
            }
        }
        return (GravityCompat.getAbsoluteGravity(i, view.getLayoutDirection()) & 7) == 5;
    }
}
