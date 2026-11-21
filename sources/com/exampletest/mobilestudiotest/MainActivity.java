package com.exampletest.mobilestudiotest;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.PlaceFactory;
import com.exampletest.mobilestudiotest.core.PluginButton;
import com.exampletest.mobilestudiotest.core.Recents;
import com.exampletest.mobilestudiotest.core.Settings;
import com.exampletest.mobilestudiotest.core.SolidModeling;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.core.Tool;
import com.exampletest.mobilestudiotest.engine.Avatar;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.format.RbxDocument;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.DataTypesKt;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Enums;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.Accounts;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import com.exampletest.mobilestudiotest.net.ImageLoader;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.net.WebPermissions;
import com.exampletest.mobilestudiotest.render.MaterialTextures;
import com.exampletest.mobilestudiotest.ui.AboutDialog;
import com.exampletest.mobilestudiotest.ui.AccountUi;
import com.exampletest.mobilestudiotest.ui.AvatarUi;
import com.exampletest.mobilestudiotest.ui.Dialogs;
import com.exampletest.mobilestudiotest.ui.DockLayout;
import com.exampletest.mobilestudiotest.ui.ExplorerPanel;
import com.exampletest.mobilestudiotest.ui.Fonts;
import com.exampletest.mobilestudiotest.ui.Icons;
import com.exampletest.mobilestudiotest.ui.MainActions;
import com.exampletest.mobilestudiotest.ui.OutputPanel;
import com.exampletest.mobilestudiotest.ui.PropertiesPanel;
import com.exampletest.mobilestudiotest.ui.ScriptEditor;
import com.exampletest.mobilestudiotest.ui.SettingsDialog;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import com.exampletest.mobilestudiotest.ui.ToolboxPanel;
import com.exampletest.mobilestudiotest.ui.Ui;
import com.exampletest.mobilestudiotest.ui.ViewportView;
import com.google.android.material.navigation.NavigationBarView;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Ò\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010P\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0014J\u0006\u0010S\u001a\u00020/J\b\u0010T\u001a\u00020/H\u0016J\b\u0010U\u001a\u00020EH\u0016J\u0010\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020/H\u0016J\u0010\u0010Z\u001a\u00020/2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020/H\u0016J\b\u0010^\u001a\u00020/H\u0002J.\u0010_\u001a\u00020/2\u0006\u0010`\u001a\u0002062\u0006\u0010a\u001a\u0002062\u0014\u0010b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0004\u0012\u00020/0cH\u0002J2\u0010d\u001a\u00020/2\u0006\u0010e\u001a\u0002062\f\u0010f\u001a\b\u0012\u0004\u0012\u000206052\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020/0cH\u0002J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0014J\u0012\u0010k\u001a\u00020/2\b\u0010l\u001a\u0004\u0018\u00010jH\u0002J\b\u0010m\u001a\u00020/H\u0014J\b\u0010n\u001a\u00020/H\u0014J\b\u0010q\u001a\u00020/H\u0014J\b\u0010r\u001a\u00020/H\u0002J\u0010\u0010s\u001a\u00020B2\u0006\u0010t\u001a\u00020uH\u0002J\u0010\u0010v\u001a\u00020/2\u0006\u0010w\u001a\u00020EH\u0002J\b\u0010x\u001a\u00020/H\u0002J\b\u0010y\u001a\u00020/H\u0002J\b\u0010z\u001a\u00020/H\u0016J\b\u0010{\u001a\u00020/H\u0002J\b\u0010|\u001a\u00020/H\u0002J\u001b\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u0002062\t\b\u0002\u0010\u0080\u0001\u001a\u000206H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020~2\u0007\u0010\u0082\u0001\u001a\u000206H\u0002J!\u0010\u0084\u0001\u001a\u00020/2\u0007\u0010\u0085\u0001\u001a\u0002062\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J5\u0010\u0087\u0001\u001a\u00020/2\u0007\u0010\u0088\u0001\u001a\u00020~2\u0007\u0010\u0089\u0001\u001a\u0002062\t\b\u0002\u0010\u008a\u0001\u001a\u00020E2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002JV\u0010\u008c\u0001\u001a\u00020/2E\u0010\u008d\u0001\u001a#\u0012\u001f\b\u0001\u0012\u001b\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u008e\u00010N\"\u001b\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u008e\u0001H\u0002¢\u0006\u0003\u0010\u008f\u0001J\t\u0010\u0090\u0001\u001a\u00020/H\u0002J\t\u0010\u0091\u0001\u001a\u00020EH\u0002J\u0011\u0010\u0092\u0001\u001a\u00020/2\u0006\u0010t\u001a\u00020EH\u0002J\u0012\u0010\u0093\u0001\u001a\u00020/2\u0007\u0010\u0082\u0001\u001a\u000206H\u0002J\u0012\u0010\u0094\u0001\u001a\u00020/2\u0007\u0010\u0082\u0001\u001a\u000206H\u0002J\t\u0010\u0095\u0001\u001a\u00020/H\u0002J\t\u0010\u0096\u0001\u001a\u00020/H\u0002J\t\u0010\u0097\u0001\u001a\u00020/H\u0002JW\u0010\u0098\u0001\u001a\u00020\u001a2\u0007\u0010\u0089\u0001\u001a\u0002062\u0007\u0010\u0099\u0001\u001a\u00020E2\u0007\u0010\u009a\u0001\u001a\u00020u2\u0007\u0010\u009b\u0001\u001a\u0002062\u0013\u0010\u009c\u0001\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020/0c2\u0013\u0010\u009d\u0001\u001a\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020/0cH\u0002J\u0013\u0010\u009e\u0001\u001a\u00020~2\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0002J\u001a\u0010¡\u0001\u001a\u00020/2\u000f\u0010¢\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060.H\u0002J\t\u0010£\u0001\u001a\u00020/H\u0002J\t\u0010¤\u0001\u001a\u00020/H\u0002J\t\u0010¥\u0001\u001a\u00020/H\u0002J\t\u0010¦\u0001\u001a\u00020/H\u0002J\t\u0010§\u0001\u001a\u00020/H\u0016J\t\u0010¨\u0001\u001a\u00020/H\u0016J\t\u0010©\u0001\u001a\u00020/H\u0016J\t\u0010ª\u0001\u001a\u00020/H\u0016J\t\u0010«\u0001\u001a\u00020/H\u0016J\t\u0010¬\u0001\u001a\u00020/H\u0016J\t\u0010\u00ad\u0001\u001a\u00020/H\u0002J\u0012\u0010®\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u00020:H\u0002J\t\u0010°\u0001\u001a\u00020/H\u0002J\u0012\u0010±\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u00020:H\u0002J\t\u0010²\u0001\u001a\u00020/H\u0002J\u0012\u0010³\u0001\u001a\u00020/2\u0007\u0010´\u0001\u001a\u00020\u001aH\u0002J\t\u0010µ\u0001\u001a\u00020/H\u0002J\t\u0010¶\u0001\u001a\u00020/H\u0002J\u0018\u0010·\u0001\u001a\u00020/2\r\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u0013\u0010¹\u0001\u001a\u0002062\b\u0010º\u0001\u001a\u00030»\u0001H\u0002J\u0013\u0010¼\u0001\u001a\u00020/2\b\u0010º\u0001\u001a\u00030»\u0001H\u0002J\t\u0010½\u0001\u001a\u00020/H\u0002J\u001c\u0010¾\u0001\u001a\u00020/2\u0011\b\u0002\u0010¸\u0001\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0002J\t\u0010¿\u0001\u001a\u00020/H\u0002J\t\u0010À\u0001\u001a\u00020/H\u0016J\t\u0010Á\u0001\u001a\u00020/H\u0016J\t\u0010Â\u0001\u001a\u00020/H\u0016J#\u0010Ã\u0001\u001a\u00020/2\u0007\u0010Ä\u0001\u001a\u0002062\u000f\u0010Å\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0.H\u0016J&\u0010Æ\u0001\u001a\u00020/2\u0006\u0010\u007f\u001a\u0002062\u0007\u0010Ç\u0001\u001a\u00020J2\n\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001H\u0016J\t\u0010Ê\u0001\u001a\u00020/H\u0016J\t\u0010Ë\u0001\u001a\u00020/H\u0016J\u0013\u0010Ì\u0001\u001a\u00020/2\b\u0010º\u0001\u001a\u00030»\u0001H\u0002J\t\u0010Í\u0001\u001a\u00020/H\u0002J\u0012\u0010Î\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u000206H\u0002J\u0013\u0010Ï\u0001\u001a\u00020E2\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010&\u001a\n (*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;09X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u0012\u0012\u0004\u0012\u00020:0=j\b\u0012\u0004\u0012\u00020:`>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0004\n\u0002\u0010FR\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060N0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\b\u0012\u0004\u0012\u0002060MX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010o\u001a(\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000206\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0004\u0012\u00020/0c\u0012\u0004\u0012\u00020/0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ó\u0001"}, d2 = {"Lcom/exampletest/mobilestudiotest/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/exampletest/mobilestudiotest/ui/MainActions;", "Lcom/exampletest/mobilestudiotest/core/Studio$Listener;", "Lcom/exampletest/mobilestudiotest/ui/StartScreen$Host;", "<init>", "()V", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "viewport", "Lcom/exampletest/mobilestudiotest/ui/ViewportView;", "explorer", "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;", "properties", "Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;", "output", "Lcom/exampletest/mobilestudiotest/ui/OutputPanel;", "toolbox", "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", "dock", "Lcom/exampletest/mobilestudiotest/ui/DockLayout;", "ribbon", "Landroid/widget/LinearLayout;", "ribbonScroll", "Landroid/widget/HorizontalScrollView;", "ribbonDivider", "Landroid/view/View;", "tabRow", "playButton", "Landroid/widget/TextView;", "hideBtn", "Landroid/widget/ImageView;", "titleView", "accountChip", "rootFrame", "Landroid/widget/FrameLayout;", "startScreen", "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", "layoutPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getLayoutPrefs", "()Landroid/content/SharedPreferences;", "layoutPrefs$delegate", "Lkotlin/Lazy;", "iconListener", "Lkotlin/Function0;", "", "accountListener", "scriptTabs", "scriptTabsScroll", "editorHost", "ribbonTabs", "", "", "ribbonTab", "openEditors", "Ljava/util/IdentityHashMap;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Lcom/exampletest/mobilestudiotest/ui/ScriptEditor;", "editorOrder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "activeScript", "keysDown", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "hiddenBeforePlay", "", "Ljava/lang/Boolean;", "openMode", "Lcom/exampletest/mobilestudiotest/MainActivity$OpenMode;", "pendingSave", "", "pendingSaveIsPlace", "openLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "createLauncher", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showStart", "closeStart", "hasOpenPlace", "newFromTemplate", "t", "Lcom/exampletest/mobilestudiotest/core/PlaceFactory$Template;", "openFileFromStart", "openRecentFile", "e", "Lcom/exampletest/mobilestudiotest/core/Recents$Entry;", "showStudioSettings", "refreshAccountChip", "askWebPermission", "host", "who", "answer", "Lkotlin/Function1;", "showPluginMenu", "title", "labels", "pick", "onNewIntent", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "handleIntent", "i", "onResume", "onPause", "webAsker", "Lkotlin/Function3;", "onDestroy", "buildUi", "dp", "v", "", "setAllHidden", "hidden", "updateHideButton", "refreshIcons", "applyThemeChange", "buildTabs", "sep", "g", "Landroid/graphics/drawable/Drawable;", "name", "fallback", "inst", "cls", "groupRow", "group", "caption", "fill", "tool", "icon", "label", "selected", "fn", "stack", "items", "Lkotlin/Triple;", "([Lkotlin/Triple;)V", "toolsGroup", "selectedPartsLocked", "setLockedOnSelection", "insertInto", "insertConstraint", "buildRibbon", "pickPartShape", "snapGroup", "snapRow", DebugKt.DEBUG_PROPERTY_VALUE_ON, "value", "unit", "toggle", "set", "pluginIcon", "b", "Lcom/exampletest/mobilestudiotest/core/PluginButton;", "solid", "op", "pickColorForSelection", "pickMaterialForSelection", "pickSurfaceForSelection", "togglePlay", "onPlayStateChanged", "onToolChanged", "onPluginsChanged", "onSelectionChanged", "onDirtyChanged", "onModelReplaced", "updateTitle", "openScript", "s", "showPlace", "closeScript", "rebuildScriptTabs", "showFileMenu", "anchor", "showSettings", "about", "confirmDiscard", "then", "displayName", "uri", "Landroid/net/Uri;", "onFilePicked", "closeAllScripts", "save", "saveAs", "exportSelection", "addSelectionToToolbox", "importToToolbox", "saveBytesAs", "fileName", "producer", "openPlaceBytes", "bytes", "cloud", "Lcom/exampletest/mobilestudiotest/net/CloudPlace;", "pickPluginFile", "pluginsChanged", "writeTo", "managePlugins", "toast", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "OpenMode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MainActivity extends AppCompatActivity implements MainActions, Studio.Listener, StartScreen.Host {
    private LinearLayout accountChip;
    private Instance activeScript;
    private DockLayout dock;
    private FrameLayout editorHost;
    private ExplorerPanel explorer;
    private LinearLayout groupRow;
    private Boolean hiddenBeforePlay;
    private ImageView hideBtn;
    private OutputPanel output;
    private Function0<byte[]> pendingSave;
    private boolean pendingSaveIsPlace;
    private TextView playButton;
    private PropertiesPanel properties;
    private LinearLayout ribbon;
    private View ribbonDivider;
    private HorizontalScrollView ribbonScroll;
    private FrameLayout rootFrame;
    private LinearLayout scriptTabs;
    private HorizontalScrollView scriptTabsScroll;
    private StartScreen startScreen;
    private Studio studio;
    private LinearLayout tabRow;
    private TextView titleView;
    private ToolboxPanel toolbox;
    private ViewportView viewport;

    /* renamed from: layoutPrefs$delegate, reason: from kotlin metadata */
    private final Lazy layoutPrefs = LazyKt.lazy(new MainActivity$$ExternalSyntheticLambda148(this));
    private final Function0<Unit> iconListener = new MainActivity$$ExternalSyntheticLambda149(this);
    private final Function0<Unit> accountListener = new MainActivity$$ExternalSyntheticLambda150(this);
    private final List<String> ribbonTabs = CollectionsKt.listOf((Object[]) new String[]{StartScreen.HOME, "Model", "Avatar", "UI", "Test", "View", "Plugins"});
    private String ribbonTab = StartScreen.HOME;
    private final IdentityHashMap<Instance, ScriptEditor> openEditors = new IdentityHashMap<>();
    private final ArrayList<Instance> editorOrder = new ArrayList<>();
    private final HashSet<Integer> keysDown = new HashSet<>();
    private OpenMode openMode = OpenMode.PLACE;
    private final ActivityResultLauncher<String[]> openLauncher = registerForActivityResult(new ActivityResultContracts.OpenDocument(), new MainActivity$$ExternalSyntheticLambda151(this));
    private final ActivityResultLauncher<String> createLauncher = registerForActivityResult(new ActivityResultContracts.CreateDocument("application/octet-stream"), new MainActivity$$ExternalSyntheticLambda152(this));
    private final Function3<String, String, Function1<? super Boolean, Unit>, Unit> webAsker = new MainActivity$$ExternalSyntheticLambda153(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/MainActivity$OpenMode;", "", "<init>", "(Ljava/lang/String;I)V", "PLACE", "TOOLBOX", "PLUGIN", "ICONS", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public enum OpenMode {
        PLACE,
        TOOLBOX,
        PLUGIN,
        ICONS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<OpenMode> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OpenMode.values().length];
            try {
                iArr[OpenMode.ICONS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OpenMode.PLUGIN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OpenMode.TOOLBOX.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[OpenMode.PLACE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void about() {
        AboutDialog.INSTANCE.show(this);
    }

    public static final /* synthetic */ void access$confirmDiscard(MainActivity mainActivity, Function0 function0) {
        mainActivity.confirmDiscard(function0);
    }

    public static final /* synthetic */ Instance access$getActiveScript$p(MainActivity mainActivity) {
        return mainActivity.activeScript;
    }

    public static final /* synthetic */ DockLayout access$getDock$p(MainActivity mainActivity) {
        return mainActivity.dock;
    }

    public static final /* synthetic */ StartScreen access$getStartScreen$p(MainActivity mainActivity) {
        return mainActivity.startScreen;
    }

    public static final /* synthetic */ Studio access$getStudio$p(MainActivity mainActivity) {
        return mainActivity.studio;
    }

    public static final /* synthetic */ ViewportView access$getViewport$p(MainActivity mainActivity) {
        return mainActivity.viewport;
    }

    public static final /* synthetic */ void access$setAllHidden(MainActivity mainActivity, boolean z) {
        mainActivity.setAllHidden(z);
    }

    public static final /* synthetic */ void access$showPlace(MainActivity mainActivity) {
        mainActivity.showPlace();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit accountListener$lambda$4(MainActivity mainActivity) {
        mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda82(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void accountListener$lambda$4$lambda$3(MainActivity mainActivity) {
        mainActivity.refreshAccountChip();
    }

    private final void askWebPermission(String host, String who, Function1<? super Boolean, Unit> answer) {
        if (isFinishing() || isDestroyed()) {
            answer.invoke(null);
            return;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        AlertDialog create = Dialogs.INSTANCE.themed(this).setTitle("Allow access to " + host + "?").setMessage(who + " wants to connect to " + host + " over the internet.\n\nIt could send that website things from the place you have open. Your Roblox sign-in is never shared with it.\n\nOnly allow websites you trust.").setPositiveButton("Allow", new MainActivity$$ExternalSyntheticLambda160(host, booleanRef, answer)).setNegativeButton("Block", new MainActivity$$ExternalSyntheticLambda161(host, booleanRef, answer)).create();
        create.setOnDismissListener(new MainActivity$$ExternalSyntheticLambda162(booleanRef, answer));
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void askWebPermission$lambda$17(String str, Ref.BooleanRef booleanRef, Function1 function1, DialogInterface dialogInterface, int i) {
        askWebPermission$reply(booleanRef, function1, true);
        OutputLog.INSTANCE.info("Allowed scripts and plugins to connect to " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void askWebPermission$lambda$18(String str, Ref.BooleanRef booleanRef, Function1 function1, DialogInterface dialogInterface, int i) {
        askWebPermission$reply(booleanRef, function1, false);
        OutputLog.INSTANCE.warn("Blocked scripts and plugins from connecting to " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void askWebPermission$lambda$19(Ref.BooleanRef booleanRef, Function1 function1, DialogInterface dialogInterface) {
        askWebPermission$reply(booleanRef, function1, null);
    }

    private static final void askWebPermission$reply(Ref.BooleanRef booleanRef, Function1<? super Boolean, Unit> function1, Boolean bool) {
        if (booleanRef.element) {
            return;
        }
        booleanRef.element = true;
        function1.invoke(bool);
    }

    private final void buildRibbon() {
        String str;
        Instance inst;
        Instance parent;
        ArrayList arrayList;
        LinearLayout linearLayout = this.ribbon;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbon");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        String str2 = this.ribbonTab;
        switch (str2.hashCode()) {
            case 2708:
                if (str2.equals("UI")) {
                    group("Containers", new MainActivity$$ExternalSyntheticLambda193(this));
                    group("Text & Images", new MainActivity$$ExternalSyntheticLambda194(this));
                    group("Style", new MainActivity$$ExternalSyntheticLambda195(this));
                    group("Layout", new MainActivity$$ExternalSyntheticLambda196(this));
                    group("3D UI", new MainActivity$$ExternalSyntheticLambda197(this));
                    return;
                }
                return;
            case 2255103:
                if (str2.equals(StartScreen.HOME)) {
                    group("Clipboard", new MainActivity$$ExternalSyntheticLambda188(this));
                    toolsGroup();
                    snapGroup();
                    group("Insert", new MainActivity$$ExternalSyntheticLambda199(this));
                    group("Edit", new MainActivity$$ExternalSyntheticLambda206(this));
                    group("Test", new MainActivity$$ExternalSyntheticLambda207(this));
                    return;
                }
                return;
            case 2603186:
                if (str2.equals("Test")) {
                    group("Play", new MainActivity$$ExternalSyntheticLambda198(this));
                    group("Output", new MainActivity$$ExternalSyntheticLambda200(this));
                    return;
                }
                return;
            case 2666181:
                if (str2.equals("View")) {
                    group("Windows", new MainActivity$$ExternalSyntheticLambda201(this));
                    group("Viewport", new MainActivity$$ExternalSyntheticLambda202(this));
                    group("Studio", new MainActivity$$ExternalSyntheticLambda203(this));
                    return;
                }
                return;
            case 74517257:
                if (str2.equals("Model")) {
                    toolsGroup();
                    snapGroup();
                    group("Parts", new MainActivity$$ExternalSyntheticLambda208(this));
                    group("Appearance", new MainActivity$$ExternalSyntheticLambda209(this));
                    group("Solid Modeling", new MainActivity$$ExternalSyntheticLambda210(this));
                    group(Constraints.TAG, new MainActivity$$ExternalSyntheticLambda211(this));
                    group("Effects", new MainActivity$$ExternalSyntheticLambda212(this));
                    group("Advanced", new MainActivity$$ExternalSyntheticLambda213(this));
                    group("Selection", new MainActivity$$ExternalSyntheticLambda189(this));
                    return;
                }
                return;
            case 1189023616:
                if (str2.equals("Plugins")) {
                    group("Plugins", new MainActivity$$ExternalSyntheticLambda204(this));
                    Studio studio = this.studio;
                    if (studio == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("studio");
                        studio = null;
                    }
                    CopyOnWriteArrayList<PluginButton> pluginButtons = studio.getPluginButtons();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj : pluginButtons) {
                        String pluginName = ((PluginButton) obj).getPluginName();
                        Object obj2 = linkedHashMap.get(pluginName);
                        if (obj2 == null) {
                            arrayList = new ArrayList();
                            linkedHashMap.put(pluginName, arrayList);
                        } else {
                            arrayList = obj2;
                        }
                        ((List) arrayList).add(obj);
                    }
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        String str3 = (String) entry.getKey();
                        List list = (List) entry.getValue();
                        PluginButton pluginButton = (PluginButton) CollectionsKt.firstOrNull(list);
                        if (pluginButton != null && (inst = pluginButton.getInst()) != null && (parent = inst.getParent()) != null && (str = parent.getName()) != null) {
                            if (!((StringsKt.isBlank(str) || Intrinsics.areEqual(str, "Plugin")) ? false : true)) {
                                str = null;
                            }
                            if (str != null) {
                                group(StringsKt.take(str, 22), new MainActivity$$ExternalSyntheticLambda205(list, this));
                            }
                        }
                        str = str3;
                        group(StringsKt.take(str, 22), new MainActivity$$ExternalSyntheticLambda205(list, this));
                    }
                    return;
                }
                return;
            case 1972874617:
                if (str2.equals("Avatar")) {
                    group("Game", new MainActivity$$ExternalSyntheticLambda190(this));
                    group("Rig Builder", new MainActivity$$ExternalSyntheticLambda191(this));
                    group("Playtest", new MainActivity$$ExternalSyntheticLambda192(this));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110(MainActivity mainActivity) {
        tool$default(mainActivity, g$default(mainActivity, "Color", null, 2, null), "Color", false, new MainActivity$$ExternalSyntheticLambda85(mainActivity), 4, null);
        tool$default(mainActivity, g$default(mainActivity, "Material", null, 2, null), "Material", false, new MainActivity$$ExternalSyntheticLambda86(mainActivity), 4, null);
        tool$default(mainActivity, g$default(mainActivity, "Group", null, 2, null), "Group", false, new MainActivity$$ExternalSyntheticLambda87(mainActivity), 4, null);
        mainActivity.tool(g$default(mainActivity, "Lock", null, 2, null), "Lock", mainActivity.selectedPartsLocked(), new MainActivity$$ExternalSyntheticLambda88(mainActivity));
        tool$default(mainActivity, g$default(mainActivity, "Anchor", null, 2, null), "Anchor", false, new MainActivity$$ExternalSyntheticLambda89(mainActivity), 4, null);
        mainActivity.stack(new Triple<>(g$default(mainActivity, "Ungroup", null, 2, null), "Ungroup", new MainActivity$$ExternalSyntheticLambda90(mainActivity)), new Triple<>(g$default(mainActivity, "Delete", null, 2, null), "Delete", new MainActivity$$ExternalSyntheticLambda91(mainActivity)), new Triple<>(mainActivity.g("ZoomTo", "Focus"), "Focus", new MainActivity$$ExternalSyntheticLambda92(mainActivity)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110$lambda$100(MainActivity mainActivity) {
        mainActivity.pickColorForSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110$lambda$101(MainActivity mainActivity) {
        mainActivity.pickMaterialForSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110$lambda$102(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.groupSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110$lambda$103(MainActivity mainActivity) {
        mainActivity.setLockedOnSelection(!mainActivity.selectedPartsLocked());
        mainActivity.buildRibbon();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110$lambda$106(MainActivity mainActivity) {
        boolean z;
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = mainActivity.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            List<Instance> selectedParts = studio3.selectedParts();
            if (!(selectedParts instanceof Collection) || !selectedParts.isEmpty()) {
                Iterator<T> it = selectedParts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    if (!Intrinsics.areEqual(((Instance) it.next()).get("Anchored"), (Object) true)) {
                        z = false;
                        break;
                    }
                }
            } else {
                z = true;
            }
        }
        Studio studio4 = mainActivity.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio4;
        }
        studio2.setAnchored(z ? false : true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110$lambda$107(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.ungroupSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110$lambda$108(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.deleteSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$110$lambda$109(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.focusSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$114(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Drawable g$default = studio.isPlaying() ? g$default(mainActivity, "Stop", null, 2, null) : g$default(mainActivity, "Play", null, 2, null);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        tool$default(mainActivity, g$default, studio3.isPlaying() ? "Stop" : "Play", false, new MainActivity$$ExternalSyntheticLambda19(mainActivity), 4, null);
        Studio studio4 = mainActivity.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio4;
        }
        if (!studio2.isPlaying()) {
            tool$default(mainActivity, mainActivity.g("Play", "Here"), "Play Here", false, new MainActivity$$ExternalSyntheticLambda20(mainActivity), 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$114$lambda$111(MainActivity mainActivity) {
        mainActivity.togglePlay();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$114$lambda$113(MainActivity mainActivity) {
        mainActivity.showPlace();
        Collection<ScriptEditor> values = mainActivity.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.playHere();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$124(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.g("Part_Block", "Block"), "Block", false, new MainActivity$$ExternalSyntheticLambda98(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("Part_Sphere", "Sphere"), "Sphere", false, new MainActivity$$ExternalSyntheticLambda99(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("Part_Cylinder", "Cylinder"), "Cylinder", false, new MainActivity$$ExternalSyntheticLambda100(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("Part_Wedge", "Wedge"), "Wedge", false, new MainActivity$$ExternalSyntheticLambda101(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("Part_CornerWedge", "Corner"), "Corner", false, new MainActivity$$ExternalSyntheticLambda102(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("TrussPart"), "Truss", false, new MainActivity$$ExternalSyntheticLambda103(mainActivity), 4, null);
        tool$default(mainActivity, g$default(mainActivity, "Spawn", null, 2, null), "Spawn", false, new MainActivity$$ExternalSyntheticLambda104(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$124$lambda$115(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.insertPart(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$124$lambda$116(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.insertPart(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$124$lambda$117(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.insertPart(2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$124$lambda$118(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.insertPart(3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$124$lambda$119(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.insertPart(4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$124$lambda$122(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Instance insertObject$default = Studio.insertObject$default(studio, "TrussPart", null, 2, null);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        synchronized (studio2.getLock()) {
            Instance.set$default(insertObject$default, "Anchored", true, false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$124$lambda$123(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "SpawnLocation", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$128(MainActivity mainActivity) {
        tool$default(mainActivity, g$default(mainActivity, "Color", null, 2, null), "Color", false, new MainActivity$$ExternalSyntheticLambda21(mainActivity), 4, null);
        tool$default(mainActivity, g$default(mainActivity, "Material", null, 2, null), "Material", false, new MainActivity$$ExternalSyntheticLambda22(mainActivity), 4, null);
        tool$default(mainActivity, g$default(mainActivity, "Surface", null, 2, null), "Surface", false, new MainActivity$$ExternalSyntheticLambda23(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$128$lambda$125(MainActivity mainActivity) {
        mainActivity.pickColorForSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$128$lambda$126(MainActivity mainActivity) {
        mainActivity.pickMaterialForSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$128$lambda$127(MainActivity mainActivity) {
        mainActivity.pickSurfaceForSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$137(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.g("Union", "Uni"), "Union", false, new MainActivity$$ExternalSyntheticLambda64(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("Intersect", "Int"), "Intersect", false, new MainActivity$$ExternalSyntheticLambda65(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("Negate", "Neg"), "Negate", false, new MainActivity$$ExternalSyntheticLambda66(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("Separate", "Sep"), "Separate", false, new MainActivity$$ExternalSyntheticLambda67(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$137$lambda$130(MainActivity mainActivity) {
        mainActivity.solid(new MainActivity$$ExternalSyntheticLambda131(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String buildRibbon$lambda$137$lambda$130$lambda$129(MainActivity mainActivity) {
        SolidModeling solidModeling = SolidModeling.INSTANCE;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        return solidModeling.combine(studio, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$137$lambda$132(MainActivity mainActivity) {
        mainActivity.solid(new MainActivity$$ExternalSyntheticLambda74(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String buildRibbon$lambda$137$lambda$132$lambda$131(MainActivity mainActivity) {
        SolidModeling solidModeling = SolidModeling.INSTANCE;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        return solidModeling.combine(studio, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$137$lambda$134(MainActivity mainActivity) {
        mainActivity.solid(new MainActivity$$ExternalSyntheticLambda47(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String buildRibbon$lambda$137$lambda$134$lambda$133(MainActivity mainActivity) {
        SolidModeling solidModeling = SolidModeling.INSTANCE;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        if (solidModeling.negate(studio) == 0) {
            return "Select the parts to negate.";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$137$lambda$136(MainActivity mainActivity) {
        mainActivity.solid(new MainActivity$$ExternalSyntheticLambda12(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String buildRibbon$lambda$137$lambda$136$lambda$135(MainActivity mainActivity) {
        SolidModeling solidModeling = SolidModeling.INSTANCE;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        return solidModeling.separate(studio);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$141(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("WeldConstraint"), "Weld", false, new MainActivity$$ExternalSyntheticLambda115(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("NoCollisionConstraint"), "No Collide", false, new MainActivity$$ExternalSyntheticLambda116(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("Attachment"), "Attachment", false, new MainActivity$$ExternalSyntheticLambda117(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$141$lambda$138(MainActivity mainActivity) {
        mainActivity.insertConstraint("WeldConstraint");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$141$lambda$139(MainActivity mainActivity) {
        mainActivity.insertConstraint("NoCollisionConstraint");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$141$lambda$140(MainActivity mainActivity) {
        mainActivity.insertInto("Attachment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$148(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("ParticleEmitter"), "Particles", false, new MainActivity$$ExternalSyntheticLambda133(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("Fire"), "Fire", false, new MainActivity$$ExternalSyntheticLambda134(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("Smoke"), "Smoke", false, new MainActivity$$ExternalSyntheticLambda135(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("Sparkles"), "Sparkles", false, new MainActivity$$ExternalSyntheticLambda136(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("PointLight"), "Light", false, new MainActivity$$ExternalSyntheticLambda137(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("Highlight"), "Highlight", false, new MainActivity$$ExternalSyntheticLambda138(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$148$lambda$142(MainActivity mainActivity) {
        mainActivity.insertInto("ParticleEmitter");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$148$lambda$143(MainActivity mainActivity) {
        mainActivity.insertInto("Fire");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$148$lambda$144(MainActivity mainActivity) {
        mainActivity.insertInto("Smoke");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$148$lambda$145(MainActivity mainActivity) {
        mainActivity.insertInto("Sparkles");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$148$lambda$146(MainActivity mainActivity) {
        mainActivity.insertInto("PointLight");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$148$lambda$147(MainActivity mainActivity) {
        mainActivity.insertInto("Highlight");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$156(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("Script"), "Script", false, new MainActivity$$ExternalSyntheticLambda9(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("LocalScript"), "LocalScript", false, new MainActivity$$ExternalSyntheticLambda10(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("ModuleScript"), "Module", false, new MainActivity$$ExternalSyntheticLambda11(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        if (r3 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit buildRibbon$lambda$156$lambda$150(com.exampletest.mobilestudiotest.MainActivity r8) {
        /*
            com.exampletest.mobilestudiotest.core.Studio r0 = r8.studio
            java.lang.String r1 = "studio"
            r2 = 0
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        Lb:
            com.exampletest.mobilestudiotest.core.Studio r3 = r8.studio
            if (r3 != 0) goto L13
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = r2
        L13:
            java.util.ArrayList r3 = r3.getSelection()
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            com.exampletest.mobilestudiotest.model.Instance r3 = (com.exampletest.mobilestudiotest.model.Instance) r3
            java.lang.String r4 = "ServerScriptService"
            if (r3 == 0) goto L3e
            r5 = r3
            r6 = 0
            boolean r7 = r5.getIsService()
            if (r7 == 0) goto L37
            java.lang.String r7 = r5.getClassName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            if (r7 != 0) goto L37
            r7 = 0
            goto L38
        L37:
            r7 = 1
        L38:
            if (r7 != 0) goto L3b
            r3 = r2
        L3b:
            if (r3 == 0) goto L3e
            goto L4f
        L3e:
            com.exampletest.mobilestudiotest.core.Studio r3 = r8.studio
            if (r3 != 0) goto L46
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L47
        L46:
            r2 = r3
        L47:
            com.exampletest.mobilestudiotest.model.DataModel r1 = r2.getModel()
            com.exampletest.mobilestudiotest.model.Instance r3 = r1.getService(r4)
        L4f:
            java.lang.String r1 = "Script"
            r0.insertObject(r1, r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.MainActivity.buildRibbon$lambda$156$lambda$150(com.exampletest.mobilestudiotest.MainActivity):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r3 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit buildRibbon$lambda$156$lambda$153(com.exampletest.mobilestudiotest.MainActivity r10) {
        /*
            com.exampletest.mobilestudiotest.core.Studio r0 = r10.studio
            java.lang.String r1 = "studio"
            r2 = 0
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        Lb:
            com.exampletest.mobilestudiotest.core.Studio r3 = r10.studio
            if (r3 != 0) goto L13
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = r2
        L13:
            java.util.ArrayList r3 = r3.getSelection()
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            com.exampletest.mobilestudiotest.model.Instance r3 = (com.exampletest.mobilestudiotest.model.Instance) r3
            r4 = 2
            r5 = 0
            if (r3 == 0) goto L3f
            r6 = r3
            r7 = 0
            boolean r8 = r6.getIsService()
            if (r8 == 0) goto L39
            java.lang.String r8 = r6.getClassName()
            java.lang.String r9 = "Starter"
            boolean r8 = kotlin.text.StringsKt.startsWith$default(r8, r9, r5, r4, r2)
            if (r8 != 0) goto L39
            r8 = r5
            goto L3a
        L39:
            r8 = 1
        L3a:
            if (r8 != 0) goto L3d
            r3 = r2
        L3d:
            if (r3 != 0) goto L5e
        L3f:
            com.exampletest.mobilestudiotest.core.Studio r3 = r10.studio
            if (r3 != 0) goto L47
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = r2
        L47:
            com.exampletest.mobilestudiotest.model.DataModel r1 = r3.getModel()
            java.lang.String r3 = "StarterPlayer"
            com.exampletest.mobilestudiotest.model.Instance r1 = r1.getService(r3)
            r3 = 0
            java.lang.String r6 = "StarterPlayerScripts"
            com.exampletest.mobilestudiotest.model.Instance r2 = com.exampletest.mobilestudiotest.model.Instance.findFirstChild$default(r1, r6, r5, r4, r2)
            if (r2 != 0) goto L5d
            r3 = r1
            goto L5e
        L5d:
            r3 = r2
        L5e:
            java.lang.String r1 = "LocalScript"
            r0.insertObject(r1, r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.MainActivity.buildRibbon$lambda$156$lambda$153(com.exampletest.mobilestudiotest.MainActivity):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        if (r3 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit buildRibbon$lambda$156$lambda$155(com.exampletest.mobilestudiotest.MainActivity r8) {
        /*
            com.exampletest.mobilestudiotest.core.Studio r0 = r8.studio
            java.lang.String r1 = "studio"
            r2 = 0
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        Lb:
            com.exampletest.mobilestudiotest.core.Studio r3 = r8.studio
            if (r3 != 0) goto L13
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = r2
        L13:
            java.util.ArrayList r3 = r3.getSelection()
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            com.exampletest.mobilestudiotest.model.Instance r3 = (com.exampletest.mobilestudiotest.model.Instance) r3
            java.lang.String r4 = "ReplicatedStorage"
            if (r3 == 0) goto L3e
            r5 = r3
            r6 = 0
            boolean r7 = r5.getIsService()
            if (r7 == 0) goto L37
            java.lang.String r7 = r5.getClassName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            if (r7 != 0) goto L37
            r7 = 0
            goto L38
        L37:
            r7 = 1
        L38:
            if (r7 != 0) goto L3b
            r3 = r2
        L3b:
            if (r3 == 0) goto L3e
            goto L4f
        L3e:
            com.exampletest.mobilestudiotest.core.Studio r3 = r8.studio
            if (r3 != 0) goto L46
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L47
        L46:
            r2 = r3
        L47:
            com.exampletest.mobilestudiotest.model.DataModel r1 = r2.getModel()
            com.exampletest.mobilestudiotest.model.Instance r3 = r1.getService(r4)
        L4f:
            java.lang.String r1 = "ModuleScript"
            r0.insertObject(r1, r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.MainActivity.buildRibbon$lambda$156$lambda$155(com.exampletest.mobilestudiotest.MainActivity):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$160(MainActivity mainActivity) {
        Drawable g = mainActivity.g("BoxSelect", "Box");
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        mainActivity.tool(g, "Box", studio.getBoxSelect(), new MainActivity$$ExternalSyntheticLambda154(mainActivity));
        Drawable g2 = mainActivity.g("SelectAll", "Multi");
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        mainActivity.tool(g2, "Multi", studio3.getMultiSelect(), new MainActivity$$ExternalSyntheticLambda155(mainActivity));
        Drawable inst = mainActivity.inst("Model");
        Studio studio4 = mainActivity.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio4;
        }
        mainActivity.tool(inst, "In Groups", studio2.getSelectInsideModels(), new MainActivity$$ExternalSyntheticLambda156(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$160$lambda$157(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio.setBoxSelect(!studio2.getBoxSelect());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$160$lambda$158(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio.setMultiSelect(!studio2.getMultiSelect());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$160$lambda$159(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio.setSelectInsideModels(!studio2.getSelectInsideModels());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$162(MainActivity mainActivity) {
        tool$default(mainActivity, g$default(mainActivity, "Settings", null, 2, null), "Game Settings", false, new MainActivity$$ExternalSyntheticLambda1(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$162$lambda$161(MainActivity mainActivity) {
        AvatarUi avatarUi = AvatarUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        avatarUi.gameSettings(mainActivity2, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$164(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("Humanoid"), "Rig Builder", false, new MainActivity$$ExternalSyntheticLambda186(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$164$lambda$163(MainActivity mainActivity) {
        AvatarUi avatarUi = AvatarUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        avatarUi.rigBuilder(mainActivity2, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$167(MainActivity mainActivity) {
        tool$default(mainActivity, g$default(mainActivity, "Account", null, 2, null), "Avatar", false, new MainActivity$$ExternalSyntheticLambda55(mainActivity), 4, null);
        mainActivity.tool(g$default(mainActivity, "Model", null, 2, null), "Character", Avatar.INSTANCE.mode(mainActivity) == Avatar.Mode.CHARACTER, new MainActivity$$ExternalSyntheticLambda56(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$167$lambda$165(MainActivity mainActivity) {
        AvatarUi avatarUi = AvatarUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        avatarUi.playtestAvatar(mainActivity2, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$167$lambda$166(MainActivity mainActivity) {
        AvatarUi avatarUi = AvatarUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        avatarUi.characterChooser(mainActivity2, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$172(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("ScreenGui"), "ScreenGui", false, new MainActivity$$ExternalSyntheticLambda144(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("Frame"), "Frame", false, new MainActivity$$ExternalSyntheticLambda145(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("ScrollingFrame"), "Scrolling", false, new MainActivity$$ExternalSyntheticLambda146(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("CanvasGroup"), "Canvas", false, new MainActivity$$ExternalSyntheticLambda147(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$172$lambda$168(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "ScreenGui", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$172$lambda$169(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "Frame", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$172$lambda$170(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "ScrollingFrame", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$172$lambda$171(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "CanvasGroup", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$178(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("TextLabel"), "TextLabel", false, new MainActivity$$ExternalSyntheticLambda125(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("TextButton"), "TextButton", false, new MainActivity$$ExternalSyntheticLambda126(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("TextBox"), "TextBox", false, new MainActivity$$ExternalSyntheticLambda127(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("ImageLabel"), "Image", false, new MainActivity$$ExternalSyntheticLambda128(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("ImageButton"), "ImageButton", false, new MainActivity$$ExternalSyntheticLambda129(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$178$lambda$173(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "TextLabel", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$178$lambda$174(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "TextButton", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$178$lambda$175(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "TextBox", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$178$lambda$176(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "ImageLabel", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$178$lambda$177(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "ImageButton", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$183(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("UICorner"), "Corner", false, new MainActivity$$ExternalSyntheticLambda110(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("UIStroke"), "Stroke", false, new MainActivity$$ExternalSyntheticLambda111(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("UIGradient"), "Gradient", false, new MainActivity$$ExternalSyntheticLambda112(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("UIPadding"), "Padding", false, new MainActivity$$ExternalSyntheticLambda113(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$183$lambda$179(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "UICorner", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$183$lambda$180(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "UIStroke", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$183$lambda$181(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "UIGradient", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$183$lambda$182(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "UIPadding", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$188(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("UIListLayout"), "List", false, new MainActivity$$ExternalSyntheticLambda15(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("UIGridLayout"), "Grid", false, new MainActivity$$ExternalSyntheticLambda16(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("UIAspectRatioConstraint"), "Aspect", false, new MainActivity$$ExternalSyntheticLambda17(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("UIScale"), "Scale", false, new MainActivity$$ExternalSyntheticLambda18(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$188$lambda$184(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "UIListLayout", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$188$lambda$185(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "UIGridLayout", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$188$lambda$186(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "UIAspectRatioConstraint", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$188$lambda$187(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertObject$default(studio, "UIScale", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$191(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.inst("BillboardGui"), "Billboard", false, new MainActivity$$ExternalSyntheticLambda24(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("SurfaceGui"), "SurfaceGui", false, new MainActivity$$ExternalSyntheticLambda25(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$191$lambda$189(MainActivity mainActivity) {
        mainActivity.insertInto("BillboardGui");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$191$lambda$190(MainActivity mainActivity) {
        mainActivity.insertInto("SurfaceGui");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$196(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Drawable g$default = studio.isPlaying() ? g$default(mainActivity, "Stop", null, 2, null) : g$default(mainActivity, "Play", null, 2, null);
        Studio studio2 = mainActivity.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio2 = null;
        }
        tool$default(mainActivity, g$default, studio2.isPlaying() ? "Stop" : "Play", false, new MainActivity$$ExternalSyntheticLambda107(mainActivity), 4, null);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        if (!studio3.isPlaying()) {
            tool$default(mainActivity, mainActivity.g("Play", "Here"), "Play Here", false, new MainActivity$$ExternalSyntheticLambda108(mainActivity), 4, null);
        }
        tool$default(mainActivity, g$default(mainActivity, "Account", null, 2, null), "Avatar", false, new MainActivity$$ExternalSyntheticLambda109(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$196$lambda$192(MainActivity mainActivity) {
        mainActivity.togglePlay();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$196$lambda$194(MainActivity mainActivity) {
        mainActivity.showPlace();
        Collection<ScriptEditor> values = mainActivity.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.playHere();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$196$lambda$195(MainActivity mainActivity) {
        AvatarUi avatarUi = AvatarUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        avatarUi.playtestAvatar(mainActivity2, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$199(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.g("Cleanup", "Clear"), "Clear Output", false, new MainActivity$$ExternalSyntheticLambda68(), 4, null);
        tool$default(mainActivity, mainActivity.g("CommandBar", "Cmd"), "Command", false, new MainActivity$$ExternalSyntheticLambda69(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$199$lambda$197() {
        OutputLog.INSTANCE.clear();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$199$lambda$198(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        DockLayout dockLayout2 = null;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        if (!dockLayout.isShown("output")) {
            DockLayout dockLayout3 = mainActivity.dock;
            if (dockLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dock");
            } else {
                dockLayout2 = dockLayout3;
            }
            dockLayout2.setShown("output", true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$206(MainActivity mainActivity) {
        DockLayout dockLayout = null;
        Drawable g$default = g$default(mainActivity, "Explorer", null, 2, null);
        DockLayout dockLayout2 = mainActivity.dock;
        if (dockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout2 = null;
        }
        mainActivity.tool(g$default, "Explorer", dockLayout2.isShown("explorer"), new MainActivity$$ExternalSyntheticLambda225(mainActivity));
        Drawable g$default2 = g$default(mainActivity, "Properties", null, 2, null);
        DockLayout dockLayout3 = mainActivity.dock;
        if (dockLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout3 = null;
        }
        mainActivity.tool(g$default2, "Properties", dockLayout3.isShown("properties"), new MainActivity$$ExternalSyntheticLambda226(mainActivity));
        Drawable g$default3 = g$default(mainActivity, "Toolbox", null, 2, null);
        DockLayout dockLayout4 = mainActivity.dock;
        if (dockLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout4 = null;
        }
        mainActivity.tool(g$default3, "Toolbox", dockLayout4.isShown("toolbox"), new MainActivity$$ExternalSyntheticLambda227(mainActivity));
        Drawable g$default4 = g$default(mainActivity, "Output", null, 2, null);
        DockLayout dockLayout5 = mainActivity.dock;
        if (dockLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout5 = null;
        }
        mainActivity.tool(g$default4, "Output", dockLayout5.isShown("output"), new MainActivity$$ExternalSyntheticLambda228(mainActivity));
        Drawable g$default5 = g$default(mainActivity, "HideWindows", null, 2, null);
        DockLayout dockLayout6 = mainActivity.dock;
        if (dockLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
        } else {
            dockLayout = dockLayout6;
        }
        mainActivity.tool(g$default5, "Hide All", dockLayout.getAllHidden(), new MainActivity$$ExternalSyntheticLambda229(mainActivity));
        tool$default(mainActivity, mainActivity.g("SwitchWindows", "Lay"), "Reset Layout", false, new MainActivity$$ExternalSyntheticLambda230(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$206$lambda$200(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        dockLayout.toggle("explorer");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$206$lambda$201(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        dockLayout.toggle("properties");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$206$lambda$202(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        dockLayout.toggle("toolbox");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$206$lambda$203(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        dockLayout.toggle("output");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$206$lambda$204(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        mainActivity.setAllHidden(!dockLayout.getAllHidden());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$206$lambda$205(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        dockLayout.reset();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$212(MainActivity mainActivity) {
        Drawable g = mainActivity.g("Effects", "Shd");
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        mainActivity.tool(g, "Shadows", studio.getShadowsEnabled(), new MainActivity$$ExternalSyntheticLambda139(mainActivity));
        tool$default(mainActivity, mainActivity.g("ViewSelector", "Cam"), "Reset Cam", false, new MainActivity$$ExternalSyntheticLambda140(mainActivity), 4, null);
        Drawable g$default = g$default(mainActivity, "Fly", null, 2, null);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        tool$default(mainActivity, g$default, "Fly x" + DataTypesKt.fmtNum(studio2.getFlySpeed()), false, new MainActivity$$ExternalSyntheticLambda141(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$212$lambda$207(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio.setShadowsEnabled(!studio2.getShadowsEnabled());
        mainActivity.buildRibbon();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$212$lambda$209(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = mainActivity.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            studio3.getCamera().setPos(new Vector3(0.0f, 20.0f, 40.0f));
            Studio studio4 = mainActivity.studio;
            if (studio4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio4 = null;
            }
            studio4.getCamera().setYaw(0.0f);
            Studio studio5 = mainActivity.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio5;
            }
            studio2.getCamera().setPitch(-0.4f);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$212$lambda$211(MainActivity mainActivity) {
        SettingsDialog.INSTANCE.pickFlySpeed(mainActivity, new MainActivity$$ExternalSyntheticLambda58(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$212$lambda$211$lambda$210(MainActivity mainActivity) {
        mainActivity.buildRibbon();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$214(MainActivity mainActivity) {
        tool$default(mainActivity, g$default(mainActivity, "Settings", null, 2, null), "Settings", false, new MainActivity$$ExternalSyntheticLambda122(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$214$lambda$213(MainActivity mainActivity) {
        mainActivity.showSettings();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$220(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.g("ManagePlugins", "Mgr"), "Manage", false, new MainActivity$$ExternalSyntheticLambda163(mainActivity), 4, null);
        tool$default(mainActivity, g$default(mainActivity, "Download", null, 2, null), "From Roblox", false, new MainActivity$$ExternalSyntheticLambda164(mainActivity), 4, null);
        tool$default(mainActivity, g$default(mainActivity, "Open", null, 2, null), "From File", false, new MainActivity$$ExternalSyntheticLambda165(mainActivity), 4, null);
        tool$default(mainActivity, g$default(mainActivity, "Toolbox", null, 2, null), "Store", false, new MainActivity$$ExternalSyntheticLambda166(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("PluginsFolder", "Rld"), "Reload", false, new MainActivity$$ExternalSyntheticLambda167(mainActivity), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$220$lambda$215(MainActivity mainActivity) {
        mainActivity.managePlugins();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$220$lambda$216(MainActivity mainActivity) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        AccountUi.installPluginFromRoblox$default(accountUi, mainActivity2, studio, mainActivity, null, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$220$lambda$217(MainActivity mainActivity) {
        mainActivity.pickPluginFile();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$220$lambda$218(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        ToolboxPanel toolboxPanel = null;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        dockLayout.setShown("toolbox", true);
        ToolboxPanel toolboxPanel2 = mainActivity.toolbox;
        if (toolboxPanel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbox");
        } else {
            toolboxPanel = toolboxPanel2;
        }
        toolboxPanel.showMarketplace(RobloxApi.Category.PLUGINS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$220$lambda$219(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.getPlugins().loadAll();
        OutputLog.INSTANCE.info("Plugins reloaded");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$225(List list, MainActivity mainActivity) {
        String name;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PluginButton pluginButton = (PluginButton) it.next();
            Object obj = pluginButton.getInst().get("Text");
            String str = obj instanceof String ? (String) obj : null;
            if (str != null) {
                String str2 = str;
                if (str2.length() == 0) {
                    str2 = pluginButton.getInst().getName();
                }
                name = str2;
                if (name != null) {
                    Intrinsics.checkNotNull(pluginButton);
                    mainActivity.tool(mainActivity.pluginIcon(pluginButton), StringsKt.take(name, 14), Intrinsics.areEqual(pluginButton.getInst().get("Active"), (Object) true), new MainActivity$$ExternalSyntheticLambda0(mainActivity, pluginButton));
                }
            }
            name = pluginButton.getInst().getName();
            Intrinsics.checkNotNull(pluginButton);
            mainActivity.tool(mainActivity.pluginIcon(pluginButton), StringsKt.take(name, 14), Intrinsics.areEqual(pluginButton.getInst().get("Active"), (Object) true), new MainActivity$$ExternalSyntheticLambda0(mainActivity, pluginButton));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$225$lambda$224(MainActivity mainActivity, PluginButton pluginButton) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Intrinsics.checkNotNull(pluginButton);
        studio.clickPluginButton(pluginButton);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$92(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.g("Paste", "Pst"), "Paste", false, new MainActivity$$ExternalSyntheticLambda93(mainActivity), 4, null);
        mainActivity.stack(new Triple<>(mainActivity.g("Copy", "Cp"), "Copy", new MainActivity$$ExternalSyntheticLambda94(mainActivity)), new Triple<>(mainActivity.g("Cut", "Cut"), "Cut", new MainActivity$$ExternalSyntheticLambda95(mainActivity)), new Triple<>(g$default(mainActivity, "Duplicate", null, 2, null), "Duplicate", new MainActivity$$ExternalSyntheticLambda96(mainActivity)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$92$lambda$88(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.paste(null);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio2.markDirty();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$92$lambda$89(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.copySelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$92$lambda$90(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.cutSelection();
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio2.markDirty();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$92$lambda$91(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.duplicateSelection();
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio2.markDirty();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$99(MainActivity mainActivity) {
        tool$default(mainActivity, mainActivity.g("Part_Block", "Part"), "Part", false, new MainActivity$$ExternalSyntheticLambda48(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("Script"), "Script", false, new MainActivity$$ExternalSyntheticLambda49(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.inst("ScreenGui"), "UI", false, new MainActivity$$ExternalSyntheticLambda50(mainActivity), 4, null);
        tool$default(mainActivity, mainActivity.g("InsertObject", "Insert"), "Object…", false, new MainActivity$$ExternalSyntheticLambda51(mainActivity), 4, null);
        DockLayout dockLayout = null;
        Drawable g$default = g$default(mainActivity, "Toolbox", null, 2, null);
        DockLayout dockLayout2 = mainActivity.dock;
        if (dockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
        } else {
            dockLayout = dockLayout2;
        }
        mainActivity.tool(g$default, "Toolbox", dockLayout.isShown("toolbox"), new MainActivity$$ExternalSyntheticLambda52(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$99$lambda$93(MainActivity mainActivity) {
        mainActivity.pickPartShape();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        if (r3 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit buildRibbon$lambda$99$lambda$95(com.exampletest.mobilestudiotest.MainActivity r8) {
        /*
            com.exampletest.mobilestudiotest.core.Studio r0 = r8.studio
            java.lang.String r1 = "studio"
            r2 = 0
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        Lb:
            com.exampletest.mobilestudiotest.core.Studio r3 = r8.studio
            if (r3 != 0) goto L13
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = r2
        L13:
            java.util.ArrayList r3 = r3.getSelection()
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            com.exampletest.mobilestudiotest.model.Instance r3 = (com.exampletest.mobilestudiotest.model.Instance) r3
            java.lang.String r4 = "ServerScriptService"
            if (r3 == 0) goto L3e
            r5 = r3
            r6 = 0
            boolean r7 = r5.getIsService()
            if (r7 == 0) goto L37
            java.lang.String r7 = r5.getClassName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            if (r7 != 0) goto L37
            r7 = 0
            goto L38
        L37:
            r7 = 1
        L38:
            if (r7 != 0) goto L3b
            r3 = r2
        L3b:
            if (r3 == 0) goto L3e
            goto L4f
        L3e:
            com.exampletest.mobilestudiotest.core.Studio r3 = r8.studio
            if (r3 != 0) goto L46
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L47
        L46:
            r2 = r3
        L47:
            com.exampletest.mobilestudiotest.model.DataModel r1 = r2.getModel()
            com.exampletest.mobilestudiotest.model.Instance r3 = r1.getService(r4)
        L4f:
            java.lang.String r1 = "Script"
            r0.insertObject(r1, r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.MainActivity.buildRibbon$lambda$99$lambda$95(com.exampletest.mobilestudiotest.MainActivity):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$99$lambda$96(MainActivity mainActivity) {
        mainActivity.ribbonTab = "UI";
        mainActivity.buildTabs();
        mainActivity.buildRibbon();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$99$lambda$97(MainActivity mainActivity) {
        ExplorerPanel explorerPanel = mainActivity.explorer;
        Studio studio = null;
        if (explorerPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("explorer");
            explorerPanel = null;
        }
        Studio studio2 = mainActivity.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio = studio2;
        }
        explorerPanel.showInsertDialog((Instance) CollectionsKt.firstOrNull((List) studio.getSelection()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildRibbon$lambda$99$lambda$98(MainActivity mainActivity) {
        DockLayout dockLayout = mainActivity.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        dockLayout.toggle("toolbox");
        return Unit.INSTANCE;
    }

    private final void buildTabs() {
        LinearLayout linearLayout = this.tabRow;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRow");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        for (String str : this.ribbonTabs) {
            TextView text = Ui.INSTANCE.text(this, str, 13.0f, Intrinsics.areEqual(str, this.ribbonTab) ? Ui.INSTANCE.getTEXT() : Ui.INSTANCE.getDIM(), Intrinsics.areEqual(str, this.ribbonTab));
            text.setPadding(dp(12.0f), dp(8.0f), dp(12.0f), dp(8.0f));
            text.setOnClickListener(new MainActivity$$ExternalSyntheticLambda84(this, str));
            if (Intrinsics.areEqual(str, this.ribbonTab)) {
                text.setBackgroundColor(Ui.INSTANCE.getRIBBON());
            }
            LinearLayout linearLayout2 = this.tabRow;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabRow");
                linearLayout2 = null;
            }
            linearLayout2.addView(text);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void buildTabs$lambda$63$lambda$62(MainActivity mainActivity, String str, View view) {
        mainActivity.ribbonTab = str;
        mainActivity.buildTabs();
        mainActivity.buildRibbon();
    }

    private final void buildUi() {
        DockLayout dockLayout;
        DockLayout dockLayout2;
        DockLayout dockLayout3;
        DockLayout dockLayout4;
        boolean z = getResources().getConfiguration().smallestScreenWidthDp < 600;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Ui.INSTANCE.getBG());
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackgroundColor(Ui.INSTANCE.getTOPBAR());
        TextView iconTextButton = Ui.INSTANCE.iconTextButton(this, null, "File", Ui.INSTANCE.getACCENT(), new MainActivity$$ExternalSyntheticLambda172(this));
        iconTextButton.setTextColor(-1);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
        lp$default.setMargins(dp(4.0f), dp(3.0f), dp(6.0f), dp(3.0f));
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(iconTextButton, lp$default);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        this.tabRow = linearLayout3;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout4 = this.tabRow;
        Studio studio = null;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRow");
            linearLayout4 = null;
        }
        horizontalScrollView.addView(linearLayout4);
        linearLayout2.addView(horizontalScrollView, Ui.INSTANCE.lp(0, -2, 1.0f));
        TextView text$default = Ui.text$default(Ui.INSTANCE, this, "", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setPadding(dp(8.0f), 0, dp(8.0f), 0);
        this.titleView = text$default;
        if (!z) {
            TextView textView = this.titleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
                textView = null;
            }
            linearLayout2.addView(textView);
        }
        this.hideBtn = Ui.iconButton$default(Ui.INSTANCE, this, g$default(this, "HideWindows", null, 2, null), 0.0f, new MainActivity$$ExternalSyntheticLambda173(this), 4, null);
        ImageView imageView = this.hideBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideBtn");
            imageView = null;
        }
        linearLayout2.addView(imageView);
        linearLayout2.addView(Ui.iconButton$default(Ui.INSTANCE, this, g$default(this, "Undo", null, 2, null), 0.0f, new MainActivity$$ExternalSyntheticLambda174(this), 4, null));
        linearLayout2.addView(Ui.iconButton$default(Ui.INSTANCE, this, g$default(this, "Redo", null, 2, null), 0.0f, new MainActivity$$ExternalSyntheticLambda175(this), 4, null));
        TextView iconTextButton2 = Ui.INSTANCE.iconTextButton(this, g$default(this, "Play", null, 2, null), "Play", -13726889, new MainActivity$$ExternalSyntheticLambda176(this));
        iconTextButton2.setTextColor(-1);
        this.playButton = iconTextButton2;
        TextView textView2 = this.playButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            textView2 = null;
        }
        LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
        lp$default2.setMargins(dp(6.0f), dp(3.0f), dp(4.0f), dp(3.0f));
        Unit unit2 = Unit.INSTANCE;
        linearLayout2.addView(textView2, lp$default2);
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setOrientation(0);
        linearLayout5.setGravity(16);
        linearLayout5.setPadding(dp(4.0f), dp(3.0f), dp(6.0f), dp(3.0f));
        linearLayout5.setBackground(Ui.INSTANCE.rippleBg(this, Ui.INSTANCE.getHOVER(), 14.0f));
        linearLayout5.setOnClickListener(new MainActivity$$ExternalSyntheticLambda177(this));
        this.accountChip = linearLayout5;
        LinearLayout linearLayout6 = this.accountChip;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountChip");
            linearLayout6 = null;
        }
        LinearLayout.LayoutParams lp$default3 = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
        lp$default3.setMargins(dp(2.0f), dp(3.0f), dp(6.0f), dp(3.0f));
        Unit unit3 = Unit.INSTANCE;
        linearLayout2.addView(linearLayout6, lp$default3);
        refreshAccountChip();
        linearLayout.addView(linearLayout2, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        LinearLayout linearLayout7 = new LinearLayout(this);
        linearLayout7.setOrientation(0);
        linearLayout7.setGravity(16);
        linearLayout7.setPadding(dp(4.0f), dp(2.0f), dp(4.0f), dp(2.0f));
        this.ribbon = linearLayout7;
        HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(this);
        horizontalScrollView2.setBackgroundColor(Ui.INSTANCE.getRIBBON());
        horizontalScrollView2.setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout8 = this.ribbon;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbon");
            linearLayout8 = null;
        }
        horizontalScrollView2.addView(linearLayout8);
        this.ribbonScroll = horizontalScrollView2;
        HorizontalScrollView horizontalScrollView3 = this.ribbonScroll;
        if (horizontalScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbonScroll");
            horizontalScrollView3 = null;
        }
        linearLayout.addView(horizontalScrollView3, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        this.ribbonDivider = Ui.divider$default(Ui.INSTANCE, this, false, 2, null);
        View view = this.ribbonDivider;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbonDivider");
            view = null;
        }
        linearLayout.addView(view);
        LinearLayout linearLayout9 = new LinearLayout(this);
        linearLayout9.setOrientation(1);
        LinearLayout linearLayout10 = new LinearLayout(this);
        linearLayout10.setOrientation(0);
        linearLayout10.setBackgroundColor(Ui.INSTANCE.getHEADER());
        this.scriptTabs = linearLayout10;
        HorizontalScrollView horizontalScrollView4 = new HorizontalScrollView(this);
        LinearLayout linearLayout11 = this.scriptTabs;
        if (linearLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scriptTabs");
            linearLayout11 = null;
        }
        horizontalScrollView4.addView(linearLayout11);
        horizontalScrollView4.setVisibility(8);
        this.scriptTabsScroll = horizontalScrollView4;
        HorizontalScrollView horizontalScrollView5 = this.scriptTabsScroll;
        if (horizontalScrollView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scriptTabsScroll");
            horizontalScrollView5 = null;
        }
        linearLayout9.addView(horizontalScrollView5, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        FrameLayout frameLayout = new FrameLayout(this);
        MainActivity mainActivity = this;
        Studio studio2 = this.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio2 = null;
        }
        this.viewport = new ViewportView(mainActivity, studio2);
        ViewportView viewportView = this.viewport;
        if (viewportView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
            viewportView = null;
        }
        frameLayout.addView(viewportView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.setVisibility(8);
        frameLayout2.setBackgroundColor(Ui.INSTANCE.getEDITOR_BG());
        this.editorHost = frameLayout2;
        FrameLayout frameLayout3 = this.editorHost;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorHost");
            frameLayout3 = null;
        }
        frameLayout.addView(frameLayout3, new FrameLayout.LayoutParams(-1, -1));
        linearLayout9.addView(frameLayout, Ui.INSTANCE.lp(-1, 0, 1.0f));
        MainActivity mainActivity2 = this;
        Studio studio3 = this.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        this.toolbox = new ToolboxPanel(mainActivity2, studio3, this);
        MainActivity mainActivity3 = this;
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        this.output = new OutputPanel(mainActivity3, studio4);
        MainActivity mainActivity4 = this;
        Studio studio5 = this.studio;
        if (studio5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio5 = null;
        }
        this.explorer = new ExplorerPanel(mainActivity4, studio5, this);
        MainActivity mainActivity5 = this;
        Studio studio6 = this.studio;
        if (studio6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio6 = null;
        }
        this.properties = new PropertiesPanel(mainActivity5, studio6);
        SharedPreferences layoutPrefs = getLayoutPrefs();
        Intrinsics.checkNotNullExpressionValue(layoutPrefs, "<get-layoutPrefs>(...)");
        this.dock = new DockLayout(this, layoutPrefs);
        DockLayout dockLayout5 = this.dock;
        if (dockLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout5 = null;
        }
        dockLayout5.setCenter(linearLayout9);
        DockLayout dockLayout6 = this.dock;
        if (dockLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        } else {
            dockLayout = dockLayout6;
        }
        ExplorerPanel explorerPanel = this.explorer;
        if (explorerPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("explorer");
            explorerPanel = null;
        }
        DockLayout.addPanel$default(dockLayout, "explorer", "Explorer", explorerPanel, DockLayout.Zone.RIGHT, 0, false, 32, null);
        DockLayout dockLayout7 = this.dock;
        if (dockLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout2 = null;
        } else {
            dockLayout2 = dockLayout7;
        }
        PropertiesPanel propertiesPanel = this.properties;
        if (propertiesPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
            propertiesPanel = null;
        }
        DockLayout.addPanel$default(dockLayout2, "properties", "Properties", propertiesPanel, DockLayout.Zone.RIGHT, 1, false, 32, null);
        DockLayout dockLayout8 = this.dock;
        if (dockLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout3 = null;
        } else {
            dockLayout3 = dockLayout8;
        }
        ToolboxPanel toolboxPanel = this.toolbox;
        if (toolboxPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbox");
            toolboxPanel = null;
        }
        dockLayout3.addPanel("toolbox", "Toolbox", toolboxPanel, DockLayout.Zone.LEFT, 0, !z);
        DockLayout dockLayout9 = this.dock;
        if (dockLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout4 = null;
        } else {
            dockLayout4 = dockLayout9;
        }
        OutputPanel outputPanel = this.output;
        if (outputPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("output");
            outputPanel = null;
        }
        dockLayout4.addPanel("output", "Output", outputPanel, DockLayout.Zone.BOTTOM, 0, !z);
        DockLayout dockLayout10 = this.dock;
        if (dockLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout10 = null;
        }
        dockLayout10.setOnChanged(new MainActivity$$ExternalSyntheticLambda178(this));
        DockLayout dockLayout11 = this.dock;
        if (dockLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout11 = null;
        }
        linearLayout.addView(dockLayout11, Ui.INSTANCE.lp(-1, 0, 1.0f));
        DockLayout dockLayout12 = this.dock;
        if (dockLayout12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout12 = null;
        }
        dockLayout12.load();
        FrameLayout frameLayout4 = new FrameLayout(this);
        frameLayout4.setBackgroundColor(Ui.INSTANCE.getBG());
        this.rootFrame = frameLayout4;
        FrameLayout frameLayout5 = this.rootFrame;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootFrame");
            frameLayout5 = null;
        }
        frameLayout5.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout6 = this.rootFrame;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootFrame");
            frameLayout6 = null;
        }
        setContentView(frameLayout6);
        FrameLayout frameLayout7 = this.rootFrame;
        if (frameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootFrame");
            frameLayout7 = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(frameLayout7, new MainActivity$$ExternalSyntheticLambda179());
        buildTabs();
        buildRibbon();
        updateTitle();
        updateHideButton();
        Studio studio7 = this.studio;
        if (studio7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio = studio7;
        }
        if (studio.isPlaying()) {
            onPlayStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildUi$lambda$36(MainActivity mainActivity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mainActivity.showFileMenu(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildUi$lambda$42(MainActivity mainActivity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DockLayout dockLayout = mainActivity.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        mainActivity.setAllHidden(!dockLayout.getAllHidden());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildUi$lambda$43(MainActivity mainActivity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.getUndo().undo();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildUi$lambda$44(MainActivity mainActivity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.getUndo().redo();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildUi$lambda$45(MainActivity mainActivity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mainActivity.togglePlay();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void buildUi$lambda$49$lambda$48(MainActivity mainActivity, View view) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        accountUi.show(mainActivity2, studio, mainActivity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildUi$lambda$57(MainActivity mainActivity) {
        if (Intrinsics.areEqual(mainActivity.ribbonTab, "View")) {
            mainActivity.buildRibbon();
        }
        mainActivity.updateHideButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final WindowInsetsCompat buildUi$lambda$59(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        return insets;
    }

    private final void closeAllScripts() {
        Iterator it = CollectionsKt.toList(this.editorOrder).iterator();
        while (it.hasNext()) {
            closeScript((Instance) it.next());
        }
    }

    private final void closeScript(Instance s) {
        ScriptEditor remove = this.openEditors.remove(s);
        if (remove != null) {
            remove.commit();
        }
        this.editorOrder.remove(s);
        if (this.activeScript == s) {
            FrameLayout frameLayout = null;
            this.activeScript = null;
            FrameLayout frameLayout2 = this.editorHost;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorHost");
                frameLayout2 = null;
            }
            frameLayout2.removeAllViews();
            FrameLayout frameLayout3 = this.editorHost;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorHost");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.setVisibility(8);
        }
        rebuildScriptTabs();
    }

    private final void confirmDiscard(Function0<Unit> then) {
        StringBuilder append;
        String str;
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        if (!studio.getDirty()) {
            then.invoke();
            return;
        }
        Studio studio2 = this.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio2 = null;
        }
        CloudPlace cloud = studio2.getCloud();
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(this).setTitle("Unsaved changes");
        if (cloud != null) {
            append = new StringBuilder().append("Save changes to “").append(cloud.getName());
            str = "” on Roblox?";
        } else {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            append = new StringBuilder().append("Save changes to ").append(studio3.getFileName());
            str = "?";
        }
        title.setMessage(append.append(str).toString()).setPositiveButton("Save", new MainActivity$$ExternalSyntheticLambda72(cloud, this, then)).setNegativeButton("Discard", new MainActivity$$ExternalSyntheticLambda73(then)).setNeutralButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void confirmDiscard$lambda$298(CloudPlace cloudPlace, MainActivity mainActivity, Function0 function0, DialogInterface dialogInterface, int i) {
        if (cloudPlace != null) {
            mainActivity.save(function0);
        } else {
            save$default(mainActivity, null, 1, null);
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void confirmDiscard$lambda$299(Function0 function0, DialogInterface dialogInterface, int i) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void createLauncher$lambda$6(MainActivity mainActivity, Uri uri) {
        if (uri != null) {
            mainActivity.writeTo(uri);
        }
    }

    private static final float dispatchKeyEvent$k(MainActivity mainActivity, int i) {
        return mainActivity.keysDown.contains(Integer.valueOf(i)) ? 1.0f : 0.0f;
    }

    private final String displayName(Uri uri) {
        Uri uri2;
        try {
            uri2 = uri;
            try {
                Cursor query = getContentResolver().query(uri2, new String[]{"_display_name"}, null, null, null);
                if (query != null) {
                    Cursor cursor = query;
                    try {
                        Cursor cursor2 = cursor;
                        r1 = cursor2.moveToFirst() ? cursor2.getString(0) : null;
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(cursor, null);
                    } catch (Throwable th) {
                        String str = r1;
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                CloseableKt.closeFinally(cursor, th);
                                throw th2;
                            } catch (Exception e) {
                                r1 = str;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            uri2 = uri;
        }
        if (r1 != null) {
            return r1;
        }
        String lastPathSegment = uri2.getLastPathSegment();
        String substringAfterLast$default = lastPathSegment != null ? StringsKt.substringAfterLast$default(lastPathSegment, '/', (String) null, 2, (Object) null) : null;
        return substringAfterLast$default == null ? "file" : substringAfterLast$default;
    }

    private final int dp(float v) {
        return Ui.INSTANCE.dp(this, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] exportSelection$lambda$319(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        return studio.serializeSelection();
    }

    private final Drawable g(String name, String fallback) {
        return Icons.INSTANCE.general(this, name, fallback);
    }

    static /* synthetic */ Drawable g$default(MainActivity mainActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return mainActivity.g(str, str2);
    }

    private final SharedPreferences getLayoutPrefs() {
        return (SharedPreferences) this.layoutPrefs.getValue();
    }

    private final void group(String caption, Function0<Unit> fill) {
        LinearLayout linearLayout = this.ribbon;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbon");
            linearLayout = null;
        }
        if (linearLayout.getChildCount() > 0) {
            sep();
        }
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams lp = Ui.INSTANCE.lp(-2, 0, 1.0f);
        lp.gravity = 1;
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(linearLayout3, lp);
        TextView text$default = Ui.text$default(Ui.INSTANCE, this, caption, 9.5f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default.setGravity(17);
        linearLayout2.addView(text$default, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        LinearLayout linearLayout4 = this.ribbon;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbon");
            linearLayout4 = null;
        }
        linearLayout4.addView(linearLayout2, new LinearLayout.LayoutParams(-2, dp(66.0f)));
        this.groupRow = linearLayout3;
        try {
            fill.invoke();
        } finally {
            this.groupRow = null;
        }
    }

    private final void handleIntent(Intent i) {
        Uri data;
        String stringExtra;
        String stringExtra2;
        boolean z = (getApplicationInfo().flags & 2) != 0;
        Studio studio = null;
        if (i != null && (stringExtra2 = i.getStringExtra("lua")) != null && z) {
            Studio studio2 = this.studio;
            if (studio2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio2 = null;
            }
            studio2.getGlJobs().add(new MainActivity$$ExternalSyntheticLambda168(this, stringExtra2));
        }
        if (z) {
            if (i != null && i.getBooleanExtra("play", false)) {
                Studio studio3 = this.studio;
                if (studio3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio3 = null;
                }
                studio3.getMain().post(new MainActivity$$ExternalSyntheticLambda169(this));
            }
        }
        if (z) {
            if (i != null && i.getBooleanExtra("stop", false)) {
                Studio studio4 = this.studio;
                if (studio4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio4 = null;
                }
                studio4.getMain().post(new MainActivity$$ExternalSyntheticLambda170(this));
            }
        }
        if (i != null && (stringExtra = i.getStringExtra("playas")) != null && z) {
            Studio studio5 = this.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio = studio5;
            }
            studio.getMain().post(new MainActivity$$ExternalSyntheticLambda171(this, stringExtra));
        }
        if (i == null || (data = i.getData()) == null || !Intrinsics.areEqual(i.getAction(), "android.intent.action.VIEW")) {
            return;
        }
        this.openMode = OpenMode.PLACE;
        onFilePicked(data);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit handleIntent$lambda$24$lambda$23(MainActivity mainActivity, String str) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.runCommand(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void handleIntent$lambda$25(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.startPlay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void handleIntent$lambda$26(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void handleIntent$lambda$30$lambda$29(MainActivity mainActivity, String str) {
        Instance findFirstChild$default;
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = mainActivity.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            findFirstChild$default = Instance.findFirstChild$default(studio3.getModel().getWorkspace(), str, false, 2, null);
        }
        if (findFirstChild$default != null) {
            Studio studio4 = mainActivity.studio;
            if (studio4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio4;
            }
            studio2.playAs(findFirstChild$default);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit iconListener$lambda$2(MainActivity mainActivity) {
        mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda57(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void iconListener$lambda$2$lambda$1(MainActivity mainActivity) {
        mainActivity.refreshIcons();
    }

    private final void insertConstraint(String cls) {
        List<Instance> selectedParts;
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            selectedParts = studio3.selectedParts();
        }
        if (selectedParts.size() < 2) {
            toast("Select the two parts to join");
            return;
        }
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        synchronized (studio4.getLock()) {
            Instance instance = selectedParts.get(0);
            Instance instance2 = selectedParts.get(1);
            Instance create = InstanceFactory.INSTANCE.create(cls);
            create.set("Part0", instance, false);
            create.set("Part1", instance2, false);
            if (Intrinsics.areEqual(cls, "Weld")) {
                create.set("C0", CFrame.INSTANCE.getIDENTITY(), false);
                create.set("C1", PartData.INSTANCE.cframe(instance2).inverse().times(PartData.INSTANCE.cframe(instance)), false);
            }
            Studio studio5 = this.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio5 = null;
            }
            studio5.getUndo().begin("Insert " + cls);
            Studio studio6 = this.studio;
            if (studio6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio6 = null;
            }
            studio6.reparent(create, instance);
            Studio studio7 = this.studio;
            if (studio7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio7 = null;
            }
            studio7.getUndo().commit();
            Studio studio8 = this.studio;
            if (studio8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio8 = null;
            }
            studio8.getSelection().clear();
            Studio studio9 = this.studio;
            if (studio9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio9 = null;
            }
            studio9.getSelection().add(create);
        }
        Studio studio10 = this.studio;
        if (studio10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio10 = null;
        }
        Iterator<T> it = studio10.getListeners().iterator();
        while (it.hasNext()) {
            ((Studio.Listener) it.next()).onSelectionChanged();
        }
        Studio studio11 = this.studio;
        if (studio11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio11;
        }
        studio2.markDirty();
        toast("Joined " + selectedParts.get(0).getName() + " and " + selectedParts.get(1).getName() + " with a " + cls);
    }

    private final void insertInto(String cls) {
        Object obj;
        Instance instance;
        Instance instance2;
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            Iterator<T> it = studio3.getSelection().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Instance instance3 = (Instance) obj;
                if (instance3.isA("BasePart") || Intrinsics.areEqual(instance3.getClassName(), "Attachment")) {
                    break;
                }
            }
            instance = (Instance) obj;
        }
        if (instance == null && !Intrinsics.areEqual(cls, "Model")) {
            toast("Select a part to put the " + cls + " in (added to Workspace)");
        }
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        if (instance == null) {
            Studio studio5 = this.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio5 = null;
            }
            instance2 = studio5.getModel().getWorkspace();
        } else {
            instance2 = instance;
        }
        studio4.insertObject(cls, instance2);
        Studio studio6 = this.studio;
        if (studio6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio6;
        }
        studio2.markDirty();
    }

    private final Drawable inst(String cls) {
        return Icons.INSTANCE.instance(this, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SharedPreferences layoutPrefs_delegate$lambda$0(MainActivity mainActivity) {
        return mainActivity.getSharedPreferences("layout", 0);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [android.app.AlertDialog, T] */
    private final void managePlugins() {
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        List<File> list = studio.getPlugins().list();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(16.0f), dp(6.0f), dp(16.0f), 0);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (list.isEmpty()) {
            TextView text$default = Ui.text$default(Ui.INSTANCE, this, "No plugins installed.\n\nInstall one from the Creator Store (Toolbox → Plugins), from a Roblox asset ID or link (like an assetdelivery.roblox.com URL), or from a file — .rbxm, .rbxmx, a .bin downloaded from Roblox, or .lua.", 13.0f, 0, false, 24, null);
            text$default.setSingleLine(false);
            linearLayout.addView(text$default);
        }
        for (File file : list) {
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout2.setPadding(0, dp(4.0f), 0, dp(4.0f));
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(inst("Plugin"));
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, dp(20.0f), dp(20.0f), 0.0f, 4, null);
            lp$default.rightMargin = dp(8.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout2.addView(imageView, lp$default);
            linearLayout2.addView(Ui.text$default(Ui.INSTANCE, this, FilesKt.getNameWithoutExtension(file), 14.0f, 0, false, 24, null), Ui.INSTANCE.lp(0, -2, 1.0f));
            Switch r9 = new Switch(this);
            Studio studio2 = this.studio;
            if (studio2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio2 = null;
            }
            r9.setChecked(studio2.getPlugins().isEnabled(file));
            r9.setOnCheckedChangeListener(new MainActivity$$ExternalSyntheticLambda214(this, file));
            linearLayout2.addView(r9);
            linearLayout2.addView(Ui.iconButton$default(Ui.INSTANCE, this, g$default(this, "Delete", null, 2, null), 0.0f, new MainActivity$$ExternalSyntheticLambda215(this, file, objectRef), 4, null));
            linearLayout.addView(linearLayout2);
        }
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(this).setTitle("Plugins");
        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(linearLayout);
        Unit unit2 = Unit.INSTANCE;
        objectRef.element = title.setView(scrollView).setPositiveButton("From Roblox…", new MainActivity$$ExternalSyntheticLambda216(this)).setNeutralButton("From file…", new MainActivity$$ExternalSyntheticLambda217(this)).setNegativeButton("Close", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void managePlugins$lambda$340$lambda$339(MainActivity mainActivity, File file, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.getPlugins().setEnabled(file, z);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio2.getPlugins().loadAll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit managePlugins$lambda$342(MainActivity mainActivity, File file, Ref.ObjectRef objectRef, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Dialogs.INSTANCE.confirm(mainActivity, "Remove plugin", "Uninstall " + FilesKt.getNameWithoutExtension(file) + "?", "Remove", new MainActivity$$ExternalSyntheticLambda75(mainActivity, file, objectRef));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit managePlugins$lambda$342$lambda$341(MainActivity mainActivity, File file, Ref.ObjectRef objectRef) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.getPlugins().remove(file);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio2.getPlugins().loadAll();
        mainActivity.buildRibbon();
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        mainActivity.managePlugins();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void managePlugins$lambda$344(MainActivity mainActivity, DialogInterface dialogInterface, int i) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        AccountUi.installPluginFromRoblox$default(accountUi, mainActivity2, studio, mainActivity, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void managePlugins$lambda$345(MainActivity mainActivity, DialogInterface dialogInterface, int i) {
        mainActivity.pickPluginFile();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit newFromTemplate$lambda$13(MainActivity mainActivity, PlaceFactory.Template template) {
        mainActivity.closeAllScripts();
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.newPlace(template);
        Application application = mainActivity.getApplication();
        StudioApp studioApp = application instanceof StudioApp ? (StudioApp) application : null;
        if (studioApp != null) {
            studioApp.setPlaceOpened(true);
        }
        mainActivity.closeStart();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$10(MainActivity mainActivity, Instance s) {
        Intrinsics.checkNotNullParameter(s, "s");
        mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda46(mainActivity, s));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$10$lambda$9(MainActivity mainActivity, Instance instance) {
        mainActivity.openScript(instance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$11(MainActivity mainActivity, String title, List labels, Function1 pick) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(labels, "labels");
        Intrinsics.checkNotNullParameter(pick, "pick");
        mainActivity.showPluginMenu(title, labels, pick);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$8(MainActivity mainActivity, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Toast.makeText(mainActivity, it, 0).show();
        return Unit.INSTANCE;
    }

    private final void onFilePicked(Uri uri) {
        OpenMode openMode = this.openMode;
        String displayName = displayName(uri);
        if (openMode == OpenMode.PLACE) {
            try {
                getContentResolver().takePersistableUriPermission(uri, 3);
            } catch (Exception e) {
                try {
                    getContentResolver().takePersistableUriPermission(uri, 1);
                } catch (Exception e2) {
                }
            }
        }
        toast("Loading " + displayName + "…");
        if (openMode == OpenMode.ICONS) {
            new Thread(new MainActivity$$ExternalSyntheticLambda76(this, uri)).start();
        } else {
            new Thread(new MainActivity$$ExternalSyntheticLambda77(this, uri, openMode, displayName)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$304(MainActivity mainActivity, Uri uri) {
        try {
            InputStream openInputStream = mainActivity.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new Exception("Could not read file");
            }
            InputStream inputStream = openInputStream;
            try {
                Icons icons = Icons.INSTANCE;
                Context applicationContext = mainActivity.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                int importZip = icons.importZip(applicationContext, inputStream);
                CloseableKt.closeFinally(inputStream, null);
                mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda184(mainActivity, importZip));
            } finally {
            }
        } catch (Exception e) {
            mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda185(mainActivity, e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$304$lambda$302(MainActivity mainActivity, int i) {
        mainActivity.toast("Installed " + i + " icons");
        OutputLog.INSTANCE.info("Icon pack installed (" + i + " icons)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$304$lambda$303(MainActivity mainActivity, Exception exc) {
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(mainActivity).setTitle("Couldn't import icons");
        String message = exc.getMessage();
        if (message == null) {
            message = String.valueOf(exc);
        }
        title.setMessage(message).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$313(MainActivity mainActivity, Uri uri, OpenMode openMode, String str) {
        String str2;
        InputStream openInputStream;
        try {
            openInputStream = mainActivity.getContentResolver().openInputStream(uri);
            try {
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            str2 = str;
        }
        if (openInputStream != null) {
            InputStream inputStream = openInputStream;
            try {
                byte[] readBytes = ByteStreamsKt.readBytes(inputStream);
                Studio studio = null;
                CloseableKt.closeFinally(inputStream, null);
                if (readBytes != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[openMode.ordinal()]) {
                        case 1:
                            return;
                        case 2:
                            Studio studio2 = mainActivity.studio;
                            if (studio2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("studio");
                            } else {
                                studio = studio2;
                            }
                            mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda4(mainActivity, studio.getPlugins().install(str, readBytes)));
                            return;
                        case 3:
                            RbxDocument read = RbxFile.INSTANCE.read(readBytes);
                            if (RbxFile.INSTANCE.isPlace(read)) {
                                throw new Exception("This is a place file. Use File → Open to open places; the Toolbox holds models (.rbxm).");
                            }
                            Instance instance = (Instance) CollectionsKt.firstOrNull((List) read.getRoots());
                            mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda5(mainActivity, str, readBytes, instance != null ? instance.getClassName() : null));
                            return;
                        case 4:
                            RbxDocument read2 = RbxFile.INSTANCE.read(readBytes);
                            boolean z = !RbxFile.INSTANCE.isBinary(RbxFile.INSTANCE.unwrap(readBytes));
                            Iterator it = CollectionsKt.take(read2.getWarnings(), 20).iterator();
                            while (it.hasNext()) {
                                OutputLog.INSTANCE.warn((String) it.next());
                            }
                            if (read2.getWarnings().size() > 20) {
                                OutputLog.INSTANCE.warn("…and " + (read2.getWarnings().size() - 20) + " more warnings");
                            }
                            if (!RbxFile.INSTANCE.isPlace(read2)) {
                                mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda7(mainActivity, read2, str));
                                return;
                            } else {
                                DataModel fromDocument = PlaceFactory.INSTANCE.fromDocument(read2);
                                mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda6(mainActivity, fromDocument, uri, str, z, Instance.descendants$default(fromDocument, null, 1, null).size()));
                                return;
                            }
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    e = e2;
                    str2 = str;
                    OutputLog.INSTANCE.error("Failed to open " + str2 + ": " + e.getMessage());
                    mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda8(mainActivity, str2, e));
                    return;
                }
            } catch (Throwable th) {
                str2 = str;
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
        throw new Exception("Could not read file");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$313$lambda$306(MainActivity mainActivity, File file) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.getPlugins().load(file);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio2.notifyPluginButtons();
        mainActivity.pluginsChanged();
        mainActivity.toast("Installed " + FilesKt.getNameWithoutExtension(file));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$313$lambda$307(MainActivity mainActivity, String str, byte[] bArr, String str2) {
        ToolboxPanel toolboxPanel = mainActivity.toolbox;
        DockLayout dockLayout = null;
        if (toolboxPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbox");
            toolboxPanel = null;
        }
        toolboxPanel.saveToLibrary(str, RbxFile.INSTANCE.unwrap(bArr), str2);
        DockLayout dockLayout2 = mainActivity.dock;
        if (dockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
        } else {
            dockLayout = dockLayout2;
        }
        dockLayout.setShown("toolbox", true);
        mainActivity.toast("Added " + str + " to Toolbox");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$313$lambda$310(MainActivity mainActivity, DataModel dataModel, Uri uri, String str, boolean z, int i) {
        mainActivity.confirmDiscard(new MainActivity$$ExternalSyntheticLambda45(mainActivity, dataModel, uri, str, z, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onFilePicked$lambda$313$lambda$310$lambda$309(MainActivity mainActivity, DataModel dataModel, Uri uri, String str, boolean z, int i) {
        mainActivity.closeAllScripts();
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.replaceEditModel$default(studio, dataModel, uri, str, z, null, 16, null);
        Recents.INSTANCE.add(mainActivity, new Recents.Entry(str, 0L, 0L, uri.toString(), 0L, 0L, 54, null));
        OutputLog.INSTANCE.info("Opened " + str + " (" + i + " instances)");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$313$lambda$311(MainActivity mainActivity, RbxDocument rbxDocument, String str) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.insertDocument$default(studio, rbxDocument, null, 2, null);
        OutputLog.INSTANCE.info("Inserted " + rbxDocument.getRoots().size() + " object(s) from " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFilePicked$lambda$313$lambda$312(MainActivity mainActivity, String str, Exception exc) {
        Dialogs.INSTANCE.themed(mainActivity).setTitle("Couldn't open file").setMessage(str + "\n\n" + exc.getMessage()).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openLauncher$lambda$5(MainActivity mainActivity, Uri uri) {
        if (uri != null) {
            mainActivity.onFilePicked(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openPlaceBytes$lambda$329(byte[] bArr, MainActivity mainActivity, String str, CloudPlace cloudPlace) {
        MainActivity mainActivity2;
        String str2;
        DataModel fromDocument;
        try {
            RbxDocument read = RbxFile.INSTANCE.read(bArr);
            Iterator it = CollectionsKt.take(read.getWarnings(), 10).iterator();
            while (it.hasNext()) {
                try {
                    OutputLog.INSTANCE.warn((String) it.next());
                } catch (Exception e) {
                    e = e;
                    mainActivity2 = mainActivity;
                    str2 = str;
                    OutputLog.INSTANCE.error("Failed to open " + str2 + ": " + e.getMessage());
                    mainActivity2.runOnUiThread(new MainActivity$$ExternalSyntheticLambda71(mainActivity2, e));
                }
            }
            fromDocument = PlaceFactory.INSTANCE.fromDocument(read);
            mainActivity2 = mainActivity;
            str2 = str;
        } catch (Exception e2) {
            e = e2;
            mainActivity2 = mainActivity;
            str2 = str;
        }
        try {
            mainActivity2.runOnUiThread(new MainActivity$$ExternalSyntheticLambda70(mainActivity2, fromDocument, str2, cloudPlace, Instance.descendants$default(fromDocument, null, 1, null).size()));
        } catch (Exception e3) {
            e = e3;
            OutputLog.INSTANCE.error("Failed to open " + str2 + ": " + e.getMessage());
            mainActivity2.runOnUiThread(new MainActivity$$ExternalSyntheticLambda71(mainActivity2, e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openPlaceBytes$lambda$329$lambda$327(MainActivity mainActivity, DataModel dataModel, String str, CloudPlace cloudPlace, int i) {
        mainActivity.confirmDiscard(new MainActivity$$ExternalSyntheticLambda13(mainActivity, dataModel, str, cloudPlace, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit openPlaceBytes$lambda$329$lambda$327$lambda$326(MainActivity mainActivity, DataModel dataModel, String str, CloudPlace cloudPlace, int i) {
        Studio studio;
        String str2;
        mainActivity.closeAllScripts();
        Studio studio2 = mainActivity.studio;
        Studio studio3 = null;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        } else {
            studio = studio2;
        }
        studio.replaceEditModel(dataModel, null, str, false, cloudPlace);
        OutputLog outputLog = OutputLog.INSTANCE;
        if (cloudPlace == null || (str2 = cloudPlace.getName()) == null) {
            str2 = str;
        }
        outputLog.info("Opened " + str2 + " from Roblox (" + i + " instances)");
        if (cloudPlace != null) {
            AvatarUi avatarUi = AvatarUi.INSTANCE;
            MainActivity mainActivity2 = mainActivity;
            Studio studio4 = mainActivity.studio;
            if (studio4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio3 = studio4;
            }
            avatarUi.syncFromCloud(mainActivity2, studio3, cloudPlace);
        }
        mainActivity.updateTitle();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openPlaceBytes$lambda$329$lambda$328(MainActivity mainActivity, Exception exc) {
        Dialogs.INSTANCE.themed(mainActivity).setTitle("Couldn't open place").setMessage(exc.getMessage()).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
    }

    private final void openScript(Instance s) {
        ScriptEditor scriptEditor;
        if (s.isA("LuaSourceContainer")) {
            IdentityHashMap<Instance, ScriptEditor> identityHashMap = this.openEditors;
            ScriptEditor scriptEditor2 = identityHashMap.get(s);
            FrameLayout frameLayout = null;
            if (scriptEditor2 == null) {
                this.editorOrder.add(s);
                MainActivity mainActivity = this;
                Studio studio = this.studio;
                if (studio == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio = null;
                }
                scriptEditor = new ScriptEditor(mainActivity, studio, s);
                identityHashMap.put(s, scriptEditor);
            } else {
                scriptEditor = scriptEditor2;
            }
            ScriptEditor scriptEditor3 = scriptEditor;
            this.activeScript = s;
            FrameLayout frameLayout2 = this.editorHost;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorHost");
                frameLayout2 = null;
            }
            frameLayout2.removeAllViews();
            FrameLayout frameLayout3 = this.editorHost;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorHost");
                frameLayout3 = null;
            }
            frameLayout3.addView(scriptEditor3, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout4 = this.editorHost;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorHost");
            } else {
                frameLayout = frameLayout4;
            }
            frameLayout.setVisibility(0);
            rebuildScriptTabs();
        }
    }

    private final void pickColorForSelection() {
        List<Instance> selectedParts;
        Color3 color;
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            selectedParts = studio3.selectedParts();
        }
        if (selectedParts.isEmpty()) {
            toast("Select a part first");
            return;
        }
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio4;
        }
        synchronized (studio2.getLock()) {
            color = PartData.INSTANCE.color(selectedParts.get(0));
        }
        Dialogs.INSTANCE.colorPicker(this, "Color", color, new MainActivity$$ExternalSyntheticLambda121(this, selectedParts));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit pickColorForSelection$lambda$248(MainActivity mainActivity, List list, Object obj) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = mainActivity.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            studio3.getUndo().begin("Color");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Instance instance = (Instance) it.next();
                String str = (instance.getProps().containsKey("Color3uint8") || !instance.getProps().containsKey("Color")) ? "Color3uint8" : "Color";
                Studio studio4 = mainActivity.studio;
                if (studio4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio4 = null;
                }
                studio4.setProp(instance, str, obj);
                instance.getPropTypes().putIfAbsent(str, 26);
            }
            Studio studio5 = mainActivity.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio5;
            }
            studio2.getUndo().commit();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void pickMaterialForSelection() {
        List<Instance> selectedParts;
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio3;
            }
            selectedParts = studio2.selectedParts();
        }
        if (selectedParts.isEmpty()) {
            toast("Select a part first");
            return;
        }
        LinkedHashMap<String, Integer> linkedHashMap = Enums.INSTANCE.getTypes().get("Material");
        Intrinsics.checkNotNull(linkedHashMap);
        Set<Map.Entry<String, Integer>> entrySet = linkedHashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Map.Entry entry = (Map.Entry) next;
            if (!Intrinsics.areEqual(entry.getKey(), "Air") && !Intrinsics.areEqual(entry.getKey(), "Water")) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(this).setTitle("Material");
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add((String) ((Map.Entry) it2.next()).getKey());
        }
        title.setItems((CharSequence[]) arrayList4.toArray(new String[0]), new MainActivity$$ExternalSyntheticLambda54(this, selectedParts, arrayList2)).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pickMaterialForSelection$lambda$253(MainActivity mainActivity, List list, List list2, DialogInterface dialogInterface, int i) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = mainActivity.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            studio3.getUndo().begin("Material");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Instance instance = (Instance) it.next();
                Studio studio4 = mainActivity.studio;
                if (studio4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio4 = null;
                }
                Object value = ((Map.Entry) list2.get(i)).getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                studio4.setProp(instance, "Material", new EnumValue(((Number) value).intValue()));
            }
            Studio studio5 = mainActivity.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio5;
            }
            studio2.getUndo().commit();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void pickPartShape() {
        List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Block", 1), TuplesKt.to("Sphere", 0), TuplesKt.to("Wedge", 3), TuplesKt.to("Corner Wedge", 4), TuplesKt.to("Cylinder", 2)});
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(this).setTitle("Part");
        List list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList.toArray(new String[0]), new MainActivity$$ExternalSyntheticLambda14(this, listOf)).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pickPartShape$lambda$227(MainActivity mainActivity, List list, DialogInterface dialogInterface, int i) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.insertPart(((Number) ((Pair) list.get(i)).getSecond()).intValue());
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio3;
        }
        studio2.markDirty();
    }

    private final void pickSurfaceForSelection() {
        List<Instance> selectedParts;
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio2 = this.studio;
            if (studio2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio2 = null;
            }
            selectedParts = studio2.selectedParts();
        }
        if (selectedParts.isEmpty()) {
            toast("Select a part first");
            return;
        }
        List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("All faces", null), TuplesKt.to("Top", "TopSurface"), TuplesKt.to("Bottom", "BottomSurface"), TuplesKt.to("Front", "FrontSurface"), TuplesKt.to("Back", "BackSurface"), TuplesKt.to("Left", "LeftSurface"), TuplesKt.to("Right", "RightSurface")});
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(this).setTitle("Surface — which face?");
        List list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        title.setItems((CharSequence[]) arrayList.toArray(new String[0]), new MainActivity$$ExternalSyntheticLambda114(this, listOf, selectedParts)).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pickSurfaceForSelection$lambda$261(MainActivity mainActivity, List list, List list2, DialogInterface dialogInterface, int i) {
        LinkedHashMap<String, Integer> linkedHashMap = Enums.INSTANCE.getTypes().get("SurfaceType");
        Intrinsics.checkNotNull(linkedHashMap);
        Set<Map.Entry<String, Integer>> entrySet = linkedHashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        List list3 = CollectionsKt.toList(entrySet);
        AlertDialog.Builder title = Dialogs.INSTANCE.themed(mainActivity).setTitle(((Pair) list.get(i)).getFirst() + ": surface type");
        List list4 = list3;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        title.setItems((CharSequence[]) arrayList.toArray(new String[0]), new MainActivity$$ExternalSyntheticLambda83(list, i, mainActivity, list2, list3)).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pickSurfaceForSelection$lambda$261$lambda$260(List list, int i, MainActivity mainActivity, List list2, List list3, DialogInterface dialogInterface, int i2) {
        List list4;
        String str = (String) ((Pair) list.get(i)).getSecond();
        if (str == null || (list4 = CollectionsKt.listOf(str)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) ((Pair) it.next()).getSecond();
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            list4 = arrayList;
        }
        List<String> list5 = list4;
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            try {
                Studio studio3 = mainActivity.studio;
                if (studio3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio3 = null;
                }
                studio3.getUndo().begin("Surface");
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    Instance instance = (Instance) it2.next();
                    for (String str3 : list5) {
                        Studio studio4 = mainActivity.studio;
                        if (studio4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                            studio4 = null;
                        }
                        try {
                            Object value = ((Map.Entry) list3.get(i2)).getValue();
                            Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                            studio4.setProp(instance, str3, new EnumValue(((Number) value).intValue()));
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                }
                Studio studio5 = mainActivity.studio;
                if (studio5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                } else {
                    studio2 = studio5;
                }
                studio2.getUndo().commit();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private final Drawable pluginIcon(PluginButton b) {
        Object obj = b.getInst().get("Icon");
        if (obj == null) {
            obj = b.getInst().get("Image");
        }
        Bitmap bitmap = ImageLoader.INSTANCE.get(obj != null ? obj.toString() : null);
        return bitmap != null ? new BitmapDrawable(getResources(), bitmap) : inst("Plugin");
    }

    private final void rebuildScriptTabs() {
        LinearLayout linearLayout = this.scriptTabs;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scriptTabs");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        HorizontalScrollView horizontalScrollView = this.scriptTabsScroll;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scriptTabsScroll");
            horizontalScrollView = null;
        }
        horizontalScrollView.setVisibility(this.editorOrder.isEmpty() ? 8 : 0);
        if (this.editorOrder.isEmpty()) {
            return;
        }
        Drawable g$default = g$default(this, "Place", null, 2, null);
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        rebuildScriptTabs$tab(this, g$default, StringsKt.substringBeforeLast$default(studio.getFileName(), '.', (String) null, 2, (Object) null), this.activeScript == null, new MainActivity$$ExternalSyntheticLambda157(this), null);
        Iterator<Instance> it = this.editorOrder.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            rebuildScriptTabs$tab(this, Ui.INSTANCE.icon(this, next), next.getName(), next == this.activeScript, new MainActivity$$ExternalSyntheticLambda158(this, next), new MainActivity$$ExternalSyntheticLambda159(this, next));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rebuildScriptTabs$lambda$271(MainActivity mainActivity) {
        mainActivity.showPlace();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rebuildScriptTabs$lambda$272(MainActivity mainActivity, Instance instance) {
        mainActivity.openScript(instance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rebuildScriptTabs$lambda$273(MainActivity mainActivity, Instance instance) {
        mainActivity.closeScript(instance);
        return Unit.INSTANCE;
    }

    private static final void rebuildScriptTabs$tab(MainActivity mainActivity, Drawable drawable, String str, boolean z, Function0<Unit> function0, Function0<Unit> function02) {
        LinearLayout linearLayout = new LinearLayout(mainActivity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        Ui ui = Ui.INSTANCE;
        linearLayout.setBackgroundColor(z ? ui.getEDITOR_BG() : ui.getHEADER());
        linearLayout.setPadding(mainActivity.dp(10.0f), mainActivity.dp(3.0f), mainActivity.dp(4.0f), mainActivity.dp(3.0f));
        linearLayout.setOnClickListener(new MainActivity$$ExternalSyntheticLambda123(function0));
        ImageView imageView = new ImageView(mainActivity);
        imageView.setImageDrawable(drawable);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, mainActivity.dp(16.0f), mainActivity.dp(16.0f), 0.0f, 4, null);
        lp$default.rightMargin = mainActivity.dp(6.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, lp$default);
        Ui ui2 = Ui.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Ui ui3 = Ui.INSTANCE;
        linearLayout.addView(Ui.text$default(ui2, mainActivity2, str, 12.0f, z ? ui3.getTEXT() : ui3.getDIM(), false, 16, null));
        if (function02 != null) {
            linearLayout.addView(Ui.INSTANCE.iconButton(mainActivity, Icons.INSTANCE.ui(mainActivity, "CloseWidget", "x"), 26.0f, new MainActivity$$ExternalSyntheticLambda124(function02)));
        } else {
            linearLayout.addView(new View(mainActivity), Ui.lp$default(Ui.INSTANCE, mainActivity.dp(8.0f), mainActivity.dp(26.0f), 0.0f, 4, null));
        }
        LinearLayout linearLayout2 = mainActivity.scriptTabs;
        LinearLayout linearLayout3 = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scriptTabs");
            linearLayout2 = null;
        }
        linearLayout2.addView(linearLayout);
        LinearLayout linearLayout4 = mainActivity.scriptTabs;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scriptTabs");
        } else {
            linearLayout3 = linearLayout4;
        }
        linearLayout3.addView(Ui.INSTANCE.divider(mainActivity, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void rebuildScriptTabs$tab$lambda$267$lambda$266(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rebuildScriptTabs$tab$lambda$270(Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:
    
        if (r7 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void refreshAccountChip() {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.MainActivity.refreshAccountChip():void");
    }

    private final void refreshIcons() {
        Collection<ScriptEditor> values = this.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
        recreate();
    }

    private final void save(Function0<Unit> then) {
        Collection<ScriptEditor> values = this.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        if (studio.isPlaying()) {
            toast("Stop the playtest before saving");
            return;
        }
        Studio studio3 = this.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        if (studio3.getCloud() != null) {
            AccountUi accountUi = AccountUi.INSTANCE;
            MainActivity mainActivity = this;
            Studio studio4 = this.studio;
            if (studio4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio4;
            }
            accountUi.saveToRoblox(mainActivity, studio2, then);
            return;
        }
        Studio studio5 = this.studio;
        if (studio5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio5 = null;
        }
        Uri fileUri = studio5.getFileUri();
        if (fileUri != null) {
            Studio studio6 = this.studio;
            if (studio6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio6 = null;
            }
            if (!studio6.getFileIsXml()) {
                Studio studio7 = this.studio;
                if (studio7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio7 = null;
                }
                String lowerCase = studio7.getFileName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.endsWith$default(lowerCase, ".rbxl", false, 2, (Object) null)) {
                    this.pendingSave = new MainActivity$$ExternalSyntheticLambda130(this);
                    this.pendingSaveIsPlace = true;
                    writeTo(fileUri);
                    return;
                }
            }
        }
        saveAs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void save$default(MainActivity mainActivity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        mainActivity.save(function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] save$lambda$315(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        return studio.serializePlace();
    }

    private final void saveAs() {
        Collection<ScriptEditor> values = this.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
        this.pendingSave = new MainActivity$$ExternalSyntheticLambda132(this);
        this.pendingSaveIsPlace = true;
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        this.createLauncher.launch(StringsKt.substringBeforeLast$default(studio.getFileName(), '.', (String) null, 2, (Object) null) + ".rbxl");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] saveAs$lambda$317(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        return studio.serializePlace();
    }

    private final boolean selectedPartsLocked() {
        boolean z;
        boolean z2;
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio3;
            }
            List<Instance> selectedParts = studio2.selectedParts();
            z = false;
            if (!selectedParts.isEmpty()) {
                List<Instance> list = selectedParts;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = true;
                            break;
                        }
                        if (!Intrinsics.areEqual(((Instance) it.next()).get("Locked"), (Object) true)) {
                            z2 = false;
                            break;
                        }
                    }
                } else {
                    z2 = true;
                }
                if (z2) {
                    z = true;
                }
            }
        }
        return z;
    }

    private final void sep() {
        LinearLayout linearLayout = this.ribbon;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbon");
            linearLayout = null;
        }
        View view = new View(this);
        view.setBackgroundColor(Ui.INSTANCE.getBORDER());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp(1.0f), dp(52.0f));
        layoutParams.setMargins(dp(4.0f), 0, dp(4.0f), 0);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(view, layoutParams);
    }

    private final void setAllHidden(boolean hidden) {
        DockLayout dockLayout = this.dock;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        dockLayout.setAllHidden(hidden);
        updateHideButton();
    }

    private final void setLockedOnSelection(boolean v) {
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            List<Instance> selectedParts = studio3.selectedParts();
            if (selectedParts.isEmpty()) {
                return;
            }
            Studio studio4 = this.studio;
            if (studio4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio4 = null;
            }
            studio4.getUndo().begin(v ? "Lock" : "Unlock");
            for (Instance instance : selectedParts) {
                Studio studio5 = this.studio;
                if (studio5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio5 = null;
                }
                studio5.setProp(instance, "Locked", Boolean.valueOf(v));
            }
            Studio studio6 = this.studio;
            if (studio6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio6 = null;
            }
            studio6.getUndo().commit();
            Unit unit = Unit.INSTANCE;
            Studio studio7 = this.studio;
            if (studio7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio7;
            }
            studio2.markDirty();
            toast(v ? "Locked: these parts can't be picked in the 3D view (select them in the Explorer)" : "Unlocked");
        }
    }

    private final void showFileMenu(View anchor) {
        String str;
        PopupMenu popupMenu = new PopupMenu(Ui.INSTANCE.popupContext(this), anchor);
        boolean z = RobloxApi.INSTANCE.cookie(this).length() > 0;
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        CloudPlace cloud = studio.getCloud();
        Pair[] pairArr = new Pair[18];
        pairArr[0] = TuplesKt.to("Home (Start Page)", new MainActivity$$ExternalSyntheticLambda26(this));
        pairArr[1] = TuplesKt.to("New Place", new MainActivity$$ExternalSyntheticLambda36(this));
        pairArr[2] = TuplesKt.to("Open File… (.rbxl / .rbxm)", new MainActivity$$ExternalSyntheticLambda37(this));
        pairArr[3] = TuplesKt.to("Open from Roblox (My Games)…", new MainActivity$$ExternalSyntheticLambda38(this));
        pairArr[4] = TuplesKt.to(cloud != null ? "Save to Roblox" : "Save", new MainActivity$$ExternalSyntheticLambda39(this));
        pairArr[5] = TuplesKt.to(cloud != null ? "Save a Copy to This Device…" : "Save As…", new MainActivity$$ExternalSyntheticLambda40(this));
        pairArr[6] = TuplesKt.to(cloud != null ? "Publish to Roblox (" + cloud.getName() + ")" : "Publish to Roblox…", new MainActivity$$ExternalSyntheticLambda41(this));
        pairArr[7] = TuplesKt.to("Publish to Roblox As…", new MainActivity$$ExternalSyntheticLambda42(this));
        pairArr[8] = TuplesKt.to(cloud != null ? "Download / Version History (" + cloud.getName() + ")…" : "Download Game / Old Version…", new MainActivity$$ExternalSyntheticLambda43(this));
        pairArr[9] = TuplesKt.to("Export Selection (.rbxm)…", new MainActivity$$ExternalSyntheticLambda44(this));
        pairArr[10] = TuplesKt.to("Import Model into Toolbox…", new MainActivity$$ExternalSyntheticLambda27(this));
        pairArr[11] = TuplesKt.to("Install Plugin from Roblox (ID or link)…", new MainActivity$$ExternalSyntheticLambda28(this));
        pairArr[12] = TuplesKt.to("Install Plugin from File…", new MainActivity$$ExternalSyntheticLambda29(this));
        pairArr[13] = TuplesKt.to("Playtest Avatar…", new MainActivity$$ExternalSyntheticLambda30(this));
        pairArr[14] = TuplesKt.to("Game Settings (Avatar: R6 / R15)…", new MainActivity$$ExternalSyntheticLambda31(this));
        pairArr[15] = TuplesKt.to("Studio Settings…", new MainActivity$$ExternalSyntheticLambda32(this));
        if (z) {
            String userName = RobloxApi.INSTANCE.userName(this);
            if (userName.length() == 0) {
                userName = "signed in";
            }
            str = "Roblox Account (@" + ((Object) userName) + ")…";
        } else {
            str = "Sign in to Roblox…";
        }
        pairArr[16] = TuplesKt.to(str, new MainActivity$$ExternalSyntheticLambda33(this));
        pairArr[17] = TuplesKt.to("About Mobile Studio (v" + ((Object) AboutDialog.INSTANCE.version(this).getFirst()) + ")", new MainActivity$$ExternalSyntheticLambda34(this));
        List listOfNotNull = CollectionsKt.listOfNotNull((Object[]) pairArr);
        int i = 0;
        for (Object obj : listOfNotNull) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            popupMenu.getMenu().add(0, i, i, (String) ((Pair) obj).component1());
            i = i2;
        }
        popupMenu.setOnMenuItemClickListener(new MainActivity$$ExternalSyntheticLambda35(listOfNotNull));
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$274(MainActivity mainActivity) {
        mainActivity.showStart();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$276(MainActivity mainActivity) {
        mainActivity.confirmDiscard(new MainActivity$$ExternalSyntheticLambda187(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$276$lambda$275(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio.newPlace$default(studio, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$277(MainActivity mainActivity) {
        mainActivity.openMode = OpenMode.PLACE;
        mainActivity.openLauncher.launch(new String[]{"*/*"});
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$278(MainActivity mainActivity) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        AccountUi.myGames$default(accountUi, mainActivity2, studio, mainActivity, null, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$279(MainActivity mainActivity) {
        save$default(mainActivity, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$280(MainActivity mainActivity) {
        mainActivity.saveAs();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$281(MainActivity mainActivity) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        accountUi.publish(mainActivity2, studio, mainActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$282(MainActivity mainActivity) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        accountUi.publishAs(mainActivity2, studio, mainActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$283(MainActivity mainActivity) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        accountUi.currentPlaceHistory(mainActivity2, studio, mainActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$284(MainActivity mainActivity) {
        mainActivity.exportSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$285(MainActivity mainActivity) {
        mainActivity.importToToolbox();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$286(MainActivity mainActivity) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        AccountUi.installPluginFromRoblox$default(accountUi, mainActivity2, studio, mainActivity, null, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$287(MainActivity mainActivity) {
        mainActivity.pickPluginFile();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$288(MainActivity mainActivity) {
        AvatarUi avatarUi = AvatarUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        avatarUi.playtestAvatar(mainActivity2, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$289(MainActivity mainActivity) {
        AvatarUi avatarUi = AvatarUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        avatarUi.gameSettings(mainActivity2, studio);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$290(MainActivity mainActivity) {
        mainActivity.showSettings();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$292(MainActivity mainActivity) {
        AccountUi accountUi = AccountUi.INSTANCE;
        MainActivity mainActivity2 = mainActivity;
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        accountUi.show(mainActivity2, studio, mainActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFileMenu$lambda$293(MainActivity mainActivity) {
        mainActivity.about();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean showFileMenu$lambda$295(List list, MenuItem menuItem) {
        ((Function0) ((Pair) list.get(menuItem.getItemId())).getSecond()).invoke();
        return true;
    }

    private final void showPlace() {
        ScriptEditor scriptEditor;
        Instance instance = this.activeScript;
        if (instance != null && (scriptEditor = this.openEditors.get(instance)) != null) {
            scriptEditor.commit();
        }
        FrameLayout frameLayout = null;
        this.activeScript = null;
        FrameLayout frameLayout2 = this.editorHost;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorHost");
            frameLayout2 = null;
        }
        frameLayout2.removeAllViews();
        FrameLayout frameLayout3 = this.editorHost;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorHost");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.setVisibility(8);
        rebuildScriptTabs();
    }

    private final void showPluginMenu(String title, List<String> labels, Function1<? super Integer, Unit> pick) {
        if (labels.isEmpty()) {
            pick.invoke(-1);
            return;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        AlertDialog.Builder themed = Dialogs.INSTANCE.themed(this);
        String str = title;
        if (str.length() == 0) {
            str = "Plugin";
        }
        AlertDialog create = themed.setTitle(str).setItems((CharSequence[]) labels.toArray(new String[0]), new MainActivity$$ExternalSyntheticLambda2(booleanRef, pick)).create();
        create.setOnDismissListener(new MainActivity$$ExternalSyntheticLambda3(booleanRef, pick));
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showPluginMenu$lambda$21(Ref.BooleanRef booleanRef, Function1 function1, DialogInterface dialogInterface, int i) {
        booleanRef.element = true;
        function1.invoke(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showPluginMenu$lambda$22(Ref.BooleanRef booleanRef, Function1 function1, DialogInterface dialogInterface) {
        if (booleanRef.element) {
            return;
        }
        function1.invoke(-1);
    }

    private final void showSettings() {
        SettingsDialog.INSTANCE.show(this, this, new MainActivity$$ExternalSyntheticLambda142(this), new MainActivity$$ExternalSyntheticLambda143(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showSettings$lambda$296(MainActivity mainActivity) {
        mainActivity.openMode = OpenMode.ICONS;
        mainActivity.openLauncher.launch(new String[]{"application/zip", "application/x-zip-compressed", "*/*"});
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showSettings$lambda$297(MainActivity mainActivity) {
        Icons.INSTANCE.remove(mainActivity);
        return Unit.INSTANCE;
    }

    private final void snapGroup() {
        group("Snap to Grid", new MainActivity$$ExternalSyntheticLambda97(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit snapGroup$lambda$234(MainActivity mainActivity) {
        LinearLayout linearLayout = new LinearLayout(mainActivity);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        linearLayout.setPadding(mainActivity.dp(4.0f), 0, mainActivity.dp(4.0f), 0);
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        boolean rotSnapEnabled = studio.getRotSnapEnabled();
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        linearLayout.addView(mainActivity.snapRow("Rotate", rotSnapEnabled, studio3.getRotSnap(), "°", new MainActivity$$ExternalSyntheticLambda59(mainActivity), new MainActivity$$ExternalSyntheticLambda60(mainActivity)));
        Studio studio4 = mainActivity.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        boolean snapEnabled = studio4.getSnapEnabled();
        Studio studio5 = mainActivity.studio;
        if (studio5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio5 = null;
        }
        linearLayout.addView(mainActivity.snapRow("Move", snapEnabled, studio5.getMoveSnap(), "studs", new MainActivity$$ExternalSyntheticLambda61(mainActivity), new MainActivity$$ExternalSyntheticLambda62(mainActivity)));
        LinearLayout linearLayout2 = mainActivity.groupRow;
        if (linearLayout2 != null) {
            linearLayout2.addView(linearLayout);
        }
        Drawable g = mainActivity.g("Collisions", "Col");
        Studio studio6 = mainActivity.studio;
        if (studio6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio6;
        }
        mainActivity.tool(g, "Collisions", studio2.getCollisionsEnabled(), new MainActivity$$ExternalSyntheticLambda63(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit snapGroup$lambda$234$lambda$229(MainActivity mainActivity, boolean z) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.setRotSnapEnabled(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit snapGroup$lambda$234$lambda$230(MainActivity mainActivity, float f) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.setRotSnap(RangesKt.coerceIn(f, 0.01f, 360.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit snapGroup$lambda$234$lambda$231(MainActivity mainActivity, boolean z) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.setSnapEnabled(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit snapGroup$lambda$234$lambda$232(MainActivity mainActivity, float f) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.setMoveSnap(RangesKt.coerceIn(f, 0.001f, 2048.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit snapGroup$lambda$234$lambda$233(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        studio.setCollisionsEnabled(!studio3.getCollisionsEnabled());
        Studio studio4 = mainActivity.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio4;
        }
        mainActivity.toast(studio2.getCollisionsEnabled() ? "Collisions on: moved parts stop at other parts" : "Collisions off");
        mainActivity.buildRibbon();
        return Unit.INSTANCE;
    }

    private final View snapRow(String label, boolean on, float value, String unit, Function1<? super Boolean, Unit> toggle, Function1<? super Float, Unit> set) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, dp(1.0f), 0, dp(1.0f));
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(new Ui.CheckBoxDrawable(on, imageView.getResources().getDisplayMetrics().density));
        imageView.setPadding(dp(3.0f), dp(3.0f), dp(3.0f), dp(3.0f));
        imageView.setOnClickListener(new MainActivity$$ExternalSyntheticLambda78(toggle, on, this));
        linearLayout.addView(imageView, Ui.lp$default(Ui.INSTANCE, dp(22.0f), dp(22.0f), 0.0f, 4, null));
        TextView text$default = Ui.text$default(Ui.INSTANCE, this, label, 11.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
        text$default.setPadding(dp(2.0f), 0, dp(4.0f), 0);
        text$default.setOnClickListener(new MainActivity$$ExternalSyntheticLambda79(toggle, on, this));
        linearLayout.addView(text$default, Ui.lp$default(Ui.INSTANCE, dp(44.0f), -2, 0.0f, 4, null));
        EditText input$default = Ui.input$default(Ui.INSTANCE, this, DataTypesKt.fmtNum(value), "", true, false, 16, null);
        input$default.setTextSize(11.0f);
        input$default.setPadding(dp(5.0f), dp(2.0f), dp(5.0f), dp(2.0f));
        input$default.setSingleLine(true);
        input$default.setImeOptions(6);
        input$default.setEnabled(on);
        input$default.setAlpha(on ? 1.0f : 0.5f);
        input$default.setOnEditorActionListener(new MainActivity$$ExternalSyntheticLambda80(this, input$default, set, value));
        input$default.setOnFocusChangeListener(new MainActivity$$ExternalSyntheticLambda81(input$default, set, value));
        linearLayout.addView(input$default, Ui.lp$default(Ui.INSTANCE, dp(52.0f), dp(24.0f), 0.0f, 4, null));
        TextView text$default2 = Ui.text$default(Ui.INSTANCE, this, unit, 10.5f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default2.setPadding(dp(4.0f), 0, 0, 0);
        linearLayout.addView(text$default2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void snapRow$lambda$237$lambda$236(Function1 function1, boolean z, MainActivity mainActivity, View view) {
        function1.invoke(Boolean.valueOf(!z));
        mainActivity.buildRibbon();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void snapRow$lambda$239$lambda$238(Function1 function1, boolean z, MainActivity mainActivity, View view) {
        function1.invoke(Boolean.valueOf(!z));
        mainActivity.buildRibbon();
    }

    private static final void snapRow$lambda$242$commit(EditText editText, Function1<? super Float, Unit> function1, float f) {
        Float floatOrNull = StringsKt.toFloatOrNull(StringsKt.trim((CharSequence) StringsKt.replace$default(editText.getText().toString(), ',', '.', false, 4, (Object) null)).toString());
        if (floatOrNull == null || floatOrNull.floatValue() <= 0.0f) {
            editText.setText(DataTypesKt.fmtNum(f));
        } else {
            function1.invoke(floatOrNull);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean snapRow$lambda$242$lambda$240(MainActivity mainActivity, EditText editText, Function1 function1, float f, TextView textView, int i, KeyEvent keyEvent) {
        snapRow$lambda$242$commit(editText, function1, f);
        textView.clearFocus();
        Object systemService = mainActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void snapRow$lambda$242$lambda$241(EditText editText, Function1 function1, float f, View view, boolean z) {
        if (z) {
            return;
        }
        snapRow$lambda$242$commit(editText, function1, f);
    }

    private final void solid(Function0<String> op) {
        String str;
        Collection<ScriptEditor> values = this.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
        try {
            str = op.invoke();
        } catch (Exception e) {
            String message = e.getMessage();
            str = "Couldn't do that: " + (message != null ? message : e);
        }
        if (str != null) {
            toast(str);
            return;
        }
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.markDirty();
    }

    private final void stack(Triple<? extends Drawable, String, ? extends Function0<Unit>>... items) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(16);
        for (Triple<? extends Drawable, String, ? extends Function0<Unit>> triple : items) {
            TextView iconTextButton = Ui.INSTANCE.iconTextButton(this, triple.component1(), triple.component2(), 0, new MainActivity$$ExternalSyntheticLambda106(triple.component3()));
            iconTextButton.setTextSize(11.0f);
            iconTextButton.setGravity(NavigationBarView.ITEM_GRAVITY_START_CENTER);
            iconTextButton.setPadding(dp(6.0f), dp(1.0f), dp(8.0f), dp(1.0f));
            iconTextButton.setMinHeight(0);
            iconTextButton.setMinimumHeight(0);
            Drawable drawable = iconTextButton.getCompoundDrawables()[0];
            if (drawable != null) {
                drawable.setBounds(0, 0, dp(14.0f), dp(14.0f));
            }
            iconTextButton.setCompoundDrawables(iconTextButton.getCompoundDrawables()[0], null, null, null);
            linearLayout2.addView(iconTextButton, Ui.lp$default(Ui.INSTANCE, -2, dp(17.0f), 0.0f, 4, null));
        }
        LinearLayout linearLayout3 = this.groupRow;
        if (linearLayout3 == null && (linearLayout3 = this.ribbon) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbon");
            linearLayout = null;
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.addView(linearLayout2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit stack$lambda$72(Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void toast(String s) {
        Toast.makeText(this, s, 0).show();
    }

    private final void togglePlay() {
        Collection<ScriptEditor> values = this.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        if (studio.isPlaying()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio3;
            }
            studio2.stopPlay();
            return;
        }
        showPlace();
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio4;
        }
        studio2.startPlay();
    }

    private final void tool(Drawable icon, String label, boolean selected, Function0<Unit> fn) {
        LinearLayout linearLayout = Ui.INSTANCE.toolButton(this, icon, label, new MainActivity$$ExternalSyntheticLambda120(fn));
        linearLayout.setSelected(selected);
        LinearLayout linearLayout2 = null;
        if (selected) {
            View childAt = linearLayout.getChildAt(1);
            TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
            if (textView != null) {
                textView.setTextColor(Ui.INSTANCE.getSELECT_TEXT());
            }
        }
        LinearLayout linearLayout3 = this.groupRow;
        if (linearLayout3 == null && (linearLayout3 = this.ribbon) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbon");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.addView(linearLayout);
    }

    static /* synthetic */ void tool$default(MainActivity mainActivity, Drawable drawable, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        mainActivity.tool(drawable, str, z, function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit tool$lambda$70(Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void toolsGroup() {
        group("Tools", new MainActivity$$ExternalSyntheticLambda53(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit toolsGroup$lambda$78(MainActivity mainActivity) {
        Studio studio = null;
        Drawable g$default = g$default(mainActivity, "Select", null, 2, null);
        Studio studio2 = mainActivity.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio2 = null;
        }
        mainActivity.tool(g$default, "Select", studio2.getTool() == Tool.SELECT, new MainActivity$$ExternalSyntheticLambda180(mainActivity));
        Drawable g$default2 = g$default(mainActivity, "Move", null, 2, null);
        Studio studio3 = mainActivity.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        mainActivity.tool(g$default2, "Move", studio3.getTool() == Tool.MOVE, new MainActivity$$ExternalSyntheticLambda181(mainActivity));
        Drawable g$default3 = g$default(mainActivity, "Scale", null, 2, null);
        Studio studio4 = mainActivity.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        mainActivity.tool(g$default3, "Scale", studio4.getTool() == Tool.SCALE, new MainActivity$$ExternalSyntheticLambda182(mainActivity));
        Drawable g$default4 = g$default(mainActivity, "Rotate", null, 2, null);
        Studio studio5 = mainActivity.studio;
        if (studio5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio = studio5;
        }
        mainActivity.tool(g$default4, "Rotate", studio.getTool() == Tool.ROTATE, new MainActivity$$ExternalSyntheticLambda183(mainActivity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit toolsGroup$lambda$78$lambda$74(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.setTool(Tool.SELECT);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit toolsGroup$lambda$78$lambda$75(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.setTool(Tool.MOVE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit toolsGroup$lambda$78$lambda$76(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.setTool(Tool.SCALE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit toolsGroup$lambda$78$lambda$77(MainActivity mainActivity) {
        Studio studio = mainActivity.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.setTool(Tool.ROTATE);
        return Unit.INSTANCE;
    }

    private final void updateHideButton() {
        DockLayout dockLayout = this.dock;
        HorizontalScrollView horizontalScrollView = null;
        if (dockLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
            dockLayout = null;
        }
        boolean allHidden = dockLayout.getAllHidden();
        ImageView imageView = this.hideBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideBtn");
            imageView = null;
        }
        imageView.setImageDrawable(g$default(this, allHidden ? "ShowWindows" : "HideWindows", null, 2, null));
        ImageView imageView2 = this.hideBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideBtn");
            imageView2 = null;
        }
        imageView2.setContentDescription(allHidden ? "Show windows" : "Hide all windows");
        HorizontalScrollView horizontalScrollView2 = this.ribbonScroll;
        if (horizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbonScroll");
            horizontalScrollView2 = null;
        }
        horizontalScrollView2.setVisibility(allHidden ? 8 : 0);
        View view = this.ribbonDivider;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbonDivider");
            view = null;
        }
        HorizontalScrollView horizontalScrollView3 = this.ribbonScroll;
        if (horizontalScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ribbonScroll");
        } else {
            horizontalScrollView = horizontalScrollView3;
        }
        view.setVisibility(horizontalScrollView.getVisibility());
    }

    private final void updateTitle() {
        String fileName;
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        CloudPlace cloud = studio.getCloud();
        if (cloud != null) {
            fileName = cloud.getName() + "  (Roblox place)";
        } else {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            fileName = studio3.getFileName();
        }
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        String str = studio4.getDirty() ? "● " : "";
        Studio studio5 = this.studio;
        if (studio5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
        } else {
            studio2 = studio5;
        }
        textView.setText(str + fileName + (studio2.isPlaying() ? "  (Playing)" : ""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit webAsker$lambda$33(MainActivity mainActivity, String host, String who, Function1 answer) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(answer, "answer");
        mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda220(mainActivity, host, who, answer));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void webAsker$lambda$33$lambda$32(MainActivity mainActivity, String str, String str2, Function1 function1) {
        mainActivity.askWebPermission(str, str2, function1);
    }

    private final void writeTo(Uri uri) {
        Function0<byte[]> function0 = this.pendingSave;
        if (function0 == null) {
            return;
        }
        boolean z = this.pendingSaveIsPlace;
        this.pendingSave = null;
        new Thread(new MainActivity$$ExternalSyntheticLambda105(function0, this, uri, z, displayName(uri))).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static final void writeTo$lambda$333(Function0 function0, MainActivity mainActivity, Uri uri, boolean z, String str) {
        MainActivity mainActivity2;
        boolean z2;
        Exception exc;
        byte[] bArr;
        ?? r2;
        OutputStream openOutputStream;
        try {
            bArr = (byte[]) function0.invoke();
        } catch (Exception e) {
            mainActivity2 = mainActivity;
            z2 = z;
            exc = e;
        }
        try {
            if (bArr == null) {
                throw new Exception("Nothing to save");
            }
            try {
                openOutputStream = mainActivity.getContentResolver().openOutputStream(uri, "wt");
            } catch (Exception e2) {
                r2 = "w";
                openOutputStream = mainActivity.getContentResolver().openOutputStream(uri, "w");
            }
            OutputStream outputStream = openOutputStream;
            if (outputStream == null) {
                throw new Exception("Could not open file for writing");
            }
            OutputStream outputStream2 = outputStream;
            try {
                r2 = 0;
                outputStream2.write(bArr);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream2, null);
                mainActivity.runOnUiThread(new MainActivity$$ExternalSyntheticLambda118(z, mainActivity, uri, str, bArr));
            } finally {
            }
        } catch (Exception e3) {
            exc = e3;
            z2 = r2;
            OutputLog.INSTANCE.error("Save failed: " + exc.getMessage());
            mainActivity2.runOnUiThread(new MainActivity$$ExternalSyntheticLambda119(mainActivity2, exc, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void writeTo$lambda$333$lambda$331(boolean z, MainActivity mainActivity, Uri uri, String str, byte[] bArr) {
        if (z) {
            try {
                mainActivity.getContentResolver().takePersistableUriPermission(uri, 3);
            } catch (Exception e) {
            }
            Studio studio = mainActivity.studio;
            Studio studio2 = null;
            if (studio == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio = null;
            }
            studio.markSaved(uri, str);
            Studio studio3 = mainActivity.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio3;
            }
            if (studio2.getCloud() == null) {
                Recents.INSTANCE.add(mainActivity, new Recents.Entry(str, 0L, 0L, uri.toString(), 0L, 0L, 54, null));
            }
            mainActivity.rebuildScriptTabs();
        }
        mainActivity.toast("Saved " + str);
        OutputLog.INSTANCE.info("Saved " + str + " (" + (bArr.length / 1024) + " KB)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void writeTo$lambda$333$lambda$332(MainActivity mainActivity, Exception exc, boolean z) {
        Dialogs.INSTANCE.themed(mainActivity).setTitle("Save failed").setMessage(exc.getMessage() + (z ? "\n\nTry File → Save As… to pick a new location." : "")).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
    }

    @Override // com.exampletest.mobilestudiotest.ui.MainActions
    public void addSelectionToToolbox() {
        Pair pair;
        Studio studio = this.studio;
        DockLayout dockLayout = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        byte[] serializeSelection = studio.serializeSelection();
        if (serializeSelection == null) {
            toast("Nothing selected");
            return;
        }
        Studio studio2 = this.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio2 = null;
        }
        synchronized (studio2.getLock()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            Instance instance = (Instance) CollectionsKt.first((List) studio3.getSelection());
            pair = TuplesKt.to(instance.getName(), instance.getClassName());
        }
        String str = (String) pair.component1();
        String str2 = (String) pair.component2();
        ToolboxPanel toolboxPanel = this.toolbox;
        if (toolboxPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbox");
            toolboxPanel = null;
        }
        toolboxPanel.saveToLibrary(str, serializeSelection, str2);
        DockLayout dockLayout2 = this.dock;
        if (dockLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dock");
        } else {
            dockLayout = dockLayout2;
        }
        dockLayout.setShown("toolbox", true);
        toast("Saved " + str + " to Toolbox");
    }

    @Override // com.exampletest.mobilestudiotest.ui.MainActions
    public void applyThemeChange() {
        Ui.INSTANCE.applyTheme(Settings.INSTANCE.getTheme());
        Collection<ScriptEditor> values = this.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
        recreate();
    }

    @Override // com.exampletest.mobilestudiotest.ui.StartScreen.Host
    public void closeStart() {
        StartScreen startScreen = this.startScreen;
        if (startScreen != null) {
            FrameLayout frameLayout = this.rootFrame;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootFrame");
                frameLayout = null;
            }
            frameLayout.removeView(startScreen);
        }
        this.startScreen = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        List<Instance> backpackTools;
        Instance instance;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z = event.isCtrlPressed() || event.isShiftPressed();
        Studio studio = this.studio;
        Studio studio2 = null;
        Studio studio3 = null;
        Studio studio4 = null;
        Studio studio5 = null;
        Studio studio6 = null;
        Studio studio7 = null;
        Studio studio8 = null;
        Studio studio9 = null;
        Studio studio10 = null;
        Studio studio11 = null;
        Studio studio12 = null;
        Studio studio13 = null;
        Studio studio14 = null;
        ViewportView viewportView = null;
        ViewportView viewportView2 = null;
        ViewportView viewportView3 = null;
        Studio studio15 = null;
        Studio studio16 = null;
        Studio studio17 = null;
        Studio studio18 = null;
        Studio studio19 = null;
        Studio studio20 = null;
        Studio studio21 = null;
        Studio studio22 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        if (z != studio.getModifierHeld()) {
            Studio studio23 = this.studio;
            if (studio23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio23 = null;
            }
            studio23.setModifierHeld(z);
            ViewportView viewportView4 = this.viewport;
            if (viewportView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
                viewportView4 = null;
            }
            viewportView4.getControls().invalidate();
        }
        if (getCurrentFocus() instanceof EditText) {
            return super.dispatchKeyEvent(event);
        }
        int keyCode = event.getKeyCode();
        Studio studio24 = this.studio;
        if (studio24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio24 = null;
        }
        boolean isPlaying = studio24.isPlaying();
        if (event.getAction() == 0) {
            this.keysDown.add(Integer.valueOf(keyCode));
            if (event.isCtrlPressed()) {
                switch (keyCode) {
                    case 8:
                        Studio studio25 = this.studio;
                        if (studio25 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio13 = studio25;
                        }
                        studio13.setTool(Tool.SELECT);
                        return true;
                    case 9:
                        Studio studio26 = this.studio;
                        if (studio26 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio12 = studio26;
                        }
                        studio12.setTool(Tool.MOVE);
                        return true;
                    case 10:
                        Studio studio27 = this.studio;
                        if (studio27 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio11 = studio27;
                        }
                        studio11.setTool(Tool.SCALE);
                        return true;
                    case 11:
                        Studio studio28 = this.studio;
                        if (studio28 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio10 = studio28;
                        }
                        studio10.setTool(Tool.ROTATE);
                        return true;
                    case 31:
                        Studio studio29 = this.studio;
                        if (studio29 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio9 = studio29;
                        }
                        studio9.copySelection();
                        return true;
                    case 32:
                        Studio studio30 = this.studio;
                        if (studio30 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio8 = studio30;
                        }
                        studio8.duplicateSelection();
                        return true;
                    case 35:
                        if (event.isShiftPressed()) {
                            Studio studio31 = this.studio;
                            if (studio31 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("studio");
                            } else {
                                studio6 = studio31;
                            }
                            studio6.ungroupSelection();
                        } else {
                            Studio studio32 = this.studio;
                            if (studio32 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("studio");
                            } else {
                                studio7 = studio32;
                            }
                            studio7.groupSelection();
                        }
                        return true;
                    case 43:
                        this.openMode = OpenMode.PLACE;
                        this.openLauncher.launch(new String[]{"*/*"});
                        return true;
                    case 47:
                        if (event.isShiftPressed()) {
                            saveAs();
                        } else {
                            save$default(this, null, 1, null);
                        }
                        return true;
                    case 50:
                        Studio studio33 = this.studio;
                        if (studio33 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                            studio33 = null;
                        }
                        studio33.paste(null);
                        return true;
                    case 52:
                        Studio studio34 = this.studio;
                        if (studio34 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio5 = studio34;
                        }
                        studio5.cutSelection();
                        return true;
                    case 53:
                        Studio studio35 = this.studio;
                        if (studio35 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio4 = studio35;
                        }
                        studio4.getUndo().redo();
                        return true;
                    case 54:
                        Studio studio36 = this.studio;
                        if (studio36 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio3 = studio36;
                        }
                        studio3.getUndo().undo();
                        return true;
                }
            }
            if (isPlaying && event.getRepeatCount() == 0) {
                switch (keyCode) {
                    case 37:
                        Studio studio37 = this.studio;
                        if (studio37 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                            studio37 = null;
                        }
                        synchronized (studio37.getLock()) {
                            Studio studio38 = this.studio;
                            if (studio38 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("studio");
                            } else {
                                studio17 = studio38;
                            }
                            PlaySession play = studio17.getPlay();
                            if (play != null) {
                                play.cameraZoom(1.25f);
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                        return true;
                    case 43:
                        Studio studio39 = this.studio;
                        if (studio39 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                            studio39 = null;
                        }
                        synchronized (studio39.getLock()) {
                            Studio studio40 = this.studio;
                            if (studio40 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("studio");
                            } else {
                                studio16 = studio40;
                            }
                            PlaySession play2 = studio16.getPlay();
                            if (play2 != null) {
                                play2.cameraZoom(0.8f);
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                        return true;
                    case 59:
                        Studio studio41 = this.studio;
                        if (studio41 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                            studio41 = null;
                        }
                        synchronized (studio41.getLock()) {
                            Studio studio42 = this.studio;
                            if (studio42 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("studio");
                            } else {
                                studio15 = studio42;
                            }
                            PlaySession play3 = studio15.getPlay();
                            if (play3 != null) {
                                play3.toggleShiftLock();
                                Unit unit3 = Unit.INSTANCE;
                            }
                        }
                        return true;
                    case 61:
                        ViewportView viewportView5 = this.viewport;
                        if (viewportView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewport");
                        } else {
                            viewportView3 = viewportView5;
                        }
                        viewportView3.getHud().togglePlayerList();
                        return true;
                    case 76:
                        ViewportView viewportView6 = this.viewport;
                        if (viewportView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewport");
                        } else {
                            viewportView2 = viewportView6;
                        }
                        viewportView2.getHud().focusChat();
                        return true;
                    case 111:
                        ViewportView viewportView7 = this.viewport;
                        if (viewportView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewport");
                        } else {
                            viewportView = viewportView7;
                        }
                        viewportView.getHud().toggleMenu();
                        return true;
                    default:
                        if ((8 <= keyCode && keyCode < 17) != false) {
                            Studio studio43 = this.studio;
                            if (studio43 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("studio");
                                studio43 = null;
                            }
                            synchronized (studio43.getLock()) {
                                Studio studio44 = this.studio;
                                if (studio44 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                                } else {
                                    studio14 = studio44;
                                }
                                PlaySession play4 = studio14.getPlay();
                                if (play4 != null && (backpackTools = play4.backpackTools()) != null && (instance = (Instance) CollectionsKt.getOrNull(backpackTools, keyCode - 8)) != null) {
                                    play4.toggleTool(instance);
                                    Unit unit4 = Unit.INSTANCE;
                                }
                            }
                            return true;
                        }
                        break;
                }
            }
            switch (keyCode) {
                case 34:
                    if (!isPlaying) {
                        Studio studio45 = this.studio;
                        if (studio45 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio21 = studio45;
                        }
                        studio21.focusSelection();
                        return true;
                    }
                    break;
                case 62:
                    if (isPlaying) {
                        Studio studio46 = this.studio;
                        if (studio46 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                            studio46 = null;
                        }
                        synchronized (studio46.getLock()) {
                            Studio studio47 = this.studio;
                            if (studio47 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("studio");
                            } else {
                                studio20 = studio47;
                            }
                            PlaySession play5 = studio20.getPlay();
                            if (play5 != null) {
                                play5.setJumpHeld(true);
                                Unit unit5 = Unit.INSTANCE;
                            }
                        }
                        return true;
                    }
                    break;
                case 67:
                case 112:
                    if (!isPlaying) {
                        Studio studio48 = this.studio;
                        if (studio48 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio19 = studio48;
                        }
                        studio19.deleteSelection();
                        return true;
                    }
                    break;
                case 135:
                    if (event.isShiftPressed()) {
                        Studio studio49 = this.studio;
                        if (studio49 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("studio");
                        } else {
                            studio18 = studio49;
                        }
                        studio18.stopPlay();
                    } else if (!isPlaying) {
                        togglePlay();
                    }
                    return true;
            }
        } else if (event.getAction() == 1) {
            this.keysDown.remove(Integer.valueOf(keyCode));
            if (keyCode == 62 && isPlaying) {
                Studio studio50 = this.studio;
                if (studio50 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio50 = null;
                }
                synchronized (studio50.getLock()) {
                    Studio studio51 = this.studio;
                    if (studio51 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("studio");
                    } else {
                        studio2 = studio51;
                    }
                    PlaySession play6 = studio2.getPlay();
                    if (play6 != null) {
                        play6.setJumpHeld(false);
                        Unit unit6 = Unit.INSTANCE;
                    }
                }
                return true;
            }
        }
        if (isPlaying && (keyCode == 21 || keyCode == 22)) {
            Studio studio52 = this.studio;
            if (studio52 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio22 = studio52;
            }
            PlaySession play7 = studio22.getPlay();
            if (play7 != null) {
                play7.setKeyTurn((this.keysDown.contains(21) ? 1.0f : 0.0f) - (this.keysDown.contains(22) ? 1.0f : 0.0f));
            }
            return true;
        }
        if (!SetsKt.setOf((Object[]) new Integer[]{51, 29, 47, 32, 45, 33, 19, 20}).contains(Integer.valueOf(keyCode)) || event.isCtrlPressed()) {
            return super.dispatchKeyEvent(event);
        }
        Studio studio53 = this.studio;
        if (studio53 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio53 = null;
        }
        studio53.setMoveX(dispatchKeyEvent$k(this, 32) - dispatchKeyEvent$k(this, 29));
        Studio studio54 = this.studio;
        if (studio54 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio54 = null;
        }
        studio54.setMoveY(RangesKt.coerceAtMost(dispatchKeyEvent$k(this, 47) + dispatchKeyEvent$k(this, 20), 1.0f) - RangesKt.coerceAtMost(dispatchKeyEvent$k(this, 51) + dispatchKeyEvent$k(this, 19), 1.0f));
        Studio studio55 = this.studio;
        if (studio55 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio55 = null;
        }
        studio55.setFlyUp(this.keysDown.contains(33));
        Studio studio56 = this.studio;
        if (studio56 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio56 = null;
        }
        studio56.setFlyDown(this.keysDown.contains(45));
        return true;
    }

    @Override // com.exampletest.mobilestudiotest.ui.MainActions
    public void exportSelection() {
        boolean isEmpty;
        String name;
        Studio studio = this.studio;
        Studio studio2 = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        synchronized (studio.getLock()) {
            Studio studio3 = this.studio;
            if (studio3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio3 = null;
            }
            isEmpty = studio3.getSelection().isEmpty();
        }
        if (isEmpty) {
            toast("Select something to export");
            return;
        }
        this.pendingSave = new MainActivity$$ExternalSyntheticLambda221(this);
        this.pendingSaveIsPlace = false;
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        synchronized (studio4.getLock()) {
            Studio studio5 = this.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
            } else {
                studio2 = studio5;
            }
            name = ((Instance) CollectionsKt.first((List) studio2.getSelection())).getName();
        }
        this.createLauncher.launch(name + ".rbxm");
    }

    @Override // com.exampletest.mobilestudiotest.ui.StartScreen.Host
    public boolean hasOpenPlace() {
        Application application = getApplication();
        StudioApp studioApp = application instanceof StudioApp ? (StudioApp) application : null;
        return studioApp != null && studioApp.getPlaceOpened();
    }

    @Override // com.exampletest.mobilestudiotest.ui.MainActions
    public void importToToolbox() {
        this.openMode = OpenMode.TOOLBOX;
        this.openLauncher.launch(new String[]{"*/*"});
    }

    @Override // com.exampletest.mobilestudiotest.ui.StartScreen.Host
    public void newFromTemplate(PlaceFactory.Template t) {
        Intrinsics.checkNotNullParameter(t, "t");
        confirmDiscard(new MainActivity$$ExternalSyntheticLambda219(this, t));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Studio studio;
        super.onCreate(savedInstanceState);
        Settings.INSTANCE.init(this);
        Ui.INSTANCE.applyTheme(Settings.INSTANCE.getTheme());
        getWindow().addFlags(128);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
        Application application = getApplication();
        StudioApp studioApp = application instanceof StudioApp ? (StudioApp) application : null;
        if (studioApp == null || (studio = studioApp.getStudio()) == null) {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            studio = new Studio(applicationContext);
        }
        this.studio = studio;
        Studio studio2 = this.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio2 = null;
        }
        studio2.setToastHandler(new MainActivity$$ExternalSyntheticLambda222(this));
        Studio studio3 = this.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        studio3.setOpenScriptHandler(new MainActivity$$ExternalSyntheticLambda223(this));
        Icons icons = Icons.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        icons.init(applicationContext2);
        Fonts fonts = Fonts.INSTANCE;
        AssetManager assets = getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        fonts.init(assets);
        ImageLoader imageLoader = ImageLoader.INSTANCE;
        Context applicationContext3 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        imageLoader.init(applicationContext3);
        AssetFetcher assetFetcher = AssetFetcher.INSTANCE;
        Context applicationContext4 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
        assetFetcher.init(applicationContext4);
        MaterialTextures materialTextures = MaterialTextures.INSTANCE;
        Context applicationContext5 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
        materialTextures.init(applicationContext5);
        Icons.INSTANCE.getListeners().add(this.iconListener);
        Accounts.INSTANCE.getListeners().add(this.accountListener);
        buildUi();
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        studio4.getListeners().add(this);
        Studio studio5 = this.studio;
        if (studio5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio5 = null;
        }
        CopyOnWriteArrayList<Studio.Listener> listeners = studio5.getListeners();
        ExplorerPanel explorerPanel = this.explorer;
        if (explorerPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("explorer");
            explorerPanel = null;
        }
        listeners.add(explorerPanel);
        Studio studio6 = this.studio;
        if (studio6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio6 = null;
        }
        CopyOnWriteArrayList<Studio.Listener> listeners2 = studio6.getListeners();
        PropertiesPanel propertiesPanel = this.properties;
        if (propertiesPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
            propertiesPanel = null;
        }
        listeners2.add(propertiesPanel);
        Studio studio7 = this.studio;
        if (studio7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio7 = null;
        }
        studio7.setPluginMenuHandler(new MainActivity$$ExternalSyntheticLambda224(this));
        WebPermissions.INSTANCE.setAsker(this.webAsker);
        getOnBackPressedDispatcher().addCallback(this, new MainActivity$onCreate$5(this));
        Application application2 = getApplication();
        StudioApp studioApp2 = application2 instanceof StudioApp ? (StudioApp) application2 : null;
        boolean z = false;
        if (studioApp2 != null && !studioApp2.getStarted()) {
            studioApp2.setStarted(true);
            z = true;
            OutputLog.INSTANCE.info("Mobile Studio ready. Open a .rbxl/.rbxm file or one of your Roblox games, or start building!");
            Studio studio8 = this.studio;
            if (studio8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio8 = null;
            }
            studio8.getPlugins().loadAll();
            Avatar avatar = Avatar.INSTANCE;
            Context applicationContext6 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext6, "getApplicationContext(...)");
            avatar.refresh(applicationContext6);
        }
        if (savedInstanceState == null) {
            handleIntent(getIntent());
        }
        if (z) {
            Intent intent = getIntent();
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.intent.action.VIEW")) {
                return;
            }
            showStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WebPermissions.INSTANCE.getAsker() == this.webAsker) {
            WebPermissions.INSTANCE.setAsker(null);
        }
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        studio.getListeners().remove(this);
        Studio studio2 = this.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio2 = null;
        }
        CopyOnWriteArrayList<Studio.Listener> listeners = studio2.getListeners();
        ExplorerPanel explorerPanel = this.explorer;
        if (explorerPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("explorer");
            explorerPanel = null;
        }
        listeners.remove(explorerPanel);
        Studio studio3 = this.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        CopyOnWriteArrayList<Studio.Listener> listeners2 = studio3.getListeners();
        PropertiesPanel propertiesPanel = this.properties;
        if (propertiesPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
            propertiesPanel = null;
        }
        listeners2.remove(propertiesPanel);
        Icons.INSTANCE.getListeners().remove(this.iconListener);
        Accounts.INSTANCE.getListeners().remove(this.accountListener);
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        if (studio4.getPluginMenuHandler() != null) {
            Studio studio5 = this.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio5 = null;
            }
            studio5.setPluginMenuHandler(null);
        }
        super.onDestroy();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onDirtyChanged() {
        updateTitle();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onModelReplaced() {
        Iterator it = CollectionsKt.toList(this.editorOrder).iterator();
        while (true) {
            Studio studio = null;
            if (!it.hasNext()) {
                break;
            }
            Instance instance = (Instance) it.next();
            DataModel root = instance.root();
            if (root != null) {
                Studio studio2 = this.studio;
                if (studio2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studio");
                    studio2 = null;
                }
                if (root != studio2.getEditModel()) {
                    Studio studio3 = this.studio;
                    if (studio3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("studio");
                    } else {
                        studio = studio3;
                    }
                    if (root == studio.getModel()) {
                    }
                }
            }
            closeScript(instance);
        }
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        if (!studio4.isPlaying()) {
            Application application = getApplication();
            StudioApp studioApp = application instanceof StudioApp ? (StudioApp) application : null;
            if (studioApp != null) {
                studioApp.setPlaceOpened(true);
            }
            if (this.startScreen != null) {
                closeStart();
            }
        }
        updateTitle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ViewportView viewportView = this.viewport;
        if (viewportView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
            viewportView = null;
        }
        viewportView.onPause();
        Collection<ScriptEditor> values = this.openEditors.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ScriptEditor) it.next()).commit();
        }
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onPlayStateChanged() {
        TextView textView = this.playButton;
        ViewportView viewportView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            textView = null;
        }
        Studio studio = this.studio;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        textView.setText(studio.isPlaying() ? "Stop" : "Play");
        Studio studio2 = this.studio;
        if (studio2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio2 = null;
        }
        Drawable g$default = studio2.isPlaying() ? g$default(this, "Stop", null, 2, null) : g$default(this, "Play", null, 2, null);
        g$default.setBounds(0, 0, dp(18.0f), dp(18.0f));
        TextView textView2 = this.playButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            textView2 = null;
        }
        textView2.setCompoundDrawables(g$default, null, null, null);
        TextView textView3 = this.playButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            textView3 = null;
        }
        Ui ui = Ui.INSTANCE;
        MainActivity mainActivity = this;
        Studio studio3 = this.studio;
        if (studio3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio3 = null;
        }
        textView3.setBackground(Ui.rippleBg$default(ui, mainActivity, studio3.isPlaying() ? Ui.STOP : -13726889, 0.0f, 4, null));
        Studio studio4 = this.studio;
        if (studio4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio4 = null;
        }
        if (studio4.isPlaying() && Settings.INSTANCE.getHideWindowsInPlaytest() && this.hiddenBeforePlay == null) {
            DockLayout dockLayout = this.dock;
            if (dockLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dock");
                dockLayout = null;
            }
            this.hiddenBeforePlay = Boolean.valueOf(dockLayout.getAllHidden());
            setAllHidden(true);
        } else {
            Studio studio5 = this.studio;
            if (studio5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studio");
                studio5 = null;
            }
            if (!studio5.isPlaying()) {
                Boolean bool = this.hiddenBeforePlay;
                if (bool != null) {
                    setAllHidden(bool.booleanValue());
                }
                this.hiddenBeforePlay = null;
            }
        }
        ViewportView viewportView2 = this.viewport;
        if (viewportView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
        } else {
            viewportView = viewportView2;
        }
        viewportView.getHud().onPlayStateChanged();
        buildRibbon();
        updateTitle();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onPluginsChanged() {
        if (Intrinsics.areEqual(this.ribbonTab, "Plugins")) {
            buildRibbon();
        }
        ViewportView viewportView = this.viewport;
        if (viewportView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
            viewportView = null;
        }
        viewportView.getControls().invalidate();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onPropsChanged() {
        super.onPropsChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ViewportView viewportView = this.viewport;
        if (viewportView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
            viewportView = null;
        }
        viewportView.onResume();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onSelectionChanged() {
        if (!Intrinsics.areEqual(this.ribbonTab, StartScreen.HOME) || (getCurrentFocus() instanceof EditText)) {
            return;
        }
        buildRibbon();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onToolChanged() {
        if ((Intrinsics.areEqual(this.ribbonTab, StartScreen.HOME) || Intrinsics.areEqual(this.ribbonTab, "Model")) && !(getCurrentFocus() instanceof EditText)) {
            buildRibbon();
        }
        ViewportView viewportView = this.viewport;
        if (viewportView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
            viewportView = null;
        }
        viewportView.getControls().invalidate();
    }

    @Override // com.exampletest.mobilestudiotest.core.Studio.Listener
    public void onTreeChanged() {
        super.onTreeChanged();
    }

    @Override // com.exampletest.mobilestudiotest.ui.StartScreen.Host
    public void openFileFromStart() {
        this.openMode = OpenMode.PLACE;
        this.openLauncher.launch(new String[]{"*/*"});
    }

    @Override // com.exampletest.mobilestudiotest.ui.MainActions
    public void openPlaceBytes(String name, byte[] bytes, CloudPlace cloud) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        new Thread(new MainActivity$$ExternalSyntheticLambda218(bytes, this, name, cloud)).start();
    }

    @Override // com.exampletest.mobilestudiotest.ui.StartScreen.Host
    public void openRecentFile(Recents.Entry e) {
        Uri parse;
        Intrinsics.checkNotNullParameter(e, "e");
        String uri = e.getUri();
        if (uri == null || (parse = Uri.parse(uri)) == null) {
            return;
        }
        this.openMode = OpenMode.PLACE;
        onFilePicked(parse);
    }

    @Override // com.exampletest.mobilestudiotest.ui.MainActions
    public void pickPluginFile() {
        this.openMode = OpenMode.PLUGIN;
        this.openLauncher.launch(new String[]{"*/*"});
    }

    @Override // com.exampletest.mobilestudiotest.ui.MainActions
    public void pluginsChanged() {
        this.ribbonTab = "Plugins";
        buildTabs();
        buildRibbon();
    }

    @Override // com.exampletest.mobilestudiotest.ui.MainActions
    public void saveBytesAs(String fileName, Function0<byte[]> producer) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(producer, "producer");
        this.pendingSave = producer;
        this.pendingSaveIsPlace = false;
        this.createLauncher.launch(fileName);
    }

    public final void showStart() {
        if (this.startScreen != null) {
            return;
        }
        MainActivity mainActivity = this;
        Studio studio = this.studio;
        FrameLayout frameLayout = null;
        if (studio == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studio");
            studio = null;
        }
        StartScreen startScreen = new StartScreen(mainActivity, studio, this, this);
        this.startScreen = startScreen;
        FrameLayout frameLayout2 = this.rootFrame;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootFrame");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.addView(startScreen, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.exampletest.mobilestudiotest.ui.StartScreen.Host
    public void showStudioSettings() {
        showSettings();
    }
}
