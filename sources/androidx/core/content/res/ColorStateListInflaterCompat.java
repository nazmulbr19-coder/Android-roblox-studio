package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.math.MathUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue = sTempTypedValue.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        sTempTypedValue.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList inflate(Resources resources, int i, Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    private static ColorStateList inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i;
        int color;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        int i2 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int i3 = 0;
        int[] iArr2 = new int[iArr.length];
        int[][] iArr3 = iArr;
        while (true) {
            int next = xmlPullParser.next();
            int i4 = next;
            if (next != i2 && ((depth = xmlPullParser.getDepth()) >= depth2 || i4 != 3)) {
                if (i4 != 2 || depth > depth2) {
                    i = depth2;
                } else if (xmlPullParser.getName().equals("item")) {
                    TypedArray obtainAttributes = obtainAttributes(resources2, theme2, attributeSet, R.styleable.ColorStateListItem);
                    int resourceId = obtainAttributes.getResourceId(R.styleable.ColorStateListItem_android_color, -1);
                    if (resourceId == -1 || isColorInt(resources2, resourceId)) {
                        color = obtainAttributes.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                    } else {
                        try {
                            color = createFromXml(resources2, resources2.getXml(resourceId), theme2).getDefaultColor();
                        } catch (Exception e) {
                            color = obtainAttributes.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                        }
                    }
                    float f = 1.0f;
                    if (obtainAttributes.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
                        f = obtainAttributes.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
                    } else if (obtainAttributes.hasValue(R.styleable.ColorStateListItem_alpha)) {
                        f = obtainAttributes.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
                    }
                    float f2 = (Build.VERSION.SDK_INT < 31 || !obtainAttributes.hasValue(R.styleable.ColorStateListItem_android_lStar)) ? obtainAttributes.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f) : obtainAttributes.getFloat(R.styleable.ColorStateListItem_android_lStar, -1.0f);
                    obtainAttributes.recycle();
                    int i5 = 0;
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr4 = new int[attributeCount];
                    int i6 = 0;
                    while (i6 < attributeCount) {
                        int i7 = depth2;
                        int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                        int i8 = i4;
                        if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                            int i9 = i5 + 1;
                            iArr4[i5] = attributeSet.getAttributeBooleanValue(i6, false) ? attributeNameResource : -attributeNameResource;
                            i5 = i9;
                        }
                        i6++;
                        depth2 = i7;
                        i4 = i8;
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr4, i5);
                    iArr2 = GrowingArrayUtils.append(iArr2, i3, modulateColorAlpha(color, f, f2));
                    iArr3 = (int[][]) GrowingArrayUtils.append(iArr3, i3, trimStateSet);
                    i3++;
                    resources2 = resources;
                    theme2 = theme;
                    depth2 = depth2;
                    i2 = 1;
                } else {
                    i = depth2;
                }
                resources2 = resources;
                theme2 = theme;
                depth2 = i;
                i2 = 1;
            }
        }
        int[] iArr5 = new int[i3];
        int[][] iArr6 = new int[i3];
        System.arraycopy(iArr2, 0, iArr5, 0, i3);
        System.arraycopy(iArr3, 0, iArr6, 0, i3);
        return new ColorStateList(iArr6, iArr5);
    }

    private static boolean isColorInt(Resources resources, int i) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i, typedValue, true);
        return typedValue.type >= 28 && typedValue.type <= 31;
    }

    private static int modulateColorAlpha(int i, float f, float f2) {
        boolean z = f2 >= 0.0f && f2 <= 100.0f;
        if (f == 1.0f && !z) {
            return i;
        }
        int clamp = MathUtils.clamp((int) ((Color.alpha(i) * f) + 0.5f), 0, 255);
        if (z) {
            CamColor fromColor = CamColor.fromColor(i);
            i = CamColor.toColor(fromColor.getHue(), fromColor.getChroma(), f2);
        }
        return (16777215 & i) | (clamp << 24);
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
