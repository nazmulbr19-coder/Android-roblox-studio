package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double mEps;
    double mS;
    double mT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Schlick(String str) {
        this.mStr = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.mS = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        this.mT = Double.parseDouble(str.substring(indexOf2 + 1, str.indexOf(44, indexOf2 + 1)).trim());
    }

    private double dfunc(double d) {
        return d < this.mT ? ((this.mS * this.mT) * this.mT) / (((this.mS * (this.mT - d)) + d) * ((this.mS * (this.mT - d)) + d)) : ((this.mS * (this.mT - 1.0d)) * (this.mT - 1.0d)) / (((((-this.mS) * (this.mT - d)) - d) + 1.0d) * ((((-this.mS) * (this.mT - d)) - d) + 1.0d));
    }

    private double func(double d) {
        return d < this.mT ? (this.mT * d) / ((this.mS * (this.mT - d)) + d) : ((1.0d - this.mT) * (d - 1.0d)) / ((1.0d - d) - (this.mS * (this.mT - d)));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d) {
        return func(d);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d) {
        return dfunc(d);
    }
}
