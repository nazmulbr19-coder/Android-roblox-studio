package com.google.android.material.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class MaterialSplitButton extends MaterialButtonGroup {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_MaterialSplitButton;
    private static final int REQUIRED_BUTTON_COUNT = 2;

    public MaterialSplitButton(Context context) {
        this(context, null);
    }

    public MaterialSplitButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSplitButtonStyle);
    }

    public MaterialSplitButton(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
    }

    @Override // com.google.android.material.button.MaterialButtonGroup, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            throw new IllegalArgumentException("MaterialSplitButton can only hold MaterialButtons.");
        }
        if (getChildCount() > 2) {
            throw new IllegalArgumentException("MaterialSplitButton can only hold two MaterialButtons.");
        }
        MaterialButton materialButton = (MaterialButton) view;
        super.addView(view, i, layoutParams);
        if (indexOfChild(view) == 1) {
            materialButton.setCheckable(true);
            materialButton.setA11yClassName(Button.class.getName());
            ViewCompat.setStateDescription(materialButton, getResources().getString(materialButton.isChecked() ? R.string.mtrl_button_expanded_content_description : R.string.mtrl_button_collapsed_content_description));
            materialButton.addOnCheckedChangeListener(new MaterialSplitButton$$ExternalSyntheticLambda0(this, materialButton));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$addView$0$com-google-android-material-button-MaterialSplitButton, reason: not valid java name */
    public /* synthetic */ void m330xf376ee79(MaterialButton materialButton, MaterialButton materialButton2, boolean z) {
        ViewCompat.setStateDescription(materialButton, getResources().getString(z ? R.string.mtrl_button_expanded_content_description : R.string.mtrl_button_collapsed_content_description));
    }
}
