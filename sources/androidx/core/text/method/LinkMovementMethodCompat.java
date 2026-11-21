package androidx.core.text.method;

import android.os.Build;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes.dex */
public class LinkMovementMethodCompat extends LinkMovementMethod {
    private static LinkMovementMethodCompat sInstance;

    private LinkMovementMethodCompat() {
    }

    public static LinkMovementMethodCompat getInstance() {
        if (sInstance == null) {
            sInstance = new LinkMovementMethodCompat();
        }
        return sInstance;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 35) {
            int action = motionEvent.getAction();
            boolean z = true;
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int totalPaddingLeft = x - textView.getTotalPaddingLeft();
                int totalPaddingTop = y - textView.getTotalPaddingTop();
                int scrollX = totalPaddingLeft + textView.getScrollX();
                int scrollY = totalPaddingTop + textView.getScrollY();
                Layout layout = textView.getLayout();
                if (scrollY < 0 || scrollY > layout.getHeight()) {
                    z = true;
                } else {
                    int lineForVertical = layout.getLineForVertical(scrollY);
                    if (scrollX >= layout.getLineLeft(lineForVertical) && scrollX <= layout.getLineRight(lineForVertical)) {
                        z = false;
                    }
                }
                if (z) {
                    Selection.removeSelection(spannable);
                    return Touch.onTouchEvent(textView, spannable, motionEvent);
                }
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
