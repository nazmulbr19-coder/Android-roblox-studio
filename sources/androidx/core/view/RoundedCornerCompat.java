package androidx.core.view;

import android.graphics.Point;
import android.view.RoundedCorner;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class RoundedCornerCompat {
    public static final int POSITION_BOTTOM_LEFT = 3;
    public static final int POSITION_BOTTOM_RIGHT = 2;
    public static final int POSITION_TOP_LEFT = 0;
    public static final int POSITION_TOP_RIGHT = 1;
    private final Point mCenter;
    private final int mPosition;
    private final int mRadius;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Position {
    }

    public RoundedCornerCompat(int i, int i2, int i3, int i4) {
        this.mPosition = i;
        this.mRadius = i2;
        this.mCenter = new Point(i3, i4);
    }

    private RoundedCornerCompat(int i, int i2, Point point) {
        this(i, i2, point.x, point.y);
    }

    private String getPositionString(int i) {
        switch (i) {
            case 0:
                return "TopLeft";
            case 1:
                return "TopRight";
            case 2:
                return "BottomRight";
            case 3:
                return "BottomLeft";
            default:
                return "Invalid";
        }
    }

    private static int toCompatPosition(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                throw new IllegalArgumentException("Invalid position: " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int toPlatformPosition(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                throw new IllegalArgumentException("Invalid position: " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RoundedCorner toPlatformRoundedCorner(RoundedCornerCompat roundedCornerCompat) {
        if (roundedCornerCompat != null) {
            return new RoundedCorner(toPlatformPosition(roundedCornerCompat.getPosition()), roundedCornerCompat.getRadius(), roundedCornerCompat.getCenterX(), roundedCornerCompat.getCenterY());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RoundedCornerCompat toRoundedCornerCompat(RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            return new RoundedCornerCompat(toCompatPosition(roundedCorner.getPosition()), roundedCorner.getRadius(), roundedCorner.getCenter());
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoundedCornerCompat)) {
            return false;
        }
        RoundedCornerCompat roundedCornerCompat = (RoundedCornerCompat) obj;
        return this.mPosition == roundedCornerCompat.mPosition && this.mRadius == roundedCornerCompat.mRadius && this.mCenter.equals(roundedCornerCompat.mCenter);
    }

    public Point getCenter() {
        return new Point(this.mCenter);
    }

    public int getCenterX() {
        return this.mCenter.x;
    }

    public int getCenterY() {
        return this.mCenter.y;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public int hashCode() {
        return (((((0 * 31) + this.mPosition) * 31) + this.mRadius) * 31) + this.mCenter.hashCode();
    }

    public String toString() {
        return "RoundedCornerCompat{position=" + getPositionString(this.mPosition) + ", radius=" + this.mRadius + ", center=" + this.mCenter + '}';
    }
}
