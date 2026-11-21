package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.exampletest.mobilestudiotest.audio.AudioEngine;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.format.RbxDocument;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import com.exampletest.mobilestudiotest.net.AuthRequiredException;
import com.exampletest.mobilestudiotest.net.HttpException;
import com.exampletest.mobilestudiotest.net.ImageLoader;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.render.MeshData;
import com.exampletest.mobilestudiotest.render.RbxMesh;
import com.exampletest.mobilestudiotest.ui.ExplorerPanel;
import com.exampletest.mobilestudiotest.ui.Samples;
import com.google.android.material.navigation.NavigationBarView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: ToolboxPanel.kt */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0006\u008f\u0001\u0090\u0001\u0091\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010F\u001a\u00020?J\u001c\u0010G\u001a\u00020\u00182\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020?0IH\u0002J\b\u0010J\u001a\u00020\u0018H\u0002J\b\u0010K\u001a\u00020?H\u0002J\u000e\u0010L\u001a\u00020?2\u0006\u0010M\u001a\u00020*J\u0010\u0010N\u001a\u00020?2\u0006\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u00020?H\u0002J\b\u0010R\u001a\u00020?H\u0002J$\u0010S\u001a\u00020?2\u0006\u0010O\u001a\u00020#2\b\b\u0002\u0010M\u001a\u00020*2\b\b\u0002\u0010T\u001a\u00020&H\u0002J\u0010\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020\u0014H\u0002J\"\u0010W\u001a\u00020?2\u0006\u0010O\u001a\u00020#2\u0006\u0010M\u001a\u00020*2\b\b\u0002\u0010X\u001a\u00020&H\u0002J \u0010Y\u001a\u00020?2\u0006\u0010O\u001a\u00020#2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020?2\u0006\u0010O\u001a\u00020#H\u0002J\u0010\u0010_\u001a\u00020?2\u0006\u0010O\u001a\u00020#H\u0002J\u0010\u0010`\u001a\u00020?2\u0006\u0010O\u001a\u00020#H\u0002J\u0018\u0010a\u001a\u00020?2\u0006\u0010b\u001a\u00020E2\u0006\u0010c\u001a\u00020\u0014H\u0002J\u0010\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u0014H\u0002J\u0010\u0010f\u001a\u00020\u00142\u0006\u0010g\u001a\u00020\rH\u0002J\u001a\u0010h\u001a\u00020?2\u0006\u0010O\u001a\u00020#2\b\b\u0002\u0010M\u001a\u00020*H\u0002J6\u0010i\u001a\u00020?2\u0006\u0010j\u001a\u00020\u00012$\u0010k\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>0l0\u0013H\u0002J\u0018\u0010n\u001a\u00020?2\u0006\u0010j\u001a\u00020\u00012\u0006\u0010o\u001a\u00020\u0014H\u0002J\u0010\u0010p\u001a\u00020?2\u0006\u0010j\u001a\u00020\u0001H\u0002J\u0010\u0010q\u001a\u00020?2\u0006\u0010j\u001a\u00020\u0001H\u0002J\u0010\u0010y\u001a\u00020\u00142\u0006\u0010z\u001a\u00020\u0014H\u0002J:\u0010{\u001a\u00020?2\u0006\u0010j\u001a\u00020\u00012\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010}\u001a\u00020\u00142\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020?0IH\u0002J\u0010\u0010\u007f\u001a\u00020?2\u0006\u0010j\u001a\u00020\u0001H\u0002J\u0011\u0010\u0080\u0001\u001a\u00020?2\u0006\u0010j\u001a\u00020\u0001H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020?2\u0006\u0010j\u001a\u00020\u0001H\u0002J#\u0010\u0087\u0001\u001a\u00020?2\u0006\u0010c\u001a\u00020\r2\u0006\u0010M\u001a\u00020w2\b\u0010$\u001a\u0004\u0018\u00010\u0014H\u0002J\u001b\u0010\u0088\u0001\u001a\u00020?2\b\u0010\u0089\u0001\u001a\u00030\u0083\u00012\u0006\u0010M\u001a\u00020wH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020?2\u0007\u0010\u008b\u0001\u001a\u00020\u001cH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020\u00142\u0007\u0010\u008d\u0001\u001a\u00020\u0014H\u0002J$\u0010\u008e\u0001\u001a\u00020?2\u0007\u0010\u008d\u0001\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020[2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020#0\u000fj\b\u0012\u0004\u0012\u00020#`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00060.R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R*\u00102\u001a\u001e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001403j\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014`5X\u0082\u0004¢\u0006\u0002\n\u0000R#\u00106\u001a\n !*\u0004\u0018\u000107078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u000e\u0010<\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010C\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D03j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D`5X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000Rm\u0010\u0081\u0001\u001a`\u0012\u0004\u0012\u00020\r\u0012%\u0012#\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u0083\u00010\u000fj\t\u0012\u0005\u0012\u00030\u0083\u0001`\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0082\u000103j/\u0012\u0004\u0012\u00020\r\u0012%\u0012#\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u0083\u00010\u000fj\t\u0012\u0005\u0012\u00030\u0083\u0001`\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0082\u0001`5X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0084\u0001\u001a\u001e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001403j\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014`5X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "actions", "Lcom/exampletest/mobilestudiotest/ui/MainActions;", "<init>", "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/ui/MainActions;)V", "body", "Landroid/widget/FrameLayout;", "tab", "", "tabViews", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "tabNames", "", "", "audioBrowser", "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;", "gridHost", "Landroid/view/View;", "searchBox", "Landroid/widget/EditText;", "libraryDir", "Ljava/io/File;", "getLibraryDir", "()Ljava/io/File;", "net", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "items", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;", "cursor", "loading", "", "endReached", "query", "category", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;", "searchGen", "market", "adapter", "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$MarketAdapter;", NotificationCompat.CATEGORY_STATUS, "progress", "Landroid/widget/ProgressBar;", "thumbUrls", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "meta", "Landroid/content/SharedPreferences;", "getMeta", "()Landroid/content/SharedPreferences;", "meta$delegate", "Lkotlin/Lazy;", "dropHighlight", "restyleCats", "Lkotlin/Function0;", "", "priceRow", "price", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$Price;", "invThumbViews", "", "Landroid/widget/ImageView;", "refresh", "scroll", "fill", "Lkotlin/Function1;", "buildMarket", "showCategory", "showMarketplace", "cat", "insertAudio", "item", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioItem;", "newSearch", "loadMore", "insertAsset", "ownedCheck", "openInBrowser", "url", "paidDialog", "refused", "insertDownloaded", "bytes", "", "doc", "Lcom/exampletest/mobilestudiotest/format/RbxDocument;", "insertDecal", "insertSound", "insertMesh", "bindImage", "v", "key", "fmtDate", "iso", "fmtCount", "n", "showDetails", "grid", "into", "cells", "Lkotlin/Triple;", "Landroid/graphics/drawable/Drawable;", "section", "title", "parts", "objects", "invRoblox", "invKind", "invSortNewest", "invRobloxCat", "robloxCats", "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$InvCat;", "deviceKinds", "kindOf", "cls", "chipRow", "labels", "selected", "onPick", "myModels", "installedPlugins", "invCache", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$InvItem;", "invThumbs", "invLoading", "robloxInventory", "loadInventory", "insertInventoryItem", "it", "insertFile", "f", "safeName", "name", "saveToLibrary", "VH", "MarketAdapter", "InvCat", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ToolboxPanel extends LinearLayout {
    private final MainActions actions;
    private final MarketAdapter adapter;
    private AudioBrowser audioBrowser;
    private final FrameLayout body;
    private RobloxApi.Category category;
    private String cursor;
    private final List<String> deviceKinds;
    private boolean dropHighlight;
    private boolean endReached;
    private View gridHost;
    private final HashMap<Integer, Pair<ArrayList<RobloxApi.InvItem>, String>> invCache;
    private String invKind;
    private boolean invLoading;
    private boolean invRoblox;
    private int invRobloxCat;
    private boolean invSortNewest;
    private final HashMap<String, List<ImageView>> invThumbViews;
    private final HashMap<Long, String> invThumbs;
    private final ArrayList<RobloxApi.Item> items;
    private boolean loading;
    private View market;

    /* renamed from: meta$delegate, reason: from kotlin metadata */
    private final Lazy meta;
    private final ExecutorService net;
    private RobloxApi.Price price;
    private View priceRow;
    private ProgressBar progress;
    private String query;
    private Function0<Unit> restyleCats;
    private final List<InvCat> robloxCats;
    private EditText searchBox;
    private int searchGen;
    private TextView status;
    private final Studio studio;
    private int tab;
    private final List<String> tabNames;
    private final ArrayList<TextView> tabViews;
    private final HashMap<Long, String> thumbUrls;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolboxPanel.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$InvCat;", "", "label", "", "types", "", "", "insertAs", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;)V", "getLabel", "()Ljava/lang/String;", "getTypes", "()Ljava/util/List;", "getInsertAs", "()Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class InvCat {
        private final RobloxApi.Category insertAs;
        private final String label;
        private final List<Integer> types;

        public InvCat(String label, List<Integer> types, RobloxApi.Category insertAs) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(types, "types");
            Intrinsics.checkNotNullParameter(insertAs, "insertAs");
            this.label = label;
            this.types = types;
            this.insertAs = insertAs;
        }

        public final RobloxApi.Category getInsertAs() {
            return this.insertAs;
        }

        public final String getLabel() {
            return this.label;
        }

        public final List<Integer> getTypes() {
            return this.types;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolboxPanel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$MarketAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$VH;", "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "h", "position", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class MarketAdapter extends RecyclerView.Adapter<VH> {
        public MarketAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$12(RobloxApi.Item item, ToolboxPanel toolboxPanel, View view) {
            if (item.isPaid()) {
                ToolboxPanel.paidDialog$default(toolboxPanel, item, ToolboxPanel.access$getCategory$p(toolboxPanel), false, 4, null);
            } else {
                ToolboxPanel.insertAsset$default(toolboxPanel, item, null, false, 6, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean onBindViewHolder$lambda$13(ToolboxPanel toolboxPanel, RobloxApi.Item item, View view) {
            ToolboxPanel.showDetails$default(toolboxPanel, item, null, 2, null);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$14(ToolboxPanel toolboxPanel, RobloxApi.Item item, View view) {
            ToolboxPanel.showDetails$default(toolboxPanel, item, null, 2, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ToolboxPanel.access$getItems$p(ToolboxPanel.this).size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(VH vh, int i) {
            onBindViewHolder2(vh, i);
        }

        /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
        public void onBindViewHolder2(VH h, int position) {
            Intrinsics.checkNotNullParameter(h, "h");
            Object obj = ToolboxPanel.access$getItems$p(ToolboxPanel.this).get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            RobloxApi.Item item = (RobloxApi.Item) obj;
            h.getName().setText(item.getName());
            int likePercent = item.getLikePercent();
            h.getBy().setText(item.getCreator() + (likePercent >= 0 ? "  ·  👍 " + likePercent + "%" : ""));
            h.getBy().setTextColor(item.getVerified() ? Ui.INFO : Ui.INSTANCE.getDIM());
            h.getBadge().setVisibility(item.isPaid() ? 0 : 8);
            h.getBadge().setText(item.getPriceText());
            h.getImg().setAlpha(item.isPaid() ? 0.75f : 1.0f);
            String str = (String) ToolboxPanel.access$getThumbUrls$p(ToolboxPanel.this).get(Long.valueOf(item.getId()));
            Bitmap key = str != null ? ImageLoader.INSTANCE.getKey("url:" + str) : null;
            if (key != null) {
                h.getImg().setImageBitmap(key);
            } else {
                h.getImg().setImageDrawable(null);
            }
            h.getRoot().setOnClickListener(new ToolboxPanel$MarketAdapter$$ExternalSyntheticLambda0(item, ToolboxPanel.this));
            h.getRoot().setOnLongClickListener(new ToolboxPanel$MarketAdapter$$ExternalSyntheticLambda1(ToolboxPanel.this, item));
            h.getInfo().setOnClickListener(new ToolboxPanel$MarketAdapter$$ExternalSyntheticLambda2(ToolboxPanel.this, item));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder2(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: onCreateViewHolder, reason: avoid collision after fix types in other method */
        public VH onCreateViewHolder2(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            Ui ui = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            linearLayout.setPadding(ui.dp(context, 4.0f), Ui.INSTANCE.dp(context, 4.0f), Ui.INSTANCE.dp(context, 4.0f), Ui.INSTANCE.dp(context, 6.0f));
            linearLayout.setBackground(Ui.INSTANCE.rippleBg(context, Ui.INSTANCE.getCARD(), 4.0f));
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            layoutParams.setMargins(Ui.INSTANCE.dp(context, 3.0f), Ui.INSTANCE.dp(context, 3.0f), Ui.INSTANCE.dp(context, 3.0f), Ui.INSTANCE.dp(context, 3.0f));
            linearLayout.setLayoutParams(layoutParams);
            ToolboxPanel$MarketAdapter$onCreateViewHolder$img$1 toolboxPanel$MarketAdapter$onCreateViewHolder$img$1 = new ToolboxPanel$MarketAdapter$onCreateViewHolder$img$1(context);
            toolboxPanel$MarketAdapter$onCreateViewHolder$img$1.setScaleType(ImageView.ScaleType.FIT_CENTER);
            toolboxPanel$MarketAdapter$onCreateViewHolder$img$1.setBackgroundColor(Ui.INSTANCE.blend(Ui.INSTANCE.getPANEL(), ViewCompat.MEASURED_STATE_MASK, 0.08f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(toolboxPanel$MarketAdapter$onCreateViewHolder$img$1, new FrameLayout.LayoutParams(-1, -2));
            TextView text = Ui.INSTANCE.text(context, "", 10.0f, -15000805, true);
            text.setPadding(Ui.INSTANCE.dp(context, 5.0f), Ui.INSTANCE.dp(context, 1.0f), Ui.INSTANCE.dp(context, 5.0f), Ui.INSTANCE.dp(context, 1.0f));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-18611);
            gradientDrawable.setCornerRadius(Ui.INSTANCE.dp(context, 4.0f));
            text.setBackground(gradientDrawable);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 8388659);
            layoutParams2.setMargins(Ui.INSTANCE.dp(context, 3.0f), Ui.INSTANCE.dp(context, 3.0f), 0, 0);
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(text, layoutParams2);
            TextView text2 = Ui.INSTANCE.text(context, "ⓘ", 15.0f, -1, true);
            text2.setGravity(17);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(-1728053248);
            text2.setBackground(gradientDrawable2);
            text2.setContentDescription("Details");
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(Ui.INSTANCE.dp(context, 26.0f), Ui.INSTANCE.dp(context, 26.0f), 8388661);
            layoutParams3.setMargins(0, Ui.INSTANCE.dp(context, 2.0f), Ui.INSTANCE.dp(context, 2.0f), 0);
            Unit unit2 = Unit.INSTANCE;
            frameLayout.addView(text2, layoutParams3);
            linearLayout.addView(frameLayout, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
            TextView text$default = Ui.text$default(Ui.INSTANCE, context, "", 12.0f, Ui.INSTANCE.getTEXT(), false, 16, null);
            text$default.setMaxLines(2);
            text$default.setSingleLine(false);
            text$default.setEllipsize(TextUtils.TruncateAt.END);
            text$default.setPadding(0, Ui.INSTANCE.dp(context, 4.0f), 0, 0);
            TextView text$default2 = Ui.text$default(Ui.INSTANCE, context, "", 10.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default2.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout.addView(text$default);
            linearLayout.addView(text$default2);
            return new VH(ToolboxPanel.this, linearLayout, toolboxPanel$MarketAdapter$onCreateViewHolder$img$1, text$default, text$default2, text, text2);
        }
    }

    /* compiled from: ToolboxPanel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/widget/LinearLayout;", "img", "Landroid/widget/ImageView;", "name", "Landroid/widget/TextView;", "by", "badge", "info", "Landroid/view/View;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/widget/LinearLayout;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;)V", "getRoot", "()Landroid/widget/LinearLayout;", "getImg", "()Landroid/widget/ImageView;", "getName", "()Landroid/widget/TextView;", "getBy", "getBadge", "getInfo", "()Landroid/view/View;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class VH extends RecyclerView.ViewHolder {
        private final TextView badge;
        private final TextView by;
        private final ImageView img;
        private final View info;
        private final TextView name;
        private final LinearLayout root;
        final /* synthetic */ ToolboxPanel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ToolboxPanel toolboxPanel, LinearLayout root, ImageView img, TextView name, TextView by, TextView badge, View info) {
            super(root);
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(img, "img");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(by, "by");
            Intrinsics.checkNotNullParameter(badge, "badge");
            Intrinsics.checkNotNullParameter(info, "info");
            this.this$0 = toolboxPanel;
            this.root = root;
            this.img = img;
            this.name = name;
            this.by = by;
            this.badge = badge;
            this.info = info;
        }

        public final TextView getBadge() {
            return this.badge;
        }

        public final TextView getBy() {
            return this.by;
        }

        public final ImageView getImg() {
            return this.img;
        }

        public final View getInfo() {
            return this.info;
        }

        public final TextView getName() {
            return this.name;
        }

        public final LinearLayout getRoot() {
            return this.root;
        }
    }

    /* compiled from: ToolboxPanel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RobloxApi.Price.values().length];
            try {
                iArr[RobloxApi.Price.FREE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RobloxApi.Price.PAID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RobloxApi.Category.values().length];
            try {
                iArr2[RobloxApi.Category.DECALS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[RobloxApi.Category.AUDIO.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[RobloxApi.Category.MESHES.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[RobloxApi.Category.PLUGINS.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolboxPanel(Context ctx, Studio studio, MainActions actions) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(studio, "studio");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.studio = studio;
        this.actions = actions;
        this.body = new FrameLayout(ctx);
        this.tabViews = new ArrayList<>();
        int i = 4;
        boolean z = true;
        this.tabNames = CollectionsKt.listOf((Object[]) new String[]{"Creator Store", "Inventory", "Parts", "Objects"});
        this.net = Executors.newSingleThreadExecutor();
        this.items = new ArrayList<>();
        this.query = "";
        this.category = RobloxApi.Category.MODELS;
        this.adapter = new MarketAdapter();
        this.thumbUrls = new HashMap<>();
        this.meta = LazyKt.lazy(new ToolboxPanel$$ExternalSyntheticLambda5(this));
        this.price = RobloxApi.Price.ANY;
        this.invThumbViews = new HashMap<>();
        setOrientation(1);
        setBackgroundColor(Ui.INSTANCE.getPANEL());
        addView(Ui.INSTANCE.header(ctx, "Toolbox", Icons.general$default(Icons.INSTANCE, ctx, "Toolbox", null, 4, null)), Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        setOnDragListener(new ToolboxPanel$$ExternalSyntheticLambda6(this, ctx));
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(Ui.INSTANCE.getHEADER());
        Iterator<T> it = this.tabNames.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            LinearLayout linearLayout2 = linearLayout;
            TextView text$default = Ui.text$default(Ui.INSTANCE, ctx, (String) it.next(), 12.0f, 0, false, 24, null);
            text$default.setGravity(17);
            text$default.setPadding(Ui.INSTANCE.dp(ctx, 10.0f), Ui.INSTANCE.dp(ctx, 7.0f), Ui.INSTANCE.dp(ctx, 10.0f), Ui.INSTANCE.dp(ctx, 7.0f));
            text$default.setOnClickListener(new ToolboxPanel$$ExternalSyntheticLambda7(this, i2));
            this.tabViews.add(text$default);
            linearLayout2.addView(text$default, Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null));
            linearLayout = linearLayout2;
            i2++;
            z = z;
            i = i;
        }
        int i3 = i;
        boolean z2 = z;
        LinearLayout linearLayout3 = linearLayout;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(ctx);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setBackgroundColor(Ui.INSTANCE.getHEADER());
        horizontalScrollView.addView(linearLayout3);
        addView(horizontalScrollView, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        addView(this.body, Ui.INSTANCE.lp(-1, 0, 1.0f));
        ImageLoader.INSTANCE.getListeners().add(new ToolboxPanel$$ExternalSyntheticLambda8(this));
        refresh();
        this.invKind = "All";
        InvCat[] invCatArr = new InvCat[7];
        invCatArr[0] = new InvCat("Models", CollectionsKt.listOf(10), RobloxApi.Category.MODELS);
        Integer[] numArr = new Integer[2];
        numArr[0] = 40;
        numArr[z2 ? 1 : 0] = Integer.valueOf(i3);
        invCatArr[z2 ? 1 : 0] = new InvCat("Meshes", CollectionsKt.listOf((Object[]) numArr), RobloxApi.Category.MESHES);
        invCatArr[2] = new InvCat("Plugins", CollectionsKt.listOf(38), RobloxApi.Category.PLUGINS);
        invCatArr[3] = new InvCat("Packages", CollectionsKt.listOf(32), RobloxApi.Category.MODELS);
        invCatArr[i3] = new InvCat("Decals", CollectionsKt.listOf(13), RobloxApi.Category.DECALS);
        invCatArr[5] = new InvCat("Audio", CollectionsKt.listOf(3), RobloxApi.Category.AUDIO);
        invCatArr[6] = new InvCat("Animations", CollectionsKt.listOf(24), RobloxApi.Category.MODELS);
        this.robloxCats = CollectionsKt.listOf((Object[]) invCatArr);
        String[] strArr = new String[9];
        strArr[0] = "All";
        strArr[z2 ? 1 : 0] = "Models";
        strArr[2] = "Parts";
        strArr[3] = "Meshes";
        strArr[i3] = "Scripts";
        strArr[5] = "GUI";
        strArr[6] = "Audio";
        strArr[7] = "Images";
        strArr[8] = "Plugins";
        this.deviceKinds = CollectionsKt.listOf((Object[]) strArr);
        this.invCache = new HashMap<>();
        this.invThumbs = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$12(ToolboxPanel toolboxPanel, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        toolboxPanel.post(new ToolboxPanel$$ExternalSyntheticLambda4(key, toolboxPanel));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean _init_$lambda$3(ToolboxPanel toolboxPanel, Context context, View view, DragEvent dragEvent) {
        String name;
        switch (dragEvent.getAction()) {
            case 1:
                return dragEvent.getLocalState() instanceof ExplorerPanel.DragPayload;
            case 2:
            default:
                return true;
            case 3:
                toolboxPanel.setForeground(null);
                Object localState = dragEvent.getLocalState();
                ExplorerPanel.DragPayload dragPayload = localState instanceof ExplorerPanel.DragPayload ? (ExplorerPanel.DragPayload) localState : null;
                if (dragPayload == null) {
                    return false;
                }
                byte[] serializeInstances = toolboxPanel.studio.serializeInstances(dragPayload.getItems());
                if (serializeInstances == null) {
                    toolboxPanel.studio.toast("Those objects can't be saved");
                    return false;
                }
                Instance instance = (Instance) CollectionsKt.first((List) dragPayload.getItems());
                if (dragPayload.getItems().size() > 1) {
                    name = instance.getName() + " (+" + (dragPayload.getItems().size() - 1) + ")";
                } else {
                    name = instance.getName();
                }
                toolboxPanel.saveToLibrary(name, serializeInstances, instance.getClassName());
                toolboxPanel.studio.toast("Saved " + name + " to your Toolbox inventory");
                return true;
            case 4:
            case 6:
                toolboxPanel.dropHighlight = false;
                toolboxPanel.setForeground(null);
                return true;
            case 5:
                toolboxPanel.dropHighlight = true;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(859540459);
                gradientDrawable.setStroke(Ui.INSTANCE.dp(context, 2.0f), Ui.INSTANCE.getACCENT());
                toolboxPanel.setForeground(gradientDrawable);
                return true;
        }
    }

    public static final /* synthetic */ RobloxApi.Category access$getCategory$p(ToolboxPanel toolboxPanel) {
        return toolboxPanel.category;
    }

    public static final /* synthetic */ ArrayList access$getItems$p(ToolboxPanel toolboxPanel) {
        return toolboxPanel.items;
    }

    public static final /* synthetic */ HashMap access$getThumbUrls$p(ToolboxPanel toolboxPanel) {
        return toolboxPanel.thumbUrls;
    }

    public static final /* synthetic */ void access$loadMore(ToolboxPanel toolboxPanel) {
        toolboxPanel.loadMore();
    }

    private final void bindImage(ImageView v, String key) {
        ArrayList arrayList;
        Bitmap key2 = ImageLoader.INSTANCE.getKey(key);
        if (key2 != null) {
            v.setImageBitmap(key2);
            return;
        }
        HashMap<String, List<ImageView>> hashMap = this.invThumbViews;
        List<ImageView> list = hashMap.get(key);
        if (list == null) {
            arrayList = new ArrayList();
            hashMap.put(key, arrayList);
        } else {
            arrayList = list;
        }
        arrayList.add(v);
    }

    private final View buildMarket() {
        RobloxApi.Price price;
        String str = "ANY";
        Context context = getContext();
        try {
            String string = getMeta().getString("priceFilter", "ANY");
            if (string != null) {
                str = string;
            }
            price = RobloxApi.Price.valueOf(str);
        } catch (Exception e) {
            price = RobloxApi.Price.ANY;
        }
        this.price = price;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        Ui ui = Ui.INSTANCE;
        Intrinsics.checkNotNull(context);
        linearLayout2.setPadding(ui.dp(context, 6.0f), Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 2.0f));
        EditText input$default = Ui.input$default(Ui.INSTANCE, context, "", "Search the Creator Store", false, false, 24, null);
        input$default.setTextSize(13.0f);
        input$default.setImeOptions(3);
        input$default.setInputType(1);
        this.searchBox = input$default;
        input$default.setOnEditorActionListener(new ToolboxPanel$$ExternalSyntheticLambda35(this, input$default));
        linearLayout2.addView(input$default, Ui.INSTANCE.lp(0, -2, 1.0f));
        linearLayout2.addView(Ui.INSTANCE.iconButton(context, Icons.INSTANCE.general(context, "FindAll", "Go"), 34.0f, new ToolboxPanel$$ExternalSyntheticLambda36(this, input$default)));
        linearLayout.addView(linearLayout2, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setPadding(Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 2.0f), Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 4.0f));
        ArrayList arrayList = new ArrayList();
        RobloxApi.Category[] values = RobloxApi.Category.values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            RobloxApi.Category category = values[i];
            EditText editText = input$default;
            RobloxApi.Category[] categoryArr = values;
            int i2 = length;
            ArrayList arrayList2 = arrayList;
            TextView text$default = Ui.text$default(Ui.INSTANCE, context, category == RobloxApi.Category.DECALS ? "Images" : category.getLabel(), 12.0f, 0, false, 24, null);
            text$default.setPadding(Ui.INSTANCE.dp(context, 12.0f), Ui.INSTANCE.dp(context, 4.0f), Ui.INSTANCE.dp(context, 12.0f), Ui.INSTANCE.dp(context, 4.0f));
            text$default.setOnClickListener(new ToolboxPanel$$ExternalSyntheticLambda37(this, category, arrayList2, context));
            arrayList2.add(text$default);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
            lp$default.rightMargin = Ui.INSTANCE.dp(context, 6.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout3.addView(text$default, lp$default);
            i++;
            arrayList = arrayList2;
            input$default = editText;
            values = categoryArr;
            length = i2;
        }
        ArrayList arrayList3 = arrayList;
        buildMarket$styleCats(arrayList3, this, context);
        this.restyleCats = new ToolboxPanel$$ExternalSyntheticLambda38(arrayList3, this, context);
        LinearLayout linearLayout4 = new LinearLayout(context);
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(16);
        LinearLayout linearLayout5 = linearLayout4;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.addView(linearLayout3);
        linearLayout5.addView(horizontalScrollView, Ui.INSTANCE.lp(0, -2, 1.0f));
        linearLayout5.addView(Ui.INSTANCE.iconButton(context, Icons.INSTANCE.general(context, "Account", "Acc"), 28.0f, new ToolboxPanel$$ExternalSyntheticLambda39(this)));
        linearLayout.addView(linearLayout5, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        LinearLayout linearLayout6 = new LinearLayout(context);
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(16);
        linearLayout6.setPadding(Ui.INSTANCE.dp(context, 6.0f), 0, Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 4.0f));
        ArrayList arrayList4 = new ArrayList();
        TextView text$default2 = Ui.text$default(Ui.INSTANCE, context, "Price:", 11.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
        lp$default2.rightMargin = Ui.INSTANCE.dp(context, 6.0f);
        Unit unit2 = Unit.INSTANCE;
        linearLayout6.addView(text$default2, lp$default2);
        RobloxApi.Price[] values2 = RobloxApi.Price.values();
        int length2 = values2.length;
        int i3 = 0;
        while (i3 < length2) {
            RobloxApi.Price price2 = values2[i3];
            int i4 = length2;
            int i5 = i3;
            TextView text$default3 = Ui.text$default(Ui.INSTANCE, context, price2.getLabel(), 11.0f, 0, false, 24, null);
            text$default3.setPadding(Ui.INSTANCE.dp(context, 10.0f), Ui.INSTANCE.dp(context, 3.0f), Ui.INSTANCE.dp(context, 10.0f), Ui.INSTANCE.dp(context, 3.0f));
            text$default3.setOnClickListener(new ToolboxPanel$$ExternalSyntheticLambda40(this, price2, arrayList4, context));
            arrayList4.add(text$default3);
            TextView textView = text$default3;
            LinearLayout.LayoutParams lp$default3 = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
            lp$default3.rightMargin = Ui.INSTANCE.dp(context, 5.0f);
            Unit unit3 = Unit.INSTANCE;
            linearLayout6.addView(textView, lp$default3);
            i3 = i5 + 1;
            linearLayout5 = linearLayout5;
            length2 = i4;
        }
        buildMarket$stylePrice(arrayList4, this, context);
        this.priceRow = linearLayout6;
        linearLayout.addView(linearLayout6, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
        FrameLayout frameLayout = new FrameLayout(context);
        RecyclerView recyclerView = new RecyclerView(context);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setItemAnimator(null);
        recyclerView.addOnScrollListener(new ToolboxPanel$buildMarket$10(gridLayoutManager, this));
        recyclerView.addOnLayoutChangeListener(new ToolboxPanel$$ExternalSyntheticLambda41(gridLayoutManager, context));
        frameLayout.addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(8);
        this.progress = progressBar;
        ProgressBar progressBar2 = this.progress;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
            progressBar2 = null;
        }
        frameLayout.addView(progressBar2, new FrameLayout.LayoutParams(Ui.INSTANCE.dp(context, 36.0f), Ui.INSTANCE.dp(context, 36.0f), 17));
        TextView text$default4 = Ui.text$default(Ui.INSTANCE, context, "", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
        text$default4.setSingleLine(false);
        text$default4.setGravity(17);
        text$default4.setPadding(Ui.INSTANCE.dp(context, 16.0f), 0, Ui.INSTANCE.dp(context, 16.0f), 0);
        this.status = text$default4;
        TextView textView2 = this.status;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
            textView2 = null;
        }
        frameLayout.addView(textView2, new FrameLayout.LayoutParams(-1, -2, 17));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.gridHost = frameLayout;
        AudioBrowser audioBrowser = new AudioBrowser(context, new ToolboxPanel$$ExternalSyntheticLambda42(this), new ToolboxPanel$$ExternalSyntheticLambda43(context, (Activity) context));
        audioBrowser.setVisibility(8);
        this.audioBrowser = audioBrowser;
        frameLayout2.addView(audioBrowser, new FrameLayout.LayoutParams(-1, -1));
        linearLayout.addView(frameLayout2, Ui.INSTANCE.lp(-1, 0, 1.0f));
        showCategory();
        return linearLayout;
    }

    private static final void buildMarket$go(ToolboxPanel toolboxPanel, EditText editText) {
        toolboxPanel.query = editText.getText().toString();
        if (toolboxPanel.category != RobloxApi.Category.AUDIO) {
            toolboxPanel.newSearch();
            return;
        }
        AudioBrowser audioBrowser = toolboxPanel.audioBrowser;
        if (audioBrowser != null) {
            audioBrowser.search(toolboxPanel.query);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean buildMarket$lambda$24(ToolboxPanel toolboxPanel, EditText editText, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            if (!(keyEvent != null && keyEvent.getKeyCode() == 66) || keyEvent.getAction() != 0) {
                return false;
            }
        }
        buildMarket$go(toolboxPanel, editText);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildMarket$lambda$25(ToolboxPanel toolboxPanel, EditText editText, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        buildMarket$go(toolboxPanel, editText);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void buildMarket$lambda$30$lambda$29(ToolboxPanel toolboxPanel, RobloxApi.Category category, ArrayList arrayList, Context context, View view) {
        toolboxPanel.category = category;
        buildMarket$styleCats(arrayList, toolboxPanel, context);
        toolboxPanel.showCategory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildMarket$lambda$32(ArrayList arrayList, ToolboxPanel toolboxPanel, Context context) {
        buildMarket$styleCats(arrayList, toolboxPanel, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildMarket$lambda$35(ToolboxPanel toolboxPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AccountUi accountUi = AccountUi.INSTANCE;
        Context context = toolboxPanel.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        accountUi.show((Activity) context, toolboxPanel.studio, toolboxPanel.actions);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void buildMarket$lambda$41$lambda$40(ToolboxPanel toolboxPanel, RobloxApi.Price price, ArrayList arrayList, Context context, View view) {
        toolboxPanel.price = price;
        toolboxPanel.getMeta().edit().putString("priceFilter", price.name()).apply();
        buildMarket$stylePrice(arrayList, toolboxPanel, context);
        if (toolboxPanel.category != RobloxApi.Category.AUDIO) {
            toolboxPanel.newSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void buildMarket$lambda$43(GridLayoutManager gridLayoutManager, Context context, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 - i != i7 - i5) {
            Ui ui = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            gridLayoutManager.setSpanCount(RangesKt.coerceIn((i3 - i) / ui.dp(context, 112.0f), 1, 6));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildMarket$lambda$46(ToolboxPanel toolboxPanel, RobloxApi.AudioItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        toolboxPanel.insertAudio(item);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildMarket$lambda$48(Context context, Activity activity, Function0 then) {
        Intrinsics.checkNotNullParameter(then, "then");
        if (RobloxApi.INSTANCE.hasCredentials(context)) {
            then.invoke();
        } else {
            AccountUi.INSTANCE.signIn(activity, new ToolboxPanel$$ExternalSyntheticLambda54(then));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit buildMarket$lambda$48$lambda$47(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final void buildMarket$styleCats(ArrayList<TextView> arrayList, ToolboxPanel toolboxPanel, Context context) {
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            boolean z = RobloxApi.Category.values()[i] == toolboxPanel.category;
            GradientDrawable gradientDrawable = new GradientDrawable();
            Ui ui = Ui.INSTANCE;
            gradientDrawable.setColor(z ? ui.getACCENT() : ui.getHOVER());
            Ui ui2 = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            gradientDrawable.setCornerRadius(ui2.dp(context, 12.0f));
            textView.setBackground(gradientDrawable);
            textView.setTextColor(z ? -1 : Ui.INSTANCE.getTEXT());
            i = i2;
        }
    }

    private static final void buildMarket$stylePrice(ArrayList<TextView> arrayList, ToolboxPanel toolboxPanel, Context context) {
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            boolean z = RobloxApi.Price.values()[i] == toolboxPanel.price;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(z ? Ui.INSTANCE.getACCENT() : 0);
            Ui ui = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            int dp = ui.dp(context, 1.0f);
            Ui ui2 = Ui.INSTANCE;
            gradientDrawable.setStroke(dp, z ? ui2.getACCENT() : ui2.getBORDER());
            gradientDrawable.setCornerRadius(Ui.INSTANCE.dp(context, 10.0f));
            textView.setBackground(gradientDrawable);
            textView.setTextColor(z ? -1 : Ui.INSTANCE.getDIM());
            i = i2;
        }
    }

    private final void chipRow(LinearLayout into, List<String> labels, String selected, Function1<? super String, Unit> onPick) {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        Ui ui = Ui.INSTANCE;
        Intrinsics.checkNotNull(context);
        linearLayout.setPadding(ui.dp(context, 6.0f), Ui.INSTANCE.dp(context, 4.0f), Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 2.0f));
        for (String str : labels) {
            boolean areEqual = Intrinsics.areEqual(str, selected);
            TextView text$default = Ui.text$default(Ui.INSTANCE, context, str, 11.0f, areEqual ? -1 : Ui.INSTANCE.getTEXT(), false, 16, null);
            text$default.setPadding(Ui.INSTANCE.dp(context, 10.0f), Ui.INSTANCE.dp(context, 4.0f), Ui.INSTANCE.dp(context, 10.0f), Ui.INSTANCE.dp(context, 4.0f));
            GradientDrawable gradientDrawable = new GradientDrawable();
            Ui ui2 = Ui.INSTANCE;
            gradientDrawable.setColor(areEqual ? ui2.getACCENT() : ui2.getHOVER());
            gradientDrawable.setCornerRadius(Ui.INSTANCE.dp(context, 12.0f));
            text$default.setBackground(gradientDrawable);
            text$default.setOnClickListener(new ToolboxPanel$$ExternalSyntheticLambda13(onPick, str));
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -2, -2, 0.0f, 4, null);
            lp$default.rightMargin = Ui.INSTANCE.dp(context, 5.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(text$default, lp$default);
        }
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.addView(linearLayout);
        into.addView(horizontalScrollView, Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void chipRow$lambda$139$lambda$138(Function1 function1, String str, View view) {
        function1.invoke(str);
    }

    private final String fmtCount(int n) {
        if (n >= 1000000) {
            String format = String.format("%.1fM", Arrays.copyOf(new Object[]{Float.valueOf(n / 1000000.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        if (n < 1000) {
            return String.valueOf(n);
        }
        String format2 = String.format("%.1fK", Arrays.copyOf(new Object[]{Float.valueOf(n / 1000.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    private final String fmtDate(String iso) {
        String take = StringsKt.take(iso, 10);
        if (StringsKt.isBlank(take)) {
            take = "—";
        }
        return take;
    }

    private final SharedPreferences getMeta() {
        return (SharedPreferences) this.meta.getValue();
    }

    private final void grid(LinearLayout into, List<? extends Triple<? extends Drawable, String, ? extends Function0<Unit>>> cells) {
        GridLayout gridLayout = new GridLayout(getContext());
        gridLayout.setColumnCount(3);
        Ui ui = Ui.INSTANCE;
        Context context = gridLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int dp = ui.dp(context, 4.0f);
        Ui ui2 = Ui.INSTANCE;
        Context context2 = gridLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        int dp2 = ui2.dp(context2, 4.0f);
        Ui ui3 = Ui.INSTANCE;
        Context context3 = gridLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        gridLayout.setPadding(dp, dp2, ui3.dp(context3, 4.0f), 0);
        Ui ui4 = Ui.INSTANCE;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        int dp3 = ui4.dp(context4, 74.0f);
        Iterator<? extends Triple<? extends Drawable, String, ? extends Function0<Unit>>> it = cells.iterator();
        while (it.hasNext()) {
            Triple<? extends Drawable, String, ? extends Function0<Unit>> next = it.next();
            Drawable component1 = next.component1();
            String component2 = next.component2();
            Function0<Unit> component3 = next.component3();
            Ui ui5 = Ui.INSTANCE;
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            LinearLayout linearLayout = ui5.toolButton(context5, component1, component2, new ToolboxPanel$$ExternalSyntheticLambda64(component3));
            Ui ui6 = Ui.INSTANCE;
            Context context6 = getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
            linearLayout.setBackground(Ui.rippleBg$default(ui6, context6, Ui.INSTANCE.getHOVER(), 0.0f, 4, null));
            View childAt = linearLayout.getChildAt(1);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt;
            textView.setTextSize(10.0f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = dp3;
            Ui ui7 = Ui.INSTANCE;
            Context context7 = getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
            layoutParams.height = ui7.dp(context7, 62.0f);
            Ui ui8 = Ui.INSTANCE;
            Context context8 = getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
            int dp4 = ui8.dp(context8, 3.0f);
            Ui ui9 = Ui.INSTANCE;
            Context context9 = getContext();
            Intrinsics.checkNotNullExpressionValue(context9, "getContext(...)");
            int dp5 = ui9.dp(context9, 3.0f);
            Ui ui10 = Ui.INSTANCE;
            int i = dp3;
            Context context10 = getContext();
            Intrinsics.checkNotNullExpressionValue(context10, "getContext(...)");
            int dp6 = ui10.dp(context10, 3.0f);
            Ui ui11 = Ui.INSTANCE;
            Iterator<? extends Triple<? extends Drawable, String, ? extends Function0<Unit>>> it2 = it;
            Context context11 = getContext();
            Intrinsics.checkNotNullExpressionValue(context11, "getContext(...)");
            layoutParams.setMargins(dp4, dp5, dp6, ui11.dp(context11, 3.0f));
            Unit unit = Unit.INSTANCE;
            gridLayout.addView(linearLayout, layoutParams);
            dp3 = i;
            it = it2;
        }
        into.addView(gridLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit grid$lambda$113(Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void insertAsset(RobloxApi.Item item, RobloxApi.Category cat, boolean ownedCheck) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        switch (WhenMappings.$EnumSwitchMapping$1[cat.ordinal()]) {
            case 1:
                insertDecal(item);
                return;
            case 2:
                insertSound(item);
                return;
            case 3:
                insertMesh(item);
                return;
            case 4:
                if (item.isPaid() && !ownedCheck) {
                    paidDialog$default(this, item, cat, false, 4, null);
                    return;
                }
                Dialogs.INSTANCE.confirm(context, "Install plugin", "Install “" + item.getName() + "” by " + item.getCreator() + "?" + (item.getHasScripts() ? "\n\nPlugins run code in Studio; only install ones you trust." : ""), "Install", new ToolboxPanel$$ExternalSyntheticLambda9(context, activity, this, item));
                return;
            default:
                if (!RobloxApi.INSTANCE.hasCredentials(context)) {
                    AccountUi.INSTANCE.signIn(activity, new ToolboxPanel$$ExternalSyntheticLambda10(this, item, cat, ownedCheck));
                    return;
                } else if (item.isPaid() && !ownedCheck) {
                    paidDialog$default(this, item, cat, false, 4, null);
                    return;
                } else {
                    this.studio.toast("Inserting " + item.getName() + "…");
                    this.net.execute(new ToolboxPanel$$ExternalSyntheticLambda11(context, item, this, cat, activity, ownedCheck));
                    return;
                }
        }
    }

    static /* synthetic */ void insertAsset$default(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            category = toolboxPanel.category;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        toolboxPanel.insertAsset(item, category, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertAsset$lambda$59(Context context, Activity activity, ToolboxPanel toolboxPanel, RobloxApi.Item item) {
        if (RobloxApi.INSTANCE.hasCredentials(context)) {
            AccountUi.INSTANCE.installPluginId(activity, toolboxPanel.studio, toolboxPanel.actions, item.getId(), item.getName());
        } else {
            AccountUi.INSTANCE.signIn(activity, new ToolboxPanel$$ExternalSyntheticLambda47(activity, toolboxPanel, item));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertAsset$lambda$59$lambda$58(Activity activity, ToolboxPanel toolboxPanel, RobloxApi.Item item) {
        AccountUi.INSTANCE.installPluginId(activity, toolboxPanel.studio, toolboxPanel.actions, item.getId(), item.getName());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertAsset$lambda$60(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category, boolean z) {
        toolboxPanel.insertAsset(item, category, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertAsset$lambda$67(Context context, RobloxApi.Item item, ToolboxPanel toolboxPanel, RobloxApi.Category category, Activity activity, boolean z) {
        try {
            byte[] downloadAsset$default = RobloxApi.downloadAsset$default(RobloxApi.INSTANCE, context, item.getId(), null, 4, null);
            RbxDocument read = RbxFile.INSTANCE.read(downloadAsset$default);
            if (RbxFile.INSTANCE.isPlace(read)) {
                throw new Exception("This asset is a place, not a model");
            }
            if (item.getHasScripts()) {
                OutputLog.INSTANCE.warn(item.getName() + " contains scripts. Check them before playtesting, like you would in Studio.");
            }
            toolboxPanel.studio.getMain().post(new ToolboxPanel$$ExternalSyntheticLambda21(toolboxPanel, item, downloadAsset$default, read));
        } catch (AuthRequiredException e) {
            toolboxPanel.studio.getMain().post(new ToolboxPanel$$ExternalSyntheticLambda22(item, toolboxPanel, category, e, activity));
        } catch (HttpException e2) {
            if (e2.getCode() == 403) {
                toolboxPanel.studio.getMain().post(new ToolboxPanel$$ExternalSyntheticLambda23(toolboxPanel, item, category));
                return;
            }
            if (e2.getCode() == 401) {
                toolboxPanel.studio.getMain().post(new ToolboxPanel$$ExternalSyntheticLambda24(activity, toolboxPanel, item, category, z));
                return;
            }
            OutputLog.INSTANCE.error("Couldn't insert " + item.getName() + ": " + e2.getMessage());
            toolboxPanel.studio.toast("Insert failed: " + e2.getMessage());
        } catch (Exception e3) {
            OutputLog.INSTANCE.error("Couldn't insert " + item.getName() + ": " + e3.getMessage());
            toolboxPanel.studio.toast("Insert failed: " + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertAsset$lambda$67$lambda$61(ToolboxPanel toolboxPanel, RobloxApi.Item item, byte[] bArr, RbxDocument rbxDocument) {
        toolboxPanel.insertDownloaded(item, bArr, rbxDocument);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertAsset$lambda$67$lambda$63(RobloxApi.Item item, ToolboxPanel toolboxPanel, RobloxApi.Category category, AuthRequiredException authRequiredException, Activity activity) {
        if (item.isPaid()) {
            toolboxPanel.paidDialog(item, category, true);
            return;
        }
        Studio studio = toolboxPanel.studio;
        String message = authRequiredException.getMessage();
        if (message == null) {
            message = "Sign in needed";
        }
        studio.toast(message);
        AccountUi.INSTANCE.signIn(activity, new ToolboxPanel$$ExternalSyntheticLambda65(toolboxPanel, item, category));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertAsset$lambda$67$lambda$63$lambda$62(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category) {
        insertAsset$default(toolboxPanel, item, category, false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertAsset$lambda$67$lambda$64(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category) {
        toolboxPanel.paidDialog(item, category, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertAsset$lambda$67$lambda$66(Activity activity, ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category, boolean z) {
        AccountUi.INSTANCE.signIn(activity, new ToolboxPanel$$ExternalSyntheticLambda31(toolboxPanel, item, category, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertAsset$lambda$67$lambda$66$lambda$65(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category, boolean z) {
        toolboxPanel.insertAsset(item, category, z);
        return Unit.INSTANCE;
    }

    private final void insertAudio(RobloxApi.AudioItem item) {
        long id = item.getId();
        String title = item.getTitle();
        if (StringsKt.isBlank(title)) {
            title = item.getName();
        }
        insertSound(new RobloxApi.Item(id, title, item.getCreator(), item.getVerified(), "", 0, 0, false, false, 0L, 0, 0, 0, 0, 0, null, null, 0L, false, null, 1048064, null));
    }

    private final void insertDecal(RobloxApi.Item item) {
        Object obj;
        Instance instance;
        synchronized (this.studio.getLock()) {
            Iterator<T> it = this.studio.getSelection().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((Instance) obj).isA("BasePart")) {
                        break;
                    }
                }
            }
            Instance instance2 = (Instance) obj;
            if (instance2 == null) {
                instance = Studio.insertObject$default(this.studio, "Part", null, 2, null);
                Instance.set$default(instance, "size", new Vector3(6.0f, 6.0f, 0.4f), false, 4, null);
                Instance.set$default(instance, "Anchored", true, false, 4, null);
            } else {
                instance = instance2;
            }
            Instance create = InstanceFactory.INSTANCE.create("Decal");
            String take = StringsKt.take(item.getName(), 40);
            if (StringsKt.isBlank(take)) {
                take = "Decal";
            }
            create.setName(take);
            Instance.set$default(create, "Texture", "rbxassetid://" + item.getId(), false, 4, null);
            Instance.set$default(create, "Face", new EnumValue(5), false, 4, null);
            this.studio.getUndo().begin("Insert decal");
            this.studio.reparent(create, instance);
            this.studio.getUndo().commit();
            Unit unit = Unit.INSTANCE;
        }
        this.studio.toast("Added decal " + item.getName());
    }

    private final void insertDownloaded(RobloxApi.Item item, byte[] bytes, RbxDocument doc) {
        Studio.insertDocument$default(this.studio, doc, null, 2, null);
        OutputLog.INSTANCE.info("Inserted " + item.getName() + " (" + item.getId() + ") from Roblox");
        try {
            new File(getLibraryDir(), "recent").mkdirs();
            File file = new File(new File(getLibraryDir(), "recent"), safeName(item.getName()) + ".rbxm");
            FilesKt.writeBytes(file, RbxFile.INSTANCE.unwrap(bytes));
            Instance instance = (Instance) CollectionsKt.firstOrNull((List) doc.getRoots());
            if (instance != null) {
                getMeta().edit().putString("recent/" + file.getName(), instance.getClassName()).apply();
            }
        } catch (Exception e) {
        }
    }

    private final void insertFile(File f) {
        new Thread(new ToolboxPanel$$ExternalSyntheticLambda30(f, this)).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertFile$lambda$217(File file, ToolboxPanel toolboxPanel) {
        try {
            RbxDocument read = RbxFile.INSTANCE.read(FilesKt.readBytes(file));
            if (RbxFile.INSTANCE.isPlace(read)) {
                OutputLog.INSTANCE.error(file.getName() + " is a place file; open it with File → Open");
            } else {
                Iterator it = CollectionsKt.take(read.getWarnings(), 5).iterator();
                while (it.hasNext()) {
                    OutputLog.INSTANCE.warn((String) it.next());
                }
                toolboxPanel.studio.getMain().post(new ToolboxPanel$$ExternalSyntheticLambda1(toolboxPanel, read));
            }
        } catch (Exception e) {
            OutputLog.INSTANCE.error("Could not insert " + file.getName() + ": " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertFile$lambda$217$lambda$216(ToolboxPanel toolboxPanel, RbxDocument rbxDocument) {
        Studio.insertDocument$default(toolboxPanel.studio, rbxDocument, null, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00c0, code lost:
    
        if (r4 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void insertInventoryItem(com.exampletest.mobilestudiotest.net.RobloxApi.InvItem r29, com.exampletest.mobilestudiotest.ui.ToolboxPanel.InvCat r30) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.ToolboxPanel.insertInventoryItem(com.exampletest.mobilestudiotest.net.RobloxApi$InvItem, com.exampletest.mobilestudiotest.ui.ToolboxPanel$InvCat):void");
    }

    private final void insertMesh(RobloxApi.Item item) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        if (!RobloxApi.INSTANCE.hasCredentials(context)) {
            AccountUi.INSTANCE.signIn(activity, new ToolboxPanel$$ExternalSyntheticLambda28(this, item));
            return;
        }
        this.studio.toast("Inserting " + item.getName() + "…");
        this.net.execute(new ToolboxPanel$$ExternalSyntheticLambda29(item, this, activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertMesh$lambda$80(ToolboxPanel toolboxPanel, RobloxApi.Item item) {
        toolboxPanel.insertMesh(item);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertMesh$lambda$89(RobloxApi.Item item, ToolboxPanel toolboxPanel, Activity activity) {
        try {
            try {
                byte[] load = AssetFetcher.INSTANCE.load(item.getId());
                RbxDocument rbxDocument = null;
                try {
                    RbxDocument read = RbxFile.INSTANCE.read(load);
                    if (!read.getRoots().isEmpty()) {
                        rbxDocument = read;
                    }
                } catch (Exception e) {
                }
                if (rbxDocument != null) {
                    toolboxPanel.studio.getMain().post(new ToolboxPanel$$ExternalSyntheticLambda25(toolboxPanel, item, load, rbxDocument));
                    return;
                }
                MeshData parse = RbxMesh.INSTANCE.parse(load);
                Vector3 vector3 = new Vector3(parse.size(0), parse.size(1), parse.size(2));
                if (vector3.getX() <= 0.01f || vector3.getY() <= 0.01f || vector3.getZ() <= 0.01f) {
                    vector3 = new Vector3(4.0f, 4.0f, 4.0f);
                }
                toolboxPanel.studio.getMain().post(new ToolboxPanel$$ExternalSyntheticLambda26(toolboxPanel, item, vector3));
            } catch (AuthRequiredException e2) {
                toolboxPanel.studio.getMain().post(new ToolboxPanel$$ExternalSyntheticLambda27(toolboxPanel, e2, activity, item));
            }
        } catch (Exception e3) {
            OutputLog outputLog = OutputLog.INSTANCE;
            String name = item.getName();
            String message = e3.getMessage();
            outputLog.error("Couldn't insert mesh " + name + ": " + (message != null ? message : e3));
            toolboxPanel.studio.toast("Insert failed: " + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertMesh$lambda$89$lambda$82(ToolboxPanel toolboxPanel, RobloxApi.Item item, byte[] bArr, RbxDocument rbxDocument) {
        toolboxPanel.insertDownloaded(item, bArr, rbxDocument);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertMesh$lambda$89$lambda$86(ToolboxPanel toolboxPanel, RobloxApi.Item item, Vector3 vector3) {
        Instance insertObject$default = Studio.insertObject$default(toolboxPanel.studio, "MeshPart", null, 2, null);
        synchronized (toolboxPanel.studio.getLock()) {
            try {
                Vector3 size = PartData.INSTANCE.size(insertObject$default);
                String take = StringsKt.take(item.getName(), 40);
                if (StringsKt.isBlank(take)) {
                    take = "MeshPart";
                }
                insertObject$default.setName(take);
                Instance.set$default(insertObject$default, "MeshId", "rbxassetid://" + item.getId(), false, 4, null);
                try {
                    Instance.set$default(insertObject$default, "size", vector3, false, 4, null);
                    insertObject$default.set("InitialSize", vector3, false);
                    Instance.set$default(insertObject$default, "Anchored", true, false, 4, null);
                    Instance.set$default(insertObject$default, "CFrame", PartData.INSTANCE.cframe(insertObject$default).plus(new Vector3(0.0f, (vector3.getY() - size.getY()) / 2.0f, 0.0f)), false, 4, null);
                    Unit unit = Unit.INSTANCE;
                    OutputLog.INSTANCE.info("Inserted mesh " + item.getName() + " (" + item.getId() + ")");
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void insertMesh$lambda$89$lambda$88(ToolboxPanel toolboxPanel, AuthRequiredException authRequiredException, Activity activity, RobloxApi.Item item) {
        Studio studio = toolboxPanel.studio;
        String message = authRequiredException.getMessage();
        if (message == null) {
            message = "Sign in needed";
        }
        studio.toast(message);
        AccountUi.INSTANCE.signIn(activity, new ToolboxPanel$$ExternalSyntheticLambda14(toolboxPanel, item));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertMesh$lambda$89$lambda$88$lambda$87(ToolboxPanel toolboxPanel, RobloxApi.Item item) {
        toolboxPanel.insertMesh(item);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
    
        if (r2 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void insertSound(com.exampletest.mobilestudiotest.net.RobloxApi.Item r10) {
        /*
            r9 = this;
            com.exampletest.mobilestudiotest.core.Studio r0 = r9.studio
            java.lang.Object r1 = r0.getLock()
            monitor-enter(r1)
            r0 = 0
            com.exampletest.mobilestudiotest.model.InstanceFactory r2 = com.exampletest.mobilestudiotest.model.InstanceFactory.INSTANCE     // Catch: java.lang.Throwable -> Lf7
            java.lang.String r3 = "Sound"
            com.exampletest.mobilestudiotest.model.Instance r2 = r2.create(r3)     // Catch: java.lang.Throwable -> Lf7
            r3 = r2
            java.lang.String r2 = r10.getName()     // Catch: java.lang.Throwable -> Lf7
            r4 = 40
            java.lang.String r2 = kotlin.text.StringsKt.take(r2, r4)     // Catch: java.lang.Throwable -> Lf7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Throwable -> Lf7
            boolean r4 = kotlin.text.StringsKt.isBlank(r2)     // Catch: java.lang.Throwable -> Lf7
            if (r4 == 0) goto L27
            r2 = 0
            java.lang.String r4 = "Sound"
            r2 = r4
        L27:
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Lf7
            r3.setName(r2)     // Catch: java.lang.Throwable -> Lf7
            java.lang.String r4 = "SoundId"
            long r5 = r10.getId()     // Catch: java.lang.Throwable -> Lf7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf7
            r2.<init>()     // Catch: java.lang.Throwable -> Lf7
            java.lang.String r7 = "rbxassetid://"
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch: java.lang.Throwable -> Lf7
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Throwable -> Lf7
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> Lf7
            r7 = 4
            r8 = 0
            r6 = 0
            com.exampletest.mobilestudiotest.model.Instance.set$default(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.core.Studio r2 = r9.studio     // Catch: java.lang.Throwable -> Lf7
            java.util.ArrayList r2 = r2.getSelection()     // Catch: java.lang.Throwable -> Lf7
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> Lf7
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.model.Instance r2 = (com.exampletest.mobilestudiotest.model.Instance) r2     // Catch: java.lang.Throwable -> Lf7
            if (r2 == 0) goto L83
            r4 = r2
            r5 = 0
            boolean r6 = r4.getIsService()     // Catch: java.lang.Throwable -> Lf7
            if (r6 == 0) goto L7d
            java.lang.String r6 = r4.getClassName()     // Catch: java.lang.Throwable -> Lf7
            java.lang.String r7 = "Workspace"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)     // Catch: java.lang.Throwable -> Lf7
            if (r6 != 0) goto L7d
            java.lang.String r6 = r4.getClassName()     // Catch: java.lang.Throwable -> Lf7
            java.lang.String r7 = "SoundService"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)     // Catch: java.lang.Throwable -> Lf7
            if (r6 != 0) goto L7d
            r6 = 0
            goto L7e
        L7d:
            r6 = 1
        L7e:
            if (r6 != 0) goto L81
            r2 = 0
        L81:
            if (r2 != 0) goto L8d
        L83:
            com.exampletest.mobilestudiotest.core.Studio r2 = r9.studio     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.model.DataModel r2 = r2.getModel()     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.model.Instance r2 = r2.getWorkspace()     // Catch: java.lang.Throwable -> Lf7
        L8d:
            com.exampletest.mobilestudiotest.core.Studio r4 = r9.studio     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.core.UndoManager r4 = r4.getUndo()     // Catch: java.lang.Throwable -> Lf7
            java.lang.String r5 = "Insert sound"
            r4.begin(r5)     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.core.Studio r4 = r9.studio     // Catch: java.lang.Throwable -> Lf7
            r4.reparent(r3, r2)     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.core.Studio r4 = r9.studio     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.core.UndoManager r4 = r4.getUndo()     // Catch: java.lang.Throwable -> Lf7
            r4.commit()     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.core.Studio r4 = r9.studio     // Catch: java.lang.Throwable -> Lf7
            java.util.ArrayList r4 = r4.getSelection()     // Catch: java.lang.Throwable -> Lf7
            r4.clear()     // Catch: java.lang.Throwable -> Lf7
            com.exampletest.mobilestudiotest.core.Studio r4 = r9.studio     // Catch: java.lang.Throwable -> Lf7
            java.util.ArrayList r4 = r4.getSelection()     // Catch: java.lang.Throwable -> Lf7
            r4.add(r3)     // Catch: java.lang.Throwable -> Lf7
            monitor-exit(r1)
            com.exampletest.mobilestudiotest.core.Studio r0 = r9.studio
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.getListeners()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        Lc6:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Ld9
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.exampletest.mobilestudiotest.core.Studio$Listener r4 = (com.exampletest.mobilestudiotest.core.Studio.Listener) r4
            r5 = 0
            r4.onSelectionChanged()
            goto Lc6
        Ld9:
            com.exampletest.mobilestudiotest.core.Studio r0 = r9.studio
            java.lang.String r1 = r10.getName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Added sound "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r0.toast(r1)
            return
        Lf7:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.ToolboxPanel.insertSound(com.exampletest.mobilestudiotest.net.RobloxApi$Item):void");
    }

    private final void installedPlugins(LinearLayout into) {
        ToolboxPanel toolboxPanel = this;
        Context context = toolboxPanel.getContext();
        List<File> list = toolboxPanel.studio.getPlugins().list();
        if (toolboxPanel.invSortNewest) {
            list = CollectionsKt.sortedWith(list, new ToolboxPanel$installedPlugins$lambda$165$$inlined$sortedByDescending$1());
        }
        List<File> list2 = list;
        float f = 8.0f;
        if (list2.isEmpty()) {
            Ui ui = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            TextView text$default = Ui.text$default(ui, context, "No plugins installed. Get some from the Creator Store (Plugins) or My Roblox items → Plugins.", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default.setSingleLine(false);
            text$default.setPadding(Ui.INSTANCE.dp(context, 12.0f), Ui.INSTANCE.dp(context, 8.0f), Ui.INSTANCE.dp(context, 12.0f), 0);
            into.addView(text$default);
            return;
        }
        for (File file : list2) {
            boolean isEnabled = toolboxPanel.studio.getPlugins().isEnabled(file);
            Ui ui2 = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            TextView iconTextButton = ui2.iconTextButton(context, Icons.INSTANCE.instance(context, "Plugin"), FilesKt.getNameWithoutExtension(file) + (isEnabled ? "" : "  (off)"), Ui.INSTANCE.getHOVER(), new ToolboxPanel$$ExternalSyntheticLambda60(isEnabled, context, file, toolboxPanel));
            iconTextButton.setGravity(NavigationBarView.ITEM_GRAVITY_START_CENTER);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default.setMargins(Ui.INSTANCE.dp(context, f), Ui.INSTANCE.dp(context, 2.0f), Ui.INSTANCE.dp(context, f), Ui.INSTANCE.dp(context, 2.0f));
            Unit unit = Unit.INSTANCE;
            into.addView(iconTextButton, lp$default);
            f = 8.0f;
            toolboxPanel = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit installedPlugins$lambda$169(boolean z, Context context, File file, ToolboxPanel toolboxPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String[] strArr = new String[2];
        strArr[0] = z ? "Turn off" : "Turn on";
        strArr[1] = "Uninstall";
        List listOf = CollectionsKt.listOf((Object[]) strArr);
        Dialogs dialogs = Dialogs.INSTANCE;
        Intrinsics.checkNotNull(context);
        dialogs.themed(context).setTitle(FilesKt.getNameWithoutExtension(file)).setItems((CharSequence[]) listOf.toArray(new String[0]), new ToolboxPanel$$ExternalSyntheticLambda34(toolboxPanel, file, z, context)).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void installedPlugins$lambda$169$lambda$168(ToolboxPanel toolboxPanel, File file, boolean z, Context context, DialogInterface dialogInterface, int i) {
        if (i == 0) {
            toolboxPanel.studio.getPlugins().setEnabled(file, !z);
            toolboxPanel.studio.getPlugins().loadAll();
        } else {
            Dialogs dialogs = Dialogs.INSTANCE;
            Intrinsics.checkNotNull(context);
            dialogs.confirm(context, "Remove plugin", "Uninstall " + FilesKt.getNameWithoutExtension(file) + "?", "Remove", new ToolboxPanel$$ExternalSyntheticLambda52(toolboxPanel, file));
        }
        toolboxPanel.refresh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit installedPlugins$lambda$169$lambda$168$lambda$167(ToolboxPanel toolboxPanel, File file) {
        toolboxPanel.studio.getPlugins().remove(file);
        toolboxPanel.studio.getPlugins().loadAll();
        return Unit.INSTANCE;
    }

    private final String kindOf(String cls) {
        return (Intrinsics.areEqual(cls, "Script") || Intrinsics.areEqual(cls, "LocalScript") || Intrinsics.areEqual(cls, "ModuleScript")) ? "Scripts" : (Intrinsics.areEqual(cls, "MeshPart") || Intrinsics.areEqual(cls, "SpecialMesh")) ? "Meshes" : (Intrinsics.areEqual(cls, "Sound") || Intrinsics.areEqual(cls, "SoundGroup")) ? "Audio" : (Intrinsics.areEqual(cls, "Decal") || Intrinsics.areEqual(cls, "Texture") || Intrinsics.areEqual(cls, "SurfaceAppearance")) ? "Images" : (StringsKt.endsWith$default(cls, "Part", false, 2, (Object) null) || StringsKt.endsWith$default(cls, "Operation", false, 2, (Object) null) || Intrinsics.areEqual(cls, "Seat") || Intrinsics.areEqual(cls, "VehicleSeat") || Intrinsics.areEqual(cls, "SpawnLocation") || Intrinsics.areEqual(cls, "Terrain")) ? "Parts" : (StringsKt.endsWith$default(cls, "Gui", false, 2, (Object) null) || StringsKt.startsWith$default(cls, "UI", false, 2, (Object) null) || StringsKt.startsWith$default(cls, "Text", false, 2, (Object) null) || StringsKt.startsWith$default(cls, "Image", false, 2, (Object) null) || StringsKt.endsWith$default(cls, "Frame", false, 2, (Object) null) || Intrinsics.areEqual(cls, "VideoFrame")) ? "GUI" : "Models";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$12$lambda$11(String str, ToolboxPanel toolboxPanel) {
        Bitmap peekKey;
        if (StringsKt.startsWith$default(str, "url:", false, 2, (Object) null)) {
            toolboxPanel.adapter.notifyDataSetChanged();
        }
        List<ImageView> remove = toolboxPanel.invThumbViews.remove(str);
        if (remove == null || (peekKey = ImageLoader.INSTANCE.peekKey(str)) == null) {
            return;
        }
        Iterator<T> it = remove.iterator();
        while (it.hasNext()) {
            ((ImageView) it.next()).setImageBitmap(peekKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$6$lambda$5(ToolboxPanel toolboxPanel, int i, View view) {
        toolboxPanel.tab = i;
        toolboxPanel.refresh();
    }

    private final void loadInventory(int key, InvCat cat, String cursor) {
        if (this.invLoading) {
            return;
        }
        this.invLoading = true;
        this.net.execute(new ToolboxPanel$$ExternalSyntheticLambda51(getContext(), cursor, cat, this, key));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadInventory$lambda$210(Context context, String str, InvCat invCat, ToolboxPanel toolboxPanel, int i) {
        Object m457constructorimpl;
        ArrayList arrayList;
        Pair<List<RobloxApi.InvItem>, String> pair;
        LinkedHashMap emptyMap;
        try {
            RobloxApi robloxApi = RobloxApi.INSTANCE;
            Intrinsics.checkNotNull(context);
            long userId = robloxApi.userId(context);
            if (str != null) {
                arrayList = CollectionsKt.listOf(RobloxApi.INSTANCE.inventory(context, userId, invCat.getTypes().get(0).intValue(), str));
            } else {
                List<Integer> types = invCat.getTypes();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(types, 10));
                Iterator<T> it = types.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    try {
                        pair = RobloxApi.INSTANCE.inventory(context, userId, intValue, null);
                    } catch (Exception e) {
                        if (intValue == invCat.getTypes().get(0).intValue()) {
                            throw e;
                        }
                        pair = TuplesKt.to(CollectionsKt.emptyList(), null);
                    }
                    arrayList2.add(pair);
                }
                arrayList = arrayList2;
            }
            List list = arrayList;
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList3, (Iterable) ((Pair) it2.next()).getFirst());
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList3) {
                if (hashSet.add(Long.valueOf(((RobloxApi.InvItem) obj).getId()))) {
                    arrayList4.add(obj);
                }
            }
            ArrayList arrayList5 = arrayList4;
            try {
                ArrayList arrayList6 = arrayList5;
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                Iterator it3 = arrayList6.iterator();
                while (it3.hasNext()) {
                    arrayList7.add(Long.valueOf(((RobloxApi.InvItem) it3.next()).getId()));
                }
                boolean z = false;
                ArrayList arrayList8 = new ArrayList();
                for (Object obj2 : arrayList7) {
                    boolean z2 = z;
                    if (!toolboxPanel.invThumbs.containsKey(Long.valueOf(((Number) obj2).longValue()))) {
                        arrayList8.add(obj2);
                    }
                    z = z2;
                }
                List chunked = CollectionsKt.chunked(arrayList8, 100);
                ArrayList arrayList9 = new ArrayList();
                Iterator it4 = chunked.iterator();
                while (it4.hasNext()) {
                    CollectionsKt.addAll(arrayList9, RobloxApi.INSTANCE.thumbnailUrls((List) it4.next(), "150x150").entrySet());
                }
                ArrayList<Map.Entry> arrayList10 = arrayList9;
                boolean z3 = false;
                emptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList10, 10)), 16));
                for (Map.Entry entry : arrayList10) {
                    boolean z4 = z3;
                    Pair pair2 = TuplesKt.to(entry.getKey(), entry.getValue());
                    emptyMap.put(pair2.getFirst(), pair2.getSecond());
                    z3 = z4;
                }
            } catch (Exception e2) {
                emptyMap = MapsKt.emptyMap();
            }
            Result.Companion companion = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(new Triple(arrayList5, ((Pair) CollectionsKt.first(list)).getSecond(), emptyMap));
        } catch (Exception e3) {
            Result.Companion companion2 = Result.INSTANCE;
            m457constructorimpl = Result.m457constructorimpl(ResultKt.createFailure(e3));
        }
        toolboxPanel.post(new ToolboxPanel$$ExternalSyntheticLambda12(toolboxPanel, m457constructorimpl, str, i, invCat));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadInventory$lambda$210$lambda$209(ToolboxPanel toolboxPanel, Object obj, String str, int i, InvCat invCat) {
        ArrayList<RobloxApi.InvItem> arrayList;
        boolean z;
        toolboxPanel.invLoading = false;
        Throwable m460exceptionOrNullimpl = Result.m460exceptionOrNullimpl(obj);
        if (m460exceptionOrNullimpl == null) {
            Triple triple = (Triple) obj;
            List list = (List) triple.component1();
            String str2 = (String) triple.component2();
            Map map = (Map) triple.component3();
            HashMap<Long, String> hashMap = toolboxPanel.invThumbs;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getValue();
                Intrinsics.checkNotNull(str3);
                if (str3.length() > 0) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            hashMap.putAll(linkedHashMap);
            if (str != null) {
                Pair<ArrayList<RobloxApi.InvItem>, String> pair = toolboxPanel.invCache.get(Integer.valueOf(i));
                if (pair == null || (arrayList = pair.getFirst()) == null) {
                    arrayList = new ArrayList<>();
                }
            } else {
                arrayList = new ArrayList<>();
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list) {
                RobloxApi.InvItem invItem = (RobloxApi.InvItem) obj2;
                ArrayList<RobloxApi.InvItem> arrayList3 = arrayList;
                if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                    Iterator it = arrayList3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((RobloxApi.InvItem) it.next()).getId() == invItem.getId()) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                } else {
                    z = true;
                }
                if (z) {
                    arrayList2.add(obj2);
                }
            }
            arrayList.addAll(arrayList2);
            toolboxPanel.invCache.put(Integer.valueOf(i), TuplesKt.to(arrayList, str2));
        } else {
            toolboxPanel.invCache.put(Integer.valueOf(i), TuplesKt.to(new ArrayList(), null));
            Studio studio = toolboxPanel.studio;
            String lowerCase = invCat.getLabel().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            studio.toast("Couldn't load your " + lowerCase + ": " + m460exceptionOrNullimpl.getMessage());
        }
        if (toolboxPanel.tab == 1 && toolboxPanel.invRoblox) {
            toolboxPanel.refresh();
        }
    }

    private final void loadMore() {
        if (this.loading || this.endReached) {
            return;
        }
        this.loading = true;
        int i = this.searchGen;
        String str = this.query;
        RobloxApi.Category category = this.category;
        String str2 = this.cursor;
        RobloxApi.Price price = this.price;
        ProgressBar progressBar = this.progress;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
            progressBar = null;
        }
        progressBar.setVisibility(this.items.isEmpty() ? 0 : 8);
        TextView textView2 = this.status;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
        } else {
            textView = textView2;
        }
        textView.setText("");
        this.net.execute(new ToolboxPanel$$ExternalSyntheticLambda44(str, category, price, str2, this, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadMore$lambda$57(String str, RobloxApi.Category category, RobloxApi.Price price, String str2, ToolboxPanel toolboxPanel, int i) {
        RobloxApi.Price price2;
        RobloxApi.Page search$default;
        LinkedHashMap emptyMap;
        try {
            try {
                try {
                    price2 = price;
                    search$default = RobloxApi.searchPriced$default(RobloxApi.INSTANCE, str, category, price, str2, 0, 16, null);
                } catch (Exception e) {
                    try {
                        price2 = price;
                        if (price2 == RobloxApi.Price.ANY) {
                            throw e;
                        }
                        search$default = RobloxApi.search$default(RobloxApi.INSTANCE, str, category, str2, 0, 8, null);
                    } catch (Exception e2) {
                        e = e2;
                        toolboxPanel.post(new ToolboxPanel$$ExternalSyntheticLambda77(i, toolboxPanel, e));
                    }
                }
                List chunked = CollectionsKt.chunked(search$default.getIds(), 30);
                ArrayList arrayList = new ArrayList();
                Iterator it = chunked.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList, RobloxApi.INSTANCE.details((List) it.next()));
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    RobloxApi.Item item = (RobloxApi.Item) obj;
                    boolean z = true;
                    switch (WhenMappings.$EnumSwitchMapping$0[price2.ordinal()]) {
                        case 1:
                            if (item.isPaid()) {
                                z = false;
                                break;
                            }
                            break;
                        case 2:
                            z = item.isPaid();
                            break;
                    }
                    if (z) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                try {
                    List chunked2 = CollectionsKt.chunked(search$default.getIds(), 50);
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it2 = chunked2.iterator();
                    while (it2.hasNext()) {
                        CollectionsKt.addAll(arrayList4, RobloxApi.INSTANCE.thumbnailUrls((List) it2.next(), "150x150").entrySet());
                    }
                    ArrayList<Map.Entry> arrayList5 = arrayList4;
                    emptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList5, 10)), 16));
                    for (Map.Entry entry : arrayList5) {
                        Pair pair = TuplesKt.to(entry.getKey(), entry.getValue());
                        emptyMap.put(pair.getFirst(), pair.getSecond());
                    }
                } catch (Exception e3) {
                    emptyMap = MapsKt.emptyMap();
                }
                toolboxPanel.post(new ToolboxPanel$$ExternalSyntheticLambda76(i, toolboxPanel, emptyMap, arrayList3, search$default, str));
            } catch (Exception e4) {
                e = e4;
                toolboxPanel.post(new ToolboxPanel$$ExternalSyntheticLambda77(i, toolboxPanel, e));
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadMore$lambda$57$lambda$55(int i, ToolboxPanel toolboxPanel, Map map, List list, RobloxApi.Page page, String str) {
        boolean z;
        if (i != toolboxPanel.searchGen) {
            return;
        }
        HashMap<Long, String> hashMap = toolboxPanel.thumbUrls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getValue();
            Intrinsics.checkNotNull(str2);
            if (str2.length() > 0) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.putAll(linkedHashMap);
        int size = toolboxPanel.items.size();
        toolboxPanel.items.addAll(list);
        toolboxPanel.adapter.notifyItemRangeInserted(size, list.size());
        toolboxPanel.cursor = page.getNextCursor();
        if (page.getNextCursor() != null && !page.getIds().isEmpty()) {
            z = false;
        }
        toolboxPanel.endReached = z;
        toolboxPanel.loading = false;
        ProgressBar progressBar = toolboxPanel.progress;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        if (toolboxPanel.items.isEmpty()) {
            TextView textView2 = toolboxPanel.status;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
            } else {
                textView = textView2;
            }
            textView.setText(StringsKt.isBlank(str) ? "Nothing here yet." : "No results for \"" + str + "\".");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadMore$lambda$57$lambda$56(int i, ToolboxPanel toolboxPanel, Exception exc) {
        if (i != toolboxPanel.searchGen) {
            return;
        }
        toolboxPanel.loading = false;
        ProgressBar progressBar = toolboxPanel.progress;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        if (toolboxPanel.items.isEmpty()) {
            TextView textView2 = toolboxPanel.status;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
            } else {
                textView = textView2;
            }
            String message = exc.getMessage();
            if (message == null) {
                message = "";
            }
            textView.setText("Couldn't reach the Creator Store.\n" + message + "\nCheck your internet connection.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SharedPreferences meta_delegate$lambda$1(ToolboxPanel toolboxPanel) {
        return toolboxPanel.getContext().getSharedPreferences("toolbox_meta", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x020b, code lost:
    
        if (r2 != null) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void myModels(android.widget.LinearLayout r20) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.ToolboxPanel.myModels(android.widget.LinearLayout):void");
    }

    private static final String myModels$clsOf(ToolboxPanel toolboxPanel, File file, boolean z) {
        String string = toolboxPanel.getMeta().getString((z ? "recent/" : "") + file.getName(), null);
        return string == null ? "Model" : string;
    }

    private static final boolean myModels$keep(ToolboxPanel toolboxPanel, File file, boolean z) {
        return Intrinsics.areEqual(toolboxPanel.invKind, "All") || Intrinsics.areEqual(toolboxPanel.kindOf(myModels$clsOf(toolboxPanel, file, z)), toolboxPanel.invKind);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myModels$lambda$142(ToolboxPanel toolboxPanel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        toolboxPanel.invRoblox = Intrinsics.areEqual(it, "My Roblox items");
        toolboxPanel.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myModels$lambda$143(ToolboxPanel toolboxPanel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        toolboxPanel.invKind = it;
        toolboxPanel.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void myModels$lambda$146$lambda$145(ToolboxPanel toolboxPanel, View view) {
        toolboxPanel.invSortNewest = !toolboxPanel.invSortNewest;
        toolboxPanel.refresh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myModels$lambda$147(ToolboxPanel toolboxPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        toolboxPanel.actions.importToToolbox();
        return Unit.INSTANCE;
    }

    private static final void myModels$row(Context context, LinearLayout linearLayout, ToolboxPanel toolboxPanel, File file, boolean z) {
        String myModels$clsOf = myModels$clsOf(toolboxPanel, file, z);
        Ui ui = Ui.INSTANCE;
        Intrinsics.checkNotNull(context);
        TextView iconTextButton = ui.iconTextButton(context, Icons.INSTANCE.instance(context, myModels$clsOf), FilesKt.getNameWithoutExtension(file), Ui.INSTANCE.getHOVER(), new ToolboxPanel$$ExternalSyntheticLambda32(toolboxPanel, file));
        iconTextButton.setGravity(NavigationBarView.ITEM_GRAVITY_START_CENTER);
        iconTextButton.setOnLongClickListener(new ToolboxPanel$$ExternalSyntheticLambda33(context, file, toolboxPanel, z, myModels$clsOf));
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default.setMargins(Ui.INSTANCE.dp(context, 8.0f), Ui.INSTANCE.dp(context, 2.0f), Ui.INSTANCE.dp(context, 8.0f), Ui.INSTANCE.dp(context, 2.0f));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(iconTextButton, lp$default);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myModels$row$lambda$156(ToolboxPanel toolboxPanel, File file, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        toolboxPanel.insertFile(file);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean myModels$row$lambda$160(Context context, File file, ToolboxPanel toolboxPanel, boolean z, String str, View view) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Insert", "Rename…", "Delete"});
        Dialogs dialogs = Dialogs.INSTANCE;
        Intrinsics.checkNotNull(context);
        dialogs.themed(context).setTitle(FilesKt.getNameWithoutExtension(file)).setItems((CharSequence[]) listOf.toArray(new String[0]), new ToolboxPanel$$ExternalSyntheticLambda59(toolboxPanel, file, context, z, str)).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void myModels$row$lambda$160$lambda$159(ToolboxPanel toolboxPanel, File file, Context context, boolean z, String str, DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                toolboxPanel.insertFile(file);
                return;
            case 1:
                Dialogs dialogs = Dialogs.INSTANCE;
                Intrinsics.checkNotNull(context);
                dialogs.prompt(context, "Rename", FilesKt.getNameWithoutExtension(file), new ToolboxPanel$$ExternalSyntheticLambda49(file, toolboxPanel, z, str));
                return;
            case 2:
                Dialogs dialogs2 = Dialogs.INSTANCE;
                Intrinsics.checkNotNull(context);
                dialogs2.confirm(context, "Remove from Toolbox", "Delete " + FilesKt.getNameWithoutExtension(file) + " from your toolbox?", "Delete", new ToolboxPanel$$ExternalSyntheticLambda50(file, toolboxPanel));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myModels$row$lambda$160$lambda$159$lambda$157(File file, ToolboxPanel toolboxPanel, boolean z, String str, String n) {
        Intrinsics.checkNotNullParameter(n, "n");
        File file2 = new File(file.getParentFile(), toolboxPanel.safeName(n) + "." + FilesKt.getExtension(file));
        if (!file2.exists() && file.renameTo(file2)) {
            String str2 = z ? "recent/" : "";
            toolboxPanel.getMeta().edit().putString(str2 + file2.getName(), str).remove(str2 + file.getName()).apply();
        }
        toolboxPanel.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit myModels$row$lambda$160$lambda$159$lambda$158(File file, ToolboxPanel toolboxPanel) {
        file.delete();
        toolboxPanel.refresh();
        return Unit.INSTANCE;
    }

    private static final List<File> myModels$sorted(ToolboxPanel toolboxPanel, List<? extends File> list) {
        return toolboxPanel.invSortNewest ? CollectionsKt.sortedWith(list, new ToolboxPanel$myModels$sorted$$inlined$sortedByDescending$1()) : CollectionsKt.sortedWith(list, new ToolboxPanel$myModels$sorted$$inlined$sortedBy$1());
    }

    private final void newSearch() {
        this.searchGen++;
        this.items.clear();
        this.cursor = null;
        this.endReached = false;
        this.loading = false;
        this.adapter.notifyDataSetChanged();
        loadMore();
    }

    private final void objects(LinearLayout into) {
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"Script", "LocalScript", "ModuleScript", "Model", "Folder", "ScreenGui", "Frame", "TextLabel", "TextButton", "TextBox", "ImageLabel", "ScrollingFrame", "UICorner", "UIListLayout", "UIStroke", "UIGradient", "PointLight", "SpotLight", "Sound", "ParticleEmitter", "ClickDetector", "ProximityPrompt", "Tool", "RemoteEvent", "BindableEvent", "StringValue", "NumberValue", "BoolValue", "Attachment", "WeldConstraint", "Humanoid", "Decal", "BillboardGui"});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (String str : listOf) {
            Icons icons = Icons.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            arrayList.add(new Triple(icons.instance(context, str), str, new ToolboxPanel$$ExternalSyntheticLambda45(this, str)));
        }
        grid(into, arrayList);
        Ui ui = Ui.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        Icons icons2 = Icons.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        TextView iconTextButton$default = Ui.iconTextButton$default(ui, context2, Icons.general$default(icons2, context3, "InsertObject", null, 4, null), "All objects…", 0, new ToolboxPanel$$ExternalSyntheticLambda46(this), 8, null);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        Ui ui2 = Ui.INSTANCE;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        int dp = ui2.dp(context4, 8.0f);
        Ui ui3 = Ui.INSTANCE;
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
        int dp2 = ui3.dp(context5, 8.0f);
        Ui ui4 = Ui.INSTANCE;
        Context context6 = getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
        int dp3 = ui4.dp(context6, 8.0f);
        Ui ui5 = Ui.INSTANCE;
        Context context7 = getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
        lp$default.setMargins(dp, dp2, dp3, ui5.dp(context7, 8.0f));
        Unit unit = Unit.INSTANCE;
        into.addView(iconTextButton$default, lp$default);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit objects$lambda$132$lambda$131(ToolboxPanel toolboxPanel, String str) {
        Studio.insertObject$default(toolboxPanel.studio, str, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit objects$lambda$134(ToolboxPanel toolboxPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Dialogs dialogs = Dialogs.INSTANCE;
        Context context = toolboxPanel.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        dialogs.pickClass(context, "Insert Object", new ToolboxPanel$$ExternalSyntheticLambda0(toolboxPanel));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit objects$lambda$134$lambda$133(ToolboxPanel toolboxPanel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Studio.insertObject$default(toolboxPanel.studio, it, null, 2, null);
        return Unit.INSTANCE;
    }

    private final void openInBrowser(String url) {
        try {
            getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } catch (Exception e) {
            this.studio.toast("No browser found to open " + url);
        }
    }

    private final void paidDialog(RobloxApi.Item item, RobloxApi.Category cat, boolean refused) {
        StringBuilder sb = new StringBuilder();
        if (item.isPaid()) {
            sb.append("“" + item.getName() + "” costs " + item.getPriceText() + " on the Creator Store, so it can't be loaded until it's bought on Roblox with the account you're signed in with.");
        } else {
            sb.append("Roblox didn't let your account download “" + item.getName() + "”. It may be a paid or private asset.");
        }
        if (refused) {
            sb.append("\n\nRoblox refused the download for the signed-in account.");
        }
        sb.append("\n\nAfter buying it, tap Insert again (or find it in Inventory → My Roblox items).");
        String sb2 = sb.toString();
        Dialogs dialogs = Dialogs.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        dialogs.themed(context).setTitle(item.isPaid() ? "Can't load paid model" : "Can't load this asset").setMessage(sb2).setPositiveButton(item.isPaid() ? "Buy on Roblox (" + item.getPriceText() + ")" : "Open on Roblox", new ToolboxPanel$$ExternalSyntheticLambda2(this, item)).setNeutralButton(refused ? "Close" : "I own it, insert", new ToolboxPanel$$ExternalSyntheticLambda3(refused, this, item, cat)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    static /* synthetic */ void paidDialog$default(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        toolboxPanel.paidDialog(item, category, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void paidDialog$lambda$69(ToolboxPanel toolboxPanel, RobloxApi.Item item, DialogInterface dialogInterface, int i) {
        toolboxPanel.openInBrowser(RobloxApi.INSTANCE.storeUrl(item.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void paidDialog$lambda$70(boolean z, ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category, DialogInterface dialogInterface, int i) {
        if (z) {
            return;
        }
        toolboxPanel.insertAsset(item, category, true);
    }

    private final void parts(LinearLayout into) {
        Context context = getContext();
        section(into, "PARTS");
        Icons icons = Icons.INSTANCE;
        Intrinsics.checkNotNull(context);
        grid(into, CollectionsKt.listOf((Object[]) new Triple[]{new Triple(icons.general(context, "Part_Block", "Block"), "Block", new ToolboxPanel$$ExternalSyntheticLambda66(this)), new Triple(Icons.INSTANCE.general(context, "Part_Sphere", "Sphere"), "Sphere", new ToolboxPanel$$ExternalSyntheticLambda67(this)), new Triple(Icons.INSTANCE.general(context, "Part_Cylinder", "Cylinder"), "Cylinder", new ToolboxPanel$$ExternalSyntheticLambda68(this)), new Triple(Icons.INSTANCE.general(context, "Part_Wedge", "Wedge"), "Wedge", new ToolboxPanel$$ExternalSyntheticLambda69(this)), new Triple(Icons.INSTANCE.general(context, "Part_CornerWedge", "Corner"), "Corner", new ToolboxPanel$$ExternalSyntheticLambda70(this)), new Triple(Icons.INSTANCE.instance(context, "SpawnLocation"), "Spawn", new ToolboxPanel$$ExternalSyntheticLambda71(this)), new Triple(Icons.INSTANCE.instance(context, "Seat"), "Seat", new ToolboxPanel$$ExternalSyntheticLambda72(this)), new Triple(Icons.INSTANCE.instance(context, "TrussPart"), "Truss", new ToolboxPanel$$ExternalSyntheticLambda73(this))}));
        section(into, "SAMPLES");
        List<Samples.Sample> all = Samples.INSTANCE.getAll();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all, 10));
        for (Samples.Sample sample : all) {
            arrayList.add(new Triple(Icons.INSTANCE.instance(context, sample.getIcon()), sample.getName(), new ToolboxPanel$$ExternalSyntheticLambda74(this, sample)));
        }
        grid(into, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$117(ToolboxPanel toolboxPanel) {
        toolboxPanel.studio.insertPart(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$118(ToolboxPanel toolboxPanel) {
        toolboxPanel.studio.insertPart(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$119(ToolboxPanel toolboxPanel) {
        toolboxPanel.studio.insertPart(2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$120(ToolboxPanel toolboxPanel) {
        toolboxPanel.studio.insertPart(3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$121(ToolboxPanel toolboxPanel) {
        toolboxPanel.studio.insertPart(4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$122(ToolboxPanel toolboxPanel) {
        Studio.insertObject$default(toolboxPanel.studio, "SpawnLocation", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$125(ToolboxPanel toolboxPanel) {
        Instance insertObject$default = Studio.insertObject$default(toolboxPanel.studio, "Seat", null, 2, null);
        synchronized (toolboxPanel.studio.getLock()) {
            Instance.set$default(insertObject$default, "Anchored", true, false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$128(ToolboxPanel toolboxPanel) {
        Instance insertObject$default = Studio.insertObject$default(toolboxPanel.studio, "TrussPart", null, 2, null);
        synchronized (toolboxPanel.studio.getLock()) {
            Instance.set$default(insertObject$default, "Anchored", true, false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit parts$lambda$130$lambda$129(ToolboxPanel toolboxPanel, Samples.Sample sample) {
        Studio.insertDocument$default(toolboxPanel.studio, new RbxDocument(CollectionsKt.listOf(sample.getBuild().invoke()), MapsKt.emptyMap(), CollectionsKt.emptyList()), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit refresh$lambda$16(ToolboxPanel toolboxPanel, LinearLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        toolboxPanel.myModels(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit refresh$lambda$17(ToolboxPanel toolboxPanel, LinearLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        toolboxPanel.parts(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit refresh$lambda$18(ToolboxPanel toolboxPanel, LinearLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        toolboxPanel.objects(it);
        return Unit.INSTANCE;
    }

    private final void robloxInventory(LinearLayout into) {
        String str;
        ArrayList arrayList;
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        List<InvCat> list = this.robloxCats;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((InvCat) it.next()).getLabel());
        }
        chipRow(into, arrayList2, this.robloxCats.get(this.invRobloxCat).getLabel(), new ToolboxPanel$$ExternalSyntheticLambda15(this));
        int i = 0;
        if (RobloxApi.INSTANCE.isGuest(context)) {
            TextView text$default = Ui.text$default(Ui.INSTANCE, context, "Sign in to see the models, meshes, plugins and other items on your Roblox account.", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default.setSingleLine(false);
            text$default.setPadding(Ui.INSTANCE.dp(context, 12.0f), Ui.INSTANCE.dp(context, 8.0f), Ui.INSTANCE.dp(context, 12.0f), Ui.INSTANCE.dp(context, 6.0f));
            into.addView(text$default);
            TextView button$default = Ui.button$default(Ui.INSTANCE, context, "Sign in with Roblox", 0, new ToolboxPanel$$ExternalSyntheticLambda16(activity, this), 4, null);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default.setMargins(Ui.INSTANCE.dp(context, 8.0f), 0, Ui.INSTANCE.dp(context, 8.0f), 0);
            Unit unit = Unit.INSTANCE;
            into.addView(button$default, lp$default);
            return;
        }
        InvCat invCat = this.robloxCats.get(this.invRobloxCat);
        int i2 = this.invRobloxCat;
        Pair<ArrayList<RobloxApi.InvItem>, String> pair = this.invCache.get(Integer.valueOf(i2));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(Ui.INSTANCE.dp(context, 10.0f), 0, Ui.INSTANCE.dp(context, 6.0f), 0);
        Ui ui = Ui.INSTANCE;
        String str2 = "";
        if (pair != null) {
            String str3 = pair.getFirst().size() + " item" + (pair.getFirst().size() == 1 ? "" : "s");
            if (str3 != null) {
                str2 = str3;
            }
        }
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.addView(Ui.text$default(ui, context, str2, 11.0f, Ui.INSTANCE.getDIM(), false, 16, null), Ui.INSTANCE.lp(0, -2, 1.0f));
        TextView text$default2 = Ui.text$default(Ui.INSTANCE, context, "Reload", 11.0f, Ui.INFO, false, 16, null);
        text$default2.setPadding(Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 4.0f), Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 4.0f));
        text$default2.setOnClickListener(new ToolboxPanel$$ExternalSyntheticLambda17(this, i2));
        linearLayout2.addView(text$default2);
        into.addView(linearLayout2);
        if (pair == null) {
            ProgressBar progressBar = new ProgressBar(context);
            progressBar.setIndeterminate(true);
            LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(context, 32.0f), Ui.INSTANCE.dp(context, 32.0f), 0.0f, 4, null);
            lp$default2.gravity = 1;
            lp$default2.topMargin = Ui.INSTANCE.dp(context, 12.0f);
            Unit unit2 = Unit.INSTANCE;
            into.addView(progressBar, lp$default2);
            loadInventory(i2, invCat, null);
            return;
        }
        ArrayList<RobloxApi.InvItem> component1 = pair.component1();
        String component2 = pair.component2();
        if (component1.isEmpty()) {
            Ui ui2 = Ui.INSTANCE;
            String lowerCase = invCat.getLabel().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            TextView text$default3 = Ui.text$default(ui2, context, "No " + lowerCase + " on your account.", 12.0f, Ui.INSTANCE.getDIM(), false, 16, null);
            text$default3.setPadding(Ui.INSTANCE.dp(context, 12.0f), Ui.INSTANCE.dp(context, 8.0f), 0, 0);
            into.addView(text$default3);
            return;
        }
        String str4 = component2;
        for (RobloxApi.InvItem invItem : this.invSortNewest ? component1 : CollectionsKt.sortedWith(component1, new ToolboxPanel$robloxInventory$$inlined$sortedBy$1())) {
            LinearLayout linearLayout3 = new LinearLayout(context);
            linearLayout3.setOrientation(i);
            linearLayout3.setGravity(16);
            linearLayout3.setPadding(Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 3.0f), Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 3.0f));
            linearLayout3.setBackground(Ui.INSTANCE.rippleBg(context, Ui.INSTANCE.getHOVER(), 4.0f));
            linearLayout3.setOnClickListener(new ToolboxPanel$$ExternalSyntheticLambda18(this, invItem, invCat));
            linearLayout3.setOnLongClickListener(new ToolboxPanel$$ExternalSyntheticLambda19(context, invItem, this));
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setBackgroundColor(Ui.INSTANCE.blend(Ui.INSTANCE.getPANEL(), ViewCompat.MEASURED_STATE_MASK, 0.08f));
            String str5 = this.invThumbs.get(Long.valueOf(invItem.getId()));
            Bitmap key = str5 != null ? ImageLoader.INSTANCE.getKey("url:" + str5) : null;
            if (key != null) {
                imageView.setImageBitmap(key);
                str = str4;
            } else {
                str = str4;
                imageView.setImageDrawable(Icons.general$default(Icons.INSTANCE, context, invCat.getInsertAs() == RobloxApi.Category.PLUGINS ? "ManagePlugins" : "Toolbox", null, 4, null));
                if (str5 != null) {
                    HashMap<String, List<ImageView>> hashMap = this.invThumbViews;
                    String str6 = "url:" + str5;
                    List<ImageView> list2 = hashMap.get(str6);
                    if (list2 == null) {
                        arrayList = new ArrayList();
                        hashMap.put(str6, arrayList);
                    } else {
                        arrayList = list2;
                    }
                    arrayList.add(imageView);
                }
            }
            ImageView imageView2 = imageView;
            LinearLayout.LayoutParams lp$default3 = Ui.lp$default(Ui.INSTANCE, Ui.INSTANCE.dp(context, 40.0f), Ui.INSTANCE.dp(context, 40.0f), 0.0f, 4, null);
            lp$default3.rightMargin = Ui.INSTANCE.dp(context, 8.0f);
            Unit unit3 = Unit.INSTANCE;
            linearLayout3.addView(imageView2, lp$default3);
            TextView text$default4 = Ui.text$default(Ui.INSTANCE, context, invItem.getName(), 12.0f, 0, false, 24, null);
            text$default4.setMaxLines(2);
            text$default4.setSingleLine(false);
            text$default4.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout3.addView(text$default4, Ui.INSTANCE.lp(0, -2, 1.0f));
            LinearLayout linearLayout4 = linearLayout3;
            LinearLayout.LayoutParams lp$default4 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default4.setMargins(Ui.INSTANCE.dp(context, 4.0f), Ui.INSTANCE.dp(context, 1.0f), Ui.INSTANCE.dp(context, 4.0f), Ui.INSTANCE.dp(context, 1.0f));
            Unit unit4 = Unit.INSTANCE;
            into.addView(linearLayout4, lp$default4);
            str4 = str;
            linearLayout2 = linearLayout2;
            activity = activity;
            i = 0;
        }
        String str7 = str4;
        if (str7 != null) {
            TextView button$default2 = Ui.button$default(Ui.INSTANCE, context, this.invLoading ? "Loading…" : "Load more", 0, new ToolboxPanel$$ExternalSyntheticLambda20(this, i2, invCat, str7), 4, null);
            LinearLayout.LayoutParams lp$default5 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default5.setMargins(Ui.INSTANCE.dp(context, 8.0f), Ui.INSTANCE.dp(context, 6.0f), Ui.INSTANCE.dp(context, 8.0f), Ui.INSTANCE.dp(context, 8.0f));
            Unit unit5 = Unit.INSTANCE;
            into.addView(button$default2, lp$default5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit robloxInventory$lambda$173(ToolboxPanel toolboxPanel, String l) {
        Intrinsics.checkNotNullParameter(l, "l");
        int i = 0;
        Iterator<InvCat> it = toolboxPanel.robloxCats.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getLabel(), l)) {
                break;
            }
            i++;
        }
        toolboxPanel.invRobloxCat = RangesKt.coerceAtLeast(i, 0);
        toolboxPanel.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit robloxInventory$lambda$176(Activity activity, ToolboxPanel toolboxPanel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AccountUi.INSTANCE.signIn(activity, new ToolboxPanel$$ExternalSyntheticLambda75(toolboxPanel));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit robloxInventory$lambda$176$lambda$175(ToolboxPanel toolboxPanel) {
        toolboxPanel.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void robloxInventory$lambda$181$lambda$180(ToolboxPanel toolboxPanel, int i, View view) {
        toolboxPanel.invCache.remove(Integer.valueOf(i));
        toolboxPanel.refresh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void robloxInventory$lambda$188$lambda$186(ToolboxPanel toolboxPanel, RobloxApi.InvItem invItem, InvCat invCat, View view) {
        toolboxPanel.insertInventoryItem(invItem, invCat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean robloxInventory$lambda$188$lambda$187(Context context, RobloxApi.InvItem invItem, ToolboxPanel toolboxPanel, View view) {
        Object systemService = ((Activity) context).getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Asset ID", String.valueOf(invItem.getId())));
        toolboxPanel.studio.toast("Copied asset ID " + invItem.getId());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit robloxInventory$lambda$195(ToolboxPanel toolboxPanel, int i, InvCat invCat, String str, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!toolboxPanel.invLoading) {
            toolboxPanel.loadInventory(i, invCat, str);
        }
        return Unit.INSTANCE;
    }

    private final String safeName(String name) {
        String replace = new Regex("[^A-Za-z0-9._ -]").replace(name, "_");
        if (StringsKt.isBlank(replace)) {
            replace = "Model";
        }
        return StringsKt.take(replace, 60);
    }

    public static /* synthetic */ void saveToLibrary$default(ToolboxPanel toolboxPanel, String str, byte[] bArr, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        toolboxPanel.saveToLibrary(str, bArr, str2);
    }

    private final View scroll(Function1<? super LinearLayout, Unit> fill) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        fill.invoke(linearLayout);
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.addView(linearLayout);
        return scrollView;
    }

    private final void section(LinearLayout into, String title) {
        Ui ui = Ui.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TextView text = ui.text(context, title, 11.0f, Ui.INSTANCE.getDIM(), true);
        Ui ui2 = Ui.INSTANCE;
        Context context2 = text.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        int dp = ui2.dp(context2, 10.0f);
        Ui ui3 = Ui.INSTANCE;
        Context context3 = text.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        int dp2 = ui3.dp(context3, 10.0f);
        Ui ui4 = Ui.INSTANCE;
        Context context4 = text.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        text.setPadding(dp, dp2, 0, ui4.dp(context4, 2.0f));
        into.addView(text);
    }

    private final void showCategory() {
        AudioBrowser audioBrowser;
        boolean z = this.category == RobloxApi.Category.AUDIO;
        AudioBrowser audioBrowser2 = this.audioBrowser;
        if (audioBrowser2 != null) {
            audioBrowser2.setVisibility(z ? 0 : 8);
        }
        View view = this.gridHost;
        if (view != null) {
            view.setVisibility(z ? 8 : 0);
        }
        View view2 = this.priceRow;
        if (view2 != null) {
            view2.setVisibility(z ? 8 : 0);
        }
        EditText editText = this.searchBox;
        if (editText != null) {
            editText.setHint(z ? "Search audio" : "Search the Creator Store");
        }
        if (!z) {
            AudioEngine.INSTANCE.stopPreview();
            newSearch();
        } else {
            if (StringsKt.isBlank(this.query) || (audioBrowser = this.audioBrowser) == null) {
                return;
            }
            audioBrowser.search(this.query);
        }
    }

    private final void showDetails(RobloxApi.Item item, RobloxApi.Category cat) {
        LinearLayout linearLayout;
        Context context;
        char c;
        CharSequence charSequence;
        String str;
        String str2;
        Context context2 = getContext();
        LinearLayout linearLayout2 = new LinearLayout(context2);
        linearLayout2.setOrientation(1);
        Ui ui = Ui.INSTANCE;
        Intrinsics.checkNotNull(context2);
        linearLayout2.setPadding(ui.dp(context2, 16.0f), Ui.INSTANCE.dp(context2, 8.0f), Ui.INSTANCE.dp(context2, 16.0f), Ui.INSTANCE.dp(context2, 8.0f));
        ImageView imageView = new ImageView(context2);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setBackgroundColor(Ui.INSTANCE.blend(Ui.INSTANCE.getPANEL(), ViewCompat.MEASURED_STATE_MASK, 0.1f));
        linearLayout2.addView(imageView, Ui.lp$default(Ui.INSTANCE, -1, Ui.INSTANCE.dp(context2, 200.0f), 0.0f, 4, null));
        bindImage(imageView, "asset:" + item.getId());
        LinearLayout linearLayout3 = new LinearLayout(context2);
        linearLayout3.setOrientation(0);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context2);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.addView(linearLayout3);
        LinearLayout.LayoutParams lp$default = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
        lp$default.topMargin = Ui.INSTANCE.dp(context2, 4.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(horizontalScrollView, lp$default);
        this.net.execute(new ToolboxPanel$$ExternalSyntheticLambda78(item, this, context2, linearLayout3, imageView));
        showDetails$line(linearLayout2, context2, item.getName(), 16.0f, Ui.INSTANCE.getTEXT(), true);
        showDetails$line$default(linearLayout2, context2, "By " + item.getCreator() + (item.getVerified() ? "  ✔ verified" : "") + (item.getCreatorIsGroup() ? " (group)" : ""), 12.0f, item.getVerified() ? Ui.INFO : Ui.INSTANCE.getDIM(), false, 32, null);
        showDetails$line(linearLayout2, context2, item.isPaid() ? "Price: " + item.getPriceText() + " (buy it on Roblox to use it)" : "Price: Free", 13.0f, item.isPaid() ? -18611 : -8595844, true);
        int upVotes = item.getUpVotes() + item.getDownVotes();
        showDetails$line(linearLayout2, context2, "Ratings", 11.0f, Ui.INSTANCE.getDIM(), true);
        if (upVotes > 0) {
            int likePercent = item.getLikePercent();
            LinearLayout linearLayout4 = new LinearLayout(context2);
            linearLayout4.setOrientation(0);
            View view = new View(context2);
            view.setBackgroundColor(-11751600);
            linearLayout4.addView(view, Ui.INSTANCE.lp(0, Ui.INSTANCE.dp(context2, 8.0f), RangesKt.coerceAtLeast(likePercent, 0.01f)));
            View view2 = new View(context2);
            view2.setBackgroundColor(-2075307);
            linearLayout4.addView(view2, Ui.INSTANCE.lp(0, Ui.INSTANCE.dp(context2, 8.0f), RangesKt.coerceAtLeast(100 - likePercent, 0.01f)));
            LinearLayout.LayoutParams lp$default2 = Ui.lp$default(Ui.INSTANCE, -1, -2, 0.0f, 4, null);
            lp$default2.topMargin = Ui.INSTANCE.dp(context2, 2.0f);
            Unit unit2 = Unit.INSTANCE;
            linearLayout2.addView(linearLayout4, lp$default2);
            linearLayout = linearLayout2;
            c = 0;
            context = context2;
            showDetails$line$default(linearLayout, context, likePercent + "% liked  ·  👍 " + fmtCount(item.getUpVotes()) + "  👎 " + fmtCount(item.getDownVotes()) + "  ·  " + fmtCount(upVotes) + " ratings", 0.0f, 0, false, 56, null);
        } else {
            linearLayout = linearLayout2;
            context = context2;
            c = 0;
            showDetails$line$default(linearLayout, context, "No ratings yet", 12.0f, Ui.INSTANCE.getDIM(), false, 32, null);
        }
        if (item.getEndorsed()) {
            showDetails$line$default(linearLayout, context, "★ Endorsed by Roblox", 12.0f, -10929, false, 32, null);
        }
        if (StringsKt.isBlank(item.getDescription())) {
            charSequence = "  ·  ";
        } else {
            charSequence = "  ·  ";
            showDetails$line(linearLayout, context, "Description", 11.0f, Ui.INSTANCE.getDIM(), true);
            showDetails$line$default(linearLayout, context, StringsKt.take(item.getDescription(), 2000), 0.0f, 0, false, 56, null);
        }
        LinearLayout linearLayout5 = linearLayout;
        showDetails$line(linearLayout5, context, "Details", 11.0f, Ui.INSTANCE.getDIM(), true);
        ArrayList arrayList = new ArrayList();
        if (item.getHasScripts()) {
            if (item.getScriptCount() > 0) {
                str2 = item.getScriptCount() + " script" + (item.getScriptCount() != 1 ? "s" : "");
            } else {
                str2 = "scripts";
            }
            str = "⚠ Contains " + str2;
        } else {
            str = "No scripts";
        }
        arrayList.add(str);
        if (item.getMeshParts() > 0) {
            arrayList.add(item.getMeshParts() + " MeshParts");
        }
        if (item.getTriangles() > 0) {
            arrayList.add(fmtCount(item.getTriangles()) + " triangles");
        }
        if (item.getAnimations() > 0) {
            arrayList.add(item.getAnimations() + " animations");
        }
        if (item.getSounds() > 0) {
            arrayList.add(item.getSounds() + " sounds");
        }
        showDetails$line$default(linearLayout5, context, CollectionsKt.joinToString$default(arrayList, charSequence, null, null, 0, null, null, 62, null), 0.0f, 0, false, 56, null);
        if (!StringsKt.isBlank(item.getCategory())) {
            String category = item.getCategory();
            String[] strArr = new String[1];
            strArr[c] = "__";
            showDetails$line$default(linearLayout5, context, "Category: " + CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) category, strArr, false, 0, 6, (Object) null), " › ", null, null, 0, null, new ToolboxPanel$$ExternalSyntheticLambda79(), 30, null), 12.0f, Ui.INSTANCE.getDIM(), false, 32, null);
        }
        showDetails$line$default(linearLayout5, context, "Created " + fmtDate(item.getCreated()) + "  ·  Updated " + fmtDate(item.getUpdated()), 12.0f, Ui.INSTANCE.getDIM(), false, 32, null);
        showDetails$line$default(linearLayout5, context, "Asset ID " + item.getId(), 12.0f, Ui.INSTANCE.getDIM(), false, 32, null);
        ScrollView scrollView = new ScrollView(context);
        scrollView.addView(linearLayout5);
        Dialogs.INSTANCE.themed(context).setView(scrollView).setPositiveButton(item.isPaid() ? "Buy (" + item.getPriceText() + ")" : cat == RobloxApi.Category.PLUGINS ? "Install" : "Insert", new ToolboxPanel$$ExternalSyntheticLambda80(item, this, cat)).setNeutralButton("Open in browser", new ToolboxPanel$$ExternalSyntheticLambda81(this, item)).setNegativeButton("Close", (DialogInterface.OnClickListener) null).show();
    }

    static /* synthetic */ void showDetails$default(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category, int i, Object obj) {
        if ((i & 2) != 0) {
            category = toolboxPanel.category;
        }
        toolboxPanel.showDetails(item, category);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showDetails$lambda$101(RobloxApi.Item item, ToolboxPanel toolboxPanel, Context context, LinearLayout linearLayout, ImageView imageView) {
        List<Long> previewImages = RobloxApi.INSTANCE.previewImages(item.getId());
        if (previewImages.isEmpty()) {
            return;
        }
        toolboxPanel.post(new ToolboxPanel$$ExternalSyntheticLambda53(previewImages, context, linearLayout, toolboxPanel, imageView));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showDetails$lambda$101$lambda$100(List list, Context context, LinearLayout linearLayout, ToolboxPanel toolboxPanel, ImageView imageView) {
        Iterator it = CollectionsKt.take(list, 8).iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            ImageView imageView2 = new ImageView(context);
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView2.setOnClickListener(new ToolboxPanel$$ExternalSyntheticLambda48(toolboxPanel, imageView, longValue));
            Ui ui = Ui.INSTANCE;
            Ui ui2 = Ui.INSTANCE;
            Intrinsics.checkNotNull(context);
            LinearLayout.LayoutParams lp$default = Ui.lp$default(ui, ui2.dp(context, 64.0f), Ui.INSTANCE.dp(context, 64.0f), 0.0f, 4, null);
            lp$default.rightMargin = Ui.INSTANCE.dp(context, 4.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(imageView2, lp$default);
            toolboxPanel.bindImage(imageView2, "asset:" + longValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showDetails$lambda$101$lambda$100$lambda$98$lambda$97(ToolboxPanel toolboxPanel, ImageView imageView, long j, View view) {
        toolboxPanel.bindImage(imageView, "asset:" + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence showDetails$lambda$108(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String replace$default = StringsKt.replace$default(it, '_', ' ', false, 4, (Object) null);
        if (replace$default.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String valueOf = String.valueOf(replace$default.charAt(0));
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            StringBuilder append = sb.append((Object) upperCase);
            String substring = replace$default.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            replace$default = append.append(substring).toString();
        }
        return replace$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showDetails$lambda$110(RobloxApi.Item item, ToolboxPanel toolboxPanel, RobloxApi.Category category, DialogInterface dialogInterface, int i) {
        if (item.isPaid()) {
            paidDialog$default(toolboxPanel, item, category, false, 4, null);
        } else {
            insertAsset$default(toolboxPanel, item, category, false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showDetails$lambda$111(ToolboxPanel toolboxPanel, RobloxApi.Item item, DialogInterface dialogInterface, int i) {
        toolboxPanel.openInBrowser(RobloxApi.INSTANCE.storeUrl(item.getId()));
    }

    private static final void showDetails$line(LinearLayout linearLayout, Context context, String str, float f, int i, boolean z) {
        Ui ui = Ui.INSTANCE;
        Intrinsics.checkNotNull(context);
        TextView text = ui.text(context, str, f, i, z);
        text.setSingleLine(false);
        text.setPadding(0, Ui.INSTANCE.dp(context, 3.0f), 0, Ui.INSTANCE.dp(context, 1.0f));
        linearLayout.addView(text);
    }

    static /* synthetic */ void showDetails$line$default(LinearLayout linearLayout, Context context, String str, float f, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            f = 12.0f;
        }
        float f2 = f;
        if ((i2 & 16) != 0) {
            i = Ui.INSTANCE.getTEXT();
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            z = false;
        }
        showDetails$line(linearLayout, context, str, f2, i3, z);
    }

    public final File getLibraryDir() {
        File file = new File(getContext().getFilesDir(), "toolbox");
        file.mkdirs();
        return file;
    }

    public final void refresh() {
        GradientDrawable gradientDrawable;
        int i = 0;
        for (Object obj : this.tabViews) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            textView.setTextColor(i == this.tab ? Ui.INSTANCE.getTEXT() : Ui.INSTANCE.getDIM());
            if (i == this.tab) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(Ui.INSTANCE.getPANEL());
                gradientDrawable = gradientDrawable2;
            } else {
                gradientDrawable = null;
            }
            textView.setBackground(gradientDrawable);
            i = i2;
        }
        this.body.removeAllViews();
        switch (this.tab) {
            case 0:
                FrameLayout frameLayout = this.body;
                View view = this.market;
                if (view == null) {
                    view = buildMarket();
                    this.market = view;
                }
                frameLayout.addView(view);
                return;
            case 1:
                this.body.addView(scroll(new ToolboxPanel$$ExternalSyntheticLambda61(this)));
                return;
            case 2:
                this.body.addView(scroll(new ToolboxPanel$$ExternalSyntheticLambda62(this)));
                return;
            default:
                this.body.addView(scroll(new ToolboxPanel$$ExternalSyntheticLambda63(this)));
                return;
        }
    }

    public final void saveToLibrary(String name, byte[] bytes, String cls) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        String safeName = safeName(name);
        if (StringsKt.endsWith$default(safeName, ".rbxm", false, 2, (Object) null) || StringsKt.endsWith$default(safeName, ".rbxmx", false, 2, (Object) null)) {
            safeName = StringsKt.substringBeforeLast$default(safeName, '.', (String) null, 2, (Object) null);
        }
        File file = new File(getLibraryDir(), safeName + ".rbxm");
        int i = 2;
        while (file.exists()) {
            file = new File(getLibraryDir(), safeName + " (" + i + ").rbxm");
            i++;
        }
        FilesKt.writeBytes(file, bytes);
        if (cls != null) {
            getMeta().edit().putString(file.getName(), cls).apply();
        }
        this.tab = 1;
        refresh();
    }

    public final void showMarketplace(RobloxApi.Category cat) {
        Intrinsics.checkNotNullParameter(cat, "cat");
        this.tab = 0;
        refresh();
        if (this.category != cat) {
            this.category = cat;
            Function0<Unit> function0 = this.restyleCats;
            if (function0 != null) {
                function0.invoke();
            }
            showCategory();
        }
    }
}
