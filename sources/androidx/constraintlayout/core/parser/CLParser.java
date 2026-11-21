package androidx.constraintlayout.core.parser;

import org.luaj.vm2.parser.LuaParserConstants;

/* loaded from: classes.dex */
public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    /* loaded from: classes.dex */
    enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i, TYPE type, boolean z, char[] cArr) {
        CLElement cLElement2 = null;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (type.ordinal()) {
            case 1:
                cLElement2 = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                cLElement2 = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                cLElement2 = CLNumber.allocate(cArr);
                break;
            case 4:
                cLElement2 = CLString.allocate(cArr);
                break;
            case 5:
                cLElement2 = CLKey.allocate(cArr);
                break;
            case 6:
                cLElement2 = CLToken.allocate(cArr);
                break;
        }
        if (cLElement2 == null) {
            return null;
        }
        cLElement2.setLine(this.mLineNumber);
        if (z) {
            cLElement2.setStart(i);
        }
        if (cLElement instanceof CLContainer) {
            cLElement2.setContainer((CLContainer) cLElement);
        }
        return cLElement2;
    }

    private CLElement getNextJsonElement(int i, char c, CLElement cLElement, char[] cArr) throws CLParsingException {
        CLElement cLElement2;
        switch (c) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
            case ',':
            case LuaParserConstants.HEXNUM /* 58 */:
                cLElement2 = cLElement;
                break;
            case '\"':
            case '\'':
                return cLElement instanceof CLObject ? createElement(cLElement, i, TYPE.KEY, true, cArr) : createElement(cLElement, i, TYPE.STRING, true, cArr);
            case '+':
            case '-':
            case '.':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case LuaParserConstants.EXP /* 56 */:
            case LuaParserConstants.HEX /* 57 */:
                return createElement(cLElement, i, TYPE.NUMBER, true, cArr);
            case '/':
                cLElement2 = cLElement;
                if (i + 1 < cArr.length && cArr[i + 1] == '/') {
                    this.mHasComment = true;
                    break;
                }
                break;
            case '[':
                return createElement(cLElement, i, TYPE.ARRAY, true, cArr);
            case ']':
            case '}':
                cLElement.setEnd(i - 1);
                CLElement container = cLElement.getContainer();
                container.setEnd(i);
                return container;
            case '{':
                return createElement(cLElement, i, TYPE.OBJECT, true, cArr);
            default:
                if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                    return createElement(cLElement, i, TYPE.KEY, true, cArr);
                }
                CLElement createElement = createElement(cLElement, i, TYPE.TOKEN, true, cArr);
                CLToken cLToken = (CLToken) createElement;
                if (cLToken.validate(c, i)) {
                    return createElement;
                }
                throw new CLParsingException("incorrect token <" + c + "> at line " + this.mLineNumber, cLToken);
        }
        return cLElement2;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        int i;
        int i2;
        int i3;
        char c;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i4 = 1;
        this.mLineNumber = 1;
        int i5 = -1;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char c2 = charArray[i6];
            if (c2 == '{') {
                i5 = i6;
                break;
            }
            if (c2 == '\n') {
                this.mLineNumber++;
            }
            i6++;
        }
        if (i5 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject allocate = CLObject.allocate(charArray);
        allocate.setLine(this.mLineNumber);
        allocate.setStart(i5);
        CLElement cLElement = allocate;
        int i7 = i5 + 1;
        while (true) {
            if (i7 >= length) {
                i = i4;
                break;
            }
            char c3 = charArray[i7];
            if (c3 == '\n') {
                this.mLineNumber += i4;
            }
            if (this.mHasComment) {
                if (c3 == '\n') {
                    this.mHasComment = false;
                } else {
                    i2 = i4;
                    i3 = i5;
                    i7++;
                    i4 = i2;
                    i5 = i3;
                }
            }
            if (cLElement == null) {
                i = i4;
                break;
            }
            if (cLElement.isDone()) {
                cLElement = getNextJsonElement(i7, c3, cLElement, charArray);
                i2 = i4;
                i3 = i5;
            } else if (cLElement instanceof CLObject) {
                if (c3 == '}') {
                    cLElement.setEnd(i7 - 1);
                    i2 = i4;
                    i3 = i5;
                } else {
                    cLElement = getNextJsonElement(i7, c3, cLElement, charArray);
                    i2 = i4;
                    i3 = i5;
                }
            } else if (cLElement instanceof CLArray) {
                if (c3 == ']') {
                    cLElement.setEnd(i7 - 1);
                    i2 = i4;
                    i3 = i5;
                } else {
                    cLElement = getNextJsonElement(i7, c3, cLElement, charArray);
                    i2 = i4;
                    i3 = i5;
                }
            } else if (cLElement instanceof CLString) {
                if (charArray[(int) cLElement.mStart] == c3) {
                    cLElement.setStart(cLElement.mStart + 1);
                    cLElement.setEnd(i7 - 1);
                }
                i2 = i4;
                i3 = i5;
            } else {
                if (cLElement instanceof CLToken) {
                    CLToken cLToken = (CLToken) cLElement;
                    i2 = i4;
                    i3 = i5;
                    if (!cLToken.validate(c3, i7)) {
                        throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                    }
                } else {
                    i2 = i4;
                    i3 = i5;
                }
                if (((cLElement instanceof CLKey) || (cLElement instanceof CLString)) && (((c = charArray[(int) cLElement.mStart]) == '\'' || c == '\"') && c == c3)) {
                    cLElement.setStart(cLElement.mStart + 1);
                    cLElement.setEnd(i7 - 1);
                }
                if (!cLElement.isDone() && (c3 == '}' || c3 == ']' || c3 == ',' || c3 == ' ' || c3 == '\t' || c3 == '\r' || c3 == '\n' || c3 == ':')) {
                    cLElement.setEnd(i7 - 1);
                    if (c3 == '}' || c3 == ']') {
                        cLElement = cLElement.getContainer();
                        cLElement.setEnd(i7 - 1);
                        if (cLElement instanceof CLKey) {
                            cLElement = cLElement.getContainer();
                            cLElement.setEnd(i7 - 1);
                        }
                    }
                }
            }
            if (cLElement.isDone() && (!(cLElement instanceof CLKey) || ((CLKey) cLElement).mElements.size() > 0)) {
                cLElement = cLElement.getContainer();
            }
            i7++;
            i4 = i2;
            i5 = i3;
        }
        while (cLElement != null && !cLElement.isDone()) {
            if (cLElement instanceof CLString) {
                cLElement.setStart(((int) cLElement.mStart) + i);
            }
            cLElement.setEnd(length - 1);
            cLElement = cLElement.getContainer();
        }
        if (sDebug) {
            System.out.println("Root: " + allocate.toJSON());
        }
        return allocate;
    }
}
