package com.github.luben.zstd;

/* loaded from: classes.dex */
public enum EndDirective {
    CONTINUE(0),
    FLUSH(1),
    END(2);

    private final int value;

    EndDirective(int i) {
        this.value = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int value() {
        return this.value;
    }
}
