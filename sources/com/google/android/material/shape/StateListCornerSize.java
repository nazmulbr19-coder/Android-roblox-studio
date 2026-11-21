package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.google.android.material.R;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class StateListCornerSize {
    private static final int INITIAL_CAPACITY = 10;
    private CornerSize defaultCornerSize;
    int stateCount;
    int[][] stateSpecs = new int[10];
    CornerSize[] cornerSizes = new CornerSize[10];

    private void addStateCornerSize(int[] iArr, CornerSize cornerSize) {
        if (this.stateCount == 0 || iArr.length == 0) {
            this.defaultCornerSize = cornerSize;
        }
        if (this.stateCount >= this.stateSpecs.length) {
            growArray(this.stateCount, this.stateCount + 10);
        }
        this.stateSpecs[this.stateCount] = iArr;
        this.cornerSizes[this.stateCount] = cornerSize;
        this.stateCount++;
    }

    public static StateListCornerSize create(Context context, TypedArray typedArray, int i, CornerSize cornerSize) {
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId != 0 && context.getResources().getResourceTypeName(resourceId).equals("xml")) {
            try {
                XmlResourceParser xml = context.getResources().getXml(resourceId);
                try {
                    StateListCornerSize stateListCornerSize = new StateListCornerSize();
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
                        stateListCornerSize.loadCornerSizesFromItems(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (xml != null) {
                        xml.close();
                    }
                    return stateListCornerSize;
                } finally {
                }
            } catch (Resources.NotFoundException | IOException | XmlPullParserException e) {
                return create(cornerSize);
            }
        }
        return create(ShapeAppearanceModel.getCornerSize(typedArray, i, cornerSize));
    }

    public static StateListCornerSize create(CornerSize cornerSize) {
        StateListCornerSize stateListCornerSize = new StateListCornerSize();
        stateListCornerSize.addStateCornerSize(StateSet.WILD_CARD, cornerSize);
        return stateListCornerSize;
    }

    private void growArray(int i, int i2) {
        int[][] iArr = new int[i2];
        System.arraycopy(this.stateSpecs, 0, iArr, 0, i);
        this.stateSpecs = iArr;
        CornerSize[] cornerSizeArr = new CornerSize[i2];
        System.arraycopy(this.cornerSizes, 0, cornerSizeArr, 0, i);
        this.cornerSizes = cornerSizeArr;
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

    private void loadCornerSizesFromItems(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                TypedArray obtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, R.styleable.ShapeAppearance) : theme.obtainStyledAttributes(attributeSet, R.styleable.ShapeAppearance, 0, 0);
                CornerSize cornerSize = ShapeAppearanceModel.getCornerSize(obtainAttributes, R.styleable.ShapeAppearance_cornerSize, new AbsoluteCornerSize(0.0f));
                obtainAttributes.recycle();
                int i2 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                for (int i3 = 0; i3 < attributeCount; i3++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i3);
                    if (attributeNameResource != R.attr.cornerSize) {
                        int i4 = i2 + 1;
                        iArr[i2] = attributeSet.getAttributeBooleanValue(i3, false) ? attributeNameResource : -attributeNameResource;
                        i2 = i4;
                    }
                }
                addStateCornerSize(StateSet.trimStateSet(iArr, i2), cornerSize);
                i = 1;
            }
        }
    }

    public CornerSize getCornerSizeForState(int[] iArr) {
        int indexOfStateSet = indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        return indexOfStateSet < 0 ? this.defaultCornerSize : this.cornerSizes[indexOfStateSet];
    }

    public CornerSize getDefaultCornerSize() {
        return this.defaultCornerSize;
    }

    public boolean isStateful() {
        return this.stateCount > 1;
    }

    public StateListCornerSize withTransformedCornerSizes(ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        StateListCornerSize stateListCornerSize = new StateListCornerSize();
        stateListCornerSize.stateCount = this.stateCount;
        stateListCornerSize.stateSpecs = new int[this.stateSpecs.length];
        System.arraycopy(this.stateSpecs, 0, stateListCornerSize.stateSpecs, 0, this.stateSpecs.length);
        stateListCornerSize.cornerSizes = new CornerSize[this.cornerSizes.length];
        for (int i = 0; i < this.stateCount; i++) {
            stateListCornerSize.cornerSizes[i] = cornerSizeUnaryOperator.apply(this.cornerSizes[i]);
        }
        return stateListCornerSize;
    }
}
