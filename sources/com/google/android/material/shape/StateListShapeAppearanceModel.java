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
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class StateListShapeAppearanceModel implements ShapeAppearance {
    private static final int INITIAL_CAPACITY = 10;
    final StateListCornerSize bottomLeftCornerSizeOverride;
    final StateListCornerSize bottomRightCornerSizeOverride;
    final ShapeAppearanceModel defaultShape;
    final ShapeAppearanceModel[] shapeAppearanceModels;
    final int stateCount;
    final int[][] stateSpecs;
    final StateListCornerSize topLeftCornerSizeOverride;
    final StateListCornerSize topRightCornerSizeOverride;

    /* loaded from: classes.dex */
    public static final class Builder {
        private StateListCornerSize bottomLeftCornerSizeOverride;
        private StateListCornerSize bottomRightCornerSizeOverride;
        private ShapeAppearanceModel defaultShape;
        private ShapeAppearanceModel[] shapeAppearanceModels;
        private int stateCount;
        private int[][] stateSpecs;
        private StateListCornerSize topLeftCornerSizeOverride;
        private StateListCornerSize topRightCornerSizeOverride;

        private Builder(Context context, int i) {
            int next;
            initialize();
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                try {
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
                        StateListShapeAppearanceModel.access$000(this, context, xml, asAttributeSet, context.getTheme());
                    }
                    if (xml != null) {
                        xml.close();
                    }
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
                initialize();
            }
        }

        /* synthetic */ Builder(Context context, int i, AnonymousClass1 anonymousClass1) {
            this(context, i);
        }

        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            initialize();
            addStateShapeAppearanceModel(StateSet.WILD_CARD, shapeAppearanceModel);
        }

        public Builder(StateListShapeAppearanceModel stateListShapeAppearanceModel) {
            this.stateCount = stateListShapeAppearanceModel.stateCount;
            this.defaultShape = stateListShapeAppearanceModel.defaultShape;
            this.stateSpecs = new int[stateListShapeAppearanceModel.stateSpecs.length];
            this.shapeAppearanceModels = new ShapeAppearanceModel[stateListShapeAppearanceModel.shapeAppearanceModels.length];
            System.arraycopy(stateListShapeAppearanceModel.stateSpecs, 0, this.stateSpecs, 0, this.stateCount);
            System.arraycopy(stateListShapeAppearanceModel.shapeAppearanceModels, 0, this.shapeAppearanceModels, 0, this.stateCount);
            this.topLeftCornerSizeOverride = stateListShapeAppearanceModel.topLeftCornerSizeOverride;
            this.topRightCornerSizeOverride = stateListShapeAppearanceModel.topRightCornerSizeOverride;
            this.bottomLeftCornerSizeOverride = stateListShapeAppearanceModel.bottomLeftCornerSizeOverride;
            this.bottomRightCornerSizeOverride = stateListShapeAppearanceModel.bottomRightCornerSizeOverride;
        }

        static /* synthetic */ StateListCornerSize access$1000(Builder builder) {
            return builder.bottomRightCornerSizeOverride;
        }

        static /* synthetic */ int access$300(Builder builder) {
            return builder.stateCount;
        }

        static /* synthetic */ ShapeAppearanceModel access$400(Builder builder) {
            return builder.defaultShape;
        }

        static /* synthetic */ int[][] access$500(Builder builder) {
            return builder.stateSpecs;
        }

        static /* synthetic */ ShapeAppearanceModel[] access$600(Builder builder) {
            return builder.shapeAppearanceModels;
        }

        static /* synthetic */ StateListCornerSize access$700(Builder builder) {
            return builder.topLeftCornerSizeOverride;
        }

        static /* synthetic */ StateListCornerSize access$800(Builder builder) {
            return builder.topRightCornerSizeOverride;
        }

        static /* synthetic */ StateListCornerSize access$900(Builder builder) {
            return builder.bottomLeftCornerSizeOverride;
        }

        private void growArray(int i, int i2) {
            int[][] iArr = new int[i2];
            System.arraycopy(this.stateSpecs, 0, iArr, 0, i);
            this.stateSpecs = iArr;
            ShapeAppearanceModel[] shapeAppearanceModelArr = new ShapeAppearanceModel[i2];
            System.arraycopy(this.shapeAppearanceModels, 0, shapeAppearanceModelArr, 0, i);
            this.shapeAppearanceModels = shapeAppearanceModelArr;
        }

        private void initialize() {
            this.defaultShape = new ShapeAppearanceModel();
            this.stateSpecs = new int[10];
            this.shapeAppearanceModels = new ShapeAppearanceModel[10];
        }

        public Builder addStateShapeAppearanceModel(int[] iArr, ShapeAppearanceModel shapeAppearanceModel) {
            if (this.stateCount == 0 || iArr.length == 0) {
                this.defaultShape = shapeAppearanceModel;
            }
            if (this.stateCount >= this.stateSpecs.length) {
                growArray(this.stateCount, this.stateCount + 10);
            }
            this.stateSpecs[this.stateCount] = iArr;
            this.shapeAppearanceModels[this.stateCount] = shapeAppearanceModel;
            this.stateCount++;
            return this;
        }

        public StateListShapeAppearanceModel build() {
            if (this.stateCount != 0) {
                return new StateListShapeAppearanceModel(this, null);
            }
            return null;
        }

        public Builder setCornerSizeOverride(StateListCornerSize stateListCornerSize, int i) {
            if (ShapeAppearanceModel.containsFlag(i, 1)) {
                this.topLeftCornerSizeOverride = stateListCornerSize;
            }
            if (ShapeAppearanceModel.containsFlag(i, 2)) {
                this.topRightCornerSizeOverride = stateListCornerSize;
            }
            if (ShapeAppearanceModel.containsFlag(i, 4)) {
                this.bottomLeftCornerSizeOverride = stateListCornerSize;
            }
            if (ShapeAppearanceModel.containsFlag(i, 8)) {
                this.bottomRightCornerSizeOverride = stateListCornerSize;
            }
            return this;
        }

        public Builder withTransformedCornerSizes(ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
            ShapeAppearanceModel[] shapeAppearanceModelArr = new ShapeAppearanceModel[this.shapeAppearanceModels.length];
            for (int i = 0; i < this.stateCount; i++) {
                shapeAppearanceModelArr[i] = this.shapeAppearanceModels[i].withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            this.shapeAppearanceModels = shapeAppearanceModelArr;
            if (this.topLeftCornerSizeOverride != null) {
                this.topLeftCornerSizeOverride = this.topLeftCornerSizeOverride.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            if (this.topRightCornerSizeOverride != null) {
                this.topRightCornerSizeOverride = this.topRightCornerSizeOverride.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            if (this.bottomLeftCornerSizeOverride != null) {
                this.bottomLeftCornerSizeOverride = this.bottomLeftCornerSizeOverride.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            if (this.bottomRightCornerSizeOverride != null) {
                this.bottomRightCornerSizeOverride = this.bottomRightCornerSizeOverride.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            return this;
        }
    }

    private StateListShapeAppearanceModel(Builder builder) {
        this.stateCount = Builder.access$300(builder);
        this.defaultShape = Builder.access$400(builder);
        this.stateSpecs = Builder.access$500(builder);
        this.shapeAppearanceModels = Builder.access$600(builder);
        this.topLeftCornerSizeOverride = Builder.access$700(builder);
        this.topRightCornerSizeOverride = Builder.access$800(builder);
        this.bottomLeftCornerSizeOverride = Builder.access$900(builder);
        this.bottomRightCornerSizeOverride = Builder.access$1000(builder);
    }

    /* synthetic */ StateListShapeAppearanceModel(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static /* synthetic */ void access$000(Builder builder, Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        loadShapeAppearanceModelsFromItems(builder, context, xmlPullParser, attributeSet, theme);
    }

    public static StateListShapeAppearanceModel create(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId != 0 && Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return new Builder(context, resourceId, null).build();
        }
        return null;
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

    private static void loadShapeAppearanceModelsFromItems(Builder builder, Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Resources.Theme theme2 = theme;
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
                theme2 = theme;
                i = 1;
            } else if (xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = theme2 == null ? context.getResources().obtainAttributes(attributeSet, R.styleable.MaterialShape) : theme2.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, 0, 0);
                ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, obtainAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0), obtainAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0)).build();
                obtainAttributes.recycle();
                int i2 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                for (int i3 = 0; i3 < attributeCount; i3++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i3);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i4 = i2 + 1;
                        iArr[i2] = attributeSet.getAttributeBooleanValue(i3, false) ? attributeNameResource : -attributeNameResource;
                        i2 = i4;
                    }
                }
                builder.addStateShapeAppearanceModel(StateSet.trimStateSet(iArr, i2), build);
                theme2 = theme;
                i = 1;
            }
        }
    }

    public static int swapCornerPositionRtl(int i) {
        return ((i & 5) << 1) | ((i & 10) >> 1);
    }

    @Override // com.google.android.material.shape.ShapeAppearance
    public ShapeAppearanceModel getDefaultShape() {
        return getDefaultShape(true);
    }

    public ShapeAppearanceModel getDefaultShape(boolean z) {
        if (!z || (this.topLeftCornerSizeOverride == null && this.topRightCornerSizeOverride == null && this.bottomLeftCornerSizeOverride == null && this.bottomRightCornerSizeOverride == null)) {
            return this.defaultShape;
        }
        ShapeAppearanceModel.Builder builder = this.defaultShape.toBuilder();
        if (this.topLeftCornerSizeOverride != null) {
            builder.setTopLeftCornerSize(this.topLeftCornerSizeOverride.getDefaultCornerSize());
        }
        if (this.topRightCornerSizeOverride != null) {
            builder.setTopRightCornerSize(this.topRightCornerSizeOverride.getDefaultCornerSize());
        }
        if (this.bottomLeftCornerSizeOverride != null) {
            builder.setBottomLeftCornerSize(this.bottomLeftCornerSizeOverride.getDefaultCornerSize());
        }
        if (this.bottomRightCornerSizeOverride != null) {
            builder.setBottomRightCornerSize(this.bottomRightCornerSizeOverride.getDefaultCornerSize());
        }
        return builder.build();
    }

    @Override // com.google.android.material.shape.ShapeAppearance
    public ShapeAppearanceModel[] getShapeAppearanceModels() {
        return this.shapeAppearanceModels;
    }

    @Override // com.google.android.material.shape.ShapeAppearance
    public ShapeAppearanceModel getShapeForState(int[] iArr) {
        int indexOfStateSet = indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        if (this.topLeftCornerSizeOverride == null && this.topRightCornerSizeOverride == null && this.bottomLeftCornerSizeOverride == null && this.bottomRightCornerSizeOverride == null) {
            return this.shapeAppearanceModels[indexOfStateSet];
        }
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModels[indexOfStateSet].toBuilder();
        if (this.topLeftCornerSizeOverride != null) {
            builder.setTopLeftCornerSize(this.topLeftCornerSizeOverride.getCornerSizeForState(iArr));
        }
        if (this.topRightCornerSizeOverride != null) {
            builder.setTopRightCornerSize(this.topRightCornerSizeOverride.getCornerSizeForState(iArr));
        }
        if (this.bottomLeftCornerSizeOverride != null) {
            builder.setBottomLeftCornerSize(this.bottomLeftCornerSizeOverride.getCornerSizeForState(iArr));
        }
        if (this.bottomRightCornerSizeOverride != null) {
            builder.setBottomRightCornerSize(this.bottomRightCornerSizeOverride.getCornerSizeForState(iArr));
        }
        return builder.build();
    }

    public int getStateCount() {
        return this.stateCount;
    }

    @Override // com.google.android.material.shape.ShapeAppearance
    public boolean isStateful() {
        if (this.stateCount > 1) {
            return true;
        }
        if (this.topLeftCornerSizeOverride != null && this.topLeftCornerSizeOverride.isStateful()) {
            return true;
        }
        if (this.topRightCornerSizeOverride != null && this.topRightCornerSizeOverride.isStateful()) {
            return true;
        }
        if (this.bottomLeftCornerSizeOverride == null || !this.bottomLeftCornerSizeOverride.isStateful()) {
            return this.bottomRightCornerSizeOverride != null && this.bottomRightCornerSizeOverride.isStateful();
        }
        return true;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override // com.google.android.material.shape.ShapeAppearance
    public ShapeAppearanceModel withCornerSize(float f) {
        return getDefaultShape().withCornerSize(f);
    }

    @Override // com.google.android.material.shape.ShapeAppearance
    public ShapeAppearanceModel withCornerSize(CornerSize cornerSize) {
        return getDefaultShape().withCornerSize(cornerSize);
    }

    public StateListShapeAppearanceModel withTransformedCornerSizes(ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().withTransformedCornerSizes(cornerSizeUnaryOperator).build();
    }
}
