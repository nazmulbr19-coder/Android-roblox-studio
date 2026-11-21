package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.ChainReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    /* loaded from: classes.dex */
    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        DesignElement(String str, String str2, HashMap<String, String> hashMap) {
            this.mId = str;
            this.mType = str2;
            this.mParams = hashMap;
        }

        public String getId() {
            return this.mId;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        public String getType() {
            return this.mType;
        }
    }

    /* loaded from: classes.dex */
    static class FiniteGenerator implements GeneratedValue {
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        float mTo;
        boolean mStop = false;
        float mCurrent = 0.0f;

        FiniteGenerator(float f, float f2, float f3, String str, String str2) {
            this.mFrom = 0.0f;
            this.mTo = 0.0f;
            this.mStep = 0.0f;
            this.mFrom = f;
            this.mTo = f2;
            this.mStep = f3;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 != null ? str2 : "";
            this.mMax = f2;
            this.mInitial = f;
        }

        public ArrayList<String> array() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i = (int) this.mInitial;
            int i2 = (int) this.mMax;
            for (int i3 = i; i3 <= i2; i3++) {
                arrayList.add(this.mPrefix + i + this.mPostfix);
                i += (int) this.mStep;
            }
            return arrayList;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (this.mCurrent >= this.mMax) {
                this.mStop = true;
            }
            if (!this.mStop) {
                this.mCurrent += this.mStep;
            }
            return this.mCurrent;
        }
    }

    /* loaded from: classes.dex */
    interface GeneratedValue {
        float value();
    }

    /* loaded from: classes.dex */
    static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        Generator(float f, float f2) {
            this.mStart = 0.0f;
            this.mIncrementBy = 0.0f;
            this.mCurrent = 0.0f;
            this.mStart = f;
            this.mIncrementBy = f2;
            this.mCurrent = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutVariables {
        HashMap<String, Integer> mMargins = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();

        float get(Object obj) {
            if (!(obj instanceof CLString)) {
                if (obj instanceof CLNumber) {
                    return ((CLNumber) obj).getFloat();
                }
                return 0.0f;
            }
            String content = ((CLString) obj).content();
            if (this.mGenerators.containsKey(content)) {
                return this.mGenerators.get(content).value();
            }
            if (this.mMargins.containsKey(content)) {
                return this.mMargins.get(content).floatValue();
            }
            return 0.0f;
        }

        ArrayList<String> getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return this.mArrayIds.get(str);
            }
            return null;
        }

        void put(String str, float f, float f2) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            this.mGenerators.put(str, new Generator(f, f2));
        }

        void put(String str, float f, float f2, float f3, String str2, String str3) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            FiniteGenerator finiteGenerator = new FiniteGenerator(f, f2, f3, str2, str3);
            this.mGenerators.put(str, finiteGenerator);
            this.mArrayIds.put(str, finiteGenerator.array());
        }

        void put(String str, int i) {
            this.mMargins.put(str, Integer.valueOf(i));
        }

        void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }

        public void putOverride(String str, float f) {
            this.mGenerators.put(str, new OverrideValue(f));
        }
    }

    /* loaded from: classes.dex */
    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    static class OverrideValue implements GeneratedValue {
        float mValue;

        OverrideValue(float f) {
            this.mValue = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            return this.mValue;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b2, code lost:
    
        if (r0.equals("invisible") != false) goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void applyAttribute(androidx.constraintlayout.core.state.State r8, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r9, androidx.constraintlayout.core.state.ConstraintReference r10, androidx.constraintlayout.core.parser.CLObject r11, java.lang.String r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.applyAttribute(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.parser.CLObject, java.lang.String):void");
    }

    private static int indexOf(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    static String lookForType(CLObject cLObject) throws CLParsingException {
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            if (it.next().equals(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                return cLObject.getString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            }
        }
        return null;
    }

    static void override(CLObject cLObject, String str, CLObject cLObject2) throws CLParsingException {
        char c;
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        Iterator<String> it = cLObject2.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.equals("clear")) {
                CLArray array = cLObject2.getArray("clear");
                for (int i = 0; i < array.size(); i++) {
                    String stringOrNull = array.getStringOrNull(i);
                    if (stringOrNull != null) {
                        switch (stringOrNull.hashCode()) {
                            case -1727069561:
                                if (stringOrNull.equals("transforms")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -1606703562:
                                if (stringOrNull.equals("constraints")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 414334925:
                                if (stringOrNull.equals("dimensions")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        c = 65535;
                        switch (c) {
                            case 0:
                                object.remove("width");
                                object.remove("height");
                                break;
                            case 1:
                                object.remove("start");
                                object.remove("end");
                                object.remove("top");
                                object.remove("bottom");
                                object.remove("baseline");
                                object.remove("center");
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                                break;
                            case 2:
                                object.remove("visibility");
                                object.remove("alpha");
                                object.remove("pivotX");
                                object.remove("pivotY");
                                object.remove("rotationX");
                                object.remove("rotationY");
                                object.remove("rotationZ");
                                object.remove("scaleX");
                                object.remove("scaleY");
                                object.remove("translationX");
                                object.remove("translationY");
                                break;
                            default:
                                object.remove(stringOrNull);
                                break;
                        }
                    }
                }
            } else {
                object.put(next, cLObject2.get(next));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00b4, code lost:
    
        if (r6.equals("left") != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void parseBarrier(androidx.constraintlayout.core.state.State r11, java.lang.String r12, androidx.constraintlayout.core.parser.CLObject r13) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseBarrier(androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:37:0x00b5. Please report as an issue. */
    static void parseChain(int i, State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        boolean z;
        String content;
        ChainReference horizontalChain = i == 0 ? state.horizontalChain() : state.verticalChain();
        CLElement cLElement = cLArray.get(1);
        if ((cLElement instanceof CLArray) && ((CLArray) cLElement).size() >= 1) {
            for (int i2 = 0; i2 < ((CLArray) cLElement).size(); i2++) {
                horizontalChain.add(((CLArray) cLElement).getString(i2));
            }
            if (cLArray.size() > 2) {
                CLElement cLElement2 = cLArray.get(2);
                if (cLElement2 instanceof CLObject) {
                    Iterator<String> it = ((CLObject) cLElement2).names().iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        char c = 65535;
                        switch (next.hashCode()) {
                            case 109780401:
                                if (next.equals("style")) {
                                    z = false;
                                    break;
                                }
                                break;
                        }
                        z = -1;
                        switch (z) {
                            case false:
                                CLElement cLElement3 = ((CLObject) cLElement2).get(next);
                                if (!(cLElement3 instanceof CLArray) || ((CLArray) cLElement3).size() <= 1) {
                                    content = cLElement3.content();
                                } else {
                                    content = ((CLArray) cLElement3).getString(0);
                                    horizontalChain.bias(((CLArray) cLElement3).getFloat(1));
                                }
                                switch (content.hashCode()) {
                                    case -995865480:
                                        if (content.equals("packed")) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                    case 1311368264:
                                        if (content.equals("spread_inside")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        horizontalChain.style(State.Chain.PACKED);
                                        break;
                                    case 1:
                                        horizontalChain.style(State.Chain.SPREAD_INSIDE);
                                        break;
                                    default:
                                        horizontalChain.style(State.Chain.SPREAD);
                                        break;
                                }
                                break;
                            default:
                                parseConstraint(state, layoutVariables, (CLObject) cLElement2, horizontalChain, next);
                                break;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00db, code lost:
    
        switch(r8) {
            case 0: goto L57;
            case 1: goto L56;
            default: goto L55;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00de, code lost:
    
        r6.style(androidx.constraintlayout.core.state.State.Chain.SPREAD);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e5, code lost:
    
        r6.style(androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ec, code lost:
    
        r6.style(androidx.constraintlayout.core.state.State.Chain.PACKED);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x003b. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseChainType(java.lang.String r24, androidx.constraintlayout.core.state.State r25, java.lang.String r26, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r27, androidx.constraintlayout.core.parser.CLObject r28) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChainType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long parseColorString(String str) {
        if (!str.startsWith("#")) {
            return -1L;
        }
        String substring = str.substring(1);
        if (substring.length() == 6) {
            substring = "FF" + substring;
        }
        return Long.parseLong(substring, 16);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0287, code lost:
    
        if (r29.equals("top") != false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x01fd, code lost:
    
        if (r8.equals("start") != false) goto L135;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void parseConstraint(androidx.constraintlayout.core.state.State r25, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r26, androidx.constraintlayout.core.parser.CLObject r27, androidx.constraintlayout.core.state.ConstraintReference r28, java.lang.String r29) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseConstraint(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.ConstraintReference, java.lang.String):void");
    }

    static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLObject object = cLObject.getObject(next);
            boolean z = false;
            String stringOrNull = object.getStringOrNull("Extends");
            if (stringOrNull != null && !stringOrNull.isEmpty()) {
                String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                if (constraintSet != null) {
                    CLObject parse = CLParser.parse(constraintSet);
                    ArrayList<String> names2 = object.names();
                    if (names2 != null) {
                        Iterator<String> it2 = names2.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            CLElement cLElement = object.get(next2);
                            if (cLElement instanceof CLObject) {
                                override(parse, next2, (CLObject) cLElement);
                            }
                        }
                        coreMotionScene.setConstraintSetContent(next, parse.toJSON());
                        z = true;
                    }
                }
            }
            if (!z) {
                coreMotionScene.setConstraintSetContent(next, object.toJSON());
            }
        }
    }

    static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull == null || (names = objectOrNull.names()) == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = objectOrNull.get(next);
            if (cLElement instanceof CLNumber) {
                constraintReference.addCustomFloat(next, cLElement.getFloat());
            } else if (cLElement instanceof CLString) {
                long parseColorString = parseColorString(cLElement.content());
                if (parseColorString != -1) {
                    constraintReference.addCustomColor(next, (int) parseColorString);
                }
            }
        }
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        char c;
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && 0 < names.size()) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            int i = 0;
            switch (str2.hashCode()) {
                case 2043588062:
                    if (str2.equals("Design")) {
                        c = 0;
                        break;
                    }
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (cLElement instanceof CLObject) {
                        ArrayList<String> names2 = ((CLObject) cLElement).names();
                        int i2 = 0;
                        while (i2 < names2.size()) {
                            String str3 = names2.get(i2);
                            CLObject cLObject = (CLObject) ((CLObject) cLElement).get(str3);
                            System.out.printf("element found " + str3 + "", new Object[i]);
                            String stringOrNull = cLObject.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                            if (stringOrNull != null) {
                                HashMap hashMap = new HashMap();
                                int size = cLObject.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    CLKey cLKey = (CLKey) cLObject.get(i2);
                                    String content = cLKey.content();
                                    String content2 = cLKey.getValue().content();
                                    if (content2 != null) {
                                        hashMap.put(content, content2);
                                    }
                                }
                                arrayList.add(new DesignElement(str2, stringOrNull, hashMap));
                            }
                            i2++;
                            i = 0;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension createFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (!(cLElement instanceof CLObject)) {
            return createFixed;
        }
        CLObject cLObject2 = (CLObject) cLElement;
        String stringOrNull = cLObject2.getStringOrNull("value");
        if (stringOrNull != null) {
            createFixed = parseDimensionMode(stringOrNull);
        }
        CLElement orNull = cLObject2.getOrNull("min");
        if (orNull != null) {
            if (orNull instanceof CLNumber) {
                createFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
            } else if (orNull instanceof CLString) {
                createFixed.min(Dimension.WRAP_DIMENSION);
            }
        }
        CLElement orNull2 = cLObject2.getOrNull("max");
        if (orNull2 == null) {
            return createFixed;
        }
        if (orNull2 instanceof CLNumber) {
            createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
            return createFixed;
        }
        if (!(orNull2 instanceof CLString)) {
            return createFixed;
        }
        createFixed.max(Dimension.WRAP_DIMENSION);
        return createFixed;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static Dimension parseDimensionMode(String str) {
        char c;
        Dimension createFixed = Dimension.createFixed(0);
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -995424086:
                if (str.equals("parent")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -895684237:
                if (str.equals("spread")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c = 0;
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
                return Dimension.createWrap();
            case 1:
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case 2:
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case 3:
                return Dimension.createParent();
            default:
                return str.endsWith("%") ? Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0) : str.contains(":") ? Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION) : createFixed;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02ee, code lost:
    
        switch(r11) {
            case 0: goto L139;
            case 1: goto L138;
            default: goto L137;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02f1, code lost:
    
        r8.setHorizontalAlign(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02f6, code lost:
    
        r8.setHorizontalAlign(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02fa, code lost:
    
        r8.setHorizontalAlign(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0331, code lost:
    
        switch(r11) {
            case 0: goto L157;
            case 1: goto L156;
            case 2: goto L155;
            default: goto L154;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0334, code lost:
    
        r8.setVerticalAlign(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0339, code lost:
    
        r8.setVerticalAlign(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x033d, code lost:
    
        r8.setVerticalAlign(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0341, code lost:
    
        r8.setVerticalAlign(0);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0035. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseFlowType(java.lang.String r19, androidx.constraintlayout.core.state.State r20, java.lang.String r21, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r22, androidx.constraintlayout.core.parser.CLObject r23) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 1406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseFlowType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            ArrayList<String> list = layoutVariables.getList(next);
            if (list != null && (cLElement instanceof CLObject)) {
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    parseWidget(state, layoutVariables, it2.next(), (CLObject) cLElement);
                }
            }
        }
    }

    private static void parseGridType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        char c;
        float f;
        float f2;
        float f3;
        float f4;
        GridReference grid = state.getGrid(str2, str);
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            switch (next.hashCode()) {
                case -1439500848:
                    if (next.equals("orientation")) {
                        c = 1;
                        break;
                    }
                    break;
                case -806339567:
                    if (next.equals("padding")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -567445985:
                    if (next.equals("contains")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3169614:
                    if (next.equals("hGap")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3506649:
                    if (next.equals("rows")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3586688:
                    if (next.equals("vGap")) {
                        c = 5;
                        break;
                    }
                    break;
                case 97513095:
                    if (next.equals("flags")) {
                        c = 11;
                        break;
                    }
                    break;
                case 109497044:
                    if (next.equals("skips")) {
                        c = 7;
                        break;
                    }
                    break;
                case 109638249:
                    if (next.equals("spans")) {
                        c = 6;
                        break;
                    }
                    break;
                case 144441793:
                    if (next.equals("rowWeights")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 949721053:
                    if (next.equals("columns")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2033353925:
                    if (next.equals("columnWeights")) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                    if (arrayOrNull != null) {
                        for (int i = 0; i < arrayOrNull.size(); i++) {
                            grid.add(state.constraints(arrayOrNull.get(i).content()));
                        }
                        break;
                    } else {
                        break;
                    }
                case 1:
                    grid.setOrientation(cLObject.get(next).getInt());
                    break;
                case 2:
                    int i2 = cLObject.get(next).getInt();
                    if (i2 > 0) {
                        grid.setRowsSet(i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    int i3 = cLObject.get(next).getInt();
                    if (i3 > 0) {
                        grid.setColumnsSet(i3);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    grid.setHorizontalGaps(toPix(state, cLObject.get(next).getFloat()));
                    break;
                case 5:
                    grid.setVerticalGaps(toPix(state, cLObject.get(next).getFloat()));
                    break;
                case 6:
                    String content = cLObject.get(next).content();
                    if (content == null || !content.contains(":")) {
                        break;
                    } else {
                        grid.setSpans(content);
                        break;
                    }
                case 7:
                    String content2 = cLObject.get(next).content();
                    if (content2 == null || !content2.contains(":")) {
                        break;
                    } else {
                        grid.setSkips(content2);
                        break;
                    }
                    break;
                case '\b':
                    String content3 = cLObject.get(next).content();
                    if (content3 == null || !content3.contains(",")) {
                        break;
                    } else {
                        grid.setRowWeights(content3);
                        break;
                    }
                case '\t':
                    String content4 = cLObject.get(next).content();
                    if (content4 == null || !content4.contains(",")) {
                        break;
                    } else {
                        grid.setColumnWeights(content4);
                        break;
                    }
                case '\n':
                    CLElement cLElement = cLObject.get(next);
                    if (!(cLElement instanceof CLArray) || ((CLArray) cLElement).size() <= 1) {
                        f = cLElement.getInt();
                        f2 = f;
                        f3 = f;
                        f4 = f;
                    } else {
                        f = ((CLArray) cLElement).getInt(0);
                        f3 = f;
                        f2 = ((CLArray) cLElement).getInt(1);
                        f4 = f2;
                        if (((CLArray) cLElement).size() > 2) {
                            float f5 = ((CLArray) cLElement).getInt(2);
                            try {
                                f4 = ((CLArray) cLElement).getInt(3);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                f4 = 0.0f;
                            }
                            f3 = f5;
                        }
                    }
                    grid.setPaddingStart(Math.round(toPix(state, f)));
                    grid.setPaddingTop(Math.round(toPix(state, f2)));
                    grid.setPaddingEnd(Math.round(toPix(state, f3)));
                    grid.setPaddingBottom(Math.round(toPix(state, f4)));
                    break;
                case 11:
                    int i4 = 0;
                    String str3 = "";
                    try {
                        CLElement cLElement2 = cLObject.get(next);
                        if (cLElement2 instanceof CLNumber) {
                            i4 = cLElement2.getInt();
                        } else {
                            str3 = cLElement2.content();
                        }
                    } catch (Exception e2) {
                        System.err.println("Error parsing grid flags " + e2);
                    }
                    if (str3 != null && !str3.isEmpty()) {
                        grid.setFlags(str3);
                        break;
                    } else {
                        grid.setFlags(i4);
                        break;
                    }
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, next);
                    break;
            }
        }
    }

    static void parseGuideline(int i, State state, CLArray cLArray) throws CLParsingException {
        String stringOrNull;
        CLElement cLElement = cLArray.get(1);
        if ((cLElement instanceof CLObject) && (stringOrNull = ((CLObject) cLElement).getStringOrNull("id")) != null) {
            parseGuidelineParams(i, state, stringOrNull, (CLObject) cLElement);
        }
    }

    static void parseGuidelineParams(int i, State state, String str, CLObject cLObject) throws CLParsingException {
        char c;
        ArrayList<String> arrayList;
        ConstraintReference constraintReference;
        boolean z;
        char c2;
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        ConstraintReference constraints = state.constraints(str);
        if (i == 0) {
            state.horizontalGuideline(str);
        } else {
            state.verticalGuideline(str);
        }
        boolean z2 = !state.isRtl() || i == 0;
        GuidelineReference guidelineReference = (GuidelineReference) constraints.getFacade();
        boolean z3 = false;
        float f = 0.0f;
        boolean z4 = true;
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            switch (next.hashCode()) {
                case -678927291:
                    if (next.equals("percent")) {
                        c = 4;
                        break;
                    }
                    break;
                case 100571:
                    if (next.equals("end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        c = 0;
                        break;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        c = 1;
                        break;
                    }
                    break;
                case 109757538:
                    if (next.equals("start")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    arrayList = names;
                    constraintReference = constraints;
                    z = z2;
                    f = toPix(state, cLObject.getFloat(next));
                    z4 = true;
                    break;
                case 1:
                    arrayList = names;
                    constraintReference = constraints;
                    z = z2;
                    f = toPix(state, cLObject.getFloat(next));
                    z4 = false;
                    break;
                case 2:
                    arrayList = names;
                    constraintReference = constraints;
                    z = z2;
                    f = toPix(state, cLObject.getFloat(next));
                    z4 = z;
                    break;
                case 3:
                    arrayList = names;
                    constraintReference = constraints;
                    z = z2;
                    f = toPix(state, cLObject.getFloat(next));
                    z4 = !z;
                    break;
                case 4:
                    z3 = true;
                    CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                    if (arrayOrNull != null) {
                        arrayList = names;
                        constraintReference = constraints;
                        if (arrayOrNull.size() <= 1) {
                            z = z2;
                            break;
                        } else {
                            z = z2;
                            String string = arrayOrNull.getString(0);
                            f = arrayOrNull.getFloat(1);
                            switch (string.hashCode()) {
                                case 100571:
                                    if (string.equals("end")) {
                                        c2 = 3;
                                        break;
                                    }
                                    break;
                                case 3317767:
                                    if (string.equals("left")) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                                case 108511772:
                                    if (string.equals("right")) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case 109757538:
                                    if (string.equals("start")) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                            }
                            c2 = 65535;
                            switch (c2) {
                                case 0:
                                    z4 = true;
                                    break;
                                case 1:
                                    z4 = false;
                                    break;
                                case 2:
                                    z4 = z;
                                    break;
                                case 3:
                                    z4 = !z;
                                    break;
                            }
                        }
                    } else {
                        arrayList = names;
                        constraintReference = constraints;
                        z = z2;
                        z4 = true;
                        f = cLObject.getFloat(next);
                        break;
                    }
                default:
                    arrayList = names;
                    constraintReference = constraints;
                    z = z2;
                    break;
            }
            z2 = z;
            names = arrayList;
            constraints = constraintReference;
        }
        if (z3) {
            if (z4) {
                guidelineReference.percent(f);
                return;
            } else {
                guidelineReference.percent(1.0f - f);
                return;
            }
        }
        if (z4) {
            guidelineReference.start(Float.valueOf(f));
        } else {
            guidelineReference.end(Float.valueOf(f));
        }
    }

    static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

    static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        char c;
        for (int i = 0; i < cLArray.size(); i++) {
            CLElement cLElement = cLArray.get(i);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    switch (string.hashCode()) {
                        case -1785507558:
                            if (string.equals("vGuideline")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1252464839:
                            if (string.equals("hChain")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -851656725:
                            if (string.equals("vChain")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 965681512:
                            if (string.equals("hGuideline")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    switch (c) {
                        case 0:
                            parseChain(0, state, layoutVariables, cLArray2);
                            break;
                        case 1:
                            parseChain(1, state, layoutVariables, cLArray2);
                            break;
                        case 2:
                            parseGuideline(0, state, cLArray2);
                            break;
                        case 3:
                            parseGuideline(1, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) throws CLParsingException {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    public static void parseJSON(String str, Transition transition, int i) {
        CLObject objectOrNull;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                    Iterator<String> it2 = objectOrNull.names().iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        CLElement cLElement2 = objectOrNull.get(next2);
                        if (cLElement2 instanceof CLNumber) {
                            transition.addCustomFloat(i, next, next2, cLElement2.getFloat());
                        } else if (cLElement2 instanceof CLString) {
                            long parseColorString = parseColorString(cLElement2.content());
                            if (parseColorString != -1) {
                                transition.addCustomColor(i, next, next2, (int) parseColorString);
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    private static void parseMotionProperties(CLElement cLElement, ConstraintReference constraintReference) throws CLParsingException {
        boolean z;
        if (cLElement instanceof CLObject) {
            CLObject cLObject = (CLObject) cLElement;
            TypedBundle typedBundle = new TypedBundle();
            ArrayList<String> names = cLObject.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                switch (next.hashCode()) {
                    case -1897525331:
                        if (next.equals("stagger")) {
                            z = 3;
                            break;
                        }
                        break;
                    case -1310311125:
                        if (next.equals("easing")) {
                            z = 2;
                            break;
                        }
                        break;
                    case -1285003983:
                        if (next.equals("quantize")) {
                            z = 4;
                            break;
                        }
                        break;
                    case -791482387:
                        if (next.equals("pathArc")) {
                            z = false;
                            break;
                        }
                        break;
                    case -236944793:
                        if (next.equals("relativeTo")) {
                            z = true;
                            break;
                        }
                        break;
                }
                z = -1;
                switch (z) {
                    case false:
                        String string = cLObject.getString(next);
                        int indexOf = indexOf(string, AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_NONE_SCRIPT, "startVertical", "startHorizontal", "flip", "below", "above");
                        if (indexOf != -1) {
                            typedBundle.add(TypedValues.MotionType.TYPE_PATHMOTION_ARC, indexOf);
                            break;
                        } else {
                            System.err.println(cLObject.getLine() + " pathArc = '" + string + "'");
                            break;
                        }
                    case true:
                        typedBundle.add(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, cLObject.getString(next));
                        break;
                    case true:
                        typedBundle.add(TypedValues.MotionType.TYPE_EASING, cLObject.getString(next));
                        break;
                    case true:
                        typedBundle.add(600, cLObject.getFloat(next));
                        break;
                    case true:
                        CLElement cLElement2 = cLObject.get(next);
                        if (!(cLElement2 instanceof CLArray)) {
                            typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLObject.getInt(next));
                            break;
                        } else {
                            CLArray cLArray = (CLArray) cLElement2;
                            int size = cLArray.size();
                            if (size <= 0) {
                                break;
                            } else {
                                typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLArray.getInt(0));
                                if (size <= 1) {
                                    break;
                                } else {
                                    typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, cLArray.getString(1));
                                    if (size <= 2) {
                                        break;
                                    } else {
                                        typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, cLArray.getFloat(2));
                                        break;
                                    }
                                }
                            }
                        }
                }
            }
            constraintReference.mMotionProperties = typedBundle;
        }
    }

    public static void parseMotionSceneJSON(CoreMotionScene coreMotionScene, String str) {
        char c;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if (cLElement instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElement;
                    switch (next.hashCode()) {
                        case -2137403731:
                            if (next.equals("Header")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -241441378:
                            if (next.equals(TypedValues.TransitionType.NAME)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1101852654:
                            if (next.equals("ConstraintSets")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    switch (c) {
                        case 0:
                            parseConstraintSets(coreMotionScene, cLObject);
                            break;
                        case 1:
                            parseTransitions(coreMotionScene, cLObject);
                            break;
                        case 2:
                            parseHeader(coreMotionScene, cLObject);
                            break;
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            coreMotionScene.setTransitionContent(next, cLObject.getObject(next).toJSON());
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            if (cLElement instanceof CLNumber) {
                layoutVariables.put(next, cLElement.getInt());
            } else if (cLElement instanceof CLObject) {
                CLObject cLObject2 = (CLObject) cLElement;
                if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                    layoutVariables.put(next, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_TO)), 1.0f, cLObject2.getStringOrNull("prefix"), cLObject2.getStringOrNull("postfix"));
                } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                    layoutVariables.put(next, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("step")));
                } else if (cLObject2.has("ids")) {
                    CLArray array = cLObject2.getArray("ids");
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i = 0; i < array.size(); i++) {
                        arrayList.add(array.getString(i));
                    }
                    layoutVariables.put(next, arrayList);
                } else if (cLObject2.has("tag")) {
                    layoutVariables.put(next, state.getIdsForTag(cLObject2.getString("tag")));
                }
            }
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            applyAttribute(state, layoutVariables, constraintReference, cLObject, it.next());
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x00bd, code lost:
    
        if (r4.equals("barrier") != false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void populateState(androidx.constraintlayout.core.parser.CLObject r10, androidx.constraintlayout.core.state.State r11, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.populateState(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables):void");
    }

    private static float toPix(State state, float f) {
        return state.getDpToPixel().toPixels(f);
    }
}
