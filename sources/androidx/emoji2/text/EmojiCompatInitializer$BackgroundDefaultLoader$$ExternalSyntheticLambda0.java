package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/emoji2/text/EmojiCompatInitializer$BackgroundDefaultLoader;", method = "lambda$load$0", proto = "(Landroidx/emoji2/text/EmojiCompat$MetadataRepoLoaderCallback;Ljava/util/concurrent/ThreadPoolExecutor;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader f$0;
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f$1;
    public final /* synthetic */ ThreadPoolExecutor f$2;

    public /* synthetic */ EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f$0 = backgroundDefaultLoader;
        this.f$1 = metadataRepoLoaderCallback;
        this.f$2 = threadPoolExecutor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m130x5cc8028a(this.f$1, this.f$2);
    }
}
