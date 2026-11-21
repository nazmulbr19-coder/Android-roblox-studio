package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public final class MaterialDynamicColors {
    private final boolean isExtendedFidelity;

    public MaterialDynamicColors() {
        this.isExtendedFidelity = false;
    }

    public MaterialDynamicColors(boolean z) {
        this.isExtendedFidelity = z;
    }

    static double findDesiredChromaByTone(double d, double d2, double d3, boolean z) {
        double d4 = d3;
        Hct from = Hct.from(d, d2, d3);
        if (from.getChroma() >= d2) {
            return d4;
        }
        double chroma = from.getChroma();
        while (from.getChroma() < d2) {
            double d5 = d4 + (z ? -1.0d : 1.0d);
            Hct from2 = Hct.from(d, d2, d5);
            if (chroma > from2.getChroma() || Math.abs(from2.getChroma() - d2) < 0.4d) {
                return d5;
            }
            if (Math.abs(from2.getChroma() - d2) < Math.abs(from.getChroma() - d2)) {
                from = from2;
            }
            chroma = Math.max(chroma, from2.getChroma());
            d4 = d5;
        }
        return d4;
    }

    private boolean isFidelity(DynamicScheme dynamicScheme) {
        return !(!this.isExtendedFidelity || dynamicScheme.variant == Variant.MONOCHROME || dynamicScheme.variant == Variant.NEUTRAL) || dynamicScheme.variant == Variant.FIDELITY || dynamicScheme.variant == Variant.CONTENT;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        return dynamicScheme.variant == Variant.MONOCHROME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$background$10(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$background$11(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : 98.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$controlActivated$145(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$controlActivated$146(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$controlHighlight$149(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$controlHighlight$150(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 100.0d : 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$controlHighlight$151(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 0.2d : 0.12d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$controlNormal$147(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralVariantPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$controlNormal$148(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$error$91(DynamicScheme dynamicScheme) {
        return dynamicScheme.errorPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$error$92(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$errorContainer$97(DynamicScheme dynamicScheme) {
        return dynamicScheme.errorPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$errorContainer$98(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$inverseOnSurface$39(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$inverseOnSurface$40(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 95.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$inversePrimary$64(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$inversePrimary$65(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 40.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$inverseSurface$37(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$inverseSurface$38(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 20.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$neutralPaletteKeyColor$6(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$neutralPaletteKeyColor$7(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.neutralPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$neutralVariantPaletteKeyColor$8(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralVariantPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$neutralVariantPaletteKeyColor$9(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.neutralVariantPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onBackground$12(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onBackground$13(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onError$94(DynamicScheme dynamicScheme) {
        return dynamicScheme.errorPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onError$95(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onErrorContainer$100(DynamicScheme dynamicScheme) {
        return dynamicScheme.errorPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onErrorContainer$101(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onPrimary$55(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onPrimary$56(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onPrimaryContainer$61(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onPrimaryFixed$109(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onPrimaryFixed$110(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 100.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onPrimaryFixedVariant$113(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onPrimaryFixedVariant$114(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 90.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onSecondary$70(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onSecondary$71(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 100.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onSecondaryContainer$76(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onSecondaryFixed$123(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onSecondaryFixed$124(DynamicScheme dynamicScheme) {
        return Double.valueOf(10.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onSecondaryFixedVariant$127(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onSecondaryFixedVariant$128(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 25.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onSurface$31(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onSurface$32(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onSurfaceVariant$35(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralVariantPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onSurfaceVariant$36(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onTertiary$82(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onTertiary$83(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onTertiaryContainer$88(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onTertiaryFixed$137(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onTertiaryFixed$138(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 100.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$onTertiaryFixedVariant$141(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$onTertiaryFixedVariant$142(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 90.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$outline$42(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralVariantPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$outline$43(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 60.0d : 50.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$outlineVariant$44(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralVariantPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$outlineVariant$45(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$primary$52(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$primary$53(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 100.0d : 0.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$primaryContainer$58(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$primaryFixed$103(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$primaryFixed$104(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 40.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$primaryFixedDim$106(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$primaryFixedDim$107(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 30.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$primaryPaletteKeyColor$0(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$primaryPaletteKeyColor$1(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.primaryPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$scrim$48(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$scrim$49(DynamicScheme dynamicScheme) {
        return Double.valueOf(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$secondary$67(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$secondary$68(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$secondaryContainer$73(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$secondaryFixed$117(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$secondaryFixed$118(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 80.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$secondaryFixedDim$120(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$secondaryFixedDim$121(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 70.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$secondaryPaletteKeyColor$2(DynamicScheme dynamicScheme) {
        return dynamicScheme.secondaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$secondaryPaletteKeyColor$3(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.secondaryPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$shadow$46(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$shadow$47(DynamicScheme dynamicScheme) {
        return Double.valueOf(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surface$15(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surface$16(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : 98.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceBright$19(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceBright$20(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? new ContrastCurve(24.0d, 24.0d, 29.0d, 34.0d).get(dynamicScheme.contrastLevel) : 98.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceContainer$25(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceContainer$26(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? new ContrastCurve(12.0d, 12.0d, 16.0d, 20.0d).get(dynamicScheme.contrastLevel) : new ContrastCurve(94.0d, 94.0d, 92.0d, 90.0d).get(dynamicScheme.contrastLevel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceContainerHigh$27(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceContainerHigh$28(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? new ContrastCurve(17.0d, 17.0d, 21.0d, 25.0d).get(dynamicScheme.contrastLevel) : new ContrastCurve(92.0d, 92.0d, 88.0d, 85.0d).get(dynamicScheme.contrastLevel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceContainerHighest$29(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceContainerHighest$30(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? new ContrastCurve(22.0d, 22.0d, 26.0d, 30.0d).get(dynamicScheme.contrastLevel) : new ContrastCurve(90.0d, 90.0d, 84.0d, 80.0d).get(dynamicScheme.contrastLevel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceContainerLow$23(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceContainerLow$24(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? new ContrastCurve(10.0d, 10.0d, 11.0d, 12.0d).get(dynamicScheme.contrastLevel) : new ContrastCurve(96.0d, 96.0d, 96.0d, 95.0d).get(dynamicScheme.contrastLevel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceContainerLowest$21(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceContainerLowest$22(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? new ContrastCurve(4.0d, 4.0d, 2.0d, 0.0d).get(dynamicScheme.contrastLevel) : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceDim$17(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceDim$18(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : new ContrastCurve(87.0d, 87.0d, 80.0d, 75.0d).get(dynamicScheme.contrastLevel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceTint$50(DynamicScheme dynamicScheme) {
        return dynamicScheme.primaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceTint$51(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$surfaceVariant$33(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralVariantPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$surfaceVariant$34(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$tertiary$79(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$tertiary$80(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 90.0d : 25.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$tertiaryContainer$85(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$tertiaryFixed$131(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$tertiaryFixed$132(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 40.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$tertiaryFixedDim$134(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$tertiaryFixedDim$135(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 30.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$tertiaryPaletteKeyColor$4(DynamicScheme dynamicScheme) {
        return dynamicScheme.tertiaryPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$tertiaryPaletteKeyColor$5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.tertiaryPalette.getKeyColor().getTone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$textHintInverse$160(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$textHintInverse$161(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$textPrimaryInverse$152(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$textPrimaryInverse$153(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$textPrimaryInverseDisableOnly$156(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$textPrimaryInverseDisableOnly$157(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$textSecondaryAndTertiaryInverse$154(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralVariantPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverse$155(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TonalPalette lambda$textSecondaryAndTertiaryInverseDisabled$158(DynamicScheme dynamicScheme) {
        return dynamicScheme.neutralPalette;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverseDisabled$159(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    public DynamicColor background() {
        return new DynamicColor("background", new MaterialDynamicColors$$ExternalSyntheticLambda43(), new MaterialDynamicColors$$ExternalSyntheticLambda44(), true, null, null, null, null);
    }

    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette("control_activated", new MaterialDynamicColors$$ExternalSyntheticLambda16(), new MaterialDynamicColors$$ExternalSyntheticLambda17());
    }

    public DynamicColor controlHighlight() {
        return new DynamicColor("control_highlight", new MaterialDynamicColors$$ExternalSyntheticLambda37(), new MaterialDynamicColors$$ExternalSyntheticLambda38(), false, null, null, null, null, new MaterialDynamicColors$$ExternalSyntheticLambda39());
    }

    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette("control_normal", new MaterialDynamicColors$$ExternalSyntheticLambda14(), new MaterialDynamicColors$$ExternalSyntheticLambda15());
    }

    public DynamicColor error() {
        return new DynamicColor("error", new MaterialDynamicColors$$ExternalSyntheticLambda129(), new MaterialDynamicColors$$ExternalSyntheticLambda130(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda131(this));
    }

    public DynamicColor errorContainer() {
        return new DynamicColor("error_container", new MaterialDynamicColors$$ExternalSyntheticLambda145(), new MaterialDynamicColors$$ExternalSyntheticLambda146(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda147(this));
    }

    public DynamicColor highestSurface(DynamicScheme dynamicScheme) {
        return dynamicScheme.isDark ? surfaceBright() : surfaceDim();
    }

    public DynamicColor inverseOnSurface() {
        return new DynamicColor("inverse_on_surface", new MaterialDynamicColors$$ExternalSyntheticLambda116(), new MaterialDynamicColors$$ExternalSyntheticLambda117(), false, new MaterialDynamicColors$$ExternalSyntheticLambda118(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor inversePrimary() {
        return new DynamicColor("inverse_primary", new MaterialDynamicColors$$ExternalSyntheticLambda57(), new MaterialDynamicColors$$ExternalSyntheticLambda58(), false, new MaterialDynamicColors$$ExternalSyntheticLambda59(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), null);
    }

    public DynamicColor inverseSurface() {
        return new DynamicColor("inverse_surface", new MaterialDynamicColors$$ExternalSyntheticLambda138(), new MaterialDynamicColors$$ExternalSyntheticLambda139(), false, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$error$93$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m335x590ec46a(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 10.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$errorContainer$99$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m336x33346ee5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 10.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$inverseOnSurface$41$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m337xcbcaf83d(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$inversePrimary$66$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m338x6f94cccc(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onBackground$14$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m339x24678954(DynamicScheme dynamicScheme) {
        return background();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onError$96$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m340xb6a5d3ac(DynamicScheme dynamicScheme) {
        return error();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onErrorContainer$102$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m341x2dffdbdb(DynamicScheme dynamicScheme) {
        return errorContainer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPrimary$57$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m342x16f20f37(DynamicScheme dynamicScheme) {
        return primary();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPrimaryContainer$62$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ Double m343x617ce7dc(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(primaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 0.0d : 100.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPrimaryContainer$63$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m344x3d3e639d(DynamicScheme dynamicScheme) {
        return primaryContainer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPrimaryFixed$111$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m345x702e4bf2(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPrimaryFixed$112$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m346x4befc7b3(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPrimaryFixedVariant$115$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m347x19d0bbbf(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPrimaryFixedVariant$116$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m348xf5923780(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSecondary$72$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m349x1ad791fe(DynamicScheme dynamicScheme) {
        return secondary();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSecondaryContainer$77$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ Double m350x4fcce1f2(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
        }
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(secondaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSecondaryContainer$78$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m351x2b8e5db3(DynamicScheme dynamicScheme) {
        return secondaryContainer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSecondaryFixed$125$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m352xf72fd9a3(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSecondaryFixed$126$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m353xd2f15564(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSecondaryFixedVariant$129$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m354x26187114(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSecondaryFixedVariant$130$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m355x8b913aa(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onTertiary$84$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m356x36068449(DynamicScheme dynamicScheme) {
        return tertiary();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onTertiaryContainer$89$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ Double m357xb5c66ea9(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 0.0d : 100.0d);
        }
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(tertiaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onTertiaryContainer$90$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m358x9867113f(DynamicScheme dynamicScheme) {
        return tertiaryContainer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onTertiaryFixed$139$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m359xfe3fcbf0(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onTertiaryFixed$140$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m360xe0e06e86(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onTertiaryFixedVariant$143$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m361x702fc122(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onTertiaryFixedVariant$144$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ DynamicColor m362x4bf13ce3(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$primary$54$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m363x39203b5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 10.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$primaryContainer$59$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ Double m364x9fd70f23(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.sourceColorHct.getTone());
        }
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 85.0d : 25.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$primaryContainer$60$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m365x8277b1b9(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 10.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$primaryFixed$105$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m366xcb141198(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$primaryFixedDim$108$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m367x8f195ac5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$secondary$69$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m368x991d7367(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 10.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$secondaryContainer$74$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ Double m369x6c9b544e(DynamicScheme dynamicScheme) {
        double d = dynamicScheme.isDark ? 30.0d : 90.0d;
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 30.0d : 85.0d);
        }
        return !isFidelity(dynamicScheme) ? Double.valueOf(d) : Double.valueOf(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d, !dynamicScheme.isDark));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$secondaryContainer$75$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m370x485cd00f(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 10.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$secondaryFixed$119$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m371x75ece309(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$secondaryFixedDim$122$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m372x801c242f(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tertiary$81$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m373x1f6aa165(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 10.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tertiaryContainer$86$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ Double m374x59bc65e7(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 60.0d : 49.0d);
        }
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone())).getTone());
        }
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tertiaryContainer$87$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m375x357de1a8(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 10.0d, TonePolarity.NEARER, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tertiaryFixed$133$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m376x59237289(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tertiaryFixedDim$136$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    public /* synthetic */ ToneDeltaPair m377x24c02d4a(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda10(), new MaterialDynamicColors$$ExternalSyntheticLambda11());
    }

    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_variant_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda83(), new MaterialDynamicColors$$ExternalSyntheticLambda84());
    }

    public DynamicColor onBackground() {
        return new DynamicColor("on_background", new MaterialDynamicColors$$ExternalSyntheticLambda47(), new MaterialDynamicColors$$ExternalSyntheticLambda48(), false, new MaterialDynamicColors$$ExternalSyntheticLambda49(this), null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), null);
    }

    public DynamicColor onError() {
        return new DynamicColor("on_error", new MaterialDynamicColors$$ExternalSyntheticLambda70(), new MaterialDynamicColors$$ExternalSyntheticLambda71(), false, new MaterialDynamicColors$$ExternalSyntheticLambda72(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor onErrorContainer() {
        return new DynamicColor("on_error_container", new MaterialDynamicColors$$ExternalSyntheticLambda140(), new MaterialDynamicColors$$ExternalSyntheticLambda141(), false, new MaterialDynamicColors$$ExternalSyntheticLambda142(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor onPrimary() {
        return new DynamicColor("on_primary", new MaterialDynamicColors$$ExternalSyntheticLambda54(), new MaterialDynamicColors$$ExternalSyntheticLambda55(), false, new MaterialDynamicColors$$ExternalSyntheticLambda56(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor onPrimaryContainer() {
        return new DynamicColor("on_primary_container", new MaterialDynamicColors$$ExternalSyntheticLambda75(), new MaterialDynamicColors$$ExternalSyntheticLambda76(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda77(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor onPrimaryFixed() {
        return new DynamicColor("on_primary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda125(), new MaterialDynamicColors$$ExternalSyntheticLambda126(), false, new MaterialDynamicColors$$ExternalSyntheticLambda127(this), new MaterialDynamicColors$$ExternalSyntheticLambda128(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor onPrimaryFixedVariant() {
        return new DynamicColor("on_primary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda63(), new MaterialDynamicColors$$ExternalSyntheticLambda64(), false, new MaterialDynamicColors$$ExternalSyntheticLambda65(this), new MaterialDynamicColors$$ExternalSyntheticLambda66(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor onSecondary() {
        return new DynamicColor("on_secondary", new MaterialDynamicColors$$ExternalSyntheticLambda100(), new MaterialDynamicColors$$ExternalSyntheticLambda101(), false, new MaterialDynamicColors$$ExternalSyntheticLambda102(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor onSecondaryContainer() {
        return new DynamicColor("on_secondary_container", new MaterialDynamicColors$$ExternalSyntheticLambda122(), new MaterialDynamicColors$$ExternalSyntheticLambda123(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda124(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor onSecondaryFixed() {
        return new DynamicColor("on_secondary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda112(), new MaterialDynamicColors$$ExternalSyntheticLambda113(), false, new MaterialDynamicColors$$ExternalSyntheticLambda114(this), new MaterialDynamicColors$$ExternalSyntheticLambda115(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor onSecondaryFixedVariant() {
        return new DynamicColor("on_secondary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda156(), new MaterialDynamicColors$$ExternalSyntheticLambda157(), false, new MaterialDynamicColors$$ExternalSyntheticLambda158(this), new MaterialDynamicColors$$ExternalSyntheticLambda159(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor onSurface() {
        return new DynamicColor("on_surface", new MaterialDynamicColors$$ExternalSyntheticLambda7(), new MaterialDynamicColors$$ExternalSyntheticLambda8(), false, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor onSurfaceVariant() {
        return new DynamicColor("on_surface_variant", new MaterialDynamicColors$$ExternalSyntheticLambda136(), new MaterialDynamicColors$$ExternalSyntheticLambda137(), false, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor onTertiary() {
        return new DynamicColor("on_tertiary", new MaterialDynamicColors$$ExternalSyntheticLambda4(), new MaterialDynamicColors$$ExternalSyntheticLambda5(), false, new MaterialDynamicColors$$ExternalSyntheticLambda6(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor onTertiaryContainer() {
        return new DynamicColor("on_tertiary_container", new MaterialDynamicColors$$ExternalSyntheticLambda119(), new MaterialDynamicColors$$ExternalSyntheticLambda120(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda121(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor onTertiaryFixed() {
        return new DynamicColor("on_tertiary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda31(), new MaterialDynamicColors$$ExternalSyntheticLambda32(), false, new MaterialDynamicColors$$ExternalSyntheticLambda33(this), new MaterialDynamicColors$$ExternalSyntheticLambda34(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor onTertiaryFixedVariant() {
        return new DynamicColor("on_tertiary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda20(), new MaterialDynamicColors$$ExternalSyntheticLambda21(), false, new MaterialDynamicColors$$ExternalSyntheticLambda22(this), new MaterialDynamicColors$$ExternalSyntheticLambda23(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor outline() {
        return new DynamicColor("outline", new MaterialDynamicColors$$ExternalSyntheticLambda108(), new MaterialDynamicColors$$ExternalSyntheticLambda109(), false, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), null);
    }

    public DynamicColor outlineVariant() {
        return new DynamicColor("outline_variant", new MaterialDynamicColors$$ExternalSyntheticLambda50(), new MaterialDynamicColors$$ExternalSyntheticLambda51(), false, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), null);
    }

    public DynamicColor primary() {
        return new DynamicColor("primary", new MaterialDynamicColors$$ExternalSyntheticLambda151(), new MaterialDynamicColors$$ExternalSyntheticLambda152(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda153(this));
    }

    public DynamicColor primaryContainer() {
        return new DynamicColor("primary_container", new MaterialDynamicColors$$ExternalSyntheticLambda40(), new MaterialDynamicColors$$ExternalSyntheticLambda41(this), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda42(this));
    }

    public DynamicColor primaryFixed() {
        return new DynamicColor("primary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda91(), new MaterialDynamicColors$$ExternalSyntheticLambda92(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda93(this));
    }

    public DynamicColor primaryFixedDim() {
        return new DynamicColor("primary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda94(), new MaterialDynamicColors$$ExternalSyntheticLambda95(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda96(this));
    }

    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette("primary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda18(), new MaterialDynamicColors$$ExternalSyntheticLambda19());
    }

    public DynamicColor scrim() {
        return new DynamicColor("scrim", new MaterialDynamicColors$$ExternalSyntheticLambda154(), new MaterialDynamicColors$$ExternalSyntheticLambda155(), false, null, null, null, null);
    }

    public DynamicColor secondary() {
        return new DynamicColor("secondary", new MaterialDynamicColors$$ExternalSyntheticLambda103(), new MaterialDynamicColors$$ExternalSyntheticLambda104(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda105(this));
    }

    public DynamicColor secondaryContainer() {
        return new DynamicColor("secondary_container", new MaterialDynamicColors$$ExternalSyntheticLambda28(), new MaterialDynamicColors$$ExternalSyntheticLambda29(this), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda30(this));
    }

    public DynamicColor secondaryFixed() {
        return new DynamicColor("secondary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda60(), new MaterialDynamicColors$$ExternalSyntheticLambda61(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda62(this));
    }

    public DynamicColor secondaryFixedDim() {
        return new DynamicColor("secondary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda78(), new MaterialDynamicColors$$ExternalSyntheticLambda79(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda80(this));
    }

    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette("secondary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda24(), new MaterialDynamicColors$$ExternalSyntheticLambda25());
    }

    public DynamicColor shadow() {
        return new DynamicColor("shadow", new MaterialDynamicColors$$ExternalSyntheticLambda87(), new MaterialDynamicColors$$ExternalSyntheticLambda88(), false, null, null, null, null);
    }

    public DynamicColor surface() {
        return new DynamicColor("surface", new MaterialDynamicColors$$ExternalSyntheticLambda0(), new MaterialDynamicColors$$ExternalSyntheticLambda1(), true, null, null, null, null);
    }

    public DynamicColor surfaceBright() {
        return new DynamicColor("surface_bright", new MaterialDynamicColors$$ExternalSyntheticLambda52(), new MaterialDynamicColors$$ExternalSyntheticLambda53(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainer() {
        return new DynamicColor("surface_container", new MaterialDynamicColors$$ExternalSyntheticLambda134(), new MaterialDynamicColors$$ExternalSyntheticLambda135(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerHigh() {
        return new DynamicColor("surface_container_high", new MaterialDynamicColors$$ExternalSyntheticLambda45(), new MaterialDynamicColors$$ExternalSyntheticLambda46(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerHighest() {
        return new DynamicColor("surface_container_highest", new MaterialDynamicColors$$ExternalSyntheticLambda89(), new MaterialDynamicColors$$ExternalSyntheticLambda90(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerLow() {
        return new DynamicColor("surface_container_low", new MaterialDynamicColors$$ExternalSyntheticLambda26(), new MaterialDynamicColors$$ExternalSyntheticLambda27(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerLowest() {
        return new DynamicColor("surface_container_lowest", new MaterialDynamicColors$$ExternalSyntheticLambda106(), new MaterialDynamicColors$$ExternalSyntheticLambda107(), true, null, null, null, null);
    }

    public DynamicColor surfaceDim() {
        return new DynamicColor("surface_dim", new MaterialDynamicColors$$ExternalSyntheticLambda12(), new MaterialDynamicColors$$ExternalSyntheticLambda13(), true, null, null, null, null);
    }

    public DynamicColor surfaceTint() {
        return new DynamicColor("surface_tint", new MaterialDynamicColors$$ExternalSyntheticLambda110(), new MaterialDynamicColors$$ExternalSyntheticLambda111(), true, null, null, null, null);
    }

    public DynamicColor surfaceVariant() {
        return new DynamicColor("surface_variant", new MaterialDynamicColors$$ExternalSyntheticLambda81(), new MaterialDynamicColors$$ExternalSyntheticLambda82(), true, null, null, null, null);
    }

    public DynamicColor tertiary() {
        return new DynamicColor("tertiary", new MaterialDynamicColors$$ExternalSyntheticLambda160(), new MaterialDynamicColors$$ExternalSyntheticLambda161(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda162(this));
    }

    public DynamicColor tertiaryContainer() {
        return new DynamicColor("tertiary_container", new MaterialDynamicColors$$ExternalSyntheticLambda97(), new MaterialDynamicColors$$ExternalSyntheticLambda98(this), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda99(this));
    }

    public DynamicColor tertiaryFixed() {
        return new DynamicColor("tertiary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda148(), new MaterialDynamicColors$$ExternalSyntheticLambda149(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda150(this));
    }

    public DynamicColor tertiaryFixedDim() {
        return new DynamicColor("tertiary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda67(), new MaterialDynamicColors$$ExternalSyntheticLambda68(), true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new MaterialDynamicColors$$ExternalSyntheticLambda69(this));
    }

    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette("tertiary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda35(), new MaterialDynamicColors$$ExternalSyntheticLambda36());
    }

    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette("text_hint_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda85(), new MaterialDynamicColors$$ExternalSyntheticLambda86());
    }

    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette("text_primary_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda132(), new MaterialDynamicColors$$ExternalSyntheticLambda133());
    }

    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette("text_primary_inverse_disable_only", new MaterialDynamicColors$$ExternalSyntheticLambda73(), new MaterialDynamicColors$$ExternalSyntheticLambda74());
    }

    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda143(), new MaterialDynamicColors$$ExternalSyntheticLambda144());
    }

    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse_disabled", new MaterialDynamicColors$$ExternalSyntheticLambda2(), new MaterialDynamicColors$$ExternalSyntheticLambda3());
    }
}
