package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.core.os.EnvironmentCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class WidgetFrame {
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    private final HashMap<String, CustomVariable> mCustom;
    TypedBundle mMotionProperties;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = constraintWidget;
    }

    private static void add(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f);
        sb.append(",\n");
    }

    private static void add(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(": ");
        sb.append(i);
        sb.append(",\n");
    }

    private static float interpolate(float f, float f2, float f3, float f4) {
        boolean isNaN = Float.isNaN(f);
        boolean isNaN2 = Float.isNaN(f2);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f = f3;
        }
        if (isNaN2) {
            f2 = f3;
        }
        return ((f2 - f) * f4) + f;
    }

    public static void interpolate(int i, int i2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f) {
        float f2;
        int i3;
        int i4;
        float f3;
        int i5;
        int i6;
        int i7;
        int i8;
        Iterator<String> it;
        int i9;
        int i10;
        WidgetFrame widgetFrame4 = widgetFrame;
        WidgetFrame widgetFrame5 = widgetFrame2;
        WidgetFrame widgetFrame6 = widgetFrame3;
        int i11 = (int) (f * 100.0f);
        int i12 = widgetFrame5.left;
        int i13 = widgetFrame5.top;
        int i14 = widgetFrame6.left;
        int i15 = widgetFrame6.top;
        int i16 = widgetFrame5.right - widgetFrame5.left;
        int i17 = widgetFrame5.bottom - widgetFrame5.top;
        int i18 = widgetFrame6.right - widgetFrame6.left;
        int i19 = widgetFrame6.bottom - widgetFrame6.top;
        float f4 = f;
        int i20 = i12;
        float f5 = widgetFrame5.alpha;
        float f6 = widgetFrame6.alpha;
        if (widgetFrame5.visibility == 8) {
            int i21 = i20 - ((int) (i18 / 2.0f));
            i3 = i13 - ((int) (i19 / 2.0f));
            i16 = i18;
            i17 = i19;
            if (Float.isNaN(f5)) {
                i20 = i21;
                f2 = 0.0f;
            } else {
                i20 = i21;
                f2 = f5;
            }
        } else {
            f2 = f5;
            i3 = i13;
        }
        float f7 = f2;
        if (widgetFrame6.visibility == 8) {
            i14 -= (int) (i16 / 2.0f);
            i15 -= (int) (i17 / 2.0f);
            i18 = i16;
            i4 = i17;
            f3 = Float.isNaN(f6) ? 0.0f : f6;
        } else {
            i4 = i19;
            f3 = f6;
        }
        float f8 = (!Float.isNaN(f7) || Float.isNaN(f3)) ? f7 : 1.0f;
        if (!Float.isNaN(f8) && Float.isNaN(f3)) {
            f3 = 1.0f;
        }
        float f9 = f3;
        int i22 = i3;
        float f10 = widgetFrame5.visibility == 4 ? 0.0f : f8;
        int i23 = i14;
        float f11 = widgetFrame6.visibility == 4 ? 0.0f : f9;
        if (widgetFrame4.widget == null || !transition.hasPositionKeyframes()) {
            i5 = i20;
            i6 = i23;
            i7 = i15;
            i8 = i22;
        } else {
            Transition.KeyPosition findPreviousPosition = transition.findPreviousPosition(widgetFrame4.widget.stringId, i11);
            int i24 = i15;
            Transition.KeyPosition findNextPosition = transition.findNextPosition(widgetFrame4.widget.stringId, i11);
            if (findPreviousPosition == findNextPosition) {
                findNextPosition = null;
            }
            int i25 = 100;
            if (findPreviousPosition != null) {
                i20 = (int) (i * findPreviousPosition.mX);
                i22 = (int) (i2 * findPreviousPosition.mY);
                i10 = findPreviousPosition.mFrame;
            } else {
                i10 = 0;
            }
            if (findNextPosition != null) {
                int i26 = (int) (i * findNextPosition.mX);
                int i27 = (int) (i2 * findNextPosition.mY);
                i25 = findNextPosition.mFrame;
                i24 = i27;
                i23 = i26;
            }
            f4 = ((f * 100.0f) - i10) / (i25 - i10);
            i5 = i20;
            i6 = i23;
            i7 = i24;
            i8 = i22;
        }
        widgetFrame4.widget = widgetFrame5.widget;
        widgetFrame4.left = (int) (i5 + ((i6 - i5) * f4));
        widgetFrame4.top = (int) (i8 + ((i7 - i8) * f4));
        widgetFrame4.right = widgetFrame4.left + ((int) (((1.0f - f) * i16) + (i18 * f)));
        widgetFrame4.bottom = widgetFrame4.top + ((int) (((1.0f - f) * i17) + (i4 * f)));
        widgetFrame4.pivotX = interpolate(widgetFrame5.pivotX, widgetFrame6.pivotX, 0.5f, f);
        widgetFrame4.pivotY = interpolate(widgetFrame5.pivotY, widgetFrame6.pivotY, 0.5f, f);
        widgetFrame4.rotationX = interpolate(widgetFrame5.rotationX, widgetFrame6.rotationX, 0.0f, f);
        widgetFrame4.rotationY = interpolate(widgetFrame5.rotationY, widgetFrame6.rotationY, 0.0f, f);
        widgetFrame4.rotationZ = interpolate(widgetFrame5.rotationZ, widgetFrame6.rotationZ, 0.0f, f);
        widgetFrame4.scaleX = interpolate(widgetFrame5.scaleX, widgetFrame6.scaleX, 1.0f, f);
        widgetFrame4.scaleY = interpolate(widgetFrame5.scaleY, widgetFrame6.scaleY, 1.0f, f);
        widgetFrame4.translationX = interpolate(widgetFrame5.translationX, widgetFrame6.translationX, 0.0f, f);
        widgetFrame4.translationY = interpolate(widgetFrame5.translationY, widgetFrame6.translationY, 0.0f, f);
        widgetFrame4.translationZ = interpolate(widgetFrame5.translationZ, widgetFrame6.translationZ, 0.0f, f);
        widgetFrame4.alpha = interpolate(f10, f11, 1.0f, f);
        Set<String> keySet = widgetFrame6.mCustom.keySet();
        widgetFrame4.mCustom.clear();
        Iterator<String> it2 = keySet.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Set<String> set = keySet;
            if (widgetFrame5.mCustom.containsKey(next)) {
                CustomVariable customVariable = widgetFrame5.mCustom.get(next);
                it = it2;
                CustomVariable customVariable2 = widgetFrame6.mCustom.get(next);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame4.mCustom.put(next, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    i9 = i5;
                    customVariable3.setValue(Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f)));
                } else {
                    i9 = i5;
                    int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[numberOfInterpolatedValues];
                    float[] fArr2 = new float[numberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    int i28 = 0;
                    while (i28 < numberOfInterpolatedValues) {
                        int i29 = i28;
                        fArr[i29] = interpolate(fArr[i29], fArr2[i29], 0.0f, f);
                        customVariable3.setValue(fArr);
                        i28 = i29 + 1;
                        customVariable2 = customVariable2;
                        numberOfInterpolatedValues = numberOfInterpolatedValues;
                    }
                }
            } else {
                it = it2;
                i9 = i5;
            }
            widgetFrame4 = widgetFrame;
            widgetFrame5 = widgetFrame2;
            widgetFrame6 = widgetFrame3;
            keySet = set;
            it2 = it;
            i5 = i9;
        }
    }

    private void serializeAnchor(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor == null || anchor.mTarget == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(type.name());
        sb.append(": ['");
        String str = anchor.mTarget.getOwner().stringId;
        sb.append(str == null ? "#PARENT" : str);
        sb.append("', '");
        sb.append(anchor.mTarget.getType().name());
        sb.append("', '");
        sb.append(anchor.mMargin);
        sb.append("'],\n");
    }

    public void addCustomColor(String str, int i) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, i);
    }

    public void addCustomFloat(String str, float f) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_FLOAT, f);
    }

    public float centerX() {
        return this.left + ((this.right - this.left) / 2.0f);
    }

    public float centerY() {
        return this.top + ((this.bottom - this.top) / 2.0f);
    }

    public boolean containsCustom(String str) {
        return this.mCustom.containsKey(str);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        return this.widget == null ? EnvironmentCompat.MEDIA_UNKNOWN : this.widget.stringId;
    }

    public TypedBundle getMotionProperties() {
        return this.mMotionProperties;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        return Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha);
    }

    void logv(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        System.out.println((this.widget != null ? str2 + "/" + (this.widget.hashCode() % 1000) : str2 + "/NULL") + " " + str);
    }

    void parseCustom(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i = 0; i < size; i++) {
            CLElement value = ((CLKey) cLObject.get(i)).getValue();
            String content = value.content();
            if (content.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_COLOR, Integer.parseInt(content.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_FLOAT, value.getFloat());
            } else {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_STRING, content);
            }
        }
    }

    void printCustomAttributes() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        String str2 = this.widget != null ? str + "/" + (this.widget.hashCode() % 1000) + " " : str + "/NULL ";
        if (this.mCustom != null) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                System.out.println(str2 + this.mCustom.get(it.next()).toString());
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z) {
        sb.append("{\n");
        add(sb, "left", this.left);
        add(sb, "top", this.top);
        add(sb, "right", this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, "rotationX", this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, "rotationZ", this.rotationZ);
        add(sb, "translationX", this.translationX);
        add(sb, "translationY", this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, "scaleX", this.scaleX);
        add(sb, "scaleY", this.scaleY);
        add(sb, "alpha", this.alpha);
        add(sb, "visibility", this.visibility);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb, type);
            }
        }
        if (z) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case 900:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR /* 902 */:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING /* 903 */:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i, float f) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, f));
        }
    }

    public void setCustomAttribute(String str, int i, int i2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, i2));
        }
    }

    public void setCustomAttribute(String str, int i, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, str2));
        }
    }

    public void setCustomAttribute(String str, int i, boolean z) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, z));
        }
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMotionAttributes(TypedBundle typedBundle) {
        this.mMotionProperties = typedBundle;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean setValue(String str, CLElement cLElement) throws CLParsingException {
        char c;
        switch (str.hashCode()) {
            case -1881940865:
                if (str.equals("phone_orientation")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -1349088399:
                if (str.equals("custom")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 115029:
                if (str.equals("top")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 642850769:
                if (str.equals("interpolatedPos")) {
                    c = 11;
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
                this.pivotX = cLElement.getFloat();
                return true;
            case 1:
                this.pivotY = cLElement.getFloat();
                return true;
            case 2:
                this.rotationX = cLElement.getFloat();
                return true;
            case 3:
                this.rotationY = cLElement.getFloat();
                return true;
            case 4:
                this.rotationZ = cLElement.getFloat();
                return true;
            case 5:
                this.translationX = cLElement.getFloat();
                return true;
            case 6:
                this.translationY = cLElement.getFloat();
                return true;
            case 7:
                this.translationZ = cLElement.getFloat();
                return true;
            case '\b':
                this.scaleX = cLElement.getFloat();
                return true;
            case '\t':
                this.scaleY = cLElement.getFloat();
                return true;
            case '\n':
                this.alpha = cLElement.getFloat();
                return true;
            case 11:
                this.interpolatedPos = cLElement.getFloat();
                return true;
            case '\f':
                phone_orientation = cLElement.getFloat();
                return true;
            case '\r':
                this.top = cLElement.getInt();
                return true;
            case 14:
                this.left = cLElement.getInt();
                return true;
            case 15:
                this.right = cLElement.getInt();
                return true;
            case 16:
                this.bottom = cLElement.getInt();
                return true;
            case 17:
                parseCustom(cLElement);
                return true;
            default:
                return false;
        }
    }

    public WidgetFrame update() {
        if (this.widget != null) {
            this.left = this.widget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        if (widgetFrame == null) {
            return;
        }
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        setMotionAttributes(widgetFrame.mMotionProperties);
        this.mCustom.clear();
        for (CustomVariable customVariable : widgetFrame.mCustom.values()) {
            this.mCustom.put(customVariable.getName(), customVariable.copy());
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }
}
