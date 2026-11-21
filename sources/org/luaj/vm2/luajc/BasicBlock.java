package org.luaj.vm2.luajc;

import java.util.Vector;
import org.luaj.vm2.Prototype;

/* loaded from: classes10.dex */
public class BasicBlock {
    boolean islive;
    BasicBlock[] next;
    int pc0;
    int pc1;
    BasicBlock[] prev;

    /* loaded from: classes10.dex */
    private static final class AllocAndXRefVisitor extends BranchVisitor {
        private final BasicBlock[] blocks;
        private final int[] nnext;
        private final int[] nprev;

        private AllocAndXRefVisitor(boolean[] zArr, int[] iArr, int[] iArr2, BasicBlock[] basicBlockArr) {
            super(zArr);
            this.nnext = iArr;
            this.nprev = iArr2;
            this.blocks = basicBlockArr;
        }

        /* synthetic */ AllocAndXRefVisitor(boolean[] zArr, int[] iArr, int[] iArr2, BasicBlock[] basicBlockArr, AnonymousClass1 anonymousClass1) {
            this(zArr, iArr, iArr2, basicBlockArr);
        }

        @Override // org.luaj.vm2.luajc.BasicBlock.BranchVisitor
        public void visitBranch(int i, int i2) {
            if (this.blocks[i].next == null) {
                this.blocks[i].next = new BasicBlock[this.nnext[i]];
            }
            if (this.blocks[i2].prev == null) {
                this.blocks[i2].prev = new BasicBlock[this.nprev[i2]];
            }
            BasicBlock[] basicBlockArr = this.blocks[i].next;
            int[] iArr = this.nnext;
            int i3 = iArr[i] - 1;
            iArr[i] = i3;
            basicBlockArr[i3] = this.blocks[i2];
            BasicBlock[] basicBlockArr2 = this.blocks[i2].prev;
            int[] iArr2 = this.nprev;
            int i4 = iArr2[i2] - 1;
            iArr2[i2] = i4;
            basicBlockArr2[i4] = this.blocks[i];
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class BranchVisitor {
        final boolean[] isbeg;

        public BranchVisitor(boolean[] zArr) {
            this.isbeg = zArr;
        }

        public void visitBranch(int i, int i2) {
        }

        public void visitReturn(int i) {
        }
    }

    /* loaded from: classes10.dex */
    private static final class CountPrevNextVistor extends BranchVisitor {
        private final int[] nnext;
        private final int[] nprev;

        private CountPrevNextVistor(boolean[] zArr, int[] iArr, int[] iArr2) {
            super(zArr);
            this.nnext = iArr;
            this.nprev = iArr2;
        }

        /* synthetic */ CountPrevNextVistor(boolean[] zArr, int[] iArr, int[] iArr2, AnonymousClass1 anonymousClass1) {
            this(zArr, iArr, iArr2);
        }

        @Override // org.luaj.vm2.luajc.BasicBlock.BranchVisitor
        public void visitBranch(int i, int i2) {
            int[] iArr = this.nnext;
            iArr[i] = iArr[i] + 1;
            int[] iArr2 = this.nprev;
            iArr2[i2] = iArr2[i2] + 1;
        }
    }

    /* loaded from: classes10.dex */
    private static final class MarkAndMergeVisitor extends BranchVisitor {
        private final boolean[] isend;

        private MarkAndMergeVisitor(boolean[] zArr, boolean[] zArr2) {
            super(zArr);
            this.isend = zArr2;
        }

        /* synthetic */ MarkAndMergeVisitor(boolean[] zArr, boolean[] zArr2, AnonymousClass1 anonymousClass1) {
            this(zArr, zArr2);
        }

        @Override // org.luaj.vm2.luajc.BasicBlock.BranchVisitor
        public void visitBranch(int i, int i2) {
            this.isend[i] = true;
            this.isbeg[i2] = true;
        }

        @Override // org.luaj.vm2.luajc.BasicBlock.BranchVisitor
        public void visitReturn(int i) {
            this.isend[i] = true;
        }
    }

    public BasicBlock(Prototype prototype, int i) {
        this.pc1 = i;
        this.pc0 = i;
    }

    public static BasicBlock[] findBasicBlocks(Prototype prototype) {
        int i;
        int length = prototype.code.length;
        boolean[] zArr = new boolean[length];
        boolean[] zArr2 = new boolean[length];
        int i2 = 0;
        zArr[0] = true;
        MarkAndMergeVisitor markAndMergeVisitor = new MarkAndMergeVisitor(zArr, zArr2, null);
        visitBranches(prototype, markAndMergeVisitor);
        visitBranches(prototype, markAndMergeVisitor);
        BasicBlock[] basicBlockArr = new BasicBlock[length];
        while (i2 < length) {
            zArr[i2] = true;
            BasicBlock basicBlock = new BasicBlock(prototype, i2);
            basicBlockArr[i2] = basicBlock;
            while (!zArr2[i2] && (i = i2 + 1) < length && !zArr[i]) {
                basicBlock.pc1 = i;
                basicBlockArr[i] = basicBlock;
                i2 = i;
            }
            i2++;
        }
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        visitBranches(prototype, new CountPrevNextVistor(zArr, iArr, iArr2, null));
        visitBranches(prototype, new AllocAndXRefVisitor(zArr, iArr, iArr2, basicBlockArr, null));
        return basicBlockArr;
    }

    public static BasicBlock[] findLiveBlocks(BasicBlock[] basicBlockArr) {
        Vector vector = new Vector();
        int i = 0;
        vector.addElement(basicBlockArr[0]);
        while (!vector.isEmpty()) {
            BasicBlock basicBlock = (BasicBlock) vector.elementAt(0);
            vector.removeElementAt(0);
            if (!basicBlock.islive) {
                basicBlock.islive = true;
                int length = basicBlock.next != null ? basicBlock.next.length : 0;
                for (int i2 = 0; i2 < length; i2++) {
                    if (!basicBlock.next[i2].islive) {
                        vector.addElement(basicBlock.next[i2]);
                    }
                }
            }
        }
        Vector vector2 = new Vector();
        while (i < basicBlockArr.length) {
            if (basicBlockArr[i].islive) {
                vector2.addElement(basicBlockArr[i]);
            }
            i = basicBlockArr[i].pc1 + 1;
        }
        BasicBlock[] basicBlockArr2 = new BasicBlock[vector2.size()];
        vector2.copyInto(basicBlockArr2);
        return basicBlockArr2;
    }

    private String str(BasicBlock[] basicBlockArr, int i) {
        if (basicBlockArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        int length = basicBlockArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf((i == 1 ? basicBlockArr[i2].pc1 : basicBlockArr[i2].pc0) + 1));
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void visitBranches(org.luaj.vm2.Prototype r5, org.luaj.vm2.luajc.BasicBlock.BranchVisitor r6) {
        /*
            int[] r5 = r5.code
            int r0 = r5.length
            r1 = 0
        L4:
            if (r1 >= r0) goto La0
            r2 = r5[r1]
            int r3 = org.luaj.vm2.Lua.GET_OPCODE(r2)
            r4 = 23
            switch(r3) {
                case 3: goto L66;
                case 23: goto L5b;
                case 24: goto L25;
                case 25: goto L25;
                case 26: goto L25;
                case 27: goto L25;
                case 28: goto L25;
                case 30: goto L20;
                case 31: goto L20;
                case 32: goto L13;
                case 33: goto L5b;
                case 35: goto L13;
                default: goto L11;
            }
        L11:
            goto L92
        L13:
            int r2 = org.luaj.vm2.Lua.GETARG_sBx(r2)
            int r2 = r2 + r1
            int r2 = r2 + 1
            r6.visitBranch(r1, r2)
            int r2 = r1 + 1
            goto L62
        L20:
            r6.visitReturn(r1)
            goto L9c
        L25:
            int r2 = r1 + 1
            r3 = r5[r2]
            int r3 = org.luaj.vm2.Lua.GET_OPCODE(r3)
            if (r3 != r4) goto L42
            r1 = r5[r2]
            int r1 = org.luaj.vm2.Lua.GETARG_sBx(r1)
            int r1 = r1 + r2
            int r1 = r1 + 1
            r6.visitBranch(r2, r1)
            int r1 = r2 + 1
            r6.visitBranch(r2, r1)
            r1 = r2
            goto L9c
        L42:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            java.lang.String r0 = "test not followed by jump at "
            java.lang.StringBuffer r6 = r6.append(r0)
            java.lang.StringBuffer r6 = r6.append(r1)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L5b:
            int r2 = org.luaj.vm2.Lua.GETARG_sBx(r2)
            int r2 = r2 + r1
            int r2 = r2 + 1
        L62:
            r6.visitBranch(r1, r2)
            goto L9c
        L66:
            int r2 = org.luaj.vm2.Lua.GETARG_C(r2)
            if (r2 == 0) goto L92
            int r2 = r1 + 1
            r2 = r5[r2]
            int r2 = org.luaj.vm2.Lua.GET_OPCODE(r2)
            if (r2 == r4) goto L79
            int r2 = r1 + 2
            goto L62
        L79:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            java.lang.String r0 = "OP_LOADBOOL followed by jump at "
            java.lang.StringBuffer r6 = r6.append(r0)
            java.lang.StringBuffer r6 = r6.append(r1)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L92:
            int r2 = r1 + 1
            if (r2 >= r0) goto L9c
            boolean[] r3 = r6.isbeg
            boolean r3 = r3[r2]
            if (r3 != 0) goto L62
        L9c:
            int r1 = r1 + 1
            goto L4
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.luajc.BasicBlock.visitBranches(org.luaj.vm2.Prototype, org.luaj.vm2.luajc.BasicBlock$BranchVisitor):void");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append(this.pc0 + 1).append("-").append(this.pc1 + 1).append(this.prev != null ? new StringBuffer().append("  prv: ").append(str(this.prev, 1)).toString() : "").append(this.next != null ? new StringBuffer().append("  nxt: ").append(str(this.next, 0)).toString() : "").append("\n").toString());
        return stringBuffer.toString();
    }
}
