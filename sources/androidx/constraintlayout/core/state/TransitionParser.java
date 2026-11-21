package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class TransitionParser {
    private static int map(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return 0;
    }

    private static void map(TypedBundle typedBundle, int i, String str, String... strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2].equals(str)) {
                typedBundle.add(i, i2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void parse(CLObject cLObject, Transition transition) throws CLParsingException {
        char c;
        transition.resetProperties();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z = false;
        if (stringOrNull != null) {
            z = true;
            switch (stringOrNull.hashCode()) {
                case -1857024520:
                    if (stringOrNull.equals("startVertical")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1007052250:
                    if (stringOrNull.equals("startHorizontal")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3145837:
                    if (stringOrNull.equals("flip")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3387192:
                    if (stringOrNull.equals(AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_NONE_SCRIPT)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 92611485:
                    if (stringOrNull.equals("above")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 93621297:
                    if (stringOrNull.equals("below")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    typedBundle.add(509, 0);
                    break;
                case 1:
                    typedBundle.add(509, 1);
                    break;
                case 2:
                    typedBundle.add(509, 2);
                    break;
                case 3:
                    typedBundle.add(509, 3);
                    break;
                case 4:
                    typedBundle.add(509, 4);
                    break;
                case 5:
                    typedBundle.add(509, 5);
                    break;
            }
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            z = true;
            typedBundle.add(TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (!Float.isNaN(floatOrNaN)) {
            z = true;
            typedBundle.add(TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        }
        if (z) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            parseOnSwipe(objectOrNull, transition);
        }
        parseKeyFrames(cLObject, transition);
    }

    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) throws CLParsingException {
        parse(cLObject, transition);
    }

    private static void parseKeyAttribute(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray arrayOrNull;
        String[] strArr;
        int[] iArr;
        CLObject cLObject2;
        int i;
        CLObject cLObject3;
        boolean[] zArr;
        int i2;
        CLArray arrayOrNull2 = cLObject.getArrayOrNull(TypedValues.AttributesType.S_TARGET);
        if (arrayOrNull2 == null || (arrayOrNull = cLObject.getArrayOrNull("frames")) == null) {
            return;
        }
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        int i3 = 0;
        boolean z = true;
        String[] strArr2 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
        int[] iArr2 = {311, 312, 304, 305, 306, 308, 309, 310, 303};
        boolean[] zArr2 = {false, false, true, true, true, false, false, false, false};
        TypedBundle[] typedBundleArr = new TypedBundle[arrayOrNull.size()];
        CustomVariable[][] customVariableArr = null;
        for (int i4 = 0; i4 < arrayOrNull.size(); i4++) {
            typedBundleArr[i4] = new TypedBundle();
        }
        int i5 = 0;
        while (i5 < strArr2.length) {
            String str = strArr2[i5];
            int i6 = iArr2[i5];
            boolean z2 = zArr2[i5];
            boolean z3 = z;
            CLArray arrayOrNull3 = cLObject.getArrayOrNull(str);
            if (arrayOrNull3 != null) {
                i2 = i3;
                if (arrayOrNull3.size() != typedBundleArr.length) {
                    throw new CLParsingException("incorrect size for " + str + " array, not matching targets array!", cLObject);
                }
                zArr = zArr2;
            } else {
                zArr = zArr2;
                i2 = i3;
            }
            if (arrayOrNull3 != null) {
                for (int i7 = 0; i7 < typedBundleArr.length; i7++) {
                    float f = arrayOrNull3.getFloat(i7);
                    if (z2) {
                        f = transition.mToPixel.toPixels(f);
                    }
                    typedBundleArr[i7].add(i6, f);
                }
            } else {
                float floatOrNaN = cLObject.getFloatOrNaN(str);
                if (!Float.isNaN(floatOrNaN)) {
                    if (z2) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    }
                    for (TypedBundle typedBundle : typedBundleArr) {
                        typedBundle.add(i6, floatOrNaN);
                    }
                }
            }
            i5++;
            z = z3;
            i3 = i2;
            zArr2 = zArr;
        }
        int i8 = i3;
        boolean z4 = z;
        CLElement orNull = cLObject.getOrNull("custom");
        if (orNull != null && (orNull instanceof CLObject)) {
            CLObject cLObject4 = (CLObject) orNull;
            int size = cLObject4.size();
            int size2 = arrayOrNull.size();
            int[] iArr3 = new int[2];
            iArr3[z4 ? 1 : 0] = size;
            iArr3[i8] = size2;
            customVariableArr = (CustomVariable[][]) Array.newInstance((Class<?>) CustomVariable.class, iArr3);
            int i9 = 0;
            while (i9 < size) {
                CLKey cLKey = (CLKey) cLObject4.get(i9);
                String content = cLKey.content();
                CLElement cLElement = orNull;
                if (cLKey.getValue() instanceof CLArray) {
                    CLArray cLArray = (CLArray) cLKey.getValue();
                    int size3 = cLArray.size();
                    strArr = strArr2;
                    if (size3 != typedBundleArr.length || size3 <= 0) {
                        iArr = iArr2;
                        cLObject2 = cLObject4;
                    } else if (cLArray.get(i8) instanceof CLNumber) {
                        int i10 = 0;
                        while (i10 < typedBundleArr.length) {
                            customVariableArr[i10][i9] = new CustomVariable(content, TypedValues.Custom.TYPE_FLOAT, cLArray.get(i10).getFloat());
                            i10++;
                            iArr2 = iArr2;
                        }
                        iArr = iArr2;
                        cLObject2 = cLObject4;
                    } else {
                        iArr = iArr2;
                        int i11 = 0;
                        while (i11 < typedBundleArr.length) {
                            long parseColorString = ConstraintSetParser.parseColorString(cLArray.get(i11).content());
                            if (parseColorString != -1) {
                                i = i11;
                                cLObject3 = cLObject4;
                                customVariableArr[i11][i9] = new CustomVariable(content, TypedValues.Custom.TYPE_COLOR, (int) parseColorString);
                            } else {
                                i = i11;
                                cLObject3 = cLObject4;
                            }
                            i11 = i + 1;
                            cLObject4 = cLObject3;
                        }
                        cLObject2 = cLObject4;
                    }
                } else {
                    strArr = strArr2;
                    iArr = iArr2;
                    cLObject2 = cLObject4;
                    CLElement value = cLKey.getValue();
                    if (value instanceof CLNumber) {
                        float f2 = value.getFloat();
                        int i12 = 0;
                        while (i12 < typedBundleArr.length) {
                            customVariableArr[i12][i9] = new CustomVariable(content, TypedValues.Custom.TYPE_FLOAT, f2);
                            i12++;
                            value = value;
                        }
                    } else {
                        long parseColorString2 = ConstraintSetParser.parseColorString(value.content());
                        if (parseColorString2 != -1) {
                            int i13 = 0;
                            while (i13 < typedBundleArr.length) {
                                customVariableArr[i13][i9] = new CustomVariable(content, TypedValues.Custom.TYPE_COLOR, (int) parseColorString2);
                                i13++;
                                parseColorString2 = parseColorString2;
                            }
                        }
                    }
                }
                i9++;
                orNull = cLElement;
                strArr2 = strArr;
                iArr2 = iArr;
                cLObject4 = cLObject2;
                i8 = 0;
            }
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        for (int i14 = 0; i14 < arrayOrNull2.size(); i14++) {
            for (int i15 = 0; i15 < typedBundleArr.length; i15++) {
                String string = arrayOrNull2.getString(i14);
                TypedBundle typedBundle2 = typedBundleArr[i15];
                if (stringOrNull2 != null) {
                    String[] strArr3 = new String[2];
                    strArr3[0] = "spline";
                    strArr3[z4 ? 1 : 0] = "linear";
                    typedBundle2.add(TypedValues.PositionType.TYPE_CURVE_FIT, map(stringOrNull2, strArr3));
                }
                typedBundle2.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                typedBundle2.add(100, arrayOrNull.getInt(i15));
                transition.addKeyAttribute(string, typedBundle2, customVariableArr != null ? customVariableArr[i15] : null);
            }
        }
    }

    private static void parseKeyCycle(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray cLArray;
        char c;
        int[] iArr;
        String[] strArr;
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray("frames");
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        String[] strArr2 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha", TypedValues.CycleType.S_WAVE_PERIOD, TypedValues.CycleType.S_WAVE_OFFSET, TypedValues.CycleType.S_WAVE_PHASE};
        int[] iArr2 = {311, 312, 304, 305, 306, 308, 309, 310, TypedValues.CycleType.TYPE_ALPHA, TypedValues.CycleType.TYPE_WAVE_PERIOD, TypedValues.CycleType.TYPE_WAVE_OFFSET, TypedValues.CycleType.TYPE_WAVE_PHASE};
        int[] iArr3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0};
        TypedBundle[] typedBundleArr = new TypedBundle[array2.size()];
        for (int i = 0; i < typedBundleArr.length; i++) {
            typedBundleArr[i] = new TypedBundle();
        }
        boolean z = false;
        for (int i2 = 0; i2 < strArr2.length; i2++) {
            if (cLObject.has(strArr2[i2]) && iArr3[i2] == 1) {
                z = true;
            }
        }
        int i3 = 0;
        while (i3 < strArr2.length) {
            String str = strArr2[i3];
            int i4 = iArr2[i3];
            int i5 = iArr3[i3];
            CLArray arrayOrNull = cLObject.getArrayOrNull(str);
            if (arrayOrNull != null) {
                iArr = iArr3;
                if (arrayOrNull.size() != typedBundleArr.length) {
                    throw new CLParsingException("incorrect size for $attrName array, not matching targets array!", cLObject);
                }
            } else {
                iArr = iArr3;
            }
            if (arrayOrNull != null) {
                int i6 = 0;
                while (i6 < typedBundleArr.length) {
                    float f = arrayOrNull.getFloat(i6);
                    int i7 = i6;
                    if (i5 == 1) {
                        f = transition.mToPixel.toPixels(f);
                    } else if (i5 == 2 && z) {
                        f = transition.mToPixel.toPixels(f);
                    }
                    typedBundleArr[i7].add(i4, f);
                    i6 = i7 + 1;
                }
                strArr = strArr2;
            } else {
                float floatOrNaN = cLObject.getFloatOrNaN(str);
                if (Float.isNaN(floatOrNaN)) {
                    strArr = strArr2;
                } else {
                    if (i5 == 1) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    } else if (i5 == 2 && z) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    }
                    int i8 = 0;
                    while (true) {
                        strArr = strArr2;
                        if (i8 < typedBundleArr.length) {
                            typedBundleArr[i8].add(i4, floatOrNaN);
                            i8++;
                            strArr2 = strArr;
                        }
                    }
                }
            }
            i3++;
            iArr3 = iArr;
            strArr2 = strArr;
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        String stringOrNull3 = cLObject.getStringOrNull("easing");
        String stringOrNull4 = cLObject.getStringOrNull("waveShape");
        String stringOrNull5 = cLObject.getStringOrNull(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE);
        for (int i9 = 0; i9 < array.size(); i9++) {
            int i10 = 0;
            while (i10 < typedBundleArr.length) {
                String string = array.getString(i9);
                TypedBundle typedBundle = typedBundleArr[i10];
                if (stringOrNull2 != null) {
                    switch (stringOrNull2.hashCode()) {
                        case -1102672091:
                            if (stringOrNull2.equals("linear")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -895858735:
                            if (stringOrNull2.equals("spline")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    switch (c) {
                        case 0:
                            cLArray = array;
                            typedBundle.add(TypedValues.CycleType.TYPE_CURVE_FIT, 0);
                            break;
                        case 1:
                            cLArray = array;
                            typedBundle.add(TypedValues.CycleType.TYPE_CURVE_FIT, 1);
                            break;
                        default:
                            cLArray = array;
                            break;
                    }
                } else {
                    cLArray = array;
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                if (stringOrNull3 != null) {
                    typedBundle.add(TypedValues.CycleType.TYPE_EASING, stringOrNull3);
                }
                if (stringOrNull4 != null) {
                    typedBundle.add(TypedValues.CycleType.TYPE_WAVE_SHAPE, stringOrNull4);
                }
                if (stringOrNull5 != null) {
                    typedBundle.add(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, stringOrNull5);
                }
                typedBundle.add(100, array2.getInt(i10));
                transition.addKeyCycle(string, typedBundle);
                i10++;
                array = cLArray;
            }
        }
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull == null) {
            return;
        }
        CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
        if (arrayOrNull != null) {
            for (int i = 0; i < arrayOrNull.size(); i++) {
                CLElement cLElement = arrayOrNull.get(i);
                if (cLElement instanceof CLObject) {
                    parseKeyPosition((CLObject) cLElement, transition);
                }
            }
        }
        CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
        if (arrayOrNull2 != null) {
            for (int i2 = 0; i2 < arrayOrNull2.size(); i2++) {
                CLElement cLElement2 = arrayOrNull2.get(i2);
                if (cLElement2 instanceof CLObject) {
                    parseKeyAttribute((CLObject) cLElement2, transition);
                }
            }
        }
        CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
        if (arrayOrNull3 != null) {
            for (int i3 = 0; i3 < arrayOrNull3.size(); i3++) {
                CLElement cLElement3 = arrayOrNull3.get(i3);
                if (cLElement3 instanceof CLObject) {
                    parseKeyCycle((CLObject) cLElement3, transition);
                }
            }
        }
    }

    private static void parseKeyPosition(CLObject cLObject, Transition transition) throws CLParsingException {
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray("frames");
        CLArray arrayOrNull = cLObject.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull == null || array2.size() == arrayOrNull.size()) {
            if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
                int i = 0;
                while (i < array.size()) {
                    String string = array.getString(i);
                    int map = map(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                    typedBundle.clear();
                    typedBundle.add(TypedValues.PositionType.TYPE_POSITION_TYPE, map);
                    if (stringOrNull3 != null) {
                        map(typedBundle, TypedValues.PositionType.TYPE_CURVE_FIT, stringOrNull3, "spline", "linear");
                    }
                    typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull2);
                    if (stringOrNull != null) {
                        map(typedBundle, 509, stringOrNull, AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_NONE_SCRIPT, "startVertical", "startHorizontal", "flip", "below", "above");
                    }
                    int i2 = 0;
                    while (i2 < array2.size()) {
                        typedBundle.add(100, array2.getInt(i2));
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_X, arrayOrNull, i2);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_Y, arrayOrNull2, i2);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_WIDTH, arrayOrNull3, i2);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, arrayOrNull4, i2);
                        transition.addKeyPosition(string, typedBundle);
                        i2++;
                        array = array;
                    }
                    i++;
                    array = array;
                }
            }
        }
    }

    private static void parseOnSwipe(CLContainer cLContainer, Transition transition) {
        String stringOrNull = cLContainer.getStringOrNull("anchor");
        int map = map(cLContainer.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int map2 = map(cLContainer.getStringOrNull("direction"), Transition.OnSwipe.DIRECTIONS);
        float floatOrNaN = cLContainer.getFloatOrNaN("scale");
        float floatOrNaN2 = cLContainer.getFloatOrNaN("threshold");
        float floatOrNaN3 = cLContainer.getFloatOrNaN("maxVelocity");
        float floatOrNaN4 = cLContainer.getFloatOrNaN("maxAccel");
        String stringOrNull2 = cLContainer.getStringOrNull("limitBounds");
        int map3 = map(cLContainer.getStringOrNull("mode"), Transition.OnSwipe.MODE);
        int map4 = map(cLContainer.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float floatOrNaN5 = cLContainer.getFloatOrNaN("springMass");
        float floatOrNaN6 = cLContainer.getFloatOrNaN("springStiffness");
        float floatOrNaN7 = cLContainer.getFloatOrNaN("springDamping");
        float floatOrNaN8 = cLContainer.getFloatOrNaN("stopThreshold");
        int map5 = map(cLContainer.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String stringOrNull3 = cLContainer.getStringOrNull("around");
        Transition.OnSwipe createOnSwipe = transition.createOnSwipe();
        createOnSwipe.setAnchorId(stringOrNull);
        createOnSwipe.setAnchorSide(map);
        createOnSwipe.setDragDirection(map2);
        createOnSwipe.setDragScale(floatOrNaN);
        createOnSwipe.setDragThreshold(floatOrNaN2);
        createOnSwipe.setMaxVelocity(floatOrNaN3);
        createOnSwipe.setMaxAcceleration(floatOrNaN4);
        createOnSwipe.setLimitBoundsTo(stringOrNull2);
        createOnSwipe.setAutoCompleteMode(map3);
        createOnSwipe.setOnTouchUp(map4);
        createOnSwipe.setSpringMass(floatOrNaN5);
        createOnSwipe.setSpringStiffness(floatOrNaN6);
        createOnSwipe.setSpringDamping(floatOrNaN7);
        createOnSwipe.setSpringStopThreshold(floatOrNaN8);
        createOnSwipe.setSpringBoundary(map5);
        createOnSwipe.setRotationCenterId(stringOrNull3);
    }

    private static void set(TypedBundle typedBundle, int i, CLArray cLArray, int i2) throws CLParsingException {
        if (cLArray != null) {
            typedBundle.add(i, cLArray.getFloat(i2));
        }
    }
}
