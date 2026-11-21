package androidx.core.provider;

import android.util.Base64;
import androidx.core.app.NotificationCompat$Metric$$ExternalSyntheticBackport0;
import androidx.core.util.Preconditions;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;
    private final String mSystemFont;
    private final String mVariationSettings;

    public FontRequest(String str, String str2, String str3, int i) {
        this(str, str2, str3, i, (String) null, (String) null);
    }

    public FontRequest(String str, String str2, String str3, int i, String str4) {
        this(str, str2, str3, i, (String) null, str4);
    }

    private FontRequest(String str, String str2, String str3, int i, String str4, String str5) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(str);
        this.mProviderPackage = (String) Preconditions.checkNotNull(str2);
        this.mQuery = (String) Preconditions.checkNotNull(str3);
        this.mCertificates = null;
        Preconditions.checkArgument(i != 0);
        this.mCertificatesArray = i;
        this.mSystemFont = str4;
        this.mVariationSettings = str5;
        this.mIdentifier = createIdentifier(str, str2, str3, null, this.mVariationSettings);
    }

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this(str, str2, str3, list, (String) null, (String) null);
    }

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list, String str4) {
        this(str, str2, str3, list, (String) null, str4);
    }

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list, String str4, String str5) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(str);
        this.mProviderPackage = (String) Preconditions.checkNotNull(str2);
        this.mQuery = (String) Preconditions.checkNotNull(str3);
        this.mCertificates = (List) Preconditions.checkNotNull(list);
        this.mCertificatesArray = 0;
        this.mSystemFont = str4;
        this.mVariationSettings = str5;
        this.mIdentifier = createIdentifier(str, str2, str3, str4, this.mVariationSettings);
    }

    private String createIdentifier(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("-").append(str2).append("-").append(str3).append("-").append(str4);
        if (str5 != null && !NotificationCompat$Metric$$ExternalSyntheticBackport0.m(str5)) {
            sb.append("-VF");
        }
        return sb.toString();
    }

    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mIdentifier;
    }

    @Deprecated
    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String getSystemFont() {
        return this.mSystemFont;
    }

    public String getVariationSettings() {
        return this.mVariationSettings;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mSystemFont: " + this.mSystemFont + ", mVariationSettings: " + this.mVariationSettings + ", mCertificates:");
        for (int i = 0; i < this.mCertificates.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }
}
