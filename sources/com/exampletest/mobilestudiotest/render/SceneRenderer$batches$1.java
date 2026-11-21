package com.exampletest.mobilestudiotest.render;

import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import com.exampletest.mobilestudiotest.net.ImageLoader;
import com.exampletest.mobilestudiotest.render.StaticBatches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SceneRenderer.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/exampletest/mobilestudiotest/render/SceneRenderer$batches$1", "Lcom/exampletest/mobilestudiotest/render/StaticBatches$Host;", "batchable", "", "p", "Lcom/exampletest/mobilestudiotest/model/Instance;", "spec", "", "Lcom/exampletest/mobilestudiotest/render/BatchSpec;", "loadSignature", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SceneRenderer$batches$1 implements StaticBatches.Host {
    final /* synthetic */ SceneRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SceneRenderer$batches$1(SceneRenderer sceneRenderer) {
        this.this$0 = sceneRenderer;
    }

    @Override // com.exampletest.mobilestudiotest.render.StaticBatches.Host
    public boolean batchable(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return SceneRenderer.access$isBatchable(this.this$0, p);
    }

    @Override // com.exampletest.mobilestudiotest.render.StaticBatches.Host
    public int loadSignature() {
        return (MaterialTextures.INSTANCE.getEpoch() * 31) + (MeshLoader.INSTANCE.getEpoch() * 17) + (UnionMeshes.INSTANCE.getEpoch() * 13) + (AssetFetcher.INSTANCE.getImageEpoch() * 7) + ImageLoader.INSTANCE.getEpoch();
    }

    @Override // com.exampletest.mobilestudiotest.render.StaticBatches.Host
    public List<BatchSpec> spec(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return SceneRenderer.access$batchSpec(this.this$0, p);
    }
}
