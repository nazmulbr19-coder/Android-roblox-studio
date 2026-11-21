package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import com.google.android.material.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class StateListSizeChange {
    private static final int INITIAL_CAPACITY = 10;
    private SizeChange defaultSizeChange;
    int stateCount;
    int[][] stateSpecs = new int[10];
    SizeChange[] sizeChanges = new SizeChange[10];

    /* loaded from: classes.dex */
    public static class SizeChange {
        public SizeChangeAmount widthChange;

        SizeChange(SizeChange sizeChange) {
            this.widthChange = new SizeChangeAmount(sizeChange.widthChange.type, sizeChange.widthChange.amount);
        }

        SizeChange(SizeChangeAmount sizeChangeAmount) {
            this.widthChange = sizeChangeAmount;
        }
    }

    /* loaded from: classes.dex */
    public static class SizeChangeAmount {
        float amount;
        SizeChangeType type;

        SizeChangeAmount(SizeChangeType sizeChangeType, float f) {
            this.type = sizeChangeType;
            this.amount = f;
        }

        public int getChange(int i) {
            if (this.type == SizeChangeType.PERCENT) {
                return (int) (this.amount * i);
            }
            if (this.type == SizeChangeType.PIXELS) {
                return (int) this.amount;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public enum SizeChangeType {
        PERCENT,
        PIXELS
    }

    private void addStateSizeChange(int[] iArr, SizeChange sizeChange) {
        if (this.stateCount == 0 || iArr.length == 0) {
            this.defaultSizeChange = sizeChange;
        }
        if (this.stateCount >= this.stateSpecs.length) {
            growArray(this.stateCount, this.stateCount + 10);
        }
        this.stateSpecs[this.stateCount] = iArr;
        this.sizeChanges[this.stateCount] = sizeChange;
        this.stateCount++;
    }

    public static StateListSizeChange create(Context context, TypedArray typedArray, int i) {
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !context.getResources().getResourceTypeName(resourceId).equals("xml")) {
            return null;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(resourceId);
            try {
                StateListSizeChange stateListSizeChange = new StateListSizeChange();
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (xml.getName().equals("selector")) {
                    stateListSizeChange.loadSizeChangeFromItems(context, xml, asAttributeSet, context.getTheme());
                }
                if (xml != null) {
                    xml.close();
                }
                return stateListSizeChange;
            } catch (Throwable th) {
                if (xml != null) {
                    try {
                        xml.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Resources.NotFoundException | IOException | XmlPullParserException e) {
            return null;
        }
    }

    private SizeChangeAmount getSizeChangeAmount(TypedArray typedArray, int i, SizeChangeAmount sizeChangeAmount) {
        TypedValue peekValue = typedArray.peekValue(i);
        return peekValue == null ? sizeChangeAmount : peekValue.type == 5 ? new SizeChangeAmount(SizeChangeType.PIXELS, TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : peekValue.type == 6 ? new SizeChangeAmount(SizeChangeType.PERCENT, peekValue.getFraction(1.0f, 1.0f)) : sizeChangeAmount;
    }

    private void growArray(int i, int i2) {
        int[][] iArr = new int[i2];
        System.arraycopy(this.stateSpecs, 0, iArr, 0, i);
        this.stateSpecs = iArr;
        SizeChange[] sizeChangeArr = new SizeChange[i2];
        System.arraycopy(this.sizeChanges, 0, sizeChangeArr, 0, i);
        this.sizeChanges = sizeChangeArr;
    }

    private int indexOfStateSet(int[] iArr) {
        int[][] iArr2 = this.stateSpecs;
        for (int i = 0; i < this.stateCount; i++) {
            if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                return i;
            }
        }
        return -1;
    }

    private void loadSizeChangeFromItems(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i = 1;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next != 2 || depth2 > depth) {
                i = 1;
            } else if (xmlPullParser.getName().equals("item")) {
                boolean z = false;
                TypedArray obtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, R.styleable.StateListSizeChange) : theme.obtainStyledAttributes(attributeSet, R.styleable.StateListSizeChange, 0, 0);
                SizeChangeAmount sizeChangeAmount = getSizeChangeAmount(obtainAttributes, R.styleable.StateListSizeChange_widthChange, null);
                obtainAttributes.recycle();
                int i2 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i3 = 0;
                while (i3 < attributeCount) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i3);
                    if (attributeNameResource != R.attr.widthChange) {
                        int i4 = i2 + 1;
                        iArr[i2] = attributeSet.getAttributeBooleanValue(i3, z) ? attributeNameResource : -attributeNameResource;
                        i2 = i4;
                    }
                    i3++;
                    z = false;
                }
                addStateSizeChange(StateSet.trimStateSet(iArr, i2), new SizeChange(sizeChangeAmount));
                i = 1;
            }
        }
    }

    public SizeChange getDefaultSizeChange() {
        return this.defaultSizeChange;
    }

    public int getMaxWidthChange(int i) {
        int i2 = -i;
        for (int i3 = 0; i3 < this.stateCount; i3++) {
            SizeChange sizeChange = this.sizeChanges[i3];
            if (sizeChange.widthChange.type == SizeChangeType.PIXELS) {
                i2 = (int) Math.max(i2, sizeChange.widthChange.amount);
            } else if (sizeChange.widthChange.type == SizeChangeType.PERCENT) {
                i2 = (int) Math.max(i2, i * sizeChange.widthChange.amount);
            }
        }
        return i2;
    }

    public SizeChange getSizeChangeForState(int[] iArr) {
        int indexOfStateSet = indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        return indexOfStateSet < 0 ? this.defaultSizeChange : this.sizeChanges[indexOfStateSet];
    }

    public boolean isStateful() {
        return this.stateCount > 1;
    }
}
