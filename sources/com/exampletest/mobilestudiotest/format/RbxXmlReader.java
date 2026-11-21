package com.exampletest.mobilestudiotest.format;

import android.util.Base64;
import android.util.Xml;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.ClassDb;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.SharedStr;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: RbxXmlReader.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00142\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0002¨\u0006\u001a"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/RbxXmlReader;", "", "<init>", "()V", "read", "Lcom/exampletest/mobilestudiotest/format/RbxDocument;", "bytes", "", "decodeB64", "s", "", "parseTree", "Lcom/exampletest/mobilestudiotest/format/RbxXmlReader$XNode;", "p", "Lorg/xmlpull/v1/XmlPullParser;", "cframe", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "n", "content", "convert", "Lkotlin/Pair;", "", "parseSpecial", "", "t", "XNode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RbxXmlReader {
    public static final RbxXmlReader INSTANCE = new RbxXmlReader();

    /* compiled from: RbxXmlReader.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00000\rj\b\u0012\u0004\u0012\u00020\u0000`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/exampletest/mobilestudiotest/format/RbxXmlReader$XNode;", "", "name", "", "attrs", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getAttrs", "()Ljava/util/Map;", "children", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getChildren", "()Ljava/util/ArrayList;", "text", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getText", "()Ljava/lang/StringBuilder;", "child", "n", "t", "f", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class XNode {
        private final Map<String, String> attrs;
        private final ArrayList<XNode> children;
        private final String name;
        private final StringBuilder text;

        public XNode(String name, Map<String, String> attrs) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            this.name = name;
            this.attrs = attrs;
            this.children = new ArrayList<>();
            this.text = new StringBuilder();
        }

        public final XNode child(String n) {
            Object obj;
            Intrinsics.checkNotNullParameter(n, "n");
            Iterator<T> it = this.children.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (StringsKt.equals(((XNode) obj).name, n, true)) {
                    break;
                }
            }
            return (XNode) obj;
        }

        public final float f(String n) {
            Intrinsics.checkNotNullParameter(n, "n");
            Float floatOrNull = StringsKt.toFloatOrNull(t(n));
            if (floatOrNull != null) {
                return floatOrNull.floatValue();
            }
            return 0.0f;
        }

        public final Map<String, String> getAttrs() {
            return this.attrs;
        }

        public final ArrayList<XNode> getChildren() {
            return this.children;
        }

        public final String getName() {
            return this.name;
        }

        public final StringBuilder getText() {
            return this.text;
        }

        public final String t(String n) {
            StringBuilder sb;
            String sb2;
            String obj;
            Intrinsics.checkNotNullParameter(n, "n");
            XNode child = child(n);
            return (child == null || (sb = child.text) == null || (sb2 = sb.toString()) == null || (obj = StringsKt.trim((CharSequence) sb2).toString()) == null) ? "" : obj;
        }
    }

    private RbxXmlReader() {
    }

    private final CFrame cframe(XNode n) {
        return new CFrame(n.f("X"), n.f("Y"), n.f("Z"), n.f("R00"), n.f("R01"), n.f("R02"), n.f("R10"), n.f("R11"), n.f("R12"), n.f("R20"), n.f("R21"), n.f("R22"));
    }

    private final String content(XNode n) {
        XNode child = n.child("url");
        if (child == null) {
            String sb = n.getText().toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            return StringsKt.trim((CharSequence) sb).toString();
        }
        String sb2 = child.getText().toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return StringsKt.trim((CharSequence) sb2).toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00db, code lost:
    
        if (r4.equals("CFrame") == false) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0722, code lost:
    
        if (r4.equals("Content") != false) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return kotlin.TuplesKt.to(16, cframe(r27));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010d, code lost:
    
        if (r4.equals("CoordinateFrame") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0123, code lost:
    
        if (r4.equals("ContentId") == false) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return kotlin.TuplesKt.to(1, content(r27));
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0046. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<java.lang.Integer, java.lang.Object> convert(com.exampletest.mobilestudiotest.format.RbxXmlReader.XNode r27) {
        /*
            Method dump skipped, instructions count: 2202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.format.RbxXmlReader.convert(com.exampletest.mobilestudiotest.format.RbxXmlReader$XNode):kotlin.Pair");
    }

    private final byte[] decodeB64(String s) {
        try {
            byte[] decode = Base64.decode(new Regex("\\s").replace(s, ""), 0);
            Intrinsics.checkNotNull(decode);
            return decode;
        } catch (Exception e) {
            return new byte[0];
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final float parseSpecial(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r3.toUpperCase(r0)
            java.lang.String r1 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case 72641: goto L29;
                case 77051: goto L1e;
                case 1413236: goto L13;
                default: goto L12;
            }
        L12:
            goto L31
        L13:
            java.lang.String r1 = "-INF"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L31
            r0 = -8388608(0xffffffffff800000, float:-Infinity)
            goto L36
        L1e:
            java.lang.String r1 = "NAN"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L31
            r0 = 2143289344(0x7fc00000, float:NaN)
            goto L36
        L29:
            java.lang.String r1 = "INF"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L32
        L31:
            goto L35
        L32:
            r0 = 2139095040(0x7f800000, float:Infinity)
            goto L36
        L35:
            r0 = 0
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.format.RbxXmlReader.parseSpecial(java.lang.String):float");
    }

    private final XNode parseTree(XmlPullParser p) {
        ArrayList arrayList = new ArrayList();
        XNode xNode = null;
        int eventType = p.getEventType();
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    HashMap hashMap = new HashMap();
                    int attributeCount = p.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        hashMap.put(p.getAttributeName(i), p.getAttributeValue(i));
                    }
                    String name = p.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    XNode xNode2 = new XNode(name, hashMap);
                    if (arrayList.isEmpty()) {
                        xNode = xNode2;
                    } else {
                        ((XNode) CollectionsKt.last((List) arrayList)).getChildren().add(xNode2);
                    }
                    arrayList.add(xNode2);
                    break;
                case 3:
                    if (arrayList.isEmpty()) {
                        break;
                    } else {
                        arrayList.remove(arrayList.size() - 1);
                        break;
                    }
                case 4:
                case 5:
                    if (arrayList.isEmpty()) {
                        break;
                    } else {
                        ((XNode) CollectionsKt.last((List) arrayList)).getText().append(p.getText());
                        break;
                    }
            }
            eventType = p.nextToken();
        }
        return xNode;
    }

    private static final void read$build(ArrayList<Instance> arrayList, HashMap<String, Instance> hashMap, ArrayList<Triple<Instance, String, String>> arrayList2, ArrayList<Triple<Instance, String, String>> arrayList3, ArrayList<String> arrayList4, XNode xNode, Instance instance) {
        ArrayList<Triple<Instance, String, String>> arrayList5;
        ArrayList<Triple<Instance, String, String>> arrayList6;
        ArrayList<XNode> children;
        ArrayList<XNode> arrayList7;
        boolean z;
        ArrayList<String> arrayList8 = arrayList4;
        String str = xNode.getAttrs().get("class");
        if (str == null) {
            str = "Folder";
        }
        Instance instance2 = new Instance(str);
        if (ClassDb.INSTANCE.isServiceName(instance2.getClassName()) && instance == null) {
            instance2.setService(true);
        }
        String str2 = xNode.getAttrs().get("referent");
        if (str2 != null) {
            hashMap.put(str2, instance2);
        }
        XNode child = xNode.child("Properties");
        if (child == null || (children = child.getChildren()) == null) {
            arrayList5 = arrayList2;
            arrayList6 = arrayList3;
        } else {
            ArrayList<XNode> arrayList9 = children;
            boolean z2 = false;
            for (XNode xNode2 : arrayList9) {
                String str3 = xNode2.getAttrs().get("name");
                if (str3 == null) {
                    arrayList7 = arrayList9;
                    z = z2;
                } else {
                    try {
                        String name = xNode2.getName();
                        if (Intrinsics.areEqual(name, "Ref")) {
                            try {
                                String sb = xNode2.getText().toString();
                                Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                                try {
                                    arrayList2.add(new Triple<>(instance2, str3, StringsKt.trim((CharSequence) sb).toString()));
                                    instance2.getPropTypes().put(str3, 19);
                                    arrayList7 = arrayList9;
                                    z = z2;
                                } catch (Exception e) {
                                    e = e;
                                    arrayList7 = arrayList9;
                                    z = z2;
                                    arrayList8.add("Bad value for " + str3 + ": " + e.getMessage());
                                    arrayList9 = arrayList7;
                                    z2 = z;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } else {
                            try {
                                if (Intrinsics.areEqual(name, "SharedString")) {
                                    String sb2 = xNode2.getText().toString();
                                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                    try {
                                        arrayList3.add(new Triple<>(instance2, str3, StringsKt.trim((CharSequence) sb2).toString()));
                                        instance2.getPropTypes().put(str3, 28);
                                        arrayList7 = arrayList9;
                                        z = z2;
                                    } catch (Exception e3) {
                                        e = e3;
                                        arrayList7 = arrayList9;
                                        z = z2;
                                        arrayList8.add("Bad value for " + str3 + ": " + e.getMessage());
                                        arrayList9 = arrayList7;
                                        z2 = z;
                                    }
                                } else {
                                    try {
                                        Pair<Integer, Object> convert = INSTANCE.convert(xNode2);
                                        int intValue = convert.component1().intValue();
                                        Object component2 = convert.component2();
                                        if (intValue == -1) {
                                            arrayList7 = arrayList9;
                                            try {
                                                z = z2;
                                            } catch (Exception e4) {
                                                e = e4;
                                                z = z2;
                                            }
                                            try {
                                                arrayList8.add("Unknown XML property type " + xNode2.getName() + " (" + str3 + ")");
                                            } catch (Exception e5) {
                                                e = e5;
                                                arrayList8.add("Bad value for " + str3 + ": " + e.getMessage());
                                                arrayList9 = arrayList7;
                                                z2 = z;
                                            }
                                        } else {
                                            arrayList7 = arrayList9;
                                            z = z2;
                                            instance2.getProps().put(str3, component2);
                                            instance2.getPropTypes().put(str3, Integer.valueOf(intValue));
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        arrayList7 = arrayList9;
                                        z = z2;
                                        arrayList8.add("Bad value for " + str3 + ": " + e.getMessage());
                                        arrayList9 = arrayList7;
                                        z2 = z;
                                    }
                                }
                            } catch (Exception e7) {
                                e = e7;
                                arrayList7 = arrayList9;
                                z = z2;
                                arrayList8.add("Bad value for " + str3 + ": " + e.getMessage());
                                arrayList9 = arrayList7;
                                z2 = z;
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                }
                arrayList9 = arrayList7;
                z2 = z;
            }
            arrayList5 = arrayList2;
            arrayList6 = arrayList3;
        }
        if (instance == null) {
            arrayList.add(instance2);
        } else {
            instance2.attachRaw(instance);
        }
        ArrayList<XNode> children2 = xNode.getChildren();
        ArrayList arrayList10 = new ArrayList();
        for (Object obj : children2) {
            ArrayList<XNode> arrayList11 = children2;
            if (Intrinsics.areEqual(((XNode) obj).getName(), "Item")) {
                arrayList10.add(obj);
            }
            children2 = arrayList11;
        }
        Iterator it = arrayList10.iterator();
        while (it.hasNext()) {
            read$build(arrayList, hashMap, arrayList5, arrayList6, arrayList8, (XNode) it.next(), instance2);
            arrayList5 = arrayList2;
            arrayList6 = arrayList3;
            arrayList8 = arrayList4;
        }
    }

    public final RbxDocument read(byte[] bytes) {
        Object obj;
        String str;
        Iterator it;
        Instance instance;
        ArrayList<XNode> children;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        newPullParser.setInput(new ByteArrayInputStream(bytes), null);
        Intrinsics.checkNotNull(newPullParser);
        XNode parseTree = parseTree(newPullParser);
        if (parseTree == null) {
            throw new RbxFormatException("Empty XML");
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it2 = parseTree.getChildren().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual(((XNode) obj).getName(), "SharedStrings")) {
                break;
            }
        }
        XNode xNode = (XNode) obj;
        String str2 = "";
        if (xNode == null || (children = xNode.getChildren()) == null) {
            str = "";
        } else {
            ArrayList<XNode> arrayList4 = children;
            for (XNode xNode2 : arrayList4) {
                HashMap hashMap3 = hashMap2;
                XmlPullParser xmlPullParser = newPullParser;
                String str3 = xNode2.getAttrs().get("md5");
                if (str3 == null) {
                    str3 = str2;
                }
                RbxXmlReader rbxXmlReader = INSTANCE;
                String str4 = str2;
                String sb = xNode2.getText().toString();
                Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                hashMap3.put(str3, rbxXmlReader.decodeB64(sb));
                newPullParser = xmlPullParser;
                arrayList4 = arrayList4;
                str2 = str4;
            }
            str = str2;
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator<XNode> it3 = parseTree.getChildren().iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            XNode next = it3.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            XNode xNode3 = next;
            String name = xNode3.getName();
            if (Intrinsics.areEqual(name, "Item")) {
                read$build(arrayList5, hashMap, arrayList2, arrayList3, arrayList, xNode3, null);
            } else if (Intrinsics.areEqual(name, "Meta")) {
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                String str5 = xNode3.getAttrs().get("name");
                if (str5 == null) {
                    str5 = str;
                }
                linkedHashMap2.put(str5, xNode3.getText().toString());
            }
        }
        Iterator it4 = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
        while (it4.hasNext()) {
            Object next2 = it4.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            Triple triple = (Triple) next2;
            Instance instance2 = (Instance) triple.component1();
            String str6 = (String) triple.component2();
            String str7 = (String) triple.component3();
            LinkedHashMap<String, Object> props = instance2.getProps();
            if (!Intrinsics.areEqual(str7, "null")) {
                if (!(str7.length() == 0)) {
                    instance = (Instance) hashMap.get(str7);
                    props.put(str6, instance);
                }
            }
            instance = null;
            props.put(str6, instance);
        }
        Iterator it5 = arrayList3.iterator();
        Intrinsics.checkNotNullExpressionValue(it5, "iterator(...)");
        while (it5.hasNext()) {
            Object next3 = it5.next();
            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
            Triple triple2 = (Triple) next3;
            Instance instance3 = (Instance) triple2.component1();
            String str8 = (String) triple2.component2();
            String str9 = (String) triple2.component3();
            LinkedHashMap<String, Object> props2 = instance3.getProps();
            byte[] bArr = (byte[]) hashMap2.get(str9);
            if (bArr == null) {
                it = it5;
                bArr = new byte[0];
            } else {
                it = it5;
            }
            props2.put(str8, new SharedStr(bArr));
            it5 = it;
        }
        return new RbxDocument(arrayList5, linkedHashMap, arrayList);
    }
}
