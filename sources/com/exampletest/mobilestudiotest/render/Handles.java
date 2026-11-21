package com.exampletest.mobilestudiotest.render;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.core.Tool;
import com.exampletest.mobilestudiotest.engine.Geometry;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SceneRenderer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/Handles;", "", "<init>", "()V", "compute", "Lcom/exampletest/mobilestudiotest/render/HandleSet;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", TypedValues.Custom.S_COLOR, "", "i", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Handles {
    public static final Handles INSTANCE = new Handles();

    private Handles() {
    }

    public final float[] color(int i) {
        switch (i % 3) {
            case 0:
                return new float[]{0.95f, 0.25f, 0.25f, 1.0f};
            case 1:
                return new float[]{0.3f, 0.9f, 0.3f, 1.0f};
            default:
                return new float[]{0.25f, 0.5f, 1.0f, 1.0f};
        }
    }

    public final HandleSet compute(Studio studio) {
        CFrame at;
        Vector3 div;
        Intrinsics.checkNotNullParameter(studio, "studio");
        CFrame cFrame = null;
        if (!studio.isPlaying() && studio.getTool() != Tool.SELECT) {
            List<Instance> selectedParts = studio.selectedParts();
            if (selectedParts.isEmpty()) {
                return null;
            }
            boolean z = studio.getTool() != Tool.MOVE && (selectedParts.size() == 1);
            if (z) {
                at = PartData.INSTANCE.cframe(selectedParts.get(0)).rotationOnly().withPosition(PartData.INSTANCE.cframe(selectedParts.get(0)).getPosition());
                div = PartData.INSTANCE.size(selectedParts.get(0)).div(2.0f);
            } else {
                Pair<Vector3, Vector3> boundsOf = Geometry.INSTANCE.boundsOf(selectedParts);
                if (boundsOf == null) {
                    return null;
                }
                Vector3 component1 = boundsOf.component1();
                Vector3 component2 = boundsOf.component2();
                at = CFrame.INSTANCE.at(component1.plus(component2).div(2.0f));
                div = component2.minus(component1).div(2.0f);
            }
            Vector3 position = at.getPosition();
            float f = 1.0f;
            float coerceAtLeast = RangesKt.coerceAtLeast(studio.getView().distTo(position), 1.0f);
            float f2 = 0.07f * coerceAtLeast;
            float f3 = coerceAtLeast * 0.02f;
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < 6) {
                int i2 = i % 3;
                Vector3 times = at.column(i2).times(i < 3 ? f : -1.0f);
                CFrame cFrame2 = cFrame;
                Vector3 plus = position.plus(times.times(div.get(i2)));
                arrayList.add(new Handle(i, times, plus, plus.plus(times.times(f2)), f3));
                i++;
                cFrame = cFrame2;
                f = 1.0f;
            }
            return new HandleSet(studio.getTool(), position, arrayList, z ? at : cFrame);
        }
        return null;
    }
}
