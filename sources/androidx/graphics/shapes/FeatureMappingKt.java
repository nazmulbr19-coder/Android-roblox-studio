package androidx.graphics.shapes;

import androidx.graphics.shapes.Feature;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: FeatureMapping.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0000\u001a,\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\u000f\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0010"}, d2 = {"LOG_TAG", "", "doMapping", "", "Landroidx/graphics/shapes/ProgressableFeature;", "Landroidx/graphics/shapes/MeasuredFeatures;", "f1", "f2", "featureDistSquared", "", "Landroidx/graphics/shapes/Feature;", "featureMapper", "Landroidx/graphics/shapes/DoubleMapper;", "features1", "features2", "MeasuredFeatures", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureMappingKt {
    private static final String LOG_TAG = "FeatureMapping";

    public static final List<ProgressableFeature> doMapping(List<ProgressableFeature> list, List<ProgressableFeature> f2) {
        int i;
        int i2;
        List<ProgressableFeature> f1 = list;
        Intrinsics.checkNotNullParameter(f1, "f1");
        Intrinsics.checkNotNullParameter(f2, "f2");
        Iterator<Integer> it = CollectionsKt.getIndices(f2).iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        int nextInt = ((IntIterator) it).nextInt();
        if (it.hasNext()) {
            float featureDistSquared = featureDistSquared(f1.get(0).getFeature(), f2.get(nextInt).getFeature());
            while (true) {
                int nextInt2 = ((IntIterator) it).nextInt();
                float featureDistSquared2 = featureDistSquared(f1.get(0).getFeature(), f2.get(nextInt2).getFeature());
                if (Float.compare(featureDistSquared, featureDistSquared2) > 0) {
                    nextInt = nextInt2;
                    featureDistSquared = featureDistSquared2;
                }
                if (!it.hasNext()) {
                    break;
                }
                f1 = list;
            }
        }
        int size = f1.size();
        int size2 = f2.size();
        List<ProgressableFeature> mutableListOf = CollectionsKt.mutableListOf(f2.get(nextInt));
        int i3 = nextInt;
        int i4 = 1;
        while (i4 < size) {
            int i5 = nextInt - (size - i4);
            if (i5 <= i3) {
                i5 += size2;
            }
            Iterator<Integer> it2 = new IntRange(i3 + 1, i5).iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            int nextInt3 = ((IntIterator) it2).nextInt();
            if (it2.hasNext()) {
                i = size;
                float featureDistSquared3 = featureDistSquared(f1.get(i4).getFeature(), f2.get(nextInt3 % size2).getFeature());
                while (true) {
                    int nextInt4 = ((IntIterator) it2).nextInt();
                    i2 = size2;
                    float featureDistSquared4 = featureDistSquared(f1.get(i4).getFeature(), f2.get(nextInt4 % i2).getFeature());
                    if (Float.compare(featureDistSquared3, featureDistSquared4) > 0) {
                        featureDistSquared3 = featureDistSquared4;
                        nextInt3 = nextInt4;
                    }
                    if (!it2.hasNext()) {
                        break;
                    }
                    f1 = list;
                    size2 = i2;
                }
            } else {
                i = size;
                i2 = size2;
            }
            mutableListOf.add(f2.get(nextInt3 % i2));
            i3 = nextInt3;
            i4++;
            f1 = list;
            size = i;
            size2 = i2;
        }
        return mutableListOf;
    }

    public static final float featureDistSquared(Feature f1, Feature f2) {
        Intrinsics.checkNotNullParameter(f1, "f1");
        Intrinsics.checkNotNullParameter(f2, "f2");
        if ((f1 instanceof Feature.Corner) && (f2 instanceof Feature.Corner) && ((Feature.Corner) f1).getConvex() != ((Feature.Corner) f2).getConvex()) {
            String str = LOG_TAG;
            return Float.MAX_VALUE;
        }
        float anchor0X = (((Cubic) CollectionsKt.first((List) f1.getCubics())).getAnchor0X() + ((Cubic) CollectionsKt.last((List) f1.getCubics())).getAnchor1X()) / 2.0f;
        float anchor0Y = (((Cubic) CollectionsKt.first((List) f1.getCubics())).getAnchor0Y() + ((Cubic) CollectionsKt.last((List) f1.getCubics())).getAnchor1Y()) / 2.0f;
        float anchor0X2 = anchor0X - ((((Cubic) CollectionsKt.first((List) f2.getCubics())).getAnchor0X() + ((Cubic) CollectionsKt.last((List) f2.getCubics())).getAnchor1X()) / 2.0f);
        float anchor0Y2 = anchor0Y - ((((Cubic) CollectionsKt.first((List) f2.getCubics())).getAnchor0Y() + ((Cubic) CollectionsKt.last((List) f2.getCubics())).getAnchor1Y()) / 2.0f);
        return (anchor0X2 * anchor0X2) + (anchor0Y2 * anchor0Y2);
    }

    public static final DoubleMapper featureMapper(List<ProgressableFeature> features1, List<ProgressableFeature> features2) {
        Intrinsics.checkNotNullParameter(features1, "features1");
        Intrinsics.checkNotNullParameter(features2, "features2");
        List createListBuilder = CollectionsKt.createListBuilder();
        int size = features1.size();
        for (int i = 0; i < size; i++) {
            if (features1.get(i).getFeature() instanceof Feature.Corner) {
                createListBuilder.add(features1.get(i));
            }
        }
        List build = CollectionsKt.build(createListBuilder);
        List createListBuilder2 = CollectionsKt.createListBuilder();
        int size2 = features2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (features2.get(i2).getFeature() instanceof Feature.Corner) {
                createListBuilder2.add(features2.get(i2));
            }
        }
        List build2 = CollectionsKt.build(createListBuilder2);
        Pair pair = build.size() > build2.size() ? TuplesKt.to(doMapping(build2, build), build2) : TuplesKt.to(build, doMapping(build, build2));
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        List createListBuilder3 = CollectionsKt.createListBuilder();
        int size3 = list.size();
        for (int i3 = 0; i3 < size3 && i3 != list2.size(); i3++) {
            createListBuilder3.add(TuplesKt.to(Float.valueOf(((ProgressableFeature) list.get(i3)).getProgress()), Float.valueOf(((ProgressableFeature) list2.get(i3)).getProgress())));
        }
        List build3 = CollectionsKt.build(createListBuilder3);
        String str = LOG_TAG;
        Pair[] pairArr = (Pair[]) build3.toArray(new Pair[0]);
        DoubleMapper doubleMapper = new DoubleMapper((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        String str2 = LOG_TAG;
        return doubleMapper;
    }
}
