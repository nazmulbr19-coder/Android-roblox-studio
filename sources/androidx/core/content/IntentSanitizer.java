package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private Predicate<String> mAllowedActions;
    private Predicate<String> mAllowedCategories;
    private Predicate<ClipData> mAllowedClipData;
    private Predicate<Uri> mAllowedClipDataUri;
    private Predicate<ComponentName> mAllowedComponents;
    private Predicate<Uri> mAllowedData;
    private Map<String, Predicate<Object>> mAllowedExtras;
    private int mAllowedFlags;
    private Predicate<String> mAllowedPackages;
    private Predicate<String> mAllowedTypes;

    /* loaded from: classes.dex */
    private static class Api29Impl {
        private Api29Impl() {
        }

        static String getIdentifier(Intent intent) {
            return intent.getIdentifier();
        }

        static Intent setIdentifier(Intent intent, String str) {
            return intent.setIdentifier(str);
        }
    }

    /* loaded from: classes.dex */
    private static class Api31Impl {
        private Api31Impl() {
        }

        static void checkOtherMembers(int i, ClipData.Item item, Consumer<String> consumer) {
            if (item.getHtmlText() == null && item.getIntent() == null && item.getTextLinks() == null) {
                return;
            }
            consumer.accept("ClipData item at position " + i + " contains htmlText, textLinks or intent: " + item);
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private int mAllowedFlags;
        private Predicate<String> mAllowedActions = new IntentSanitizer$Builder$$ExternalSyntheticLambda1();
        private Predicate<Uri> mAllowedData = new IntentSanitizer$Builder$$ExternalSyntheticLambda2();
        private Predicate<String> mAllowedTypes = new IntentSanitizer$Builder$$ExternalSyntheticLambda3();
        private Predicate<String> mAllowedCategories = new IntentSanitizer$Builder$$ExternalSyntheticLambda4();
        private Predicate<String> mAllowedPackages = new IntentSanitizer$Builder$$ExternalSyntheticLambda5();
        private Predicate<ComponentName> mAllowedComponents = new IntentSanitizer$Builder$$ExternalSyntheticLambda6();
        private Map<String, Predicate<Object>> mAllowedExtras = new HashMap();
        private boolean mAllowClipDataText = false;
        private Predicate<Uri> mAllowedClipDataUri = new IntentSanitizer$Builder$$ExternalSyntheticLambda7();
        private Predicate<ClipData> mAllowedClipData = new IntentSanitizer$Builder$$ExternalSyntheticLambda8();

        public static /* synthetic */ boolean $r8$lambda$DvjTS4tHjUqRA2QfyccBu7fhDzE(String str, Object obj) {
            return str.equals(obj);
        }

        public static /* synthetic */ boolean $r8$lambda$HF7enmHP1Z3cPiyI1KCE8M8gPts(ComponentName componentName, Object obj) {
            return componentName.equals(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName componentName) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowClipDataUriWithAuthority$11(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowComponentWithPackage$9(String str, ComponentName componentName) {
            return str.equals(componentName.getPackageName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowDataWithAuthority$8(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowExtra$12(Object obj) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowExtra$13(Class cls, Predicate predicate, Object obj) {
            return cls.isInstance(obj) && predicate.test(cls.cast(obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowExtra$14(Object obj) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowExtraOutput$16(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$allowExtraStreamUriWithAuthority$15(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$new$0(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$new$1(Uri uri) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$new$2(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$new$3(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$new$4(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$new$5(ComponentName componentName) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$new$6(Uri uri) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$new$7(ClipData clipData) {
            return false;
        }

        public Builder allowAction(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedActions = this.mAllowedActions.or(predicate);
            return this;
        }

        public Builder allowAction(String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            allowAction(new IntentSanitizer$Builder$$ExternalSyntheticLambda10(str));
            return this;
        }

        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new IntentSanitizer$Builder$$ExternalSyntheticLambda15();
            return this;
        }

        public Builder allowCategory(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedCategories = this.mAllowedCategories.or(predicate);
            return this;
        }

        public Builder allowCategory(String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowCategory(new IntentSanitizer$Builder$$ExternalSyntheticLambda10(str));
        }

        public Builder allowClipData(Predicate<ClipData> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipData = this.mAllowedClipData.or(predicate);
            return this;
        }

        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        public Builder allowClipDataUri(Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(predicate);
            return this;
        }

        public Builder allowClipDataUriWithAuthority(String str) {
            Preconditions.checkNotNull(str);
            return allowClipDataUri(new IntentSanitizer$Builder$$ExternalSyntheticLambda16(str));
        }

        public Builder allowComponent(ComponentName componentName) {
            Preconditions.checkNotNull(componentName);
            Objects.requireNonNull(componentName);
            return allowComponent(new IntentSanitizer$Builder$$ExternalSyntheticLambda14(componentName));
        }

        public Builder allowComponent(Predicate<ComponentName> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(predicate);
            return this;
        }

        public Builder allowComponentWithPackage(String str) {
            Preconditions.checkNotNull(str);
            return allowComponent(new IntentSanitizer$Builder$$ExternalSyntheticLambda11(str));
        }

        public Builder allowData(Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedData = this.mAllowedData.or(predicate);
            return this;
        }

        public Builder allowDataWithAuthority(String str) {
            Preconditions.checkNotNull(str);
            allowData(new IntentSanitizer$Builder$$ExternalSyntheticLambda12(str));
            return this;
        }

        public Builder allowExtra(String str, Predicate<Object> predicate) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(predicate);
            Predicate<Object> predicate2 = this.mAllowedExtras.get(str);
            if (predicate2 == null) {
                predicate2 = new IntentSanitizer$Builder$$ExternalSyntheticLambda17();
            }
            this.mAllowedExtras.put(str, predicate2.or(predicate));
            return this;
        }

        public Builder allowExtra(String str, Class<?> cls) {
            return allowExtra(str, cls, new IntentSanitizer$Builder$$ExternalSyntheticLambda9());
        }

        public <T> Builder allowExtra(String str, Class<T> cls, Predicate<T> predicate) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(predicate);
            return allowExtra(str, new IntentSanitizer$Builder$$ExternalSyntheticLambda13(cls, predicate));
        }

        public Builder allowExtraOutput(Predicate<Uri> predicate) {
            allowExtra("output", Uri.class, predicate);
            return this;
        }

        public Builder allowExtraOutput(String str) {
            allowExtra("output", Uri.class, new IntentSanitizer$Builder$$ExternalSyntheticLambda0(str));
            return this;
        }

        public Builder allowExtraStream(Predicate<Uri> predicate) {
            allowExtra("android.intent.extra.STREAM", Uri.class, predicate);
            return this;
        }

        public Builder allowExtraStreamUriWithAuthority(String str) {
            Preconditions.checkNotNull(str);
            allowExtra("android.intent.extra.STREAM", Uri.class, new IntentSanitizer$Builder$$ExternalSyntheticLambda18(str));
            return this;
        }

        public Builder allowFlags(int i) {
            this.mAllowedFlags |= i;
            return this;
        }

        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        public Builder allowPackage(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedPackages = this.mAllowedPackages.or(predicate);
            return this;
        }

        public Builder allowPackage(String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowPackage(new IntentSanitizer$Builder$$ExternalSyntheticLambda10(str));
        }

        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        public Builder allowType(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedTypes = this.mAllowedTypes.or(predicate);
            return this;
        }

        public Builder allowType(String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowType(new IntentSanitizer$Builder$$ExternalSyntheticLambda10(str));
        }

        public IntentSanitizer build() {
            if ((this.mAllowAnyComponent && this.mAllowSomeComponents) || (!this.mAllowAnyComponent && !this.mAllowSomeComponents)) {
                throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
            }
            IntentSanitizer intentSanitizer = new IntentSanitizer(null);
            IntentSanitizer.m71$$Nest$fputmAllowedFlags(intentSanitizer, this.mAllowedFlags);
            IntentSanitizer.m64$$Nest$fputmAllowedActions(intentSanitizer, this.mAllowedActions);
            IntentSanitizer.m69$$Nest$fputmAllowedData(intentSanitizer, this.mAllowedData);
            IntentSanitizer.m73$$Nest$fputmAllowedTypes(intentSanitizer, this.mAllowedTypes);
            IntentSanitizer.m65$$Nest$fputmAllowedCategories(intentSanitizer, this.mAllowedCategories);
            IntentSanitizer.m72$$Nest$fputmAllowedPackages(intentSanitizer, this.mAllowedPackages);
            IntentSanitizer.m59$$Nest$fputmAllowAnyComponent(intentSanitizer, this.mAllowAnyComponent);
            IntentSanitizer.m68$$Nest$fputmAllowedComponents(intentSanitizer, this.mAllowedComponents);
            IntentSanitizer.m70$$Nest$fputmAllowedExtras(intentSanitizer, this.mAllowedExtras);
            IntentSanitizer.m60$$Nest$fputmAllowClipDataText(intentSanitizer, this.mAllowClipDataText);
            IntentSanitizer.m67$$Nest$fputmAllowedClipDataUri(intentSanitizer, this.mAllowedClipDataUri);
            IntentSanitizer.m66$$Nest$fputmAllowedClipData(intentSanitizer, this.mAllowedClipData);
            IntentSanitizer.m61$$Nest$fputmAllowIdentifier(intentSanitizer, this.mAllowIdentifier);
            IntentSanitizer.m62$$Nest$fputmAllowSelector(intentSanitizer, this.mAllowSelector);
            IntentSanitizer.m63$$Nest$fputmAllowSourceBounds(intentSanitizer, this.mAllowSourceBounds);
            return intentSanitizer;
        }
    }

    /* renamed from: -$$Nest$fputmAllowAnyComponent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m59$$Nest$fputmAllowAnyComponent(IntentSanitizer intentSanitizer, boolean z) {
        intentSanitizer.mAllowAnyComponent = z;
    }

    /* renamed from: -$$Nest$fputmAllowClipDataText, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m60$$Nest$fputmAllowClipDataText(IntentSanitizer intentSanitizer, boolean z) {
        intentSanitizer.mAllowClipDataText = z;
    }

    /* renamed from: -$$Nest$fputmAllowIdentifier, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m61$$Nest$fputmAllowIdentifier(IntentSanitizer intentSanitizer, boolean z) {
        intentSanitizer.mAllowIdentifier = z;
    }

    /* renamed from: -$$Nest$fputmAllowSelector, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m62$$Nest$fputmAllowSelector(IntentSanitizer intentSanitizer, boolean z) {
        intentSanitizer.mAllowSelector = z;
    }

    /* renamed from: -$$Nest$fputmAllowSourceBounds, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m63$$Nest$fputmAllowSourceBounds(IntentSanitizer intentSanitizer, boolean z) {
        intentSanitizer.mAllowSourceBounds = z;
    }

    /* renamed from: -$$Nest$fputmAllowedActions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m64$$Nest$fputmAllowedActions(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedActions = predicate;
    }

    /* renamed from: -$$Nest$fputmAllowedCategories, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m65$$Nest$fputmAllowedCategories(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedCategories = predicate;
    }

    /* renamed from: -$$Nest$fputmAllowedClipData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m66$$Nest$fputmAllowedClipData(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedClipData = predicate;
    }

    /* renamed from: -$$Nest$fputmAllowedClipDataUri, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m67$$Nest$fputmAllowedClipDataUri(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedClipDataUri = predicate;
    }

    /* renamed from: -$$Nest$fputmAllowedComponents, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m68$$Nest$fputmAllowedComponents(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedComponents = predicate;
    }

    /* renamed from: -$$Nest$fputmAllowedData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m69$$Nest$fputmAllowedData(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedData = predicate;
    }

    /* renamed from: -$$Nest$fputmAllowedExtras, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m70$$Nest$fputmAllowedExtras(IntentSanitizer intentSanitizer, Map map) {
        intentSanitizer.mAllowedExtras = map;
    }

    /* renamed from: -$$Nest$fputmAllowedFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m71$$Nest$fputmAllowedFlags(IntentSanitizer intentSanitizer, int i) {
        intentSanitizer.mAllowedFlags = i;
    }

    /* renamed from: -$$Nest$fputmAllowedPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m72$$Nest$fputmAllowedPackages(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedPackages = predicate;
    }

    /* renamed from: -$$Nest$fputmAllowedTypes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m73$$Nest$fputmAllowedTypes(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedTypes = predicate;
    }

    private IntentSanitizer() {
    }

    /* synthetic */ IntentSanitizer(IntentSanitizerIA intentSanitizerIA) {
        this();
    }

    private static void checkOtherMembers(int i, ClipData.Item item, Consumer<String> consumer) {
        if (item.getHtmlText() == null && item.getIntent() == null) {
            return;
        }
        consumer.accept("ClipData item at position " + i + " contains htmlText, textLinks or intent: " + item);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$sanitizeByFiltering$0(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$sanitizeByThrowing$1(String str) {
        throw new SecurityException(str);
    }

    private void putExtra(Intent intent, String str, Object obj) {
        if (obj == null) {
            intent.getExtras().putString(str, null);
            return;
        }
        if (obj instanceof Parcelable) {
            intent.putExtra(str, (Parcelable) obj);
        } else if (obj instanceof Parcelable[]) {
            intent.putExtra(str, (Parcelable[]) obj);
        } else {
            if (!(obj instanceof Serializable)) {
                throw new IllegalArgumentException("Unsupported type " + obj.getClass());
            }
            intent.putExtra(str, (Serializable) obj);
        }
    }

    static void sanitizeClipData(Intent intent, Intent intent2, Predicate<ClipData> predicate, boolean z, Predicate<Uri> predicate2, Consumer<String> consumer) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return;
        }
        ClipData clipData2 = null;
        if (predicate != null && predicate.test(clipData)) {
            intent2.setClipData(clipData);
            return;
        }
        for (int i = 0; i < clipData.getItemCount(); i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.checkOtherMembers(i, itemAt, consumer);
            } else {
                checkOtherMembers(i, itemAt, consumer);
            }
            CharSequence charSequence = null;
            if (z) {
                charSequence = itemAt.getText();
            } else if (itemAt.getText() != null) {
                consumer.accept("Item text cannot contain value. Item position: " + i + ". Text: " + ((Object) itemAt.getText()));
            }
            Uri uri = null;
            if (predicate2 == null) {
                if (itemAt.getUri() != null) {
                    consumer.accept("Item URI is not allowed. Item position: " + i + ". URI: " + itemAt.getUri());
                }
            } else if (itemAt.getUri() == null || predicate2.test(itemAt.getUri())) {
                uri = itemAt.getUri();
            } else {
                consumer.accept("Item URI is not allowed. Item position: " + i + ". URI: " + itemAt.getUri());
            }
            if (charSequence != null || uri != null) {
                if (clipData2 == null) {
                    clipData2 = new ClipData(clipData.getDescription(), new ClipData.Item(charSequence, null, uri));
                } else {
                    clipData2.addItem(new ClipData.Item(charSequence, null, uri));
                }
            }
        }
        if (clipData2 != null) {
            intent2.setClipData(clipData2);
        }
    }

    public Intent sanitize(Intent intent, Consumer<String> consumer) {
        Intent intent2 = new Intent();
        ComponentName component = intent.getComponent();
        if ((this.mAllowAnyComponent && component == null) || this.mAllowedComponents.test(component)) {
            intent2.setComponent(component);
        } else {
            consumer.accept("Component is not allowed: " + component);
            intent2.setComponent(new ComponentName("android", "java.lang.Void"));
        }
        String str = intent.getPackage();
        if (str == null || this.mAllowedPackages.test(str)) {
            intent2.setPackage(str);
        } else {
            consumer.accept("Package is not allowed: " + str);
        }
        if ((this.mAllowedFlags | intent.getFlags()) == this.mAllowedFlags) {
            intent2.setFlags(intent.getFlags());
        } else {
            intent2.setFlags(this.mAllowedFlags & intent.getFlags());
            consumer.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(intent.getFlags() & (~this.mAllowedFlags)));
        }
        String action = intent.getAction();
        if (action == null || this.mAllowedActions.test(action)) {
            intent2.setAction(action);
        } else {
            consumer.accept("Action is not allowed: " + action);
        }
        Uri data = intent.getData();
        if (data == null || this.mAllowedData.test(data)) {
            intent2.setData(data);
        } else {
            consumer.accept("Data is not allowed: " + data);
        }
        String type = intent.getType();
        if (type == null || this.mAllowedTypes.test(type)) {
            intent2.setDataAndType(intent2.getData(), type);
        } else {
            consumer.accept("Type is not allowed: " + type);
        }
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            for (String str2 : categories) {
                if (this.mAllowedCategories.test(str2)) {
                    intent2.addCategory(str2);
                } else {
                    consumer.accept("Category is not allowed: " + str2);
                }
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str3 : extras.keySet()) {
                if (str3.equals("android.intent.extra.STREAM") && (this.mAllowedFlags & 1) == 0) {
                    consumer.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                } else if (!str3.equals("output") || ((~this.mAllowedFlags) & 3) == 0) {
                    Object obj = extras.get(str3);
                    Predicate<Object> predicate = this.mAllowedExtras.get(str3);
                    if (predicate == null || !predicate.test(obj)) {
                        consumer.accept("Extra is not allowed. Key: " + str3 + ". Value: " + obj);
                    } else {
                        putExtra(intent2, str3, obj);
                    }
                } else {
                    consumer.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                }
            }
        }
        sanitizeClipData(intent, intent2, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, consumer);
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.mAllowIdentifier) {
                Api29Impl.setIdentifier(intent2, Api29Impl.getIdentifier(intent));
            } else if (Api29Impl.getIdentifier(intent) != null) {
                consumer.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(intent));
            }
        }
        if (this.mAllowSelector) {
            intent2.setSelector(intent.getSelector());
        } else if (intent.getSelector() != null) {
            consumer.accept("Selector is not allowed: " + intent.getSelector());
        }
        if (this.mAllowSourceBounds) {
            intent2.setSourceBounds(intent.getSourceBounds());
        } else if (intent.getSourceBounds() != null) {
            consumer.accept("SourceBounds is not allowed: " + intent.getSourceBounds());
        }
        return intent2;
    }

    public Intent sanitizeByFiltering(Intent intent) {
        return sanitize(intent, new IntentSanitizer$$ExternalSyntheticLambda1());
    }

    public Intent sanitizeByThrowing(Intent intent) {
        return sanitize(intent, new IntentSanitizer$$ExternalSyntheticLambda0());
    }
}
