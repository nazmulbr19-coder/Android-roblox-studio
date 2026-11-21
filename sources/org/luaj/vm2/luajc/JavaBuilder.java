package org.luaj.vm2.luajc;

import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;
import org.apache.bcel.generic.AASTORE;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.ANEWARRAY;
import org.apache.bcel.generic.ASTORE;
import org.apache.bcel.generic.ArrayInstruction;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.BranchInstruction;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.CompoundInstruction;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.FieldGen;
import org.apache.bcel.generic.GOTO;
import org.apache.bcel.generic.IFEQ;
import org.apache.bcel.generic.IFNE;
import org.apache.bcel.generic.Instruction;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.InvokeInstruction;
import org.apache.bcel.generic.LocalVariableGen;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.PUSH;
import org.apache.bcel.generic.Type;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;

/* loaded from: classes10.dex */
public class JavaBuilder {
    private static final String[][] ARG_NAMES_N;
    private static final Type[] ARG_TYPES_BUFFER;
    private static final Type[] ARG_TYPES_CHARARRAY;
    private static final Type[] ARG_TYPES_DOUBLE;
    private static final Type[] ARG_TYPES_INT;
    private static final Type[] ARG_TYPES_INT_INT;
    private static final Type[] ARG_TYPES_INT_LUAVALUE;
    private static final Type[] ARG_TYPES_INT_VARARGS;
    private static final Type[] ARG_TYPES_LUAVALUE;
    private static final Type[] ARG_TYPES_LUAVALUEARRAY;
    private static final Type[] ARG_TYPES_LUAVALUEARRAY_VARARGS;
    private static final Type[] ARG_TYPES_LUAVALUE_LUAVALUE;
    private static final Type[] ARG_TYPES_LUAVALUE_LUAVALUE_LUAVALUE;
    private static final Type[] ARG_TYPES_LUAVALUE_LUAVALUE_VARARGS;
    private static final Type[] ARG_TYPES_LUAVALUE_STRINGARRAY;
    private static final Type[] ARG_TYPES_LUAVALUE_VARARGS;
    private static final Type[][] ARG_TYPES_N;
    private static final Type[] ARG_TYPES_NONE;
    private static final Type[] ARG_TYPES_STRING;
    private static final Type[] ARG_TYPES_STRINGARRAY;
    private static final Type[] ARG_TYPES_VARARGS;
    public static final int BRANCH_GOTO = 1;
    public static final int BRANCH_IFEQ = 3;
    public static final int BRANCH_IFNE = 2;
    private static final String[] METH_NAME_N;
    private static final String NAME_VARRESULT = "v";
    private static final String PREFIX_CONSTANT = "k";
    private static final String PREFIX_PLAIN_SLOT = "s";
    private static final String PREFIX_UPVALUE = "u";
    private static final String PREFIX_UPVALUE_SLOT = "a";
    private static final ObjectType[] RETURN_TYPE_N;
    private static final String STR_BUFFER;
    private static final String STR_FUNC0;
    private static final String STR_FUNC1;
    private static final String STR_FUNC2;
    private static final String STR_FUNC3;
    private static final String STR_FUNCV;
    private static final String STR_JSEPLATFORM = "org.luaj.vm2.lib.jse.JsePlatform";
    private static final String STR_LUABOOLEAN;
    private static final String STR_LUAINTEGER;
    private static final String STR_LUANUMBER;
    private static final String STR_LUASTRING;
    private static final String STR_LUATABLE;
    private static final String STR_LUAVALUE;
    private static final String STR_STRING;
    private static final String STR_VARARGS;
    private static int SUPERTYPE_VARARGS;
    private static final String[] SUPER_NAME_N;
    private static final ObjectType TYPE_BUFFER;
    private static final ArrayType TYPE_CHARARRAY;
    private static final ArrayType TYPE_LOCALUPVALUE;
    private static final ObjectType TYPE_LUABOOLEAN;
    private static final ObjectType TYPE_LUAINTEGER;
    private static final ObjectType TYPE_LUANUMBER;
    private static final ObjectType TYPE_LUASTRING;
    private static final ObjectType TYPE_LUATABLE;
    private static final ObjectType TYPE_LUAVALUE;
    private static final ObjectType TYPE_STRING;
    private static final ArrayType TYPE_STRINGARRAY;
    private static final ObjectType TYPE_VARARGS;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$luaj$vm2$Buffer;
    static /* synthetic */ Class class$org$luaj$vm2$LuaBoolean;
    static /* synthetic */ Class class$org$luaj$vm2$LuaInteger;
    static /* synthetic */ Class class$org$luaj$vm2$LuaNumber;
    static /* synthetic */ Class class$org$luaj$vm2$LuaString;
    static /* synthetic */ Class class$org$luaj$vm2$LuaTable;
    static /* synthetic */ Class class$org$luaj$vm2$LuaValue;
    static /* synthetic */ Class class$org$luaj$vm2$Varargs;
    static /* synthetic */ Class class$org$luaj$vm2$lib$OneArgFunction;
    static /* synthetic */ Class class$org$luaj$vm2$lib$ThreeArgFunction;
    static /* synthetic */ Class class$org$luaj$vm2$lib$TwoArgFunction;
    static /* synthetic */ Class class$org$luaj$vm2$lib$VarArgFunction;
    static /* synthetic */ Class class$org$luaj$vm2$lib$ZeroArgFunction;
    private InstructionHandle beginningOfLuaInstruction;
    private final InstructionHandle[] branchDestHandles;
    private final BranchInstruction[] branches;
    private final ClassGen cg;
    private final String classname;
    private final ConstantPoolGen cp;
    private final InstructionFactory factory;
    private final InstructionList init;
    private final InstructionHandle[] lastInstrHandles;
    private final InstructionList main;
    private final MethodGen mg;
    private final Prototype p;
    private final ProtoInfo pi;
    private int superclassType;
    private final int[] targets;
    private LocalVariableGen varresult = null;
    private int prev_line = -1;
    private Map plainSlotVars = new HashMap();
    private Map upvalueSlotVars = new HashMap();
    private Map localVarGenBySlot = new HashMap();
    private Map constants = new HashMap();

    static {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        Class cls7;
        Class cls8;
        Class cls9;
        Class cls10;
        Class cls11;
        Class cls12;
        Class cls13;
        Class cls14;
        if (class$org$luaj$vm2$Varargs == null) {
            cls = class$("org.luaj.vm2.Varargs");
            class$org$luaj$vm2$Varargs = cls;
        } else {
            cls = class$org$luaj$vm2$Varargs;
        }
        STR_VARARGS = cls.getName();
        if (class$org$luaj$vm2$LuaValue == null) {
            cls2 = class$("org.luaj.vm2.LuaValue");
            class$org$luaj$vm2$LuaValue = cls2;
        } else {
            cls2 = class$org$luaj$vm2$LuaValue;
        }
        STR_LUAVALUE = cls2.getName();
        if (class$org$luaj$vm2$LuaString == null) {
            cls3 = class$("org.luaj.vm2.LuaString");
            class$org$luaj$vm2$LuaString = cls3;
        } else {
            cls3 = class$org$luaj$vm2$LuaString;
        }
        STR_LUASTRING = cls3.getName();
        if (class$org$luaj$vm2$LuaInteger == null) {
            cls4 = class$("org.luaj.vm2.LuaInteger");
            class$org$luaj$vm2$LuaInteger = cls4;
        } else {
            cls4 = class$org$luaj$vm2$LuaInteger;
        }
        STR_LUAINTEGER = cls4.getName();
        if (class$org$luaj$vm2$LuaNumber == null) {
            cls5 = class$("org.luaj.vm2.LuaNumber");
            class$org$luaj$vm2$LuaNumber = cls5;
        } else {
            cls5 = class$org$luaj$vm2$LuaNumber;
        }
        STR_LUANUMBER = cls5.getName();
        if (class$org$luaj$vm2$LuaBoolean == null) {
            cls6 = class$("org.luaj.vm2.LuaBoolean");
            class$org$luaj$vm2$LuaBoolean = cls6;
        } else {
            cls6 = class$org$luaj$vm2$LuaBoolean;
        }
        STR_LUABOOLEAN = cls6.getName();
        if (class$org$luaj$vm2$LuaTable == null) {
            cls7 = class$("org.luaj.vm2.LuaTable");
            class$org$luaj$vm2$LuaTable = cls7;
        } else {
            cls7 = class$org$luaj$vm2$LuaTable;
        }
        STR_LUATABLE = cls7.getName();
        if (class$org$luaj$vm2$Buffer == null) {
            cls8 = class$("org.luaj.vm2.Buffer");
            class$org$luaj$vm2$Buffer = cls8;
        } else {
            cls8 = class$org$luaj$vm2$Buffer;
        }
        STR_BUFFER = cls8.getName();
        if (class$java$lang$String == null) {
            cls9 = class$("java.lang.String");
            class$java$lang$String = cls9;
        } else {
            cls9 = class$java$lang$String;
        }
        STR_STRING = cls9.getName();
        TYPE_VARARGS = new ObjectType(STR_VARARGS);
        TYPE_LUAVALUE = new ObjectType(STR_LUAVALUE);
        TYPE_LUASTRING = new ObjectType(STR_LUASTRING);
        TYPE_LUAINTEGER = new ObjectType(STR_LUAINTEGER);
        TYPE_LUANUMBER = new ObjectType(STR_LUANUMBER);
        TYPE_LUABOOLEAN = new ObjectType(STR_LUABOOLEAN);
        TYPE_LUATABLE = new ObjectType(STR_LUATABLE);
        TYPE_BUFFER = new ObjectType(STR_BUFFER);
        TYPE_STRING = new ObjectType(STR_STRING);
        TYPE_LOCALUPVALUE = new ArrayType(TYPE_LUAVALUE, 1);
        TYPE_CHARARRAY = new ArrayType(Type.CHAR, 1);
        TYPE_STRINGARRAY = new ArrayType(TYPE_STRING, 1);
        if (class$org$luaj$vm2$lib$VarArgFunction == null) {
            cls10 = class$("org.luaj.vm2.lib.VarArgFunction");
            class$org$luaj$vm2$lib$VarArgFunction = cls10;
        } else {
            cls10 = class$org$luaj$vm2$lib$VarArgFunction;
        }
        STR_FUNCV = cls10.getName();
        if (class$org$luaj$vm2$lib$ZeroArgFunction == null) {
            cls11 = class$("org.luaj.vm2.lib.ZeroArgFunction");
            class$org$luaj$vm2$lib$ZeroArgFunction = cls11;
        } else {
            cls11 = class$org$luaj$vm2$lib$ZeroArgFunction;
        }
        STR_FUNC0 = cls11.getName();
        if (class$org$luaj$vm2$lib$OneArgFunction == null) {
            cls12 = class$("org.luaj.vm2.lib.OneArgFunction");
            class$org$luaj$vm2$lib$OneArgFunction = cls12;
        } else {
            cls12 = class$org$luaj$vm2$lib$OneArgFunction;
        }
        STR_FUNC1 = cls12.getName();
        if (class$org$luaj$vm2$lib$TwoArgFunction == null) {
            cls13 = class$("org.luaj.vm2.lib.TwoArgFunction");
            class$org$luaj$vm2$lib$TwoArgFunction = cls13;
        } else {
            cls13 = class$org$luaj$vm2$lib$TwoArgFunction;
        }
        STR_FUNC2 = cls13.getName();
        if (class$org$luaj$vm2$lib$ThreeArgFunction == null) {
            cls14 = class$("org.luaj.vm2.lib.ThreeArgFunction");
            class$org$luaj$vm2$lib$ThreeArgFunction = cls14;
        } else {
            cls14 = class$org$luaj$vm2$lib$ThreeArgFunction;
        }
        STR_FUNC3 = cls14.getName();
        ARG_TYPES_NONE = new Type[0];
        ARG_TYPES_INT = new Type[]{Type.INT};
        ARG_TYPES_DOUBLE = new Type[]{Type.DOUBLE};
        ARG_TYPES_STRING = new Type[]{Type.STRING};
        ARG_TYPES_CHARARRAY = new Type[]{TYPE_CHARARRAY};
        ARG_TYPES_INT_LUAVALUE = new Type[]{Type.INT, TYPE_LUAVALUE};
        ARG_TYPES_INT_VARARGS = new Type[]{Type.INT, TYPE_VARARGS};
        ARG_TYPES_LUAVALUE_VARARGS = new Type[]{TYPE_LUAVALUE, TYPE_VARARGS};
        ARG_TYPES_LUAVALUE_LUAVALUE_VARARGS = new Type[]{TYPE_LUAVALUE, TYPE_LUAVALUE, TYPE_VARARGS};
        ARG_TYPES_LUAVALUEARRAY = new Type[]{new ArrayType(TYPE_LUAVALUE, 1)};
        ARG_TYPES_LUAVALUEARRAY_VARARGS = new Type[]{new ArrayType(TYPE_LUAVALUE, 1), TYPE_VARARGS};
        ARG_TYPES_LUAVALUE_LUAVALUE_LUAVALUE = new Type[]{TYPE_LUAVALUE, TYPE_LUAVALUE, TYPE_LUAVALUE};
        ARG_TYPES_VARARGS = new Type[]{TYPE_VARARGS};
        ARG_TYPES_LUAVALUE_LUAVALUE = new Type[]{TYPE_LUAVALUE, TYPE_LUAVALUE};
        ARG_TYPES_INT_INT = new Type[]{Type.INT, Type.INT};
        ARG_TYPES_LUAVALUE = new Type[]{TYPE_LUAVALUE};
        ARG_TYPES_BUFFER = new Type[]{TYPE_BUFFER};
        ARG_TYPES_STRINGARRAY = new Type[]{TYPE_STRINGARRAY};
        ARG_TYPES_LUAVALUE_STRINGARRAY = new Type[]{TYPE_LUAVALUE, TYPE_STRINGARRAY};
        SUPER_NAME_N = new String[]{STR_FUNC0, STR_FUNC1, STR_FUNC2, STR_FUNC3, STR_FUNCV};
        RETURN_TYPE_N = new ObjectType[]{TYPE_LUAVALUE, TYPE_LUAVALUE, TYPE_LUAVALUE, TYPE_LUAVALUE, TYPE_VARARGS};
        ARG_TYPES_N = new Type[][]{ARG_TYPES_NONE, ARG_TYPES_LUAVALUE, ARG_TYPES_LUAVALUE_LUAVALUE, ARG_TYPES_LUAVALUE_LUAVALUE_LUAVALUE, ARG_TYPES_VARARGS};
        ARG_NAMES_N = new String[][]{new String[0], new String[]{AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_ARG}, new String[]{"arg1", "arg2"}, new String[]{"arg1", "arg2", "arg3"}, new String[]{"args"}};
        METH_NAME_N = new String[]{NotificationCompat.CATEGORY_CALL, NotificationCompat.CATEGORY_CALL, NotificationCompat.CATEGORY_CALL, NotificationCompat.CATEGORY_CALL, "onInvoke"};
        SUPERTYPE_VARARGS = 4;
    }

    public JavaBuilder(ProtoInfo protoInfo, String str, String str2) {
        this.pi = protoInfo;
        this.p = protoInfo.prototype;
        this.classname = str;
        this.superclassType = this.p.numparams;
        if (this.p.is_vararg != 0 || this.superclassType >= SUPERTYPE_VARARGS) {
            this.superclassType = SUPERTYPE_VARARGS;
        }
        int length = this.p.code.length;
        for (int i = 0; i < length; i++) {
            int i2 = this.p.code[i];
            int GET_OPCODE = Lua.GET_OPCODE(i2);
            if (GET_OPCODE == 30 || (GET_OPCODE == 31 && (Lua.GETARG_B(i2) < 1 || Lua.GETARG_B(i2) > 2))) {
                this.superclassType = SUPERTYPE_VARARGS;
                break;
            }
        }
        this.cg = new ClassGen(str, SUPER_NAME_N[this.superclassType], str2, 33, (String[]) null);
        this.cp = this.cg.getConstantPool();
        this.factory = new InstructionFactory(this.cg);
        this.init = new InstructionList();
        this.main = new InstructionList();
        for (int i3 = 0; i3 < this.p.upvalues.length; i3++) {
            this.cg.addField(new FieldGen(0, protoInfo.isReadWriteUpvalue(protoInfo.upvals[i3]) ? TYPE_LOCALUPVALUE : TYPE_LUAVALUE, upvalueName(i3), this.cp).getField());
        }
        this.mg = new MethodGen(17, RETURN_TYPE_N[this.superclassType], ARG_TYPES_N[this.superclassType], ARG_NAMES_N[this.superclassType], METH_NAME_N[this.superclassType], STR_LUAVALUE, this.main, this.cp);
        initializeSlots();
        int length2 = this.p.code.length;
        this.targets = new int[length2];
        this.branches = new BranchInstruction[length2];
        this.branchDestHandles = new InstructionHandle[length2];
        this.lastInstrHandles = new InstructionHandle[length2];
    }

    private void append(BranchInstruction branchInstruction) {
        conditionalSetBeginningOfLua(this.main.append(branchInstruction));
    }

    private void append(CompoundInstruction compoundInstruction) {
        conditionalSetBeginningOfLua(this.main.append(compoundInstruction));
    }

    private void append(Instruction instruction) {
        conditionalSetBeginningOfLua(this.main.append(instruction));
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void conditionalSetBeginningOfLua(InstructionHandle instructionHandle) {
        if (this.beginningOfLuaInstruction == null) {
            this.beginningOfLuaInstruction = instructionHandle;
        }
    }

    private String createLuaDoubleField(double d) {
        String stringBuffer = new StringBuffer().append(PREFIX_CONSTANT).append(this.constants.size()).toString();
        this.cg.addField(new FieldGen(24, TYPE_LUAVALUE, stringBuffer, this.cp).getField());
        this.init.append(new PUSH(this.cp, d));
        this.init.append(this.factory.createInvoke(STR_LUAVALUE, "valueOf", TYPE_LUANUMBER, ARG_TYPES_DOUBLE, (short) 184));
        this.init.append(this.factory.createPutStatic(this.classname, stringBuffer, TYPE_LUAVALUE));
        return stringBuffer;
    }

    private String createLuaIntegerField(int i) {
        String stringBuffer = new StringBuffer().append(PREFIX_CONSTANT).append(this.constants.size()).toString();
        this.cg.addField(new FieldGen(24, TYPE_LUAVALUE, stringBuffer, this.cp).getField());
        this.init.append(new PUSH(this.cp, i));
        this.init.append(this.factory.createInvoke(STR_LUAVALUE, "valueOf", TYPE_LUAINTEGER, ARG_TYPES_INT, (short) 184));
        this.init.append(this.factory.createPutStatic(this.classname, stringBuffer, TYPE_LUAVALUE));
        return stringBuffer;
    }

    private String createLuaStringField(LuaString luaString) {
        InstructionList instructionList;
        InvokeInstruction createInvoke;
        String stringBuffer = new StringBuffer().append(PREFIX_CONSTANT).append(this.constants.size()).toString();
        this.cg.addField(new FieldGen(24, TYPE_LUAVALUE, stringBuffer, this.cp).getField());
        LuaString checkstring = luaString.checkstring();
        if (checkstring.isValidUtf8()) {
            this.init.append(new PUSH(this.cp, luaString.tojstring()));
            instructionList = this.init;
            createInvoke = this.factory.createInvoke(STR_LUASTRING, "valueOf", TYPE_LUASTRING, ARG_TYPES_STRING, (short) 184);
        } else {
            char[] cArr = new char[checkstring.m_length];
            for (int i = 0; i < checkstring.m_length; i++) {
                cArr[i] = (char) (checkstring.m_bytes[checkstring.m_offset + i] & UByte.MAX_VALUE);
            }
            this.init.append(new PUSH(this.cp, new String(cArr)));
            this.init.append(this.factory.createInvoke(STR_STRING, "toCharArray", TYPE_CHARARRAY, Type.NO_ARGS, (short) 182));
            instructionList = this.init;
            createInvoke = this.factory.createInvoke(STR_LUASTRING, "valueOf", TYPE_LUASTRING, ARG_TYPES_CHARARRAY, (short) 184);
        }
        instructionList.append(createInvoke);
        this.init.append(this.factory.createPutStatic(this.classname, stringBuffer, TYPE_LUAVALUE));
        return stringBuffer;
    }

    private int findSlot(int i, Map map, String str, Type type) {
        Integer valueOf = Integer.valueOf(i);
        if (map.containsKey(valueOf)) {
            return ((Integer) map.get(valueOf)).intValue();
        }
        LocalVariableGen addLocalVariable = this.mg.addLocalVariable(new StringBuffer().append(str).append(i).toString(), type, (InstructionHandle) null, (InstructionHandle) null);
        int index = addLocalVariable.getIndex();
        map.put(valueOf, Integer.valueOf(index));
        this.localVarGenBySlot.put(valueOf, addLocalVariable);
        return index;
    }

    private int findSlotIndex(int i, boolean z) {
        Map map;
        String str;
        ArrayType arrayType;
        if (z) {
            map = this.upvalueSlotVars;
            str = PREFIX_UPVALUE_SLOT;
            arrayType = TYPE_LOCALUPVALUE;
        } else {
            map = this.plainSlotVars;
            str = PREFIX_PLAIN_SLOT;
            arrayType = TYPE_LUAVALUE;
        }
        return findSlot(i, map, str, arrayType);
    }

    private int getVarresultIndex() {
        if (this.varresult == null) {
            this.varresult = this.mg.addLocalVariable(NAME_VARRESULT, TYPE_VARARGS, (InstructionHandle) null, (InstructionHandle) null);
        }
        return this.varresult.getIndex();
    }

    private void resolveBranches() {
        int length = this.p.code.length;
        for (int i = 0; i < length; i++) {
            if (this.branches[i] != null) {
                int i2 = this.targets[i];
                while (i2 < this.branchDestHandles.length && this.branchDestHandles[i2] == null) {
                    i2++;
                }
                if (i2 >= this.branchDestHandles.length) {
                    throw new IllegalArgumentException(new StringBuffer().append("no target at or after ").append(this.targets[i]).append(" op=").append(Lua.GET_OPCODE(this.p.code[this.targets[i]])).toString());
                }
                this.branches[i].setTarget(this.branchDestHandles[i2]);
            }
        }
    }

    private static String upvalueName(int i) {
        return new StringBuffer().append(PREFIX_UPVALUE).append(i).toString();
    }

    public void addBranch(int i, int i2, int i3) {
        switch (i2) {
            case 2:
                this.branches[i] = new IFNE((InstructionHandle) null);
                break;
            case 3:
                this.branches[i] = new IFEQ((InstructionHandle) null);
                break;
            default:
                this.branches[i] = new GOTO((InstructionHandle) null);
                break;
        }
        this.targets[i] = i3;
        append(this.branches[i]);
    }

    public void areturn() {
        append((Instruction) InstructionConstants.ARETURN);
    }

    public void arg(int i) {
        InvokeInstruction createInvoke;
        if (i == 1) {
            createInvoke = this.factory.createInvoke(STR_VARARGS, "arg1", TYPE_LUAVALUE, ARG_TYPES_NONE, (short) 182);
        } else {
            append((CompoundInstruction) new PUSH(this.cp, i));
            createInvoke = this.factory.createInvoke(STR_VARARGS, AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_ARG, TYPE_LUAVALUE, ARG_TYPES_INT, (short) 182);
        }
        append((Instruction) createInvoke);
    }

    public void binaryop(int i) {
        String str;
        switch (i) {
            case 14:
                str = "sub";
                break;
            case 15:
                str = "mul";
                break;
            case 16:
                str = "div";
                break;
            case 17:
                str = "mod";
                break;
            case 18:
                str = "pow";
                break;
            default:
                str = "add";
                break;
        }
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, str, TYPE_LUAVALUE, ARG_TYPES_LUAVALUE, (short) 182));
    }

    public void call(int i) {
        InvokeInstruction createInvoke;
        switch (i) {
            case 0:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, NotificationCompat.CATEGORY_CALL, TYPE_LUAVALUE, ARG_TYPES_NONE, (short) 182);
                break;
            case 1:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, NotificationCompat.CATEGORY_CALL, TYPE_LUAVALUE, ARG_TYPES_LUAVALUE, (short) 182);
                break;
            case 2:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, NotificationCompat.CATEGORY_CALL, TYPE_LUAVALUE, ARG_TYPES_LUAVALUE_LUAVALUE, (short) 182);
                break;
            case 3:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, NotificationCompat.CATEGORY_CALL, TYPE_LUAVALUE, ARG_TYPES_LUAVALUE_LUAVALUE_LUAVALUE, (short) 182);
                break;
            default:
                throw new IllegalArgumentException(new StringBuffer().append("can't call with ").append(i).append(" args").toString());
        }
        append((Instruction) createInvoke);
    }

    public void closeUpvalue(int i, int i2) {
    }

    public void closureCreate(String str) {
        append((Instruction) this.factory.createNew(new ObjectType(str)));
        append((Instruction) InstructionConstants.DUP);
        append((Instruction) this.factory.createInvoke(str, "<init>", Type.VOID, Type.NO_ARGS, (short) 183));
    }

    public void closureInitUpvalueFromLocal(String str, int i, int i2, int i3) {
        boolean isReadWriteUpvalue = this.pi.isReadWriteUpvalue(this.pi.vars[i3][i2].upvalue);
        ArrayType arrayType = isReadWriteUpvalue ? TYPE_LOCALUPVALUE : TYPE_LUAVALUE;
        String upvalueName = upvalueName(i);
        append((Instruction) new ALOAD(findSlotIndex(i3, isReadWriteUpvalue)));
        append((Instruction) this.factory.createFieldAccess(str, upvalueName, arrayType, (short) 181));
    }

    public void closureInitUpvalueFromUpvalue(String str, int i, int i2) {
        ArrayType arrayType = this.pi.isReadWriteUpvalue(this.pi.upvals[i2]) ? TYPE_LOCALUPVALUE : TYPE_LUAVALUE;
        String upvalueName = upvalueName(i2);
        String upvalueName2 = upvalueName(i);
        append((Instruction) InstructionConstants.THIS);
        append((Instruction) this.factory.createFieldAccess(this.classname, upvalueName, arrayType, (short) 180));
        append((Instruction) this.factory.createFieldAccess(str, upvalueName2, arrayType, (short) 181));
    }

    public void compareop(int i) {
        String str;
        switch (i) {
            case 25:
                str = "lt_b";
                break;
            case 26:
                str = "lteq_b";
                break;
            default:
                str = "eq_b";
                break;
        }
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, str, Type.BOOLEAN, ARG_TYPES_LUAVALUE, (short) 182));
    }

    public byte[] completeClass(boolean z) {
        InstructionFactory instructionFactory;
        String str;
        String upvalueName;
        ArrayType arrayType;
        if (!this.init.isEmpty()) {
            MethodGen methodGen = new MethodGen(8, Type.VOID, ARG_TYPES_NONE, new String[0], "<clinit>", this.cg.getClassName(), this.init, this.cg.getConstantPool());
            this.init.append(InstructionConstants.RETURN);
            methodGen.setMaxStack();
            this.cg.addMethod(methodGen.getMethod());
            this.init.dispose();
        }
        this.cg.addEmptyConstructor(1);
        resolveBranches();
        this.mg.setMaxStack();
        this.cg.addMethod(this.mg.getMethod());
        this.main.dispose();
        if (this.p.upvalues.length == 1 && this.superclassType == SUPERTYPE_VARARGS) {
            MethodGen methodGen2 = new MethodGen(17, Type.VOID, ARG_TYPES_LUAVALUE, new String[]{"env"}, "initupvalue1", STR_LUAVALUE, this.main, this.cp);
            boolean isReadWriteUpvalue = this.pi.isReadWriteUpvalue(this.pi.upvals[0]);
            append((Instruction) InstructionConstants.THIS);
            append((Instruction) new ALOAD(1));
            if (isReadWriteUpvalue) {
                append((Instruction) this.factory.createInvoke(this.classname, "newupl", TYPE_LOCALUPVALUE, ARG_TYPES_LUAVALUE, (short) 184));
                instructionFactory = this.factory;
                str = this.classname;
                upvalueName = upvalueName(0);
                arrayType = TYPE_LOCALUPVALUE;
            } else {
                instructionFactory = this.factory;
                str = this.classname;
                upvalueName = upvalueName(0);
                arrayType = TYPE_LUAVALUE;
            }
            append((Instruction) instructionFactory.createFieldAccess(str, upvalueName, arrayType, (short) 181));
            append((Instruction) InstructionConstants.RETURN);
            methodGen2.setMaxStack();
            this.cg.addMethod(methodGen2.getMethod());
            this.main.dispose();
        }
        if (z) {
            MethodGen methodGen3 = new MethodGen(9, Type.VOID, ARG_TYPES_STRINGARRAY, new String[]{AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_ARG}, "main", this.classname, this.main, this.cp);
            append((Instruction) this.factory.createNew(this.classname));
            append((Instruction) InstructionConstants.DUP);
            append((Instruction) this.factory.createInvoke(this.classname, "<init>", Type.VOID, ARG_TYPES_NONE, (short) 183));
            append((Instruction) new ALOAD(0));
            append((Instruction) this.factory.createInvoke(STR_JSEPLATFORM, "luaMain", Type.VOID, ARG_TYPES_LUAVALUE_STRINGARRAY, (short) 184));
            append((Instruction) InstructionConstants.RETURN);
            methodGen3.setMaxStack();
            this.cg.addMethod(methodGen3.getMethod());
            this.main.dispose();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.cg.getJavaClass().dump(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(new StringBuffer().append("JavaClass.dump() threw ").append(e).toString());
        }
    }

    public void concatbuffer() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "concat", TYPE_BUFFER, ARG_TYPES_BUFFER, (short) 182));
    }

    public void concatvalue() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "concat", TYPE_LUAVALUE, ARG_TYPES_LUAVALUE, (short) 182));
    }

    public void convertToUpvalue(int i, int i2) {
        if (this.pi.isUpvalueAssign(i, i2)) {
            append((Instruction) new ALOAD(findSlotIndex(i2, false)));
            append((Instruction) this.factory.createInvoke(this.classname, "newupl", TYPE_LOCALUPVALUE, ARG_TYPES_LUAVALUE, (short) 184));
            append((Instruction) new ASTORE(findSlotIndex(i2, true)));
        }
    }

    public void createUpvalues(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 + i4;
            if (this.pi.isUpvalueCreate(i, i5)) {
                int findSlotIndex = findSlotIndex(i5, true);
                append((Instruction) this.factory.createInvoke(this.classname, "newupn", TYPE_LOCALUPVALUE, ARG_TYPES_NONE, (short) 184));
                append((Instruction) new ASTORE(findSlotIndex));
            }
        }
    }

    public void dup() {
        append((Instruction) InstructionConstants.DUP);
    }

    public void getTable() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "get", TYPE_LUAVALUE, ARG_TYPES_LUAVALUE, (short) 182));
    }

    public void initializeSlots() {
        int i = 0;
        createUpvalues(-1, 0, this.p.maxstacksize);
        if (this.superclassType == SUPERTYPE_VARARGS) {
            while (i < this.p.numparams) {
                if (this.pi.isInitialValueUsed(i)) {
                    append((Instruction) new ALOAD(1));
                    append((CompoundInstruction) new PUSH(this.cp, i + 1));
                    append((Instruction) this.factory.createInvoke(STR_VARARGS, AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_ARG, TYPE_LUAVALUE, ARG_TYPES_INT, (short) 182));
                    storeLocal(-1, i);
                }
                i++;
            }
            append((Instruction) new ALOAD(1));
            append((CompoundInstruction) new PUSH(this.cp, this.p.numparams + 1));
            append((Instruction) this.factory.createInvoke(STR_VARARGS, "subargs", TYPE_VARARGS, ARG_TYPES_INT, (short) 182));
            append((Instruction) new ASTORE(1));
        } else {
            while (i < this.p.numparams) {
                int i2 = i + 1;
                this.plainSlotVars.put(Integer.valueOf(i), Integer.valueOf(i2));
                if (this.pi.isUpvalueCreate(-1, i)) {
                    append((Instruction) new ALOAD(i2));
                    storeLocal(-1, i);
                }
                i = i2;
            }
        }
        while (i < this.p.maxstacksize) {
            if (this.pi.isInitialValueUsed(i)) {
                loadNil();
                storeLocal(-1, i);
            }
            i++;
        }
    }

    public void invoke(int i) {
        InvokeInstruction createInvoke;
        switch (i) {
            case -1:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, "invoke", TYPE_VARARGS, ARG_TYPES_VARARGS, (short) 182);
                break;
            case 0:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, "invoke", TYPE_VARARGS, ARG_TYPES_NONE, (short) 182);
                break;
            case 1:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, "invoke", TYPE_VARARGS, ARG_TYPES_VARARGS, (short) 182);
                break;
            case 2:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, "invoke", TYPE_VARARGS, ARG_TYPES_LUAVALUE_VARARGS, (short) 182);
                break;
            case 3:
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, "invoke", TYPE_VARARGS, ARG_TYPES_LUAVALUE_LUAVALUE_VARARGS, (short) 182);
                break;
            default:
                throw new IllegalArgumentException(new StringBuffer().append("can't invoke with ").append(i).append(" args").toString());
        }
        append((Instruction) createInvoke);
    }

    public void isNil() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "isnil", Type.BOOLEAN, Type.NO_ARGS, (short) 182));
    }

    public void loadArrayArgs(int i, int i2, int i3) {
        append((CompoundInstruction) new PUSH(this.cp, i3));
        append((Instruction) new ANEWARRAY(this.cp.addClass(STR_LUAVALUE)));
        int i4 = 0;
        while (i4 < i3) {
            append((Instruction) InstructionConstants.DUP);
            append((CompoundInstruction) new PUSH(this.cp, i4));
            loadLocal(i, i2);
            append((Instruction) new AASTORE());
            i4++;
            i2++;
        }
    }

    public void loadBoolean(boolean z) {
        append((Instruction) this.factory.createFieldAccess(STR_LUAVALUE, z ? "TRUE" : "FALSE", TYPE_LUABOOLEAN, (short) 178));
    }

    public void loadConstant(LuaValue luaValue) {
        switch (luaValue.type()) {
            case 0:
                loadNil();
                return;
            case 1:
                loadBoolean(luaValue.toboolean());
                return;
            case 2:
            default:
                throw new IllegalArgumentException(new StringBuffer().append("bad constant type: ").append(luaValue.type()).toString());
            case 3:
            case 4:
                String str = (String) this.constants.get(luaValue);
                if (str == null) {
                    str = luaValue.type() == 3 ? luaValue.isinttype() ? createLuaIntegerField(luaValue.checkint()) : createLuaDoubleField(luaValue.checkdouble()) : createLuaStringField(luaValue.checkstring());
                    this.constants.put(luaValue, str);
                }
                append((Instruction) this.factory.createGetStatic(this.classname, str, TYPE_LUAVALUE));
                return;
        }
    }

    public void loadLocal(int i, int i2) {
        boolean isUpvalueRefer = this.pi.isUpvalueRefer(i, i2);
        append((Instruction) new ALOAD(findSlotIndex(i2, isUpvalueRefer)));
        if (isUpvalueRefer) {
            append((CompoundInstruction) new PUSH(this.cp, 0));
            append((Instruction) InstructionConstants.AALOAD);
        }
    }

    public void loadNil() {
        append((Instruction) this.factory.createFieldAccess(STR_LUAVALUE, "NIL", TYPE_LUAVALUE, (short) 178));
    }

    public void loadNone() {
        append((Instruction) this.factory.createFieldAccess(STR_LUAVALUE, "NONE", TYPE_LUAVALUE, (short) 178));
    }

    public void loadUpvalue(int i) {
        ArrayInstruction createFieldAccess;
        boolean isReadWriteUpvalue = this.pi.isReadWriteUpvalue(this.pi.upvals[i]);
        append((Instruction) InstructionConstants.THIS);
        if (isReadWriteUpvalue) {
            append((Instruction) this.factory.createFieldAccess(this.classname, upvalueName(i), TYPE_LOCALUPVALUE, (short) 180));
            append((CompoundInstruction) new PUSH(this.cp, 0));
            createFieldAccess = InstructionConstants.AALOAD;
        } else {
            createFieldAccess = this.factory.createFieldAccess(this.classname, upvalueName(i), TYPE_LUAVALUE, (short) 180);
        }
        append((Instruction) createFieldAccess);
    }

    public void loadVarargs() {
        append((Instruction) new ALOAD(1));
    }

    public void loadVarargs(int i) {
        loadVarargs();
        arg(i);
    }

    public void loadVarresult() {
        append((Instruction) new ALOAD(getVarresultIndex()));
    }

    public void newTable(int i, int i2) {
        append((CompoundInstruction) new PUSH(this.cp, i));
        append((CompoundInstruction) new PUSH(this.cp, i2));
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "tableOf", TYPE_LUATABLE, ARG_TYPES_INT_INT, (short) 184));
    }

    public void newTailcallVarargs() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "tailcallOf", TYPE_VARARGS, ARG_TYPES_LUAVALUE_VARARGS, (short) 184));
    }

    public void newVarargs(int i, int i2, int i3) {
        InvokeInstruction createInvoke;
        switch (i3) {
            case 0:
                loadNone();
                return;
            case 1:
                loadLocal(i, i2);
                return;
            case 2:
                loadLocal(i, i2);
                loadLocal(i, i2 + 1);
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, "varargsOf", TYPE_VARARGS, ARG_TYPES_LUAVALUE_VARARGS, (short) 184);
                break;
            case 3:
                loadLocal(i, i2);
                loadLocal(i, i2 + 1);
                loadLocal(i, i2 + 2);
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, "varargsOf", TYPE_VARARGS, ARG_TYPES_LUAVALUE_LUAVALUE_VARARGS, (short) 184);
                break;
            default:
                loadArrayArgs(i, i2, i3);
                createInvoke = this.factory.createInvoke(STR_LUAVALUE, "varargsOf", TYPE_VARARGS, ARG_TYPES_LUAVALUEARRAY, (short) 184);
                break;
        }
        append((Instruction) createInvoke);
    }

    public void newVarargsVarresult(int i, int i2, int i3) {
        loadArrayArgs(i, i2, i3);
        loadVarresult();
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "varargsOf", TYPE_VARARGS, ARG_TYPES_LUAVALUEARRAY_VARARGS, (short) 184));
    }

    public void onEndOfLuaInstruction(int i, int i2) {
        this.branchDestHandles[i] = this.beginningOfLuaInstruction;
        this.lastInstrHandles[i] = this.main.getEnd();
        if (i2 != this.prev_line) {
            MethodGen methodGen = this.mg;
            InstructionHandle instructionHandle = this.beginningOfLuaInstruction;
            this.prev_line = i2;
            methodGen.addLineNumber(instructionHandle, i2);
        }
        this.beginningOfLuaInstruction = null;
    }

    public void pop() {
        append((Instruction) InstructionConstants.POP);
    }

    public void setTable() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "set", Type.VOID, ARG_TYPES_LUAVALUE_LUAVALUE, (short) 182));
    }

    public void setVarStartEnd(int i, int i2, int i3, String str) {
        Integer valueOf = Integer.valueOf(i);
        if (this.localVarGenBySlot.containsKey(valueOf)) {
            String replaceAll = str.replaceAll("[^a-zA-Z0-9]", "_");
            LocalVariableGen localVariableGen = (LocalVariableGen) this.localVarGenBySlot.get(valueOf);
            localVariableGen.setEnd(this.lastInstrHandles[i3 - 1]);
            if (i2 > 1) {
                localVariableGen.setStart(this.lastInstrHandles[i2 - 2]);
            }
            localVariableGen.setName(replaceAll);
        }
    }

    public void setlistStack(int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            dup();
            append((CompoundInstruction) new PUSH(this.cp, i3 + i5));
            loadLocal(i, i2 + i5);
            append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "rawset", Type.VOID, ARG_TYPES_INT_LUAVALUE, (short) 182));
        }
    }

    public void setlistVarargs(int i, int i2) {
        append((CompoundInstruction) new PUSH(this.cp, i));
        loadVarresult();
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "rawsetlist", Type.VOID, ARG_TYPES_INT_VARARGS, (short) 182));
    }

    public void storeLocal(int i, int i2) {
        ArrayInstruction astore;
        ASTORE aload;
        boolean isUpvalueAssign = this.pi.isUpvalueAssign(i, i2);
        int findSlotIndex = findSlotIndex(i2, isUpvalueAssign);
        if (isUpvalueAssign) {
            if (this.pi.isUpvalueCreate(i, i2)) {
                append((Instruction) this.factory.createInvoke(this.classname, "newupe", TYPE_LOCALUPVALUE, ARG_TYPES_NONE, (short) 184));
                append((Instruction) InstructionConstants.DUP);
                aload = new ASTORE(findSlotIndex);
            } else {
                aload = new ALOAD(findSlotIndex);
            }
            append((Instruction) aload);
            append((Instruction) InstructionConstants.SWAP);
            append((CompoundInstruction) new PUSH(this.cp, 0));
            append((Instruction) InstructionConstants.SWAP);
            astore = InstructionConstants.AASTORE;
        } else {
            astore = new ASTORE(findSlotIndex);
        }
        append((Instruction) astore);
    }

    public void storeUpvalue(int i, int i2, int i3) {
        ArrayInstruction createFieldAccess;
        boolean isReadWriteUpvalue = this.pi.isReadWriteUpvalue(this.pi.upvals[i2]);
        append((Instruction) InstructionConstants.THIS);
        if (isReadWriteUpvalue) {
            append((Instruction) this.factory.createFieldAccess(this.classname, upvalueName(i2), TYPE_LOCALUPVALUE, (short) 180));
            append((CompoundInstruction) new PUSH(this.cp, 0));
            loadLocal(i, i3);
            createFieldAccess = InstructionConstants.AASTORE;
        } else {
            loadLocal(i, i3);
            createFieldAccess = this.factory.createFieldAccess(this.classname, upvalueName(i2), TYPE_LUAVALUE, (short) 181);
        }
        append((Instruction) createFieldAccess);
    }

    public void storeVarresult() {
        append((Instruction) new ASTORE(getVarresultIndex()));
    }

    public void subargs(int i) {
        append((CompoundInstruction) new PUSH(this.cp, i));
        append((Instruction) this.factory.createInvoke(STR_VARARGS, "subargs", TYPE_VARARGS, ARG_TYPES_INT, (short) 182));
    }

    public void testForLoop() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "testfor_b", Type.BOOLEAN, ARG_TYPES_LUAVALUE_LUAVALUE, (short) 182));
    }

    public void toBoolean() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "toboolean", Type.BOOLEAN, Type.NO_ARGS, (short) 182));
    }

    public void tobuffer() {
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, "buffer", TYPE_BUFFER, Type.NO_ARGS, (short) 182));
    }

    public void tostring() {
        append((Instruction) this.factory.createInvoke(STR_BUFFER, "tostring", TYPE_LUASTRING, Type.NO_ARGS, (short) 182));
    }

    public void tovalue() {
        append((Instruction) this.factory.createInvoke(STR_BUFFER, "value", TYPE_LUAVALUE, Type.NO_ARGS, (short) 182));
    }

    public void unaryop(int i) {
        String str;
        switch (i) {
            case 20:
                str = "not";
                break;
            case 21:
                str = "len";
                break;
            default:
                str = "neg";
                break;
        }
        append((Instruction) this.factory.createInvoke(STR_LUAVALUE, str, TYPE_LUAVALUE, Type.NO_ARGS, (short) 182));
    }
}
