package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: BroadcastChannel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ SelectInstance<?> $select;
    int label;
    final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl<E> broadcastChannelImpl, Object obj, SelectInstance<?> selectInstance, Continuation<? super BroadcastChannelImpl$registerSelectForSend$2> continuation) {
        super(2, continuation);
        this.this$0 = broadcastChannelImpl;
        this.$element = obj;
        this.$select = selectInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.this$0, this.$element, this.$select, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return invoke2(coroutineScope, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:12:0x005e, B:14:0x0064, B:18:0x0072, B:19:0x0077, B:20:0x0078, B:22:0x0080, B:23:0x0087, B:25:0x009f, B:26:0x00a6, B:29:0x0083), top: B:11:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:12:0x005e, B:14:0x0064, B:18:0x0072, B:19:0x0077, B:20:0x0078, B:22:0x0080, B:23:0x0087, B:25:0x009f, B:26:0x00a6, B:29:0x0083), top: B:11:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:12:0x005e, B:14:0x0064, B:18:0x0072, B:19:0x0077, B:20:0x0078, B:22:0x0080, B:23:0x0087, B:25:0x009f, B:26:0x00a6, B:29:0x0083), top: B:11:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:12:0x005e, B:14:0x0064, B:18:0x0072, B:19:0x0077, B:20:0x0078, B:22:0x0080, B:23:0x0087, B:25:0x009f, B:26:0x00a6, B:29:0x0083), top: B:11:0x005e }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            r3 = 1
            switch(r1) {
                case 0: goto L1a;
                case 1: goto L13;
                default: goto Lb;
            }
        Lb:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L13:
            r0 = r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L18
            goto L30
        L18:
            r1 = move-exception
            goto L36
        L1a:
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r12
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r4 = r1.this$0     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = r1.$element     // Catch: java.lang.Throwable -> L32
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L32
            r1.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r4.send(r5, r6)     // Catch: java.lang.Throwable -> L32
            if (r4 != r0) goto L2f
            return r0
        L2f:
            r0 = r1
        L30:
            r1 = r3
            goto L4b
        L32:
            r0 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L36:
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r4 = r0.this$0
            boolean r4 = r4.isClosedForSend()
            if (r4 == 0) goto Lb4
            boolean r4 = r1 instanceof kotlinx.coroutines.channels.ClosedSendChannelException
            if (r4 != 0) goto L4a
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r4 = r0.this$0
            java.lang.Throwable r4 = r4.getSendException()
            if (r4 != r1) goto Lb4
        L4a:
            r1 = r2
        L4b:
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r4 = r0.this$0
            java.util.concurrent.locks.ReentrantLock r4 = kotlinx.coroutines.channels.BroadcastChannelImpl.access$getLock$p(r4)
            kotlinx.coroutines.channels.BroadcastChannelImpl<E> r5 = r0.this$0
            kotlinx.coroutines.selects.SelectInstance<?> r6 = r0.$select
            r7 = 0
            r8 = r4
            java.util.concurrent.locks.Lock r8 = (java.util.concurrent.locks.Lock) r8
            r8.lock()
            r4 = 0
            boolean r9 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()     // Catch: java.lang.Throwable -> Laf
            if (r9 == 0) goto L78
            r9 = 0
            java.util.HashMap r10 = kotlinx.coroutines.channels.BroadcastChannelImpl.access$getOnSendInternalResult$p(r5)     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r10 = r10.get(r6)     // Catch: java.lang.Throwable -> Laf
            if (r10 != 0) goto L70
            r2 = r3
        L70:
            if (r2 != 0) goto L78
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> Laf
            r2.<init>()     // Catch: java.lang.Throwable -> Laf
            throw r2     // Catch: java.lang.Throwable -> Laf
        L78:
            java.util.HashMap r2 = kotlinx.coroutines.channels.BroadcastChannelImpl.access$getOnSendInternalResult$p(r5)     // Catch: java.lang.Throwable -> Laf
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto L83
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Laf
            goto L87
        L83:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()     // Catch: java.lang.Throwable -> Laf
        L87:
            r2.put(r6, r3)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)     // Catch: java.lang.Throwable -> Laf
            r1 = r6
            kotlinx.coroutines.selects.SelectImplementation r1 = (kotlinx.coroutines.selects.SelectImplementation) r1     // Catch: java.lang.Throwable -> Laf
            r1 = r6
            kotlinx.coroutines.selects.SelectImplementation r1 = (kotlinx.coroutines.selects.SelectImplementation) r1     // Catch: java.lang.Throwable -> Laf
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Laf
            kotlinx.coroutines.selects.TrySelectDetailedResult r1 = r1.trySelectDetailed(r5, r2)     // Catch: java.lang.Throwable -> Laf
            kotlinx.coroutines.selects.TrySelectDetailedResult r2 = kotlinx.coroutines.selects.TrySelectDetailedResult.REREGISTER     // Catch: java.lang.Throwable -> Laf
            if (r1 == r2) goto La6
            java.util.HashMap r1 = kotlinx.coroutines.channels.BroadcastChannelImpl.access$getOnSendInternalResult$p(r5)     // Catch: java.lang.Throwable -> Laf
            r1.remove(r6)     // Catch: java.lang.Throwable -> Laf
        La6:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Laf
            r8.unlock()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        Laf:
            r1 = move-exception
            r8.unlock()
            throw r1
        Lb4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
