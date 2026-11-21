package org.luaj.vm2.compiler;

/* loaded from: classes10.dex */
class InstructionPtr {
    final int[] code;
    final int idx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstructionPtr(int[] iArr, int i) {
        this.code = iArr;
        this.idx = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int get() {
        return this.code[this.idx];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(int i) {
        this.code[this.idx] = i;
    }
}
