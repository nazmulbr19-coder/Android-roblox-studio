package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Ref {
    private String mId;
    private float mPostMargin;
    private float mPreMargin;
    private float mWeight;

    Ref(String str) {
        this.mWeight = Float.NaN;
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
    }

    Ref(String str, float f) {
        this.mWeight = Float.NaN;
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f;
    }

    Ref(String str, float f, float f2) {
        this.mWeight = Float.NaN;
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f;
        this.mPreMargin = f2;
    }

    Ref(String str, float f, float f2, float f3) {
        this.mWeight = Float.NaN;
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f;
        this.mPreMargin = f2;
        this.mPostMargin = f3;
    }

    public static void addStringToReferences(String str, ArrayList<Ref> arrayList) {
        if (str == null || str.length() == 0) {
            return;
        }
        Object[] objArr = new Object[4];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            switch (charAt) {
                case ' ':
                case '\'':
                    break;
                case ',':
                    if (i2 < 3) {
                        objArr[i2] = sb.toString();
                        sb.setLength(0);
                        i2++;
                    }
                    if (i == 1 && objArr[0] != null) {
                        arrayList.add(new Ref(objArr[0].toString()));
                        i2 = 0;
                        objArr[0] = null;
                        break;
                    }
                    break;
                case '[':
                    i++;
                    break;
                case ']':
                    if (i > 0) {
                        i--;
                        objArr[i2] = sb.toString();
                        sb.setLength(0);
                        if (objArr[0] != null) {
                            arrayList.add(new Ref(objArr[0].toString(), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3])));
                            i2 = 0;
                            Arrays.fill(objArr, (Object) null);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                default:
                    sb.append(charAt);
                    break;
            }
        }
    }

    public static float parseFloat(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (Exception e) {
            return Float.NaN;
        }
    }

    public static Ref parseStringToRef(String str) {
        String[] split = str.replaceAll("[\\[\\]\\']", "").split(",");
        if (split.length == 0) {
            return null;
        }
        Object[] objArr = new Object[4];
        for (int i = 0; i < split.length && i < 4; i++) {
            objArr[i] = split[i];
        }
        return new Ref(objArr[0].toString().replace("'", ""), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3]));
    }

    public String getId() {
        return this.mId;
    }

    public float getPostMargin() {
        return this.mPostMargin;
    }

    public float getPreMargin() {
        return this.mPreMargin;
    }

    public float getWeight() {
        return this.mWeight;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setPostMargin(float f) {
        this.mPostMargin = f;
    }

    public void setPreMargin(float f) {
        this.mPreMargin = f;
    }

    public void setWeight(float f) {
        this.mWeight = f;
    }

    public String toString() {
        if (this.mId == null || this.mId.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = (Float.isNaN(this.mWeight) && Float.isNaN(this.mPreMargin) && Float.isNaN(this.mPostMargin)) ? false : true;
        if (z) {
            sb.append("[");
        }
        sb.append("'").append(this.mId).append("'");
        if (!Float.isNaN(this.mPostMargin)) {
            sb.append(",").append(!Float.isNaN(this.mWeight) ? this.mWeight : 0.0f).append(",");
            sb.append(Float.isNaN(this.mPreMargin) ? 0.0f : this.mPreMargin).append(",");
            sb.append(this.mPostMargin);
        } else if (!Float.isNaN(this.mPreMargin)) {
            sb.append(",").append(Float.isNaN(this.mWeight) ? 0.0f : this.mWeight).append(",");
            sb.append(this.mPreMargin);
        } else if (!Float.isNaN(this.mWeight)) {
            sb.append(",").append(this.mWeight);
        }
        if (z) {
            sb.append("]");
        }
        sb.append(",");
        return sb.toString();
    }
}
