package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [I] */
/* compiled from: ActivityResultRegistry.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016R\u001e\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/activity/result/ActivityResultRegistry$register$3", "Landroidx/activity/result/ActivityResultLauncher;", "launch", "", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "getContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "activity"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultRegistry$register$3<I> extends ActivityResultLauncher<I> {
    final /* synthetic */ ActivityResultContract<I, O> $contract;
    final /* synthetic */ String $key;
    final /* synthetic */ ActivityResultRegistry this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityResultRegistry$register$3(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract<I, O> activityResultContract) {
        this.this$0 = activityResultRegistry;
        this.$key = str;
        this.$contract = activityResultContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<I, ?> getContract() {
        return (ActivityResultContract<I, ?>) this.$contract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(I input, ActivityOptionsCompat options) {
        Object obj = ActivityResultRegistry.access$getKeyToRc$p(this.this$0).get(this.$key);
        Object obj2 = this.$contract;
        if (obj == null) {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + obj2 + " and input " + input + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
        int intValue = ((Number) obj).intValue();
        ActivityResultRegistry.access$getLaunchedKeys$p(this.this$0).add(this.$key);
        try {
            this.this$0.onLaunch(intValue, this.$contract, input, options);
        } catch (Exception e) {
            ActivityResultRegistry.access$getLaunchedKeys$p(this.this$0).remove(this.$key);
            throw e;
        }
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.this$0.unregister$activity(this.$key);
    }
}
