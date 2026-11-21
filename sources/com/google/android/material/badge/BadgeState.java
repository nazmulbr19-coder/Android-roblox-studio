package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

/* loaded from: classes.dex */
public final class BadgeState {
    private static final String BADGE_RESOURCE_TAG = "badge";
    int badgeFixedEdge;
    final float badgeHeight;
    final float badgeRadius;
    final float badgeWidth;
    final float badgeWithTextHeight;
    final float badgeWithTextRadius;
    final float badgeWithTextWidth;
    private final State currentState = new State();
    final int horizontalInset;
    final int horizontalInsetWithText;
    int offsetAlignmentMode;
    private final State overridingState;

    /* loaded from: classes.dex */
    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = new AnonymousClass1();
        private static final int NOT_SET = -2;
        private Integer additionalHorizontalOffset;
        private Integer additionalVerticalOffset;
        private int alpha;
        private Boolean autoAdjustToWithinGrandparentBounds;
        private Integer backgroundColor;
        private Integer badgeFixedEdge;
        private Integer badgeGravity;
        private Integer badgeHorizontalPadding;
        private int badgeResId;
        private Integer badgeShapeAppearanceOverlayResId;
        private Integer badgeShapeAppearanceResId;
        private Integer badgeTextAppearanceResId;
        private Integer badgeTextColor;
        private Integer badgeVerticalPadding;
        private Integer badgeWithTextShapeAppearanceOverlayResId;
        private Integer badgeWithTextShapeAppearanceResId;
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        private CharSequence contentDescriptionForText;
        private CharSequence contentDescriptionNumberless;
        private int contentDescriptionQuantityStrings;
        private Integer horizontalOffsetWithText;
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;
        private Integer largeFontVerticalOffsetAdjustment;
        private int maxCharacterCount;
        private int maxNumber;
        private int number;
        private Locale numberLocale;
        private String text;
        private Integer verticalOffsetWithText;
        private Integer verticalOffsetWithoutText;

        /* renamed from: com.google.android.material.badge.BadgeState$State$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Parcelable.Creator<State> {
            AnonymousClass1() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ State createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public State[] newArray(int i) {
                return new State[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ State[] newArray(int i) {
                return newArray(i);
            }
        }

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = true;
        }

        State(Parcel parcel) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = true;
            this.badgeResId = parcel.readInt();
            this.backgroundColor = (Integer) parcel.readSerializable();
            this.badgeTextColor = (Integer) parcel.readSerializable();
            this.badgeTextAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeShapeAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
            this.badgeWithTextShapeAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeWithTextShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
            this.alpha = parcel.readInt();
            this.text = parcel.readString();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.maxNumber = parcel.readInt();
            this.contentDescriptionForText = parcel.readString();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = (Integer) parcel.readSerializable();
            this.badgeHorizontalPadding = (Integer) parcel.readSerializable();
            this.badgeVerticalPadding = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithText = (Integer) parcel.readSerializable();
            this.largeFontVerticalOffsetAdjustment = (Integer) parcel.readSerializable();
            this.additionalHorizontalOffset = (Integer) parcel.readSerializable();
            this.additionalVerticalOffset = (Integer) parcel.readSerializable();
            this.isVisible = (Boolean) parcel.readSerializable();
            this.numberLocale = (Locale) parcel.readSerializable();
            this.autoAdjustToWithinGrandparentBounds = (Boolean) parcel.readSerializable();
            this.badgeFixedEdge = (Integer) parcel.readSerializable();
        }

        static /* synthetic */ int access$000(State state) {
            return state.badgeResId;
        }

        static /* synthetic */ int access$002(State state, int i) {
            state.badgeResId = i;
            return i;
        }

        static /* synthetic */ int access$100(State state) {
            return state.alpha;
        }

        static /* synthetic */ int access$1000(State state) {
            return state.maxNumber;
        }

        static /* synthetic */ int access$1002(State state, int i) {
            state.maxNumber = i;
            return i;
        }

        static /* synthetic */ int access$102(State state, int i) {
            state.alpha = i;
            return i;
        }

        static /* synthetic */ Integer access$1100(State state) {
            return state.badgeShapeAppearanceResId;
        }

        static /* synthetic */ Integer access$1102(State state, Integer num) {
            state.badgeShapeAppearanceResId = num;
            return num;
        }

        static /* synthetic */ Integer access$1200(State state) {
            return state.badgeShapeAppearanceOverlayResId;
        }

        static /* synthetic */ Integer access$1202(State state, Integer num) {
            state.badgeShapeAppearanceOverlayResId = num;
            return num;
        }

        static /* synthetic */ Integer access$1300(State state) {
            return state.badgeWithTextShapeAppearanceResId;
        }

        static /* synthetic */ Integer access$1302(State state, Integer num) {
            state.badgeWithTextShapeAppearanceResId = num;
            return num;
        }

        static /* synthetic */ Integer access$1400(State state) {
            return state.badgeWithTextShapeAppearanceOverlayResId;
        }

        static /* synthetic */ Integer access$1402(State state, Integer num) {
            state.badgeWithTextShapeAppearanceOverlayResId = num;
            return num;
        }

        static /* synthetic */ Integer access$1500(State state) {
            return state.backgroundColor;
        }

        static /* synthetic */ Integer access$1502(State state, Integer num) {
            state.backgroundColor = num;
            return num;
        }

        static /* synthetic */ Integer access$1600(State state) {
            return state.badgeTextAppearanceResId;
        }

        static /* synthetic */ Integer access$1602(State state, Integer num) {
            state.badgeTextAppearanceResId = num;
            return num;
        }

        static /* synthetic */ Integer access$1700(State state) {
            return state.badgeTextColor;
        }

        static /* synthetic */ Integer access$1702(State state, Integer num) {
            state.badgeTextColor = num;
            return num;
        }

        static /* synthetic */ Integer access$1800(State state) {
            return state.badgeGravity;
        }

        static /* synthetic */ Integer access$1802(State state, Integer num) {
            state.badgeGravity = num;
            return num;
        }

        static /* synthetic */ Integer access$1900(State state) {
            return state.badgeHorizontalPadding;
        }

        static /* synthetic */ Integer access$1902(State state, Integer num) {
            state.badgeHorizontalPadding = num;
            return num;
        }

        static /* synthetic */ int access$200(State state) {
            return state.number;
        }

        static /* synthetic */ Integer access$2000(State state) {
            return state.badgeVerticalPadding;
        }

        static /* synthetic */ Integer access$2002(State state, Integer num) {
            state.badgeVerticalPadding = num;
            return num;
        }

        static /* synthetic */ int access$202(State state, int i) {
            state.number = i;
            return i;
        }

        static /* synthetic */ Integer access$2100(State state) {
            return state.horizontalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$2102(State state, Integer num) {
            state.horizontalOffsetWithoutText = num;
            return num;
        }

        static /* synthetic */ Integer access$2200(State state) {
            return state.verticalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$2202(State state, Integer num) {
            state.verticalOffsetWithoutText = num;
            return num;
        }

        static /* synthetic */ Integer access$2300(State state) {
            return state.horizontalOffsetWithText;
        }

        static /* synthetic */ Integer access$2302(State state, Integer num) {
            state.horizontalOffsetWithText = num;
            return num;
        }

        static /* synthetic */ Integer access$2400(State state) {
            return state.verticalOffsetWithText;
        }

        static /* synthetic */ Integer access$2402(State state, Integer num) {
            state.verticalOffsetWithText = num;
            return num;
        }

        static /* synthetic */ Integer access$2500(State state) {
            return state.largeFontVerticalOffsetAdjustment;
        }

        static /* synthetic */ Integer access$2502(State state, Integer num) {
            state.largeFontVerticalOffsetAdjustment = num;
            return num;
        }

        static /* synthetic */ Integer access$2600(State state) {
            return state.additionalHorizontalOffset;
        }

        static /* synthetic */ Integer access$2602(State state, Integer num) {
            state.additionalHorizontalOffset = num;
            return num;
        }

        static /* synthetic */ Integer access$2700(State state) {
            return state.additionalVerticalOffset;
        }

        static /* synthetic */ Integer access$2702(State state, Integer num) {
            state.additionalVerticalOffset = num;
            return num;
        }

        static /* synthetic */ Boolean access$2800(State state) {
            return state.autoAdjustToWithinGrandparentBounds;
        }

        static /* synthetic */ Boolean access$2802(State state, Boolean bool) {
            state.autoAdjustToWithinGrandparentBounds = bool;
            return bool;
        }

        static /* synthetic */ Locale access$2900(State state) {
            return state.numberLocale;
        }

        static /* synthetic */ Locale access$2902(State state, Locale locale) {
            state.numberLocale = locale;
            return locale;
        }

        static /* synthetic */ String access$300(State state) {
            return state.text;
        }

        static /* synthetic */ String access$302(State state, String str) {
            state.text = str;
            return str;
        }

        static /* synthetic */ CharSequence access$400(State state) {
            return state.contentDescriptionForText;
        }

        static /* synthetic */ CharSequence access$402(State state, CharSequence charSequence) {
            state.contentDescriptionForText = charSequence;
            return charSequence;
        }

        static /* synthetic */ CharSequence access$500(State state) {
            return state.contentDescriptionNumberless;
        }

        static /* synthetic */ CharSequence access$502(State state, CharSequence charSequence) {
            state.contentDescriptionNumberless = charSequence;
            return charSequence;
        }

        static /* synthetic */ int access$600(State state) {
            return state.contentDescriptionQuantityStrings;
        }

        static /* synthetic */ int access$602(State state, int i) {
            state.contentDescriptionQuantityStrings = i;
            return i;
        }

        static /* synthetic */ int access$700(State state) {
            return state.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        static /* synthetic */ int access$702(State state, int i) {
            state.contentDescriptionExceedsMaxBadgeNumberRes = i;
            return i;
        }

        static /* synthetic */ Boolean access$800(State state) {
            return state.isVisible;
        }

        static /* synthetic */ Boolean access$802(State state, Boolean bool) {
            state.isVisible = bool;
            return bool;
        }

        static /* synthetic */ int access$900(State state) {
            return state.maxCharacterCount;
        }

        static /* synthetic */ int access$902(State state, int i) {
            state.maxCharacterCount = i;
            return i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.badgeResId);
            parcel.writeSerializable(this.backgroundColor);
            parcel.writeSerializable(this.badgeTextColor);
            parcel.writeSerializable(this.badgeTextAppearanceResId);
            parcel.writeSerializable(this.badgeShapeAppearanceResId);
            parcel.writeSerializable(this.badgeShapeAppearanceOverlayResId);
            parcel.writeSerializable(this.badgeWithTextShapeAppearanceResId);
            parcel.writeSerializable(this.badgeWithTextShapeAppearanceOverlayResId);
            parcel.writeInt(this.alpha);
            parcel.writeString(this.text);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeInt(this.maxNumber);
            parcel.writeString(this.contentDescriptionForText != null ? this.contentDescriptionForText.toString() : null);
            parcel.writeString(this.contentDescriptionNumberless != null ? this.contentDescriptionNumberless.toString() : null);
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeSerializable(this.badgeGravity);
            parcel.writeSerializable(this.badgeHorizontalPadding);
            parcel.writeSerializable(this.badgeVerticalPadding);
            parcel.writeSerializable(this.horizontalOffsetWithoutText);
            parcel.writeSerializable(this.verticalOffsetWithoutText);
            parcel.writeSerializable(this.horizontalOffsetWithText);
            parcel.writeSerializable(this.verticalOffsetWithText);
            parcel.writeSerializable(this.largeFontVerticalOffsetAdjustment);
            parcel.writeSerializable(this.additionalHorizontalOffset);
            parcel.writeSerializable(this.additionalVerticalOffset);
            parcel.writeSerializable(this.isVisible);
            parcel.writeSerializable(this.numberLocale);
            parcel.writeSerializable(this.autoAdjustToWithinGrandparentBounds);
            parcel.writeSerializable(this.badgeFixedEdge);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeState(Context context, int i, int i2, int i3, State state) {
        state = state == null ? new State() : state;
        if (i != 0) {
            State.access$002(state, i);
        }
        TypedArray generateTypedArray = generateTypedArray(context, State.access$000(state), i2, i3);
        Resources resources = context.getResources();
        this.badgeRadius = generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeRadius, -1);
        this.horizontalInset = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.horizontalInsetWithText = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.badgeWithTextRadius = generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, -1);
        this.badgeWidth = generateTypedArray.getDimension(R.styleable.Badge_badgeWidth, resources.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextWidth = generateTypedArray.getDimension(R.styleable.Badge_badgeWithTextWidth, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.badgeHeight = generateTypedArray.getDimension(R.styleable.Badge_badgeHeight, resources.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextHeight = generateTypedArray.getDimension(R.styleable.Badge_badgeWithTextHeight, resources.getDimension(R.dimen.m3_badge_with_text_size));
        boolean z = true;
        this.offsetAlignmentMode = generateTypedArray.getInt(R.styleable.Badge_offsetAlignmentMode, 1);
        this.badgeFixedEdge = generateTypedArray.getInt(R.styleable.Badge_badgeFixedEdge, 0);
        State.access$102(this.currentState, State.access$100(state) == -2 ? 255 : State.access$100(state));
        if (State.access$200(state) != -2) {
            State.access$202(this.currentState, State.access$200(state));
        } else if (generateTypedArray.hasValue(R.styleable.Badge_number)) {
            State.access$202(this.currentState, generateTypedArray.getInt(R.styleable.Badge_number, 0));
        } else {
            State.access$202(this.currentState, -1);
        }
        if (State.access$300(state) != null) {
            State.access$302(this.currentState, State.access$300(state));
        } else if (generateTypedArray.hasValue(R.styleable.Badge_badgeText)) {
            State.access$302(this.currentState, generateTypedArray.getString(R.styleable.Badge_badgeText));
        }
        State.access$402(this.currentState, State.access$400(state));
        State.access$502(this.currentState, State.access$500(state) == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : State.access$500(state));
        State.access$602(this.currentState, State.access$600(state) == 0 ? R.plurals.mtrl_badge_content_description : State.access$600(state));
        State.access$702(this.currentState, State.access$700(state) == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : State.access$700(state));
        State state2 = this.currentState;
        if (State.access$800(state) != null && !State.access$800(state).booleanValue()) {
            z = false;
        }
        State.access$802(state2, Boolean.valueOf(z));
        State.access$902(this.currentState, State.access$900(state) == -2 ? generateTypedArray.getInt(R.styleable.Badge_maxCharacterCount, -2) : State.access$900(state));
        State.access$1002(this.currentState, State.access$1000(state) == -2 ? generateTypedArray.getInt(R.styleable.Badge_maxNumber, -2) : State.access$1000(state));
        State.access$1102(this.currentState, Integer.valueOf(State.access$1100(state) == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : State.access$1100(state).intValue()));
        State.access$1202(this.currentState, Integer.valueOf(State.access$1200(state) == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeShapeAppearanceOverlay, 0) : State.access$1200(state).intValue()));
        State.access$1302(this.currentState, Integer.valueOf(State.access$1300(state) == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : State.access$1300(state).intValue()));
        State.access$1402(this.currentState, Integer.valueOf(State.access$1400(state) == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0) : State.access$1400(state).intValue()));
        State.access$1502(this.currentState, Integer.valueOf(State.access$1500(state) == null ? readColorFromAttributes(context, generateTypedArray, R.styleable.Badge_backgroundColor) : State.access$1500(state).intValue()));
        State.access$1602(this.currentState, Integer.valueOf(State.access$1600(state) == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeTextAppearance, R.style.TextAppearance_MaterialComponents_Badge) : State.access$1600(state).intValue()));
        if (State.access$1700(state) != null) {
            State.access$1702(this.currentState, State.access$1700(state));
        } else if (generateTypedArray.hasValue(R.styleable.Badge_badgeTextColor)) {
            State.access$1702(this.currentState, Integer.valueOf(readColorFromAttributes(context, generateTypedArray, R.styleable.Badge_badgeTextColor)));
        } else {
            State.access$1702(this.currentState, Integer.valueOf(new TextAppearance(context, State.access$1600(this.currentState).intValue()).getTextColor().getDefaultColor()));
        }
        State.access$1802(this.currentState, Integer.valueOf(State.access$1800(state) == null ? generateTypedArray.getInt(R.styleable.Badge_badgeGravity, 8388661) : State.access$1800(state).intValue()));
        State.access$1902(this.currentState, Integer.valueOf(State.access$1900(state) == null ? generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : State.access$1900(state).intValue()));
        State.access$2002(this.currentState, Integer.valueOf(State.access$2000(state) == null ? generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : State.access$2000(state).intValue()));
        State.access$2102(this.currentState, Integer.valueOf(State.access$2100(state) == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0) : State.access$2100(state).intValue()));
        State.access$2202(this.currentState, Integer.valueOf(State.access$2200(state) == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0) : State.access$2200(state).intValue()));
        State.access$2302(this.currentState, Integer.valueOf(State.access$2300(state) == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, State.access$2100(this.currentState).intValue()) : State.access$2300(state).intValue()));
        State.access$2402(this.currentState, Integer.valueOf(State.access$2400(state) == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, State.access$2200(this.currentState).intValue()) : State.access$2400(state).intValue()));
        State.access$2502(this.currentState, Integer.valueOf(State.access$2500(state) == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_largeFontVerticalOffsetAdjustment, 0) : State.access$2500(state).intValue()));
        State.access$2602(this.currentState, Integer.valueOf(State.access$2600(state) == null ? 0 : State.access$2600(state).intValue()));
        State.access$2702(this.currentState, Integer.valueOf(State.access$2700(state) == null ? 0 : State.access$2700(state).intValue()));
        State.access$2802(this.currentState, Boolean.valueOf(State.access$2800(state) == null ? generateTypedArray.getBoolean(R.styleable.Badge_autoAdjustToWithinGrandparentBounds, false) : State.access$2800(state).booleanValue()));
        generateTypedArray.recycle();
        if (State.access$2900(state) == null) {
            State state3 = this.currentState;
            int i4 = Build.VERSION.SDK_INT;
            State.access$2902(state3, Locale.getDefault(Locale.Category.FORMAT));
        } else {
            State.access$2902(this.currentState, State.access$2900(state));
        }
        this.overridingState = state;
    }

    private TypedArray generateTypedArray(Context context, int i, int i2, int i3) {
        AttributeSet attributeSet;
        int i4 = 0;
        if (i != 0) {
            AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i, BADGE_RESOURCE_TAG);
            i4 = parseDrawableXml.getStyleAttribute();
            attributeSet = parseDrawableXml;
        } else {
            attributeSet = null;
        }
        return ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Badge, i2, i4 == 0 ? i3 : i4, new int[0]);
    }

    private static int readColorFromAttributes(Context context, TypedArray typedArray, int i) {
        return MaterialResources.getColorStateList(context, typedArray, i).getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNumber() {
        setNumber(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearText() {
        setText(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAdditionalHorizontalOffset() {
        return State.access$2600(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAdditionalVerticalOffset() {
        return State.access$2700(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAlpha() {
        return State.access$100(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBackgroundColor() {
        return State.access$1500(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBadgeGravity() {
        return State.access$1800(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBadgeHorizontalPadding() {
        return State.access$1900(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBadgeShapeAppearanceOverlayResId() {
        return State.access$1200(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBadgeShapeAppearanceResId() {
        return State.access$1100(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBadgeTextColor() {
        return State.access$1700(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBadgeVerticalPadding() {
        return State.access$2000(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBadgeWithTextShapeAppearanceOverlayResId() {
        return State.access$1400(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBadgeWithTextShapeAppearanceResId() {
        return State.access$1300(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getContentDescriptionExceedsMaxBadgeNumberStringResource() {
        return State.access$700(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getContentDescriptionForText() {
        return State.access$400(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getContentDescriptionNumberless() {
        return State.access$500(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getContentDescriptionQuantityStrings() {
        return State.access$600(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHorizontalOffsetWithText() {
        return State.access$2300(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHorizontalOffsetWithoutText() {
        return State.access$2100(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLargeFontVerticalOffsetAdjustment() {
        return State.access$2500(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxCharacterCount() {
        return State.access$900(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxNumber() {
        return State.access$1000(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumber() {
        return State.access$200(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Locale getNumberLocale() {
        return State.access$2900(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State getOverridingState() {
        return this.overridingState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getText() {
        return State.access$300(this.currentState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTextAppearanceResId() {
        return State.access$1600(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVerticalOffsetWithText() {
        return State.access$2400(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVerticalOffsetWithoutText() {
        return State.access$2200(this.currentState).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasNumber() {
        return State.access$200(this.currentState) != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasText() {
        return State.access$300(this.currentState) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public boolean isAutoAdjustedToGrandparentBounds() {
        return State.access$2800(this.currentState).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isVisible() {
        return State.access$800(this.currentState).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAdditionalHorizontalOffset(int i) {
        State.access$2602(this.overridingState, Integer.valueOf(i));
        State.access$2602(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAdditionalVerticalOffset(int i) {
        State.access$2702(this.overridingState, Integer.valueOf(i));
        State.access$2702(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAlpha(int i) {
        State.access$102(this.overridingState, i);
        State.access$102(this.currentState, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public void setAutoAdjustToGrandparentBounds(boolean z) {
        State.access$2802(this.overridingState, Boolean.valueOf(z));
        State.access$2802(this.currentState, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundColor(int i) {
        State.access$1502(this.overridingState, Integer.valueOf(i));
        State.access$1502(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeGravity(int i) {
        State.access$1802(this.overridingState, Integer.valueOf(i));
        State.access$1802(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeHorizontalPadding(int i) {
        State.access$1902(this.overridingState, Integer.valueOf(i));
        State.access$1902(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeShapeAppearanceOverlayResId(int i) {
        State.access$1202(this.overridingState, Integer.valueOf(i));
        State.access$1202(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeShapeAppearanceResId(int i) {
        State.access$1102(this.overridingState, Integer.valueOf(i));
        State.access$1102(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeTextColor(int i) {
        State.access$1702(this.overridingState, Integer.valueOf(i));
        State.access$1702(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeVerticalPadding(int i) {
        State.access$2002(this.overridingState, Integer.valueOf(i));
        State.access$2002(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeWithTextShapeAppearanceOverlayResId(int i) {
        State.access$1402(this.overridingState, Integer.valueOf(i));
        State.access$1402(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeWithTextShapeAppearanceResId(int i) {
        State.access$1302(this.overridingState, Integer.valueOf(i));
        State.access$1302(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(int i) {
        State.access$702(this.overridingState, i);
        State.access$702(this.currentState, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContentDescriptionForText(CharSequence charSequence) {
        State.access$402(this.overridingState, charSequence);
        State.access$402(this.currentState, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContentDescriptionNumberless(CharSequence charSequence) {
        State.access$502(this.overridingState, charSequence);
        State.access$502(this.currentState, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContentDescriptionQuantityStringsResource(int i) {
        State.access$602(this.overridingState, i);
        State.access$602(this.currentState, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHorizontalOffsetWithText(int i) {
        State.access$2302(this.overridingState, Integer.valueOf(i));
        State.access$2302(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHorizontalOffsetWithoutText(int i) {
        State.access$2102(this.overridingState, Integer.valueOf(i));
        State.access$2102(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLargeFontVerticalOffsetAdjustment(int i) {
        State.access$2502(this.overridingState, Integer.valueOf(i));
        State.access$2502(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCharacterCount(int i) {
        State.access$902(this.overridingState, i);
        State.access$902(this.currentState, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxNumber(int i) {
        State.access$1002(this.overridingState, i);
        State.access$1002(this.currentState, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNumber(int i) {
        State.access$202(this.overridingState, i);
        State.access$202(this.currentState, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNumberLocale(Locale locale) {
        State.access$2902(this.overridingState, locale);
        State.access$2902(this.currentState, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setText(String str) {
        State.access$302(this.overridingState, str);
        State.access$302(this.currentState, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTextAppearanceResId(int i) {
        State.access$1602(this.overridingState, Integer.valueOf(i));
        State.access$1602(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVerticalOffsetWithText(int i) {
        State.access$2402(this.overridingState, Integer.valueOf(i));
        State.access$2402(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVerticalOffsetWithoutText(int i) {
        State.access$2202(this.overridingState, Integer.valueOf(i));
        State.access$2202(this.currentState, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVisible(boolean z) {
        State.access$802(this.overridingState, Boolean.valueOf(z));
        State.access$802(this.currentState, Boolean.valueOf(z));
    }
}
