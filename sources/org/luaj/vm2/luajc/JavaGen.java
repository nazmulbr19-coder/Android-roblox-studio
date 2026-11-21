package org.luaj.vm2.luajc;

import org.luaj.vm2.LocVars;
import org.luaj.vm2.Prototype;

/* loaded from: classes10.dex */
public class JavaGen {
    public final byte[] bytecode;
    public final String classname;
    public final JavaGen[] inners;

    public JavaGen(Prototype prototype, String str, String str2, boolean z) {
        this(new ProtoInfo(prototype, str), str, str2, z);
    }

    private JavaGen(ProtoInfo protoInfo, String str, String str2, boolean z) {
        this.classname = str;
        JavaBuilder javaBuilder = new JavaBuilder(protoInfo, str, str2);
        scanInstructions(protoInfo, str, javaBuilder);
        for (int i = 0; i < protoInfo.prototype.locvars.length; i++) {
            LocVars locVars = protoInfo.prototype.locvars[i];
            javaBuilder.setVarStartEnd(i, locVars.startpc, locVars.endpc, locVars.varname.tojstring());
        }
        this.bytecode = javaBuilder.completeClass(z);
        if (protoInfo.subprotos == null) {
            this.inners = null;
            return;
        }
        int length = protoInfo.subprotos.length;
        this.inners = new JavaGen[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.inners[i2] = new JavaGen(protoInfo.subprotos[i2], protoInfo.subprotos[i2].name, str2, false);
        }
    }

    private void loadLocalOrConstant(Prototype prototype, JavaBuilder javaBuilder, int i, int i2) {
        if (i2 <= 255) {
            javaBuilder.loadLocal(i, i2);
        } else {
            javaBuilder.loadConstant(prototype.k[i2 & 255]);
        }
    }

    private void loadVarargResults(JavaBuilder javaBuilder, int i, int i2, int i3) {
        if (i3 <= i2) {
            javaBuilder.loadVarresult();
            javaBuilder.subargs((i2 + 1) - i3);
        } else if (i3 == i2) {
            javaBuilder.loadVarresult();
        } else {
            javaBuilder.newVarargsVarresult(i, i2, i3 - i2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01fd, code lost:
    
        if (r10 != 0) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x020c, code lost:
    
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x020d, code lost:
    
        r5 = r9 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x020a, code lost:
    
        if (r13 == 0) goto L111;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0063. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void scanInstructions(org.luaj.vm2.luajc.ProtoInfo r18, java.lang.String r19, org.luaj.vm2.luajc.JavaBuilder r20) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.luajc.JavaGen.scanInstructions(org.luaj.vm2.luajc.ProtoInfo, java.lang.String, org.luaj.vm2.luajc.JavaBuilder):void");
    }
}
