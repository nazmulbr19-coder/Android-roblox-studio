package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;
import java.util.Set;

/* loaded from: classes.dex */
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private static final int MAX_LOOK_AROUND_CHARACTER = 16;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private EmojiCompat.GlyphChecker mGlyphChecker;
    private final MetadataRepo mMetadataRepo;
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    /* loaded from: classes.dex */
    private static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        static int findIndexBackward(CharSequence charSequence, int i, int i2) {
            int i3 = i;
            boolean z = false;
            int length = charSequence.length();
            if (i3 < 0 || length < i3 || i2 < 0) {
                return -1;
            }
            int i4 = i2;
            while (i4 != 0) {
                i3--;
                if (i3 < 0) {
                    return z ? -1 : 0;
                }
                char charAt = charSequence.charAt(i3);
                if (z) {
                    if (!Character.isHighSurrogate(charAt)) {
                        return -1;
                    }
                    z = false;
                    i4--;
                } else if (!Character.isSurrogate(charAt)) {
                    i4--;
                } else {
                    if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    }
                    z = true;
                }
            }
            return i3;
        }

        static int findIndexForward(CharSequence charSequence, int i, int i2) {
            int i3 = i;
            boolean z = false;
            int length = charSequence.length();
            if (i3 < 0 || length < i3 || i2 < 0) {
                return -1;
            }
            int i4 = i2;
            while (i4 != 0) {
                if (i3 >= length) {
                    if (z) {
                        return -1;
                    }
                    return length;
                }
                char charAt = charSequence.charAt(i3);
                if (z) {
                    if (!Character.isLowSurrogate(charAt)) {
                        return -1;
                    }
                    i4--;
                    z = false;
                    i3++;
                } else if (!Character.isSurrogate(charAt)) {
                    i4--;
                    i3++;
                } else {
                    if (Character.isLowSurrogate(charAt)) {
                        return -1;
                    }
                    z = true;
                    i3++;
                }
            }
            return i3;
        }
    }

    /* loaded from: classes.dex */
    private static class EmojiProcessAddSpanCallback implements EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {
        private final EmojiCompat.SpanFactory mSpanFactory;
        public UnprecomputeTextOnModificationSpannable spannable;

        EmojiProcessAddSpanCallback(UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable, EmojiCompat.SpanFactory spanFactory) {
            this.spannable = unprecomputeTextOnModificationSpannable;
            this.mSpanFactory = spanFactory;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public UnprecomputeTextOnModificationSpannable getResult() {
            return this.spannable;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public /* bridge */ /* synthetic */ UnprecomputeTextOnModificationSpannable getResult() {
            return getResult();
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (typefaceEmojiRasterizer.isPreferredSystemRender()) {
                return true;
            }
            if (this.spannable == null) {
                this.spannable = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.spannable.setSpan(this.mSpanFactory.createSpan(typefaceEmojiRasterizer), i, i2, 33);
            return true;
        }
    }

    /* loaded from: classes.dex */
    private interface EmojiProcessCallback<T> {
        T getResult();

        boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    /* loaded from: classes.dex */
    private static class EmojiProcessLookupCallback implements EmojiProcessCallback<EmojiProcessLookupCallback> {
        private final int mOffset;
        public int start = -1;
        public int end = -1;

        EmojiProcessLookupCallback(int i) {
            this.mOffset = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public EmojiProcessLookupCallback getResult() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public /* bridge */ /* synthetic */ EmojiProcessLookupCallback getResult() {
            return getResult();
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (i > this.mOffset || this.mOffset >= i2) {
                return i2 <= this.mOffset;
            }
            this.start = i;
            this.end = i2;
            return false;
        }
    }

    /* loaded from: classes.dex */
    private static class MarkExclusionCallback implements EmojiProcessCallback<MarkExclusionCallback> {
        private final String mExclusion;

        MarkExclusionCallback(String str) {
            this.mExclusion = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public MarkExclusionCallback getResult() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public /* bridge */ /* synthetic */ MarkExclusionCallback getResult() {
            return getResult();
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (!TextUtils.equals(charSequence.subSequence(i, i2), this.mExclusion)) {
                return true;
            }
            typefaceEmojiRasterizer.setExclusion(true);
            return false;
        }
    }

    /* loaded from: classes.dex */
    static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState = 1;
        private final boolean mUseEmojiAsDefaultStyle;

        ProcessorSm(MetadataRepo.Node node, boolean z, int[] iArr) {
            this.mRootNode = node;
            this.mCurrentNode = node;
            this.mUseEmojiAsDefaultStyle = z;
            this.mEmojiAsDefaultStyleExceptions = iArr;
        }

        private static boolean isEmojiStyle(int i) {
            return i == 65039;
        }

        private static boolean isTextStyle(int i) {
            return i == 65038;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji() || isEmojiStyle(this.mLastCodepoint)) {
                return true;
            }
            if (this.mUseEmojiAsDefaultStyle) {
                if (this.mEmojiAsDefaultStyleExceptions == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.getData().getCodepointAt(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int check(int i) {
            int reset;
            MetadataRepo.Node node = this.mCurrentNode.get(i);
            switch (this.mState) {
                case 2:
                    if (node == null) {
                        if (!isTextStyle(i)) {
                            if (!isEmojiStyle(i)) {
                                if (this.mCurrentNode.getData() == null) {
                                    reset = reset();
                                    break;
                                } else if (this.mCurrentDepth != 1) {
                                    this.mFlushNode = this.mCurrentNode;
                                    reset = 3;
                                    reset();
                                    break;
                                } else if (!shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                    reset = reset();
                                    break;
                                } else {
                                    this.mFlushNode = this.mCurrentNode;
                                    reset = 3;
                                    reset();
                                    break;
                                }
                            } else {
                                reset = 2;
                                break;
                            }
                        } else {
                            reset = reset();
                            break;
                        }
                    } else {
                        this.mCurrentNode = node;
                        this.mCurrentDepth++;
                        reset = 2;
                        break;
                    }
                default:
                    if (node != null) {
                        this.mState = 2;
                        this.mCurrentNode = node;
                        this.mCurrentDepth = 1;
                        reset = 2;
                        break;
                    } else {
                        reset = reset();
                        break;
                    }
            }
            this.mLastCodepoint = i;
            return reset;
        }

        TypefaceEmojiRasterizer getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        TypefaceEmojiRasterizer getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        boolean isInFlushableState() {
            return this.mState == 2 && this.mCurrentNode.getData() != null && (this.mCurrentDepth > 1 || shouldUseEmojiPresentationStyleForSingleCodepoint());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean z, int[] iArr, Set<int[]> set) {
        this.mSpanFactory = spanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = glyphChecker;
        this.mUseEmojiAsDefaultStyle = z;
        this.mEmojiAsDefaultStyleExceptions = iArr;
        initExclusions(set);
    }

    private static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        EmojiSpan[] emojiSpanArr;
        if (hasModifiers(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!hasInvalidSelection(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int max;
        int min;
        if (editable == null || inputConnection == null || i < 0 || i2 < 0) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (hasInvalidSelection(selectionStart, selectionEnd)) {
            return false;
        }
        if (z) {
            max = CodepointIndexFinder.findIndexBackward(editable, selectionStart, Math.max(i, 0));
            min = CodepointIndexFinder.findIndexForward(editable, selectionEnd, Math.max(i2, 0));
            if (max == -1 || min == -1) {
                return false;
            }
        } else {
            max = Math.max(selectionStart - i, 0);
            min = Math.min(selectionEnd + i2, editable.length());
        }
        EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(max, min, EmojiSpan.class);
        if (emojiSpanArr == null || emojiSpanArr.length <= 0) {
            return false;
        }
        for (EmojiSpan emojiSpan : emojiSpanArr) {
            int spanStart = editable.getSpanStart(emojiSpan);
            int spanEnd = editable.getSpanEnd(emojiSpan);
            max = Math.min(spanStart, max);
            min = Math.max(spanEnd, min);
        }
        int max2 = Math.max(max, 0);
        int min2 = Math.min(min, editable.length());
        inputConnection.beginBatchEdit();
        editable.delete(max2, min2);
        inputConnection.endBatchEdit();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean handleOnKeyDown(Editable editable, int i, KeyEvent keyEvent) {
        boolean delete;
        switch (i) {
            case 67:
                delete = delete(editable, keyEvent, false);
                break;
            case 112:
                delete = delete(editable, keyEvent, true);
                break;
            default:
                delete = false;
                break;
        }
        if (!delete) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean hasGlyph(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (typefaceEmojiRasterizer.getHasGlyph() == 0) {
            typefaceEmojiRasterizer.setHasGlyph(this.mGlyphChecker.hasGlyph(charSequence, i, i2, typefaceEmojiRasterizer.getSdkAdded()));
        }
        return typefaceEmojiRasterizer.getHasGlyph() == 2;
    }

    private static boolean hasInvalidSelection(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    private static boolean hasModifiers(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void initExclusions(Set<int[]> set) {
        if (set.isEmpty()) {
            return;
        }
        for (int[] iArr : set) {
            String str = new String(iArr, 0, iArr.length);
            process(str, 0, str.length(), 1, true, new MarkExclusionCallback(str));
        }
    }

    private <T> T process(CharSequence charSequence, int i, int i2, int i3, boolean z, EmojiProcessCallback<T> emojiProcessCallback) {
        int i4 = 0;
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int i5 = i;
        int codePointAt = Character.codePointAt(charSequence, i5);
        boolean z2 = true;
        while (i5 < i2 && i4 < i3 && z2) {
            switch (processorSm.check(codePointAt)) {
                case 1:
                    i += Character.charCount(Character.codePointAt(charSequence, i));
                    i5 = i;
                    if (i5 >= i2) {
                        break;
                    } else {
                        codePointAt = Character.codePointAt(charSequence, i5);
                        break;
                    }
                case 2:
                    i5 += Character.charCount(codePointAt);
                    if (i5 >= i2) {
                        break;
                    } else {
                        codePointAt = Character.codePointAt(charSequence, i5);
                        break;
                    }
                case 3:
                    if (z || !hasGlyph(charSequence, i, i5, processorSm.getFlushMetadata())) {
                        z2 = emojiProcessCallback.handleEmoji(charSequence, i, i5, processorSm.getFlushMetadata());
                        i4++;
                    }
                    i = i5;
                    break;
            }
        }
        if (processorSm.isInFlushableState() && i4 < i3 && z2 && (z || !hasGlyph(charSequence, i, i5, processorSm.getCurrentMetadata()))) {
            emojiProcessCallback.handleEmoji(charSequence, i, i5, processorSm.getCurrentMetadata());
            int i6 = i4 + 1;
        }
        return emojiProcessCallback.getResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEmojiEnd(CharSequence charSequence, int i) {
        if (i >= 0 && i < charSequence.length()) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i, i + 1, EmojiSpan.class);
                if (emojiSpanArr.length > 0) {
                    return spanned.getSpanEnd(emojiSpanArr[0]);
                }
            }
            return ((EmojiProcessLookupCallback) process(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(i))).end;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEmojiMatch(CharSequence charSequence) {
        return getEmojiMatch(charSequence, this.mMetadataRepo.getMetadataVersion());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0016 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getEmojiMatch(java.lang.CharSequence r10, int r11) {
        /*
            r9 = this;
            androidx.emoji2.text.EmojiProcessor$ProcessorSm r0 = new androidx.emoji2.text.EmojiProcessor$ProcessorSm
            androidx.emoji2.text.MetadataRepo r1 = r9.mMetadataRepo
            androidx.emoji2.text.MetadataRepo$Node r1 = r1.getRootNode()
            boolean r2 = r9.mUseEmojiAsDefaultStyle
            int[] r3 = r9.mEmojiAsDefaultStyleExceptions
            r0.<init>(r1, r2, r3)
            int r1 = r10.length()
            r2 = 0
            r3 = 0
            r4 = 0
        L16:
            if (r2 >= r1) goto L4d
            int r5 = java.lang.Character.codePointAt(r10, r2)
            int r6 = r0.check(r5)
            androidx.emoji2.text.TypefaceEmojiRasterizer r7 = r0.getCurrentMetadata()
            switch(r6) {
                case 1: goto L3b;
                case 2: goto L35;
                case 3: goto L28;
                default: goto L27;
            }
        L27:
            goto L42
        L28:
            androidx.emoji2.text.TypefaceEmojiRasterizer r7 = r0.getFlushMetadata()
            short r8 = r7.getCompatAdded()
            if (r8 > r11) goto L42
            int r4 = r4 + 1
            goto L42
        L35:
            int r8 = java.lang.Character.charCount(r5)
            int r2 = r2 + r8
            goto L42
        L3b:
            int r8 = java.lang.Character.charCount(r5)
            int r2 = r2 + r8
            r3 = 0
        L42:
            if (r7 == 0) goto L4c
            short r8 = r7.getCompatAdded()
            if (r8 > r11) goto L4c
            int r3 = r3 + 1
        L4c:
            goto L16
        L4d:
            r5 = 2
            if (r4 == 0) goto L51
            return r5
        L51:
            boolean r6 = r0.isInFlushableState()
            if (r6 == 0) goto L63
            androidx.emoji2.text.TypefaceEmojiRasterizer r6 = r0.getCurrentMetadata()
            short r7 = r6.getCompatAdded()
            if (r7 > r11) goto L63
            r5 = 1
            return r5
        L63:
            if (r3 != 0) goto L67
            r5 = 0
            return r5
        L67:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.getEmojiMatch(java.lang.CharSequence, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEmojiStart(CharSequence charSequence, int i) {
        if (i >= 0 && i < charSequence.length()) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i, i + 1, EmojiSpan.class);
                if (emojiSpanArr.length > 0) {
                    return spanned.getSpanStart(emojiSpanArr[0]);
                }
            }
            return ((EmojiProcessLookupCallback) process(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(i))).start;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.CharSequence process(java.lang.CharSequence r10, int r11, int r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.process(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
