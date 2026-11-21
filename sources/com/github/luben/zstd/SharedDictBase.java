package com.github.luben.zstd;

/* loaded from: classes.dex */
abstract class SharedDictBase extends AutoCloseBase {
    protected void finalize() {
        close();
    }
}
