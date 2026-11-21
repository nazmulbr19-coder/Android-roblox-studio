package org.luaj.vm2.parser;

/* loaded from: classes10.dex */
public class ParseException extends Exception {
    private static final long serialVersionUID = 1;
    public Token currentToken;
    protected String eol;
    public int[][] expectedTokenSequences;
    public String[] tokenImage;

    public ParseException() {
        this.eol = System.getProperty("line.separator", "\n");
    }

    public ParseException(String str) {
        super(str);
        this.eol = System.getProperty("line.separator", "\n");
    }

    public ParseException(Token token, int[][] iArr, String[] strArr) {
        super(initialise(token, iArr, strArr));
        this.eol = System.getProperty("line.separator", "\n");
        this.currentToken = token;
        this.expectedTokenSequences = iArr;
        this.tokenImage = strArr;
    }

    static String add_escapes(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 0:
                    break;
                case '\b':
                    str2 = "\\b";
                    break;
                case '\t':
                    str2 = "\\t";
                    break;
                case '\n':
                    str2 = "\\n";
                    break;
                case '\f':
                    str2 = "\\f";
                    break;
                case '\r':
                    str2 = "\\r";
                    break;
                case '\"':
                    str2 = "\\\"";
                    break;
                case '\'':
                    str2 = "\\'";
                    break;
                case '\\':
                    str2 = "\\\\";
                    break;
                default:
                    char charAt = str.charAt(i);
                    if (charAt < ' ' || charAt > '~') {
                        String stringBuffer2 = new StringBuffer().append("0000").append(Integer.toString(charAt, 16)).toString();
                        str2 = new StringBuffer().append("\\u").append(stringBuffer2.substring(stringBuffer2.length() - 4, stringBuffer2.length())).toString();
                        break;
                    } else {
                        stringBuffer.append(charAt);
                        break;
                    }
                    break;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    private static String initialise(Token token, int[][] iArr, String[] strArr) {
        StringBuffer append;
        String str;
        String property = System.getProperty("line.separator", "\n");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i < iArr[i2].length) {
                i = iArr[i2].length;
            }
            for (int i3 = 0; i3 < iArr[i2].length; i3++) {
                stringBuffer.append(strArr[iArr[i2][i3]]).append(' ');
            }
            if (iArr[i2][iArr[i2].length - 1] != 0) {
                stringBuffer.append("...");
            }
            stringBuffer.append(property).append("    ");
        }
        Token token2 = token.next;
        String str2 = "Encountered \"";
        int i4 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            }
            if (i4 != 0) {
                str2 = new StringBuffer().append(str2).append(" ").toString();
            }
            if (token2.kind == 0) {
                str2 = new StringBuffer().append(str2).append(strArr[0]).toString();
                break;
            }
            str2 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str2).append(" ").append(strArr[token2.kind]).toString()).append(" \"").toString()).append(add_escapes(token2.image)).toString()).append(" \"").toString();
            token2 = token2.next;
            i4++;
        }
        String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(str2).append("\" at line ").append(token.next.beginLine).append(", column ").append(token.next.beginColumn).toString()).append(".").append(property).toString();
        if (iArr.length == 1) {
            append = new StringBuffer().append(stringBuffer2);
            str = "Was expecting:";
        } else {
            append = new StringBuffer().append(stringBuffer2);
            str = "Was expecting one of:";
        }
        return new StringBuffer().append(append.append(str).append(property).append("    ").toString()).append(stringBuffer.toString()).toString();
    }
}
