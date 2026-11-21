package org.luaj.vm2.lib;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.luaj.vm2.Buffer;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: classes10.dex */
public class OsLib extends TwoArgFunction {
    private static final int CLOCK = 0;
    private static final int DATE = 1;
    private static final int DIFFTIME = 2;
    private static final int EXECUTE = 3;
    private static final int EXIT = 4;
    private static final int GETENV = 5;
    private static final int REMOVE = 6;
    private static final int RENAME = 7;
    private static final int SETLOCALE = 8;
    private static final int TIME = 9;
    private static final int TMPNAME = 10;
    static /* synthetic */ Class class$org$luaj$vm2$lib$OsLib;
    protected Globals globals;
    public static String TMP_PREFIX = ".luaj";
    public static String TMP_SUFFIX = "tmp";
    private static final String[] NAMES = {"clock", "date", "difftime", "execute", "exit", "getenv", "remove", "rename", "setlocale", "time", "tmpname"};
    private static final long t0 = System.currentTimeMillis();
    private static long tmpnames = t0;
    private static final String[] WeekdayNameAbbrev = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String[] WeekdayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final String[] MonthNameAbbrev = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] MonthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    /* loaded from: classes10.dex */
    class OsLibFunc extends VarArgFunction {
        public OsLibFunc(int i, String str) {
            this.opcode = i;
            this.name = str;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            try {
                switch (this.opcode) {
                    case 0:
                        return valueOf(OsLib.this.clock());
                    case 1:
                        String optjstring = varargs.optjstring(1, "%c");
                        double time = varargs.isnumber(2) ? varargs.todouble(2) : OsLib.this.time(null);
                        if (!optjstring.equals("*t")) {
                            OsLib osLib = OsLib.this;
                            if (time == -1.0d) {
                                time = OsLib.this.time(null);
                            }
                            return valueOf(osLib.date(optjstring, time));
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date((long) (time * 1000.0d)));
                        LuaTable tableOf = LuaValue.tableOf();
                        tableOf.set("year", LuaValue.valueOf(calendar.get(1)));
                        tableOf.set("month", LuaValue.valueOf(calendar.get(2) + 1));
                        tableOf.set("day", LuaValue.valueOf(calendar.get(5)));
                        tableOf.set("hour", LuaValue.valueOf(calendar.get(11)));
                        tableOf.set("min", LuaValue.valueOf(calendar.get(12)));
                        tableOf.set("sec", LuaValue.valueOf(calendar.get(13)));
                        tableOf.set("wday", LuaValue.valueOf(calendar.get(7)));
                        tableOf.set("yday", LuaValue.valueOf(calendar.get(6)));
                        tableOf.set("isdst", LuaValue.valueOf(OsLib.access$000(OsLib.this, calendar)));
                        return tableOf;
                    case 2:
                        return valueOf(OsLib.this.difftime(varargs.checkdouble(1), varargs.checkdouble(2)));
                    case 3:
                        return OsLib.this.execute(varargs.optjstring(1, null));
                    case 4:
                        OsLib.this.exit(varargs.optint(1, 0));
                        return NONE;
                    case 5:
                        String str = OsLib.this.getenv(varargs.checkjstring(1));
                        return str != null ? valueOf(str) : NIL;
                    case 6:
                        OsLib.this.remove(varargs.checkjstring(1));
                        return LuaValue.TRUE;
                    case 7:
                        OsLib.this.rename(varargs.checkjstring(1), varargs.checkjstring(2));
                        return LuaValue.TRUE;
                    case 8:
                        String str2 = OsLib.this.setlocale(varargs.optjstring(1, null), varargs.optjstring(2, "all"));
                        return str2 != null ? valueOf(str2) : NIL;
                    case 9:
                        return valueOf(OsLib.this.time(varargs.opttable(1, null)));
                    case 10:
                        return valueOf(OsLib.this.tmpname());
                    default:
                        return NONE;
                }
            } catch (IOException e) {
                return varargsOf(NIL, valueOf(e.getMessage()));
            }
        }
    }

    static /* synthetic */ boolean access$000(OsLib osLib, Calendar calendar) {
        return osLib.isDaylightSavingsTime(calendar);
    }

    private Calendar beginningOfYear(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(calendar.getTime());
        calendar2.set(2, 0);
        calendar2.set(5, 1);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return calendar2;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private boolean isDaylightSavingsTime(Calendar calendar) {
        return timeZoneOffset(calendar) != calendar.getTimeZone().getRawOffset() / 1000;
    }

    private int timeZoneOffset(Calendar calendar) {
        return calendar.getTimeZone().getOffset(1, calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), (((calendar.get(11) * 3600) + (calendar.get(12) * 60)) + calendar.get(13)) * 1000) / 1000;
    }

    private int weekNumber(Calendar calendar, int i) {
        Calendar beginningOfYear = beginningOfYear(calendar);
        int i2 = i + 8;
        beginningOfYear.set(5, ((i2 - beginningOfYear.get(7)) % 7) + 1);
        if (beginningOfYear.after(calendar)) {
            beginningOfYear.set(1, beginningOfYear.get(1) - 1);
            beginningOfYear.set(5, ((i2 - beginningOfYear.get(7)) % 7) + 1);
        }
        return ((int) ((calendar.getTime().getTime() - beginningOfYear.getTime().getTime()) / 604800000)) + 1;
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        LuaTable luaTable = new LuaTable();
        for (int i = 0; i < NAMES.length; i++) {
            luaTable.set(NAMES[i], new OsLibFunc(i, NAMES[i]));
        }
        luaValue2.set("os", luaTable);
        luaValue2.get("package").get("loaded").set("os", luaTable);
        return luaTable;
    }

    protected double clock() {
        return (System.currentTimeMillis() - t0) / 1000.0d;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0057. Please report as an issue. */
    public String date(String str, double d) {
        String str2;
        int i;
        int i2;
        int weekNumber;
        String str3;
        int i3;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date((long) (d * 1000.0d)));
        if (str.startsWith("!")) {
            d -= timeZoneOffset(calendar);
            calendar.setTime(new Date((long) (1000.0d * d)));
            str = str.substring(1);
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        Buffer buffer = new Buffer(length);
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            byte b = bytes[i4];
            switch (b) {
                case 10:
                    buffer.append("\n");
                    break;
                case 37:
                    if (i5 >= length) {
                        break;
                    } else {
                        i4 = i5 + 1;
                        byte b2 = bytes[i5];
                        switch (b2) {
                            case 37:
                                buffer.append((byte) 37);
                                break;
                            case 65:
                                str2 = WeekdayName[calendar.get(7) - 1];
                                buffer.append(str2);
                                break;
                            case 66:
                                str2 = MonthName[calendar.get(2)];
                                buffer.append(str2);
                                break;
                            case 72:
                                i = calendar.get(11);
                                i3 = i + 100;
                                str2 = String.valueOf(i3).substring(1);
                                buffer.append(str2);
                                break;
                            case 73:
                                i = calendar.get(11) % 12;
                                i3 = i + 100;
                                str2 = String.valueOf(i3).substring(1);
                                buffer.append(str2);
                                break;
                            case 77:
                                i = calendar.get(12);
                                i3 = i + 100;
                                str2 = String.valueOf(i3).substring(1);
                                buffer.append(str2);
                                break;
                            case 83:
                                i2 = 13;
                                i = calendar.get(i2);
                                i3 = i + 100;
                                str2 = String.valueOf(i3).substring(1);
                                buffer.append(str2);
                                break;
                            case 85:
                                weekNumber = weekNumber(calendar, 0);
                                str2 = String.valueOf(weekNumber);
                                buffer.append(str2);
                                break;
                            case 87:
                                weekNumber = weekNumber(calendar, 1);
                                str2 = String.valueOf(weekNumber);
                                buffer.append(str2);
                                break;
                            case 88:
                                str3 = "%H:%M:%S";
                                str2 = date(str3, d);
                                buffer.append(str2);
                                break;
                            case 89:
                                weekNumber = calendar.get(1);
                                str2 = String.valueOf(weekNumber);
                                buffer.append(str2);
                                break;
                            case 97:
                                str2 = WeekdayNameAbbrev[calendar.get(7) - 1];
                                buffer.append(str2);
                                break;
                            case 98:
                                str2 = MonthNameAbbrev[calendar.get(2)];
                                buffer.append(str2);
                                break;
                            case 99:
                                str3 = "%a %b %d %H:%M:%S %Y";
                                str2 = date(str3, d);
                                buffer.append(str2);
                                break;
                            case 100:
                                i2 = 5;
                                i = calendar.get(i2);
                                i3 = i + 100;
                                str2 = String.valueOf(i3).substring(1);
                                buffer.append(str2);
                                break;
                            case 106:
                                i3 = ((int) ((calendar.getTime().getTime() - beginningOfYear(calendar).getTime().getTime()) / 86400000)) + PointerIconCompat.TYPE_CONTEXT_MENU;
                                str2 = String.valueOf(i3).substring(1);
                                buffer.append(str2);
                                break;
                            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                                i3 = calendar.get(2) + TypedValues.TYPE_TARGET;
                                str2 = String.valueOf(i3).substring(1);
                                buffer.append(str2);
                                break;
                            case 112:
                                str2 = calendar.get(11) < 12 ? "AM" : "PM";
                                buffer.append(str2);
                                break;
                            case 119:
                                weekNumber = (calendar.get(7) + 6) % 7;
                                str2 = String.valueOf(weekNumber);
                                buffer.append(str2);
                                break;
                            case 120:
                                str3 = "%m/%d/%y";
                                str2 = date(str3, d);
                                buffer.append(str2);
                                break;
                            case 121:
                                str2 = String.valueOf(calendar.get(1)).substring(2);
                                buffer.append(str2);
                                break;
                            case 122:
                                int timeZoneOffset = timeZoneOffset(calendar) / 60;
                                int abs = Math.abs(timeZoneOffset);
                                str2 = new StringBuffer().append(timeZoneOffset >= 0 ? "+" : "-").append(String.valueOf((abs / 60) + 100).substring(1)).append(String.valueOf((abs % 60) + 100).substring(1)).toString();
                                buffer.append(str2);
                                break;
                            default:
                                LuaValue.argerror(1, new StringBuffer().append("invalid conversion specifier '%").append((int) b2).append("'").toString());
                                break;
                        }
                    }
                default:
                    buffer.append(b);
                    break;
            }
            i4 = i5;
        }
        return buffer.tojstring();
    }

    protected double difftime(double d, double d2) {
        return d - d2;
    }

    protected Varargs execute(String str) {
        return varargsOf(NIL, valueOf("exit"), ONE);
    }

    protected void exit(int i) {
        System.exit(i);
    }

    protected String getenv(String str) {
        return System.getProperty(str);
    }

    protected void remove(String str) throws IOException {
        throw new IOException("not implemented");
    }

    protected void rename(String str, String str2) throws IOException {
        throw new IOException("not implemented");
    }

    protected String setlocale(String str, String str2) {
        return "C";
    }

    protected double time(LuaTable luaTable) {
        Date time;
        if (luaTable == null) {
            time = new Date();
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, luaTable.get("year").checkint());
            calendar.set(2, luaTable.get("month").checkint() - 1);
            calendar.set(5, luaTable.get("day").checkint());
            calendar.set(11, luaTable.get("hour").optint(12));
            calendar.set(12, luaTable.get("min").optint(0));
            calendar.set(13, luaTable.get("sec").optint(0));
            calendar.set(14, 0);
            time = calendar.getTime();
        }
        return time.getTime() / 1000.0d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String tmpname() {
        Class cls;
        String stringBuffer;
        if (class$org$luaj$vm2$lib$OsLib == null) {
            cls = class$("org.luaj.vm2.lib.OsLib");
            class$org$luaj$vm2$lib$OsLib = cls;
        } else {
            cls = class$org$luaj$vm2$lib$OsLib;
        }
        synchronized (cls) {
            StringBuffer append = new StringBuffer().append(TMP_PREFIX);
            long j = tmpnames;
            tmpnames = 1 + j;
            stringBuffer = append.append(j).append(TMP_SUFFIX).toString();
        }
        return stringBuffer;
    }
}
