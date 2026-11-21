package com.google.android.material.color;

import android.content.Context;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.UByte;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* loaded from: classes.dex */
final class ColorResourcesTableCreator {
    private static final byte ANDROID_PACKAGE_ID = 1;
    private static final byte APPLICATION_PACKAGE_ID = Byte.MAX_VALUE;
    private static final short HEADER_TYPE_PACKAGE = 512;
    private static final short HEADER_TYPE_RES_TABLE = 2;
    private static final short HEADER_TYPE_STRING_POOL = 1;
    private static final short HEADER_TYPE_TYPE = 513;
    private static final short HEADER_TYPE_TYPE_SPEC = 514;
    private static final String RESOURCE_TYPE_NAME_COLOR = "color";
    private static byte typeIdColor;
    private static final PackageInfo ANDROID_PACKAGE_INFO = new PackageInfo(1, "android");
    private static final Comparator<ColorResource> COLOR_RESOURCE_COMPARATOR = new AnonymousClass1();

    /* renamed from: com.google.android.material.color.ColorResourcesTableCreator$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Comparator<ColorResource> {
        AnonymousClass1() {
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ColorResource colorResource, ColorResource colorResource2) {
            return ColorResource.access$000(colorResource) - ColorResource.access$000(colorResource2);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ColorResource colorResource, ColorResource colorResource2) {
            return compare2(colorResource, colorResource2);
        }
    }

    /* loaded from: classes.dex */
    static class ColorResource {
        private final short entryId;
        private final String name;
        private final byte packageId;
        private final byte typeId;
        private final int value;

        ColorResource(int i, String str, int i2) {
            this.name = str;
            this.value = i2;
            this.entryId = (short) (65535 & i);
            this.typeId = (byte) ((i >> 16) & 255);
            this.packageId = (byte) ((i >> 24) & 255);
        }

        static /* synthetic */ short access$000(ColorResource colorResource) {
            return colorResource.entryId;
        }

        static /* synthetic */ String access$100(ColorResource colorResource) {
            return colorResource.name;
        }

        static /* synthetic */ int access$1400(ColorResource colorResource) {
            return colorResource.value;
        }

        static /* synthetic */ byte access$200(ColorResource colorResource) {
            return colorResource.typeId;
        }

        static /* synthetic */ byte access$300(ColorResource colorResource) {
            return colorResource.packageId;
        }
    }

    /* loaded from: classes.dex */
    private static class PackageChunk {
        private static final short HEADER_SIZE = 288;
        private static final int PACKAGE_NAME_MAX_LENGTH = 128;
        private final ResChunkHeader header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_PACKAGE, HEADER_SIZE, getChunkSize());
        private final StringPoolChunk keyStrings;
        private final PackageInfo packageInfo;
        private final TypeSpecChunk typeSpecChunk;
        private final StringPoolChunk typeStrings;

        PackageChunk(PackageInfo packageInfo, List<ColorResource> list) {
            this.packageInfo = packageInfo;
            this.typeStrings = new StringPoolChunk(false, generateTypeStrings(list));
            this.keyStrings = new StringPoolChunk(true, generateKeyStrings(list));
            this.typeSpecChunk = new TypeSpecChunk(list);
        }

        private String[] generateKeyStrings(List<ColorResource> list) {
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = ColorResource.access$100(list.get(i));
            }
            return strArr;
        }

        private String[] generateTypeStrings(List<ColorResource> list) {
            if (list.isEmpty()) {
                return new String[0];
            }
            int access$200 = ColorResource.access$200(list.get(0));
            String[] strArr = new String[access$200];
            for (int i = 0; i < access$200 - 1; i++) {
                strArr[i] = "?" + (i + 1);
            }
            strArr[access$200 - 1] = "color";
            return strArr;
        }

        int getChunkSize() {
            return this.typeStrings.getChunkSize() + 288 + this.keyStrings.getChunkSize() + this.typeSpecChunk.getChunkSizeWithTypeChunk();
        }

        void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(PackageInfo.access$1000(this.packageInfo)));
            char[] charArray = PackageInfo.access$1100(this.packageInfo).toCharArray();
            for (int i = 0; i < 128; i++) {
                if (i < charArray.length) {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.access$1200(charArray[i]));
                } else {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.access$1200((char) 0));
                }
            }
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(288));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.typeStrings.getChunkSize() + 288));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(0));
            this.typeStrings.writeTo(byteArrayOutputStream);
            this.keyStrings.writeTo(byteArrayOutputStream);
            this.typeSpecChunk.writeTo(byteArrayOutputStream);
        }
    }

    /* loaded from: classes.dex */
    static class PackageInfo {
        private final int id;
        private final String name;

        PackageInfo(int i, String str) {
            this.id = i;
            this.name = str;
        }

        static /* synthetic */ int access$1000(PackageInfo packageInfo) {
            return packageInfo.id;
        }

        static /* synthetic */ String access$1100(PackageInfo packageInfo) {
            return packageInfo.name;
        }
    }

    /* loaded from: classes.dex */
    private static class ResChunkHeader {
        private final int chunkSize;
        private final short headerSize;
        private final short type;

        ResChunkHeader(short s, short s2, int i) {
            this.type = s;
            this.headerSize = s2;
            this.chunkSize = i;
        }

        void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$600(this.type));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$600(this.headerSize));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.chunkSize));
        }
    }

    /* loaded from: classes.dex */
    private static class ResEntry {
        private static final byte DATA_TYPE_AARRGGBB = 28;
        private static final short ENTRY_SIZE = 8;
        private static final short FLAG_PUBLIC = 2;
        private static final int SIZE = 16;
        private static final short VALUE_SIZE = 8;
        private final int data;
        private final int keyStringIndex;

        ResEntry(int i, int i2) {
            this.keyStringIndex = i;
            this.data = i2;
        }

        void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$600((short) 8));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$600(FLAG_PUBLIC));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.keyStringIndex));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$600((short) 8));
            byteArrayOutputStream.write(new byte[]{0, DATA_TYPE_AARRGGBB});
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.data));
        }
    }

    /* loaded from: classes.dex */
    private static class ResTable {
        private static final short HEADER_SIZE = 12;
        private final ResChunkHeader header;
        private final int packageCount;
        private final List<PackageChunk> packageChunks = new ArrayList();
        private final StringPoolChunk stringPool = new StringPoolChunk(new String[0]);

        ResTable(Map<PackageInfo, List<ColorResource>> map) {
            this.packageCount = map.size();
            for (Map.Entry<PackageInfo, List<ColorResource>> entry : map.entrySet()) {
                List<ColorResource> value = entry.getValue();
                Collections.sort(value, ColorResourcesTableCreator.access$400());
                this.packageChunks.add(new PackageChunk(entry.getKey(), value));
            }
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_RES_TABLE, HEADER_SIZE, getOverallSize());
        }

        private int getOverallSize() {
            int i = 0;
            Iterator<PackageChunk> it = this.packageChunks.iterator();
            while (it.hasNext()) {
                i += it.next().getChunkSize();
            }
            return this.stringPool.getChunkSize() + 12 + i;
        }

        void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.packageCount));
            this.stringPool.writeTo(byteArrayOutputStream);
            Iterator<PackageChunk> it = this.packageChunks.iterator();
            while (it.hasNext()) {
                it.next().writeTo(byteArrayOutputStream);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class StringPoolChunk {
        private static final int FLAG_UTF8 = 256;
        private static final short HEADER_SIZE = 28;
        private static final int STYLED_SPAN_LIST_END = -1;
        private final int chunkSize;
        private final ResChunkHeader header;
        private final int stringCount;
        private final List<Integer> stringIndex;
        private final List<byte[]> strings;
        private final int stringsPaddingSize;
        private final int stringsStart;
        private final int styledSpanCount;
        private final List<Integer> styledSpanIndex;
        private final List<List<StringStyledSpan>> styledSpans;
        private final int styledSpansStart;
        private final boolean utf8Encode;

        StringPoolChunk(boolean z, String... strArr) {
            this.stringIndex = new ArrayList();
            this.styledSpanIndex = new ArrayList();
            this.strings = new ArrayList();
            this.styledSpans = new ArrayList();
            this.utf8Encode = z;
            int i = 0;
            for (String str : strArr) {
                Pair<byte[], List<StringStyledSpan>> processString = processString(str);
                this.stringIndex.add(Integer.valueOf(i));
                i += ((byte[]) processString.first).length;
                this.strings.add((byte[]) processString.first);
                this.styledSpans.add((List) processString.second);
            }
            int i2 = 0;
            for (List<StringStyledSpan> list : this.styledSpans) {
                for (StringStyledSpan stringStyledSpan : list) {
                    this.stringIndex.add(Integer.valueOf(i));
                    i += StringStyledSpan.access$700(stringStyledSpan).length;
                    this.strings.add(StringStyledSpan.access$700(stringStyledSpan));
                }
                this.styledSpanIndex.add(Integer.valueOf(i2));
                i2 += (list.size() * 12) + 4;
            }
            int i3 = i % 4;
            this.stringsPaddingSize = i3 == 0 ? 0 : 4 - i3;
            this.stringCount = this.strings.size();
            this.styledSpanCount = this.strings.size() - strArr.length;
            boolean z2 = this.strings.size() - strArr.length > 0;
            if (!z2) {
                this.styledSpanIndex.clear();
                this.styledSpans.clear();
            }
            this.stringsStart = (this.stringCount * 4) + 28 + (this.styledSpanIndex.size() * 4);
            int i4 = this.stringsPaddingSize + i;
            this.styledSpansStart = z2 ? this.stringsStart + i4 : 0;
            this.chunkSize = this.stringsStart + i4 + (z2 ? i2 : 0);
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_STRING_POOL, HEADER_SIZE, this.chunkSize);
        }

        StringPoolChunk(String... strArr) {
            this(false, strArr);
        }

        private Pair<byte[], List<StringStyledSpan>> processString(String str) {
            return new Pair<>(this.utf8Encode ? ColorResourcesTableCreator.access$800(str) : ColorResourcesTableCreator.access$900(str), Collections.emptyList());
        }

        int getChunkSize() {
            return this.chunkSize;
        }

        void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.stringCount));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.styledSpanCount));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.utf8Encode ? 256 : 0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.stringsStart));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.styledSpansStart));
            Iterator<Integer> it = this.stringIndex.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(it.next().intValue()));
            }
            Iterator<Integer> it2 = this.styledSpanIndex.iterator();
            while (it2.hasNext()) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(it2.next().intValue()));
            }
            Iterator<byte[]> it3 = this.strings.iterator();
            while (it3.hasNext()) {
                byteArrayOutputStream.write(it3.next());
            }
            if (this.stringsPaddingSize > 0) {
                byteArrayOutputStream.write(new byte[this.stringsPaddingSize]);
            }
            Iterator<List<StringStyledSpan>> it4 = this.styledSpans.iterator();
            while (it4.hasNext()) {
                Iterator<StringStyledSpan> it5 = it4.next().iterator();
                while (it5.hasNext()) {
                    it5.next().writeTo(byteArrayOutputStream);
                }
                byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(-1));
            }
        }
    }

    /* loaded from: classes.dex */
    private static class StringStyledSpan {
        private int firstCharacterIndex;
        private int lastCharacterIndex;
        private int nameReference;
        private byte[] styleString;

        private StringStyledSpan() {
        }

        static /* synthetic */ byte[] access$700(StringStyledSpan stringStyledSpan) {
            return stringStyledSpan.styleString;
        }

        void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.nameReference));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.firstCharacterIndex));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.lastCharacterIndex));
        }
    }

    /* loaded from: classes.dex */
    private static class TypeChunk {
        private static final byte CONFIG_SIZE = 64;
        private static final short HEADER_SIZE = 84;
        private static final int OFFSET_NO_ENTRY = -1;
        private final byte[] config = new byte[64];
        private final int entryCount;
        private final ResChunkHeader header;
        private final int[] offsetTable;
        private final ResEntry[] resEntries;

        TypeChunk(List<ColorResource> list, Set<Short> set, int i) {
            this.entryCount = i;
            this.config[0] = CONFIG_SIZE;
            this.resEntries = new ResEntry[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.resEntries[i2] = new ResEntry(i2, ColorResource.access$1400(list.get(i2)));
            }
            this.offsetTable = new int[i];
            int i3 = 0;
            for (short s = 0; s < i; s = (short) (s + ColorResourcesTableCreator.HEADER_TYPE_STRING_POOL)) {
                if (set.contains(Short.valueOf(s))) {
                    this.offsetTable[s] = i3;
                    i3 += 16;
                } else {
                    this.offsetTable[s] = -1;
                }
            }
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_TYPE, HEADER_SIZE, getChunkSize());
        }

        private int getEntryStart() {
            return getOffsetTableSize() + 84;
        }

        private int getOffsetTableSize() {
            return this.offsetTable.length * 4;
        }

        int getChunkSize() {
            return getEntryStart() + (this.resEntries.length * 16);
        }

        void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.access$1300(), 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.entryCount));
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(getEntryStart()));
            byteArrayOutputStream.write(this.config);
            for (int i : this.offsetTable) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(i));
            }
            for (ResEntry resEntry : this.resEntries) {
                resEntry.writeTo(byteArrayOutputStream);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class TypeSpecChunk {
        private static final short HEADER_SIZE = 16;
        private static final int SPEC_PUBLIC = 1073741824;
        private final int entryCount;
        private final int[] entryFlags;
        private final ResChunkHeader header;
        private final TypeChunk typeChunk;

        TypeSpecChunk(List<ColorResource> list) {
            this.entryCount = ColorResource.access$000(list.get(list.size() - 1)) + ColorResourcesTableCreator.HEADER_TYPE_STRING_POOL;
            HashSet hashSet = new HashSet();
            Iterator<ColorResource> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(Short.valueOf(ColorResource.access$000(it.next())));
            }
            this.entryFlags = new int[this.entryCount];
            for (short s = 0; s < this.entryCount; s = (short) (s + ColorResourcesTableCreator.HEADER_TYPE_STRING_POOL)) {
                if (hashSet.contains(Short.valueOf(s))) {
                    this.entryFlags[s] = 1073741824;
                }
            }
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_TYPE_SPEC, HEADER_SIZE, getChunkSize());
            this.typeChunk = new TypeChunk(list, hashSet, this.entryCount);
        }

        private int getChunkSize() {
            return (this.entryCount * 4) + 16;
        }

        int getChunkSizeWithTypeChunk() {
            return getChunkSize() + this.typeChunk.getChunkSize();
        }

        void writeTo(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.header.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.access$1300(), 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(this.entryCount));
            for (int i : this.entryFlags) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.access$500(i));
            }
            this.typeChunk.writeTo(byteArrayOutputStream);
        }
    }

    private ColorResourcesTableCreator() {
    }

    static /* synthetic */ byte[] access$1200(char c) {
        return charToByteArray(c);
    }

    static /* synthetic */ byte access$1300() {
        return typeIdColor;
    }

    static /* synthetic */ Comparator access$400() {
        return COLOR_RESOURCE_COMPARATOR;
    }

    static /* synthetic */ byte[] access$500(int i) {
        return intToByteArray(i);
    }

    static /* synthetic */ byte[] access$600(short s) {
        return shortToByteArray(s);
    }

    static /* synthetic */ byte[] access$800(String str) {
        return stringToByteArrayUtf8(str);
    }

    static /* synthetic */ byte[] access$900(String str) {
        return stringToByteArray(str);
    }

    private static byte[] charToByteArray(char c) {
        return new byte[]{(byte) (c & 255), (byte) ((c >> '\b') & 255)};
    }

    private static byte[] concat(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
            i2 += bArr4.length;
        }
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] create(Context context, Map<Integer, Integer> map) throws IOException {
        PackageInfo packageInfo;
        if (map.entrySet().isEmpty()) {
            throw new IllegalArgumentException("No color resources provided for harmonization.");
        }
        PackageInfo packageInfo2 = new PackageInfo(WorkQueueKt.MASK, context.getPackageName());
        HashMap hashMap = new HashMap();
        ColorResource colorResource = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            colorResource = new ColorResource(entry.getKey().intValue(), context.getResources().getResourceEntryName(entry.getKey().intValue()), entry.getValue().intValue());
            if (!context.getResources().getResourceTypeName(entry.getKey().intValue()).equals("color")) {
                throw new IllegalArgumentException("Non color resource found: name=" + ColorResource.access$100(colorResource) + ", typeId=" + Integer.toHexString(ColorResource.access$200(colorResource) & UByte.MAX_VALUE));
            }
            if (ColorResource.access$300(colorResource) == 1) {
                packageInfo = ANDROID_PACKAGE_INFO;
            } else {
                if (ColorResource.access$300(colorResource) != Byte.MAX_VALUE) {
                    throw new IllegalArgumentException("Not supported with unknown package id: " + ((int) ColorResource.access$300(colorResource)));
                }
                packageInfo = packageInfo2;
            }
            if (!hashMap.containsKey(packageInfo)) {
                hashMap.put(packageInfo, new ArrayList());
            }
            ((List) hashMap.get(packageInfo)).add(colorResource);
        }
        typeIdColor = ColorResource.access$200(colorResource);
        if (typeIdColor == 0) {
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ResTable(hashMap).writeTo(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] encodeLengthUtf8(short s) {
        return s > 127 ? new byte[]{(byte) (((s >> 8) & WorkQueueKt.MASK) | 128), (byte) (s & 255)} : new byte[]{(byte) (s & 255)};
    }

    private static byte[] intToByteArray(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    private static byte[] shortToByteArray(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255)};
    }

    private static byte[] stringToByteArray(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[(charArray.length * 2) + 4];
        byte[] shortToByteArray = shortToByteArray((short) charArray.length);
        bArr[0] = shortToByteArray[0];
        bArr[1] = shortToByteArray[1];
        for (int i = 0; i < charArray.length; i++) {
            byte[] charToByteArray = charToByteArray(charArray[i]);
            bArr[(i * 2) + 2] = charToByteArray[0];
            bArr[(i * 2) + 3] = charToByteArray[1];
        }
        bArr[bArr.length - 2] = 0;
        bArr[bArr.length - 1] = 0;
        return bArr;
    }

    private static byte[] stringToByteArrayUtf8(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return concat(encodeLengthUtf8((short) str.length()), encodeLengthUtf8((short) bytes.length), bytes, new byte[]{0});
    }
}
